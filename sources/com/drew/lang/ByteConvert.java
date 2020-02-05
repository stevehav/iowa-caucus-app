package com.drew.lang;

import com.drew.lang.annotations.NotNull;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;

public class ByteConvert {
    public static int toInt32BigEndian(@NotNull byte[] bArr) {
        return (bArr[3] & UnsignedBytes.MAX_VALUE) | ((bArr[0] << Ascii.CAN) & Ascii.NUL) | ((bArr[1] << Ascii.DLE) & Ascii.NUL) | ((bArr[2] << 8) & Ascii.NUL);
    }

    public static int toInt32LittleEndian(@NotNull byte[] bArr) {
        return ((bArr[3] << Ascii.CAN) & Ascii.NUL) | (bArr[0] & UnsignedBytes.MAX_VALUE) | ((bArr[1] << 8) & Ascii.NUL) | ((bArr[2] << Ascii.DLE) & Ascii.NUL);
    }
}
