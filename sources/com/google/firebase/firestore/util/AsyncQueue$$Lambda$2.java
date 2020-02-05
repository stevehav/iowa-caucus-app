package com.google.firebase.firestore.util;

import java.lang.Thread;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$$Lambda$2 implements Thread.UncaughtExceptionHandler {
    private final AsyncQueue arg$1;

    private AsyncQueue$$Lambda$2(AsyncQueue asyncQueue) {
        this.arg$1 = asyncQueue;
    }

    public static Thread.UncaughtExceptionHandler lambdaFactory$(AsyncQueue asyncQueue) {
        return new AsyncQueue$$Lambda$2(asyncQueue);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.arg$1.panic(th);
    }
}
