package com.oblador.keychain.cipherStorage;

import android.annotation.TargetApi;
import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyInfo;
import android.security.keystore.StrongBoxUnavailableException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.oblador.keychain.SecurityLevel;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;

@TargetApi(23)
public class CipherStorageKeystoreAESCBC implements CipherStorage {
    public static final String CIPHER_STORAGE_NAME = "KeystoreAESCBC";
    public static final String DEFAULT_SERVICE = "RN_KEYCHAIN_DEFAULT_ALIAS";
    public static final String ENCRYPTION_ALGORITHM = "AES";
    public static final String ENCRYPTION_BLOCK_MODE = "CBC";
    public static final int ENCRYPTION_KEY_SIZE = 256;
    public static final String ENCRYPTION_PADDING = "PKCS7Padding";
    public static final String ENCRYPTION_TRANSFORMATION = "AES/CBC/PKCS7Padding";
    public static final String KEYSTORE_TYPE = "AndroidKeyStore";
    public static final String TAG = "KeystoreAESCBC";
    private boolean retry = true;

    public String getCipherStorageName() {
        return "KeystoreAESCBC";
    }

    public int getMinSupportedApiLevel() {
        return 23;
    }

    public SecurityLevel securityLevel() {
        return SecurityLevel.SECURE_HARDWARE;
    }

    public boolean supportsSecureHardware() {
        try {
            boolean validateKeySecurityLevel = validateKeySecurityLevel(SecurityLevel.SECURE_HARDWARE, tryGenerateRegularSecurityKey("AndroidKeyStore#supportsSecureHardware"));
            try {
                removeKey("AndroidKeyStore#supportsSecureHardware");
            } catch (KeyStoreAccessException e) {
                Log.e("KeystoreAESCBC", "Unable to remove temp key from keychain", e);
            }
            return validateKeySecurityLevel;
        } catch (InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException unused) {
            try {
                removeKey("AndroidKeyStore#supportsSecureHardware");
            } catch (KeyStoreAccessException e2) {
                Log.e("KeystoreAESCBC", "Unable to remove temp key from keychain", e2);
            }
            return false;
        } catch (Throwable th) {
            try {
                removeKey("AndroidKeyStore#supportsSecureHardware");
            } catch (KeyStoreAccessException e3) {
                Log.e("KeystoreAESCBC", "Unable to remove temp key from keychain", e3);
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0056, code lost:
        throw new com.oblador.keychain.exceptions.CryptoFailedException("Unknown error: " + r4.getMessage(), r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0057, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0070, code lost:
        throw new com.oblador.keychain.exceptions.CryptoFailedException("Could not access Keystore for service " + r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0073, code lost:
        r5 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b A[ExcHandler: Exception (r4v4 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0057 A[ExcHandler: KeyStoreAccessException | KeyStoreException (r5v4 'e' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:1:0x0004] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A[ExcHandler: InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchProviderException (e java.lang.Throwable), Splitter:B:1:0x0004] */
    @android.annotation.TargetApi(23)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.oblador.keychain.cipherStorage.CipherStorage.EncryptionResult encrypt(@androidx.annotation.NonNull java.lang.String r4, @androidx.annotation.NonNull java.lang.String r5, @androidx.annotation.NonNull java.lang.String r6, com.oblador.keychain.SecurityLevel r7) throws com.oblador.keychain.exceptions.CryptoFailedException {
        /*
            r3 = this;
            java.lang.String r4 = r3.getDefaultServiceIfEmpty(r4)
            java.security.KeyStore r0 = r3.getKeyStoreAndLoad()     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            boolean r1 = r0.containsAlias(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            if (r1 != 0) goto L_0x0011
            r3.generateKeyAndStoreUnderAlias(r4, r7)     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
        L_0x0011:
            r1 = 0
            java.security.Key r7 = r0.getKey(r4, r1)     // Catch:{ UnrecoverableKeyException -> 0x0027, NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            byte[] r5 = r3.encryptString(r7, r4, r5)     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            byte[] r6 = r3.encryptString(r7, r4, r6)     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            r7 = 1
            r3.retry = r7     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            com.oblador.keychain.cipherStorage.CipherStorage$EncryptionResult r7 = new com.oblador.keychain.cipherStorage.CipherStorage$EncryptionResult     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            r7.<init>(r5, r6, r3)     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            return r7
        L_0x0027:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            boolean r2 = r3.retry     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            if (r2 == 0) goto L_0x003a
            r1 = 0
            r3.retry = r1     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            r0.deleteEntry(r4)     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            com.oblador.keychain.cipherStorage.CipherStorage$EncryptionResult r4 = r3.encrypt(r4, r5, r6, r7)     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
            return r4
        L_0x003a:
            throw r1     // Catch:{ NoSuchAlgorithmException -> 0x0077, InvalidAlgorithmParameterException -> 0x0075, NoSuchProviderException -> 0x0073, UnrecoverableKeyException -> 0x0071, KeyStoreException -> 0x0059, KeyStoreAccessException -> 0x0057, Exception -> 0x003b }
        L_0x003b:
            r4 = move-exception
            com.oblador.keychain.exceptions.CryptoFailedException r5 = new com.oblador.keychain.exceptions.CryptoFailedException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "Unknown error: "
            r6.append(r7)
            java.lang.String r7 = r4.getMessage()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6, r4)
            throw r5
        L_0x0057:
            r5 = move-exception
            goto L_0x005a
        L_0x0059:
            r5 = move-exception
        L_0x005a:
            com.oblador.keychain.exceptions.CryptoFailedException r6 = new com.oblador.keychain.exceptions.CryptoFailedException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Could not access Keystore for service "
            r7.append(r0)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r6.<init>(r4, r5)
            throw r6
        L_0x0071:
            r5 = move-exception
            goto L_0x0078
        L_0x0073:
            r5 = move-exception
            goto L_0x0078
        L_0x0075:
            r5 = move-exception
            goto L_0x0078
        L_0x0077:
            r5 = move-exception
        L_0x0078:
            com.oblador.keychain.exceptions.CryptoFailedException r6 = new com.oblador.keychain.exceptions.CryptoFailedException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Could not encrypt data for service "
            r7.append(r0)
            r7.append(r4)
            java.lang.String r4 = r7.toString()
            r6.<init>(r4, r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oblador.keychain.cipherStorage.CipherStorageKeystoreAESCBC.encrypt(java.lang.String, java.lang.String, java.lang.String, com.oblador.keychain.SecurityLevel):com.oblador.keychain.cipherStorage.CipherStorage$EncryptionResult");
    }

    @TargetApi(23)
    private boolean validateKeySecurityLevel(SecurityLevel securityLevel, SecretKey secretKey) {
        return getSecurityLevel(secretKey).satisfiesSafetyThreshold(securityLevel);
    }

    @TargetApi(23)
    private SecurityLevel getSecurityLevel(SecretKey secretKey) {
        try {
            return ((KeyInfo) SecretKeyFactory.getInstance(secretKey.getAlgorithm(), KEYSTORE_TYPE).getKeySpec(secretKey, KeyInfo.class)).isInsideSecureHardware() ? SecurityLevel.SECURE_HARDWARE : SecurityLevel.SECURE_SOFTWARE;
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeySpecException unused) {
            return SecurityLevel.ANY;
        }
    }

    private void generateKeyAndStoreUnderAlias(@NonNull String str, SecurityLevel securityLevel) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CryptoFailedException {
        SecretKey tryGenerateStrongBoxSecurityKey = tryGenerateStrongBoxSecurityKey(str);
        if (tryGenerateStrongBoxSecurityKey == null) {
            tryGenerateStrongBoxSecurityKey = tryGenerateRegularSecurityKey(str);
        }
        if (!validateKeySecurityLevel(securityLevel, tryGenerateStrongBoxSecurityKey)) {
            try {
                removeKey(str);
            } catch (KeyStoreAccessException e) {
                Log.e("KeystoreAESCBC", "Unable to remove key from keychain", e);
            }
            throw new CryptoFailedException("Cannot generate keys with required security guarantees");
        }
    }

    public CipherStorage.DecryptionResult decrypt(@NonNull String str, @NonNull byte[] bArr, @NonNull byte[] bArr2) throws CryptoFailedException {
        try {
            Key key = getKeyStoreAndLoad().getKey(getDefaultServiceIfEmpty(str), (char[]) null);
            if (key != null) {
                return new CipherStorage.DecryptionResult(decryptBytes(key, bArr), decryptBytes(key, bArr2), getSecurityLevel((SecretKey) key));
            }
            throw new CryptoFailedException("The provided service/key could not be found in the Keystore");
        } catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
            throw new CryptoFailedException("Could not get key from Keystore", e);
        } catch (KeyStoreAccessException e2) {
            throw new CryptoFailedException("Could not access Keystore", e2);
        } catch (Exception e3) {
            throw new CryptoFailedException("Unknown error: " + e3.getMessage(), e3);
        }
    }

    public void removeKey(@NonNull String str) throws KeyStoreAccessException {
        String defaultServiceIfEmpty = getDefaultServiceIfEmpty(str);
        try {
            KeyStore keyStoreAndLoad = getKeyStoreAndLoad();
            if (keyStoreAndLoad.containsAlias(defaultServiceIfEmpty)) {
                keyStoreAndLoad.deleteEntry(defaultServiceIfEmpty);
            }
        } catch (KeyStoreException e) {
            throw new KeyStoreAccessException("Failed to access Keystore", e);
        } catch (Exception e2) {
            throw new KeyStoreAccessException("Unknown error " + e2.getMessage(), e2);
        }
    }

    private byte[] encryptString(Key key, String str, String str2) throws CryptoFailedException {
        try {
            Cipher instance = Cipher.getInstance(ENCRYPTION_TRANSFORMATION);
            instance.init(1, key);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] iv = instance.getIV();
            byteArrayOutputStream.write(iv, 0, iv.length);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, instance);
            cipherOutputStream.write(str2.getBytes("UTF-8"));
            cipherOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new CryptoFailedException("Could not encrypt value for service " + str + ", message: " + e.getMessage(), e);
        }
    }

    private String decryptBytes(Key key, byte[] bArr) throws CryptoFailedException {
        try {
            Cipher instance = Cipher.getInstance(ENCRYPTION_TRANSFORMATION);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            instance.init(2, key, readIvFromStream(byteArrayInputStream));
            CipherInputStream cipherInputStream = new CipherInputStream(byteArrayInputStream, instance);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = cipherInputStream.read(bArr2, 0, bArr2.length);
                if (read <= 0) {
                    return new String(byteArrayOutputStream.toByteArray(), Charset.forName("UTF-8"));
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (Exception e) {
            throw new CryptoFailedException("Could not decrypt bytes: " + e.getMessage(), e);
        }
    }

    private IvParameterSpec readIvFromStream(ByteArrayInputStream byteArrayInputStream) {
        byte[] bArr = new byte[16];
        byteArrayInputStream.read(bArr, 0, bArr.length);
        return new IvParameterSpec(bArr);
    }

    private KeyStore getKeyStoreAndLoad() throws KeyStoreException, KeyStoreAccessException {
        try {
            KeyStore instance = KeyStore.getInstance(KEYSTORE_TYPE);
            instance.load((KeyStore.LoadStoreParameter) null);
            return instance;
        } catch (IOException | NoSuchAlgorithmException | CertificateException e) {
            throw new KeyStoreAccessException("Could not access Keystore", e);
        }
    }

    @NonNull
    private String getDefaultServiceIfEmpty(@NonNull String str) {
        return str.isEmpty() ? DEFAULT_SERVICE : str;
    }

    @TargetApi(28)
    private SecretKey tryGenerateStrongBoxSecurityKey(String str) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException {
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        try {
            return generateKey(getKeyGenSpecBuilder(str).setIsStrongBoxBacked(true).build());
        } catch (Exception e) {
            if (e instanceof StrongBoxUnavailableException) {
                Log.i("KeystoreAESCBC", "StrongBox is unavailable on this device");
            } else {
                Log.e("KeystoreAESCBC", "An error occurred when trying to generate a StrongBoxSecurityKey: " + e.getMessage());
            }
            return null;
        }
    }

    @TargetApi(23)
    private SecretKey tryGenerateRegularSecurityKey(String str) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchProviderException {
        return generateKey(getKeyGenSpecBuilder(str).build());
    }

    @TargetApi(23)
    private SecretKey generateKey(KeyGenParameterSpec keyGenParameterSpec) throws NoSuchProviderException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        KeyGenerator instance = KeyGenerator.getInstance(ENCRYPTION_ALGORITHM, KEYSTORE_TYPE);
        instance.init(keyGenParameterSpec);
        return instance.generateKey();
    }

    @TargetApi(23)
    private KeyGenParameterSpec.Builder getKeyGenSpecBuilder(String str) {
        return new KeyGenParameterSpec.Builder(str, 3).setBlockModes(new String[]{ENCRYPTION_BLOCK_MODE}).setEncryptionPaddings(new String[]{ENCRYPTION_PADDING}).setRandomizedEncryptionRequired(true).setKeySize(256);
    }
}
