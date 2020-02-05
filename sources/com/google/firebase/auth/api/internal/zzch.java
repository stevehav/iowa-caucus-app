package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final /* synthetic */ class zzch implements RemoteCall {
    private final zzci zza;

    zzch(zzci zzci) {
        this.zza = zzci;
    }

    public final void accept(Object obj, Object obj2) {
        zzci zzci = this.zza;
        zzdu zzdu = (zzdu) obj;
        zzci.zzh = new zzez(zzci, (TaskCompletionSource) obj2);
        if (zzci.zzu) {
            zzdu.zza().zzf(zzci.zze.zzf(), zzci.zzc);
        } else {
            zzdu.zza().zza(new zzcr(zzci.zze.zzf()), (zzdz) zzci.zzc);
        }
    }
}
