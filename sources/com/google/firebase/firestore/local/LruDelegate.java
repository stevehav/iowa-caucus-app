package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface LruDelegate {
    void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer);

    void forEachTarget(Consumer<QueryData> consumer);

    long getByteSize();

    LruGarbageCollector getGarbageCollector();

    long getSequenceNumberCount();

    int removeOrphanedDocuments(long j);

    int removeTargets(long j, SparseArray<?> sparseArray);
}
