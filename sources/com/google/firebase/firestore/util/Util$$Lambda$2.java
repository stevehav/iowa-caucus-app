package com.google.firebase.firestore.util;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class Util$$Lambda$2 implements Continuation {
    private static final Util$$Lambda$2 instance = new Util$$Lambda$2();

    private Util$$Lambda$2() {
    }

    public static Continuation lambdaFactory$() {
        return instance;
    }

    public Object then(Task task) {
        return Util.lambda$static$0(task);
    }
}
