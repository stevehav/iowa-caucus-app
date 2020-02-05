package io.grpc;

import java.net.SocketAddress;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/5279")
public abstract class ProxiedSocketAddress extends SocketAddress {
    private static final long serialVersionUID = 0;
}
