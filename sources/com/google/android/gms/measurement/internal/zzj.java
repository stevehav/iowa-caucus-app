package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.0.1 */
final class zzj implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ zzai zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzp, zzai zzai, String str) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzp;
        this.zzb = zzai;
        this.zzc = str;
    }

    public final void run() {
        this.zzd.zza.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}
