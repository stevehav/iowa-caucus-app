package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteQueryCache$$Lambda$2 implements Consumer {
    private final SQLiteQueryCache arg$1;
    private final Consumer arg$2;

    private SQLiteQueryCache$$Lambda$2(SQLiteQueryCache sQLiteQueryCache, Consumer consumer) {
        this.arg$1 = sQLiteQueryCache;
        this.arg$2 = consumer;
    }

    public static Consumer lambdaFactory$(SQLiteQueryCache sQLiteQueryCache, Consumer consumer) {
        return new SQLiteQueryCache$$Lambda$2(sQLiteQueryCache, consumer);
    }

    public void accept(Object obj) {
        this.arg$2.accept(this.arg$1.decodeQueryData(((Cursor) obj).getBlob(0)));
    }
}
