package io.opencensus.resource;

import java.util.Map;
import javax.annotation.Nullable;

final class AutoValue_Resource extends Resource {
    private final Map<String, String> labels;
    private final String type;

    AutoValue_Resource(@Nullable String str, Map<String, String> map) {
        this.type = str;
        if (map != null) {
            this.labels = map;
            return;
        }
        throw new NullPointerException("Null labels");
    }

    @Nullable
    public String getType() {
        return this.type;
    }

    public Map<String, String> getLabels() {
        return this.labels;
    }

    public String toString() {
        return "Resource{type=" + this.type + ", labels=" + this.labels + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Resource)) {
            return false;
        }
        Resource resource = (Resource) obj;
        String str = this.type;
        if (str != null ? str.equals(resource.getType()) : resource.getType() == null) {
            if (this.labels.equals(resource.getLabels())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.type;
        return (((str == null ? 0 : str.hashCode()) ^ 1000003) * 1000003) ^ this.labels.hashCode();
    }
}
