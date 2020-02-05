package io.opencensus.stats;

import io.opencensus.metrics.data.Exemplar;
import io.opencensus.stats.AggregationData;
import java.util.List;

final class AutoValue_AggregationData_DistributionData extends AggregationData.DistributionData {
    private final List<Long> bucketCounts;
    private final long count;
    private final List<Exemplar> exemplars;
    private final double mean;
    private final double sumOfSquaredDeviations;

    AutoValue_AggregationData_DistributionData(double d, long j, double d2, List<Long> list, List<Exemplar> list2) {
        this.mean = d;
        this.count = j;
        this.sumOfSquaredDeviations = d2;
        if (list != null) {
            this.bucketCounts = list;
            if (list2 != null) {
                this.exemplars = list2;
                return;
            }
            throw new NullPointerException("Null exemplars");
        }
        throw new NullPointerException("Null bucketCounts");
    }

    public double getMean() {
        return this.mean;
    }

    public long getCount() {
        return this.count;
    }

    public double getSumOfSquaredDeviations() {
        return this.sumOfSquaredDeviations;
    }

    public List<Long> getBucketCounts() {
        return this.bucketCounts;
    }

    public List<Exemplar> getExemplars() {
        return this.exemplars;
    }

    public String toString() {
        return "DistributionData{mean=" + this.mean + ", count=" + this.count + ", sumOfSquaredDeviations=" + this.sumOfSquaredDeviations + ", bucketCounts=" + this.bucketCounts + ", exemplars=" + this.exemplars + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AggregationData.DistributionData)) {
            return false;
        }
        AggregationData.DistributionData distributionData = (AggregationData.DistributionData) obj;
        if (Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(distributionData.getMean()) && this.count == distributionData.getCount() && Double.doubleToLongBits(this.sumOfSquaredDeviations) == Double.doubleToLongBits(distributionData.getSumOfSquaredDeviations()) && this.bucketCounts.equals(distributionData.getBucketCounts()) && this.exemplars.equals(distributionData.getExemplars())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.count;
        int hashCode = this.bucketCounts.hashCode();
        return this.exemplars.hashCode() ^ ((hashCode ^ (((int) (((long) (((int) (((long) (((int) (((long) 1000003) ^ ((Double.doubleToLongBits(this.mean) >>> 32) ^ Double.doubleToLongBits(this.mean)))) * 1000003)) ^ (j ^ (j >>> 32)))) * 1000003)) ^ ((Double.doubleToLongBits(this.sumOfSquaredDeviations) >>> 32) ^ Double.doubleToLongBits(this.sumOfSquaredDeviations)))) * 1000003)) * 1000003);
    }
}
