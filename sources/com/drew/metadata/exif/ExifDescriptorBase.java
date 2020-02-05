package com.drew.metadata.exif;

import androidx.exifinterface.media.ExifInterface;
import com.drew.imaging.PhotographicConversions;
import com.drew.lang.ByteArrayReader;
import com.drew.lang.Rational;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Directory;
import com.drew.metadata.TagDescriptor;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public abstract class ExifDescriptorBase<T extends Directory> extends TagDescriptor<T> {
    private final boolean _allowDecimalRepresentationOfRationals = true;

    public ExifDescriptorBase(@NotNull T t) {
        super(t);
    }

    @Nullable
    public String getDescription(int i) {
        switch (i) {
            case 1:
                return getInteropIndexDescription();
            case 2:
                return getInteropVersionDescription();
            case ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE:
                return getNewSubfileTypeDescription();
            case 255:
                return getSubfileTypeDescription();
            case 256:
                return getImageWidthDescription();
            case 257:
                return getImageHeightDescription();
            case 258:
                return getBitsPerSampleDescription();
            case 259:
                return getCompressionDescription();
            case 262:
                return getPhotometricInterpretationDescription();
            case 263:
                return getThresholdingDescription();
            case 266:
                return getFillOrderDescription();
            case 274:
                return getOrientationDescription();
            case 277:
                return getSamplesPerPixelDescription();
            case 278:
                return getRowsPerStripDescription();
            case 279:
                return getStripByteCountsDescription();
            case 282:
                return getXResolutionDescription();
            case 283:
                return getYResolutionDescription();
            case 284:
                return getPlanarConfigurationDescription();
            case 296:
                return getResolutionDescription();
            case 512:
                return getJpegProcDescription();
            case 530:
                return getYCbCrSubsamplingDescription();
            case 531:
                return getYCbCrPositioningDescription();
            case 532:
                return getReferenceBlackWhiteDescription();
            case ExifDirectoryBase.TAG_CFA_PATTERN_2:
                return getCfaPattern2Description();
            case ExifDirectoryBase.TAG_EXPOSURE_TIME:
                return getExposureTimeDescription();
            case ExifDirectoryBase.TAG_FNUMBER:
                return getFNumberDescription();
            case ExifDirectoryBase.TAG_EXPOSURE_PROGRAM:
                return getExposureProgramDescription();
            case ExifDirectoryBase.TAG_ISO_EQUIVALENT:
                return getIsoEquivalentDescription();
            case ExifDirectoryBase.TAG_SENSITIVITY_TYPE:
                return getSensitivityTypeRangeDescription();
            case ExifDirectoryBase.TAG_EXIF_VERSION:
                return getExifVersionDescription();
            case ExifDirectoryBase.TAG_COMPONENTS_CONFIGURATION:
                return getComponentConfigurationDescription();
            case ExifDirectoryBase.TAG_COMPRESSED_AVERAGE_BITS_PER_PIXEL:
                return getCompressedAverageBitsPerPixelDescription();
            case ExifDirectoryBase.TAG_SHUTTER_SPEED:
                return getShutterSpeedDescription();
            case ExifDirectoryBase.TAG_APERTURE:
                return getApertureValueDescription();
            case ExifDirectoryBase.TAG_EXPOSURE_BIAS:
                return getExposureBiasDescription();
            case ExifDirectoryBase.TAG_MAX_APERTURE:
                return getMaxApertureValueDescription();
            case ExifDirectoryBase.TAG_SUBJECT_DISTANCE:
                return getSubjectDistanceDescription();
            case ExifDirectoryBase.TAG_METERING_MODE:
                return getMeteringModeDescription();
            case 37384:
                return getWhiteBalanceDescription();
            case ExifDirectoryBase.TAG_FLASH:
                return getFlashDescription();
            case ExifDirectoryBase.TAG_FOCAL_LENGTH:
                return getFocalLengthDescription();
            case ExifDirectoryBase.TAG_USER_COMMENT:
                return getUserCommentDescription();
            case ExifDirectoryBase.TAG_WIN_TITLE:
                return getWindowsTitleDescription();
            case ExifDirectoryBase.TAG_WIN_COMMENT:
                return getWindowsCommentDescription();
            case ExifDirectoryBase.TAG_WIN_AUTHOR:
                return getWindowsAuthorDescription();
            case ExifDirectoryBase.TAG_WIN_KEYWORDS:
                return getWindowsKeywordsDescription();
            case ExifDirectoryBase.TAG_WIN_SUBJECT:
                return getWindowsSubjectDescription();
            case ExifDirectoryBase.TAG_FLASHPIX_VERSION:
                return getFlashPixVersionDescription();
            case 40961:
                return getColorSpaceDescription();
            case ExifDirectoryBase.TAG_EXIF_IMAGE_WIDTH:
                return getExifImageWidthDescription();
            case ExifDirectoryBase.TAG_EXIF_IMAGE_HEIGHT:
                return getExifImageHeightDescription();
            case ExifDirectoryBase.TAG_FOCAL_PLANE_X_RESOLUTION:
                return getFocalPlaneXResolutionDescription();
            case ExifDirectoryBase.TAG_FOCAL_PLANE_Y_RESOLUTION:
                return getFocalPlaneYResolutionDescription();
            case ExifDirectoryBase.TAG_FOCAL_PLANE_RESOLUTION_UNIT:
                return getFocalPlaneResolutionUnitDescription();
            case ExifDirectoryBase.TAG_SENSING_METHOD:
                return getSensingMethodDescription();
            case ExifDirectoryBase.TAG_FILE_SOURCE:
                return getFileSourceDescription();
            case ExifDirectoryBase.TAG_SCENE_TYPE:
                return getSceneTypeDescription();
            case ExifDirectoryBase.TAG_CFA_PATTERN:
                return getCfaPatternDescription();
            case ExifDirectoryBase.TAG_CUSTOM_RENDERED:
                return getCustomRenderedDescription();
            case ExifDirectoryBase.TAG_EXPOSURE_MODE:
                return getExposureModeDescription();
            case ExifDirectoryBase.TAG_WHITE_BALANCE_MODE:
                return getWhiteBalanceModeDescription();
            case ExifDirectoryBase.TAG_DIGITAL_ZOOM_RATIO:
                return getDigitalZoomRatioDescription();
            case ExifDirectoryBase.TAG_35MM_FILM_EQUIV_FOCAL_LENGTH:
                return get35mmFilmEquivFocalLengthDescription();
            case ExifDirectoryBase.TAG_SCENE_CAPTURE_TYPE:
                return getSceneCaptureTypeDescription();
            case ExifDirectoryBase.TAG_GAIN_CONTROL:
                return getGainControlDescription();
            case ExifDirectoryBase.TAG_CONTRAST:
                return getContrastDescription();
            case ExifDirectoryBase.TAG_SATURATION:
                return getSaturationDescription();
            case ExifDirectoryBase.TAG_SHARPNESS:
                return getSharpnessDescription();
            case ExifDirectoryBase.TAG_SUBJECT_DISTANCE_RANGE:
                return getSubjectDistanceRangeDescription();
            case ExifDirectoryBase.TAG_LENS_SPECIFICATION:
                return getLensSpecificationDescription();
            default:
                return super.getDescription(i);
        }
    }

    @Nullable
    public String getInteropVersionDescription() {
        return getVersionBytesDescription(2, 2);
    }

    @Nullable
    public String getInteropIndexDescription() {
        String string = this._directory.getString(1);
        if (string == null) {
            return null;
        }
        if ("R98".equalsIgnoreCase(string.trim())) {
            return "Recommended Exif Interoperability Rules (ExifR98)";
        }
        return "Unknown (" + string + ")";
    }

    @Nullable
    public String getReferenceBlackWhiteDescription() {
        int[] intArray = this._directory.getIntArray(532);
        if (intArray == null || intArray.length < 6) {
            Object object = this._directory.getObject(532);
            if (object == null || !(object instanceof long[])) {
                return null;
            }
            long[] jArr = (long[]) object;
            if (jArr.length < 6) {
                return null;
            }
            int[] iArr = new int[jArr.length];
            for (int i = 0; i < jArr.length; i++) {
                iArr[i] = (int) jArr[i];
            }
            intArray = iArr;
        }
        int i2 = intArray[0];
        int i3 = intArray[1];
        int i4 = intArray[2];
        int i5 = intArray[3];
        return String.format("[%d,%d,%d] [%d,%d,%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(intArray[4]), Integer.valueOf(i3), Integer.valueOf(i5), Integer.valueOf(intArray[5])});
    }

    @Nullable
    public String getYResolutionDescription() {
        Rational rational = this._directory.getRational(283);
        if (rational == null) {
            return null;
        }
        String resolutionDescription = getResolutionDescription();
        Object[] objArr = new Object[2];
        objArr[0] = rational.toSimpleString(true);
        objArr[1] = resolutionDescription == null ? "unit" : resolutionDescription.toLowerCase();
        return String.format("%s dots per %s", objArr);
    }

    @Nullable
    public String getXResolutionDescription() {
        Rational rational = this._directory.getRational(282);
        if (rational == null) {
            return null;
        }
        String resolutionDescription = getResolutionDescription();
        Object[] objArr = new Object[2];
        objArr[0] = rational.toSimpleString(true);
        objArr[1] = resolutionDescription == null ? "unit" : resolutionDescription.toLowerCase();
        return String.format("%s dots per %s", objArr);
    }

    @Nullable
    public String getYCbCrPositioningDescription() {
        return getIndexedDescription(531, 1, "Center of pixel array", "Datum point");
    }

    @Nullable
    public String getOrientationDescription() {
        return super.getOrientationDescription(274);
    }

    @Nullable
    public String getResolutionDescription() {
        return getIndexedDescription(296, 1, "(No unit)", "Inch", "cm");
    }

    @Nullable
    private String getUnicodeDescription(int i) {
        byte[] byteArray = this._directory.getByteArray(i);
        if (byteArray == null) {
            return null;
        }
        try {
            return new String(byteArray, "UTF-16LE").trim();
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Nullable
    public String getWindowsAuthorDescription() {
        return getUnicodeDescription(ExifDirectoryBase.TAG_WIN_AUTHOR);
    }

    @Nullable
    public String getWindowsCommentDescription() {
        return getUnicodeDescription(ExifDirectoryBase.TAG_WIN_COMMENT);
    }

    @Nullable
    public String getWindowsKeywordsDescription() {
        return getUnicodeDescription(ExifDirectoryBase.TAG_WIN_KEYWORDS);
    }

    @Nullable
    public String getWindowsTitleDescription() {
        return getUnicodeDescription(ExifDirectoryBase.TAG_WIN_TITLE);
    }

    @Nullable
    public String getWindowsSubjectDescription() {
        return getUnicodeDescription(ExifDirectoryBase.TAG_WIN_SUBJECT);
    }

    @Nullable
    public String getYCbCrSubsamplingDescription() {
        int[] intArray = this._directory.getIntArray(530);
        if (intArray == null || intArray.length < 2) {
            return null;
        }
        if (intArray[0] == 2 && intArray[1] == 1) {
            return "YCbCr4:2:2";
        }
        return (intArray[0] == 2 && intArray[1] == 2) ? "YCbCr4:2:0" : "(Unknown)";
    }

    @Nullable
    public String getPlanarConfigurationDescription() {
        return getIndexedDescription(284, 1, "Chunky (contiguous for each subsampling pixel)", "Separate (Y-plane/Cb-plane/Cr-plane format)");
    }

    @Nullable
    public String getSamplesPerPixelDescription() {
        String string = this._directory.getString(277);
        if (string == null) {
            return null;
        }
        return string + " samples/pixel";
    }

    @Nullable
    public String getRowsPerStripDescription() {
        String string = this._directory.getString(278);
        if (string == null) {
            return null;
        }
        return string + " rows/strip";
    }

    @Nullable
    public String getStripByteCountsDescription() {
        String string = this._directory.getString(279);
        if (string == null) {
            return null;
        }
        return string + " bytes";
    }

    @Nullable
    public String getPhotometricInterpretationDescription() {
        Integer integer = this._directory.getInteger(262);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 32803) {
            return "Color Filter Array";
        }
        if (intValue == 32892) {
            return "Linear Raw";
        }
        switch (intValue) {
            case 0:
                return "WhiteIsZero";
            case 1:
                return "BlackIsZero";
            case 2:
                return "RGB";
            case 3:
                return "RGB Palette";
            case 4:
                return "Transparency Mask";
            case 5:
                return "CMYK";
            case 6:
                return "YCbCr";
            default:
                switch (intValue) {
                    case 8:
                        return "CIELab";
                    case 9:
                        return "ICCLab";
                    case 10:
                        return "ITULab";
                    default:
                        switch (intValue) {
                            case 32844:
                                return "Pixar LogL";
                            case 32845:
                                return "Pixar LogLuv";
                            default:
                                return "Unknown colour space";
                        }
                }
        }
    }

    @Nullable
    public String getBitsPerSampleDescription() {
        String string = this._directory.getString(258);
        if (string == null) {
            return null;
        }
        return string + " bits/component/pixel";
    }

    @Nullable
    public String getImageWidthDescription() {
        String string = this._directory.getString(256);
        if (string == null) {
            return null;
        }
        return string + " pixels";
    }

    @Nullable
    public String getImageHeightDescription() {
        String string = this._directory.getString(257);
        if (string == null) {
            return null;
        }
        return string + " pixels";
    }

    @Nullable
    public String getNewSubfileTypeDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_NEW_SUBFILE_TYPE, 0, "Full-resolution image", "Reduced-resolution image", "Single page of multi-page image", "Single page of multi-page reduced-resolution image", "Transparency mask", "Transparency mask of reduced-resolution image", "Transparency mask of multi-page image", "Transparency mask of reduced-resolution multi-page image");
    }

    @Nullable
    public String getSubfileTypeDescription() {
        return getIndexedDescription(255, 1, "Full-resolution image", "Reduced-resolution image", "Single page of multi-page image");
    }

    @Nullable
    public String getThresholdingDescription() {
        return getIndexedDescription(263, 1, "No dithering or halftoning", "Ordered dither or halftone", "Randomized dither");
    }

    @Nullable
    public String getFillOrderDescription() {
        return getIndexedDescription(266, 1, "Normal", "Reversed");
    }

    @Nullable
    public String getSubjectDistanceRangeDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_SUBJECT_DISTANCE_RANGE, "Unknown", "Macro", "Close view", "Distant view");
    }

    @Nullable
    public String getSensitivityTypeRangeDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_SENSITIVITY_TYPE, "Unknown", "Standard Output Sensitivity", "Recommended Exposure Index", "ISO Speed", "Standard Output Sensitivity and Recommended Exposure Index", "Standard Output Sensitivity and ISO Speed", "Recommended Exposure Index and ISO Speed", "Standard Output Sensitivity, Recommended Exposure Index and ISO Speed");
    }

    @Nullable
    public String getLensSpecificationDescription() {
        return getLensSpecificationDescription(ExifDirectoryBase.TAG_LENS_SPECIFICATION);
    }

    @Nullable
    public String getSharpnessDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_SHARPNESS, "None", "Low", "Hard");
    }

    @Nullable
    public String getSaturationDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_SATURATION, "None", "Low saturation", "High saturation");
    }

    @Nullable
    public String getContrastDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_CONTRAST, "None", "Soft", "Hard");
    }

    @Nullable
    public String getGainControlDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_GAIN_CONTROL, "None", "Low gain up", "Low gain down", "High gain up", "High gain down");
    }

    @Nullable
    public String getSceneCaptureTypeDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_SCENE_CAPTURE_TYPE, "Standard", "Landscape", "Portrait", "Night scene");
    }

    @Nullable
    public String get35mmFilmEquivFocalLengthDescription() {
        Integer integer = this._directory.getInteger(ExifDirectoryBase.TAG_35MM_FILM_EQUIV_FOCAL_LENGTH);
        if (integer == null) {
            return null;
        }
        return integer.intValue() == 0 ? "Unknown" : getFocalLengthDescription((double) integer.intValue());
    }

    @Nullable
    public String getDigitalZoomRatioDescription() {
        Rational rational = this._directory.getRational(ExifDirectoryBase.TAG_DIGITAL_ZOOM_RATIO);
        if (rational == null) {
            return null;
        }
        return rational.getNumerator() == 0 ? "Digital zoom not used" : new DecimalFormat("0.#").format(rational.doubleValue());
    }

    @Nullable
    public String getWhiteBalanceModeDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_WHITE_BALANCE_MODE, "Auto white balance", "Manual white balance");
    }

    @Nullable
    public String getExposureModeDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_EXPOSURE_MODE, "Auto exposure", "Manual exposure", "Auto bracket");
    }

    @Nullable
    public String getCustomRenderedDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_CUSTOM_RENDERED, "Normal process", "Custom process");
    }

    @Nullable
    public String getUserCommentDescription() {
        byte[] byteArray = this._directory.getByteArray(ExifDirectoryBase.TAG_USER_COMMENT);
        if (byteArray == null) {
            return null;
        }
        if (byteArray.length == 0) {
            return "";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("ASCII", System.getProperty("file.encoding"));
        hashMap.put("UNICODE", "UTF-16LE");
        hashMap.put("JIS", "Shift-JIS");
        try {
            if (byteArray.length >= 10) {
                String str = new String(byteArray, 0, 10);
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    if (str.startsWith(str2)) {
                        for (int length = str2.length(); length < 10; length++) {
                            byte b = byteArray[length];
                            if (b != 0 && b != 32) {
                                return new String(byteArray, length, byteArray.length - length, str3).trim();
                            }
                        }
                        return new String(byteArray, 10, byteArray.length - 10, str3).trim();
                    }
                }
            }
            return new String(byteArray, System.getProperty("file.encoding")).trim();
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Nullable
    public String getIsoEquivalentDescription() {
        Integer integer = this._directory.getInteger(ExifDirectoryBase.TAG_ISO_EQUIVALENT);
        if (integer != null) {
            return Integer.toString(integer.intValue());
        }
        return null;
    }

    @Nullable
    public String getExifVersionDescription() {
        return getVersionBytesDescription(ExifDirectoryBase.TAG_EXIF_VERSION, 2);
    }

    @Nullable
    public String getFlashPixVersionDescription() {
        return getVersionBytesDescription(ExifDirectoryBase.TAG_FLASHPIX_VERSION, 2);
    }

    @Nullable
    public String getSceneTypeDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_SCENE_TYPE, 1, "Directly photographed image");
    }

    @Nullable
    public String getCfaPatternDescription() {
        return formatCFAPattern(decodeCfaPattern(ExifDirectoryBase.TAG_CFA_PATTERN));
    }

    @Nullable
    public String getCfaPattern2Description() {
        byte[] byteArray = this._directory.getByteArray(ExifDirectoryBase.TAG_CFA_PATTERN_2);
        if (byteArray == null) {
            return null;
        }
        int[] intArray = this._directory.getIntArray(ExifDirectoryBase.TAG_CFA_REPEAT_PATTERN_DIM);
        if (intArray == null) {
            return String.format("Repeat Pattern not found for CFAPattern (%s)", new Object[]{super.getDescription(ExifDirectoryBase.TAG_CFA_PATTERN_2)});
        } else if (intArray.length == 2 && byteArray.length == intArray[0] * intArray[1]) {
            int[] iArr = new int[(byteArray.length + 2)];
            iArr[0] = intArray[0];
            iArr[1] = intArray[1];
            for (int i = 0; i < byteArray.length; i++) {
                iArr[i + 2] = byteArray[i] & UnsignedBytes.MAX_VALUE;
            }
            return formatCFAPattern(iArr);
        } else {
            return String.format("Unknown Pattern (%s)", new Object[]{super.getDescription(ExifDirectoryBase.TAG_CFA_PATTERN_2)});
        }
    }

    @Nullable
    private static String formatCFAPattern(@Nullable int[] iArr) {
        if (iArr == null) {
            return null;
        }
        if (iArr.length < 2) {
            return "<truncated data>";
        }
        if (iArr[0] == 0 && iArr[1] == 0) {
            return "<zero pattern size>";
        }
        int i = (iArr[0] * iArr[1]) + 2;
        if (i > iArr.length) {
            return "<invalid pattern size>";
        }
        String[] strArr = {"Red", "Green", "Blue", "Cyan", "Magenta", "Yellow", "White"};
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i2 = 2; i2 < i; i2++) {
            if (iArr[i2] <= strArr.length - 1) {
                sb.append(strArr[iArr[i2]]);
            } else {
                sb.append("Unknown");
            }
            if ((i2 - 2) % iArr[1] == 0) {
                sb.append(",");
            } else if (i2 != i - 1) {
                sb.append("][");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Nullable
    private int[] decodeCfaPattern(int i) {
        byte[] byteArray = this._directory.getByteArray(i);
        if (byteArray == 0) {
            return null;
        }
        if (byteArray.length < 4) {
            int[] iArr = new int[byteArray.length];
            for (int i2 = 0; i2 < byteArray.length; i2++) {
                iArr[i2] = byteArray[i2];
            }
            return iArr;
        }
        int[] iArr2 = new int[(byteArray.length - 2)];
        try {
            ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
            int int16 = byteArrayReader.getInt16(0);
            int int162 = byteArrayReader.getInt16(2);
            Boolean bool = false;
            if ((int16 * int162) + 2 > byteArray.length) {
                byteArrayReader.setMotorolaByteOrder(!byteArrayReader.isMotorolaByteOrder());
                int16 = byteArrayReader.getInt16(0);
                int162 = byteArrayReader.getInt16(2);
                if (byteArray.length >= (int16 * int162) + 2) {
                    bool = true;
                }
            } else {
                bool = true;
            }
            if (bool.booleanValue()) {
                iArr2[0] = int16;
                iArr2[1] = int162;
                for (int i3 = 4; i3 < byteArray.length; i3++) {
                    iArr2[i3 - 2] = byteArrayReader.getInt8(i3);
                }
            }
        } catch (IOException e) {
            Directory directory = this._directory;
            directory.addError("IO exception processing data: " + e.getMessage());
        }
        return iArr2;
    }

    @Nullable
    public String getFileSourceDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_FILE_SOURCE, 1, "Film Scanner", "Reflection Print Scanner", "Digital Still Camera (DSC)");
    }

    @Nullable
    public String getExposureBiasDescription() {
        Rational rational = this._directory.getRational(ExifDirectoryBase.TAG_EXPOSURE_BIAS);
        if (rational == null) {
            return null;
        }
        return rational.toSimpleString(true) + " EV";
    }

    @Nullable
    public String getMaxApertureValueDescription() {
        Double doubleObject = this._directory.getDoubleObject(ExifDirectoryBase.TAG_MAX_APERTURE);
        if (doubleObject == null) {
            return null;
        }
        return getFStopDescription(PhotographicConversions.apertureToFStop(doubleObject.doubleValue()));
    }

    @Nullable
    public String getApertureValueDescription() {
        Double doubleObject = this._directory.getDoubleObject(ExifDirectoryBase.TAG_APERTURE);
        if (doubleObject == null) {
            return null;
        }
        return getFStopDescription(PhotographicConversions.apertureToFStop(doubleObject.doubleValue()));
    }

    @Nullable
    public String getExposureProgramDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_EXPOSURE_PROGRAM, 1, "Manual control", "Program normal", "Aperture priority", "Shutter priority", "Program creative (slow program)", "Program action (high-speed program)", "Portrait mode", "Landscape mode");
    }

    @Nullable
    public String getFocalPlaneXResolutionDescription() {
        String str;
        Rational rational = this._directory.getRational(ExifDirectoryBase.TAG_FOCAL_PLANE_X_RESOLUTION);
        if (rational == null) {
            return null;
        }
        String focalPlaneResolutionUnitDescription = getFocalPlaneResolutionUnitDescription();
        StringBuilder sb = new StringBuilder();
        sb.append(rational.getReciprocal().toSimpleString(true));
        if (focalPlaneResolutionUnitDescription == null) {
            str = "";
        } else {
            str = " " + focalPlaneResolutionUnitDescription.toLowerCase();
        }
        sb.append(str);
        return sb.toString();
    }

    @Nullable
    public String getFocalPlaneYResolutionDescription() {
        String str;
        Rational rational = this._directory.getRational(ExifDirectoryBase.TAG_FOCAL_PLANE_Y_RESOLUTION);
        if (rational == null) {
            return null;
        }
        String focalPlaneResolutionUnitDescription = getFocalPlaneResolutionUnitDescription();
        StringBuilder sb = new StringBuilder();
        sb.append(rational.getReciprocal().toSimpleString(true));
        if (focalPlaneResolutionUnitDescription == null) {
            str = "";
        } else {
            str = " " + focalPlaneResolutionUnitDescription.toLowerCase();
        }
        sb.append(str);
        return sb.toString();
    }

    @Nullable
    public String getFocalPlaneResolutionUnitDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_FOCAL_PLANE_RESOLUTION_UNIT, 1, "(No unit)", "Inches", "cm");
    }

    @Nullable
    public String getExifImageWidthDescription() {
        Integer integer = this._directory.getInteger(ExifDirectoryBase.TAG_EXIF_IMAGE_WIDTH);
        if (integer == null) {
            return null;
        }
        return integer + " pixels";
    }

    @Nullable
    public String getExifImageHeightDescription() {
        Integer integer = this._directory.getInteger(ExifDirectoryBase.TAG_EXIF_IMAGE_HEIGHT);
        if (integer == null) {
            return null;
        }
        return integer + " pixels";
    }

    @Nullable
    public String getColorSpaceDescription() {
        Integer integer = this._directory.getInteger(40961);
        if (integer == null) {
            return null;
        }
        if (integer.intValue() == 1) {
            return "sRGB";
        }
        if (integer.intValue() == 65535) {
            return "Undefined";
        }
        return "Unknown (" + integer + ")";
    }

    @Nullable
    public String getFocalLengthDescription() {
        Rational rational = this._directory.getRational(ExifDirectoryBase.TAG_FOCAL_LENGTH);
        if (rational == null) {
            return null;
        }
        return getFocalLengthDescription(rational.doubleValue());
    }

    @Nullable
    public String getFlashDescription() {
        Integer integer = this._directory.getInteger(ExifDirectoryBase.TAG_FLASH);
        if (integer == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if ((integer.intValue() & 1) != 0) {
            sb.append("Flash fired");
        } else {
            sb.append("Flash did not fire");
        }
        if ((integer.intValue() & 4) != 0) {
            if ((integer.intValue() & 2) != 0) {
                sb.append(", return detected");
            } else {
                sb.append(", return not detected");
            }
        }
        if ((integer.intValue() & 16) != 0) {
            sb.append(", auto");
        }
        if ((integer.intValue() & 64) != 0) {
            sb.append(", red-eye reduction");
        }
        return sb.toString();
    }

    @Nullable
    public String getWhiteBalanceDescription() {
        Integer integer = this._directory.getInteger(37384);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 0) {
            return "Unknown";
        }
        if (intValue == 1) {
            return "Daylight";
        }
        if (intValue == 2) {
            return "Florescent";
        }
        if (intValue == 3) {
            return "Tungsten";
        }
        if (intValue == 4) {
            return ExifInterface.TAG_FLASH;
        }
        if (intValue == 255) {
            return "(Other)";
        }
        switch (intValue) {
            case 9:
                return "Fine Weather";
            case 10:
                return "Cloudy";
            case 11:
                return "Shade";
            case 12:
                return "Daylight Fluorescent";
            case 13:
                return "Day White Fluorescent";
            case 14:
                return "Cool White Fluorescent";
            case 15:
                return "White Fluorescent";
            case 16:
                return "Warm White Fluorescent";
            case 17:
                return "Standard light";
            case 18:
                return "Standard light (B)";
            case 19:
                return "Standard light (C)";
            case 20:
                return "D55";
            case 21:
                return "D65";
            case 22:
                return "D75";
            case 23:
                return "D50";
            case 24:
                return "Studio Tungsten";
            default:
                return "Unknown (" + integer + ")";
        }
    }

    @Nullable
    public String getMeteringModeDescription() {
        Integer integer = this._directory.getInteger(ExifDirectoryBase.TAG_METERING_MODE);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 255) {
            return "(Other)";
        }
        switch (intValue) {
            case 0:
                return "Unknown";
            case 1:
                return "Average";
            case 2:
                return "Center weighted average";
            case 3:
                return "Spot";
            case 4:
                return "Multi-spot";
            case 5:
                return "Multi-segment";
            case 6:
                return "Partial";
            default:
                return "Unknown (" + integer + ")";
        }
    }

    @Nullable
    public String getCompressionDescription() {
        Integer integer = this._directory.getInteger(259);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 32766) {
            return "Next";
        }
        if (intValue == 32767) {
            return "Sony ARW Compressed";
        }
        switch (intValue) {
            case 1:
                return "Uncompressed";
            case 2:
                return "CCITT 1D";
            case 3:
                return "T4/Group 3 Fax";
            case 4:
                return "T6/Group 4 Fax";
            case 5:
                return "LZW";
            case 6:
                return "JPEG (old-style)";
            case 7:
                return "JPEG";
            case 8:
                return "Adobe Deflate";
            case 9:
                return "JBIG B&W";
            case 10:
                return "JBIG Color";
            default:
                switch (intValue) {
                    case 99:
                        return "JPEG";
                    case 262:
                        return "Kodak 262";
                    case 32809:
                        return "Thunderscan";
                    case 32867:
                        return "Kodak KDC Compressed";
                    case 34661:
                        return "JBIG";
                    case 34715:
                        return "JBIG2 TIFF FX";
                    case ExifInterface.DATA_LOSSY_JPEG:
                        return "Lossy JPEG";
                    case 65000:
                        return "Kodak DCR Compressed";
                    case 65535:
                        return "Pentax PEF Compressed";
                    default:
                        switch (intValue) {
                            case PanasonicMakernoteDirectory.TAG_SCENE_MODE /*32769*/:
                                return "Packed RAW";
                            case FujifilmMakernoteDirectory.TAG_ORDER_NUMBER /*32770*/:
                                return "Samsung SRW Compressed";
                            case FujifilmMakernoteDirectory.TAG_FRAME_NUMBER /*32771*/:
                                return "CCIRLEW";
                            case PanasonicMakernoteDirectory.TAG_WB_RED_LEVEL /*32772*/:
                                return "Samsung SRW Compressed 2";
                            case 32773:
                                return "PackBits";
                            default:
                                switch (intValue) {
                                    case 32895:
                                        return "IT8CTPAD";
                                    case 32896:
                                        return "IT8LW";
                                    case 32897:
                                        return "IT8MP";
                                    case 32898:
                                        return "IT8BL";
                                    default:
                                        switch (intValue) {
                                            case 32908:
                                                return "PixarFilm";
                                            case 32909:
                                                return "PixarLog";
                                            default:
                                                switch (intValue) {
                                                    case 32946:
                                                        return "Deflate";
                                                    case 32947:
                                                        return "DCS";
                                                    default:
                                                        switch (intValue) {
                                                            case 34676:
                                                                return "SGILog";
                                                            case 34677:
                                                                return "SGILog24";
                                                            default:
                                                                switch (intValue) {
                                                                    case 34712:
                                                                        return "JPEG 2000";
                                                                    case 34713:
                                                                        return "Nikon NEF Compressed";
                                                                    default:
                                                                        switch (intValue) {
                                                                            case 34718:
                                                                                return "Microsoft Document Imaging (MDI) Binary Level Codec";
                                                                            case 34719:
                                                                                return "Microsoft Document Imaging (MDI) Progressive Transform Codec";
                                                                            case 34720:
                                                                                return "Microsoft Document Imaging (MDI) Vector";
                                                                            default:
                                                                                return "Unknown (" + integer + ")";
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    @Nullable
    public String getSubjectDistanceDescription() {
        Rational rational = this._directory.getRational(ExifDirectoryBase.TAG_SUBJECT_DISTANCE);
        if (rational == null) {
            return null;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.0##");
        return decimalFormat.format(rational.doubleValue()) + " metres";
    }

    @Nullable
    public String getCompressedAverageBitsPerPixelDescription() {
        String str;
        StringBuilder sb;
        Rational rational = this._directory.getRational(ExifDirectoryBase.TAG_COMPRESSED_AVERAGE_BITS_PER_PIXEL);
        if (rational == null) {
            return null;
        }
        String simpleString = rational.toSimpleString(true);
        if (!rational.isInteger() || rational.intValue() != 1) {
            sb = new StringBuilder();
            sb.append(simpleString);
            str = " bits/pixel";
        } else {
            sb = new StringBuilder();
            sb.append(simpleString);
            str = " bit/pixel";
        }
        sb.append(str);
        return sb.toString();
    }

    @Nullable
    public String getExposureTimeDescription() {
        String string = this._directory.getString(ExifDirectoryBase.TAG_EXPOSURE_TIME);
        if (string == null) {
            return null;
        }
        return string + " sec";
    }

    @Nullable
    public String getShutterSpeedDescription() {
        return super.getShutterSpeedDescription(ExifDirectoryBase.TAG_SHUTTER_SPEED);
    }

    @Nullable
    public String getFNumberDescription() {
        Rational rational = this._directory.getRational(ExifDirectoryBase.TAG_FNUMBER);
        if (rational == null) {
            return null;
        }
        return getFStopDescription(rational.doubleValue());
    }

    @Nullable
    public String getSensingMethodDescription() {
        return getIndexedDescription(ExifDirectoryBase.TAG_SENSING_METHOD, 1, "(Not defined)", "One-chip color area sensor", "Two-chip color area sensor", "Three-chip color area sensor", "Color sequential area sensor", null, "Trilinear sensor", "Color sequential linear sensor");
    }

    @Nullable
    public String getComponentConfigurationDescription() {
        int[] intArray = this._directory.getIntArray(ExifDirectoryBase.TAG_COMPONENTS_CONFIGURATION);
        if (intArray == null) {
            return null;
        }
        String[] strArr = {"", "Y", "Cb", "Cr", "R", "G", "B"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(4, intArray.length); i++) {
            int i2 = intArray[i];
            if (i2 > 0 && i2 < strArr.length) {
                sb.append(strArr[i2]);
            }
        }
        return sb.toString();
    }

    @Nullable
    public String getJpegProcDescription() {
        Integer integer = this._directory.getInteger(512);
        if (integer == null) {
            return null;
        }
        int intValue = integer.intValue();
        if (intValue == 1) {
            return "Baseline";
        }
        if (intValue == 14) {
            return "Lossless";
        }
        return "Unknown (" + integer + ")";
    }
}
