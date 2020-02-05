package io.opencensus.trace.export;

import io.opencensus.trace.Link;
import io.opencensus.trace.export.SpanData;
import java.util.List;

final class AutoValue_SpanData_Links extends SpanData.Links {
    private final int droppedLinksCount;
    private final List<Link> links;

    AutoValue_SpanData_Links(List<Link> list, int i) {
        if (list != null) {
            this.links = list;
            this.droppedLinksCount = i;
            return;
        }
        throw new NullPointerException("Null links");
    }

    public List<Link> getLinks() {
        return this.links;
    }

    public int getDroppedLinksCount() {
        return this.droppedLinksCount;
    }

    public String toString() {
        return "Links{links=" + this.links + ", droppedLinksCount=" + this.droppedLinksCount + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SpanData.Links)) {
            return false;
        }
        SpanData.Links links2 = (SpanData.Links) obj;
        if (!this.links.equals(links2.getLinks()) || this.droppedLinksCount != links2.getDroppedLinksCount()) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.links.hashCode() ^ 1000003) * 1000003) ^ this.droppedLinksCount;
    }
}
