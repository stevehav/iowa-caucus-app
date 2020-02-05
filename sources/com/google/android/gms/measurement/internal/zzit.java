package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzit implements Runnable {
    private final /* synthetic */ zzeb zza;
    private final /* synthetic */ zziq zzb;

    zzit(zziq zziq, zzeb zzeb) {
        this.zzb = zziq;
        this.zza = zzeb;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzab()) {
                this.zzb.zza.zzr().zzx().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
