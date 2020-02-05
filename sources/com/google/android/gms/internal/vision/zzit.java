package com.google.android.gms.internal.vision;

import java.util.Iterator;

final class zzit implements Iterator<String> {
    private final /* synthetic */ zzir zzaax;
    private Iterator<String> zzaay = this.zzaax.zzaau.iterator();

    zzit(zzir zzir) {
        this.zzaax = zzir;
    }

    public final boolean hasNext() {
        return this.zzaay.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzaay.next();
    }
}
