package com.google.firebase.firestore;

import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirebaseFirestore$$Lambda$2 implements Runnable {
    private final FirebaseFirestore arg$1;
    private final TaskCompletionSource arg$2;

    private FirebaseFirestore$$Lambda$2(FirebaseFirestore firebaseFirestore, TaskCompletionSource taskCompletionSource) {
        this.arg$1 = firebaseFirestore;
        this.arg$2 = taskCompletionSource;
    }

    public static Runnable lambdaFactory$(FirebaseFirestore firebaseFirestore, TaskCompletionSource taskCompletionSource) {
        return new FirebaseFirestore$$Lambda$2(firebaseFirestore, taskCompletionSource);
    }

    public void run() {
        FirebaseFirestore.lambda$clearPersistence$2(this.arg$1, this.arg$2);
    }
}
