package com.google.firebase.firestore;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class Query$$Lambda$2 implements EventListener {
    private final TaskCompletionSource arg$1;
    private final TaskCompletionSource arg$2;
    private final Source arg$3;

    private Query$$Lambda$2(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Source source) {
        this.arg$1 = taskCompletionSource;
        this.arg$2 = taskCompletionSource2;
        this.arg$3 = source;
    }

    public static EventListener lambdaFactory$(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Source source) {
        return new Query$$Lambda$2(taskCompletionSource, taskCompletionSource2, source);
    }

    public void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        Query.lambda$getViaSnapshotListener$1(this.arg$1, this.arg$2, this.arg$3, (QuerySnapshot) obj, firebaseFirestoreException);
    }
}
