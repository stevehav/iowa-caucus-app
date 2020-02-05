package io.grpc.internal;

import io.grpc.Compressor;
import java.io.InputStream;

public interface Stream {
    void flush();

    boolean isReady();

    void request(int i);

    void setCompressor(Compressor compressor);

    void setMessageCompression(boolean z);

    void writeMessage(InputStream inputStream);
}
