package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.0.1 */
final class zzk implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzp) {
        this.zzb = appMeasurementDynamiteService;
        this.zza = zzp;
    }

    public final void run() {
        this.zzb.zza.zzi().zza(this.zza, this.zzb.zza.zzaa());
    }
}
