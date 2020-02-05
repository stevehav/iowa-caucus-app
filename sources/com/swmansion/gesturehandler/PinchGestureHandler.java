package com.swmansion.gesturehandler;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

public class PinchGestureHandler extends GestureHandler<PinchGestureHandler> {
    private ScaleGestureDetector.OnScaleGestureListener mGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }

        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            double access$000 = PinchGestureHandler.this.mLastScaleFactor;
            PinchGestureHandler pinchGestureHandler = PinchGestureHandler.this;
            double access$0002 = pinchGestureHandler.mLastScaleFactor;
            double scaleFactor = (double) scaleGestureDetector.getScaleFactor();
            Double.isNaN(scaleFactor);
            double unused = pinchGestureHandler.mLastScaleFactor = access$0002 * scaleFactor;
            long timeDelta = scaleGestureDetector.getTimeDelta();
            if (timeDelta > 0) {
                PinchGestureHandler pinchGestureHandler2 = PinchGestureHandler.this;
                double access$0003 = pinchGestureHandler2.mLastScaleFactor - access$000;
                double d = (double) timeDelta;
                Double.isNaN(d);
                double unused2 = pinchGestureHandler2.mLastVelocity = access$0003 / d;
            }
            if (Math.abs(PinchGestureHandler.this.mStartingSpan - scaleGestureDetector.getCurrentSpan()) < PinchGestureHandler.this.mSpanSlop || PinchGestureHandler.this.getState() != 2) {
                return true;
            }
            PinchGestureHandler.this.activate();
            return true;
        }

        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            float unused = PinchGestureHandler.this.mStartingSpan = scaleGestureDetector.getCurrentSpan();
            return true;
        }
    };
    /* access modifiers changed from: private */
    public double mLastScaleFactor;
    /* access modifiers changed from: private */
    public double mLastVelocity;
    private ScaleGestureDetector mScaleGestureDetector;
    /* access modifiers changed from: private */
    public float mSpanSlop;
    /* access modifiers changed from: private */
    public float mStartingSpan;

    public PinchGestureHandler() {
        setShouldCancelWhenOutside(false);
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        if (getState() == 0) {
            Context context = getView().getContext();
            this.mLastVelocity = 0.0d;
            this.mLastScaleFactor = 1.0d;
            this.mScaleGestureDetector = new ScaleGestureDetector(context, this.mGestureListener);
            this.mSpanSlop = (float) ViewConfiguration.get(context).getScaledTouchSlop();
            begin();
        }
        ScaleGestureDetector scaleGestureDetector = this.mScaleGestureDetector;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        if (motionEvent.getActionMasked() == 6) {
            pointerCount--;
        }
        if (getState() == 4 && pointerCount < 2) {
            end();
        } else if (motionEvent.getActionMasked() == 1) {
            fail();
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.mScaleGestureDetector = null;
        this.mLastVelocity = 0.0d;
        this.mLastScaleFactor = 1.0d;
    }

    public double getScale() {
        return this.mLastScaleFactor;
    }

    public double getVelocity() {
        return this.mLastVelocity;
    }

    public float getFocalPointX() {
        ScaleGestureDetector scaleGestureDetector = this.mScaleGestureDetector;
        if (scaleGestureDetector == null) {
            return Float.NaN;
        }
        return scaleGestureDetector.getFocusX();
    }

    public float getFocalPointY() {
        ScaleGestureDetector scaleGestureDetector = this.mScaleGestureDetector;
        if (scaleGestureDetector == null) {
            return Float.NaN;
        }
        return scaleGestureDetector.getFocusY();
    }
}
