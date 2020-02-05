package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhl implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzgt zzb;

    zzhl(zzgt zzgt, boolean z) {
        this.zzb = zzgt;
        this.zza = z;
    }

    public final void run() {
        boolean zzab = this.zzb.zzw.zzab();
        boolean zzaa = this.zzb.zzw.zzaa();
        this.zzb.zzw.zza(this.zza);
        if (zzaa == this.zza) {
            this.zzb.zzw.zzr().zzx().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzw.zzab() == zzab || this.zzb.zzw.zzab() != this.zzb.zzw.zzaa()) {
            this.zzb.zzw.zzr().zzk().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzab));
        }
        this.zzb.zzam();
    }
}
