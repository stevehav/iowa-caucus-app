package com.google.firebase.firestore.local;

import com.google.firebase.firestore.util.Supplier;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LocalStore$$Lambda$10 implements Supplier {
    private final LocalStore arg$1;
    private final LruGarbageCollector arg$2;

    private LocalStore$$Lambda$10(LocalStore localStore, LruGarbageCollector lruGarbageCollector) {
        this.arg$1 = localStore;
        this.arg$2 = lruGarbageCollector;
    }

    public static Supplier lambdaFactory$(LocalStore localStore, LruGarbageCollector lruGarbageCollector) {
        return new LocalStore$$Lambda$10(localStore, lruGarbageCollector);
    }

    public Object get() {
        return this.arg$2.collect(this.arg$1.targetIds);
    }
}
