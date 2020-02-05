package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class RemoteStore$$Lambda$2 implements Consumer {
    private final RemoteStore arg$1;
    private final AsyncQueue arg$2;

    private RemoteStore$$Lambda$2(RemoteStore remoteStore, AsyncQueue asyncQueue) {
        this.arg$1 = remoteStore;
        this.arg$2 = asyncQueue;
    }

    public static Consumer lambdaFactory$(RemoteStore remoteStore, AsyncQueue asyncQueue) {
        return new RemoteStore$$Lambda$2(remoteStore, asyncQueue);
    }

    public void accept(Object obj) {
        this.arg$2.enqueueAndForget(RemoteStore$$Lambda$3.lambdaFactory$(this.arg$1));
    }
}
