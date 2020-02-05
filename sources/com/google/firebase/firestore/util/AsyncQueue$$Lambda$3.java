package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$$Lambda$3 implements Runnable {
    private final TaskCompletionSource arg$1;
    private final Callable arg$2;

    private AsyncQueue$$Lambda$3(TaskCompletionSource taskCompletionSource, Callable callable) {
        this.arg$1 = taskCompletionSource;
        this.arg$2 = callable;
    }

    public static Runnable lambdaFactory$(TaskCompletionSource taskCompletionSource, Callable callable) {
        return new AsyncQueue$$Lambda$3(taskCompletionSource, callable);
    }

    public void run() {
        AsyncQueue.lambda$enqueue$3(this.arg$1, this.arg$2);
    }
}
