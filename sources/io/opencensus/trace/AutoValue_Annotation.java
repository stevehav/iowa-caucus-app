package io.opencensus.trace;

import java.util.Map;

final class AutoValue_Annotation extends Annotation {
    private final Map<String, AttributeValue> attributes;
    private final String description;

    AutoValue_Annotation(String str, Map<String, AttributeValue> map) {
        if (str != null) {
            this.description = str;
            if (map != null) {
                this.attributes = map;
                return;
            }
            throw new NullPointerException("Null attributes");
        }
        throw new NullPointerException("Null description");
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, AttributeValue> getAttributes() {
        return this.attributes;
    }

    public String toString() {
        return "Annotation{description=" + this.description + ", attributes=" + this.attributes + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Annotation)) {
            return false;
        }
        Annotation annotation = (Annotation) obj;
        if (!this.description.equals(annotation.getDescription()) || !this.attributes.equals(annotation.getAttributes())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.description.hashCode() ^ 1000003) * 1000003) ^ this.attributes.hashCode();
    }
}
