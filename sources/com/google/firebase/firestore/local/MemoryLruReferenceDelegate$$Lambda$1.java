package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class MemoryLruReferenceDelegate$$Lambda$1 implements Consumer {
    private final long[] arg$1;

    private MemoryLruReferenceDelegate$$Lambda$1(long[] jArr) {
        this.arg$1 = jArr;
    }

    public static Consumer lambdaFactory$(long[] jArr) {
        return new MemoryLruReferenceDelegate$$Lambda$1(jArr);
    }

    public void accept(Object obj) {
        MemoryLruReferenceDelegate.lambda$getSequenceNumberCount$0(this.arg$1, (Long) obj);
    }
}
