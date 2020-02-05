package com.drew.lang;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import java.text.DecimalFormat;

public final class GeoLocation {
    private final double _latitude;
    private final double _longitude;

    public GeoLocation(double d, double d2) {
        this._latitude = d;
        this._longitude = d2;
    }

    public double getLatitude() {
        return this._latitude;
    }

    public double getLongitude() {
        return this._longitude;
    }

    public boolean isZero() {
        return this._latitude == 0.0d && this._longitude == 0.0d;
    }

    @NotNull
    public static String decimalToDegreesMinutesSecondsString(double d) {
        double[] decimalToDegreesMinutesSeconds = decimalToDegreesMinutesSeconds(d);
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        return String.format("%s° %s' %s\"", new Object[]{decimalFormat.format(decimalToDegreesMinutesSeconds[0]), decimalFormat.format(decimalToDegreesMinutesSeconds[1]), decimalFormat.format(decimalToDegreesMinutesSeconds[2])});
    }

    @NotNull
    public static double[] decimalToDegreesMinutesSeconds(double d) {
        int i = (int) d;
        double abs = Math.abs((d % 1.0d) * 60.0d);
        return new double[]{(double) i, (double) ((int) abs), (abs % 1.0d) * 60.0d};
    }

    @Nullable
    public static Double degreesMinutesSecondsToDecimal(@NotNull Rational rational, @NotNull Rational rational2, @NotNull Rational rational3, boolean z) {
        double abs = Math.abs(rational.doubleValue()) + (rational2.doubleValue() / 60.0d) + (rational3.doubleValue() / 3600.0d);
        if (Double.isNaN(abs)) {
            return null;
        }
        if (z) {
            abs *= -1.0d;
        }
        return Double.valueOf(abs);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        GeoLocation geoLocation = (GeoLocation) obj;
        return Double.compare(geoLocation._latitude, this._latitude) == 0 && Double.compare(geoLocation._longitude, this._longitude) == 0;
    }

    public int hashCode() {
        double d = this._latitude;
        long j = 0;
        long doubleToLongBits = d != 0.0d ? Double.doubleToLongBits(d) : 0;
        int i = (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
        double d2 = this._longitude;
        if (d2 != 0.0d) {
            j = Double.doubleToLongBits(d2);
        }
        return (i * 31) + ((int) (j ^ (j >>> 32)));
    }

    @NotNull
    public String toString() {
        return this._latitude + ", " + this._longitude;
    }

    @NotNull
    public String toDMSString() {
        return decimalToDegreesMinutesSecondsString(this._latitude) + ", " + decimalToDegreesMinutesSecondsString(this._longitude);
    }
}
