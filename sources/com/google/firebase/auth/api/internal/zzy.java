package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzeq;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfl;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzy implements zzfe<zzeq> {
    private final /* synthetic */ zzfe zza;
    private final /* synthetic */ zzey zzb;
    private final /* synthetic */ zzv zzc;

    zzy(zzv zzv, zzfe zzfe, zzey zzey) {
        this.zzc = zzv;
        this.zza = zzfe;
        this.zzb = zzey;
    }

    public final void zza(@Nullable String str) {
        this.zzc.zzb.zza(com.google.firebase.auth.internal.zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzes> zzb2 = ((zzeq) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        zzfl zzfl = new zzfl();
        zzfl.zzb(this.zzb.zzd()).zzg(this.zzc.zza);
        this.zzc.zzc.zza(this.zzc.zzb, this.zzb, zzb2.get(0), zzfl, (zzfb) this.zza);
    }
}
