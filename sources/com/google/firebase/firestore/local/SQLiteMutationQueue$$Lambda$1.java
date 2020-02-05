package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import com.google.protobuf.ByteString;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$1 implements Consumer {
    private final SQLiteMutationQueue arg$1;

    private SQLiteMutationQueue$$Lambda$1(SQLiteMutationQueue sQLiteMutationQueue) {
        this.arg$1 = sQLiteMutationQueue;
    }

    public static Consumer lambdaFactory$(SQLiteMutationQueue sQLiteMutationQueue) {
        return new SQLiteMutationQueue$$Lambda$1(sQLiteMutationQueue);
    }

    public void accept(Object obj) {
        this.arg$1.lastStreamToken = ByteString.copyFrom(((Cursor) obj).getBlob(0));
    }
}
