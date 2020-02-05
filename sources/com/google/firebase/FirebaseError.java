package com.google.firebase;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
/* compiled from: com.google.firebase:firebase-common@@17.1.0 */
public class FirebaseError {
    @KeepForSdk
    public static final int ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL = 17012;
    @KeepForSdk
    public static final int ERROR_APP_NOT_AUTHORIZED = 17028;
    @KeepForSdk
    public static final int ERROR_CREDENTIAL_ALREADY_IN_USE = 17025;
    @KeepForSdk
    public static final int ERROR_CUSTOM_TOKEN_MISMATCH = 17002;
    @KeepForSdk
    public static final int ERROR_EMAIL_ALREADY_IN_USE = 17007;
    @KeepForSdk
    public static final int ERROR_INTERNAL_ERROR = 17499;
    @KeepForSdk
    public static final int ERROR_INVALID_API_KEY = 17023;
    @KeepForSdk
    public static final int ERROR_INVALID_CREDENTIAL = 17004;
    @KeepForSdk
    public static final int ERROR_INVALID_CUSTOM_TOKEN = 17000;
    @KeepForSdk
    public static final int ERROR_INVALID_EMAIL = 17008;
    @KeepForSdk
    public static final int ERROR_INVALID_USER_TOKEN = 17017;
    @KeepForSdk
    public static final int ERROR_NETWORK_REQUEST_FAILED = 17020;
    @KeepForSdk
    public static final int ERROR_NO_SIGNED_IN_USER = 17495;
    @KeepForSdk
    public static final int ERROR_NO_SUCH_PROVIDER = 17016;
    @KeepForSdk
    public static final int ERROR_OPERATION_NOT_ALLOWED = 17006;
    @KeepForSdk
    public static final int ERROR_PROVIDER_ALREADY_LINKED = 17015;
    @KeepForSdk
    public static final int ERROR_REQUIRES_RECENT_LOGIN = 17014;
    @KeepForSdk
    public static final int ERROR_TOO_MANY_REQUESTS = 17010;
    @KeepForSdk
    public static final int ERROR_USER_DISABLED = 17005;
    @KeepForSdk
    public static final int ERROR_USER_MISMATCH = 17024;
    @KeepForSdk
    public static final int ERROR_USER_NOT_FOUND = 17011;
    @KeepForSdk
    public static final int ERROR_USER_TOKEN_EXPIRED = 17021;
    @KeepForSdk
    public static final int ERROR_WEAK_PASSWORD = 17026;
    @KeepForSdk
    public static final int ERROR_WRONG_PASSWORD = 17009;
    private int errorCode;

    public FirebaseError(int i) {
        this.errorCode = i;
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}
