package io.grpc;

import java.io.IOException;
import java.io.InputStream;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1704")
public interface Decompressor {
    InputStream decompress(InputStream inputStream) throws IOException;

    String getMessageEncoding();
}
