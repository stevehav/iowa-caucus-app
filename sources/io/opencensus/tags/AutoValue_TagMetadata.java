package io.opencensus.tags;

import io.opencensus.tags.TagMetadata;

final class AutoValue_TagMetadata extends TagMetadata {
    private final TagMetadata.TagTtl tagTtl;

    AutoValue_TagMetadata(TagMetadata.TagTtl tagTtl2) {
        if (tagTtl2 != null) {
            this.tagTtl = tagTtl2;
            return;
        }
        throw new NullPointerException("Null tagTtl");
    }

    public TagMetadata.TagTtl getTagTtl() {
        return this.tagTtl;
    }

    public String toString() {
        return "TagMetadata{tagTtl=" + this.tagTtl + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof TagMetadata) {
            return this.tagTtl.equals(((TagMetadata) obj).getTagTtl());
        }
        return false;
    }

    public int hashCode() {
        return this.tagTtl.hashCode() ^ 1000003;
    }
}
