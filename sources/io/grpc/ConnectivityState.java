package io.grpc;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4359")
public enum ConnectivityState {
    CONNECTING,
    READY,
    TRANSIENT_FAILURE,
    IDLE,
    SHUTDOWN
}
