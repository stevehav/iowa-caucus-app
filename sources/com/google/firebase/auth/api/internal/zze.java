package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzed;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzga;
import com.google.firebase.auth.internal.zzy;
import com.google.firebase.auth.zzg;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zze implements zzfe<zzga> {
    private final /* synthetic */ zzdr zza;
    private final /* synthetic */ zza zzb;

    zze(zza zza2, zzdr zzdr) {
        this.zzb = zza2;
        this.zza = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzga zzga = (zzga) obj;
        if (!zzga.zzg()) {
            this.zzb.zza(new zzey(zzga.zzc(), zzga.zzb(), Long.valueOf(zzga.zzd()), "Bearer"), (String) null, (String) null, false, (zzg) null, this.zza, this);
        } else if (this.zzb.zzc.zzb()) {
            this.zza.zza(new zzed(zzga.zzf(), zzga.zze(), (zzg) null));
        } else {
            zza.zza.e("Need to do multi-factor auth, but SDK does not support it.", new Object[0]);
            zza("REQUIRES_SECOND_FACTOR_AUTH");
        }
    }
}
