package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzjk extends zzaa {
    private final /* synthetic */ zzjp zza;
    private final /* synthetic */ zzjl zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzjk(zzjl zzjl, zzgl zzgl, zzjp zzjp) {
        super(zzgl);
        this.zzb = zzjl;
        this.zza = zzjp;
    }

    public final void zza() {
        this.zzb.zzf();
        this.zzb.zzr().zzx().zza("Starting upload from DelayedRunnable");
        this.zza.zzl();
    }
}
