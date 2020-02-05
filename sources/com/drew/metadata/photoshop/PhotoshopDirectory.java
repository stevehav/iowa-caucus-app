package com.drew.metadata.photoshop;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class PhotoshopDirectory extends Directory {
    public static final int TAG_ALPHA_CHANNELS = 1006;
    public static final int TAG_ALPHA_IDENTIFIERS = 1053;
    public static final int TAG_ALTERNATE_DUOTONE_COLORS = 1066;
    public static final int TAG_ALTERNATE_SPOT_COLORS = 1067;
    public static final int TAG_AUTO_SAVE_FILE_PATH = 1086;
    public static final int TAG_AUTO_SAVE_FORMAT = 1087;
    public static final int TAG_BACKGROUND_COLOR = 1010;
    public static final int TAG_BORDER_INFORMATION = 1009;
    public static final int TAG_CAPTION = 1008;
    public static final int TAG_CAPTION_DIGEST = 1061;
    public static final int TAG_CHANNELS_ROWS_COLUMNS_DEPTH_MODE = 1000;
    public static final int TAG_CLIPPING_PATH_NAME = 2999;
    public static final int TAG_COLOR_HALFTONING_INFORMATION = 1013;
    public static final int TAG_COLOR_SAMPLERS = 1073;
    public static final int TAG_COLOR_TRANSFER_FUNCTIONS = 1016;
    public static final int TAG_COPYRIGHT = 1034;
    public static final int TAG_COUNT_INFORMATION = 1080;
    public static final int TAG_DISPLAY_INFO = 1077;
    public static final int TAG_DISPLAY_INFO_OBSOLETE = 1007;
    public static final int TAG_DUOTONE_HALFTONING_INFORMATION = 1014;
    public static final int TAG_DUOTONE_IMAGE_INFORMATION = 1018;
    public static final int TAG_DUOTONE_TRANSFER_FUNCTIONS = 1017;
    public static final int TAG_EFFECTIVE_BLACK_AND_WHITE_VALUES = 1019;
    public static final int TAG_EFFECTS_VISIBLE = 1042;
    public static final int TAG_EPS_OPTIONS = 1021;
    public static final int TAG_EXIF_DATA_1 = 1058;
    public static final int TAG_EXIF_DATA_3 = 1059;
    public static final int TAG_GLOBAL_ALTITUDE = 1049;
    public static final int TAG_GLOBAL_ANGLE = 1037;
    public static final int TAG_GRAYSCALE_AND_MULTICHANNEL_HALFTONING_INFORMATION = 1012;
    public static final int TAG_GRAYSCALE_AND_MULTICHANNEL_TRANSFER_FUNCTION = 1015;
    public static final int TAG_GRID_AND_GUIDES_INFORMATION = 1032;
    public static final int TAG_HDR_TONING_INFO = 1070;
    public static final int TAG_ICC_PROFILE_BYTES = 1039;
    public static final int TAG_ICC_UNTAGGED_PROFILE = 1041;
    public static final int TAG_IMAGE_MODE_FOR_RAW_FORMAT_FILES = 1029;
    public static final int TAG_IMAGE_READY_7_ROLLOVER = 7003;
    public static final int TAG_IMAGE_READY_DATA_SETS = 7001;
    public static final int TAG_IMAGE_READY_ROLLOVER = 7004;
    public static final int TAG_IMAGE_READY_SAVE_LAYER_SETTINGS = 7005;
    public static final int TAG_IMAGE_READY_SELECTED_STATE = 7002;
    public static final int TAG_IMAGE_READY_VARIABLES_XML = 7000;
    public static final int TAG_IMAGE_READY_VERSION = 7006;
    public static final int TAG_INDEXED_COLOR_TABLE = 1003;
    public static final int TAG_INDEXED_COLOR_TABLE_COUNT = 1046;
    public static final int TAG_IPTC = 1028;
    public static final int TAG_JPEG_QUALITY = 1030;
    public static final int TAG_JUMP_TO_XPEP = 1052;
    public static final int TAG_LAYERS_GROUP_INFORMATION = 1026;
    public static final int TAG_LAYER_COMPS = 1065;
    public static final int TAG_LAYER_GROUPS_ENABLED_ID = 1072;
    public static final int TAG_LAYER_SELECTION_IDS = 1069;
    public static final int TAG_LAYER_STATE_INFORMATION = 1024;
    public static final int TAG_LIGHTROOM_WORKFLOW = 8000;
    public static final int TAG_MAC_NSPRINTINFO = 1084;
    public static final int TAG_MAC_PRINT_INFO = 1001;
    public static final int TAG_MEASUREMENT_SCALE = 1074;
    public static final int TAG_ONION_SKINS = 1078;
    public static final int TAG_ORIGIN_PATH_INFO = 3000;
    public static final int TAG_PATH_SELECTION_STATE = 1088;
    public static final int TAG_PIXEL_ASPECT_RATIO = 1064;
    public static final int TAG_PRINT_FLAGS = 1011;
    public static final int TAG_PRINT_FLAGS_INFO = 10000;
    public static final int TAG_PRINT_INFO = 1071;
    public static final int TAG_PRINT_INFO_2 = 1082;
    public static final int TAG_PRINT_SCALE = 1062;
    public static final int TAG_PRINT_STYLE = 1083;
    public static final int TAG_QUICK_MASK_INFORMATION = 1022;
    public static final int TAG_RESOLUTION_INFO = 1005;
    public static final int TAG_SEED_NUMBER = 1044;
    public static final int TAG_SHEET_DISCLOSURE = 1076;
    public static final int TAG_SLICES = 1050;
    public static final int TAG_SPOT_HALFTONE = 1043;
    public static final int TAG_THUMBNAIL = 1036;
    public static final int TAG_THUMBNAIL_OLD = 1033;
    public static final int TAG_TIMELINE_INFORMATION = 1075;
    public static final int TAG_TRANSPARENCY_INDEX = 1047;
    public static final int TAG_UNICODE_ALPHA_NAMES = 1045;
    public static final int TAG_URL = 1035;
    public static final int TAG_URL_LIST = 1054;
    public static final int TAG_VERSION = 1057;
    public static final int TAG_WATERMARK = 1040;
    public static final int TAG_WIN_DEVMODE = 1085;
    public static final int TAG_WORKFLOW_URL = 1051;
    public static final int TAG_XML = 1002;
    public static final int TAG_XMP_DATA = 1060;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "Photoshop";
    }

    static {
        _tagNameMap.put(1000, "Channels, Rows, Columns, Depth, Mode");
        _tagNameMap.put(1001, "Mac Print Info");
        _tagNameMap.put(1002, "XML Data");
        _tagNameMap.put(1003, "Indexed Color Table");
        _tagNameMap.put(Integer.valueOf(TAG_RESOLUTION_INFO), "Resolution Info");
        _tagNameMap.put(1006, "Alpha Channels");
        _tagNameMap.put(1007, "Display Info (Obsolete)");
        _tagNameMap.put(1008, "Caption");
        _tagNameMap.put(1009, "Border Information");
        _tagNameMap.put(1010, "Background Color");
        _tagNameMap.put(1011, "Print Flags");
        _tagNameMap.put(1012, "Grayscale and Multichannel Halftoning Information");
        _tagNameMap.put(1013, "Color Halftoning Information");
        _tagNameMap.put(1014, "Duotone Halftoning Information");
        _tagNameMap.put(1015, "Grayscale and Multichannel Transfer Function");
        _tagNameMap.put(1016, "Color Transfer Functions");
        _tagNameMap.put(1017, "Duotone Transfer Functions");
        _tagNameMap.put(1018, "Duotone Image Information");
        _tagNameMap.put(1019, "Effective Black and White Values");
        _tagNameMap.put(1021, "EPS Options");
        _tagNameMap.put(Integer.valueOf(TAG_QUICK_MASK_INFORMATION), "Quick Mask Information");
        _tagNameMap.put(1024, "Layer State Information");
        _tagNameMap.put(Integer.valueOf(TAG_LAYERS_GROUP_INFORMATION), "Layers Group Information");
        _tagNameMap.put(1028, "IPTC-NAA Record");
        _tagNameMap.put(1029, "Image Mode for Raw Format Files");
        _tagNameMap.put(1030, "JPEG Quality");
        _tagNameMap.put(1032, "Grid and Guides Information");
        _tagNameMap.put(Integer.valueOf(TAG_THUMBNAIL_OLD), "Photoshop 4.0 Thumbnail");
        _tagNameMap.put(Integer.valueOf(TAG_COPYRIGHT), "Copyright Flag");
        _tagNameMap.put(Integer.valueOf(TAG_URL), "URL");
        _tagNameMap.put(Integer.valueOf(TAG_THUMBNAIL), "Thumbnail Data");
        _tagNameMap.put(1037, "Global Angle");
        _tagNameMap.put(Integer.valueOf(TAG_ICC_PROFILE_BYTES), "ICC Profile Bytes");
        _tagNameMap.put(1040, "Watermark");
        _tagNameMap.put(Integer.valueOf(TAG_ICC_UNTAGGED_PROFILE), "ICC Untagged Profile");
        _tagNameMap.put(1042, "Effects Visible");
        _tagNameMap.put(1043, "Spot Halftone");
        _tagNameMap.put(Integer.valueOf(TAG_SEED_NUMBER), "Seed Number");
        _tagNameMap.put(Integer.valueOf(TAG_UNICODE_ALPHA_NAMES), "Unicode Alpha Names");
        _tagNameMap.put(Integer.valueOf(TAG_INDEXED_COLOR_TABLE_COUNT), "Indexed Color Table Count");
        _tagNameMap.put(Integer.valueOf(TAG_TRANSPARENCY_INDEX), "Transparency Index");
        _tagNameMap.put(Integer.valueOf(TAG_GLOBAL_ALTITUDE), "Global Altitude");
        _tagNameMap.put(Integer.valueOf(TAG_SLICES), "Slices");
        _tagNameMap.put(Integer.valueOf(TAG_WORKFLOW_URL), "Workflow URL");
        _tagNameMap.put(Integer.valueOf(TAG_JUMP_TO_XPEP), "Jump To XPEP");
        _tagNameMap.put(Integer.valueOf(TAG_ALPHA_IDENTIFIERS), "Alpha Identifiers");
        _tagNameMap.put(Integer.valueOf(TAG_URL_LIST), "URL List");
        _tagNameMap.put(Integer.valueOf(TAG_VERSION), "Version Info");
        _tagNameMap.put(Integer.valueOf(TAG_EXIF_DATA_1), "EXIF Data 1");
        _tagNameMap.put(Integer.valueOf(TAG_EXIF_DATA_3), "EXIF Data 3");
        _tagNameMap.put(Integer.valueOf(TAG_XMP_DATA), "XMP Data");
        _tagNameMap.put(Integer.valueOf(TAG_CAPTION_DIGEST), "Caption Digest");
        _tagNameMap.put(Integer.valueOf(TAG_PRINT_SCALE), "Print Scale");
        _tagNameMap.put(Integer.valueOf(TAG_PIXEL_ASPECT_RATIO), "Pixel Aspect Ratio");
        _tagNameMap.put(Integer.valueOf(TAG_LAYER_COMPS), "Layer Comps");
        _tagNameMap.put(Integer.valueOf(TAG_ALTERNATE_DUOTONE_COLORS), "Alternate Duotone Colors");
        _tagNameMap.put(Integer.valueOf(TAG_ALTERNATE_SPOT_COLORS), "Alternate Spot Colors");
        _tagNameMap.put(Integer.valueOf(TAG_LAYER_SELECTION_IDS), "Layer Selection IDs");
        _tagNameMap.put(Integer.valueOf(TAG_HDR_TONING_INFO), "HDR Toning Info");
        _tagNameMap.put(Integer.valueOf(TAG_PRINT_INFO), "Print Info");
        _tagNameMap.put(Integer.valueOf(TAG_LAYER_GROUPS_ENABLED_ID), "Layer Groups Enabled ID");
        _tagNameMap.put(Integer.valueOf(TAG_COLOR_SAMPLERS), "Color Samplers");
        _tagNameMap.put(Integer.valueOf(TAG_MEASUREMENT_SCALE), "Measurement Scale");
        _tagNameMap.put(Integer.valueOf(TAG_TIMELINE_INFORMATION), "Timeline Information");
        _tagNameMap.put(Integer.valueOf(TAG_SHEET_DISCLOSURE), "Sheet Disclosure");
        _tagNameMap.put(Integer.valueOf(TAG_DISPLAY_INFO), "Display Info");
        _tagNameMap.put(Integer.valueOf(TAG_ONION_SKINS), "Onion Skins");
        _tagNameMap.put(Integer.valueOf(TAG_COUNT_INFORMATION), "Count information");
        _tagNameMap.put(Integer.valueOf(TAG_PRINT_INFO_2), "Print Info 2");
        _tagNameMap.put(Integer.valueOf(TAG_PRINT_STYLE), "Print Style");
        _tagNameMap.put(Integer.valueOf(TAG_MAC_NSPRINTINFO), "Mac NSPrintInfo");
        _tagNameMap.put(Integer.valueOf(TAG_WIN_DEVMODE), "Win DEVMODE");
        _tagNameMap.put(Integer.valueOf(TAG_AUTO_SAVE_FILE_PATH), "Auto Save File Subpath");
        _tagNameMap.put(Integer.valueOf(TAG_AUTO_SAVE_FORMAT), "Auto Save Format");
        _tagNameMap.put(Integer.valueOf(TAG_PATH_SELECTION_STATE), "Subpath Selection State");
        _tagNameMap.put(Integer.valueOf(TAG_CLIPPING_PATH_NAME), "Clipping Path Name");
        _tagNameMap.put(3000, "Origin Subpath Info");
        _tagNameMap.put(Integer.valueOf(TAG_IMAGE_READY_VARIABLES_XML), "Image Ready Variables XML");
        _tagNameMap.put(Integer.valueOf(TAG_IMAGE_READY_DATA_SETS), "Image Ready Data Sets");
        _tagNameMap.put(Integer.valueOf(TAG_IMAGE_READY_SELECTED_STATE), "Image Ready Selected State");
        _tagNameMap.put(Integer.valueOf(TAG_IMAGE_READY_7_ROLLOVER), "Image Ready 7 Rollover Expanded State");
        _tagNameMap.put(Integer.valueOf(TAG_IMAGE_READY_ROLLOVER), "Image Ready Rollover Expanded State");
        _tagNameMap.put(Integer.valueOf(TAG_IMAGE_READY_SAVE_LAYER_SETTINGS), "Image Ready Save Layer Settings");
        _tagNameMap.put(Integer.valueOf(TAG_IMAGE_READY_VERSION), "Image Ready Version");
        _tagNameMap.put(Integer.valueOf(TAG_LIGHTROOM_WORKFLOW), "Lightroom Workflow");
        _tagNameMap.put(Integer.valueOf(TAG_PRINT_FLAGS_INFO), "Print Flags Information");
    }

    public PhotoshopDirectory() {
        setDescriptor(new PhotoshopDescriptor(this));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    @Nullable
    public byte[] getThumbnailBytes() {
        byte[] byteArray = getByteArray(TAG_THUMBNAIL);
        if (byteArray == null) {
            byteArray = getByteArray(TAG_THUMBNAIL_OLD);
        }
        if (byteArray == null || byteArray.length <= 28) {
            return null;
        }
        int length = byteArray.length - 28;
        byte[] bArr = new byte[length];
        System.arraycopy(byteArray, 28, bArr, 0, length);
        return bArr;
    }
}
