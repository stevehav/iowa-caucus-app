package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$7 implements Consumer {
    private final SQLiteMutationQueue arg$1;
    private final List arg$2;

    private SQLiteMutationQueue$$Lambda$7(SQLiteMutationQueue sQLiteMutationQueue, List list) {
        this.arg$1 = sQLiteMutationQueue;
        this.arg$2 = list;
    }

    public static Consumer lambdaFactory$(SQLiteMutationQueue sQLiteMutationQueue, List list) {
        return new SQLiteMutationQueue$$Lambda$7(sQLiteMutationQueue, list);
    }

    public void accept(Object obj) {
        this.arg$2.add(this.arg$1.decodeInlineMutationBatch(((Cursor) obj).getInt(0), ((Cursor) obj).getBlob(1)));
    }
}
