package com.google.firebase;

import androidx.annotation.NonNull;

public class FirebaseApiNotAvailableException extends FirebaseException {
    public FirebaseApiNotAvailableException(@NonNull String str) {
        super(str);
    }
}
