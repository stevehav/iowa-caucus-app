package io.grpc;

import java.io.IOException;

public interface KnownLength {
    int available() throws IOException;
}
