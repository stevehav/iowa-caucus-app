package com.google.android.gms.internal.vision;

final class zzfj {
    private static final Class<?> zzte = zzee();

    private static Class<?> zzee() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static zzfk zzef() {
        if (zzte != null) {
            try {
                return zzp("newInstance");
            } catch (Exception unused) {
            }
        }
        return new zzfk();
    }

    public static zzfk zzeg() {
        if (zzte != null) {
            try {
                return zzp("getEmptyRegistry");
            } catch (Exception unused) {
            }
        }
        return zzfk.zzti;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0014  */
    /* JADX WARNING: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x000e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.gms.internal.vision.zzfk zzeh() {
        /*
            java.lang.Class<?> r0 = zzte
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = "loadGeneratedRegistry"
            com.google.android.gms.internal.vision.zzfk r0 = zzp(r0)     // Catch:{ Exception -> 0x000b }
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 != 0) goto L_0x0012
            com.google.android.gms.internal.vision.zzfk r0 = com.google.android.gms.internal.vision.zzfk.zzeh()
        L_0x0012:
            if (r0 != 0) goto L_0x0018
            com.google.android.gms.internal.vision.zzfk r0 = zzeg()
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfj.zzeh():com.google.android.gms.internal.vision.zzfk");
    }

    private static final zzfk zzp(String str) throws Exception {
        return (zzfk) zzte.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
    }
}
