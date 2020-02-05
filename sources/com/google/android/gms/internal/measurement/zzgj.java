package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzgj implements zzgg {
    zzgj() {
    }

    public final Map<?, ?> zza(Object obj) {
        return (zzgh) obj;
    }

    public final zzge<?, ?> zzf(Object obj) {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzb(Object obj) {
        return (zzgh) obj;
    }

    public final boolean zzc(Object obj) {
        return !((zzgh) obj).zzd();
    }

    public final Object zzd(Object obj) {
        ((zzgh) obj).zzc();
        return obj;
    }

    public final Object zze(Object obj) {
        return zzgh.zza().zzb();
    }

    public final Object zza(Object obj, Object obj2) {
        zzgh zzgh = (zzgh) obj;
        zzgh zzgh2 = (zzgh) obj2;
        if (!zzgh2.isEmpty()) {
            if (!zzgh.zzd()) {
                zzgh = zzgh.zzb();
            }
            zzgh.zza(zzgh2);
        }
        return zzgh;
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzgh zzgh = (zzgh) obj;
        if (zzgh.isEmpty()) {
            return 0;
        }
        Iterator it = zzgh.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
