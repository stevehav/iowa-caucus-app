package com.google.android.gms.internal.vision;

import java.io.IOException;

final class zziq extends zzio<zzip, zzip> {
    zziq() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzhv zzhv) {
        return false;
    }

    private static void zza(Object obj, zzip zzip) {
        ((zzfy) obj).zzwj = zzip;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        ((zzfy) obj).zzwj.zzci();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzp(Object obj) {
        return ((zzip) obj).zzeq();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzv(Object obj) {
        return ((zzip) obj).zzhg();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzg(Object obj, Object obj2) {
        zzip zzip = (zzip) obj;
        zzip zzip2 = (zzip) obj2;
        if (zzip2.equals(zzip.zzhe())) {
            return zzip;
        }
        return zzip.zza(zzip, zzip2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, zzjj zzjj) throws IOException {
        ((zzip) obj).zza(zzjj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzjj zzjj) throws IOException {
        ((zzip) obj).zzb(zzjj);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Object obj, Object obj2) {
        zza(obj, (zzip) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzu(Object obj) {
        zzip zzip = ((zzfy) obj).zzwj;
        if (zzip != zzip.zzhe()) {
            return zzip;
        }
        zzip zzhf = zzip.zzhf();
        zza(obj, zzhf);
        return zzhf;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzt(Object obj) {
        return ((zzfy) obj).zzwj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(Object obj, Object obj2) {
        zza(obj, (zzip) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzm(Object obj) {
        zzip zzip = (zzip) obj;
        zzip.zzci();
        return zzip;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzhd() {
        return zzip.zzhf();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzip) obj).zzb((i << 3) | 3, (zzip) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzeo zzeo) {
        ((zzip) obj).zzb((i << 3) | 2, zzeo);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzip) obj).zzb((i << 3) | 1, Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(Object obj, int i, int i2) {
        ((zzip) obj).zzb((i << 3) | 5, Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzip) obj).zzb(i << 3, Long.valueOf(j));
    }
}
