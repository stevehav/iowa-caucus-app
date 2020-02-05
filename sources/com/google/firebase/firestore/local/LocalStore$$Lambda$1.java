package com.google.firebase.firestore.local;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LocalStore$$Lambda$1 implements Runnable {
    private final LocalStore arg$1;

    private LocalStore$$Lambda$1(LocalStore localStore) {
        this.arg$1 = localStore;
    }

    public static Runnable lambdaFactory$(LocalStore localStore) {
        return new LocalStore$$Lambda$1(localStore);
    }

    public void run() {
        this.arg$1.mutationQueue.start();
    }
}
