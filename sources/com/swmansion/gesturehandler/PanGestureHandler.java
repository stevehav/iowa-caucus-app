package com.swmansion.gesturehandler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class PanGestureHandler extends GestureHandler<PanGestureHandler> {
    private static int DEFAULT_MAX_POINTERS = 10;
    private static int DEFAULT_MIN_POINTERS = 1;
    private static float MAX_VALUE_IGNORE = Float.MIN_VALUE;
    private static float MIN_VALUE_IGNORE = Float.MAX_VALUE;
    private float mActiveOffsetXEnd;
    private float mActiveOffsetXStart;
    private float mActiveOffsetYEnd;
    private float mActiveOffsetYStart;
    private boolean mAverageTouches;
    private float mFailOffsetXEnd;
    private float mFailOffsetXStart;
    private float mFailOffsetYEnd;
    private float mFailOffsetYStart;
    private float mLastVelocityX;
    private float mLastVelocityY;
    private float mLastX;
    private float mLastY;
    private int mMaxPointers = DEFAULT_MAX_POINTERS;
    private float mMinDistSq;
    private int mMinPointers = DEFAULT_MIN_POINTERS;
    private float mMinVelocitySq;
    private float mMinVelocityX;
    private float mMinVelocityY;
    private float mOffsetX;
    private float mOffsetY;
    private float mStartX;
    private float mStartY;
    private VelocityTracker mVelocityTracker;

    public PanGestureHandler(Context context) {
        float f = MAX_VALUE_IGNORE;
        this.mMinDistSq = f;
        float f2 = MIN_VALUE_IGNORE;
        this.mActiveOffsetXStart = f2;
        this.mActiveOffsetXEnd = f;
        this.mFailOffsetXStart = f;
        this.mFailOffsetXEnd = f2;
        this.mActiveOffsetYStart = f2;
        this.mActiveOffsetYEnd = f;
        this.mFailOffsetYStart = f;
        this.mFailOffsetYEnd = f2;
        this.mMinVelocityX = f2;
        this.mMinVelocityY = f2;
        this.mMinVelocitySq = f2;
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMinDistSq = (float) (scaledTouchSlop * scaledTouchSlop);
    }

    public PanGestureHandler setActiveOffsetXStart(float f) {
        this.mActiveOffsetXStart = f;
        return this;
    }

    public PanGestureHandler setActiveOffsetXEnd(float f) {
        this.mActiveOffsetXEnd = f;
        return this;
    }

    public PanGestureHandler setFailOffsetXStart(float f) {
        this.mFailOffsetXStart = f;
        return this;
    }

    public PanGestureHandler setFailOffsetXEnd(float f) {
        this.mFailOffsetXEnd = f;
        return this;
    }

    public PanGestureHandler setActiveOffsetYStart(float f) {
        this.mActiveOffsetYStart = f;
        return this;
    }

    public PanGestureHandler setActiveOffsetYEnd(float f) {
        this.mActiveOffsetYEnd = f;
        return this;
    }

    public PanGestureHandler setFailOffsetYStart(float f) {
        this.mFailOffsetYStart = f;
        return this;
    }

    public PanGestureHandler setFailOffsetYEnd(float f) {
        this.mFailOffsetYEnd = f;
        return this;
    }

    public PanGestureHandler setMinDist(float f) {
        this.mMinDistSq = f * f;
        return this;
    }

    public PanGestureHandler setMinPointers(int i) {
        this.mMinPointers = i;
        return this;
    }

    public PanGestureHandler setMaxPointers(int i) {
        this.mMaxPointers = i;
        return this;
    }

    public PanGestureHandler setAverageTouches(boolean z) {
        this.mAverageTouches = z;
        return this;
    }

    public PanGestureHandler setMinVelocity(float f) {
        this.mMinVelocitySq = f * f;
        return this;
    }

    public PanGestureHandler setMinVelocityX(float f) {
        this.mMinVelocityX = f;
        return this;
    }

    public PanGestureHandler setMinVelocityY(float f) {
        this.mMinVelocityY = f;
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0072, code lost:
        if (r0 >= r1) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x008f, code lost:
        if (r0 >= r2) goto L_0x0091;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean shouldActivate() {
        /*
            r6 = this;
            float r0 = r6.mLastX
            float r1 = r6.mStartX
            float r0 = r0 - r1
            float r1 = r6.mOffsetX
            float r0 = r0 + r1
            float r1 = r6.mActiveOffsetXStart
            float r2 = MIN_VALUE_IGNORE
            r3 = 1
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0016
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 >= 0) goto L_0x0016
            return r3
        L_0x0016:
            float r1 = r6.mActiveOffsetXEnd
            float r2 = MAX_VALUE_IGNORE
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0023
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0023
            return r3
        L_0x0023:
            float r1 = r6.mLastY
            float r2 = r6.mStartY
            float r1 = r1 - r2
            float r2 = r6.mOffsetY
            float r1 = r1 + r2
            float r2 = r6.mActiveOffsetYStart
            float r4 = MIN_VALUE_IGNORE
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0038
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0038
            return r3
        L_0x0038:
            float r2 = r6.mActiveOffsetYEnd
            float r4 = MAX_VALUE_IGNORE
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x0045
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0045
            return r3
        L_0x0045:
            float r0 = r0 * r0
            float r1 = r1 * r1
            float r0 = r0 + r1
            float r1 = r6.mMinDistSq
            float r2 = MIN_VALUE_IGNORE
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0057
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x0057
            return r3
        L_0x0057:
            float r0 = r6.mLastVelocityX
            float r1 = r6.mMinVelocityX
            float r2 = MIN_VALUE_IGNORE
            r4 = 0
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x0075
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x006a
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 <= 0) goto L_0x0074
        L_0x006a:
            float r1 = r6.mMinVelocityX
            int r2 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x0075
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x0075
        L_0x0074:
            return r3
        L_0x0075:
            float r1 = r6.mLastVelocityY
            float r2 = r6.mMinVelocityY
            float r5 = MIN_VALUE_IGNORE
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 == 0) goto L_0x0092
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x0087
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0091
        L_0x0087:
            float r2 = r6.mMinVelocityY
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 < 0) goto L_0x0092
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 < 0) goto L_0x0092
        L_0x0091:
            return r3
        L_0x0092:
            float r0 = r0 * r0
            float r1 = r1 * r1
            float r0 = r0 + r1
            float r1 = r6.mMinVelocitySq
            float r2 = MIN_VALUE_IGNORE
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00a4
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00a4
            return r3
        L_0x00a4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.PanGestureHandler.shouldActivate():boolean");
    }

    private boolean shouldFail() {
        float f = (this.mLastX - this.mStartX) + this.mOffsetX;
        float f2 = this.mFailOffsetXStart;
        if (f2 != MAX_VALUE_IGNORE && f < f2) {
            return true;
        }
        float f3 = this.mFailOffsetXEnd;
        if (f3 != MIN_VALUE_IGNORE && f > f3) {
            return true;
        }
        float f4 = (this.mLastY - this.mStartY) + this.mOffsetY;
        float f5 = this.mFailOffsetYStart;
        if (f5 != MAX_VALUE_IGNORE && f4 < f5) {
            return true;
        }
        float f6 = this.mFailOffsetYEnd;
        if (f6 == MIN_VALUE_IGNORE || f4 <= f6) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        int state = getState();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 6 || actionMasked == 5) {
            this.mOffsetX += this.mLastX - this.mStartX;
            this.mOffsetY += this.mLastY - this.mStartY;
            this.mLastX = GestureUtils.getLastPointerX(motionEvent, this.mAverageTouches);
            this.mLastY = GestureUtils.getLastPointerY(motionEvent, this.mAverageTouches);
            this.mStartX = this.mLastX;
            this.mStartY = this.mLastY;
        } else {
            this.mLastX = GestureUtils.getLastPointerX(motionEvent, this.mAverageTouches);
            this.mLastY = GestureUtils.getLastPointerY(motionEvent, this.mAverageTouches);
        }
        if (state != 0 || motionEvent.getPointerCount() < this.mMinPointers) {
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                addVelocityMovement(velocityTracker, motionEvent);
                this.mVelocityTracker.computeCurrentVelocity(1000);
                this.mLastVelocityX = this.mVelocityTracker.getXVelocity();
                this.mLastVelocityY = this.mVelocityTracker.getYVelocity();
            }
        } else {
            this.mStartX = this.mLastX;
            this.mStartY = this.mLastY;
            this.mOffsetX = 0.0f;
            this.mOffsetY = 0.0f;
            this.mVelocityTracker = VelocityTracker.obtain();
            addVelocityMovement(this.mVelocityTracker, motionEvent);
            begin();
        }
        if (actionMasked == 1) {
            if (state == 4 || state == 2) {
                end();
            } else {
                fail();
            }
        } else if (actionMasked != 5 || motionEvent.getPointerCount() <= this.mMaxPointers) {
            if (actionMasked == 6 && state == 4 && motionEvent.getPointerCount() < this.mMinPointers) {
                fail();
            } else if (state != 2) {
            } else {
                if (shouldFail()) {
                    fail();
                } else if (shouldActivate()) {
                    this.mStartX = this.mLastX;
                    this.mStartY = this.mLastY;
                    activate();
                }
            }
        } else if (state == 4) {
            cancel();
        } else {
            fail();
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public float getTranslationX() {
        return (this.mLastX - this.mStartX) + this.mOffsetX;
    }

    public float getTranslationY() {
        return (this.mLastY - this.mStartY) + this.mOffsetY;
    }

    public float getVelocityX() {
        return this.mLastVelocityX;
    }

    public float getVelocityY() {
        return this.mLastVelocityY;
    }

    private static void addVelocityMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        motionEvent.offsetLocation(rawX, rawY);
        velocityTracker.addMovement(motionEvent);
        motionEvent.offsetLocation(-rawX, -rawY);
    }
}
