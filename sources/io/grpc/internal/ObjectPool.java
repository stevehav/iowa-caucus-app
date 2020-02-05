package io.grpc.internal;

import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public interface ObjectPool<T> {
    T getObject();

    T returnObject(Object obj);
}
