package com.google.firebase.storage.internal;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
public class SleeperImpl implements Sleeper {
    public void sleep(int i) throws InterruptedException {
        Thread.sleep((long) i);
    }
}
