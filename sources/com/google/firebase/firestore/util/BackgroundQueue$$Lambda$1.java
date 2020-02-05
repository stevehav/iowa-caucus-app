package com.google.firebase.firestore.util;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class BackgroundQueue$$Lambda$1 implements Runnable {
    private final BackgroundQueue arg$1;
    private final Runnable arg$2;

    private BackgroundQueue$$Lambda$1(BackgroundQueue backgroundQueue, Runnable runnable) {
        this.arg$1 = backgroundQueue;
        this.arg$2 = runnable;
    }

    public static Runnable lambdaFactory$(BackgroundQueue backgroundQueue, Runnable runnable) {
        return new BackgroundQueue$$Lambda$1(backgroundQueue, runnable);
    }

    public void run() {
        BackgroundQueue.lambda$execute$0(this.arg$1, this.arg$2);
    }
}
