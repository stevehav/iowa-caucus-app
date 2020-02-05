package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class UnexpectedNativeTypeException extends RuntimeException {
    @DoNotStrip
    public UnexpectedNativeTypeException(String str) {
        super(str);
    }
}
