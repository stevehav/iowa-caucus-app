package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

final class zzel extends zzer {
    private final /* synthetic */ zzei zzos;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzel(zzei zzei) {
        super(zzei, (zzej) null);
        this.zzos = zzei;
    }

    /* synthetic */ zzel(zzei zzei, zzej zzej) {
        this(zzei);
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzek(this.zzos, (zzej) null);
    }
}
