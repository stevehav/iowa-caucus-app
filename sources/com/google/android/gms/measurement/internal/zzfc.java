package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzfc implements Runnable {
    private final /* synthetic */ zzfn zza;
    private final /* synthetic */ zzej zzb;

    zzfc(zzfd zzfd, zzfn zzfn, zzej zzej) {
        this.zza = zzfn;
        this.zzb = zzej;
    }

    public final void run() {
        if (this.zza.zzf() == null) {
            this.zzb.zzf().zza("Install Referrer Reporter is null");
            return;
        }
        zzey zzf = this.zza.zzf();
        zzf.zza.zzad();
        zzf.zza(zzf.zza.zzn().getPackageName());
    }
}
