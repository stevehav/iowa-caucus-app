package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Function;
import com.google.firebase.firestore.util.AsyncQueue;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SyncEngine$$Lambda$1 implements Continuation {
    private final SyncEngine arg$1;
    private final Transaction arg$2;
    private final AsyncQueue arg$3;
    private final int arg$4;
    private final Function arg$5;

    private SyncEngine$$Lambda$1(SyncEngine syncEngine, Transaction transaction, AsyncQueue asyncQueue, int i, Function function) {
        this.arg$1 = syncEngine;
        this.arg$2 = transaction;
        this.arg$3 = asyncQueue;
        this.arg$4 = i;
        this.arg$5 = function;
    }

    public static Continuation lambdaFactory$(SyncEngine syncEngine, Transaction transaction, AsyncQueue asyncQueue, int i, Function function) {
        return new SyncEngine$$Lambda$1(syncEngine, transaction, asyncQueue, i, function);
    }

    public Object then(Task task) {
        return SyncEngine.lambda$transaction$1(this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5, task);
    }
}
