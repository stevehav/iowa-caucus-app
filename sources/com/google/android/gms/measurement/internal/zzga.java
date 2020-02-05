package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzga implements Runnable {
    private final /* synthetic */ zzai zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzfo zzc;

    zzga(zzfo zzfo, zzai zzai, String str) {
        this.zzc = zzfo;
        this.zza = zzai;
        this.zzb = str;
    }

    public final void run() {
        this.zzc.zza.zzo();
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
