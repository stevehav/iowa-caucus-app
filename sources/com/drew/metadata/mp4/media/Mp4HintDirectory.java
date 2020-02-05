package com.drew.metadata.mp4.media;

import com.drew.lang.annotations.NotNull;
import java.util.HashMap;

public class Mp4HintDirectory extends Mp4MediaDirectory {
    public static final int TAG_AVERAGE_BITRATE = 104;
    public static final int TAG_AVERAGE_PDU_SIZE = 102;
    public static final int TAG_MAX_BITRATE = 103;
    public static final int TAG_MAX_PDU_SIZE = 101;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "MP4 Hint";
    }

    public Mp4HintDirectory() {
        setDescriptor(new Mp4HintDescriptor(this));
    }

    static {
        Mp4MediaDirectory.addMp4MediaTags(_tagNameMap);
        _tagNameMap.put(101, "Max PDU Size");
        _tagNameMap.put(102, "Average PDU Size");
        _tagNameMap.put(103, "Max Bitrate");
        _tagNameMap.put(104, "Average Bitrate");
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
