package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MaybeDocument;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Executors;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final class SQLiteRemoteDocumentCache implements RemoteDocumentCache {
    private final SQLitePersistence db;
    private final LocalSerializer serializer;

    SQLiteRemoteDocumentCache(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer) {
        this.db = sQLitePersistence;
        this.serializer = localSerializer;
    }

    public void add(MaybeDocument maybeDocument) {
        String pathForKey = pathForKey(maybeDocument.getKey());
        com.google.firebase.firestore.proto.MaybeDocument encodeMaybeDocument = this.serializer.encodeMaybeDocument(maybeDocument);
        this.db.execute("INSERT OR REPLACE INTO remote_documents (path, contents) VALUES (?, ?)", pathForKey, encodeMaybeDocument.toByteArray());
        this.db.getIndexManager().addToCollectionParentIndex((ResourcePath) maybeDocument.getKey().getPath().popLast());
    }

    public void remove(DocumentKey documentKey) {
        String pathForKey = pathForKey(documentKey);
        this.db.execute("DELETE FROM remote_documents WHERE path = ?", pathForKey);
    }

    @Nullable
    public MaybeDocument get(DocumentKey documentKey) {
        String pathForKey = pathForKey(documentKey);
        return (MaybeDocument) this.db.query("SELECT contents FROM remote_documents WHERE path = ?").binding(pathForKey).firstValue(SQLiteRemoteDocumentCache$$Lambda$1.lambdaFactory$(this));
    }

    public Map<DocumentKey, MaybeDocument> getAll(Iterable<DocumentKey> iterable) {
        ArrayList arrayList = new ArrayList();
        for (DocumentKey path : iterable) {
            arrayList.add(EncodedPath.encode(path.getPath()));
        }
        HashMap hashMap = new HashMap();
        for (DocumentKey put : iterable) {
            hashMap.put(put, (Object) null);
        }
        SQLitePersistence.LongQuery longQuery = new SQLitePersistence.LongQuery(this.db, "SELECT contents FROM remote_documents WHERE path IN (", arrayList, ") ORDER BY path");
        while (longQuery.hasMoreSubqueries()) {
            longQuery.performNextSubquery().forEach(SQLiteRemoteDocumentCache$$Lambda$2.lambdaFactory$(this, hashMap));
        }
        return hashMap;
    }

    static /* synthetic */ void lambda$getAll$1(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, Map map, Cursor cursor) {
        MaybeDocument decodeMaybeDocument = sQLiteRemoteDocumentCache.decodeMaybeDocument(cursor.getBlob(0));
        map.put(decodeMaybeDocument.getKey(), decodeMaybeDocument);
    }

    public ImmutableSortedMap<DocumentKey, Document> getAllDocumentsMatchingQuery(Query query) {
        Assert.hardAssert(!query.isCollectionGroupQuery(), "CollectionGroup queries should be handled in LocalDocumentsView", new Object[0]);
        ResourcePath path = query.getPath();
        String encode = EncodedPath.encode(path);
        String prefixSuccessor = EncodedPath.prefixSuccessor(encode);
        BackgroundQueue backgroundQueue = new BackgroundQueue();
        ImmutableSortedMap<DocumentKey, Document>[] immutableSortedMapArr = {DocumentCollections.emptyDocumentMap()};
        this.db.query("SELECT path, contents FROM remote_documents WHERE path >= ? AND path < ?").binding(encode, prefixSuccessor).forEach(SQLiteRemoteDocumentCache$$Lambda$3.lambdaFactory$(this, path.length() + 1, backgroundQueue, query, immutableSortedMapArr));
        try {
            backgroundQueue.drain();
        } catch (InterruptedException e) {
            Assert.fail("Interrupted while deserializing documents", e);
        }
        return immutableSortedMapArr[0];
    }

    static /* synthetic */ void lambda$getAllDocumentsMatchingQuery$3(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, int i, BackgroundQueue backgroundQueue, Query query, ImmutableSortedMap[] immutableSortedMapArr, Cursor cursor) {
        if (EncodedPath.decodeResourcePath(cursor.getString(0)).length() == i) {
            byte[] blob = cursor.getBlob(1);
            Executor executor = backgroundQueue;
            if (cursor.isLast()) {
                executor = Executors.DIRECT_EXECUTOR;
            }
            executor.execute(SQLiteRemoteDocumentCache$$Lambda$4.lambdaFactory$(sQLiteRemoteDocumentCache, blob, query, immutableSortedMapArr));
        }
    }

    static /* synthetic */ void lambda$getAllDocumentsMatchingQuery$2(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, byte[] bArr, Query query, ImmutableSortedMap[] immutableSortedMapArr) {
        MaybeDocument decodeMaybeDocument = sQLiteRemoteDocumentCache.decodeMaybeDocument(bArr);
        if ((decodeMaybeDocument instanceof Document) && query.matches((Document) decodeMaybeDocument)) {
            synchronized (sQLiteRemoteDocumentCache) {
                immutableSortedMapArr[0] = immutableSortedMapArr[0].insert(decodeMaybeDocument.getKey(), (Document) decodeMaybeDocument);
            }
        }
    }

    private String pathForKey(DocumentKey documentKey) {
        return EncodedPath.encode(documentKey.getPath());
    }

    /* access modifiers changed from: private */
    public MaybeDocument decodeMaybeDocument(byte[] bArr) {
        try {
            return this.serializer.decodeMaybeDocument(com.google.firebase.firestore.proto.MaybeDocument.parseFrom(bArr));
        } catch (InvalidProtocolBufferException e) {
            throw Assert.fail("MaybeDocument failed to parse: %s", e);
        }
    }
}
