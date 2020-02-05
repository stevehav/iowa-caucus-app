package io.grpc.internal;

import io.grpc.Attributes;
import io.grpc.SecurityLevel;
import java.util.Map;

public final class GrpcAttributes {
    public static final Attributes.Key<Attributes> ATTR_CLIENT_EAG_ATTRS = Attributes.Key.create("io.grpc.internal.GrpcAttributes.clientEagAttrs");
    public static final Attributes.Key<String> ATTR_LB_ADDR_AUTHORITY = Attributes.Key.create("io.grpc.grpclb.lbAddrAuthority");
    public static final Attributes.Key<Boolean> ATTR_LB_PROVIDED_BACKEND = Attributes.Key.create("io.grpc.grpclb.lbProvidedBackend");
    public static final Attributes.Key<SecurityLevel> ATTR_SECURITY_LEVEL = Attributes.Key.create("io.grpc.internal.GrpcAttributes.securityLevel");
    public static final Attributes.Key<Map<String, ?>> NAME_RESOLVER_SERVICE_CONFIG = Attributes.Key.create("service-config");

    private GrpcAttributes() {
    }
}
