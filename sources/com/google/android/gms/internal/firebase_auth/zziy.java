package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zziy<K, V> {
    static <K, V> void zza(zzhh zzhh, zzjb<K, V> zzjb, K k, V v) throws IOException {
        zzhq.zza(zzhh, zzjb.zza, 1, k);
        zzhq.zza(zzhh, zzjb.zzc, 2, v);
    }

    static <K, V> int zza(zzjb<K, V> zzjb, K k, V v) {
        return zzhq.zza(zzjb.zza, 1, k) + zzhq.zza(zzjb.zzc, 2, v);
    }
}
