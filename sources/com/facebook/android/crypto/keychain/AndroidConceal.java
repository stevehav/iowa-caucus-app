package com.facebook.android.crypto.keychain;

import com.facebook.crypto.Conceal;
import com.facebook.crypto.util.SystemNativeCryptoLibrary;

public class AndroidConceal extends Conceal {
    private static AndroidConceal sInstance;

    public static synchronized AndroidConceal get() {
        AndroidConceal androidConceal;
        synchronized (AndroidConceal.class) {
            if (sInstance == null) {
                sInstance = new AndroidConceal();
            }
            androidConceal = sInstance;
        }
        return androidConceal;
    }

    private AndroidConceal() {
        super(new SystemNativeCryptoLibrary(), new FixedSecureRandom());
    }
}
