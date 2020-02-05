package io.grpc.internal;

public interface WritableBufferAllocator {
    WritableBuffer allocate(int i);
}
