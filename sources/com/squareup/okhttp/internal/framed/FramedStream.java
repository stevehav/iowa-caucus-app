package com.squareup.okhttp.internal.framed;

import io.sentry.DefaultSentryClientFactory;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class FramedStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    /* access modifiers changed from: private */
    public final FramedConnection connection;
    /* access modifiers changed from: private */
    public ErrorCode errorCode = null;
    /* access modifiers changed from: private */
    public final int id;
    /* access modifiers changed from: private */
    public final StreamTimeout readTimeout = new StreamTimeout();
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final FramedDataSink sink;
    private final FramedDataSource source;
    long unacknowledgedBytesRead = 0;
    /* access modifiers changed from: private */
    public final StreamTimeout writeTimeout = new StreamTimeout();

    FramedStream(int i, FramedConnection framedConnection, boolean z, boolean z2, List<Header> list) {
        if (framedConnection == null) {
            throw new NullPointerException("connection == null");
        } else if (list != null) {
            this.id = i;
            this.connection = framedConnection;
            this.bytesLeftInWriteWindow = (long) framedConnection.peerSettings.getInitialWindowSize(65536);
            this.source = new FramedDataSource((long) framedConnection.okHttpSettings.getInitialWindowSize(65536));
            this.sink = new FramedDataSink();
            boolean unused = this.source.finished = z2;
            boolean unused2 = this.sink.finished = z;
            this.requestHeaders = list;
        } else {
            throw new NullPointerException("requestHeaders == null");
        }
    }

    public int getId() {
        return this.id;
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && ((this.sink.finished || this.sink.closed) && this.responseHeaders != null)) {
            return false;
        }
        return true;
    }

    public boolean isLocallyInitiated() {
        if (this.connection.client == ((this.id & 1) == 1)) {
            return true;
        }
        return false;
    }

    public FramedConnection getConnection() {
        return this.connection;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0038, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
        r3.readTimeout.exitAndThrowIfTimedOut();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.util.List<com.squareup.okhttp.internal.framed.Header> getResponseHeaders() throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            com.squareup.okhttp.internal.framed.FramedStream$StreamTimeout r0 = r3.readTimeout     // Catch:{ all -> 0x003f }
            r0.enter()     // Catch:{ all -> 0x003f }
        L_0x0006:
            java.util.List<com.squareup.okhttp.internal.framed.Header> r0 = r3.responseHeaders     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x0012
            com.squareup.okhttp.internal.framed.ErrorCode r0 = r3.errorCode     // Catch:{ all -> 0x0038 }
            if (r0 != 0) goto L_0x0012
            r3.waitForIo()     // Catch:{ all -> 0x0038 }
            goto L_0x0006
        L_0x0012:
            com.squareup.okhttp.internal.framed.FramedStream$StreamTimeout r0 = r3.readTimeout     // Catch:{ all -> 0x003f }
            r0.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x003f }
            java.util.List<com.squareup.okhttp.internal.framed.Header> r0 = r3.responseHeaders     // Catch:{ all -> 0x003f }
            if (r0 == 0) goto L_0x001f
            java.util.List<com.squareup.okhttp.internal.framed.Header> r0 = r3.responseHeaders     // Catch:{ all -> 0x003f }
            monitor-exit(r3)
            return r0
        L_0x001f:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x003f }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x003f }
            r1.<init>()     // Catch:{ all -> 0x003f }
            java.lang.String r2 = "stream was reset: "
            r1.append(r2)     // Catch:{ all -> 0x003f }
            com.squareup.okhttp.internal.framed.ErrorCode r2 = r3.errorCode     // Catch:{ all -> 0x003f }
            r1.append(r2)     // Catch:{ all -> 0x003f }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x003f }
            r0.<init>(r1)     // Catch:{ all -> 0x003f }
            throw r0     // Catch:{ all -> 0x003f }
        L_0x0038:
            r0 = move-exception
            com.squareup.okhttp.internal.framed.FramedStream$StreamTimeout r1 = r3.readTimeout     // Catch:{ all -> 0x003f }
            r1.exitAndThrowIfTimedOut()     // Catch:{ all -> 0x003f }
            throw r0     // Catch:{ all -> 0x003f }
        L_0x003f:
            r0 = move-exception
            monitor-exit(r3)
            goto L_0x0043
        L_0x0042:
            throw r0
        L_0x0043:
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedStream.getResponseHeaders():java.util.List");
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public void reply(List<Header> list, boolean z) throws IOException {
        boolean z2 = false;
        synchronized (this) {
            if (list != null) {
                try {
                    if (this.responseHeaders == null) {
                        this.responseHeaders = list;
                        if (!z) {
                            boolean unused = this.sink.finished = true;
                            z2 = true;
                        }
                    } else {
                        throw new IllegalStateException("reply already sent");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                throw new NullPointerException("responseHeaders == null");
            }
        }
        this.connection.writeSynReply(this.id, z2, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public Source getSource() {
        return this.source;
    }

    public Sink getSink() {
        synchronized (this) {
            if (this.responseHeaders == null) {
                if (!isLocallyInitiated()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            }
        }
        return this.sink;
    }

    public void close(ErrorCode errorCode2) throws IOException {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynReset(this.id, errorCode2);
        }
    }

    public void closeLater(ErrorCode errorCode2) {
        if (closeInternal(errorCode2)) {
            this.connection.writeSynResetLater(this.id, errorCode2);
        }
    }

    private boolean closeInternal(ErrorCode errorCode2) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode2;
            notifyAll();
            this.connection.removeStream(this.id);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void receiveHeaders(List<Header> list, HeadersMode headersMode) {
        ErrorCode errorCode2 = null;
        boolean z = true;
        synchronized (this) {
            if (this.responseHeaders == null) {
                if (headersMode.failIfHeadersAbsent()) {
                    errorCode2 = ErrorCode.PROTOCOL_ERROR;
                } else {
                    this.responseHeaders = list;
                    z = isOpen();
                    notifyAll();
                }
            } else if (headersMode.failIfHeadersPresent()) {
                errorCode2 = ErrorCode.STREAM_IN_USE;
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (errorCode2 != null) {
            closeLater(errorCode2);
        } else if (!z) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public void receiveData(BufferedSource bufferedSource, int i) throws IOException {
        this.source.receive(bufferedSource, (long) i);
    }

    /* access modifiers changed from: package-private */
    public void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            boolean unused = this.source.finished = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void receiveRstStream(ErrorCode errorCode2) {
        if (this.errorCode == null) {
            this.errorCode = errorCode2;
            notifyAll();
        }
    }

    private final class FramedDataSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        /* access modifiers changed from: private */
        public boolean closed;
        /* access modifiers changed from: private */
        public boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;

        static {
            Class<FramedStream> cls = FramedStream.class;
        }

        private FramedDataSource(long j) {
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = j;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0065, code lost:
            r11 = com.squareup.okhttp.internal.framed.FramedStream.access$500(r8.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x006b, code lost:
            monitor-enter(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
            com.squareup.okhttp.internal.framed.FramedStream.access$500(r8.this$0).unacknowledgedBytesRead += r9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0090, code lost:
            if (com.squareup.okhttp.internal.framed.FramedStream.access$500(r8.this$0).unacknowledgedBytesRead < ((long) (com.squareup.okhttp.internal.framed.FramedStream.access$500(r8.this$0).okHttpSettings.getInitialWindowSize(65536) / 2))) goto L_0x00ac;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0092, code lost:
            com.squareup.okhttp.internal.framed.FramedStream.access$500(r8.this$0).writeWindowUpdateLater(0, com.squareup.okhttp.internal.framed.FramedStream.access$500(r8.this$0).unacknowledgedBytesRead);
            com.squareup.okhttp.internal.framed.FramedStream.access$500(r8.this$0).unacknowledgedBytesRead = 0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00ac, code lost:
            monitor-exit(r11);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ad, code lost:
            return r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(okio.Buffer r9, long r10) throws java.io.IOException {
            /*
                r8 = this;
                r0 = 0
                int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
                if (r2 < 0) goto L_0x00b4
                com.squareup.okhttp.internal.framed.FramedStream r2 = com.squareup.okhttp.internal.framed.FramedStream.this
                monitor-enter(r2)
                r8.waitUntilReadable()     // Catch:{ all -> 0x00b1 }
                r8.checkNotClosed()     // Catch:{ all -> 0x00b1 }
                okio.Buffer r3 = r8.readBuffer     // Catch:{ all -> 0x00b1 }
                long r3 = r3.size()     // Catch:{ all -> 0x00b1 }
                int r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
                if (r5 != 0) goto L_0x001d
                r9 = -1
                monitor-exit(r2)     // Catch:{ all -> 0x00b1 }
                return r9
            L_0x001d:
                okio.Buffer r3 = r8.readBuffer     // Catch:{ all -> 0x00b1 }
                okio.Buffer r4 = r8.readBuffer     // Catch:{ all -> 0x00b1 }
                long r4 = r4.size()     // Catch:{ all -> 0x00b1 }
                long r10 = java.lang.Math.min(r10, r4)     // Catch:{ all -> 0x00b1 }
                long r9 = r3.read(r9, r10)     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.FramedStream r11 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00b1 }
                long r3 = r11.unacknowledgedBytesRead     // Catch:{ all -> 0x00b1 }
                long r3 = r3 + r9
                r11.unacknowledgedBytesRead = r3     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.FramedStream r11 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00b1 }
                long r3 = r11.unacknowledgedBytesRead     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.FramedStream r11 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.FramedConnection r11 = r11.connection     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.Settings r11 = r11.okHttpSettings     // Catch:{ all -> 0x00b1 }
                r5 = 65536(0x10000, float:9.18355E-41)
                int r11 = r11.getInitialWindowSize(r5)     // Catch:{ all -> 0x00b1 }
                int r11 = r11 / 2
                long r6 = (long) r11     // Catch:{ all -> 0x00b1 }
                int r11 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
                if (r11 < 0) goto L_0x0064
                com.squareup.okhttp.internal.framed.FramedStream r11 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.FramedConnection r11 = r11.connection     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.FramedStream r3 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00b1 }
                int r3 = r3.id     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.FramedStream r4 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00b1 }
                long r6 = r4.unacknowledgedBytesRead     // Catch:{ all -> 0x00b1 }
                r11.writeWindowUpdateLater(r3, r6)     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.FramedStream r11 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00b1 }
                r11.unacknowledgedBytesRead = r0     // Catch:{ all -> 0x00b1 }
            L_0x0064:
                monitor-exit(r2)     // Catch:{ all -> 0x00b1 }
                com.squareup.okhttp.internal.framed.FramedStream r11 = com.squareup.okhttp.internal.framed.FramedStream.this
                com.squareup.okhttp.internal.framed.FramedConnection r11 = r11.connection
                monitor-enter(r11)
                com.squareup.okhttp.internal.framed.FramedStream r2 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.FramedConnection r2 = r2.connection     // Catch:{ all -> 0x00ae }
                long r3 = r2.unacknowledgedBytesRead     // Catch:{ all -> 0x00ae }
                long r3 = r3 + r9
                r2.unacknowledgedBytesRead = r3     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.FramedStream r2 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.FramedConnection r2 = r2.connection     // Catch:{ all -> 0x00ae }
                long r2 = r2.unacknowledgedBytesRead     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.FramedStream r4 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.FramedConnection r4 = r4.connection     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.Settings r4 = r4.okHttpSettings     // Catch:{ all -> 0x00ae }
                int r4 = r4.getInitialWindowSize(r5)     // Catch:{ all -> 0x00ae }
                int r4 = r4 / 2
                long r4 = (long) r4     // Catch:{ all -> 0x00ae }
                int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r6 < 0) goto L_0x00ac
                com.squareup.okhttp.internal.framed.FramedStream r2 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.FramedConnection r2 = r2.connection     // Catch:{ all -> 0x00ae }
                r3 = 0
                com.squareup.okhttp.internal.framed.FramedStream r4 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.FramedConnection r4 = r4.connection     // Catch:{ all -> 0x00ae }
                long r4 = r4.unacknowledgedBytesRead     // Catch:{ all -> 0x00ae }
                r2.writeWindowUpdateLater(r3, r4)     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.FramedStream r2 = com.squareup.okhttp.internal.framed.FramedStream.this     // Catch:{ all -> 0x00ae }
                com.squareup.okhttp.internal.framed.FramedConnection r2 = r2.connection     // Catch:{ all -> 0x00ae }
                r2.unacknowledgedBytesRead = r0     // Catch:{ all -> 0x00ae }
            L_0x00ac:
                monitor-exit(r11)     // Catch:{ all -> 0x00ae }
                return r9
            L_0x00ae:
                r9 = move-exception
                monitor-exit(r11)     // Catch:{ all -> 0x00ae }
                throw r9
            L_0x00b1:
                r9 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x00b1 }
                throw r9
            L_0x00b4:
                java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "byteCount < 0: "
                r0.append(r1)
                r0.append(r10)
                java.lang.String r10 = r0.toString()
                r9.<init>(r10)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedStream.FramedDataSource.read(okio.Buffer, long):long");
        }

        private void waitUntilReadable() throws IOException {
            FramedStream.this.readTimeout.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && FramedStream.this.errorCode == null) {
                try {
                    FramedStream.this.waitForIo();
                } finally {
                    FramedStream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void receive(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (FramedStream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size() + j > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    FramedStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    bufferedSource.skip(j);
                    return;
                } else {
                    long read = bufferedSource.read(this.receiveBuffer, j);
                    if (read != -1) {
                        j -= read;
                        synchronized (FramedStream.this) {
                            if (this.readBuffer.size() != 0) {
                                z2 = false;
                            }
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (z2) {
                                FramedStream.this.notifyAll();
                            }
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public Timeout timeout() {
            return FramedStream.this.readTimeout;
        }

        public void close() throws IOException {
            synchronized (FramedStream.this) {
                this.closed = true;
                this.readBuffer.clear();
                FramedStream.this.notifyAll();
            }
            FramedStream.this.cancelStreamIfNecessary();
        }

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            } else if (FramedStream.this.errorCode != null) {
                throw new IOException("stream was reset: " + FramedStream.this.errorCode);
            }
        }
    }

    /* access modifiers changed from: private */
    public void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            z = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else if (!isOpen) {
            this.connection.removeStream(this.id);
        }
    }

    final class FramedDataSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        /* access modifiers changed from: private */
        public boolean closed;
        /* access modifiers changed from: private */
        public boolean finished;
        private final Buffer sendBuffer = new Buffer();

        FramedDataSink() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            this.sendBuffer.write(buffer, j);
            while (this.sendBuffer.size() >= 16384) {
                emitDataFrame(false);
            }
        }

        /* JADX INFO: finally extract failed */
        private void emitDataFrame(boolean z) throws IOException {
            long min;
            synchronized (FramedStream.this) {
                FramedStream.this.writeTimeout.enter();
                while (FramedStream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && FramedStream.this.errorCode == null) {
                    try {
                        FramedStream.this.waitForIo();
                    } catch (Throwable th) {
                        FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
                        throw th;
                    }
                }
                FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
                FramedStream.this.checkOutNotClosed();
                min = Math.min(FramedStream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                FramedStream.this.bytesLeftInWriteWindow -= min;
            }
            FramedStream.this.writeTimeout.enter();
            try {
                FramedStream.this.connection.writeData(FramedStream.this.id, z && min == this.sendBuffer.size(), this.sendBuffer, min);
            } finally {
                FramedStream.this.writeTimeout.exitAndThrowIfTimedOut();
            }
        }

        public void flush() throws IOException {
            synchronized (FramedStream.this) {
                FramedStream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitDataFrame(false);
                FramedStream.this.connection.flush();
            }
        }

        public Timeout timeout() {
            return FramedStream.this.writeTimeout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
            if (r8.sendBuffer.size() <= 0) goto L_0x002d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            if (r8.sendBuffer.size() <= 0) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
            emitDataFrame(true);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x002d, code lost:
            com.squareup.okhttp.internal.framed.FramedStream.access$500(r8.this$0).writeData(com.squareup.okhttp.internal.framed.FramedStream.access$600(r8.this$0), true, (okio.Buffer) null, 0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0040, code lost:
            r2 = r8.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0042, code lost:
            monitor-enter(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r8.closed = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0045, code lost:
            monitor-exit(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0046, code lost:
            com.squareup.okhttp.internal.framed.FramedStream.access$500(r8.this$0).flush();
            com.squareup.okhttp.internal.framed.FramedStream.access$1000(r8.this$0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            if (r8.this$0.sink.finished != false) goto L_0x0040;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
                r8 = this;
                com.squareup.okhttp.internal.framed.FramedStream r0 = com.squareup.okhttp.internal.framed.FramedStream.this
                monitor-enter(r0)
                boolean r1 = r8.closed     // Catch:{ all -> 0x0058 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0058 }
                return
            L_0x0009:
                monitor-exit(r0)     // Catch:{ all -> 0x0058 }
                com.squareup.okhttp.internal.framed.FramedStream r0 = com.squareup.okhttp.internal.framed.FramedStream.this
                com.squareup.okhttp.internal.framed.FramedStream$FramedDataSink r0 = r0.sink
                boolean r0 = r0.finished
                r1 = 1
                if (r0 != 0) goto L_0x0040
                okio.Buffer r0 = r8.sendBuffer
                long r2 = r0.size()
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x002d
            L_0x001f:
                okio.Buffer r0 = r8.sendBuffer
                long r2 = r0.size()
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 <= 0) goto L_0x0040
                r8.emitDataFrame(r1)
                goto L_0x001f
            L_0x002d:
                com.squareup.okhttp.internal.framed.FramedStream r0 = com.squareup.okhttp.internal.framed.FramedStream.this
                com.squareup.okhttp.internal.framed.FramedConnection r2 = r0.connection
                com.squareup.okhttp.internal.framed.FramedStream r0 = com.squareup.okhttp.internal.framed.FramedStream.this
                int r3 = r0.id
                r4 = 1
                r5 = 0
                r6 = 0
                r2.writeData(r3, r4, r5, r6)
            L_0x0040:
                com.squareup.okhttp.internal.framed.FramedStream r2 = com.squareup.okhttp.internal.framed.FramedStream.this
                monitor-enter(r2)
                r8.closed = r1     // Catch:{ all -> 0x0055 }
                monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                com.squareup.okhttp.internal.framed.FramedStream r0 = com.squareup.okhttp.internal.framed.FramedStream.this
                com.squareup.okhttp.internal.framed.FramedConnection r0 = r0.connection
                r0.flush()
                com.squareup.okhttp.internal.framed.FramedStream r0 = com.squareup.okhttp.internal.framed.FramedStream.this
                r0.cancelStreamIfNecessary()
                return
            L_0x0055:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0055 }
                throw r0
            L_0x0058:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0058 }
                goto L_0x005c
            L_0x005b:
                throw r1
            L_0x005c:
                goto L_0x005b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.framed.FramedStream.FramedDataSink.close():void");
        }
    }

    /* access modifiers changed from: package-private */
    public void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: private */
    public void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        } else if (this.sink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            throw new IOException("stream was reset: " + this.errorCode);
        }
    }

    /* access modifiers changed from: private */
    public void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        /* access modifiers changed from: protected */
        public void timedOut() {
            FramedStream.this.closeLater(ErrorCode.CANCEL);
        }

        /* access modifiers changed from: protected */
        public IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(DefaultSentryClientFactory.CONNECTION_TIMEOUT_OPTION);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException((IOException) null);
            }
        }
    }
}
