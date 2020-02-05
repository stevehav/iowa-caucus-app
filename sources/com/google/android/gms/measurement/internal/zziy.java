package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final /* synthetic */ class zziy implements Runnable {
    private final zziw zza;
    private final zzej zzb;
    private final JobParameters zzc;

    zziy(zziw zziw, zzej zzej, JobParameters jobParameters) {
        this.zza = zziw;
        this.zzb = zzej;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
