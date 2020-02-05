package com.google.android.gms.measurement.internal;

import androidx.annotation.MainThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzje implements Runnable {
    final /* synthetic */ zzjd zza;

    zzje(zzjd zzjd) {
        this.zza = zzjd;
    }

    @MainThread
    public final void run() {
        this.zza.zzq().zza((Runnable) new zzjh(this));
    }
}
