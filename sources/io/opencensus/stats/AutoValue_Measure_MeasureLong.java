package io.opencensus.stats;

import io.opencensus.stats.Measure;

final class AutoValue_Measure_MeasureLong extends Measure.MeasureLong {
    private final String description;
    private final String name;
    private final String unit;

    AutoValue_Measure_MeasureLong(String str, String str2, String str3) {
        if (str != null) {
            this.name = str;
            if (str2 != null) {
                this.description = str2;
                if (str3 != null) {
                    this.unit = str3;
                    return;
                }
                throw new NullPointerException("Null unit");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null name");
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUnit() {
        return this.unit;
    }

    public String toString() {
        return "MeasureLong{name=" + this.name + ", description=" + this.description + ", unit=" + this.unit + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Measure.MeasureLong)) {
            return false;
        }
        Measure.MeasureLong measureLong = (Measure.MeasureLong) obj;
        if (!this.name.equals(measureLong.getName()) || !this.description.equals(measureLong.getDescription()) || !this.unit.equals(measureLong.getUnit())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.unit.hashCode();
    }
}
