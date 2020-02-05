package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzet implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzeq zzb;

    zzet(zzeq zzeq, boolean z) {
        this.zzb = zzeq;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zza(this.zza);
    }
}
