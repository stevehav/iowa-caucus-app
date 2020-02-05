package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

final class zzic extends zzii {
    private final /* synthetic */ zzhz zzaal;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzic(zzhz zzhz) {
        super(zzhz, (zzia) null);
        this.zzaal = zzhz;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzib(this.zzaal, (zzia) null);
    }

    /* synthetic */ zzic(zzhz zzhz, zzia zzia) {
        this(zzhz);
    }
}
