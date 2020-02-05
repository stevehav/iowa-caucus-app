package com.facebook.react.views.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.modules.i18nmanager.I18nUtil;
import com.facebook.react.touch.OnInterceptTouchEventListener;
import com.facebook.react.touch.ReactHitSlopView;
import com.facebook.react.touch.ReactInterceptingViewGroup;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.MeasureSpecAssertions;
import com.facebook.react.uimanager.PointerEvents;
import com.facebook.react.uimanager.ReactClippingViewGroup;
import com.facebook.react.uimanager.ReactClippingViewGroupHelper;
import com.facebook.react.uimanager.ReactPointerEventsView;
import com.facebook.react.uimanager.ReactZIndexedViewGroup;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.RootViewUtil;
import com.facebook.react.uimanager.ViewGroupDrawingOrderHelper;
import com.facebook.react.uimanager.ViewProps;

public class ReactViewGroup extends ViewGroup implements ReactInterceptingViewGroup, ReactClippingViewGroup, ReactPointerEventsView, ReactHitSlopView, ReactZIndexedViewGroup {
    private static final int ARRAY_CAPACITY_INCREMENT = 12;
    private static final int DEFAULT_BACKGROUND_COLOR = 0;
    private static final ViewGroup.LayoutParams sDefaultLayoutParam = new ViewGroup.LayoutParams(0, 0);
    private static final Rect sHelperRect = new Rect();
    @Nullable
    private View[] mAllChildren = null;
    private int mAllChildrenCount;
    private float mBackfaceOpacity = 1.0f;
    private String mBackfaceVisibility = ViewProps.VISIBLE;
    @Nullable
    private ChildrenLayoutChangeListener mChildrenLayoutChangeListener;
    @Nullable
    private Rect mClippingRect;
    private final ViewGroupDrawingOrderHelper mDrawingOrderHelper;
    @Nullable
    private Rect mHitSlopRect;
    private int mLayoutDirection;
    private boolean mNeedsOffscreenAlphaCompositing = false;
    @Nullable
    private OnInterceptTouchEventListener mOnInterceptTouchEventListener;
    @Nullable
    private String mOverflow;
    @Nullable
    private Path mPath;
    private PointerEvents mPointerEvents = PointerEvents.AUTO;
    @Nullable
    private ReactViewBackgroundDrawable mReactBackgroundDrawable;
    private boolean mRemoveClippedSubviews = false;

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void requestLayout() {
    }

    private static final class ChildrenLayoutChangeListener implements View.OnLayoutChangeListener {
        private final ReactViewGroup mParent;

        private ChildrenLayoutChangeListener(ReactViewGroup reactViewGroup) {
            this.mParent = reactViewGroup;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (this.mParent.getRemoveClippedSubviews()) {
                this.mParent.updateSubviewClipStatus(view);
            }
        }
    }

    public ReactViewGroup(Context context) {
        super(context);
        setClipChildren(false);
        this.mDrawingOrderHelper = new ViewGroupDrawingOrderHelper(this);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        MeasureSpecAssertions.assertExplicitMeasureSpec(i, i2);
        setMeasuredDimension(View.MeasureSpec.getSize(i), View.MeasureSpec.getSize(i2));
    }

    public void onRtlPropertiesChanged(int i) {
        ReactViewBackgroundDrawable reactViewBackgroundDrawable;
        if (Build.VERSION.SDK_INT >= 17 && (reactViewBackgroundDrawable = this.mReactBackgroundDrawable) != null) {
            reactViewBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
        }
    }

    @TargetApi(23)
    public void dispatchProvideStructure(ViewStructure viewStructure) {
        try {
            super.dispatchProvideStructure(viewStructure);
        } catch (NullPointerException e) {
            FLog.e(ReactConstants.TAG, "NullPointerException when executing dispatchProvideStructure", (Throwable) e);
        }
    }

    public void setBackgroundColor(int i) {
        if (i != 0 || this.mReactBackgroundDrawable != null) {
            getOrCreateReactViewBackground().setColor(i);
        }
    }

    public void setBackground(Drawable drawable) {
        throw new UnsupportedOperationException("This method is not supported for ReactViewGroup instances");
    }

    public void setTranslucentBackgroundDrawable(@Nullable Drawable drawable) {
        updateBackgroundDrawable((Drawable) null);
        ReactViewBackgroundDrawable reactViewBackgroundDrawable = this.mReactBackgroundDrawable;
        if (reactViewBackgroundDrawable != null && drawable != null) {
            updateBackgroundDrawable(new LayerDrawable(new Drawable[]{reactViewBackgroundDrawable, drawable}));
        } else if (drawable != null) {
            updateBackgroundDrawable(drawable);
        }
    }

    public void setOnInterceptTouchEventListener(OnInterceptTouchEventListener onInterceptTouchEventListener) {
        this.mOnInterceptTouchEventListener = onInterceptTouchEventListener;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        OnInterceptTouchEventListener onInterceptTouchEventListener = this.mOnInterceptTouchEventListener;
        if ((onInterceptTouchEventListener != null && onInterceptTouchEventListener.onInterceptTouchEvent(this, motionEvent)) || this.mPointerEvents == PointerEvents.NONE || this.mPointerEvents == PointerEvents.BOX_ONLY) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.mPointerEvents == PointerEvents.NONE || this.mPointerEvents == PointerEvents.BOX_NONE) ? false : true;
    }

    public boolean hasOverlappingRendering() {
        return this.mNeedsOffscreenAlphaCompositing;
    }

    public void setNeedsOffscreenAlphaCompositing(boolean z) {
        this.mNeedsOffscreenAlphaCompositing = z;
    }

    public void setBorderWidth(int i, float f) {
        getOrCreateReactViewBackground().setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        getOrCreateReactViewBackground().setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
        orCreateReactViewBackground.setRadius(f);
        if (Build.VERSION.SDK_INT < 18) {
            int i = orCreateReactViewBackground.hasRoundedBorders() ? 1 : 2;
            if (i != getLayerType()) {
                setLayerType(i, (Paint) null);
            }
        }
    }

    public void setBorderRadius(float f, int i) {
        ReactViewBackgroundDrawable orCreateReactViewBackground = getOrCreateReactViewBackground();
        orCreateReactViewBackground.setRadius(f, i);
        if (Build.VERSION.SDK_INT < 18) {
            int i2 = orCreateReactViewBackground.hasRoundedBorders() ? 1 : 2;
            if (i2 != getLayerType()) {
                setLayerType(i2, (Paint) null);
            }
        }
    }

    public void setBorderStyle(@Nullable String str) {
        getOrCreateReactViewBackground().setBorderStyle(str);
    }

    public void setRemoveClippedSubviews(boolean z) {
        if (z != this.mRemoveClippedSubviews) {
            this.mRemoveClippedSubviews = z;
            if (z) {
                this.mClippingRect = new Rect();
                ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
                this.mAllChildrenCount = getChildCount();
                this.mAllChildren = new View[Math.max(12, this.mAllChildrenCount)];
                this.mChildrenLayoutChangeListener = new ChildrenLayoutChangeListener();
                for (int i = 0; i < this.mAllChildrenCount; i++) {
                    View childAt = getChildAt(i);
                    this.mAllChildren[i] = childAt;
                    childAt.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
                }
                updateClippingRect();
                return;
            }
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            Assertions.assertNotNull(this.mChildrenLayoutChangeListener);
            for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                this.mAllChildren[i2].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
            }
            getDrawingRect(this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
            this.mAllChildren = null;
            this.mClippingRect = null;
            this.mAllChildrenCount = 0;
            this.mChildrenLayoutChangeListener = null;
        }
    }

    public boolean getRemoveClippedSubviews() {
        return this.mRemoveClippedSubviews;
    }

    public void getClippingRect(Rect rect) {
        rect.set(this.mClippingRect);
    }

    public void updateClippingRect() {
        if (this.mRemoveClippedSubviews) {
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            ReactClippingViewGroupHelper.calculateClippingRect(this, this.mClippingRect);
            updateClippingToRect(this.mClippingRect);
        }
    }

    private void updateClippingToRect(Rect rect) {
        Assertions.assertNotNull(this.mAllChildren);
        int i = 0;
        for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
            updateSubviewClipStatus(rect, i2, i);
            if (this.mAllChildren[i2].getParent() == null) {
                i++;
            }
        }
    }

    private void updateSubviewClipStatus(Rect rect, int i, int i2) {
        View view = ((View[]) Assertions.assertNotNull(this.mAllChildren))[i];
        sHelperRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        boolean intersects = rect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom);
        Animation animation = view.getAnimation();
        boolean z = true;
        boolean z2 = animation != null && !animation.hasEnded();
        if (!intersects && view.getParent() != null && !z2) {
            super.removeViewsInLayout(i - i2, 1);
        } else if (intersects && view.getParent() == null) {
            super.addViewInLayout(view, i - i2, sDefaultLayoutParam, true);
            invalidate();
        } else if (!intersects) {
            z = false;
        }
        if (z && (view instanceof ReactClippingViewGroup)) {
            ReactClippingViewGroup reactClippingViewGroup = (ReactClippingViewGroup) view;
            if (reactClippingViewGroup.getRemoveClippedSubviews()) {
                reactClippingViewGroup.updateClippingRect();
            }
        }
    }

    /* access modifiers changed from: private */
    public void updateSubviewClipStatus(View view) {
        if (this.mRemoveClippedSubviews && getParent() != null) {
            Assertions.assertNotNull(this.mClippingRect);
            Assertions.assertNotNull(this.mAllChildren);
            sHelperRect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            if (this.mClippingRect.intersects(sHelperRect.left, sHelperRect.top, sHelperRect.right, sHelperRect.bottom) != (view.getParent() != null)) {
                int i = 0;
                for (int i2 = 0; i2 < this.mAllChildrenCount; i2++) {
                    View[] viewArr = this.mAllChildren;
                    if (viewArr[i2] == view) {
                        updateSubviewClipStatus(this.mClippingRect, i2, i);
                        return;
                    }
                    if (viewArr[i2].getParent() == null) {
                        i++;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mRemoveClippedSubviews) {
            updateClippingRect();
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        this.mDrawingOrderHelper.handleAddView(view);
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        super.addView(view, i, layoutParams);
    }

    public void removeView(View view) {
        this.mDrawingOrderHelper.handleRemoveView(view);
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        super.removeView(view);
    }

    public void removeViewAt(int i) {
        this.mDrawingOrderHelper.handleRemoveView(getChildAt(i));
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        super.removeViewAt(i);
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i, int i2) {
        return this.mDrawingOrderHelper.getChildDrawingOrder(i, i2);
    }

    public int getZIndexMappedChildIndex(int i) {
        return this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder() ? this.mDrawingOrderHelper.getChildDrawingOrder(getChildCount(), i) : i;
    }

    public void updateDrawingOrder() {
        this.mDrawingOrderHelper.update();
        setChildrenDrawingOrderEnabled(this.mDrawingOrderHelper.shouldEnableCustomDrawingOrder());
        invalidate();
    }

    public PointerEvents getPointerEvents() {
        return this.mPointerEvents;
    }

    /* access modifiers changed from: package-private */
    public void setPointerEvents(PointerEvents pointerEvents) {
        this.mPointerEvents = pointerEvents;
    }

    /* access modifiers changed from: package-private */
    public int getAllChildrenCount() {
        return this.mAllChildrenCount;
    }

    /* access modifiers changed from: package-private */
    public View getChildAtWithSubviewClippingEnabled(int i) {
        return ((View[]) Assertions.assertNotNull(this.mAllChildren))[i];
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(View view, int i) {
        addViewWithSubviewClippingEnabled(view, i, sDefaultLayoutParam);
    }

    /* access modifiers changed from: package-private */
    public void addViewWithSubviewClippingEnabled(View view, int i, ViewGroup.LayoutParams layoutParams) {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        addInArray(view, i);
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            if (this.mAllChildren[i3].getParent() == null) {
                i2++;
            }
        }
        updateSubviewClipStatus(this.mClippingRect, i, i2);
        view.addOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
    }

    /* access modifiers changed from: package-private */
    public void removeViewWithSubviewClippingEnabled(View view) {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mClippingRect);
        Assertions.assertNotNull(this.mAllChildren);
        view.removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        int indexOfChildInAllChildren = indexOfChildInAllChildren(view);
        if (this.mAllChildren[indexOfChildInAllChildren].getParent() != null) {
            int i = 0;
            for (int i2 = 0; i2 < indexOfChildInAllChildren; i2++) {
                if (this.mAllChildren[i2].getParent() == null) {
                    i++;
                }
            }
            super.removeViewsInLayout(indexOfChildInAllChildren - i, 1);
        }
        removeFromArray(indexOfChildInAllChildren);
    }

    /* access modifiers changed from: package-private */
    public void removeAllViewsWithSubviewClippingEnabled() {
        Assertions.assertCondition(this.mRemoveClippedSubviews);
        Assertions.assertNotNull(this.mAllChildren);
        for (int i = 0; i < this.mAllChildrenCount; i++) {
            this.mAllChildren[i].removeOnLayoutChangeListener(this.mChildrenLayoutChangeListener);
        }
        removeAllViewsInLayout();
        this.mAllChildrenCount = 0;
    }

    private int indexOfChildInAllChildren(View view) {
        int i = this.mAllChildrenCount;
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        for (int i2 = 0; i2 < i; i2++) {
            if (viewArr[i2] == view) {
                return i2;
            }
        }
        return -1;
    }

    private void addInArray(View view, int i) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i2 = this.mAllChildrenCount;
        int length = viewArr.length;
        if (i == i2) {
            if (length == i2) {
                this.mAllChildren = new View[(length + 12)];
                System.arraycopy(viewArr, 0, this.mAllChildren, 0, length);
                viewArr = this.mAllChildren;
            }
            int i3 = this.mAllChildrenCount;
            this.mAllChildrenCount = i3 + 1;
            viewArr[i3] = view;
        } else if (i < i2) {
            if (length == i2) {
                this.mAllChildren = new View[(length + 12)];
                System.arraycopy(viewArr, 0, this.mAllChildren, 0, i);
                System.arraycopy(viewArr, i, this.mAllChildren, i + 1, i2 - i);
                viewArr = this.mAllChildren;
            } else {
                System.arraycopy(viewArr, i, viewArr, i + 1, i2 - i);
            }
            viewArr[i] = view;
            this.mAllChildrenCount++;
        } else {
            throw new IndexOutOfBoundsException("index=" + i + " count=" + i2);
        }
    }

    private void removeFromArray(int i) {
        View[] viewArr = (View[]) Assertions.assertNotNull(this.mAllChildren);
        int i2 = this.mAllChildrenCount;
        if (i == i2 - 1) {
            int i3 = i2 - 1;
            this.mAllChildrenCount = i3;
            viewArr[i3] = null;
        } else if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException();
        } else {
            System.arraycopy(viewArr, i + 1, viewArr, i, (i2 - i) - 1);
            int i4 = this.mAllChildrenCount - 1;
            this.mAllChildrenCount = i4;
            viewArr[i4] = null;
        }
    }

    @VisibleForTesting
    public int getBackgroundColor() {
        if (getBackground() != null) {
            return ((ReactViewBackgroundDrawable) getBackground()).getColor();
        }
        return 0;
    }

    private ReactViewBackgroundDrawable getOrCreateReactViewBackground() {
        if (this.mReactBackgroundDrawable == null) {
            this.mReactBackgroundDrawable = new ReactViewBackgroundDrawable(getContext());
            Drawable background = getBackground();
            updateBackgroundDrawable((Drawable) null);
            if (background == null) {
                updateBackgroundDrawable(this.mReactBackgroundDrawable);
            } else {
                updateBackgroundDrawable(new LayerDrawable(new Drawable[]{this.mReactBackgroundDrawable, background}));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                this.mLayoutDirection = I18nUtil.getInstance().isRTL(getContext()) ? 1 : 0;
                this.mReactBackgroundDrawable.setResolvedLayoutDirection(this.mLayoutDirection);
            }
        }
        return this.mReactBackgroundDrawable;
    }

    @Nullable
    public Rect getHitSlopRect() {
        return this.mHitSlopRect;
    }

    public void setHitSlopRect(@Nullable Rect rect) {
        this.mHitSlopRect = rect;
    }

    public void setOverflow(String str) {
        this.mOverflow = str;
        invalidate();
    }

    @Nullable
    public String getOverflow() {
        return this.mOverflow;
    }

    private void updateBackgroundDrawable(Drawable drawable) {
        super.setBackground(drawable);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        try {
            dispatchOverflowDraw(canvas);
            super.dispatchDraw(canvas);
        } catch (NullPointerException e) {
            FLog.e(ReactConstants.TAG, "NullPointerException when executing ViewGroup.dispatchDraw method", (Throwable) e);
        } catch (StackOverflowError e2) {
            RootView rootView = RootViewUtil.getRootView(this);
            if (rootView != null) {
                rootView.handleException(e2);
            } else if (getContext() instanceof ReactContext) {
                ((ReactContext) getContext()).handleException(new IllegalViewOperationException("StackOverflowException", this, e2));
            } else {
                throw e2;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0136, code lost:
        if (com.facebook.yoga.YogaConstants.isUndefined(r10) == false) goto L_0x0138;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void dispatchOverflowDraw(android.graphics.Canvas r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            java.lang.String r2 = r0.mOverflow
            if (r2 == 0) goto L_0x01e5
            r3 = -1
            int r4 = r2.hashCode()
            r5 = -1217487446(0xffffffffb76e9daa, float:-1.42226145E-5)
            r7 = 1
            if (r4 == r5) goto L_0x0023
            r5 = 466743410(0x1bd1f072, float:3.4731534E-22)
            if (r4 == r5) goto L_0x0019
            goto L_0x002c
        L_0x0019:
            java.lang.String r4 = "visible"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x002c
            r3 = 0
            goto L_0x002c
        L_0x0023:
            java.lang.String r4 = "hidden"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x002c
            r3 = 1
        L_0x002c:
            if (r3 == 0) goto L_0x01de
            if (r3 == r7) goto L_0x0032
            goto L_0x01e5
        L_0x0032:
            int r2 = r19.getWidth()
            float r2 = (float) r2
            int r3 = r19.getHeight()
            float r3 = (float) r3
            com.facebook.react.views.view.ReactViewBackgroundDrawable r4 = r0.mReactBackgroundDrawable
            r5 = 0
            if (r4 == 0) goto L_0x01cd
            android.graphics.RectF r4 = r4.getDirectionAwareBorderInsets()
            float r8 = r4.top
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x0061
            float r8 = r4.left
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x0061
            float r8 = r4.bottom
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 > 0) goto L_0x0061
            float r8 = r4.right
            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r8 <= 0) goto L_0x005e
            goto L_0x0061
        L_0x005e:
            r8 = 0
            r9 = 0
            goto L_0x006d
        L_0x0061:
            float r8 = r4.left
            float r8 = r8 + r5
            float r9 = r4.top
            float r9 = r9 + r5
            float r10 = r4.right
            float r2 = r2 - r10
            float r10 = r4.bottom
            float r3 = r3 - r10
        L_0x006d:
            com.facebook.react.views.view.ReactViewBackgroundDrawable r10 = r0.mReactBackgroundDrawable
            float r10 = r10.getFullBorderRadius()
            com.facebook.react.views.view.ReactViewBackgroundDrawable r11 = r0.mReactBackgroundDrawable
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r12 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_LEFT
            float r11 = r11.getBorderRadiusOrDefaultTo(r10, r12)
            com.facebook.react.views.view.ReactViewBackgroundDrawable r12 = r0.mReactBackgroundDrawable
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r13 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_RIGHT
            float r12 = r12.getBorderRadiusOrDefaultTo(r10, r13)
            com.facebook.react.views.view.ReactViewBackgroundDrawable r13 = r0.mReactBackgroundDrawable
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r14 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_LEFT
            float r13 = r13.getBorderRadiusOrDefaultTo(r10, r14)
            com.facebook.react.views.view.ReactViewBackgroundDrawable r14 = r0.mReactBackgroundDrawable
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r15 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_RIGHT
            float r10 = r14.getBorderRadiusOrDefaultTo(r10, r15)
            int r14 = android.os.Build.VERSION.SDK_INT
            r15 = 17
            if (r14 < r15) goto L_0x013c
            int r14 = r0.mLayoutDirection
            if (r14 != r7) goto L_0x009f
            r14 = 1
            goto L_0x00a0
        L_0x009f:
            r14 = 0
        L_0x00a0:
            com.facebook.react.views.view.ReactViewBackgroundDrawable r15 = r0.mReactBackgroundDrawable
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r7 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_START
            float r7 = r15.getBorderRadius(r7)
            com.facebook.react.views.view.ReactViewBackgroundDrawable r15 = r0.mReactBackgroundDrawable
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r6 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.TOP_END
            float r6 = r15.getBorderRadius(r6)
            com.facebook.react.views.view.ReactViewBackgroundDrawable r15 = r0.mReactBackgroundDrawable
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r5 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_START
            float r5 = r15.getBorderRadius(r5)
            com.facebook.react.views.view.ReactViewBackgroundDrawable r15 = r0.mReactBackgroundDrawable
            r17 = r10
            com.facebook.react.views.view.ReactViewBackgroundDrawable$BorderRadiusLocation r10 = com.facebook.react.views.view.ReactViewBackgroundDrawable.BorderRadiusLocation.BOTTOM_END
            float r10 = r15.getBorderRadius(r10)
            com.facebook.react.modules.i18nmanager.I18nUtil r15 = com.facebook.react.modules.i18nmanager.I18nUtil.getInstance()
            r18 = r11
            android.content.Context r11 = r19.getContext()
            boolean r11 = r15.doLeftAndRightSwapInRTL(r11)
            if (r11 == 0) goto L_0x010b
            boolean r11 = com.facebook.yoga.YogaConstants.isUndefined((float) r7)
            if (r11 == 0) goto L_0x00d9
            goto L_0x00db
        L_0x00d9:
            r18 = r7
        L_0x00db:
            boolean r7 = com.facebook.yoga.YogaConstants.isUndefined((float) r6)
            if (r7 == 0) goto L_0x00e2
            r6 = r12
        L_0x00e2:
            boolean r7 = com.facebook.yoga.YogaConstants.isUndefined((float) r5)
            if (r7 == 0) goto L_0x00e9
            r5 = r13
        L_0x00e9:
            boolean r7 = com.facebook.yoga.YogaConstants.isUndefined((float) r10)
            if (r7 == 0) goto L_0x00f0
            goto L_0x00f2
        L_0x00f0:
            r17 = r10
        L_0x00f2:
            if (r14 == 0) goto L_0x00f6
            r11 = r6
            goto L_0x00f8
        L_0x00f6:
            r11 = r18
        L_0x00f8:
            if (r14 == 0) goto L_0x00fd
            r12 = r18
            goto L_0x00fe
        L_0x00fd:
            r12 = r6
        L_0x00fe:
            if (r14 == 0) goto L_0x0103
            r13 = r17
            goto L_0x0104
        L_0x0103:
            r13 = r5
        L_0x0104:
            if (r14 == 0) goto L_0x0108
            r10 = r5
            goto L_0x0138
        L_0x0108:
            r10 = r17
            goto L_0x0138
        L_0x010b:
            if (r14 == 0) goto L_0x010f
            r11 = r6
            goto L_0x0110
        L_0x010f:
            r11 = r7
        L_0x0110:
            if (r14 == 0) goto L_0x0113
            r6 = r7
        L_0x0113:
            if (r14 == 0) goto L_0x0117
            r7 = r10
            goto L_0x0118
        L_0x0117:
            r7 = r5
        L_0x0118:
            if (r14 == 0) goto L_0x011b
            r10 = r5
        L_0x011b:
            boolean r5 = com.facebook.yoga.YogaConstants.isUndefined((float) r11)
            if (r5 != 0) goto L_0x0122
            goto L_0x0124
        L_0x0122:
            r11 = r18
        L_0x0124:
            boolean r5 = com.facebook.yoga.YogaConstants.isUndefined((float) r6)
            if (r5 != 0) goto L_0x012b
            r12 = r6
        L_0x012b:
            boolean r5 = com.facebook.yoga.YogaConstants.isUndefined((float) r7)
            if (r5 != 0) goto L_0x0132
            r13 = r7
        L_0x0132:
            boolean r5 = com.facebook.yoga.YogaConstants.isUndefined((float) r10)
            if (r5 != 0) goto L_0x013a
        L_0x0138:
            r17 = r10
        L_0x013a:
            r5 = 0
            goto L_0x0140
        L_0x013c:
            r17 = r10
            r18 = r11
        L_0x0140:
            int r6 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r6 > 0) goto L_0x0150
            int r6 = (r12 > r5 ? 1 : (r12 == r5 ? 0 : -1))
            if (r6 > 0) goto L_0x0150
            int r6 = (r17 > r5 ? 1 : (r17 == r5 ? 0 : -1))
            if (r6 > 0) goto L_0x0150
            int r6 = (r13 > r5 ? 1 : (r13 == r5 ? 0 : -1))
            if (r6 <= 0) goto L_0x01d1
        L_0x0150:
            android.graphics.Path r5 = r0.mPath
            if (r5 != 0) goto L_0x015b
            android.graphics.Path r5 = new android.graphics.Path
            r5.<init>()
            r0.mPath = r5
        L_0x015b:
            android.graphics.Path r5 = r0.mPath
            r5.rewind()
            android.graphics.Path r5 = r0.mPath
            android.graphics.RectF r6 = new android.graphics.RectF
            r6.<init>(r8, r9, r2, r3)
            r7 = 8
            float[] r7 = new float[r7]
            float r10 = r4.left
            float r10 = r11 - r10
            r14 = 0
            float r10 = java.lang.Math.max(r10, r14)
            r15 = 0
            r7[r15] = r10
            float r10 = r4.top
            float r11 = r11 - r10
            float r10 = java.lang.Math.max(r11, r14)
            r16 = 1
            r7[r16] = r10
            r10 = 2
            float r11 = r4.right
            float r11 = r12 - r11
            float r11 = java.lang.Math.max(r11, r14)
            r7[r10] = r11
            r10 = 3
            float r11 = r4.top
            float r12 = r12 - r11
            float r11 = java.lang.Math.max(r12, r14)
            r7[r10] = r11
            r10 = 4
            float r11 = r4.right
            float r11 = r17 - r11
            float r11 = java.lang.Math.max(r11, r14)
            r7[r10] = r11
            r10 = 5
            float r11 = r4.bottom
            float r11 = r17 - r11
            float r11 = java.lang.Math.max(r11, r14)
            r7[r10] = r11
            r10 = 6
            float r11 = r4.left
            float r11 = r13 - r11
            float r11 = java.lang.Math.max(r11, r14)
            r7[r10] = r11
            r10 = 7
            float r4 = r4.bottom
            float r13 = r13 - r4
            float r4 = java.lang.Math.max(r13, r14)
            r7[r10] = r4
            android.graphics.Path$Direction r4 = android.graphics.Path.Direction.CW
            r5.addRoundRect(r6, r7, r4)
            android.graphics.Path r4 = r0.mPath
            r1.clipPath(r4)
            goto L_0x01d3
        L_0x01cd:
            r14 = 0
            r15 = 0
            r8 = 0
            r9 = 0
        L_0x01d1:
            r16 = 0
        L_0x01d3:
            if (r16 != 0) goto L_0x01e5
            android.graphics.RectF r4 = new android.graphics.RectF
            r4.<init>(r8, r9, r2, r3)
            r1.clipRect(r4)
            goto L_0x01e5
        L_0x01de:
            android.graphics.Path r1 = r0.mPath
            if (r1 == 0) goto L_0x01e5
            r1.rewind()
        L_0x01e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.view.ReactViewGroup.dispatchOverflowDraw(android.graphics.Canvas):void");
    }

    public void setOpacityIfPossible(float f) {
        this.mBackfaceOpacity = f;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibility(String str) {
        this.mBackfaceVisibility = str;
        setBackfaceVisibilityDependantOpacity();
    }

    public void setBackfaceVisibilityDependantOpacity() {
        if (this.mBackfaceVisibility.equals(ViewProps.VISIBLE)) {
            setAlpha(this.mBackfaceOpacity);
            return;
        }
        float rotationX = getRotationX();
        float rotationY = getRotationY();
        if (rotationX >= -90.0f && rotationX < 90.0f && rotationY >= -90.0f && rotationY < 90.0f) {
            setAlpha(this.mBackfaceOpacity);
        } else {
            setAlpha(0.0f);
        }
    }
}
