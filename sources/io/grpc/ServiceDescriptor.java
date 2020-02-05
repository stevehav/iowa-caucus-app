package io.grpc;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.annotation.Nullable;

public final class ServiceDescriptor {
    private final Collection<MethodDescriptor<?, ?>> methods;
    private final String name;
    private final Object schemaDescriptor;

    public ServiceDescriptor(String str, MethodDescriptor<?, ?>... methodDescriptorArr) {
        this(str, (Collection<MethodDescriptor<?, ?>>) Arrays.asList(methodDescriptorArr));
    }

    public ServiceDescriptor(String str, Collection<MethodDescriptor<?, ?>> collection) {
        this(newBuilder(str).addAllMethods((Collection) Preconditions.checkNotNull(collection, "methods")));
    }

    private ServiceDescriptor(Builder builder) {
        this.name = builder.name;
        validateMethodNames(this.name, builder.methods);
        this.methods = Collections.unmodifiableList(new ArrayList(builder.methods));
        this.schemaDescriptor = builder.schemaDescriptor;
    }

    public String getName() {
        return this.name;
    }

    public Collection<MethodDescriptor<?, ?>> getMethods() {
        return this.methods;
    }

    @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2222")
    @Nullable
    public Object getSchemaDescriptor() {
        return this.schemaDescriptor;
    }

    static void validateMethodNames(String str, Collection<MethodDescriptor<?, ?>> collection) {
        HashSet hashSet = new HashSet(collection.size());
        for (MethodDescriptor next : collection) {
            Preconditions.checkNotNull(next, FirebaseAnalytics.Param.METHOD);
            String serviceName = next.getServiceName();
            Preconditions.checkArgument(str.equals(serviceName), "service names %s != %s", (Object) serviceName, (Object) str);
            Preconditions.checkArgument(hashSet.add(next.getFullMethodName()), "duplicate name %s", (Object) next.getFullMethodName());
        }
    }

    public static Builder newBuilder(String str) {
        return new Builder(str);
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public List<MethodDescriptor<?, ?>> methods;
        /* access modifiers changed from: private */
        public String name;
        /* access modifiers changed from: private */
        public Object schemaDescriptor;

        private Builder(String str) {
            this.methods = new ArrayList();
            setName(str);
        }

        @ExperimentalApi("https://github.com/grpc/grpc-java/issues/2666")
        public Builder setName(String str) {
            this.name = (String) Preconditions.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            return this;
        }

        public Builder addMethod(MethodDescriptor<?, ?> methodDescriptor) {
            this.methods.add(Preconditions.checkNotNull(methodDescriptor, FirebaseAnalytics.Param.METHOD));
            return this;
        }

        /* access modifiers changed from: private */
        public Builder addAllMethods(Collection<MethodDescriptor<?, ?>> collection) {
            this.methods.addAll(collection);
            return this;
        }

        public Builder setSchemaDescriptor(@Nullable Object obj) {
            this.schemaDescriptor = obj;
            return this;
        }

        public ServiceDescriptor build() {
            return new ServiceDescriptor(this);
        }
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) this.name).add("schemaDescriptor", this.schemaDescriptor).add("methods", (Object) this.methods).omitNullValues().toString();
    }
}
