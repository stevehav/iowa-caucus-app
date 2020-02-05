package io.sentry.connection;

import io.sentry.buffer.Buffer;
import io.sentry.environment.SentryEnvironment;
import io.sentry.event.Event;
import java.io.IOException;
import java.io.NotSerializableException;
import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BufferedConnection implements Connection {
    /* access modifiers changed from: private */
    public static final Logger logger = LoggerFactory.getLogger((Class<?>) BufferedConnection.class);
    private Connection actualConnection;
    /* access modifiers changed from: private */
    public Buffer buffer;
    /* access modifiers changed from: private */
    public volatile boolean closed = false;
    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        }
    });
    private boolean gracefulShutdown;
    private final ShutDownHook shutDownHook = new ShutDownHook();
    private long shutdownTimeout;

    public BufferedConnection(Connection connection, Buffer buffer2, long j, boolean z, long j2) {
        this.actualConnection = connection;
        this.buffer = buffer2;
        this.gracefulShutdown = z;
        this.shutdownTimeout = j2;
        if (z) {
            Runtime.getRuntime().addShutdownHook(this.shutDownHook);
        }
        this.executorService.scheduleWithFixedDelay(new Flusher(j), j, j, TimeUnit.MILLISECONDS);
    }

    public void send(Event event) {
        try {
            this.actualConnection.send(event);
            this.buffer.discard(event);
        } catch (ConnectionException e) {
            boolean z = e.getCause() instanceof NotSerializableException;
            Integer responseCode = e.getResponseCode();
            if (z || responseCode != null) {
                this.buffer.discard(event);
            }
            throw e;
        }
    }

    public void addEventSendCallback(EventSendCallback eventSendCallback) {
        this.actualConnection.addEventSendCallback(eventSendCallback);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:18|19) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        java.lang.Thread.currentThread().interrupt();
        logger.warn("Graceful shutdown interrupted, forcing the shutdown.");
        logger.warn("{} tasks failed to execute before the shutdown.", (java.lang.Object) java.lang.Integer.valueOf(r6.executorService.shutdownNow().size()));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0095, code lost:
        r6.actualConnection.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x009b, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x0072 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r6 = this;
            java.lang.String r0 = "{} tasks failed to execute before the shutdown."
            boolean r1 = r6.gracefulShutdown
            if (r1 == 0) goto L_0x0011
            io.sentry.connection.BufferedConnection$ShutDownHook r1 = r6.shutDownHook
            io.sentry.util.Util.safelyRemoveShutdownHook(r1)
            io.sentry.connection.BufferedConnection$ShutDownHook r1 = r6.shutDownHook
            r2 = 0
            boolean unused = r1.enabled = r2
        L_0x0011:
            org.slf4j.Logger r1 = logger
            java.lang.String r2 = "Gracefully shutting down Sentry buffer threads."
            r1.debug(r2)
            r1 = 1
            r6.closed = r1
            java.util.concurrent.ScheduledExecutorService r1 = r6.executorService
            r1.shutdown()
            long r1 = r6.shutdownTimeout     // Catch:{ InterruptedException -> 0x0072 }
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x003d
            r1 = 5000(0x1388, double:2.4703E-320)
        L_0x002a:
            java.util.concurrent.ScheduledExecutorService r3 = r6.executorService     // Catch:{ InterruptedException -> 0x0072 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0072 }
            boolean r3 = r3.awaitTermination(r1, r4)     // Catch:{ InterruptedException -> 0x0072 }
            if (r3 == 0) goto L_0x0035
            goto L_0x0063
        L_0x0035:
            org.slf4j.Logger r3 = logger     // Catch:{ InterruptedException -> 0x0072 }
            java.lang.String r4 = "Still waiting on buffer flusher executor to terminate."
            r3.debug(r4)     // Catch:{ InterruptedException -> 0x0072 }
            goto L_0x002a
        L_0x003d:
            java.util.concurrent.ScheduledExecutorService r1 = r6.executorService     // Catch:{ InterruptedException -> 0x0072 }
            long r2 = r6.shutdownTimeout     // Catch:{ InterruptedException -> 0x0072 }
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException -> 0x0072 }
            boolean r1 = r1.awaitTermination(r2, r4)     // Catch:{ InterruptedException -> 0x0072 }
            if (r1 != 0) goto L_0x0063
            org.slf4j.Logger r1 = logger     // Catch:{ InterruptedException -> 0x0072 }
            java.lang.String r2 = "Graceful shutdown took too much time, forcing the shutdown."
            r1.warn(r2)     // Catch:{ InterruptedException -> 0x0072 }
            java.util.concurrent.ScheduledExecutorService r1 = r6.executorService     // Catch:{ InterruptedException -> 0x0072 }
            java.util.List r1 = r1.shutdownNow()     // Catch:{ InterruptedException -> 0x0072 }
            org.slf4j.Logger r2 = logger     // Catch:{ InterruptedException -> 0x0072 }
            int r1 = r1.size()     // Catch:{ InterruptedException -> 0x0072 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ InterruptedException -> 0x0072 }
            r2.warn((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ InterruptedException -> 0x0072 }
        L_0x0063:
            org.slf4j.Logger r1 = logger     // Catch:{ InterruptedException -> 0x0072 }
            java.lang.String r2 = "Shutdown finished."
            r1.debug(r2)     // Catch:{ InterruptedException -> 0x0072 }
        L_0x006a:
            io.sentry.connection.Connection r0 = r6.actualConnection
            r0.close()
            goto L_0x0094
        L_0x0070:
            r0 = move-exception
            goto L_0x0095
        L_0x0072:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0070 }
            r1.interrupt()     // Catch:{ all -> 0x0070 }
            org.slf4j.Logger r1 = logger     // Catch:{ all -> 0x0070 }
            java.lang.String r2 = "Graceful shutdown interrupted, forcing the shutdown."
            r1.warn(r2)     // Catch:{ all -> 0x0070 }
            java.util.concurrent.ScheduledExecutorService r1 = r6.executorService     // Catch:{ all -> 0x0070 }
            java.util.List r1 = r1.shutdownNow()     // Catch:{ all -> 0x0070 }
            org.slf4j.Logger r2 = logger     // Catch:{ all -> 0x0070 }
            int r1 = r1.size()     // Catch:{ all -> 0x0070 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0070 }
            r2.warn((java.lang.String) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0070 }
            goto L_0x006a
        L_0x0094:
            return
        L_0x0095:
            io.sentry.connection.Connection r1 = r6.actualConnection
            r1.close()
            goto L_0x009c
        L_0x009b:
            throw r0
        L_0x009c:
            goto L_0x009b
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.connection.BufferedConnection.close():void");
    }

    public Connection wrapConnectionWithBufferWriter(final Connection connection) {
        return new Connection() {
            final Connection wrappedConnection = connection;

            public void send(Event event) throws ConnectionException {
                try {
                    BufferedConnection.this.buffer.add(event);
                } catch (Exception e) {
                    BufferedConnection.logger.error("Exception occurred while attempting to add Event to buffer: ", (Throwable) e);
                }
                this.wrappedConnection.send(event);
            }

            public void addEventSendCallback(EventSendCallback eventSendCallback) {
                this.wrappedConnection.addEventSendCallback(eventSendCallback);
            }

            public void close() throws IOException {
                this.wrappedConnection.close();
            }
        };
    }

    private class Flusher implements Runnable {
        private long minAgeMillis;

        Flusher(long j) {
            this.minAgeMillis = j;
        }

        public void run() {
            BufferedConnection.logger.trace("Running Flusher");
            SentryEnvironment.startManagingThread();
            try {
                Iterator<Event> events = BufferedConnection.this.buffer.getEvents();
                while (events.hasNext() && !BufferedConnection.this.closed) {
                    Event next = events.next();
                    long currentTimeMillis = System.currentTimeMillis() - next.getTimestamp().getTime();
                    if (currentTimeMillis < this.minAgeMillis) {
                        Logger access$300 = BufferedConnection.logger;
                        access$300.trace("Ignoring buffered event because it only " + currentTimeMillis + "ms old.");
                        SentryEnvironment.stopManagingThread();
                        return;
                    }
                    try {
                        Logger access$3002 = BufferedConnection.logger;
                        access$3002.trace("Flusher attempting to send Event: " + next.getId());
                        BufferedConnection.this.send(next);
                        Logger access$3003 = BufferedConnection.logger;
                        access$3003.trace("Flusher successfully sent Event: " + next.getId());
                    } catch (Exception e) {
                        Logger access$3004 = BufferedConnection.logger;
                        access$3004.debug("Flusher failed to send Event: " + next.getId(), (Throwable) e);
                        BufferedConnection.logger.trace("Flusher run exiting early.");
                        SentryEnvironment.stopManagingThread();
                        return;
                    }
                }
                BufferedConnection.logger.trace("Flusher run exiting, no more events to send.");
            } catch (Exception e2) {
                BufferedConnection.logger.error("Error running Flusher: ", (Throwable) e2);
            } catch (Throwable th) {
                SentryEnvironment.stopManagingThread();
                throw th;
            }
            SentryEnvironment.stopManagingThread();
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
                    BufferedConnection.this.close();
                } catch (Exception e) {
                    BufferedConnection.logger.error("An exception occurred while closing the connection.", (Throwable) e);
                } catch (Throwable th) {
                    SentryEnvironment.stopManagingThread();
                    throw th;
                }
                SentryEnvironment.stopManagingThread();
            }
        }
    }
}
