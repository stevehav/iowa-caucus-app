package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfy;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzfg implements zzjj {
    private final zzfe zzsd;

    public static zzfg zza(zzfe zzfe) {
        if (zzfe.zzss != null) {
            return zzfe.zzss;
        }
        return new zzfg(zzfe);
    }

    private zzfg(zzfe zzfe) {
        this.zzsd = (zzfe) zzga.zza(zzfe, "output");
        this.zzsd.zzss = this;
    }

    public final int zzed() {
        return zzfy.zzg.zzxi;
    }

    public final void zzo(int i, int i2) throws IOException {
        this.zzsd.zzh(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzsd.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzsd.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzsd.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzsd.zza(i, d);
    }

    public final void zzp(int i, int i2) throws IOException {
        this.zzsd.zze(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzsd.zza(i, j);
    }

    public final void zze(int i, int i2) throws IOException {
        this.zzsd.zze(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzsd.zzc(i, j);
    }

    public final void zzh(int i, int i2) throws IOException {
        this.zzsd.zzh(i, i2);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zzsd.zzb(i, z);
    }

    public final void zza(int i, String str) throws IOException {
        this.zzsd.zza(i, str);
    }

    public final void zza(int i, zzeo zzeo) throws IOException {
        this.zzsd.zza(i, zzeo);
    }

    public final void zzf(int i, int i2) throws IOException {
        this.zzsd.zzf(i, i2);
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zzsd.zzg(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzsd.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzhw zzhw) throws IOException {
        this.zzsd.zza(i, (zzhf) obj, zzhw);
    }

    public final void zzb(int i, Object obj, zzhw zzhw) throws IOException {
        zzfe zzfe = this.zzsd;
        zzfe.zzd(i, 3);
        zzhw.zza((zzhf) obj, zzfe.zzss);
        zzfe.zzd(i, 4);
    }

    public final void zzbe(int i) throws IOException {
        this.zzsd.zzd(i, 3);
    }

    public final void zzbf(int i) throws IOException {
        this.zzsd.zzd(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzeo) {
            this.zzsd.zzb(i, (zzeo) obj);
        } else {
            this.zzsd.zzb(i, (zzhf) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzaw(list.get(i4).intValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzar(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzaz(list.get(i4).intValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzau(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzh(list.get(i4).longValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zze(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzi(list.get(i4).longValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zze(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzk(list.get(i4).longValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzg(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzg(list.get(i4).floatValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzf(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzb(list.get(i4).doubleValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzbb(list.get(i4).intValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzar(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zze(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzi(list.get(i4).booleanValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzh(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzgo) {
            zzgo zzgo = (zzgo) list;
            while (i2 < list.size()) {
                Object raw = zzgo.getRaw(i2);
                if (raw instanceof String) {
                    this.zzsd.zza(i, (String) raw);
                } else {
                    this.zzsd.zza(i, (zzeo) raw);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzeo> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzsd.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzax(list.get(i4).intValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzas(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzf(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzba(list.get(i4).intValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzau(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzl(list.get(i4).longValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzg(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzay(list.get(i4).intValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzat(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsd.zzd(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzfe.zzj(list.get(i4).longValue());
            }
            this.zzsd.zzas(i3);
            while (i2 < list.size()) {
                this.zzsd.zzf(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsd.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzhw zzhw) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzhw);
        }
    }

    public final void zzb(int i, List<?> list, zzhw zzhw) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzhw);
        }
    }

    public final <K, V> void zza(int i, zzgy<K, V> zzgy, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzsd.zzd(i, 2);
            this.zzsd.zzas(zzgx.zza(zzgy, next.getKey(), next.getValue()));
            zzgx.zza(this.zzsd, zzgy, next.getKey(), next.getValue());
        }
    }
}
