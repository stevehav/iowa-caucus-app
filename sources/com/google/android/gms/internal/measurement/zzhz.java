package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzhz extends AbstractList<String> implements zzfu, RandomAccess {
    /* access modifiers changed from: private */
    public final zzfu zza;

    public zzhz(zzfu zzfu) {
        this.zza = zzfu;
    }

    public final zzfu i_() {
        return this;
    }

    public final Object zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int size() {
        return this.zza.size();
    }

    public final void zza(zzdv zzdv) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzhy(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzib(this);
    }

    public final List<?> zzb() {
        return this.zza.zzb();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zza.get(i);
    }
}
