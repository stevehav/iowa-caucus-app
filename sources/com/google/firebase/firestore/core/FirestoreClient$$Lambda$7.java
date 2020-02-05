package com.google.firebase.firestore.core;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$7 implements Runnable {
    private final FirestoreClient arg$1;
    private final QueryListener arg$2;

    private FirestoreClient$$Lambda$7(FirestoreClient firestoreClient, QueryListener queryListener) {
        this.arg$1 = firestoreClient;
        this.arg$2 = queryListener;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient, QueryListener queryListener) {
        return new FirestoreClient$$Lambda$7(firestoreClient, queryListener);
    }

    public void run() {
        this.arg$1.eventManager.removeQueryListener(this.arg$2);
    }
}
