package io.grpc.internal;

import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.Preconditions;
import io.grpc.Attributes;
import io.grpc.Decompressor;
import io.grpc.InternalStatus;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import io.grpc.internal.MessageFramer;
import javax.annotation.Nullable;

public abstract class AbstractServerStream extends AbstractStream implements ServerStream, MessageFramer.Sink {
    private final MessageFramer framer;
    private boolean headersSent;
    private boolean outboundClosed;
    private final StatsTraceContext statsTraceCtx;

    protected interface Sink {
        void cancel(Status status);

        void request(int i);

        void writeFrame(@Nullable WritableBuffer writableBuffer, boolean z, int i);

        void writeHeaders(Metadata metadata);

        void writeTrailers(Metadata metadata, boolean z, Status status);
    }

    /* access modifiers changed from: protected */
    public abstract Sink abstractServerStreamSink();

    public String getAuthority() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract TransportState transportState();

    protected AbstractServerStream(WritableBufferAllocator writableBufferAllocator, StatsTraceContext statsTraceContext) {
        this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        this.framer = new MessageFramer(this, writableBufferAllocator, statsTraceContext);
    }

    /* access modifiers changed from: protected */
    public final MessageFramer framer() {
        return this.framer;
    }

    public final void request(int i) {
        abstractServerStreamSink().request(i);
    }

    public final void writeHeaders(Metadata metadata) {
        Preconditions.checkNotNull(metadata, "headers");
        this.headersSent = true;
        abstractServerStreamSink().writeHeaders(metadata);
    }

    public final void deliverFrame(WritableBuffer writableBuffer, boolean z, boolean z2, int i) {
        Sink abstractServerStreamSink = abstractServerStreamSink();
        if (z) {
            z2 = false;
        }
        abstractServerStreamSink.writeFrame(writableBuffer, z2, i);
    }

    public final void close(Status status, Metadata metadata) {
        Preconditions.checkNotNull(status, NotificationCompat.CATEGORY_STATUS);
        Preconditions.checkNotNull(metadata, GrpcUtil.TE_TRAILERS);
        if (!this.outboundClosed) {
            this.outboundClosed = true;
            endOfMessages();
            addStatusToTrailers(metadata, status);
            transportState().setClosedStatus(status);
            abstractServerStreamSink().writeTrailers(metadata, this.headersSent, status);
        }
    }

    private void addStatusToTrailers(Metadata metadata, Status status) {
        metadata.discardAll(InternalStatus.CODE_KEY);
        metadata.discardAll(InternalStatus.MESSAGE_KEY);
        metadata.put(InternalStatus.CODE_KEY, status);
        if (status.getDescription() != null) {
            metadata.put(InternalStatus.MESSAGE_KEY, status.getDescription());
        }
    }

    public final void cancel(Status status) {
        abstractServerStreamSink().cancel(status);
    }

    public final boolean isReady() {
        return super.isReady();
    }

    public final void setDecompressor(Decompressor decompressor) {
        transportState().setDecompressor((Decompressor) Preconditions.checkNotNull(decompressor, "decompressor"));
    }

    public Attributes getAttributes() {
        return Attributes.EMPTY;
    }

    public final void setListener(ServerStreamListener serverStreamListener) {
        transportState().setListener(serverStreamListener);
    }

    public StatsTraceContext statsTraceContext() {
        return this.statsTraceCtx;
    }

    protected static abstract class TransportState extends AbstractStream.TransportState {
        @Nullable
        private Status closedStatus;
        private boolean deframerClosed = false;
        private Runnable deframerClosedTask;
        private boolean endOfStream = false;
        private boolean immediateCloseRequested = false;
        private ServerStreamListener listener;
        private boolean listenerClosed;
        private final StatsTraceContext statsTraceCtx;

        protected TransportState(int i, StatsTraceContext statsTraceContext, TransportTracer transportTracer) {
            super(i, statsTraceContext, (TransportTracer) Preconditions.checkNotNull(transportTracer, "transportTracer"));
            this.statsTraceCtx = (StatsTraceContext) Preconditions.checkNotNull(statsTraceContext, "statsTraceCtx");
        }

        public final void setListener(ServerStreamListener serverStreamListener) {
            Preconditions.checkState(this.listener == null, "setListener should be called only once");
            this.listener = (ServerStreamListener) Preconditions.checkNotNull(serverStreamListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        }

        public final void onStreamAllocated() {
            super.onStreamAllocated();
            getTransportTracer().reportRemoteStreamStarted();
        }

        public void deframerClosed(boolean z) {
            this.deframerClosed = true;
            if (this.endOfStream) {
                if (this.immediateCloseRequested || !z) {
                    this.listener.halfClosed();
                } else {
                    deframeFailed(Status.INTERNAL.withDescription("Encountered end-of-stream mid-frame").asRuntimeException());
                    this.deframerClosedTask = null;
                    return;
                }
            }
            Runnable runnable = this.deframerClosedTask;
            if (runnable != null) {
                runnable.run();
                this.deframerClosedTask = null;
            }
        }

        /* access modifiers changed from: protected */
        public ServerStreamListener listener() {
            return this.listener;
        }

        public void inboundDataReceived(ReadableBuffer readableBuffer, boolean z) {
            Preconditions.checkState(!this.endOfStream, "Past end of stream");
            deframe(readableBuffer);
            if (z) {
                this.endOfStream = true;
                closeDeframer(false);
            }
        }

        public final void transportReportStatus(final Status status) {
            Preconditions.checkArgument(!status.isOk(), "status must not be OK");
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(status);
                return;
            }
            this.deframerClosedTask = new Runnable() {
                public void run() {
                    TransportState.this.closeListener(status);
                }
            };
            this.immediateCloseRequested = true;
            closeDeframer(true);
        }

        public void complete() {
            if (this.deframerClosed) {
                this.deframerClosedTask = null;
                closeListener(Status.OK);
                return;
            }
            this.deframerClosedTask = new Runnable() {
                public void run() {
                    TransportState.this.closeListener(Status.OK);
                }
            };
            this.immediateCloseRequested = true;
            closeDeframer(true);
        }

        /* access modifiers changed from: private */
        public void closeListener(Status status) {
            Preconditions.checkState(!status.isOk() || this.closedStatus != null);
            if (!this.listenerClosed) {
                if (!status.isOk()) {
                    this.statsTraceCtx.streamClosed(status);
                    getTransportTracer().reportStreamClosed(false);
                } else {
                    this.statsTraceCtx.streamClosed(this.closedStatus);
                    getTransportTracer().reportStreamClosed(this.closedStatus.isOk());
                }
                this.listenerClosed = true;
                onStreamDeallocated();
                listener().closed(status);
            }
        }

        /* access modifiers changed from: private */
        public void setClosedStatus(Status status) {
            Preconditions.checkState(this.closedStatus == null, "closedStatus can only be set once");
            this.closedStatus = status;
        }
    }
}
