package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class SimpleQueryEngine implements QueryEngine {
    private final LocalDocumentsView localDocumentsView;

    public void handleDocumentChange(MaybeDocument maybeDocument, MaybeDocument maybeDocument2) {
    }

    public SimpleQueryEngine(LocalDocumentsView localDocumentsView2) {
        this.localDocumentsView = localDocumentsView2;
    }

    public ImmutableSortedMap<DocumentKey, Document> getDocumentsMatchingQuery(Query query) {
        return this.localDocumentsView.getDocumentsMatchingQuery(query);
    }
}
