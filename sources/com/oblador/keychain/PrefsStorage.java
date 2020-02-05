package com.oblador.keychain;

import android.content.SharedPreferences;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.ReactApplicationContext;
import com.oblador.keychain.cipherStorage.CipherStorage;
import com.oblador.keychain.cipherStorage.CipherStorageFacebookConceal;

public class PrefsStorage {
    public static final String KEYCHAIN_DATA = "RN_KEYCHAIN";
    private final SharedPreferences prefs;

    public static class ResultSet {
        public final String cipherStorageName;
        public final byte[] passwordBytes;
        public final byte[] usernameBytes;

        public ResultSet(String str, byte[] bArr, byte[] bArr2) {
            this.cipherStorageName = str;
            this.usernameBytes = bArr;
            this.passwordBytes = bArr2;
        }
    }

    public PrefsStorage(ReactApplicationContext reactApplicationContext) {
        this.prefs = reactApplicationContext.getSharedPreferences("RN_KEYCHAIN", 0);
    }

    public ResultSet getEncryptedEntry(@NonNull String str) {
        byte[] bytesForUsername = getBytesForUsername(str);
        byte[] bytesForPassword = getBytesForPassword(str);
        String cipherStorageName = getCipherStorageName(str);
        if (bytesForUsername == null || bytesForPassword == null) {
            return null;
        }
        if (cipherStorageName == null) {
            cipherStorageName = CipherStorageFacebookConceal.CIPHER_STORAGE_NAME;
        }
        return new ResultSet(cipherStorageName, bytesForUsername, bytesForPassword);
    }

    public void removeEntry(@NonNull String str) {
        String keyForUsername = getKeyForUsername(str);
        String keyForPassword = getKeyForPassword(str);
        this.prefs.edit().remove(keyForUsername).remove(keyForPassword).remove(getKeyForCipherStorage(str)).apply();
    }

    public void storeEncryptedEntry(@NonNull String str, @NonNull CipherStorage.EncryptionResult encryptionResult) {
        String keyForUsername = getKeyForUsername(str);
        String keyForPassword = getKeyForPassword(str);
        this.prefs.edit().putString(keyForUsername, Base64.encodeToString((byte[]) encryptionResult.username, 0)).putString(keyForPassword, Base64.encodeToString((byte[]) encryptionResult.password, 0)).putString(getKeyForCipherStorage(str), encryptionResult.cipherStorage.getCipherStorageName()).apply();
    }

    private byte[] getBytesForUsername(String str) {
        return getBytes(getKeyForUsername(str));
    }

    private byte[] getBytesForPassword(String str) {
        return getBytes(getKeyForPassword(str));
    }

    private String getCipherStorageName(String str) {
        return this.prefs.getString(getKeyForCipherStorage(str), (String) null);
    }

    private String getKeyForUsername(String str) {
        return str + ":u";
    }

    private String getKeyForPassword(String str) {
        return str + ":p";
    }

    private String getKeyForCipherStorage(String str) {
        return str + ":c";
    }

    private byte[] getBytes(String str) {
        String string = this.prefs.getString(str, (String) null);
        if (string != null) {
            return Base64.decode(string, 0);
        }
        return null;
    }
}
