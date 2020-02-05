package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzp;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzir implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzn zzd;
    private final /* synthetic */ zzp zze;
    private final /* synthetic */ zzhy zzf;

    zzir(zzhy zzhy, String str, String str2, boolean z, zzn zzn, zzp zzp) {
        this.zzf = zzhy;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = zzn;
        this.zze = zzp;
    }

    public final void run() {
        Bundle bundle = new Bundle();
        try {
            zzeb zzd2 = this.zzf.zzb;
            if (zzd2 == null) {
                this.zzf.zzr().zzf().zza("Failed to get user properties", this.zza, this.zzb);
                return;
            }
            bundle = zzjx.zza(zzd2.zza(this.zza, this.zzb, this.zzc, this.zzd));
            this.zzf.zzaj();
            this.zzf.zzp().zza(this.zze, bundle);
        } catch (RemoteException e) {
            this.zzf.zzr().zzf().zza("Failed to get user properties", this.zza, e);
        } finally {
            this.zzf.zzp().zza(this.zze, bundle);
        }
    }
}
