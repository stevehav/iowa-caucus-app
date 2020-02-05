package com.swmansion.gesturehandler.react;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewGroup;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> {
    public String getName() {
        return "RNGestureHandlerButton";
    }

    static class ButtonViewGroup extends ViewGroup {
        static TypedValue sResolveOutValue = new TypedValue();
        static ButtonViewGroup sResponder;
        int mBackgroundColor = 0;
        float mBorderRadius = 0.0f;
        boolean mNeedBackgroundUpdate = false;
        Integer mRippleColor;
        boolean mUseBorderless = false;
        boolean mUseForeground = false;

        public void dispatchDrawableHotspotChanged(float f, float f2) {
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public ButtonViewGroup(Context context) {
            super(context);
            setClickable(true);
            setFocusable(true);
            this.mNeedBackgroundUpdate = true;
        }

        public void setBackgroundColor(int i) {
            this.mBackgroundColor = i;
            this.mNeedBackgroundUpdate = true;
        }

        public void setRippleColor(Integer num) {
            this.mRippleColor = num;
            this.mNeedBackgroundUpdate = true;
        }

        public void setBorderRadius(float f) {
            this.mBorderRadius = f * getResources().getDisplayMetrics().density;
            this.mNeedBackgroundUpdate = true;
        }

        private Drawable applyRippleEffectWhenNeeded(Drawable drawable) {
            if (this.mRippleColor != null && drawable != null && Build.VERSION.SDK_INT >= 21 && (drawable instanceof RippleDrawable)) {
                ((RippleDrawable) drawable).setColor(new ColorStateList(new int[][]{new int[]{16842910}}, new int[]{this.mRippleColor.intValue()}));
            }
            return drawable;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            onTouchEvent(motionEvent);
            if (isPressed()) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public void updateBackground() {
            if (this.mNeedBackgroundUpdate) {
                this.mNeedBackgroundUpdate = false;
                if (this.mBackgroundColor == 0) {
                    setBackground((Drawable) null);
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    setForeground((Drawable) null);
                }
                if (this.mUseForeground && Build.VERSION.SDK_INT >= 23) {
                    setForeground(applyRippleEffectWhenNeeded(createSelectableDrawable()));
                    int i = this.mBackgroundColor;
                    if (i != 0) {
                        setBackgroundColor(i);
                    }
                } else if (this.mBackgroundColor == 0 && this.mRippleColor == null) {
                    setBackground(createSelectableDrawable());
                } else {
                    PaintDrawable paintDrawable = new PaintDrawable(this.mBackgroundColor);
                    Drawable createSelectableDrawable = createSelectableDrawable();
                    float f = this.mBorderRadius;
                    if (f != 0.0f) {
                        paintDrawable.setCornerRadius(f);
                        if (Build.VERSION.SDK_INT >= 21 && (createSelectableDrawable instanceof RippleDrawable)) {
                            PaintDrawable paintDrawable2 = new PaintDrawable(-1);
                            paintDrawable2.setCornerRadius(this.mBorderRadius);
                            ((RippleDrawable) createSelectableDrawable).setDrawableByLayerId(16908334, paintDrawable2);
                        }
                    }
                    applyRippleEffectWhenNeeded(createSelectableDrawable);
                    setBackground(new LayerDrawable(new Drawable[]{paintDrawable, createSelectableDrawable}));
                }
            }
        }

        public void setUseDrawableOnForeground(boolean z) {
            this.mUseForeground = z;
            this.mNeedBackgroundUpdate = true;
        }

        public void setUseBorderlessDrawable(boolean z) {
            this.mUseBorderless = z;
        }

        private Drawable createSelectableDrawable() {
            int i = Build.VERSION.SDK_INT;
            getContext().getTheme().resolveAttribute(getResources().getIdentifier((!this.mUseBorderless || i < 21) ? "selectableItemBackground" : "selectableItemBackgroundBorderless", "attr", "android"), sResolveOutValue, true);
            if (i >= 21) {
                return getResources().getDrawable(sResolveOutValue.resourceId, getContext().getTheme());
            }
            return getResources().getDrawable(sResolveOutValue.resourceId);
        }

        public void drawableHotspotChanged(float f, float f2) {
            ButtonViewGroup buttonViewGroup = sResponder;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(f, f2);
            }
        }

        public void setPressed(boolean z) {
            if (z && sResponder == null) {
                sResponder = this;
            }
            if (!z || sResponder == this) {
                super.setPressed(z);
            }
            if (!z && sResponder == this) {
                sResponder = null;
            }
        }
    }

    public ButtonViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        return new ButtonViewGroup(themedReactContext);
    }

    @ReactProp(name = "foreground")
    @TargetApi(23)
    public void setForeground(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.setUseDrawableOnForeground(z);
    }

    @ReactProp(name = "borderless")
    public void setBorderless(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.setUseBorderlessDrawable(z);
    }

    @ReactProp(name = "enabled")
    public void setEnabled(ButtonViewGroup buttonViewGroup, boolean z) {
        buttonViewGroup.setEnabled(z);
    }

    @ReactProp(name = "borderRadius")
    public void setBorderRadius(ButtonViewGroup buttonViewGroup, float f) {
        buttonViewGroup.setBorderRadius(f);
    }

    @ReactProp(name = "rippleColor")
    public void setRippleColor(ButtonViewGroup buttonViewGroup, Integer num) {
        buttonViewGroup.setRippleColor(num);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ButtonViewGroup buttonViewGroup) {
        buttonViewGroup.updateBackground();
    }
}
