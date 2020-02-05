package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;

public final class zabw {
    public final RegisterListenerMethod<Api.AnyClient, ?> zajx;
    public final UnregisterListenerMethod<Api.AnyClient, ?> zajy;

    public zabw(@NonNull RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, @NonNull UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod) {
        this.zajx = registerListenerMethod;
        this.zajy = unregisterListenerMethod;
    }
}
