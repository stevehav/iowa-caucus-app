package com.google.firebase.firestore.local;

import com.google.protobuf.ByteString;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LocalStore$$Lambda$5 implements Runnable {
    private final LocalStore arg$1;
    private final ByteString arg$2;

    private LocalStore$$Lambda$5(LocalStore localStore, ByteString byteString) {
        this.arg$1 = localStore;
        this.arg$2 = byteString;
    }

    public static Runnable lambdaFactory$(LocalStore localStore, ByteString byteString) {
        return new LocalStore$$Lambda$5(localStore, byteString);
    }

    public void run() {
        this.arg$1.mutationQueue.setLastStreamToken(this.arg$2);
    }
}
