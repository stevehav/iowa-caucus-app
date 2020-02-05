package com.google.firebase.firestore.core;

import android.app.Activity;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class ActivityScope$$Lambda$1 implements Runnable {
    private final Activity arg$1;
    private final Runnable arg$2;

    private ActivityScope$$Lambda$1(Activity activity, Runnable runnable) {
        this.arg$1 = activity;
        this.arg$2 = runnable;
    }

    public static Runnable lambdaFactory$(Activity activity, Runnable runnable) {
        return new ActivityScope$$Lambda$1(activity, runnable);
    }

    public void run() {
        ActivityScope.lambda$onActivityStopCallOnce$0(this.arg$1, this.arg$2);
    }
}
