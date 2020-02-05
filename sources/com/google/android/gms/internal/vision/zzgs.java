package com.google.android.gms.internal.vision;

import java.util.List;

final class zzgs extends zzgp {
    private zzgs() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        zzge zzd = zzd(obj, j);
        if (zzd.zzch()) {
            return zzd;
        }
        int size = zzd.size();
        zzge zzah = zzd.zzah(size == 0 ? 10 : size << 1);
        zziu.zza(obj, j, (Object) zzah);
        return zzah;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        zzd(obj, j).zzci();
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        zzge zzd = zzd(obj, j);
        zzge zzd2 = zzd(obj2, j);
        int size = zzd.size();
        int size2 = zzd2.size();
        if (size > 0 && size2 > 0) {
            if (!zzd.zzch()) {
                zzd = zzd.zzah(size2 + size);
            }
            zzd.addAll(zzd2);
        }
        if (size > 0) {
            zzd2 = zzd;
        }
        zziu.zza(obj, j, (Object) zzd2);
    }

    private static <E> zzge<E> zzd(Object obj, long j) {
        return (zzge) zziu.zzp(obj, j);
    }
}
