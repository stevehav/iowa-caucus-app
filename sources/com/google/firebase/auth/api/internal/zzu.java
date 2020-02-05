package com.google.firebase.auth.api.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.android.gms.internal.firebase_auth.zzft;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzu implements zzfe<zzey> {
    final /* synthetic */ zzdr zza;
    final /* synthetic */ zza zzb;
    private final /* synthetic */ zzfr zzc;

    zzu(zza zza2, zzfr zzfr, zzdr zzdr) {
        this.zzb = zza2;
        this.zzc = zzfr;
        this.zza = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzey zzey = (zzey) obj;
        if (this.zzb.zzc.zza()) {
            this.zzc.zzc(true);
        }
        this.zzc.zza(zzey.zzd());
        this.zzb.zzb.zza((Context) null, this.zzc, (zzfe<zzft>) new zzt(this, this));
    }
}
