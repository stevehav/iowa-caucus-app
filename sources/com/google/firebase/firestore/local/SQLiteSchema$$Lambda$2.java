package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteSchema$$Lambda$2 implements Consumer {
    private final SQLiteSchema arg$1;

    private SQLiteSchema$$Lambda$2(SQLiteSchema sQLiteSchema) {
        this.arg$1 = sQLiteSchema;
    }

    public static Consumer lambdaFactory$(SQLiteSchema sQLiteSchema) {
        return new SQLiteSchema$$Lambda$2(sQLiteSchema);
    }

    public void accept(Object obj) {
        SQLiteSchema.lambda$removeAcknowledgedMutations$2(this.arg$1, (Cursor) obj);
    }
}
