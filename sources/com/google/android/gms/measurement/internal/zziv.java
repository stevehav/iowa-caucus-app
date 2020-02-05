package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zziv implements Runnable {
    private final /* synthetic */ zzeb zza;
    private final /* synthetic */ zziq zzb;

    zziv(zziq zziq, zzeb zzeb) {
        this.zzb = zziq;
        this.zza = zzeb;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzw().zza("Connected to remote service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
