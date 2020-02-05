package com.swmansion.gesturehandler;

import android.view.MotionEvent;
import com.swmansion.gesturehandler.RotationGestureDetector;

public class RotationGestureHandler extends GestureHandler<RotationGestureHandler> {
    private static final double ROTATION_RECOGNITION_THRESHOLD = 0.08726646259971647d;
    private RotationGestureDetector.OnRotationGestureListener mGestureListener = new RotationGestureDetector.OnRotationGestureListener() {
        public boolean onRotationBegin(RotationGestureDetector rotationGestureDetector) {
            return true;
        }

        public boolean onRotation(RotationGestureDetector rotationGestureDetector) {
            double access$000 = RotationGestureHandler.this.mLastRotation;
            RotationGestureHandler rotationGestureHandler = RotationGestureHandler.this;
            double unused = rotationGestureHandler.mLastRotation = rotationGestureHandler.mLastRotation + rotationGestureDetector.getRotation();
            long timeDelta = rotationGestureDetector.getTimeDelta();
            if (timeDelta > 0) {
                RotationGestureHandler rotationGestureHandler2 = RotationGestureHandler.this;
                double access$0002 = rotationGestureHandler2.mLastRotation - access$000;
                double d = (double) timeDelta;
                Double.isNaN(d);
                double unused2 = rotationGestureHandler2.mLastVelocity = access$0002 / d;
            }
            if (Math.abs(RotationGestureHandler.this.mLastRotation) < RotationGestureHandler.ROTATION_RECOGNITION_THRESHOLD || RotationGestureHandler.this.getState() != 2) {
                return true;
            }
            RotationGestureHandler.this.activate();
            return true;
        }

        public void onRotationEnd(RotationGestureDetector rotationGestureDetector) {
            RotationGestureHandler.this.end();
        }
    };
    /* access modifiers changed from: private */
    public double mLastRotation;
    /* access modifiers changed from: private */
    public double mLastVelocity;
    private RotationGestureDetector mRotationGestureDetector;

    public RotationGestureHandler() {
        setShouldCancelWhenOutside(false);
    }

    /* access modifiers changed from: protected */
    public void onHandle(MotionEvent motionEvent) {
        int state = getState();
        if (state == 0) {
            this.mLastVelocity = 0.0d;
            this.mLastRotation = 0.0d;
            this.mRotationGestureDetector = new RotationGestureDetector(this.mGestureListener);
            begin();
        }
        RotationGestureDetector rotationGestureDetector = this.mRotationGestureDetector;
        if (rotationGestureDetector != null) {
            rotationGestureDetector.onTouchEvent(motionEvent);
        }
        if (motionEvent.getActionMasked() != 1) {
            return;
        }
        if (state == 4) {
            end();
        } else {
            fail();
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        this.mRotationGestureDetector = null;
        this.mLastVelocity = 0.0d;
        this.mLastRotation = 0.0d;
    }

    public double getRotation() {
        return this.mLastRotation;
    }

    public double getVelocity() {
        return this.mLastVelocity;
    }

    public float getAnchorX() {
        RotationGestureDetector rotationGestureDetector = this.mRotationGestureDetector;
        if (rotationGestureDetector == null) {
            return Float.NaN;
        }
        return rotationGestureDetector.getAnchorX();
    }

    public float getAnchorY() {
        RotationGestureDetector rotationGestureDetector = this.mRotationGestureDetector;
        if (rotationGestureDetector == null) {
            return Float.NaN;
        }
        return rotationGestureDetector.getAnchorY();
    }
}
