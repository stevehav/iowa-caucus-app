package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzbj<K> extends zzbg<K> {
    private final transient zzbe<K, ?> zza;
    private final transient zzaz<K> zzb;

    zzbj(zzbe<K, ?> zzbe, zzaz<K> zzaz) {
        this.zza = zzbe;
        this.zzb = zzaz;
    }

    public final zzbo<K> zzb() {
        return (zzbo) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    public final zzaz<K> zzc() {
        return this.zzb;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final int size() {
        return this.zza.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
