package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzku extends zzks<zzkr, zzkr> {
    zzku() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzjx zzjx) {
        return false;
    }

    private static void zza(Object obj, zzkr zzkr) {
        ((zzhx) obj).zzb = zzkr;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object obj) {
        ((zzhx) obj).zzb.zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzf(Object obj) {
        return ((zzkr) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zze(Object obj) {
        return ((zzkr) obj).zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj, Object obj2) {
        zzkr zzkr = (zzkr) obj;
        zzkr zzkr2 = (zzkr) obj2;
        if (zzkr2.equals(zzkr.zza())) {
            return zzkr;
        }
        return zzkr.zza(zzkr, zzkr2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, zzll zzll) throws IOException {
        ((zzkr) obj).zza(zzll);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzll zzll) throws IOException {
        ((zzkr) obj).zzb(zzll);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzkr) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        zzkr zzkr = ((zzhx) obj).zzb;
        if (zzkr != zzkr.zza()) {
            return zzkr;
        }
        zzkr zzb = zzkr.zzb();
        zza(obj, zzb);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzb(Object obj) {
        return ((zzhx) obj).zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Object obj2) {
        zza(obj, (zzkr) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        zzkr zzkr = (zzkr) obj;
        zzkr.zzc();
        return zzkr;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza() {
        return zzkr.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzkr) obj).zza((i << 3) | 3, (Object) (zzkr) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzgm zzgm) {
        ((zzkr) obj).zza((i << 3) | 2, (Object) zzgm);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzkr) obj).zza((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzkr) obj).zza((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzkr) obj).zza(i << 3, (Object) Long.valueOf(j));
    }
}
