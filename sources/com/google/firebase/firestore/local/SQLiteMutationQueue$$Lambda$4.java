package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.common.base.Function;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$4 implements Function {
    private final SQLiteMutationQueue arg$1;
    private final int arg$2;

    private SQLiteMutationQueue$$Lambda$4(SQLiteMutationQueue sQLiteMutationQueue, int i) {
        this.arg$1 = sQLiteMutationQueue;
        this.arg$2 = i;
    }

    public static Function lambdaFactory$(SQLiteMutationQueue sQLiteMutationQueue, int i) {
        return new SQLiteMutationQueue$$Lambda$4(sQLiteMutationQueue, i);
    }

    public Object apply(Object obj) {
        return this.arg$1.decodeInlineMutationBatch(this.arg$2, ((Cursor) obj).getBlob(0));
    }
}
