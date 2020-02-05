package com.google.firebase.firestore.local;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteSchema$$Lambda$1 implements Runnable {
    private final SQLiteSchema arg$1;

    private SQLiteSchema$$Lambda$1(SQLiteSchema sQLiteSchema) {
        this.arg$1 = sQLiteSchema;
    }

    public static Runnable lambdaFactory$(SQLiteSchema sQLiteSchema) {
        return new SQLiteSchema$$Lambda$1(sQLiteSchema);
    }

    public void run() {
        SQLiteSchema.lambda$createV1MutationQueue$0(this.arg$1);
    }
}
