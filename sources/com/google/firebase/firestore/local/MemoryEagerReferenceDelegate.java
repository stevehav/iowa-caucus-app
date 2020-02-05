package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class MemoryEagerReferenceDelegate implements ReferenceDelegate {
    private ReferenceSet inMemoryPins;
    private Set<DocumentKey> orphanedDocuments;
    private final MemoryPersistence persistence;

    public long getCurrentSequenceNumber() {
        return -1;
    }

    MemoryEagerReferenceDelegate(MemoryPersistence memoryPersistence) {
        this.persistence = memoryPersistence;
    }

    public void setInMemoryPins(ReferenceSet referenceSet) {
        this.inMemoryPins = referenceSet;
    }

    public void addReference(DocumentKey documentKey) {
        this.orphanedDocuments.remove(documentKey);
    }

    public void removeReference(DocumentKey documentKey) {
        this.orphanedDocuments.add(documentKey);
    }

    public void removeMutationReference(DocumentKey documentKey) {
        this.orphanedDocuments.add(documentKey);
    }

    public void removeTarget(QueryData queryData) {
        MemoryQueryCache queryCache = this.persistence.getQueryCache();
        Iterator<DocumentKey> it = queryCache.getMatchingKeysForTargetId(queryData.getTargetId()).iterator();
        while (it.hasNext()) {
            this.orphanedDocuments.add(it.next());
        }
        queryCache.removeQueryData(queryData);
    }

    public void onTransactionStarted() {
        this.orphanedDocuments = new HashSet();
    }

    public void onTransactionCommitted() {
        MemoryRemoteDocumentCache remoteDocumentCache = this.persistence.getRemoteDocumentCache();
        for (DocumentKey next : this.orphanedDocuments) {
            if (!isReferenced(next)) {
                remoteDocumentCache.remove(next);
            }
        }
        this.orphanedDocuments = null;
    }

    public void updateLimboDocument(DocumentKey documentKey) {
        if (isReferenced(documentKey)) {
            this.orphanedDocuments.remove(documentKey);
        } else {
            this.orphanedDocuments.add(documentKey);
        }
    }

    private boolean mutationQueuesContainKey(DocumentKey documentKey) {
        for (MemoryMutationQueue containsKey : this.persistence.getMutationQueues()) {
            if (containsKey.containsKey(documentKey)) {
                return true;
            }
        }
        return false;
    }

    private boolean isReferenced(DocumentKey documentKey) {
        if (this.persistence.getQueryCache().containsKey(documentKey) || mutationQueuesContainKey(documentKey)) {
            return true;
        }
        ReferenceSet referenceSet = this.inMemoryPins;
        if (referenceSet == null || !referenceSet.containsKey(documentKey)) {
            return false;
        }
        return true;
    }
}
