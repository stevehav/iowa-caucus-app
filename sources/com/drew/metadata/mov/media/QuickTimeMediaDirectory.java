package com.drew.metadata.mov.media;

import com.drew.metadata.mov.QuickTimeDirectory;
import java.util.HashMap;

public abstract class QuickTimeMediaDirectory extends QuickTimeDirectory {
    public static final int TAG_CREATION_TIME = 20481;
    public static final int TAG_DURATION = 20483;
    public static final int TAG_MODIFICATION_TIME = 20482;

    protected static void addQuickTimeMediaTags(HashMap<Integer, String> hashMap) {
        hashMap.put(Integer.valueOf(TAG_CREATION_TIME), "Creation Time");
        hashMap.put(Integer.valueOf(TAG_MODIFICATION_TIME), "Modification Time");
        hashMap.put(Integer.valueOf(TAG_DURATION), "Duration");
    }
}
