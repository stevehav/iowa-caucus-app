package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.local.SQLiteQueryCache;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteQueryCache$$Lambda$4 implements Consumer {
    private final SQLiteQueryCache arg$1;
    private final Query arg$2;
    private final SQLiteQueryCache.QueryDataHolder arg$3;

    private SQLiteQueryCache$$Lambda$4(SQLiteQueryCache sQLiteQueryCache, Query query, SQLiteQueryCache.QueryDataHolder queryDataHolder) {
        this.arg$1 = sQLiteQueryCache;
        this.arg$2 = query;
        this.arg$3 = queryDataHolder;
    }

    public static Consumer lambdaFactory$(SQLiteQueryCache sQLiteQueryCache, Query query, SQLiteQueryCache.QueryDataHolder queryDataHolder) {
        return new SQLiteQueryCache$$Lambda$4(sQLiteQueryCache, query, queryDataHolder);
    }

    public void accept(Object obj) {
        SQLiteQueryCache.lambda$getQueryData$3(this.arg$1, this.arg$2, this.arg$3, (Cursor) obj);
    }
}
