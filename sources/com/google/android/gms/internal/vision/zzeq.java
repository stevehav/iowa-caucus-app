package com.google.android.gms.internal.vision;

import java.util.Comparator;

final class zzeq implements Comparator<zzeo> {
    zzeq() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzeo zzeo = (zzeo) obj;
        zzeo zzeo2 = (zzeo) obj2;
        zzeu zzeu = (zzeu) zzeo.iterator();
        zzeu zzeu2 = (zzeu) zzeo2.iterator();
        while (zzeu.hasNext() && zzeu2.hasNext()) {
            int compare = Integer.compare(zzeo.zza(zzeu.nextByte()), zzeo.zza(zzeu2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzeo.size(), zzeo2.size());
    }
}
