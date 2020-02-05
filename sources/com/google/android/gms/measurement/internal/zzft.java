package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzft implements Runnable {
    private final /* synthetic */ zzq zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzfo zzc;

    zzft(zzfo zzfo, zzq zzq, zzn zzn) {
        this.zzc = zzfo;
        this.zza = zzq;
        this.zzb = zzn;
    }

    public final void run() {
        this.zzc.zza.zzo();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
