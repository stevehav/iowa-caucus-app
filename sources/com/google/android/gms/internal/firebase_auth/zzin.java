package com.google.android.gms.internal.firebase_auth;

import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzin<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzil> zza;

    private zzin(Map.Entry<K, zzil> entry) {
        this.zza = entry;
    }

    public final K getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzil.zza();
    }

    public final zzil zza() {
        return this.zza.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzjg) {
            return this.zza.getValue().zza((zzjg) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
