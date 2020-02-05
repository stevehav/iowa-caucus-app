package com.google.android.gms.measurement.internal;

import android.content.Intent;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final /* synthetic */ class zziz implements Runnable {
    private final zziw zza;
    private final int zzb;
    private final zzej zzc;
    private final Intent zzd;

    zziz(zziw zziw, int i, zzej zzej, Intent intent) {
        this.zza = zziw;
        this.zzb = i;
        this.zzc = zzej;
        this.zzd = intent;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd);
    }
}
