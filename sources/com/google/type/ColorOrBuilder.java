package com.google.type;

import com.google.protobuf.FloatValue;
import com.google.protobuf.MessageLiteOrBuilder;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public interface ColorOrBuilder extends MessageLiteOrBuilder {
    FloatValue getAlpha();

    float getBlue();

    float getGreen();

    float getRed();

    boolean hasAlpha();
}
