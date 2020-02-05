package com.drew.metadata.exif.makernotes;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.TagDescriptor;

public class KyoceraMakernoteDescriptor extends TagDescriptor<KyoceraMakernoteDirectory> {
    public KyoceraMakernoteDescriptor(@NotNull KyoceraMakernoteDirectory kyoceraMakernoteDirectory) {
        super(kyoceraMakernoteDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i != 1) {
            return super.getDescription(i);
        }
        return getProprietaryThumbnailDataDescription();
    }

    @Nullable
    public String getProprietaryThumbnailDataDescription() {
        return getByteLengthDescription(1);
    }
}
