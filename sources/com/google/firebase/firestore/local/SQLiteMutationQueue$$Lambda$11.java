package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$11 implements Consumer {
    private final List arg$1;

    private SQLiteMutationQueue$$Lambda$11(List list) {
        this.arg$1 = list;
    }

    public static Consumer lambdaFactory$(List list) {
        return new SQLiteMutationQueue$$Lambda$11(list);
    }

    public void accept(Object obj) {
        this.arg$1.add(EncodedPath.decodeResourcePath(((Cursor) obj).getString(0)));
    }
}
