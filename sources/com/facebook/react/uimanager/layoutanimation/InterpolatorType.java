package com.facebook.react.uimanager.layoutanimation;

enum InterpolatorType {
    LINEAR,
    EASE_IN,
    EASE_OUT,
    EASE_IN_EASE_OUT,
    SPRING;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.react.uimanager.layoutanimation.InterpolatorType fromString(java.lang.String r6) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r0 = r6.toLowerCase(r0)
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case -1965056864: goto L_0x003a;
                case -1310315117: goto L_0x0030;
                case -1102672091: goto L_0x0026;
                case -895679987: goto L_0x001c;
                case 1164546989: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x0044
        L_0x0012:
            java.lang.String r1 = "easeineaseout"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0044
            r0 = 3
            goto L_0x0045
        L_0x001c:
            java.lang.String r1 = "spring"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0044
            r0 = 4
            goto L_0x0045
        L_0x0026:
            java.lang.String r1 = "linear"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0044
            r0 = 0
            goto L_0x0045
        L_0x0030:
            java.lang.String r1 = "easein"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0044
            r0 = 1
            goto L_0x0045
        L_0x003a:
            java.lang.String r1 = "easeout"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0044
            r0 = 2
            goto L_0x0045
        L_0x0044:
            r0 = -1
        L_0x0045:
            if (r0 == 0) goto L_0x0072
            if (r0 == r5) goto L_0x006f
            if (r0 == r4) goto L_0x006c
            if (r0 == r3) goto L_0x0069
            if (r0 != r2) goto L_0x0052
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r6 = SPRING
            return r6
        L_0x0052:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unsupported interpolation type : "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x0069:
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r6 = EASE_IN_EASE_OUT
            return r6
        L_0x006c:
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r6 = EASE_OUT
            return r6
        L_0x006f:
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r6 = EASE_IN
            return r6
        L_0x0072:
            com.facebook.react.uimanager.layoutanimation.InterpolatorType r6 = LINEAR
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.layoutanimation.InterpolatorType.fromString(java.lang.String):com.facebook.react.uimanager.layoutanimation.InterpolatorType");
    }
}
