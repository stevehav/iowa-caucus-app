package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzb extends com.google.firebase.auth.zzb {
    private final String zzb;

    public zzb(String str, String str2) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
    }
}
