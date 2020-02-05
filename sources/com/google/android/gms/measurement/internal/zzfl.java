package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzfl<V> extends FutureTask<V> implements Comparable<zzfl> {
    final boolean zza;
    private final long zzb = zzfg.zzj.getAndIncrement();
    private final String zzc;
    private final /* synthetic */ zzfg zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfl(zzfg zzfg, Callable<V> callable, boolean z, String str) {
        super(callable);
        this.zzd = zzfg;
        Preconditions.checkNotNull(str);
        this.zzc = str;
        this.zza = z;
        if (this.zzb == Long.MAX_VALUE) {
            zzfg.zzr().zzf().zza("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfl(zzfg zzfg, Runnable runnable, boolean z, String str) {
        super(runnable, (Object) null);
        this.zzd = zzfg;
        Preconditions.checkNotNull(str);
        this.zzc = str;
        this.zza = false;
        if (this.zzb == Long.MAX_VALUE) {
            zzfg.zzr().zzf().zza("Tasks index overflow");
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzd.zzr().zzf().zza(this.zzc, th);
        if (th instanceof zzfj) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        zzfl zzfl = (zzfl) obj;
        boolean z = this.zza;
        if (z != zzfl.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzfl.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzr().zzg().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }
}
