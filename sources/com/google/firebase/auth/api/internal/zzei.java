package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzei {
    private String zza;

    public zzei(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public final zzej zza() {
        return new zzej(this.zza, (zzeg) null);
    }
}
