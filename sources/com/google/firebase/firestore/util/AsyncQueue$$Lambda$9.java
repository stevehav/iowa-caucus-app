package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncQueue$$Lambda$9 implements Continuation {
    private final TaskCompletionSource arg$1;

    private AsyncQueue$$Lambda$9(TaskCompletionSource taskCompletionSource) {
        this.arg$1 = taskCompletionSource;
    }

    public static Continuation lambdaFactory$(TaskCompletionSource taskCompletionSource) {
        return new AsyncQueue$$Lambda$9(taskCompletionSource);
    }

    public Object then(Task task) {
        return AsyncQueue.lambda$callTask$0(this.arg$1, task);
    }
}
