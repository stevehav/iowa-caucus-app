package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzbg extends zzes<SignInMethodQueryResult, zza> {
    private final zzcj zza;

    public zzbg(String str, @Nullable String str2) {
        super(3);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = new zzcj(str, str2);
    }

    public final String zza() {
        return "fetchSignInMethodsForEmail";
    }

    public final TaskApiCall<zzdu, SignInMethodQueryResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzbf(this)).build();
    }

    public final void zze() {
        zzb(new zzx(this.zzm.zzb()));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdu zzdu, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzez(this, taskCompletionSource);
        if (this.zzu) {
            zzdu.zza().zzc(this.zza.zza(), this.zzc);
        } else {
            zzdu.zza().zza(this.zza, (zzdz) this.zzc);
        }
    }
}
