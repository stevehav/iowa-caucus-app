package io.grpc.okhttp;

import androidx.core.app.NotificationCompat;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.okhttp.internal.framed.FrameWriter;
import java.io.IOException;
import javax.annotation.Nullable;
import okio.Buffer;

class OutboundFlowController {
    /* access modifiers changed from: private */
    public final OutboundFlowState connectionState;
    /* access modifiers changed from: private */
    public final FrameWriter frameWriter;
    private int initialWindowSize;
    private final OkHttpClientTransport transport;

    OutboundFlowController(OkHttpClientTransport okHttpClientTransport, FrameWriter frameWriter2, int i) {
        this.transport = (OkHttpClientTransport) Preconditions.checkNotNull(okHttpClientTransport, NotificationCompat.CATEGORY_TRANSPORT);
        this.frameWriter = (FrameWriter) Preconditions.checkNotNull(frameWriter2, "frameWriter");
        this.initialWindowSize = i;
        this.connectionState = new OutboundFlowState(0, i);
    }

    /* access modifiers changed from: package-private */
    public boolean initialOutboundWindowSize(int i) {
        if (i >= 0) {
            int i2 = i - this.initialWindowSize;
            this.initialWindowSize = i;
            for (OkHttpClientStream okHttpClientStream : this.transport.getActiveStreams()) {
                OutboundFlowState outboundFlowState = (OutboundFlowState) okHttpClientStream.getOutboundFlowState();
                if (outboundFlowState == null) {
                    okHttpClientStream.setOutboundFlowState(new OutboundFlowState(this, okHttpClientStream, this.initialWindowSize));
                } else {
                    outboundFlowState.incrementStreamWindow(i2);
                }
            }
            if (i2 > 0) {
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("Invalid initial window size: " + i);
    }

    /* access modifiers changed from: package-private */
    public int windowUpdate(@Nullable OkHttpClientStream okHttpClientStream, int i) {
        if (okHttpClientStream == null) {
            int incrementStreamWindow = this.connectionState.incrementStreamWindow(i);
            writeStreams();
            return incrementStreamWindow;
        }
        OutboundFlowState state = state(okHttpClientStream);
        int incrementStreamWindow2 = state.incrementStreamWindow(i);
        WriteStatus writeStatus = new WriteStatus();
        state.writeBytes(state.writableWindow(), writeStatus);
        if (writeStatus.hasWritten()) {
            flush();
        }
        return incrementStreamWindow2;
    }

    /* access modifiers changed from: package-private */
    public void data(boolean z, int i, Buffer buffer, boolean z2) {
        Preconditions.checkNotNull(buffer, FirebaseAnalytics.Param.SOURCE);
        OkHttpClientStream stream = this.transport.getStream(i);
        if (stream != null) {
            OutboundFlowState state = state(stream);
            int writableWindow = state.writableWindow();
            boolean hasPendingData = state.hasPendingData();
            int size = (int) buffer.size();
            if (hasPendingData || writableWindow < size) {
                if (!hasPendingData && writableWindow > 0) {
                    state.write(buffer, writableWindow, false);
                }
                state.enqueue(buffer, (int) buffer.size(), z);
            } else {
                state.write(buffer, size, z);
            }
            if (z2) {
                flush();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        try {
            this.frameWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private OutboundFlowState state(OkHttpClientStream okHttpClientStream) {
        OutboundFlowState outboundFlowState = (OutboundFlowState) okHttpClientStream.getOutboundFlowState();
        if (outboundFlowState != null) {
            return outboundFlowState;
        }
        OutboundFlowState outboundFlowState2 = new OutboundFlowState(this, okHttpClientStream, this.initialWindowSize);
        okHttpClientStream.setOutboundFlowState(outboundFlowState2);
        return outboundFlowState2;
    }

    /* access modifiers changed from: package-private */
    public void writeStreams() {
        int i;
        OkHttpClientStream[] activeStreams = this.transport.getActiveStreams();
        int window = this.connectionState.window();
        int length = activeStreams.length;
        while (true) {
            i = 0;
            if (length <= 0 || window <= 0) {
                WriteStatus writeStatus = new WriteStatus();
                OkHttpClientStream[] activeStreams2 = this.transport.getActiveStreams();
                int length2 = activeStreams2.length;
            } else {
                int ceil = (int) Math.ceil((double) (((float) window) / ((float) length)));
                int i2 = 0;
                while (i < length && window > 0) {
                    OkHttpClientStream okHttpClientStream = activeStreams[i];
                    OutboundFlowState state = state(okHttpClientStream);
                    int min = Math.min(window, Math.min(state.unallocatedBytes(), ceil));
                    if (min > 0) {
                        state.allocateBytes(min);
                        window -= min;
                    }
                    if (state.unallocatedBytes() > 0) {
                        activeStreams[i2] = okHttpClientStream;
                        i2++;
                    }
                    i++;
                }
                length = i2;
            }
        }
        WriteStatus writeStatus2 = new WriteStatus();
        OkHttpClientStream[] activeStreams22 = this.transport.getActiveStreams();
        int length22 = activeStreams22.length;
        while (i < length22) {
            OutboundFlowState state2 = state(activeStreams22[i]);
            state2.writeBytes(state2.allocatedBytes(), writeStatus2);
            state2.clearAllocatedBytes();
            i++;
        }
        if (writeStatus2.hasWritten()) {
            flush();
        }
    }

    private static final class WriteStatus {
        int numWrites;

        private WriteStatus() {
        }

        /* access modifiers changed from: package-private */
        public void incrementNumWrites() {
            this.numWrites++;
        }

        /* access modifiers changed from: package-private */
        public boolean hasWritten() {
            return this.numWrites > 0;
        }
    }

    private final class OutboundFlowState {
        int allocatedBytes;
        boolean pendingBufferHasEndOfStream;
        final Buffer pendingWriteBuffer;
        OkHttpClientStream stream;
        final int streamId;
        int window;

        OutboundFlowState(int i, int i2) {
            this.pendingBufferHasEndOfStream = false;
            this.streamId = i;
            this.window = i2;
            this.pendingWriteBuffer = new Buffer();
        }

        OutboundFlowState(OutboundFlowController outboundFlowController, OkHttpClientStream okHttpClientStream, int i) {
            this(okHttpClientStream.id(), i);
            this.stream = okHttpClientStream;
        }

        /* access modifiers changed from: package-private */
        public int window() {
            return this.window;
        }

        /* access modifiers changed from: package-private */
        public void allocateBytes(int i) {
            this.allocatedBytes += i;
        }

        /* access modifiers changed from: package-private */
        public int allocatedBytes() {
            return this.allocatedBytes;
        }

        /* access modifiers changed from: package-private */
        public int unallocatedBytes() {
            return streamableBytes() - this.allocatedBytes;
        }

        /* access modifiers changed from: package-private */
        public void clearAllocatedBytes() {
            this.allocatedBytes = 0;
        }

        /* access modifiers changed from: package-private */
        public int incrementStreamWindow(int i) {
            if (i <= 0 || Integer.MAX_VALUE - i >= this.window) {
                this.window += i;
                return this.window;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.streamId);
        }

        /* access modifiers changed from: package-private */
        public int writableWindow() {
            return Math.min(this.window, OutboundFlowController.this.connectionState.window());
        }

        /* access modifiers changed from: package-private */
        public int streamableBytes() {
            return Math.max(0, Math.min(this.window, (int) this.pendingWriteBuffer.size()));
        }

        /* access modifiers changed from: package-private */
        public boolean hasPendingData() {
            return this.pendingWriteBuffer.size() > 0;
        }

        /* access modifiers changed from: package-private */
        public int writeBytes(int i, WriteStatus writeStatus) {
            int min = Math.min(i, writableWindow());
            int i2 = 0;
            while (hasPendingData() && min > 0) {
                if (((long) min) >= this.pendingWriteBuffer.size()) {
                    i2 += (int) this.pendingWriteBuffer.size();
                    Buffer buffer = this.pendingWriteBuffer;
                    write(buffer, (int) buffer.size(), this.pendingBufferHasEndOfStream);
                } else {
                    i2 += min;
                    write(this.pendingWriteBuffer, min, false);
                }
                writeStatus.incrementNumWrites();
                min = Math.min(i - i2, writableWindow());
            }
            return i2;
        }

        /* access modifiers changed from: package-private */
        public void write(Buffer buffer, int i, boolean z) {
            do {
                int min = Math.min(i, OutboundFlowController.this.frameWriter.maxDataLength());
                int i2 = -min;
                OutboundFlowController.this.connectionState.incrementStreamWindow(i2);
                incrementStreamWindow(i2);
                try {
                    OutboundFlowController.this.frameWriter.data(buffer.size() == ((long) min) && z, this.streamId, buffer, min);
                    this.stream.transportState().onSentBytes(min);
                    i -= min;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } while (i > 0);
        }

        /* access modifiers changed from: package-private */
        public void enqueue(Buffer buffer, int i, boolean z) {
            this.pendingWriteBuffer.write(buffer, (long) i);
            this.pendingBufferHasEndOfStream |= z;
        }
    }
}
