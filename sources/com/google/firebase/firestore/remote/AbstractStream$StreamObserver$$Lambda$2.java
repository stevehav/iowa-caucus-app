package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.AbstractStream;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AbstractStream$StreamObserver$$Lambda$2 implements Runnable {
    private final AbstractStream.StreamObserver arg$1;
    private final Object arg$2;

    private AbstractStream$StreamObserver$$Lambda$2(AbstractStream.StreamObserver streamObserver, Object obj) {
        this.arg$1 = streamObserver;
        this.arg$2 = obj;
    }

    public static Runnable lambdaFactory$(AbstractStream.StreamObserver streamObserver, Object obj) {
        return new AbstractStream$StreamObserver$$Lambda$2(streamObserver, obj);
    }

    public void run() {
        AbstractStream.StreamObserver.lambda$onNext$1(this.arg$1, this.arg$2);
    }
}
