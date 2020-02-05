package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.AsyncQueue;
import java.util.Date;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class ExponentialBackoff {
    private final double backoffFactor;
    private long currentBaseMs;
    private final long initialDelayMs;
    private long lastAttemptTime = new Date().getTime();
    private final long maxDelayMs;
    private final AsyncQueue queue;
    private final AsyncQueue.TimerId timerId;
    private AsyncQueue.DelayedTask timerTask;

    public ExponentialBackoff(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId2, long j, double d, long j2) {
        this.queue = asyncQueue;
        this.timerId = timerId2;
        this.initialDelayMs = j;
        this.backoffFactor = d;
        this.maxDelayMs = j2;
        reset();
    }

    public void reset() {
        this.currentBaseMs = 0;
    }

    public void resetToMax() {
        this.currentBaseMs = this.maxDelayMs;
    }

    public void backoffAndRun(Runnable runnable) {
        cancel();
        long jitterDelayMs = this.currentBaseMs + jitterDelayMs();
        long max = Math.max(0, new Date().getTime() - this.lastAttemptTime);
        long max2 = Math.max(0, jitterDelayMs - max);
        if (this.currentBaseMs > 0) {
            Logger.debug(getClass().getSimpleName(), "Backing off for %d ms (base delay: %d ms, delay with jitter: %d ms, last attempt: %d ms ago)", Long.valueOf(max2), Long.valueOf(this.currentBaseMs), Long.valueOf(jitterDelayMs), Long.valueOf(max));
        }
        this.timerTask = this.queue.enqueueAfterDelay(this.timerId, max2, ExponentialBackoff$$Lambda$1.lambdaFactory$(this, runnable));
        double d = (double) this.currentBaseMs;
        double d2 = this.backoffFactor;
        Double.isNaN(d);
        this.currentBaseMs = (long) (d * d2);
        long j = this.currentBaseMs;
        long j2 = this.initialDelayMs;
        if (j < j2) {
            this.currentBaseMs = j2;
            return;
        }
        long j3 = this.maxDelayMs;
        if (j > j3) {
            this.currentBaseMs = j3;
        }
    }

    static /* synthetic */ void lambda$backoffAndRun$0(ExponentialBackoff exponentialBackoff, Runnable runnable) {
        exponentialBackoff.lastAttemptTime = new Date().getTime();
        runnable.run();
    }

    public void cancel() {
        AsyncQueue.DelayedTask delayedTask = this.timerTask;
        if (delayedTask != null) {
            delayedTask.cancel();
            this.timerTask = null;
        }
    }

    private long jitterDelayMs() {
        double d = (double) this.currentBaseMs;
        Double.isNaN(d);
        return (long) ((Math.random() - 0.5d) * d);
    }
}
