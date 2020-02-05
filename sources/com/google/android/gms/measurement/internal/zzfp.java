package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzfp implements Runnable {
    private final /* synthetic */ zzgq zza;
    private final /* synthetic */ zzfn zzb;

    zzfp(zzfn zzfn, zzgq zzgq) {
        this.zzb = zzfn;
        this.zza = zzgq;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
