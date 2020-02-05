package com.google.firebase.storage;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
final /* synthetic */ class StorageTask$$Lambda$12 implements Runnable {
    private final StorageTask arg$1;

    private StorageTask$$Lambda$12(StorageTask storageTask) {
        this.arg$1 = storageTask;
    }

    public static Runnable lambdaFactory$(StorageTask storageTask) {
        return new StorageTask$$Lambda$12(storageTask);
    }

    public void run() {
        StorageTask.lambda$getRunnable$7(this.arg$1);
    }
}
