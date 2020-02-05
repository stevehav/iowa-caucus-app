package com.google.firebase.firestore;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.InternalAuthProvider;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
class FirestoreMultiDbComponent {
    private final FirebaseApp app;
    private final InternalAuthProvider authProvider;
    private final Context context;
    private final Map<String, FirebaseFirestore> instances = new HashMap();

    FirestoreMultiDbComponent(@NonNull Context context2, @NonNull FirebaseApp firebaseApp, @Nullable InternalAuthProvider internalAuthProvider) {
        this.context = context2;
        this.app = firebaseApp;
        this.authProvider = internalAuthProvider;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized FirebaseFirestore get(@NonNull String str) {
        FirebaseFirestore firebaseFirestore;
        firebaseFirestore = this.instances.get(str);
        if (firebaseFirestore == null) {
            firebaseFirestore = FirebaseFirestore.newInstance(this.context, this.app, this.authProvider, str);
            this.instances.put(str, firebaseFirestore);
        }
        return firebaseFirestore;
    }
}
