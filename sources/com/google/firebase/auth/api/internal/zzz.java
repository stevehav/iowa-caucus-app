package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzeq;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzey;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzz implements zzfe<zzeq> {
    private final /* synthetic */ zzfe zza;
    private final /* synthetic */ zzey zzb;
    private final /* synthetic */ zzaa zzc;

    zzz(zzaa zzaa, zzfe zzfe, zzey zzey) {
        this.zzc = zzaa;
        this.zza = zzfe;
        this.zzb = zzey;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        List<zzes> zzb2 = ((zzeq) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users");
        } else {
            this.zzc.zza.zza(this.zzb, zzb2.get(0));
        }
    }
}
