package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzih implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zzhy zzc;

    zzih(zzhy zzhy, zzn zzn, boolean z) {
        this.zzc = zzhy;
        this.zza = zzn;
        this.zzb = z;
    }

    public final void run() {
        zzeb zzd = this.zzc.zzb;
        if (zzd == null) {
            this.zzc.zzr().zzf().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzd.zza(this.zza);
            if (this.zzb) {
                this.zzc.zzj().zzad();
            }
            this.zzc.zza(zzd, (AbstractSafeParcelable) null, this.zza);
            this.zzc.zzaj();
        } catch (RemoteException e) {
            this.zzc.zzr().zzf().zza("Failed to send app launch to the service", e);
        }
    }
}
