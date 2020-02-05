package com.oblador.keychain;

public enum SecurityLevel {
    ANY,
    SECURE_SOFTWARE,
    SECURE_HARDWARE;

    public String jsName() {
        return String.format("SECURITY_LEVEL_%s", new Object[]{name()});
    }

    public boolean satisfiesSafetyThreshold(SecurityLevel securityLevel) {
        return compareTo(securityLevel) >= 0;
    }
}
