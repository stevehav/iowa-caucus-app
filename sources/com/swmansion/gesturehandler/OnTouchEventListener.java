package com.swmansion.gesturehandler;

import android.view.MotionEvent;
import com.swmansion.gesturehandler.GestureHandler;

public interface OnTouchEventListener<T extends GestureHandler> {
    void onStateChange(T t, int i, int i2);

    void onTouchEvent(T t, MotionEvent motionEvent);
}
