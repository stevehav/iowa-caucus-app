package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzfi implements Thread.UncaughtExceptionHandler {
    private final String zza;
    private final /* synthetic */ zzfg zzb;

    public zzfi(zzfg zzfg, String str) {
        this.zzb = zzfg;
        Preconditions.checkNotNull(str);
        this.zza = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzb.zzr().zzf().zza(this.zza, th);
    }
}
