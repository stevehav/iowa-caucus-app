package com.swmansion.reanimated.transitions;

import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionManager;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerModule;

public class TransitionModule {
    private final UIManagerModule mUIManager;

    public TransitionModule(UIManagerModule uIManagerModule) {
        this.mUIManager = uIManagerModule;
    }

    public void animateNextTransition(final int i, final ReadableMap readableMap) {
        this.mUIManager.prependUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                try {
                    View resolveView = nativeViewHierarchyManager.resolveView(i);
                    if (resolveView instanceof ViewGroup) {
                        ReadableArray array = readableMap.getArray("transitions");
                        int size = array.size();
                        for (int i = 0; i < size; i++) {
                            TransitionManager.beginDelayedTransition((ViewGroup) resolveView, TransitionUtils.inflate(array.getMap(i)));
                        }
                    }
                } catch (IllegalViewOperationException unused) {
                }
            }
        });
    }
}
