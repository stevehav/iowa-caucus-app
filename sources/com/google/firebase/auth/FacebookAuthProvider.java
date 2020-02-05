package com.google.firebase.auth;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public class FacebookAuthProvider {
    public static final String FACEBOOK_SIGN_IN_METHOD = "facebook.com";
    public static final String PROVIDER_ID = "facebook.com";

    private FacebookAuthProvider() {
    }

    public static AuthCredential getCredential(@NonNull String str) {
        return new FacebookAuthCredential(str);
    }
}
