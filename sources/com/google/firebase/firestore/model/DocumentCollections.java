package com.google.firebase.firestore.model;

import com.google.firebase.database.collection.ImmutableSortedMap;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class DocumentCollections {
    private static final ImmutableSortedMap<DocumentKey, ?> EMPTY_DOCUMENT_MAP = ImmutableSortedMap.Builder.emptyMap(DocumentKey.comparator());

    public static ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap() {
        return EMPTY_DOCUMENT_MAP;
    }

    public static ImmutableSortedMap<DocumentKey, MaybeDocument> emptyMaybeDocumentMap() {
        return EMPTY_DOCUMENT_MAP;
    }

    public static ImmutableSortedMap<DocumentKey, SnapshotVersion> emptyVersionMap() {
        return EMPTY_DOCUMENT_MAP;
    }
}
