package com.facebook.crypto.util;

import com.facebook.crypto.exception.CryptoInitializationException;

public interface NativeCryptoLibrary {
    void ensureCryptoLoaded() throws CryptoInitializationException;
}
