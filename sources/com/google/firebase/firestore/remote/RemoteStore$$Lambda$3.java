package com.google.firebase.firestore.remote;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class RemoteStore$$Lambda$3 implements Runnable {
    private final RemoteStore arg$1;

    private RemoteStore$$Lambda$3(RemoteStore remoteStore) {
        this.arg$1 = remoteStore;
    }

    public static Runnable lambdaFactory$(RemoteStore remoteStore) {
        return new RemoteStore$$Lambda$3(remoteStore);
    }

    public void run() {
        RemoteStore.lambda$new$0(this.arg$1);
    }
}
