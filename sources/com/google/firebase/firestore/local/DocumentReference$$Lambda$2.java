package com.google.firebase.firestore.local;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class DocumentReference$$Lambda$2 implements Comparator {
    private static final DocumentReference$$Lambda$2 instance = new DocumentReference$$Lambda$2();

    private DocumentReference$$Lambda$2() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    public int compare(Object obj, Object obj2) {
        return DocumentReference.lambda$static$1((DocumentReference) obj, (DocumentReference) obj2);
    }
}
