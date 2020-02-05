package com.oblador.keychain;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.oblador.keychain.PrefsStorage;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.cipherStorage.CipherStorageFacebookConceal;
import com.oblador.keychain.cipherStorage.CipherStorageKeystoreAESCBC;
import com.oblador.keychain.exceptions.CryptoFailedException;
import com.oblador.keychain.exceptions.EmptyParameterException;
import com.oblador.keychain.exceptions.KeyStoreAccessException;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class KeychainModule extends ReactContextBaseJavaModule {
    public static final String EMPTY_STRING = "";
    public static final String E_CRYPTO_FAILED = "E_CRYPTO_FAILED";
    public static final String E_EMPTY_PARAMETERS = "E_EMPTY_PARAMETERS";
    public static final String E_KEYSTORE_ACCESS_ERROR = "E_KEYSTORE_ACCESS_ERROR";
    public static final String E_SUPPORTED_BIOMETRY_ERROR = "E_SUPPORTED_BIOMETRY_ERROR";
    public static final String FINGERPRINT_SUPPORTED_NAME = "Fingerprint";
    public static final String KEYCHAIN_MODULE = "RNKeychainManager";
    private final Map<String, CipherStorage> cipherStorageMap = new HashMap();
    private final PrefsStorage prefsStorage;

    @NonNull
    private String getDefaultServiceIfNull(String str) {
        return str == null ? "" : str;
    }

    public String getName() {
        return KEYCHAIN_MODULE;
    }

    public KeychainModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.prefsStorage = new PrefsStorage(reactApplicationContext);
        addCipherStorageToMap(new CipherStorageFacebookConceal(reactApplicationContext));
        addCipherStorageToMap(new CipherStorageKeystoreAESCBC());
    }

    private void addCipherStorageToMap(CipherStorage cipherStorage) {
        this.cipherStorageMap.put(cipherStorage.getCipherStorageName(), cipherStorage);
    }

    @Nullable
    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put(SecurityLevel.ANY.jsName(), SecurityLevel.ANY.name());
        hashMap.put(SecurityLevel.SECURE_SOFTWARE.jsName(), SecurityLevel.SECURE_SOFTWARE.name());
        hashMap.put(SecurityLevel.SECURE_HARDWARE.jsName(), SecurityLevel.SECURE_HARDWARE.name());
        return hashMap;
    }

    @ReactMethod
    public void getSecurityLevel(Promise promise) {
        promise.resolve(getSecurityLevel().name());
    }

    @ReactMethod
    public void setGenericPasswordForOptions(String str, String str2, String str3, String str4, Promise promise) {
        try {
            SecurityLevel valueOf = SecurityLevel.valueOf(str4);
            if (str2 == null || str2.isEmpty() || str3 == null || str3.isEmpty()) {
                throw new EmptyParameterException("you passed empty or null username/password");
            }
            String defaultServiceIfNull = getDefaultServiceIfNull(str);
            CipherStorage cipherStorageForCurrentAPILevel = getCipherStorageForCurrentAPILevel();
            validateCipherStorageSecurityLevel(cipherStorageForCurrentAPILevel, valueOf);
            this.prefsStorage.storeEncryptedEntry(defaultServiceIfNull, cipherStorageForCurrentAPILevel.encrypt(defaultServiceIfNull, str2, str3, valueOf));
            promise.resolve(true);
        } catch (EmptyParameterException e) {
            Log.e(KEYCHAIN_MODULE, e.getMessage());
            promise.reject(E_EMPTY_PARAMETERS, (Throwable) e);
        } catch (CryptoFailedException e2) {
            Log.e(KEYCHAIN_MODULE, e2.getMessage());
            promise.reject(E_CRYPTO_FAILED, (Throwable) e2);
        }
    }

    @ReactMethod
    public void getGenericPasswordForOptions(String str, Promise promise) {
        try {
            String defaultServiceIfNull = getDefaultServiceIfNull(str);
            CipherStorage cipherStorageForCurrentAPILevel = getCipherStorageForCurrentAPILevel();
            PrefsStorage.ResultSet encryptedEntry = this.prefsStorage.getEncryptedEntry(defaultServiceIfNull);
            if (encryptedEntry == null) {
                Log.e(KEYCHAIN_MODULE, "No entry found for service: " + defaultServiceIfNull);
                promise.resolve(false);
                return;
            }
            CipherStorage.DecryptionResult decryptCredentials = decryptCredentials(defaultServiceIfNull, cipherStorageForCurrentAPILevel, encryptedEntry);
            WritableMap createMap = Arguments.createMap();
            createMap.putString(NotificationCompat.CATEGORY_SERVICE, defaultServiceIfNull);
            createMap.putString("username", (String) decryptCredentials.username);
            createMap.putString("password", (String) decryptCredentials.password);
            promise.resolve(createMap);
        } catch (KeyStoreAccessException e) {
            Log.e(KEYCHAIN_MODULE, e.getMessage());
            promise.reject(E_KEYSTORE_ACCESS_ERROR, (Throwable) e);
        } catch (CryptoFailedException e2) {
            Log.e(KEYCHAIN_MODULE, e2.getMessage());
            promise.reject(E_CRYPTO_FAILED, (Throwable) e2);
        }
    }

    private CipherStorage.DecryptionResult decryptCredentials(String str, CipherStorage cipherStorage, PrefsStorage.ResultSet resultSet) throws CryptoFailedException, KeyStoreAccessException {
        if (resultSet.cipherStorageName.equals(cipherStorage.getCipherStorageName())) {
            return cipherStorage.decrypt(str, resultSet.usernameBytes, resultSet.passwordBytes);
        }
        CipherStorage cipherStorageByName = getCipherStorageByName(resultSet.cipherStorageName);
        CipherStorage.DecryptionResult decrypt = cipherStorageByName.decrypt(str, resultSet.usernameBytes, resultSet.passwordBytes);
        try {
            migrateCipherStorage(str, cipherStorage, cipherStorageByName, decrypt);
        } catch (CryptoFailedException unused) {
            Log.e(KEYCHAIN_MODULE, "Migrating to a less safe storage is not allowed. Keeping the old one");
        }
        return decrypt;
    }

    private void migrateCipherStorage(String str, CipherStorage cipherStorage, CipherStorage cipherStorage2, CipherStorage.DecryptionResult decryptionResult) throws KeyStoreAccessException, CryptoFailedException {
        this.prefsStorage.storeEncryptedEntry(str, cipherStorage.encrypt(str, (String) decryptionResult.username, (String) decryptionResult.password, decryptionResult.getSecurityLevel()));
        cipherStorage2.removeKey(str);
    }

    @ReactMethod
    public void resetGenericPasswordForOptions(String str, Promise promise) {
        CipherStorage cipherStorageByName;
        try {
            String defaultServiceIfNull = getDefaultServiceIfNull(str);
            PrefsStorage.ResultSet encryptedEntry = this.prefsStorage.getEncryptedEntry(defaultServiceIfNull);
            if (!(encryptedEntry == null || (cipherStorageByName = getCipherStorageByName(encryptedEntry.cipherStorageName)) == null)) {
                cipherStorageByName.removeKey(defaultServiceIfNull);
            }
            this.prefsStorage.removeEntry(defaultServiceIfNull);
            promise.resolve(true);
        } catch (KeyStoreAccessException e) {
            Log.e(KEYCHAIN_MODULE, e.getMessage());
            promise.reject(E_KEYSTORE_ACCESS_ERROR, (Throwable) e);
        }
    }

    @ReactMethod
    public void hasInternetCredentialsForServer(@NonNull String str, Promise promise) {
        String defaultServiceIfNull = getDefaultServiceIfNull(str);
        if (this.prefsStorage.getEncryptedEntry(defaultServiceIfNull) == null) {
            Log.e(KEYCHAIN_MODULE, "No entry found for service: " + defaultServiceIfNull);
            promise.resolve(false);
            return;
        }
        promise.resolve(true);
    }

    @ReactMethod
    public void setInternetCredentialsForServer(@NonNull String str, String str2, String str3, String str4, ReadableMap readableMap, Promise promise) {
        setGenericPasswordForOptions(str, str2, str3, str4, promise);
    }

    @ReactMethod
    public void getInternetCredentialsForServer(@NonNull String str, ReadableMap readableMap, Promise promise) {
        getGenericPasswordForOptions(str, promise);
    }

    @ReactMethod
    public void resetInternetCredentialsForServer(@NonNull String str, ReadableMap readableMap, Promise promise) {
        resetGenericPasswordForOptions(str, promise);
    }

    @ReactMethod
    public void getSupportedBiometryType(Promise promise) {
        try {
            if (isFingerprintAuthAvailable()) {
                promise.resolve(FINGERPRINT_SUPPORTED_NAME);
            } else {
                promise.resolve((Object) null);
            }
        } catch (Exception e) {
            Log.e(KEYCHAIN_MODULE, e.getMessage());
            promise.reject(E_SUPPORTED_BIOMETRY_ERROR, (Throwable) e);
        }
    }

    private CipherStorage getCipherStorageForCurrentAPILevel() throws CryptoFailedException {
        int i = Build.VERSION.SDK_INT;
        CipherStorage cipherStorage = null;
        for (CipherStorage next : this.cipherStorageMap.values()) {
            int minSupportedApiLevel = next.getMinSupportedApiLevel();
            if ((minSupportedApiLevel <= i) && (cipherStorage == null || minSupportedApiLevel > cipherStorage.getMinSupportedApiLevel())) {
                cipherStorage = next;
            }
        }
        if (cipherStorage != null) {
            return cipherStorage;
        }
        throw new CryptoFailedException("Unsupported Android SDK " + Build.VERSION.SDK_INT);
    }

    private void validateCipherStorageSecurityLevel(CipherStorage cipherStorage, SecurityLevel securityLevel) throws CryptoFailedException {
        if (!cipherStorage.securityLevel().satisfiesSafetyThreshold(securityLevel)) {
            throw new CryptoFailedException(String.format("Cipher Storage is too weak. Required security level is: %s, but only %s is provided", new Object[]{securityLevel.name(), cipherStorage.securityLevel().name()}));
        }
    }

    private CipherStorage getCipherStorageByName(String str) {
        return this.cipherStorageMap.get(str);
    }

    private boolean isFingerprintAuthAvailable() {
        return DeviceAvailability.isFingerprintAuthAvailable(getReactApplicationContext());
    }

    private boolean isSecureHardwareAvailable() {
        try {
            return getCipherStorageForCurrentAPILevel().supportsSecureHardware();
        } catch (CryptoFailedException unused) {
            return false;
        }
    }

    private SecurityLevel getSecurityLevel() {
        try {
            if (!getCipherStorageForCurrentAPILevel().securityLevel().satisfiesSafetyThreshold(SecurityLevel.SECURE_SOFTWARE)) {
                return SecurityLevel.ANY;
            }
            if (isSecureHardwareAvailable()) {
                return SecurityLevel.SECURE_HARDWARE;
            }
            return SecurityLevel.SECURE_SOFTWARE;
        } catch (CryptoFailedException unused) {
            return SecurityLevel.ANY;
        }
    }
}
