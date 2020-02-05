package io.opencensus.metrics.export;

import io.opencensus.metrics.export.Distribution;
import java.util.List;
import javax.annotation.Nullable;

final class AutoValue_Distribution extends Distribution {
    private final Distribution.BucketOptions bucketOptions;
    private final List<Distribution.Bucket> buckets;
    private final long count;
    private final double sum;
    private final double sumOfSquaredDeviations;

    AutoValue_Distribution(long j, double d, double d2, @Nullable Distribution.BucketOptions bucketOptions2, List<Distribution.Bucket> list) {
        this.count = j;
        this.sum = d;
        this.sumOfSquaredDeviations = d2;
        this.bucketOptions = bucketOptions2;
        if (list != null) {
            this.buckets = list;
            return;
        }
        throw new NullPointerException("Null buckets");
    }

    public long getCount() {
        return this.count;
    }

    public double getSum() {
        return this.sum;
    }

    public double getSumOfSquaredDeviations() {
        return this.sumOfSquaredDeviations;
    }

    @Nullable
    public Distribution.BucketOptions getBucketOptions() {
        return this.bucketOptions;
    }

    public List<Distribution.Bucket> getBuckets() {
        return this.buckets;
    }

    public String toString() {
        return "Distribution{count=" + this.count + ", sum=" + this.sum + ", sumOfSquaredDeviations=" + this.sumOfSquaredDeviations + ", bucketOptions=" + this.bucketOptions + ", buckets=" + this.buckets + "}";
    }

    public boolean equals(Object obj) {
        Distribution.BucketOptions bucketOptions2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Distribution)) {
            return false;
        }
        Distribution distribution = (Distribution) obj;
        if (this.count == distribution.getCount() && Double.doubleToLongBits(this.sum) == Double.doubleToLongBits(distribution.getSum()) && Double.doubleToLongBits(this.sumOfSquaredDeviations) == Double.doubleToLongBits(distribution.getSumOfSquaredDeviations()) && ((bucketOptions2 = this.bucketOptions) != null ? bucketOptions2.equals(distribution.getBucketOptions()) : distribution.getBucketOptions() == null) && this.buckets.equals(distribution.getBuckets())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.count;
        int doubleToLongBits = ((int) (((long) (((int) (((long) (((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) * 1000003)) ^ ((Double.doubleToLongBits(this.sum) >>> 32) ^ Double.doubleToLongBits(this.sum)))) * 1000003)) ^ ((Double.doubleToLongBits(this.sumOfSquaredDeviations) >>> 32) ^ Double.doubleToLongBits(this.sumOfSquaredDeviations)))) * 1000003;
        Distribution.BucketOptions bucketOptions2 = this.bucketOptions;
        return this.buckets.hashCode() ^ (((bucketOptions2 == null ? 0 : bucketOptions2.hashCode()) ^ doubleToLongBits) * 1000003);
    }
}
