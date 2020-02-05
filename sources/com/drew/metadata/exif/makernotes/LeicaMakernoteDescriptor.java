package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class LeicaMakernoteDescriptor extends TagDescriptor<LeicaMakernoteDirectory> {
    public LeicaMakernoteDescriptor(@NotNull LeicaMakernoteDirectory leicaMakernoteDirectory) {
        super(leicaMakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 768) {
            return getQualityDescription();
        }
        if (i == 770) {
            return getUserProfileDescription();
        }
        if (i == 772) {
            return getWhiteBalanceDescription();
        }
        if (i == 800) {
            return getCameraTemperatureDescription();
        }
        switch (i) {
            case 785:
                return getExternalSensorBrightnessValueDescription();
            case LeicaMakernoteDirectory.TAG_MEASURED_LV /*786*/:
                return getMeasuredLvDescription();
            case LeicaMakernoteDirectory.TAG_APPROXIMATE_F_NUMBER /*787*/:
                return getApproximateFNumberDescription();
            default:
                switch (i) {
                    case LeicaMakernoteDirectory.TAG_WB_RED_LEVEL /*802*/:
                    case LeicaMakernoteDirectory.TAG_WB_GREEN_LEVEL /*803*/:
                    case LeicaMakernoteDirectory.TAG_WB_BLUE_LEVEL /*804*/:
                        return getSimpleRational(i);
                    default:
                        return super.getDescription(i);
                }
        }
    }

    @Nullable
    private String getCameraTemperatureDescription() {
        return getFormattedInt(800, "%d C");
    }

    @Nullable
    private String getApproximateFNumberDescription() {
        return getSimpleRational(LeicaMakernoteDirectory.TAG_APPROXIMATE_F_NUMBER);
    }

    @Nullable
    private String getMeasuredLvDescription() {
        return getSimpleRational(LeicaMakernoteDirectory.TAG_MEASURED_LV);
    }

    @Nullable
    private String getExternalSensorBrightnessValueDescription() {
        return getSimpleRational(785);
    }

    @Nullable
    private String getWhiteBalanceDescription() {
        return getIndexedDescription(772, "Auto or Manual", "Daylight", "Fluorescent", "Tungsten", ExifInterface.TAG_FLASH, "Cloudy", "Shadow");
    }

    @Nullable
    private String getUserProfileDescription() {
        return getIndexedDescription(768, 1, "User Profile 1", "User Profile 2", "User Profile 3", "User Profile 0 (Dynamic)");
    }

    @Nullable
    private String getQualityDescription() {
        return getIndexedDescription(768, 1, "Fine", "Basic");
    }
}
