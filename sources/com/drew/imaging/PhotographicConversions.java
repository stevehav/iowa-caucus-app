package com.drew.imaging;

public final class PhotographicConversions {
    public static final double ROOT_TWO = Math.sqrt(2.0d);

    private PhotographicConversions() throws Exception {
        throw new Exception("Not intended for instantiation.");
    }

    public static double apertureToFStop(double d) {
        return Math.pow(ROOT_TWO, d);
    }

    public static double shutterSpeedToExposureTime(double d) {
        return (double) ((float) (1.0d / Math.exp(d * Math.log(2.0d))));
    }
}
