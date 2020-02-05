package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzgb;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.zzg;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzr implements zzfe<zzgb> {
    private final /* synthetic */ zzfe zza;
    private final /* synthetic */ zzs zzb;

    zzr(zzs zzs, zzfe zzfe) {
        this.zzb = zzs;
        this.zza = zzfe;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzgb zzgb = (zzgb) obj;
        if (!TextUtils.isEmpty(zzgb.zzf())) {
            this.zzb.zza.zza(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zza(zzgb.zzg(), zzgb.zzf()));
            return;
        }
        this.zzb.zzb.zza(new zzey(zzgb.zzc(), zzgb.zzb(), Long.valueOf(zzgb.zzd()), "Bearer"), (String) null, "phone", Boolean.valueOf(zzgb.zze()), (zzg) null, this.zzb.zza, this.zza);
    }
}
