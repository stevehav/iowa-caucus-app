package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzjj implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzjd zzb;

    zzjj(zzjd zzjd, long j) {
        this.zzb = zzjd;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzb(this.zza);
    }
}
