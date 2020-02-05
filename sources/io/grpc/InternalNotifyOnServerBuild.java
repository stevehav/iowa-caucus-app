package io.grpc;

@Internal
public interface InternalNotifyOnServerBuild {
    void notifyOnBuild(Server server);
}
