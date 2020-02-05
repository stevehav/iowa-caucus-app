package io.grpc;

import java.io.IOException;
import java.io.OutputStream;

public interface Drainable {
    int drainTo(OutputStream outputStream) throws IOException;
}
