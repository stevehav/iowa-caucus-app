package com.google.android.gms.internal.vision;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class zzga {
    private static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final byte[] zzxn;
    private static final ByteBuffer zzxo;
    private static final zzez zzxp = zzez.zzf(zzxn);

    static boolean zzf(zzhf zzhf) {
        return false;
    }

    public static int zzj(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzo(long j) {
        return (int) (j ^ (j >>> 32));
    }

    static <T> T checkNotNull(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    static <T> T zza(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public static boolean zzi(byte[] bArr) {
        return zziw.zzi(bArr);
    }

    public static String zzj(byte[] bArr) {
        return new String(bArr, UTF_8);
    }

    public static int hashCode(byte[] bArr) {
        int length = bArr.length;
        int zza = zza(length, bArr, 0, length);
        if (zza == 0) {
            return 1;
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3) {
        int i4 = i;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 = (i4 * 31) + bArr[i5];
        }
        return i4;
    }

    static Object zza(Object obj, Object obj2) {
        return ((zzhf) obj).zzez().zza((zzhf) obj2).zzff();
    }

    static {
        byte[] bArr = new byte[0];
        zzxn = bArr;
        zzxo = ByteBuffer.wrap(bArr);
    }
}
