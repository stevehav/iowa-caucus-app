package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzed;
import com.google.android.gms.internal.firebase_auth.zzft;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzx implements zzfe<zzft> {
    private final /* synthetic */ zzdr zza;
    private final /* synthetic */ zza zzb;

    zzx(zza zza2, zzdr zzdr) {
        this.zzb = zza2;
        this.zza = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzft zzft = (zzft) obj;
        if (!zzft.zzo()) {
            this.zzb.zza(zzft, this.zza, (zzfb) this);
        } else if (this.zzb.zzc.zzb()) {
            this.zza.zza(new zzed(zzft.zzn(), zzft.zzm(), zzft.zzp()));
        } else {
            zza.zza.e("Need to do multi-factor auth, but SDK does not support it.", new Object[0]);
            zza("REQUIRES_SECOND_FACTOR_AUTH");
        }
    }
}
