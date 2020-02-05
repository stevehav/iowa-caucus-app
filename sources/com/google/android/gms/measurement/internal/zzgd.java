package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzgd implements Callable<byte[]> {
    private final /* synthetic */ zzai zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzfo zzc;

    zzgd(zzfo zzfo, zzai zzai, String str) {
        this.zzc = zzfo;
        this.zza = zzai;
        this.zzb = str;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzc.zza.zzo();
        return this.zzc.zza.zzg().zza(this.zza, this.zzb);
    }
}
