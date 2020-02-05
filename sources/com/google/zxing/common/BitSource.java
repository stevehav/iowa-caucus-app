package com.google.zxing.common;

import com.google.common.primitives.UnsignedBytes;

public final class BitSource {
    private int bitOffset;
    private int byteOffset;
    private final byte[] bytes;

    public BitSource(byte[] bArr) {
        this.bytes = bArr;
    }

    public int getBitOffset() {
        return this.bitOffset;
    }

    public int getByteOffset() {
        return this.byteOffset;
    }

    public int readBits(int i) {
        byte b;
        if (i <= 0 || i > 32 || i > available()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.bitOffset;
        if (i2 > 0) {
            int i3 = 8 - i2;
            int i4 = i < i3 ? i : i3;
            int i5 = i3 - i4;
            byte[] bArr = this.bytes;
            int i6 = this.byteOffset;
            b = (((255 >> (8 - i4)) << i5) & bArr[i6]) >> i5;
            i -= i4;
            this.bitOffset += i4;
            if (this.bitOffset == 8) {
                this.bitOffset = 0;
                this.byteOffset = i6 + 1;
            }
        } else {
            b = 0;
        }
        if (i <= 0) {
            return b;
        }
        while (i >= 8) {
            byte[] bArr2 = this.bytes;
            int i7 = this.byteOffset;
            b = (b << 8) | (bArr2[i7] & UnsignedBytes.MAX_VALUE);
            this.byteOffset = i7 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return b;
        }
        int i8 = 8 - i;
        int i9 = (b << i) | ((((255 >> i8) << i8) & this.bytes[this.byteOffset]) >> i8);
        this.bitOffset += i;
        return i9;
    }

    public int available() {
        return ((this.bytes.length - this.byteOffset) * 8) - this.bitOffset;
    }
}
