package com.drew.metadata.mov.media;

import com.drew.lang.annotations.NotNull;
import java.util.HashMap;

public class QuickTimeVideoDirectory extends QuickTimeMediaDirectory {
    public static final int TAG_COLOR_TABLE = 13;
    public static final int TAG_COMPRESSION_TYPE = 10;
    public static final int TAG_COMPRESSOR_NAME = 8;
    public static final int TAG_DEPTH = 9;
    public static final int TAG_FRAME_RATE = 14;
    public static final int TAG_GRAPHICS_MODE = 11;
    public static final int TAG_HEIGHT = 5;
    public static final int TAG_HORIZONTAL_RESOLUTION = 6;
    public static final int TAG_OPCOLOR = 12;
    public static final int TAG_SPATIAL_QUALITY = 3;
    public static final int TAG_TEMPORAL_QUALITY = 2;
    public static final int TAG_VENDOR = 1;
    public static final int TAG_VERTICAL_RESOLUTION = 7;
    public static final int TAG_WIDTH = 4;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "QuickTime Video";
    }

    public QuickTimeVideoDirectory() {
        setDescriptor(new QuickTimeVideoDescriptor(this));
    }

    static {
        QuickTimeMediaDirectory.addQuickTimeMediaTags(_tagNameMap);
        _tagNameMap.put(1, "Vendor");
        _tagNameMap.put(2, "Temporal Quality");
        _tagNameMap.put(3, "Spatial Quality");
        _tagNameMap.put(4, "Width");
        _tagNameMap.put(5, "Height");
        _tagNameMap.put(6, "Horizontal Resolution");
        _tagNameMap.put(7, "Vertical Resolution");
        _tagNameMap.put(8, "Compressor Name");
        _tagNameMap.put(9, "Depth");
        _tagNameMap.put(10, "Compression Type");
        _tagNameMap.put(11, "Graphics Mode");
        _tagNameMap.put(12, "Opcolor");
        _tagNameMap.put(13, "Color Table");
        _tagNameMap.put(14, "Frame Rate");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
