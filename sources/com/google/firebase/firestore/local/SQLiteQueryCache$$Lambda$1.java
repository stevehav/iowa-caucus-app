package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteQueryCache$$Lambda$1 implements Consumer {
    private final SQLiteQueryCache arg$1;

    private SQLiteQueryCache$$Lambda$1(SQLiteQueryCache sQLiteQueryCache) {
        this.arg$1 = sQLiteQueryCache;
    }

    public static Consumer lambdaFactory$(SQLiteQueryCache sQLiteQueryCache) {
        return new SQLiteQueryCache$$Lambda$1(sQLiteQueryCache);
    }

    public void accept(Object obj) {
        SQLiteQueryCache.lambda$start$0(this.arg$1, (Cursor) obj);
    }
}
