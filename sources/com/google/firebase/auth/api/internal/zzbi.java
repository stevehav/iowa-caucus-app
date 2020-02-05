package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzch;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzap;

@VisibleForTesting
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzbi extends zzes<GetTokenResult, zza> {
    private final zzch zza;

    public zzbi(String str) {
        super(1);
        Preconditions.checkNotEmpty(str, "refresh token cannot be null");
        this.zza = new zzch(str);
    }

    public final String zza() {
        return "getAccessToken";
    }

    public final TaskApiCall<zzdu, GetTokenResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzbh(this)).build();
    }

    public final void zze() {
        if (TextUtils.isEmpty(this.zzk.zzc())) {
            this.zzk.zza(this.zza.zza());
        }
        ((zza) this.zzf).zza(this.zzk, this.zze);
        zzb(zzap.zza(this.zzk.zzd()));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdu zzdu, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzez(this, taskCompletionSource);
        if (this.zzu) {
            zzdu.zza().zza(this.zza.zza(), (zzdz) this.zzc);
        } else {
            zzdu.zza().zza(this.zza, (zzdz) this.zzc);
        }
    }
}
