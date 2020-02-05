package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.AbstractStream;
import io.grpc.Metadata;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AbstractStream$StreamObserver$$Lambda$1 implements Runnable {
    private final AbstractStream.StreamObserver arg$1;
    private final Metadata arg$2;

    private AbstractStream$StreamObserver$$Lambda$1(AbstractStream.StreamObserver streamObserver, Metadata metadata) {
        this.arg$1 = streamObserver;
        this.arg$2 = metadata;
    }

    public static Runnable lambdaFactory$(AbstractStream.StreamObserver streamObserver, Metadata metadata) {
        return new AbstractStream$StreamObserver$$Lambda$1(streamObserver, metadata);
    }

    public void run() {
        AbstractStream.StreamObserver.lambda$onHeaders$0(this.arg$1, this.arg$2);
    }
}
