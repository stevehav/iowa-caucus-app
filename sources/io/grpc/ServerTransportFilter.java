package io.grpc;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/2132")
public abstract class ServerTransportFilter {
    public Attributes transportReady(Attributes attributes) {
        return attributes;
    }

    public void transportTerminated(Attributes attributes) {
    }
}
