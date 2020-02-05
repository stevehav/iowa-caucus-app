package com.google.firebase.firestore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class Query$$Lambda$1 implements Continuation {
    private final Query arg$1;

    private Query$$Lambda$1(Query query) {
        this.arg$1 = query;
    }

    public static Continuation lambdaFactory$(Query query) {
        return new Query$$Lambda$1(query);
    }

    public Object then(Task task) {
        return Query.lambda$get$0(this.arg$1, task);
    }
}
