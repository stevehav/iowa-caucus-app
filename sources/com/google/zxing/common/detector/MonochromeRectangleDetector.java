package com.google.zxing.common.detector;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;

@Deprecated
public final class MonochromeRectangleDetector {
    private static final int MAX_MODULES = 32;
    private final BitMatrix image;

    public MonochromeRectangleDetector(BitMatrix bitMatrix) {
        this.image = bitMatrix;
    }

    public ResultPoint[] detect() throws NotFoundException {
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = height / 2;
        int i2 = width / 2;
        int max = Math.max(1, height / 256);
        int i3 = -max;
        int i4 = i2 / 2;
        int i5 = i2;
        int i6 = width;
        int i7 = i;
        int i8 = i3;
        int i9 = height;
        int i10 = max;
        int max2 = Math.max(1, width / 256);
        int i11 = -max2;
        int y = ((int) findCornerFromCenter(i5, 0, 0, i6, i7, i3, 0, i9, i4).getY()) - 1;
        int i12 = max2;
        int i13 = i / 2;
        ResultPoint findCornerFromCenter = findCornerFromCenter(i5, i11, 0, i6, i7, 0, y, i9, i13);
        int x = ((int) findCornerFromCenter.getX()) - 1;
        ResultPoint findCornerFromCenter2 = findCornerFromCenter(i5, i12, x, i6, i7, 0, y, i9, i13);
        int x2 = ((int) findCornerFromCenter2.getX()) + 1;
        ResultPoint findCornerFromCenter3 = findCornerFromCenter(i5, 0, x, x2, i7, i10, y, i9, i4);
        return new ResultPoint[]{findCornerFromCenter(i5, 0, x, x2, i7, i8, y, ((int) findCornerFromCenter3.getY()) + 1, i2 / 4), findCornerFromCenter, findCornerFromCenter2, findCornerFromCenter3};
    }

    private ResultPoint findCornerFromCenter(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) throws NotFoundException {
        int[] iArr;
        int i10 = i;
        int i11 = i5;
        int i12 = i10;
        int i13 = i11;
        int[] iArr2 = null;
        int i14 = i8;
        while (i13 < i14 && i13 >= i7 && i12 < i4 && i12 >= i3) {
            if (i2 == 0) {
                iArr = blackWhiteRange(i13, i9, i3, i4, true);
            } else {
                iArr = blackWhiteRange(i12, i9, i7, i8, false);
            }
            if (iArr != null) {
                i13 += i6;
                i12 += i2;
                iArr2 = iArr;
            } else if (iArr2 != null) {
                char c = 1;
                if (i2 == 0) {
                    int i15 = i13 - i6;
                    if (iArr2[0] >= i10) {
                        return new ResultPoint((float) iArr2[1], (float) i15);
                    }
                    if (iArr2[1] <= i10) {
                        return new ResultPoint((float) iArr2[0], (float) i15);
                    }
                    if (i6 > 0) {
                        c = 0;
                    }
                    return new ResultPoint((float) iArr2[c], (float) i15);
                }
                int i16 = i12 - i2;
                if (iArr2[0] >= i11) {
                    return new ResultPoint((float) i16, (float) iArr2[1]);
                }
                if (iArr2[1] <= i11) {
                    return new ResultPoint((float) i16, (float) iArr2[0]);
                }
                float f = (float) i16;
                if (i2 < 0) {
                    c = 0;
                }
                return new ResultPoint(f, (float) iArr2[c]);
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private int[] blackWhiteRange(int i, int i2, int i3, int i4, boolean z) {
        int i5 = (i3 + i4) / 2;
        int i6 = i5;
        while (i6 >= i3) {
            if (!z ? !this.image.get(i, i6) : !this.image.get(i6, i)) {
                int i7 = i6;
                while (true) {
                    i7--;
                    if (i7 < i3) {
                        break;
                    } else if (z) {
                        if (this.image.get(i7, i)) {
                            break;
                        }
                    } else if (this.image.get(i, i7)) {
                        break;
                    }
                }
                int i8 = i6 - i7;
                if (i7 < i3 || i8 > i2) {
                    break;
                }
                i6 = i7;
            } else {
                i6--;
            }
        }
        int i9 = i6 + 1;
        while (i5 < i4) {
            if (!z ? !this.image.get(i, i5) : !this.image.get(i5, i)) {
                int i10 = i5;
                while (true) {
                    i10++;
                    if (i10 >= i4) {
                        break;
                    } else if (z) {
                        if (this.image.get(i10, i)) {
                            break;
                        }
                    } else if (this.image.get(i, i10)) {
                        break;
                    }
                }
                int i11 = i10 - i5;
                if (i10 >= i4 || i11 > i2) {
                    break;
                }
                i5 = i10;
            } else {
                i5++;
            }
        }
        int i12 = i5 - 1;
        if (i12 <= i9) {
            return null;
        }
        return new int[]{i9, i12};
    }
}
