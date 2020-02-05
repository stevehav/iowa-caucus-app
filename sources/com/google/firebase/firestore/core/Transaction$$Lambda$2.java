package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class Transaction$$Lambda$2 implements Continuation {
    private static final Transaction$$Lambda$2 instance = new Transaction$$Lambda$2();

    private Transaction$$Lambda$2() {
    }

    public static Continuation lambdaFactory$() {
        return instance;
    }

    public Object then(Task task) {
        return Transaction.lambda$commit$1(task);
    }
}
