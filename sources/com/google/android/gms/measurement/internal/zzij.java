package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzij implements Runnable {
    private final /* synthetic */ zzai zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzp zzc;
    private final /* synthetic */ zzhy zzd;

    zzij(zzhy zzhy, zzai zzai, String str, zzp zzp) {
        this.zzd = zzhy;
        this.zza = zzai;
        this.zzb = str;
        this.zzc = zzp;
    }

    public final void run() {
        byte[] bArr = null;
        try {
            zzeb zzd2 = this.zzd.zzb;
            if (zzd2 == null) {
                this.zzd.zzr().zzf().zza("Discarding data. Failed to send event to service to bundle");
                return;
            }
            bArr = zzd2.zza(this.zza, this.zzb);
            this.zzd.zzaj();
            this.zzd.zzp().zza(this.zzc, bArr);
        } catch (RemoteException e) {
            this.zzd.zzr().zzf().zza("Failed to send event to the service to bundle", e);
        } finally {
            this.zzd.zzp().zza(this.zzc, bArr);
        }
    }
}
