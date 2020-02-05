package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteLruReferenceDelegate$$Lambda$2 implements Consumer {
    private final Consumer arg$1;

    private SQLiteLruReferenceDelegate$$Lambda$2(Consumer consumer) {
        this.arg$1 = consumer;
    }

    public static Consumer lambdaFactory$(Consumer consumer) {
        return new SQLiteLruReferenceDelegate$$Lambda$2(consumer);
    }

    public void accept(Object obj) {
        this.arg$1.accept(Long.valueOf(((Cursor) obj).getLong(0)));
    }
}
