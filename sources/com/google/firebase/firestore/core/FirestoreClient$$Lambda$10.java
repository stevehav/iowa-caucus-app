package com.google.firebase.firestore.core;

import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$10 implements Callable {
    private final FirestoreClient arg$1;
    private final Query arg$2;

    private FirestoreClient$$Lambda$10(FirestoreClient firestoreClient, Query query) {
        this.arg$1 = firestoreClient;
        this.arg$2 = query;
    }

    public static Callable lambdaFactory$(FirestoreClient firestoreClient, Query query) {
        return new FirestoreClient$$Lambda$10(firestoreClient, query);
    }

    public Object call() {
        return FirestoreClient.lambda$getDocumentsFromLocalCache$10(this.arg$1, this.arg$2);
    }
}
