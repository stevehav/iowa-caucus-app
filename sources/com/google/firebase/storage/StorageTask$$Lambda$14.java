package com.google.firebase.storage;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
final /* synthetic */ class StorageTask$$Lambda$14 implements OnFailureListener {
    private final TaskCompletionSource arg$1;

    private StorageTask$$Lambda$14(TaskCompletionSource taskCompletionSource) {
        this.arg$1 = taskCompletionSource;
    }

    public static OnFailureListener lambdaFactory$(TaskCompletionSource taskCompletionSource) {
        return new StorageTask$$Lambda$14(taskCompletionSource);
    }

    public void onFailure(Exception exc) {
        this.arg$1.setException(exc);
    }
}
