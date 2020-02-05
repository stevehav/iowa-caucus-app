package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

public class DefaultPlacement {
    private final byte[] bits;
    private final CharSequence codewords;
    private final int numcols;
    private final int numrows;

    public DefaultPlacement(CharSequence charSequence, int i, int i2) {
        this.codewords = charSequence;
        this.numcols = i;
        this.numrows = i2;
        this.bits = new byte[(i * i2)];
        Arrays.fill(this.bits, (byte) -1);
    }

    /* access modifiers changed from: package-private */
    public final int getNumrows() {
        return this.numrows;
    }

    /* access modifiers changed from: package-private */
    public final int getNumcols() {
        return this.numcols;
    }

    /* access modifiers changed from: package-private */
    public final byte[] getBits() {
        return this.bits;
    }

    public final boolean getBit(int i, int i2) {
        return this.bits[(i2 * this.numcols) + i] == 1;
    }

    private void setBit(int i, int i2, boolean z) {
        this.bits[(i2 * this.numcols) + i] = z ? (byte) 1 : 0;
    }

    private boolean hasBit(int i, int i2) {
        return this.bits[(i2 * this.numcols) + i] >= 0;
    }

    public final void place() {
        int i;
        int i2;
        int i3 = 4;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i3 == this.numrows && i4 == 0) {
                corner1(i5);
                i5++;
            }
            if (i3 == this.numrows - 2 && i4 == 0 && this.numcols % 4 != 0) {
                corner2(i5);
                i5++;
            }
            if (i3 == this.numrows - 2 && i4 == 0 && this.numcols % 8 == 4) {
                corner3(i5);
                i5++;
            }
            if (i3 == this.numrows + 4 && i4 == 2 && this.numcols % 8 == 0) {
                corner4(i5);
                i5++;
            }
            do {
                if (i3 < this.numrows && i4 >= 0 && !hasBit(i4, i3)) {
                    utah(i3, i4, i5);
                    i5++;
                }
                i3 -= 2;
                i4 += 2;
                if (i3 < 0 || i4 >= this.numcols) {
                    int i6 = i3 + 1;
                    int i7 = i4 + 3;
                }
                utah(i3, i4, i5);
                i5++;
                i3 -= 2;
                i4 += 2;
                break;
            } while (i4 >= this.numcols);
            int i62 = i3 + 1;
            int i72 = i4 + 3;
            do {
                if (i62 >= 0 && i72 < this.numcols && !hasBit(i72, i62)) {
                    utah(i62, i72, i5);
                    i5++;
                }
                i62 += 2;
                i72 -= 2;
                if (i62 >= this.numrows) {
                    break;
                }
            } while (i72 >= 0);
            i3 = i62 + 3;
            i4 = i72 + 1;
            i = this.numrows;
            if (i3 >= i && i4 >= (i2 = this.numcols)) {
                break;
            }
        }
        if (!hasBit(i2 - 1, i - 1)) {
            setBit(this.numcols - 1, this.numrows - 1, true);
            setBit(this.numcols - 2, this.numrows - 2, true);
        }
    }

    private void module(int i, int i2, int i3, int i4) {
        if (i < 0) {
            int i5 = this.numrows;
            i += i5;
            i2 += 4 - ((i5 + 4) % 8);
        }
        if (i2 < 0) {
            int i6 = this.numcols;
            i2 += i6;
            i += 4 - ((i6 + 4) % 8);
        }
        boolean z = true;
        if ((this.codewords.charAt(i3) & (1 << (8 - i4))) == 0) {
            z = false;
        }
        setBit(i2, i, z);
    }

    private void utah(int i, int i2, int i3) {
        int i4 = i - 2;
        int i5 = i2 - 2;
        module(i4, i5, i3, 1);
        int i6 = i2 - 1;
        module(i4, i6, i3, 2);
        int i7 = i - 1;
        module(i7, i5, i3, 3);
        module(i7, i6, i3, 4);
        module(i7, i2, i3, 5);
        module(i, i5, i3, 6);
        module(i, i6, i3, 7);
        module(i, i2, i3, 8);
    }

    private void corner1(int i) {
        module(this.numrows - 1, 0, i, 1);
        module(this.numrows - 1, 1, i, 2);
        module(this.numrows - 1, 2, i, 3);
        module(0, this.numcols - 2, i, 4);
        module(0, this.numcols - 1, i, 5);
        module(1, this.numcols - 1, i, 6);
        module(2, this.numcols - 1, i, 7);
        module(3, this.numcols - 1, i, 8);
    }

    private void corner2(int i) {
        module(this.numrows - 3, 0, i, 1);
        module(this.numrows - 2, 0, i, 2);
        module(this.numrows - 1, 0, i, 3);
        module(0, this.numcols - 4, i, 4);
        module(0, this.numcols - 3, i, 5);
        module(0, this.numcols - 2, i, 6);
        module(0, this.numcols - 1, i, 7);
        module(1, this.numcols - 1, i, 8);
    }

    private void corner3(int i) {
        module(this.numrows - 3, 0, i, 1);
        module(this.numrows - 2, 0, i, 2);
        module(this.numrows - 1, 0, i, 3);
        module(0, this.numcols - 2, i, 4);
        module(0, this.numcols - 1, i, 5);
        module(1, this.numcols - 1, i, 6);
        module(2, this.numcols - 1, i, 7);
        module(3, this.numcols - 1, i, 8);
    }

    private void corner4(int i) {
        module(this.numrows - 1, 0, i, 1);
        module(this.numrows - 1, this.numcols - 1, i, 2);
        module(0, this.numcols - 3, i, 3);
        module(0, this.numcols - 2, i, 4);
        module(0, this.numcols - 1, i, 5);
        module(1, this.numcols - 3, i, 6);
        module(1, this.numcols - 2, i, 7);
        module(1, this.numcols - 1, i, 8);
    }
}
