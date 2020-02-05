package com.google.firebase.firestore.core;

import android.content.Context;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$2 implements Runnable {
    private final FirestoreClient arg$1;
    private final TaskCompletionSource arg$2;
    private final Context arg$3;
    private final FirebaseFirestoreSettings arg$4;

    private FirestoreClient$$Lambda$2(FirestoreClient firestoreClient, TaskCompletionSource taskCompletionSource, Context context, FirebaseFirestoreSettings firebaseFirestoreSettings) {
        this.arg$1 = firestoreClient;
        this.arg$2 = taskCompletionSource;
        this.arg$3 = context;
        this.arg$4 = firebaseFirestoreSettings;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient, TaskCompletionSource taskCompletionSource, Context context, FirebaseFirestoreSettings firebaseFirestoreSettings) {
        return new FirestoreClient$$Lambda$2(firestoreClient, taskCompletionSource, context, firebaseFirestoreSettings);
    }

    public void run() {
        FirestoreClient.lambda$new$2(this.arg$1, this.arg$2, this.arg$3, this.arg$4);
    }
}
