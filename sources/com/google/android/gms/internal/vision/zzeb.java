package com.google.android.gms.internal.vision;

public final class zzeb {
    public static int zzx(int i) {
        if (i > 0 && i <= 14) {
            return i;
        }
        StringBuilder sb = new StringBuilder(45);
        sb.append(i);
        sb.append(" is not a valid enum BarcodeFormat");
        throw new IllegalArgumentException(sb.toString());
    }
}
