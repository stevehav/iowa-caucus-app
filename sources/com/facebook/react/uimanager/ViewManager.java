package com.facebook.react.uimanager;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.annotations.ReactPropertyHolder;
import com.facebook.yoga.YogaMeasureMode;
import java.util.Map;

@ReactPropertyHolder
public abstract class ViewManager<T extends View, C extends ReactShadowNode> extends BaseJavaModule {
    /* access modifiers changed from: protected */
    public void addEventEmitters(@NonNull ThemedReactContext themedReactContext, @NonNull T t) {
    }

    /* access modifiers changed from: protected */
    @NonNull
    public abstract T createViewInstance(@NonNull ThemedReactContext themedReactContext);

    @Nullable
    public Map<String, Integer> getCommandsMap() {
        return null;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public ViewManagerDelegate<T> getDelegate() {
        return null;
    }

    @Nullable
    public Map<String, Object> getExportedCustomBubblingEventTypeConstants() {
        return null;
    }

    @Nullable
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return null;
    }

    @Nullable
    public Map<String, Object> getExportedViewConstants() {
        return null;
    }

    @NonNull
    public abstract String getName();

    public abstract Class<? extends C> getShadowNodeClass();

    public long measure(Context context, ReadableMap readableMap, ReadableMap readableMap2, ReadableMap readableMap3, float f, YogaMeasureMode yogaMeasureMode, float f2, YogaMeasureMode yogaMeasureMode2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(@NonNull T t) {
    }

    public void onDropViewInstance(@NonNull T t) {
    }

    @Deprecated
    public void receiveCommand(@NonNull T t, int i, @Nullable ReadableArray readableArray) {
    }

    public void receiveCommand(@NonNull T t, String str, @Nullable ReadableArray readableArray) {
    }

    public abstract void updateExtraData(@NonNull T t, Object obj);

    @Nullable
    public Object updateLocalData(@NonNull T t, ReactStylesDiffMap reactStylesDiffMap, ReactStylesDiffMap reactStylesDiffMap2) {
        return null;
    }

    @Nullable
    public Object updateState(@NonNull T t, ReactStylesDiffMap reactStylesDiffMap, StateWrapper stateWrapper) {
        return null;
    }

    public void updateProperties(@NonNull T t, ReactStylesDiffMap reactStylesDiffMap) {
        ViewManagerDelegate delegate;
        if (!ReactFeatureFlags.useViewManagerDelegates || (delegate = getDelegate()) == null) {
            ViewManagerPropertyUpdater.updateProps(this, t, reactStylesDiffMap);
        } else {
            ViewManagerPropertyUpdater.updateProps(delegate, t, reactStylesDiffMap);
        }
        onAfterUpdateTransaction(t);
    }

    @NonNull
    private final T createView(@NonNull ThemedReactContext themedReactContext, JSResponderHandler jSResponderHandler) {
        return createView(themedReactContext, (ReactStylesDiffMap) null, (StateWrapper) null, jSResponderHandler);
    }

    @NonNull
    public T createView(@NonNull ThemedReactContext themedReactContext, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper, JSResponderHandler jSResponderHandler) {
        T createViewInstance = createViewInstance(themedReactContext, reactStylesDiffMap, stateWrapper);
        addEventEmitters(themedReactContext, createViewInstance);
        if (createViewInstance instanceof ReactInterceptingViewGroup) {
            ((ReactInterceptingViewGroup) createViewInstance).setOnInterceptTouchEventListener(jSResponderHandler);
        }
        return createViewInstance;
    }

    public C createShadowNodeInstance() {
        throw new RuntimeException("ViewManager subclasses must implement createShadowNodeInstance()");
    }

    @NonNull
    public C createShadowNodeInstance(@NonNull ReactApplicationContext reactApplicationContext) {
        return createShadowNodeInstance();
    }

    /* access modifiers changed from: protected */
    @NonNull
    public T createViewInstance(@NonNull ThemedReactContext themedReactContext, @Nullable ReactStylesDiffMap reactStylesDiffMap, @Nullable StateWrapper stateWrapper) {
        Object updateState;
        T createViewInstance = createViewInstance(themedReactContext);
        if (reactStylesDiffMap != null) {
            updateProperties(createViewInstance, reactStylesDiffMap);
        }
        if (!(stateWrapper == null || (updateState = updateState(createViewInstance, reactStylesDiffMap, stateWrapper)) == null)) {
            updateExtraData(createViewInstance, updateState);
        }
        return createViewInstance;
    }

    public Map<String, String> getNativeProps() {
        return ViewManagerPropertyUpdater.getNativeProps(getClass(), getShadowNodeClass());
    }
}
