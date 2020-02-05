package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final /* synthetic */ class zzgs implements Runnable {
    private final zzgt zza;

    zzgs(zzgt zzgt) {
        this.zza = zzgt;
    }

    public final void run() {
        zzgt zzgt = this.zza;
        zzgt.zzd();
        if (zzgt.zzs().zzu.zza()) {
            zzgt.zzr().zzw().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza2 = zzgt.zzs().zzv.zza();
        zzgt.zzs().zzv.zza(1 + zza2);
        if (zza2 >= 5) {
            zzgt.zzr().zzi().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzgt.zzs().zzu.zza(true);
            return;
        }
        zzgt.zzw.zzah();
    }
}
