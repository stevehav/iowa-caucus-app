package com.google.cloud.datastore.core.number;

import com.drew.metadata.exif.ExifDirectoryBase;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.facebook.imageutils.JfifUtil;
import com.google.common.primitives.UnsignedBytes;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class IndexNumberEncoder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int DOUBLE_EXPONENT_BIAS = 1023;
    static final int DOUBLE_MIN_EXPONENT = -1022;
    static final int DOUBLE_SIGNIFICAND_BITS = 52;
    static final long DOUBLE_SIGN_BIT = Long.MIN_VALUE;
    static final int EXP1_END = 4;
    static final int EXP2_END = 20;
    static final int EXP3_END = 148;
    static final int EXP4_END = 1172;
    public static final int MAX_ENCODED_BYTES = 11;
    static final int NEGATIVE_INFINITE_EXPONENT = Integer.MIN_VALUE;
    static final int POSITIVE_INFINITE_EXPONENT = Integer.MAX_VALUE;
    static final int SIGNIFICAND_BITS = 64;

    private static int topSignificandByte(long j) {
        return ((int) (j >>> 56)) & ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE;
    }

    private IndexNumberEncoder() {
    }

    public static int encodeLong(boolean z, long j, byte[] bArr, int i) {
        if (j == 0) {
            return encodeZero(bArr, i);
        }
        if (j < 0) {
            z = !z;
            j = -j;
        }
        boolean z2 = z;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j);
        int i2 = 63 - numberOfLeadingZeros;
        return encodeNumber(z2, i2, (j & ((1 << i2) ^ -1)) << (numberOfLeadingZeros + 1), bArr, i);
    }

    public static int encodeDouble(boolean z, double d, byte[] bArr, int i) {
        long j;
        if (d == 0.0d) {
            return encodeZero(bArr, i);
        }
        long doubleToLongBits = Double.doubleToLongBits(d);
        boolean z2 = (d < 0.0d) ^ z;
        int i2 = ((int) ((doubleToLongBits >>> 52) & 2047)) - DOUBLE_EXPONENT_BIAS;
        long j2 = doubleToLongBits & 4503599627370495L;
        if (i2 < DOUBLE_MIN_EXPONENT) {
            int numberOfLeadingZeros = Long.numberOfLeadingZeros(j2);
            j = (j2 & ((1 << (63 - numberOfLeadingZeros)) ^ -1)) << (numberOfLeadingZeros + 1);
            i2 -= numberOfLeadingZeros - 12;
        } else if (i2 <= DOUBLE_EXPONENT_BIAS) {
            j = j2 << 12;
        } else if (j2 != 0) {
            bArr[i] = 0;
            bArr[i + 1] = 96;
            return 2;
        } else if (z2) {
            bArr[i] = 0;
            bArr[i + 1] = UnsignedBytes.MAX_POWER_OF_TWO;
            return 2;
        } else {
            bArr[i] = -1;
            return 1;
        }
        return encodeNumber(z2, i2, j, bArr, i);
    }

    private static int encodeZero(byte[] bArr, int i) {
        bArr[i] = UnsignedBytes.MAX_POWER_OF_TWO;
        return 1;
    }

    private static int encodeNumber(boolean z, int i, long j, byte[] bArr, int i2) {
        long j2;
        int i3;
        int i4;
        int i5;
        int i6 = 0;
        int i7 = z ? 255 : 0;
        if (i < 0) {
            i = -i;
            i6 = 255;
        }
        if (i < 4) {
            int i8 = i + 1;
            int i9 = 1 << i8;
            i3 = ((i9 - 2) & ((int) (j >>> (64 - i8)))) | i9 | JfifUtil.MARKER_SOFn;
            j2 = j << i;
            if (i6 != 0) {
                i3 ^= (-1 << i8) & 126;
            }
            i4 = i2;
        } else {
            if (i < 20) {
                int i10 = ((i - 4) | CanonMakernoteDirectory.TAG_SENSOR_INFO_ARRAY) ^ ((i6 & 127) ^ i7);
                i4 = i2 + 1;
                bArr[i2] = (byte) i10;
                i5 = topSignificandByte(j);
            } else if (i < 148) {
                int i11 = i - 20;
                int i12 = i2 + 1;
                bArr[i2] = (byte) (((i11 >>> 4) | 240) ^ ((i6 & 127) ^ i7));
                j <<= 4;
                int i13 = (((i11 << 4) & 240) | ((int) (j >>> 60))) ^ ((i6 & 240) ^ i7);
                i4 = i12 + 1;
                bArr[i12] = (byte) i13;
                i5 = topSignificandByte(j);
            } else if (i < EXP4_END) {
                int i14 = i - 148;
                int i15 = i2 + 1;
                bArr[i2] = (byte) ((248 | (i14 >>> 8)) ^ ((i6 & 127) ^ i7));
                int i16 = (i14 & 255) ^ ((i6 & 255) ^ i7);
                i4 = i15 + 1;
                bArr[i15] = (byte) i16;
                i5 = topSignificandByte(j);
            } else {
                throw new IllegalStateException("unimplemented");
            }
            j2 = j << 7;
        }
        while (j2 != 0) {
            bArr[i4] = (byte) ((i3 | 1) ^ i7);
            i3 = topSignificandByte(j2);
            j2 <<= 7;
            i4++;
        }
        bArr[i4] = (byte) (i7 ^ i3);
        return (i4 + 1) - i2;
    }
}
