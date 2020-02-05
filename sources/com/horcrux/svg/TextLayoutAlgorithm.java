package com.horcrux.svg;

import android.view.View;
import com.horcrux.svg.TextProperties;
import java.util.ArrayList;

class TextLayoutAlgorithm {
    TextLayoutAlgorithm() {
    }

    class CharacterInformation {
        boolean addressable = true;
        double advance;
        boolean anchoredChunk = false;
        char character;
        TextView element;
        boolean firstCharacterInResolvedDescendant = false;
        boolean hidden = false;
        int index;
        boolean middle = false;
        boolean resolved = false;
        double rotate = 0.0d;
        boolean rotateSpecified = false;
        double x = 0.0d;
        boolean xSpecified = false;
        double y = 0.0d;
        boolean ySpecified = false;

        CharacterInformation(int i, char c) {
            this.index = i;
            this.character = c;
        }
    }

    class LayoutInput {
        boolean horizontal;
        TextView text;

        LayoutInput() {
        }
    }

    private void getSubTreeTypographicCharacterPositions(ArrayList<TextPathView> arrayList, ArrayList<TextView> arrayList2, StringBuilder sb, View view, TextPathView textPathView) {
        int i = 0;
        if (view instanceof TSpanView) {
            TSpanView tSpanView = (TSpanView) view;
            String str = tSpanView.mContent;
            if (str == null) {
                while (i < tSpanView.getChildCount()) {
                    getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, tSpanView.getChildAt(i), textPathView);
                    i++;
                }
                return;
            }
            while (i < str.length()) {
                arrayList2.add(tSpanView);
                arrayList.add(textPathView);
                i++;
            }
            sb.append(str);
            return;
        }
        if (view instanceof TextPathView) {
            textPathView = (TextPathView) view;
        }
        while (i < textPathView.getChildCount()) {
            getSubTreeTypographicCharacterPositions(arrayList, arrayList2, sb, textPathView.getChildAt(i), textPathView);
            i++;
        }
    }

    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v4, types: [android.graphics.Canvas, android.graphics.Paint] */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x02c6, code lost:
        if (r9 > (r13 / 2.0d)) goto L_0x02c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01a0, code lost:
        if (r18 == Double.POSITIVE_INFINITY) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01a7, code lost:
        if (r4 == (r10 - 1)) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01a9, code lost:
        r12 = com.horcrux.svg.TextProperties.TextAnchor.start;
        r13 = com.horcrux.svg.TextProperties.Direction.ltr;
        r14 = r10 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01af, code lost:
        if (r4 != r14) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01b1, code lost:
        r16 = r0;
        r18 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b5, code lost:
        r2 = r11[r8].x;
        r12 = com.horcrux.svg.TextLayoutAlgorithm.AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor[r12.ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01c2, code lost:
        if (r12 == 1) goto L_0x01d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01c5, code lost:
        if (r12 == 2) goto L_0x01d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01c8, code lost:
        if (r12 == 3) goto L_0x01cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01cd, code lost:
        if (r13 != com.horcrux.svg.TextProperties.Direction.ltr) goto L_0x01dc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01d0, code lost:
        r12 = com.horcrux.svg.TextProperties.Direction.ltr;
        r2 = r2 - ((r18 + r16) / 2.0d);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x01da, code lost:
        if (r13 != com.horcrux.svg.TextProperties.Direction.ltr) goto L_0x01df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01dc, code lost:
        r2 = r2 - r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01df, code lost:
        r2 = r2 - r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01e1, code lost:
        if (r4 != r14) goto L_0x01e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01e3, code lost:
        r12 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01e5, code lost:
        r12 = r4 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01e7, code lost:
        if (r8 > r12) goto L_0x01f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01e9, code lost:
        r11[r8].x += r2;
        r8 = r8 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x01f3, code lost:
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01f4, code lost:
        r20 = r16;
        r16 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.horcrux.svg.TextLayoutAlgorithm.CharacterInformation[] layoutText(com.horcrux.svg.TextLayoutAlgorithm.LayoutInput r27) {
        /*
            r26 = this;
            r7 = r26
            r0 = r27
            com.horcrux.svg.TextView r8 = r0.text
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            r5 = 0
            r0 = r26
            r1 = r9
            r3 = r6
            r4 = r8
            r0.getSubTreeTypographicCharacterPositions(r1, r2, r3, r4, r5)
            java.lang.String r0 = r6.toString()
            char[] r0 = r0.toCharArray()
            int r10 = r0.length
            com.horcrux.svg.TextLayoutAlgorithm$CharacterInformation[] r11 = new com.horcrux.svg.TextLayoutAlgorithm.CharacterInformation[r10]
            r12 = 0
            r1 = 0
        L_0x002b:
            if (r1 >= r10) goto L_0x0039
            com.horcrux.svg.TextLayoutAlgorithm$CharacterInformation r2 = new com.horcrux.svg.TextLayoutAlgorithm$CharacterInformation
            char r3 = r0[r1]
            r2.<init>(r1, r3)
            r11[r1] = r2
            int r1 = r1 + 1
            goto L_0x002b
        L_0x0039:
            if (r10 != 0) goto L_0x003c
            return r11
        L_0x003c:
            android.graphics.PointF[] r13 = new android.graphics.PointF[r10]
            r0 = 0
        L_0x003f:
            r14 = 0
            if (r0 >= r10) goto L_0x004c
            android.graphics.PointF r1 = new android.graphics.PointF
            r1.<init>(r14, r14)
            r13[r0] = r1
            int r0 = r0 + 1
            goto L_0x003f
        L_0x004c:
            r0 = 0
        L_0x004d:
            r15 = 1
            if (r0 >= r10) goto L_0x0080
            r1 = r11[r0]
            r1.addressable = r15
            r1 = r11[r0]
            r1.middle = r12
            r1 = r11[r0]
            if (r0 != 0) goto L_0x005d
            goto L_0x005e
        L_0x005d:
            r15 = 0
        L_0x005e:
            r1.anchoredChunk = r15
            r1 = r11[r0]
            boolean r1 = r1.addressable
            if (r1 == 0) goto L_0x0072
            r1 = r11[r0]
            boolean r1 = r1.middle
            if (r1 != 0) goto L_0x0072
            r1 = r13[r0]
            r1.set(r14, r14)
            goto L_0x007d
        L_0x0072:
            if (r0 <= 0) goto L_0x007d
            r1 = r13[r0]
            int r2 = r0 + -1
            r2 = r13[r2]
            r1.set(r2)
        L_0x007d:
            int r0 = r0 + 1
            goto L_0x004d
        L_0x0080:
            java.lang.String[] r6 = new java.lang.String[r10]
            java.lang.String[] r5 = new java.lang.String[r10]
            java.lang.String[] r4 = new java.lang.String[r10]
            java.lang.String[] r3 = new java.lang.String[r10]
            com.horcrux.svg.TextLayoutAlgorithm$1CharacterPositioningResolver r0 = new com.horcrux.svg.TextLayoutAlgorithm$1CharacterPositioningResolver
            r1 = r26
            r2 = r11
            r16 = r3
            r3 = r6
            r17 = r4
            r4 = r5
            r18 = r5
            r5 = r17
            r17 = r6
            r6 = r16
            r0.<init>(r2, r3, r4, r5, r6)
            android.graphics.PointF r0 = new android.graphics.PointF
            r0.<init>(r14, r14)
            r1 = 0
        L_0x00a4:
            if (r1 >= r10) goto L_0x00ef
            r2 = r17[r1]
            java.lang.String r3 = ""
            boolean r2 = r2.equals(r3)
            java.lang.String r4 = "0"
            if (r2 == 0) goto L_0x00b4
            r17[r1] = r4
        L_0x00b4:
            r2 = r18[r1]
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00be
            r18[r1] = r4
        L_0x00be:
            float r2 = r0.x
            r3 = r17[r1]
            float r3 = java.lang.Float.parseFloat(r3)
            float r2 = r2 + r3
            r0.x = r2
            float r2 = r0.y
            r3 = r18[r1]
            float r3 = java.lang.Float.parseFloat(r3)
            float r2 = r2 + r3
            r0.y = r2
            r2 = r11[r1]
            r3 = r13[r1]
            float r3 = r3.x
            float r4 = r0.x
            float r3 = r3 + r4
            double r3 = (double) r3
            r2.x = r3
            r2 = r11[r1]
            r3 = r13[r1]
            float r3 = r3.y
            float r4 = r0.y
            float r3 = r3 + r4
            double r3 = (double) r3
            r2.y = r3
            int r1 = r1 + 1
            goto L_0x00a4
        L_0x00ef:
            com.horcrux.svg.TextLayoutAlgorithm$1TextLengthResolver r1 = new com.horcrux.svg.TextLayoutAlgorithm$1TextLengthResolver
            r1.<init>(r11)
            r1.resolveTextLength(r8)
            r0.set(r14, r14)
            r1 = 1
        L_0x00fb:
            if (r1 >= r10) goto L_0x0154
            r2 = r17[r1]
            if (r2 == 0) goto L_0x010f
            r2 = r17[r1]
            double r2 = java.lang.Double.parseDouble(r2)
            r4 = r11[r1]
            double r4 = r4.x
            double r2 = r2 - r4
            float r2 = (float) r2
            r0.x = r2
        L_0x010f:
            r2 = r18[r1]
            if (r2 == 0) goto L_0x0121
            r2 = r18[r1]
            double r2 = java.lang.Double.parseDouble(r2)
            r4 = r11[r1]
            double r4 = r4.y
            double r2 = r2 - r4
            float r2 = (float) r2
            r0.y = r2
        L_0x0121:
            r2 = r11[r1]
            double r3 = r2.x
            float r5 = r0.x
            double r5 = (double) r5
            java.lang.Double.isNaN(r5)
            double r3 = r3 + r5
            r2.x = r3
            r2 = r11[r1]
            double r3 = r2.y
            float r5 = r0.y
            double r5 = (double) r5
            java.lang.Double.isNaN(r5)
            double r3 = r3 + r5
            r2.y = r3
            r2 = r11[r1]
            boolean r2 = r2.middle
            if (r2 == 0) goto L_0x014b
            r2 = r11[r1]
            boolean r2 = r2.anchoredChunk
            if (r2 == 0) goto L_0x014b
            r2 = r11[r1]
            r2.anchoredChunk = r12
        L_0x014b:
            int r1 = r1 + 1
            if (r1 >= r10) goto L_0x00fb
            r2 = r11[r1]
            r2.anchoredChunk = r15
            goto L_0x00fb
        L_0x0154:
            r4 = 0
            r5 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r8 = 0
            r16 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            r18 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r20 = -4503599627370496(0xfff0000000000000, double:-Infinity)
        L_0x015e:
            r22 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r4 >= r10) goto L_0x01ff
            r1 = r11[r4]
            boolean r1 = r1.addressable
            if (r1 != 0) goto L_0x016a
            goto L_0x01f8
        L_0x016a:
            r1 = r11[r4]
            boolean r1 = r1.anchoredChunk
            if (r1 == 0) goto L_0x0177
            r18 = r5
            r5 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            r12 = -4503599627370496(0xfff0000000000000, double:-Infinity)
            goto L_0x017b
        L_0x0177:
            r12 = r16
            r16 = r20
        L_0x017b:
            r1 = r11[r4]
            double r0 = r1.x
            r14 = r11[r4]
            double r2 = r14.advance
            double r2 = r2 + r0
            double r14 = java.lang.Math.min(r0, r2)
            double r5 = java.lang.Math.min(r5, r14)
            double r0 = java.lang.Math.max(r0, r2)
            double r0 = java.lang.Math.max(r12, r0)
            if (r4 <= 0) goto L_0x01a3
            r2 = r11[r4]
            boolean r2 = r2.anchoredChunk
            if (r2 == 0) goto L_0x01a3
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
            int r12 = (r18 > r2 ? 1 : (r18 == r2 ? 0 : -1))
            if (r12 != 0) goto L_0x01a9
            goto L_0x01a5
        L_0x01a3:
            r2 = 9218868437227405312(0x7ff0000000000000, double:Infinity)
        L_0x01a5:
            int r12 = r10 + -1
            if (r4 != r12) goto L_0x01f4
        L_0x01a9:
            com.horcrux.svg.TextProperties$TextAnchor r12 = com.horcrux.svg.TextProperties.TextAnchor.start
            com.horcrux.svg.TextProperties$Direction r13 = com.horcrux.svg.TextProperties.Direction.ltr
            int r14 = r10 + -1
            if (r4 != r14) goto L_0x01b5
            r16 = r0
            r18 = r5
        L_0x01b5:
            r15 = r11[r8]
            double r2 = r15.x
            int[] r15 = com.horcrux.svg.TextLayoutAlgorithm.AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor
            int r12 = r12.ordinal()
            r12 = r15[r12]
            r15 = 1
            if (r12 == r15) goto L_0x01d8
            r15 = 2
            if (r12 == r15) goto L_0x01d0
            r15 = 3
            if (r12 == r15) goto L_0x01cb
            goto L_0x01e1
        L_0x01cb:
            com.horcrux.svg.TextProperties$Direction r12 = com.horcrux.svg.TextProperties.Direction.ltr
            if (r13 != r12) goto L_0x01dc
            goto L_0x01df
        L_0x01d0:
            com.horcrux.svg.TextProperties$Direction r12 = com.horcrux.svg.TextProperties.Direction.ltr
            double r12 = r18 + r16
            double r12 = r12 / r22
            double r2 = r2 - r12
            goto L_0x01e1
        L_0x01d8:
            com.horcrux.svg.TextProperties$Direction r12 = com.horcrux.svg.TextProperties.Direction.ltr
            if (r13 != r12) goto L_0x01df
        L_0x01dc:
            double r2 = r2 - r18
            goto L_0x01e1
        L_0x01df:
            double r2 = r2 - r16
        L_0x01e1:
            if (r4 != r14) goto L_0x01e5
            r12 = r4
            goto L_0x01e7
        L_0x01e5:
            int r12 = r4 + -1
        L_0x01e7:
            if (r8 > r12) goto L_0x01f3
            r13 = r11[r8]
            double r14 = r13.x
            double r14 = r14 + r2
            r13.x = r14
            int r8 = r8 + 1
            goto L_0x01e7
        L_0x01f3:
            r8 = r4
        L_0x01f4:
            r20 = r16
            r16 = r0
        L_0x01f8:
            int r4 = r4 + 1
            r12 = 0
            r14 = 0
            r15 = 1
            goto L_0x015e
        L_0x01ff:
            android.graphics.PointF r0 = new android.graphics.PointF
            r2 = 0
            r0.<init>(r2, r2)
            android.graphics.PathMeasure r2 = new android.graphics.PathMeasure
            r2.<init>()
            r3 = 0
            r5 = r3
            r4 = 0
            r6 = 0
            r15 = 0
        L_0x020f:
            if (r4 >= r10) goto L_0x03ca
            java.lang.Object r12 = r9.get(r4)
            com.horcrux.svg.TextPathView r12 = (com.horcrux.svg.TextPathView) r12
            if (r12 == 0) goto L_0x0365
            r13 = r11[r4]
            boolean r13 = r13.addressable
            if (r13 == 0) goto L_0x0365
            android.graphics.Path r5 = r12.getTextPath(r3, r3)
            r6 = r11[r4]
            boolean r6 = r6.middle
            if (r6 != 0) goto L_0x033d
            r12.getSide()
            com.horcrux.svg.TextProperties$TextPathSide r6 = com.horcrux.svg.TextProperties.TextPathSide.right
            r6 = 0
            r2.setPath(r5, r6)
            float r6 = r2.getLength()
            double r13 = (double) r6
            com.horcrux.svg.SVGLength r6 = r12.getStartOffset()
            r16 = r2
            double r1 = r6.value
            r6 = r11[r4]
            r17 = r5
            double r5 = r6.advance
            r3 = r11[r4]
            r19 = r9
            r24 = r10
            double r9 = r3.x
            r3 = r11[r4]
            r25 = r8
            double r7 = r3.y
            r3 = r11[r4]
            double r7 = r3.rotate
            double r5 = r5 / r22
            double r9 = r9 + r5
            double r9 = r9 + r1
            boolean r1 = r16.isClosed()
            r2 = 0
            if (r1 != 0) goto L_0x0270
            int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x026b
            int r1 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x0270
        L_0x026b:
            r1 = r11[r4]
            r5 = 1
            r1.hidden = r5
        L_0x0270:
            boolean r1 = r16.isClosed()
            if (r1 == 0) goto L_0x02f3
            com.horcrux.svg.TextProperties$TextAnchor r1 = com.horcrux.svg.TextProperties.TextAnchor.start
            com.horcrux.svg.TextProperties$Direction r5 = com.horcrux.svg.TextProperties.Direction.ltr
            r6 = r11[r25]
            double r6 = r6.x
            int[] r6 = com.horcrux.svg.TextLayoutAlgorithm.AnonymousClass1.$SwitchMap$com$horcrux$svg$TextProperties$TextAnchor
            int r1 = r1.ordinal()
            r1 = r6[r1]
            r6 = 1
            if (r1 == r6) goto L_0x02ce
            r6 = 2
            if (r1 == r6) goto L_0x02b4
            r7 = 3
            if (r1 == r7) goto L_0x0290
            goto L_0x02f4
        L_0x0290:
            com.horcrux.svg.TextProperties$Direction r1 = com.horcrux.svg.TextProperties.Direction.ltr
            if (r5 != r1) goto L_0x02a6
            java.lang.Double.isNaN(r13)
            double r5 = -r13
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x02a0
            int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x02f4
        L_0x02a0:
            r1 = r11[r4]
            r5 = 1
            r1.hidden = r5
            goto L_0x02f4
        L_0x02a6:
            r5 = 1
            int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x02af
            int r1 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x02f4
        L_0x02af:
            r1 = r11[r4]
            r1.hidden = r5
            goto L_0x02f4
        L_0x02b4:
            r7 = 3
            java.lang.Double.isNaN(r13)
            double r1 = -r13
            double r1 = r1 / r22
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x02c8
            java.lang.Double.isNaN(r13)
            double r1 = r13 / r22
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x02f4
        L_0x02c8:
            r1 = r11[r4]
            r2 = 1
            r1.hidden = r2
            goto L_0x02f4
        L_0x02ce:
            r7 = 3
            com.horcrux.svg.TextProperties$Direction r1 = com.horcrux.svg.TextProperties.Direction.ltr
            if (r5 != r1) goto L_0x02e1
            int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x02db
            int r1 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r1 <= 0) goto L_0x02f4
        L_0x02db:
            r1 = r11[r4]
            r2 = 1
            r1.hidden = r2
            goto L_0x02f4
        L_0x02e1:
            java.lang.Double.isNaN(r13)
            double r5 = -r13
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x02ed
            int r1 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x02f4
        L_0x02ed:
            r1 = r11[r4]
            r2 = 1
            r1.hidden = r2
            goto L_0x02f4
        L_0x02f3:
            r7 = 3
        L_0x02f4:
            java.lang.Double.isNaN(r13)
            double r9 = r9 % r13
            r1 = r11[r4]
            boolean r1 = r1.hidden
            if (r1 != 0) goto L_0x033a
            r1 = 2
            float[] r2 = new float[r1]
            float[] r3 = new float[r1]
            float r1 = (float) r9
            r8 = r16
            r8.getPosTan(r1, r2, r3)
            r1 = 1
            r2 = r3[r1]
            double r1 = (double) r2
            r5 = 0
            r3 = r3[r5]
            double r9 = (double) r3
            double r1 = java.lang.Math.atan2(r1, r9)
            r9 = 4633260481411531256(0x404ca5dc1a63c1f8, double:57.29577951308232)
            double r1 = r1 * r9
            r9 = 4636033603912859648(0x4056800000000000, double:90.0)
            double r9 = r9 + r1
            r3 = 2
            double[] r6 = new double[r3]
            double r13 = java.lang.Math.cos(r9)
            r6[r5] = r13
            double r9 = java.lang.Math.sin(r9)
            r3 = 1
            r6[r3] = r9
            r3 = r11[r4]
            double r5 = r3.rotate
            double r5 = r5 + r1
            r3.rotate = r5
            goto L_0x0361
        L_0x033a:
            r8 = r16
            goto L_0x0361
        L_0x033d:
            r17 = r5
            r25 = r8
            r19 = r9
            r24 = r10
            r7 = 3
            r8 = r2
            r1 = r11[r4]
            int r2 = r4 + -1
            r3 = r11[r2]
            double r5 = r3.x
            r1.x = r5
            r1 = r11[r4]
            r3 = r11[r2]
            double r5 = r3.y
            r1.y = r5
            r1 = r11[r4]
            r2 = r11[r2]
            double r2 = r2.rotate
            r1.rotate = r2
        L_0x0361:
            r5 = r17
            r6 = 1
            goto L_0x036d
        L_0x0365:
            r25 = r8
            r19 = r9
            r24 = r10
            r7 = 3
            r8 = r2
        L_0x036d:
            if (r12 != 0) goto L_0x03ba
            r1 = r11[r4]
            boolean r1 = r1.addressable
            if (r1 == 0) goto L_0x03ba
            if (r6 == 0) goto L_0x0391
            r1 = 0
            r8.setPath(r5, r1)
            r2 = 2
            float[] r3 = new float[r2]
            float r6 = r8.getLength()
            r9 = 0
            r8.getPosTan(r6, r3, r9)
            r6 = r3[r1]
            r10 = 1
            r3 = r3[r10]
            r0.set(r6, r3)
            r6 = 0
            r15 = 1
            goto L_0x0395
        L_0x0391:
            r1 = 0
            r2 = 2
            r9 = 0
            r10 = 1
        L_0x0395:
            if (r15 == 0) goto L_0x03bc
            r3 = r11[r4]
            boolean r3 = r3.anchoredChunk
            if (r3 == 0) goto L_0x039f
            r15 = 0
            goto L_0x03bc
        L_0x039f:
            r3 = r11[r4]
            double r12 = r3.x
            float r14 = r0.x
            double r1 = (double) r14
            java.lang.Double.isNaN(r1)
            double r12 = r12 + r1
            r3.x = r12
            r1 = r11[r4]
            double r2 = r1.y
            float r12 = r0.y
            double r12 = (double) r12
            java.lang.Double.isNaN(r12)
            double r2 = r2 + r12
            r1.y = r2
            goto L_0x03bc
        L_0x03ba:
            r9 = 0
            r10 = 1
        L_0x03bc:
            int r4 = r4 + 1
            r7 = r26
            r2 = r8
            r3 = r9
            r9 = r19
            r10 = r24
            r8 = r25
            goto L_0x020f
        L_0x03ca:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TextLayoutAlgorithm.layoutText(com.horcrux.svg.TextLayoutAlgorithm$LayoutInput):com.horcrux.svg.TextLayoutAlgorithm$CharacterInformation[]");
    }

    /* renamed from: com.horcrux.svg.TextLayoutAlgorithm$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = new int[TextProperties.TextAnchor.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.horcrux.svg.TextProperties$TextAnchor[] r0 = com.horcrux.svg.TextProperties.TextAnchor.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor = r0
                int[] r0 = $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.horcrux.svg.TextProperties$TextAnchor r1 = com.horcrux.svg.TextProperties.TextAnchor.start     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor     // Catch:{ NoSuchFieldError -> 0x001f }
                com.horcrux.svg.TextProperties$TextAnchor r1 = com.horcrux.svg.TextProperties.TextAnchor.middle     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = $SwitchMap$com$horcrux$svg$TextProperties$TextAnchor     // Catch:{ NoSuchFieldError -> 0x002a }
                com.horcrux.svg.TextProperties$TextAnchor r1 = com.horcrux.svg.TextProperties.TextAnchor.end     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.TextLayoutAlgorithm.AnonymousClass1.<clinit>():void");
        }
    }
}
