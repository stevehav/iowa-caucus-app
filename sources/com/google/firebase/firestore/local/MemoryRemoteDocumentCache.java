package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final class MemoryRemoteDocumentCache implements RemoteDocumentCache {
    private ImmutableSortedMap<DocumentKey, MaybeDocument> docs = DocumentCollections.emptyMaybeDocumentMap();
    private final MemoryPersistence persistence;

    MemoryRemoteDocumentCache(MemoryPersistence memoryPersistence) {
        this.persistence = memoryPersistence;
    }

    public void add(MaybeDocument maybeDocument) {
        this.docs = this.docs.insert(maybeDocument.getKey(), maybeDocument);
        this.persistence.getIndexManager().addToCollectionParentIndex((ResourcePath) maybeDocument.getKey().getPath().popLast());
    }

    public void remove(DocumentKey documentKey) {
        this.docs = this.docs.remove(documentKey);
    }

    @Nullable
    public MaybeDocument get(DocumentKey documentKey) {
        return this.docs.get(documentKey);
    }

    public Map<DocumentKey, MaybeDocument> getAll(Iterable<DocumentKey> iterable) {
        HashMap hashMap = new HashMap();
        for (DocumentKey next : iterable) {
            hashMap.put(next, get(next));
        }
        return hashMap;
    }

    public ImmutableSortedMap<DocumentKey, Document> getAllDocumentsMatchingQuery(Query query) {
        Assert.hardAssert(!query.isCollectionGroupQuery(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        ImmutableSortedMap<DocumentKey, Document> emptyDocumentMap = DocumentCollections.emptyDocumentMap();
        ResourcePath path = query.getPath();
        Iterator<Map.Entry<DocumentKey, MaybeDocument>> iteratorFrom = this.docs.iteratorFrom(DocumentKey.fromPath((ResourcePath) path.append("")));
        while (iteratorFrom.hasNext()) {
            Map.Entry next = iteratorFrom.next();
            if (!path.isPrefixOf(((DocumentKey) next.getKey()).getPath())) {
                break;
            }
            MaybeDocument maybeDocument = (MaybeDocument) next.getValue();
            if (maybeDocument instanceof Document) {
                Document document = (Document) maybeDocument;
                if (query.matches(document)) {
                    emptyDocumentMap = emptyDocumentMap.insert(document.getKey(), document);
                }
            }
        }
        return emptyDocumentMap;
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedMap<DocumentKey, MaybeDocument> getDocuments() {
        return this.docs;
    }

    private static long getKeySize(DocumentKey documentKey) {
        ResourcePath path = documentKey.getPath();
        long j = 0;
        for (int i = 0; i < path.length(); i++) {
            j += (long) (path.getSegment(i).length() * 2);
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public long getByteSize(LocalSerializer localSerializer) {
        Iterator<Map.Entry<DocumentKey, MaybeDocument>> it = this.docs.iterator();
        long j = 0;
        while (it.hasNext()) {
            Map.Entry next = it.next();
            j = j + getKeySize((DocumentKey) next.getKey()) + ((long) localSerializer.encodeMaybeDocument((MaybeDocument) next.getValue()).getSerializedSize());
        }
        return j;
    }
}
