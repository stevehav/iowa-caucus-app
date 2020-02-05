package com.swmansion.gesturehandler;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;

public class LongPressGestureHandler extends GestureHandler<LongPressGestureHandler> {
    private static float DEFAULT_MAX_DIST_DP = 10.0f;
    private static final long DEFAULT_MIN_DURATION_MS = 500;
    private Handler mHandler;
    private float mMaxDistSq;
    private long mMinDurationMs = DEFAULT_MIN_DURATION_MS;
    private float mStartX;
    private float mStartY;

    public LongPressGestureHandler(Context context) {
        setShouldCancelWhenOutside(true);
        this.mMaxDistSq = DEFAULT_MAX_DIST_DP * context.getResources().getDisplayMetrics().density;
    }

    public void setMinDurationMs(long j) {
        this.mMinDurationMs = j;
    }

    public LongPressGestureHandler setMaxDist(float f) {
        this.mMaxDistSq = f * f;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        if (getState() == 0) {
            begin();
            this.mStartX = motionEvent.getRawX();
            this.mStartY = motionEvent.getRawY();
            this.mHandler = new Handler();
            this.mHandler.postDelayed(new Runnable() {
                public void run() {
                    LongPressGestureHandler.this.activate();
                }
            }, this.mMinDurationMs);
        }
        if (motionEvent.getActionMasked() == 1) {
            Handler handler = this.mHandler;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                this.mHandler = null;
            }
            if (getState() == 4) {
                end();
            } else {
                fail();
            }
        } else {
            float rawX = motionEvent.getRawX() - this.mStartX;
            float rawY = motionEvent.getRawY() - this.mStartY;
            if ((rawX * rawX) + (rawY * rawY) <= this.mMaxDistSq) {
                return;
            }
            if (getState() == 4) {
                cancel();
            } else {
                fail();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onStateChange(int i, int i2) {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.mHandler = null;
        }
    }
}
