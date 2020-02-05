package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteRemoteDocumentCache$$Lambda$4 implements Runnable {
    private final SQLiteRemoteDocumentCache arg$1;
    private final byte[] arg$2;
    private final Query arg$3;
    private final ImmutableSortedMap[] arg$4;

    private SQLiteRemoteDocumentCache$$Lambda$4(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, byte[] bArr, Query query, ImmutableSortedMap[] immutableSortedMapArr) {
        this.arg$1 = sQLiteRemoteDocumentCache;
        this.arg$2 = bArr;
        this.arg$3 = query;
        this.arg$4 = immutableSortedMapArr;
    }

    public static Runnable lambdaFactory$(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, byte[] bArr, Query query, ImmutableSortedMap[] immutableSortedMapArr) {
        return new SQLiteRemoteDocumentCache$$Lambda$4(sQLiteRemoteDocumentCache, bArr, query, immutableSortedMapArr);
    }

    public void run() {
        SQLiteRemoteDocumentCache.lambda$getAllDocumentsMatchingQuery$2(this.arg$1, this.arg$2, this.arg$3, this.arg$4);
    }
}
