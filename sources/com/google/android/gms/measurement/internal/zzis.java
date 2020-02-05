package com.google.android.gms.measurement.internal;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzis implements Runnable {
    private final /* synthetic */ ComponentName zza;
    private final /* synthetic */ zziq zzb;

    zzis(zziq zziq, ComponentName componentName) {
        this.zzb = zziq;
        this.zza = componentName;
    }

    public final void run() {
        this.zzb.zza.zza(this.zza);
    }
}
