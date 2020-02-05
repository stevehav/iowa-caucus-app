package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class Datastore$$Lambda$1 implements Continuation {
    private final Datastore arg$1;

    private Datastore$$Lambda$1(Datastore datastore) {
        this.arg$1 = datastore;
    }

    public static Continuation lambdaFactory$(Datastore datastore) {
        return new Datastore$$Lambda$1(datastore);
    }

    public Object then(Task task) {
        return Datastore.lambda$commit$0(this.arg$1, task);
    }
}
