package com.drew.metadata.mov.media;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.mov.QuickTimeDirectory;
import java.util.HashMap;

public class QuickTimeTextDirectory extends QuickTimeDirectory {
    public static final int TAG_ANTI_ALIAS = 9;
    public static final int TAG_AUTO_SCALE = 1;
    public static final int TAG_BACKGROUND_COLOR = 12;
    public static final int TAG_CONTINUOUS_SCROLL = 7;
    public static final int TAG_DEFAULT_TEXT_BOX = 13;
    public static final int TAG_DROP_SHADOW = 8;
    public static final int TAG_FONT_FACE = 15;
    public static final int TAG_FONT_NUMBER = 14;
    public static final int TAG_FOREGROUND_COLOR = 16;
    public static final int TAG_HORIZONTAL_SCROLL = 5;
    public static final int TAG_JUSTIFICATION = 11;
    public static final int TAG_KEY_TEXT = 10;
    public static final int TAG_MOVIE_BACKGROUND_COLOR = 2;
    public static final int TAG_NAME = 17;
    public static final int TAG_REVERSE_SCROLL = 6;
    public static final int TAG_SCROLL_IN = 3;
    public static final int TAG_SCROLL_OUT = 4;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "QuickTime Text";
    }

    public QuickTimeTextDirectory() {
        setDescriptor(new QuickTimeTextDescriptor(this));
    }

    static {
        QuickTimeMediaDirectory.addQuickTimeMediaTags(_tagNameMap);
        _tagNameMap.put(1, "Auto Scale");
        _tagNameMap.put(2, "Use Background Color");
        _tagNameMap.put(3, "Scroll In");
        _tagNameMap.put(4, "Scroll Out");
        _tagNameMap.put(5, "Scroll Orientation");
        _tagNameMap.put(6, "Scroll Direction");
        _tagNameMap.put(7, "Continuous Scroll");
        _tagNameMap.put(8, "Drop Shadow");
        _tagNameMap.put(9, "Anti-aliasing");
        _tagNameMap.put(10, "Display Text Background Color");
        _tagNameMap.put(11, "Alignment");
        _tagNameMap.put(12, "Background Color");
        _tagNameMap.put(13, "Default Text Box");
        _tagNameMap.put(14, "Font Number");
        _tagNameMap.put(15, "Font Face");
        _tagNameMap.put(16, "Foreground Color");
        _tagNameMap.put(17, "Font Name");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
