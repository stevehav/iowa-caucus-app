package com.swmansion.gesturehandler.react;

import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.swmansion.gesturehandler.GestureHandler;
import com.swmansion.gesturehandler.GestureHandlerOrchestrator;

public class RNGestureHandlerRootHelper {
    private static final float MIN_ALPHA_FOR_TOUCH = 0.1f;
    private final ReactContext mContext;
    private final GestureHandler mJSGestureHandler;
    private final GestureHandlerOrchestrator mOrchestrator;
    private boolean mPassingTouch = false;
    /* access modifiers changed from: private */
    public final ReactRootView mReactRootView;
    /* access modifiers changed from: private */
    public boolean mShouldIntercept = false;

    private static ReactRootView findRootViewTag(ViewGroup viewGroup) {
        UiThreadUtil.assertOnUiThread();
        ViewParent viewParent = viewGroup;
        while (viewParent != null && !(viewParent instanceof ReactRootView)) {
            viewParent = viewParent.getParent();
        }
        if (viewParent != null) {
            return (ReactRootView) viewParent;
        }
        throw new IllegalStateException("View " + viewGroup + " has not been mounted under ReactRootView");
    }

    public RNGestureHandlerRootHelper(ReactContext reactContext, ViewGroup viewGroup) {
        UiThreadUtil.assertOnUiThread();
        int id = viewGroup.getId();
        if (id >= 1) {
            RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) reactContext.getNativeModule(RNGestureHandlerModule.class);
            RNGestureHandlerRegistry registry = rNGestureHandlerModule.getRegistry();
            this.mReactRootView = findRootViewTag(viewGroup);
            Log.i(ReactConstants.TAG, "[GESTURE HANDLER] Initialize gesture handler for root view " + this.mReactRootView);
            this.mContext = reactContext;
            this.mOrchestrator = new GestureHandlerOrchestrator(viewGroup, registry, new RNViewConfigurationHelper());
            this.mOrchestrator.setMinimumAlphaForTraversal(MIN_ALPHA_FOR_TOUCH);
            this.mJSGestureHandler = new RootViewGestureHandler();
            this.mJSGestureHandler.setTag(-id);
            registry.registerHandler(this.mJSGestureHandler);
            registry.attachHandlerToView(this.mJSGestureHandler.getTag(), id);
            rNGestureHandlerModule.registerRootHelper(this);
            return;
        }
        throw new IllegalStateException("Expect view tag to be set for " + viewGroup);
    }

    public void tearDown() {
        Log.i(ReactConstants.TAG, "[GESTURE HANDLER] Tearing down gesture handler registered for root view " + this.mReactRootView);
        RNGestureHandlerModule rNGestureHandlerModule = (RNGestureHandlerModule) this.mContext.getNativeModule(RNGestureHandlerModule.class);
        rNGestureHandlerModule.getRegistry().dropHandler(this.mJSGestureHandler.getTag());
        rNGestureHandlerModule.unregisterRootHelper(this);
    }

    public ReactRootView getRootView() {
        return this.mReactRootView;
    }

    private class RootViewGestureHandler extends GestureHandler {
        private RootViewGestureHandler() {
        }

        /* access modifiers changed from: protected */
        public void onHandle(MotionEvent motionEvent) {
            if (getState() == 0) {
                begin();
                boolean unused = RNGestureHandlerRootHelper.this.mShouldIntercept = false;
            }
            if (motionEvent.getActionMasked() == 1) {
                end();
            }
        }

        /* access modifiers changed from: protected */
        public void onCancel() {
            boolean unused = RNGestureHandlerRootHelper.this.mShouldIntercept = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
            obtain.setAction(3);
            RNGestureHandlerRootHelper.this.mReactRootView.onChildStartedNativeGesture(obtain);
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (this.mOrchestrator != null && !this.mPassingTouch) {
            tryCancelAllHandlers();
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        this.mPassingTouch = true;
        this.mOrchestrator.onTouchEvent(motionEvent);
        this.mPassingTouch = false;
        if (this.mShouldIntercept) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void tryCancelAllHandlers() {
        GestureHandler gestureHandler = this.mJSGestureHandler;
        if (gestureHandler != null && gestureHandler.getState() == 2) {
            this.mJSGestureHandler.activate();
            this.mJSGestureHandler.end();
        }
    }

    /* access modifiers changed from: package-private */
    public void handleSetJSResponder(int i, boolean z) {
        if (z) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    RNGestureHandlerRootHelper.this.tryCancelAllHandlers();
                }
            });
        }
    }
}
