package io.grpc.stub.annotations;

import io.grpc.MethodDescriptor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface RpcMethod {
    String fullMethodName();

    MethodDescriptor.MethodType methodType();

    Class<?> requestType();

    Class<?> responseType();
}
