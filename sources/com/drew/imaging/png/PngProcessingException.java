package com.drew.imaging.png;

import com.drew.imaging.ImageProcessingException;
import com.drew.lang.annotations.Nullable;

public class PngProcessingException extends ImageProcessingException {
    private static final long serialVersionUID = -687991554932005033L;

    public PngProcessingException(@Nullable String str) {
        super(str);
    }

    public PngProcessingException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public PngProcessingException(@Nullable Throwable th) {
        super(th);
    }
}
