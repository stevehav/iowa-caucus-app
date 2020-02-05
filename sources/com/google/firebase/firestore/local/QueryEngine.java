package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
interface QueryEngine {
    ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query);

    void handleDocumentChange(MaybeDocument maybeDocument, MaybeDocument maybeDocument2);
}
