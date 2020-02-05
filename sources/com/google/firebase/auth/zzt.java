package com.google.firebase.auth;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final /* synthetic */ class zzt implements ComponentFactory {
    static final ComponentFactory zza = new zzt();

    private zzt() {
    }

    public final Object create(ComponentContainer componentContainer) {
        return new zzl((FirebaseApp) componentContainer.get(FirebaseApp.class));
    }
}
