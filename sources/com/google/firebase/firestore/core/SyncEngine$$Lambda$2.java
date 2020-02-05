package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.common.base.Function;
import com.google.firebase.firestore.util.AsyncQueue;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class SyncEngine$$Lambda$2 implements Continuation {
    private final SyncEngine arg$1;
    private final Task arg$2;
    private final int arg$3;
    private final AsyncQueue arg$4;
    private final Function arg$5;

    private SyncEngine$$Lambda$2(SyncEngine syncEngine, Task task, int i, AsyncQueue asyncQueue, Function function) {
        this.arg$1 = syncEngine;
        this.arg$2 = task;
        this.arg$3 = i;
        this.arg$4 = asyncQueue;
        this.arg$5 = function;
    }

    public static Continuation lambdaFactory$(SyncEngine syncEngine, Task task, int i, AsyncQueue asyncQueue, Function function) {
        return new SyncEngine$$Lambda$2(syncEngine, task, i, asyncQueue, function);
    }

    public Object then(Task task) {
        return SyncEngine.lambda$transaction$0(this.arg$1, this.arg$2, this.arg$3, this.arg$4, this.arg$5, task);
    }
}
