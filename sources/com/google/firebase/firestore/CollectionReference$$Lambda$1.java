package com.google.firebase.firestore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class CollectionReference$$Lambda$1 implements Continuation {
    private final DocumentReference arg$1;

    private CollectionReference$$Lambda$1(DocumentReference documentReference) {
        this.arg$1 = documentReference;
    }

    public static Continuation lambdaFactory$(DocumentReference documentReference) {
        return new CollectionReference$$Lambda$1(documentReference);
    }

    public Object then(Task task) {
        return task.getResult();
    }
}
