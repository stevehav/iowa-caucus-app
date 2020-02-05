package com.google.firebase.firestore.core;

import com.google.firebase.firestore.auth.User;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$14 implements Runnable {
    private final FirestoreClient arg$1;
    private final User arg$2;

    private FirestoreClient$$Lambda$14(FirestoreClient firestoreClient, User user) {
        this.arg$1 = firestoreClient;
        this.arg$2 = user;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient, User user) {
        return new FirestoreClient$$Lambda$14(firestoreClient, user);
    }

    public void run() {
        FirestoreClient.lambda$new$0(this.arg$1, this.arg$2);
    }
}
