package io.grpc.internal;

import io.grpc.Compressor;
import java.io.InputStream;

public interface Framer {
    void close();

    void dispose();

    void flush();

    boolean isClosed();

    Framer setCompressor(Compressor compressor);

    void setMaxOutboundMessageSize(int i);

    Framer setMessageCompression(boolean z);

    void writePayload(InputStream inputStream);
}
