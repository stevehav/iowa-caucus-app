package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfz extends zzef<Integer> implements zzge<Integer>, zzhr, RandomAccess {
    private static final zzfz zzxl;
    private int size;
    private int[] zzxm;

    zzfz() {
        this(new int[10], 0);
    }

    private zzfz(int[] iArr, int i) {
        this.zzxm = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzcj();
        if (i2 >= i) {
            int[] iArr = this.zzxm;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfz)) {
            return super.equals(obj);
        }
        zzfz zzfz = (zzfz) obj;
        if (this.size != zzfz.size) {
            return false;
        }
        int[] iArr = zzfz.zzxm;
        for (int i = 0; i < this.size; i++) {
            if (this.zzxm[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzxm[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzaf(i);
        return this.zzxm[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzbg(int i) {
        zzq(this.size, i);
    }

    private final void zzq(int i, int i2) {
        int i3;
        zzcj();
        if (i < 0 || i > (i3 = this.size)) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
        int[] iArr = this.zzxm;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[(((i3 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzxm, i, iArr2, i + 1, this.size - i);
            this.zzxm = iArr2;
        }
        this.zzxm[i] = i2;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzcj();
        zzga.checkNotNull(collection);
        if (!(collection instanceof zzfz)) {
            return super.addAll(collection);
        }
        zzfz zzfz = (zzfz) collection;
        int i = zzfz.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzxm;
            if (i3 > iArr.length) {
                this.zzxm = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzfz.zzxm, 0, this.zzxm, this.size, zzfz.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final boolean remove(Object obj) {
        zzcj();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzxm[i]))) {
                int[] iArr = this.zzxm;
                System.arraycopy(iArr, i + 1, iArr, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzaf(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
    }

    private final String zzag(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzcj();
        zzaf(i);
        int[] iArr = this.zzxm;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzcj();
        zzaf(i);
        int[] iArr = this.zzxm;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, i3 - i);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzq(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ zzge zzah(int i) {
        if (i >= this.size) {
            return new zzfz(Arrays.copyOf(this.zzxm, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzfz zzfz = new zzfz();
        zzxl = zzfz;
        zzfz.zzci();
    }
}
