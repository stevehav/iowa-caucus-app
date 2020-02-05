package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhw implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzhu zzb;
    private final /* synthetic */ zzhu zzc;
    private final /* synthetic */ zzhx zzd;

    zzhw(zzhx zzhx, boolean z, zzhu zzhu, zzhu zzhu2) {
        this.zzd = zzhx;
        this.zza = z;
        this.zzb = zzhu;
        this.zzc = zzhu2;
    }

    public final void run() {
        boolean z;
        boolean z2 = false;
        if (this.zzd.zzt().zzr(this.zzd.zzg().zzab())) {
            z = this.zza && this.zzd.zza != null;
            if (z) {
                zzhx zzhx = this.zzd;
                zzhx.zza(zzhx.zza, true);
            }
        } else {
            if (this.zza && this.zzd.zza != null) {
                zzhx zzhx2 = this.zzd;
                zzhx2.zza(zzhx2.zza, true);
            }
            z = false;
        }
        zzhu zzhu = this.zzb;
        if (zzhu == null || zzhu.zzc != this.zzc.zzc || !zzjx.zzd(this.zzb.zzb, this.zzc.zzb) || !zzjx.zzd(this.zzb.zza, this.zzc.zza)) {
            z2 = true;
        }
        if (z2) {
            Bundle bundle = new Bundle();
            zzhx.zza(this.zzc, bundle, true);
            zzhu zzhu2 = this.zzb;
            if (zzhu2 != null) {
                if (zzhu2.zza != null) {
                    bundle.putString("_pn", this.zzb.zza);
                }
                bundle.putString("_pc", this.zzb.zzb);
                bundle.putLong("_pi", this.zzb.zzc);
            }
            if (this.zzd.zzt().zzr(this.zzd.zzg().zzab()) && z) {
                long zzad = this.zzd.zzk().zzad();
                if (zzad > 0) {
                    this.zzd.zzp().zza(bundle, zzad);
                }
            }
            this.zzd.zzf().zzb("auto", "_vs", bundle);
        }
        zzhx zzhx3 = this.zzd;
        zzhx3.zza = this.zzc;
        zzhx3.zzh().zza(this.zzc);
    }
}
