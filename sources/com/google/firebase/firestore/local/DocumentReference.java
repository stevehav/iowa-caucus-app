package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Util;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class DocumentReference {
    static final Comparator<DocumentReference> BY_KEY = DocumentReference$$Lambda$1.lambdaFactory$();
    static final Comparator<DocumentReference> BY_TARGET = DocumentReference$$Lambda$2.lambdaFactory$();
    private final DocumentKey key;
    private final int targetOrBatchId;

    public DocumentReference(DocumentKey documentKey, int i) {
        this.key = documentKey;
        this.targetOrBatchId = i;
    }

    /* access modifiers changed from: package-private */
    public DocumentKey getKey() {
        return this.key;
    }

    /* access modifiers changed from: package-private */
    public int getId() {
        return this.targetOrBatchId;
    }

    static /* synthetic */ int lambda$static$0(DocumentReference documentReference, DocumentReference documentReference2) {
        int compareTo = documentReference.key.compareTo(documentReference2.key);
        if (compareTo != 0) {
            return compareTo;
        }
        return Util.compareIntegers(documentReference.targetOrBatchId, documentReference2.targetOrBatchId);
    }

    static /* synthetic */ int lambda$static$1(DocumentReference documentReference, DocumentReference documentReference2) {
        int compareIntegers = Util.compareIntegers(documentReference.targetOrBatchId, documentReference2.targetOrBatchId);
        if (compareIntegers != 0) {
            return compareIntegers;
        }
        return documentReference.key.compareTo(documentReference2.key);
    }
}
