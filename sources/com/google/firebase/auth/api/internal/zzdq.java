package com.google.firebase.auth.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcx;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.android.gms.internal.firebase_auth.zzfk;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthProvider;

@VisibleForTesting
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzdq extends zzes<Void, PhoneAuthProvider.OnVerificationStateChangedCallbacks> {
    private final zzcx zza;

    public zzdq(zzfk zzfk) {
        super(8);
        Preconditions.checkNotNull(zzfk);
        this.zza = new zzcx(zzfk);
    }

    public final String zza() {
        return "verifyPhoneNumber";
    }

    public final void zze() {
    }

    public final TaskApiCall<zzdu, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzdp(this)).build();
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
