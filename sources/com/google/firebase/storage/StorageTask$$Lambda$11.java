package com.google.firebase.storage;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.storage.StorageTask;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
final /* synthetic */ class StorageTask$$Lambda$11 implements OnSuccessListener {
    private final SuccessContinuation arg$1;
    private final TaskCompletionSource arg$2;
    private final CancellationTokenSource arg$3;

    private StorageTask$$Lambda$11(SuccessContinuation successContinuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        this.arg$1 = successContinuation;
        this.arg$2 = taskCompletionSource;
        this.arg$3 = cancellationTokenSource;
    }

    public static OnSuccessListener lambdaFactory$(SuccessContinuation successContinuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource) {
        return new StorageTask$$Lambda$11(successContinuation, taskCompletionSource, cancellationTokenSource);
    }

    public void onSuccess(Object obj) {
        StorageTask.lambda$successTaskImpl$6(this.arg$1, this.arg$2, this.arg$3, (StorageTask.ProvideError) obj);
    }
}
