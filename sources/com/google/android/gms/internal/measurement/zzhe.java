package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhe {
    private static final Class<?> zza = zzd();
    private static final zzhu<?, ?> zzb = zza(false);
    private static final zzhu<?, ?> zzc = zza(true);
    private static final zzhu<?, ?> zzd = new zzhw();

    public static void zza(Class<?> cls) {
        Class<?> cls2;
        if (!zzfd.class.isAssignableFrom(cls) && (cls2 = zza) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzir zzir, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzir zzir) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzdv> list, zzir zzir) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzir zzir, zzhc zzhc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zza(i, list, zzhc);
        }
    }

    public static void zzb(int i, List<?> list, zzir zzir, zzhc zzhc) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzir.zzb(i, list, zzhc);
        }
    }

    static int zza(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgb) {
            zzgb zzgb = (zzgb) list;
            i = 0;
            while (i2 < size) {
                i += zzek.zzd(zzgb.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzek.zzd(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zza(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zza(list) + (list.size() * zzek.zze(i));
    }

    static int zzb(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgb) {
            zzgb zzgb = (zzgb) list;
            i = 0;
            while (i2 < size) {
                i += zzek.zze(zzgb.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzek.zze(list.get(i2).longValue());
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
        return zzb(list) + (size * zzek.zze(i));
    }

    static int zzc(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgb) {
            zzgb zzgb = (zzgb) list;
            i = 0;
            while (i2 < size) {
                i += zzek.zzf(zzgb.zzb(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzek.zzf(list.get(i2).longValue());
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
        return zzc(list) + (size * zzek.zze(i));
    }

    static int zzd(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzek.zzk(zzff.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzek.zzk(list.get(i2).intValue());
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
        return zzd(list) + (size * zzek.zze(i));
    }

    static int zze(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzek.zzf(zzff.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzek.zzf(list.get(i2).intValue());
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
        return zze(list) + (size * zzek.zze(i));
    }

    static int zzf(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzek.zzg(zzff.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzek.zzg(list.get(i2).intValue());
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
        return zzf(list) + (size * zzek.zze(i));
    }

    static int zzg(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            i = 0;
            while (i2 < size) {
                i += zzek.zzh(zzff.zzc(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzek.zzh(list.get(i2).intValue());
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
        return zzg(list) + (size * zzek.zze(i));
    }

    static int zzh(List<?> list) {
        return list.size() << 2;
    }

    static int zzh(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzek.zzi(i, 0);
    }

    static int zzi(List<?> list) {
        return list.size() << 3;
    }

    static int zzi(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzek.zzg(i, 0);
    }

    static int zzj(List<?> list) {
        return list.size();
    }

    static int zzj(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzek.zzb(i, true);
    }

    static int zza(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zze = zzek.zze(i) * size;
        if (list instanceof zzfu) {
            zzfu zzfu = (zzfu) list;
            while (i4 < size) {
                Object zzb2 = zzfu.zzb(i4);
                if (zzb2 instanceof zzdv) {
                    i3 = zzek.zzb((zzdv) zzb2);
                } else {
                    i3 = zzek.zzb((String) zzb2);
                }
                zze += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzdv) {
                    i2 = zzek.zzb((zzdv) obj);
                } else {
                    i2 = zzek.zzb((String) obj);
                }
                zze += i2;
                i4++;
            }
        }
        return zze;
    }

    static int zza(int i, Object obj, zzhc zzhc) {
        if (obj instanceof zzfs) {
            return zzek.zza(i, (zzfs) obj);
        }
        return zzek.zzb(i, (zzgn) obj, zzhc);
    }

    static int zza(int i, List<?> list, zzhc zzhc) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = zzek.zze(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzfs) {
                i2 = zzek.zza((zzfs) obj);
            } else {
                i2 = zzek.zza((zzgn) obj, zzhc);
            }
            zze += i2;
        }
        return zze;
    }

    static int zzb(int i, List<zzdv> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zze = size * zzek.zze(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zze += zzek.zzb(list.get(i2));
        }
        return zze;
    }

    static int zzb(int i, List<zzgn> list, zzhc zzhc) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzek.zzc(i, list.get(i3), zzhc);
        }
        return i2;
    }

    public static zzhu<?, ?> zza() {
        return zzb;
    }

    public static zzhu<?, ?> zzb() {
        return zzc;
    }

    public static zzhu<?, ?> zzc() {
        return zzd;
    }

    private static zzhu<?, ?> zza(boolean z) {
        try {
            Class<?> zze = zze();
            if (zze == null) {
                return null;
            }
            return (zzhu) zze.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
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

    static <T> void zza(zzgg zzgg, T t, T t2, long j) {
        zzia.zza((Object) t, j, zzgg.zza(zzia.zzf(t, j), zzia.zzf(t2, j)));
    }

    static <T, FT extends zzev<FT>> void zza(zzes<FT> zzes, T t, T t2) {
        zzet<FT> zza2 = zzes.zza((Object) t2);
        if (!zza2.zza.isEmpty()) {
            zzes.zzb(t).zza(zza2);
        }
    }

    static <T, UT, UB> void zza(zzhu<UT, UB> zzhu, T t, T t2) {
        zzhu.zza((Object) t, zzhu.zzc(zzhu.zzb(t), zzhu.zzb(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzfj zzfj, UB ub, zzhu<UT, UB> zzhu) {
        UB ub2;
        if (zzfj == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (!zzfj.zza(intValue)) {
                        ub = zza(i, intValue, ub2, zzhu);
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
                if (zzfj.zza(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zzhu);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzhu<UT, UB> zzhu) {
        if (ub == null) {
            ub = zzhu.zza();
        }
        zzhu.zza(ub, i, (long) i2);
        return ub;
    }
}
