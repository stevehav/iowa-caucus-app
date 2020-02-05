package com.google.firebase.firestore.local;

import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.util.Supplier;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LocalStore$$Lambda$6 implements Supplier {
    private final LocalStore arg$1;
    private final RemoteEvent arg$2;

    private LocalStore$$Lambda$6(LocalStore localStore, RemoteEvent remoteEvent) {
        this.arg$1 = localStore;
        this.arg$2 = remoteEvent;
    }

    public static Supplier lambdaFactory$(LocalStore localStore, RemoteEvent remoteEvent) {
        return new LocalStore$$Lambda$6(localStore, remoteEvent);
    }

    public Object get() {
        return LocalStore.lambda$applyRemoteEvent$5(this.arg$1, this.arg$2);
    }
}
