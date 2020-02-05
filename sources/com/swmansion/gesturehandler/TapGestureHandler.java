package com.swmansion.gesturehandler;

import android.os.Handler;
import android.view.MotionEvent;

public class TapGestureHandler extends GestureHandler<TapGestureHandler> {
    private static final long DEFAULT_MAX_DELAY_MS = 500;
    private static final long DEFAULT_MAX_DURATION_MS = 500;
    private static final int DEFAULT_MIN_NUMBER_OF_POINTERS = 1;
    private static final int DEFAULT_NUMBER_OF_TAPS = 1;
    private static float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private final Runnable mFailDelayed = new Runnable() {
        public void run() {
            TapGestureHandler.this.fail();
        }
    };
    private Handler mHandler;
    private float mLastX;
    private float mLastY;
    private long mMaxDelayMs = 500;
    private float mMaxDeltaX;
    private float mMaxDeltaY;
    private float mMaxDistSq;
    private long mMaxDurationMs = 500;
    private int mMinNumberOfPointers = 1;
    private int mNumberOfPointers = 1;
    private int mNumberOfTaps = 1;
    private float mOffsetX;
    private float mOffsetY;
    private float mStartX;
    private float mStartY;
    private int mTapsSoFar;

    public TapGestureHandler setNumberOfTaps(int i) {
        this.mNumberOfTaps = i;
        return this;
    }

    public TapGestureHandler setMaxDelayMs(long j) {
        this.mMaxDelayMs = j;
        return this;
    }

    public TapGestureHandler setMaxDurationMs(long j) {
        this.mMaxDurationMs = j;
        return this;
    }

    public TapGestureHandler setMaxDx(float f) {
        this.mMaxDeltaX = f;
        return this;
    }

    public TapGestureHandler setMaxDy(float f) {
        this.mMaxDeltaY = f;
        return this;
    }

    public TapGestureHandler setMaxDist(float f) {
        this.mMaxDistSq = f * f;
        return this;
    }

    public TapGestureHandler setMinNumberOfPointers(int i) {
        this.mMinNumberOfPointers = i;
        return this;
    }

    public TapGestureHandler() {
        float f = MAX_VALUE_IGNORE;
        this.mMaxDeltaX = f;
        this.mMaxDeltaY = f;
        this.mMaxDistSq = f;
        setShouldCancelWhenOutside(true);
    }

    private void startTap() {
        Handler handler = this.mHandler;
        if (handler == null) {
            this.mHandler = new Handler();
        } else {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.mHandler.postDelayed(this.mFailDelayed, this.mMaxDurationMs);
    }

    private void endTap() {
        Handler handler = this.mHandler;
        if (handler == null) {
            this.mHandler = new Handler();
        } else {
            handler.removeCallbacksAndMessages((Object) null);
        }
        int i = this.mTapsSoFar + 1;
        this.mTapsSoFar = i;
        if (i != this.mNumberOfTaps || this.mNumberOfPointers < this.mMinNumberOfPointers) {
            this.mHandler.postDelayed(this.mFailDelayed, this.mMaxDelayMs);
            return;
        }
        activate();
        end();
    }

    private boolean shouldFail() {
        float f = (this.mLastX - this.mStartX) + this.mOffsetX;
        if (this.mMaxDeltaX != MAX_VALUE_IGNORE && Math.abs(f) > this.mMaxDeltaX) {
            return true;
        }
        float f2 = (this.mLastY - this.mStartY) + this.mOffsetY;
        if (this.mMaxDeltaY != MAX_VALUE_IGNORE && Math.abs(f2) > this.mMaxDeltaY) {
            return true;
        }
        float f3 = (f2 * f2) + (f * f);
        float f4 = this.mMaxDistSq;
        if (f4 == MAX_VALUE_IGNORE || f3 <= f4) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        int state = getState();
        int actionMasked = motionEvent.getActionMasked();
        if (state == 0) {
            this.mOffsetX = 0.0f;
            this.mOffsetY = 0.0f;
            this.mStartX = motionEvent.getRawX();
            this.mStartY = motionEvent.getRawY();
        }
        if (actionMasked == 6 || actionMasked == 5) {
            this.mOffsetX += this.mLastX - this.mStartX;
            this.mOffsetY += this.mLastY - this.mStartY;
            this.mLastX = GestureUtils.getLastPointerX(motionEvent, true);
            this.mLastY = GestureUtils.getLastPointerY(motionEvent, true);
            this.mStartX = this.mLastX;
            this.mStartY = this.mLastY;
        } else {
            this.mLastX = GestureUtils.getLastPointerX(motionEvent, true);
            this.mLastY = GestureUtils.getLastPointerY(motionEvent, true);
        }
        if (this.mNumberOfPointers < motionEvent.getPointerCount()) {
            this.mNumberOfPointers = motionEvent.getPointerCount();
        }
        if (shouldFail()) {
            fail();
        } else if (state == 0) {
            if (actionMasked == 0) {
                begin();
            }
            startTap();
        } else if (state != 2) {
        } else {
            if (actionMasked == 1) {
                endTap();
            } else if (actionMasked == 0) {
                startTap();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.mTapsSoFar = 0;
        this.mNumberOfPointers = 0;
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }
}
