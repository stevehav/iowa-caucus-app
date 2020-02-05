package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.horcrux.svg.TextProperties;
import java.util.ArrayList;
import javax.annotation.Nullable;

@SuppressLint({"ViewConstructor"})
class TSpanView extends TextView {
    private static final String FONTS = "fonts/";
    private static final String OTF = ".otf";
    private static final String TTF = ".ttf";
    static final String additionalLigatures = "'hlig', 'cala', ";
    static final String defaultFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', ";
    static final String disableDiscretionaryLigatures = "'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, ";
    static final String fontWeightTag = "'wght' ";
    private static final double radToDeg = 57.29577951308232d;
    static final String requiredFontFeatures = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk',";
    private static final double tau = 6.283185307179586d;
    private final AssetManager assets = this.mContext.getResources().getAssets();
    private final ArrayList<String> emoji = new ArrayList<>();
    private final ArrayList<Matrix> emojiTransforms = new ArrayList<>();
    private Path mCachedPath;
    @Nullable
    String mContent;
    private TextPathView textPath;

    public TSpanView(ReactContext reactContext) {
        super(reactContext);
    }

    @ReactProp(name = "content")
    public void setContent(@Nullable String str) {
        this.mContent = str;
        invalidate();
    }

    public void invalidate() {
        this.mCachedPath = null;
        super.invalidate();
    }

    /* access modifiers changed from: package-private */
    public void clearCache() {
        this.mCachedPath = null;
        super.clearCache();
    }

    /* access modifiers changed from: package-private */
    public void draw(Canvas canvas, Paint paint, float f) {
        if (this.mContent == null) {
            clip(canvas, paint);
            drawGroup(canvas, paint, f);
        } else if (this.mInlineSize == null || this.mInlineSize.value == 0.0d) {
            int size = this.emoji.size();
            if (size > 0) {
                applyTextPropertiesToPaint(paint, getTextRootGlyphContext().getFont());
                for (int i = 0; i < size; i++) {
                    canvas.save();
                    canvas.concat(this.emojiTransforms.get(i));
                    canvas.drawText(this.emoji.get(i), 0.0f, 0.0f, paint);
                    canvas.restore();
                }
            }
            drawPath(canvas, paint, f);
        } else {
            drawWrappedText(canvas, paint);
        }
    }

    private void drawWrappedText(Canvas canvas, Paint paint) {
        Layout.Alignment alignment;
        StaticLayout staticLayout;
        Canvas canvas2 = canvas;
        GlyphContext textRootGlyphContext = getTextRootGlyphContext();
        pushGlyphContext();
        FontData font = textRootGlyphContext.getFont();
        TextPaint textPaint = new TextPaint(paint);
        applyTextPropertiesToPaint(textPaint, font);
        applySpacingAndFeatures(textPaint, font);
        double fontSize = textRootGlyphContext.getFontSize();
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[font.textAnchor.ordinal()];
        if (i == 2) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i != 3) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        SpannableString spannableString = new SpannableString(this.mContent);
        double fromRelative = PropHelper.fromRelative(this.mInlineSize, (double) canvas.getWidth(), 0.0d, (double) this.mScale, fontSize);
        if (Build.VERSION.SDK_INT < 23) {
            staticLayout = new StaticLayout(spannableString, textPaint, (int) fromRelative, alignment, 1.0f, 0.0f, true);
        } else {
            staticLayout = StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, (int) fromRelative).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(true).setBreakStrategy(1).setHyphenationFrequency(1).build();
        }
        int lineAscent = staticLayout.getLineAscent(0);
        double nextY = textRootGlyphContext.nextY();
        double d = (double) lineAscent;
        Double.isNaN(d);
        popGlyphContext();
        canvas.save();
        canvas2.translate((float) textRootGlyphContext.nextX(0.0d), (float) (nextY + d));
        staticLayout.draw(canvas2);
        canvas.restore();
    }

    /* access modifiers changed from: package-private */
    public Path getPath(Canvas canvas, Paint paint) {
        Path path = this.mCachedPath;
        if (path != null) {
            return path;
        }
        if (this.mContent == null) {
            this.mCachedPath = getGroupPath(canvas, paint);
            return this.mCachedPath;
        }
        setupTextPath();
        pushGlyphContext();
        this.mCachedPath = getLinePath(this.mContent, paint, canvas);
        popGlyphContext();
        return this.mCachedPath;
    }

    /* access modifiers changed from: package-private */
    public double getSubtreeTextChunksTotalAdvance(Paint paint) {
        if (!Double.isNaN(this.cachedAdvance)) {
            return this.cachedAdvance;
        }
        String str = this.mContent;
        double d = 0.0d;
        if (str == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof TextView) {
                    d += ((TextView) childAt).getSubtreeTextChunksTotalAdvance(paint);
                }
            }
            this.cachedAdvance = d;
            return d;
        } else if (str.length() == 0) {
            this.cachedAdvance = 0.0d;
            return 0.0d;
        } else {
            FontData font = getTextRootGlyphContext().getFont();
            applyTextPropertiesToPaint(paint, font);
            applySpacingAndFeatures(paint, font);
            this.cachedAdvance = (double) paint.measureText(str);
            return this.cachedAdvance;
        }
    }

    private void applySpacingAndFeatures(Paint paint, FontData fontData) {
        if (Build.VERSION.SDK_INT >= 21) {
            double d = fontData.letterSpacing;
            double d2 = fontData.fontSize;
            double d3 = (double) this.mScale;
            Double.isNaN(d3);
            paint.setLetterSpacing((float) (d / (d2 * d3)));
            if (d == 0.0d && fontData.fontVariantLigatures == TextProperties.FontVariantLigatures.normal) {
                paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + fontData.fontFeatureSettings);
            } else {
                paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + fontData.fontFeatureSettings);
            }
            if (Build.VERSION.SDK_INT >= 26) {
                paint.setFontVariationSettings(fontWeightTag + fontData.absoluteFontWeight + fontData.fontVariationSettings);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0209, code lost:
        r0 = r0 * r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0237, code lost:
        r0 = -r8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02ea A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Path getLinePath(java.lang.String r73, android.graphics.Paint r74, android.graphics.Canvas r75) {
        /*
            r72 = this;
            r6 = r72
            r14 = r74
            r15 = r75
            int r13 = r73.length()
            android.graphics.Path r12 = new android.graphics.Path
            r12.<init>()
            java.util.ArrayList<java.lang.String> r0 = r6.emoji
            r0.clear()
            java.util.ArrayList<android.graphics.Matrix> r0 = r6.emojiTransforms
            r0.clear()
            if (r13 != 0) goto L_0x001c
            return r12
        L_0x001c:
            r0 = 0
            com.horcrux.svg.TextPathView r1 = r6.textPath
            r11 = 0
            if (r1 == 0) goto L_0x0025
            r16 = 1
            goto L_0x0027
        L_0x0025:
            r16 = 0
        L_0x0027:
            r17 = 0
            if (r16 == 0) goto L_0x0048
            android.graphics.PathMeasure r0 = new android.graphics.PathMeasure
            com.horcrux.svg.TextPathView r1 = r6.textPath
            android.graphics.Path r1 = r1.getTextPath(r15, r14)
            r0.<init>(r1, r11)
            float r1 = r0.getLength()
            double r1 = (double) r1
            boolean r3 = r0.isClosed()
            int r4 = (r1 > r17 ? 1 : (r1 == r17 ? 0 : -1))
            if (r4 != 0) goto L_0x0044
            return r12
        L_0x0044:
            r4 = r0
            r8 = r1
            r7 = r3
            goto L_0x004c
        L_0x0048:
            r4 = r0
            r8 = r17
            r7 = 0
        L_0x004c:
            com.horcrux.svg.GlyphContext r5 = r72.getTextRootGlyphContext()
            com.horcrux.svg.FontData r0 = r5.getFont()
            r6.applyTextPropertiesToPaint(r14, r0)
            com.horcrux.svg.GlyphPathBag r2 = new com.horcrux.svg.GlyphPathBag
            r2.<init>(r14)
            boolean[] r3 = new boolean[r13]
            char[] r19 = r73.toCharArray()
            r20 = r12
            double r11 = r0.kerning
            r22 = r11
            double r11 = r0.wordSpacing
            r25 = r11
            double r10 = r0.letterSpacing
            boolean r1 = r0.manualKerning
            r12 = 1
            r27 = r1 ^ 1
            int r1 = (r10 > r17 ? 1 : (r10 == r17 ? 0 : -1))
            if (r1 != 0) goto L_0x007f
            com.horcrux.svg.TextProperties$FontVariantLigatures r1 = r0.fontVariantLigatures
            com.horcrux.svg.TextProperties$FontVariantLigatures r12 = com.horcrux.svg.TextProperties.FontVariantLigatures.normal
            if (r1 != r12) goto L_0x007f
            r1 = 1
            goto L_0x0080
        L_0x007f:
            r1 = 0
        L_0x0080:
            int r12 = android.os.Build.VERSION.SDK_INT
            r28 = r2
            r2 = 21
            if (r12 < r2) goto L_0x00d8
            if (r1 == 0) goto L_0x00a1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', "
            r1.append(r2)
            java.lang.String r2 = r0.fontFeatureSettings
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r14.setFontFeatureSettings(r1)
            goto L_0x00b7
        L_0x00a1:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, "
            r1.append(r2)
            java.lang.String r2 = r0.fontFeatureSettings
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r14.setFontFeatureSettings(r1)
        L_0x00b7:
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x00d8
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "'wght' "
            r1.append(r2)
            int r2 = r0.absoluteFontWeight
            r1.append(r2)
            java.lang.String r2 = r0.fontVariationSettings
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r14.setFontVariationSettings(r1)
        L_0x00d8:
            com.facebook.react.bridge.ReadableMap r12 = r0.fontData
            float[] r2 = new float[r13]
            r1 = r73
            r14.getTextWidths(r1, r2)
            com.horcrux.svg.TextProperties$TextAnchor r1 = r0.textAnchor
            com.horcrux.svg.TextView r0 = r72.getTextAnchorRoot()
            r29 = r10
            double r10 = r0.getSubtreeTextChunksTotalAdvance(r14)
            double r31 = r6.getTextAnchorOffset(r1, r10)
            double r42 = r5.getFontSize()
            r44 = -1
            r45 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r16 == 0) goto L_0x0151
            com.horcrux.svg.TextPathView r0 = r6.textPath
            com.horcrux.svg.TextProperties$TextPathMidLine r0 = r0.getMidLine()
            r33 = r1
            com.horcrux.svg.TextProperties$TextPathMidLine r1 = com.horcrux.svg.TextProperties.TextPathMidLine.sharp
            if (r0 != r1) goto L_0x010a
            r34 = 1
            goto L_0x010c
        L_0x010a:
            r34 = 0
        L_0x010c:
            com.horcrux.svg.TextPathView r0 = r6.textPath
            com.horcrux.svg.TextProperties$TextPathSide r0 = r0.getSide()
            com.horcrux.svg.TextProperties$TextPathSide r1 = com.horcrux.svg.TextProperties.TextPathSide.right
            if (r0 != r1) goto L_0x0119
            r35 = -1
            goto L_0x011b
        L_0x0119:
            r35 = 1
        L_0x011b:
            com.horcrux.svg.TextPathView r0 = r6.textPath
            com.horcrux.svg.SVGLength r1 = r0.getStartOffset()
            r0 = r72
            r15 = r33
            r48 = r2
            r47 = r28
            r28 = r3
            r2 = r8
            r50 = r4
            r49 = r5
            r4 = r42
            double r0 = r0.getAbsoluteStartOffset(r1, r2, r4)
            double r31 = r31 + r0
            if (r7 == 0) goto L_0x0149
            double r2 = r8 / r45
            com.horcrux.svg.TextProperties$TextAnchor r4 = com.horcrux.svg.TextProperties.TextAnchor.middle
            if (r15 != r4) goto L_0x0142
            double r2 = -r2
            goto L_0x0144
        L_0x0142:
            r2 = r17
        L_0x0144:
            double r0 = r0 + r2
            double r2 = r0 + r8
            r4 = r0
            goto L_0x014c
        L_0x0149:
            r2 = r8
            r4 = r17
        L_0x014c:
            r1 = r34
            r0 = r35
            goto L_0x0160
        L_0x0151:
            r48 = r2
            r50 = r4
            r49 = r5
            r47 = r28
            r28 = r3
            r2 = r8
            r4 = r17
            r0 = 1
            r1 = 0
        L_0x0160:
            r51 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            com.horcrux.svg.SVGLength r7 = r6.mTextLength
            if (r7 == 0) goto L_0x01ab
            com.horcrux.svg.SVGLength r7 = r6.mTextLength
            int r15 = r75.getWidth()
            r53 = r8
            double r8 = (double) r15
            r36 = 0
            float r15 = r6.mScale
            r55 = r4
            double r4 = (double) r15
            r33 = r7
            r34 = r8
            r38 = r4
            r40 = r42
            double r4 = com.horcrux.svg.PropHelper.fromRelative(r33, r34, r36, r38, r40)
            int r7 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r7 < 0) goto L_0x01a3
            int[] r7 = com.horcrux.svg.TSpanView.AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust
            com.horcrux.svg.TextProperties$TextLengthAdjust r8 = r6.mLengthAdjust
            int r8 = r8.ordinal()
            r7 = r7[r8]
            r8 = 2
            if (r7 == r8) goto L_0x01a0
            double r4 = r4 - r10
            int r7 = r13 + -1
            double r7 = (double) r7
            java.lang.Double.isNaN(r7)
            double r4 = r4 / r7
            double r10 = r29 + r4
            r29 = r10
            goto L_0x01af
        L_0x01a0:
            double r51 = r4 / r10
            goto L_0x01af
        L_0x01a3:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Negative textLength value"
            r0.<init>(r1)
            throw r0
        L_0x01ab:
            r55 = r4
            r53 = r8
        L_0x01af:
            double r4 = (double) r0
            java.lang.Double.isNaN(r4)
            double r10 = r51 * r4
            android.graphics.Paint$FontMetrics r7 = r74.getFontMetrics()
            float r8 = r7.descent
            double r8 = (double) r8
            float r15 = r7.leading
            r40 = r10
            double r10 = (double) r15
            java.lang.Double.isNaN(r8)
            java.lang.Double.isNaN(r10)
            double r10 = r10 + r8
            float r15 = r7.ascent
            float r15 = -r15
            r57 = r0
            float r0 = r7.leading
            float r15 = r15 + r0
            r58 = r1
            double r0 = (double) r15
            float r7 = r7.top
            float r7 = -r7
            r59 = r2
            double r2 = (double) r7
            java.lang.Double.isNaN(r2)
            double r33 = r2 + r10
            java.lang.String r7 = r72.getBaselineShift()
            com.horcrux.svg.TextProperties$AlignmentBaseline r15 = r72.getAlignmentBaseline()
            if (r15 == 0) goto L_0x0239
            int[] r35 = com.horcrux.svg.TSpanView.AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline
            int r36 = r15.ordinal()
            r35 = r35[r36]
            switch(r35) {
                case 2: goto L_0x0233;
                case 3: goto L_0x0233;
                case 4: goto L_0x0233;
                case 5: goto L_0x0239;
                case 6: goto L_0x022e;
                case 7: goto L_0x0217;
                case 8: goto L_0x020c;
                case 9: goto L_0x0204;
                case 10: goto L_0x01fb;
                case 11: goto L_0x0215;
                case 12: goto L_0x0215;
                case 13: goto L_0x0215;
                case 14: goto L_0x01f9;
                case 15: goto L_0x01f6;
                case 16: goto L_0x01f4;
                default: goto L_0x01f3;
            }
        L_0x01f3:
            goto L_0x0239
        L_0x01f4:
            r0 = r2
            goto L_0x0215
        L_0x01f6:
            double r0 = r33 / r45
            goto L_0x0215
        L_0x01f9:
            r0 = r10
            goto L_0x0215
        L_0x01fb:
            r2 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            java.lang.Double.isNaN(r0)
            goto L_0x0209
        L_0x0204:
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            java.lang.Double.isNaN(r0)
        L_0x0209:
            double r0 = r0 * r2
            goto L_0x0215
        L_0x020c:
            java.lang.Double.isNaN(r0)
            java.lang.Double.isNaN(r8)
            double r0 = r0 - r8
            double r0 = r0 / r45
        L_0x0215:
            r2 = 0
            goto L_0x023c
        L_0x0217:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            java.lang.String r1 = "x"
            r2 = 0
            r3 = 1
            r14.getTextBounds(r1, r2, r3, r0)
            int r0 = r0.height()
            double r0 = (double) r0
            java.lang.Double.isNaN(r0)
            double r0 = r0 / r45
            goto L_0x023c
        L_0x022e:
            r2 = 0
            java.lang.Double.isNaN(r8)
            goto L_0x0237
        L_0x0233:
            r2 = 0
            java.lang.Double.isNaN(r8)
        L_0x0237:
            double r0 = -r8
            goto L_0x023c
        L_0x0239:
            r2 = 0
            r0 = r17
        L_0x023c:
            if (r7 == 0) goto L_0x0326
            boolean r3 = r7.isEmpty()
            if (r3 != 0) goto L_0x0326
            int[] r3 = com.horcrux.svg.TSpanView.AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline
            int r8 = r15.ordinal()
            r3 = r3[r8]
            r8 = 14
            if (r3 == r8) goto L_0x0326
            r8 = 16
            if (r3 == r8) goto L_0x0326
            int r3 = r7.hashCode()
            r8 = -1720785339(0xffffffff996ee645, float:-1.2350814E-23)
            if (r3 == r8) goto L_0x027c
            r8 = 114240(0x1be40, float:1.60084E-40)
            if (r3 == r8) goto L_0x0272
            r8 = 109801339(0x68b6f7b, float:5.2449795E-35)
            if (r3 == r8) goto L_0x0268
            goto L_0x0286
        L_0x0268:
            java.lang.String r3 = "super"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0286
            r3 = 1
            goto L_0x0287
        L_0x0272:
            java.lang.String r3 = "sub"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0286
            r3 = 0
            goto L_0x0287
        L_0x027c:
            java.lang.String r3 = "baseline"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0286
            r3 = 2
            goto L_0x0287
        L_0x0286:
            r3 = -1
        L_0x0287:
            java.lang.String r8 = "os2"
            java.lang.String r9 = "unitsPerEm"
            java.lang.String r10 = "tables"
            if (r3 == 0) goto L_0x02ea
            r11 = 1
            if (r3 == r11) goto L_0x02ad
            r11 = 2
            if (r3 == r11) goto L_0x0326
            float r3 = r6.mScale
            double r8 = (double) r3
            java.lang.Double.isNaN(r8)
            double r34 = r8 * r42
            float r3 = r6.mScale
            double r8 = (double) r3
            r33 = r7
            r36 = r8
            r38 = r42
            double r7 = com.horcrux.svg.PropHelper.fromRelative(r33, r34, r36, r38)
            double r0 = r0 - r7
            goto L_0x0326
        L_0x02ad:
            if (r12 == 0) goto L_0x0326
            boolean r3 = r12.hasKey(r10)
            if (r3 == 0) goto L_0x0326
            boolean r3 = r12.hasKey(r9)
            if (r3 == 0) goto L_0x0326
            int r3 = r12.getInt(r9)
            com.facebook.react.bridge.ReadableMap r7 = r12.getMap(r10)
            boolean r9 = r7.hasKey(r8)
            if (r9 == 0) goto L_0x0326
            com.facebook.react.bridge.ReadableMap r7 = r7.getMap(r8)
            java.lang.String r8 = "ySuperscriptYOffset"
            boolean r9 = r7.hasKey(r8)
            if (r9 == 0) goto L_0x0326
            double r7 = r7.getDouble(r8)
            float r9 = r6.mScale
            double r9 = (double) r9
            java.lang.Double.isNaN(r9)
            double r9 = r9 * r42
            double r9 = r9 * r7
            double r7 = (double) r3
            java.lang.Double.isNaN(r7)
            double r9 = r9 / r7
            double r0 = r0 - r9
            goto L_0x0326
        L_0x02ea:
            if (r12 == 0) goto L_0x0326
            boolean r3 = r12.hasKey(r10)
            if (r3 == 0) goto L_0x0326
            boolean r3 = r12.hasKey(r9)
            if (r3 == 0) goto L_0x0326
            int r3 = r12.getInt(r9)
            com.facebook.react.bridge.ReadableMap r7 = r12.getMap(r10)
            boolean r9 = r7.hasKey(r8)
            if (r9 == 0) goto L_0x0326
            com.facebook.react.bridge.ReadableMap r7 = r7.getMap(r8)
            java.lang.String r8 = "ySubscriptYOffset"
            boolean r9 = r7.hasKey(r8)
            if (r9 == 0) goto L_0x0326
            double r7 = r7.getDouble(r8)
            float r9 = r6.mScale
            double r9 = (double) r9
            java.lang.Double.isNaN(r9)
            double r9 = r9 * r42
            double r9 = r9 * r7
            double r7 = (double) r3
            java.lang.Double.isNaN(r7)
            double r9 = r9 / r7
            double r0 = r0 + r9
        L_0x0326:
            android.graphics.Matrix r3 = new android.graphics.Matrix
            r3.<init>()
            android.graphics.Matrix r15 = new android.graphics.Matrix
            r15.<init>()
            android.graphics.Matrix r12 = new android.graphics.Matrix
            r12.<init>()
            r7 = 9
            float[] r11 = new float[r7]
            float[] r10 = new float[r7]
            r9 = 0
        L_0x033c:
            if (r9 >= r13) goto L_0x05dc
            char r7 = r19[r9]
            java.lang.String r8 = java.lang.String.valueOf(r7)
            boolean r21 = r28[r9]
            r2 = 0
            if (r21 == 0) goto L_0x0351
            java.lang.String r8 = ""
            r2 = r8
            r36 = r13
            r34 = 0
            goto L_0x0388
        L_0x0351:
            r61 = r8
            r8 = r9
            r24 = 1
            r34 = 0
        L_0x0358:
            int r8 = r8 + 1
            if (r8 >= r13) goto L_0x0383
            r35 = r48[r8]
            int r35 = (r35 > r2 ? 1 : (r35 == r2 ? 0 : -1))
            if (r35 <= 0) goto L_0x0363
            goto L_0x0383
        L_0x0363:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r36 = r13
            r13 = r61
            r2.append(r13)
            char r13 = r19[r8]
            r2.append(r13)
            java.lang.String r61 = r2.toString()
            r2 = 1
            r28[r8] = r2
            r13 = r36
            r2 = 0
            r24 = 1
            r34 = 1
            goto L_0x0358
        L_0x0383:
            r36 = r13
            r13 = r61
            r2 = r13
        L_0x0388:
            float r8 = r14.measureText(r2)
            double r13 = (double) r8
            java.lang.Double.isNaN(r13)
            double r13 = r13 * r51
            if (r27 == 0) goto L_0x03a2
            r8 = r48[r9]
            r37 = r9
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r51
            double r8 = r8 - r13
            r22 = r8
            goto L_0x03a4
        L_0x03a2:
            r37 = r9
        L_0x03a4:
            r8 = 32
            if (r7 != r8) goto L_0x03aa
            r8 = 1
            goto L_0x03ab
        L_0x03aa:
            r8 = 0
        L_0x03ab:
            if (r8 == 0) goto L_0x03b0
            r38 = r25
            goto L_0x03b2
        L_0x03b0:
            r38 = r17
        L_0x03b2:
            double r38 = r38 + r29
            double r38 = r13 + r38
            if (r21 == 0) goto L_0x03bf
            r42 = r7
            r6 = r17
            r9 = r49
            goto L_0x03c9
        L_0x03bf:
            double r42 = r22 + r38
            r9 = r49
            r70 = r42
            r42 = r7
            r6 = r70
        L_0x03c9:
            double r6 = r9.nextX(r6)
            r43 = r0
            double r0 = r9.nextY()
            double r61 = r9.nextDeltaX()
            double r63 = r9.nextDeltaY()
            r65 = r0
            double r0 = r9.nextRotation()
            if (r21 != 0) goto L_0x0596
            if (r8 == 0) goto L_0x03e7
            goto L_0x0596
        L_0x03e7:
            java.lang.Double.isNaN(r4)
            double r38 = r38 * r4
            java.lang.Double.isNaN(r4)
            double r13 = r13 * r4
            double r6 = r6 + r61
            java.lang.Double.isNaN(r4)
            double r6 = r6 * r4
            double r6 = r31 + r6
            double r6 = r6 - r38
            if (r16 == 0) goto L_0x04d6
            r49 = r9
            double r8 = r6 + r13
            double r13 = r13 / r45
            r38 = r0
            double r0 = r6 + r13
            int r21 = (r0 > r59 ? 1 : (r0 == r59 ? 0 : -1))
            if (r21 <= 0) goto L_0x0432
        L_0x040c:
            r8 = r75
            r14 = r10
            r6 = r11
            r1 = r15
            r9 = r20
            r24 = r25
            r33 = r36
            r0 = r47
            r34 = r50
            r15 = r57
            r2 = 1
            r26 = 0
            r10 = r72
            r11 = r74
            r20 = r12
            r70 = r40
            r41 = r37
            r37 = r49
            r39 = r53
            r49 = r70
            goto L_0x05b8
        L_0x0432:
            int r21 = (r0 > r55 ? 1 : (r0 == r55 ? 0 : -1))
            if (r21 >= 0) goto L_0x0437
            goto L_0x040c
        L_0x0437:
            r21 = r2
            r2 = 3
            if (r58 == 0) goto L_0x0448
            float r0 = (float) r0
            r1 = r50
            r1.getMatrix(r0, r15, r2)
            r2 = r1
            r1 = r15
            r67 = r53
            goto L_0x04bd
        L_0x0448:
            r2 = r50
            int r61 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r61 >= 0) goto L_0x045b
            r61 = r13
            r13 = 3
            r14 = 0
            r2.getMatrix(r14, r3, r13)
            float r6 = (float) r6
            r3.preTranslate(r6, r14)
            r13 = 1
            goto L_0x0462
        L_0x045b:
            r61 = r13
            float r6 = (float) r6
            r13 = 1
            r2.getMatrix(r6, r3, r13)
        L_0x0462:
            float r0 = (float) r0
            r2.getMatrix(r0, r15, r13)
            int r0 = (r8 > r53 ? 1 : (r8 == r53 ? 0 : -1))
            if (r0 <= 0) goto L_0x0478
            r0 = r53
            float r6 = (float) r0
            r7 = 3
            r2.getMatrix(r6, r12, r7)
            double r8 = r8 - r0
            float r6 = (float) r8
            r7 = 0
            r12.preTranslate(r6, r7)
            goto L_0x047e
        L_0x0478:
            r0 = r53
            float r6 = (float) r8
            r2.getMatrix(r6, r12, r13)
        L_0x047e:
            r3.getValues(r11)
            r12.getValues(r10)
            r14 = 2
            r6 = r11[r14]
            double r6 = (double) r6
            r8 = 5
            r9 = r11[r8]
            double r8 = (double) r9
            r13 = r10[r14]
            r50 = r15
            double r14 = (double) r13
            r13 = 5
            r13 = r10[r13]
            r67 = r0
            double r0 = (double) r13
            java.lang.Double.isNaN(r14)
            java.lang.Double.isNaN(r6)
            double r14 = r14 - r6
            java.lang.Double.isNaN(r0)
            java.lang.Double.isNaN(r8)
            double r0 = r0 - r8
            double r0 = java.lang.Math.atan2(r0, r14)
            r6 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r0 = r0 * r6
            java.lang.Double.isNaN(r4)
            double r0 = r0 * r4
            float r0 = (float) r0
            r1 = r50
            r1.preRotate(r0)
            r13 = r61
        L_0x04bd:
            double r6 = -r13
            float r0 = (float) r6
            double r6 = r63 + r43
            float r6 = (float) r6
            r1.preTranslate(r0, r6)
            r13 = r40
            float r0 = (float) r13
            r15 = r57
            float r6 = (float) r15
            r1.preScale(r0, r6)
            r8 = r65
            float r0 = (float) r8
            r6 = 0
            r1.postTranslate(r6, r0)
            goto L_0x04f0
        L_0x04d6:
            r38 = r0
            r21 = r2
            r49 = r9
            r1 = r15
            r13 = r40
            r2 = r50
            r67 = r53
            r15 = r57
            r8 = r65
            float r0 = (float) r6
            double r6 = r8 + r63
            double r6 = r6 + r43
            float r6 = (float) r6
            r1.setTranslate(r0, r6)
        L_0x04f0:
            r6 = r38
            float r0 = (float) r6
            r1.preRotate(r0)
            if (r34 == 0) goto L_0x0531
            android.graphics.Path r0 = new android.graphics.Path
            r0.<init>()
            r9 = 0
            int r6 = r21.length()
            r34 = 0
            r38 = 0
            r7 = r74
            r39 = r67
            r8 = r21
            r41 = r37
            r37 = r49
            r49 = r13
            r13 = 1
            r14 = r10
            r10 = r6
            r6 = r11
            r24 = r25
            r26 = 0
            r11 = r34
            r69 = r20
            r20 = r12
            r12 = r38
            r34 = r2
            r33 = r36
            r2 = 1
            r13 = r0
            r7.getTextPath(r8, r9, r10, r11, r12, r13)
            r7 = r0
            r13 = r21
            r0 = r47
            goto L_0x0552
        L_0x0531:
            r34 = r2
            r6 = r11
            r69 = r20
            r24 = r25
            r33 = r36
            r41 = r37
            r7 = r42
            r0 = r47
            r37 = r49
            r39 = r67
            r2 = 1
            r26 = 0
            r20 = r12
            r49 = r13
            r13 = r21
            r14 = r10
            android.graphics.Path r7 = r0.getOrCreateAndCache(r7, r13)
        L_0x0552:
            android.graphics.RectF r8 = new android.graphics.RectF
            r8.<init>()
            r7.computeBounds(r8, r2)
            float r8 = r8.width()
            r9 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x0587
            r75.save()
            r8 = r75
            r8.concat(r1)
            r10 = r72
            java.util.ArrayList<java.lang.String> r7 = r10.emoji
            r7.add(r13)
            java.util.ArrayList<android.graphics.Matrix> r7 = r10.emojiTransforms
            android.graphics.Matrix r11 = new android.graphics.Matrix
            r11.<init>(r1)
            r7.add(r11)
            r11 = r74
            r8.drawText(r13, r9, r9, r11)
            r75.restore()
            r9 = r69
            goto L_0x05b8
        L_0x0587:
            r10 = r72
            r11 = r74
            r8 = r75
            r7.transform(r1)
            r9 = r69
            r9.addPath(r7)
            goto L_0x05b8
        L_0x0596:
            r8 = r75
            r14 = r10
            r6 = r11
            r1 = r15
            r24 = r25
            r33 = r36
            r0 = r47
            r34 = r50
            r15 = r57
            r2 = 1
            r26 = 0
            r10 = r72
            r11 = r74
            r49 = r40
            r39 = r53
            r41 = r37
            r37 = r9
            r9 = r20
            r20 = r12
        L_0x05b8:
            int r7 = r41 + 1
            r47 = r0
            r57 = r15
            r12 = r20
            r25 = r24
            r13 = r33
            r53 = r39
            r40 = r49
            r2 = 0
            r15 = r1
            r20 = r9
            r50 = r34
            r49 = r37
            r0 = r43
            r9 = r7
            r70 = r11
            r11 = r6
            r6 = r10
            r10 = r14
            r14 = r70
            goto L_0x033c
        L_0x05dc:
            r10 = r6
            r9 = r20
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.getLinePath(java.lang.String, android.graphics.Paint, android.graphics.Canvas):android.graphics.Path");
    }

    /* renamed from: com.horcrux.svg.TSpanView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = new int[TextProperties.TextAnchor.values().length];
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust = new int[TextProperties.TextLengthAdjust.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(42:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|(2:41|42)|43|45|46|47|48|(3:49|50|52)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(44:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|(2:35|36)|37|39|40|(2:41|42)|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(45:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|(2:41|42)|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(47:0|(2:1|2)|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Can't wrap try/catch for region: R(48:0|1|2|3|5|6|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|39|40|41|42|43|45|46|47|48|49|50|52) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0035 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x007a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0086 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0092 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x009e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00b6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00d5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00f2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00fc */
        static {
            /*
                com.horcrux.svg.TextProperties$AlignmentBaseline[] r0 = com.horcrux.svg.TextProperties.AlignmentBaseline.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline = r0
                r0 = 1
                int[] r1 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r2 = com.horcrux.svg.TextProperties.AlignmentBaseline.baseline     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x001f }
                com.horcrux.svg.TextProperties$AlignmentBaseline r3 = com.horcrux.svg.TextProperties.AlignmentBaseline.textBottom     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x002a }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.afterEdge     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.textAfterEdge     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0040 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.alphabetic     // Catch:{ NoSuchFieldError -> 0x0040 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0040 }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0040 }
            L_0x0040:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x004b }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.ideographic     // Catch:{ NoSuchFieldError -> 0x004b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0056 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.middle     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r5 = 7
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0062 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.central     // Catch:{ NoSuchFieldError -> 0x0062 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0062 }
                r5 = 8
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0062 }
            L_0x0062:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x006e }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.mathematical     // Catch:{ NoSuchFieldError -> 0x006e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r5 = 9
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x007a }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.hanging     // Catch:{ NoSuchFieldError -> 0x007a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r5 = 10
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0086 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.textTop     // Catch:{ NoSuchFieldError -> 0x0086 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0086 }
                r5 = 11
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0086 }
            L_0x0086:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x0092 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.beforeEdge     // Catch:{ NoSuchFieldError -> 0x0092 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0092 }
                r5 = 12
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0092 }
            L_0x0092:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x009e }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.textBeforeEdge     // Catch:{ NoSuchFieldError -> 0x009e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x009e }
                r5 = 13
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x009e }
            L_0x009e:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x00aa }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.bottom     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r5 = 14
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x00b6 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.center     // Catch:{ NoSuchFieldError -> 0x00b6 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b6 }
                r5 = 15
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00b6 }
            L_0x00b6:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$AlignmentBaseline     // Catch:{ NoSuchFieldError -> 0x00c2 }
                com.horcrux.svg.TextProperties$AlignmentBaseline r4 = com.horcrux.svg.TextProperties.AlignmentBaseline.top     // Catch:{ NoSuchFieldError -> 0x00c2 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c2 }
                r5 = 16
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x00c2 }
            L_0x00c2:
                com.horcrux.svg.TextProperties$TextLengthAdjust[] r3 = com.horcrux.svg.TextProperties.TextLengthAdjust.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust = r3
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust     // Catch:{ NoSuchFieldError -> 0x00d5 }
                com.horcrux.svg.TextProperties$TextLengthAdjust r4 = com.horcrux.svg.TextProperties.TextLengthAdjust.spacing     // Catch:{ NoSuchFieldError -> 0x00d5 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d5 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x00d5 }
            L_0x00d5:
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$TextLengthAdjust     // Catch:{ NoSuchFieldError -> 0x00df }
                com.horcrux.svg.TextProperties$TextLengthAdjust r4 = com.horcrux.svg.TextProperties.TextLengthAdjust.spacingAndGlyphs     // Catch:{ NoSuchFieldError -> 0x00df }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00df }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x00df }
            L_0x00df:
                com.horcrux.svg.TextProperties$TextAnchor[] r3 = com.horcrux.svg.TextProperties.TextAnchor.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = r3
                int[] r3 = $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor     // Catch:{ NoSuchFieldError -> 0x00f2 }
                com.horcrux.svg.TextProperties$TextAnchor r4 = com.horcrux.svg.TextProperties.TextAnchor.start     // Catch:{ NoSuchFieldError -> 0x00f2 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f2 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x00f2 }
            L_0x00f2:
                int[] r0 = $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.horcrux.svg.TextProperties$TextAnchor r3 = com.horcrux.svg.TextProperties.TextAnchor.middle     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor     // Catch:{ NoSuchFieldError -> 0x0106 }
                com.horcrux.svg.TextProperties$TextAnchor r1 = com.horcrux.svg.TextProperties.TextAnchor.end     // Catch:{ NoSuchFieldError -> 0x0106 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0106 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0106 }
            L_0x0106:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.AnonymousClass1.<clinit>():void");
        }
    }

    private double getAbsoluteStartOffset(SVGLength sVGLength, double d, double d2) {
        return PropHelper.fromRelative(sVGLength, d, 0.0d, (double) this.mScale, d2);
    }

    private double getTextAnchorOffset(TextProperties.TextAnchor textAnchor, double d) {
        int i = AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[textAnchor.ordinal()];
        if (i == 2) {
            return (-d) / 2.0d;
        }
        if (i != 3) {
            return 0.0d;
        }
        return -d;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:28|29) */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r0 = android.graphics.Typeface.create(android.graphics.Typeface.createFromAsset(r10.assets, r7), r2);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00c5 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void applyTextPropertiesToPaint(android.graphics.Paint r11, com.horcrux.svg.FontData r12) {
        /*
            r10 = this;
            com.horcrux.svg.TextProperties$FontWeight r0 = r12.fontWeight
            com.horcrux.svg.TextProperties$FontWeight r1 = com.horcrux.svg.TextProperties.FontWeight.Bold
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0011
            int r0 = r12.absoluteFontWeight
            r1 = 550(0x226, float:7.71E-43)
            if (r0 < r1) goto L_0x000f
            goto L_0x0011
        L_0x000f:
            r0 = 0
            goto L_0x0012
        L_0x0011:
            r0 = 1
        L_0x0012:
            com.horcrux.svg.TextProperties$FontStyle r1 = r12.fontStyle
            com.horcrux.svg.TextProperties$FontStyle r4 = com.horcrux.svg.TextProperties.FontStyle.italic
            if (r1 != r4) goto L_0x001a
            r1 = 1
            goto L_0x001b
        L_0x001a:
            r1 = 0
        L_0x001b:
            if (r0 == 0) goto L_0x0021
            if (r1 == 0) goto L_0x0021
            r2 = 3
            goto L_0x0028
        L_0x0021:
            if (r0 == 0) goto L_0x0025
            r2 = 1
            goto L_0x0028
        L_0x0025:
            if (r1 == 0) goto L_0x0028
            r2 = 2
        L_0x0028:
            r0 = 0
            int r4 = r12.absoluteFontWeight
            java.lang.String r5 = r12.fontFamily
            if (r5 == 0) goto L_0x00d1
            int r6 = r5.length()
            if (r6 <= 0) goto L_0x00d1
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "fonts/"
            r6.append(r7)
            r6.append(r5)
            java.lang.String r8 = ".otf"
            r6.append(r8)
            java.lang.String r6 = r6.toString()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r7)
            r8.append(r5)
            java.lang.String r7 = ".ttf"
            r8.append(r7)
            java.lang.String r7 = r8.toString()
            int r8 = android.os.Build.VERSION.SDK_INT
            r9 = 26
            if (r8 < r9) goto L_0x00ba
            android.graphics.Typeface$Builder r0 = new android.graphics.Typeface$Builder
            android.content.res.AssetManager r8 = r10.assets
            r0.<init>(r8, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r8 = "'wght' "
            r6.append(r8)
            r6.append(r4)
            java.lang.String r9 = r12.fontVariationSettings
            r6.append(r9)
            java.lang.String r6 = r6.toString()
            r0.setFontVariationSettings(r6)
            r0.setWeight(r4)
            r0.setItalic(r1)
            android.graphics.Typeface r0 = r0.build()
            if (r0 != 0) goto L_0x00d1
            android.graphics.Typeface$Builder r0 = new android.graphics.Typeface$Builder
            android.content.res.AssetManager r6 = r10.assets
            r0.<init>(r6, r7)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r8)
            r6.append(r4)
            java.lang.String r7 = r12.fontVariationSettings
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r0.setFontVariationSettings(r6)
            r0.setWeight(r4)
            r0.setItalic(r1)
            android.graphics.Typeface r0 = r0.build()
            goto L_0x00d1
        L_0x00ba:
            android.content.res.AssetManager r8 = r10.assets     // Catch:{ Exception -> 0x00c5 }
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromAsset(r8, r6)     // Catch:{ Exception -> 0x00c5 }
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r2)     // Catch:{ Exception -> 0x00c5 }
            goto L_0x00d1
        L_0x00c5:
            android.content.res.AssetManager r6 = r10.assets     // Catch:{ Exception -> 0x00d0 }
            android.graphics.Typeface r0 = android.graphics.Typeface.createFromAsset(r6, r7)     // Catch:{ Exception -> 0x00d0 }
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r2)     // Catch:{ Exception -> 0x00d0 }
            goto L_0x00d1
        L_0x00d0:
        L_0x00d1:
            if (r0 != 0) goto L_0x00dd
            com.facebook.react.views.text.ReactFontManager r6 = com.facebook.react.views.text.ReactFontManager.getInstance()     // Catch:{ Exception -> 0x00dd }
            android.content.res.AssetManager r7 = r10.assets     // Catch:{ Exception -> 0x00dd }
            android.graphics.Typeface r0 = r6.getTypeface(r5, r2, r7)     // Catch:{ Exception -> 0x00dd }
        L_0x00dd:
            int r2 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r2 < r5) goto L_0x00e7
            android.graphics.Typeface r0 = android.graphics.Typeface.create(r0, r4, r1)
        L_0x00e7:
            r11.setLinearText(r3)
            r11.setSubpixelText(r3)
            r11.setTypeface(r0)
            double r0 = r12.fontSize
            float r12 = r10.mScale
            double r2 = (double) r12
            java.lang.Double.isNaN(r2)
            double r0 = r0 * r2
            float r12 = (float) r0
            r11.setTextSize(r12)
            int r12 = android.os.Build.VERSION.SDK_INT
            r0 = 21
            if (r12 < r0) goto L_0x0108
            r12 = 0
            r11.setLetterSpacing(r12)
        L_0x0108:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TSpanView.applyTextPropertiesToPaint(android.graphics.Paint, com.horcrux.svg.FontData):void");
    }

    private void setupTextPath() {
        ViewParent parent = getParent();
        while (parent != null) {
            if (parent.getClass() == TextPathView.class) {
                this.textPath = (TextPathView) parent;
                return;
            } else if (parent instanceof TextView) {
                parent = parent.getParent();
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int hitTest(float[] fArr) {
        if (this.mContent == null) {
            return super.hitTest(fArr);
        }
        if (this.mPath != null && this.mInvertible && this.mTransformInvertible) {
            float[] fArr2 = new float[2];
            this.mInvMatrix.mapPoints(fArr2, fArr);
            this.mInvTransform.mapPoints(fArr2);
            int round = Math.round(fArr2[0]);
            int round2 = Math.round(fArr2[1]);
            initBounds();
            if ((this.mRegion != null && this.mRegion.contains(round, round2)) || (this.mStrokeRegion != null && this.mStrokeRegion.contains(round, round2))) {
                if (getClipPath() == null || this.mClipRegion.contains(round, round2)) {
                    return getId();
                }
                return -1;
            }
        }
        return -1;
    }
}
