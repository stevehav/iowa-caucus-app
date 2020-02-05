package com.google.firebase.firestore.remote;

import com.google.firebase.firestore.util.Consumer;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public interface ConnectivityMonitor {

    /* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
    public enum NetworkStatus {
        UNREACHABLE,
        REACHABLE
    }

    void addCallback(Consumer<NetworkStatus> consumer);

    void shutdown();
}
