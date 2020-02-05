package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteLruReferenceDelegate$$Lambda$3 implements Consumer {
    private final SQLiteLruReferenceDelegate arg$1;
    private final int[] arg$2;

    private SQLiteLruReferenceDelegate$$Lambda$3(SQLiteLruReferenceDelegate sQLiteLruReferenceDelegate, int[] iArr) {
        this.arg$1 = sQLiteLruReferenceDelegate;
        this.arg$2 = iArr;
    }

    public static Consumer lambdaFactory$(SQLiteLruReferenceDelegate sQLiteLruReferenceDelegate, int[] iArr) {
        return new SQLiteLruReferenceDelegate$$Lambda$3(sQLiteLruReferenceDelegate, iArr);
    }

    public void accept(Object obj) {
        SQLiteLruReferenceDelegate.lambda$removeOrphanedDocuments$2(this.arg$1, this.arg$2, (Cursor) obj);
    }
}
