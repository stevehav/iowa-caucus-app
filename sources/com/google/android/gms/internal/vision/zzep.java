package com.google.android.gms.internal.vision;

import java.util.NoSuchElementException;

final class zzep implements zzeu {
    private final int limit = this.zzsa.size();
    private int position = 0;
    private final /* synthetic */ zzeo zzsa;

    zzep(zzeo zzeo) {
        this.zzsa = zzeo;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        try {
            zzeo zzeo = this.zzsa;
            int i = this.position;
            this.position = i + 1;
            return zzeo.zzai(i);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return Byte.valueOf(nextByte());
    }
}
