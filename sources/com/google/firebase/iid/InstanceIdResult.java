package com.google.firebase.iid;

import androidx.annotation.NonNull;

public interface InstanceIdResult {
    @NonNull
    String getId();

    @NonNull
    String getToken();
}
