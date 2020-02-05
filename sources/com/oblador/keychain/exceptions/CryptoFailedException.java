package com.oblador.keychain.exceptions;

public class CryptoFailedException extends Exception {
    public CryptoFailedException(String str) {
        super(str);
    }

    public CryptoFailedException(String str, Throwable th) {
        super(str, th);
    }
}
