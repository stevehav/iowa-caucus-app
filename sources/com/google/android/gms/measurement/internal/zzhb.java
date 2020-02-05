package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhb implements Runnable {
    private final /* synthetic */ zzgo zza;
    private final /* synthetic */ zzgt zzb;

    zzhb(zzgt zzgt, zzgo zzgo) {
        this.zzb = zzgt;
        this.zza = zzgo;
    }

    public final void run() {
        this.zzb.zza(this.zza);
    }
}
