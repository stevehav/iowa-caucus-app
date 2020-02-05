package com.google.firebase.firestore.core;

import com.google.firebase.firestore.FirebaseFirestoreException;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class AsyncEventListener$$Lambda$1 implements Runnable {
    private final AsyncEventListener arg$1;
    private final Object arg$2;
    private final FirebaseFirestoreException arg$3;

    private AsyncEventListener$$Lambda$1(AsyncEventListener asyncEventListener, Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        this.arg$1 = asyncEventListener;
        this.arg$2 = obj;
        this.arg$3 = firebaseFirestoreException;
    }

    public static Runnable lambdaFactory$(AsyncEventListener asyncEventListener, Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        return new AsyncEventListener$$Lambda$1(asyncEventListener, obj, firebaseFirestoreException);
    }

    public void run() {
        AsyncEventListener.lambda$onEvent$0(this.arg$1, this.arg$2, this.arg$3);
    }
}
