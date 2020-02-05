package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.AsyncQueue;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$DelayedTask$$Lambda$1 implements Runnable {
    private final AsyncQueue.DelayedTask arg$1;

    private AsyncQueue$DelayedTask$$Lambda$1(AsyncQueue.DelayedTask delayedTask) {
        this.arg$1 = delayedTask;
    }

    public static Runnable lambdaFactory$(AsyncQueue.DelayedTask delayedTask) {
        return new AsyncQueue$DelayedTask$$Lambda$1(delayedTask);
    }

    public void run() {
        this.arg$1.handleDelayElapsed();
    }
}
