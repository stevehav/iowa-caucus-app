package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteSchema$$Lambda$11 implements Consumer {
    private final Consumer arg$1;

    private SQLiteSchema$$Lambda$11(Consumer consumer) {
        this.arg$1 = consumer;
    }

    public static Consumer lambdaFactory$(Consumer consumer) {
        return new SQLiteSchema$$Lambda$11(consumer);
    }

    public void accept(Object obj) {
        this.arg$1.accept((ResourcePath) EncodedPath.decodeResourcePath(((Cursor) obj).getString(0)).popLast());
    }
}
