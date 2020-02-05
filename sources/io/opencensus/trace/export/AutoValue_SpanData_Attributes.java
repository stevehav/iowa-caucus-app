package io.opencensus.trace.export;

import io.opencensus.trace.AttributeValue;
import io.opencensus.trace.export.SpanData;
import java.util.Map;

final class AutoValue_SpanData_Attributes extends SpanData.Attributes {
    private final Map<String, AttributeValue> attributeMap;
    private final int droppedAttributesCount;

    AutoValue_SpanData_Attributes(Map<String, AttributeValue> map, int i) {
        if (map != null) {
            this.attributeMap = map;
            this.droppedAttributesCount = i;
            return;
        }
        throw new NullPointerException("Null attributeMap");
    }

    public Map<String, AttributeValue> getAttributeMap() {
        return this.attributeMap;
    }

    public int getDroppedAttributesCount() {
        return this.droppedAttributesCount;
    }

    public String toString() {
        return "Attributes{attributeMap=" + this.attributeMap + ", droppedAttributesCount=" + this.droppedAttributesCount + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanData.Attributes)) {
            return false;
        }
        SpanData.Attributes attributes = (SpanData.Attributes) obj;
        if (!this.attributeMap.equals(attributes.getAttributeMap()) || this.droppedAttributesCount != attributes.getDroppedAttributesCount()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.attributeMap.hashCode() ^ 1000003) * 1000003) ^ this.droppedAttributesCount;
    }
}
