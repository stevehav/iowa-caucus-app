package com.facebook.crypto.streams;

import com.facebook.crypto.cipher.NativeGCMCipher;
import java.io.IOException;
import java.io.OutputStream;

public class NativeGCMCipherOutputStream extends OutputStream {
    private static final int DEFAULT_ENCRYPT_BUFFER_SIZE = 256;
    private final NativeGCMCipher mCipher;
    private final OutputStream mCipherDelegate;
    private final byte[] mTag;
    private boolean mTagAppended = false;
    private final byte[] mUpdateBuffer;
    private final int mUpdateBufferChunkSize;

    public NativeGCMCipherOutputStream(OutputStream outputStream, NativeGCMCipher nativeGCMCipher, byte[] bArr, int i) {
        this.mCipherDelegate = outputStream;
        this.mCipher = nativeGCMCipher;
        this.mTag = new byte[i];
        int cipherBlockSize = this.mCipher.getCipherBlockSize();
        if (bArr == null) {
            bArr = new byte[(cipherBlockSize + 256)];
        } else {
            int i2 = cipherBlockSize + 1;
            if (bArr.length < i2) {
                throw new IllegalArgumentException("encryptBuffer cannot be smaller than " + i2 + "B");
            }
        }
        this.mUpdateBufferChunkSize = bArr.length - cipherBlockSize;
        this.mUpdateBuffer = bArr;
    }

    public void close() throws IOException {
        try {
            appendTag();
        } finally {
            this.mCipherDelegate.close();
        }
    }

    private void appendTag() throws IOException {
        if (!this.mTagAppended) {
            this.mTagAppended = true;
            try {
                this.mCipher.encryptFinal(this.mTag, this.mTag.length);
                this.mCipherDelegate.write(this.mTag);
            } finally {
                this.mCipher.destroy();
            }
        }
    }

    public void flush() throws IOException {
        this.mCipherDelegate.flush();
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = i + i2;
        if (bArr.length >= i3) {
            int i4 = this.mUpdateBufferChunkSize;
            int i5 = i2 / i4;
            int i6 = i2 % i4;
            int i7 = i;
            for (int i8 = 0; i8 < i5; i8++) {
                this.mCipherDelegate.write(this.mUpdateBuffer, 0, this.mCipher.update(bArr, i7, this.mUpdateBufferChunkSize, this.mUpdateBuffer, 0));
                i7 += this.mUpdateBufferChunkSize;
            }
            if (i6 > 0) {
                this.mCipherDelegate.write(this.mUpdateBuffer, 0, this.mCipher.update(bArr, i7, i6, this.mUpdateBuffer, 0));
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException(i3);
    }

    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }
}
