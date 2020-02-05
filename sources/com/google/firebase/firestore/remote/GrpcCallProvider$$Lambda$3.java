package com.google.firebase.firestore.remote;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class GrpcCallProvider$$Lambda$3 implements OnCompleteListener {
    private static final GrpcCallProvider$$Lambda$3 instance = new GrpcCallProvider$$Lambda$3();

    private GrpcCallProvider$$Lambda$3() {
    }

    public static OnCompleteListener lambdaFactory$() {
        return instance;
    }

    public void onComplete(Task task) {
        GrpcCallProvider.lambda$shutdown$2(task);
    }
}
