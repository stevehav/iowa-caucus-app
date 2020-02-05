package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhc implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ String zzd;
    private final /* synthetic */ zzgt zze;

    zzhc(zzgt zzgt, AtomicReference atomicReference, String str, String str2, String str3) {
        this.zze = zzgt;
        this.zza = atomicReference;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final void run() {
        this.zze.zzw.zzw().zza((AtomicReference<List<zzq>>) this.zza, this.zzb, this.zzc, this.zzd);
    }
}
