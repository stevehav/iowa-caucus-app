package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.CallOptions;
import io.grpc.Compressor;
import io.grpc.Deadline;
import io.grpc.DecompressorRegistry;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.MessageFramer;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public abstract class AbstractClientStream extends AbstractStream implements ClientStream, MessageFramer.Sink {
    /* access modifiers changed from: private */
    public static final Logger log = Logger.getLogger(AbstractClientStream.class.getName());
    private volatile boolean cancelled;
    private final Framer framer;
    private Metadata headers;
    private boolean shouldBeCountedForInUse;
    private final TransportTracer transportTracer;
    private boolean useGet;

    protected interface Sink {
        void cancel(Status status);

        void request(int i);

        void writeFrame(@Nullable WritableBuffer writableBuffer, boolean z, boolean z2, int i);

        void writeHeaders(Metadata metadata, @Nullable byte[] bArr);
    }

    /* access modifiers changed from: protected */
    public abstract Sink abstractClientStreamSink();

    /* access modifiers changed from: protected */
    public abstract TransportState transportState();

    protected AbstractClientStream(WritableBufferAllocator writableBufferAllocator, StatsTraceContext statsTraceContext, TransportTracer transportTracer2, Metadata metadata, CallOptions callOptions, boolean z) {
        Preconditions.checkNotNull(metadata, "headers");
        this.transportTracer = (TransportTracer) Preconditions.checkNotNull(transportTracer2, "transportTracer");
        this.shouldBeCountedForInUse = GrpcUtil.shouldBeCountedForInUse(callOptions);
        this.useGet = z;
        if (!z) {
            this.framer = new MessageFramer(this, writableBufferAllocator, statsTraceContext);
            this.headers = metadata;
            return;
        }
        this.framer = new GetFramer(metadata, statsTraceContext);
    }

    public void setDeadline(Deadline deadline) {
        this.headers.discardAll(GrpcUtil.TIMEOUT_KEY);
        this.headers.put(GrpcUtil.TIMEOUT_KEY, Long.valueOf(Math.max(0, deadline.timeRemaining(TimeUnit.NANOSECONDS))));
    }

    public void setMaxOutboundMessageSize(int i) {
        this.framer.setMaxOutboundMessageSize(i);
    }

    public void setMaxInboundMessageSize(int i) {
        transportState().setMaxInboundMessageSize(i);
    }

    public final void setFullStreamDecompression(boolean z) {
        transportState().setFullStreamDecompression(z);
    }

    public final void setDecompressorRegistry(DecompressorRegistry decompressorRegistry) {
        transportState().setDecompressorRegistry(decompressorRegistry);
    }

    public final void start(ClientStreamListener clientStreamListener) {
        transportState().setListener(clientStreamListener);
        if (!this.useGet) {
            abstractClientStreamSink().writeHeaders(this.headers, (byte[]) null);
            this.headers = null;
        }
    }

    /* access modifiers changed from: protected */
    public final Framer framer() {
        return this.framer;
    }

    public final boolean shouldBeCountedForInUse() {
        return this.shouldBeCountedForInUse;
    }

    public final void request(int i) {
        abstractClientStreamSink().request(i);
    }

    public final void deliverFrame(WritableBuffer writableBuffer, boolean z, boolean z2, int i) {
        Preconditions.checkArgument(writableBuffer != null || z, "null frame before EOS");
        abstractClientStreamSink().writeFrame(writableBuffer, z, z2, i);
    }

    public final void halfClose() {
        if (!transportState().isOutboundClosed()) {
            transportState().setOutboundClosed();
            endOfMessages();
        }
    }

    public final void cancel(Status status) {
        Preconditions.checkArgument(!status.isOk(), "Should not cancel with OK status");
        this.cancelled = true;
        abstractClientStreamSink().cancel(status);
    }

    public final boolean isReady() {
        return super.isReady() && !this.cancelled;
    }

    /* access modifiers changed from: protected */
    public TransportTracer getTransportTracer() {
        return this.transportTracer;
    }

    protected static abstract class TransportState extends AbstractStream.TransportState {
        private DecompressorRegistry decompressorRegistry = DecompressorRegistry.getDefaultInstance();
        private boolean deframerClosed = false;
        private Runnable deframerClosedTask;
        private boolean fullStreamDecompression;
        private ClientStreamListener listener;
        private boolean listenerClosed;
        private volatile boolean outboundClosed;
        private final StatsTraceContext statsTraceCtx;
        private boolean statusReported;
        private boolean statusReportedIsOk;

        protected TransportState(int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
            super(i, statsTraceContext, transportTracer);
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        }

        /* access modifiers changed from: private */
        public void setFullStreamDecompression(boolean z) {
            this.fullStreamDecompression = z;
        }

        /* access modifiers changed from: private */
        public void setDecompressorRegistry(DecompressorRegistry decompressorRegistry2) {
            Preconditions.checkState(this.listener == null, "Already called start");
            this.decompressorRegistry = (DecompressorRegistry) Preconditions.checkNotNull(decompressorRegistry2, "decompressorRegistry");
        }

        @VisibleForTesting
        public final void setListener(ClientStreamListener clientStreamListener) {
            Preconditions.checkState(this.listener == null, "Already called setListener");
            this.listener = (ClientStreamListener) Preconditions.checkNotNull(clientStreamListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }

        public void deframerClosed(boolean z) {
            Preconditions.checkState(this.statusReported, "status should have been reported on deframer closed");
            this.deframerClosed = true;
            if (this.statusReportedIsOk && z) {
                transportReportStatus(Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame"), true, new Metadata());
            }
            Runnable runnable = this.deframerClosedTask;
            if (runnable != null) {
                runnable.run();
                this.deframerClosedTask = null;
            }
        }

        /* access modifiers changed from: protected */
        public final ClientStreamListener listener() {
            return this.listener;
        }

        /* access modifiers changed from: private */
        public final void setOutboundClosed() {
            this.outboundClosed = true;
        }

        /* access modifiers changed from: protected */
        public final boolean isOutboundClosed() {
            return this.outboundClosed;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x005a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void inboundHeadersReceived(io.grpc.Metadata r6) {
            /*
                r5 = this;
                boolean r0 = r5.statusReported
                r1 = 1
                r0 = r0 ^ r1
                java.lang.String r2 = "Received headers on closed stream"
                com.google.common.base.Preconditions.checkState(r0, r2)
                io.grpc.internal.StatsTraceContext r0 = r5.statsTraceCtx
                r0.clientInboundHeaders()
                io.grpc.Metadata$Key<java.lang.String> r0 = io.grpc.internal.GrpcUtil.CONTENT_ENCODING_KEY
                java.lang.Object r0 = r6.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                boolean r2 = r5.fullStreamDecompression
                r3 = 0
                if (r2 == 0) goto L_0x004f
                if (r0 == 0) goto L_0x004f
                java.lang.String r2 = "gzip"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 == 0) goto L_0x002f
                io.grpc.internal.GzipInflatingBuffer r0 = new io.grpc.internal.GzipInflatingBuffer
                r0.<init>()
                r5.setFullStreamDecompressor(r0)
                r0 = 1
                goto L_0x0050
            L_0x002f:
                java.lang.String r2 = "identity"
                boolean r2 = r0.equalsIgnoreCase(r2)
                if (r2 != 0) goto L_0x004f
                io.grpc.Status r6 = io.grpc.Status.INTERNAL
                java.lang.Object[] r1 = new java.lang.Object[r1]
                r1[r3] = r0
                java.lang.String r0 = "Can't find full stream decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r0, r1)
                io.grpc.Status r6 = r6.withDescription(r0)
                io.grpc.StatusRuntimeException r6 = r6.asRuntimeException()
                r5.deframeFailed(r6)
                return
            L_0x004f:
                r0 = 0
            L_0x0050:
                io.grpc.Metadata$Key<java.lang.String> r2 = io.grpc.internal.GrpcUtil.MESSAGE_ENCODING_KEY
                java.lang.Object r2 = r6.get(r2)
                java.lang.String r2 = (java.lang.String) r2
                if (r2 == 0) goto L_0x0099
                io.grpc.DecompressorRegistry r4 = r5.decompressorRegistry
                io.grpc.Decompressor r4 = r4.lookupDecompressor(r2)
                if (r4 != 0) goto L_0x007a
                io.grpc.Status r6 = io.grpc.Status.INTERNAL
                java.lang.Object[] r0 = new java.lang.Object[r1]
                r0[r3] = r2
                java.lang.String r1 = "Can't find decompressor for %s"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                io.grpc.Status r6 = r6.withDescription(r0)
                io.grpc.StatusRuntimeException r6 = r6.asRuntimeException()
                r5.deframeFailed(r6)
                return
            L_0x007a:
                io.grpc.Codec r1 = io.grpc.Codec.Identity.NONE
                if (r4 == r1) goto L_0x0099
                if (r0 == 0) goto L_0x0096
                io.grpc.Status r6 = io.grpc.Status.INTERNAL
                java.lang.Object[] r0 = new java.lang.Object[r3]
                java.lang.String r1 = "Full stream and gRPC message encoding cannot both be set"
                java.lang.String r0 = java.lang.String.format(r1, r0)
                io.grpc.Status r6 = r6.withDescription(r0)
                io.grpc.StatusRuntimeException r6 = r6.asRuntimeException()
                r5.deframeFailed(r6)
                return
            L_0x0096:
                r5.setDecompressor(r4)
            L_0x0099:
                io.grpc.internal.ClientStreamListener r0 = r5.listener()
                r0.headersRead(r6)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.AbstractClientStream.TransportState.inboundHeadersReceived(io.grpc.Metadata):void");
        }

        /* access modifiers changed from: protected */
        public void inboundDataReceived(ReadableBuffer readableBuffer) {
            Preconditions.checkNotNull(readableBuffer, "frame");
            boolean z = true;
            try {
                if (this.statusReported) {
                    AbstractClientStream.log.log(Level.INFO, "Received data on closed stream");
                    readableBuffer.close();
                    return;
                }
                z = false;
                deframe(readableBuffer);
            } catch (Throwable th) {
                if (z) {
                    readableBuffer.close();
                }
                throw th;
            }
        }

        /* access modifiers changed from: protected */
        public void inboundTrailersReceived(Metadata metadata, Status status) {
            Preconditions.checkNotNull(status, NotificationCompat.CATEGORY_STATUS);
            Preconditions.checkNotNull(metadata, GrpcUtil.TE_TRAILERS);
            if (this.statusReported) {
                AbstractClientStream.log.log(Level.INFO, "Received trailers on closed stream:\n {1}\n {2}", new Object[]{status, metadata});
                return;
            }
            this.statsTraceCtx.clientInboundTrailers(metadata);
            transportReportStatus(status, false, metadata);
        }

        public final void transportReportStatus(Status status, boolean z, Metadata metadata) {
            transportReportStatus(status, ClientStreamListener.RpcProgress.PROCESSED, z, metadata);
        }

        public final void transportReportStatus(final Status status, final ClientStreamListener.RpcProgress rpcProgress, boolean z, final Metadata metadata) {
            Preconditions.checkNotNull(status, NotificationCompat.CATEGORY_STATUS);
            Preconditions.checkNotNull(metadata, GrpcUtil.TE_TRAILERS);
            if (!this.statusReported || z) {
                this.statusReported = true;
                this.statusReportedIsOk = status.isOk();
                onStreamDeallocated();
                if (this.deframerClosed) {
                    this.deframerClosedTask = null;
                    closeListener(status, rpcProgress, metadata);
                    return;
                }
                this.deframerClosedTask = new Runnable() {
                    public void run() {
                        TransportState.this.closeListener(status, rpcProgress, metadata);
                    }
                };
                closeDeframer(z);
            }
        }

        /* access modifiers changed from: private */
        public void closeListener(Status status, ClientStreamListener.RpcProgress rpcProgress, Metadata metadata) {
            if (!this.listenerClosed) {
                this.listenerClosed = true;
                this.statsTraceCtx.streamClosed(status);
                listener().closed(status, rpcProgress, metadata);
                if (getTransportTracer() != null) {
                    getTransportTracer().reportStreamClosed(status.isOk());
                }
            }
        }
    }

    private class GetFramer implements Framer {
        private boolean closed;
        private Metadata headers;
        private byte[] payload;
        private final StatsTraceContext statsTraceCtx;

        public void flush() {
        }

        public Framer setCompressor(Compressor compressor) {
            return this;
        }

        public void setMaxOutboundMessageSize(int i) {
        }

        public Framer setMessageCompression(boolean z) {
            return this;
        }

        public GetFramer(Metadata metadata, StatsTraceContext statsTraceContext) {
            this.headers = (Metadata) Preconditions.checkNotNull(metadata, "headers");
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        }

        public void writePayload(InputStream inputStream) {
            Preconditions.checkState(this.payload == null, "writePayload should not be called multiple times");
            try {
                this.payload = IoUtils.toByteArray(inputStream);
                this.statsTraceCtx.outboundMessage(0);
                StatsTraceContext statsTraceContext = this.statsTraceCtx;
                byte[] bArr = this.payload;
                statsTraceContext.outboundMessageSent(0, (long) bArr.length, (long) bArr.length);
                this.statsTraceCtx.outboundUncompressedSize((long) this.payload.length);
                this.statsTraceCtx.outboundWireSize((long) this.payload.length);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public boolean isClosed() {
            return this.closed;
        }

        public void close() {
            boolean z = true;
            this.closed = true;
            if (this.payload == null) {
                z = false;
            }
            Preconditions.checkState(z, "Lack of request message. GET request is only supported for unary requests");
            AbstractClientStream.this.abstractClientStreamSink().writeHeaders(this.headers, this.payload);
            this.payload = null;
            this.headers = null;
        }

        public void dispose() {
            this.closed = true;
            this.payload = null;
            this.headers = null;
        }
    }
}
