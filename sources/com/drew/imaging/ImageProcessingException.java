package com.drew.imaging;

import com.drew.lang.CompoundException;
import com.drew.lang.annotations.Nullable;

public class ImageProcessingException extends CompoundException {
    private static final long serialVersionUID = -9115669182209912676L;

    public ImageProcessingException(@Nullable String str) {
        super(str);
    }

    public ImageProcessingException(@Nullable String str, @Nullable Throwable th) {
        super(str, th);
    }

    public ImageProcessingException(@Nullable Throwable th) {
        super(th);
    }
}
