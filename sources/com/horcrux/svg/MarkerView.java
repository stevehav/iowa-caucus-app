package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

@SuppressLint({"ViewConstructor"})
class MarkerView extends GroupView {
    String mAlign;
    private SVGLength mMarkerHeight;
    private String mMarkerUnits;
    private SVGLength mMarkerWidth;
    int mMeetOrSlice;
    private float mMinX;
    private float mMinY;
    private String mOrient;
    private SVGLength mRefX;
    private SVGLength mRefY;
    private float mVbHeight;
    private float mVbWidth;
    Matrix markerTransform = new Matrix();

    public MarkerView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "refX")
    public void setRefX(Dynamic dynamic) {
        this.mRefX = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "refY")
    public void setRefY(Dynamic dynamic) {
        this.mRefY = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "markerWidth")
    public void setMarkerWidth(Dynamic dynamic) {
        this.mMarkerWidth = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "markerHeight")
    public void setMarkerHeight(Dynamic dynamic) {
        this.mMarkerHeight = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "markerUnits")
    public void setMarkerUnits(String str) {
        this.mMarkerUnits = str;
        invalidate();
    }

    @ReactProp(name = "orient")
    public void setOrient(String str) {
        this.mOrient = str;
        invalidate();
    }

    @ReactProp(name = "minX")
    public void setMinX(float f) {
        this.mMinX = f;
        invalidate();
    }

    @ReactProp(name = "minY")
    public void setMinY(float f) {
        this.mMinY = f;
        invalidate();
    }

    @ReactProp(name = "vbWidth")
    public void setVbWidth(float f) {
        this.mVbWidth = f;
        invalidate();
    }

    @ReactProp(name = "vbHeight")
    public void setVbHeight(float f) {
        this.mVbHeight = f;
        invalidate();
    }

    @ReactProp(name = "align")
    public void setAlign(String str) {
        this.mAlign = str;
        invalidate();
    }

    @ReactProp(name = "meetOrSlice")
    public void setMeetOrSlice(int i) {
        this.mMeetOrSlice = i;
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void saveDefinition() {
        if (this.mName != null) {
            getSvgView().defineMarker(this, this.mName);
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof VirtualView) {
                    ((VirtualView) childAt).saveDefinition();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void renderMarker(Canvas canvas, Paint paint, float f, RNSVGMarkerPosition rNSVGMarkerPosition, float f2) {
        int saveAndSetupCanvas = saveAndSetupCanvas(canvas, this.mCTM);
        this.markerTransform.reset();
        Point point = rNSVGMarkerPosition.origin;
        this.markerTransform.setTranslate(((float) point.x) * this.mScale, ((float) point.y) * this.mScale);
        double parseDouble = "auto".equals(this.mOrient) ? -1.0d : Double.parseDouble(this.mOrient);
        if (parseDouble == -1.0d) {
            parseDouble = rNSVGMarkerPosition.angle;
        }
        this.markerTransform.preRotate(((float) parseDouble) + 180.0f);
        if ("strokeWidth".equals(this.mMarkerUnits)) {
            this.markerTransform.preScale(f2, f2);
        }
        double relativeOnWidth = relativeOnWidth(this.mMarkerWidth);
        double d = (double) this.mScale;
        Double.isNaN(d);
        double d2 = relativeOnWidth / d;
        double relativeOnHeight = relativeOnHeight(this.mMarkerHeight);
        double d3 = (double) this.mScale;
        Double.isNaN(d3);
        RectF rectF = new RectF(0.0f, 0.0f, (float) d2, (float) (relativeOnHeight / d3));
        if (this.mAlign != null) {
            float[] fArr = new float[9];
            ViewBox.getTransform(new RectF(this.mMinX * this.mScale, this.mMinY * this.mScale, (this.mMinX + this.mVbWidth) * this.mScale, (this.mMinY + this.mVbHeight) * this.mScale), rectF, this.mAlign, this.mMeetOrSlice).getValues(fArr);
            this.markerTransform.preScale(fArr[0], fArr[4]);
        }
        this.markerTransform.preTranslate((float) (-relativeOnWidth(this.mRefX)), (float) (-relativeOnHeight(this.mRefY)));
        canvas.concat(this.markerTransform);
        drawGroup(canvas, paint, f);
        restoreCanvas(canvas, saveAndSetupCanvas);
    }
}
