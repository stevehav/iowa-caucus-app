package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzbk extends zzaz<Map.Entry<K, V>> {
    private final /* synthetic */ zzbh zza;

    zzbk(zzbh zzbh) {
        this.zza = zzbh;
    }

    public final int size() {
        return this.zza.zzd;
    }

    public final /* synthetic */ Object get(int i) {
        zzao.zza(i, this.zza.zzd);
        Object[] zzb = this.zza.zzb;
        int i2 = i * 2;
        zzbh zzbh = this.zza;
        Object obj = zzb[i2];
        Object[] zzb2 = zzbh.zzb;
        zzbh zzbh2 = this.zza;
        return new AbstractMap.SimpleImmutableEntry(obj, zzb2[i2 + 1]);
    }
}
