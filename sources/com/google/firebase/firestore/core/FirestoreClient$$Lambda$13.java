package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.DocumentKey;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class FirestoreClient$$Lambda$13 implements Comparator {
    private static final FirestoreClient$$Lambda$13 instance = new FirestoreClient$$Lambda$13();

    private FirestoreClient$$Lambda$13() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    public int compare(Object obj, Object obj2) {
        return ((DocumentKey) obj).compareTo((DocumentKey) obj2);
    }
}
