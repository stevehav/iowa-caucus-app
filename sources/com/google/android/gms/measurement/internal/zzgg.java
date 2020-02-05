package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzgg implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzfo zze;

    zzgg(zzfo zzfo, String str, String str2, String str3, long j) {
        this.zze = zzfo;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzs().zzv().zza(this.zzb, (zzhu) null);
            return;
        }
        this.zze.zza.zzs().zzv().zza(this.zzb, new zzhu(this.zzc, str, this.zzd));
    }
}
