package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.DataOutput;

@GwtIncompatible
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    void write(int i);

    void write(byte[] bArr);

    void write(byte[] bArr, int i, int i2);

    void writeBoolean(boolean z);

    void writeByte(int i);

    @Deprecated
    void writeBytes(String str);

    void writeChar(int i);

    void writeChars(String str);

    void writeDouble(double d);

    void writeFloat(float f);

    void writeInt(int i);

    void writeLong(long j);

    void writeShort(int i);

    void writeUTF(String str);
}
