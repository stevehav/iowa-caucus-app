package io.grpc.protobuf.lite;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MessageLite;
import com.google.protobuf.Parser;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.annotation.Nullable;

final class ProtoInputStream extends InputStream implements Drainable, KnownLength {
    @Nullable
    private MessageLite message;
    private final Parser<?> parser;
    @Nullable
    private ByteArrayInputStream partial;

    ProtoInputStream(MessageLite messageLite, Parser<?> parser2) {
        this.message = messageLite;
        this.parser = parser2;
    }

    public int drainTo(OutputStream outputStream) throws IOException {
        MessageLite messageLite = this.message;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            this.message.writeTo(outputStream);
            this.message = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int copy = (int) ProtoLiteUtils.copy(byteArrayInputStream, outputStream);
        this.partial = null;
        return copy;
    }

    public int read() {
        MessageLite messageLite = this.message;
        if (messageLite != null) {
            this.partial = new ByteArrayInputStream(messageLite.toByteArray());
            this.message = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        MessageLite messageLite = this.message;
        if (messageLite != null) {
            int serializedSize = messageLite.getSerializedSize();
            if (serializedSize == 0) {
                this.message = null;
                this.partial = null;
                return -1;
            } else if (i2 >= serializedSize) {
                CodedOutputStream newInstance = CodedOutputStream.newInstance(bArr, i, serializedSize);
                this.message.writeTo(newInstance);
                newInstance.flush();
                newInstance.checkNoSpaceLeft();
                this.message = null;
                this.partial = null;
                return serializedSize;
            } else {
                this.partial = new ByteArrayInputStream(this.message.toByteArray());
                this.message = null;
            }
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i, i2);
        }
        return -1;
    }

    public int available() {
        MessageLite messageLite = this.message;
        if (messageLite != null) {
            return messageLite.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public MessageLite message() {
        MessageLite messageLite = this.message;
        if (messageLite != null) {
            return messageLite;
        }
        throw new IllegalStateException("message not available");
    }

    /* access modifiers changed from: package-private */
    public Parser<?> parser() {
        return this.parser;
    }
}
