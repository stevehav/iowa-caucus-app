package com.google.firebase.auth;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseException;
import com.google.firebase.annotations.PublicApi;

@PublicApi
public class FirebaseAuthException extends FirebaseException {
    private final String zzc;

    @PublicApi
    public FirebaseAuthException(@NonNull String str, @NonNull String str2) {
        super(str2);
        this.zzc = Preconditions.checkNotEmpty(str);
    }

    @PublicApi
    @NonNull
    public String getErrorCode() {
        return this.zzc;
    }
}
