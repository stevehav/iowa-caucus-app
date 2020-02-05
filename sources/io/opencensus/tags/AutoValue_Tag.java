package io.opencensus.tags;

final class AutoValue_Tag extends Tag {
    private final TagKey key;
    private final TagMetadata tagMetadata;
    private final TagValue value;

    AutoValue_Tag(TagKey tagKey, TagValue tagValue, TagMetadata tagMetadata2) {
        if (tagKey != null) {
            this.key = tagKey;
            if (tagValue != null) {
                this.value = tagValue;
                if (tagMetadata2 != null) {
                    this.tagMetadata = tagMetadata2;
                    return;
                }
                throw new NullPointerException("Null tagMetadata");
            }
            throw new NullPointerException("Null value");
        }
        throw new NullPointerException("Null key");
    }

    public TagKey getKey() {
        return this.key;
    }

    public TagValue getValue() {
        return this.value;
    }

    public TagMetadata getTagMetadata() {
        return this.tagMetadata;
    }

    public String toString() {
        return "Tag{key=" + this.key + ", value=" + this.value + ", tagMetadata=" + this.tagMetadata + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (!this.key.equals(tag.getKey()) || !this.value.equals(tag.getValue()) || !this.tagMetadata.equals(tag.getTagMetadata())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.key.hashCode() ^ 1000003) * 1000003) ^ this.value.hashCode()) * 1000003) ^ this.tagMetadata.hashCode();
    }
}
