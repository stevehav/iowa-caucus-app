package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.Rational;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class FujifilmMakernoteDescriptor extends TagDescriptor<FujifilmMakernoteDirectory> {
    public FujifilmMakernoteDescriptor(@NotNull FujifilmMakernoteDirectory fujifilmMakernoteDirectory) {
        super(fujifilmMakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 0) {
            return getMakernoteVersionDescription();
        }
        if (i == 4102) {
            return getContrastDescription();
        }
        if (i == 4107) {
            return getNoiseReductionDescription();
        }
        if (i == 4110) {
            return getHighIsoNoiseReductionDescription();
        }
        if (i == 4352) {
            return getAutoBracketingDescription();
        }
        if (i == 4624) {
            return getFinePixColorDescription();
        }
        if (i == 4112) {
            return getFlashModeDescription();
        }
        if (i == 4113) {
            return getFlashExposureValueDescription();
        }
        if (i == 4128) {
            return getMacroDescription();
        }
        if (i == 4129) {
            return getFocusModeDescription();
        }
        if (i == 4144) {
            return getSlowSyncDescription();
        }
        if (i == 4145) {
            return getPictureModeDescription();
        }
        if (i == 4147) {
            return getExrAutoDescription();
        }
        if (i == 4148) {
            return getExrModeDescription();
        }
        switch (i) {
            case 4097:
                return getSharpnessDescription();
            case 4098:
                return getWhiteBalanceDescription();
            case 4099:
                return getColorSaturationDescription();
            case 4100:
                return getToneDescription();
            default:
                switch (i) {
                    case FujifilmMakernoteDirectory.TAG_BLUR_WARNING:
                        return getBlurWarningDescription();
                    case FujifilmMakernoteDirectory.TAG_FOCUS_WARNING:
                        return getFocusWarningDescription();
                    case FujifilmMakernoteDirectory.TAG_AUTO_EXPOSURE_WARNING:
                        return getAutoExposureWarningDescription();
                    default:
                        switch (i) {
                            case FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE:
                                return getDynamicRangeDescription();
                            case FujifilmMakernoteDirectory.TAG_FILM_MODE:
                                return getFilmModeDescription();
                            case FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE_SETTING:
                                return getDynamicRangeSettingDescription();
                            default:
                                return super.getDescription(i);
                        }
                }
        }
    }

    @Nullable
    private String getMakernoteVersionDescription() {
        return getVersionBytesDescription(0, 2);
    }

    @Nullable
    public String getSharpnessDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4097);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 1) {
            return "Softest";
        }
        if (intValue == 2) {
            return "Soft";
        }
        if (intValue == 3) {
            return "Normal";
        }
        if (intValue == 4) {
            return "Hard";
        }
        if (intValue == 5) {
            return "Hardest";
        }
        if (intValue == 130) {
            return "Medium Soft";
        }
        if (intValue == 132) {
            return "Medium Hard";
        }
        if (intValue == 32768) {
            return "Film Simulation";
        }
        if (intValue == 65535) {
            return "N/A";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getWhiteBalanceDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4098);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Auto";
        }
        if (intValue == 256) {
            return "Daylight";
        }
        if (intValue == 512) {
            return "Cloudy";
        }
        if (intValue == 1024) {
            return "Incandescence";
        }
        if (intValue == 1280) {
            return ExifInterface.TAG_FLASH;
        }
        if (intValue == 4080) {
            return "Kelvin";
        }
        switch (intValue) {
            case 768:
                return "Daylight Fluorescent";
            case 769:
                return "Day White Fluorescent";
            case 770:
                return "White Fluorescent";
            case 771:
                return "Warm White Fluorescent";
            case 772:
                return "Living Room Warm White Fluorescent";
            default:
                switch (intValue) {
                    case 3840:
                        return "Custom White Balance";
                    case OlympusMakernoteDirectory.TAG_DATA_DUMP_2 /*3841*/:
                        return "Custom White Balance 2";
                    case 3842:
                        return "Custom White Balance 3";
                    case 3843:
                        return "Custom White Balance 4";
                    case 3844:
                        return "Custom White Balance 5";
                    default:
                        return "Unknown (" + integer + ")";
                }
        }
    }

    @Nullable
    public String getColorSaturationDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4099);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue == 128) {
            return "Medium High";
        }
        if (intValue == 256) {
            return "High";
        }
        if (intValue == 384) {
            return "Medium Low";
        }
        if (intValue == 512) {
            return "Low";
        }
        if (intValue == 32768) {
            return "Film Simulation";
        }
        switch (intValue) {
            case 768:
                return "None (B&W)";
            case 769:
                return "B&W Green Filter";
            case 770:
                return "B&W Yellow Filter";
            case 771:
                return "B&W Blue Filter";
            case 772:
                return "B&W Sepia";
            default:
                return "Unknown (" + integer + ")";
        }
    }

    @Nullable
    public String getToneDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4100);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue == 128) {
            return "Medium High";
        }
        if (intValue == 256) {
            return "High";
        }
        if (intValue == 384) {
            return "Medium Low";
        }
        if (intValue == 512) {
            return "Low";
        }
        if (intValue == 768) {
            return "None (B&W)";
        }
        if (intValue == 32768) {
            return "Film Simulation";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getContrastDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4102);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue == 256) {
            return "High";
        }
        if (intValue == 768) {
            return "Low";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getNoiseReductionDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4107);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 64) {
            return "Low";
        }
        if (intValue == 128) {
            return "Normal";
        }
        if (intValue == 256) {
            return "N/A";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getHighIsoNoiseReductionDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4110);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Normal";
        }
        if (intValue == 256) {
            return "Strong";
        }
        if (intValue == 512) {
            return "Weak";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getFlashModeDescription() {
        return getIndexedDescription(4112, "Auto", "On", "Off", "Red-eye Reduction", "External");
    }

    @Nullable
    public String getFlashExposureValueDescription() {
        Rational rational = ((FujifilmMakernoteDirectory) this._directory).getRational(4113);
        if (rational == null) {
            return null;
        }
        return rational.toSimpleString(false) + " EV (Apex)";
    }

    @Nullable
    public String getMacroDescription() {
        return getIndexedDescription(4128, "Off", "On");
    }

    @Nullable
    public String getFocusModeDescription() {
        return getIndexedDescription(4129, "Auto Focus", "Manual Focus");
    }

    @Nullable
    public String getSlowSyncDescription() {
        return getIndexedDescription(4144, "Off", "On");
    }

    @Nullable
    public String getPictureModeDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4145);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 27) {
            return "Dog Face Detection";
        }
        if (intValue == 28) {
            return "Cat Face Detection";
        }
        if (intValue == 256) {
            return "Aperture priority AE";
        }
        if (intValue == 512) {
            return "Shutter priority AE";
        }
        if (intValue == 768) {
            return "Manual exposure";
        }
        switch (intValue) {
            case 0:
                return "Auto";
            case 1:
                return "Portrait scene";
            case 2:
                return "Landscape scene";
            case 3:
                return "Macro";
            case 4:
                return "Sports scene";
            case 5:
                return "Night scene";
            case 6:
                return "Program AE";
            case 7:
                return "Natural Light";
            case 8:
                return "Anti-blur";
            case 9:
                return "Beach & Snow";
            case 10:
                return "Sunset";
            case 11:
                return "Museum";
            case 12:
                return "Party";
            case 13:
                return "Flower";
            case 14:
                return "Text";
            case 15:
                return "Natural Light & Flash";
            case 16:
                return "Beach";
            case 17:
                return "Snow";
            case 18:
                return "Fireworks";
            case 19:
                return "Underwater";
            case 20:
                return "Portrait with Skin Correction";
            default:
                switch (intValue) {
                    case 22:
                        return "Panorama";
                    case 23:
                        return "Night (Tripod)";
                    case 24:
                        return "Pro Low-light";
                    case 25:
                        return "Pro Focus";
                    default:
                        return "Unknown (" + integer + ")";
                }
        }
    }

    @Nullable
    public String getExrAutoDescription() {
        return getIndexedDescription(4147, "Auto", "Manual");
    }

    @Nullable
    public String getExrModeDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(4148);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 256) {
            return "HR (High Resolution)";
        }
        if (intValue == 512) {
            return "SN (Signal to Noise Priority)";
        }
        if (intValue == 768) {
            return "DR (Dynamic Range Priority)";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getAutoBracketingDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_AUTO_BRACKETING, "Off", "On", "No Flash & Flash");
    }

    @Nullable
    public String getFinePixColorDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(FujifilmMakernoteDirectory.TAG_FINE_PIX_COLOR);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Standard";
        }
        if (intValue == 16) {
            return "Chrome";
        }
        if (intValue == 48) {
            return "B&W";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getBlurWarningDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_BLUR_WARNING, "No Blur Warning", "Blur warning");
    }

    @Nullable
    public String getFocusWarningDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_FOCUS_WARNING, "Good Focus", "Out Of Focus");
    }

    @Nullable
    public String getAutoExposureWarningDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_AUTO_EXPOSURE_WARNING, "AE Good", "Over Exposed");
    }

    @Nullable
    public String getDynamicRangeDescription() {
        return getIndexedDescription(FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE, 1, "Standard", null, "Wide");
    }

    @Nullable
    public String getFilmModeDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(FujifilmMakernoteDirectory.TAG_FILM_MODE);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "F0/Standard (Provia) ";
        }
        if (intValue == 256) {
            return "F1/Studio Portrait";
        }
        if (intValue == 272) {
            return "F1a/Studio Portrait Enhanced Saturation";
        }
        if (intValue == 288) {
            return "F1b/Studio Portrait Smooth Skin Tone (Astia)";
        }
        if (intValue == 304) {
            return "F1c/Studio Portrait Increased Sharpness";
        }
        if (intValue == 512) {
            return "F2/Fujichrome (Velvia)";
        }
        if (intValue == 768) {
            return "F3/Studio Portrait Ex";
        }
        if (intValue == 1024) {
            return "F4/Velvia";
        }
        if (intValue == 1280) {
            return "Pro Neg. Std";
        }
        if (intValue == 1281) {
            return "Pro Neg. Hi";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getDynamicRangeSettingDescription() {
        Integer integer = ((FujifilmMakernoteDirectory) this._directory).getInteger(FujifilmMakernoteDirectory.TAG_DYNAMIC_RANGE_SETTING);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Auto (100-400%)";
        }
        if (intValue == 1) {
            return "Manual";
        }
        if (intValue == 256) {
            return "Standard (100%)";
        }
        if (intValue == 32768) {
            return "Film Simulation";
        }
        if (intValue == 512) {
            return "Wide 1 (230%)";
        }
        if (intValue == 513) {
            return "Wide 2 (400%)";
        }
        return "Unknown (" + integer + ")";
    }
}
