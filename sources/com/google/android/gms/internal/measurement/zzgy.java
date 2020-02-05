package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzgy {
    private static final zzgy zza = new zzgy();
    private final zzhf zzb = new zzga();
    private final ConcurrentMap<Class<?>, zzhc<?>> zzc = new ConcurrentHashMap();

    public static zzgy zza() {
        return zza;
    }

    public final <T> zzhc<T> zza(Class<T> cls) {
        zzfe.zza(cls, "messageType");
        zzhc<T> zzhc = (zzhc) this.zzc.get(cls);
        if (zzhc != null) {
            return zzhc;
        }
        zzhc<T> zza2 = this.zzb.zza(cls);
        zzfe.zza(cls, "messageType");
        zzfe.zza(zza2, "schema");
        zzhc<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        return putIfAbsent != null ? putIfAbsent : zza2;
    }

    public final <T> zzhc<T> zza(T t) {
        return zza(t.getClass());
    }

    private zzgy() {
    }
}
