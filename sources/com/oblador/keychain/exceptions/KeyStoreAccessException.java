package com.oblador.keychain.exceptions;

public class KeyStoreAccessException extends Exception {
    public KeyStoreAccessException(String str, Throwable th) {
        super(str, th);
    }
}
