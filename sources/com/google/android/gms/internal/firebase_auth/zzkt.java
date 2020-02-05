package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzkt extends AbstractList<String> implements zzir, RandomAccess {
    /* access modifiers changed from: private */
    public final zzir zza;

    public zzkt(zzir zzir) {
        this.zza = zzir;
    }

    public final zzir zze() {
        return this;
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zza(zzgm zzgm) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzkw(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzkv(this);
    }

    public final List<?> zzd() {
        return this.zza.zzd();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
