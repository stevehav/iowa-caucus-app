package com.oblador.keychain.cipherStorage;

import androidx.annotation.NonNull;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;

public interface CipherStorage {
    DecryptionResult decrypt(@NonNull String str, @NonNull byte[] bArr, @NonNull byte[] bArr2) throws CryptoFailedException;

    EncryptionResult encrypt(@NonNull String str, @NonNull String str2, @NonNull String str3, SecurityLevel securityLevel) throws CryptoFailedException;

    String getCipherStorageName();

    int getMinSupportedApiLevel();

    void removeKey(@NonNull String str) throws KeyStoreAccessException;

    SecurityLevel securityLevel();

    boolean supportsSecureHardware();

    public static abstract class CipherResult<T> {
        public final T password;
        public final T username;

        public CipherResult(T t, T t2) {
            this.username = t;
            this.password = t2;
        }
    }

    public static class EncryptionResult extends CipherResult<byte[]> {
        public CipherStorage cipherStorage;

        public EncryptionResult(byte[] bArr, byte[] bArr2, CipherStorage cipherStorage2) {
            super(bArr, bArr2);
            this.cipherStorage = cipherStorage2;
        }
    }

    public static class DecryptionResult extends CipherResult<String> {
        private SecurityLevel securityLevel;

        public DecryptionResult(String str, String str2, SecurityLevel securityLevel2) {
            super(str, str2);
            this.securityLevel = securityLevel2;
        }

        public SecurityLevel getSecurityLevel() {
            return this.securityLevel;
        }
    }
}
