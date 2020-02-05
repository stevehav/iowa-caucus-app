package com.drew.metadata.exif;

import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.GeoLocation;
import com.drew.lang.Rational;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;
import java.text.DecimalFormat;

public class GpsDescriptor extends TagDescriptor<GpsDirectory> {
    public GpsDescriptor(@NotNull GpsDirectory gpsDirectory) {
        super(gpsDirectory);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0035, code lost:
        return getGpsDirectionDescription(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x003a, code lost:
        return getGpsDirectionReferenceDescription(r2);
     */
    @com.drew.lang.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getDescription(int r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x0068
            r0 = 2
            if (r2 == r0) goto L_0x0063
            r0 = 12
            if (r2 == r0) goto L_0x005e
            r0 = 30
            if (r2 == r0) goto L_0x0059
            r0 = 4
            if (r2 == r0) goto L_0x0054
            r0 = 5
            if (r2 == r0) goto L_0x004f
            r0 = 6
            if (r2 == r0) goto L_0x004a
            r0 = 7
            if (r2 == r0) goto L_0x0045
            r0 = 9
            if (r2 == r0) goto L_0x0040
            r0 = 10
            if (r2 == r0) goto L_0x003b
            switch(r2) {
                case 14: goto L_0x0036;
                case 15: goto L_0x0031;
                case 16: goto L_0x0036;
                case 17: goto L_0x0031;
                default: goto L_0x0024;
            }
        L_0x0024:
            switch(r2) {
                case 23: goto L_0x0036;
                case 24: goto L_0x0031;
                case 25: goto L_0x002c;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.String r2 = super.getDescription(r2)
            return r2
        L_0x002c:
            java.lang.String r2 = r1.getGpsDestinationReferenceDescription()
            return r2
        L_0x0031:
            java.lang.String r2 = r1.getGpsDirectionDescription(r2)
            return r2
        L_0x0036:
            java.lang.String r2 = r1.getGpsDirectionReferenceDescription(r2)
            return r2
        L_0x003b:
            java.lang.String r2 = r1.getGpsMeasureModeDescription()
            return r2
        L_0x0040:
            java.lang.String r2 = r1.getGpsStatusDescription()
            return r2
        L_0x0045:
            java.lang.String r2 = r1.getGpsTimeStampDescription()
            return r2
        L_0x004a:
            java.lang.String r2 = r1.getGpsAltitudeDescription()
            return r2
        L_0x004f:
            java.lang.String r2 = r1.getGpsAltitudeRefDescription()
            return r2
        L_0x0054:
            java.lang.String r2 = r1.getGpsLongitudeDescription()
            return r2
        L_0x0059:
            java.lang.String r2 = r1.getGpsDifferentialDescription()
            return r2
        L_0x005e:
            java.lang.String r2 = r1.getGpsSpeedRefDescription()
            return r2
        L_0x0063:
            java.lang.String r2 = r1.getGpsLatitudeDescription()
            return r2
        L_0x0068:
            java.lang.String r2 = r1.getGpsVersionIdDescription()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.exif.GpsDescriptor.getDescription(int):java.lang.String");
    }

    @Nullable
    private String getGpsVersionIdDescription() {
        return getVersionBytesDescription(0, 1);
    }

    @Nullable
    public String getGpsLatitudeDescription() {
        GeoLocation geoLocation = ((GpsDirectory) this._directory).getGeoLocation();
        if (geoLocation == null) {
            return null;
        }
        return GeoLocation.decimalToDegreesMinutesSecondsString(geoLocation.getLatitude());
    }

    @Nullable
    public String getGpsLongitudeDescription() {
        GeoLocation geoLocation = ((GpsDirectory) this._directory).getGeoLocation();
        if (geoLocation == null) {
            return null;
        }
        return GeoLocation.decimalToDegreesMinutesSecondsString(geoLocation.getLongitude());
    }

    @Nullable
    public String getGpsTimeStampDescription() {
        Rational[] rationalArray = ((GpsDirectory) this._directory).getRationalArray(7);
        DecimalFormat decimalFormat = new DecimalFormat("00.000");
        if (rationalArray == null) {
            return null;
        }
        return String.format("%02d:%02d:%s UTC", new Object[]{Integer.valueOf(rationalArray[0].intValue()), Integer.valueOf(rationalArray[1].intValue()), decimalFormat.format(rationalArray[2].doubleValue())});
    }

    @Nullable
    public String getGpsDestinationReferenceDescription() {
        String string = ((GpsDirectory) this._directory).getString(25);
        if (string == null) {
            return null;
        }
        String trim = string.trim();
        if ("K".equalsIgnoreCase(trim)) {
            return "kilometers";
        }
        if ("M".equalsIgnoreCase(trim)) {
            return "miles";
        }
        if ("N".equalsIgnoreCase(trim)) {
            return "knots";
        }
        return "Unknown (" + trim + ")";
    }

    @Nullable
    public String getGpsDirectionDescription(int i) {
        Rational rational = ((GpsDirectory) this._directory).getRational(i);
        String format = rational != null ? new DecimalFormat("0.##").format(rational.doubleValue()) : ((GpsDirectory) this._directory).getString(i);
        if (format == null || format.trim().length() == 0) {
            return null;
        }
        return format.trim() + " degrees";
    }

    @Nullable
    public String getGpsDirectionReferenceDescription(int i) {
        String string = ((GpsDirectory) this._directory).getString(i);
        if (string == null) {
            return null;
        }
        String trim = string.trim();
        if (ExifInterface.GPS_DIRECTION_TRUE.equalsIgnoreCase(trim)) {
            return "True direction";
        }
        if ("M".equalsIgnoreCase(trim)) {
            return "Magnetic direction";
        }
        return "Unknown (" + trim + ")";
    }

    @Nullable
    public String getGpsSpeedRefDescription() {
        String string = ((GpsDirectory) this._directory).getString(12);
        if (string == null) {
            return null;
        }
        String trim = string.trim();
        if ("K".equalsIgnoreCase(trim)) {
            return "kph";
        }
        if ("M".equalsIgnoreCase(trim)) {
            return "mph";
        }
        if ("N".equalsIgnoreCase(trim)) {
            return "knots";
        }
        return "Unknown (" + trim + ")";
    }

    @Nullable
    public String getGpsMeasureModeDescription() {
        String string = ((GpsDirectory) this._directory).getString(10);
        if (string == null) {
            return null;
        }
        String trim = string.trim();
        if (ExifInterface.GPS_MEASUREMENT_2D.equalsIgnoreCase(trim)) {
            return "2-dimensional measurement";
        }
        if (ExifInterface.GPS_MEASUREMENT_3D.equalsIgnoreCase(trim)) {
            return "3-dimensional measurement";
        }
        return "Unknown (" + trim + ")";
    }

    @Nullable
    public String getGpsStatusDescription() {
        String string = ((GpsDirectory) this._directory).getString(9);
        if (string == null) {
            return null;
        }
        String trim = string.trim();
        if (ExifInterface.GPS_MEASUREMENT_IN_PROGRESS.equalsIgnoreCase(trim)) {
            return "Active (Measurement in progress)";
        }
        if (ExifInterface.GPS_MEASUREMENT_INTERRUPTED.equalsIgnoreCase(trim)) {
            return "Void (Measurement Interoperability)";
        }
        return "Unknown (" + trim + ")";
    }

    @Nullable
    public String getGpsAltitudeRefDescription() {
        return getIndexedDescription(5, "Sea level", "Below sea level");
    }

    @Nullable
    public String getGpsAltitudeDescription() {
        Rational rational = ((GpsDirectory) this._directory).getRational(6);
        if (rational == null) {
            return null;
        }
        return rational.intValue() + " metres";
    }

    @Nullable
    public String getGpsDifferentialDescription() {
        return getIndexedDescription(30, "No Correction", "Differential Corrected");
    }

    @Nullable
    public String getDegreesMinutesSecondsDescription() {
        GeoLocation geoLocation = ((GpsDirectory) this._directory).getGeoLocation();
        if (geoLocation == null) {
            return null;
        }
        return geoLocation.toDMSString();
    }
}
