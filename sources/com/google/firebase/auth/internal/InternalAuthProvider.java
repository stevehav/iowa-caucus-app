package com.google.firebase.auth.internal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.internal.InternalTokenProvider;

@KeepForSdk
public interface InternalAuthProvider extends InternalTokenProvider {
    @KeepForSdk
    void addIdTokenListener(@NonNull IdTokenListener idTokenListener);

    @KeepForSdk
    Task<GetTokenResult> getAccessToken(boolean z);

    @Nullable
    String getUid();

    @KeepForSdk
    void removeIdTokenListener(@NonNull IdTokenListener idTokenListener);
}
