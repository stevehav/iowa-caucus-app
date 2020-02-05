package com.google.firebase.firestore.util;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class ExponentialBackoff$$Lambda$1 implements Runnable {
    private final ExponentialBackoff arg$1;
    private final Runnable arg$2;

    private ExponentialBackoff$$Lambda$1(ExponentialBackoff exponentialBackoff, Runnable runnable) {
        this.arg$1 = exponentialBackoff;
        this.arg$2 = runnable;
    }

    public static Runnable lambdaFactory$(ExponentialBackoff exponentialBackoff, Runnable runnable) {
        return new ExponentialBackoff$$Lambda$1(exponentialBackoff, runnable);
    }

    public void run() {
        ExponentialBackoff.lambda$backoffAndRun$0(this.arg$1, this.arg$2);
    }
}
