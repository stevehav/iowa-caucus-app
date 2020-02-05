package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.AbstractStream;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AbstractStream$StreamObserver$$Lambda$3 implements Runnable {
    private final AbstractStream.StreamObserver arg$1;

    private AbstractStream$StreamObserver$$Lambda$3(AbstractStream.StreamObserver streamObserver) {
        this.arg$1 = streamObserver;
    }

    public static Runnable lambdaFactory$(AbstractStream.StreamObserver streamObserver) {
        return new AbstractStream$StreamObserver$$Lambda$3(streamObserver);
    }

    public void run() {
        AbstractStream.StreamObserver.lambda$onOpen$2(this.arg$1);
    }
}
