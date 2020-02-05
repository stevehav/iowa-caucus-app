package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzfs implements Runnable {
    private final /* synthetic */ zzq zza;
    private final /* synthetic */ zzfo zzb;

    zzfs(zzfo zzfo, zzq zzq) {
        this.zzb = zzfo;
        this.zza = zzq;
    }

    public final void run() {
        this.zzb.zza.zzo();
        this.zzb.zza.zzb(this.zza);
    }
}
