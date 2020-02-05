package com.drew.metadata.exif;

import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;

public class ExifThumbnailDescriptor extends ExifDescriptorBase<ExifThumbnailDirectory> {
    public ExifThumbnailDescriptor(@NotNull ExifThumbnailDirectory exifThumbnailDirectory) {
        super(exifThumbnailDirectory);
    }

    @Nullable
    public String getDescription(int i) {
        if (i == 513) {
            return getThumbnailOffsetDescription();
        }
        if (i != 514) {
            return super.getDescription(i);
        }
        return getThumbnailLengthDescription();
    }

    @Nullable
    public String getThumbnailLengthDescription() {
        String string = ((ExifThumbnailDirectory) this._directory).getString(514);
        if (string == null) {
            return null;
        }
        return string + " bytes";
    }

    @Nullable
    public String getThumbnailOffsetDescription() {
        String string = ((ExifThumbnailDirectory) this._directory).getString(513);
        if (string == null) {
            return null;
        }
        return string + " bytes";
    }
}
