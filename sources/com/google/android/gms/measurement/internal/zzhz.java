package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhz implements Runnable {
    private final /* synthetic */ zzhu zza;
    private final /* synthetic */ zzhx zzb;

    zzhz(zzhx zzhx, zzhu zzhu) {
        this.zzb = zzhx;
        this.zza = zzhu;
    }

    public final void run() {
        this.zzb.zza(this.zza, false);
        zzhx zzhx = this.zzb;
        zzhx.zza = null;
        zzhx.zzh().zza((zzhu) null);
    }
}
