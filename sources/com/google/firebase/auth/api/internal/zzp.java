package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfl;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzp implements zzfe<zzey> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzdr zzc;
    private final /* synthetic */ zza zzd;

    zzp(zza zza2, String str, String str2, zzdr zzdr) {
        this.zzd = zza2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zzc.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzey zzey = (zzey) obj;
        zzfl zzfl = new zzfl();
        zzfl.zzb(zzey.zzd()).zzc(this.zza).zzd(this.zzb);
        this.zzd.zza(this.zzc, zzey, zzfl, (zzfb) this);
    }
}
