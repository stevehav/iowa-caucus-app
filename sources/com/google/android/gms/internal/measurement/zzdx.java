package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzdx implements Comparator<zzdv> {
    zzdx() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzdv zzdv = (zzdv) obj;
        zzdv zzdv2 = (zzdv) obj2;
        zzea zzea = (zzea) zzdv.iterator();
        zzea zzea2 = (zzea) zzdv2.iterator();
        while (zzea.hasNext() && zzea2.hasNext()) {
            int compare = Integer.compare(zzdv.zzb(zzea.zza()), zzdv.zzb(zzea2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzdv.zza(), zzdv2.zza());
    }
}
