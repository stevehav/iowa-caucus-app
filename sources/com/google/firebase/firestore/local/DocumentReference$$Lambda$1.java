package com.google.firebase.firestore.local;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class DocumentReference$$Lambda$1 implements Comparator {
    private static final DocumentReference$$Lambda$1 instance = new DocumentReference$$Lambda$1();

    private DocumentReference$$Lambda$1() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    public int compare(Object obj, Object obj2) {
        return DocumentReference.lambda$static$0((DocumentReference) obj, (DocumentReference) obj2);
    }
}
