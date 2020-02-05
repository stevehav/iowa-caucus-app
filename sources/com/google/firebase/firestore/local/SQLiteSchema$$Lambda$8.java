package com.google.firebase.firestore.local;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteSchema$$Lambda$8 implements Runnable {
    private final SQLiteSchema arg$1;

    private SQLiteSchema$$Lambda$8(SQLiteSchema sQLiteSchema) {
        this.arg$1 = sQLiteSchema;
    }

    public static Runnable lambdaFactory$(SQLiteSchema sQLiteSchema) {
        return new SQLiteSchema$$Lambda$8(sQLiteSchema);
    }

    public void run() {
        this.arg$1.db.execSQL("CREATE TABLE collection_parents (collection_id TEXT, parent TEXT, PRIMARY KEY(collection_id, parent))");
    }
}
