package com.drew.metadata.file;

import com.drew.imaging.FileType;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class FileTypeDirectory extends Directory {
    public static final int TAG_DETECTED_FILE_MIME_TYPE = 3;
    public static final int TAG_DETECTED_FILE_TYPE_LONG_NAME = 2;
    public static final int TAG_DETECTED_FILE_TYPE_NAME = 1;
    public static final int TAG_EXPECTED_FILE_NAME_EXTENSION = 4;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "File Type";
    }

    static {
        _tagNameMap.put(1, "Detected File Type Name");
        _tagNameMap.put(2, "Detected File Type Long Name");
        _tagNameMap.put(3, "Detected MIME Type");
        _tagNameMap.put(4, "Expected File Name Extension");
    }

    public FileTypeDirectory(FileType fileType) {
        setDescriptor(new FileTypeDescriptor(this));
        setString(1, fileType.getName());
        setString(2, fileType.getLongName());
        if (fileType.getMimeType() != null) {
            setString(3, fileType.getMimeType());
        }
        if (fileType.getCommonExtension() != null) {
            setString(4, fileType.getCommonExtension());
        }
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
