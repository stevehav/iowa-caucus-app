package io.grpc.internal;

import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import io.grpc.KnownLength;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class ReadableBuffers {
    private static final ReadableBuffer EMPTY_BUFFER = new ByteArrayWrapper(new byte[0]);

    public static ReadableBuffer empty() {
        return EMPTY_BUFFER;
    }

    public static ReadableBuffer wrap(byte[] bArr) {
        return new ByteArrayWrapper(bArr, 0, bArr.length);
    }

    public static ReadableBuffer wrap(byte[] bArr, int i, int i2) {
        return new ByteArrayWrapper(bArr, i, i2);
    }

    public static ReadableBuffer wrap(ByteBuffer byteBuffer) {
        return new ByteReadableBufferWrapper(byteBuffer);
    }

    public static byte[] readArray(ReadableBuffer readableBuffer) {
        Preconditions.checkNotNull(readableBuffer, "buffer");
        int readableBytes = readableBuffer.readableBytes();
        byte[] bArr = new byte[readableBytes];
        readableBuffer.readBytes(bArr, 0, readableBytes);
        return bArr;
    }

    public static String readAsString(ReadableBuffer readableBuffer, Charset charset) {
        Preconditions.checkNotNull(charset, "charset");
        return new String(readArray(readableBuffer), charset);
    }

    public static String readAsStringUtf8(ReadableBuffer readableBuffer) {
        return readAsString(readableBuffer, Charsets.UTF_8);
    }

    public static InputStream openStream(ReadableBuffer readableBuffer, boolean z) {
        if (!z) {
            readableBuffer = ignoreClose(readableBuffer);
        }
        return new BufferInputStream(readableBuffer);
    }

    public static ReadableBuffer ignoreClose(ReadableBuffer readableBuffer) {
        return new ForwardingReadableBuffer(readableBuffer) {
            public void close() {
            }
        };
    }

    private static class ByteArrayWrapper extends AbstractReadableBuffer {
        final byte[] bytes;
        final int end;
        int offset;

        public boolean hasArray() {
            return true;
        }

        ByteArrayWrapper(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        ByteArrayWrapper(byte[] bArr, int i, int i2) {
            boolean z = true;
            Preconditions.checkArgument(i >= 0, "offset must be >= 0");
            Preconditions.checkArgument(i2 >= 0, "length must be >= 0");
            int i3 = i2 + i;
            Preconditions.checkArgument(i3 > bArr.length ? false : z, "offset + length exceeds array boundary");
            this.bytes = (byte[]) Preconditions.checkNotNull(bArr, "bytes");
            this.offset = i;
            this.end = i3;
        }

        public int readableBytes() {
            return this.end - this.offset;
        }

        public void skipBytes(int i) {
            checkReadable(i);
            this.offset += i;
        }

        public int readUnsignedByte() {
            checkReadable(1);
            byte[] bArr = this.bytes;
            int i = this.offset;
            this.offset = i + 1;
            return bArr[i] & UnsignedBytes.MAX_VALUE;
        }

        public void readBytes(byte[] bArr, int i, int i2) {
            System.arraycopy(this.bytes, this.offset, bArr, i, i2);
            this.offset += i2;
        }

        public void readBytes(ByteBuffer byteBuffer) {
            Preconditions.checkNotNull(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            checkReadable(remaining);
            byteBuffer.put(this.bytes, this.offset, remaining);
            this.offset += remaining;
        }

        public void readBytes(OutputStream outputStream, int i) throws IOException {
            checkReadable(i);
            outputStream.write(this.bytes, this.offset, i);
            this.offset += i;
        }

        public ByteArrayWrapper readBytes(int i) {
            checkReadable(i);
            int i2 = this.offset;
            this.offset = i2 + i;
            return new ByteArrayWrapper(this.bytes, i2, i);
        }

        public byte[] array() {
            return this.bytes;
        }

        public int arrayOffset() {
            return this.offset;
        }
    }

    private static class ByteReadableBufferWrapper extends AbstractReadableBuffer {
        final ByteBuffer bytes;

        ByteReadableBufferWrapper(ByteBuffer byteBuffer) {
            this.bytes = (ByteBuffer) Preconditions.checkNotNull(byteBuffer, "bytes");
        }

        public int readableBytes() {
            return this.bytes.remaining();
        }

        public int readUnsignedByte() {
            checkReadable(1);
            return this.bytes.get() & UnsignedBytes.MAX_VALUE;
        }

        public void skipBytes(int i) {
            checkReadable(i);
            ByteBuffer byteBuffer = this.bytes;
            byteBuffer.position(byteBuffer.position() + i);
        }

        public void readBytes(byte[] bArr, int i, int i2) {
            checkReadable(i2);
            this.bytes.get(bArr, i, i2);
        }

        public void readBytes(ByteBuffer byteBuffer) {
            Preconditions.checkNotNull(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            checkReadable(remaining);
            int limit = this.bytes.limit();
            ByteBuffer byteBuffer2 = this.bytes;
            byteBuffer2.limit(byteBuffer2.position() + remaining);
            byteBuffer.put(this.bytes);
            this.bytes.limit(limit);
        }

        public void readBytes(OutputStream outputStream, int i) throws IOException {
            checkReadable(i);
            if (hasArray()) {
                outputStream.write(array(), arrayOffset(), i);
                ByteBuffer byteBuffer = this.bytes;
                byteBuffer.position(byteBuffer.position() + i);
                return;
            }
            byte[] bArr = new byte[i];
            this.bytes.get(bArr);
            outputStream.write(bArr);
        }

        public ByteReadableBufferWrapper readBytes(int i) {
            checkReadable(i);
            ByteBuffer duplicate = this.bytes.duplicate();
            duplicate.limit(this.bytes.position() + i);
            ByteBuffer byteBuffer = this.bytes;
            byteBuffer.position(byteBuffer.position() + i);
            return new ByteReadableBufferWrapper(duplicate);
        }

        public boolean hasArray() {
            return this.bytes.hasArray();
        }

        public byte[] array() {
            return this.bytes.array();
        }

        public int arrayOffset() {
            return this.bytes.arrayOffset() + this.bytes.position();
        }
    }

    private static final class BufferInputStream extends InputStream implements KnownLength {
        final ReadableBuffer buffer;

        public BufferInputStream(ReadableBuffer readableBuffer) {
            this.buffer = (ReadableBuffer) Preconditions.checkNotNull(readableBuffer, "buffer");
        }

        public int available() throws IOException {
            return this.buffer.readableBytes();
        }

        public int read() {
            if (this.buffer.readableBytes() == 0) {
                return -1;
            }
            return this.buffer.readUnsignedByte();
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (this.buffer.readableBytes() == 0) {
                return -1;
            }
            int min = Math.min(this.buffer.readableBytes(), i2);
            this.buffer.readBytes(bArr, i, min);
            return min;
        }

        public void close() throws IOException {
            this.buffer.close();
        }
    }

    private ReadableBuffers() {
    }
}
