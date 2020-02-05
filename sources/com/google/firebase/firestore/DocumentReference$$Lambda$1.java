package com.google.firebase.firestore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class DocumentReference$$Lambda$1 implements Continuation {
    private final DocumentReference arg$1;

    private DocumentReference$$Lambda$1(DocumentReference documentReference) {
        this.arg$1 = documentReference;
    }

    public static Continuation lambdaFactory$(DocumentReference documentReference) {
        return new DocumentReference$$Lambda$1(documentReference);
    }

    public Object then(Task task) {
        return DocumentReference.lambda$get$0(this.arg$1, task);
    }
}
