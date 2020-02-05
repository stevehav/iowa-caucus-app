package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

final class zzgl<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzyg;

    public zzgl(Iterator<Map.Entry<K, Object>> it) {
        this.zzyg = it;
    }

    public final boolean hasNext() {
        return this.zzyg.hasNext();
    }

    public final void remove() {
        this.zzyg.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzyg.next();
        return next.getValue() instanceof zzgi ? new zzgk(next) : next;
    }
}
