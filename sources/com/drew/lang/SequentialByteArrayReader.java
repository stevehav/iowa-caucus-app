package com.drew.lang;

import com.drew.lang.annotations.NotNull;
import java.io.EOFException;
import java.io.IOException;

public class SequentialByteArrayReader extends SequentialReader {
    @NotNull
    private final byte[] _bytes;
    private int _index;

    public long getPosition() {
        return (long) this._index;
    }

    public SequentialByteArrayReader(@NotNull byte[] bArr) {
        this(bArr, 0);
    }

    public SequentialByteArrayReader(@NotNull byte[] bArr, int i) {
        if (bArr != null) {
            this._bytes = bArr;
            this._index = i;
            return;
        }
        throw new NullPointerException();
    }

    public byte getByte() throws IOException {
        int i = this._index;
        byte[] bArr = this._bytes;
        if (i < bArr.length) {
            this._index = i + 1;
            return bArr[i];
        }
        throw new EOFException("End of data reached.");
    }

    @NotNull
    public byte[] getBytes(int i) throws IOException {
        int i2 = this._index;
        int i3 = i2 + i;
        byte[] bArr = this._bytes;
        if (i3 <= bArr.length) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, i2, bArr2, 0, i);
            this._index += i;
            return bArr2;
        }
        throw new EOFException("End of data reached.");
    }

    public void getBytes(@NotNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = this._index;
        int i4 = i3 + i2;
        byte[] bArr2 = this._bytes;
        if (i4 <= bArr2.length) {
            System.arraycopy(bArr2, i3, bArr, i, i2);
            this._index += i2;
            return;
        }
        throw new EOFException("End of data reached.");
    }

    public void skip(long j) throws IOException {
        if (j >= 0) {
            int i = this._index;
            if (((long) i) + j <= ((long) this._bytes.length)) {
                this._index = (int) (((long) i) + j);
                return;
            }
            throw new EOFException("End of data reached.");
        }
        throw new IllegalArgumentException("n must be zero or greater.");
    }

    public boolean trySkip(long j) throws IOException {
        if (j >= 0) {
            this._index = (int) (((long) this._index) + j);
            int i = this._index;
            byte[] bArr = this._bytes;
            if (i <= bArr.length) {
                return true;
            }
            this._index = bArr.length;
            return false;
        }
        throw new IllegalArgumentException("n must be zero or greater.");
    }

    public int available() {
        return this._bytes.length - this._index;
    }
}
