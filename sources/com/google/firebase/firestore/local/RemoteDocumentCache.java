package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
interface RemoteDocumentCache {
    void add(MaybeDocument maybeDocument);

    @Nullable
    MaybeDocument get(DocumentKey documentKey);

    Map<DocumentKey, MaybeDocument> getAll(Iterable<DocumentKey> iterable);

    ImmutableSortedMap<DocumentKey, Document> getAllDocumentsMatchingQuery(Query query);

    void remove(DocumentKey documentKey);
}
