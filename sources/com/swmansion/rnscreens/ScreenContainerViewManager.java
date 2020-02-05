package com.swmansion.rnscreens;

import android.view.View;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

@ReactModule(name = "RNSScreenContainer")
public class ScreenContainerViewManager extends ViewGroupManager<ScreenContainer> {
    protected static final String REACT_CLASS = "RNSScreenContainer";

    public String getName() {
        return REACT_CLASS;
    }

    /* access modifiers changed from: protected */
    public ScreenContainer createViewInstance(ThemedReactContext themedReactContext) {
        return new ScreenContainer(themedReactContext);
    }

    public void addView(ScreenContainer screenContainer, View view, int i) {
        if (view instanceof Screen) {
            screenContainer.addScreen((Screen) view, i);
            return;
        }
        throw new IllegalArgumentException("Attempt attach child that is not of type RNScreens");
    }

    public void removeViewAt(ScreenContainer screenContainer, int i) {
        screenContainer.removeScreenAt(i);
    }

    public int getChildCount(ScreenContainer screenContainer) {
        return screenContainer.getScreenCount();
    }

    public View getChildAt(ScreenContainer screenContainer, int i) {
        return screenContainer.getScreenAt(i);
    }
}
