package com.oblador.keychain;

import android.app.KeyguardManager;
import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import io.sentry.marshaller.json.JsonMarshaller;

public class DeviceAvailability {
    public static boolean isFingerprintAuthAvailable(Context context) {
        FingerprintManager fingerprintManager;
        if (Build.VERSION.SDK_INT < 23 || (fingerprintManager = (FingerprintManager) context.getSystemService(JsonMarshaller.FINGERPRINT)) == null || !fingerprintManager.isHardwareDetected() || !fingerprintManager.hasEnrolledFingerprints()) {
            return false;
        }
        return true;
    }

    public static boolean isDeviceSecure(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
        return Build.VERSION.SDK_INT >= 23 && keyguardManager != null && keyguardManager.isDeviceSecure();
    }
}
