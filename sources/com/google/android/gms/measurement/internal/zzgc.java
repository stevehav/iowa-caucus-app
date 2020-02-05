package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzgc implements Runnable {
    private final /* synthetic */ zzjw zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzfo zzc;

    zzgc(zzfo zzfo, zzjw zzjw, zzn zzn) {
        this.zzc = zzfo;
        this.zza = zzjw;
        this.zzb = zzn;
    }

    public final void run() {
        this.zzc.zza.zzo();
        this.zzc.zza.zzb(this.zza, this.zzb);
    }
}
