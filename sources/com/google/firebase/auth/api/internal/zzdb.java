package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.internal.firebase_auth.zzdt;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final /* synthetic */ class zzdb implements RemoteCall {
    private final zzdc zza;

    zzdb(zzdc zzdc) {
        this.zza = zzdc;
    }

    public final void accept(Object obj, Object obj2) {
        zzdc zzdc = this.zza;
        zzdu zzdu = (zzdu) obj;
        zzdc.zzh = new zzez(zzdc, (TaskCompletionSource) obj2);
        if (zzdc.zzu) {
            zzdu.zza().zze(zzdc.zze.zzf(), zzdc.zzc);
        } else {
            zzdu.zza().zza(new zzdt(zzdc.zze.zzf()), (zzdz) zzdc.zzc);
        }
    }
}
