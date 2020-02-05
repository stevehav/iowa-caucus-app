package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzjs implements Callable<String> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ zzjp zzb;

    zzjs(zzjp zzjp, zzn zzn) {
        this.zzb = zzjp;
        this.zza = zzn;
    }

    public final /* synthetic */ Object call() throws Exception {
        zzf zza2 = this.zzb.zze(this.zza);
        if (zza2 != null) {
            return zza2.zzc();
        }
        this.zzb.zzr().zzi().zza("App info was null when attempting to get app instance id");
        return null;
    }
}
