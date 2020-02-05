package io.opencensus.metrics.export;

import io.opencensus.metrics.data.Exemplar;
import io.opencensus.metrics.export.Distribution;
import javax.annotation.Nullable;

final class AutoValue_Distribution_Bucket extends Distribution.Bucket {
    private final long count;
    private final Exemplar exemplar;

    AutoValue_Distribution_Bucket(long j, @Nullable Exemplar exemplar2) {
        this.count = j;
        this.exemplar = exemplar2;
    }

    public long getCount() {
        return this.count;
    }

    @Nullable
    public Exemplar getExemplar() {
        return this.exemplar;
    }

    public String toString() {
        return "Bucket{count=" + this.count + ", exemplar=" + this.exemplar + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Distribution.Bucket)) {
            return false;
        }
        Distribution.Bucket bucket = (Distribution.Bucket) obj;
        if (this.count == bucket.getCount()) {
            Exemplar exemplar2 = this.exemplar;
            if (exemplar2 == null) {
                if (bucket.getExemplar() == null) {
                    return true;
                }
            } else if (exemplar2.equals(bucket.getExemplar())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.count;
        int i = ((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) * 1000003;
        Exemplar exemplar2 = this.exemplar;
        return (exemplar2 == null ? 0 : exemplar2.hashCode()) ^ i;
    }
}
