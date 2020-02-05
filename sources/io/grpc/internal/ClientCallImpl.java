package io.grpc.internal;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.CompressorRegistry;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.InternalDecompressorRegistry;
import io.grpc.LoadBalancer;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.StreamListener;
import io.grpc.perfmark.PerfMark;
import io.grpc.perfmark.PerfTag;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

final class ClientCallImpl<ReqT, RespT> extends ClientCall<ReqT, RespT> {
    private static final byte[] FULL_STREAM_DECOMPRESSION_ENCODINGS = "gzip".getBytes(Charset.forName("US-ASCII"));
    private static final Logger log = Logger.getLogger(ClientCallImpl.class.getName());
    /* access modifiers changed from: private */
    public final Executor callExecutor;
    private final CallOptions callOptions;
    private boolean cancelCalled;
    /* access modifiers changed from: private */
    public volatile boolean cancelListenersShouldBeRemoved;
    private final Context.CancellationListener cancellationListener = new ContextCancellationListener();
    /* access modifiers changed from: private */
    public final CallTracer channelCallsTracer;
    private final ClientTransportProvider clientTransportProvider;
    private CompressorRegistry compressorRegistry = CompressorRegistry.getDefaultInstance();
    /* access modifiers changed from: private */
    public final Context context;
    private final ScheduledExecutorService deadlineCancellationExecutor;
    private volatile ScheduledFuture<?> deadlineCancellationFuture;
    private DecompressorRegistry decompressorRegistry = DecompressorRegistry.getDefaultInstance();
    private boolean fullStreamDecompression;
    private boolean halfCloseCalled;
    /* access modifiers changed from: private */
    public final MethodDescriptor<ReqT, RespT> method;
    private final boolean retryEnabled;
    /* access modifiers changed from: private */
    public ClientStream stream;
    /* access modifiers changed from: private */
    public final PerfTag tag;
    private final boolean unaryRequest;

    interface ClientTransportProvider {
        ClientTransport get(LoadBalancer.PickSubchannelArgs pickSubchannelArgs);

        <ReqT> ClientStream newRetriableStream(MethodDescriptor<ReqT, ?> methodDescriptor, CallOptions callOptions, Metadata metadata, Context context);
    }

    ClientCallImpl(MethodDescriptor<ReqT, RespT> methodDescriptor, Executor executor, CallOptions callOptions2, ClientTransportProvider clientTransportProvider2, ScheduledExecutorService scheduledExecutorService, CallTracer callTracer, boolean z) {
        Executor executor2;
        this.method = methodDescriptor;
        this.tag = PerfMark.createTag(methodDescriptor.getFullMethodName());
        if (executor == MoreExecutors.directExecutor()) {
            executor2 = new SerializeReentrantCallsDirectExecutor();
        } else {
            executor2 = new SerializingExecutor(executor);
        }
        this.callExecutor = executor2;
        this.channelCallsTracer = callTracer;
        this.context = Context.current();
        this.unaryRequest = methodDescriptor.getType() == MethodDescriptor.MethodType.UNARY || methodDescriptor.getType() == MethodDescriptor.MethodType.SERVER_STREAMING;
        this.callOptions = callOptions2;
        this.clientTransportProvider = clientTransportProvider2;
        this.deadlineCancellationExecutor = scheduledExecutorService;
        this.retryEnabled = z;
    }

    private final class ContextCancellationListener implements Context.CancellationListener {
        private ContextCancellationListener() {
        }

        public void cancelled(Context context) {
            ClientCallImpl.this.stream.cancel(Contexts.statusFromCancelled(context));
        }
    }

    /* access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setFullStreamDecompression(boolean z) {
        this.fullStreamDecompression = z;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setDecompressorRegistry(DecompressorRegistry decompressorRegistry2) {
        this.decompressorRegistry = decompressorRegistry2;
        return this;
    }

    /* access modifiers changed from: package-private */
    public ClientCallImpl<ReqT, RespT> setCompressorRegistry(CompressorRegistry compressorRegistry2) {
        this.compressorRegistry = compressorRegistry2;
        return this;
    }

    @VisibleForTesting
    static void prepareHeaders(Metadata metadata, DecompressorRegistry decompressorRegistry2, Compressor compressor, boolean z) {
        metadata.discardAll(GrpcUtil.MESSAGE_ENCODING_KEY);
        if (compressor != Codec.Identity.NONE) {
            metadata.put(GrpcUtil.MESSAGE_ENCODING_KEY, compressor.getMessageEncoding());
        }
        metadata.discardAll(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY);
        byte[] rawAdvertisedMessageEncodings = InternalDecompressorRegistry.getRawAdvertisedMessageEncodings(decompressorRegistry2);
        if (rawAdvertisedMessageEncodings.length != 0) {
            metadata.put(GrpcUtil.MESSAGE_ACCEPT_ENCODING_KEY, rawAdvertisedMessageEncodings);
        }
        metadata.discardAll(GrpcUtil.CONTENT_ENCODING_KEY);
        metadata.discardAll(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY);
        if (z) {
            metadata.put(GrpcUtil.CONTENT_ACCEPT_ENCODING_KEY, FULL_STREAM_DECOMPRESSION_ENCODINGS);
        }
    }

    public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
        PerfMark.taskStart(this.tag, "ClientCall.start");
        try {
            startInternal(listener, metadata);
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.start");
        }
    }

    private void startInternal(final ClientCall.Listener<RespT> listener, Metadata metadata) {
        Compressor compressor;
        boolean z = false;
        Preconditions.checkState(this.stream == null, "Already started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkNotNull(listener, "observer");
        Preconditions.checkNotNull(metadata, "headers");
        if (this.context.isCancelled()) {
            this.stream = NoopClientStream.INSTANCE;
            this.callExecutor.execute(new ContextRunnable() {
                public void runInContext() {
                    ClientCallImpl clientCallImpl = ClientCallImpl.this;
                    clientCallImpl.closeObserver(listener, Contexts.statusFromCancelled(clientCallImpl.context), new Metadata());
                }
            });
            return;
        }
        final String compressor2 = this.callOptions.getCompressor();
        if (compressor2 != null) {
            compressor = this.compressorRegistry.lookupCompressor(compressor2);
            if (compressor == null) {
                this.stream = NoopClientStream.INSTANCE;
                this.callExecutor.execute(new ContextRunnable() {
                    public void runInContext() {
                        ClientCallImpl.this.closeObserver(listener, Status.INTERNAL.withDescription(String.format("Unable to find compressor by name %s", new Object[]{compressor2})), new Metadata());
                    }
                });
                return;
            }
        } else {
            compressor = Codec.Identity.NONE;
        }
        prepareHeaders(metadata, this.decompressorRegistry, compressor, this.fullStreamDecompression);
        Deadline effectiveDeadline = effectiveDeadline();
        if (effectiveDeadline != null && effectiveDeadline.isExpired()) {
            z = true;
        }
        if (!z) {
            logIfContextNarrowedTimeout(effectiveDeadline, this.callOptions.getDeadline(), this.context.getDeadline());
            if (this.retryEnabled) {
                this.stream = this.clientTransportProvider.newRetriableStream(this.method, this.callOptions, metadata, this.context);
            } else {
                ClientTransport clientTransport = this.clientTransportProvider.get(new PickSubchannelArgsImpl(this.method, metadata, this.callOptions));
                Context attach = this.context.attach();
                try {
                    this.stream = clientTransport.newStream(this.method, metadata, this.callOptions);
                } finally {
                    this.context.detach(attach);
                }
            }
        } else {
            Status status = Status.DEADLINE_EXCEEDED;
            this.stream = new FailingClientStream(status.withDescription("deadline exceeded: " + effectiveDeadline));
        }
        if (this.callOptions.getAuthority() != null) {
            this.stream.setAuthority(this.callOptions.getAuthority());
        }
        if (this.callOptions.getMaxInboundMessageSize() != null) {
            this.stream.setMaxInboundMessageSize(this.callOptions.getMaxInboundMessageSize().intValue());
        }
        if (this.callOptions.getMaxOutboundMessageSize() != null) {
            this.stream.setMaxOutboundMessageSize(this.callOptions.getMaxOutboundMessageSize().intValue());
        }
        if (effectiveDeadline != null) {
            this.stream.setDeadline(effectiveDeadline);
        }
        this.stream.setCompressor(compressor);
        boolean z2 = this.fullStreamDecompression;
        if (z2) {
            this.stream.setFullStreamDecompression(z2);
        }
        this.stream.setDecompressorRegistry(this.decompressorRegistry);
        this.channelCallsTracer.reportCallStarted();
        this.stream.start(new ClientStreamListenerImpl(listener));
        this.context.addListener(this.cancellationListener, MoreExecutors.directExecutor());
        if (!(effectiveDeadline == null || this.context.getDeadline() == effectiveDeadline || this.deadlineCancellationExecutor == null)) {
            this.deadlineCancellationFuture = startDeadlineTimer(effectiveDeadline);
        }
        if (this.cancelListenersShouldBeRemoved) {
            removeContextListenerAndCancelDeadlineFuture();
        }
    }

    private static void logIfContextNarrowedTimeout(Deadline deadline, @Nullable Deadline deadline2, @Nullable Deadline deadline3) {
        if (log.isLoggable(Level.FINE) && deadline != null && deadline2 == deadline) {
            StringBuilder sb = new StringBuilder(String.format("Call timeout set to '%d' ns, due to context deadline.", new Object[]{Long.valueOf(Math.max(0, deadline.timeRemaining(TimeUnit.NANOSECONDS)))}));
            if (deadline3 == null) {
                sb.append(" Explicit call timeout was not set.");
            } else {
                sb.append(String.format(" Explicit call timeout was '%d' ns.", new Object[]{Long.valueOf(deadline3.timeRemaining(TimeUnit.NANOSECONDS))}));
            }
            log.fine(sb.toString());
        }
    }

    /* access modifiers changed from: private */
    public void removeContextListenerAndCancelDeadlineFuture() {
        this.context.removeListener(this.cancellationListener);
        ScheduledFuture<?> scheduledFuture = this.deadlineCancellationFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    private class DeadlineTimer implements Runnable {
        private final long remainingNanos;

        DeadlineTimer(long j) {
            this.remainingNanos = j;
        }

        public void run() {
            ClientCallImpl.this.stream.cancel(Status.DEADLINE_EXCEEDED.augmentDescription(String.format("deadline exceeded after %dns", new Object[]{Long.valueOf(this.remainingNanos)})));
        }
    }

    private ScheduledFuture<?> startDeadlineTimer(Deadline deadline) {
        long timeRemaining = deadline.timeRemaining(TimeUnit.NANOSECONDS);
        return this.deadlineCancellationExecutor.schedule(new LogExceptionRunnable(new DeadlineTimer(timeRemaining)), timeRemaining, TimeUnit.NANOSECONDS);
    }

    /* access modifiers changed from: private */
    @Nullable
    public Deadline effectiveDeadline() {
        return min(this.callOptions.getDeadline(), this.context.getDeadline());
    }

    @Nullable
    private static Deadline min(@Nullable Deadline deadline, @Nullable Deadline deadline2) {
        if (deadline == null) {
            return deadline2;
        }
        return deadline2 == null ? deadline : deadline.minimum(deadline2);
    }

    public void request(int i) {
        boolean z = true;
        Preconditions.checkState(this.stream != null, "Not started");
        if (i < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "Number requested must be non-negative");
        this.stream.request(i);
    }

    public void cancel(@Nullable String str, @Nullable Throwable th) {
        PerfMark.taskStart(this.tag, "ClientCall.cancel");
        try {
            cancelInternal(str, th);
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.cancel");
        }
    }

    private void cancelInternal(@Nullable String str, @Nullable Throwable th) {
        Status status;
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            log.log(Level.WARNING, "Cancelling without a message or cause is suboptimal", th);
        }
        if (!this.cancelCalled) {
            this.cancelCalled = true;
            try {
                if (this.stream != null) {
                    Status status2 = Status.CANCELLED;
                    if (str != null) {
                        status = status2.withDescription(str);
                    } else {
                        status = status2.withDescription("Call cancelled without message");
                    }
                    if (th != null) {
                        status = status.withCause(th);
                    }
                    this.stream.cancel(status);
                }
            } finally {
                removeContextListenerAndCancelDeadlineFuture();
            }
        }
    }

    public void halfClose() {
        PerfMark.taskStart(this.tag, "ClientCall.halfClose");
        try {
            halfCloseInternal();
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.halfClose");
        }
    }

    private void halfCloseInternal() {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call already half-closed");
        this.halfCloseCalled = true;
        this.stream.halfClose();
    }

    public void sendMessage(ReqT reqt) {
        PerfMark.taskStart(this.tag, "ClientCall.sendMessage");
        try {
            sendMessageInternal(reqt);
        } finally {
            PerfMark.taskEnd(this.tag, "ClientCall.sendMessage");
        }
    }

    private void sendMessageInternal(ReqT reqt) {
        Preconditions.checkState(this.stream != null, "Not started");
        Preconditions.checkState(!this.cancelCalled, "call was cancelled");
        Preconditions.checkState(!this.halfCloseCalled, "call was half-closed");
        try {
            if (this.stream instanceof RetriableStream) {
                ((RetriableStream) this.stream).sendMessage(reqt);
            } else {
                this.stream.writeMessage(this.method.streamRequest(reqt));
            }
            if (!this.unaryRequest) {
                this.stream.flush();
            }
        } catch (RuntimeException e) {
            this.stream.cancel(Status.CANCELLED.withCause(e).withDescription("Failed to stream message"));
        } catch (Error e2) {
            this.stream.cancel(Status.CANCELLED.withDescription("Client sendMessage() failed with Error"));
            throw e2;
        }
    }

    public void setMessageCompression(boolean z) {
        Preconditions.checkState(this.stream != null, "Not started");
        this.stream.setMessageCompression(z);
    }

    public boolean isReady() {
        return this.stream.isReady();
    }

    public Attributes getAttributes() {
        ClientStream clientStream = this.stream;
        if (clientStream != null) {
            return clientStream.getAttributes();
        }
        return Attributes.EMPTY;
    }

    /* access modifiers changed from: private */
    public void closeObserver(ClientCall.Listener<RespT> listener, Status status, Metadata metadata) {
        listener.onClose(status, metadata);
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add(FirebaseAnalytics.Param.METHOD, (Object) this.method).toString();
    }

    private class ClientStreamListenerImpl implements ClientStreamListener {
        /* access modifiers changed from: private */
        public boolean closed;
        /* access modifiers changed from: private */
        public final ClientCall.Listener<RespT> observer;

        public ClientStreamListenerImpl(ClientCall.Listener<RespT> listener) {
            this.observer = (ClientCall.Listener) Preconditions.checkNotNull(listener, "observer");
        }

        public void headersRead(final Metadata metadata) {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                public final void runInContext() {
                    if (!ClientStreamListenerImpl.this.closed) {
                        PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.headersRead");
                        try {
                            ClientStreamListenerImpl.this.observer.onHeaders(metadata);
                        } catch (Throwable th) {
                            PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.headersRead");
                            throw th;
                        }
                        PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.headersRead");
                    }
                }
            });
        }

        public void messagesAvailable(final StreamListener.MessageProducer messageProducer) {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                public final void runInContext() {
                    InputStream next;
                    if (ClientStreamListenerImpl.this.closed) {
                        GrpcUtil.closeQuietly(messageProducer);
                        return;
                    }
                    PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.messagesAvailable");
                    while (true) {
                        try {
                            next = messageProducer.next();
                            if (next == null) {
                                break;
                            }
                            ClientStreamListenerImpl.this.observer.onMessage(ClientCallImpl.this.method.parseResponse(next));
                            next.close();
                        } catch (Throwable th) {
                            try {
                                GrpcUtil.closeQuietly(messageProducer);
                                Status withDescription = Status.CANCELLED.withCause(th).withDescription("Failed to read message.");
                                ClientCallImpl.this.stream.cancel(withDescription);
                                ClientStreamListenerImpl.this.close(withDescription, new Metadata());
                            } catch (Throwable th2) {
                                PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.messagesAvailable");
                                throw th2;
                            }
                        }
                    }
                    PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.messagesAvailable");
                }
            });
        }

        /* access modifiers changed from: private */
        public void close(Status status, Metadata metadata) {
            this.closed = true;
            boolean unused = ClientCallImpl.this.cancelListenersShouldBeRemoved = true;
            try {
                ClientCallImpl.this.closeObserver(this.observer, status, metadata);
            } finally {
                ClientCallImpl.this.removeContextListenerAndCancelDeadlineFuture();
                ClientCallImpl.this.channelCallsTracer.reportCallEnded(status.isOk());
            }
        }

        public void closed(Status status, Metadata metadata) {
            closed(status, ClientStreamListener.RpcProgress.PROCESSED, metadata);
        }

        public void closed(final Status status, ClientStreamListener.RpcProgress rpcProgress, final Metadata metadata) {
            Deadline access$1300 = ClientCallImpl.this.effectiveDeadline();
            if (status.getCode() == Status.Code.CANCELLED && access$1300 != null && access$1300.isExpired()) {
                status = Status.DEADLINE_EXCEEDED;
                metadata = new Metadata();
            }
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                public final void runInContext() {
                    if (!ClientStreamListenerImpl.this.closed) {
                        PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.closed");
                        try {
                            ClientStreamListenerImpl.this.close(status, metadata);
                        } finally {
                            PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.closed");
                        }
                    }
                }
            });
        }

        public void onReady() {
            ClientCallImpl.this.callExecutor.execute(new ContextRunnable() {
                {
                    Context access$200 = ClientCallImpl.this.context;
                }

                public final void runInContext() {
                    PerfMark.taskStart(ClientCallImpl.this.tag, "ClientCall.onReady");
                    try {
                        ClientStreamListenerImpl.this.observer.onReady();
                    } catch (Throwable th) {
                        PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.onReady");
                        throw th;
                    }
                    PerfMark.taskEnd(ClientCallImpl.this.tag, "ClientCall.onReady");
                }
            });
        }
    }
}
