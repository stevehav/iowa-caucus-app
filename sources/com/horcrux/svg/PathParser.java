package com.horcrux.svg;

import android.graphics.Path;
import android.graphics.RectF;
import java.util.ArrayList;

class PathParser {
    static ArrayList<PathElement> elements;
    private static int i;
    private static int l;
    private static Path mPath;
    private static boolean mPenDown;
    private static float mPenDownX;
    private static float mPenDownY;
    private static float mPenX;
    private static float mPenY;
    private static float mPivotX;
    private static float mPivotY;
    static float mScale;
    private static String s;

    private static boolean is_cmd(char c) {
        switch (c) {
            case 'A':
            case 'C':
            case 'H':
            case 'L':
            case 'M':
            case 'Q':
            case 'S':
            case 'T':
            case 'V':
            case 'Z':
            case 'a':
            case 'c':
            case 'h':
            case 'l':
            case 'm':
            case 'q':
            case 's':
            case 't':
            case 'v':
            case 'z':
                return true;
            default:
                return false;
        }
    }

    private static boolean is_number_start(char c) {
        return (c >= '0' && c <= '9') || c == '.' || c == '-' || c == '+';
    }

    PathParser() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0118  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0149  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0196  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a0  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0092 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x002c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static android.graphics.Path parse(java.lang.String r23) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            elements = r0
            android.graphics.Path r0 = new android.graphics.Path
            r0.<init>()
            mPath = r0
            int r0 = r23.length()
            l = r0
            s = r23
            r0 = 0
            i = r0
            r1 = 0
            mPenX = r1
            mPenY = r1
            mPivotX = r1
            mPivotY = r1
            mPenDownX = r1
            mPenDownY = r1
            mPenDown = r0
            r2 = 32
            r3 = 32
        L_0x002c:
            int r4 = i
            int r5 = l
            if (r4 >= r5) goto L_0x01f3
            skip_spaces()
            int r4 = i
            int r5 = l
            if (r4 < r5) goto L_0x003d
            goto L_0x01f3
        L_0x003d:
            r4 = 1
            if (r3 == r2) goto L_0x0042
            r5 = 1
            goto L_0x0043
        L_0x0042:
            r5 = 0
        L_0x0043:
            java.lang.String r6 = s
            int r7 = i
            char r6 = r6.charAt(r7)
            r7 = 109(0x6d, float:1.53E-43)
            r8 = 77
            java.lang.String r9 = "UnexpectedData"
            if (r5 != 0) goto L_0x005e
            if (r6 == r8) goto L_0x005e
            if (r6 != r7) goto L_0x0058
            goto L_0x005e
        L_0x0058:
            java.lang.Error r0 = new java.lang.Error
            r0.<init>(r9)
            throw r0
        L_0x005e:
            boolean r10 = is_cmd(r6)
            if (r10 == 0) goto L_0x006c
            int r3 = i
            int r3 = r3 + r4
            i = r3
            r3 = r6
        L_0x006a:
            r4 = 0
            goto L_0x008b
        L_0x006c:
            boolean r6 = is_number_start(r6)
            if (r6 == 0) goto L_0x01ed
            if (r5 == 0) goto L_0x01ed
            r5 = 90
            if (r3 == r5) goto L_0x01e7
            r5 = 122(0x7a, float:1.71E-43)
            if (r3 == r5) goto L_0x01e7
            if (r3 == r8) goto L_0x0080
            if (r3 != r7) goto L_0x006a
        L_0x0080:
            boolean r3 = is_absolute(r3)
            if (r3 == 0) goto L_0x0089
            r3 = 76
            goto L_0x008b
        L_0x0089:
            r3 = 108(0x6c, float:1.51E-43)
        L_0x008b:
            boolean r5 = is_absolute(r3)
            switch(r3) {
                case 65: goto L_0x01bc;
                case 67: goto L_0x01a0;
                case 72: goto L_0x0196;
                case 76: goto L_0x018a;
                case 77: goto L_0x017e;
                case 81: goto L_0x016a;
                case 83: goto L_0x0156;
                case 84: goto L_0x0149;
                case 86: goto L_0x013e;
                case 90: goto L_0x0139;
                case 97: goto L_0x0118;
                case 99: goto L_0x00fb;
                case 104: goto L_0x00f2;
                case 108: goto L_0x00e5;
                case 109: goto L_0x00d8;
                case 113: goto L_0x00c3;
                case 115: goto L_0x00ae;
                case 116: goto L_0x00a1;
                case 118: goto L_0x0098;
                case 122: goto L_0x0139;
                default: goto L_0x0092;
            }
        L_0x0092:
            java.lang.Error r0 = new java.lang.Error
            r0.<init>(r9)
            throw r0
        L_0x0098:
            float r6 = parse_list_number()
            line(r1, r6)
            goto L_0x01db
        L_0x00a1:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            smoothQuadraticBezierCurve(r6, r9)
            goto L_0x01db
        L_0x00ae:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            float r10 = parse_list_number()
            float r11 = parse_list_number()
            smoothCurve(r6, r9, r10, r11)
            goto L_0x01db
        L_0x00c3:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            float r10 = parse_list_number()
            float r11 = parse_list_number()
            quadraticBezierCurve(r6, r9, r10, r11)
            goto L_0x01db
        L_0x00d8:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            move(r6, r9)
            goto L_0x01db
        L_0x00e5:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            line(r6, r9)
            goto L_0x01db
        L_0x00f2:
            float r6 = parse_list_number()
            line(r6, r1)
            goto L_0x01db
        L_0x00fb:
            float r9 = parse_list_number()
            float r10 = parse_list_number()
            float r11 = parse_list_number()
            float r12 = parse_list_number()
            float r13 = parse_list_number()
            float r14 = parse_list_number()
            curve(r9, r10, r11, r12, r13, r14)
            goto L_0x01db
        L_0x0118:
            float r15 = parse_list_number()
            float r16 = parse_list_number()
            float r17 = parse_list_number()
            boolean r18 = parse_flag()
            boolean r19 = parse_flag()
            float r20 = parse_list_number()
            float r21 = parse_list_number()
            arc(r15, r16, r17, r18, r19, r20, r21)
            goto L_0x01db
        L_0x0139:
            close()
            goto L_0x01db
        L_0x013e:
            float r6 = mPenX
            float r9 = parse_list_number()
            lineTo(r6, r9)
            goto L_0x01db
        L_0x0149:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            smoothQuadraticBezierCurveTo(r6, r9)
            goto L_0x01db
        L_0x0156:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            float r10 = parse_list_number()
            float r11 = parse_list_number()
            smoothCurveTo(r6, r9, r10, r11)
            goto L_0x01db
        L_0x016a:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            float r10 = parse_list_number()
            float r11 = parse_list_number()
            quadraticBezierCurveTo(r6, r9, r10, r11)
            goto L_0x01db
        L_0x017e:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            moveTo(r6, r9)
            goto L_0x01db
        L_0x018a:
            float r6 = parse_list_number()
            float r9 = parse_list_number()
            lineTo(r6, r9)
            goto L_0x01db
        L_0x0196:
            float r6 = parse_list_number()
            float r9 = mPenY
            lineTo(r6, r9)
            goto L_0x01db
        L_0x01a0:
            float r10 = parse_list_number()
            float r11 = parse_list_number()
            float r12 = parse_list_number()
            float r13 = parse_list_number()
            float r14 = parse_list_number()
            float r15 = parse_list_number()
            curveTo(r10, r11, r12, r13, r14, r15)
            goto L_0x01db
        L_0x01bc:
            float r16 = parse_list_number()
            float r17 = parse_list_number()
            float r18 = parse_list_number()
            boolean r19 = parse_flag()
            boolean r20 = parse_flag()
            float r21 = parse_list_number()
            float r22 = parse_list_number()
            arcTo(r16, r17, r18, r19, r20, r21, r22)
        L_0x01db:
            if (r4 == 0) goto L_0x002c
            if (r5 == 0) goto L_0x01e3
            r3 = 77
            goto L_0x002c
        L_0x01e3:
            r3 = 109(0x6d, float:1.53E-43)
            goto L_0x002c
        L_0x01e7:
            java.lang.Error r0 = new java.lang.Error
            r0.<init>(r9)
            throw r0
        L_0x01ed:
            java.lang.Error r0 = new java.lang.Error
            r0.<init>(r9)
            throw r0
        L_0x01f3:
            android.graphics.Path r0 = mPath
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.PathParser.parse(java.lang.String):android.graphics.Path");
    }

    private static void move(float f, float f2) {
        moveTo(f + mPenX, f2 + mPenY);
    }

    private static void moveTo(float f, float f2) {
        mPenX = f;
        mPivotX = f;
        mPenDownX = f;
        mPenY = f2;
        mPivotY = f2;
        mPenDownY = f2;
        Path path = mPath;
        float f3 = mScale;
        path.moveTo(f * f3, f3 * f2);
        elements.add(new PathElement(ElementType.kCGPathElementMoveToPoint, new Point[]{new Point((double) f, (double) f2)}));
    }

    private static void line(float f, float f2) {
        lineTo(f + mPenX, f2 + mPenY);
    }

    private static void lineTo(float f, float f2) {
        setPenDown();
        mPenX = f;
        mPivotX = f;
        mPenY = f2;
        mPivotY = f2;
        Path path = mPath;
        float f3 = mScale;
        path.lineTo(f * f3, f3 * f2);
        elements.add(new PathElement(ElementType.kCGPathElementAddLineToPoint, new Point[]{new Point((double) f, (double) f2)}));
    }

    private static void curve(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = mPenX;
        float f8 = mPenY;
        curveTo(f + f7, f2 + f8, f3 + f7, f4 + f8, f5 + f7, f6 + f8);
    }

    private static void curveTo(float f, float f2, float f3, float f4, float f5, float f6) {
        mPivotX = f3;
        mPivotY = f4;
        cubicTo(f, f2, f3, f4, f5, f6);
    }

    private static void cubicTo(float f, float f2, float f3, float f4, float f5, float f6) {
        setPenDown();
        mPenX = f5;
        mPenY = f6;
        Path path = mPath;
        float f7 = mScale;
        path.cubicTo(f * f7, f2 * f7, f3 * f7, f4 * f7, f5 * f7, f6 * f7);
        elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point((double) f, (double) f2), new Point((double) f3, (double) f4), new Point((double) f5, (double) f6)}));
    }

    private static void smoothCurve(float f, float f2, float f3, float f4) {
        float f5 = mPenX;
        float f6 = mPenY;
        smoothCurveTo(f + f5, f2 + f6, f3 + f5, f4 + f6);
    }

    private static void smoothCurveTo(float f, float f2, float f3, float f4) {
        mPivotX = f;
        mPivotY = f2;
        cubicTo((mPenX * 2.0f) - mPivotX, (mPenY * 2.0f) - mPivotY, f, f2, f3, f4);
    }

    private static void quadraticBezierCurve(float f, float f2, float f3, float f4) {
        float f5 = mPenX;
        float f6 = mPenY;
        quadraticBezierCurveTo(f + f5, f2 + f6, f3 + f5, f4 + f6);
    }

    private static void quadraticBezierCurveTo(float f, float f2, float f3, float f4) {
        mPivotX = f;
        mPivotY = f2;
        float f5 = f * 2.0f;
        float f6 = f2 * 2.0f;
        float f7 = (mPenX + f5) / 3.0f;
        float f8 = (mPenY + f6) / 3.0f;
        cubicTo(f7, f8, (f3 + f5) / 3.0f, (f4 + f6) / 3.0f, f3, f4);
    }

    private static void smoothQuadraticBezierCurve(float f, float f2) {
        smoothQuadraticBezierCurveTo(f + mPenX, f2 + mPenY);
    }

    private static void smoothQuadraticBezierCurveTo(float f, float f2) {
        quadraticBezierCurveTo((mPenX * 2.0f) - mPivotX, (mPenY * 2.0f) - mPivotY, f, f2);
    }

    private static void arc(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        arcTo(f, f2, f3, z, z2, f4 + mPenX, f5 + mPenY);
    }

    private static void arcTo(float f, float f2, float f3, boolean z, boolean z2, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        boolean z3 = z;
        boolean z4 = z2;
        float f9 = mPenX;
        float f10 = mPenY;
        float abs = Math.abs(f2 == 0.0f ? f == 0.0f ? f5 - f10 : f : f2);
        float abs2 = Math.abs(f == 0.0f ? f4 - f9 : f);
        if (abs2 == 0.0f || abs == 0.0f || (f4 == f9 && f5 == f10)) {
            lineTo(f4, f5);
            return;
        }
        float radians = (float) Math.toRadians((double) f3);
        double d = (double) radians;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float f11 = f4 - f9;
        float f12 = f5 - f10;
        float f13 = ((cos * f11) / 2.0f) + ((sin * f12) / 2.0f);
        float f14 = -sin;
        float f15 = ((f14 * f11) / 2.0f) + ((cos * f12) / 2.0f);
        float f16 = abs2 * abs2;
        float f17 = f16 * abs * abs;
        float f18 = abs * abs * f13 * f13;
        float f19 = f16 * f15 * f15;
        float f20 = (f17 - f19) - f18;
        if (f20 < 0.0f) {
            f6 = f14;
            float sqrt = (float) Math.sqrt((double) (1.0f - (f20 / f17)));
            abs2 *= sqrt;
            abs *= sqrt;
            f7 = f12 / 2.0f;
            f8 = f11 / 2.0f;
        } else {
            f6 = f14;
            float sqrt2 = (float) Math.sqrt((double) (f20 / (f19 + f18)));
            if (z3 == z4) {
                sqrt2 = -sqrt2;
            }
            float f21 = (((-sqrt2) * f15) * abs2) / abs;
            float f22 = ((sqrt2 * f13) * abs) / abs2;
            f8 = ((cos * f21) - (sin * f22)) + (f11 / 2.0f);
            f7 = (f12 / 2.0f) + (f21 * sin) + (f22 * cos);
        }
        float f23 = cos / abs2;
        float f24 = sin / abs2;
        float f25 = f6 / abs;
        float f26 = cos / abs;
        float f27 = -f8;
        float f28 = -f7;
        float f29 = abs;
        float f30 = abs2;
        float f31 = radians;
        float atan2 = (float) Math.atan2((double) ((f25 * f27) + (f26 * f28)), (double) ((f27 * f23) + (f28 * f24)));
        float f32 = f11 - f8;
        float f33 = f12 - f7;
        float atan22 = (float) Math.atan2((double) ((f25 * f32) + (f26 * f33)), (double) ((f23 * f32) + (f24 * f33)));
        float f34 = f8 + f9;
        float f35 = f7 + f10;
        float f36 = f11 + f9;
        float f37 = f12 + f10;
        setPenDown();
        mPivotX = f36;
        mPenX = f36;
        mPivotY = f37;
        mPenY = f37;
        if (f30 == f29 && f31 == 0.0f) {
            float degrees = (float) Math.toDegrees((double) atan2);
            float abs3 = Math.abs((degrees - ((float) Math.toDegrees((double) atan22))) % 360.0f);
            if (!z ? abs3 > 180.0f : abs3 < 180.0f) {
                abs3 = 360.0f - abs3;
            }
            if (!z2) {
                abs3 = -abs3;
            }
            float f38 = mScale;
            mPath.arcTo(new RectF((f34 - f30) * f38, (f35 - f30) * f38, (f34 + f30) * f38, (f35 + f30) * f38), degrees, abs3);
            elements.add(new PathElement(ElementType.kCGPathElementAddCurveToPoint, new Point[]{new Point((double) f36, (double) f37)}));
            return;
        }
        arcToBezier(f34, f35, f30, f29, atan2, atan22, z2, f31);
    }

    private static void close() {
        if (mPenDown) {
            mPenX = mPenDownX;
            mPenY = mPenDownY;
            mPenDown = false;
            mPath.close();
            elements.add(new PathElement(ElementType.kCGPathElementCloseSubpath, new Point[]{new Point((double) mPenX, (double) mPenY)}));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0072 A[LOOP:0: B:10:0x0070->B:11:0x0072, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void arcToBezier(float r24, float r25, float r26, float r27, float r28, float r29, boolean r30, float r31) {
        /*
            r0 = r28
            r1 = r31
            double r1 = (double) r1
            double r3 = java.lang.Math.cos(r1)
            float r3 = (float) r3
            double r1 = java.lang.Math.sin(r1)
            float r1 = (float) r1
            float r2 = r3 * r26
            float r4 = -r1
            float r4 = r4 * r27
            float r1 = r1 * r26
            float r3 = r3 * r27
            float r5 = r29 - r0
            r6 = 4618760256179416344(0x401921fb54442d18, double:6.283185307179586)
            r8 = 0
            int r9 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r9 >= 0) goto L_0x002d
            if (r30 == 0) goto L_0x002d
            double r8 = (double) r5
            java.lang.Double.isNaN(r8)
            double r8 = r8 + r6
        L_0x002b:
            float r5 = (float) r8
            goto L_0x0039
        L_0x002d:
            int r8 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r8 <= 0) goto L_0x0039
            if (r30 != 0) goto L_0x0039
            double r8 = (double) r5
            java.lang.Double.isNaN(r8)
            double r8 = r8 - r6
            goto L_0x002b
        L_0x0039:
            double r6 = (double) r5
            r8 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            java.lang.Double.isNaN(r6)
            double r6 = r6 / r8
            double r6 = round(r6)
            double r6 = java.lang.Math.abs(r6)
            double r6 = java.lang.Math.ceil(r6)
            int r6 = (int) r6
            float r7 = (float) r6
            float r5 = r5 / r7
            r7 = 4608683618675807573(0x3ff5555555555555, double:1.3333333333333333)
            r9 = 1082130432(0x40800000, float:4.0)
            float r9 = r5 / r9
            double r9 = (double) r9
            double r9 = java.lang.Math.tan(r9)
            double r9 = r9 * r7
            float r7 = (float) r9
            double r8 = (double) r0
            double r10 = java.lang.Math.cos(r8)
            float r10 = (float) r10
            double r8 = java.lang.Math.sin(r8)
            float r8 = (float) r8
            r11 = r0
            r0 = 0
        L_0x0070:
            if (r0 >= r6) goto L_0x012e
            float r12 = r7 * r8
            float r12 = r10 - r12
            float r10 = r10 * r7
            float r8 = r8 + r10
            float r11 = r11 + r5
            double r13 = (double) r11
            double r9 = java.lang.Math.cos(r13)
            float r10 = (float) r9
            double r13 = java.lang.Math.sin(r13)
            float r9 = (float) r13
            float r13 = r7 * r9
            float r13 = r13 + r10
            float r14 = r7 * r10
            float r14 = r9 - r14
            float r15 = r2 * r12
            float r15 = r24 + r15
            float r16 = r4 * r8
            float r15 = r15 + r16
            float r12 = r12 * r1
            float r12 = r25 + r12
            float r8 = r8 * r3
            float r12 = r12 + r8
            float r8 = r2 * r13
            float r8 = r24 + r8
            float r16 = r4 * r14
            float r8 = r8 + r16
            float r13 = r13 * r1
            float r13 = r25 + r13
            float r14 = r14 * r3
            float r13 = r13 + r14
            float r14 = r2 * r10
            float r14 = r24 + r14
            float r16 = r4 * r9
            float r14 = r14 + r16
            float r16 = r1 * r10
            float r16 = r25 + r16
            float r17 = r3 * r9
            r31 = r1
            float r1 = r16 + r17
            android.graphics.Path r16 = mPath
            float r17 = mScale
            float r18 = r15 * r17
            float r19 = r12 * r17
            float r20 = r8 * r17
            float r21 = r13 * r17
            float r22 = r14 * r17
            float r23 = r1 * r17
            r17 = r18
            r18 = r19
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r23
            r16.cubicTo(r17, r18, r19, r20, r21, r22)
            r16 = r2
            java.util.ArrayList<com.horcrux.svg.PathElement> r2 = elements
            r27 = r3
            com.horcrux.svg.PathElement r3 = new com.horcrux.svg.PathElement
            r17 = r4
            com.horcrux.svg.ElementType r4 = com.horcrux.svg.ElementType.kCGPathElementAddCurveToPoint
            r29 = r5
            r5 = 3
            com.horcrux.svg.Point[] r5 = new com.horcrux.svg.Point[r5]
            r18 = r6
            com.horcrux.svg.Point r6 = new com.horcrux.svg.Point
            r20 = r9
            r19 = r10
            double r9 = (double) r15
            r28 = r11
            double r11 = (double) r12
            r6.<init>(r9, r11)
            r9 = 0
            r5[r9] = r6
            com.horcrux.svg.Point r6 = new com.horcrux.svg.Point
            double r10 = (double) r8
            double r12 = (double) r13
            r6.<init>(r10, r12)
            r8 = 1
            r5[r8] = r6
            r6 = 2
            com.horcrux.svg.Point r8 = new com.horcrux.svg.Point
            double r10 = (double) r14
            double r12 = (double) r1
            r8.<init>(r10, r12)
            r5[r6] = r8
            r3.<init>(r4, r5)
            r2.add(r3)
            int r0 = r0 + 1
            r3 = r27
            r11 = r28
            r5 = r29
            r1 = r31
            r2 = r16
            r4 = r17
            r6 = r18
            r10 = r19
            r8 = r20
            goto L_0x0070
        L_0x012e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.PathParser.arcToBezier(float, float, float, float, float, float, boolean, float):void");
    }

    private static void setPenDown() {
        if (!mPenDown) {
            mPenDownX = mPenX;
            mPenDownY = mPenY;
            mPenDown = true;
        }
    }

    private static double round(double d) {
        double pow = Math.pow(10.0d, 4.0d);
        double round = (double) Math.round(d * pow);
        Double.isNaN(round);
        return round / pow;
    }

    private static void skip_spaces() {
        while (true) {
            int i2 = i;
            if (i2 < l && Character.isWhitespace(s.charAt(i2))) {
                i++;
            } else {
                return;
            }
        }
    }

    private static boolean is_absolute(char c) {
        return Character.isUpperCase(c);
    }

    private static boolean parse_flag() {
        skip_spaces();
        char charAt = s.charAt(i);
        if (charAt == '0' || charAt == '1') {
            i++;
            int i2 = i;
            if (i2 < l && s.charAt(i2) == ',') {
                i++;
            }
            skip_spaces();
            if (charAt == '1') {
                return true;
            }
            return false;
        }
        throw new Error("UnexpectedData");
    }

    private static float parse_list_number() {
        if (i != l) {
            float parse_number = parse_number();
            skip_spaces();
            parse_list_separator();
            return parse_number;
        }
        throw new Error("UnexpectedEnd");
    }

    private static float parse_number() {
        char charAt;
        skip_spaces();
        int i2 = i;
        if (i2 != l) {
            char charAt2 = s.charAt(i2);
            if (charAt2 == '-' || charAt2 == '+') {
                i++;
                charAt2 = s.charAt(i);
            }
            if (charAt2 >= '0' && charAt2 <= '9') {
                skip_digits();
                int i3 = i;
                if (i3 < l) {
                    charAt2 = s.charAt(i3);
                }
            } else if (charAt2 != '.') {
                throw new Error("InvalidNumber");
            }
            if (charAt2 == '.') {
                i++;
                skip_digits();
                int i4 = i;
                if (i4 < l) {
                    charAt2 = s.charAt(i4);
                }
            }
            if (charAt2 == 'e' || charAt2 == 'E') {
                int i5 = i;
                if (!(i5 + 1 >= l || (charAt = s.charAt(i5 + 1)) == 'm' || charAt == 'x')) {
                    i++;
                    char charAt3 = s.charAt(i);
                    if (charAt3 == '+' || charAt3 == '-') {
                        i++;
                        skip_digits();
                    } else if (charAt3 < '0' || charAt3 > '9') {
                        throw new Error("InvalidNumber");
                    } else {
                        skip_digits();
                    }
                }
            }
            float parseFloat = Float.parseFloat(s.substring(i2, i));
            if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                return parseFloat;
            }
            throw new Error("InvalidNumber");
        }
        throw new Error("InvalidNumber");
    }

    private static void parse_list_separator() {
        int i2 = i;
        if (i2 < l && s.charAt(i2) == ',') {
            i++;
        }
    }

    private static void skip_digits() {
        while (true) {
            int i2 = i;
            if (i2 < l && Character.isDigit(s.charAt(i2))) {
                i++;
            } else {
                return;
            }
        }
    }
}
