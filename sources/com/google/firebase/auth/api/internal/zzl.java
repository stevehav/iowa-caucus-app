package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfv;
import com.google.firebase.auth.internal.zzy;
import com.google.firebase.auth.zzg;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzl implements zzfe<zzfv> {
    private final /* synthetic */ zzdr zza;
    private final /* synthetic */ zza zzb;

    zzl(zza zza2, zzdr zzdr) {
        this.zzb = zza2;
        this.zza = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzfv zzfv = (zzfv) obj;
        this.zzb.zza(new zzey(zzfv.zzc(), zzfv.zzb(), Long.valueOf(zzfv.zzd()), "Bearer"), (String) null, (String) null, Boolean.valueOf(zzfv.zze()), (zzg) null, this.zza, this);
    }
}
