package io.sentry.marshaller;

import io.sentry.event.Event;
import java.io.IOException;
import java.io.OutputStream;

public interface Marshaller {
    String getContentEncoding();

    String getContentType();

    void marshall(Event event, OutputStream outputStream) throws IOException;

    public static final class UncloseableOutputStream extends OutputStream {
        private final OutputStream originalStream;

        public void close() throws IOException {
        }

        public UncloseableOutputStream(OutputStream outputStream) {
            this.originalStream = outputStream;
        }

        public void write(int i) throws IOException {
            this.originalStream.write(i);
        }

        public void write(byte[] bArr) throws IOException {
            this.originalStream.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.originalStream.write(bArr, i, i2);
        }

        public void flush() throws IOException {
            this.originalStream.flush();
        }
    }
}
