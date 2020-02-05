package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzjb implements Runnable {
    private final /* synthetic */ zzjp zza;
    private final /* synthetic */ Runnable zzb;

    zzjb(zziw zziw, zzjp zzjp, Runnable runnable) {
        this.zza = zzjp;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzo();
        this.zza.zza(this.zzb);
        this.zza.zzl();
    }
}
