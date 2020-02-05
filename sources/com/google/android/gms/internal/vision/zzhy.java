package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

final class zzhy {
    private static final Class<?> zzaaa = zzgs();
    private static final zzio<?, ?> zzaab = zzk(false);
    private static final zzio<?, ?> zzaac = zzk(true);
    private static final zzio<?, ?> zzaad = new zziq();

    public static void zzg(Class<?> cls) {
        Class<?> cls2;
        if (!zzfy.class.isAssignableFrom(cls) && (cls2 = zzaaa) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zza(int i, List<Double> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzg(i, list, z);
        }
    }

    public static void zzb(int i, List<Float> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzf(i, list, z);
        }
    }

    public static void zzc(int i, List<Long> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzc(i, list, z);
        }
    }

    public static void zzd(int i, List<Long> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzd(i, list, z);
        }
    }

    public static void zze(int i, List<Long> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzn(i, list, z);
        }
    }

    public static void zzf(int i, List<Long> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zze(i, list, z);
        }
    }

    public static void zzg(int i, List<Long> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzl(i, list, z);
        }
    }

    public static void zzh(int i, List<Integer> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zza(i, list, z);
        }
    }

    public static void zzi(int i, List<Integer> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzj(i, list, z);
        }
    }

    public static void zzj(int i, List<Integer> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzm(i, list, z);
        }
    }

    public static void zzk(int i, List<Integer> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzb(i, list, z);
        }
    }

    public static void zzl(int i, List<Integer> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzk(i, list, z);
        }
    }

    public static void zzm(int i, List<Integer> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzh(i, list, z);
        }
    }

    public static void zzn(int i, List<Boolean> list, zzjj zzjj, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzi(i, list, z);
        }
    }

    public static void zza(int i, List<String> list, zzjj zzjj) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zza(i, list);
        }
    }

    public static void zzb(int i, List<zzeo> list, zzjj zzjj) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzb(i, list);
        }
    }

    public static void zza(int i, List<?> list, zzjj zzjj, zzhw zzhw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zza(i, list, zzhw);
        }
    }

    public static void zzb(int i, List<?> list, zzjj zzjj, zzhw zzhw) throws IOException {
        if (list != null && !list.isEmpty()) {
            zzjj.zzb(i, list, zzhw);
        }
    }

    static int zzq(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            i = 0;
            while (i2 < size) {
                i += zzfe.zzh(zzgt.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfe.zzh(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzq(list) + (list.size() * zzfe.zzav(i));
    }

    static int zzr(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            i = 0;
            while (i2 < size) {
                i += zzfe.zzi(zzgt.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfe.zzi(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzr(list) + (size * zzfe.zzav(i));
    }

    static int zzs(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            i = 0;
            while (i2 < size) {
                i += zzfe.zzj(zzgt.getLong(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfe.zzj(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzs(list) + (size * zzfe.zzav(i));
    }

    static int zzt(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            i = 0;
            while (i2 < size) {
                i += zzfe.zzbb(zzfz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfe.zzbb(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzt(list) + (size * zzfe.zzav(i));
    }

    static int zzu(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            i = 0;
            while (i2 < size) {
                i += zzfe.zzaw(zzfz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfe.zzaw(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzu(list) + (size * zzfe.zzav(i));
    }

    static int zzv(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            i = 0;
            while (i2 < size) {
                i += zzfe.zzax(zzfz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfe.zzax(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzv(list) + (size * zzfe.zzav(i));
    }

    static int zzw(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            i = 0;
            while (i2 < size) {
                i += zzfe.zzay(zzfz.getInt(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + zzfe.zzay(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzw(list) + (size * zzfe.zzav(i));
    }

    static int zzx(List<?> list) {
        return list.size() << 2;
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfe.zzl(i, 0);
    }

    static int zzy(List<?> list) {
        return list.size() << 3;
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfe.zzg(i, 0);
    }

    static int zzz(List<?> list) {
        return list.size();
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzfe.zzc(i, true);
    }

    static int zzc(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int zzav = zzfe.zzav(i) * size;
        if (list instanceof zzgo) {
            zzgo zzgo = (zzgo) list;
            while (i4 < size) {
                Object raw = zzgo.getRaw(i4);
                if (raw instanceof zzeo) {
                    i3 = zzfe.zzb((zzeo) raw);
                } else {
                    i3 = zzfe.zzn((String) raw);
                }
                zzav += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof zzeo) {
                    i2 = zzfe.zzb((zzeo) obj);
                } else {
                    i2 = zzfe.zzn((String) obj);
                }
                zzav += i2;
                i4++;
            }
        }
        return zzav;
    }

    static int zzc(int i, Object obj, zzhw zzhw) {
        if (obj instanceof zzgm) {
            return zzfe.zza(i, (zzgm) obj);
        }
        return zzfe.zzb(i, (zzhf) obj, zzhw);
    }

    static int zzc(int i, List<?> list, zzhw zzhw) {
        int i2;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzav = zzfe.zzav(i) * size;
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = list.get(i3);
            if (obj instanceof zzgm) {
                i2 = zzfe.zza((zzgm) obj);
            } else {
                i2 = zzfe.zzb((zzhf) obj, zzhw);
            }
            zzav += i2;
        }
        return zzav;
    }

    static int zzd(int i, List<zzeo> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int zzav = size * zzfe.zzav(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzav += zzfe.zzb(list.get(i2));
        }
        return zzav;
    }

    static int zzd(int i, List<zzhf> list, zzhw zzhw) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += zzfe.zzc(i, list.get(i3), zzhw);
        }
        return i2;
    }

    public static zzio<?, ?> zzgp() {
        return zzaab;
    }

    public static zzio<?, ?> zzgq() {
        return zzaac;
    }

    public static zzio<?, ?> zzgr() {
        return zzaad;
    }

    private static zzio<?, ?> zzk(boolean z) {
        try {
            Class<?> zzgt = zzgt();
            if (zzgt == null) {
                return null;
            }
            return (zzio) zzgt.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzgs() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzgt() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean zzd(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    static <T> void zza(zzha zzha, T t, T t2, long j) {
        zziu.zza((Object) t, j, zzha.zzb(zziu.zzp(t, j), zziu.zzp(t2, j)));
    }

    static <T, FT extends zzfr<FT>> void zza(zzfl<FT> zzfl, T t, T t2) {
        zzfp<FT> zzc = zzfl.zzc(t2);
        if (!zzc.isEmpty()) {
            zzfl.zzd(t).zza(zzc);
        }
    }

    static <T, UT, UB> void zza(zzio<UT, UB> zzio, T t, T t2) {
        zzio.zze(t, zzio.zzg(zzio.zzt(t), zzio.zzt(t2)));
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzgc<?> zzgc, UB ub, zzio<UT, UB> zzio) {
        if (zzgc == null) {
            return ub;
        }
        int size = list.size();
        UB ub2 = ub;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = list.get(i3).intValue();
            if (zzgc.zzf(intValue) != null) {
                if (i3 != i2) {
                    list.set(i2, Integer.valueOf(intValue));
                }
                i2++;
            } else {
                ub2 = zza(i, intValue, ub2, zzio);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzgd zzgd, UB ub, zzio<UT, UB> zzio) {
        UB ub2;
        if (zzgd == null) {
            return ub;
        }
        if (!(list instanceof RandomAccess)) {
            Iterator<Integer> it = list.iterator();
            loop1:
            while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (!zzgd.zzh(intValue)) {
                        ub = zza(i, intValue, ub2, zzio);
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
                if (zzgd.zzh(intValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue2));
                    }
                    i2++;
                } else {
                    ub2 = zza(i, intValue2, ub2, zzio);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        }
        return ub2;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzio<UT, UB> zzio) {
        if (ub == null) {
            ub = zzio.zzhd();
        }
        zzio.zza(ub, i, (long) i2);
        return ub;
    }
}
