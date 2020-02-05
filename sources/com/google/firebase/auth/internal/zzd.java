package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zzc;
import com.google.firebase.auth.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzd extends zzc {
    private final zzy zzb;

    public zzd(String str, zzy zzy) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = (zzy) Preconditions.checkNotNull(zzy);
    }
}
