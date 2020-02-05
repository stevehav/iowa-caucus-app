package com.google.firebase.firestore.core;

import com.google.common.base.Function;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$12 implements Callable {
    private final FirestoreClient arg$1;
    private final Function arg$2;
    private final int arg$3;

    private FirestoreClient$$Lambda$12(FirestoreClient firestoreClient, Function function, int i) {
        this.arg$1 = firestoreClient;
        this.arg$2 = function;
        this.arg$3 = i;
    }

    public static Callable lambdaFactory$(FirestoreClient firestoreClient, Function function, int i) {
        return new FirestoreClient$$Lambda$12(firestoreClient, function, i);
    }

    public Object call() {
        return this.arg$1.syncEngine.transaction(this.arg$1.asyncQueue, this.arg$2, this.arg$3);
    }
}
