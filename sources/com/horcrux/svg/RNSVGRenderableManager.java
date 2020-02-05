package com.horcrux.svg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Region;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nonnull;

class RNSVGRenderableManager extends ReactContextBaseJavaModule {
    @Nonnull
    public String getName() {
        return "RNSVGRenderableManager";
    }

    RNSVGRenderableManager(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isPointInFill(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return false;
        }
        float f = renderableViewByTag.mScale;
        if (renderableViewByTag.hitTest(new float[]{((float) readableMap.getDouble("x")) * f, ((float) readableMap.getDouble("y")) * f}) != -1) {
            return true;
        }
        return false;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isPointInStroke(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return false;
        }
        renderableViewByTag.getPath((Canvas) null, (Paint) null);
        renderableViewByTag.initBounds();
        float f = renderableViewByTag.mScale;
        double d = readableMap.getDouble("x");
        double d2 = (double) f;
        Double.isNaN(d2);
        int i2 = (int) (d * d2);
        double d3 = readableMap.getDouble("y");
        Double.isNaN(d2);
        int i3 = (int) (d3 * d2);
        Region region = renderableViewByTag.mStrokeRegion;
        if (region == null || !region.contains(i2, i3)) {
            return false;
        }
        return true;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public float getTotalLength(int i) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return 0.0f;
        }
        return new PathMeasure(renderableViewByTag.getPath((Canvas) null, (Paint) null), false).getLength() / renderableViewByTag.mScale;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getPointAtLength(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return null;
        }
        PathMeasure pathMeasure = new PathMeasure(renderableViewByTag.getPath((Canvas) null, (Paint) null), false);
        float f = (float) readableMap.getDouble("length");
        float f2 = renderableViewByTag.mScale;
        float[] fArr = new float[2];
        float[] fArr2 = new float[2];
        pathMeasure.getPosTan(Math.max(0.0f, Math.min(f, pathMeasure.getLength())), fArr, fArr2);
        double atan2 = Math.atan2((double) fArr2[1], (double) fArr2[0]);
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", (double) (fArr[0] / f2));
        createMap.putDouble("y", (double) (fArr[1] / f2));
        createMap.putDouble("angle", atan2);
        return createMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getBBox(int i, ReadableMap readableMap) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return null;
        }
        boolean z = readableMap.getBoolean("fill");
        boolean z2 = readableMap.getBoolean("stroke");
        boolean z3 = readableMap.getBoolean("markers");
        boolean z4 = readableMap.getBoolean("clipped");
        renderableViewByTag.getPath((Canvas) null, (Paint) null);
        float f = renderableViewByTag.mScale;
        renderableViewByTag.initBounds();
        RectF rectF = new RectF();
        if (z) {
            rectF.union(renderableViewByTag.mFillBounds);
        }
        if (z2) {
            rectF.union(renderableViewByTag.mStrokeBounds);
        }
        if (z3) {
            rectF.union(renderableViewByTag.mMarkerBounds);
        }
        if (z4 && renderableViewByTag.mClipBounds != null) {
            rectF.intersect(renderableViewByTag.mClipBounds);
        }
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("x", (double) (rectF.left / f));
        createMap.putDouble("y", (double) (rectF.top / f));
        createMap.putDouble("width", (double) (rectF.width() / f));
        createMap.putDouble("height", (double) (rectF.height() / f));
        return createMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getCTM(int i) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return null;
        }
        float f = renderableViewByTag.mScale;
        Matrix matrix = new Matrix(renderableViewByTag.mCTM);
        matrix.preConcat(renderableViewByTag.getSvgView().mInvViewBoxMatrix);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("a", (double) fArr[0]);
        createMap.putDouble("b", (double) fArr[3]);
        createMap.putDouble("c", (double) fArr[1]);
        createMap.putDouble("d", (double) fArr[4]);
        createMap.putDouble("e", (double) (fArr[2] / f));
        createMap.putDouble("f", (double) (fArr[5] / f));
        return createMap;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getScreenCTM(int i) {
        RenderableView renderableViewByTag = RenderableViewManager.getRenderableViewByTag(i);
        if (renderableViewByTag == null) {
            return null;
        }
        float[] fArr = new float[9];
        renderableViewByTag.mCTM.getValues(fArr);
        float f = renderableViewByTag.mScale;
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("a", (double) fArr[0]);
        createMap.putDouble("b", (double) fArr[3]);
        createMap.putDouble("c", (double) fArr[1]);
        createMap.putDouble("d", (double) fArr[4]);
        createMap.putDouble("e", (double) (fArr[2] / f));
        createMap.putDouble("f", (double) (fArr[5] / f));
        return createMap;
    }
}
