package com.facebook.crypto;

import com.facebook.crypto.keychain.KeyChain;
import com.facebook.crypto.keygen.PasswordBasedKeyDerivation;
import com.facebook.crypto.util.NativeCryptoLibrary;
import java.security.SecureRandom;

public abstract class Conceal {
    public final NativeCryptoLibrary nativeLibrary;
    public final SecureRandom secureRandom;

    protected Conceal(NativeCryptoLibrary nativeCryptoLibrary, SecureRandom secureRandom2) {
        this.nativeLibrary = nativeCryptoLibrary;
        this.secureRandom = secureRandom2;
    }

    public Crypto createDefaultCrypto(KeyChain keyChain) {
        return createCrypto256Bits(keyChain);
    }

    public Crypto createCrypto128Bits(KeyChain keyChain) {
        return new Crypto(keyChain, this.nativeLibrary, CryptoConfig.KEY_128);
    }

    public Crypto createCrypto256Bits(KeyChain keyChain) {
        return new Crypto(keyChain, this.nativeLibrary, CryptoConfig.KEY_256);
    }

    public PasswordBasedKeyDerivation createPasswordBasedKeyDerivation() {
        return new PasswordBasedKeyDerivation(this.secureRandom, this.nativeLibrary);
    }
}
