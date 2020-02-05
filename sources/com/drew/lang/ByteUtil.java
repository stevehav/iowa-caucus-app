package com.drew.lang;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

public class ByteUtil {
    public static int getInt16(byte[] bArr, int i, boolean z) {
        int i2;
        int i3;
        if (z) {
            i2 = (bArr[i] & UnsignedBytes.MAX_VALUE) << 8;
            i3 = bArr[i + 1] & UnsignedBytes.MAX_VALUE;
        } else {
            i2 = bArr[i] & UnsignedBytes.MAX_VALUE;
            i3 = (bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8;
        }
        return i3 | i2;
    }

    public static int getInt32(byte[] bArr, int i, boolean z) {
        byte b;
        int i2;
        if (z) {
            b = ((bArr[i] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 8);
            i2 = bArr[i + 3] & UnsignedBytes.MAX_VALUE;
        } else {
            b = (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
            i2 = (bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN;
        }
        return i2 | b;
    }

    public static long getLong64(byte[] bArr, int i, boolean z) {
        byte b;
        int i2;
        if (z) {
            b = ((bArr[i] & UnsignedBytes.MAX_VALUE) << 56) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 48) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << 40) | ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << 32) | ((bArr[i + 4] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i + 5] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i + 6] & UnsignedBytes.MAX_VALUE) << 8);
            i2 = bArr[i + 7] & UnsignedBytes.MAX_VALUE;
        } else {
            b = (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE) | ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | ((bArr[i + 4] & UnsignedBytes.MAX_VALUE) << 32) | ((bArr[i + 5] & UnsignedBytes.MAX_VALUE) << 40) | ((bArr[i + 6] & UnsignedBytes.MAX_VALUE) << 48);
            i2 = (bArr[i + 7] & UnsignedBytes.MAX_VALUE) << 56;
        }
        return (long) (i2 | b);
    }
}
