package com.facebook.crypto.streams;

import com.google.common.primitives.UnsignedBytes;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TailInputStream extends FilterInputStream {
    private int mCount;
    private boolean mEOF;
    private final byte[] mTail;
    private final int mTailTength;

    public boolean markSupported() {
        return false;
    }

    protected TailInputStream(InputStream inputStream, int i) {
        super(inputStream);
        this.mTail = new byte[i];
        this.mTailTength = i;
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        while (read == 0) {
            read = read(bArr, 0, 1);
        }
        if (read == -1) {
            return -1;
        }
        return bArr[0] & UnsignedBytes.MAX_VALUE;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.mEOF) {
            return -1;
        }
        int i3 = 0;
        if (i2 == 0) {
            return 0;
        }
        while (i3 == 0) {
            i3 = readTail(bArr, i, i2);
        }
        return i3;
    }

    private int readTail(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.mCount;
        if (i2 >= i3) {
            int read = this.in.read(bArr, this.mCount + i, i2 - i3);
            if (read == -1) {
                this.mEOF = true;
                return -1;
            }
            int i4 = this.mCount;
            if (i4 > 0) {
                System.arraycopy(this.mTail, 0, bArr, i, i4);
            }
            int i5 = this.mCount + read;
            int read2 = this.in.read(this.mTail, 0, this.mTailTength);
            if (read2 == -1) {
                this.mEOF = true;
                read2 = 0;
            }
            return extractTail(bArr, i5, read2, i);
        }
        int i6 = i3 - i2;
        System.arraycopy(this.mTail, 0, bArr, i, i2);
        byte[] bArr2 = this.mTail;
        System.arraycopy(bArr2, i2, bArr2, 0, i6);
        int read3 = this.in.read(this.mTail, i6, this.mTailTength - i6);
        if (read3 != -1) {
            return extractTail(bArr, i2, read3 + i6, i);
        }
        byte[] bArr3 = this.mTail;
        System.arraycopy(bArr3, 0, bArr3, i2, i6);
        System.arraycopy(bArr, i, this.mTail, 0, i2);
        this.mEOF = true;
        return -1;
    }

    private int extractTail(byte[] bArr, int i, int i2, int i3) {
        int i4 = this.mTailTength - i2;
        int max = Math.max(0, i - i4) + i3;
        int min = Math.min(i4, i);
        if (min > 0) {
            if (i2 > 0) {
                byte[] bArr2 = this.mTail;
                System.arraycopy(bArr2, 0, bArr2, min, i2);
            }
            System.arraycopy(bArr, max, this.mTail, 0, min);
        }
        this.mCount = min + i2;
        return max - i3;
    }

    public byte[] getTail() throws IOException {
        if (this.mCount == this.mTailTength) {
            return this.mTail;
        }
        throw new IOException("Not enough tail data");
    }
}
