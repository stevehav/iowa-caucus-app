package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzbc implements Iterator {
    private final int limit = this.zzfl.size();
    private int position = 0;
    private final /* synthetic */ zzbb zzfl;

    zzbc(zzbb zzbb) {
        this.zzfl = zzbb;
    }

    private final byte nextByte() {
        try {
            zzbb zzbb = this.zzfl;
            int i = this.position;
            this.position = i + 1;
            return zzbb.zzj(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
