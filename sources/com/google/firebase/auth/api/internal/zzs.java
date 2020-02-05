package com.google.firebase.auth.api.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfz;
import com.google.android.gms.internal.firebase_auth.zzgb;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzs implements zzfe<zzey> {
    final /* synthetic */ zzdr zza;
    final /* synthetic */ zza zzb;
    private final /* synthetic */ zzfz zzc;
    private final /* synthetic */ Context zzd = null;

    zzs(zza zza2, zzfz zzfz, Context context, zzdr zzdr) {
        this.zzb = zza2;
        this.zzc = zzfz;
        this.zza = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzc.zza(((zzey) obj).zzd());
        this.zzb.zzb.zza(this.zzd, this.zzc, (zzfe<zzgb>) new zzr(this, this));
    }
}
