package com.drew.metadata.jpeg;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Directory;
import com.drew.metadata.MetadataException;
import java.util.HashMap;

public class JpegDirectory extends Directory {
    public static final int TAG_COMPONENT_DATA_1 = 6;
    public static final int TAG_COMPONENT_DATA_2 = 7;
    public static final int TAG_COMPONENT_DATA_3 = 8;
    public static final int TAG_COMPONENT_DATA_4 = 9;
    public static final int TAG_COMPRESSION_TYPE = -3;
    public static final int TAG_DATA_PRECISION = 0;
    public static final int TAG_IMAGE_HEIGHT = 1;
    public static final int TAG_IMAGE_WIDTH = 3;
    public static final int TAG_NUMBER_OF_COMPONENTS = 5;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();

    @NotNull
    public String getName() {
        return "JPEG";
    }

    static {
        _tagNameMap.put(-3, "Compression Type");
        _tagNameMap.put(0, "Data Precision");
        _tagNameMap.put(3, "Image Width");
        _tagNameMap.put(1, "Image Height");
        _tagNameMap.put(5, "Number of Components");
        _tagNameMap.put(6, "Component 1");
        _tagNameMap.put(7, "Component 2");
        _tagNameMap.put(8, "Component 3");
        _tagNameMap.put(9, "Component 4");
    }

    public JpegDirectory() {
        setDescriptor(new JpegDescriptor(this));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    @Nullable
    public JpegComponent getComponent(int i) {
        return (JpegComponent) getObject(i + 6);
    }

    public int getImageWidth() throws MetadataException {
        return getInt(3);
    }

    public int getImageHeight() throws MetadataException {
        return getInt(1);
    }

    public int getNumberOfComponents() throws MetadataException {
        return getInt(5);
    }
}
