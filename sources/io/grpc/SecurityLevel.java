package io.grpc;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4692")
public enum SecurityLevel {
    NONE,
    INTEGRITY,
    PRIVACY_AND_INTEGRITY
}
