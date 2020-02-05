package com.horcrux.svg;

import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.SVGLength;

class PropHelper {
    private static final int inputMatrixDataSize = 6;

    PropHelper() {
    }

    static int toMatrixData(ReadableArray readableArray, float[] fArr, float f) {
        int size = readableArray.size();
        if (size != 6) {
            return size;
        }
        fArr[0] = (float) readableArray.getDouble(0);
        fArr[1] = (float) readableArray.getDouble(2);
        fArr[2] = ((float) readableArray.getDouble(4)) * f;
        fArr[3] = (float) readableArray.getDouble(1);
        fArr[4] = (float) readableArray.getDouble(3);
        fArr[5] = ((float) readableArray.getDouble(5)) * f;
        return 6;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00a8, code lost:
        r12 = 1.0d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00c1, code lost:
        r7 = java.lang.Double.valueOf(r7.substring(0, r8)).doubleValue() * r12;
     */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static double fromRelative(java.lang.String r7, double r8, double r10, double r12) {
        /*
            java.lang.String r7 = r7.trim()
            int r0 = r7.length()
            int r1 = r0 + -1
            if (r0 == 0) goto L_0x00db
            java.lang.String r2 = "normal"
            boolean r2 = r7.equals(r2)
            if (r2 == 0) goto L_0x0016
            goto L_0x00db
        L_0x0016:
            int r2 = r7.codePointAt(r1)
            r3 = 37
            r4 = 0
            if (r2 != r3) goto L_0x0031
            java.lang.String r7 = r7.substring(r4, r1)
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            double r10 = r7.doubleValue()
            r12 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r10 = r10 / r12
            double r10 = r10 * r8
            return r10
        L_0x0031:
            int r8 = r0 + -2
            if (r8 <= 0) goto L_0x00d2
            java.lang.String r9 = r7.substring(r8)
            r1 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            r3 = -1
            int r5 = r9.hashCode()
            r6 = 3178(0xc6a, float:4.453E-42)
            if (r5 == r6) goto L_0x0099
            r6 = 3240(0xca8, float:4.54E-42)
            if (r5 == r6) goto L_0x008f
            r6 = 3365(0xd25, float:4.715E-42)
            if (r5 == r6) goto L_0x0085
            r6 = 3488(0xda0, float:4.888E-42)
            if (r5 == r6) goto L_0x007b
            r6 = 3571(0xdf3, float:5.004E-42)
            if (r5 == r6) goto L_0x0071
            r6 = 3588(0xe04, float:5.028E-42)
            if (r5 == r6) goto L_0x0067
            r6 = 3592(0xe08, float:5.033E-42)
            if (r5 == r6) goto L_0x005d
            goto L_0x00a3
        L_0x005d:
            java.lang.String r5 = "px"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x00a3
            r9 = 0
            goto L_0x00a4
        L_0x0067:
            java.lang.String r5 = "pt"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x00a3
            r9 = 2
            goto L_0x00a4
        L_0x0071:
            java.lang.String r5 = "pc"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x00a3
            r9 = 3
            goto L_0x00a4
        L_0x007b:
            java.lang.String r5 = "mm"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x00a3
            r9 = 4
            goto L_0x00a4
        L_0x0085:
            java.lang.String r5 = "in"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x00a3
            r9 = 6
            goto L_0x00a4
        L_0x008f:
            java.lang.String r5 = "em"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x00a3
            r9 = 1
            goto L_0x00a4
        L_0x0099:
            java.lang.String r5 = "cm"
            boolean r9 = r9.equals(r5)
            if (r9 == 0) goto L_0x00a3
            r9 = 5
            goto L_0x00a4
        L_0x00a3:
            r9 = -1
        L_0x00a4:
            switch(r9) {
                case 0: goto L_0x00a8;
                case 1: goto L_0x00c1;
                case 2: goto L_0x00bf;
                case 3: goto L_0x00bc;
                case 4: goto L_0x00b6;
                case 5: goto L_0x00b0;
                case 6: goto L_0x00aa;
                default: goto L_0x00a7;
            }
        L_0x00a7:
            r8 = r0
        L_0x00a8:
            r12 = r1
            goto L_0x00c1
        L_0x00aa:
            r12 = 4636033603912859648(0x4056800000000000, double:90.0)
            goto L_0x00c1
        L_0x00b0:
            r12 = 4630183578586017914(0x4041b76ed677707a, double:35.43307)
            goto L_0x00c1
        L_0x00b6:
            r12 = 4615161236842447043(0x400c58b1572580c3, double:3.543307)
            goto L_0x00c1
        L_0x00bc:
            r12 = 4624633867356078080(0x402e000000000000, double:15.0)
            goto L_0x00c1
        L_0x00bf:
            r12 = 4608308318706860032(0x3ff4000000000000, double:1.25)
        L_0x00c1:
            java.lang.String r7 = r7.substring(r4, r8)
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            double r7 = r7.doubleValue()
            double r7 = r7 * r12
        L_0x00cf:
            double r7 = r7 * r10
            return r7
        L_0x00d2:
            java.lang.Double r7 = java.lang.Double.valueOf(r7)
            double r7 = r7.doubleValue()
            goto L_0x00cf
        L_0x00db:
            r7 = 0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.PropHelper.fromRelative(java.lang.String, double, double, double):double");
    }

    static double fromRelative(SVGLength sVGLength, double d, double d2, double d3, double d4) {
        double d5;
        if (sVGLength == null) {
            return d2;
        }
        SVGLength.UnitType unitType = sVGLength.unit;
        double d6 = sVGLength.value;
        switch (unitType) {
            case NUMBER:
            case PX:
                d4 = 1.0d;
                break;
            case PERCENTAGE:
                d5 = (d6 / 100.0d) * d;
                break;
            case EMS:
                break;
            case EXS:
                d4 /= 2.0d;
                break;
            case CM:
                d4 = 35.43307d;
                break;
            case MM:
                d4 = 3.543307d;
                break;
            case IN:
                d4 = 90.0d;
                break;
            case PT:
                d4 = 1.25d;
                break;
            case PC:
                d4 = 15.0d;
                break;
        }
        d6 *= d4;
        d5 = d6 * d3;
        return d5 + d2;
    }
}
