package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzen;
import com.google.android.gms.internal.firebase_auth.zzeq;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzv implements zzfe<zzey> {
    final /* synthetic */ String zza;
    final /* synthetic */ zzdr zzb;
    final /* synthetic */ zza zzc;

    zzv(zza zza2, String str, zzdr zzdr) {
        this.zzc = zza2;
        this.zza = str;
        this.zzb = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzey zzey = (zzey) obj;
        this.zzc.zzb.zza(new zzen(zzey.zzd()), (zzfe<zzeq>) new zzy(this, this, zzey));
    }
}
