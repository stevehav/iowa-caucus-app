package io.opencensus.trace;

import io.opencensus.trace.Tracestate;
import java.util.List;

final class AutoValue_Tracestate extends Tracestate {
    private final List<Tracestate.Entry> entries;

    AutoValue_Tracestate(List<Tracestate.Entry> list) {
        if (list != null) {
            this.entries = list;
            return;
        }
        throw new NullPointerException("Null entries");
    }

    public List<Tracestate.Entry> getEntries() {
        return this.entries;
    }

    public String toString() {
        return "Tracestate{entries=" + this.entries + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Tracestate) {
            return this.entries.equals(((Tracestate) obj).getEntries());
        }
        return false;
    }

    public int hashCode() {
        return this.entries.hashCode() ^ 1000003;
    }
}
