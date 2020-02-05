package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzej;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzd implements zzfe<zzey> {
    private final /* synthetic */ EmailAuthCredential zza;
    private final /* synthetic */ zzdr zzb;
    private final /* synthetic */ zza zzc;

    zzd(zza zza2, EmailAuthCredential emailAuthCredential, zzdr zzdr) {
        this.zzc = zza2;
        this.zza = emailAuthCredential;
        this.zzb = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        this.zzc.zza(new zzej(this.zza, ((zzey) obj).zzd()), this.zzb);
    }
}
