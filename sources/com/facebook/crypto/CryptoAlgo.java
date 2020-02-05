package com.facebook.crypto;

import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface CryptoAlgo {
    int getCipherMetaDataLength();

    InputStream wrap(InputStream inputStream, Entity entity) throws IOException, CryptoInitializationException, KeyChainException;

    OutputStream wrap(OutputStream outputStream, Entity entity, byte[] bArr) throws IOException, CryptoInitializationException, KeyChainException;
}
