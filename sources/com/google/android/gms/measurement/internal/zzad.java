package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzad implements Runnable {
    private final /* synthetic */ zzgl zza;
    private final /* synthetic */ zzaa zzb;

    zzad(zzaa zzaa, zzgl zzgl) {
        this.zzb = zzaa;
        this.zza = zzgl;
    }

    public final void run() {
        this.zza.zzu();
        if (zzr.zza()) {
            this.zza.zzq().zza((Runnable) this);
            return;
        }
        boolean zzb2 = this.zzb.zzb();
        long unused = this.zzb.zzd = 0;
        if (zzb2) {
            this.zzb.zza();
        }
    }
}
