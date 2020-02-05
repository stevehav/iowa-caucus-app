package com.drew.lang;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.SuppressWarnings;
import java.io.IOException;

public class ByteArrayReader extends RandomAccessReader {
    private final int _baseOffset;
    @NotNull
    private final byte[] _buffer;

    @SuppressWarnings(justification = "Design intent", value = "EI_EXPOSE_REP2")
    public ByteArrayReader(@NotNull byte[] bArr) {
        this(bArr, 0);
    }

    @SuppressWarnings(justification = "Design intent", value = "EI_EXPOSE_REP2")
    public ByteArrayReader(@NotNull byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException();
        } else if (i >= 0) {
            this._buffer = bArr;
            this._baseOffset = i;
        } else {
            throw new IllegalArgumentException("Must be zero or greater");
        }
    }

    public int toUnshiftedOffset(int i) {
        return i + this._baseOffset;
    }

    public long getLength() {
        return (long) (this._buffer.length - this._baseOffset);
    }

    public byte getByte(int i) throws IOException {
        validateIndex(i, 1);
        return this._buffer[i + this._baseOffset];
    }

    /* access modifiers changed from: protected */
    public void validateIndex(int i, int i2) throws IOException {
        if (!isValidIndex(i, i2)) {
            throw new BufferBoundsException(toUnshiftedOffset(i), i2, (long) this._buffer.length);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isValidIndex(int i, int i2) throws IOException {
        return i2 >= 0 && i >= 0 && (((long) i) + ((long) i2)) - 1 < getLength();
    }

    @NotNull
    public byte[] getBytes(int i, int i2) throws IOException {
        validateIndex(i, i2);
        byte[] bArr = new byte[i2];
        System.arraycopy(this._buffer, i + this._baseOffset, bArr, 0, i2);
        return bArr;
    }
}
