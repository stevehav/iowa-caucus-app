package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfl;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzw implements zzfe<zzey> {
    private final /* synthetic */ zzdr zza;
    private final /* synthetic */ zza zzb;

    zzw(zza zza2, zzdr zzdr) {
        this.zzb = zza2;
        this.zza = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzey zzey = (zzey) obj;
        zzfl zzfl = new zzfl();
        zzfl.zzb(zzey.zzd()).zzc((String) null).zzd((String) null);
        this.zzb.zza(this.zza, zzey, zzfl, (zzfb) this);
    }
}
