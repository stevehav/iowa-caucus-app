package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
abstract class zzfx {
    private static final zzfx zza = new zzfz();
    private static final zzfx zzb = new zzfy();

    private zzfx() {
    }

    /* access modifiers changed from: package-private */
    public abstract <L> List<L> zza(Object obj, long j);

    /* access modifiers changed from: package-private */
    public abstract <L> void zza(Object obj, Object obj2, long j);

    /* access modifiers changed from: package-private */
    public abstract void zzb(Object obj, long j);

    static zzfx zza() {
        return zza;
    }

    static zzfx zzb() {
        return zzb;
    }
}
