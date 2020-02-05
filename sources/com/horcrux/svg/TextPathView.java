package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.TextProperties;
import javax.annotation.Nullable;

@SuppressLint({"ViewConstructor"})
class TextPathView extends TextView {
    private String mHref;
    private TextProperties.TextPathMethod mMethod = TextProperties.TextPathMethod.align;
    private TextProperties.TextPathMidLine mMidLine;
    private TextProperties.TextPathSide mSide;
    private TextProperties.TextPathSpacing mSpacing = TextProperties.TextPathSpacing.exact;
    @Nullable
    private SVGLength mStartOffset;

    /* access modifiers changed from: package-private */
    public void popGlyphContext() {
    }

    /* access modifiers changed from: package-private */
    public void pushGlyphContext() {
    }

    public TextPathView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "href")
    public void setHref(String str) {
        this.mHref = str;
        invalidate();
    }

    @ReactProp(name = "startOffset")
    public void setStartOffset(Dynamic dynamic) {
        this.mStartOffset = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "method")
    public void setMethod(@Nullable String str) {
        this.mMethod = TextProperties.TextPathMethod.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "spacing")
    public void setSpacing(@Nullable String str) {
        this.mSpacing = TextProperties.TextPathSpacing.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "side")
    public void setSide(@Nullable String str) {
        this.mSide = TextProperties.TextPathSide.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "midLine")
    public void setSharp(@Nullable String str) {
        this.mMidLine = TextProperties.TextPathMidLine.valueOf(str);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public TextProperties.TextPathMethod getMethod() {
        return this.mMethod;
    }

    /* access modifiers changed from: package-private */
    public TextProperties.TextPathSpacing getSpacing() {
        return this.mSpacing;
    }

    /* access modifiers changed from: package-private */
    public TextProperties.TextPathSide getSide() {
        return this.mSide;
    }

    /* access modifiers changed from: package-private */
    public TextProperties.TextPathMidLine getMidLine() {
        return this.mMidLine;
    }

    /* access modifiers changed from: package-private */
    public SVGLength getStartOffset() {
        return this.mStartOffset;
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        drawGroup(canvas, paint, f);
    }

    /* access modifiers changed from: package-private */
    public Path getTextPath(Canvas canvas, Paint paint) {
        VirtualView definedTemplate = getSvgView().getDefinedTemplate(this.mHref);
        if (!(definedTemplate instanceof RenderableView)) {
            return null;
        }
        return ((RenderableView) definedTemplate).getPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        return getGroupPath(canvas, paint);
    }
}
