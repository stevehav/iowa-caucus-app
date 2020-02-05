package com.google.android.gms.internal.clearcut;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class zzk {
    private static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
    }

    private static long zza(long j, long j2, long j3) {
        long j4 = (j ^ j2) * j3;
        long j5 = ((j4 ^ (j4 >>> 47)) ^ j2) * j3;
        return (j5 ^ (j5 >>> 47)) * j3;
    }

    public static long zza(byte[] bArr) {
        byte[] bArr2 = bArr;
        int length = bArr2.length;
        if (length < 0 || length > bArr2.length) {
            StringBuilder sb = new StringBuilder(67);
            sb.append("Out of bound index with offput: 0 and length: ");
            sb.append(length);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int i = 37;
        char c = 0;
        if (length <= 32) {
            if (length > 16) {
                long j = ((long) (length << 1)) - 7286425919675154353L;
                long zzb = zzb(bArr2, 0) * -5435081209227447693L;
                long zzb2 = zzb(bArr2, 8);
                int i2 = length + 0;
                long zzb3 = zzb(bArr2, i2 - 8) * j;
                return zza(Long.rotateRight(zzb + zzb2, 43) + Long.rotateRight(zzb3, 30) + (zzb(bArr2, i2 - 16) * -7286425919675154353L), zzb + Long.rotateRight(zzb2 - 7286425919675154353L, 18) + zzb3, j);
            } else if (length >= 8) {
                long j2 = ((long) (length << 1)) - 7286425919675154353L;
                long zzb4 = zzb(bArr2, 0) - 7286425919675154353L;
                long zzb5 = zzb(bArr2, (length + 0) - 8);
                return zza((Long.rotateRight(zzb5, 37) * j2) + zzb4, (Long.rotateRight(zzb4, 25) + zzb5) * j2, j2);
            } else if (length >= 4) {
                return zza(((((long) zza(bArr2, 0)) & 4294967295L) << 3) + ((long) length), ((long) zza(bArr2, (length + 0) - 4)) & 4294967295L, ((long) (length << 1)) - 7286425919675154353L);
            } else if (length <= 0) {
                return -7286425919675154353L;
            } else {
                long j3 = (((long) ((bArr2[0] & UnsignedBytes.MAX_VALUE) + ((bArr2[(length >> 1) + 0] & UnsignedBytes.MAX_VALUE) << 8))) * -7286425919675154353L) ^ (((long) (length + ((bArr2[(length - 1) + 0] & UnsignedBytes.MAX_VALUE) << 2))) * -4348849565147123417L);
                return (j3 ^ (j3 >>> 47)) * -7286425919675154353L;
            }
        } else if (length <= 64) {
            long j4 = ((long) (length << 1)) - 7286425919675154353L;
            long zzb6 = zzb(bArr2, 0) * -7286425919675154353L;
            long zzb7 = zzb(bArr2, 8);
            int i3 = length + 0;
            long zzb8 = zzb(bArr2, i3 - 8) * j4;
            long rotateRight = Long.rotateRight(zzb6 + zzb7, 43) + Long.rotateRight(zzb8, 30) + (zzb(bArr2, i3 - 16) * -7286425919675154353L);
            long j5 = j4;
            long zza = zza(rotateRight, Long.rotateRight(-7286425919675154353L + zzb7, 18) + zzb6 + zzb8, j5);
            byte[] bArr3 = bArr;
            long zzb9 = zzb(bArr3, 16) * j4;
            long zzb10 = zzb(bArr3, 24);
            long zzb11 = (rotateRight + zzb(bArr3, i3 - 32)) * j4;
            return zza(((zza + zzb(bArr3, i3 - 24)) * j4) + Long.rotateRight(zzb9 + zzb10, 43) + Long.rotateRight(zzb11, 30), zzb9 + Long.rotateRight(zzb10 + zzb6, 18) + zzb11, j5);
        } else {
            long j6 = 2480279821605975764L;
            long j7 = 1390051526045402406L;
            long[] jArr = new long[2];
            long[] jArr2 = new long[2];
            long zzb12 = zzb(bArr2, 0) + 95310865018149119L;
            int i4 = length - 1;
            int i5 = ((i4 / 64) << 6) + 0;
            int i6 = i4 & 63;
            int i7 = (i5 + i6) - 63;
            int i8 = 0;
            while (true) {
                long rotateRight2 = (Long.rotateRight(((zzb12 + j6) + jArr[c]) + zzb(bArr2, i8 + 8), i) * -5435081209227447693L) ^ jArr2[1];
                long rotateRight3 = (Long.rotateRight(j6 + jArr[1] + zzb(bArr2, i8 + 48), 42) * -5435081209227447693L) + jArr[0] + zzb(bArr2, i8 + 40);
                long rotateRight4 = Long.rotateRight(j7 + jArr2[0], 33) * -5435081209227447693L;
                int i9 = i6;
                int i10 = i5;
                zza(bArr, i8, jArr[1] * -5435081209227447693L, rotateRight2 + jArr2[0], jArr);
                zza(bArr, i8 + 32, rotateRight4 + jArr2[1], rotateRight3 + zzb(bArr2, i8 + 16), jArr2);
                int i11 = i8 + 64;
                if (i11 == i10) {
                    long j8 = -5435081209227447693L + ((255 & rotateRight2) << 1);
                    jArr2[0] = jArr2[0] + ((long) i9);
                    jArr[0] = jArr[0] + jArr2[0];
                    jArr2[0] = jArr2[0] + jArr[0];
                    long rotateRight5 = (Long.rotateRight(((rotateRight4 + rotateRight3) + jArr[0]) + zzb(bArr2, i7 + 8), 37) * j8) ^ (jArr2[1] * 9);
                    long rotateRight6 = (Long.rotateRight(rotateRight3 + jArr[1] + zzb(bArr2, i7 + 48), 42) * j8) + (jArr[0] * 9) + zzb(bArr2, i7 + 40);
                    long rotateRight7 = Long.rotateRight(rotateRight2 + jArr2[0], 33) * j8;
                    zza(bArr, i7, jArr[1] * j8, rotateRight5 + jArr2[0], jArr);
                    zza(bArr, i7 + 32, jArr2[1] + rotateRight7, rotateRight6 + zzb(bArr2, i7 + 16), jArr2);
                    long j9 = j8;
                    return zza(zza(jArr[0], jArr2[0], j9) + ((rotateRight6 ^ (rotateRight6 >>> 47)) * -4348849565147123417L) + rotateRight5, zza(jArr[1], jArr2[1], j9) + rotateRight7, j9);
                }
                i8 = i11;
                i5 = i10;
                i6 = i9;
                j7 = rotateRight2;
                j6 = rotateRight3;
                zzb12 = rotateRight4;
                i = 37;
                c = 0;
            }
        }
    }

    private static void zza(byte[] bArr, int i, long j, long j2, long[] jArr) {
        long zzb = zzb(bArr, i);
        long zzb2 = zzb(bArr, i + 8);
        long zzb3 = zzb(bArr, i + 16);
        long zzb4 = zzb(bArr, i + 24);
        long j3 = j + zzb;
        long j4 = zzb2 + j3 + zzb3;
        jArr[0] = j4 + zzb4;
        jArr[1] = Long.rotateRight(j2 + j3 + zzb4, 21) + Long.rotateRight(j4, 44) + j3;
    }

    private static long zzb(byte[] bArr, int i) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr, i, 8);
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        return wrap.getLong();
    }
}
