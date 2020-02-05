package com.drew.metadata.exif;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class PanasonicRawWbInfo2Descriptor extends TagDescriptor<PanasonicRawWbInfo2Directory> {
    public PanasonicRawWbInfo2Descriptor(@NotNull PanasonicRawWbInfo2Directory panasonicRawWbInfo2Directory) {
        super(panasonicRawWbInfo2Directory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 1 || i == 5 || i == 9 || i == 13 || i == 17 || i == 21 || i == 25) {
            return getWbTypeDescription(i);
        }
        return super.getDescription(i);
    }

    @Nullable
    public String getWbTypeDescription(int i) {
        Integer integer = ((PanasonicRawWbInfo2Directory) this._directory).getInteger(i);
        if (integer == null) {
            return null;
        }
        return super.getLightSourceDescription(integer.shortValue());
    }
}
