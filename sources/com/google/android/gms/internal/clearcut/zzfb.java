package com.google.android.gms.internal.clearcut;

import java.util.ListIterator;

final class zzfb implements ListIterator<String> {
    private ListIterator<String> zzpc = this.zzpe.zzpb.listIterator(this.zzpd);
    private final /* synthetic */ int zzpd;
    private final /* synthetic */ zzfa zzpe;

    zzfb(zzfa zzfa, int i) {
        this.zzpe = zzfa;
        this.zzpd = i;
    }

    public final /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasNext() {
        return this.zzpc.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzpc.hasPrevious();
    }

    public final /* synthetic */ Object next() {
        return this.zzpc.next();
    }

    public final int nextIndex() {
        return this.zzpc.nextIndex();
    }

    public final /* synthetic */ Object previous() {
        return this.zzpc.previous();
    }

    public final int previousIndex() {
        return this.zzpc.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
