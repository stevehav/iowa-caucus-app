package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzgh implements Runnable {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzfo zzb;

    zzgh(zzfo zzfo, zzn zzn) {
        this.zzb = zzfo;
        this.zza = zzn;
    }

    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zzc(this.zza);
    }
}
