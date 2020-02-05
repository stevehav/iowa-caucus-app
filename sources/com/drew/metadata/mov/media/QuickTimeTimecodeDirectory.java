package com.drew.metadata.mov.media;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.mov.QuickTimeDirectory;
import java.util.HashMap;

public class QuickTimeTimecodeDirectory extends QuickTimeDirectory {
    public static final int TAG_24_HOUR_MAX = 2;
    public static final int TAG_BACKGROUND_COLOR = 9;
    public static final int TAG_COUNTER = 4;
    public static final int TAG_DROP_FRAME = 1;
    public static final int TAG_FONT_NAME = 10;
    public static final int TAG_NEGATIVE_TIMES_OK = 3;
    public static final int TAG_TEXT_COLOR = 8;
    public static final int TAG_TEXT_FACE = 6;
    public static final int TAG_TEXT_FONT = 5;
    public static final int TAG_TEXT_SIZE = 7;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "QuickTime Timecode";
    }

    public QuickTimeTimecodeDirectory() {
        setDescriptor(new QuickTimeTimecodeDescriptor(this));
    }

    static {
        QuickTimeMediaDirectory.addQuickTimeMediaTags(_tagNameMap);
        _tagNameMap.put(1, "Drop Frame");
        _tagNameMap.put(2, "24 Hour Max");
        _tagNameMap.put(3, "Negative Times OK");
        _tagNameMap.put(4, "Counter");
        _tagNameMap.put(5, "Text Font");
        _tagNameMap.put(6, "Text Face");
        _tagNameMap.put(7, "Text Size");
        _tagNameMap.put(8, "Text Color");
        _tagNameMap.put(9, "Background Color");
        _tagNameMap.put(10, "Font Name");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
