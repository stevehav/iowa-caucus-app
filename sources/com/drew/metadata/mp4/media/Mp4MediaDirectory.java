package com.drew.metadata.mp4.media;

import com.drew.metadata.mp4.Mp4Directory;
import java.util.HashMap;

public abstract class Mp4MediaDirectory extends Mp4Directory {
    public static final int TAG_CREATION_TIME = 101;
    public static final int TAG_DURATION = 103;
    public static final int TAG_LANGUAGE_CODE = 104;
    public static final int TAG_MODIFICATION_TIME = 102;

    protected static void addMp4MediaTags(HashMap<Integer, String> hashMap) {
        hashMap.put(101, "Creation Time");
        hashMap.put(102, "Modification Time");
        hashMap.put(103, "Duration");
        hashMap.put(104, "ISO 639-2 Language Code");
    }
}
