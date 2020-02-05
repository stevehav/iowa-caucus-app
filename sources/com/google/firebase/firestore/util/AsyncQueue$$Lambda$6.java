package com.google.firebase.firestore.util;

import java.util.concurrent.Semaphore;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$$Lambda$6 implements Runnable {
    private final Runnable arg$1;
    private final Throwable[] arg$2;
    private final Semaphore arg$3;

    private AsyncQueue$$Lambda$6(Runnable runnable, Throwable[] thArr, Semaphore semaphore) {
        this.arg$1 = runnable;
        this.arg$2 = thArr;
        this.arg$3 = semaphore;
    }

    public static Runnable lambdaFactory$(Runnable runnable, Throwable[] thArr, Semaphore semaphore) {
        return new AsyncQueue$$Lambda$6(runnable, thArr, semaphore);
    }

    public void run() {
        AsyncQueue.lambda$runSync$6(this.arg$1, this.arg$2, this.arg$3);
    }
}
