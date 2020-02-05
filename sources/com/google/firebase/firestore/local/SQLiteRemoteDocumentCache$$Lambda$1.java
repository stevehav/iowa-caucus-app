package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.common.base.Function;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteRemoteDocumentCache$$Lambda$1 implements Function {
    private final SQLiteRemoteDocumentCache arg$1;

    private SQLiteRemoteDocumentCache$$Lambda$1(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache) {
        this.arg$1 = sQLiteRemoteDocumentCache;
    }

    public static Function lambdaFactory$(SQLiteRemoteDocumentCache sQLiteRemoteDocumentCache) {
        return new SQLiteRemoteDocumentCache$$Lambda$1(sQLiteRemoteDocumentCache);
    }

    public Object apply(Object obj) {
        return this.arg$1.decodeMaybeDocument(((Cursor) obj).getBlob(0));
    }
}
