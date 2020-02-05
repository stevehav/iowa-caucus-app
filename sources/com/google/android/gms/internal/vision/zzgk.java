package com.google.android.gms.internal.vision;

import java.util.Map;

final class zzgk<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzgi> zzyf;

    private zzgk(Map.Entry<K, zzgi> entry) {
        this.zzyf = entry;
    }

    public final K getKey() {
        return this.zzyf.getKey();
    }

    public final Object getValue() {
        if (this.zzyf.getValue() == null) {
            return null;
        }
        return zzgi.zzfr();
    }

    public final zzgi zzfs() {
        return this.zzyf.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzhf) {
            return this.zzyf.getValue().zzi((zzhf) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
