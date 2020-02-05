package com.google.firebase.storage;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.TaskListenerImpl;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
final /* synthetic */ class StorageTask$$Lambda$4 implements TaskListenerImpl.OnRaise {
    private final StorageTask arg$1;

    private StorageTask$$Lambda$4(StorageTask storageTask) {
        this.arg$1 = storageTask;
    }

    public static TaskListenerImpl.OnRaise lambdaFactory$(StorageTask storageTask) {
        return new StorageTask$$Lambda$4(storageTask);
    }

    public void raise(Object obj, Object obj2) {
        StorageTask.lambda$new$1(this.arg$1, (OnFailureListener) obj, (StorageTask.ProvideError) obj2);
    }
}
