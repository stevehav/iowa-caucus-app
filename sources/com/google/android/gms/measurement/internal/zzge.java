package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzge implements Callable<List<zzjy>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzfo zzb;

    zzge(zzfo zzfo, zzn zzn) {
        this.zzb = zzfo;
        this.zza = zzn;
    }

    public final /* synthetic */ Object call() throws Exception {
        this.zzb.zza.zzo();
        return this.zzb.zza.zze().zza(this.zza.zza);
    }
}
