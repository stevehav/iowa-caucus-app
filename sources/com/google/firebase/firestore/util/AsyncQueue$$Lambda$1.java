package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$$Lambda$1 implements Runnable {
    private final Callable arg$1;
    private final Executor arg$2;
    private final TaskCompletionSource arg$3;

    private AsyncQueue$$Lambda$1(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        this.arg$1 = callable;
        this.arg$2 = executor;
        this.arg$3 = taskCompletionSource;
    }

    public static Runnable lambdaFactory$(Callable callable, Executor executor, TaskCompletionSource taskCompletionSource) {
        return new AsyncQueue$$Lambda$1(callable, executor, taskCompletionSource);
    }

    public void run() {
        AsyncQueue.lambda$callTask$1(this.arg$1, this.arg$2, this.arg$3);
    }
}
