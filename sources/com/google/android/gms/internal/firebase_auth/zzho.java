package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;
import java.io.IOException;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzho extends zzhm<Object> {
    zzho() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzjg zzjg) {
        return zzjg instanceof zzhx.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzhq<Object> zza(Object obj) {
        return ((zzhx.zzd) obj).zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzhq<Object> zzb(Object obj) {
        zzhx.zzd zzd = (zzhx.zzd) obj;
        if (zzd.zzc.zzc()) {
            zzd.zzc = (zzhq) zzd.zzc.clone();
        }
        return zzd.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(Object obj) {
        zza(obj).zzb();
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB zza(zzjx zzjx, Object obj, zzhk zzhk, zzhq<Object> zzhq, UB ub, zzks<UT, UB> zzks) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzll zzll, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final Object zza(zzhk zzhk, zzjg zzjg, int i) {
        return zzhk.zza(zzjg, i);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjx zzjx, Object obj, zzhk zzhk, zzhq<Object> zzhq) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzgm zzgm, Object obj, zzhk zzhk, zzhq<Object> zzhq) throws IOException {
        throw new NoSuchMethodError();
    }
}
