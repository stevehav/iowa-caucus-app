package com.google.api;

import com.google.api.MetricDescriptor;
import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.List;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public interface MetricDescriptorOrBuilder extends MessageLiteOrBuilder {
    String getDescription();

    ByteString getDescriptionBytes();

    String getDisplayName();

    ByteString getDisplayNameBytes();

    LabelDescriptor getLabels(int i);

    int getLabelsCount();

    List<LabelDescriptor> getLabelsList();

    MetricDescriptor.MetricKind getMetricKind();

    int getMetricKindValue();

    String getName();

    ByteString getNameBytes();

    String getType();

    ByteString getTypeBytes();

    String getUnit();

    ByteString getUnitBytes();

    MetricDescriptor.ValueType getValueType();

    int getValueTypeValue();
}
