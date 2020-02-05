package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final /* synthetic */ class zzbb implements RemoteCall {
    private final zzbc zza;

    zzbb(zzbc zzbc) {
        this.zza = zzbc;
    }

    public final void accept(Object obj, Object obj2) {
        zzbc zzbc = this.zza;
        zzdu zzdu = (zzdu) obj;
        zzbc.zzh = new zzez(zzbc, (TaskCompletionSource) obj2);
        if (zzbc.zzu) {
            zzdu.zza().zzc(zzbc.zza.zza(), zzbc.zza.zzb(), (zzdz) zzbc.zzc);
        } else {
            zzdu.zza().zza(zzbc.zza, (zzdz) zzbc.zzc);
        }
    }
}
