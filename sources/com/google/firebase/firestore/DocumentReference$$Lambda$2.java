package com.google.firebase.firestore;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class DocumentReference$$Lambda$2 implements EventListener {
    private final TaskCompletionSource arg$1;
    private final TaskCompletionSource arg$2;
    private final Source arg$3;

    private DocumentReference$$Lambda$2(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Source source) {
        this.arg$1 = taskCompletionSource;
        this.arg$2 = taskCompletionSource2;
        this.arg$3 = source;
    }

    public static EventListener lambdaFactory$(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Source source) {
        return new DocumentReference$$Lambda$2(taskCompletionSource, taskCompletionSource2, source);
    }

    public void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        DocumentReference.lambda$getViaSnapshotListener$1(this.arg$1, this.arg$2, this.arg$3, (DocumentSnapshot) obj, firebaseFirestoreException);
    }
}
