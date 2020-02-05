package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhi extends zzho {
    private final /* synthetic */ zzhh zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzhi(zzhh zzhh) {
        super(zzhh, (zzhg) null);
        this.zza = zzhh;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzhj(this.zza, (zzhg) null);
    }

    /* synthetic */ zzhi(zzhh zzhh, zzhg zzhg) {
        this(zzhh);
    }
}
