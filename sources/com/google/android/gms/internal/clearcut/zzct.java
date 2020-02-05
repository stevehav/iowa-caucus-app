package com.google.android.gms.internal.clearcut;

import java.util.Map;

final class zzct<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzcr> zzll;

    private zzct(Map.Entry<K, zzcr> entry) {
        this.zzll = entry;
    }

    public final K getKey() {
        return this.zzll.getKey();
    }

    public final Object getValue() {
        if (this.zzll.getValue() == null) {
            return null;
        }
        return zzcr.zzbr();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzdo) {
            return this.zzll.getValue().zzi((zzdo) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzcr zzbs() {
        return this.zzll.getValue();
    }
}
