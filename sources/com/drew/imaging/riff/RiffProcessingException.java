package com.drew.imaging.riff;

import com.drew.imaging.ImageProcessingException;
import com.drew.lang.annotations.Nullable;

public class RiffProcessingException extends ImageProcessingException {
    private static final long serialVersionUID = -1658134596321487960L;

    public RiffProcessingException(@Nullable String str) {
        super(str);
    }

    public RiffProcessingException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public RiffProcessingException(@Nullable Throwable th) {
        super(th);
    }
}
