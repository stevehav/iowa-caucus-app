package com.facebook.crypto.streams;

import com.facebook.crypto.mac.NativeMac;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;

public class NativeMacLayeredInputStream extends InputStream {
    private static final String MAC_DOES_NOT_MATCH = "Mac does not match";
    private final TailInputStream mInputDelegate;
    private final NativeMac mMac;
    private boolean mMacChecked = false;

    public boolean markSupported() {
        return false;
    }

    public NativeMacLayeredInputStream(NativeMac nativeMac, InputStream inputStream) {
        this.mMac = nativeMac;
        this.mInputDelegate = new TailInputStream(inputStream, nativeMac.getMacLength());
    }

    public int available() throws IOException {
        return this.mInputDelegate.available();
    }

    public void close() throws IOException {
        try {
            ensureMacValid();
        } finally {
            this.mInputDelegate.close();
        }
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
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

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.mInputDelegate.read(bArr, i, i2);
        if (read == -1) {
            ensureMacValid();
            return -1;
        }
        if (read > 0) {
            this.mMac.update(bArr, i, read);
        }
        return read;
    }

    private void ensureMacValid() throws IOException {
        if (!this.mMacChecked) {
            this.mMacChecked = true;
            try {
                if (!constantTimeEquals(this.mInputDelegate.getTail(), this.mMac.doFinal())) {
                    throw new IOException(MAC_DOES_NOT_MATCH);
                }
            } finally {
                this.mMac.destroy();
            }
        }
    }

    public synchronized void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) throws IOException {
        throw new UnsupportedOperationException();
    }

    private boolean constantTimeEquals(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        byte b = 0;
        for (int i = 0; i < bArr.length; i++) {
            b |= bArr[i] ^ bArr2[i];
        }
        if (b == 0) {
            return true;
        }
        return false;
    }
}
