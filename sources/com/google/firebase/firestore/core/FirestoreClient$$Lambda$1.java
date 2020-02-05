package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Listener;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$1 implements Listener {
    private final FirestoreClient arg$1;
    private final AtomicBoolean arg$2;
    private final TaskCompletionSource arg$3;
    private final AsyncQueue arg$4;

    private FirestoreClient$$Lambda$1(FirestoreClient firestoreClient, AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, AsyncQueue asyncQueue) {
        this.arg$1 = firestoreClient;
        this.arg$2 = atomicBoolean;
        this.arg$3 = taskCompletionSource;
        this.arg$4 = asyncQueue;
    }

    public static Listener lambdaFactory$(FirestoreClient firestoreClient, AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, AsyncQueue asyncQueue) {
        return new FirestoreClient$$Lambda$1(firestoreClient, atomicBoolean, taskCompletionSource, asyncQueue);
    }

    public void onValue(Object obj) {
        FirestoreClient.lambda$new$1(this.arg$1, this.arg$2, this.arg$3, this.arg$4, (User) obj);
    }
}
