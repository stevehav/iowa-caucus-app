package com.facebook.react.devsupport.interfaces;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.NativeDeltaClient;

public interface DevBundleDownloadListener {
    void onFailure(Exception exc);

    void onProgress(@Nullable String str, @Nullable Integer num, @Nullable Integer num2);

    void onSuccess(@Nullable NativeDeltaClient nativeDeltaClient);
}
