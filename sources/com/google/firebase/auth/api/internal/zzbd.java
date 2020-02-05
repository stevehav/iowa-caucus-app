package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzcb;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final /* synthetic */ class zzbd implements RemoteCall {
    private final zzbe zza;

    zzbd(zzbe zzbe) {
        this.zza = zzbe;
    }

    public final void accept(Object obj, Object obj2) {
        zzbe zzbe = this.zza;
        zzdu zzdu = (zzdu) obj;
        zzbe.zzh = new zzez(zzbe, (TaskCompletionSource) obj2);
        if (zzbe.zzu) {
            zzdu.zza().zzg(zzbe.zze.zzf(), zzbe.zzc);
        } else {
            zzdu.zza().zza(new zzcb(zzbe.zze.zzf()), (zzdz) zzbe.zzc);
        }
    }
}
