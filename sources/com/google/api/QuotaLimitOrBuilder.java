package com.google.api;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageLiteOrBuilder;
import java.util.Map;

/* compiled from: com.google.firebase:protolite-well-known-types@@16.0.1 */
public interface QuotaLimitOrBuilder extends MessageLiteOrBuilder {
    boolean containsValues(String str);

    long getDefaultLimit();

    String getDescription();

    ByteString getDescriptionBytes();

    String getDisplayName();

    ByteString getDisplayNameBytes();

    String getDuration();

    ByteString getDurationBytes();

    long getFreeTier();

    long getMaxLimit();

    String getMetric();

    ByteString getMetricBytes();

    String getName();

    ByteString getNameBytes();

    String getUnit();

    ByteString getUnitBytes();

    @Deprecated
    Map<String, Long> getValues();

    int getValuesCount();

    Map<String, Long> getValuesMap();

    long getValuesOrDefault(String str, long j);

    long getValuesOrThrow(String str);
}
