package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhw extends zzhu<zzhx, zzhx> {
    zzhw() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzhd zzhd) {
        return false;
    }

    private static void zza(Object obj, zzhx zzhx) {
        ((zzfd) obj).zzb = zzhx;
    }

    /* access modifiers changed from: package-private */
    public final void zzd(Object obj) {
        ((zzfd) obj).zzb.zzc();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zzf(Object obj) {
        return ((zzhx) obj).zze();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ int zze(Object obj) {
        return ((zzhx) obj).zzd();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj, Object obj2) {
        zzhx zzhx = (zzhx) obj;
        zzhx zzhx2 = (zzhx) obj2;
        if (zzhx2.equals(zzhx.zza())) {
            return zzhx;
        }
        return zzhx.zza(zzhx, zzhx2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, zzir zzir) throws IOException {
        ((zzhx) obj).zza(zzir);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzir zzir) throws IOException {
        ((zzhx) obj).zzb(zzir);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, Object obj2) {
        zza(obj, (zzhx) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzc(Object obj) {
        zzhx zzhx = ((zzfd) obj).zzb;
        if (zzhx != zzhx.zza()) {
            return zzhx;
        }
        zzhx zzb = zzhx.zzb();
        zza(obj, zzb);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzb(Object obj) {
        return ((zzfd) obj).zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* bridge */ /* synthetic */ void zza(Object obj, Object obj2) {
        zza(obj, (zzhx) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza(Object obj) {
        zzhx zzhx = (zzhx) obj;
        zzhx.zzc();
        return zzhx;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zza() {
        return zzhx.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, Object obj2) {
        ((zzhx) obj).zza((i << 3) | 3, (Object) (zzhx) obj2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, zzdv zzdv) {
        ((zzhx) obj).zza((i << 3) | 2, (Object) zzdv);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Object obj, int i, long j) {
        ((zzhx) obj).zza((i << 3) | 1, (Object) Long.valueOf(j));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, int i2) {
        ((zzhx) obj).zza((i << 3) | 5, (Object) Integer.valueOf(i2));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, int i, long j) {
        ((zzhx) obj).zza(i << 3, (Object) Long.valueOf(j));
    }
}
