package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzdv;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzn;

@VisibleForTesting
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzde extends zzes<AuthResult, zza> {
    private String zza;

    public zzde(String str) {
        super(2);
        this.zza = Preconditions.checkNotEmpty(str, "provider cannot be null or empty");
    }

    public final String zza() {
        return "unlinkFederatedCredential";
    }

    public final TaskApiCall<zzdu, AuthResult> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzdd(this)).build();
    }

    public final void zze() {
        zzn zza2 = zzau.zza(this.zzd, this.zzl);
        ((zza) this.zzf).zza(this.zzk, zza2);
        zzb(new zzh(zza2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzdu zzdu, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzh = new zzez(this, taskCompletionSource);
        if (this.zzu) {
            zzdu.zza().zze(this.zza, this.zze.zzf(), this.zzc);
        } else {
            zzdu.zza().zza(new zzdv(this.zza, this.zze.zzf()), (zzdz) this.zzc);
        }
    }
}
