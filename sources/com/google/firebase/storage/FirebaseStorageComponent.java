package com.google.firebase.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-storage@@18.1.1 */
class FirebaseStorageComponent {
    private final FirebaseApp app;
    @Nullable
    private final Provider<InternalAuthProvider> authProvider;
    private final Map<String, FirebaseStorage> instances = new HashMap();

    FirebaseStorageComponent(@NonNull FirebaseApp firebaseApp, @Nullable Provider<InternalAuthProvider> provider) {
        this.app = firebaseApp;
        this.authProvider = provider;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized FirebaseStorage get(@Nullable String str) {
        FirebaseStorage firebaseStorage;
        firebaseStorage = this.instances.get(str);
        if (firebaseStorage == null) {
            firebaseStorage = new FirebaseStorage(str, this.app, this.authProvider);
            this.instances.put(str, firebaseStorage);
        }
        return firebaseStorage;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized void clearInstancesForTesting() {
        this.instances.clear();
    }
}
