package com.google.firebase.firestore.util;

import com.google.firebase.firestore.util.AsyncQueue;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$$Lambda$7 implements Runnable {
    private final AsyncQueue arg$1;
    private final AsyncQueue.TimerId arg$2;

    private AsyncQueue$$Lambda$7(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId) {
        this.arg$1 = asyncQueue;
        this.arg$2 = timerId;
    }

    public static Runnable lambdaFactory$(AsyncQueue asyncQueue, AsyncQueue.TimerId timerId) {
        return new AsyncQueue$$Lambda$7(asyncQueue, timerId);
    }

    public void run() {
        AsyncQueue.lambda$runDelayedTasksUntil$8(this.arg$1, this.arg$2);
    }
}
