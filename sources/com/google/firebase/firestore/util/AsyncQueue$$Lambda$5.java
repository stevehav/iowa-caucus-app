package com.google.firebase.firestore.util;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$$Lambda$5 implements Runnable {
    private final Throwable arg$1;

    private AsyncQueue$$Lambda$5(Throwable th) {
        this.arg$1 = th;
    }

    public static Runnable lambdaFactory$(Throwable th) {
        return new AsyncQueue$$Lambda$5(th);
    }

    public void run() {
        AsyncQueue.lambda$panic$5(this.arg$1);
    }
}
