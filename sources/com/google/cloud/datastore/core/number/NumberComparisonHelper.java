package com.google.cloud.datastore.core.number;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class NumberComparisonHelper {
    public static final double LONG_EXCLUSIVE_UPPER_BOUND_AS_DOUBLE = 9.223372036854776E18d;
    public static final double LONG_INCLUSIVE_LOWER_BOUND_AS_DOUBLE = -9.223372036854776E18d;
    public static final long MAX_SAFE_LONG = 9007199254740992L;
    public static final long MIN_SAFE_LONG = -9007199254740992L;

    public static int compareLongs(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static int firestoreCompareDoubleWithLong(double d, long j) {
        if (Double.isNaN(d) || d < -9.223372036854776E18d) {
            return -1;
        }
        if (d >= 9.223372036854776E18d) {
            return 1;
        }
        int compareLongs = compareLongs((long) d, j);
        if (compareLongs != 0) {
            return compareLongs;
        }
        return firestoreCompareDoubles(d, (double) j);
    }

    public static int firestoreCompareDoubles(double d, double d2) {
        if (d < d2) {
            return -1;
        }
        if (d > d2) {
            return 1;
        }
        if (d == d2) {
            return 0;
        }
        if (!Double.isNaN(d2)) {
            return -1;
        }
        return !Double.isNaN(d) ? 1 : 0;
    }

    private NumberComparisonHelper() {
    }
}
