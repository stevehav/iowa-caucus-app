package com.google.firebase.firestore.local;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteSchema$$Lambda$3 implements Runnable {
    private final SQLiteSchema arg$1;

    private SQLiteSchema$$Lambda$3(SQLiteSchema sQLiteSchema) {
        this.arg$1 = sQLiteSchema;
    }

    public static Runnable lambdaFactory$(SQLiteSchema sQLiteSchema) {
        return new SQLiteSchema$$Lambda$3(sQLiteSchema);
    }

    public void run() {
        SQLiteSchema.lambda$createV1QueryCache$3(this.arg$1);
    }
}
