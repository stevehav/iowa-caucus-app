package io.grpc.internal;

import io.grpc.Attributes;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ConnectionClientTransport extends ManagedClientTransport {
    Attributes getAttributes();
}
