package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class LocalWriteResult {
    private final int batchId;
    private final ImmutableSortedMap<DocumentKey, MaybeDocument> changes;

    LocalWriteResult(int i, ImmutableSortedMap<DocumentKey, MaybeDocument> immutableSortedMap) {
        this.batchId = i;
        this.changes = immutableSortedMap;
    }

    public int getBatchId() {
        return this.batchId;
    }

    public ImmutableSortedMap<DocumentKey, MaybeDocument> getChanges() {
        return this.changes;
    }
}
