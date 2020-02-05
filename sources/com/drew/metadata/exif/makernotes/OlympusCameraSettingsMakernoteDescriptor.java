package com.drew.metadata.exif.makernotes;

import com.drew.lang.Rational;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;
import java.text.DecimalFormat;
import java.util.HashMap;

public class OlympusCameraSettingsMakernoteDescriptor extends TagDescriptor<OlympusCameraSettingsMakernoteDirectory> {
    private static final HashMap<Integer, String> _filters = new HashMap<>();
    private static final HashMap<Integer, String> _toneLevelType = new HashMap<>();

    public OlympusCameraSettingsMakernoteDescriptor(@NotNull OlympusCameraSettingsMakernoteDirectory olympusCameraSettingsMakernoteDirectory) {
        super(olympusCameraSettingsMakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i != 0) {
            if (i == 1280) {
                return getWhiteBalance2Description();
            }
            if (i == 1281) {
                return getWhiteBalanceTemperatureDescription();
            }
            if (i == 1312) {
                return getPictureModeDescription();
            }
            if (i == 1313) {
                return getPictureModeSaturationDescription();
            }
            if (i == 1536) {
                return getDriveModeDescription();
            }
            if (i == 1537) {
                return getPanoramaModeDescription();
            }
            switch (i) {
                case 0:
                    break;
                case 256:
                    return getPreviewImageValidDescription();
                case 768:
                    return getMacroModeDescription();
                case 769:
                    return getFocusModeDescription();
                case 770:
                    return getFocusProcessDescription();
                case 771:
                    return getAfSearchDescription();
                case 772:
                    return getAfAreasDescription();
                case 773:
                    return getAfPointSelectedDescription();
                case 774:
                    return getAfFineTuneDescription();
                case 1024:
                    return getFlashModeDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagGradation /*1295*/:
                    return getGradationDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagArtFilter /*1321*/:
                    return getArtFilterDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagColorCreatorEffect /*1330*/:
                    return getColorCreatorEffectDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagImageQuality2 /*1539*/:
                    return getImageQuality2Description();
                case OlympusCameraSettingsMakernoteDirectory.TagImageStabilization /*1540*/:
                    return getImageStabilizationDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagStackedImage /*2052*/:
                    return getStackedImageDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagManometerPressure /*2304*/:
                    return getManometerPressureDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagManometerReading /*2305*/:
                    return getManometerReadingDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagExtendedWBDetect /*2306*/:
                    return getExtendedWBDetectDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagRollAngle /*2307*/:
                    return getRollAngleDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagPitchAngle /*2308*/:
                    return getPitchAngleDescription();
                case OlympusCameraSettingsMakernoteDirectory.TagDateTimeUtc /*2312*/:
                    return getDateTimeUTCDescription();
                default:
                    switch (i) {
                        case 512:
                            return getExposureModeDescription();
                        case 513:
                            return getAeLockDescription();
                        case 514:
                            return getMeteringModeDescription();
                        case 515:
                            return getExposureShiftDescription();
                        case 516:
                            return getNdFilterDescription();
                        default:
                            switch (i) {
                                case 1027:
                                    return getFlashRemoteControlDescription();
                                case 1028:
                                    return getFlashControlModeDescription();
                                case 1029:
                                    return getFlashIntensityDescription();
                                case 1030:
                                    return getManualFlashStrengthDescription();
                                default:
                                    switch (i) {
                                        case OlympusCameraSettingsMakernoteDirectory.TagCustomSaturation /*1283*/:
                                            return getCustomSaturationDescription();
                                        case OlympusCameraSettingsMakernoteDirectory.TagModifiedSaturation /*1284*/:
                                            return getModifiedSaturationDescription();
                                        case OlympusCameraSettingsMakernoteDirectory.TagContrastSetting /*1285*/:
                                            return getContrastSettingDescription();
                                        case OlympusCameraSettingsMakernoteDirectory.TagSharpnessSetting /*1286*/:
                                            return getSharpnessSettingDescription();
                                        case OlympusCameraSettingsMakernoteDirectory.TagColorSpace /*1287*/:
                                            return getColorSpaceDescription();
                                        default:
                                            switch (i) {
                                                case OlympusCameraSettingsMakernoteDirectory.TagSceneMode /*1289*/:
                                                    return getSceneModeDescription();
                                                case OlympusCameraSettingsMakernoteDirectory.TagNoiseReduction /*1290*/:
                                                    return getNoiseReductionDescription();
                                                case OlympusCameraSettingsMakernoteDirectory.TagDistortionCorrection /*1291*/:
                                                    return getDistortionCorrectionDescription();
                                                case OlympusCameraSettingsMakernoteDirectory.TagShadingCompensation /*1292*/:
                                                    return getShadingCompensationDescription();
                                                default:
                                                    switch (i) {
                                                        case OlympusCameraSettingsMakernoteDirectory.TagPictureModeContrast /*1315*/:
                                                            return getPictureModeContrastDescription();
                                                        case OlympusCameraSettingsMakernoteDirectory.TagPictureModeSharpness /*1316*/:
                                                            return getPictureModeSharpnessDescription();
                                                        case OlympusCameraSettingsMakernoteDirectory.TagPictureModeBWFilter /*1317*/:
                                                            return getPictureModeBWFilterDescription();
                                                        case OlympusCameraSettingsMakernoteDirectory.TagPictureModeTone /*1318*/:
                                                            return getPictureModeToneDescription();
                                                        case OlympusCameraSettingsMakernoteDirectory.TagNoiseFilter /*1319*/:
                                                            return getNoiseFilterDescription();
                                                        default:
                                                            switch (i) {
                                                                case OlympusCameraSettingsMakernoteDirectory.TagMagicFilter /*1324*/:
                                                                    return getMagicFilterDescription();
                                                                case OlympusCameraSettingsMakernoteDirectory.TagPictureModeEffect /*1325*/:
                                                                    return getPictureModeEffectDescription();
                                                                case OlympusCameraSettingsMakernoteDirectory.TagToneLevel /*1326*/:
                                                                    return getToneLevelDescription();
                                                                case OlympusCameraSettingsMakernoteDirectory.TagArtFilterEffect /*1327*/:
                                                                    return getArtFilterEffectDescription();
                                                                default:
                                                                    return super.getDescription(i);
                                                            }
                                                    }
                                            }
                                    }
                            }
                    }
            }
        }
        return getCameraSettingsVersionDescription();
    }

    @Nullable
    public String getCameraSettingsVersionDescription() {
        return getVersionBytesDescription(0, 4);
    }

    @Nullable
    public String getPreviewImageValidDescription() {
        return getIndexedDescription(256, "No", "Yes");
    }

    @Nullable
    public String getExposureModeDescription() {
        return getIndexedDescription(512, 1, "Manual", "Program", "Aperture-priority AE", "Shutter speed priority", "Program-shift");
    }

    @Nullable
    public String getAeLockDescription() {
        return getIndexedDescription(513, "Off", "On");
    }

    @Nullable
    public String getMeteringModeDescription() {
        Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(514);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 2) {
            return "Center-weighted average";
        }
        if (intValue == 3) {
            return "Spot";
        }
        if (intValue == 5) {
            return "ESP";
        }
        if (intValue == 261) {
            return "Pattern+AF";
        }
        if (intValue == 515) {
            return "Spot+Highlight control";
        }
        if (intValue == 1027) {
            return "Spot+Shadow control";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getExposureShiftDescription() {
        return getRationalOrDoubleString(515);
    }

    @Nullable
    public String getNdFilterDescription() {
        return getIndexedDescription(516, "Off", "On");
    }

    @Nullable
    public String getMacroModeDescription() {
        return getIndexedDescription(768, "Off", "On", "Super Macro");
    }

    @Nullable
    public String getFocusModeDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(769);
        if (intArray == null) {
            Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(769);
            if (integer == null) {
                return null;
            }
            intArray = new int[]{integer.intValue()};
        }
        if (intArray.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = intArray[0];
        if (i == 0) {
            sb.append("Single AF");
        } else if (i == 1) {
            sb.append("Sequential shooting AF");
        } else if (i == 2) {
            sb.append("Continuous AF");
        } else if (i == 3) {
            sb.append("Multi AF");
        } else if (i == 4) {
            sb.append("Face detect");
        } else if (i != 10) {
            sb.append("Unknown (" + intArray[0] + ")");
        } else {
            sb.append("MF");
        }
        if (intArray.length > 1) {
            sb.append("; ");
            int i2 = intArray[1];
            if (i2 == 0) {
                sb.append("(none)");
            } else {
                if ((i2 & 1) > 0) {
                    sb.append("S-AF, ");
                }
                if (((i2 >> 2) & 1) > 0) {
                    sb.append("C-AF, ");
                }
                if (((i2 >> 4) & 1) > 0) {
                    sb.append("MF, ");
                }
                if (((i2 >> 5) & 1) > 0) {
                    sb.append("Face detect, ");
                }
                if (((i2 >> 6) & 1) > 0) {
                    sb.append("Imager AF, ");
                }
                if (((i2 >> 7) & 1) > 0) {
                    sb.append("Live View Magnification Frame, ");
                }
                if (((i2 >> 8) & 1) > 0) {
                    sb.append("AF sensor, ");
                }
                sb.setLength(sb.length() - 2);
            }
        }
        return sb.toString();
    }

    @Nullable
    public String getFocusProcessDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(770);
        if (intArray == null) {
            Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(770);
            if (integer == null) {
                return null;
            }
            intArray = new int[]{integer.intValue()};
        }
        if (intArray.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = intArray[0];
        if (i == 0) {
            sb.append("AF not used");
        } else if (i != 1) {
            sb.append("Unknown (" + intArray[0] + ")");
        } else {
            sb.append("AF used");
        }
        if (intArray.length > 1) {
            sb.append("; " + intArray[1]);
        }
        return sb.toString();
    }

    @Nullable
    public String getAfSearchDescription() {
        return getIndexedDescription(771, "Not Ready", "Ready");
    }

    @Nullable
    public String getAfAreasDescription() {
        Object object = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getObject(772);
        if (object == null || !(object instanceof long[])) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (long j : (long[]) object) {
            if (j != 0) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                if (j == 913916549) {
                    sb.append("Left ");
                } else if (j == 2038007173) {
                    sb.append("Center ");
                } else if (j == 3178875269L) {
                    sb.append("Right ");
                }
                sb.append(String.format("(%d/255,%d/255)-(%d/255,%d/255)", new Object[]{Long.valueOf((j >> 24) & 255), Long.valueOf((j >> 16) & 255), Long.valueOf((j >> 8) & 255), Long.valueOf(j & 255)}));
            }
        }
        if (sb.length() == 0) {
            return null;
        }
        return sb.toString();
    }

    @Nullable
    public String getAfPointSelectedDescription() {
        Rational[] rationalArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getRationalArray(773);
        if (rationalArray == null) {
            return "n/a";
        }
        if (rationalArray.length < 4) {
            return null;
        }
        int i = (rationalArray.length == 5 && rationalArray[0].longValue() == 0) ? 1 : 0;
        int doubleValue = (int) (rationalArray[i].doubleValue() * 100.0d);
        int doubleValue2 = (int) (rationalArray[i + 1].doubleValue() * 100.0d);
        int doubleValue3 = (int) (rationalArray[i + 2].doubleValue() * 100.0d);
        int doubleValue4 = (int) (rationalArray[i + 3].doubleValue() * 100.0d);
        if (doubleValue + doubleValue2 + doubleValue3 + doubleValue4 == 0) {
            return "n/a";
        }
        return String.format("(%d%%,%d%%) (%d%%,%d%%)", new Object[]{Integer.valueOf(doubleValue), Integer.valueOf(doubleValue2), Integer.valueOf(doubleValue3), Integer.valueOf(doubleValue4)});
    }

    @Nullable
    public String getAfFineTuneDescription() {
        return getIndexedDescription(774, "Off", "On");
    }

    @Nullable
    public String getFlashModeDescription() {
        Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(1024);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "Off";
        }
        StringBuilder sb = new StringBuilder();
        int intValue = integer.intValue();
        if ((intValue & 1) != 0) {
            sb.append("On, ");
        }
        if (((intValue >> 1) & 1) != 0) {
            sb.append("Fill-in, ");
        }
        if (((intValue >> 2) & 1) != 0) {
            sb.append("Red-eye, ");
        }
        if (((intValue >> 3) & 1) != 0) {
            sb.append("Slow-sync, ");
        }
        if (((intValue >> 4) & 1) != 0) {
            sb.append("Forced On, ");
        }
        if (((intValue >> 5) & 1) != 0) {
            sb.append("2nd Curtain, ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    @Nullable
    public String getFlashRemoteControlDescription() {
        Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(1027);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Off";
        }
        if (intValue == 1) {
            return "Channel 1, Low";
        }
        if (intValue == 2) {
            return "Channel 2, Low";
        }
        if (intValue == 3) {
            return "Channel 3, Low";
        }
        if (intValue == 4) {
            return "Channel 4, Low";
        }
        switch (intValue) {
            case 9:
                return "Channel 1, Mid";
            case 10:
                return "Channel 2, Mid";
            case 11:
                return "Channel 3, Mid";
            case 12:
                return "Channel 4, Mid";
            default:
                switch (intValue) {
                    case 17:
                        return "Channel 1, High";
                    case 18:
                        return "Channel 2, High";
                    case 19:
                        return "Channel 3, High";
                    case 20:
                        return "Channel 4, High";
                    default:
                        return "Unknown (" + integer + ")";
                }
        }
    }

    @Nullable
    public String getFlashControlModeDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(1028);
        if (intArray == null || intArray.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = intArray[0];
        if (i == 0) {
            sb.append("Off");
        } else if (i == 3) {
            sb.append("TTL");
        } else if (i == 4) {
            sb.append("Auto");
        } else if (i != 5) {
            sb.append("Unknown (");
            sb.append(intArray[0]);
            sb.append(")");
        } else {
            sb.append("Manual");
        }
        for (int i2 = 1; i2 < intArray.length; i2++) {
            sb.append("; ");
            sb.append(intArray[i2]);
        }
        return sb.toString();
    }

    @Nullable
    public String getFlashIntensityDescription() {
        Rational[] rationalArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getRationalArray(1029);
        if (rationalArray == null || rationalArray.length == 0) {
            return null;
        }
        if (rationalArray.length == 3) {
            if (rationalArray[0].getDenominator() == 0 && rationalArray[1].getDenominator() == 0 && rationalArray[2].getDenominator() == 0) {
                return "n/a";
            }
        } else if (rationalArray.length == 4 && rationalArray[0].getDenominator() == 0 && rationalArray[1].getDenominator() == 0 && rationalArray[2].getDenominator() == 0 && rationalArray[3].getDenominator() == 0) {
            return "n/a (x4)";
        }
        StringBuilder sb = new StringBuilder();
        for (Rational append : rationalArray) {
            sb.append(append);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    @Nullable
    public String getManualFlashStrengthDescription() {
        Rational[] rationalArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getRationalArray(1030);
        if (rationalArray == null || rationalArray.length == 0) {
            return "n/a";
        }
        if (rationalArray.length == 3) {
            if (rationalArray[0].getDenominator() == 0 && rationalArray[1].getDenominator() == 0 && rationalArray[2].getDenominator() == 0) {
                return "n/a";
            }
        } else if (rationalArray.length == 4 && rationalArray[0].getDenominator() == 0 && rationalArray[1].getDenominator() == 0 && rationalArray[2].getDenominator() == 0 && rationalArray[3].getDenominator() == 0) {
            return "n/a (x4)";
        }
        StringBuilder sb = new StringBuilder();
        for (Rational append : rationalArray) {
            sb.append(append);
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    @Nullable
    public String getWhiteBalance2Description() {
        Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(OlympusCameraSettingsMakernoteDirectory.TagWhiteBalance2);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Auto";
        }
        if (intValue == 1) {
            return "Auto (Keep Warm Color Off)";
        }
        if (intValue == 48) {
            return "3600K (Tungsten light-like)";
        }
        if (intValue == 67) {
            return "Underwater";
        }
        switch (intValue) {
            case 16:
                return "7500K (Fine Weather with Shade)";
            case 17:
                return "6000K (Cloudy)";
            case 18:
                return "5300K (Fine Weather)";
            default:
                switch (intValue) {
                    case 20:
                        return "3000K (Tungsten light)";
                    case 21:
                        return "3600K (Tungsten light-like)";
                    case 22:
                        return "Auto Setup";
                    case 23:
                        return "5500K (Flash)";
                    default:
                        switch (intValue) {
                            case 33:
                                return "6600K (Daylight fluorescent)";
                            case 34:
                                return "4500K (Neutral white fluorescent)";
                            case 35:
                                return "4000K (Cool white fluorescent)";
                            case 36:
                                return "White Fluorescent";
                            default:
                                switch (intValue) {
                                    case 256:
                                        return "One Touch WB 1";
                                    case 257:
                                        return "One Touch WB 2";
                                    case 258:
                                        return "One Touch WB 3";
                                    case 259:
                                        return "One Touch WB 4";
                                    default:
                                        switch (intValue) {
                                            case 512:
                                                return "Custom WB 1";
                                            case 513:
                                                return "Custom WB 2";
                                            case 514:
                                                return "Custom WB 3";
                                            case 515:
                                                return "Custom WB 4";
                                            default:
                                                return "Unknown (" + integer + ")";
                                        }
                                }
                        }
                }
        }
    }

    @Nullable
    public String getWhiteBalanceTemperatureDescription() {
        Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(OlympusCameraSettingsMakernoteDirectory.TagWhiteBalanceTemperature);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "Auto";
        }
        return integer.toString();
    }

    @Nullable
    public String getCustomSaturationDescription() {
        return getValueMinMaxDescription(OlympusCameraSettingsMakernoteDirectory.TagCustomSaturation);
    }

    @Nullable
    public String getModifiedSaturationDescription() {
        return getIndexedDescription(OlympusCameraSettingsMakernoteDirectory.TagModifiedSaturation, "Off", "CM1 (Red Enhance)", "CM2 (Green Enhance)", "CM3 (Blue Enhance)", "CM4 (Skin Tones)");
    }

    @Nullable
    public String getContrastSettingDescription() {
        return getValueMinMaxDescription(OlympusCameraSettingsMakernoteDirectory.TagContrastSetting);
    }

    @Nullable
    public String getSharpnessSettingDescription() {
        return getValueMinMaxDescription(OlympusCameraSettingsMakernoteDirectory.TagSharpnessSetting);
    }

    @Nullable
    public String getColorSpaceDescription() {
        return getIndexedDescription(OlympusCameraSettingsMakernoteDirectory.TagColorSpace, "sRGB", "Adobe RGB", "Pro Photo RGB");
    }

    @Nullable
    public String getSceneModeDescription() {
        Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(OlympusCameraSettingsMakernoteDirectory.TagSceneMode);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Standard";
        }
        if (intValue == 54) {
            return "Face Portrait";
        }
        if (intValue == 57) {
            return "Bulb";
        }
        if (intValue == 142) {
            return "Hand-held Starlight";
        }
        if (intValue == 154) {
            return "HDR";
        }
        if (intValue == 59) {
            return "Smile Shot";
        }
        if (intValue == 60) {
            return "Quick Shutter";
        }
        switch (intValue) {
            case 6:
                return "Auto";
            case 7:
                return "Sport";
            case 8:
                return "Portrait";
            case 9:
                return "Landscape+Portrait";
            case 10:
                return "Landscape";
            case 11:
                return "Night Scene";
            case 12:
                return "Self Portrait";
            case 13:
                return "Panorama";
            case 14:
                return "2 in 1";
            case 15:
                return "Movie";
            case 16:
                return "Landscape+Portrait";
            case 17:
                return "Night+Portrait";
            case 18:
                return "Indoor";
            case 19:
                return "Fireworks";
            case 20:
                return "Sunset";
            case 21:
                return "Beauty Skin";
            case 22:
                return "Macro";
            case 23:
                return "Super Macro";
            case 24:
                return "Food";
            case 25:
                return "Documents";
            case 26:
                return "Museum";
            case 27:
                return "Shoot & Select";
            case 28:
                return "Beach & Snow";
            case 29:
                return "Self Portrait+Timer";
            case 30:
                return "Candle";
            case 31:
                return "Available Light";
            case 32:
                return "Behind Glass";
            case 33:
                return "My Mode";
            case 34:
                return "Pet";
            case 35:
                return "Underwater Wide1";
            case 36:
                return "Underwater Macro";
            case 37:
                return "Shoot & Select1";
            case 38:
                return "Shoot & Select2";
            case 39:
                return "High Key";
            case 40:
                return "Digital Image Stabilization";
            case 41:
                return "Auction";
            case 42:
                return "Beach";
            case 43:
                return "Snow";
            case 44:
                return "Underwater Wide2";
            case 45:
                return "Low Key";
            case 46:
                return "Children";
            case 47:
                return "Vivid";
            case 48:
                return "Nature Macro";
            case 49:
                return "Underwater Snapshot";
            case 50:
                return "Shooting Guide";
            default:
                switch (intValue) {
                    case 63:
                        return "Slow Shutter";
                    case 64:
                        return "Bird Watching";
                    case 65:
                        return "Multiple Exposure";
                    case 66:
                        return "e-Portrait";
                    case 67:
                        return "Soft Background Shot";
                    default:
                        return "Unknown (" + integer + ")";
                }
        }
    }

    @Nullable
    public String getNoiseReductionDescription() {
        Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(OlympusCameraSettingsMakernoteDirectory.TagNoiseReduction);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 0) {
            return "(none)";
        }
        StringBuilder sb = new StringBuilder();
        int intValue = integer.intValue();
        if ((intValue & 1) != 0) {
            sb.append("Noise Reduction, ");
        }
        if (((intValue >> 1) & 1) != 0) {
            sb.append("Noise Filter, ");
        }
        if (((intValue >> 2) & 1) != 0) {
            sb.append("Noise Filter (ISO Boost), ");
        }
        if (((intValue >> 3) & 1) != 0) {
            sb.append("Auto, ");
        }
        if (sb.length() != 0) {
            return sb.substring(0, sb.length() - 2);
        }
        return "(none)";
    }

    @Nullable
    public String getDistortionCorrectionDescription() {
        return getIndexedDescription(OlympusCameraSettingsMakernoteDirectory.TagDistortionCorrection, "Off", "On");
    }

    @Nullable
    public String getShadingCompensationDescription() {
        return getIndexedDescription(OlympusCameraSettingsMakernoteDirectory.TagShadingCompensation, "Off", "On");
    }

    @Nullable
    public String getGradationDescription() {
        String str;
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagGradation);
        if (intArray == null || intArray.length < 3) {
            return null;
        }
        String format = String.format("%d %d %d", new Object[]{Integer.valueOf(intArray[0]), Integer.valueOf(intArray[1]), Integer.valueOf(intArray[2])});
        if (format.equals("0 0 0")) {
            str = "n/a";
        } else if (format.equals("-1 -1 1")) {
            str = "Low Key";
        } else if (format.equals("0 -1 1")) {
            str = "Normal";
        } else if (format.equals("1 -1 1")) {
            str = "High Key";
        } else {
            str = "Unknown (" + format + ")";
        }
        if (intArray.length <= 3) {
            return str;
        }
        if (intArray[3] == 0) {
            return str + "; User-Selected";
        } else if (intArray[3] != 1) {
            return str;
        } else {
            return str + "; Auto-Override";
        }
    }

    @Nullable
    public String getPictureModeDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagPictureMode);
        if (intArray == null) {
            Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(OlympusCameraSettingsMakernoteDirectory.TagNoiseReduction);
            if (integer == null) {
                return null;
            }
            intArray = new int[]{integer.intValue()};
        }
        if (intArray.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = intArray[0];
        if (i == 1) {
            sb.append("Vivid");
        } else if (i == 2) {
            sb.append("Natural");
        } else if (i == 3) {
            sb.append("Muted");
        } else if (i == 4) {
            sb.append("Portrait");
        } else if (i == 5) {
            sb.append("i-Enhance");
        } else if (i == 256) {
            sb.append("Monotone");
        } else if (i != 512) {
            sb.append("Unknown (");
            sb.append(intArray[0]);
            sb.append(")");
        } else {
            sb.append("Sepia");
        }
        if (intArray.length > 1) {
            sb.append("; ");
            sb.append(intArray[1]);
        }
        return sb.toString();
    }

    @Nullable
    public String getPictureModeSaturationDescription() {
        return getValueMinMaxDescription(OlympusCameraSettingsMakernoteDirectory.TagPictureModeSaturation);
    }

    @Nullable
    public String getPictureModeContrastDescription() {
        return getValueMinMaxDescription(OlympusCameraSettingsMakernoteDirectory.TagPictureModeContrast);
    }

    @Nullable
    public String getPictureModeSharpnessDescription() {
        return getValueMinMaxDescription(OlympusCameraSettingsMakernoteDirectory.TagPictureModeSharpness);
    }

    @Nullable
    public String getPictureModeBWFilterDescription() {
        return getIndexedDescription(OlympusCameraSettingsMakernoteDirectory.TagPictureModeBWFilter, "n/a", "Neutral", "Yellow", "Orange", "Red", "Green");
    }

    @Nullable
    public String getPictureModeToneDescription() {
        return getIndexedDescription(OlympusCameraSettingsMakernoteDirectory.TagPictureModeTone, "n/a", "Neutral", "Sepia", "Blue", "Purple", "Green");
    }

    @Nullable
    public String getNoiseFilterDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagNoiseFilter);
        if (intArray == null) {
            return null;
        }
        String format = String.format("%d %d %d", new Object[]{Integer.valueOf(intArray[0]), Integer.valueOf(intArray[1]), Integer.valueOf(intArray[2])});
        if (format.equals("0 0 0")) {
            return "n/a";
        }
        if (format.equals("-2 -2 1")) {
            return "Off";
        }
        if (format.equals("-1 -2 1")) {
            return "Low";
        }
        if (format.equals("0 -2 1")) {
            return "Standard";
        }
        if (format.equals("1 -2 1")) {
            return "High";
        }
        return "Unknown (" + format + ")";
    }

    @Nullable
    public String getArtFilterDescription() {
        return getFiltersDescription(OlympusCameraSettingsMakernoteDirectory.TagArtFilter);
    }

    @Nullable
    public String getMagicFilterDescription() {
        return getFiltersDescription(OlympusCameraSettingsMakernoteDirectory.TagMagicFilter);
    }

    @Nullable
    public String getPictureModeEffectDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagPictureModeEffect);
        if (intArray == null) {
            return null;
        }
        String format = String.format("%d %d %d", new Object[]{Integer.valueOf(intArray[0]), Integer.valueOf(intArray[1]), Integer.valueOf(intArray[2])});
        if (format.equals("0 0 0")) {
            return "n/a";
        }
        if (format.equals("-1 -1 1")) {
            return "Low";
        }
        if (format.equals("0 -1 1")) {
            return "Standard";
        }
        if (format.equals("1 -1 1")) {
            return "High";
        }
        return "Unknown (" + format + ")";
    }

    @Nullable
    public String getToneLevelDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagToneLevel);
        if (intArray == null || intArray.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 12 || i == 16 || i == 20 || i == 24) {
                sb.append(_toneLevelType.get(Integer.valueOf(intArray[i])));
                sb.append("; ");
            } else {
                sb.append(intArray[i]);
                sb.append("; ");
            }
        }
        return sb.substring(0, sb.length() - 2);
    }

    @Nullable
    public String getArtFilterEffectDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagArtFilterEffect);
        if (intArray == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            if (i == 0) {
                sb.append(_filters.containsKey(Integer.valueOf(intArray[i])) ? _filters.get(Integer.valueOf(intArray[i])) : "[unknown]");
                sb.append("; ");
            } else if (i == 3) {
                sb.append("Partial Color ");
                sb.append(intArray[i]);
                sb.append("; ");
            } else if (i == 4) {
                switch (intArray[i]) {
                    case 0:
                        sb.append("No Effect");
                        break;
                    case PanasonicMakernoteDirectory.TAG_BABY_AGE_1 /*32784*/:
                        sb.append("Star Light");
                        break;
                    case 32800:
                        sb.append("Pin Hole");
                        break;
                    case 32816:
                        sb.append("Frame");
                        break;
                    case 32832:
                        sb.append("Soft Focus");
                        break;
                    case 32848:
                        sb.append("White Edge");
                        break;
                    case 32864:
                        sb.append("B&W");
                        break;
                    default:
                        sb.append("Unknown (");
                        sb.append(intArray[i]);
                        sb.append(")");
                        break;
                }
                sb.append("; ");
            } else if (i == 6) {
                int i2 = intArray[i];
                if (i2 == 0) {
                    sb.append("No Color Filter");
                } else if (i2 == 1) {
                    sb.append("Yellow Color Filter");
                } else if (i2 == 2) {
                    sb.append("Orange Color Filter");
                } else if (i2 == 3) {
                    sb.append("Red Color Filter");
                } else if (i2 != 4) {
                    sb.append("Unknown (");
                    sb.append(intArray[i]);
                    sb.append(")");
                } else {
                    sb.append("Green Color Filter");
                }
                sb.append("; ");
            } else {
                sb.append(intArray[i]);
                sb.append("; ");
            }
        }
        return sb.substring(0, sb.length() - 2);
    }

    @Nullable
    public String getColorCreatorEffectDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagColorCreatorEffect);
        if (intArray == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArray.length; i++) {
            if (i == 0) {
                sb.append("Color ");
                sb.append(intArray[i]);
                sb.append("; ");
            } else if (i == 3) {
                sb.append("Strength ");
                sb.append(intArray[i]);
                sb.append("; ");
            } else {
                sb.append(intArray[i]);
                sb.append("; ");
            }
        }
        return sb.substring(0, sb.length() - 2);
    }

    @Nullable
    public String getDriveModeDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(1536);
        if (intArray == null) {
            return null;
        }
        if (intArray.length == 0 || intArray[0] == 0) {
            return "Single Shot";
        }
        StringBuilder sb = new StringBuilder();
        if (intArray[0] != 5 || intArray.length < 3) {
            int i = intArray[0];
            if (i == 1) {
                sb.append("Continuous Shooting");
            } else if (i == 2) {
                sb.append("Exposure Bracketing");
            } else if (i == 3) {
                sb.append("White Balance Bracketing");
            } else if (i != 4) {
                sb.append("Unknown (");
                sb.append(intArray[0]);
                sb.append(")");
            } else {
                sb.append("Exposure+WB Bracketing");
            }
        } else {
            int i2 = intArray[2];
            if ((i2 & 1) > 0) {
                sb.append("AE");
            }
            if (((i2 >> 1) & 1) > 0) {
                sb.append("WB");
            }
            if (((i2 >> 2) & 1) > 0) {
                sb.append("FL");
            }
            if (((i2 >> 3) & 1) > 0) {
                sb.append("MF");
            }
            if (((i2 >> 6) & 1) > 0) {
                sb.append("Focus");
            }
            sb.append(" Bracketing");
        }
        sb.append(", Shot ");
        sb.append(intArray[1]);
        return sb.toString();
    }

    @Nullable
    public String getPanoramaModeDescription() {
        String str;
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(1537);
        if (intArray == null) {
            return null;
        }
        if (intArray.length == 0 || intArray[0] == 0) {
            return "Off";
        }
        int i = intArray[0];
        if (i == 1) {
            str = "Left to Right";
        } else if (i == 2) {
            str = "Right to Left";
        } else if (i == 3) {
            str = "Bottom to Top";
        } else if (i != 4) {
            str = "Unknown (" + intArray[0] + ")";
        } else {
            str = "Top to Bottom";
        }
        return String.format("%s, Shot %d", new Object[]{str, Integer.valueOf(intArray[1])});
    }

    @Nullable
    public String getImageQuality2Description() {
        return getIndexedDescription(OlympusCameraSettingsMakernoteDirectory.TagImageQuality2, 1, "SQ", "HQ", "SHQ", "RAW", "SQ (5)");
    }

    @Nullable
    public String getImageStabilizationDescription() {
        return getIndexedDescription(OlympusCameraSettingsMakernoteDirectory.TagImageStabilization, "Off", "On, Mode 1", "On, Mode 2", "On, Mode 3", "On, Mode 4");
    }

    @Nullable
    public String getStackedImageDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagStackedImage);
        if (intArray == null || intArray.length < 2) {
            return null;
        }
        int i = intArray[0];
        int i2 = intArray[1];
        if (i == 0 && i2 == 0) {
            return "No";
        }
        if (i == 9 && i2 == 8) {
            return "Focus-stacked (8 images)";
        }
        return String.format("Unknown (%d %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
    }

    @Nullable
    public String getManometerPressureDescription() {
        Integer integer = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getInteger(OlympusCameraSettingsMakernoteDirectory.TagManometerPressure);
        if (integer == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double intValue = (double) integer.intValue();
        Double.isNaN(intValue);
        return String.format("%s kPa", new Object[]{decimalFormat.format(intValue / 10.0d)});
    }

    @Nullable
    public String getManometerReadingDescription() {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagManometerReading);
        if (intArray == null || intArray.length < 2) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        double d = (double) intArray[0];
        Double.isNaN(d);
        double d2 = (double) intArray[1];
        Double.isNaN(d2);
        return String.format("%s m, %s ft", new Object[]{decimalFormat.format(d / 10.0d), decimalFormat.format(d2 / 10.0d)});
    }

    @Nullable
    public String getExtendedWBDetectDescription() {
        return getIndexedDescription(OlympusCameraSettingsMakernoteDirectory.TagExtendedWBDetect, "Off", "On");
    }

    @Nullable
    public String getRollAngleDescription() {
        String str;
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagRollAngle);
        if (intArray == null || intArray.length < 2) {
            return null;
        }
        if (intArray[0] != 0) {
            double d = (double) (-intArray[0]);
            Double.isNaN(d);
            str = Double.toString(d / 10.0d);
        } else {
            str = "n/a";
        }
        return String.format("%s %d", new Object[]{str, Integer.valueOf(intArray[1])});
    }

    @Nullable
    public String getPitchAngleDescription() {
        String str;
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(OlympusCameraSettingsMakernoteDirectory.TagPitchAngle);
        if (intArray == null || intArray.length < 2) {
            return null;
        }
        if (intArray[0] != 0) {
            double d = (double) intArray[0];
            Double.isNaN(d);
            str = Double.toString(d / 10.0d);
        } else {
            str = "n/a";
        }
        return String.format("%s %d", new Object[]{str, Integer.valueOf(intArray[1])});
    }

    @Nullable
    public String getDateTimeUTCDescription() {
        Object object = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getObject(OlympusCameraSettingsMakernoteDirectory.TagDateTimeUtc);
        if (object == null) {
            return null;
        }
        return object.toString();
    }

    @Nullable
    private String getValueMinMaxDescription(int i) {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(i);
        if (intArray == null || intArray.length < 3) {
            return null;
        }
        return String.format("%d (min %d, max %d)", new Object[]{Integer.valueOf(intArray[0]), Integer.valueOf(intArray[1]), Integer.valueOf(intArray[2])});
    }

    @Nullable
    private String getFiltersDescription(int i) {
        int[] intArray = ((OlympusCameraSettingsMakernoteDirectory) this._directory).getIntArray(i);
        if (intArray == null || intArray.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < intArray.length; i2++) {
            if (i2 == 0) {
                sb.append(_filters.containsKey(Integer.valueOf(intArray[i2])) ? _filters.get(Integer.valueOf(intArray[i2])) : "[unknown]");
            } else {
                sb.append(intArray[i2]);
            }
            sb.append("; ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    static {
        _filters.put(0, "Off");
        _filters.put(1, "Soft Focus");
        _filters.put(2, "Pop Art");
        _filters.put(3, "Pale & Light Color");
        _filters.put(4, "Light Tone");
        _filters.put(5, "Pin Hole");
        _filters.put(6, "Grainy Film");
        _filters.put(9, "Diorama");
        _filters.put(10, "Cross Process");
        _filters.put(12, "Fish Eye");
        _filters.put(13, "Drawing");
        _filters.put(14, "Gentle Sepia");
        _filters.put(15, "Pale & Light Color II");
        _filters.put(16, "Pop Art II");
        _filters.put(17, "Pin Hole II");
        _filters.put(18, "Pin Hole III");
        _filters.put(19, "Grainy Film II");
        _filters.put(20, "Dramatic Tone");
        _filters.put(21, "Punk");
        _filters.put(22, "Soft Focus 2");
        _filters.put(23, "Sparkle");
        _filters.put(24, "Watercolor");
        _filters.put(25, "Key Line");
        _filters.put(26, "Key Line II");
        _filters.put(27, "Miniature");
        _filters.put(28, "Reflection");
        _filters.put(29, "Fragmented");
        _filters.put(31, "Cross Process II");
        _filters.put(32, "Dramatic Tone II");
        _filters.put(33, "Watercolor I");
        _filters.put(34, "Watercolor II");
        _filters.put(35, "Diorama II");
        _filters.put(36, "Vintage");
        _filters.put(37, "Vintage II");
        _filters.put(38, "Vintage III");
        _filters.put(39, "Partial Color");
        _filters.put(40, "Partial Color II");
        _filters.put(41, "Partial Color III");
        _toneLevelType.put(0, "0");
        _toneLevelType.put(-31999, "Highlights ");
        _toneLevelType.put(-31998, "Shadows ");
        _toneLevelType.put(-31997, "Midtones ");
    }
}
