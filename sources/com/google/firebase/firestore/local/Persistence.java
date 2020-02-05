package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Supplier;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public abstract class Persistence {
    public static boolean INDEXING_SUPPORT_ENABLED = false;
    static final String TAG = "Persistence";

    /* access modifiers changed from: package-private */
    public abstract IndexManager getIndexManager();

    /* access modifiers changed from: package-private */
    public abstract MutationQueue getMutationQueue(User user);

    /* access modifiers changed from: package-private */
    public abstract QueryCache getQueryCache();

    /* access modifiers changed from: package-private */
    public abstract ReferenceDelegate getReferenceDelegate();

    /* access modifiers changed from: package-private */
    public abstract RemoteDocumentCache getRemoteDocumentCache();

    public abstract boolean isStarted();

    /* access modifiers changed from: package-private */
    public abstract <T> T runTransaction(String str, Supplier<T> supplier);

    /* access modifiers changed from: package-private */
    public abstract void runTransaction(String str, Runnable runnable);

    public abstract void shutdown();

    public abstract void start();

    Persistence() {
    }
}
