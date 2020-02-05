package com.swmansion.rnscreens;

import android.view.View;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class LifecycleHelper {
    private View.OnLayoutChangeListener mRegisterOnLayoutChange = new View.OnLayoutChangeListener() {
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            LifecycleHelper.this.registerViewWithLifecycleOwner(view);
            view.removeOnLayoutChangeListener(this);
        }
    };
    private Map<View, Lifecycle> mViewToLifecycleMap = new HashMap();

    @Nullable
    public static Fragment findNearestScreenFragmentAncestor(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && !(parent instanceof Screen)) {
            parent = parent.getParent();
        }
        if (parent != null) {
            return ((Screen) parent).getFragment();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void registerViewWithLifecycleOwner(View view) {
        Fragment findNearestScreenFragmentAncestor = findNearestScreenFragmentAncestor(view);
        if (findNearestScreenFragmentAncestor != null && (view instanceof LifecycleObserver)) {
            Lifecycle lifecycle = findNearestScreenFragmentAncestor.getLifecycle();
            lifecycle.addObserver((LifecycleObserver) view);
            this.mViewToLifecycleMap.put(view, lifecycle);
        }
    }

    public <T extends View & LifecycleObserver> void register(T t) {
        t.addOnLayoutChangeListener(this.mRegisterOnLayoutChange);
    }

    public <T extends View & LifecycleObserver> void unregister(T t) {
        Lifecycle lifecycle = this.mViewToLifecycleMap.get(t);
        if (lifecycle != null) {
            lifecycle.removeObserver((LifecycleObserver) t);
        }
    }
}
