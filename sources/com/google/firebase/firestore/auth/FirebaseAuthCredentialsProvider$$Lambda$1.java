package com.google.firebase.firestore.auth;

import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.internal.InternalTokenResult;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirebaseAuthCredentialsProvider$$Lambda$1 implements IdTokenListener {
    private final FirebaseAuthCredentialsProvider arg$1;

    private FirebaseAuthCredentialsProvider$$Lambda$1(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider) {
        this.arg$1 = firebaseAuthCredentialsProvider;
    }

    public static IdTokenListener lambdaFactory$(FirebaseAuthCredentialsProvider firebaseAuthCredentialsProvider) {
        return new FirebaseAuthCredentialsProvider$$Lambda$1(firebaseAuthCredentialsProvider);
    }

    public void onIdTokenChanged(InternalTokenResult internalTokenResult) {
        FirebaseAuthCredentialsProvider.lambda$new$0(this.arg$1, internalTokenResult);
    }
}
