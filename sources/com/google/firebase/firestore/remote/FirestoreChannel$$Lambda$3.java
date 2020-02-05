package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreChannel$$Lambda$3 implements OnCompleteListener {
    private final FirestoreChannel arg$1;
    private final TaskCompletionSource arg$2;
    private final Object arg$3;

    private FirestoreChannel$$Lambda$3(FirestoreChannel firestoreChannel, TaskCompletionSource taskCompletionSource, Object obj) {
        this.arg$1 = firestoreChannel;
        this.arg$2 = taskCompletionSource;
        this.arg$3 = obj;
    }

    public static OnCompleteListener lambdaFactory$(FirestoreChannel firestoreChannel, TaskCompletionSource taskCompletionSource, Object obj) {
        return new FirestoreChannel$$Lambda$3(firestoreChannel, taskCompletionSource, obj);
    }

    public void onComplete(Task task) {
        FirestoreChannel.lambda$runRpc$2(this.arg$1, this.arg$2, this.arg$3, task);
    }
}
