package com.google.android.gms.internal.firebase_auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzjs {
    private static final zzjs zza = new zzjs();
    private final zzjz zzb = new zzix();
    private final ConcurrentMap<Class<?>, zzjw<?>> zzc = new ConcurrentHashMap();

    public static zzjs zza() {
        return zza;
    }

    public final <T> zzjw<T> zza(Class<T> cls) {
        zzib.zza(cls, "messageType");
        zzjw<T> zzjw = (zzjw) this.zzc.get(cls);
        if (zzjw != null) {
            return zzjw;
        }
        zzjw<T> zza2 = this.zzb.zza(cls);
        zzib.zza(cls, "messageType");
        zzib.zza(zza2, "schema");
        zzjw<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        return putIfAbsent != null ? putIfAbsent : zza2;
    }

    public final <T> zzjw<T> zza(T t) {
        return zza(t.getClass());
    }

    private zzjs() {
    }
}
