package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzae;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzo implements zza, zzae {
    private final /* synthetic */ FirebaseAuth zza;

    zzo(FirebaseAuth firebaseAuth) {
        this.zza = firebaseAuth;
    }

    public final void zza(@NonNull zzey zzey, @NonNull FirebaseUser firebaseUser) {
        this.zza.zza(firebaseUser, zzey, true);
    }

    public final void zza(Status status) {
        int statusCode = status.getStatusCode();
        if (statusCode == 17011 || statusCode == 17021 || statusCode == 17005) {
            this.zza.signOut();
        }
    }
}
