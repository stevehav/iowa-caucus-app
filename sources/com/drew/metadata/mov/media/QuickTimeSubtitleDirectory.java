package com.drew.metadata.mov.media;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.mov.QuickTimeDirectory;
import java.util.HashMap;

public class QuickTimeSubtitleDirectory extends QuickTimeDirectory {
    public static final int TAG_ALL_SAMPLES_FORCED = 3;
    public static final int TAG_DEFAULT_TEXT_BOX = 4;
    public static final int TAG_FONT_FACE = 6;
    public static final int TAG_FONT_IDENTIFIER = 5;
    public static final int TAG_FONT_SIZE = 7;
    public static final int TAG_FOREGROUND_COLOR = 8;
    public static final int TAG_SOME_SAMPLES_FORCED = 2;
    public static final int TAG_VERTICAL_PLACEMENT = 1;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "QuickTime Subtitle";
    }

    public QuickTimeSubtitleDirectory() {
        setDescriptor(new QuickTimeSubtitleDescriptor(this));
    }

    static {
        QuickTimeMediaDirectory.addQuickTimeMediaTags(_tagNameMap);
        _tagNameMap.put(1, "Vertical Placement");
        _tagNameMap.put(2, "Some Samples Forced");
        _tagNameMap.put(3, "All Samples Forced");
        _tagNameMap.put(4, "Default Text Box");
        _tagNameMap.put(5, "Font Identifier");
        _tagNameMap.put(6, "Font Face");
        _tagNameMap.put(7, "Font Size");
        _tagNameMap.put(8, "Foreground Color");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
