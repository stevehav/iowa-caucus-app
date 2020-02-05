package com.fasterxml.jackson.core.sym;

import java.util.Arrays;

public final class NameN extends Name {
    private final int[] q;
    private final int q1;
    private final int q2;
    private final int q3;
    private final int q4;
    private final int qlen;

    public boolean equals(int i) {
        return false;
    }

    public boolean equals(int i, int i2) {
        return false;
    }

    public boolean equals(int i, int i2, int i3) {
        return false;
    }

    NameN(String str, int i, int i2, int i3, int i4, int i5, int[] iArr, int i6) {
        super(str, i);
        this.q1 = i2;
        this.q2 = i3;
        this.q3 = i4;
        this.q4 = i5;
        this.q = iArr;
        this.qlen = i6;
    }

    public static NameN construct(String str, int i, int[] iArr, int i2) {
        if (i2 >= 4) {
            return new NameN(str, i, iArr[0], iArr[1], iArr[2], iArr[3], i2 + -4 > 0 ? Arrays.copyOfRange(iArr, 4, i2) : null, i2);
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        if (r7[6] == r6.q[2]) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0040, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        if (r7[5] == r6.q[1]) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004a, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0052, code lost:
        if (r7[4] == r6.q[0]) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0054, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(int[] r7, int r8) {
        /*
            r6 = this;
            int r0 = r6.qlen
            r1 = 0
            if (r8 == r0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = r7[r1]
            int r2 = r6.q1
            if (r0 == r2) goto L_0x000d
            return r1
        L_0x000d:
            r0 = 1
            r2 = r7[r0]
            int r3 = r6.q2
            if (r2 == r3) goto L_0x0015
            return r1
        L_0x0015:
            r2 = 2
            r3 = r7[r2]
            int r4 = r6.q3
            if (r3 == r4) goto L_0x001d
            return r1
        L_0x001d:
            r3 = 3
            r4 = r7[r3]
            int r5 = r6.q4
            if (r4 == r5) goto L_0x0025
            return r1
        L_0x0025:
            switch(r8) {
                case 4: goto L_0x0055;
                case 5: goto L_0x004b;
                case 6: goto L_0x0041;
                case 7: goto L_0x0037;
                case 8: goto L_0x002d;
                default: goto L_0x0028;
            }
        L_0x0028:
            boolean r7 = r6._equals2(r7)
            return r7
        L_0x002d:
            r8 = 7
            r8 = r7[r8]
            int[] r4 = r6.q
            r3 = r4[r3]
            if (r8 == r3) goto L_0x0037
            return r1
        L_0x0037:
            r8 = 6
            r8 = r7[r8]
            int[] r3 = r6.q
            r2 = r3[r2]
            if (r8 == r2) goto L_0x0041
            return r1
        L_0x0041:
            r8 = 5
            r8 = r7[r8]
            int[] r2 = r6.q
            r2 = r2[r0]
            if (r8 == r2) goto L_0x004b
            return r1
        L_0x004b:
            r8 = 4
            r7 = r7[r8]
            int[] r8 = r6.q
            r8 = r8[r1]
            if (r7 == r8) goto L_0x0055
            return r1
        L_0x0055:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.core.sym.NameN.equals(int[], int):boolean");
    }

    private final boolean _equals2(int[] iArr) {
        int i = this.qlen - 4;
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2 + 4] != this.q[i2]) {
                return false;
            }
        }
        return true;
    }
}
