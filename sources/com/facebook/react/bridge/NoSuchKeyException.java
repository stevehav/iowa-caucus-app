package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;

@DoNotStrip
public class NoSuchKeyException extends RuntimeException {
    @DoNotStrip
    public NoSuchKeyException(String str) {
        super(str);
    }
}
