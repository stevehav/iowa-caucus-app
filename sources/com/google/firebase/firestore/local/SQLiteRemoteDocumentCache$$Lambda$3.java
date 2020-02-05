package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.util.BackgroundQueue;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteRemoteDocumentCache$$Lambda$3 implements Consumer {
    private final SQLiteRemoteDocumentCache arg$1;
    private final int arg$2;
    private final BackgroundQueue arg$3;
    private final Query arg$4;
    private final ImmutableSortedMap[] arg$5;

    private SQLiteRemoteDocumentCache$$Lambda$3(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, int i, BackgroundQueue backgroundQueue, Query query, ImmutableSortedMap[] immutableSortedMapArr) {
        this.arg$1 = sQLiteRemoteDocumentCache;
        this.arg$2 = i;
        this.arg$3 = backgroundQueue;
        this.arg$4 = query;
        this.arg$5 = immutableSortedMapArr;
    }

    public static Consumer lambdaFactory$(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, int i, BackgroundQueue backgroundQueue, Query query, ImmutableSortedMap[] immutableSortedMapArr) {
        return new SQLiteRemoteDocumentCache$$Lambda$3(sQLiteRemoteDocumentCache, i, backgroundQueue, query, immutableSortedMapArr);
    }

    public void accept(Object obj) {
        SQLiteRemoteDocumentCache.lambda$getAllDocumentsMatchingQuery$3(this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5, (Cursor) obj);
    }
}
