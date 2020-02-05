package com.google.firebase.firestore.local;

import android.database.Cursor;
import com.google.firebase.firestore.util.Consumer;
import java.util.ArrayList;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteIndexManager$$Lambda$1 implements Consumer {
    private final ArrayList arg$1;

    private SQLiteIndexManager$$Lambda$1(ArrayList arrayList) {
        this.arg$1 = arrayList;
    }

    public static Consumer lambdaFactory$(ArrayList arrayList) {
        return new SQLiteIndexManager$$Lambda$1(arrayList);
    }

    public void accept(Object obj) {
        this.arg$1.add(EncodedPath.decodeResourcePath(((Cursor) obj).getString(0)));
    }
}
