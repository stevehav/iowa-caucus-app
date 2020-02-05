package io.grpc.internal;

public interface WritableBuffer {
    int readableBytes();

    void release();

    int writableBytes();

    void write(byte b);

    void write(byte[] bArr, int i, int i2);
}
