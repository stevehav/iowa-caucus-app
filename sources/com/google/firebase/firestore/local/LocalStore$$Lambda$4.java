package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Supplier;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LocalStore$$Lambda$4 implements Supplier {
    private final LocalStore arg$1;
    private final int arg$2;

    private LocalStore$$Lambda$4(LocalStore localStore, int i) {
        this.arg$1 = localStore;
        this.arg$2 = i;
    }

    public static Supplier lambdaFactory$(LocalStore localStore, int i) {
        return new LocalStore$$Lambda$4(localStore, i);
    }

    public Object get() {
        return LocalStore.lambda$rejectBatch$3(this.arg$1, this.arg$2);
    }
}
