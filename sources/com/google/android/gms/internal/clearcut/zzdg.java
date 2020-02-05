package com.google.android.gms.internal.clearcut;

import java.io.IOException;

public final class zzdg<K, V> {
    static <K, V> int zza(zzdh<K, V> zzdh, K k, V v) {
        return zzby.zza(zzdh.zzmb, 1, k) + zzby.zza(zzdh.zzmd, 2, v);
    }

    static <K, V> void zza(zzbn zzbn, zzdh<K, V> zzdh, K k, V v) throws IOException {
        zzby.zza(zzbn, zzdh.zzmb, 1, k);
        zzby.zza(zzbn, zzdh.zzmd, 2, v);
    }
}
