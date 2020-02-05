package com.drew.metadata.exif;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class PanasonicRawIFD0Descriptor extends TagDescriptor<PanasonicRawIFD0Directory> {
    public PanasonicRawIFD0Descriptor(@NotNull PanasonicRawIFD0Directory panasonicRawIFD0Directory) {
        super(panasonicRawIFD0Directory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 1) {
            return getVersionBytesDescription(1, 2);
        }
        if (i != 274) {
            return super.getDescription(i);
        }
        return getOrientationDescription(274);
    }
}
