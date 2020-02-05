package com.google.android.gms.internal.vision;

import java.util.ListIterator;

final class zzis implements ListIterator<String> {
    private ListIterator<String> zzaav = this.zzaax.zzaau.listIterator(this.zzaaw);
    private final /* synthetic */ int zzaaw;
    private final /* synthetic */ zzir zzaax;

    zzis(zzir zzir, int i) {
        this.zzaax = zzir;
        this.zzaaw = i;
    }

    public final boolean hasNext() {
        return this.zzaav.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzaav.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzaav.nextIndex();
    }

    public final int previousIndex() {
        return this.zzaav.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.zzaav.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zzaav.next();
    }
}
