package com.google.firebase.firestore.core;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$5 implements Runnable {
    private final FirestoreClient arg$1;

    private FirestoreClient$$Lambda$5(FirestoreClient firestoreClient) {
        this.arg$1 = firestoreClient;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient) {
        return new FirestoreClient$$Lambda$5(firestoreClient);
    }

    public void run() {
        FirestoreClient.lambda$shutdown$5(this.arg$1);
    }
}
