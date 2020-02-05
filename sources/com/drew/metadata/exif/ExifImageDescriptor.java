package com.drew.metadata.exif;

import com.drew.lang.annotations.NotNull;

public class ExifImageDescriptor extends ExifDescriptorBase<ExifImageDirectory> {
    public ExifImageDescriptor(@NotNull ExifImageDirectory exifImageDirectory) {
        super(exifImageDirectory);
    }
}
