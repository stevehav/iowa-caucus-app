package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
public interface Compressor {
    OutputStream compress(OutputStream outputStream) throws IOException;

    String getMessageEncoding();
}
