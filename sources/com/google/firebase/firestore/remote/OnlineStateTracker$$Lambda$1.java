package com.google.firebase.firestore.remote;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class OnlineStateTracker$$Lambda$1 implements Runnable {
    private final OnlineStateTracker arg$1;

    private OnlineStateTracker$$Lambda$1(OnlineStateTracker onlineStateTracker) {
        this.arg$1 = onlineStateTracker;
    }

    public static Runnable lambdaFactory$(OnlineStateTracker onlineStateTracker) {
        return new OnlineStateTracker$$Lambda$1(onlineStateTracker);
    }

    public void run() {
        OnlineStateTracker.lambda$handleWatchStreamStart$0(this.arg$1);
    }
}
