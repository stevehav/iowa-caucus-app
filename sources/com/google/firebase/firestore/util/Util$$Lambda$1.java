package com.google.firebase.firestore.util;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class Util$$Lambda$1 implements Runnable {
    private final RuntimeException arg$1;

    private Util$$Lambda$1(RuntimeException runtimeException) {
        this.arg$1 = runtimeException;
    }

    public static Runnable lambdaFactory$(RuntimeException runtimeException) {
        return new Util$$Lambda$1(runtimeException);
    }

    public void run() {
        Util.lambda$crashMainThread$1(this.arg$1);
    }
}
