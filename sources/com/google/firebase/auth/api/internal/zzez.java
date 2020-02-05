package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzed;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzez<ResultT, CallbackT> implements zzeq<ResultT> {
    private final zzes<ResultT, CallbackT> zza;
    private final TaskCompletionSource<ResultT> zzb;

    public zzez(zzes<ResultT, CallbackT> zzes, TaskCompletionSource<ResultT> taskCompletionSource) {
        this.zza = zzes;
        this.zzb = taskCompletionSource;
    }

    public final void zza(ResultT resultt, Status status) {
        FirebaseUser firebaseUser;
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status == null) {
            this.zzb.setResult(resultt);
        } else if (this.zza.zzt != null) {
            TaskCompletionSource<ResultT> taskCompletionSource = this.zzb;
            FirebaseAuth instance = FirebaseAuth.getInstance(this.zza.zzd);
            zzed zzed = this.zza.zzt;
            if ("reauthenticateWithCredential".equals(this.zza.zza()) || "reauthenticateWithCredentialWithData".equals(this.zza.zza())) {
                firebaseUser = this.zza.zze;
            } else {
                firebaseUser = null;
            }
            taskCompletionSource.setException(zzdw.zza(instance, zzed, firebaseUser));
        } else if (this.zza.zzq != null) {
            this.zzb.setException(zzdw.zza(status, this.zza.zzq, this.zza.zzr, this.zza.zzs));
        } else {
            this.zzb.setException(zzdw.zza(status));
        }
    }
}
