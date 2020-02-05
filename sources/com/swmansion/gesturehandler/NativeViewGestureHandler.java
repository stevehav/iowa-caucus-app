package com.swmansion.gesturehandler;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

public class NativeViewGestureHandler extends GestureHandler<NativeViewGestureHandler> {
    private boolean mDisallowInterruption;
    private boolean mShouldActivateOnStart;

    public NativeViewGestureHandler() {
        setShouldCancelWhenOutside(true);
    }

    public NativeViewGestureHandler setShouldActivateOnStart(boolean z) {
        this.mShouldActivateOnStart = z;
        return this;
    }

    public NativeViewGestureHandler setDisallowInterruption(boolean z) {
        this.mDisallowInterruption = z;
        return this;
    }

    public boolean shouldRequireToWaitForFailure(GestureHandler gestureHandler) {
        return super.shouldRequireToWaitForFailure(gestureHandler);
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
        if (gestureHandler instanceof NativeViewGestureHandler) {
            NativeViewGestureHandler nativeViewGestureHandler = (NativeViewGestureHandler) gestureHandler;
            if (nativeViewGestureHandler.getState() == 4 && nativeViewGestureHandler.mDisallowInterruption) {
                return false;
            }
        }
        boolean z = !this.mDisallowInterruption;
        int state = getState();
        int state2 = gestureHandler.getState();
        if ((state != 4 || state2 != 4 || !z) && state == 4 && z) {
            return true;
        }
        return false;
    }

    public boolean shouldBeCancelledBy(GestureHandler gestureHandler) {
        return !this.mDisallowInterruption;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        View view = getView();
        int state = getState();
        if (motionEvent.getActionMasked() == 1) {
            view.onTouchEvent(motionEvent);
            if ((state == 0 || state == 2) && view.isPressed()) {
                activate();
            }
            end();
        } else if (state == 0 || state == 2) {
            if (this.mShouldActivateOnStart) {
                tryIntercept(view, motionEvent);
                view.onTouchEvent(motionEvent);
                activate();
            } else if (tryIntercept(view, motionEvent)) {
                view.onTouchEvent(motionEvent);
                activate();
            } else if (state != 2) {
                begin();
            }
        } else if (state == 4) {
            view.onTouchEvent(motionEvent);
        }
    }

    private static boolean tryIntercept(View view, MotionEvent motionEvent) {
        return (view instanceof ViewGroup) && ((ViewGroup) view).onInterceptTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setAction(3);
        getView().onTouchEvent(obtain);
    }
}
