package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
final /* synthetic */ class StorageTask$$Lambda$10 implements OnCompleteListener {
    private final StorageTask arg$1;
    private final Continuation arg$2;
    private final TaskCompletionSource arg$3;
    private final CancellationTokenSource arg$4;

    private StorageTask$$Lambda$10(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        this.arg$1 = storageTask;
        this.arg$2 = continuation;
        this.arg$3 = taskCompletionSource;
        this.arg$4 = cancellationTokenSource;
    }

    public static OnCompleteListener lambdaFactory$(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        return new StorageTask$$Lambda$10(storageTask, continuation, taskCompletionSource, cancellationTokenSource);
    }

    public void onComplete(Task task) {
        StorageTask.lambda$continueWithTaskImpl$5(this.arg$1, this.arg$2, this.arg$3, this.arg$4, task);
    }
}
