package com.swmansion.gesturehandler;

import android.view.MotionEvent;
import android.view.View;
import com.swmansion.gesturehandler.GestureHandler;
import java.util.Arrays;

public class GestureHandler<T extends GestureHandler> {
    public static final int DIRECTION_DOWN = 8;
    public static final int DIRECTION_LEFT = 2;
    public static final int DIRECTION_RIGHT = 1;
    public static final int DIRECTION_UP = 4;
    private static final int HIT_SLOP_BOTTOM_IDX = 3;
    private static final int HIT_SLOP_HEIGHT_IDX = 5;
    private static final int HIT_SLOP_LEFT_IDX = 0;
    public static final float HIT_SLOP_NONE = Float.NaN;
    private static final int HIT_SLOP_RIGHT_IDX = 2;
    private static final int HIT_SLOP_TOP_IDX = 1;
    private static final int HIT_SLOP_WIDTH_IDX = 4;
    private static int MAX_POINTERS_COUNT = 11;
    public static final int STATE_ACTIVE = 4;
    public static final int STATE_BEGAN = 2;
    public static final int STATE_CANCELLED = 3;
    public static final int STATE_END = 5;
    public static final int STATE_FAILED = 1;
    public static final int STATE_UNDETERMINED = 0;
    private static MotionEvent.PointerCoords[] sPointerCoords;
    private static MotionEvent.PointerProperties[] sPointerProps;
    int mActivationIndex;
    private boolean mEnabled = true;
    private float[] mHitSlop;
    private GestureHandlerInteractionController mInteractionController;
    boolean mIsActive;
    boolean mIsAwaiting;
    private float mLastEventOffsetX;
    private float mLastEventOffsetY;
    private float mLastX;
    private float mLastY;
    private OnTouchEventListener<T> mListener;
    private int mNumberOfPointers = 0;
    private GestureHandlerOrchestrator mOrchestrator;
    private boolean mShouldCancelWhenOutside;
    private int mState = 0;
    private int mTag;
    private final int[] mTrackedPointerIDs = new int[MAX_POINTERS_COUNT];
    private int mTrackedPointersCount = 0;
    private View mView;
    private boolean mWithinBounds;
    private float mX;
    private float mY;

    public static String stateToString(int i) {
        if (i == 0) {
            return "UNDETERMINED";
        }
        if (i == 1) {
            return "FAILED";
        }
        if (i == 2) {
            return "BEGIN";
        }
        if (i == 3) {
            return "CANCELLED";
        }
        if (i == 4) {
            return "ACTIVE";
        }
        if (i != 5) {
            return null;
        }
        return "END";
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
    }

    /* access modifiers changed from: protected */
    public void onReset() {
    }

    /* access modifiers changed from: protected */
    public void onStateChange(int i, int i2) {
    }

    private static void initPointerProps(int i) {
        if (sPointerProps == null) {
            int i2 = MAX_POINTERS_COUNT;
            sPointerProps = new MotionEvent.PointerProperties[i2];
            sPointerCoords = new MotionEvent.PointerCoords[i2];
        }
        while (i > 0) {
            MotionEvent.PointerProperties[] pointerPropertiesArr = sPointerProps;
            int i3 = i - 1;
            if (pointerPropertiesArr[i3] == null) {
                pointerPropertiesArr[i3] = new MotionEvent.PointerProperties();
                sPointerCoords[i3] = new MotionEvent.PointerCoords();
                i--;
            } else {
                return;
            }
        }
    }

    private static boolean hitSlopSet(float f) {
        return !Float.isNaN(f);
    }

    /* access modifiers changed from: package-private */
    public void dispatchStateChange(int i, int i2) {
        OnTouchEventListener<T> onTouchEventListener = this.mListener;
        if (onTouchEventListener != null) {
            onTouchEventListener.onStateChange(this, i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchTouchEvent(MotionEvent motionEvent) {
        OnTouchEventListener<T> onTouchEventListener = this.mListener;
        if (onTouchEventListener != null) {
            onTouchEventListener.onTouchEvent(this, motionEvent);
        }
    }

    public boolean hasCommonPointers(GestureHandler gestureHandler) {
        int i = 0;
        while (true) {
            int[] iArr = this.mTrackedPointerIDs;
            if (i >= iArr.length) {
                return false;
            }
            if (iArr[i] != -1 && gestureHandler.mTrackedPointerIDs[i] != -1) {
                return true;
            }
            i++;
        }
    }

    public T setShouldCancelWhenOutside(boolean z) {
        this.mShouldCancelWhenOutside = z;
        return this;
    }

    public T setEnabled(boolean z) {
        if (this.mView != null) {
            cancel();
        }
        this.mEnabled = z;
        return this;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public T setHitSlop(float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.mHitSlop == null) {
            this.mHitSlop = new float[6];
        }
        float[] fArr = this.mHitSlop;
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        if (hitSlopSet(f5) && hitSlopSet(f) && hitSlopSet(f3)) {
            throw new IllegalArgumentException("Cannot have all of left, right and width defined");
        } else if (hitSlopSet(f5) && !hitSlopSet(f) && !hitSlopSet(f3)) {
            throw new IllegalArgumentException("When width is set one of left or right pads need to be defined");
        } else if (hitSlopSet(f6) && hitSlopSet(f4) && hitSlopSet(f2)) {
            throw new IllegalArgumentException("Cannot have all of top, bottom and height defined");
        } else if (!hitSlopSet(f6) || hitSlopSet(f4) || hitSlopSet(f2)) {
            return this;
        } else {
            throw new IllegalArgumentException("When height is set one of top or bottom pads need to be defined");
        }
    }

    public T setHitSlop(float f) {
        return setHitSlop(f, f, f, f, Float.NaN, Float.NaN);
    }

    public T setInteractionController(GestureHandlerInteractionController gestureHandlerInteractionController) {
        this.mInteractionController = gestureHandlerInteractionController;
        return this;
    }

    public void setTag(int i) {
        this.mTag = i;
    }

    public int getTag() {
        return this.mTag;
    }

    public View getView() {
        return this.mView;
    }

    public float getX() {
        return this.mX;
    }

    public float getY() {
        return this.mY;
    }

    public int getNumberOfPointers() {
        return this.mNumberOfPointers;
    }

    public boolean isWithinBounds() {
        return this.mWithinBounds;
    }

    public final void prepare(View view, GestureHandlerOrchestrator gestureHandlerOrchestrator) {
        if (this.mView == null && this.mOrchestrator == null) {
            Arrays.fill(this.mTrackedPointerIDs, -1);
            this.mTrackedPointersCount = 0;
            this.mState = 0;
            this.mView = view;
            this.mOrchestrator = gestureHandlerOrchestrator;
            return;
        }
        throw new IllegalStateException("Already prepared or hasn't been reset");
    }

    private int findNextLocalPointerId() {
        int i = 0;
        while (i < this.mTrackedPointersCount) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.mTrackedPointerIDs;
                if (i2 < iArr.length && iArr[i2] != i) {
                    i2++;
                }
            }
            if (i2 == this.mTrackedPointerIDs.length) {
                return i;
            }
            i++;
        }
        return i;
    }

    public void startTrackingPointer(int i) {
        int[] iArr = this.mTrackedPointerIDs;
        if (iArr[i] == -1) {
            iArr[i] = findNextLocalPointerId();
            this.mTrackedPointersCount++;
        }
    }

    public void stopTrackingPointer(int i) {
        int[] iArr = this.mTrackedPointerIDs;
        if (iArr[i] != -1) {
            iArr[i] = -1;
            this.mTrackedPointersCount--;
        }
    }

    private boolean needAdapt(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != this.mTrackedPointersCount) {
            return true;
        }
        int i = 0;
        while (true) {
            int[] iArr = this.mTrackedPointerIDs;
            if (i >= iArr.length) {
                return false;
            }
            if (iArr[i] != -1 && iArr[i] != i) {
                return true;
            }
            i++;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.MotionEvent adaptEvent(android.view.MotionEvent r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            boolean r2 = r25.needAdapt(r26)
            if (r2 != 0) goto L_0x000b
            return r1
        L_0x000b:
            int r2 = r26.getActionMasked()
            r3 = 2
            r4 = 5
            r5 = 0
            r6 = -1
            r7 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x0019
            goto L_0x0037
        L_0x0019:
            r4 = 6
            if (r2 == r7) goto L_0x0022
            if (r2 != r4) goto L_0x001f
            goto L_0x0022
        L_0x001f:
            r3 = r2
            r2 = -1
            goto L_0x004b
        L_0x0022:
            int r2 = r26.getActionIndex()
            int r8 = r1.getPointerId(r2)
            int[] r9 = r0.mTrackedPointerIDs
            r8 = r9[r8]
            if (r8 == r6) goto L_0x004b
            int r3 = r0.mTrackedPointersCount
            if (r3 != r7) goto L_0x0035
            r4 = 1
        L_0x0035:
            r3 = r4
            goto L_0x004b
        L_0x0037:
            int r2 = r26.getActionIndex()
            int r8 = r1.getPointerId(r2)
            int[] r9 = r0.mTrackedPointerIDs
            r8 = r9[r8]
            if (r8 == r6) goto L_0x004b
            int r3 = r0.mTrackedPointersCount
            if (r3 != r7) goto L_0x0035
            r4 = 0
            goto L_0x0035
        L_0x004b:
            int r4 = r0.mTrackedPointersCount
            initPointerProps(r4)
            float r4 = r26.getX()
            float r7 = r26.getY()
            float r8 = r26.getRawX()
            float r9 = r26.getRawY()
            r1.setLocation(r8, r9)
            int r8 = r26.getPointerCount()
            r13 = r3
            r14 = 0
        L_0x0069:
            if (r5 >= r8) goto L_0x0097
            int r3 = r1.getPointerId(r5)
            int[] r9 = r0.mTrackedPointerIDs
            r9 = r9[r3]
            if (r9 == r6) goto L_0x0094
            android.view.MotionEvent$PointerProperties[] r9 = sPointerProps
            r9 = r9[r14]
            r1.getPointerProperties(r5, r9)
            android.view.MotionEvent$PointerProperties[] r9 = sPointerProps
            r9 = r9[r14]
            int[] r10 = r0.mTrackedPointerIDs
            r3 = r10[r3]
            r9.id = r3
            android.view.MotionEvent$PointerCoords[] r3 = sPointerCoords
            r3 = r3[r14]
            r1.getPointerCoords(r5, r3)
            if (r5 != r2) goto L_0x0092
            int r3 = r14 << 8
            r13 = r13 | r3
        L_0x0092:
            int r14 = r14 + 1
        L_0x0094:
            int r5 = r5 + 1
            goto L_0x0069
        L_0x0097:
            long r9 = r26.getDownTime()
            long r11 = r26.getEventTime()
            android.view.MotionEvent$PointerProperties[] r15 = sPointerProps
            android.view.MotionEvent$PointerCoords[] r16 = sPointerCoords
            int r17 = r26.getMetaState()
            int r18 = r26.getButtonState()
            float r19 = r26.getXPrecision()
            float r20 = r26.getYPrecision()
            int r21 = r26.getDeviceId()
            int r22 = r26.getEdgeFlags()
            int r23 = r26.getSource()
            int r24 = r26.getFlags()
            android.view.MotionEvent r2 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            r1.setLocation(r4, r7)
            r2.setLocation(r4, r7)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.GestureHandler.adaptEvent(android.view.MotionEvent):android.view.MotionEvent");
    }

    public final void handle(MotionEvent motionEvent) {
        int i;
        if (this.mEnabled && (i = this.mState) != 3 && i != 1 && i != 5 && this.mTrackedPointersCount >= 1) {
            MotionEvent adaptEvent = adaptEvent(motionEvent);
            this.mX = adaptEvent.getX();
            this.mY = adaptEvent.getY();
            this.mNumberOfPointers = adaptEvent.getPointerCount();
            this.mWithinBounds = isWithinBounds(this.mView, this.mX, this.mY);
            if (!this.mShouldCancelWhenOutside || this.mWithinBounds) {
                this.mLastX = GestureUtils.getLastPointerX(adaptEvent, true);
                this.mLastY = GestureUtils.getLastPointerY(adaptEvent, true);
                this.mLastEventOffsetX = adaptEvent.getRawX() - adaptEvent.getX();
                this.mLastEventOffsetY = adaptEvent.getRawY() - adaptEvent.getY();
                onHandle(adaptEvent);
                if (adaptEvent != motionEvent) {
                    adaptEvent.recycle();
                    return;
                }
                return;
            }
            int i2 = this.mState;
            if (i2 == 4) {
                cancel();
            } else if (i2 == 2) {
                fail();
            }
        }
    }

    private void moveToState(int i) {
        int i2 = this.mState;
        if (i2 != i) {
            this.mState = i;
            this.mOrchestrator.onHandlerStateChange(this, i, i2);
            onStateChange(i, i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r3.mState;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean wantEvents() {
        /*
            r3 = this;
            boolean r0 = r3.mEnabled
            r1 = 1
            if (r0 == 0) goto L_0x0014
            int r0 = r3.mState
            if (r0 == r1) goto L_0x0014
            r2 = 3
            if (r0 == r2) goto L_0x0014
            r2 = 5
            if (r0 == r2) goto L_0x0014
            int r0 = r3.mTrackedPointersCount
            if (r0 <= 0) goto L_0x0014
            goto L_0x0015
        L_0x0014:
            r1 = 0
        L_0x0015:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.GestureHandler.wantEvents():boolean");
    }

    public int getState() {
        return this.mState;
    }

    public boolean shouldRequireToWaitForFailure(GestureHandler gestureHandler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        if (gestureHandler == this || (gestureHandlerInteractionController = this.mInteractionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldRequireHandlerToWaitForFailure(this, gestureHandler);
    }

    public boolean shouldWaitForHandlerFailure(GestureHandler gestureHandler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        if (gestureHandler == this || (gestureHandlerInteractionController = this.mInteractionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldWaitForHandlerFailure(this, gestureHandler);
    }

    public boolean shouldRecognizeSimultaneously(GestureHandler gestureHandler) {
        if (gestureHandler == this) {
            return true;
        }
        GestureHandlerInteractionController gestureHandlerInteractionController = this.mInteractionController;
        if (gestureHandlerInteractionController != null) {
            return gestureHandlerInteractionController.shouldRecognizeSimultaneously(this, gestureHandler);
        }
        return false;
    }

    public boolean shouldBeCancelledBy(GestureHandler gestureHandler) {
        GestureHandlerInteractionController gestureHandlerInteractionController;
        if (gestureHandler == this || (gestureHandlerInteractionController = this.mInteractionController) == null) {
            return false;
        }
        return gestureHandlerInteractionController.shouldHandlerBeCancelledBy(this, gestureHandler);
    }

    public boolean isWithinBounds(View view, float f, float f2) {
        float f3;
        float width = (float) view.getWidth();
        float height = (float) view.getHeight();
        float[] fArr = this.mHitSlop;
        float f4 = 0.0f;
        if (fArr != null) {
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = fArr[2];
            float f8 = fArr[3];
            f3 = hitSlopSet(f5) ? 0.0f - f5 : 0.0f;
            if (hitSlopSet(f6)) {
                f4 = 0.0f - f8;
            }
            if (hitSlopSet(f7)) {
                width += f7;
            }
            if (hitSlopSet(f8)) {
                height += f8;
            }
            float[] fArr2 = this.mHitSlop;
            float f9 = fArr2[4];
            float f10 = fArr2[5];
            if (hitSlopSet(f9)) {
                if (!hitSlopSet(f5)) {
                    f3 = width - f9;
                } else if (!hitSlopSet(f7)) {
                    width = f9 + f3;
                }
            }
            if (hitSlopSet(f10)) {
                if (!hitSlopSet(f4)) {
                    f4 = height - f10;
                } else if (!hitSlopSet(height)) {
                    height = f4 + f10;
                }
            }
        } else {
            f3 = 0.0f;
        }
        if (f < f3 || f > width || f2 < f4 || f2 > height) {
            return false;
        }
        return true;
    }

    public final void cancel() {
        int i = this.mState;
        if (i == 4 || i == 0 || i == 2) {
            onCancel();
            moveToState(3);
        }
    }

    public final void fail() {
        int i = this.mState;
        if (i == 4 || i == 0 || i == 2) {
            moveToState(1);
        }
    }

    public final void activate() {
        int i = this.mState;
        if (i == 0 || i == 2) {
            moveToState(4);
        }
    }

    public final void begin() {
        if (this.mState == 0) {
            moveToState(2);
        }
    }

    public final void end() {
        int i = this.mState;
        if (i == 2 || i == 4) {
            moveToState(5);
        }
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        moveToState(1);
    }

    public final void reset() {
        this.mView = null;
        this.mOrchestrator = null;
        Arrays.fill(this.mTrackedPointerIDs, -1);
        this.mTrackedPointersCount = 0;
        onReset();
    }

    public GestureHandler setOnTouchEventListener(OnTouchEventListener<T> onTouchEventListener) {
        this.mListener = onTouchEventListener;
        return this;
    }

    public String toString() {
        View view = this.mView;
        String simpleName = view == null ? null : view.getClass().getSimpleName();
        return getClass().getSimpleName() + "@[" + this.mTag + "]:" + simpleName;
    }

    public float getLastAbsolutePositionX() {
        return this.mLastX;
    }

    public float getLastAbsolutePositionY() {
        return this.mLastY;
    }

    public float getLastRelativePositionX() {
        return this.mLastX - this.mLastEventOffsetX;
    }

    public float getLastRelativePositionY() {
        return this.mLastY - this.mLastEventOffsetY;
    }
}
