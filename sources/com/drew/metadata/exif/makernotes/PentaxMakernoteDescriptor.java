package com.drew.metadata.exif.makernotes;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class PentaxMakernoteDescriptor extends TagDescriptor<PentaxMakernoteDirectory> {
    public PentaxMakernoteDescriptor(@NotNull PentaxMakernoteDirectory pentaxMakernoteDirectory) {
        super(pentaxMakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 1) {
            return getCaptureModeDescription();
        }
        if (i == 2) {
            return getQualityLevelDescription();
        }
        if (i == 3) {
            return getFocusModeDescription();
        }
        if (i == 4) {
            return getFlashModeDescription();
        }
        if (i == 7) {
            return getWhiteBalanceDescription();
        }
        if (i == 20) {
            return getIsoSpeedDescription();
        }
        if (i == 23) {
            return getColourDescription();
        }
        switch (i) {
            case 10:
                return getDigitalZoomDescription();
            case 11:
                return getSharpnessDescription();
            case 12:
                return getContrastDescription();
            case 13:
                return getSaturationDescription();
            default:
                return super.getDescription(i);
        }
    }

    @Nullable
    public String getColourDescription() {
        return getIndexedDescription(23, 1, "Normal", "Black & White", "Sepia");
    }

    @Nullable
    public String getIsoSpeedDescription() {
        Integer integer = ((PentaxMakernoteDirectory) this._directory).getInteger(20);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 10) {
            return "ISO 100";
        }
        if (intValue == 16) {
            return "ISO 200";
        }
        if (intValue == 100) {
            return "ISO 100";
        }
        if (intValue == 200) {
            return "ISO 200";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getSaturationDescription() {
        return getIndexedDescription(13, "Normal", "Low", "High");
    }

    @Nullable
    public String getContrastDescription() {
        return getIndexedDescription(12, "Normal", "Low", "High");
    }

    @Nullable
    public String getSharpnessDescription() {
        return getIndexedDescription(11, "Normal", "Soft", "Hard");
    }

    @Nullable
    public String getDigitalZoomDescription() {
        Float floatObject = ((PentaxMakernoteDirectory) this._directory).getFloatObject(10);
        if (floatObject == null) {
            return null;
        }
        if (floatObject.floatValue() == 0.0f) {
            return "Off";
        }
        return Float.toString(floatObject.floatValue());
    }

    @Nullable
    public String getWhiteBalanceDescription() {
        return getIndexedDescription(7, "Auto", "Daylight", "Shade", "Tungsten", "Fluorescent", "Manual");
    }

    @Nullable
    public String getFlashModeDescription() {
        return getIndexedDescription(4, 1, "Auto", "Flash On", null, "Flash Off", null, "Red-eye Reduction");
    }

    @Nullable
    public String getFocusModeDescription() {
        return getIndexedDescription(3, 2, "Custom", "Auto");
    }

    @Nullable
    public String getQualityLevelDescription() {
        return getIndexedDescription(2, "Good", "Better", "Best");
    }

    @Nullable
    public String getCaptureModeDescription() {
        return getIndexedDescription(1, "Auto", "Night-scene", "Manual", null, "Multiple");
    }
}
