package com.drew.metadata.bmp;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;
import com.drew.metadata.bmp.BmpHeaderDirectory;
import java.text.DecimalFormat;

public class BmpHeaderDescriptor extends TagDescriptor<BmpHeaderDirectory> {
    public BmpHeaderDescriptor(@NotNull BmpHeaderDirectory bmpHeaderDirectory) {
        super(bmpHeaderDirectory);
    }

    public String getDescription(int i) {
        if (i == -2) {
            return getBitmapTypeDescription();
        }
        if (i == 5) {
            return getCompressionDescription();
        }
        switch (i) {
            case 10:
                return getRenderingDescription();
            case 11:
                return getColorEncodingDescription();
            case 12:
            case 13:
            case 14:
            case 15:
                return formatHex(((BmpHeaderDirectory) this._directory).getLongObject(i), 8);
            case 16:
                return getColorSpaceTypeDescription();
            case 17:
            case 18:
            case 19:
                return formatFixed1616(((BmpHeaderDirectory) this._directory).getLongObject(i));
            case 20:
                return getRenderingIntentDescription();
            default:
                return super.getDescription(i);
        }
    }

    @Nullable
    public String getBitmapTypeDescription() {
        BmpHeaderDirectory.BitmapType bitmapType = ((BmpHeaderDirectory) this._directory).getBitmapType();
        if (bitmapType == null) {
            return null;
        }
        return bitmapType.toString();
    }

    @Nullable
    public String getCompressionDescription() {
        BmpHeaderDirectory.Compression compression = ((BmpHeaderDirectory) this._directory).getCompression();
        if (compression != null) {
            return compression.toString();
        }
        Integer integer = ((BmpHeaderDirectory) this._directory).getInteger(5);
        if (integer == null) {
            return null;
        }
        return "Illegal value 0x" + Integer.toHexString(integer.intValue());
    }

    @Nullable
    public String getRenderingDescription() {
        BmpHeaderDirectory.RenderingHalftoningAlgorithm rendering = ((BmpHeaderDirectory) this._directory).getRendering();
        if (rendering == null) {
            return null;
        }
        return rendering.toString();
    }

    @Nullable
    public String getColorEncodingDescription() {
        BmpHeaderDirectory.ColorEncoding colorEncoding = ((BmpHeaderDirectory) this._directory).getColorEncoding();
        if (colorEncoding == null) {
            return null;
        }
        return colorEncoding.toString();
    }

    @Nullable
    public String getColorSpaceTypeDescription() {
        BmpHeaderDirectory.ColorSpaceType colorSpaceType = ((BmpHeaderDirectory) this._directory).getColorSpaceType();
        if (colorSpaceType == null) {
            return null;
        }
        return colorSpaceType.toString();
    }

    @Nullable
    public String getRenderingIntentDescription() {
        BmpHeaderDirectory.RenderingIntent renderingIntent = ((BmpHeaderDirectory) this._directory).getRenderingIntent();
        if (renderingIntent == null) {
            return null;
        }
        return renderingIntent.toString();
    }

    @Nullable
    public static String formatHex(@Nullable Integer num, int i) {
        if (num == null) {
            return null;
        }
        return formatHex(((long) num.intValue()) & 4294967295L, i);
    }

    @NotNull
    public static String formatHex(int i, int i2) {
        return formatHex(((long) i) & 4294967295L, i2);
    }

    @Nullable
    public static String formatHex(@Nullable Long l, int i) {
        if (l == null) {
            return null;
        }
        return formatHex(l.longValue(), i);
    }

    @NotNull
    public static String formatHex(long j, int i) {
        return String.format("0x%0" + i + "X", new Object[]{Long.valueOf(j)});
    }

    @Nullable
    public static String formatFixed1616(Integer num) {
        if (num == null) {
            return null;
        }
        return formatFixed1616(((long) num.intValue()) & 4294967295L);
    }

    @NotNull
    public static String formatFixed1616(int i) {
        return formatFixed1616(((long) i) & 4294967295L);
    }

    @Nullable
    public static String formatFixed1616(Long l) {
        if (l == null) {
            return null;
        }
        return formatFixed1616(l.longValue());
    }

    @NotNull
    public static String formatFixed1616(long j) {
        double d = (double) j;
        Double.isNaN(d);
        return new DecimalFormat("0.###").format(Double.valueOf(d / 65536.0d));
    }
}
