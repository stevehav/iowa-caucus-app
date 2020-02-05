package com.facebook.crypto;

import com.facebook.crypto.exception.KeyChainException;
import com.facebook.crypto.keychain.KeyChain;

class CheckedKeyChain implements KeyChain {
    private final CryptoConfig mConfig;
    private final KeyChain mDelegate;

    public CheckedKeyChain(KeyChain keyChain, CryptoConfig cryptoConfig) {
        this.mDelegate = keyChain;
        this.mConfig = cryptoConfig;
    }

    public byte[] getCipherKey() throws KeyChainException {
        byte[] cipherKey = this.mDelegate.getCipherKey();
        checkLength(cipherKey, this.mConfig.keyLength, "Key");
        return cipherKey;
    }

    public byte[] getMacKey() throws KeyChainException {
        byte[] macKey = this.mDelegate.getMacKey();
        checkLength(macKey, 64, "Mac");
        return macKey;
    }

    public byte[] getNewIV() throws KeyChainException {
        byte[] newIV = this.mDelegate.getNewIV();
        checkLength(newIV, this.mConfig.ivLength, "IV");
        return newIV;
    }

    public void destroyKeys() {
        this.mDelegate.destroyKeys();
    }

    private void checkLength(byte[] bArr, int i, String str) {
        if (bArr.length != i) {
            throw new IllegalStateException(str + " should be " + i + " bytes long but is " + bArr.length);
        }
    }
}
