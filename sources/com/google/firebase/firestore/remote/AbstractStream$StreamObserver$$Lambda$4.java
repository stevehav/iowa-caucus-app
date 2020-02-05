package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.remote.AbstractStream;
import io.grpc.Status;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AbstractStream$StreamObserver$$Lambda$4 implements Runnable {
    private final AbstractStream.StreamObserver arg$1;
    private final Status arg$2;

    private AbstractStream$StreamObserver$$Lambda$4(AbstractStream.StreamObserver streamObserver, Status status) {
        this.arg$1 = streamObserver;
        this.arg$2 = status;
    }

    public static Runnable lambdaFactory$(AbstractStream.StreamObserver streamObserver, Status status) {
        return new AbstractStream$StreamObserver$$Lambda$4(streamObserver, status);
    }

    public void run() {
        AbstractStream.StreamObserver.lambda$onClose$3(this.arg$1, this.arg$2);
    }
}
