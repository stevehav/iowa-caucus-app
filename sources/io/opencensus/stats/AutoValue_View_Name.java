package io.opencensus.stats;

import io.opencensus.stats.View;

final class AutoValue_View_Name extends View.Name {
    private final String asString;

    AutoValue_View_Name(String str) {
        if (str != null) {
            this.asString = str;
            return;
        }
        throw new NullPointerException("Null asString");
    }

    public String asString() {
        return this.asString;
    }

    public String toString() {
        return "Name{asString=" + this.asString + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof View.Name) {
            return this.asString.equals(((View.Name) obj).asString());
        }
        return false;
    }

    public int hashCode() {
        return this.asString.hashCode() ^ 1000003;
    }
}
