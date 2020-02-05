package com.drew.metadata.png;

import androidx.exifinterface.media.ExifInterface;
import com.drew.imaging.png.PngColorType;
import com.drew.lang.KeyValuePair;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;
import java.io.IOException;
import java.util.List;

public class PngDescriptor extends TagDescriptor<PngDirectory> {
    public PngDescriptor(@NotNull PngDirectory pngDirectory) {
        super(pngDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 4) {
            return getColorTypeDescription();
        }
        if (i == 5) {
            return getCompressionTypeDescription();
        }
        if (i == 6) {
            return getFilterMethodDescription();
        }
        if (i == 7) {
            return getInterlaceMethodDescription();
        }
        if (i == 9) {
            return getPaletteHasTransparencyDescription();
        }
        if (i == 10) {
            return getIsSrgbColorSpaceDescription();
        }
        if (i == 13) {
            return getTextualDataDescription();
        }
        if (i == 15) {
            return getBackgroundColorDescription();
        }
        if (i != 18) {
            return super.getDescription(i);
        }
        return getUnitSpecifierDescription();
    }

    @Nullable
    public String getColorTypeDescription() {
        PngColorType fromNumericValue;
        Integer integer = ((PngDirectory) this._directory).getInteger(4);
        if (integer == null || (fromNumericValue = PngColorType.fromNumericValue(integer.intValue())) == null) {
            return null;
        }
        return fromNumericValue.getDescription();
    }

    @Nullable
    public String getCompressionTypeDescription() {
        return getIndexedDescription(5, "Deflate");
    }

    @Nullable
    public String getFilterMethodDescription() {
        return getIndexedDescription(6, "Adaptive");
    }

    @Nullable
    public String getInterlaceMethodDescription() {
        return getIndexedDescription(7, "No Interlace", "Adam7 Interlace");
    }

    @Nullable
    public String getPaletteHasTransparencyDescription() {
        return getIndexedDescription(9, null, "Yes");
    }

    @Nullable
    public String getIsSrgbColorSpaceDescription() {
        return getIndexedDescription(10, "Perceptual", "Relative Colorimetric", ExifInterface.TAG_SATURATION, "Absolute Colorimetric");
    }

    @Nullable
    public String getUnitSpecifierDescription() {
        return getIndexedDescription(18, "Unspecified", "Metres");
    }

    @Nullable
    public String getTextualDataDescription() {
        Object object = ((PngDirectory) this._directory).getObject(13);
        if (object == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (KeyValuePair keyValuePair : (List) object) {
            if (sb.length() != 0) {
                sb.append(10);
            }
            sb.append(String.format("%s: %s", new Object[]{keyValuePair.getKey(), keyValuePair.getValue()}));
        }
        return sb.toString();
    }

    @Nullable
    public String getBackgroundColorDescription() {
        byte[] byteArray = ((PngDirectory) this._directory).getByteArray(15);
        Integer integer = ((PngDirectory) this._directory).getInteger(4);
        if (!(byteArray == null || integer == null)) {
            SequentialByteArrayReader sequentialByteArrayReader = new SequentialByteArrayReader(byteArray);
            try {
                int intValue = integer.intValue();
                if (intValue != 0) {
                    if (intValue == 6 || intValue == 2) {
                        return String.format("R %d, G %d, B %d", new Object[]{Integer.valueOf(sequentialByteArrayReader.getUInt16()), Integer.valueOf(sequentialByteArrayReader.getUInt16()), Integer.valueOf(sequentialByteArrayReader.getUInt16())});
                    } else if (intValue == 3) {
                        return String.format("Palette Index %d", new Object[]{Short.valueOf(sequentialByteArrayReader.getUInt8())});
                    } else if (intValue != 4) {
                        return null;
                    }
                }
                return String.format("Greyscale Level %d", new Object[]{Integer.valueOf(sequentialByteArrayReader.getUInt16())});
            } catch (IOException unused) {
            }
        }
        return null;
    }
}
