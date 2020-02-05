package com.facebook.react;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.List;

public interface ViewManagerOnDemandReactPackage {
    @Nullable
    ViewManager createViewManager(ReactApplicationContext reactApplicationContext, String str);

    @Nullable
    List<String> getViewManagerNames(ReactApplicationContext reactApplicationContext);
}
