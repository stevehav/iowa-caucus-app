package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.Status;
import io.grpc.internal.StreamListener;
import io.grpc.perfmark.PerfMark;
import io.grpc.perfmark.PerfTag;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

final class ServerCallImpl<ReqT, RespT> extends ServerCall<ReqT, RespT> {
    @VisibleForTesting
    static final String MISSING_RESPONSE = "Completed without a response";
    @VisibleForTesting
    static final String TOO_MANY_RESPONSES = "Too many responses";
    private static final Logger log = Logger.getLogger(ServerCallImpl.class.getName());
    /* access modifiers changed from: private */
    public volatile boolean cancelled;
    private boolean closeCalled;
    private Compressor compressor;
    private final CompressorRegistry compressorRegistry;
    private final Context.CancellableContext context;
    private final DecompressorRegistry decompressorRegistry;
    private final byte[] messageAcceptEncoding;
    private boolean messageSent;
    /* access modifiers changed from: private */
    public final MethodDescriptor<ReqT, RespT> method;
    private boolean sendHeadersCalled;
    private CallTracer serverCallTracer;
    private final ServerStream stream;
    /* access modifiers changed from: private */
    public final PerfTag tag;

    ServerCallImpl(ServerStream serverStream, MethodDescriptor<ReqT, RespT> methodDescriptor, Metadata metadata, Context.CancellableContext cancellableContext, DecompressorRegistry decompressorRegistry2, CompressorRegistry compressorRegistry2, CallTracer callTracer) {
        this.stream = serverStream;
        this.method = methodDescriptor;
        this.tag = PerfMark.createTag(methodDescriptor.getFullMethodName());
        this.context = cancellableContext;
        this.messageAcceptEncoding = (byte[]) metadata.get(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        this.decompressorRegistry = decompressorRegistry2;
        this.compressorRegistry = compressorRegistry2;
        this.serverCallTracer = callTracer;
        this.serverCallTracer.reportCallStarted();
    }

    public void request(int i) {
        this.stream.request(i);
    }

    public void sendHeaders(Metadata metadata) {
        PerfMark.taskStart(this.tag, "ServerCall.sendHeaders");
        try {
            sendHeadersInternal(metadata);
        } finally {
            PerfMark.taskEnd(this.tag, "ServerCall.sendHeaders");
        }
    }

    private void sendHeadersInternal(Metadata metadata) {
        Preconditions.checkState(!this.sendHeadersCalled, "sendHeaders has already been called");
        Preconditions.checkState(!this.closeCalled, "call is closed");
        metadata.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (this.compressor == null) {
            this.compressor = Codec.Identity.NONE;
        } else if (this.messageAcceptEncoding == null) {
            this.compressor = Codec.Identity.NONE;
        } else if (!GrpcUtil.iterableContains(GrpcUtil.ACCEPT_ENCODING_SPLITTER.split(new String(this.messageAcceptEncoding, GrpcUtil.US_ASCII)), this.compressor.getMessageEncoding())) {
            this.compressor = Codec.Identity.NONE;
        }
        metadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, this.compressor.getMessageEncoding());
        this.stream.setCompressor(this.compressor);
        metadata.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        byte[] rawAdvertisedMessageEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(this.decompressorRegistry);
        if (rawAdvertisedMessageEncodings.length != 0) {
            metadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, rawAdvertisedMessageEncodings);
        }
        this.sendHeadersCalled = true;
        this.stream.writeHeaders(metadata);
    }

    public void sendMessage(RespT respt) {
        PerfMark.taskStart(this.tag, "ServerCall.sendMessage");
        try {
            sendMessageInternal(respt);
        } finally {
            PerfMark.taskEnd(this.tag, "ServerCall.sendMessage");
        }
    }

    private void sendMessageInternal(RespT respt) {
        Preconditions.checkState(this.sendHeadersCalled, "sendHeaders has not been called");
        Preconditions.checkState(!this.closeCalled, "call is closed");
        if (!this.method.getType().serverSendsOneMessage() || !this.messageSent) {
            this.messageSent = true;
            try {
                this.stream.writeMessage(this.method.streamResponse(respt));
                this.stream.flush();
            } catch (RuntimeException e) {
                close(Status.fromThrowable(e), new Metadata());
            } catch (Error e2) {
                close(Status.CANCELLED.withDescription("Server sendMessage() failed with Error"), new Metadata());
                throw e2;
            }
        } else {
            internalClose(Status.INTERNAL.withDescription(TOO_MANY_RESPONSES));
        }
    }

    public void setMessageCompression(boolean z) {
        this.stream.setMessageCompression(z);
    }

    public void setCompression(String str) {
        boolean z = true;
        Preconditions.checkState(!this.sendHeadersCalled, "sendHeaders has been called");
        this.compressor = this.compressorRegistry.lookupCompressor(str);
        if (this.compressor == null) {
            z = false;
        }
        Preconditions.checkArgument(z, "Unable to find compressor by name %s", (Object) str);
    }

    public boolean isReady() {
        return this.stream.isReady();
    }

    public void close(Status status, Metadata metadata) {
        PerfMark.taskStart(this.tag, "ServerCall.close");
        try {
            closeInternal(status, metadata);
        } finally {
            PerfMark.taskEnd(this.tag, "ServerCall.close");
        }
    }

    private void closeInternal(Status status, Metadata metadata) {
        Preconditions.checkState(!this.closeCalled, "call already closed");
        try {
            this.closeCalled = true;
            if (!status.isOk() || !this.method.getType().serverSendsOneMessage() || this.messageSent) {
                this.stream.close(status, metadata);
                this.serverCallTracer.reportCallEnded(status.isOk());
                return;
            }
            internalClose(Status.INTERNAL.withDescription(MISSING_RESPONSE));
        } finally {
            this.serverCallTracer.reportCallEnded(status.isOk());
        }
    }

    public boolean isCancelled() {
        return this.cancelled;
    }

    /* access modifiers changed from: package-private */
    public ServerStreamListener newServerStreamListener(ServerCall.Listener<ReqT> listener) {
        return new ServerStreamListenerImpl(this, listener, this.context);
    }

    public Attributes getAttributes() {
        return this.stream.getAttributes();
    }

    public String getAuthority() {
        return this.stream.getAuthority();
    }

    public MethodDescriptor<ReqT, RespT> getMethodDescriptor() {
        return this.method;
    }

    private void internalClose(Status status) {
        log.log(Level.WARNING, "Cancelling the stream with status {0}", new Object[]{status});
        this.stream.cancel(status);
        this.serverCallTracer.reportCallEnded(status.isOk());
    }

    @VisibleForTesting
    static final class ServerStreamListenerImpl<ReqT> implements ServerStreamListener {
        /* access modifiers changed from: private */
        public final ServerCallImpl<ReqT, ?> call;
        private final Context.CancellableContext context;
        private final ServerCall.Listener<ReqT> listener;

        public ServerStreamListenerImpl(ServerCallImpl<ReqT, ?> serverCallImpl, ServerCall.Listener<ReqT> listener2, Context.CancellableContext cancellableContext) {
            this.call = (ServerCallImpl) Preconditions.checkNotNull(serverCallImpl, NotificationCompat.CATEGORY_CALL);
            this.listener = (ServerCall.Listener) Preconditions.checkNotNull(listener2, "listener must not be null");
            this.context = (Context.CancellableContext) Preconditions.checkNotNull(cancellableContext, "context");
            this.context.addListener(new Context.CancellationListener() {
                public void cancelled(Context context) {
                    boolean unused = ServerStreamListenerImpl.this.call.cancelled = true;
                }
            }, MoreExecutors.directExecutor());
        }

        public void messagesAvailable(StreamListener.MessageProducer messageProducer) {
            InputStream next;
            if (this.call.cancelled) {
                GrpcUtil.closeQuietly(messageProducer);
                return;
            }
            PerfMark.taskStart(this.call.tag, "ServerCall.messagesAvailable");
            while (true) {
                try {
                    next = messageProducer.next();
                    if (next != null) {
                        this.listener.onMessage(this.call.method.parseRequest(next));
                        next.close();
                    } else {
                        PerfMark.taskEnd(this.call.tag, "ServerCall.messagesAvailable");
                        return;
                    }
                } catch (Throwable th) {
                    try {
                        GrpcUtil.closeQuietly(messageProducer);
                        Throwables.throwIfUnchecked(th);
                        throw new RuntimeException(th);
                    } catch (Throwable th2) {
                        PerfMark.taskEnd(this.call.tag, "ServerCall.messagesAvailable");
                        throw th2;
                    }
                }
            }
        }

        public void halfClosed() {
            if (!this.call.cancelled) {
                PerfMark.taskStart(this.call.tag, "ServerCall.halfClosed");
                try {
                    this.listener.onHalfClose();
                } finally {
                    PerfMark.taskEnd(this.call.tag, "ServerCall.halfClosed");
                }
            }
        }

        public void closed(Status status) {
            PerfMark.taskStart(this.call.tag, "ServerCall.closed");
            try {
                if (status.isOk()) {
                    this.listener.onComplete();
                } else {
                    boolean unused = this.call.cancelled = true;
                    this.listener.onCancel();
                }
                this.context.cancel((Throwable) null);
                PerfMark.taskEnd(this.call.tag, "ServerCall.closed");
            } catch (Throwable th) {
                PerfMark.taskEnd(this.call.tag, "ServerCall.closed");
                throw th;
            }
        }

        public void onReady() {
            if (!this.call.cancelled) {
                PerfMark.taskStart(this.call.tag, "ServerCall.closed");
                try {
                    this.listener.onReady();
                } finally {
                    PerfMark.taskEnd(this.call.tag, "ServerCall.closed");
                }
            }
        }
    }
}
