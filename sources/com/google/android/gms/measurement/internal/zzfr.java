package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzfr implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzfo zzb;

    zzfr(zzfo zzfo, zzn zzn) {
        this.zzb = zzfo;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zza(this.zza);
    }
}
