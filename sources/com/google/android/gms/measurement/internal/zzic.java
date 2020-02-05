package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzic implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhy zzb;

    zzic(zzhy zzhy, zzn zzn) {
        this.zzb = zzhy;
        this.zza = zzn;
    }

    public final void run() {
        zzeb zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service; null service");
            return;
        }
        try {
            zzd.zzd(this.zza);
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to reset data on the service", e);
        }
        this.zzb.zzaj();
    }
}
