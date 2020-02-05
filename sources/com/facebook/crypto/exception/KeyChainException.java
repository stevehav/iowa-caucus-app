package com.facebook.crypto.exception;

public class KeyChainException extends Exception {
    public KeyChainException(String str) {
        super(str);
    }

    public KeyChainException(String str, Throwable th) {
        super(str, th);
    }
}
