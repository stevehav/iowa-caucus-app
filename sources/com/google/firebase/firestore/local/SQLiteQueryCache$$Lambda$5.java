package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.local.SQLiteQueryCache;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteQueryCache$$Lambda$5 implements Consumer {
    private final SQLiteQueryCache.DocumentKeysHolder arg$1;

    private SQLiteQueryCache$$Lambda$5(SQLiteQueryCache.DocumentKeysHolder documentKeysHolder) {
        this.arg$1 = documentKeysHolder;
    }

    public static Consumer lambdaFactory$(SQLiteQueryCache.DocumentKeysHolder documentKeysHolder) {
        return new SQLiteQueryCache$$Lambda$5(documentKeysHolder);
    }

    public void accept(Object obj) {
        this.arg$1.keys = this.arg$1.keys.insert(DocumentKey.fromPath(EncodedPath.decodeResourcePath(((Cursor) obj).getString(0))));
    }
}
