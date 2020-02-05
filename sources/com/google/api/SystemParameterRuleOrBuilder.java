package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public interface SystemParameterRuleOrBuilder extends MessageLiteOrBuilder {
    SystemParameter getParameters(int i);

    int getParametersCount();

    List<SystemParameter> getParametersList();

    String getSelector();

    ByteString getSelectorBytes();
}
