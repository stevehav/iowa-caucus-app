package io.grpc.internal;

import com.google.common.base.Stopwatch;
import io.grpc.internal.ClientTransport;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public class Http2Ping {
    private static final Logger log = Logger.getLogger(Http2Ping.class.getName());
    @GuardedBy("this")
    private Map<ClientTransport.PingCallback, Executor> callbacks = new LinkedHashMap();
    @GuardedBy("this")
    private boolean completed;
    private final long data;
    @GuardedBy("this")
    private Throwable failureCause;
    @GuardedBy("this")
    private long roundTripTimeNanos;
    private final Stopwatch stopwatch;

    public Http2Ping(long j, Stopwatch stopwatch2) {
        this.data = j;
        this.stopwatch = stopwatch2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        doExecute(r4, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void addCallback(io.grpc.internal.ClientTransport.PingCallback r3, java.util.concurrent.Executor r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.completed     // Catch:{ all -> 0x0022 }
            if (r0 != 0) goto L_0x000c
            java.util.Map<io.grpc.internal.ClientTransport$PingCallback, java.util.concurrent.Executor> r0 = r2.callbacks     // Catch:{ all -> 0x0022 }
            r0.put(r3, r4)     // Catch:{ all -> 0x0022 }
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            return
        L_0x000c:
            java.lang.Throwable r0 = r2.failureCause     // Catch:{ all -> 0x0022 }
            if (r0 == 0) goto L_0x0017
            java.lang.Throwable r0 = r2.failureCause     // Catch:{ all -> 0x0022 }
            java.lang.Runnable r3 = asRunnable((io.grpc.internal.ClientTransport.PingCallback) r3, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0022 }
            goto L_0x001d
        L_0x0017:
            long r0 = r2.roundTripTimeNanos     // Catch:{ all -> 0x0022 }
            java.lang.Runnable r3 = asRunnable((io.grpc.internal.ClientTransport.PingCallback) r3, (long) r0)     // Catch:{ all -> 0x0022 }
        L_0x001d:
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            doExecute(r4, r3)
            return
        L_0x0022:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0022 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.Http2Ping.addCallback(io.grpc.internal.ClientTransport$PingCallback, java.util.concurrent.Executor):void");
    }

    public long payload() {
        return this.data;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0027, code lost:
        if (r3.hasNext() == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r4 = r3.next();
        doExecute((java.util.concurrent.Executor) r4.getValue(), asRunnable((io.grpc.internal.ClientTransport.PingCallback) r4.getKey(), r1));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        r3 = r3.entrySet().iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean complete() {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.completed     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0008
            r0 = 0
            monitor-exit(r6)     // Catch:{ all -> 0x0044 }
            return r0
        L_0x0008:
            r0 = 1
            r6.completed = r0     // Catch:{ all -> 0x0044 }
            com.google.common.base.Stopwatch r1 = r6.stopwatch     // Catch:{ all -> 0x0044 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x0044 }
            long r1 = r1.elapsed(r2)     // Catch:{ all -> 0x0044 }
            r6.roundTripTimeNanos = r1     // Catch:{ all -> 0x0044 }
            java.util.Map<io.grpc.internal.ClientTransport$PingCallback, java.util.concurrent.Executor> r3 = r6.callbacks     // Catch:{ all -> 0x0044 }
            r4 = 0
            r6.callbacks = r4     // Catch:{ all -> 0x0044 }
            monitor-exit(r6)     // Catch:{ all -> 0x0044 }
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0023:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0043
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getValue()
            java.util.concurrent.Executor r5 = (java.util.concurrent.Executor) r5
            java.lang.Object r4 = r4.getKey()
            io.grpc.internal.ClientTransport$PingCallback r4 = (io.grpc.internal.ClientTransport.PingCallback) r4
            java.lang.Runnable r4 = asRunnable((io.grpc.internal.ClientTransport.PingCallback) r4, (long) r1)
            doExecute(r5, r4)
            goto L_0x0023
        L_0x0043:
            return r0
        L_0x0044:
            r0 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0044 }
            goto L_0x0048
        L_0x0047:
            throw r0
        L_0x0048:
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.Http2Ping.complete():boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001e, code lost:
        if (r0.hasNext() == false) goto L_0x0036;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r1 = r0.next();
        notifyFailed((io.grpc.internal.ClientTransport.PingCallback) r1.getKey(), (java.util.concurrent.Executor) r1.getValue(), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0012, code lost:
        r0 = r0.entrySet().iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void failed(java.lang.Throwable r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.completed     // Catch:{ all -> 0x0037 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            return
        L_0x0007:
            r0 = 1
            r3.completed = r0     // Catch:{ all -> 0x0037 }
            r3.failureCause = r4     // Catch:{ all -> 0x0037 }
            java.util.Map<io.grpc.internal.ClientTransport$PingCallback, java.util.concurrent.Executor> r0 = r3.callbacks     // Catch:{ all -> 0x0037 }
            r1 = 0
            r3.callbacks = r1     // Catch:{ all -> 0x0037 }
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x001a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            io.grpc.internal.ClientTransport$PingCallback r2 = (io.grpc.internal.ClientTransport.PingCallback) r2
            java.lang.Object r1 = r1.getValue()
            java.util.concurrent.Executor r1 = (java.util.concurrent.Executor) r1
            notifyFailed(r2, r1, r4)
            goto L_0x001a
        L_0x0036:
            return
        L_0x0037:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0037 }
            goto L_0x003b
        L_0x003a:
            throw r4
        L_0x003b:
            goto L_0x003a
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.Http2Ping.failed(java.lang.Throwable):void");
    }

    public static void notifyFailed(ClientTransport.PingCallback pingCallback, Executor executor, Throwable th) {
        doExecute(executor, asRunnable(pingCallback, th));
    }

    private static void doExecute(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
        } catch (Throwable th) {
            log.log(Level.SEVERE, "Failed to execute PingCallback", th);
        }
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback pingCallback, final long j) {
        return new Runnable() {
            public void run() {
                ClientTransport.PingCallback.this.onSuccess(j);
            }
        };
    }

    private static Runnable asRunnable(final ClientTransport.PingCallback pingCallback, final Throwable th) {
        return new Runnable() {
            public void run() {
                ClientTransport.PingCallback.this.onFailure(th);
            }
        };
    }
}
