package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class InvalidIteratorException extends RuntimeException {
    @DoNotStrip
    public InvalidIteratorException(String str) {
        super(str);
    }
}
