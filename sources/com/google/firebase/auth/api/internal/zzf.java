package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzeq;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfl;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzf implements zzfe<zzeq> {
    private final /* synthetic */ zzfb zza;
    private final /* synthetic */ zzdr zzb;
    private final /* synthetic */ zzey zzc;
    private final /* synthetic */ zzfl zzd;
    private final /* synthetic */ zza zze;

    zzf(zza zza2, zzfb zzfb, zzdr zzdr, zzey zzey, zzfl zzfl) {
        this.zze = zza2;
        this.zza = zzfb;
        this.zzb = zzdr;
        this.zzc = zzey;
        this.zzd = zzfl;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzes> zzb2 = ((zzeq) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zze.zza(this.zzb, this.zzc, zzb2.get(0), this.zzd, this.zza);
        }
    }
}
