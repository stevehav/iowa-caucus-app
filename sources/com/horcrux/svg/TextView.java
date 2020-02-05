package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.TextProperties;
import java.util.ArrayList;
import javax.annotation.Nullable;

@SuppressLint({"ViewConstructor"})
class TextView extends GroupView {
    double cachedAdvance = Double.NaN;
    private TextProperties.AlignmentBaseline mAlignmentBaseline;
    private String mBaselineShift = null;
    @Nullable
    private ArrayList<SVGLength> mDeltaX;
    @Nullable
    private ArrayList<SVGLength> mDeltaY;
    SVGLength mInlineSize = null;
    TextProperties.TextLengthAdjust mLengthAdjust = TextProperties.TextLengthAdjust.spacing;
    @Nullable
    private ArrayList<SVGLength> mPositionX;
    @Nullable
    private ArrayList<SVGLength> mPositionY;
    @Nullable
    private ArrayList<SVGLength> mRotate;
    SVGLength mTextLength = null;

    public TextView(ReactContext reactContext) {
        super(reactContext);
    }

    public void invalidate() {
        if (this.mPath != null) {
            super.invalidate();
            getTextContainer().clearChildCache();
        }
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.cachedAdvance = Double.NaN;
        super.clearCache();
    }

    @ReactProp(name = "inlineSize")
    public void setInlineSize(Dynamic dynamic) {
        this.mInlineSize = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "textLength")
    public void setTextLength(Dynamic dynamic) {
        this.mTextLength = SVGLength.from(dynamic);
        invalidate();
    }

    @ReactProp(name = "lengthAdjust")
    public void setLengthAdjust(@Nullable String str) {
        this.mLengthAdjust = TextProperties.TextLengthAdjust.valueOf(str);
        invalidate();
    }

    @ReactProp(name = "alignmentBaseline")
    public void setMethod(@Nullable String str) {
        this.mAlignmentBaseline = TextProperties.AlignmentBaseline.getEnum(str);
        invalidate();
    }

    @ReactProp(name = "baselineShift")
    public void setBaselineShift(Dynamic dynamic) {
        this.mBaselineShift = SVGLength.toString(dynamic);
        invalidate();
    }

    @ReactProp(name = "verticalAlign")
    public void setVerticalAlign(@Nullable String str) {
        if (str != null) {
            String trim = str.trim();
            int lastIndexOf = trim.lastIndexOf(32);
            try {
                this.mAlignmentBaseline = TextProperties.AlignmentBaseline.getEnum(trim.substring(lastIndexOf));
            } catch (IllegalArgumentException unused) {
                this.mAlignmentBaseline = TextProperties.AlignmentBaseline.baseline;
            }
            try {
                this.mBaselineShift = trim.substring(0, lastIndexOf);
            } catch (IndexOutOfBoundsException unused2) {
                this.mBaselineShift = null;
            }
        } else {
            this.mAlignmentBaseline = TextProperties.AlignmentBaseline.baseline;
            this.mBaselineShift = null;
        }
        invalidate();
    }

    @ReactProp(name = "rotate")
    public void setRotate(Dynamic dynamic) {
        this.mRotate = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    @ReactProp(name = "dx")
    public void setDeltaX(Dynamic dynamic) {
        this.mDeltaX = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    @ReactProp(name = "dy")
    public void setDeltaY(Dynamic dynamic) {
        this.mDeltaY = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    @ReactProp(name = "x")
    public void setPositionX(Dynamic dynamic) {
        this.mPositionX = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    @ReactProp(name = "y")
    public void setPositionY(Dynamic dynamic) {
        this.mPositionY = SVGLength.arrayFrom(dynamic);
        invalidate();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        if (f > 0.01f) {
            setupGlyphContext(canvas);
            clip(canvas, paint);
            getGroupPath(canvas, paint);
            pushGlyphContext();
            drawGroup(canvas, paint, f);
            popGlyphContext();
        }
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        setupGlyphContext(canvas);
        return getGroupPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint, Region.Op op) {
        return getPath(canvas, paint);
    }

    /* access modifiers changed from: package-private */
    public TextProperties.AlignmentBaseline getAlignmentBaseline() {
        TextProperties.AlignmentBaseline alignmentBaseline;
        if (this.mAlignmentBaseline == null) {
            ViewParent parent = getParent();
            while (parent != null) {
                if (!(parent instanceof TextView) || (alignmentBaseline = ((TextView) parent).mAlignmentBaseline) == null) {
                    parent = parent.getParent();
                } else {
                    this.mAlignmentBaseline = alignmentBaseline;
                    return alignmentBaseline;
                }
            }
        }
        if (this.mAlignmentBaseline == null) {
            this.mAlignmentBaseline = TextProperties.AlignmentBaseline.baseline;
        }
        return this.mAlignmentBaseline;
    }

    /* access modifiers changed from: package-private */
    public String getBaselineShift() {
        String str;
        if (this.mBaselineShift == null) {
            ViewParent parent = getParent();
            while (parent != null) {
                if (!(parent instanceof TextView) || (str = ((TextView) parent).mBaselineShift) == null) {
                    parent = parent.getParent();
                } else {
                    this.mBaselineShift = str;
                    return str;
                }
            }
        }
        return this.mBaselineShift;
    }

    /* access modifiers changed from: package-private */
    public Path getGroupPath(Canvas canvas, Paint paint) {
        if (this.mPath != null) {
            return this.mPath;
        }
        pushGlyphContext();
        this.mPath = super.getPath(canvas, paint);
        popGlyphContext();
        return this.mPath;
    }

    /* access modifiers changed from: package-private */
    public void pushGlyphContext() {
        getTextRootGlyphContext().pushContext(!(this instanceof TextPathView) && !(this instanceof TSpanView), this, this.mFont, this.mPositionX, this.mPositionY, this.mDeltaX, this.mDeltaY, this.mRotate);
    }

    /* access modifiers changed from: package-private */
    public TextView getTextAnchorRoot() {
        ArrayList<FontData> arrayList = getTextRootGlyphContext().mFontContext;
        ViewParent parent = getParent();
        int size = arrayList.size() - 1;
        ViewParent viewParent = parent;
        TextView textView = this;
        while (size >= 0 && (viewParent instanceof TextView) && arrayList.get(size).textAnchor != TextProperties.TextAnchor.start && textView.mPositionX == null) {
            textView = viewParent;
            viewParent = textView.getParent();
            size--;
        }
        return textView;
    }

    /* access modifiers changed from: package-private */
    public double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        double d = 0.0d;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TextView) {
                d += ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint);
            }
        }
        this.cachedAdvance = d;
        return d;
    }

    /* access modifiers changed from: package-private */
    public TextView getTextContainer() {
        TextView textView = this;
        ViewParent viewParent = getParent();
        while (viewParent instanceof TextView) {
            textView = (TextView) viewParent;
            viewParent = textView.getParent();
        }
        return textView;
    }
}
