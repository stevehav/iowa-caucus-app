package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextPaint;
import androidx.annotation.Nullable;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.NativeViewHierarchyOptimizer;
import com.facebook.react.uimanager.ReactShadowNode;
import com.facebook.react.uimanager.UIViewOperationQueue;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.yoga.YogaDirection;
import com.facebook.yoga.YogaMeasureFunction;
import java.util.ArrayList;

@TargetApi(23)
public class ReactTextShadowNode extends ReactBaseTextShadowNode {
    /* access modifiers changed from: private */
    public static final TextPaint sTextPaintInstance = new TextPaint(1);
    /* access modifiers changed from: private */
    @Nullable
    public Spannable mPreparedSpannableText;
    /* access modifiers changed from: private */
    public boolean mShouldNotifyOnTextLayout;
    private final YogaMeasureFunction mTextMeasureFunction = new YogaMeasureFunction() {
        /* JADX WARNING: type inference failed for: r12v15, types: [android.text.BoringLayout] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long measure(com.facebook.yoga.YogaNode r10, float r11, com.facebook.yoga.YogaMeasureMode r12, float r13, com.facebook.yoga.YogaMeasureMode r14) {
            /*
                r9 = this;
                android.text.TextPaint r2 = com.facebook.react.views.text.ReactTextShadowNode.sTextPaintInstance
                com.facebook.react.views.text.ReactTextShadowNode r10 = com.facebook.react.views.text.ReactTextShadowNode.this
                com.facebook.react.views.text.TextAttributes r10 = r10.mTextAttributes
                int r10 = r10.getEffectiveFontSize()
                float r10 = (float) r10
                r2.setTextSize(r10)
                com.facebook.react.views.text.ReactTextShadowNode r10 = com.facebook.react.views.text.ReactTextShadowNode.this
                android.text.Spannable r10 = r10.mPreparedSpannableText
                java.lang.String r13 = "Spannable element has not been prepared in onBeforeLayout"
                java.lang.Object r10 = com.facebook.infer.annotation.Assertions.assertNotNull(r10, r13)
                android.text.Spanned r10 = (android.text.Spanned) r10
                android.text.BoringLayout$Metrics r6 = android.text.BoringLayout.isBoring(r10, r2)
                if (r6 != 0) goto L_0x0029
                float r13 = android.text.Layout.getDesiredWidth(r10, r2)
                goto L_0x002b
            L_0x0029:
                r13 = 2143289344(0x7fc00000, float:NaN)
            L_0x002b:
                com.facebook.yoga.YogaMeasureMode r14 = com.facebook.yoga.YogaMeasureMode.UNDEFINED
                r0 = 0
                r1 = 0
                r8 = 1
                if (r12 == r14) goto L_0x0039
                int r12 = (r11 > r1 ? 1 : (r11 == r1 ? 0 : -1))
                if (r12 >= 0) goto L_0x0037
                goto L_0x0039
            L_0x0037:
                r12 = 0
                goto L_0x003a
            L_0x0039:
                r12 = 1
            L_0x003a:
                android.text.Layout$Alignment r14 = android.text.Layout.Alignment.ALIGN_NORMAL
                com.facebook.react.views.text.ReactTextShadowNode r3 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r3 = r3.getTextAlign()
                if (r3 == r8) goto L_0x0052
                r4 = 3
                if (r3 == r4) goto L_0x004f
                r4 = 5
                if (r3 == r4) goto L_0x004c
            L_0x004a:
                r4 = r14
                goto L_0x0055
            L_0x004c:
                android.text.Layout$Alignment r14 = android.text.Layout.Alignment.ALIGN_OPPOSITE
                goto L_0x004a
            L_0x004f:
                android.text.Layout$Alignment r14 = android.text.Layout.Alignment.ALIGN_NORMAL
                goto L_0x004a
            L_0x0052:
                android.text.Layout$Alignment r14 = android.text.Layout.Alignment.ALIGN_CENTER
                goto L_0x004a
            L_0x0055:
                r14 = 28
                r3 = 1065353216(0x3f800000, float:1.0)
                r5 = 23
                if (r6 != 0) goto L_0x00c6
                if (r12 != 0) goto L_0x0069
                boolean r7 = com.facebook.yoga.YogaConstants.isUndefined((float) r13)
                if (r7 != 0) goto L_0x00c6
                int r7 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
                if (r7 > 0) goto L_0x00c6
            L_0x0069:
                double r11 = (double) r13
                double r11 = java.lang.Math.ceil(r11)
                int r11 = (int) r11
                int r12 = android.os.Build.VERSION.SDK_INT
                if (r12 >= r5) goto L_0x0084
                android.text.StaticLayout r12 = new android.text.StaticLayout
                r5 = 1065353216(0x3f800000, float:1.0)
                r6 = 0
                com.facebook.react.views.text.ReactTextShadowNode r13 = com.facebook.react.views.text.ReactTextShadowNode.this
                boolean r7 = r13.mIncludeFontPadding
                r0 = r12
                r1 = r10
                r3 = r11
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                goto L_0x012c
            L_0x0084:
                int r12 = r10.length()
                android.text.StaticLayout$Builder r11 = android.text.StaticLayout.Builder.obtain(r10, r0, r12, r2, r11)
                android.text.StaticLayout$Builder r11 = r11.setAlignment(r4)
                android.text.StaticLayout$Builder r11 = r11.setLineSpacing(r1, r3)
                com.facebook.react.views.text.ReactTextShadowNode r12 = com.facebook.react.views.text.ReactTextShadowNode.this
                boolean r12 = r12.mIncludeFontPadding
                android.text.StaticLayout$Builder r11 = r11.setIncludePad(r12)
                com.facebook.react.views.text.ReactTextShadowNode r12 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r12 = r12.mTextBreakStrategy
                android.text.StaticLayout$Builder r11 = r11.setBreakStrategy(r12)
                com.facebook.react.views.text.ReactTextShadowNode r12 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r12 = r12.mHyphenationFrequency
                android.text.StaticLayout$Builder r11 = r11.setHyphenationFrequency(r12)
                int r12 = android.os.Build.VERSION.SDK_INT
                r13 = 26
                if (r12 < r13) goto L_0x00b9
                com.facebook.react.views.text.ReactTextShadowNode r12 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r12 = r12.mJustificationMode
                r11.setJustificationMode(r12)
            L_0x00b9:
                int r12 = android.os.Build.VERSION.SDK_INT
                if (r12 < r14) goto L_0x00c0
                r11.setUseLineSpacingFromFallbacks(r8)
            L_0x00c0:
                android.text.StaticLayout r12 = r11.build()
                goto L_0x012c
            L_0x00c6:
                if (r6 == 0) goto L_0x00e4
                if (r12 != 0) goto L_0x00d1
                int r12 = r6.width
                float r12 = (float) r12
                int r12 = (r12 > r11 ? 1 : (r12 == r11 ? 0 : -1))
                if (r12 > 0) goto L_0x00e4
            L_0x00d1:
                int r11 = r6.width
                r12 = 1065353216(0x3f800000, float:1.0)
                r5 = 0
                com.facebook.react.views.text.ReactTextShadowNode r13 = com.facebook.react.views.text.ReactTextShadowNode.this
                boolean r7 = r13.mIncludeFontPadding
                r0 = r10
                r1 = r2
                r2 = r11
                r3 = r4
                r4 = r12
                android.text.BoringLayout r12 = android.text.BoringLayout.make(r0, r1, r2, r3, r4, r5, r6, r7)
                goto L_0x012c
            L_0x00e4:
                int r12 = android.os.Build.VERSION.SDK_INT
                if (r12 >= r5) goto L_0x00f8
                android.text.StaticLayout r12 = new android.text.StaticLayout
                int r3 = (int) r11
                r5 = 1065353216(0x3f800000, float:1.0)
                r6 = 0
                com.facebook.react.views.text.ReactTextShadowNode r11 = com.facebook.react.views.text.ReactTextShadowNode.this
                boolean r7 = r11.mIncludeFontPadding
                r0 = r12
                r1 = r10
                r0.<init>(r1, r2, r3, r4, r5, r6, r7)
                goto L_0x012c
            L_0x00f8:
                int r12 = r10.length()
                int r11 = (int) r11
                android.text.StaticLayout$Builder r11 = android.text.StaticLayout.Builder.obtain(r10, r0, r12, r2, r11)
                android.text.StaticLayout$Builder r11 = r11.setAlignment(r4)
                android.text.StaticLayout$Builder r11 = r11.setLineSpacing(r1, r3)
                com.facebook.react.views.text.ReactTextShadowNode r12 = com.facebook.react.views.text.ReactTextShadowNode.this
                boolean r12 = r12.mIncludeFontPadding
                android.text.StaticLayout$Builder r11 = r11.setIncludePad(r12)
                com.facebook.react.views.text.ReactTextShadowNode r12 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r12 = r12.mTextBreakStrategy
                android.text.StaticLayout$Builder r11 = r11.setBreakStrategy(r12)
                com.facebook.react.views.text.ReactTextShadowNode r12 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r12 = r12.mHyphenationFrequency
                android.text.StaticLayout$Builder r11 = r11.setHyphenationFrequency(r12)
                int r12 = android.os.Build.VERSION.SDK_INT
                if (r12 < r14) goto L_0x0128
                r11.setUseLineSpacingFromFallbacks(r8)
            L_0x0128:
                android.text.StaticLayout r12 = r11.build()
            L_0x012c:
                com.facebook.react.views.text.ReactTextShadowNode r11 = com.facebook.react.views.text.ReactTextShadowNode.this
                boolean r11 = r11.mShouldNotifyOnTextLayout
                if (r11 == 0) goto L_0x0164
                android.text.TextPaint r11 = com.facebook.react.views.text.ReactTextShadowNode.sTextPaintInstance
                com.facebook.react.views.text.ReactTextShadowNode r13 = com.facebook.react.views.text.ReactTextShadowNode.this
                com.facebook.react.uimanager.ThemedReactContext r13 = r13.getThemedContext()
                com.facebook.react.bridge.WritableArray r10 = com.facebook.react.views.text.FontMetricsUtil.getFontMetrics(r10, r12, r11, r13)
                com.facebook.react.bridge.WritableMap r11 = com.facebook.react.bridge.Arguments.createMap()
                java.lang.String r13 = "lines"
                r11.putArray(r13, r10)
                com.facebook.react.views.text.ReactTextShadowNode r10 = com.facebook.react.views.text.ReactTextShadowNode.this
                com.facebook.react.uimanager.ThemedReactContext r10 = r10.getThemedContext()
                java.lang.Class<com.facebook.react.uimanager.events.RCTEventEmitter> r13 = com.facebook.react.uimanager.events.RCTEventEmitter.class
                com.facebook.react.bridge.JavaScriptModule r10 = r10.getJSModule(r13)
                com.facebook.react.uimanager.events.RCTEventEmitter r10 = (com.facebook.react.uimanager.events.RCTEventEmitter) r10
                com.facebook.react.views.text.ReactTextShadowNode r13 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r13 = r13.getReactTag()
                java.lang.String r14 = "topTextLayout"
                r10.receiveEvent(r13, r14, r11)
            L_0x0164:
                com.facebook.react.views.text.ReactTextShadowNode r10 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r10 = r10.mNumberOfLines
                r11 = -1
                if (r10 == r11) goto L_0x0187
                com.facebook.react.views.text.ReactTextShadowNode r10 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r10 = r10.mNumberOfLines
                int r11 = r12.getLineCount()
                if (r10 >= r11) goto L_0x0187
                int r10 = r12.getWidth()
                com.facebook.react.views.text.ReactTextShadowNode r11 = com.facebook.react.views.text.ReactTextShadowNode.this
                int r11 = r11.mNumberOfLines
                int r11 = r11 - r8
                int r11 = r12.getLineBottom(r11)
                long r10 = com.facebook.yoga.YogaMeasureOutput.make((int) r10, (int) r11)
                return r10
            L_0x0187:
                int r10 = r12.getWidth()
                int r11 = r12.getHeight()
                long r10 = com.facebook.yoga.YogaMeasureOutput.make((int) r10, (int) r11)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextShadowNode.AnonymousClass1.measure(com.facebook.yoga.YogaNode, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode):long");
        }
    };

    public boolean hoistNativeChildren() {
        return true;
    }

    public boolean isVirtualAnchor() {
        return false;
    }

    public ReactTextShadowNode() {
        initMeasureFunction();
    }

    private void initMeasureFunction() {
        if (!isVirtual()) {
            setMeasureFunction(this.mTextMeasureFunction);
        }
    }

    /* access modifiers changed from: private */
    public int getTextAlign() {
        int i = this.mTextAlign;
        if (getLayoutDirection() != YogaDirection.RTL) {
            return i;
        }
        if (i == 5) {
            return 3;
        }
        if (i == 3) {
            return 5;
        }
        return i;
    }

    public void onBeforeLayout(NativeViewHierarchyOptimizer nativeViewHierarchyOptimizer) {
        this.mPreparedSpannableText = spannedFromShadowNode(this, (String) null, true, nativeViewHierarchyOptimizer);
        markUpdated();
    }

    public void markUpdated() {
        super.markUpdated();
        super.dirty();
    }

    public void onCollectExtraUpdates(UIViewOperationQueue uIViewOperationQueue) {
        super.onCollectExtraUpdates(uIViewOperationQueue);
        Spannable spannable = this.mPreparedSpannableText;
        if (spannable != null) {
            uIViewOperationQueue.enqueueUpdateExtraData(getReactTag(), new ReactTextUpdate(spannable, -1, this.mContainsImages, getPadding(4), getPadding(1), getPadding(5), getPadding(3), getTextAlign(), this.mTextBreakStrategy, this.mJustificationMode));
        }
    }

    @ReactProp(name = "onTextLayout")
    public void setShouldNotifyOnTextLayout(boolean z) {
        this.mShouldNotifyOnTextLayout = z;
    }

    public Iterable<? extends ReactShadowNode> calculateLayoutOnChildren() {
        if (this.mInlineViews == null || this.mInlineViews.isEmpty()) {
            return null;
        }
        Spanned spanned = (Spanned) Assertions.assertNotNull(this.mPreparedSpannableText, "Spannable element has not been prepared in onBeforeLayout");
        TextInlineViewPlaceholderSpan[] textInlineViewPlaceholderSpanArr = (TextInlineViewPlaceholderSpan[]) spanned.getSpans(0, spanned.length(), TextInlineViewPlaceholderSpan.class);
        ArrayList arrayList = new ArrayList(textInlineViewPlaceholderSpanArr.length);
        for (TextInlineViewPlaceholderSpan reactTag : textInlineViewPlaceholderSpanArr) {
            ReactShadowNode reactShadowNode = (ReactShadowNode) this.mInlineViews.get(Integer.valueOf(reactTag.getReactTag()));
            reactShadowNode.calculateLayout();
            arrayList.add(reactShadowNode);
        }
        return arrayList;
    }
}
