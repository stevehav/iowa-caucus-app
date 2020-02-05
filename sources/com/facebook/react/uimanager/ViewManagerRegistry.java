package com.facebook.react.uimanager;

import androidx.annotation.Nullable;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.UIManagerModule;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ViewManagerRegistry {
    @Nullable
    private final UIManagerModule.ViewManagerResolver mViewManagerResolver;
    private final Map<String, ViewManager> mViewManagers;

    public ViewManagerRegistry(UIManagerModule.ViewManagerResolver viewManagerResolver) {
        this.mViewManagers = MapBuilder.newHashMap();
        this.mViewManagerResolver = viewManagerResolver;
    }

    public ViewManagerRegistry(List<ViewManager> list) {
        HashMap newHashMap = MapBuilder.newHashMap();
        for (ViewManager next : list) {
            newHashMap.put(next.getName(), next);
        }
        this.mViewManagers = newHashMap;
        this.mViewManagerResolver = null;
    }

    public ViewManagerRegistry(Map<String, ViewManager> map) {
        this.mViewManagers = map == null ? MapBuilder.newHashMap() : map;
        this.mViewManagerResolver = null;
    }

    public ViewManager get(String str) {
        ViewManager viewManager;
        ViewManager viewManager2 = this.mViewManagers.get(str);
        if (viewManager2 != null) {
            return viewManager2;
        }
        UIManagerModule.ViewManagerResolver viewManagerResolver = this.mViewManagerResolver;
        if (viewManagerResolver == null || (viewManager = viewManagerResolver.getViewManager(str)) == null) {
            throw new IllegalViewOperationException("No ViewManager defined for class " + str);
        }
        this.mViewManagers.put(str, viewManager);
        return viewManager;
    }
}
