package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$11 implements Runnable {
    private final FirestoreClient arg$1;
    private final List arg$2;
    private final TaskCompletionSource arg$3;

    private FirestoreClient$$Lambda$11(FirestoreClient firestoreClient, List list, TaskCompletionSource taskCompletionSource) {
        this.arg$1 = firestoreClient;
        this.arg$2 = list;
        this.arg$3 = taskCompletionSource;
    }

    public static Runnable lambdaFactory$(FirestoreClient firestoreClient, List list, TaskCompletionSource taskCompletionSource) {
        return new FirestoreClient$$Lambda$11(firestoreClient, list, taskCompletionSource);
    }

    public void run() {
        this.arg$1.syncEngine.writeMutations(this.arg$2, this.arg$3);
    }
}
