package com.facebook.react.devsupport;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeDeltaClient;

public interface ReactInstanceManagerDevHelper {
    @Nullable
    Activity getCurrentActivity();

    JavaScriptExecutorFactory getJavaScriptExecutorFactory();

    void onJSBundleLoadedFromServer(@Nullable NativeDeltaClient nativeDeltaClient);

    void onReloadWithJSDebugger(JavaJSExecutor.Factory factory);

    void toggleElementInspector();
}
