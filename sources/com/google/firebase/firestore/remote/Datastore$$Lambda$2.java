package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.List;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class Datastore$$Lambda$2 implements Continuation {
    private final Datastore arg$1;
    private final List arg$2;

    private Datastore$$Lambda$2(Datastore datastore, List list) {
        this.arg$1 = datastore;
        this.arg$2 = list;
    }

    public static Continuation lambdaFactory$(Datastore datastore, List list) {
        return new Datastore$$Lambda$2(datastore, list);
    }

    public Object then(Task task) {
        return Datastore.lambda$lookup$1(this.arg$1, this.arg$2, task);
    }
}
