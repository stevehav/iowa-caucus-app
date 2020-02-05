package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class CasioType2MakernoteDescriptor extends TagDescriptor<CasioType2MakernoteDirectory> {
    public CasioType2MakernoteDescriptor(@NotNull CasioType2MakernoteDirectory casioType2MakernoteDirectory) {
        super(casioType2MakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 2) {
            return getThumbnailDimensionsDescription();
        }
        if (i == 3) {
            return getThumbnailSizeDescription();
        }
        if (i == 4) {
            return getThumbnailOffsetDescription();
        }
        if (i == 8) {
            return getQualityModeDescription();
        }
        if (i == 9) {
            return getImageSizeDescription();
        }
        if (i == 13) {
            return getFocusMode1Description();
        }
        if (i == 20) {
            return getIsoSensitivityDescription();
        }
        if (i == 25) {
            return getWhiteBalance1Description();
        }
        if (i == 29) {
            return getFocalLengthDescription();
        }
        if (i == 8192) {
            return getCasioPreviewThumbnailDescription();
        }
        if (i == 8226) {
            return getObjectDistanceDescription();
        }
        if (i == 8244) {
            return getFlashDistanceDescription();
        }
        if (i == 12294) {
            return getTimeZoneDescription();
        }
        if (i == 8209) {
            return getWhiteBalanceBiasDescription();
        }
        if (i == 8210) {
            return getWhiteBalance2Description();
        }
        switch (i) {
            case 31:
                return getSaturationDescription();
            case 32:
                return getContrastDescription();
            case 33:
                return getSharpnessDescription();
            default:
                switch (i) {
                    case 12288:
                        return getRecordModeDescription();
                    case CasioType2MakernoteDirectory.TAG_SELF_TIMER /*12289*/:
                        return getSelfTimerDescription();
                    case CasioType2MakernoteDirectory.TAG_QUALITY /*12290*/:
                        return getQualityDescription();
                    case CasioType2MakernoteDirectory.TAG_FOCUS_MODE_2 /*12291*/:
                        return getFocusMode2Description();
                    default:
                        switch (i) {
                            case CasioType2MakernoteDirectory.TAG_CCD_ISO_SENSITIVITY /*12308*/:
                                return getCcdIsoSensitivityDescription();
                            case CasioType2MakernoteDirectory.TAG_COLOUR_MODE /*12309*/:
                                return getColourModeDescription();
                            case CasioType2MakernoteDirectory.TAG_ENHANCEMENT /*12310*/:
                                return getEnhancementDescription();
                            case CasioType2MakernoteDirectory.TAG_FILTER /*12311*/:
                                return getFilterDescription();
                            default:
                                return super.getDescription(i);
                        }
                }
        }
    }

    @Nullable
    public String getFilterDescription() {
        return getIndexedDescription(CasioType2MakernoteDirectory.TAG_FILTER, "Off");
    }

    @Nullable
    public String getEnhancementDescription() {
        return getIndexedDescription(CasioType2MakernoteDirectory.TAG_ENHANCEMENT, "Off");
    }

    @Nullable
    public String getColourModeDescription() {
        return getIndexedDescription(CasioType2MakernoteDirectory.TAG_COLOUR_MODE, "Off");
    }

    @Nullable
    public String getCcdIsoSensitivityDescription() {
        return getIndexedDescription(CasioType2MakernoteDirectory.TAG_CCD_ISO_SENSITIVITY, "Off", "On");
    }

    @Nullable
    public String getTimeZoneDescription() {
        return ((CasioType2MakernoteDirectory) this._directory).getString(CasioType2MakernoteDirectory.TAG_TIME_ZONE);
    }

    @Nullable
    public String getFocusMode2Description() {
        Integer integer = ((CasioType2MakernoteDirectory) this._directory).getInteger(CasioType2MakernoteDirectory.TAG_FOCUS_MODE_2);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 1) {
            return "Fixation";
        }
        if (intValue == 6) {
            return "Multi-Area Focus";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getQualityDescription() {
        return getIndexedDescription(CasioType2MakernoteDirectory.TAG_QUALITY, 3, "Fine");
    }

    @Nullable
    public String getSelfTimerDescription() {
        return getIndexedDescription(CasioType2MakernoteDirectory.TAG_SELF_TIMER, 1, "Off");
    }

    @Nullable
    public String getRecordModeDescription() {
        return getIndexedDescription(12288, 2, "Normal");
    }

    @Nullable
    public String getFlashDistanceDescription() {
        return getIndexedDescription(CasioType2MakernoteDirectory.TAG_FLASH_DISTANCE, "Off");
    }

    @Nullable
    public String getObjectDistanceDescription() {
        Integer integer = ((CasioType2MakernoteDirectory) this._directory).getInteger(8226);
        if (integer == null) {
            return null;
        }
        return Integer.toString(integer.intValue()) + " mm";
    }

    @Nullable
    public String getWhiteBalance2Description() {
        Integer integer = ((CasioType2MakernoteDirectory) this._directory).getInteger(8210);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Manual";
        }
        if (intValue == 1) {
            return "Auto";
        }
        if (intValue == 4 || intValue == 12) {
            return ExifInterface.TAG_FLASH;
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getWhiteBalanceBiasDescription() {
        return ((CasioType2MakernoteDirectory) this._directory).getString(8209);
    }

    @Nullable
    public String getCasioPreviewThumbnailDescription() {
        byte[] byteArray = ((CasioType2MakernoteDirectory) this._directory).getByteArray(8192);
        if (byteArray == null) {
            return null;
        }
        return "<" + byteArray.length + " bytes of image data>";
    }

    @Nullable
    public String getSharpnessDescription() {
        return getIndexedDescription(33, "-1", "Normal", "+1");
    }

    @Nullable
    public String getContrastDescription() {
        return getIndexedDescription(32, "-1", "Normal", "+1");
    }

    @Nullable
    public String getSaturationDescription() {
        return getIndexedDescription(31, "-1", "Normal", "+1");
    }

    @Nullable
    public String getFocalLengthDescription() {
        Double doubleObject = ((CasioType2MakernoteDirectory) this._directory).getDoubleObject(29);
        if (doubleObject == null) {
            return null;
        }
        return getFocalLengthDescription(doubleObject.doubleValue() / 10.0d);
    }

    @Nullable
    public String getWhiteBalance1Description() {
        return getIndexedDescription(25, "Auto", "Daylight", "Shade", "Tungsten", "Florescent", "Manual");
    }

    @Nullable
    public String getIsoSensitivityDescription() {
        Integer integer = ((CasioType2MakernoteDirectory) this._directory).getInteger(20);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 3) {
            return "50";
        }
        if (intValue == 4) {
            return "64";
        }
        if (intValue == 6) {
            return "100";
        }
        if (intValue == 9) {
            return "200";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getFocusMode1Description() {
        return getIndexedDescription(13, "Normal", "Macro");
    }

    @Nullable
    public String getImageSizeDescription() {
        Integer integer = ((CasioType2MakernoteDirectory) this._directory).getInteger(9);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "640 x 480 pixels";
        }
        if (intValue == 36) {
            return "3008 x 2008 pixels";
        }
        if (intValue == 4) {
            return "1600 x 1200 pixels";
        }
        if (intValue == 5) {
            return "2048 x 1536 pixels";
        }
        switch (intValue) {
            case 20:
                return "2288 x 1712 pixels";
            case 21:
                return "2592 x 1944 pixels";
            case 22:
                return "2304 x 1728 pixels";
            default:
                return "Unknown (" + integer + ")";
        }
    }

    @Nullable
    public String getQualityModeDescription() {
        return getIndexedDescription(8, 1, "Fine", "Super Fine");
    }

    @Nullable
    public String getThumbnailOffsetDescription() {
        return ((CasioType2MakernoteDirectory) this._directory).getString(4);
    }

    @Nullable
    public String getThumbnailSizeDescription() {
        Integer integer = ((CasioType2MakernoteDirectory) this._directory).getInteger(3);
        if (integer == null) {
            return null;
        }
        return Integer.toString(integer.intValue()) + " bytes";
    }

    @Nullable
    public String getThumbnailDimensionsDescription() {
        int[] intArray = ((CasioType2MakernoteDirectory) this._directory).getIntArray(2);
        if (intArray == null || intArray.length != 2) {
            return ((CasioType2MakernoteDirectory) this._directory).getString(2);
        }
        return intArray[0] + " x " + intArray[1] + " pixels";
    }
}
