package com.google.firebase.auth;

import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public interface ActionCodeResult {
    public static final int EMAIL = 0;
    public static final int ERROR = 3;
    public static final int FROM_EMAIL = 1;
    public static final int PASSWORD_RESET = 0;
    public static final int RECOVER_EMAIL = 2;
    public static final int SIGN_IN_WITH_EMAIL_LINK = 4;
    public static final int VERIFY_EMAIL = 1;

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public @interface ActionDataKey {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public @interface Operation {
    }

    @Nullable
    String getData(int i);

    int getOperation();
}
