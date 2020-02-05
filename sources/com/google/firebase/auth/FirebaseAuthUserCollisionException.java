package com.google.firebase.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class FirebaseAuthUserCollisionException extends FirebaseAuthException {
    @Nullable
    private AuthCredential zza;
    @Nullable
    private String zzb;
    @Nullable
    private String zzc;

    public FirebaseAuthUserCollisionException(@NonNull String str, @NonNull String str2) {
        super(str, str2);
    }

    public final FirebaseAuthUserCollisionException zza(String str) {
        this.zzb = str;
        return this;
    }

    public final FirebaseAuthUserCollisionException zza(AuthCredential authCredential) {
        this.zza = authCredential;
        return this;
    }

    public final FirebaseAuthUserCollisionException zzb(String str) {
        this.zzc = str;
        return this;
    }

    @Nullable
    public final AuthCredential getUpdatedCredential() {
        return this.zza;
    }
}
