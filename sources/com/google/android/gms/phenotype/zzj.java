package com.google.android.gms.phenotype;

import java.util.Comparator;

final class zzj implements Comparator<zzi> {
    zzj() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzi zzi = (zzi) obj;
        zzi zzi2 = (zzi) obj2;
        return zzi.zzah == zzi2.zzah ? zzi.name.compareTo(zzi2.name) : zzi.zzah - zzi2.zzah;
    }
}
