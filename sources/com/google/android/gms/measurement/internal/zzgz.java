package com.google.android.gms.measurement.internal;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzgz implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzgt zzb;

    zzgz(zzgt zzgt, AtomicReference atomicReference) {
        this.zzb = zzgt;
        this.zza = atomicReference;
    }

    public final void run() {
        this.zzb.zzh().zza((AtomicReference<String>) this.zza);
    }
}
