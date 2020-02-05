package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzek;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzac implements zzfe<zzey> {
    final /* synthetic */ zzdr zza;
    private final /* synthetic */ zza zzb;

    zzac(zza zza2, zzdr zzdr) {
        this.zzb = zza2;
        this.zza = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzb.zzb.zza(new zzek(((zzey) obj).zzd()), (zzfe<Void>) new zzab(this, this));
    }
}
