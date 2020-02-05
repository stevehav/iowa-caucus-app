package com.google.android.gms.internal.vision;

import java.io.IOException;

public final class zzjw {
    private static final int zzadq = 11;
    private static final int zzadr = 12;
    private static final int zzads = 16;
    private static final int zzadt = 26;
    private static final long[] zzadu = new long[0];
    private static final float[] zzadv = new float[0];
    private static final double[] zzadw = new double[0];
    private static final boolean[] zzadx = new boolean[0];
    public static final String[] zzady = new String[0];
    private static final byte[][] zzadz = new byte[0][];
    public static final byte[] zzaea = new byte[0];
    public static final int[] zzzb = new int[0];

    public static final int zzb(zzjk zzjk, int i) throws IOException {
        int position = zzjk.getPosition();
        zzjk.zzal(i);
        int i2 = 1;
        while (zzjk.zzdq() == i) {
            zzjk.zzal(i);
            i2++;
        }
        zzjk.zzw(position, i);
        return i2;
    }
}
