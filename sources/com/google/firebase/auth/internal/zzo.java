package com.google.firebase.auth.internal;

import androidx.annotation.Nullable;
import com.google.firebase.auth.FirebaseAuthSettings;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzo extends FirebaseAuthSettings {
    private String zza;
    private String zzb;

    @Nullable
    public final String zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return (this.zza == null || this.zzb == null) ? false : true;
    }

    public final void setAutoRetrievedSmsCodeForPhoneNumber(@Nullable String str, @Nullable String str2) {
        this.zza = str;
        this.zzb = str2;
    }
}
