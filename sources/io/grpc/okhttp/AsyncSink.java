package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.internal.SerializingExecutor;
import io.grpc.okhttp.ExceptionHandlingFrameWriter;
import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import okio.Buffer;
import okio.Sink;
import okio.Timeout;

final class AsyncSink implements Sink {
    /* access modifiers changed from: private */
    public final Buffer buffer = new Buffer();
    private boolean closed = false;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean flushEnqueued = false;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private final SerializingExecutor serializingExecutor;
    /* access modifiers changed from: private */
    @Nullable
    public Sink sink;
    /* access modifiers changed from: private */
    @Nullable
    public Socket socket;
    /* access modifiers changed from: private */
    public final ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler;
    /* access modifiers changed from: private */
    @GuardedBy("lock")
    public boolean writeEnqueued = false;

    private AsyncSink(SerializingExecutor serializingExecutor2, ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler2) {
        this.serializingExecutor = (SerializingExecutor) Preconditions.checkNotNull(serializingExecutor2, "executor");
        this.transportExceptionHandler = (ExceptionHandlingFrameWriter.TransportExceptionHandler) Preconditions.checkNotNull(transportExceptionHandler2, "exceptionHandler");
    }

    static AsyncSink sink(SerializingExecutor serializingExecutor2, ExceptionHandlingFrameWriter.TransportExceptionHandler transportExceptionHandler2) {
        return new AsyncSink(serializingExecutor2, transportExceptionHandler2);
    }

    /* access modifiers changed from: package-private */
    public void becomeConnected(Sink sink2, Socket socket2) {
        Preconditions.checkState(this.sink == null, "AsyncSink's becomeConnected should only be called once.");
        this.sink = (Sink) Preconditions.checkNotNull(sink2, "sink");
        this.socket = (Socket) Preconditions.checkNotNull(socket2, "socket");
    }

    public void write(Buffer buffer2, long j) throws IOException {
        Preconditions.checkNotNull(buffer2, FirebaseAnalytics.Param.SOURCE);
        if (!this.closed) {
            synchronized (this.lock) {
                this.buffer.write(buffer2, j);
                if (!this.writeEnqueued && !this.flushEnqueued) {
                    if (this.buffer.completeSegmentByteCount() > 0) {
                        this.writeEnqueued = true;
                        this.serializingExecutor.execute(new WriteRunnable() {
                            public void doRun() throws IOException {
                                Buffer buffer = new Buffer();
                                synchronized (AsyncSink.this.lock) {
                                    buffer.write(AsyncSink.this.buffer, AsyncSink.this.buffer.completeSegmentByteCount());
                                    boolean unused = AsyncSink.this.writeEnqueued = false;
                                }
                                AsyncSink.this.sink.write(buffer, buffer.size());
                            }
                        });
                        return;
                    }
                }
                return;
            }
        }
        throw new IOException("closed");
    }

    public void flush() throws IOException {
        if (!this.closed) {
            synchronized (this.lock) {
                if (!this.flushEnqueued) {
                    this.flushEnqueued = true;
                    this.serializingExecutor.execute(new WriteRunnable() {
                        public void doRun() throws IOException {
                            Buffer buffer = new Buffer();
                            synchronized (AsyncSink.this.lock) {
                                buffer.write(AsyncSink.this.buffer, AsyncSink.this.buffer.size());
                                boolean unused = AsyncSink.this.flushEnqueued = false;
                            }
                            AsyncSink.this.sink.write(buffer, buffer.size());
                            AsyncSink.this.sink.flush();
                        }
                    });
                    return;
                }
                return;
            }
        }
        throw new IOException("closed");
    }

    public Timeout timeout() {
        return Timeout.NONE;
    }

    public void close() {
        if (!this.closed) {
            this.closed = true;
            this.serializingExecutor.execute(new Runnable() {
                public void run() {
                    AsyncSink.this.buffer.close();
                    try {
                        if (AsyncSink.this.sink != null) {
                            AsyncSink.this.sink.close();
                        }
                    } catch (IOException e) {
                        AsyncSink.this.transportExceptionHandler.onException(e);
                    }
                    try {
                        if (AsyncSink.this.socket != null) {
                            AsyncSink.this.socket.close();
                        }
                    } catch (IOException e2) {
                        AsyncSink.this.transportExceptionHandler.onException(e2);
                    }
                }
            });
        }
    }

    private abstract class WriteRunnable implements Runnable {
        public abstract void doRun() throws IOException;

        private WriteRunnable() {
        }

        public final void run() {
            try {
                if (AsyncSink.this.sink != null) {
                    doRun();
                    return;
                }
                throw new IOException("Unable to perform write due to unavailable sink.");
            } catch (Exception e) {
                AsyncSink.this.transportExceptionHandler.onException(e);
            }
        }
    }
}
