package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhi implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzgt zzb;

    zzhi(zzgt zzgt, boolean z) {
        this.zzb = zzgt;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzd(this.zza);
    }
}
