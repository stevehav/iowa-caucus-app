package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class zzir extends AbstractList<String> implements zzgo, RandomAccess {
    /* access modifiers changed from: private */
    public final zzgo zzaau;

    public zzir(zzgo zzgo) {
        this.zzaau = zzgo;
    }

    public final zzgo zzfu() {
        return this;
    }

    public final Object getRaw(int i) {
        return this.zzaau.getRaw(i);
    }

    public final int size() {
        return this.zzaau.size();
    }

    public final void zzc(zzeo zzeo) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzis(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzit(this);
    }

    public final List<?> zzft() {
        return this.zzaau.zzft();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzaau.get(i);
    }
}
