package com.drew.metadata.exif.makernotes;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class RicohMakernoteDescriptor extends TagDescriptor<RicohMakernoteDirectory> {
    public RicohMakernoteDescriptor(@NotNull RicohMakernoteDirectory ricohMakernoteDirectory) {
        super(ricohMakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        return super.getDescription(i);
    }
}
