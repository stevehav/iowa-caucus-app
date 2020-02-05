package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.util.SparseArray;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteQueryCache$$Lambda$3 implements Consumer {
    private final SQLiteQueryCache arg$1;
    private final SparseArray arg$2;
    private final int[] arg$3;

    private SQLiteQueryCache$$Lambda$3(SQLiteQueryCache sQLiteQueryCache, SparseArray sparseArray, int[] iArr) {
        this.arg$1 = sQLiteQueryCache;
        this.arg$2 = sparseArray;
        this.arg$3 = iArr;
    }

    public static Consumer lambdaFactory$(SQLiteQueryCache sQLiteQueryCache, SparseArray sparseArray, int[] iArr) {
        return new SQLiteQueryCache$$Lambda$3(sQLiteQueryCache, sparseArray, iArr);
    }

    public void accept(Object obj) {
        SQLiteQueryCache.lambda$removeQueries$2(this.arg$1, this.arg$2, this.arg$3, (Cursor) obj);
    }
}
