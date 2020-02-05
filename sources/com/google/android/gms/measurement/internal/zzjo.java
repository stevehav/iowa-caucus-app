package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzjo implements Runnable {
    private final /* synthetic */ zzju zza;
    private final /* synthetic */ zzjp zzb;

    zzjo(zzjp zzjp, zzju zzju) {
        this.zzb = zzjp;
        this.zza = zzju;
    }

    public final void run() {
        this.zzb.zza(this.zza);
        this.zzb.zza();
    }
}
