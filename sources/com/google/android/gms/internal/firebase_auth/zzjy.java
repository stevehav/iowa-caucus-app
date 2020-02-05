package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzjy {
    private static final Class<?> zza = zzd();
    private static final zzks<?, ?> zzb = zza(false);
    private static final zzks<?, ?> zzc = zza(true);
    private static final zzks<?, ?> zzd = new zzku();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzhx.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzll zzll, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzll zzll) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzgm> list, zzll zzll) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzll zzll, zzjw zzjw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zza(i, list, zzjw);
        }
    }

    public static void zzb(int i, List<?> list, zzll zzll, zzjw zzjw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzll.zzb(i, list, zzjw);
        }
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzd(zziu.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzhh.zze(i));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zze(zziu.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zze(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzb(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzb(list) + (size * zzhh.zze(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zziu) {
            zziu zziu = (zziu) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzf(zziu.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzf(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzc(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzc(list) + (size * zzhh.zze(i));
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhz) {
            zzhz zzhz = (zzhz) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzk(zzhz.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzk(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzd(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzd(list) + (size * zzhh.zze(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhz) {
            zzhz zzhz = (zzhz) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzf(zzhz.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzf(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zze(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zze(list) + (size * zzhh.zze(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhz) {
            zzhz zzhz = (zzhz) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzg(zzhz.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzg(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzf(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzf(list) + (size * zzhh.zze(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzhz) {
            zzhz zzhz = (zzhz) list;
            i = 0;
            while (i2 < size) {
                i += zzhh.zzh(zzhz.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzhh.zzh(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzg(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzg(list) + (size * zzhh.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhh.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhh.zzg(i, 0);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzhh.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzhh.zze(i) * size;
        if (list instanceof zzir) {
            zzir zzir = (zzir) list;
            while (i4 < size) {
                Object zzb2 = zzir.zzb(i4);
                if (zzb2 instanceof zzgm) {
                    i3 = zzhh.zzb((zzgm) zzb2);
                } else {
                    i3 = zzhh.zzb((String) zzb2);
                }
                zze += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzgm) {
                    i2 = zzhh.zzb((zzgm) obj);
                } else {
                    i2 = zzhh.zzb((String) obj);
                }
                zze += i2;
                i4++;
            }
        }
        return zze;
    }

    static int zza(int i, Object obj, zzjw zzjw) {
        if (obj instanceof zzip) {
            return zzhh.zza(i, (zzip) obj);
        }
        return zzhh.zzb(i, (zzjg) obj, zzjw);
    }

    static int zza(int i, List<?> list, zzjw zzjw) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzhh.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzip) {
                i2 = zzhh.zza((zzip) obj);
            } else {
                i2 = zzhh.zza((zzjg) obj, zzjw);
            }
            zze += i2;
        }
        return zze;
    }

    static int zzb(int i, List<zzgm> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzhh.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzhh.zzb(list.get(i2));
        }
        return zze;
    }

    static int zzb(int i, List<zzjg> list, zzjw zzjw) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzhh.zzc(i, list.get(i3), zzjw);
        }
        return i2;
    }

    public static zzks<?, ?> zza() {
        return zzb;
    }

    public static zzks<?, ?> zzb() {
        return zzc;
    }

    public static zzks<?, ?> zzc() {
        return zzd;
    }

    private static zzks<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzks) zze.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzd() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zze() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zza(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzjd zzjd, T t, T t2, long j) {
        zzky.zza((Object) t, j, zzjd.zza(zzky.zzf(t, j), zzky.zzf(t2, j)));
    }

    static <T, FT extends zzhs<FT>> void zza(zzhm<FT> zzhm, T t, T t2) {
        zzhq<FT> zza2 = zzhm.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzhm.zzb(t).zza(zza2);
        }
    }

    static <T, UT, UB> void zza(zzks<UT, UB> zzks, T t, T t2) {
        zzks.zza((Object) t, zzks.zzc(zzks.zzb(t), zzks.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzic zzic, UB ub, zzks<UT, UB> zzks) {
        UB ub2;
        if (zzic == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (!zzic.zza(intValue)) {
                        ub = zza(i, intValue, ub2, zzks);
                        it.remove();
                    }
                }
                break loop1;
            }
        } else {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue2 = list.get(i3).intValue();
                if (zzic.zza(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zzks);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzks<UT, UB> zzks) {
        if (ub == null) {
            ub = zzks.zza();
        }
        zzks.zza(ub, i, (long) i2);
        return ub;
    }
}
