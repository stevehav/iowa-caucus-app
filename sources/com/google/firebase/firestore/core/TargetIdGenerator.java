package com.google.firebase.firestore.core;

import com.google.firebase.firestore.util.Assert;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class TargetIdGenerator {
    private static final int QUERY_CACHE_ID = 0;
    private static final int RESERVED_BITS = 1;
    private static final int SYNC_ENGINE_ID = 1;
    private int generatorId;
    private int nextId;

    public static TargetIdGenerator forQueryCache(int i) {
        TargetIdGenerator targetIdGenerator = new TargetIdGenerator(0, i);
        targetIdGenerator.nextId();
        return targetIdGenerator;
    }

    public static TargetIdGenerator forSyncEngine() {
        return new TargetIdGenerator(1, 1);
    }

    TargetIdGenerator(int i, int i2) {
        Assert.hardAssert((i & 1) == i, "Generator ID %d contains more than %d reserved bits", Integer.valueOf(i), 1);
        this.generatorId = i;
        seek(i2);
    }

    private void seek(int i) {
        Assert.hardAssert((i & 1) == this.generatorId, "Cannot supply target ID from different generator ID", new Object[0]);
        this.nextId = i;
    }

    public int nextId() {
        int i = this.nextId;
        this.nextId = i + 2;
        return i;
    }
}
