package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzjh implements Runnable {
    private final /* synthetic */ zzje zza;

    zzjh(zzje zzje) {
        this.zza = zzje;
    }

    public final void run() {
        zzjd zzjd = this.zza.zza;
        zzjd.zzd();
        zzjd.zzr().zzw().zza("Application backgrounded");
        zzjd.zzf().zzb("auto", "_ab", new Bundle());
    }
}
