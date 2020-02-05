package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.DocumentKey;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
interface ReferenceDelegate {
    void addReference(DocumentKey documentKey);

    long getCurrentSequenceNumber();

    void onTransactionCommitted();

    void onTransactionStarted();

    void removeMutationReference(DocumentKey documentKey);

    void removeReference(DocumentKey documentKey);

    void removeTarget(QueryData queryData);

    void setInMemoryPins(ReferenceSet referenceSet);

    void updateLimboDocument(DocumentKey documentKey);
}
