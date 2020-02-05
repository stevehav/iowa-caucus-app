package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzjc implements zzjd {
    zzjc() {
    }

    public final Map<?, ?> zza(Object obj) {
        return (zzja) obj;
    }

    public final zzjb<?, ?> zzb(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzc(Object obj) {
        return (zzja) obj;
    }

    public final boolean zzd(Object obj) {
        return !((zzja) obj).zzd();
    }

    public final Object zze(Object obj) {
        ((zzja) obj).zzc();
        return obj;
    }

    public final Object zzf(Object obj) {
        return zzja.zza().zzb();
    }

    public final Object zza(Object obj, Object obj2) {
        zzja zzja = (zzja) obj;
        zzja zzja2 = (zzja) obj2;
        if (!zzja2.isEmpty()) {
            if (!zzja.zzd()) {
                zzja = zzja.zzb();
            }
            zzja.zza(zzja2);
        }
        return zzja;
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzja zzja = (zzja) obj;
        if (zzja.isEmpty()) {
            return 0;
        }
        Iterator it = zzja.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
