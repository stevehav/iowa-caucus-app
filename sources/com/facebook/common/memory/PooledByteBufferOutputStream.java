package com.facebook.common.memory;

import com.facebook.common.internal.Throwables;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PooledByteBufferOutputStream extends OutputStream {
    public abstract int size();

    public abstract PooledByteBuffer toByteBuffer();

    public void close() {
        try {
            super.close();
        } catch (IOException e) {
            Throwables.propagate(e);
        }
    }
}
