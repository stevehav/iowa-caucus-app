package com.facebook.crypto.streams;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.IOException;
import java.io.InputStream;

public class NativeGCMCipherInputStream extends InputStream {
    private static final int SKIP_BUFFER_SIZE = 256;
    private final NativeGCMCipher mCipher;
    private final TailInputStream mCipherDelegate;
    private byte[] mSkipBuffer;
    private boolean mTagChecked = false;

    public boolean markSupported() {
        return false;
    }

    public NativeGCMCipherInputStream(InputStream inputStream, NativeGCMCipher nativeGCMCipher, int i) {
        this.mCipherDelegate = new TailInputStream(inputStream, i);
        this.mCipher = nativeGCMCipher;
    }

    public int available() throws IOException {
        return this.mCipherDelegate.available();
    }

    public void close() throws IOException {
        try {
            ensureTagValid();
        } finally {
            this.mCipherDelegate.close();
        }
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public int read() throws IOException {
        throw new UnsupportedOperationException();
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        if (bArr.length >= i3) {
            int read = this.mCipherDelegate.read(bArr, i, i2);
            if (read != -1) {
                return this.mCipher.update(bArr, i, read, bArr, i);
            }
            ensureTagValid();
            return -1;
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    private void ensureTagValid() throws IOException {
        if (!this.mTagChecked) {
            this.mTagChecked = true;
            try {
                byte[] tail = this.mCipherDelegate.getTail();
                this.mCipher.decryptFinal(tail, tail.length);
            } finally {
                this.mCipher.destroy();
            }
        }
    }

    public synchronized void reset() throws IOException {
        throw new UnsupportedOperationException();
    }

    public long skip(long j) throws IOException {
        int read;
        if (this.mSkipBuffer == null) {
            this.mSkipBuffer = new byte[256];
        }
        long j2 = 0;
        while (j > 0 && (read = read(this.mSkipBuffer, 0, (int) Math.min(j, 256))) >= 0) {
            long j3 = (long) read;
            j2 += j3;
            j -= j3;
        }
        if (j2 == 0) {
            return -1;
        }
        return j2;
    }
}
