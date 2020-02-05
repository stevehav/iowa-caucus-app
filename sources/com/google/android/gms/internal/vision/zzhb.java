package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

final class zzhb implements zzha {
    zzhb() {
    }

    public final Map<?, ?> zzj(Object obj) {
        return (zzgz) obj;
    }

    public final zzgy<?, ?> zzo(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzk(Object obj) {
        return (zzgz) obj;
    }

    public final boolean zzl(Object obj) {
        return !((zzgz) obj).isMutable();
    }

    public final Object zzm(Object obj) {
        ((zzgz) obj).zzci();
        return obj;
    }

    public final Object zzn(Object obj) {
        return zzgz.zzfy().zzfz();
    }

    public final Object zzb(Object obj, Object obj2) {
        zzgz zzgz = (zzgz) obj;
        zzgz zzgz2 = (zzgz) obj2;
        if (!zzgz2.isEmpty()) {
            if (!zzgz.isMutable()) {
                zzgz = zzgz.zzfz();
            }
            zzgz.zza(zzgz2);
        }
        return zzgz;
    }

    public final int zzb(int i, Object obj, Object obj2) {
        zzgz zzgz = (zzgz) obj;
        if (zzgz.isEmpty()) {
            return 0;
        }
        Iterator it = zzgz.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
