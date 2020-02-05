package com.google.firebase.firestore.model.value;

import com.google.firebase.firestore.GeoPoint;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public class GeoPointValue extends FieldValue {
    private final GeoPoint internalValue;

    public int typeOrder() {
        return 7;
    }

    private GeoPointValue(GeoPoint geoPoint) {
        this.internalValue = geoPoint;
    }

    public GeoPoint value() {
        return this.internalValue;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GeoPointValue) && this.internalValue.equals(((GeoPointValue) obj).internalValue);
    }

    public int hashCode() {
        return this.internalValue.hashCode();
    }

    public int compareTo(FieldValue fieldValue) {
        if (fieldValue instanceof GeoPointValue) {
            return this.internalValue.compareTo(((GeoPointValue) fieldValue).internalValue);
        }
        return defaultCompareTo(fieldValue);
    }

    public static GeoPointValue valueOf(GeoPoint geoPoint) {
        return new GeoPointValue(geoPoint);
    }
}
