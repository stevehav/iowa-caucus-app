package com.google.firebase.firestore.util;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class ThrottledForwardingExecutor implements Executor {
    private final Semaphore availableSlots;
    private final Executor executor;

    ThrottledForwardingExecutor(int i, Executor executor2) {
        this.availableSlots = new Semaphore(i);
        this.executor = executor2;
    }

    public void execute(Runnable runnable) {
        if (this.availableSlots.tryAcquire()) {
            try {
                this.executor.execute(ThrottledForwardingExecutor$$Lambda$1.lambdaFactory$(this, runnable));
            } catch (RejectedExecutionException unused) {
                runnable.run();
            }
        } else {
            runnable.run();
        }
    }

    static /* synthetic */ void lambda$execute$0(ThrottledForwardingExecutor throttledForwardingExecutor, Runnable runnable) {
        runnable.run();
        throttledForwardingExecutor.availableSlots.release();
    }
}
