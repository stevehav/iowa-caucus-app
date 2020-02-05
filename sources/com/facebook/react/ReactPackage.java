package com.facebook.react;

import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.List;

public interface ReactPackage {
    @NonNull
    List<NativeModule> createNativeModules(@NonNull ReactApplicationContext reactApplicationContext);

    @NonNull
    List<ViewManager> createViewManagers(@NonNull ReactApplicationContext reactApplicationContext);
}
