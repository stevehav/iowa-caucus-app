package com.drew.metadata.exif.makernotes;

import androidx.exifinterface.media.ExifInterface;
import com.drew.lang.ByteArrayReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Age;
import com.drew.metadata.Directory;
import com.drew.metadata.Face;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.util.HashMap;

public class PanasonicMakernoteDirectory extends Directory {
    public static final int TAG_ACCELEROMETER_X = 141;
    public static final int TAG_ACCELEROMETER_Y = 142;
    public static final int TAG_ACCELEROMETER_Z = 140;
    public static final int TAG_ACCESSORY_SERIAL_NUMBER = 84;
    public static final int TAG_ACCESSORY_TYPE = 83;
    public static final int TAG_ADVANCED_SCENE_MODE = 61;
    public static final int TAG_AF_AREA_MODE = 15;
    public static final int TAG_AF_ASSIST_LAMP = 49;
    public static final int TAG_AF_POINT_POSITION = 77;
    public static final int TAG_AUDIO = 32;
    public static final int TAG_BABY_AGE = 51;
    public static final int TAG_BABY_AGE_1 = 32784;
    public static final int TAG_BABY_NAME = 102;
    public static final int TAG_BRACKET_SETTINGS = 69;
    public static final int TAG_BURST_MODE = 42;
    public static final int TAG_BURST_SPEED = 119;
    public static final int TAG_CAMERA_ORIENTATION = 143;
    public static final int TAG_CITY = 109;
    public static final int TAG_CITY2 = 128;
    public static final int TAG_CLEAR_RETOUCH = 124;
    public static final int TAG_CLEAR_RETOUCH_VALUE = 163;
    public static final int TAG_COLOR_EFFECT = 40;
    public static final int TAG_COLOR_MODE = 50;
    public static final int TAG_COLOR_TEMP_KELVIN = 68;
    public static final int TAG_CONTRAST = 57;
    public static final int TAG_CONTRAST_MODE = 44;
    public static final int TAG_CONVERSION_LENS = 53;
    public static final int TAG_COUNTRY = 105;
    public static final int TAG_EASY_MODE = 34;
    public static final int TAG_EXIF_VERSION = 38;
    public static final int TAG_FACES_DETECTED = 63;
    public static final int TAG_FACE_DETECTION_INFO = 78;
    public static final int TAG_FACE_RECOGNITION_INFO = 97;
    public static final int TAG_FILM_MODE = 66;
    public static final int TAG_FIRMWARE_VERSION = 2;
    public static final int TAG_FLASH_BIAS = 36;
    public static final int TAG_FLASH_CURTAIN = 72;
    public static final int TAG_FLASH_FIRED = 32775;
    public static final int TAG_FLASH_WARNING = 98;
    public static final int TAG_FOCUS_MODE = 7;
    public static final int TAG_HDR = 158;
    public static final int TAG_IMAGE_STABILIZATION = 26;
    public static final int TAG_INTELLIGENT_D_RANGE = 121;
    public static final int TAG_INTELLIGENT_EXPOSURE = 93;
    public static final int TAG_INTELLIGENT_RESOLUTION = 112;
    public static final int TAG_INTERNAL_ND_FILTER = 157;
    public static final int TAG_INTERNAL_SERIAL_NUMBER = 37;
    public static final int TAG_LANDMARK = 111;
    public static final int TAG_LENS_FIRMWARE_VERSION = 96;
    public static final int TAG_LENS_SERIAL_NUMBER = 82;
    public static final int TAG_LENS_TYPE = 81;
    public static final int TAG_LOCATION = 103;
    public static final int TAG_LONG_EXPOSURE_NOISE_REDUCTION = 73;
    public static final int TAG_MACRO_MODE = 28;
    public static final int TAG_MAKERNOTE_VERSION = 32768;
    public static final int TAG_NOISE_REDUCTION = 45;
    public static final int TAG_OPTICAL_ZOOM_MODE = 52;
    public static final int TAG_PANASONIC_IMAGE_HEIGHT = 76;
    public static final int TAG_PANASONIC_IMAGE_WIDTH = 75;
    public static final int TAG_PHOTO_STYLE = 137;
    public static final int TAG_PITCH_ANGLE = 145;
    public static final int TAG_PRINT_IMAGE_MATCHING_INFO = 3584;
    public static final int TAG_PROGRAM_ISO = 60;
    public static final int TAG_QUALITY_MODE = 1;
    public static final int TAG_RECOGNIZED_FACE_FLAGS = 99;
    public static final int TAG_RECORD_MODE = 31;
    public static final int TAG_ROLL_ANGLE = 144;
    public static final int TAG_ROTATION = 48;
    public static final int TAG_SATURATION = 64;
    public static final int TAG_SCENE_MODE = 32769;
    public static final int TAG_SELF_TIMER = 46;
    public static final int TAG_SEQUENCE_NUMBER = 43;
    public static final int TAG_SHADING_COMPENSATION = 138;
    public static final int TAG_SHARPNESS = 65;
    public static final int TAG_SHUTTER_TYPE = 159;
    public static final int TAG_STATE = 107;
    public static final int TAG_SWEEP_PANORAMA_DIRECTION = 147;
    public static final int TAG_SWEEP_PANORAMA_FIELD_OF_VIEW = 148;
    public static final int TAG_TEXT_STAMP = 59;
    public static final int TAG_TEXT_STAMP_1 = 62;
    public static final int TAG_TEXT_STAMP_2 = 32776;
    public static final int TAG_TEXT_STAMP_3 = 32777;
    public static final int TAG_TIMER_RECORDING = 150;
    public static final int TAG_TITLE = 101;
    public static final int TAG_TOUCH_AE = 171;
    public static final int TAG_TRANSFORM = 89;
    public static final int TAG_TRANSFORM_1 = 32786;
    public static final int TAG_TRAVEL_DAY = 54;
    public static final int TAG_UNKNOWN_DATA_DUMP = 33;
    public static final int TAG_UPTIME = 41;
    public static final int TAG_WB_ADJUST_AB = 70;
    public static final int TAG_WB_ADJUST_GM = 71;
    public static final int TAG_WB_BLUE_LEVEL = 32774;
    public static final int TAG_WB_GREEN_LEVEL = 32773;
    public static final int TAG_WB_RED_LEVEL = 32772;
    public static final int TAG_WHITE_BALANCE = 3;
    public static final int TAG_WHITE_BALANCE_BIAS = 35;
    public static final int TAG_WORLD_TIME_LOCATION = 58;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "Panasonic Makernote";
    }

    static {
        _tagNameMap.put(1, "Quality Mode");
        _tagNameMap.put(2, "Version");
        _tagNameMap.put(3, "White Balance");
        _tagNameMap.put(7, "Focus Mode");
        _tagNameMap.put(15, "AF Area Mode");
        _tagNameMap.put(26, "Image Stabilization");
        _tagNameMap.put(28, "Macro Mode");
        _tagNameMap.put(31, "Record Mode");
        _tagNameMap.put(32, "Audio");
        _tagNameMap.put(37, "Internal Serial Number");
        _tagNameMap.put(33, "Unknown Data Dump");
        _tagNameMap.put(34, "Easy Mode");
        _tagNameMap.put(35, "White Balance Bias");
        _tagNameMap.put(36, "Flash Bias");
        _tagNameMap.put(38, "Exif Version");
        _tagNameMap.put(40, "Color Effect");
        _tagNameMap.put(41, "Camera Uptime");
        _tagNameMap.put(42, "Burst Mode");
        _tagNameMap.put(43, "Sequence Number");
        _tagNameMap.put(44, "Contrast Mode");
        _tagNameMap.put(45, "Noise Reduction");
        _tagNameMap.put(46, "Self Timer");
        _tagNameMap.put(48, "Rotation");
        _tagNameMap.put(49, "AF Assist Lamp");
        _tagNameMap.put(50, "Color Mode");
        _tagNameMap.put(51, "Baby Age");
        _tagNameMap.put(52, "Optical Zoom Mode");
        _tagNameMap.put(53, "Conversion Lens");
        _tagNameMap.put(54, "Travel Day");
        _tagNameMap.put(57, ExifInterface.TAG_CONTRAST);
        _tagNameMap.put(58, "World Time Location");
        _tagNameMap.put(59, "Text Stamp");
        _tagNameMap.put(60, "Program ISO");
        _tagNameMap.put(61, "Advanced Scene Mode");
        _tagNameMap.put(3584, "Print Image Matching (PIM) Info");
        _tagNameMap.put(63, "Number of Detected Faces");
        _tagNameMap.put(64, ExifInterface.TAG_SATURATION);
        _tagNameMap.put(65, ExifInterface.TAG_SHARPNESS);
        _tagNameMap.put(66, "Film Mode");
        _tagNameMap.put(68, "Color Temp Kelvin");
        _tagNameMap.put(69, "Bracket Settings");
        _tagNameMap.put(70, "White Balance Adjust (AB)");
        _tagNameMap.put(71, "White Balance Adjust (GM)");
        _tagNameMap.put(72, "Flash Curtain");
        _tagNameMap.put(73, "Long Exposure Noise Reduction");
        _tagNameMap.put(75, "Panasonic Image Width");
        _tagNameMap.put(76, "Panasonic Image Height");
        _tagNameMap.put(77, "Af Point Position");
        _tagNameMap.put(78, "Face Detection Info");
        _tagNameMap.put(81, "Lens Type");
        _tagNameMap.put(82, "Lens Serial Number");
        _tagNameMap.put(83, "Accessory Type");
        _tagNameMap.put(84, "Accessory Serial Number");
        _tagNameMap.put(89, "Transform");
        _tagNameMap.put(93, "Intelligent Exposure");
        _tagNameMap.put(96, "Lens Firmware Version");
        _tagNameMap.put(97, "Face Recognition Info");
        _tagNameMap.put(98, "Flash Warning");
        _tagNameMap.put(99, "Recognized Face Flags");
        _tagNameMap.put(101, "Title");
        _tagNameMap.put(102, "Baby Name");
        _tagNameMap.put(103, HttpHeaders.LOCATION);
        _tagNameMap.put(105, "Country");
        _tagNameMap.put(107, "State");
        _tagNameMap.put(109, "City");
        _tagNameMap.put(111, "Landmark");
        _tagNameMap.put(112, "Intelligent Resolution");
        _tagNameMap.put(119, "Burst Speed");
        _tagNameMap.put(Integer.valueOf(TAG_INTELLIGENT_D_RANGE), "Intelligent D-Range");
        _tagNameMap.put(Integer.valueOf(TAG_CLEAR_RETOUCH), "Clear Retouch");
        _tagNameMap.put(128, "City 2");
        _tagNameMap.put(137, "Photo Style");
        _tagNameMap.put(138, "Shading Compensation");
        _tagNameMap.put(140, "Accelerometer Z");
        _tagNameMap.put(141, "Accelerometer X");
        _tagNameMap.put(142, "Accelerometer Y");
        _tagNameMap.put(143, "Camera Orientation");
        _tagNameMap.put(144, "Roll Angle");
        _tagNameMap.put(145, "Pitch Angle");
        _tagNameMap.put(147, "Sweep Panorama Direction");
        _tagNameMap.put(148, "Sweep Panorama Field Of View");
        _tagNameMap.put(150, "Timer Recording");
        _tagNameMap.put(157, "Internal ND Filter");
        _tagNameMap.put(158, "HDR");
        _tagNameMap.put(159, "Shutter Type");
        _tagNameMap.put(163, "Clear Retouch Value");
        _tagNameMap.put(171, "Touch AE");
        _tagNameMap.put(32768, "Makernote Version");
        _tagNameMap.put(Integer.valueOf(TAG_SCENE_MODE), "Scene Mode");
        _tagNameMap.put(Integer.valueOf(TAG_WB_RED_LEVEL), "White Balance (Red)");
        _tagNameMap.put(32773, "White Balance (Green)");
        _tagNameMap.put(Integer.valueOf(TAG_WB_BLUE_LEVEL), "White Balance (Blue)");
        _tagNameMap.put(Integer.valueOf(TAG_FLASH_FIRED), "Flash Fired");
        _tagNameMap.put(62, "Text Stamp 1");
        _tagNameMap.put(Integer.valueOf(TAG_TEXT_STAMP_2), "Text Stamp 2");
        _tagNameMap.put(Integer.valueOf(TAG_TEXT_STAMP_3), "Text Stamp 3");
        _tagNameMap.put(Integer.valueOf(TAG_BABY_AGE_1), "Baby Age 1");
        _tagNameMap.put(Integer.valueOf(TAG_TRANSFORM_1), "Transform 1");
    }

    public PanasonicMakernoteDirectory() {
        setDescriptor(new PanasonicMakernoteDescriptor(this));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    @Nullable
    public Face[] getDetectedFaces() {
        byte[] byteArray = getByteArray(78);
        if (byteArray == null) {
            return null;
        }
        ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
        byteArrayReader.setMotorolaByteOrder(false);
        try {
            int uInt16 = byteArrayReader.getUInt16(0);
            if (uInt16 == 0) {
                return null;
            }
            Face[] faceArr = new Face[uInt16];
            for (int i = 0; i < uInt16; i++) {
                int i2 = (i * 8) + 2;
                faceArr[i] = new Face(byteArrayReader.getUInt16(i2), byteArrayReader.getUInt16(i2 + 2), byteArrayReader.getUInt16(i2 + 4), byteArrayReader.getUInt16(i2 + 6), (String) null, (Age) null);
            }
            return faceArr;
        } catch (IOException unused) {
            return null;
        }
    }

    @Nullable
    public Face[] getRecognizedFaces() {
        byte[] byteArray = getByteArray(97);
        if (byteArray == null) {
            return null;
        }
        ByteArrayReader byteArrayReader = new ByteArrayReader(byteArray);
        byteArrayReader.setMotorolaByteOrder(false);
        try {
            int uInt16 = byteArrayReader.getUInt16(0);
            if (uInt16 == 0) {
                return null;
            }
            Face[] faceArr = new Face[uInt16];
            for (int i = 0; i < uInt16; i++) {
                int i2 = (i * 44) + 4;
                faceArr[i] = new Face(byteArrayReader.getUInt16(i2 + 20), byteArrayReader.getUInt16(i2 + 22), byteArrayReader.getUInt16(i2 + 24), byteArrayReader.getUInt16(i2 + 26), byteArrayReader.getString(i2, 20, "ASCII").trim(), Age.fromPanasonicString(byteArrayReader.getString(i2 + 28, 20, "ASCII").trim()));
            }
            return faceArr;
        } catch (IOException unused) {
            return null;
        }
    }

    @Nullable
    public Age getAge(int i) {
        String string = getString(i);
        if (string == null) {
            return null;
        }
        return Age.fromPanasonicString(string);
    }
}
