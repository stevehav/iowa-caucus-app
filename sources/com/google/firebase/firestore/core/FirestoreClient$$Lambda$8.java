package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$8 implements Callable {
    private final FirestoreClient arg$1;
    private final DocumentKey arg$2;

    private FirestoreClient$$Lambda$8(FirestoreClient firestoreClient, DocumentKey documentKey) {
        this.arg$1 = firestoreClient;
        this.arg$2 = documentKey;
    }

    public static Callable lambdaFactory$(FirestoreClient firestoreClient, DocumentKey documentKey) {
        return new FirestoreClient$$Lambda$8(firestoreClient, documentKey);
    }

    public Object call() {
        return this.arg$1.localStore.readDocument(this.arg$2);
    }
}
