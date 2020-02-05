package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhn implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzgt zzb;

    zzhn(zzgt zzgt, long j) {
        this.zzb = zzgt;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs().zzl.zza(this.zza);
        this.zzb.zzr().zzw().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
