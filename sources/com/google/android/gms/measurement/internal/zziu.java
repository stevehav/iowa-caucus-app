package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zziu implements Runnable {
    private final /* synthetic */ zziq zza;

    zziu(zziq zziq) {
        this.zza = zziq;
    }

    public final void run() {
        zzhy zzhy = this.zza.zza;
        Context zzn = this.zza.zza.zzn();
        this.zza.zza.zzu();
        zzhy.zza(new ComponentName(zzn, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
