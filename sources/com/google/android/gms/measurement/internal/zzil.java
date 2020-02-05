package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzil implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzhy zzb;

    zzil(zzhy zzhy, zzn zzn) {
        this.zzb = zzhy;
        this.zza = zzn;
    }

    public final void run() {
        zzeb zzd = this.zzb.zzb;
        if (zzd == null) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzd.zzb(this.zza);
            this.zzb.zzaj();
        } catch (RemoteException e) {
            this.zzb.zzr().zzf().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
