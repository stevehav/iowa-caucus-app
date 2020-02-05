package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.remote.OnlineStateTracker;
import com.google.firebase.firestore.remote.RemoteStore;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class RemoteStore$$Lambda$1 implements OnlineStateTracker.OnlineStateCallback {
    private final RemoteStore.RemoteStoreCallback arg$1;

    private RemoteStore$$Lambda$1(RemoteStore.RemoteStoreCallback remoteStoreCallback) {
        this.arg$1 = remoteStoreCallback;
    }

    public static OnlineStateTracker.OnlineStateCallback lambdaFactory$(RemoteStore.RemoteStoreCallback remoteStoreCallback) {
        return new RemoteStore$$Lambda$1(remoteStoreCallback);
    }

    public void handleOnlineStateChange(OnlineState onlineState) {
        this.arg$1.handleOnlineStateChange(onlineState);
    }
}
