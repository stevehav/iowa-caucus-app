package io.opencensus.common;

final class AutoValue_Duration extends Duration {
    private final int nanos;
    private final long seconds;

    AutoValue_Duration(long j, int i) {
        this.seconds = j;
        this.nanos = i;
    }

    public long getSeconds() {
        return this.seconds;
    }

    public int getNanos() {
        return this.nanos;
    }

    public String toString() {
        return "Duration{seconds=" + this.seconds + ", nanos=" + this.nanos + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        if (this.seconds == duration.getSeconds() && this.nanos == duration.getNanos()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.seconds;
        return this.nanos ^ (((int) (((long) 1000003) ^ (j ^ (j >>> 32)))) * 1000003);
    }
}
