package com.google.firebase.firestore.util;

import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$$Lambda$4 implements Callable {
    private final Runnable arg$1;

    private AsyncQueue$$Lambda$4(Runnable runnable) {
        this.arg$1 = runnable;
    }

    public static Callable lambdaFactory$(Runnable runnable) {
        return new AsyncQueue$$Lambda$4(runnable);
    }

    public Object call() {
        return this.arg$1.run();
    }
}
