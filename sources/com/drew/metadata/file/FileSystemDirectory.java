package com.drew.metadata.file;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class FileSystemDirectory extends Directory {
    public static final int TAG_FILE_MODIFIED_DATE = 3;
    public static final int TAG_FILE_NAME = 1;
    public static final int TAG_FILE_SIZE = 2;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "File";
    }

    static {
        _tagNameMap.put(1, "File Name");
        _tagNameMap.put(2, "File Size");
        _tagNameMap.put(3, "File Modified Date");
    }

    public FileSystemDirectory() {
        setDescriptor(new FileSystemDescriptor(this));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
