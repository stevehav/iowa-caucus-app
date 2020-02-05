package com.drew.imaging.tiff;

import com.drew.imaging.ImageProcessingException;
import com.drew.lang.annotations.Nullable;

public class TiffProcessingException extends ImageProcessingException {
    private static final long serialVersionUID = -1658134119488001891L;

    public TiffProcessingException(@Nullable String str) {
        super(str);
    }

    public TiffProcessingException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public TiffProcessingException(@Nullable Throwable th) {
        super(th);
    }
}
