package com.google.firebase.firestore.model;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class DocumentSet$$Lambda$1 implements Comparator {
    private final Comparator arg$1;

    private DocumentSet$$Lambda$1(Comparator comparator) {
        this.arg$1 = comparator;
    }

    public static Comparator lambdaFactory$(Comparator comparator) {
        return new DocumentSet$$Lambda$1(comparator);
    }

    public int compare(Object obj, Object obj2) {
        return DocumentSet.lambda$emptySet$0(this.arg$1, (Document) obj, (Document) obj2);
    }
}
