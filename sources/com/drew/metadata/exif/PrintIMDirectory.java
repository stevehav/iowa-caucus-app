package com.drew.metadata.exif;

import com.drew.lang.annotations.NotNull;
import com.drew.metadata.Directory;
import java.util.HashMap;

public class PrintIMDirectory extends Directory {
    public static final int TagPrintImVersion = 0;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "PrintIM";
    }

    static {
        _tagNameMap.put(0, "PrintIM Version");
    }

    public PrintIMDirectory() {
        setDescriptor(new PrintIMDescriptor(this));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }
}
