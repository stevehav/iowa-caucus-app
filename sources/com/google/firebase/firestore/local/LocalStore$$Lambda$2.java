package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.util.Supplier;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LocalStore$$Lambda$2 implements Supplier {
    private final LocalStore arg$1;
    private final Set arg$2;
    private final List arg$3;
    private final Timestamp arg$4;

    private LocalStore$$Lambda$2(LocalStore localStore, Set set, List list, Timestamp timestamp) {
        this.arg$1 = localStore;
        this.arg$2 = set;
        this.arg$3 = list;
        this.arg$4 = timestamp;
    }

    public static Supplier lambdaFactory$(LocalStore localStore, Set set, List list, Timestamp timestamp) {
        return new LocalStore$$Lambda$2(localStore, set, list, timestamp);
    }

    public Object get() {
        return LocalStore.lambda$writeLocally$1(this.arg$1, this.arg$2, this.arg$3, this.arg$4);
    }
}
