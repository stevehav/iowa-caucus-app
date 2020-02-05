package com.drew.imaging.jpeg;

import com.drew.imaging.ImageProcessingException;
import com.drew.lang.annotations.Nullable;

public class JpegProcessingException extends ImageProcessingException {
    private static final long serialVersionUID = -7870179776125450158L;

    public JpegProcessingException(@Nullable String str) {
        super(str);
    }

    public JpegProcessingException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public JpegProcessingException(@Nullable Throwable th) {
        super(th);
    }
}
