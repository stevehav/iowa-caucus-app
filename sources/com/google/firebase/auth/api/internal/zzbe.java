package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.firebase.auth.internal.zzab;

@VisibleForTesting
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzbe extends zzes<Void, zzab> {
    public zzbe() {
        super(5);
    }

    public final String zza() {
        return "delete";
    }

    public final TaskApiCall<zzdu, Void> zzb() {
        return TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures((this.zzu || this.zzv) ? null : new Feature[]{zze.zza}).run(new zzbd(this)).build();
    }

    public final void zze() {
        ((zzab) this.zzf).zza();
        zzb(null);
    }
}
