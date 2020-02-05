package com.google.firebase.firestore.local;

import com.google.firebase.firestore.local.LruGarbageCollector;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
final /* synthetic */ class LruGarbageCollector$Scheduler$$Lambda$1 implements Runnable {
    private final LruGarbageCollector.Scheduler arg$1;

    private LruGarbageCollector$Scheduler$$Lambda$1(LruGarbageCollector.Scheduler scheduler) {
        this.arg$1 = scheduler;
    }

    public static Runnable lambdaFactory$(LruGarbageCollector.Scheduler scheduler) {
        return new LruGarbageCollector$Scheduler$$Lambda$1(scheduler);
    }

    public void run() {
        LruGarbageCollector.Scheduler.lambda$scheduleGC$0(this.arg$1);
    }
}
