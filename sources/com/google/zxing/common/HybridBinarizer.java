package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;
import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

public final class HybridBinarizer extends GlobalHistogramBinarizer {
    private static final int BLOCK_SIZE = 8;
    private static final int BLOCK_SIZE_MASK = 7;
    private static final int BLOCK_SIZE_POWER = 3;
    private static final int MINIMUM_DIMENSION = 40;
    private static final int MIN_DYNAMIC_RANGE = 24;
    private BitMatrix matrix;

    private static int cap(int i, int i2, int i3) {
        return i < i2 ? i2 : i > i3 ? i3 : i;
    }

    public HybridBinarizer(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    public BitMatrix getBlackMatrix() throws NotFoundException {
        BitMatrix bitMatrix = this.matrix;
        if (bitMatrix != null) {
            return bitMatrix;
        }
        LuminanceSource luminanceSource = getLuminanceSource();
        int width = luminanceSource.getWidth();
        int height = luminanceSource.getHeight();
        if (width < 40 || height < 40) {
            this.matrix = super.getBlackMatrix();
        } else {
            byte[] matrix2 = luminanceSource.getMatrix();
            int i = width >> 3;
            if ((width & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = height >> 3;
            if ((height & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] calculateBlackPoints = calculateBlackPoints(matrix2, i2, i4, width, height);
            BitMatrix bitMatrix2 = new BitMatrix(width, height);
            calculateThresholdForBlock(matrix2, i2, i4, width, height, calculateBlackPoints, bitMatrix2);
            this.matrix = bitMatrix2;
        }
        return this.matrix;
    }

    public Binarizer createBinarizer(LuminanceSource luminanceSource) {
        return new HybridBinarizer(luminanceSource);
    }

    private static void calculateThresholdForBlock(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, BitMatrix bitMatrix) {
        int i5 = i;
        int i6 = i2;
        int i7 = i4 - 8;
        int i8 = i3 - 8;
        for (int i9 = 0; i9 < i6; i9++) {
            int i10 = i9 << 3;
            int i11 = i10 > i7 ? i7 : i10;
            int cap = cap(i9, 2, i6 - 3);
            for (int i12 = 0; i12 < i5; i12++) {
                int i13 = i12 << 3;
                int i14 = i13 > i8 ? i8 : i13;
                int cap2 = cap(i12, 2, i5 - 3);
                int i15 = 0;
                for (int i16 = -2; i16 <= 2; i16++) {
                    int[] iArr2 = iArr[cap + i16];
                    i15 += iArr2[cap2 - 2] + iArr2[cap2 - 1] + iArr2[cap2] + iArr2[cap2 + 1] + iArr2[cap2 + 2];
                }
                thresholdBlock(bArr, i14, i11, i15 / 25, i3, bitMatrix);
            }
        }
    }

    private static void thresholdBlock(byte[] bArr, int i, int i2, int i3, int i4, BitMatrix bitMatrix) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & UnsignedBytes.MAX_VALUE) <= i3) {
                    bitMatrix.set(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    private static int[][] calculateBlackPoints(byte[] bArr, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        int i9 = 8;
        int i10 = i4 - 8;
        int i11 = i3 - 8;
        int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{i8, i7});
        for (int i12 = 0; i12 < i8; i12++) {
            int i13 = i12 << 3;
            if (i13 > i10) {
                i13 = i10;
            }
            for (int i14 = 0; i14 < i7; i14++) {
                int i15 = i14 << 3;
                if (i15 > i11) {
                    i15 = i11;
                }
                int i16 = (i13 * i3) + i15;
                int i17 = 0;
                int i18 = 0;
                byte b = 0;
                byte b2 = UnsignedBytes.MAX_VALUE;
                while (i6 < i9) {
                    int i19 = i18;
                    int i20 = 0;
                    while (i20 < i9) {
                        byte b3 = bArr[i5 + i20] & UnsignedBytes.MAX_VALUE;
                        i19 += b3;
                        if (b3 < b2) {
                            b2 = b3;
                        }
                        if (b3 > b) {
                            b = b3;
                        }
                        i20++;
                        i9 = 8;
                    }
                    if (b - b2 > 24) {
                        i6++;
                        i5 += i3;
                        i9 = 8;
                        while (i6 < 8) {
                            for (int i21 = 0; i21 < 8; i21++) {
                                i19 += bArr[i5 + i21] & UnsignedBytes.MAX_VALUE;
                            }
                            i6++;
                            i5 += i3;
                        }
                    } else {
                        i9 = 8;
                    }
                    i18 = i19;
                    i17 = i6 + 1;
                    i16 = i5 + i3;
                }
                int i22 = i18 >> 6;
                if (b - b2 <= 24) {
                    i22 = b2 / 2;
                    if (i12 > 0 && i14 > 0) {
                        int i23 = i12 - 1;
                        int i24 = i14 - 1;
                        int i25 = ((iArr[i23][i14] + (iArr[i12][i24] * 2)) + iArr[i23][i24]) / 4;
                        if (b2 < i25) {
                            i22 = i25;
                        }
                    }
                }
                iArr[i12][i14] = i22;
            }
        }
        return iArr;
    }
}
