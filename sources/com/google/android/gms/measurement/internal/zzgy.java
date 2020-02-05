package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzgy implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzgt zzb;

    zzgy(zzgt zzgt, long j) {
        this.zzb = zzgt;
        this.zza = j;
    }

    public final void run() {
        zzgt zzgt = this.zzb;
        long j = this.zza;
        zzgt.zzd();
        zzgt.zzb();
        zzgt.zzw();
        zzgt.zzr().zzw().zza("Resetting analytics data (FE)");
        zzgt.zzk().zzab();
        if (zzgt.zzt().zzj(zzgt.zzg().zzab())) {
            zzgt.zzs().zzh.zza(j);
        }
        boolean zzab = zzgt.zzw.zzab();
        if (!zzgt.zzt().zzh()) {
            zzgt.zzs().zzd(!zzab);
        }
        zzgt.zzh().zzad();
        zzgt.zzb = !zzab;
        this.zzb.zzh().zza((AtomicReference<String>) new AtomicReference());
    }
}
