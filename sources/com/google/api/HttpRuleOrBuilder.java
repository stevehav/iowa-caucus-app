package com.google.api;

import com.google.api.HttpRule;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public interface HttpRuleOrBuilder extends MessageLiteOrBuilder {
    HttpRule getAdditionalBindings(int i);

    int getAdditionalBindingsCount();

    List<HttpRule> getAdditionalBindingsList();

    String getBody();

    ByteString getBodyBytes();

    CustomHttpPattern getCustom();

    String getDelete();

    ByteString getDeleteBytes();

    String getGet();

    ByteString getGetBytes();

    String getPatch();

    ByteString getPatchBytes();

    HttpRule.PatternCase getPatternCase();

    String getPost();

    ByteString getPostBytes();

    String getPut();

    ByteString getPutBytes();

    String getSelector();

    ByteString getSelectorBytes();
}
