package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzfm;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzn implements zzfe<zzfm> {
    private final /* synthetic */ zzdr zza;
    private final /* synthetic */ zza zzb;

    zzn(zza zza2, zzdr zzdr) {
        this.zzb = zza2;
        this.zza = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(zzy.zza(str));
        zzfc unused = this.zzb.zzb;
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zza.zzb(((zzfm) obj).zzb());
        zzfc unused = this.zzb.zzb;
    }
}
