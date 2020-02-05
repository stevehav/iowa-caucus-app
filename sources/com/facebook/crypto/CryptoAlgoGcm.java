package com.facebook.crypto;

import com.facebook.crypto.cipher.NativeGCMCipher;
import com.facebook.crypto.cipher.NativeGCMCipherException;
import com.facebook.crypto.exception.CryptoInitializationException;
import com.facebook.crypto.exception.KeyChainException;
import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.streams.NativeGCMCipherInputStream;
import com.facebook.crypto.streams.NativeGCMCipherOutputStream;
import com.facebook.crypto.util.Assertions;
import com.facebook.crypto.util.NativeCryptoLibrary;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CryptoAlgoGcm implements CryptoAlgo {
    private final CryptoConfig mConfig;
    private final KeyChain mKeyChain;
    private final NativeCryptoLibrary mNativeLibrary;

    public CryptoAlgoGcm(NativeCryptoLibrary nativeCryptoLibrary, KeyChain keyChain, CryptoConfig cryptoConfig) {
        this.mNativeLibrary = nativeCryptoLibrary;
        this.mKeyChain = keyChain;
        this.mConfig = cryptoConfig;
    }

    public OutputStream wrap(OutputStream outputStream, Entity entity, byte[] bArr) throws IOException, CryptoInitializationException, KeyChainException {
        outputStream.write(1);
        outputStream.write(this.mConfig.cipherId);
        byte[] newIV = this.mKeyChain.getNewIV();
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.mNativeLibrary);
        nativeGCMCipher.encryptInit(this.mKeyChain.getCipherKey(), newIV);
        outputStream.write(newIV);
        computeCipherAad(nativeGCMCipher, (byte) 1, this.mConfig.cipherId, entity.getBytes());
        return new NativeGCMCipherOutputStream(outputStream, nativeGCMCipher, bArr, this.mConfig.tagLength);
    }

    public InputStream wrap(InputStream inputStream, Entity entity) throws IOException, CryptoInitializationException, KeyChainException {
        byte read = (byte) inputStream.read();
        byte read2 = (byte) inputStream.read();
        boolean z = false;
        boolean z2 = read == 1;
        Assertions.checkArgumentForIO(z2, "Unexpected crypto version " + read);
        if (read2 == this.mConfig.cipherId) {
            z = true;
        }
        Assertions.checkArgumentForIO(z, "Unexpected cipher ID " + read2);
        byte[] bArr = new byte[this.mConfig.ivLength];
        new DataInputStream(inputStream).readFully(bArr);
        NativeGCMCipher nativeGCMCipher = new NativeGCMCipher(this.mNativeLibrary);
        nativeGCMCipher.decryptInit(this.mKeyChain.getCipherKey(), bArr);
        computeCipherAad(nativeGCMCipher, read, read2, entity.getBytes());
        return new NativeGCMCipherInputStream(inputStream, nativeGCMCipher, this.mConfig.tagLength);
    }

    private void computeCipherAad(NativeGCMCipher nativeGCMCipher, byte b, byte b2, byte[] bArr) throws NativeGCMCipherException {
        byte[] bArr2 = {b};
        nativeGCMCipher.updateAad(bArr2, 1);
        nativeGCMCipher.updateAad(new byte[]{b2}, 1);
        nativeGCMCipher.updateAad(bArr, bArr.length);
    }

    public int getCipherMetaDataLength() {
        return this.mConfig.ivLength + 2 + this.mConfig.tagLength;
    }
}
