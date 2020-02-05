package com.drew.metadata.exif;

import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.GeoLocation;
import com.drew.lang.Rational;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class GpsDirectory extends ExifDirectoryBase {
    public static final int TAG_ALTITUDE = 6;
    public static final int TAG_ALTITUDE_REF = 5;
    public static final int TAG_AREA_INFORMATION = 28;
    public static final int TAG_DATE_STAMP = 29;
    public static final int TAG_DEST_BEARING = 24;
    public static final int TAG_DEST_BEARING_REF = 23;
    public static final int TAG_DEST_DISTANCE = 26;
    public static final int TAG_DEST_DISTANCE_REF = 25;
    public static final int TAG_DEST_LATITUDE = 20;
    public static final int TAG_DEST_LATITUDE_REF = 19;
    public static final int TAG_DEST_LONGITUDE = 22;
    public static final int TAG_DEST_LONGITUDE_REF = 21;
    public static final int TAG_DIFFERENTIAL = 30;
    public static final int TAG_DOP = 11;
    public static final int TAG_IMG_DIRECTION = 17;
    public static final int TAG_IMG_DIRECTION_REF = 16;
    public static final int TAG_LATITUDE = 2;
    public static final int TAG_LATITUDE_REF = 1;
    public static final int TAG_LONGITUDE = 4;
    public static final int TAG_LONGITUDE_REF = 3;
    public static final int TAG_MAP_DATUM = 18;
    public static final int TAG_MEASURE_MODE = 10;
    public static final int TAG_PROCESSING_METHOD = 27;
    public static final int TAG_SATELLITES = 8;
    public static final int TAG_SPEED = 13;
    public static final int TAG_SPEED_REF = 12;
    public static final int TAG_STATUS = 9;
    public static final int TAG_TIME_STAMP = 7;
    public static final int TAG_TRACK = 15;
    public static final int TAG_TRACK_REF = 14;
    public static final int TAG_VERSION_ID = 0;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "GPS";
    }

    static {
        addExifTagNames(_tagNameMap);
        _tagNameMap.put(0, "GPS Version ID");
        _tagNameMap.put(1, "GPS Latitude Ref");
        _tagNameMap.put(2, "GPS Latitude");
        _tagNameMap.put(3, "GPS Longitude Ref");
        _tagNameMap.put(4, "GPS Longitude");
        _tagNameMap.put(5, "GPS Altitude Ref");
        _tagNameMap.put(6, "GPS Altitude");
        _tagNameMap.put(7, "GPS Time-Stamp");
        _tagNameMap.put(8, "GPS Satellites");
        _tagNameMap.put(9, "GPS Status");
        _tagNameMap.put(10, "GPS Measure Mode");
        _tagNameMap.put(11, "GPS DOP");
        _tagNameMap.put(12, "GPS Speed Ref");
        _tagNameMap.put(13, "GPS Speed");
        _tagNameMap.put(14, "GPS Track Ref");
        _tagNameMap.put(15, "GPS Track");
        _tagNameMap.put(16, "GPS Img Direction Ref");
        _tagNameMap.put(17, "GPS Img Direction");
        _tagNameMap.put(18, "GPS Map Datum");
        _tagNameMap.put(19, "GPS Dest Latitude Ref");
        _tagNameMap.put(20, "GPS Dest Latitude");
        _tagNameMap.put(21, "GPS Dest Longitude Ref");
        _tagNameMap.put(22, "GPS Dest Longitude");
        _tagNameMap.put(23, "GPS Dest Bearing Ref");
        _tagNameMap.put(24, "GPS Dest Bearing");
        _tagNameMap.put(25, "GPS Dest Distance Ref");
        _tagNameMap.put(26, "GPS Dest Distance");
        _tagNameMap.put(27, "GPS Processing Method");
        _tagNameMap.put(28, "GPS Area Information");
        _tagNameMap.put(29, "GPS Date Stamp");
        _tagNameMap.put(30, "GPS Differential");
    }

    public GpsDirectory() {
        setDescriptor(new GpsDescriptor(this));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    @Nullable
    public GeoLocation getGeoLocation() {
        Rational[] rationalArray = getRationalArray(2);
        Rational[] rationalArray2 = getRationalArray(4);
        String string = getString(1);
        String string2 = getString(3);
        if (!(rationalArray == null || rationalArray.length != 3 || rationalArray2 == null || rationalArray2.length != 3 || string == null || string2 == null)) {
            Double degreesMinutesSecondsToDecimal = GeoLocation.degreesMinutesSecondsToDecimal(rationalArray[0], rationalArray[1], rationalArray[2], string.equalsIgnoreCase(ExifInterface.LATITUDE_SOUTH));
            Double degreesMinutesSecondsToDecimal2 = GeoLocation.degreesMinutesSecondsToDecimal(rationalArray2[0], rationalArray2[1], rationalArray2[2], string2.equalsIgnoreCase(ExifInterface.LONGITUDE_WEST));
            if (!(degreesMinutesSecondsToDecimal == null || degreesMinutesSecondsToDecimal2 == null)) {
                return new GeoLocation(degreesMinutesSecondsToDecimal.doubleValue(), degreesMinutesSecondsToDecimal2.doubleValue());
            }
        }
        return null;
    }

    @Nullable
    public Date getGpsDate() {
        String string = getString(29);
        Rational[] rationalArray = getRationalArray(7);
        if (!(string == null || rationalArray == null || rationalArray.length != 3)) {
            try {
                return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss.S z").parse(String.format(Locale.US, "%s %02d:%02d:%02.3f UTC", new Object[]{string, Integer.valueOf(rationalArray[0].intValue()), Integer.valueOf(rationalArray[1].intValue()), Double.valueOf(rationalArray[2].doubleValue())}));
            } catch (ParseException unused) {
            }
        }
        return null;
    }
}
