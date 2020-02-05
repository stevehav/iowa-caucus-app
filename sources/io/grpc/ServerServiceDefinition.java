package io.grpc;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class ServerServiceDefinition {
    private final Map<String, ServerMethodDefinition<?, ?>> methods;
    private final ServiceDescriptor serviceDescriptor;

    public static Builder builder(String str) {
        return new Builder(str);
    }

    public static Builder builder(ServiceDescriptor serviceDescriptor2) {
        return new Builder(serviceDescriptor2);
    }

    private ServerServiceDefinition(ServiceDescriptor serviceDescriptor2, Map<String, ServerMethodDefinition<?, ?>> map) {
        this.serviceDescriptor = (ServiceDescriptor) Preconditions.checkNotNull(serviceDescriptor2, "serviceDescriptor");
        this.methods = Collections.unmodifiableMap(new HashMap(map));
    }

    public ServiceDescriptor getServiceDescriptor() {
        return this.serviceDescriptor;
    }

    public Collection<ServerMethodDefinition<?, ?>> getMethods() {
        return this.methods.values();
    }

    @Internal
    public ServerMethodDefinition<?, ?> getMethod(String str) {
        return this.methods.get(str);
    }

    public static final class Builder {
        private final Map<String, ServerMethodDefinition<?, ?>> methods;
        private final ServiceDescriptor serviceDescriptor;
        private final String serviceName;

        private Builder(String str) {
            this.methods = new HashMap();
            this.serviceName = (String) Preconditions.checkNotNull(str, "serviceName");
            this.serviceDescriptor = null;
        }

        private Builder(ServiceDescriptor serviceDescriptor2) {
            this.methods = new HashMap();
            this.serviceDescriptor = (ServiceDescriptor) Preconditions.checkNotNull(serviceDescriptor2, "serviceDescriptor");
            this.serviceName = serviceDescriptor2.getName();
        }

        public <ReqT, RespT> Builder addMethod(MethodDescriptor<ReqT, RespT> methodDescriptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return addMethod(ServerMethodDefinition.create((MethodDescriptor) Preconditions.checkNotNull(methodDescriptor, "method must not be null"), (ServerCallHandler) Preconditions.checkNotNull(serverCallHandler, "handler must not be null")));
        }

        public <ReqT, RespT> Builder addMethod(ServerMethodDefinition<ReqT, RespT> serverMethodDefinition) {
            MethodDescriptor<ReqT, RespT> methodDescriptor = serverMethodDefinition.getMethodDescriptor();
            Preconditions.checkArgument(this.serviceName.equals(methodDescriptor.getServiceName()), "Method name should be prefixed with service name and separated with '/'. Expected service name: '%s'. Actual fully qualifed method name: '%s'.", (Object) this.serviceName, (Object) methodDescriptor.getFullMethodName());
            String fullMethodName = methodDescriptor.getFullMethodName();
            Preconditions.checkState(!this.methods.containsKey(fullMethodName), "Method by same name already registered: %s", (Object) fullMethodName);
            this.methods.put(fullMethodName, serverMethodDefinition);
            return this;
        }

        public ServerServiceDefinition build() {
            ServiceDescriptor serviceDescriptor2 = this.serviceDescriptor;
            if (serviceDescriptor2 == null) {
                ArrayList arrayList = new ArrayList(this.methods.size());
                for (ServerMethodDefinition<?, ?> methodDescriptor : this.methods.values()) {
                    arrayList.add(methodDescriptor.getMethodDescriptor());
                }
                serviceDescriptor2 = new ServiceDescriptor(this.serviceName, (Collection<MethodDescriptor<?, ?>>) arrayList);
            }
            HashMap hashMap = new HashMap(this.methods);
            for (MethodDescriptor next : serviceDescriptor2.getMethods()) {
                ServerMethodDefinition serverMethodDefinition = (ServerMethodDefinition) hashMap.remove(next.getFullMethodName());
                if (serverMethodDefinition == null) {
                    throw new IllegalStateException("No method bound for descriptor entry " + next.getFullMethodName());
                } else if (serverMethodDefinition.getMethodDescriptor() != next) {
                    throw new IllegalStateException("Bound method for " + next.getFullMethodName() + " not same instance as method in service descriptor");
                }
            }
            if (hashMap.size() <= 0) {
                return new ServerServiceDefinition(serviceDescriptor2, this.methods);
            }
            throw new IllegalStateException("No entry in descriptor matching bound method " + ((ServerMethodDefinition) hashMap.values().iterator().next()).getMethodDescriptor().getFullMethodName());
        }
    }
}
