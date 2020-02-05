package com.google.firebase.firestore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.firestore.util.Util;

@PublicApi
/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class GeoPoint implements Comparable<GeoPoint> {
    private final double latitude;
    private final double longitude;

    @PublicApi
    public GeoPoint(double d, double d2) {
        if (Double.isNaN(d) || d < -90.0d || d > 90.0d) {
            throw new IllegalArgumentException("Latitude must be in the range of [-90, 90]");
        } else if (Double.isNaN(d2) || d2 < -180.0d || d2 > 180.0d) {
            throw new IllegalArgumentException("Longitude must be in the range of [-180, 180]");
        } else {
            this.latitude = d;
            this.longitude = d2;
        }
    }

    @PublicApi
    public double getLatitude() {
        return this.latitude;
    }

    @PublicApi
    public double getLongitude() {
        return this.longitude;
    }

    @PublicApi
    public int compareTo(@NonNull GeoPoint geoPoint) {
        int compareDoubles = Util.compareDoubles(this.latitude, geoPoint.latitude);
        return compareDoubles == 0 ? Util.compareDoubles(this.longitude, geoPoint.longitude) : compareDoubles;
    }

    @NonNull
    public String toString() {
        return "GeoPoint { latitude=" + this.latitude + ", longitude=" + this.longitude + " }";
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.latitude == geoPoint.latitude && this.longitude == geoPoint.longitude) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.latitude);
        long doubleToLongBits2 = Double.doubleToLongBits(this.longitude);
        return (((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }
}
