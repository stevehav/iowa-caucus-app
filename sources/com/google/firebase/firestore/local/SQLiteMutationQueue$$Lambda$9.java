package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.util.Util;
import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SQLiteMutationQueue$$Lambda$9 implements Comparator {
    private static final SQLiteMutationQueue$$Lambda$9 instance = new SQLiteMutationQueue$$Lambda$9();

    private SQLiteMutationQueue$$Lambda$9() {
    }

    public static Comparator lambdaFactory$() {
        return instance;
    }

    public int compare(Object obj, Object obj2) {
        return Util.compareInts(((MutationBatch) obj).getBatchId(), ((MutationBatch) obj2).getBatchId());
    }
}
