package com.facebook.android.crypto.keychain;

import java.security.SecureRandom;

public class FixedSecureRandom extends SecureRandom {
    public synchronized void nextBytes(byte[] bArr) {
        SecureRandomFix.tryApplyFixes();
        super.nextBytes(bArr);
    }
}
