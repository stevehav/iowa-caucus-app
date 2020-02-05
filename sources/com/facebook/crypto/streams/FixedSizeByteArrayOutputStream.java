package com.facebook.crypto.streams;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class FixedSizeByteArrayOutputStream extends ByteArrayOutputStream {
    public FixedSizeByteArrayOutputStream(int i) {
        super(i);
    }

    public byte[] getBytes() throws IOException {
        if (this.buf.length == this.count) {
            return this.buf;
        }
        throw new IOException("Size supplied is too small");
    }
}
