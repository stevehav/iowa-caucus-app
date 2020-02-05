package com.drew.lang;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.SuppressWarnings;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileReader extends RandomAccessReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int _baseOffset;
    private int _currentIndex;
    @NotNull
    private final RandomAccessFile _file;
    private final long _length;

    @SuppressWarnings(justification = "Design intent", value = "EI_EXPOSE_REP2")
    public RandomAccessFileReader(@NotNull RandomAccessFile randomAccessFile) throws IOException {
        this(randomAccessFile, 0);
    }

    @SuppressWarnings(justification = "Design intent", value = "EI_EXPOSE_REP2")
    public RandomAccessFileReader(@NotNull RandomAccessFile randomAccessFile, int i) throws IOException {
        if (randomAccessFile != null) {
            this._file = randomAccessFile;
            this._baseOffset = i;
            this._length = this._file.length();
            return;
        }
        throw new NullPointerException();
    }

    public int toUnshiftedOffset(int i) {
        return i + this._baseOffset;
    }

    public long getLength() {
        return this._length;
    }

    public byte getByte(int i) throws IOException {
        if (i != this._currentIndex) {
            seek(i);
        }
        int read = this._file.read();
        if (read >= 0) {
            this._currentIndex++;
            return (byte) read;
        }
        throw new BufferBoundsException("Unexpected end of file encountered.");
    }

    @NotNull
    public byte[] getBytes(int i, int i2) throws IOException {
        validateIndex(i, i2);
        if (i != this._currentIndex) {
            seek(i);
        }
        byte[] bArr = new byte[i2];
        int read = this._file.read(bArr);
        this._currentIndex += read;
        if (read == i2) {
            return bArr;
        }
        throw new BufferBoundsException("Unexpected end of file encountered.");
    }

    private void seek(int i) throws IOException {
        if (i != this._currentIndex) {
            this._file.seek((long) i);
            this._currentIndex = i;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isValidIndex(int i, int i2) throws IOException {
        return i2 >= 0 && i >= 0 && (((long) i) + ((long) i2)) - 1 < this._length;
    }

    /* access modifiers changed from: protected */
    public void validateIndex(int i, int i2) throws IOException {
        if (!isValidIndex(i, i2)) {
            throw new BufferBoundsException(i, i2, this._length);
        }
    }
}
