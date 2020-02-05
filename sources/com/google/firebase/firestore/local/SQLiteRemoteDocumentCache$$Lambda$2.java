package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteRemoteDocumentCache$$Lambda$2 implements Consumer {
    private final SQLiteRemoteDocumentCache arg$1;
    private final Map arg$2;

    private SQLiteRemoteDocumentCache$$Lambda$2(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, Map map) {
        this.arg$1 = sQLiteRemoteDocumentCache;
        this.arg$2 = map;
    }

    public static Consumer lambdaFactory$(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache, Map map) {
        return new SQLiteRemoteDocumentCache$$Lambda$2(sQLiteRemoteDocumentCache, map);
    }

    public void accept(Object obj) {
        SQLiteRemoteDocumentCache.lambda$getAll$1(this.arg$1, this.arg$2, (Cursor) obj);
    }
}
