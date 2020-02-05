package io.sentry.connection;

import io.sentry.SentryClient;
import io.sentry.environment.SentryEnvironment;
import io.sentry.event.Event;
import io.sentry.util.Util;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class AsyncConnection implements Connection {
    private static final Logger lockdownLogger = LoggerFactory.getLogger(SentryClient.class.getName() + ".lockdown");
    /* access modifiers changed from: private */
    public static final Logger logger = LoggerFactory.getLogger((Class<?>) AsyncConnection.class);
    /* access modifiers changed from: private */
    public final Connection actualConnection;
    private volatile boolean closed;
    private final ExecutorService executorService;
    private boolean gracefulShutdown;
    private final ShutDownHook shutDownHook = new ShutDownHook();
    private final long shutdownTimeout;

    public AsyncConnection(Connection connection, ExecutorService executorService2, boolean z, long j) {
        this.actualConnection = connection;
        if (executorService2 == null) {
            this.executorService = Executors.newSingleThreadExecutor();
        } else {
            this.executorService = executorService2;
        }
        if (z) {
            this.gracefulShutdown = z;
            addShutdownHook();
        }
        this.shutdownTimeout = j;
    }

    private void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(this.shutDownHook);
    }

    public void send(Event event) {
        if (!this.closed) {
            this.executorService.execute(new EventSubmitter(event, MDC.getCopyOfContextMap()));
        }
    }

    public void addEventSendCallback(EventSendCallback eventSendCallback) {
        this.actualConnection.addEventSendCallback(eventSendCallback);
    }

    public void close() throws IOException {
        if (this.gracefulShutdown) {
            Util.safelyRemoveShutdownHook(this.shutDownHook);
            boolean unused = this.shutDownHook.enabled = false;
        }
        doClose();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:15|16) */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0061, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        java.lang.Thread.currentThread().interrupt();
        logger.warn("Graceful shutdown interrupted, forcing the shutdown.");
        logger.warn("{} tasks failed to execute before shutdown.", (java.lang.Object) java.lang.Integer.valueOf(r6.executorService.shutdownNow().size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0086, code lost:
        r6.actualConnection.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008c, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0063 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doClose() throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "{} tasks failed to execute before shutdown."
            org.slf4j.Logger r1 = logger
            java.lang.String r2 = "Gracefully shutting down Sentry async threads."
            r1.debug(r2)
            r1 = 1
            r6.closed = r1
            java.util.concurrent.ExecutorService r1 = r6.executorService
            r1.shutdown()
            long r1 = r6.shutdownTimeout     // Catch:{ InterruptedException -> 0x0063 }
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x002e
            r1 = 5000(0x1388, double:2.4703E-320)
        L_0x001b:
            java.util.concurrent.ExecutorService r3 = r6.executorService     // Catch:{ InterruptedException -> 0x0063 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0063 }
            boolean r3 = r3.awaitTermination(r1, r4)     // Catch:{ InterruptedException -> 0x0063 }
            if (r3 == 0) goto L_0x0026
            goto L_0x0054
        L_0x0026:
            org.slf4j.Logger r3 = logger     // Catch:{ InterruptedException -> 0x0063 }
            java.lang.String r4 = "Still waiting on async executor to terminate."
            r3.debug(r4)     // Catch:{ InterruptedException -> 0x0063 }
            goto L_0x001b
        L_0x002e:
            java.util.concurrent.ExecutorService r1 = r6.executorService     // Catch:{ InterruptedException -> 0x0063 }
            long r2 = r6.shutdownTimeout     // Catch:{ InterruptedException -> 0x0063 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0063 }
            boolean r1 = r1.awaitTermination(r2, r4)     // Catch:{ InterruptedException -> 0x0063 }
            if (r1 != 0) goto L_0x0054
            org.slf4j.Logger r1 = logger     // Catch:{ InterruptedException -> 0x0063 }
            java.lang.String r2 = "Graceful shutdown took too much time, forcing the shutdown."
            r1.warn(r2)     // Catch:{ InterruptedException -> 0x0063 }
            java.util.concurrent.ExecutorService r1 = r6.executorService     // Catch:{ InterruptedException -> 0x0063 }
            java.util.List r1 = r1.shutdownNow()     // Catch:{ InterruptedException -> 0x0063 }
            org.slf4j.Logger r2 = logger     // Catch:{ InterruptedException -> 0x0063 }
            int r1 = r1.size()     // Catch:{ InterruptedException -> 0x0063 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InterruptedException -> 0x0063 }
            r2.warn((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ InterruptedException -> 0x0063 }
        L_0x0054:
            org.slf4j.Logger r1 = logger     // Catch:{ InterruptedException -> 0x0063 }
            java.lang.String r2 = "Shutdown finished."
            r1.debug(r2)     // Catch:{ InterruptedException -> 0x0063 }
        L_0x005b:
            io.sentry.connection.Connection r0 = r6.actualConnection
            r0.close()
            goto L_0x0085
        L_0x0061:
            r0 = move-exception
            goto L_0x0086
        L_0x0063:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0061 }
            r1.interrupt()     // Catch:{ all -> 0x0061 }
            org.slf4j.Logger r1 = logger     // Catch:{ all -> 0x0061 }
            java.lang.String r2 = "Graceful shutdown interrupted, forcing the shutdown."
            r1.warn(r2)     // Catch:{ all -> 0x0061 }
            java.util.concurrent.ExecutorService r1 = r6.executorService     // Catch:{ all -> 0x0061 }
            java.util.List r1 = r1.shutdownNow()     // Catch:{ all -> 0x0061 }
            org.slf4j.Logger r2 = logger     // Catch:{ all -> 0x0061 }
            int r1 = r1.size()     // Catch:{ all -> 0x0061 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0061 }
            r2.warn((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0061 }
            goto L_0x005b
        L_0x0085:
            return
        L_0x0086:
            io.sentry.connection.Connection r1 = r6.actualConnection
            r1.close()
            goto L_0x008d
        L_0x008c:
            throw r0
        L_0x008d:
            goto L_0x008c
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.connection.AsyncConnection.doClose():void");
    }

    private final class EventSubmitter implements Runnable {
        private final Event event;
        private Map<String, String> mdcContext;

        private EventSubmitter(Event event2, Map<String, String> map) {
            this.event = event2;
            this.mdcContext = map;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
            if (r0 != null) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
            if (r0 == null) goto L_0x001f;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                io.sentry.environment.SentryEnvironment.startManagingThread()
                java.util.Map r0 = org.slf4j.MDC.getCopyOfContextMap()
                java.util.Map<java.lang.String, java.lang.String> r1 = r4.mdcContext
                if (r1 != 0) goto L_0x000f
                org.slf4j.MDC.clear()
                goto L_0x0012
            L_0x000f:
                org.slf4j.MDC.setContextMap(r1)
            L_0x0012:
                io.sentry.connection.AsyncConnection r1 = io.sentry.connection.AsyncConnection.this     // Catch:{ LockedDownException | TooManyRequestsException -> 0x0039, Exception -> 0x002c }
                io.sentry.connection.Connection r1 = r1.actualConnection     // Catch:{ LockedDownException | TooManyRequestsException -> 0x0039, Exception -> 0x002c }
                io.sentry.event.Event r2 = r4.event     // Catch:{ LockedDownException | TooManyRequestsException -> 0x0039, Exception -> 0x002c }
                r1.send(r2)     // Catch:{ LockedDownException | TooManyRequestsException -> 0x0039, Exception -> 0x002c }
                if (r0 != 0) goto L_0x0023
            L_0x001f:
                org.slf4j.MDC.clear()
                goto L_0x0026
            L_0x0023:
                org.slf4j.MDC.setContextMap(r0)
            L_0x0026:
                io.sentry.environment.SentryEnvironment.stopManagingThread()
                goto L_0x0056
            L_0x002a:
                r1 = move-exception
                goto L_0x0057
            L_0x002c:
                r1 = move-exception
                org.slf4j.Logger r2 = io.sentry.connection.AsyncConnection.logger     // Catch:{ all -> 0x002a }
                java.lang.String r3 = "An exception occurred while sending the event to Sentry."
                r2.error((java.lang.String) r3, (java.lang.Throwable) r1)     // Catch:{ all -> 0x002a }
                if (r0 != 0) goto L_0x0023
                goto L_0x001f
            L_0x0039:
                org.slf4j.Logger r1 = io.sentry.connection.AsyncConnection.logger     // Catch:{ all -> 0x002a }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x002a }
                r2.<init>()     // Catch:{ all -> 0x002a }
                java.lang.String r3 = "Dropping an Event due to lockdown: "
                r2.append(r3)     // Catch:{ all -> 0x002a }
                io.sentry.event.Event r3 = r4.event     // Catch:{ all -> 0x002a }
                r2.append(r3)     // Catch:{ all -> 0x002a }
                java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x002a }
                r1.debug(r2)     // Catch:{ all -> 0x002a }
                if (r0 != 0) goto L_0x0023
                goto L_0x001f
            L_0x0056:
                return
            L_0x0057:
                if (r0 != 0) goto L_0x005d
                org.slf4j.MDC.clear()
                goto L_0x0060
            L_0x005d:
                org.slf4j.MDC.setContextMap(r0)
            L_0x0060:
                io.sentry.environment.SentryEnvironment.stopManagingThread()
                goto L_0x0065
            L_0x0064:
                throw r1
            L_0x0065:
                goto L_0x0064
            */
            throw new UnsupportedOperationException("Method not decompiled: io.sentry.connection.AsyncConnection.EventSubmitter.run():void");
        }
    }

    private final class ShutDownHook extends Thread {
        /* access modifiers changed from: private */
        public volatile boolean enabled;

        private ShutDownHook() {
            this.enabled = true;
        }

        public void run() {
            if (this.enabled) {
                SentryEnvironment.startManagingThread();
                try {
                    AsyncConnection.this.doClose();
                } catch (Exception e) {
                    AsyncConnection.logger.error("An exception occurred while closing the connection.", (Throwable) e);
                } catch (Throwable th) {
                    SentryEnvironment.stopManagingThread();
                    throw th;
                }
                SentryEnvironment.stopManagingThread();
            }
        }
    }
}
