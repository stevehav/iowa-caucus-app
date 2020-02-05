package com.google.android.gms.internal.measurement;

import com.adobe.xmp.options.PropertyOptions;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzgr<T> implements zzhc<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzia.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzgn zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzgv zzo;
    private final zzfx zzp;
    private final zzhu<?, ?> zzq;
    private final zzes<?> zzr;
    private final zzgg zzs;

    private zzgr(int[] iArr, Object[] objArr, int i, int i2, zzgn zzgn, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgv zzgv, zzfx zzfx, zzhu<?, ?> zzhu, zzes<?> zzes, zzgg zzgg) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzgn instanceof zzfd;
        this.zzj = z;
        this.zzh = zzes != null && zzes.zza(zzgn);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzgv;
        this.zzp = zzfx;
        this.zzq = zzhu;
        this.zzr = zzes;
        this.zzg = zzgn;
        this.zzs = zzgg;
    }

    private static boolean zzf(int i) {
        return (i & PropertyOptions.DELETE_EXISTING) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x03c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.zzgr<T> zza(java.lang.Class<T> r35, com.google.android.gms.internal.measurement.zzgl r36, com.google.android.gms.internal.measurement.zzgv r37, com.google.android.gms.internal.measurement.zzfx r38, com.google.android.gms.internal.measurement.zzhu<?, ?> r39, com.google.android.gms.internal.measurement.zzes<?> r40, com.google.android.gms.internal.measurement.zzgg r41) {
        /*
            r0 = r36
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzha
            if (r1 == 0) goto L_0x0444
            com.google.android.gms.internal.measurement.zzha r0 = (com.google.android.gms.internal.measurement.zzha) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.measurement.zzfd.zzd.zzi
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r7) goto L_0x003f
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            r8 = r5
            r5 = 1
            r9 = 13
        L_0x002c:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r7) goto L_0x003c
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r8 = r8 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x002c
        L_0x003c:
            int r5 = r5 << r9
            r5 = r5 | r8
            goto L_0x0040
        L_0x003f:
            r10 = 1
        L_0x0040:
            int r8 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r7) goto L_0x005f
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x004c:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x005c
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x004c
        L_0x005c:
            int r8 = r8 << r10
            r9 = r9 | r8
            goto L_0x0060
        L_0x005f:
            r12 = r8
        L_0x0060:
            if (r9 != 0) goto L_0x006e
            int[] r8 = zza
            r15 = r8
            r8 = 0
            r9 = 0
            r10 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            goto L_0x01a0
        L_0x006e:
            int r8 = r12 + 1
            char r9 = r1.charAt(r12)
            if (r9 < r7) goto L_0x008e
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x007a:
            int r12 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x008a
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r10
            r9 = r9 | r8
            int r10 = r10 + 13
            r8 = r12
            goto L_0x007a
        L_0x008a:
            int r8 = r8 << r10
            r8 = r8 | r9
            r9 = r8
            goto L_0x008f
        L_0x008e:
            r12 = r8
        L_0x008f:
            int r8 = r12 + 1
            char r10 = r1.charAt(r12)
            if (r10 < r7) goto L_0x00ae
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x009b:
            int r13 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00ab
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r12
            r10 = r10 | r8
            int r12 = r12 + 13
            r8 = r13
            goto L_0x009b
        L_0x00ab:
            int r8 = r8 << r12
            r10 = r10 | r8
            goto L_0x00af
        L_0x00ae:
            r13 = r8
        L_0x00af:
            int r8 = r13 + 1
            char r12 = r1.charAt(r13)
            if (r12 < r7) goto L_0x00cf
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00bb:
            int r14 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00cb
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r13
            r12 = r12 | r8
            int r13 = r13 + 13
            r8 = r14
            goto L_0x00bb
        L_0x00cb:
            int r8 = r8 << r13
            r8 = r8 | r12
            r12 = r8
            goto L_0x00d0
        L_0x00cf:
            r14 = r8
        L_0x00d0:
            int r8 = r14 + 1
            char r13 = r1.charAt(r14)
            if (r13 < r7) goto L_0x00f0
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00dc:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x00ec
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r14
            r13 = r13 | r8
            int r14 = r14 + 13
            r8 = r15
            goto L_0x00dc
        L_0x00ec:
            int r8 = r8 << r14
            r8 = r8 | r13
            r13 = r8
            goto L_0x00f1
        L_0x00f0:
            r15 = r8
        L_0x00f1:
            int r8 = r15 + 1
            char r14 = r1.charAt(r15)
            if (r14 < r7) goto L_0x0113
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x00fd:
            int r16 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x010e
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r15
            r14 = r14 | r8
            int r15 = r15 + 13
            r8 = r16
            goto L_0x00fd
        L_0x010e:
            int r8 = r8 << r15
            r8 = r8 | r14
            r14 = r8
            r8 = r16
        L_0x0113:
            int r15 = r8 + 1
            char r8 = r1.charAt(r8)
            if (r8 < r7) goto L_0x0136
            r8 = r8 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x011f:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0131
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r8 = r8 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x011f
        L_0x0131:
            int r15 = r15 << r16
            r8 = r8 | r15
            r15 = r17
        L_0x0136:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x0162
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r34 = r16
            r16 = r15
            r15 = r34
        L_0x0148:
            int r18 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r7) goto L_0x015b
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r17
            r16 = r16 | r15
            int r17 = r17 + 13
            r15 = r18
            goto L_0x0148
        L_0x015b:
            int r15 = r15 << r17
            r15 = r16 | r15
            r3 = r18
            goto L_0x0164
        L_0x0162:
            r3 = r16
        L_0x0164:
            int r16 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x018f
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r34 = r16
            r16 = r3
            r3 = r34
        L_0x0176:
            int r18 = r3 + 1
            char r3 = r1.charAt(r3)
            if (r3 < r7) goto L_0x0189
            r3 = r3 & 8191(0x1fff, float:1.1478E-41)
            int r3 = r3 << r17
            r16 = r16 | r3
            int r17 = r17 + 13
            r3 = r18
            goto L_0x0176
        L_0x0189:
            int r3 = r3 << r17
            r3 = r16 | r3
            r16 = r18
        L_0x018f:
            int r17 = r3 + r8
            int r15 = r17 + r15
            int[] r15 = new int[r15]
            int r17 = r9 << 1
            int r10 = r17 + r10
            r34 = r16
            r16 = r9
            r9 = r12
            r12 = r34
        L_0x01a0:
            sun.misc.Unsafe r6 = zzb
            java.lang.Object[] r17 = r0.zze()
            com.google.android.gms.internal.measurement.zzgn r18 = r0.zzc()
            java.lang.Class r7 = r18.getClass()
            r18 = r10
            int r10 = r14 * 3
            int[] r10 = new int[r10]
            int r14 = r14 << r4
            java.lang.Object[] r14 = new java.lang.Object[r14]
            int r20 = r3 + r8
            r22 = r3
            r23 = r20
            r8 = 0
            r21 = 0
        L_0x01c0:
            if (r12 >= r2) goto L_0x041a
            int r24 = r12 + 1
            char r12 = r1.charAt(r12)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r12 < r4) goto L_0x01f4
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
            r34 = r24
            r24 = r12
            r12 = r34
        L_0x01d7:
            int r27 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r4) goto L_0x01ed
            r4 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r26
            r24 = r24 | r4
            int r26 = r26 + 13
            r12 = r27
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01d7
        L_0x01ed:
            int r4 = r12 << r26
            r12 = r24 | r4
            r4 = r27
            goto L_0x01f6
        L_0x01f4:
            r4 = r24
        L_0x01f6:
            int r24 = r4 + 1
            char r4 = r1.charAt(r4)
            r26 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x022a
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r27 = 13
            r34 = r24
            r24 = r4
            r4 = r34
        L_0x020d:
            int r28 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r2) goto L_0x0223
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r27
            r24 = r24 | r2
            int r27 = r27 + 13
            r4 = r28
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x020d
        L_0x0223:
            int r2 = r4 << r27
            r4 = r24 | r2
            r2 = r28
            goto L_0x022c
        L_0x022a:
            r2 = r24
        L_0x022c:
            r24 = r3
            r3 = r4 & 255(0xff, float:3.57E-43)
            r27 = r11
            r11 = r4 & 1024(0x400, float:1.435E-42)
            if (r11 == 0) goto L_0x023b
            int r11 = r8 + 1
            r15[r8] = r21
            r8 = r11
        L_0x023b:
            r11 = 51
            r30 = r8
            if (r3 < r11) goto L_0x02e1
            int r11 = r2 + 1
            char r2 = r1.charAt(r2)
            r8 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r8) goto L_0x026a
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r32 = 13
        L_0x0250:
            int r33 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r8) goto L_0x0265
            r8 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r8 = r8 << r32
            r2 = r2 | r8
            int r32 = r32 + 13
            r11 = r33
            r8 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0250
        L_0x0265:
            int r8 = r11 << r32
            r2 = r2 | r8
            r11 = r33
        L_0x026a:
            int r8 = r3 + -51
            r32 = r11
            r11 = 9
            if (r8 == r11) goto L_0x028e
            r11 = 17
            if (r8 != r11) goto L_0x0277
            goto L_0x028e
        L_0x0277:
            r11 = 12
            if (r8 != r11) goto L_0x028c
            r8 = r5 & 1
            r11 = 1
            if (r8 != r11) goto L_0x028c
            int r8 = r21 / 3
            int r8 = r8 << r11
            int r8 = r8 + r11
            int r11 = r18 + 1
            r18 = r17[r18]
            r14[r8] = r18
            r18 = r11
        L_0x028c:
            r11 = 1
            goto L_0x029b
        L_0x028e:
            int r8 = r21 / 3
            r11 = 1
            int r8 = r8 << r11
            int r8 = r8 + r11
            int r25 = r18 + 1
            r18 = r17[r18]
            r14[r8] = r18
            r18 = r25
        L_0x029b:
            int r2 = r2 << r11
            r8 = r17[r2]
            boolean r11 = r8 instanceof java.lang.reflect.Field
            if (r11 == 0) goto L_0x02a5
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x02ad
        L_0x02a5:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zza((java.lang.Class<?>) r7, (java.lang.String) r8)
            r17[r2] = r8
        L_0x02ad:
            r11 = r9
            long r8 = r6.objectFieldOffset(r8)
            int r9 = (int) r8
            int r2 = r2 + 1
            r8 = r17[r2]
            r28 = r9
            boolean r9 = r8 instanceof java.lang.reflect.Field
            if (r9 == 0) goto L_0x02c0
            java.lang.reflect.Field r8 = (java.lang.reflect.Field) r8
            goto L_0x02c8
        L_0x02c0:
            java.lang.String r8 = (java.lang.String) r8
            java.lang.reflect.Field r8 = zza((java.lang.Class<?>) r7, (java.lang.String) r8)
            r17[r2] = r8
        L_0x02c8:
            long r8 = r6.objectFieldOffset(r8)
            int r2 = (int) r8
            r31 = r1
            r8 = r2
            r1 = r7
            r25 = r18
            r9 = r28
            r2 = 0
            r19 = 1
            r28 = r11
            r18 = r13
            r13 = r12
            r12 = r32
            goto L_0x03e2
        L_0x02e1:
            r11 = r9
            int r8 = r18 + 1
            r9 = r17[r18]
            java.lang.String r9 = (java.lang.String) r9
            java.lang.reflect.Field r9 = zza((java.lang.Class<?>) r7, (java.lang.String) r9)
            r18 = r13
            r13 = 9
            if (r3 == r13) goto L_0x0361
            r13 = 17
            if (r3 != r13) goto L_0x02f8
            goto L_0x0361
        L_0x02f8:
            r13 = 27
            if (r3 == r13) goto L_0x0350
            r13 = 49
            if (r3 != r13) goto L_0x0301
            goto L_0x0350
        L_0x0301:
            r13 = 12
            if (r3 == r13) goto L_0x033e
            r13 = 30
            if (r3 == r13) goto L_0x033e
            r13 = 44
            if (r3 != r13) goto L_0x030e
            goto L_0x033e
        L_0x030e:
            r13 = 50
            if (r3 != r13) goto L_0x033a
            int r13 = r22 + 1
            r15[r22] = r21
            int r22 = r21 / 3
            r25 = 1
            int r22 = r22 << 1
            int r28 = r8 + 1
            r8 = r17[r8]
            r14[r22] = r8
            r8 = r4 & 2048(0x800, float:2.87E-42)
            if (r8 == 0) goto L_0x0333
            int r22 = r22 + 1
            int r8 = r28 + 1
            r28 = r17[r28]
            r14[r22] = r28
            r28 = r11
            r22 = r13
            goto L_0x036e
        L_0x0333:
            r22 = r13
            r8 = r28
            r28 = r11
            goto L_0x036e
        L_0x033a:
            r28 = r11
            r11 = 1
            goto L_0x036e
        L_0x033e:
            r13 = r5 & 1
            r28 = r11
            r11 = 1
            if (r13 != r11) goto L_0x036e
            int r13 = r21 / 3
            int r13 = r13 << r11
            int r13 = r13 + r11
            int r25 = r8 + 1
            r8 = r17[r8]
            r14[r13] = r8
            goto L_0x035d
        L_0x0350:
            r28 = r11
            r11 = 1
            int r13 = r21 / 3
            int r13 = r13 << r11
            int r13 = r13 + r11
            int r25 = r8 + 1
            r8 = r17[r8]
            r14[r13] = r8
        L_0x035d:
            r13 = r12
            r8 = r25
            goto L_0x036f
        L_0x0361:
            r28 = r11
            r11 = 1
            int r13 = r21 / 3
            int r13 = r13 << r11
            int r13 = r13 + r11
            java.lang.Class r25 = r9.getType()
            r14[r13] = r25
        L_0x036e:
            r13 = r12
        L_0x036f:
            long r11 = r6.objectFieldOffset(r9)
            int r9 = (int) r11
            r11 = r5 & 1
            r12 = 1
            if (r11 != r12) goto L_0x03c9
            r11 = 17
            if (r3 > r11) goto L_0x03c9
            int r11 = r2 + 1
            char r2 = r1.charAt(r2)
            r12 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r12) goto L_0x03a3
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r19 = 13
        L_0x038c:
            int r29 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 < r12) goto L_0x039e
            r11 = r11 & 8191(0x1fff, float:1.1478E-41)
            int r11 = r11 << r19
            r2 = r2 | r11
            int r19 = r19 + 13
            r11 = r29
            goto L_0x038c
        L_0x039e:
            int r11 = r11 << r19
            r2 = r2 | r11
            r11 = r29
        L_0x03a3:
            r19 = 1
            int r25 = r16 << 1
            int r29 = r2 / 32
            int r25 = r25 + r29
            r12 = r17[r25]
            r31 = r1
            boolean r1 = r12 instanceof java.lang.reflect.Field
            if (r1 == 0) goto L_0x03b6
            java.lang.reflect.Field r12 = (java.lang.reflect.Field) r12
            goto L_0x03be
        L_0x03b6:
            java.lang.String r12 = (java.lang.String) r12
            java.lang.reflect.Field r12 = zza((java.lang.Class<?>) r7, (java.lang.String) r12)
            r17[r25] = r12
        L_0x03be:
            r1 = r7
            r25 = r8
            long r7 = r6.objectFieldOffset(r12)
            int r8 = (int) r7
            int r2 = r2 % 32
            goto L_0x03d3
        L_0x03c9:
            r31 = r1
            r1 = r7
            r25 = r8
            r19 = 1
            r11 = r2
            r2 = 0
            r8 = 0
        L_0x03d3:
            r7 = 18
            if (r3 < r7) goto L_0x03e1
            r7 = 49
            if (r3 > r7) goto L_0x03e1
            int r7 = r23 + 1
            r15[r23] = r9
            r23 = r7
        L_0x03e1:
            r12 = r11
        L_0x03e2:
            int r7 = r21 + 1
            r10[r21] = r13
            int r11 = r7 + 1
            r13 = r4 & 512(0x200, float:7.175E-43)
            if (r13 == 0) goto L_0x03ef
            r13 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03f0
        L_0x03ef:
            r13 = 0
        L_0x03f0:
            r4 = r4 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x03f7
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03f8
        L_0x03f7:
            r4 = 0
        L_0x03f8:
            r4 = r4 | r13
            int r3 = r3 << 20
            r3 = r3 | r4
            r3 = r3 | r9
            r10[r7] = r3
            int r21 = r11 + 1
            int r2 = r2 << 20
            r2 = r2 | r8
            r10[r11] = r2
            r7 = r1
            r13 = r18
            r3 = r24
            r18 = r25
            r2 = r26
            r11 = r27
            r9 = r28
            r8 = r30
            r1 = r31
            r4 = 1
            goto L_0x01c0
        L_0x041a:
            r24 = r3
            r28 = r9
            r27 = r11
            r18 = r13
            com.google.android.gms.internal.measurement.zzgr r1 = new com.google.android.gms.internal.measurement.zzgr
            com.google.android.gms.internal.measurement.zzgn r0 = r0.zzc()
            r12 = 0
            r5 = r1
            r6 = r10
            r7 = r14
            r8 = r28
            r9 = r18
            r10 = r0
            r13 = r15
            r14 = r24
            r15 = r20
            r16 = r37
            r17 = r38
            r18 = r39
            r19 = r40
            r20 = r41
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x0444:
            com.google.android.gms.internal.measurement.zzhr r0 = (com.google.android.gms.internal.measurement.zzhr) r0
            int r0 = r0.zza()
            int r1 = com.google.android.gms.internal.measurement.zzfd.zzd.zzi
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            goto L_0x0453
        L_0x0452:
            throw r0
        L_0x0453:
            goto L_0x0452
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzgl, com.google.android.gms.internal.measurement.zzgv, com.google.android.gms.internal.measurement.zzfx, com.google.android.gms.internal.measurement.zzhu, com.google.android.gms.internal.measurement.zzes, com.google.android.gms.internal.measurement.zzgg):com.google.android.gms.internal.measurement.zzgr");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzhe.zza(com.google.android.gms.internal.measurement.zzia.zzf(r10, r6), com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzhe.zza(com.google.android.gms.internal.measurement.zzia.zzf(r10, r6), com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzhe.zza(com.google.android.gms.internal.measurement.zzia.zzf(r10, r6), com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzhe.zza(com.google.android.gms.internal.measurement.zzia.zzf(r10, r6), com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzia.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzia.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzia.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzia.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzia.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzia.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzhe.zza(com.google.android.gms.internal.measurement.zzia.zzf(r10, r6), com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzd((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zze((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzia.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhe.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzhe.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzhe.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzia.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhe.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzia.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzia.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzia.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhe.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzia.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhe.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzia.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzhe.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.measurement.zzia.zzc(r10, r6)
            boolean r5 = com.google.android.gms.internal.measurement.zzia.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzia.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzia.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzia.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzia.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.measurement.zzia.zzd(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.measurement.zzia.zzd(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.measurement.zzia.zze(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.measurement.zzia.zze(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.measurement.zzhu<?, ?> r0 = r9.zzq
            java.lang.Object r0 = r0.zzb(r10)
            com.google.android.gms.internal.measurement.zzhu<?, ?> r2 = r9.zzq
            java.lang.Object r2 = r2.zzb(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.measurement.zzes<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzet r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.measurement.zzes<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzet r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzd((int) r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzf(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzc(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zzb(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzia.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzia.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzia.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzia.zzc(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzia.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzia.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzia.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzia.zzd(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzia.zze(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzfe.zza((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzhu<?, ?> r0 = r8.zzq
            java.lang.Object r0 = r0.zzb(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzes<?> r0 = r8.zzr
            com.google.android.gms.internal.measurement.zzet r9 = r0.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Object):int");
    }

    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzd2 = zzd(i);
                long j = (long) (1048575 & zzd2);
                int i2 = this.zzc[i];
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zze(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzd(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzc(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zzhe.zza(this.zzs, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzia.zza((Object) t, j, zzia.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzj) {
                zzhe.zza(this.zzq, t, t2);
                if (this.zzh) {
                    zzhe.zza(this.zzr, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzia.zzf(t, zzd2);
            Object zzf3 = zzia.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzia.zza((Object) t, zzd2, zzfe.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzia.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzia.zzf(t, j);
            Object zzf3 = zzia.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzia.zza((Object) t, j, zzfe.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzia.zza((Object) t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0834, code lost:
        r8 = (r8 + r9) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:415:0x0900, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x0915, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:437:0x095a, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:476:0x0a11, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:484:0x0a34, code lost:
        r3 = r3 + 3;
        r9 = r13;
        r7 = 1048575;
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zzj
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzb
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzc
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzd((int) r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzc
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.measurement.zzey r14 = com.google.android.gms.internal.measurement.zzey.DOUBLE_LIST_PACKED
            int r14 = r14.zza()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.measurement.zzey r14 = com.google.android.gms.internal.measurement.zzey.SINT64_LIST_PACKED
            int r14 = r14.zza()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzc
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r7
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x04d6;
                case 1: goto L_0x04ca;
                case 2: goto L_0x04ba;
                case 3: goto L_0x04aa;
                case 4: goto L_0x049a;
                case 5: goto L_0x048e;
                case 6: goto L_0x0482;
                case 7: goto L_0x0476;
                case 8: goto L_0x0458;
                case 9: goto L_0x0444;
                case 10: goto L_0x0433;
                case 11: goto L_0x0424;
                case 12: goto L_0x0415;
                case 13: goto L_0x040a;
                case 14: goto L_0x03ff;
                case 15: goto L_0x03f0;
                case 16: goto L_0x03e1;
                case 17: goto L_0x03cc;
                case 18: goto L_0x03c1;
                case 19: goto L_0x03b8;
                case 20: goto L_0x03af;
                case 21: goto L_0x03a6;
                case 22: goto L_0x039d;
                case 23: goto L_0x0394;
                case 24: goto L_0x038b;
                case 25: goto L_0x0382;
                case 26: goto L_0x0379;
                case 27: goto L_0x036c;
                case 28: goto L_0x0363;
                case 29: goto L_0x035a;
                case 30: goto L_0x0350;
                case 31: goto L_0x0346;
                case 32: goto L_0x033c;
                case 33: goto L_0x0332;
                case 34: goto L_0x0328;
                case 35: goto L_0x0308;
                case 36: goto L_0x02eb;
                case 37: goto L_0x02ce;
                case 38: goto L_0x02b1;
                case 39: goto L_0x0293;
                case 40: goto L_0x0275;
                case 41: goto L_0x0257;
                case 42: goto L_0x0239;
                case 43: goto L_0x021b;
                case 44: goto L_0x01fd;
                case 45: goto L_0x01df;
                case 46: goto L_0x01c1;
                case 47: goto L_0x01a3;
                case 48: goto L_0x0185;
                case 49: goto L_0x0177;
                case 50: goto L_0x0167;
                case 51: goto L_0x0159;
                case 52: goto L_0x014d;
                case 53: goto L_0x013d;
                case 54: goto L_0x012d;
                case 55: goto L_0x011d;
                case 56: goto L_0x0111;
                case 57: goto L_0x0105;
                case 58: goto L_0x00f9;
                case 59: goto L_0x00db;
                case 60: goto L_0x00c7;
                case 61: goto L_0x00b5;
                case 62: goto L_0x00a5;
                case 63: goto L_0x0095;
                case 64: goto L_0x0089;
                case 65: goto L_0x007d;
                case 66: goto L_0x006d;
                case 67: goto L_0x005d;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x04e4
        L_0x0047:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzgn r5 = (com.google.android.gms.internal.measurement.zzgn) r5
            com.google.android.gms.internal.measurement.zzhc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzh((int) r3, (int) r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzj(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzk(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzg((int) r3, (int) r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzdv r5 = (com.google.android.gms.internal.measurement.zzdv) r5
            int r3 = com.google.android.gms.internal.measurement.zzek.zzc((int) r3, (com.google.android.gms.internal.measurement.zzdv) r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzhc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zza((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.measurement.zzhc) r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzdv
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.measurement.zzdv r5 = (com.google.android.gms.internal.measurement.zzdv) r5
            int r3 = com.google.android.gms.internal.measurement.zzek.zzc((int) r3, (com.google.android.gms.internal.measurement.zzdv) r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.measurement.zzek.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzb((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzi(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzf((int) r3, (int) r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.measurement.zzek.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.measurement.zzgg r14 = r0.zzs
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r1, r5)
            java.lang.Object r6 = r0.zzb((int) r12)
            int r3 = r14.zza(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.measurement.zzhc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzb((int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzgn>) r5, (com.google.android.gms.internal.measurement.zzhc) r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzc(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzg(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzd(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzf(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzj(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zze(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzb(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zza((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzhe.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzek.zzg((int) r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzc(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzg(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzi(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzh(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzd(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzf(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzb(r3, r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.measurement.zzhc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zza((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.measurement.zzhc) r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zza((int) r3, (java.util.List<?>) r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzj(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzh(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzi(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zze(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzb((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zza((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzh(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zzi(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzgn r5 = (com.google.android.gms.internal.measurement.zzgn) r5
            com.google.android.gms.internal.measurement.zzhc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.measurement.zzia.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzh((int) r3, (int) r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzj(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzk(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzg((int) r3, (int) r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzdv r5 = (com.google.android.gms.internal.measurement.zzdv) r5
            int r3 = com.google.android.gms.internal.measurement.zzek.zzc((int) r3, (com.google.android.gms.internal.measurement.zzdv) r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzhc r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzhe.zza((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.measurement.zzhc) r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzdv
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.measurement.zzdv r5 = (com.google.android.gms.internal.measurement.zzdv) r5
            int r3 = com.google.android.gms.internal.measurement.zzek.zzc((int) r3, (com.google.android.gms.internal.measurement.zzdv) r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.measurement.zzek.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzb((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzi(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzf((int) r3, (int) r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.measurement.zzia.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.measurement.zzia.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzek.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.measurement.zzek.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.measurement.zzek.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.measurement.zzhu<?, ?> r2 = r0.zzq
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzb
            r3 = -1
            r3 = 0
            r5 = 0
            r6 = -1
            r12 = 0
        L_0x04f9:
            int[] r13 = r0.zzc
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0a3f
            int r13 = r0.zzd((int) r3)
            int[] r14 = r0.zzc
            r15 = r14[r3]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x0525
            int r11 = r3 + 2
            r11 = r14[r11]
            r14 = r11 & r7
            int r18 = r11 >>> 20
            int r18 = r8 << r18
            if (r14 == r6) goto L_0x0522
            long r8 = (long) r14
            int r12 = r2.getInt(r1, r8)
            goto L_0x0523
        L_0x0522:
            r14 = r6
        L_0x0523:
            r6 = r14
            goto L_0x0545
        L_0x0525:
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x0542
            com.google.android.gms.internal.measurement.zzey r8 = com.google.android.gms.internal.measurement.zzey.DOUBLE_LIST_PACKED
            int r8 = r8.zza()
            if (r4 < r8) goto L_0x0542
            com.google.android.gms.internal.measurement.zzey r8 = com.google.android.gms.internal.measurement.zzey.SINT64_LIST_PACKED
            int r8 = r8.zza()
            if (r4 > r8) goto L_0x0542
            int[] r8 = r0.zzc
            int r9 = r3 + 2
            r8 = r8[r9]
            r11 = r8 & r7
            goto L_0x0543
        L_0x0542:
            r11 = 0
        L_0x0543:
            r18 = 0
        L_0x0545:
            r8 = r13 & r7
            long r8 = (long) r8
            switch(r4) {
                case 0: goto L_0x0a24;
                case 1: goto L_0x0a13;
                case 2: goto L_0x0a01;
                case 3: goto L_0x09f0;
                case 4: goto L_0x09df;
                case 5: goto L_0x09cf;
                case 6: goto L_0x09bf;
                case 7: goto L_0x09b3;
                case 8: goto L_0x0997;
                case 9: goto L_0x0985;
                case 10: goto L_0x0976;
                case 11: goto L_0x0969;
                case 12: goto L_0x095c;
                case 13: goto L_0x0951;
                case 14: goto L_0x0946;
                case 15: goto L_0x0939;
                case 16: goto L_0x092c;
                case 17: goto L_0x0919;
                case 18: goto L_0x0905;
                case 19: goto L_0x08f5;
                case 20: goto L_0x08e9;
                case 21: goto L_0x08dd;
                case 22: goto L_0x08d1;
                case 23: goto L_0x08c5;
                case 24: goto L_0x08b9;
                case 25: goto L_0x08ad;
                case 26: goto L_0x08a2;
                case 27: goto L_0x0892;
                case 28: goto L_0x0886;
                case 29: goto L_0x0879;
                case 30: goto L_0x086c;
                case 31: goto L_0x085f;
                case 32: goto L_0x0852;
                case 33: goto L_0x0845;
                case 34: goto L_0x0838;
                case 35: goto L_0x0818;
                case 36: goto L_0x07fb;
                case 37: goto L_0x07de;
                case 38: goto L_0x07c1;
                case 39: goto L_0x07a3;
                case 40: goto L_0x0785;
                case 41: goto L_0x0767;
                case 42: goto L_0x0749;
                case 43: goto L_0x072b;
                case 44: goto L_0x070d;
                case 45: goto L_0x06ef;
                case 46: goto L_0x06d1;
                case 47: goto L_0x06b3;
                case 48: goto L_0x0695;
                case 49: goto L_0x0685;
                case 50: goto L_0x0675;
                case 51: goto L_0x0667;
                case 52: goto L_0x065a;
                case 53: goto L_0x064a;
                case 54: goto L_0x063a;
                case 55: goto L_0x062a;
                case 56: goto L_0x061c;
                case 57: goto L_0x060f;
                case 58: goto L_0x0602;
                case 59: goto L_0x05e4;
                case 60: goto L_0x05d0;
                case 61: goto L_0x05be;
                case 62: goto L_0x05ae;
                case 63: goto L_0x059e;
                case 64: goto L_0x0591;
                case 65: goto L_0x0583;
                case 66: goto L_0x0573;
                case 67: goto L_0x0563;
                case 68: goto L_0x054d;
                default: goto L_0x054b;
            }
        L_0x054b:
            goto L_0x0911
        L_0x054d:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzgn r4 = (com.google.android.gms.internal.measurement.zzgn) r4
            com.google.android.gms.internal.measurement.zzhc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x0563:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzf((int) r15, (long) r8)
            goto L_0x0910
        L_0x0573:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzh((int) r15, (int) r4)
            goto L_0x0910
        L_0x0583:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzek.zzh((int) r15, (long) r8)
            goto L_0x0910
        L_0x0591:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzek.zzj(r15, r4)
            goto L_0x095a
        L_0x059e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzk(r15, r4)
            goto L_0x0910
        L_0x05ae:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzg((int) r15, (int) r4)
            goto L_0x0910
        L_0x05be:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzdv r4 = (com.google.android.gms.internal.measurement.zzdv) r4
            int r4 = com.google.android.gms.internal.measurement.zzek.zzc((int) r15, (com.google.android.gms.internal.measurement.zzdv) r4)
            goto L_0x0910
        L_0x05d0:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzhc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzhe.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhc) r8)
            goto L_0x0910
        L_0x05e4:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.measurement.zzdv
            if (r8 == 0) goto L_0x05fa
            com.google.android.gms.internal.measurement.zzdv r4 = (com.google.android.gms.internal.measurement.zzdv) r4
            int r4 = com.google.android.gms.internal.measurement.zzek.zzc((int) r15, (com.google.android.gms.internal.measurement.zzdv) r4)
            goto L_0x0910
        L_0x05fa:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.measurement.zzek.zzb((int) r15, (java.lang.String) r4)
            goto L_0x0910
        L_0x0602:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.measurement.zzek.zzb((int) r15, (boolean) r4)
            goto L_0x095a
        L_0x060f:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzek.zzi(r15, r4)
            goto L_0x095a
        L_0x061c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzek.zzg((int) r15, (long) r8)
            goto L_0x0910
        L_0x062a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzf((int) r15, (int) r4)
            goto L_0x0910
        L_0x063a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zze((int) r15, (long) r8)
            goto L_0x0910
        L_0x064a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzd((int) r15, (long) r8)
            goto L_0x0910
        L_0x065a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzek.zzb((int) r15, (float) r4)
            goto L_0x095a
        L_0x0667:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzek.zzb((int) r15, (double) r8)
            goto L_0x0910
        L_0x0675:
            com.google.android.gms.internal.measurement.zzgg r4 = r0.zzs
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzb((int) r3)
            int r4 = r4.zza(r15, r8, r9)
            goto L_0x0910
        L_0x0685:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzhc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzb((int) r15, (java.util.List<com.google.android.gms.internal.measurement.zzgn>) r4, (com.google.android.gms.internal.measurement.zzhc) r8)
            goto L_0x0910
        L_0x0695:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzc(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x06a9
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06a9:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x06b3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzg(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x06c7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06c7:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x06d1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzi(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x06e5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06e5:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x06ef:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzh(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x0703
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0703:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x070d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzd(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x0721
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0721:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x072b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzf(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x073f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x073f:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x0749:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzj(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x075d
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x075d:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x0767:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzh(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x077b
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x077b:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x0785:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzi(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x0799
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0799:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x07a3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zze(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x07b7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07b7:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x07c1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzb(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x07d5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07d5:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x07de:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zza((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x07f2
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07f2:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x07fb:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzh(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x080f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x080f:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
            goto L_0x0834
        L_0x0818:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzi(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x082c
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x082c:
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzek.zzg((int) r4)
        L_0x0834:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x095a
        L_0x0838:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzc(r15, r4, r10)
            goto L_0x0900
        L_0x0845:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzg(r15, r4, r10)
            goto L_0x0900
        L_0x0852:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzi(r15, r4, r10)
            goto L_0x0900
        L_0x085f:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzh(r15, r4, r10)
            goto L_0x0900
        L_0x086c:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzd(r15, r4, r10)
            goto L_0x0900
        L_0x0879:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzf(r15, r4, r10)
            goto L_0x0910
        L_0x0886:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzb(r15, r4)
            goto L_0x0910
        L_0x0892:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzhc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzhe.zza((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.measurement.zzhc) r8)
            goto L_0x0910
        L_0x08a2:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zza((int) r15, (java.util.List<?>) r4)
            goto L_0x0910
        L_0x08ad:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzj(r15, r4, r10)
            goto L_0x0900
        L_0x08b9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzh(r15, r4, r10)
            goto L_0x0900
        L_0x08c5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzi(r15, r4, r10)
            goto L_0x0900
        L_0x08d1:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zze(r15, r4, r10)
            goto L_0x0900
        L_0x08dd:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzb((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x0900
        L_0x08e9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zza((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x0900
        L_0x08f5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzh(r15, r4, r10)
        L_0x0900:
            int r5 = r5 + r4
            r4 = 1
        L_0x0902:
            r7 = 0
            goto L_0x0915
        L_0x0905:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzhe.zzi(r15, r4, r10)
        L_0x0910:
            int r5 = r5 + r4
        L_0x0911:
            r4 = 1
        L_0x0912:
            r7 = 0
            r10 = 0
        L_0x0915:
            r13 = 0
            goto L_0x0a34
        L_0x0919:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzgn r4 = (com.google.android.gms.internal.measurement.zzgn) r4
            com.google.android.gms.internal.measurement.zzhc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x092c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzf((int) r15, (long) r8)
            goto L_0x0910
        L_0x0939:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzh((int) r15, (int) r4)
            goto L_0x0910
        L_0x0946:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzek.zzh((int) r15, (long) r8)
            goto L_0x0910
        L_0x0951:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzek.zzj(r15, r4)
        L_0x095a:
            int r5 = r5 + r8
            goto L_0x0911
        L_0x095c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzk(r15, r4)
            goto L_0x0910
        L_0x0969:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzek.zzg((int) r15, (int) r4)
            goto L_0x0910
        L_0x0976:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzdv r4 = (com.google.android.gms.internal.measurement.zzdv) r4
            int r4 = com.google.android.gms.internal.measurement.zzek.zzc((int) r15, (com.google.android.gms.internal.measurement.zzdv) r4)
            goto L_0x0910
        L_0x0985:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzhc r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzhe.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhc) r8)
            goto L_0x0910
        L_0x0997:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.measurement.zzdv
            if (r8 == 0) goto L_0x09ab
            com.google.android.gms.internal.measurement.zzdv r4 = (com.google.android.gms.internal.measurement.zzdv) r4
            int r4 = com.google.android.gms.internal.measurement.zzek.zzc((int) r15, (com.google.android.gms.internal.measurement.zzdv) r4)
            goto L_0x0910
        L_0x09ab:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.measurement.zzek.zzb((int) r15, (java.lang.String) r4)
            goto L_0x0910
        L_0x09b3:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.measurement.zzek.zzb((int) r15, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x0912
        L_0x09bf:
            r4 = 1
            r8 = r12 & r18
            if (r8 == 0) goto L_0x09cc
            r10 = 0
            int r8 = com.google.android.gms.internal.measurement.zzek.zzi(r15, r10)
            int r5 = r5 + r8
            goto L_0x0902
        L_0x09cc:
            r10 = 0
            goto L_0x0902
        L_0x09cf:
            r4 = 1
            r10 = 0
            r8 = r12 & r18
            if (r8 == 0) goto L_0x09dc
            r13 = 0
            int r8 = com.google.android.gms.internal.measurement.zzek.zzg((int) r15, (long) r13)
            goto L_0x0a11
        L_0x09dc:
            r13 = 0
            goto L_0x0a21
        L_0x09df:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            int r8 = r2.getInt(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzek.zzf((int) r15, (int) r8)
            goto L_0x0a11
        L_0x09f0:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzek.zze((int) r15, (long) r8)
            goto L_0x0a11
        L_0x0a01:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzek.zzd((int) r15, (long) r8)
        L_0x0a11:
            int r5 = r5 + r8
            goto L_0x0a21
        L_0x0a13:
            r4 = 1
            r10 = 0
            r13 = 0
            r8 = r12 & r18
            if (r8 == 0) goto L_0x0a21
            r8 = 0
            int r9 = com.google.android.gms.internal.measurement.zzek.zzb((int) r15, (float) r8)
            int r5 = r5 + r9
        L_0x0a21:
            r7 = 0
            goto L_0x0a34
        L_0x0a24:
            r4 = 1
            r8 = 0
            r10 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0a21
            r7 = 0
            int r11 = com.google.android.gms.internal.measurement.zzek.zzb((int) r15, (double) r7)
            int r5 = r5 + r11
        L_0x0a34:
            int r3 = r3 + 3
            r9 = r13
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r11 = 0
            goto L_0x04f9
        L_0x0a3f:
            r10 = 0
            com.google.android.gms.internal.measurement.zzhu<?, ?> r2 = r0.zzq
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x0a99
            com.google.android.gms.internal.measurement.zzes<?> r2 = r0.zzr
            com.google.android.gms.internal.measurement.zzet r1 = r2.zza((java.lang.Object) r1)
            r2 = 0
        L_0x0a52:
            com.google.android.gms.internal.measurement.zzhh<FieldDescriptorType, java.lang.Object> r3 = r1.zza
            int r3 = r3.zzc()
            if (r10 >= r3) goto L_0x0a72
            com.google.android.gms.internal.measurement.zzhh<FieldDescriptorType, java.lang.Object> r3 = r1.zza
            java.util.Map$Entry r3 = r3.zzb((int) r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.measurement.zzev r4 = (com.google.android.gms.internal.measurement.zzev) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.measurement.zzet.zza((com.google.android.gms.internal.measurement.zzev<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x0a52
        L_0x0a72:
            com.google.android.gms.internal.measurement.zzhh<FieldDescriptorType, java.lang.Object> r1 = r1.zza
            java.lang.Iterable r1 = r1.zzd()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a7c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a98
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.measurement.zzev r4 = (com.google.android.gms.internal.measurement.zzev) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.measurement.zzet.zza((com.google.android.gms.internal.measurement.zzev<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0a7c
        L_0x0a98:
            int r5 = r5 + r2
        L_0x0a99:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zzb(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzhu<UT, UB> zzhu, T t) {
        return zzhu.zzf(zzhu.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzia.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzir r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.measurement.zzfd.zzd.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.measurement.zzhu<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzir) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.measurement.zzes<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzet r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzhh<FieldDescriptorType, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzd((int) r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.measurement.zzes<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.measurement.zzes<?> r10 = r13.zzr
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhc r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzhc) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzdv r8 = (com.google.android.gms.internal.measurement.zzdv) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzdv) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhc r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzhc) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzir) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzf(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, (long) r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.measurement.zzir) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhc r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzir) r15, (com.google.android.gms.internal.measurement.zzhc) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzir) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzir) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r9, (java.util.List<com.google.android.gms.internal.measurement.zzdv>) r8, (com.google.android.gms.internal.measurement.zzir) r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhc r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzhe.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzir) r15, (com.google.android.gms.internal.measurement.zzhc) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.measurement.zzir) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzir) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzhe.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzir) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhc r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzhc) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzdv r8 = (com.google.android.gms.internal.measurement.zzdv) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzdv) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzhc r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzhc) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzir) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zzia.zzc(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zzia.zzd(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.measurement.zzia.zze(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.measurement.zzes<?> r14 = r13.zzr
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0a46
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.measurement.zzes<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzet r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzhh<FieldDescriptorType, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x0551:
            if (r1 >= r7) goto L_0x0a29
            int r9 = r13.zzd((int) r1)
            int[] r10 = r13.zzc
            r10 = r10[r1]
        L_0x055b:
            if (r8 == 0) goto L_0x0579
            com.google.android.gms.internal.measurement.zzes<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0579
            com.google.android.gms.internal.measurement.zzes<?> r11 = r13.zzr
            r11.zza(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0577
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x055b
        L_0x0577:
            r8 = r3
            goto L_0x055b
        L_0x0579:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a16;
                case 1: goto L_0x0a06;
                case 2: goto L_0x09f6;
                case 3: goto L_0x09e6;
                case 4: goto L_0x09d6;
                case 5: goto L_0x09c6;
                case 6: goto L_0x09b6;
                case 7: goto L_0x09a5;
                case 8: goto L_0x0994;
                case 9: goto L_0x097f;
                case 10: goto L_0x096c;
                case 11: goto L_0x095b;
                case 12: goto L_0x094a;
                case 13: goto L_0x0939;
                case 14: goto L_0x0928;
                case 15: goto L_0x0917;
                case 16: goto L_0x0906;
                case 17: goto L_0x08f1;
                case 18: goto L_0x08e0;
                case 19: goto L_0x08cf;
                case 20: goto L_0x08be;
                case 21: goto L_0x08ad;
                case 22: goto L_0x089c;
                case 23: goto L_0x088b;
                case 24: goto L_0x087a;
                case 25: goto L_0x0869;
                case 26: goto L_0x0858;
                case 27: goto L_0x0843;
                case 28: goto L_0x0832;
                case 29: goto L_0x0821;
                case 30: goto L_0x0810;
                case 31: goto L_0x07ff;
                case 32: goto L_0x07ee;
                case 33: goto L_0x07dd;
                case 34: goto L_0x07cc;
                case 35: goto L_0x07bb;
                case 36: goto L_0x07aa;
                case 37: goto L_0x0799;
                case 38: goto L_0x0788;
                case 39: goto L_0x0777;
                case 40: goto L_0x0766;
                case 41: goto L_0x0755;
                case 42: goto L_0x0744;
                case 43: goto L_0x0733;
                case 44: goto L_0x0722;
                case 45: goto L_0x0711;
                case 46: goto L_0x0700;
                case 47: goto L_0x06ef;
                case 48: goto L_0x06de;
                case 49: goto L_0x06c9;
                case 50: goto L_0x06be;
                case 51: goto L_0x06ad;
                case 52: goto L_0x069c;
                case 53: goto L_0x068b;
                case 54: goto L_0x067a;
                case 55: goto L_0x0669;
                case 56: goto L_0x0658;
                case 57: goto L_0x0647;
                case 58: goto L_0x0636;
                case 59: goto L_0x0625;
                case 60: goto L_0x0610;
                case 61: goto L_0x05fd;
                case 62: goto L_0x05ec;
                case 63: goto L_0x05db;
                case 64: goto L_0x05ca;
                case 65: goto L_0x05b9;
                case 66: goto L_0x05a8;
                case 67: goto L_0x0597;
                case 68: goto L_0x0582;
                default: goto L_0x0580;
            }
        L_0x0580:
            goto L_0x0a25
        L_0x0582:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhc r11 = r13.zza((int) r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzhc) r11)
            goto L_0x0a25
        L_0x0597:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05a8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a25
        L_0x05b9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05ca:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0a25
        L_0x05db:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0a25
        L_0x05ec:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0a25
        L_0x05fd:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzdv r9 = (com.google.android.gms.internal.measurement.zzdv) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzdv) r9)
            goto L_0x0a25
        L_0x0610:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhc r11 = r13.zza((int) r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzhc) r11)
            goto L_0x0a25
        L_0x0625:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzir) r15)
            goto L_0x0a25
        L_0x0636:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzf(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x0647:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a25
        L_0x0658:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0669:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a25
        L_0x067a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a25
        L_0x068b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x069c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x06ad:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, (long) r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0a25
        L_0x06be:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.measurement.zzir) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0a25
        L_0x06c9:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhc r11 = r13.zza((int) r1)
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzir) r15, (com.google.android.gms.internal.measurement.zzhc) r11)
            goto L_0x0a25
        L_0x06de:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zze(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x06ef:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzj(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0700:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzg(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0711:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzl(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0722:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzm(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0733:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzi(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0744:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzn(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0755:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzk(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0766:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzf(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0777:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzh(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0788:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzd(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0799:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzc(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x07aa:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzir) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07bb:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzir) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07cc:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zze(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07dd:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzj(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ee:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzg(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ff:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzl(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0810:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzm(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0821:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzi(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0832:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r10, (java.util.List<com.google.android.gms.internal.measurement.zzdv>) r9, (com.google.android.gms.internal.measurement.zzir) r15)
            goto L_0x0a25
        L_0x0843:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhc r11 = r13.zza((int) r1)
            com.google.android.gms.internal.measurement.zzhe.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzir) r15, (com.google.android.gms.internal.measurement.zzhc) r11)
            goto L_0x0a25
        L_0x0858:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzir) r15)
            goto L_0x0a25
        L_0x0869:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzn(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x087a:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzk(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x088b:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzf(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x089c:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzh(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08ad:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzd(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08be:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzc(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08cf:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzir) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08e0:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzir) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08f1:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhc r11 = r13.zza((int) r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzhc) r11)
            goto L_0x0a25
        L_0x0906:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0917:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r11)
            r15.zzf(r10, r9)
            goto L_0x0a25
        L_0x0928:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0939:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0a25
        L_0x094a:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0a25
        L_0x095b:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0a25
        L_0x096c:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzdv r9 = (com.google.android.gms.internal.measurement.zzdv) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzdv) r9)
            goto L_0x0a25
        L_0x097f:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzhc r11 = r13.zza((int) r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzhc) r11)
            goto L_0x0a25
        L_0x0994:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzia.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzir) r15)
            goto L_0x0a25
        L_0x09a5:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.measurement.zzia.zzc(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x09b6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a25
        L_0x09c6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09d6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a25
        L_0x09e6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09f6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzia.zzb(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0a06:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.measurement.zzia.zzd(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x0a16:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.measurement.zzia.zze(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a25:
            int r1 = r1 + 3
            goto L_0x0551
        L_0x0a29:
            if (r8 == 0) goto L_0x0a40
            com.google.android.gms.internal.measurement.zzes<?> r1 = r13.zzr
            r1.zza(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0a29
        L_0x0a3e:
            r8 = r3
            goto L_0x0a29
        L_0x0a40:
            com.google.android.gms.internal.measurement.zzhu<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzir) r15)
            return
        L_0x0a46:
            r13.zzb(r14, (com.google.android.gms.internal.measurement.zzir) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzir):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.measurement.zzir r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.measurement.zzes<?> r3 = r0.zzr
            com.google.android.gms.internal.measurement.zzet r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.measurement.zzhh<FieldDescriptorType, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            r6 = -1
            int[] r7 = r0.zzc
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzb
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x04af
            int r12 = r0.zzd((int) r5)
            int[] r13 = r0.zzc
            r14 = r13[r5]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzj
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x0064
            r4 = 17
            if (r15 > r4) goto L_0x0064
            int r4 = r5 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            if (r13 == r6) goto L_0x0058
            r17 = r10
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            goto L_0x005b
        L_0x0058:
            r17 = r10
            r13 = r6
        L_0x005b:
            int r4 = r4 >>> 20
            r6 = 1
            int r9 = r6 << r4
            r6 = r13
            r10 = r17
            goto L_0x0069
        L_0x0064:
            r17 = r10
            r10 = r17
            r9 = 0
        L_0x0069:
            if (r10 == 0) goto L_0x0088
            com.google.android.gms.internal.measurement.zzes<?> r4 = r0.zzr
            int r4 = r4.zza((java.util.Map.Entry<?, ?>) r10)
            if (r4 > r14) goto L_0x0088
            com.google.android.gms.internal.measurement.zzes<?> r4 = r0.zzr
            r4.zza(r2, r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0069
        L_0x0086:
            r10 = 0
            goto L_0x0069
        L_0x0088:
            r4 = r12 & r16
            long r12 = (long) r4
            switch(r15) {
                case 0: goto L_0x049f;
                case 1: goto L_0x0492;
                case 2: goto L_0x0485;
                case 3: goto L_0x0478;
                case 4: goto L_0x046b;
                case 5: goto L_0x045e;
                case 6: goto L_0x0451;
                case 7: goto L_0x0444;
                case 8: goto L_0x0436;
                case 9: goto L_0x0424;
                case 10: goto L_0x0414;
                case 11: goto L_0x0406;
                case 12: goto L_0x03f8;
                case 13: goto L_0x03ea;
                case 14: goto L_0x03dc;
                case 15: goto L_0x03ce;
                case 16: goto L_0x03c0;
                case 17: goto L_0x03ae;
                case 18: goto L_0x039e;
                case 19: goto L_0x038e;
                case 20: goto L_0x037e;
                case 21: goto L_0x036e;
                case 22: goto L_0x035e;
                case 23: goto L_0x034e;
                case 24: goto L_0x033e;
                case 25: goto L_0x032e;
                case 26: goto L_0x031f;
                case 27: goto L_0x030c;
                case 28: goto L_0x02fd;
                case 29: goto L_0x02ed;
                case 30: goto L_0x02dd;
                case 31: goto L_0x02cd;
                case 32: goto L_0x02bd;
                case 33: goto L_0x02ad;
                case 34: goto L_0x029d;
                case 35: goto L_0x028d;
                case 36: goto L_0x027d;
                case 37: goto L_0x026d;
                case 38: goto L_0x025d;
                case 39: goto L_0x024d;
                case 40: goto L_0x023d;
                case 41: goto L_0x022d;
                case 42: goto L_0x021d;
                case 43: goto L_0x020d;
                case 44: goto L_0x01fd;
                case 45: goto L_0x01ed;
                case 46: goto L_0x01dd;
                case 47: goto L_0x01cd;
                case 48: goto L_0x01bd;
                case 49: goto L_0x01aa;
                case 50: goto L_0x01a1;
                case 51: goto L_0x0192;
                case 52: goto L_0x0183;
                case 53: goto L_0x0174;
                case 54: goto L_0x0165;
                case 55: goto L_0x0156;
                case 56: goto L_0x0147;
                case 57: goto L_0x0138;
                case 58: goto L_0x0129;
                case 59: goto L_0x011a;
                case 60: goto L_0x0107;
                case 61: goto L_0x00f7;
                case 62: goto L_0x00e9;
                case 63: goto L_0x00db;
                case 64: goto L_0x00cd;
                case 65: goto L_0x00bf;
                case 66: goto L_0x00b1;
                case 67: goto L_0x00a3;
                case 68: goto L_0x0091;
                default: goto L_0x008e;
            }
        L_0x008e:
            r15 = 0
            goto L_0x04ab
        L_0x0091:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzhc r9 = r0.zza((int) r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhc) r9)
            goto L_0x008e
        L_0x00a3:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zze(r1, r12)
            r2.zze((int) r14, (long) r12)
            goto L_0x008e
        L_0x00b1:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x008e
        L_0x00bf:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zze(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x008e
        L_0x00cd:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r12)
            r2.zza((int) r14, (int) r4)
            goto L_0x008e
        L_0x00db:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r12)
            r2.zzb((int) r14, (int) r4)
            goto L_0x008e
        L_0x00e9:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r12)
            r2.zze((int) r14, (int) r4)
            goto L_0x008e
        L_0x00f7:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzdv r4 = (com.google.android.gms.internal.measurement.zzdv) r4
            r2.zza((int) r14, (com.google.android.gms.internal.measurement.zzdv) r4)
            goto L_0x008e
        L_0x0107:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzhc r9 = r0.zza((int) r5)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhc) r9)
            goto L_0x008e
        L_0x011a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzir) r2)
            goto L_0x008e
        L_0x0129:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            boolean r4 = zzf(r1, r12)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x008e
        L_0x0138:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r12)
            r2.zzd((int) r14, (int) r4)
            goto L_0x008e
        L_0x0147:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zze(r1, r12)
            r2.zzd((int) r14, (long) r12)
            goto L_0x008e
        L_0x0156:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r12)
            r2.zzc((int) r14, (int) r4)
            goto L_0x008e
        L_0x0165:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zze(r1, r12)
            r2.zzc((int) r14, (long) r12)
            goto L_0x008e
        L_0x0174:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r12 = zze(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x008e
        L_0x0183:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            float r4 = zzc(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x008e
        L_0x0192:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            double r12 = zzb(r1, (long) r12)
            r2.zza((int) r14, (double) r12)
            goto L_0x008e
        L_0x01a1:
            java.lang.Object r4 = r8.getObject(r1, r12)
            r0.zza((com.google.android.gms.internal.measurement.zzir) r2, (int) r14, (java.lang.Object) r4, (int) r5)
            goto L_0x008e
        L_0x01aa:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhc r12 = r0.zza((int) r5)
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzir) r2, (com.google.android.gms.internal.measurement.zzhc) r12)
            goto L_0x008e
        L_0x01bd:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 1
            com.google.android.gms.internal.measurement.zzhe.zze(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01cd:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzj(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01dd:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzg(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01ed:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzl(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01fd:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzm(r4, r9, r2, r14)
            goto L_0x008e
        L_0x020d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzi(r4, r9, r2, r14)
            goto L_0x008e
        L_0x021d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzn(r4, r9, r2, r14)
            goto L_0x008e
        L_0x022d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzk(r4, r9, r2, r14)
            goto L_0x008e
        L_0x023d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzf(r4, r9, r2, r14)
            goto L_0x008e
        L_0x024d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzh(r4, r9, r2, r14)
            goto L_0x008e
        L_0x025d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzd(r4, r9, r2, r14)
            goto L_0x008e
        L_0x026d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzc(r4, r9, r2, r14)
            goto L_0x008e
        L_0x027d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzir) r2, (boolean) r14)
            goto L_0x008e
        L_0x028d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzir) r2, (boolean) r14)
            goto L_0x008e
        L_0x029d:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 0
            com.google.android.gms.internal.measurement.zzhe.zze(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ad:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzj(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02bd:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzg(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02cd:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzl(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02dd:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzm(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ed:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzi(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02fd:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzdv>) r9, (com.google.android.gms.internal.measurement.zzir) r2)
            goto L_0x008e
        L_0x030c:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhc r12 = r0.zza((int) r5)
            com.google.android.gms.internal.measurement.zzhe.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzir) r2, (com.google.android.gms.internal.measurement.zzhc) r12)
            goto L_0x008e
        L_0x031f:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzir) r2)
            goto L_0x008e
        L_0x032e:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.measurement.zzhe.zzn(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x033e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzk(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x034e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzf(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x035e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzh(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x036e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzd(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x037e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzc(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x038e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzir) r2, (boolean) r15)
            goto L_0x04ab
        L_0x039e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzhe.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzir) r2, (boolean) r15)
            goto L_0x04ab
        L_0x03ae:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzhc r9 = r0.zza((int) r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhc) r9)
            goto L_0x04ab
        L_0x03c0:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zze((int) r14, (long) r12)
            goto L_0x04ab
        L_0x03ce:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzf(r14, r4)
            goto L_0x04ab
        L_0x03dc:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzb((int) r14, (long) r12)
            goto L_0x04ab
        L_0x03ea:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zza((int) r14, (int) r4)
            goto L_0x04ab
        L_0x03f8:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzb((int) r14, (int) r4)
            goto L_0x04ab
        L_0x0406:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zze((int) r14, (int) r4)
            goto L_0x04ab
        L_0x0414:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzdv r4 = (com.google.android.gms.internal.measurement.zzdv) r4
            r2.zza((int) r14, (com.google.android.gms.internal.measurement.zzdv) r4)
            goto L_0x04ab
        L_0x0424:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.measurement.zzhc r9 = r0.zza((int) r5)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzhc) r9)
            goto L_0x04ab
        L_0x0436:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzir) r2)
            goto L_0x04ab
        L_0x0444:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            boolean r4 = com.google.android.gms.internal.measurement.zzia.zzc(r1, r12)
            r2.zza((int) r14, (boolean) r4)
            goto L_0x04ab
        L_0x0451:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzd((int) r14, (int) r4)
            goto L_0x04ab
        L_0x045e:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzd((int) r14, (long) r12)
            goto L_0x04ab
        L_0x046b:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            int r4 = r8.getInt(r1, r12)
            r2.zzc((int) r14, (int) r4)
            goto L_0x04ab
        L_0x0478:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zzc((int) r14, (long) r12)
            goto L_0x04ab
        L_0x0485:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            long r12 = r8.getLong(r1, r12)
            r2.zza((int) r14, (long) r12)
            goto L_0x04ab
        L_0x0492:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            float r4 = com.google.android.gms.internal.measurement.zzia.zzd(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x04ab
        L_0x049f:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            double r12 = com.google.android.gms.internal.measurement.zzia.zze(r1, r12)
            r2.zza((int) r14, (double) r12)
        L_0x04ab:
            int r5 = r5 + 3
            goto L_0x002e
        L_0x04af:
            r17 = r10
            r4 = r17
        L_0x04b3:
            if (r4 == 0) goto L_0x04c9
            com.google.android.gms.internal.measurement.zzes<?> r5 = r0.zzr
            r5.zza(r2, r4)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04c7
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            goto L_0x04b3
        L_0x04c7:
            r4 = 0
            goto L_0x04b3
        L_0x04c9:
            com.google.android.gms.internal.measurement.zzhu<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.measurement.zzir) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzir):void");
    }

    private final <K, V> void zza(zzir zzir, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzir.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzhu<UT, UB> zzhu, T t, zzir zzir) throws IOException {
        zzhu.zza(zzhu.zzb(t), zzir);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:148|149|(1:151)|152|(5:174|154|(2:157|155)|256|(2:159|264)(1:265))(1:252)) */
    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        r7.zza(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x05a0, code lost:
        if (r10 == null) goto L_0x05a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x05a2, code lost:
        r10 = r7.zzc(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x05ab, code lost:
        if (r7.zza(r10, r14) == false) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x05ad, code lost:
        r14 = r12.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x05b1, code lost:
        if (r14 < r12.zzn) goto L_0x05b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x05b3, code lost:
        r10 = zza((java.lang.Object) r13, r12.zzl[r14], r10, r7);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05be, code lost:
        if (r10 != null) goto L_0x05c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x05c0, code lost:
        r7.zzb((java.lang.Object) r13, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:148:0x059d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzhd r14, com.google.android.gms.internal.measurement.zzeq r15) throws java.io.IOException {
        /*
            r12 = this;
            if (r15 == 0) goto L_0x05dc
            com.google.android.gms.internal.measurement.zzhu<?, ?> r7 = r12.zzq
            com.google.android.gms.internal.measurement.zzes<?> r8 = r12.zzr
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x0009:
            int r1 = r14.zza()     // Catch:{ all -> 0x05c4 }
            int r2 = r12.zzg(r1)     // Catch:{ all -> 0x05c4 }
            if (r2 >= 0) goto L_0x0077
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002f
            int r14 = r12.zzm
        L_0x001a:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r7.zzb((java.lang.Object) r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r2 = r12.zzh     // Catch:{ all -> 0x05c4 }
            if (r2 != 0) goto L_0x0035
            r2 = r9
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.measurement.zzgn r2 = r12.zzg     // Catch:{ all -> 0x05c4 }
            java.lang.Object r1 = r8.zza(r15, r2, r1)     // Catch:{ all -> 0x05c4 }
            r2 = r1
        L_0x003c:
            if (r2 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0044
            com.google.android.gms.internal.measurement.zzet r0 = r8.zzb(r13)     // Catch:{ all -> 0x05c4 }
        L_0x0044:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x05c4 }
            r0 = r11
            goto L_0x0009
        L_0x0051:
            r7.zza((com.google.android.gms.internal.measurement.zzhd) r14)     // Catch:{ all -> 0x05c4 }
            if (r10 != 0) goto L_0x005a
            java.lang.Object r10 = r7.zzc(r13)     // Catch:{ all -> 0x05c4 }
        L_0x005a:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.measurement.zzhd) r14)     // Catch:{ all -> 0x05c4 }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0062:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0071:
            if (r10 == 0) goto L_0x0076
            r7.zzb((java.lang.Object) r13, r10)
        L_0x0076:
            return
        L_0x0077:
            int r3 = r12.zzd((int) r2)     // Catch:{ all -> 0x05c4 }
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r3
            int r4 = r4 >>> 20
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x0571;
                case 1: goto L_0x0562;
                case 2: goto L_0x0553;
                case 3: goto L_0x0544;
                case 4: goto L_0x0535;
                case 5: goto L_0x0526;
                case 6: goto L_0x0517;
                case 7: goto L_0x0508;
                case 8: goto L_0x0500;
                case 9: goto L_0x04cf;
                case 10: goto L_0x04c0;
                case 11: goto L_0x04b1;
                case 12: goto L_0x048f;
                case 13: goto L_0x0480;
                case 14: goto L_0x0471;
                case 15: goto L_0x0462;
                case 16: goto L_0x0453;
                case 17: goto L_0x0422;
                case 18: goto L_0x0414;
                case 19: goto L_0x0406;
                case 20: goto L_0x03f8;
                case 21: goto L_0x03ea;
                case 22: goto L_0x03dc;
                case 23: goto L_0x03ce;
                case 24: goto L_0x03c0;
                case 25: goto L_0x03b2;
                case 26: goto L_0x0390;
                case 27: goto L_0x037e;
                case 28: goto L_0x0370;
                case 29: goto L_0x0362;
                case 30: goto L_0x034d;
                case 31: goto L_0x033f;
                case 32: goto L_0x0331;
                case 33: goto L_0x0323;
                case 34: goto L_0x0315;
                case 35: goto L_0x0307;
                case 36: goto L_0x02f9;
                case 37: goto L_0x02eb;
                case 38: goto L_0x02dd;
                case 39: goto L_0x02cf;
                case 40: goto L_0x02c1;
                case 41: goto L_0x02b3;
                case 42: goto L_0x02a5;
                case 43: goto L_0x0297;
                case 44: goto L_0x0282;
                case 45: goto L_0x0274;
                case 46: goto L_0x0266;
                case 47: goto L_0x0258;
                case 48: goto L_0x024a;
                case 49: goto L_0x0238;
                case 50: goto L_0x01f6;
                case 51: goto L_0x01e4;
                case 52: goto L_0x01d2;
                case 53: goto L_0x01c0;
                case 54: goto L_0x01ae;
                case 55: goto L_0x019c;
                case 56: goto L_0x018a;
                case 57: goto L_0x0178;
                case 58: goto L_0x0166;
                case 59: goto L_0x015e;
                case 60: goto L_0x012d;
                case 61: goto L_0x011f;
                case 62: goto L_0x010d;
                case 63: goto L_0x00e8;
                case 64: goto L_0x00d6;
                case 65: goto L_0x00c4;
                case 66: goto L_0x00b2;
                case 67: goto L_0x00a0;
                case 68: goto L_0x008e;
                default: goto L_0x0086;
            }
        L_0x0086:
            if (r10 != 0) goto L_0x0580
            java.lang.Object r10 = r7.zza()     // Catch:{ zzfm -> 0x059d }
            goto L_0x0580
        L_0x008e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzhc r5 = r12.zza((int) r2)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r5 = r14.zzb(r5, r15)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x00a0:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzt()     // Catch:{ zzfm -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x00b2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            int r5 = r14.zzs()     // Catch:{ zzfm -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x00c4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzr()     // Catch:{ zzfm -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x00d6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            int r5 = r14.zzq()     // Catch:{ zzfm -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x00e8:
            int r4 = r14.zzp()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzfj r6 = r12.zzc((int) r2)     // Catch:{ zzfm -> 0x059d }
            if (r6 == 0) goto L_0x00ff
            boolean r6 = r6.zza(r4)     // Catch:{ zzfm -> 0x059d }
            if (r6 == 0) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhe.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x00ff:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzfm -> 0x059d }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r5, (java.lang.Object) r3)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x010d:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            int r5 = r14.zzo()     // Catch:{ zzfm -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x011f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzdv r5 = r14.zzn()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x012d:
            boolean r4 = r12.zza(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            if (r4 == 0) goto L_0x0149
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzia.zzf(r13, r3)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzhc r6 = r12.zza((int) r2)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzfe.zza((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0159
        L_0x0149:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzhc r5 = r12.zza((int) r2)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r5 = r14.zza(r5, r15)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
        L_0x0159:
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x015e:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.measurement.zzhd) r14)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0166:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            boolean r5 = r14.zzk()     // Catch:{ zzfm -> 0x059d }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0178:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            int r5 = r14.zzj()     // Catch:{ zzfm -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x018a:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzi()     // Catch:{ zzfm -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x019c:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            int r5 = r14.zzh()     // Catch:{ zzfm -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x01ae:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzf()     // Catch:{ zzfm -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x01c0:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzg()     // Catch:{ zzfm -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x01d2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            float r5 = r14.zze()     // Catch:{ zzfm -> 0x059d }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x01e4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzfm -> 0x059d }
            double r5 = r14.zzd()     // Catch:{ zzfm -> 0x059d }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x01f6:
            java.lang.Object r1 = r12.zzb((int) r2)     // Catch:{ zzfm -> 0x059d }
            int r2 = r12.zzd((int) r2)     // Catch:{ zzfm -> 0x059d }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzia.zzf(r13, r2)     // Catch:{ zzfm -> 0x059d }
            if (r4 != 0) goto L_0x0210
            com.google.android.gms.internal.measurement.zzgg r4 = r12.zzs     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r4 = r4.zze(r1)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r4)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0227
        L_0x0210:
            com.google.android.gms.internal.measurement.zzgg r5 = r12.zzs     // Catch:{ zzfm -> 0x059d }
            boolean r5 = r5.zzc(r4)     // Catch:{ zzfm -> 0x059d }
            if (r5 == 0) goto L_0x0227
            com.google.android.gms.internal.measurement.zzgg r5 = r12.zzs     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r5 = r5.zze(r1)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzgg r6 = r12.zzs     // Catch:{ zzfm -> 0x059d }
            r6.zza(r5, r4)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r5)     // Catch:{ zzfm -> 0x059d }
            r4 = r5
        L_0x0227:
            com.google.android.gms.internal.measurement.zzgg r2 = r12.zzs     // Catch:{ zzfm -> 0x059d }
            java.util.Map r2 = r2.zza(r4)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzgg r3 = r12.zzs     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzge r1 = r3.zzf(r1)     // Catch:{ zzfm -> 0x059d }
            r14.zza(r2, r1, (com.google.android.gms.internal.measurement.zzeq) r15)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0238:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzhc r1 = r12.zza((int) r2)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzfx r2 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzfm -> 0x059d }
            r14.zzb(r2, r1, r15)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x024a:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzq(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0258:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzp(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0266:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzo(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0274:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzn(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0282:
            com.google.android.gms.internal.measurement.zzfx r4 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzfm -> 0x059d }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzfm -> 0x059d }
            r14.zzm(r3)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzfj r2 = r12.zzc((int) r2)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhe.zza(r1, r3, r2, r10, r7)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0297:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzl(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x02a5:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzh(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x02b3:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzg(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x02c1:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzf(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x02cf:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zze(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x02dd:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzc(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x02eb:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzd(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x02f9:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzb(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0307:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zza(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0315:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzq(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0323:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzp(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0331:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzo(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x033f:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzn(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x034d:
            com.google.android.gms.internal.measurement.zzfx r4 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzfm -> 0x059d }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzfm -> 0x059d }
            r14.zzm(r3)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzfj r2 = r12.zzc((int) r2)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhe.zza(r1, r3, r2, r10, r7)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0362:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzl(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0370:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzk(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x037e:
            com.google.android.gms.internal.measurement.zzhc r1 = r12.zza((int) r2)     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzfx r4 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zza(r2, r1, (com.google.android.gms.internal.measurement.zzeq) r15)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0390:
            boolean r1 = zzf(r3)     // Catch:{ zzfm -> 0x059d }
            if (r1 == 0) goto L_0x03a4
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzj(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x03a4:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzi(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x03b2:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzh(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x03c0:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzg(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x03ce:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzf(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x03dc:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zze(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x03ea:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzc(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x03f8:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzd(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0406:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zzb(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0414:
            com.google.android.gms.internal.measurement.zzfx r1 = r12.zzp     // Catch:{ zzfm -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzfm -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzfm -> 0x059d }
            r14.zza(r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0422:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            if (r1 == 0) goto L_0x0440
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzia.zzf(r13, r3)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzhc r2 = r12.zza((int) r2)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzfe.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0440:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzhc r1 = r12.zza((int) r2)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r1 = r14.zzb(r1, r15)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0453:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzt()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0462:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            int r1 = r14.zzs()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0471:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzr()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0480:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            int r1 = r14.zzq()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x048f:
            int r4 = r14.zzp()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzfj r6 = r12.zzc((int) r2)     // Catch:{ zzfm -> 0x059d }
            if (r6 == 0) goto L_0x04a6
            boolean r6 = r6.zza(r4)     // Catch:{ zzfm -> 0x059d }
            if (r6 == 0) goto L_0x04a0
            goto L_0x04a6
        L_0x04a0:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzhe.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x04a6:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r5, (int) r4)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x04b1:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            int r1 = r14.zzo()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x04c0:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzdv r1 = r14.zzn()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x04cf:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            if (r1 == 0) goto L_0x04ed
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzia.zzf(r13, r3)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzhc r2 = r12.zza((int) r2)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzfe.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x04ed:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzhc r1 = r12.zza((int) r2)     // Catch:{ zzfm -> 0x059d }
            java.lang.Object r1 = r14.zza(r1, r15)     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0500:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.measurement.zzhd) r14)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0508:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            boolean r1 = r14.zzk()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (boolean) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0517:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            int r1 = r14.zzj()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0526:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzi()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0535:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            int r1 = r14.zzh()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0544:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzf()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0553:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            long r5 = r14.zzg()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0562:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            float r1 = r14.zze()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (float) r1)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0571:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzfm -> 0x059d }
            double r5 = r14.zzd()     // Catch:{ zzfm -> 0x059d }
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r13, (long) r3, (double) r5)     // Catch:{ zzfm -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzfm -> 0x059d }
            goto L_0x0009
        L_0x0580:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.measurement.zzhd) r14)     // Catch:{ zzfm -> 0x059d }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0588:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0597
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0588
        L_0x0597:
            if (r10 == 0) goto L_0x059c
            r7.zzb((java.lang.Object) r13, r10)
        L_0x059c:
            return
        L_0x059d:
            r7.zza((com.google.android.gms.internal.measurement.zzhd) r14)     // Catch:{ all -> 0x05c4 }
            if (r10 != 0) goto L_0x05a7
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x05c4 }
            r10 = r1
        L_0x05a7:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.measurement.zzhd) r14)     // Catch:{ all -> 0x05c4 }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x05af:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x05be
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05af
        L_0x05be:
            if (r10 == 0) goto L_0x05c3
            r7.zzb((java.lang.Object) r13, r10)
        L_0x05c3:
            return
        L_0x05c4:
            r14 = move-exception
            int r15 = r12.zzm
        L_0x05c7:
            int r0 = r12.zzn
            if (r15 >= r0) goto L_0x05d6
            int[] r0 = r12.zzl
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05c7
        L_0x05d6:
            if (r10 == 0) goto L_0x05db
            r7.zzb((java.lang.Object) r13, r10)
        L_0x05db:
            throw r14
        L_0x05dc:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            r13.<init>()
            goto L_0x05e3
        L_0x05e2:
            throw r13
        L_0x05e3:
            goto L_0x05e2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzhd, com.google.android.gms.internal.measurement.zzeq):void");
    }

    private static zzhx zze(Object obj) {
        zzfd zzfd = (zzfd) obj;
        zzhx zzhx = zzfd.zzb;
        if (zzhx != zzhx.zza()) {
            return zzhx;
        }
        zzhx zzb2 = zzhx.zzb();
        zzfd.zzb = zzb2;
        return zzb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.measurement.zzil r4, java.lang.Class<?> r5, com.google.android.gms.internal.measurement.zzdq r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.measurement.zzgq.zza
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzd(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r1, r2, r6)
            long r2 = r6.zzb
            long r2 = com.google.android.gms.internal.measurement.zzeh.zza((long) r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r1, r2, r6)
            int r2 = r6.zza
            int r2 = com.google.android.gms.internal.measurement.zzeh.zze(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.measurement.zzgy r4 = com.google.android.gms.internal.measurement.zzgy.zza()
            com.google.android.gms.internal.measurement.zzhc r4 = r4.zza(r5)
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza((com.google.android.gms.internal.measurement.zzhc) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzdq) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r1, r2, r6)
            long r2 = r6.zzb
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r1, r2, r6)
            int r2 = r6.zza
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.measurement.zzdr.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzc = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.measurement.zzdr.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzc = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzc = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.measurement.zzdr.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzc = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.measurement.zzdr.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r1, r2, r6)
            long r2 = r6.zzb
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzc = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(byte[], int, int, com.google.android.gms.internal.measurement.zzil, java.lang.Class, com.google.android.gms.internal.measurement.zzdq):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0422 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzdq r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzfk r11 = (com.google.android.gms.internal.measurement.zzfk) r11
            boolean r12 = r11.zza()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.measurement.zzfk r11 = r11.zza(r12)
            sun.misc.Unsafe r12 = zzb
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x03a6;
                case 20: goto L_0x0365;
                case 21: goto L_0x0365;
                case 22: goto L_0x034b;
                case 23: goto L_0x030c;
                case 24: goto L_0x02cd;
                case 25: goto L_0x0276;
                case 26: goto L_0x01c3;
                case 27: goto L_0x01a9;
                case 28: goto L_0x0151;
                case 29: goto L_0x034b;
                case 30: goto L_0x0119;
                case 31: goto L_0x02cd;
                case 32: goto L_0x030c;
                case 33: goto L_0x00cc;
                case 34: goto L_0x007f;
                case 35: goto L_0x03e4;
                case 36: goto L_0x03a6;
                case 37: goto L_0x0365;
                case 38: goto L_0x0365;
                case 39: goto L_0x034b;
                case 40: goto L_0x030c;
                case 41: goto L_0x02cd;
                case 42: goto L_0x0276;
                case 43: goto L_0x034b;
                case 44: goto L_0x0119;
                case 45: goto L_0x02cd;
                case 46: goto L_0x030c;
                case 47: goto L_0x00cc;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0422
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0422
            com.google.android.gms.internal.measurement.zzhc r1 = r0.zza((int) r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza((com.google.android.gms.internal.measurement.zzhc) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.measurement.zzdq) r27)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza((com.google.android.gms.internal.measurement.zzhc) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.measurement.zzdq) r27)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.measurement.zzgb r11 = (com.google.android.gms.internal.measurement.zzgb) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzeh.zza((long) r4)
            r11.zza((long) r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgb r11 = (com.google.android.gms.internal.measurement.zzgb) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzeh.zza((long) r8)
            r11.zza((long) r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzeh.zza((long) r8)
            r11.zza((long) r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.measurement.zzff r11 = (com.google.android.gms.internal.measurement.zzff) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzeh.zze(r4)
            r11.zzd(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzff r11 = (com.google.android.gms.internal.measurement.zzff) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzeh.zze(r4)
            r11.zzd(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzeh.zze(r4)
            r11.zzd(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.measurement.zzdr.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzfk<?>) r11, (com.google.android.gms.internal.measurement.zzdq) r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.measurement.zzdr.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzfk<?>) r6, (com.google.android.gms.internal.measurement.zzdq) r7)
        L_0x0131:
            com.google.android.gms.internal.measurement.zzfd r1 = (com.google.android.gms.internal.measurement.zzfd) r1
            com.google.android.gms.internal.measurement.zzhx r3 = r1.zzb
            com.google.android.gms.internal.measurement.zzhx r4 = com.google.android.gms.internal.measurement.zzhx.zza()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.measurement.zzfj r4 = r0.zzc((int) r8)
            com.google.android.gms.internal.measurement.zzhu<?, ?> r5 = r0.zzq
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhe.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.measurement.zzhx r3 = (com.google.android.gms.internal.measurement.zzhx) r3
            if (r3 == 0) goto L_0x014e
            r1.zzb = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.measurement.zzdv r4 = com.google.android.gms.internal.measurement.zzdv.zza
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.measurement.zzdv r6 = com.google.android.gms.internal.measurement.zzdv.zza((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.measurement.zzdv r4 = com.google.android.gms.internal.measurement.zzdv.zza
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.measurement.zzdv r6 = com.google.android.gms.internal.measurement.zzdv.zza((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zzb()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zzb()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.measurement.zzhc r1 = r0.zza((int) r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x0216
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0211
            if (r6 != 0) goto L_0x01de
            r11.add(r1)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzfe.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01e8:
            int r4 = r4 + r6
        L_0x01e9:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x020c
            if (r6 != 0) goto L_0x0201
            r11.add(r1)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzfe.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zzb()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zzb()
            throw r1
        L_0x0216:
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0271
            if (r6 != 0) goto L_0x0224
            r11.add(r1)
            goto L_0x0237
        L_0x0224:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzid.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzfe.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x0236:
            r4 = r8
        L_0x0237:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0267
            if (r6 != 0) goto L_0x024f
            r11.add(r1)
            goto L_0x0237
        L_0x024f:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzid.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzfe.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zzh()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zzb()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zzh()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zzb()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.measurement.zzdt r11 = (com.google.android.gms.internal.measurement.zzdt) r11
            int r2 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0290
            r5 = 1
            goto L_0x0291
        L_0x0290:
            r5 = 0
        L_0x0291:
            r11.zza((boolean) r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzdt r11 = (com.google.android.gms.internal.measurement.zzdt) r11
            int r4 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r11.zza((boolean) r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = 1
            goto L_0x02c9
        L_0x02c8:
            r6 = 0
        L_0x02c9:
            r11.zza((boolean) r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.measurement.zzff r11 = (com.google.android.gms.internal.measurement.zzff) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzff r11 = (com.google.android.gms.internal.measurement.zzff) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r18, r19)
            r11.zzd(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4)
            r11.zzd(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.measurement.zzgb r11 = (com.google.android.gms.internal.measurement.zzgb) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r1)
            r11.zza((long) r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgb r11 = (com.google.android.gms.internal.measurement.zzgb) r11
            long r8 = com.google.android.gms.internal.measurement.zzdr.zzb(r18, r19)
            r11.zza((long) r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r4)
            r11.zza((long) r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzfk<?>) r11, (com.google.android.gms.internal.measurement.zzdq) r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.measurement.zzfk<?>) r25, (com.google.android.gms.internal.measurement.zzdq) r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.measurement.zzgb r11 = (com.google.android.gms.internal.measurement.zzgb) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r1, r7)
            long r4 = r7.zzb
            r11.zza((long) r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgb r11 = (com.google.android.gms.internal.measurement.zzgb) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza((long) r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza((long) r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.measurement.zzez r11 = (com.google.android.gms.internal.measurement.zzez) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.measurement.zzdr.zzd(r3, r1)
            r11.zza((float) r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzez r11 = (com.google.android.gms.internal.measurement.zzez) r11
            float r1 = com.google.android.gms.internal.measurement.zzdr.zzd(r18, r19)
            r11.zza((float) r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.measurement.zzdr.zzd(r3, r4)
            r11.zza((float) r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.measurement.zzep r11 = (com.google.android.gms.internal.measurement.zzep) r11
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.measurement.zzdr.zzc(r3, r1)
            r11.zza((double) r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zzep r11 = (com.google.android.gms.internal.measurement.zzep) r11
            double r8 = com.google.android.gms.internal.measurement.zzdr.zzc(r18, r19)
            r11.zza((double) r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.measurement.zzdr.zzc(r3, r4)
            r11.zza((double) r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzdq):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.measurement.zzdq r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r12 = r7.zzb((int) r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.measurement.zzgg r2 = r7.zzs
            boolean r2 = r2.zzc(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.measurement.zzgg r2 = r7.zzs
            java.lang.Object r2 = r2.zze(r12)
            com.google.android.gms.internal.measurement.zzgg r3 = r7.zzs
            r3.zza(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zzgg r8 = r7.zzs
            com.google.android.gms.internal.measurement.zzge r8 = r8.zzf(r12)
            com.google.android.gms.internal.measurement.zzgg r12 = r7.zzs
            java.util.Map r12 = r12.zza(r1)
            int r10 = com.google.android.gms.internal.measurement.zzdr.zza(r9, r10, r15)
            int r13 = r15.zza
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzb
            V r0 = r8.zzd
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.measurement.zzdr.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.measurement.zzdq) r15)
            int r10 = r15.zza
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.measurement.zzil r1 = r8.zzc
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzil r4 = r8.zzc
            V r10 = r8.zzd
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzil) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzdq) r6)
            java.lang.Object r0 = r15.zzc
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.measurement.zzil r1 = r8.zza
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzil r4 = r8.zza
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzil) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzdq) r6)
            java.lang.Object r14 = r15.zzc
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.measurement.zzdr.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.measurement.zzdq) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.measurement.zzfn r8 = com.google.android.gms.internal.measurement.zzfn.zzg()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.measurement.zzfn r8 = com.google.android.gms.internal.measurement.zzfn.zza()
            goto L_0x009d
        L_0x009c:
            throw r8
        L_0x009d:
            goto L_0x009c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.measurement.zzdq):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.measurement.zzdq r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzb
            int[] r7 = r0.zzc
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.measurement.zzhc r2 = r0.zza((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzdr.zza((com.google.android.gms.internal.measurement.zzhc) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.measurement.zzdq) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzfe.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r4, r11)
            long r3 = r11.zzb
            long r3 = com.google.android.gms.internal.measurement.zzeh.zza((long) r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.measurement.zzeh.zze(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r11)
            int r4 = r11.zza
            com.google.android.gms.internal.measurement.zzfj r5 = r0.zzc((int) r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zza(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.measurement.zzhx r1 = zze((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zza((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdr.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.measurement.zzhc r2 = r0.zza((int) r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.measurement.zzdr.zza((com.google.android.gms.internal.measurement.zzhc) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzdq) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzfe.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r11)
            int r4 = r11.zza
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.measurement.zzid.zza((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.measurement.zzfn r1 = com.google.android.gms.internal.measurement.zzfn.zzh()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.measurement.zzfe.zza
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r4, r11)
            long r3 = r11.zzb
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdr.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.measurement.zzdr.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdr.zza(r3, r4, r11)
            int r3 = r11.zza
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzdr.zzb(r3, r4, r11)
            long r3 = r11.zzb
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.measurement.zzdr.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.measurement.zzdr.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.measurement.zzdq):int");
    }

    private final zzhc zza(int i) {
        int i2 = (i / 3) << 1;
        zzhc zzhc = (zzhc) this.zzd[i2];
        if (zzhc != null) {
            return zzhc;
        }
        zzhc zza2 = zzgy.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzfj zzc(int i) {
        return (zzfj) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r25v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v35, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v44, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v36, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v37, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v31, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0372, code lost:
        if (r0 == r15) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x03bb, code lost:
        if (r0 == r15) goto L_0x03e1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0094, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x017a, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0219, code lost:
        r6 = r6 | r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x021b, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
        r11 = r34;
        r13 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0245, code lost:
        r32 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02bc, code lost:
        r0 = r7 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02be, code lost:
        r6 = r6 | r22;
        r7 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02c2, code lost:
        r3 = r8;
        r2 = r9;
        r1 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02c6, code lost:
        r13 = r33;
        r11 = r34;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02cc, code lost:
        r17 = r32;
        r19 = r6;
        r2 = r7;
        r7 = r8;
        r18 = r9;
        r26 = r10;
        r24 = r11;
        r6 = r34;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x03e7 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x03fc  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x043e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r30, byte[] r31, int r32, int r33, int r34, com.google.android.gms.internal.measurement.zzdq r35) throws java.io.IOException {
        /*
            r29 = this;
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r32
            r1 = -1
            r2 = 0
            r3 = 0
            r6 = 0
            r7 = -1
        L_0x0017:
            if (r0 >= r13) goto L_0x0480
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0028
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzdq) r9)
            int r3 = r9.zza
            r4 = r0
            r5 = r3
            goto L_0x002a
        L_0x0028:
            r5 = r0
            r4 = r3
        L_0x002a:
            int r3 = r5 >>> 3
            r0 = r5 & 7
            r8 = 3
            if (r3 <= r1) goto L_0x0037
            int r2 = r2 / r8
            int r1 = r15.zza((int) r3, (int) r2)
            goto L_0x003b
        L_0x0037:
            int r1 = r15.zzg(r3)
        L_0x003b:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004e
            r24 = r3
            r2 = r4
            r19 = r6
            r17 = r7
            r26 = r10
            r6 = r11
            r18 = 0
            r7 = r5
            goto L_0x03e5
        L_0x004e:
            int[] r1 = r15.zzc
            int r18 = r2 + 1
            r8 = r1[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r8 & r18
            int r11 = r18 >>> 20
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r19 = r5
            r5 = r8 & r18
            long r12 = (long) r5
            r5 = 17
            r20 = r8
            if (r11 > r5) goto L_0x02dc
            int r5 = r2 + 2
            r1 = r1[r5]
            int r5 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r5
            r1 = r1 & r18
            if (r1 == r7) goto L_0x0083
            r5 = -1
            if (r7 == r5) goto L_0x007c
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x007c:
            long r6 = (long) r1
            int r6 = r10.getInt(r14, r6)
            r7 = r1
            goto L_0x0084
        L_0x0083:
            r5 = -1
        L_0x0084:
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02a4;
                case 1: goto L_0x028a;
                case 2: goto L_0x0264;
                case 3: goto L_0x0264;
                case 4: goto L_0x0249;
                case 5: goto L_0x0224;
                case 6: goto L_0x0201;
                case 7: goto L_0x01d9;
                case 8: goto L_0x01b4;
                case 9: goto L_0x017e;
                case 10: goto L_0x0163;
                case 11: goto L_0x0249;
                case 12: goto L_0x0131;
                case 13: goto L_0x0201;
                case 14: goto L_0x0224;
                case 15: goto L_0x0116;
                case 16: goto L_0x00e9;
                case 17: goto L_0x0097;
                default: goto L_0x0088;
            }
        L_0x0088:
            r12 = r31
            r13 = r35
            r9 = r2
            r11 = r3
            r32 = r7
            r8 = r19
            r18 = -1
        L_0x0094:
            r7 = r4
            goto L_0x02cc
        L_0x0097:
            r8 = 3
            if (r0 != r8) goto L_0x00dd
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.measurement.zzhc r0 = r15.zza((int) r2)
            r1 = r31
            r9 = r2
            r2 = r4
            r11 = r3
            r3 = r33
            r4 = r8
            r8 = r19
            r18 = -1
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza((com.google.android.gms.internal.measurement.zzhc) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.measurement.zzdq) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00c0
            r5 = r35
            java.lang.Object r1 = r5.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x00cf
        L_0x00c0:
            r5 = r35
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r5.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzfe.zza((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r12, r1)
        L_0x00cf:
            r6 = r6 | r22
            r12 = r31
            r13 = r33
            r3 = r8
            r2 = r9
            r1 = r11
            r11 = r34
            r9 = r5
            goto L_0x0017
        L_0x00dd:
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            goto L_0x0245
        L_0x00e9:
            r5 = r35
            r9 = r2
            r11 = r3
            r8 = r19
            r18 = -1
            if (r0 != 0) goto L_0x0111
            r2 = r12
            r12 = r31
            int r13 = com.google.android.gms.internal.measurement.zzdr.zzb(r12, r4, r5)
            long r0 = r5.zzb
            long r19 = com.google.android.gms.internal.measurement.zzeh.zza((long) r0)
            r0 = r10
            r1 = r30
            r32 = r13
            r13 = r5
            r4 = r19
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r32
            goto L_0x02c2
        L_0x0111:
            r12 = r31
            r13 = r5
            goto L_0x0245
        L_0x0116:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0245
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r12, r4, r13)
            int r1 = r13.zza
            int r1 = com.google.android.gms.internal.measurement.zzeh.zze(r1)
            r10.putInt(r14, r2, r1)
            goto L_0x017a
        L_0x0131:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0245
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r12, r4, r13)
            int r1 = r13.zza
            com.google.android.gms.internal.measurement.zzfj r4 = r15.zzc((int) r9)
            if (r4 == 0) goto L_0x015f
            boolean r4 = r4.zza(r1)
            if (r4 == 0) goto L_0x0151
            goto L_0x015f
        L_0x0151:
            com.google.android.gms.internal.measurement.zzhx r2 = zze((java.lang.Object) r30)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zza((int) r8, (java.lang.Object) r1)
            goto L_0x02c2
        L_0x015f:
            r10.putInt(r14, r2, r1)
            goto L_0x017a
        L_0x0163:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0245
            int r0 = com.google.android.gms.internal.measurement.zzdr.zze(r12, r4, r13)
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r2, r1)
        L_0x017a:
            r6 = r6 | r22
            goto L_0x02c2
        L_0x017e:
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x01b0
            com.google.android.gms.internal.measurement.zzhc r0 = r15.zza((int) r9)
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza((com.google.android.gms.internal.measurement.zzhc) r0, (byte[]) r12, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzdq) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01a1
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0219
        L_0x01a1:
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r13.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzfe.zza((java.lang.Object) r1, (java.lang.Object) r4)
            r10.putObject(r14, r2, r1)
            goto L_0x0219
        L_0x01b0:
            r5 = r33
            goto L_0x0245
        L_0x01b4:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 2
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0245
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x01cf
            int r0 = com.google.android.gms.internal.measurement.zzdr.zzc(r12, r4, r13)
            goto L_0x01d3
        L_0x01cf:
            int r0 = com.google.android.gms.internal.measurement.zzdr.zzd(r12, r4, r13)
        L_0x01d3:
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r2, r1)
            goto L_0x0219
        L_0x01d9:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != 0) goto L_0x0245
            int r0 = com.google.android.gms.internal.measurement.zzdr.zzb(r12, r4, r13)
            r32 = r0
            long r0 = r13.zzb
            r19 = 0
            int r4 = (r0 > r19 ? 1 : (r0 == r19 ? 0 : -1))
            if (r4 == 0) goto L_0x01f8
            r0 = 1
            goto L_0x01f9
        L_0x01f8:
            r0 = 0
        L_0x01f9:
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r6 = r6 | r22
            r0 = r32
            goto L_0x021b
        L_0x0201:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0245
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r12, r4)
            r10.putInt(r14, r2, r0)
            int r0 = r4 + 4
        L_0x0219:
            r6 = r6 | r22
        L_0x021b:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r11 = r34
            r13 = r5
            goto L_0x0017
        L_0x0224:
            r5 = r33
            r9 = r2
            r11 = r3
            r2 = r12
            r8 = r19
            r1 = 1
            r18 = -1
            r12 = r31
            r13 = r35
            if (r0 != r1) goto L_0x0245
            long r19 = com.google.android.gms.internal.measurement.zzdr.zzb(r12, r4)
            r0 = r10
            r1 = r30
            r32 = r7
            r7 = r4
            r4 = r19
            r0.putLong(r1, r2, r4)
            goto L_0x02bc
        L_0x0245:
            r32 = r7
            goto L_0x0094
        L_0x0249:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02cc
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r12, r7, r13)
            int r1 = r13.zza
            r10.putInt(r14, r2, r1)
            goto L_0x02be
        L_0x0264:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != 0) goto L_0x02cc
            int r7 = com.google.android.gms.internal.measurement.zzdr.zzb(r12, r7, r13)
            long r4 = r13.zzb
            r0 = r10
            r1 = r30
            r0.putLong(r1, r2, r4)
            r6 = r6 | r22
            r0 = r7
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
            r7 = r32
            goto L_0x02c6
        L_0x028a:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02cc
            float r0 = com.google.android.gms.internal.measurement.zzdr.zzd(r12, r7)
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r7 + 4
            goto L_0x02be
        L_0x02a4:
            r9 = r2
            r11 = r3
            r32 = r7
            r2 = r12
            r8 = r19
            r1 = 1
            r18 = -1
            r12 = r31
            r13 = r35
            r7 = r4
            if (r0 != r1) goto L_0x02cc
            double r0 = com.google.android.gms.internal.measurement.zzdr.zzc(r12, r7)
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x02bc:
            int r0 = r7 + 8
        L_0x02be:
            r6 = r6 | r22
            r7 = r32
        L_0x02c2:
            r3 = r8
            r2 = r9
            r1 = r11
            r9 = r13
        L_0x02c6:
            r13 = r33
            r11 = r34
            goto L_0x0017
        L_0x02cc:
            r17 = r32
            r19 = r6
            r2 = r7
            r7 = r8
            r18 = r9
            r26 = r10
            r24 = r11
            r6 = r34
            goto L_0x03e5
        L_0x02dc:
            r5 = r3
            r17 = r7
            r8 = r19
            r18 = -1
            r7 = r4
            r27 = r12
            r12 = r31
            r13 = r9
            r9 = r2
            r2 = r27
            r1 = 27
            if (r11 != r1) goto L_0x0341
            r1 = 2
            if (r0 != r1) goto L_0x0334
            java.lang.Object r0 = r10.getObject(r14, r2)
            com.google.android.gms.internal.measurement.zzfk r0 = (com.google.android.gms.internal.measurement.zzfk) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x0311
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0308
            r1 = 10
            goto L_0x030a
        L_0x0308:
            int r1 = r1 << 1
        L_0x030a:
            com.google.android.gms.internal.measurement.zzfk r0 = r0.zza(r1)
            r10.putObject(r14, r2, r0)
        L_0x0311:
            r11 = r0
            com.google.android.gms.internal.measurement.zzhc r0 = r15.zza((int) r9)
            r1 = r8
            r2 = r31
            r3 = r7
            r4 = r33
            r7 = r5
            r5 = r11
            r19 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r34
            r1 = r7
            r3 = r8
            r2 = r9
            r9 = r13
            r7 = r17
            r6 = r19
            r13 = r33
            goto L_0x0017
        L_0x0334:
            r19 = r6
            r24 = r5
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            goto L_0x03be
        L_0x0341:
            r19 = r6
            r6 = r5
            r1 = 49
            if (r11 > r1) goto L_0x0390
            r5 = r20
            long r4 = (long) r5
            r1 = r0
            r0 = r29
            r32 = r1
            r1 = r30
            r22 = r2
            r2 = r31
            r3 = r7
            r20 = r4
            r4 = r33
            r5 = r8
            r24 = r6
            r15 = r7
            r7 = r32
            r25 = r8
            r8 = r9
            r18 = r9
            r26 = r10
            r9 = r20
            r12 = r22
            r14 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzdq) r14)
            if (r0 != r15) goto L_0x0376
            goto L_0x03e1
        L_0x0376:
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r7 = r17
            r2 = r18
            r6 = r19
            r1 = r24
            r3 = r25
        L_0x038c:
            r10 = r26
            goto L_0x0017
        L_0x0390:
            r32 = r0
            r22 = r2
            r24 = r6
            r15 = r7
            r25 = r8
            r18 = r9
            r26 = r10
            r5 = r20
            r0 = 50
            if (r11 != r0) goto L_0x03c4
            r7 = r32
            r0 = 2
            if (r7 != r0) goto L_0x03be
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r5 = r18
            r6 = r22
            r8 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzdq) r8)
            if (r0 != r15) goto L_0x0376
            goto L_0x03e1
        L_0x03be:
            r6 = r34
            r2 = r15
        L_0x03c1:
            r7 = r25
            goto L_0x03e5
        L_0x03c4:
            r7 = r32
            r0 = r29
            r1 = r30
            r2 = r31
            r3 = r15
            r4 = r33
            r8 = r5
            r5 = r25
            r6 = r24
            r9 = r11
            r10 = r22
            r12 = r18
            r13 = r35
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzdq) r13)
            if (r0 != r15) goto L_0x0466
        L_0x03e1:
            r6 = r34
            r2 = r0
            goto L_0x03c1
        L_0x03e5:
            if (r7 != r6) goto L_0x03f6
            if (r6 != 0) goto L_0x03ea
            goto L_0x03f6
        L_0x03ea:
            r4 = -1
            r8 = r29
            r11 = r30
            r3 = r7
            r0 = r17
            r1 = r19
            goto L_0x048f
        L_0x03f6:
            r8 = r29
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x043e
            r9 = r35
            com.google.android.gms.internal.measurement.zzeq r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzeq r1 = com.google.android.gms.internal.measurement.zzeq.zza()
            if (r0 == r1) goto L_0x043b
            com.google.android.gms.internal.measurement.zzgn r0 = r8.zzg
            com.google.android.gms.internal.measurement.zzeq r1 = r9.zzd
            r10 = r24
            com.google.android.gms.internal.measurement.zzfd$zze r0 = r1.zza(r0, r10)
            if (r0 != 0) goto L_0x042b
            com.google.android.gms.internal.measurement.zzhx r4 = zze((java.lang.Object) r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzhx) r4, (com.google.android.gms.internal.measurement.zzdq) r5)
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r6
            r3 = r7
            r15 = r8
            goto L_0x0477
        L_0x042b:
            r11 = r30
            r0 = r11
            com.google.android.gms.internal.measurement.zzfd$zzb r0 = (com.google.android.gms.internal.measurement.zzfd.zzb) r0
            r0.zza()
            com.google.android.gms.internal.measurement.zzet<java.lang.Object> r0 = r0.zzc
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x043b:
            r11 = r30
            goto L_0x0442
        L_0x043e:
            r11 = r30
            r9 = r35
        L_0x0442:
            r10 = r24
            com.google.android.gms.internal.measurement.zzhx r4 = zze((java.lang.Object) r30)
            r0 = r7
            r1 = r31
            r3 = r33
            r5 = r35
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzhx) r4, (com.google.android.gms.internal.measurement.zzdq) r5)
            r12 = r31
            r13 = r33
            r3 = r7
            r15 = r8
            r1 = r10
            r14 = r11
            r7 = r17
            r2 = r18
            r10 = r26
            r11 = r6
            r6 = r19
            goto L_0x0017
        L_0x0466:
            r10 = r24
            r7 = r25
            r15 = r29
            r14 = r30
            r12 = r31
            r13 = r33
            r11 = r34
            r9 = r35
            r3 = r7
        L_0x0477:
            r1 = r10
            r7 = r17
            r2 = r18
            r6 = r19
            goto L_0x038c
        L_0x0480:
            r19 = r6
            r17 = r7
            r26 = r10
            r6 = r11
            r11 = r14
            r8 = r15
            r2 = r0
            r0 = r17
            r1 = r19
            r4 = -1
        L_0x048f:
            if (r0 == r4) goto L_0x0497
            long r4 = (long) r0
            r0 = r26
            r0.putInt(r11, r4, r1)
        L_0x0497:
            r0 = 0
            int r1 = r8.zzm
        L_0x049a:
            int r4 = r8.zzn
            if (r1 >= r4) goto L_0x04ad
            int[] r4 = r8.zzl
            r4 = r4[r1]
            com.google.android.gms.internal.measurement.zzhu<?, ?> r5 = r8.zzq
            java.lang.Object r0 = r8.zza((java.lang.Object) r11, (int) r4, r0, r5)
            com.google.android.gms.internal.measurement.zzhx r0 = (com.google.android.gms.internal.measurement.zzhx) r0
            int r1 = r1 + 1
            goto L_0x049a
        L_0x04ad:
            if (r0 == 0) goto L_0x04b4
            com.google.android.gms.internal.measurement.zzhu<?, ?> r1 = r8.zzq
            r1.zzb((java.lang.Object) r11, r0)
        L_0x04b4:
            if (r6 != 0) goto L_0x04c0
            r0 = r33
            if (r2 != r0) goto L_0x04bb
            goto L_0x04c6
        L_0x04bb:
            com.google.android.gms.internal.measurement.zzfn r0 = com.google.android.gms.internal.measurement.zzfn.zzg()
            throw r0
        L_0x04c0:
            r0 = r33
            if (r2 > r0) goto L_0x04c7
            if (r3 != r6) goto L_0x04c7
        L_0x04c6:
            return r2
        L_0x04c7:
            com.google.android.gms.internal.measurement.zzfn r0 = com.google.android.gms.internal.measurement.zzfn.zzg()
            goto L_0x04cd
        L_0x04cc:
            throw r0
        L_0x04cd:
            goto L_0x04cc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzdq):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v2, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x010b, code lost:
        r2 = r4;
        r1 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x013d, code lost:
        r0 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0159, code lost:
        r0 = r8 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x015b, code lost:
        r1 = r7;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x015f, code lost:
        r24 = r7;
        r15 = r8;
        r18 = r9;
        r19 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x01e2, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x020f, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x022e, code lost:
        if (r0 == r15) goto L_0x0230;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r28, byte[] r29, int r30, int r31, com.google.android.gms.internal.measurement.zzdq r32) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            boolean r0 = r15.zzj
            if (r0 == 0) goto L_0x025d
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
        L_0x0017:
            if (r0 >= r13) goto L_0x0254
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0029
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzdq) r11)
            int r3 = r11.zza
            r8 = r0
            r17 = r3
            goto L_0x002c
        L_0x0029:
            r17 = r0
            r8 = r3
        L_0x002c:
            int r7 = r17 >>> 3
            r6 = r17 & 7
            if (r7 <= r1) goto L_0x0039
            int r2 = r2 / 3
            int r0 = r15.zza((int) r7, (int) r2)
            goto L_0x003d
        L_0x0039:
            int r0 = r15.zzg(r7)
        L_0x003d:
            r4 = r0
            if (r4 != r10) goto L_0x004b
            r24 = r7
            r2 = r8
            r18 = r9
            r19 = 0
            r26 = -1
            goto L_0x0231
        L_0x004b:
            int[] r0 = r15.zzc
            int r1 = r4 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r3 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r1 = (long) r0
            r0 = 17
            r10 = 2
            if (r3 > r0) goto L_0x0167
            r0 = 1
            switch(r3) {
                case 0: goto L_0x014e;
                case 1: goto L_0x013f;
                case 2: goto L_0x012d;
                case 3: goto L_0x012d;
                case 4: goto L_0x011f;
                case 5: goto L_0x010f;
                case 6: goto L_0x00fe;
                case 7: goto L_0x00e8;
                case 8: goto L_0x00d1;
                case 9: goto L_0x00b0;
                case 10: goto L_0x00a3;
                case 11: goto L_0x011f;
                case 12: goto L_0x0094;
                case 13: goto L_0x00fe;
                case 14: goto L_0x010f;
                case 15: goto L_0x0081;
                case 16: goto L_0x0066;
                default: goto L_0x0064;
            }
        L_0x0064:
            goto L_0x01a4
        L_0x0066:
            if (r6 != 0) goto L_0x01a4
            int r6 = com.google.android.gms.internal.measurement.zzdr.zzb(r12, r8, r11)
            r19 = r1
            long r0 = r11.zzb
            long r21 = com.google.android.gms.internal.measurement.zzeh.zza((long) r0)
            r0 = r9
            r2 = r19
            r1 = r28
            r10 = r4
            r4 = r21
            r0.putLong(r1, r2, r4)
            goto L_0x013d
        L_0x0081:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r12, r8, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzeh.zze(r1)
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x0094:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x00a3:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            int r0 = com.google.android.gms.internal.measurement.zzdr.zze(r12, r8, r11)
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00b0:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            com.google.android.gms.internal.measurement.zzhc r0 = r15.zza((int) r4)
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza((com.google.android.gms.internal.measurement.zzhc) r0, (byte[]) r12, (int) r8, (int) r13, (com.google.android.gms.internal.measurement.zzdq) r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x00c7
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00c7:
            java.lang.Object r5 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzfe.zza((java.lang.Object) r1, (java.lang.Object) r5)
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00d1:
            r2 = r1
            if (r6 != r10) goto L_0x01a4
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x00de
            int r0 = com.google.android.gms.internal.measurement.zzdr.zzc(r12, r8, r11)
            goto L_0x00e2
        L_0x00de:
            int r0 = com.google.android.gms.internal.measurement.zzdr.zzd(r12, r8, r11)
        L_0x00e2:
            java.lang.Object r1 = r11.zzc
            r9.putObject(r14, r2, r1)
            goto L_0x010b
        L_0x00e8:
            r2 = r1
            if (r6 != 0) goto L_0x01a4
            int r1 = com.google.android.gms.internal.measurement.zzdr.zzb(r12, r8, r11)
            long r5 = r11.zzb
            r19 = 0
            int r8 = (r5 > r19 ? 1 : (r5 == r19 ? 0 : -1))
            if (r8 == 0) goto L_0x00f8
            goto L_0x00f9
        L_0x00f8:
            r0 = 0
        L_0x00f9:
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r2, (boolean) r0)
            r0 = r1
            goto L_0x010b
        L_0x00fe:
            r2 = r1
            r0 = 5
            if (r6 != r0) goto L_0x01a4
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r12, r8)
            r9.putInt(r14, r2, r0)
            int r0 = r8 + 4
        L_0x010b:
            r2 = r4
            r1 = r7
            goto L_0x0251
        L_0x010f:
            r2 = r1
            if (r6 != r0) goto L_0x01a4
            long r5 = com.google.android.gms.internal.measurement.zzdr.zzb(r12, r8)
            r0 = r9
            r1 = r28
            r10 = r4
            r4 = r5
            r0.putLong(r1, r2, r4)
            goto L_0x0159
        L_0x011f:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r12, r8, r11)
            int r1 = r11.zza
            r9.putInt(r14, r2, r1)
            goto L_0x015b
        L_0x012d:
            r2 = r1
            r10 = r4
            if (r6 != 0) goto L_0x015f
            int r6 = com.google.android.gms.internal.measurement.zzdr.zzb(r12, r8, r11)
            long r4 = r11.zzb
            r0 = r9
            r1 = r28
            r0.putLong(r1, r2, r4)
        L_0x013d:
            r0 = r6
            goto L_0x015b
        L_0x013f:
            r2 = r1
            r10 = r4
            r0 = 5
            if (r6 != r0) goto L_0x015f
            float r0 = com.google.android.gms.internal.measurement.zzdr.zzd(r12, r8)
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r2, (float) r0)
            int r0 = r8 + 4
            goto L_0x015b
        L_0x014e:
            r2 = r1
            r10 = r4
            if (r6 != r0) goto L_0x015f
            double r0 = com.google.android.gms.internal.measurement.zzdr.zzc(r12, r8)
            com.google.android.gms.internal.measurement.zzia.zza((java.lang.Object) r14, (long) r2, (double) r0)
        L_0x0159:
            int r0 = r8 + 8
        L_0x015b:
            r1 = r7
            r2 = r10
            goto L_0x0251
        L_0x015f:
            r24 = r7
            r15 = r8
            r18 = r9
            r19 = r10
            goto L_0x01ab
        L_0x0167:
            r0 = 27
            if (r3 != r0) goto L_0x01af
            if (r6 != r10) goto L_0x01a4
            java.lang.Object r0 = r9.getObject(r14, r1)
            com.google.android.gms.internal.measurement.zzfk r0 = (com.google.android.gms.internal.measurement.zzfk) r0
            boolean r3 = r0.zza()
            if (r3 != 0) goto L_0x018b
            int r3 = r0.size()
            if (r3 != 0) goto L_0x0182
            r3 = 10
            goto L_0x0184
        L_0x0182:
            int r3 = r3 << 1
        L_0x0184:
            com.google.android.gms.internal.measurement.zzfk r0 = r0.zza(r3)
            r9.putObject(r14, r1, r0)
        L_0x018b:
            r5 = r0
            com.google.android.gms.internal.measurement.zzhc r0 = r15.zza((int) r4)
            r1 = r17
            r2 = r29
            r3 = r8
            r19 = r4
            r4 = r31
            r6 = r32
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza(r0, r1, r2, r3, r4, r5, r6)
            r1 = r7
            r2 = r19
            goto L_0x0251
        L_0x01a4:
            r19 = r4
            r24 = r7
            r15 = r8
            r18 = r9
        L_0x01ab:
            r26 = -1
            goto L_0x0212
        L_0x01af:
            r19 = r4
            r0 = 49
            if (r3 > r0) goto L_0x01e5
            long r4 = (long) r5
            r0 = r27
            r20 = r1
            r1 = r28
            r2 = r29
            r10 = r3
            r3 = r8
            r22 = r4
            r4 = r31
            r5 = r17
            r30 = r6
            r6 = r7
            r24 = r7
            r7 = r30
            r15 = r8
            r8 = r19
            r18 = r9
            r25 = r10
            r26 = -1
            r9 = r22
            r11 = r25
            r12 = r20
            r14 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzdq) r14)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x01e5:
            r20 = r1
            r25 = r3
            r30 = r6
            r24 = r7
            r15 = r8
            r18 = r9
            r26 = -1
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x0214
            r7 = r30
            if (r7 != r10) goto L_0x0212
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r6 = r20
            r8 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzdq) r8)
            if (r0 != r15) goto L_0x0241
            goto L_0x0230
        L_0x0212:
            r2 = r15
            goto L_0x0231
        L_0x0214:
            r7 = r30
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r8 = r5
            r5 = r17
            r6 = r24
            r10 = r20
            r12 = r19
            r13 = r32
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzdq) r13)
            if (r0 != r15) goto L_0x0241
        L_0x0230:
            r2 = r0
        L_0x0231:
            com.google.android.gms.internal.measurement.zzhx r4 = zze((java.lang.Object) r28)
            r0 = r17
            r1 = r29
            r3 = r31
            r5 = r32
            int r0 = com.google.android.gms.internal.measurement.zzdr.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzhx) r4, (com.google.android.gms.internal.measurement.zzdq) r5)
        L_0x0241:
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r18
            r2 = r19
            r1 = r24
        L_0x0251:
            r10 = -1
            goto L_0x0017
        L_0x0254:
            r4 = r13
            if (r0 != r4) goto L_0x0258
            return
        L_0x0258:
            com.google.android.gms.internal.measurement.zzfn r0 = com.google.android.gms.internal.measurement.zzfn.zzg()
            throw r0
        L_0x025d:
            r4 = r13
            r5 = 0
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r30
            r4 = r31
            r6 = r32
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzdq) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgr.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzdq):void");
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzia.zzf(t, zzd2);
            if (zzf2 != null) {
                zzia.zza((Object) t, zzd2, this.zzs.zzd(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzhu<UT, UB> zzhu) {
        zzfj zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzia.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzhu);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfj zzfj, UB ub, zzhu<UT, UB> zzhu) {
        zzge<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzfj.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzhu.zza();
                }
                zzed zzc2 = zzdv.zzc(zzgf.zza(zzf2, next.getKey(), next.getValue()));
                try {
                    zzgf.zza(zzc2.zzb(), zzf2, next.getKey(), next.getValue());
                    zzhu.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean zzd(T t) {
        int i;
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t).zzf();
            }
            int i5 = this.zzl[i2];
            int i6 = this.zzc[i5];
            int zzd2 = zzd(i5);
            if (!this.zzj) {
                int i7 = this.zzc[i5 + 2];
                int i8 = i7 & 1048575;
                i = 1 << (i7 >>> 20);
                if (i8 != i3) {
                    i4 = zzb.getInt(t, (long) i8);
                    i3 = i8;
                }
            } else {
                i = 0;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i5, i4, i)) {
                return false;
            }
            int i9 = (267386880 & zzd2) >>> 20;
            if (i9 != 9 && i9 != 17) {
                if (i9 != 27) {
                    if (i9 == 60 || i9 == 68) {
                        if (zza(t, i6, i5) && !zza((Object) t, zzd2, zza(i5))) {
                            return false;
                        }
                    } else if (i9 != 49) {
                        if (i9 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzb2 = this.zzs.zzb(zzia.zzf(t, (long) (zzd2 & 1048575)));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i5)).zzc.zza() == zzio.MESSAGE) {
                                    zzhc<?> zzhc = null;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzhc == null) {
                                            zzhc = zzgy.zza().zza(next.getClass());
                                        }
                                        if (!zzhc.zzd(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzia.zzf(t, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzhc zza2 = zza(i5);
                    int i10 = 0;
                    while (true) {
                        if (i10 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i10))) {
                            z = false;
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i5, i4, i) && !zza((Object) t, zzd2, zza(i5))) {
                return false;
            }
            i2++;
        }
    }

    private static boolean zza(Object obj, int i, zzhc zzhc) {
        return zzhc.zzd(zzia.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzir zzir) throws IOException {
        if (obj instanceof String) {
            zzir.zza(i, (String) obj);
        } else {
            zzir.zza(i, (zzdv) obj);
        }
    }

    private final void zza(Object obj, int i, zzhd zzhd) throws IOException {
        if (zzf(i)) {
            zzia.zza(obj, (long) (i & 1048575), (Object) zzhd.zzm());
        } else if (this.zzi) {
            zzia.zza(obj, (long) (i & 1048575), (Object) zzhd.zzl());
        } else {
            zzia.zza(obj, (long) (i & 1048575), (Object) zzhd.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzia.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzia.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzia.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzia.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzia.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzj) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzj) {
            int zzd2 = zzd(i);
            long j = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzia.zze(t, j) != 0.0d;
                case 1:
                    return zzia.zzd(t, j) != 0.0f;
                case 2:
                    return zzia.zzb(t, j) != 0;
                case 3:
                    return zzia.zzb(t, j) != 0;
                case 4:
                    return zzia.zza((Object) t, j) != 0;
                case 5:
                    return zzia.zzb(t, j) != 0;
                case 6:
                    return zzia.zza((Object) t, j) != 0;
                case 7:
                    return zzia.zzc(t, j);
                case 8:
                    Object zzf2 = zzia.zzf(t, j);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzdv) {
                        return !zzdv.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzia.zzf(t, j) != null;
                case 10:
                    return !zzdv.zza.equals(zzia.zzf(t, j));
                case 11:
                    return zzia.zza((Object) t, j) != 0;
                case 12:
                    return zzia.zza((Object) t, j) != 0;
                case 13:
                    return zzia.zza((Object) t, j) != 0;
                case 14:
                    return zzia.zzb(t, j) != 0;
                case 15:
                    return zzia.zza((Object) t, j) != 0;
                case 16:
                    return zzia.zzb(t, j) != 0;
                case 17:
                    return zzia.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zze2 = zze(i);
            return (zzia.zza((Object) t, (long) (zze2 & 1048575)) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzj) {
            int zze2 = zze(i);
            long j = (long) (zze2 & 1048575);
            zzia.zza((Object) t, j, zzia.zza((Object) t, j) | (1 << (zze2 >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzia.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzia.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
