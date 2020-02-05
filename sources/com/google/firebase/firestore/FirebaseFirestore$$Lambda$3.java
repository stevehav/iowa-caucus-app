package com.google.firebase.firestore;

import com.google.firebase.firestore.Transaction;
import java.util.concurrent.Callable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirebaseFirestore$$Lambda$3 implements Callable {
    private final FirebaseFirestore arg$1;
    private final Transaction.Function arg$2;
    private final com.google.firebase.firestore.core.Transaction arg$3;

    private FirebaseFirestore$$Lambda$3(FirebaseFirestore firebaseFirestore, Transaction.Function function, com.google.firebase.firestore.core.Transaction transaction) {
        this.arg$1 = firebaseFirestore;
        this.arg$2 = function;
        this.arg$3 = transaction;
    }

    public static Callable lambdaFactory$(FirebaseFirestore firebaseFirestore, Transaction.Function function, com.google.firebase.firestore.core.Transaction transaction) {
        return new FirebaseFirestore$$Lambda$3(firebaseFirestore, function, transaction);
    }

    public Object call() {
        return this.arg$2.apply(new Transaction(this.arg$3, this.arg$1));
    }
}
