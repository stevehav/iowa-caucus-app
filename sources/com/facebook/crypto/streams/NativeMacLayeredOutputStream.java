package com.facebook.crypto.streams;

import com.facebook.crypto.mac.NativeMac;
import java.io.IOException;
import java.io.OutputStream;

public class NativeMacLayeredOutputStream extends OutputStream {
    private final NativeMac mMac;
    private boolean mMacAppended = false;
    private final OutputStream mOutputDelegate;

    public NativeMacLayeredOutputStream(NativeMac nativeMac, OutputStream outputStream) {
        this.mMac = nativeMac;
        this.mOutputDelegate = outputStream;
    }

    public void close() throws IOException {
        try {
            appendMac();
        } finally {
            this.mOutputDelegate.close();
        }
    }

    private void appendMac() throws IOException {
        if (!this.mMacAppended) {
            this.mMacAppended = true;
            try {
                this.mOutputDelegate.write(this.mMac.doFinal());
            } finally {
                this.mMac.destroy();
            }
        }
    }

    public void flush() throws IOException {
        this.mOutputDelegate.flush();
    }

    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.mMac.update(bArr, i, i2);
        this.mOutputDelegate.write(bArr, i, i2);
    }

    public void write(int i) throws IOException {
        this.mMac.update((byte) i);
        this.mOutputDelegate.write(i);
    }
}
