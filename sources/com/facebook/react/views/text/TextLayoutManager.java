package com.facebook.react.views.text;

import android.content.Context;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.util.LruCache;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import java.util.ArrayList;
import java.util.List;

public class TextLayoutManager {
    private static LruCache<String, Spannable> sSpannableCache = new LruCache<>(100);
    private static final Object sSpannableCacheLock = new Object();
    private static final TextPaint sTextPaintInstance = new TextPaint(1);
    private static final int spannableCacheSize = 100;

    private static void buildSpannableFromFragment(Context context, ReadableArray readableArray, SpannableStringBuilder spannableStringBuilder, List<SetSpanOperation> list) {
        int size = readableArray.size();
        for (int i = 0; i < size; i++) {
            ReadableMap map = readableArray.getMap(i);
            int length = spannableStringBuilder.length();
            TextAttributeProps textAttributeProps = new TextAttributeProps(new ReactStylesDiffMap(map.getMap("textAttributes")));
            spannableStringBuilder.append(TextTransform.apply(map.getString("string"), textAttributeProps.mTextTransform));
            int length2 = spannableStringBuilder.length();
            if (length2 >= length) {
                if (textAttributeProps.mIsColorSet) {
                    list.add(new SetSpanOperation(length, length2, new ReactForegroundColorSpan(textAttributeProps.mColor)));
                }
                if (textAttributeProps.mIsBackgroundColorSet) {
                    list.add(new SetSpanOperation(length, length2, new ReactBackgroundColorSpan(textAttributeProps.mBackgroundColor)));
                }
                if (Build.VERSION.SDK_INT >= 21 && !Float.isNaN(textAttributeProps.mLetterSpacing)) {
                    list.add(new SetSpanOperation(length, length2, new CustomLetterSpacingSpan(textAttributeProps.mLetterSpacing)));
                }
                list.add(new SetSpanOperation(length, length2, new ReactAbsoluteSizeSpan(textAttributeProps.mFontSize)));
                if (!(textAttributeProps.mFontStyle == -1 && textAttributeProps.mFontWeight == -1 && textAttributeProps.mFontFamily == null)) {
                    list.add(new SetSpanOperation(length, length2, new CustomStyleSpan(textAttributeProps.mFontStyle, textAttributeProps.mFontWeight, textAttributeProps.mFontFamily, context.getAssets())));
                }
                if (textAttributeProps.mIsUnderlineTextDecorationSet) {
                    list.add(new SetSpanOperation(length, length2, new ReactUnderlineSpan()));
                }
                if (textAttributeProps.mIsLineThroughTextDecorationSet) {
                    list.add(new SetSpanOperation(length, length2, new ReactStrikethroughSpan()));
                }
                if (!(textAttributeProps.mTextShadowOffsetDx == 0.0f && textAttributeProps.mTextShadowOffsetDy == 0.0f)) {
                    list.add(new SetSpanOperation(length, length2, new ShadowStyleSpan(textAttributeProps.mTextShadowOffsetDx, textAttributeProps.mTextShadowOffsetDy, textAttributeProps.mTextShadowRadius, textAttributeProps.mTextShadowColor)));
                }
                if (!Float.isNaN(textAttributeProps.getEffectiveLineHeight())) {
                    list.add(new SetSpanOperation(length, length2, new CustomLineHeightSpan(textAttributeProps.getEffectiveLineHeight())));
                }
                list.add(new SetSpanOperation(length, length2, new ReactTagSpan(map.getInt("reactTag"))));
            }
        }
    }

    protected static Spannable getOrCreateSpannableForText(Context context, ReadableMap readableMap) {
        String obj = readableMap.toString();
        synchronized (sSpannableCacheLock) {
            Spannable spannable = sSpannableCache.get(obj);
            if (spannable != null) {
                return spannable;
            }
            Spannable createSpannableFromAttributedString = createSpannableFromAttributedString(context, readableMap);
            synchronized (sSpannableCacheLock) {
                sSpannableCache.put(obj, createSpannableFromAttributedString);
            }
            return createSpannableFromAttributedString;
        }
    }

    private static Spannable createSpannableFromAttributedString(Context context, ReadableMap readableMap) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<SetSpanOperation> arrayList = new ArrayList<>();
        buildSpannableFromFragment(context, readableMap.getArray("fragments"), spannableStringBuilder, arrayList);
        int i = 0;
        for (SetSpanOperation execute : arrayList) {
            execute.execute(spannableStringBuilder, i);
            i++;
        }
        return spannableStringBuilder;
    }

    /* JADX WARNING: type inference failed for: r9v21, types: [android.text.BoringLayout] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long measureText(android.content.Context r9, com.facebook.react.bridge.ReadableMap r10, com.facebook.react.bridge.ReadableMap r11, float r12, com.facebook.yoga.YogaMeasureMode r13, float r14, com.facebook.yoga.YogaMeasureMode r15) {
        /*
            android.text.TextPaint r2 = sTextPaintInstance
            android.text.Spannable r1 = getOrCreateSpannableForText(r9, r10)
            if (r1 == 0) goto L_0x00f7
            android.text.BoringLayout$Metrics r6 = android.text.BoringLayout.isBoring(r1, r2)
            if (r6 != 0) goto L_0x0013
            float r9 = android.text.Layout.getDesiredWidth(r1, r2)
            goto L_0x0015
        L_0x0013:
            r9 = 2143289344(0x7fc00000, float:NaN)
        L_0x0015:
            com.facebook.yoga.YogaMeasureMode r10 = com.facebook.yoga.YogaMeasureMode.UNDEFINED
            r14 = 0
            r15 = 0
            r8 = 1
            if (r13 == r10) goto L_0x0023
            int r10 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
            if (r10 >= 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r10 = 0
            goto L_0x0024
        L_0x0023:
            r10 = 1
        L_0x0024:
            r13 = 1065353216(0x3f800000, float:1.0)
            r0 = 23
            if (r6 != 0) goto L_0x0071
            if (r10 != 0) goto L_0x0036
            boolean r3 = com.facebook.yoga.YogaConstants.isUndefined((float) r9)
            if (r3 != 0) goto L_0x0071
            int r3 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r3 > 0) goto L_0x0071
        L_0x0036:
            double r9 = (double) r9
            double r9 = java.lang.Math.ceil(r9)
            int r3 = (int) r9
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 >= r0) goto L_0x004e
            android.text.StaticLayout r9 = new android.text.StaticLayout
            android.text.Layout$Alignment r4 = android.text.Layout.Alignment.ALIGN_NORMAL
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            r7 = 1
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x00c1
        L_0x004e:
            int r9 = r1.length()
            android.text.StaticLayout$Builder r9 = android.text.StaticLayout.Builder.obtain(r1, r14, r9, r2, r3)
            android.text.Layout$Alignment r10 = android.text.Layout.Alignment.ALIGN_NORMAL
            android.text.StaticLayout$Builder r9 = r9.setAlignment(r10)
            android.text.StaticLayout$Builder r9 = r9.setLineSpacing(r15, r13)
            android.text.StaticLayout$Builder r9 = r9.setIncludePad(r8)
            android.text.StaticLayout$Builder r9 = r9.setBreakStrategy(r8)
            android.text.StaticLayout$Builder r9 = r9.setHyphenationFrequency(r8)
            android.text.StaticLayout r9 = r9.build()
            goto L_0x00c1
        L_0x0071:
            if (r6 == 0) goto L_0x008c
            if (r10 != 0) goto L_0x007c
            int r9 = r6.width
            float r9 = (float) r9
            int r9 = (r9 > r12 ? 1 : (r9 == r12 ? 0 : -1))
            if (r9 > 0) goto L_0x008c
        L_0x007c:
            int r9 = r6.width
            android.text.Layout$Alignment r3 = android.text.Layout.Alignment.ALIGN_NORMAL
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            r7 = 1
            r0 = r1
            r1 = r2
            r2 = r9
            android.text.BoringLayout r9 = android.text.BoringLayout.make(r0, r1, r2, r3, r4, r5, r6, r7)
            goto L_0x00c1
        L_0x008c:
            int r9 = android.os.Build.VERSION.SDK_INT
            if (r9 >= r0) goto L_0x009e
            android.text.StaticLayout r9 = new android.text.StaticLayout
            int r3 = (int) r12
            android.text.Layout$Alignment r4 = android.text.Layout.Alignment.ALIGN_NORMAL
            r5 = 1065353216(0x3f800000, float:1.0)
            r6 = 0
            r7 = 1
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            goto L_0x00c1
        L_0x009e:
            int r9 = r1.length()
            int r10 = (int) r12
            android.text.StaticLayout$Builder r9 = android.text.StaticLayout.Builder.obtain(r1, r14, r9, r2, r10)
            android.text.Layout$Alignment r10 = android.text.Layout.Alignment.ALIGN_NORMAL
            android.text.StaticLayout$Builder r9 = r9.setAlignment(r10)
            android.text.StaticLayout$Builder r9 = r9.setLineSpacing(r15, r13)
            android.text.StaticLayout$Builder r9 = r9.setIncludePad(r8)
            android.text.StaticLayout$Builder r9 = r9.setBreakStrategy(r8)
            android.text.StaticLayout$Builder r9 = r9.setHyphenationFrequency(r8)
            android.text.StaticLayout r9 = r9.build()
        L_0x00c1:
            java.lang.String r10 = "maximumNumberOfLines"
            boolean r12 = r11.hasKey(r10)
            r13 = -1
            if (r12 == 0) goto L_0x00cf
            int r10 = r11.getInt(r10)
            goto L_0x00d0
        L_0x00cf:
            r10 = -1
        L_0x00d0:
            int r11 = r9.getWidth()
            float r11 = (float) r11
            if (r10 == r13) goto L_0x00e5
            if (r10 == 0) goto L_0x00e5
            int r12 = r9.getLineCount()
            if (r10 >= r12) goto L_0x00e5
            int r10 = r10 - r8
            int r9 = r9.getLineBottom(r10)
            goto L_0x00e9
        L_0x00e5:
            int r9 = r9.getHeight()
        L_0x00e9:
            float r9 = (float) r9
            float r10 = com.facebook.react.uimanager.PixelUtil.toSPFromPixel(r11)
            float r9 = com.facebook.react.uimanager.PixelUtil.toSPFromPixel(r9)
            long r9 = com.facebook.yoga.YogaMeasureOutput.make((float) r10, (float) r9)
            return r9
        L_0x00f7:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Spannable element has not been prepared in onBeforeLayout"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.TextLayoutManager.measureText(android.content.Context, com.facebook.react.bridge.ReadableMap, com.facebook.react.bridge.ReadableMap, float, com.facebook.yoga.YogaMeasureMode, float, com.facebook.yoga.YogaMeasureMode):long");
    }

    public static class SetSpanOperation {
        protected int end;
        protected int start;
        protected ReactSpan what;

        SetSpanOperation(int i, int i2, ReactSpan reactSpan) {
            this.start = i;
            this.end = i2;
            this.what = reactSpan;
        }

        public void execute(SpannableStringBuilder spannableStringBuilder, int i) {
            spannableStringBuilder.setSpan(this.what, this.start, this.end, ((i << 16) & 16711680) | ((this.start == 0 ? 18 : 34) & -16711681));
        }
    }
}
