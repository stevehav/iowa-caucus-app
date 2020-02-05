package com.drew.lang;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.StringValue;
import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public abstract class RandomAccessReader {
    private boolean _isMotorolaByteOrder = true;

    public abstract byte getByte(int i) throws IOException;

    @NotNull
    public abstract byte[] getBytes(int i, int i2) throws IOException;

    public abstract long getLength() throws IOException;

    /* access modifiers changed from: protected */
    public abstract boolean isValidIndex(int i, int i2) throws IOException;

    public abstract int toUnshiftedOffset(int i);

    /* access modifiers changed from: protected */
    public abstract void validateIndex(int i, int i2) throws IOException;

    public void setMotorolaByteOrder(boolean z) {
        this._isMotorolaByteOrder = z;
    }

    public boolean isMotorolaByteOrder() {
        return this._isMotorolaByteOrder;
    }

    public boolean getBit(int i) throws IOException {
        int i2 = i / 8;
        validateIndex(i2, 1);
        if (((getByte(i2) >> (i % 8)) & 1) == 1) {
            return true;
        }
        return false;
    }

    public short getUInt8(int i) throws IOException {
        validateIndex(i, 1);
        return (short) (getByte(i) & UnsignedBytes.MAX_VALUE);
    }

    public byte getInt8(int i) throws IOException {
        validateIndex(i, 1);
        return getByte(i);
    }

    public int getUInt16(int i) throws IOException {
        byte b;
        byte b2;
        validateIndex(i, 2);
        if (this._isMotorolaByteOrder) {
            b = (getByte(i) << 8) & Ascii.NUL;
            b2 = getByte(i + 1);
        } else {
            b = (getByte(i + 1) << 8) & Ascii.NUL;
            b2 = getByte(i);
        }
        return (b2 & UnsignedBytes.MAX_VALUE) | b;
    }

    public short getInt16(int i) throws IOException {
        short s;
        byte b;
        validateIndex(i, 2);
        if (this._isMotorolaByteOrder) {
            s = (((short) getByte(i)) << 8) & -256;
            b = getByte(i + 1);
        } else {
            s = (((short) getByte(i + 1)) << 8) & -256;
            b = getByte(i);
        }
        return (short) ((((short) b) & 255) | s);
    }

    public int getInt24(int i) throws IOException {
        byte b;
        byte b2;
        validateIndex(i, 3);
        if (this._isMotorolaByteOrder) {
            b = ((getByte(i) << Ascii.DLE) & Ascii.NUL) | (65280 & (getByte(i + 1) << 8));
            b2 = getByte(i + 2);
        } else {
            b = ((getByte(i + 2) << Ascii.DLE) & Ascii.NUL) | (65280 & (getByte(i + 1) << 8));
            b2 = getByte(i);
        }
        return (b2 & UnsignedBytes.MAX_VALUE) | b;
    }

    public long getUInt32(int i) throws IOException {
        long j;
        byte b;
        validateIndex(i, 4);
        if (this._isMotorolaByteOrder) {
            long j2 = 4278190080L & (((long) getByte(i)) << 24);
            j = (65280 & (((long) getByte(i + 2)) << 8)) | (16711680 & (((long) getByte(i + 1)) << 16)) | j2;
            b = getByte(i + 3);
        } else {
            long j3 = 4278190080L & (((long) getByte(i + 3)) << 24);
            j = (65280 & (((long) getByte(i + 1)) << 8)) | (16711680 & (((long) getByte(i + 2)) << 16)) | j3;
            b = getByte(i);
        }
        return (255 & ((long) b)) | j;
    }

    public int getInt32(int i) throws IOException {
        byte b;
        byte b2;
        validateIndex(i, 4);
        if (this._isMotorolaByteOrder) {
            b = ((getByte(i) << Ascii.CAN) & Ascii.NUL) | (16711680 & (getByte(i + 1) << Ascii.DLE)) | (65280 & (getByte(i + 2) << 8));
            b2 = getByte(i + 3);
        } else {
            b = ((getByte(i + 3) << Ascii.CAN) & Ascii.NUL) | (16711680 & (getByte(i + 2) << Ascii.DLE)) | (65280 & (getByte(i + 1) << 8));
            b2 = getByte(i);
        }
        return (b2 & UnsignedBytes.MAX_VALUE) | b;
    }

    public long getInt64(int i) throws IOException {
        long j;
        byte b;
        int i2 = i;
        validateIndex(i2, 8);
        if (this._isMotorolaByteOrder) {
            j = ((((long) getByte(i)) << 56) & -72057594037927936L) | (71776119061217280L & (((long) getByte(i2 + 1)) << 48)) | (280375465082880L & (((long) getByte(i2 + 2)) << 40)) | (1095216660480L & (((long) getByte(i2 + 3)) << 32)) | ((((long) getByte(i2 + 4)) << 24) & 4278190080L) | ((((long) getByte(i2 + 5)) << 16) & 16711680) | ((((long) getByte(i2 + 6)) << 8) & 65280);
            b = getByte(i2 + 7);
        } else {
            j = ((((long) getByte(i2 + 7)) << 56) & -72057594037927936L) | (71776119061217280L & (((long) getByte(i2 + 6)) << 48)) | (280375465082880L & (((long) getByte(i2 + 5)) << 40)) | (1095216660480L & (((long) getByte(i2 + 4)) << 32)) | ((((long) getByte(i2 + 3)) << 24) & 4278190080L) | ((((long) getByte(i2 + 2)) << 16) & 16711680) | ((((long) getByte(i2 + 1)) << 8) & 65280);
            b = getByte(i);
        }
        return j | (((long) b) & 255);
    }

    public float getS15Fixed16(int i) throws IOException {
        double d;
        double d2;
        validateIndex(i, 4);
        if (this._isMotorolaByteOrder) {
            byte b = (getByte(i + 3) & UnsignedBytes.MAX_VALUE) | ((getByte(i + 2) & UnsignedBytes.MAX_VALUE) << 8);
            d = (double) ((float) (((getByte(i) & UnsignedBytes.MAX_VALUE) << 8) | (getByte(i + 1) & UnsignedBytes.MAX_VALUE)));
            double d3 = (double) b;
            Double.isNaN(d3);
            d2 = d3 / 65536.0d;
            Double.isNaN(d);
        } else {
            byte b2 = (getByte(i) & UnsignedBytes.MAX_VALUE) | ((getByte(i + 1) & UnsignedBytes.MAX_VALUE) << 8);
            d = (double) ((float) (((getByte(i + 3) & UnsignedBytes.MAX_VALUE) << 8) | (getByte(i + 2) & UnsignedBytes.MAX_VALUE)));
            double d4 = (double) b2;
            Double.isNaN(d4);
            d2 = d4 / 65536.0d;
            Double.isNaN(d);
        }
        return (float) (d + d2);
    }

    public float getFloat32(int i) throws IOException {
        return Float.intBitsToFloat(getInt32(i));
    }

    public double getDouble64(int i) throws IOException {
        return Double.longBitsToDouble(getInt64(i));
    }

    @NotNull
    public StringValue getStringValue(int i, int i2, @Nullable Charset charset) throws IOException {
        return new StringValue(getBytes(i, i2), charset);
    }

    @NotNull
    public String getString(int i, int i2, @NotNull Charset charset) throws IOException {
        return new String(getBytes(i, i2), charset.name());
    }

    @NotNull
    public String getString(int i, int i2, @NotNull String str) throws IOException {
        byte[] bytes = getBytes(i, i2);
        try {
            return new String(bytes, str);
        } catch (UnsupportedEncodingException unused) {
            return new String(bytes);
        }
    }

    @NotNull
    public String getNullTerminatedString(int i, int i2, @NotNull Charset charset) throws IOException {
        return new String(getNullTerminatedBytes(i, i2), charset.name());
    }

    @NotNull
    public StringValue getNullTerminatedStringValue(int i, int i2, @Nullable Charset charset) throws IOException {
        return new StringValue(getNullTerminatedBytes(i, i2), charset);
    }

    @NotNull
    public byte[] getNullTerminatedBytes(int i, int i2) throws IOException {
        byte[] bytes = getBytes(i, i2);
        int i3 = 0;
        while (i3 < bytes.length && bytes[i3] != 0) {
            i3++;
        }
        if (i3 == i2) {
            return bytes;
        }
        byte[] bArr = new byte[i3];
        if (i3 > 0) {
            System.arraycopy(bytes, 0, bArr, 0, i3);
        }
        return bArr;
    }
}
