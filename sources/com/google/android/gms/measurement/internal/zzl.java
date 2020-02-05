package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzp;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@17.0.1 */
final class zzl implements Runnable {
    private final /* synthetic */ zzp zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    zzl(AppMeasurementDynamiteService appMeasurementDynamiteService, zzp zzp, String str, String str2) {
        this.zzd = appMeasurementDynamiteService;
        this.zza = zzp;
        this.zzb = str;
        this.zzc = str2;
    }

    public final void run() {
        this.zzd.zza.zzw().zza(this.zza, this.zzb, this.zzc);
    }
}
