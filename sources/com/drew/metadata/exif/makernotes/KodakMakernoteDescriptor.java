package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class KodakMakernoteDescriptor extends TagDescriptor<KodakMakernoteDirectory> {
    public KodakMakernoteDescriptor(@NotNull KodakMakernoteDirectory kodakMakernoteDirectory) {
        super(kodakMakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 9) {
            return getQualityDescription();
        }
        if (i == 10) {
            return getBurstModeDescription();
        }
        if (i == 27) {
            return getShutterModeDescription();
        }
        if (i == 56) {
            return getFocusModeDescription();
        }
        if (i == 64) {
            return getWhiteBalanceDescription();
        }
        if (i == 102) {
            return getColorModeDescription();
        }
        if (i == 107) {
            return getSharpnessDescription();
        }
        if (i == 92) {
            return getFlashModeDescription();
        }
        if (i != 93) {
            return super.getDescription(i);
        }
        return getFlashFiredDescription();
    }

    @Nullable
    public String getSharpnessDescription() {
        return getIndexedDescription(107, "Normal");
    }

    @Nullable
    public String getColorModeDescription() {
        Integer integer = ((KodakMakernoteDirectory) this._directory).getInteger(102);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 1) {
            return "B&W";
        }
        if (intValue == 2) {
            return "Sepia";
        }
        if (intValue == 3) {
            return "B&W Yellow Filter";
        }
        if (intValue == 4) {
            return "B&W Red Filter";
        }
        if (intValue == 32) {
            return "Saturated Color";
        }
        if (intValue == 64) {
            return "Neutral Color";
        }
        if (intValue == 256) {
            return "Saturated Color";
        }
        if (intValue == 512) {
            return "Neutral Color";
        }
        if (intValue == 8192) {
            return "B&W";
        }
        if (intValue == 16384) {
            return "Sepia";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getFlashFiredDescription() {
        return getIndexedDescription(93, "No", "Yes");
    }

    @Nullable
    public String getFlashModeDescription() {
        Integer integer = ((KodakMakernoteDirectory) this._directory).getInteger(92);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Auto";
        }
        if (intValue == 1) {
            return "Fill Flash";
        }
        if (intValue == 2) {
            return "Off";
        }
        if (intValue == 3) {
            return "Red Eye";
        }
        if (intValue == 16) {
            return "Fill Flash";
        }
        if (intValue == 32) {
            return "Off";
        }
        if (intValue == 64) {
            return "Red Eye";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getWhiteBalanceDescription() {
        return getIndexedDescription(64, "Auto", ExifInterface.TAG_FLASH, "Tungsten", "Daylight");
    }

    @Nullable
    public String getFocusModeDescription() {
        return getIndexedDescription(56, "Normal", null, "Macro");
    }

    @Nullable
    public String getShutterModeDescription() {
        Integer integer = ((KodakMakernoteDirectory) this._directory).getInteger(27);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Auto";
        }
        if (intValue == 8) {
            return "Aperture Priority";
        }
        if (intValue == 32) {
            return "Manual";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getBurstModeDescription() {
        return getIndexedDescription(10, "Off", "On");
    }

    @Nullable
    public String getQualityDescription() {
        return getIndexedDescription(9, 1, "Fine", "Normal");
    }
}
