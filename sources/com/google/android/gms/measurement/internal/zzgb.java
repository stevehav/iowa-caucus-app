package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzgb implements Runnable {
    private final /* synthetic */ zzai zza;
    private final /* synthetic */ zzn zzb;
    private final /* synthetic */ zzfo zzc;

    zzgb(zzfo zzfo, zzai zzai, zzn zzn) {
        this.zzc = zzfo;
        this.zza = zzai;
        this.zzb = zzn;
    }

    public final void run() {
        zzai zzb2 = this.zzc.zzb(this.zza, this.zzb);
        this.zzc.zza.zzo();
        this.zzc.zza.zza(zzb2, this.zzb);
    }
}
