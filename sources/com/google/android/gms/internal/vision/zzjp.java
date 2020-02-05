package com.google.android.gms.internal.vision;

public final class zzjp implements Cloneable {
    private static final zzjq zzadi = new zzjq();
    private int mSize;
    private boolean zzadj;
    private int[] zzadk;
    private zzjq[] zzadl;

    zzjp() {
        this(10);
    }

    private zzjp(int i) {
        this.zzadj = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.zzadk = new int[idealIntArraySize];
        this.zzadl = new zzjq[idealIntArraySize];
        this.mSize = 0;
    }

    /* access modifiers changed from: package-private */
    public final zzjq zzbw(int i) {
        int zzby = zzby(i);
        if (zzby < 0) {
            return null;
        }
        zzjq[] zzjqArr = this.zzadl;
        if (zzjqArr[zzby] == zzadi) {
            return null;
        }
        return zzjqArr[zzby];
    }

    /* access modifiers changed from: package-private */
    public final void zza(int i, zzjq zzjq) {
        int zzby = zzby(i);
        if (zzby >= 0) {
            this.zzadl[zzby] = zzjq;
            return;
        }
        int i2 = zzby ^ -1;
        if (i2 < this.mSize) {
            zzjq[] zzjqArr = this.zzadl;
            if (zzjqArr[i2] == zzadi) {
                this.zzadk[i2] = i;
                zzjqArr[i2] = zzjq;
                return;
            }
        }
        int i3 = this.mSize;
        if (i3 >= this.zzadk.length) {
            int idealIntArraySize = idealIntArraySize(i3 + 1);
            int[] iArr = new int[idealIntArraySize];
            zzjq[] zzjqArr2 = new zzjq[idealIntArraySize];
            int[] iArr2 = this.zzadk;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            zzjq[] zzjqArr3 = this.zzadl;
            System.arraycopy(zzjqArr3, 0, zzjqArr2, 0, zzjqArr3.length);
            this.zzadk = iArr;
            this.zzadl = zzjqArr2;
        }
        int i4 = this.mSize;
        if (i4 - i2 != 0) {
            int[] iArr3 = this.zzadk;
            int i5 = i2 + 1;
            System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
            zzjq[] zzjqArr4 = this.zzadl;
            System.arraycopy(zzjqArr4, i2, zzjqArr4, i5, this.mSize - i2);
        }
        this.zzadk[i2] = i;
        this.zzadl[i2] = zzjq;
        this.mSize++;
    }

    /* access modifiers changed from: package-private */
    public final int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public final zzjq zzbx(int i) {
        return this.zzadl[i];
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjp)) {
            return false;
        }
        zzjp zzjp = (zzjp) obj;
        int i = this.mSize;
        if (i != zzjp.mSize) {
            return false;
        }
        int[] iArr = this.zzadk;
        int[] iArr2 = zzjp.zzadk;
        int i2 = 0;
        while (true) {
            if (i2 >= i) {
                z = true;
                break;
            } else if (iArr[i2] != iArr2[i2]) {
                z = false;
                break;
            } else {
                i2++;
            }
        }
        if (z) {
            zzjq[] zzjqArr = this.zzadl;
            zzjq[] zzjqArr2 = zzjp.zzadl;
            int i3 = this.mSize;
            int i4 = 0;
            while (true) {
                if (i4 >= i3) {
                    z2 = true;
                    break;
                } else if (!zzjqArr[i4].equals(zzjqArr2[i4])) {
                    z2 = false;
                    break;
                } else {
                    i4++;
                }
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.zzadk[i2]) * 31) + this.zzadl[i2].hashCode();
        }
        return i;
    }

    private static int idealIntArraySize(int i) {
        int i2 = i << 2;
        int i3 = 4;
        while (true) {
            if (i3 >= 32) {
                break;
            }
            int i4 = (1 << i3) - 12;
            if (i2 <= i4) {
                i2 = i4;
                break;
            }
            i3++;
        }
        return i2 / 4;
    }

    private final int zzby(int i) {
        int i2 = this.mSize - 1;
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) >>> 1;
            int i5 = this.zzadk[i4];
            if (i5 < i) {
                i3 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i2 = i4 - 1;
            }
        }
        return i3 ^ -1;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        int i = this.mSize;
        zzjp zzjp = new zzjp(i);
        System.arraycopy(this.zzadk, 0, zzjp.zzadk, 0, i);
        for (int i2 = 0; i2 < i; i2++) {
            zzjq[] zzjqArr = this.zzadl;
            if (zzjqArr[i2] != null) {
                zzjp.zzadl[i2] = (zzjq) zzjqArr[i2].clone();
            }
        }
        zzjp.mSize = i;
        return zzjp;
    }
}
