package com.google.firebase.firestore.local;

import com.google.firebase.firestore.core.Query;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LocalStore$$Lambda$9 implements Runnable {
    private final LocalStore arg$1;
    private final Query arg$2;

    private LocalStore$$Lambda$9(LocalStore localStore, Query query) {
        this.arg$1 = localStore;
        this.arg$2 = query;
    }

    public static Runnable lambdaFactory$(LocalStore localStore, Query query) {
        return new LocalStore$$Lambda$9(localStore, query);
    }

    public void run() {
        LocalStore.lambda$releaseQuery$8(this.arg$1, this.arg$2);
    }
}
