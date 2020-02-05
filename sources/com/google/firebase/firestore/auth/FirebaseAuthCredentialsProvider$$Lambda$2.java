package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirebaseAuthCredentialsProvider$$Lambda$2 implements Continuation {
    private final FirebaseAuthCredentialsProvider arg$1;
    private final int arg$2;

    private FirebaseAuthCredentialsProvider$$Lambda$2(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider, int i) {
        this.arg$1 = firebaseAuthCredentialsProvider;
        this.arg$2 = i;
    }

    public static Continuation lambdaFactory$(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider, int i) {
        return new FirebaseAuthCredentialsProvider$$Lambda$2(firebaseAuthCredentialsProvider, i);
    }

    public Object then(Task task) {
        return FirebaseAuthCredentialsProvider.lambda$getToken$1(this.arg$1, this.arg$2, task);
    }
}
