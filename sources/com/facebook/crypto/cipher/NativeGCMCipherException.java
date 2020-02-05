package com.facebook.crypto.cipher;

import java.io.IOException;

public class NativeGCMCipherException extends IOException {
    public NativeGCMCipherException(String str) {
        super(str);
    }
}
