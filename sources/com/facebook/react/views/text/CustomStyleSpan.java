package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomStyleSpan extends MetricAffectingSpan implements ReactSpan {
    private final AssetManager mAssetManager;
    @Nullable
    private final String mFontFamily;
    private final int mStyle;
    private final int mWeight;

    public CustomStyleSpan(int i, int i2, @Nullable String str, @NonNull AssetManager assetManager) {
        this.mStyle = i;
        this.mWeight = i2;
        this.mFontFamily = str;
        this.mAssetManager = assetManager;
    }

    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint, this.mStyle, this.mWeight, this.mFontFamily, this.mAssetManager);
    }

    public void updateMeasureState(@NonNull TextPaint textPaint) {
        apply(textPaint, this.mStyle, this.mWeight, this.mFontFamily, this.mAssetManager);
    }

    public int getStyle() {
        int i = this.mStyle;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    public int getWeight() {
        int i = this.mWeight;
        if (i == -1) {
            return 0;
        }
        return i;
    }

    @Nullable
    public String getFontFamily() {
        return this.mFontFamily;
    }

    private static void apply(Paint paint, int i, int i2, @Nullable String str, AssetManager assetManager) {
        int i3;
        Typeface typeface = paint.getTypeface();
        int i4 = 0;
        if (typeface == null) {
            i3 = 0;
        } else {
            i3 = typeface.getStyle();
        }
        if (i2 == 1 || ((i3 & 1) != 0 && i2 == -1)) {
            i4 = 1;
        }
        if (i == 2 || ((i3 & 2) != 0 && i == -1)) {
            i4 |= 2;
        }
        if (str != null) {
            typeface = ReactFontManager.getInstance().getTypeface(str, i4, i2, assetManager);
        } else if (typeface != null) {
            typeface = Typeface.create(typeface, i4);
        }
        if (typeface != null) {
            paint.setTypeface(typeface);
        } else {
            paint.setTypeface(Typeface.defaultFromStyle(i4));
        }
        paint.setSubpixelText(true);
    }
}
