package com.google.android.gms.internal.firebase_auth;

import com.adobe.xmp.options.PropertyOptions;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzjk<T> implements zzjw<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzky.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjg zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjp zzo;
    private final zziq zzp;
    private final zzks<?, ?> zzq;
    private final zzhm<?> zzr;
    private final zzjd zzs;

    private zzjk(int[] iArr, Object[] objArr, int i, int i2, zzjg zzjg, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjp zzjp, zziq zziq, zzks<?, ?> zzks, zzhm<?> zzhm, zzjd zzjd) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjg instanceof zzhx;
        this.zzj = z;
        this.zzh = zzhm != null && zzhm.zza(zzjg);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjp;
        this.zzp = zziq;
        this.zzq = zzks;
        this.zzr = zzhm;
        this.zzg = zzjg;
        this.zzs = zzjd;
    }

    private static boolean zzf(int i) {
        return (i & PropertyOptions.DELETE_EXISTING) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:168:0x037d  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x03c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.firebase_auth.zzjk<T> zza(java.lang.Class<T> r35, com.google.android.gms.internal.firebase_auth.zzje r36, com.google.android.gms.internal.firebase_auth.zzjp r37, com.google.android.gms.internal.firebase_auth.zziq r38, com.google.android.gms.internal.firebase_auth.zzks<?, ?> r39, com.google.android.gms.internal.firebase_auth.zzhm<?> r40, com.google.android.gms.internal.firebase_auth.zzjd r41) {
        /*
            r0 = r36
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzju
            if (r1 == 0) goto L_0x0444
            com.google.android.gms.internal.firebase_auth.zzju r0 = (com.google.android.gms.internal.firebase_auth.zzju) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.firebase_auth.zzhx.zze.zzi
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
            com.google.android.gms.internal.firebase_auth.zzjg r18 = r0.zzc()
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
            com.google.android.gms.internal.firebase_auth.zzjk r1 = new com.google.android.gms.internal.firebase_auth.zzjk
            com.google.android.gms.internal.firebase_auth.zzjg r0 = r0.zzc()
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
            com.google.android.gms.internal.firebase_auth.zzkl r0 = (com.google.android.gms.internal.firebase_auth.zzkl) r0
            int r0 = r0.zza()
            int r1 = com.google.android.gms.internal.firebase_auth.zzhx.zze.zzi
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            goto L_0x0453
        L_0x0452:
            throw r0
        L_0x0453:
            goto L_0x0452
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjk.zza(java.lang.Class, com.google.android.gms.internal.firebase_auth.zzje, com.google.android.gms.internal.firebase_auth.zzjp, com.google.android.gms.internal.firebase_auth.zziq, com.google.android.gms.internal.firebase_auth.zzks, com.google.android.gms.internal.firebase_auth.zzhm, com.google.android.gms.internal.firebase_auth.zzjd):com.google.android.gms.internal.firebase_auth.zzjk");
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
        if (com.google.android.gms.internal.firebase_auth.zzjy.zza(com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6), com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzjy.zza(com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6), com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzjy.zza(com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6), com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzjy.zza(com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6), com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zzc(r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6) == com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_auth.zzky.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_auth.zzky.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_auth.zzky.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_auth.zzky.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzjy.zza(com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6), com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)) != false) goto L_0x01c2;
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
            int r4 = r9.zze(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_auth.zzjy.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_auth.zzjy.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzky.zzc(r10, r6)
            boolean r5 = com.google.android.gms.internal.firebase_auth.zzky.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.firebase_auth.zzky.zzd(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.firebase_auth.zzky.zzd(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.firebase_auth.zzky.zze(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.firebase_auth.zzky.zze(r11, r6)
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
            com.google.android.gms.internal.firebase_auth.zzks<?, ?> r0 = r9.zzq
            java.lang.Object r0 = r0.zzb(r10)
            com.google.android.gms.internal.firebase_auth.zzks<?, ?> r2 = r9.zzq
            java.lang.Object r2 = r2.zzb(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.firebase_auth.zzhm<?> r0 = r9.zzr
            com.google.android.gms.internal.firebase_auth.zzhq r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.firebase_auth.zzhm<?> r0 = r9.zzr
            com.google.android.gms.internal.firebase_auth.zzhq r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjk.zza(java.lang.Object, java.lang.Object):boolean");
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
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
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
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
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
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzf(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((boolean) r3)
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
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
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
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
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
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.firebase_auth.zzky.zzc(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.firebase_auth.zzky.zzd(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.firebase_auth.zzky.zze(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.firebase_auth.zzib.zza((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase_auth.zzks<?, ?> r0 = r8.zzq
            java.lang.Object r0 = r0.zzb(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase_auth.zzhm<?> r0 = r8.zzr
            com.google.android.gms.internal.firebase_auth.zzhq r9 = r0.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjk.zza(java.lang.Object):int");
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
                            zzky.zza((Object) t, j, zzky.zze(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zzd(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zzc(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zzf(t2, j));
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
                            zzky.zza((Object) t, j, zzky.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzky.zza((Object) t, j, zzky.zzb(t2, j));
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
                        zzjy.zza(this.zzs, t, t2, j);
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
                            zzky.zza((Object) t, j, zzky.zzf(t2, j));
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
                            zzky.zza((Object) t, j, zzky.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            if (!this.zzj) {
                zzjy.zza(this.zzq, t, t2);
                if (this.zzh) {
                    zzjy.zza(this.zzr, t, t2);
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
            Object zzf2 = zzky.zzf(t, zzd2);
            Object zzf3 = zzky.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzky.zza((Object) t, zzd2, zzib.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzky.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzky.zzf(t, j);
            Object zzf3 = zzky.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzky.zza((Object) t, j, zzib.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzky.zza((Object) t, j, zzf3);
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
            com.google.android.gms.internal.firebase_auth.zzhr r14 = com.google.android.gms.internal.firebase_auth.zzhr.DOUBLE_LIST_PACKED
            int r14 = r14.zza()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.firebase_auth.zzhr r14 = com.google.android.gms.internal.firebase_auth.zzhr.SINT64_LIST_PACKED
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
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzjg r5 = (com.google.android.gms.internal.firebase_auth.zzjg) r5
            com.google.android.gms.internal.firebase_auth.zzjw r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzh((int) r3, (int) r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzj(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzk(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r3, (int) r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzgm r5 = (com.google.android.gms.internal.firebase_auth.zzgm) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzc((int) r3, (com.google.android.gms.internal.firebase_auth.zzgm) r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzjw r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.firebase_auth.zzjw) r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.firebase_auth.zzgm
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.firebase_auth.zzgm r5 = (com.google.android.gms.internal.firebase_auth.zzgm) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzc((int) r3, (com.google.android.gms.internal.firebase_auth.zzgm) r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzi(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzf((int) r3, (int) r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.firebase_auth.zzjd r14 = r0.zzs
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r1, r5)
            java.lang.Object r6 = r0.zzb((int) r12)
            int r3 = r14.zza(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.firebase_auth.zzjw r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r3, (java.util.List<com.google.android.gms.internal.firebase_auth.zzjg>) r5, (com.google.android.gms.internal.firebase_auth.zzjw) r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzc(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzg(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzd(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzf(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzj(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zze(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzb(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zza((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zzk
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzc(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzg(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzd(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzf(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzb(r3, r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.firebase_auth.zzjw r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.firebase_auth.zzjw) r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r3, (java.util.List<?>) r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzj(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zze(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzjg r5 = (com.google.android.gms.internal.firebase_auth.zzjg) r5
            com.google.android.gms.internal.firebase_auth.zzjw r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzh((int) r3, (int) r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzj(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzk(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r3, (int) r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzgm r5 = (com.google.android.gms.internal.firebase_auth.zzgm) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzc((int) r3, (com.google.android.gms.internal.firebase_auth.zzgm) r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzjw r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.firebase_auth.zzjw) r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.firebase_auth.zzgm
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.firebase_auth.zzgm r5 = (com.google.android.gms.internal.firebase_auth.zzgm) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzc((int) r3, (com.google.android.gms.internal.firebase_auth.zzgm) r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r3, (boolean) r8)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzi(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzf((int) r3, (int) r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.firebase_auth.zzks<?, ?> r2 = r0.zzq
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
            com.google.android.gms.internal.firebase_auth.zzhr r8 = com.google.android.gms.internal.firebase_auth.zzhr.DOUBLE_LIST_PACKED
            int r8 = r8.zza()
            if (r4 < r8) goto L_0x0542
            com.google.android.gms.internal.firebase_auth.zzhr r8 = com.google.android.gms.internal.firebase_auth.zzhr.SINT64_LIST_PACKED
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
            com.google.android.gms.internal.firebase_auth.zzjg r4 = (com.google.android.gms.internal.firebase_auth.zzjg) r4
            com.google.android.gms.internal.firebase_auth.zzjw r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x0563:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzf((int) r15, (long) r8)
            goto L_0x0910
        L_0x0573:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzh((int) r15, (int) r4)
            goto L_0x0910
        L_0x0583:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzh((int) r15, (long) r8)
            goto L_0x0910
        L_0x0591:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzj(r15, r4)
            goto L_0x095a
        L_0x059e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzk(r15, r4)
            goto L_0x0910
        L_0x05ae:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r15, (int) r4)
            goto L_0x0910
        L_0x05be:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase_auth.zzgm r4 = (com.google.android.gms.internal.firebase_auth.zzgm) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzc((int) r15, (com.google.android.gms.internal.firebase_auth.zzgm) r4)
            goto L_0x0910
        L_0x05d0:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase_auth.zzjw r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzjw) r8)
            goto L_0x0910
        L_0x05e4:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.firebase_auth.zzgm
            if (r8 == 0) goto L_0x05fa
            com.google.android.gms.internal.firebase_auth.zzgm r4 = (com.google.android.gms.internal.firebase_auth.zzgm) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzc((int) r15, (com.google.android.gms.internal.firebase_auth.zzgm) r4)
            goto L_0x0910
        L_0x05fa:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r15, (java.lang.String) r4)
            goto L_0x0910
        L_0x0602:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r15, (boolean) r4)
            goto L_0x095a
        L_0x060f:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzi(r15, r4)
            goto L_0x095a
        L_0x061c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r15, (long) r8)
            goto L_0x0910
        L_0x062a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzf((int) r15, (int) r4)
            goto L_0x0910
        L_0x063a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15, (long) r8)
            goto L_0x0910
        L_0x064a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzd((int) r15, (long) r8)
            goto L_0x0910
        L_0x065a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r15, (float) r4)
            goto L_0x095a
        L_0x0667:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r15, (double) r8)
            goto L_0x0910
        L_0x0675:
            com.google.android.gms.internal.firebase_auth.zzjd r4 = r0.zzs
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzb((int) r3)
            int r4 = r4.zza(r15, r8, r9)
            goto L_0x0910
        L_0x0685:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzjw r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r15, (java.util.List<com.google.android.gms.internal.firebase_auth.zzjg>) r4, (com.google.android.gms.internal.firebase_auth.zzjw) r8)
            goto L_0x0910
        L_0x0695:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzc(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x06a9
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06a9:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x06b3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzg(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x06c7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06c7:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x06d1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x06e5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x06e5:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x06ef:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x0703
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0703:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x070d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzd(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x0721
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0721:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x072b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzf(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x073f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x073f:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x0749:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzj(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x075d
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x075d:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x0767:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x077b
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x077b:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x0785:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x0799
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x0799:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x07a3:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zze(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x07b7
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07b7:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x07c1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzb(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x07d5
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07d5:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x07de:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x07f2
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x07f2:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x07fb:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x080f
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x080f:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
            goto L_0x0834
        L_0x0818:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r4)
            if (r4 <= 0) goto L_0x0911
            boolean r8 = r0.zzk
            if (r8 == 0) goto L_0x082c
            long r8 = (long) r11
            r2.putInt(r1, r8, r4)
        L_0x082c:
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15)
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r4)
        L_0x0834:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x095a
        L_0x0838:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzc(r15, r4, r10)
            goto L_0x0900
        L_0x0845:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzg(r15, r4, r10)
            goto L_0x0900
        L_0x0852:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r15, r4, r10)
            goto L_0x0900
        L_0x085f:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r15, r4, r10)
            goto L_0x0900
        L_0x086c:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzd(r15, r4, r10)
            goto L_0x0900
        L_0x0879:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzf(r15, r4, r10)
            goto L_0x0910
        L_0x0886:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzb(r15, r4)
            goto L_0x0910
        L_0x0892:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzjw r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.firebase_auth.zzjw) r8)
            goto L_0x0910
        L_0x08a2:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r15, (java.util.List<?>) r4)
            goto L_0x0910
        L_0x08ad:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzj(r15, r4, r10)
            goto L_0x0900
        L_0x08b9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r15, r4, r10)
            goto L_0x0900
        L_0x08c5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r15, r4, r10)
            goto L_0x0900
        L_0x08d1:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zze(r15, r4, r10)
            goto L_0x0900
        L_0x08dd:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x0900
        L_0x08e9:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x0900
        L_0x08f5:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzh(r15, r4, r10)
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
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zzi(r15, r4, r10)
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
            com.google.android.gms.internal.firebase_auth.zzjg r4 = (com.google.android.gms.internal.firebase_auth.zzjg) r4
            com.google.android.gms.internal.firebase_auth.zzjw r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzc(r15, r4, r8)
            goto L_0x0910
        L_0x092c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzf((int) r15, (long) r8)
            goto L_0x0910
        L_0x0939:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzh((int) r15, (int) r4)
            goto L_0x0910
        L_0x0946:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r8 = 0
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzh((int) r15, (long) r8)
            goto L_0x0910
        L_0x0951:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 0
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzj(r15, r4)
        L_0x095a:
            int r5 = r5 + r8
            goto L_0x0911
        L_0x095c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzk(r15, r4)
            goto L_0x0910
        L_0x0969:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r15, (int) r4)
            goto L_0x0910
        L_0x0976:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase_auth.zzgm r4 = (com.google.android.gms.internal.firebase_auth.zzgm) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzc((int) r15, (com.google.android.gms.internal.firebase_auth.zzgm) r4)
            goto L_0x0910
        L_0x0985:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.firebase_auth.zzjw r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzjw) r8)
            goto L_0x0910
        L_0x0997:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.firebase_auth.zzgm
            if (r8 == 0) goto L_0x09ab
            com.google.android.gms.internal.firebase_auth.zzgm r4 = (com.google.android.gms.internal.firebase_auth.zzgm) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzc((int) r15, (com.google.android.gms.internal.firebase_auth.zzgm) r4)
            goto L_0x0910
        L_0x09ab:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r15, (java.lang.String) r4)
            goto L_0x0910
        L_0x09b3:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x0911
            r4 = 1
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r15, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x0912
        L_0x09bf:
            r4 = 1
            r8 = r12 & r18
            if (r8 == 0) goto L_0x09cc
            r10 = 0
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzi(r15, r10)
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
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzg((int) r15, (long) r13)
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
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzf((int) r15, (int) r8)
            goto L_0x0a11
        L_0x09f0:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zze((int) r15, (long) r8)
            goto L_0x0a11
        L_0x0a01:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a21
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.firebase_auth.zzhh.zzd((int) r15, (long) r8)
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
            int r9 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r15, (float) r8)
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
            int r11 = com.google.android.gms.internal.firebase_auth.zzhh.zzb((int) r15, (double) r7)
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
            com.google.android.gms.internal.firebase_auth.zzks<?, ?> r2 = r0.zzq
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x0a99
            com.google.android.gms.internal.firebase_auth.zzhm<?> r2 = r0.zzr
            com.google.android.gms.internal.firebase_auth.zzhq r1 = r2.zza((java.lang.Object) r1)
            r2 = 0
        L_0x0a52:
            com.google.android.gms.internal.firebase_auth.zzkb<T, java.lang.Object> r3 = r1.zza
            int r3 = r3.zzc()
            if (r10 >= r3) goto L_0x0a72
            com.google.android.gms.internal.firebase_auth.zzkb<T, java.lang.Object> r3 = r1.zza
            java.util.Map$Entry r3 = r3.zzb((int) r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.firebase_auth.zzhs r4 = (com.google.android.gms.internal.firebase_auth.zzhs) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.firebase_auth.zzhq.zza((com.google.android.gms.internal.firebase_auth.zzhs<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x0a52
        L_0x0a72:
            com.google.android.gms.internal.firebase_auth.zzkb<T, java.lang.Object> r1 = r1.zza
            java.lang.Iterable r1 = r1.zzd()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a7c:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a98
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.firebase_auth.zzhs r4 = (com.google.android.gms.internal.firebase_auth.zzhs) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.firebase_auth.zzhq.zza((com.google.android.gms.internal.firebase_auth.zzhs<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0a7c
        L_0x0a98:
            int r5 = r5 + r2
        L_0x0a99:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjk.zzb(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzks<UT, UB> zzks, T t) {
        return zzks.zzf(zzks.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzky.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.firebase_auth.zzll r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.firebase_auth.zzhx.zze.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.firebase_auth.zzks<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.firebase_auth.zzll) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.firebase_auth.zzhm<?> r0 = r13.zzr
            com.google.android.gms.internal.firebase_auth.zzhq r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.firebase_auth.zzkb<T, java.lang.Object> r1 = r0.zza
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
            com.google.android.gms.internal.firebase_auth.zzhm<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.firebase_auth.zzhm<?> r10 = r13.zzr
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzjw r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzjw) r10)
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzgm r8 = (com.google.android.gms.internal.firebase_auth.zzgm) r8
            r15.zza((int) r9, (com.google.android.gms.internal.firebase_auth.zzgm) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzjw r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzjw) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15)
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
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.firebase_auth.zzll) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjw r10 = r13.zza((int) r7)
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15, (com.google.android.gms.internal.firebase_auth.zzjw) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r9, (java.util.List<com.google.android.gms.internal.firebase_auth.zzgm>) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjw r10 = r13.zza((int) r7)
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15, (com.google.android.gms.internal.firebase_auth.zzjw) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzjw r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzjw) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzgm r8 = (com.google.android.gms.internal.firebase_auth.zzgm) r8
            r15.zza((int) r9, (com.google.android.gms.internal.firebase_auth.zzgm) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzjw r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzjw) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzll) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.firebase_auth.zzky.zzc(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.firebase_auth.zzky.zzd(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.firebase_auth.zzky.zze(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.firebase_auth.zzhm<?> r14 = r13.zzr
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
            com.google.android.gms.internal.firebase_auth.zzhm<?> r0 = r13.zzr
            com.google.android.gms.internal.firebase_auth.zzhq r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.firebase_auth.zzkb<T, java.lang.Object> r1 = r0.zza
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
            com.google.android.gms.internal.firebase_auth.zzhm<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0579
            com.google.android.gms.internal.firebase_auth.zzhm<?> r11 = r13.zzr
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzjw r11 = r13.zza((int) r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzjw) r11)
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzgm r9 = (com.google.android.gms.internal.firebase_auth.zzgm) r9
            r15.zza((int) r10, (com.google.android.gms.internal.firebase_auth.zzgm) r9)
            goto L_0x0a25
        L_0x0610:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzjw r11 = r13.zza((int) r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzjw) r11)
            goto L_0x0a25
        L_0x0625:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15)
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
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.firebase_auth.zzll) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0a25
        L_0x06c9:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjw r11 = r13.zza((int) r1)
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15, (com.google.android.gms.internal.firebase_auth.zzjw) r11)
            goto L_0x0a25
        L_0x06de:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zze(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x06ef:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzj(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0700:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzg(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0711:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzl(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0722:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzm(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0733:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzi(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0744:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzn(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0755:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzk(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0766:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzf(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0777:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzh(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0788:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzd(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0799:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzc(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x07aa:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07bb:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07cc:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zze(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07dd:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzj(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ee:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzg(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ff:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzl(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0810:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzm(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0821:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzi(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0832:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r10, (java.util.List<com.google.android.gms.internal.firebase_auth.zzgm>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15)
            goto L_0x0a25
        L_0x0843:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjw r11 = r13.zza((int) r1)
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15, (com.google.android.gms.internal.firebase_auth.zzjw) r11)
            goto L_0x0a25
        L_0x0858:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15)
            goto L_0x0a25
        L_0x0869:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzn(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x087a:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzk(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x088b:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzf(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x089c:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzh(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08ad:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzd(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08be:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzc(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08cf:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08e0:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08f1:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzjw r11 = r13.zza((int) r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzjw) r11)
            goto L_0x0a25
        L_0x0906:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0917:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r11)
            r15.zzf(r10, r9)
            goto L_0x0a25
        L_0x0928:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0939:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0a25
        L_0x094a:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0a25
        L_0x095b:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0a25
        L_0x096c:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzgm r9 = (com.google.android.gms.internal.firebase_auth.zzgm) r9
            r15.zza((int) r10, (com.google.android.gms.internal.firebase_auth.zzgm) r9)
            goto L_0x0a25
        L_0x097f:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzjw r11 = r13.zza((int) r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzjw) r11)
            goto L_0x0a25
        L_0x0994:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzll) r15)
            goto L_0x0a25
        L_0x09a5:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.firebase_auth.zzky.zzc(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x09b6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a25
        L_0x09c6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09d6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r14, (long) r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a25
        L_0x09e6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09f6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zzky.zzb(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0a06:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.firebase_auth.zzky.zzd(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x0a16:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.firebase_auth.zzky.zze(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a25:
            int r1 = r1 + 3
            goto L_0x0551
        L_0x0a29:
            if (r8 == 0) goto L_0x0a40
            com.google.android.gms.internal.firebase_auth.zzhm<?> r1 = r13.zzr
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
            com.google.android.gms.internal.firebase_auth.zzks<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.firebase_auth.zzll) r15)
            return
        L_0x0a46:
            r13.zzb(r14, (com.google.android.gms.internal.firebase_auth.zzll) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjk.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzll):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x04b5  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.firebase_auth.zzll r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.firebase_auth.zzhm<?> r3 = r0.zzr
            com.google.android.gms.internal.firebase_auth.zzhq r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.firebase_auth.zzkb<T, java.lang.Object> r5 = r3.zza
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
            com.google.android.gms.internal.firebase_auth.zzhm<?> r4 = r0.zzr
            int r4 = r4.zza((java.util.Map.Entry<?, ?>) r10)
            if (r4 > r14) goto L_0x0088
            com.google.android.gms.internal.firebase_auth.zzhm<?> r4 = r0.zzr
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
            com.google.android.gms.internal.firebase_auth.zzjw r9 = r0.zza((int) r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzjw) r9)
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
            com.google.android.gms.internal.firebase_auth.zzgm r4 = (com.google.android.gms.internal.firebase_auth.zzgm) r4
            r2.zza((int) r14, (com.google.android.gms.internal.firebase_auth.zzgm) r4)
            goto L_0x008e
        L_0x0107:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase_auth.zzjw r9 = r0.zza((int) r5)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzjw) r9)
            goto L_0x008e
        L_0x011a:
            boolean r4 = r0.zza(r1, (int) r14, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzll) r2)
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
            r0.zza((com.google.android.gms.internal.firebase_auth.zzll) r2, (int) r14, (java.lang.Object) r4, (int) r5)
            goto L_0x008e
        L_0x01aa:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjw r12 = r0.zza((int) r5)
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r2, (com.google.android.gms.internal.firebase_auth.zzjw) r12)
            goto L_0x008e
        L_0x01bd:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 1
            com.google.android.gms.internal.firebase_auth.zzjy.zze(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01cd:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzj(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01dd:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzg(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01ed:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzl(r4, r9, r2, r14)
            goto L_0x008e
        L_0x01fd:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzm(r4, r9, r2, r14)
            goto L_0x008e
        L_0x020d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzi(r4, r9, r2, r14)
            goto L_0x008e
        L_0x021d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzn(r4, r9, r2, r14)
            goto L_0x008e
        L_0x022d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzk(r4, r9, r2, r14)
            goto L_0x008e
        L_0x023d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzf(r4, r9, r2, r14)
            goto L_0x008e
        L_0x024d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzh(r4, r9, r2, r14)
            goto L_0x008e
        L_0x025d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzd(r4, r9, r2, r14)
            goto L_0x008e
        L_0x026d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzc(r4, r9, r2, r14)
            goto L_0x008e
        L_0x027d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r2, (boolean) r14)
            goto L_0x008e
        L_0x028d:
            r14 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r2, (boolean) r14)
            goto L_0x008e
        L_0x029d:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r14 = 0
            com.google.android.gms.internal.firebase_auth.zzjy.zze(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ad:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzj(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02bd:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzg(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02cd:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzl(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02dd:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzm(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02ed:
            r14 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzi(r4, r9, r2, r14)
            goto L_0x008e
        L_0x02fd:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r4, (java.util.List<com.google.android.gms.internal.firebase_auth.zzgm>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r2)
            goto L_0x008e
        L_0x030c:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjw r12 = r0.zza((int) r5)
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r2, (com.google.android.gms.internal.firebase_auth.zzjw) r12)
            goto L_0x008e
        L_0x031f:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r2)
            goto L_0x008e
        L_0x032e:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.firebase_auth.zzjy.zzn(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x033e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzk(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x034e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzf(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x035e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzh(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x036e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzd(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x037e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzc(r4, r9, r2, r15)
            goto L_0x04ab
        L_0x038e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r2, (boolean) r15)
            goto L_0x04ab
        L_0x039e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r8.getObject(r1, r12)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzll) r2, (boolean) r15)
            goto L_0x04ab
        L_0x03ae:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase_auth.zzjw r9 = r0.zza((int) r5)
            r2.zzb((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzjw) r9)
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
            com.google.android.gms.internal.firebase_auth.zzgm r4 = (com.google.android.gms.internal.firebase_auth.zzgm) r4
            r2.zza((int) r14, (com.google.android.gms.internal.firebase_auth.zzgm) r4)
            goto L_0x04ab
        L_0x0424:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            com.google.android.gms.internal.firebase_auth.zzjw r9 = r0.zza((int) r5)
            r2.zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzjw) r9)
            goto L_0x04ab
        L_0x0436:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            java.lang.Object r4 = r8.getObject(r1, r12)
            zza((int) r14, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzll) r2)
            goto L_0x04ab
        L_0x0444:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzky.zzc(r1, r12)
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
            float r4 = com.google.android.gms.internal.firebase_auth.zzky.zzd(r1, r12)
            r2.zza((int) r14, (float) r4)
            goto L_0x04ab
        L_0x049f:
            r15 = 0
            r4 = r11 & r9
            if (r4 == 0) goto L_0x04ab
            double r12 = com.google.android.gms.internal.firebase_auth.zzky.zze(r1, r12)
            r2.zza((int) r14, (double) r12)
        L_0x04ab:
            int r5 = r5 + 3
            goto L_0x002e
        L_0x04af:
            r17 = r10
            r4 = r17
        L_0x04b3:
            if (r4 == 0) goto L_0x04c9
            com.google.android.gms.internal.firebase_auth.zzhm<?> r5 = r0.zzr
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
            com.google.android.gms.internal.firebase_auth.zzks<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.firebase_auth.zzll) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjk.zzb(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzll):void");
    }

    private final <K, V> void zza(zzll zzll, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzll.zza(i, this.zzs.zzb(zzb(i2)), this.zzs.zzc(obj));
        }
    }

    private static <UT, UB> void zza(zzks<UT, UB> zzks, T t, zzll zzll) throws IOException {
        zzks.zza(zzks.zzb(t), zzll);
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void zza(T r18, com.google.android.gms.internal.firebase_auth.zzjx r19, com.google.android.gms.internal.firebase_auth.zzhk r20) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r0 = r19
            r10 = r20
            if (r10 == 0) goto L_0x05ed
            com.google.android.gms.internal.firebase_auth.zzks<?, ?> r11 = r1.zzq
            com.google.android.gms.internal.firebase_auth.zzhm<?> r12 = r1.zzr
            r13 = 0
            r3 = r13
            r14 = r3
        L_0x0011:
            int r4 = r19.zza()     // Catch:{ all -> 0x05d5 }
            int r5 = r1.zze     // Catch:{ all -> 0x05d5 }
            r6 = -1
            if (r4 < r5) goto L_0x003e
            int r5 = r1.zzf     // Catch:{ all -> 0x05d5 }
            if (r4 > r5) goto L_0x003e
            r5 = 0
            int[] r7 = r1.zzc     // Catch:{ all -> 0x05d5 }
            int r7 = r7.length     // Catch:{ all -> 0x05d5 }
            int r7 = r7 / 3
            int r7 = r7 + -1
        L_0x0026:
            if (r5 > r7) goto L_0x003e
            int r8 = r7 + r5
            int r8 = r8 >>> 1
            int r9 = r8 * 3
            int[] r15 = r1.zzc     // Catch:{ all -> 0x05d5 }
            r15 = r15[r9]     // Catch:{ all -> 0x05d5 }
            if (r4 != r15) goto L_0x0036
            r6 = r9
            goto L_0x003e
        L_0x0036:
            if (r4 >= r15) goto L_0x003b
            int r7 = r8 + -1
            goto L_0x0026
        L_0x003b:
            int r5 = r8 + 1
            goto L_0x0026
        L_0x003e:
            if (r6 >= 0) goto L_0x00a6
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L_0x005c
            int r0 = r1.zzm
        L_0x0047:
            int r3 = r1.zzn
            if (r0 >= r3) goto L_0x0056
            int[] r3 = r1.zzl
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r3, r14, r11)
            int r0 = r0 + 1
            goto L_0x0047
        L_0x0056:
            if (r14 == 0) goto L_0x005b
            r11.zzb((java.lang.Object) r2, r14)
        L_0x005b:
            return
        L_0x005c:
            boolean r5 = r1.zzh     // Catch:{ all -> 0x05d5 }
            if (r5 != 0) goto L_0x0062
            r5 = r13
            goto L_0x0069
        L_0x0062:
            com.google.android.gms.internal.firebase_auth.zzjg r5 = r1.zzg     // Catch:{ all -> 0x05d5 }
            java.lang.Object r4 = r12.zza(r10, r5, r4)     // Catch:{ all -> 0x05d5 }
            r5 = r4
        L_0x0069:
            if (r5 == 0) goto L_0x0080
            if (r3 != 0) goto L_0x0071
            com.google.android.gms.internal.firebase_auth.zzhq r3 = r12.zzb(r2)     // Catch:{ all -> 0x05d5 }
        L_0x0071:
            r15 = r3
            r3 = r12
            r4 = r19
            r6 = r20
            r7 = r15
            r8 = r14
            r9 = r11
            java.lang.Object r14 = r3.zza(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x05d5 }
            r3 = r15
            goto L_0x0011
        L_0x0080:
            r11.zza((com.google.android.gms.internal.firebase_auth.zzjx) r0)     // Catch:{ all -> 0x05d5 }
            if (r14 != 0) goto L_0x0089
            java.lang.Object r14 = r11.zzc(r2)     // Catch:{ all -> 0x05d5 }
        L_0x0089:
            boolean r4 = r11.zza(r14, (com.google.android.gms.internal.firebase_auth.zzjx) r0)     // Catch:{ all -> 0x05d5 }
            if (r4 != 0) goto L_0x0011
            int r0 = r1.zzm
        L_0x0091:
            int r3 = r1.zzn
            if (r0 >= r3) goto L_0x00a0
            int[] r3 = r1.zzl
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r3, r14, r11)
            int r0 = r0 + 1
            goto L_0x0091
        L_0x00a0:
            if (r14 == 0) goto L_0x00a5
            r11.zzb((java.lang.Object) r2, r14)
        L_0x00a5:
            return
        L_0x00a6:
            int r5 = r1.zzd((int) r6)     // Catch:{ all -> 0x05d5 }
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r7 = r7 & r5
            int r7 = r7 >>> 20
            r8 = 1048575(0xfffff, float:1.469367E-39)
            switch(r7) {
                case 0: goto L_0x0582;
                case 1: goto L_0x0573;
                case 2: goto L_0x0564;
                case 3: goto L_0x0555;
                case 4: goto L_0x0546;
                case 5: goto L_0x0537;
                case 6: goto L_0x0528;
                case 7: goto L_0x0519;
                case 8: goto L_0x0511;
                case 9: goto L_0x04e0;
                case 10: goto L_0x04d1;
                case 11: goto L_0x04c2;
                case 12: goto L_0x04a0;
                case 13: goto L_0x0491;
                case 14: goto L_0x0482;
                case 15: goto L_0x0473;
                case 16: goto L_0x0464;
                case 17: goto L_0x0433;
                case 18: goto L_0x0426;
                case 19: goto L_0x0419;
                case 20: goto L_0x040c;
                case 21: goto L_0x03ff;
                case 22: goto L_0x03f2;
                case 23: goto L_0x03e5;
                case 24: goto L_0x03d8;
                case 25: goto L_0x03cb;
                case 26: goto L_0x03ab;
                case 27: goto L_0x039a;
                case 28: goto L_0x038d;
                case 29: goto L_0x0380;
                case 30: goto L_0x036b;
                case 31: goto L_0x035e;
                case 32: goto L_0x0351;
                case 33: goto L_0x0344;
                case 34: goto L_0x0337;
                case 35: goto L_0x032a;
                case 36: goto L_0x031d;
                case 37: goto L_0x0310;
                case 38: goto L_0x0303;
                case 39: goto L_0x02f6;
                case 40: goto L_0x02e9;
                case 41: goto L_0x02dc;
                case 42: goto L_0x02cf;
                case 43: goto L_0x02c2;
                case 44: goto L_0x02ad;
                case 45: goto L_0x02a0;
                case 46: goto L_0x0293;
                case 47: goto L_0x0286;
                case 48: goto L_0x0279;
                case 49: goto L_0x0267;
                case 50: goto L_0x0225;
                case 51: goto L_0x0213;
                case 52: goto L_0x0201;
                case 53: goto L_0x01ef;
                case 54: goto L_0x01dd;
                case 55: goto L_0x01cb;
                case 56: goto L_0x01b9;
                case 57: goto L_0x01a7;
                case 58: goto L_0x0195;
                case 59: goto L_0x018d;
                case 60: goto L_0x015c;
                case 61: goto L_0x014e;
                case 62: goto L_0x013c;
                case 63: goto L_0x0117;
                case 64: goto L_0x0105;
                case 65: goto L_0x00f3;
                case 66: goto L_0x00e1;
                case 67: goto L_0x00cf;
                case 68: goto L_0x00bd;
                default: goto L_0x00b5;
            }
        L_0x00b5:
            if (r14 != 0) goto L_0x0591
            java.lang.Object r14 = r11.zza()     // Catch:{ zzij -> 0x05ae }
            goto L_0x0591
        L_0x00bd:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjw r5 = r1.zza((int) r6)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r5 = r0.zzb(r5, r10)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x00cf:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            long r15 = r19.zzt()     // Catch:{ zzij -> 0x05ae }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x00e1:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            int r5 = r19.zzs()     // Catch:{ zzij -> 0x05ae }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x00f3:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            long r15 = r19.zzr()     // Catch:{ zzij -> 0x05ae }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0105:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            int r5 = r19.zzq()     // Catch:{ zzij -> 0x05ae }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0117:
            int r7 = r19.zzp()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzic r9 = r1.zzc((int) r6)     // Catch:{ zzij -> 0x05ae }
            if (r9 == 0) goto L_0x012e
            boolean r9 = r9.zza(r7)     // Catch:{ zzij -> 0x05ae }
            if (r9 == 0) goto L_0x0128
            goto L_0x012e
        L_0x0128:
            java.lang.Object r14 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r4, (int) r7, r14, r11)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x012e:
            r5 = r5 & r8
            long r8 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r7)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r8, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x013c:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            int r5 = r19.zzo()     // Catch:{ zzij -> 0x05ae }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x014e:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzgm r5 = r19.zzn()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x015c:
            boolean r7 = r1.zza(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            if (r7 == 0) goto L_0x0178
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r2, r7)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjw r9 = r1.zza((int) r6)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r9 = r0.zza(r9, r10)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zzib.zza((java.lang.Object) r5, (java.lang.Object) r9)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0188
        L_0x0178:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjw r5 = r1.zza((int) r6)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r5 = r0.zza(r5, r10)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
        L_0x0188:
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x018d:
            r1.zza((java.lang.Object) r2, (int) r5, (com.google.android.gms.internal.firebase_auth.zzjx) r0)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0195:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            boolean r5 = r19.zzk()     // Catch:{ zzij -> 0x05ae }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x01a7:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            int r5 = r19.zzj()     // Catch:{ zzij -> 0x05ae }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x01b9:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            long r15 = r19.zzi()     // Catch:{ zzij -> 0x05ae }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x01cb:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            int r5 = r19.zzh()     // Catch:{ zzij -> 0x05ae }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x01dd:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            long r15 = r19.zzf()     // Catch:{ zzij -> 0x05ae }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x01ef:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            long r15 = r19.zzg()     // Catch:{ zzij -> 0x05ae }
            java.lang.Long r5 = java.lang.Long.valueOf(r15)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0201:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            float r5 = r19.zze()     // Catch:{ zzij -> 0x05ae }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0213:
            r5 = r5 & r8
            long r7 = (long) r5     // Catch:{ zzij -> 0x05ae }
            double r15 = r19.zzd()     // Catch:{ zzij -> 0x05ae }
            java.lang.Double r5 = java.lang.Double.valueOf(r15)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r4, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0225:
            java.lang.Object r4 = r1.zzb((int) r6)     // Catch:{ zzij -> 0x05ae }
            int r5 = r1.zzd((int) r6)     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r2, r5)     // Catch:{ zzij -> 0x05ae }
            if (r7 != 0) goto L_0x023f
            com.google.android.gms.internal.firebase_auth.zzjd r7 = r1.zzs     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r7 = r7.zzf(r4)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0256
        L_0x023f:
            com.google.android.gms.internal.firebase_auth.zzjd r8 = r1.zzs     // Catch:{ zzij -> 0x05ae }
            boolean r8 = r8.zzd(r7)     // Catch:{ zzij -> 0x05ae }
            if (r8 == 0) goto L_0x0256
            com.google.android.gms.internal.firebase_auth.zzjd r8 = r1.zzs     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r8 = r8.zzf(r4)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjd r9 = r1.zzs     // Catch:{ zzij -> 0x05ae }
            r9.zza(r8, r7)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r8)     // Catch:{ zzij -> 0x05ae }
            r7 = r8
        L_0x0256:
            com.google.android.gms.internal.firebase_auth.zzjd r5 = r1.zzs     // Catch:{ zzij -> 0x05ae }
            java.util.Map r5 = r5.zza(r7)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjd r6 = r1.zzs     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjb r4 = r6.zzb(r4)     // Catch:{ zzij -> 0x05ae }
            r0.zza(r5, r4, (com.google.android.gms.internal.firebase_auth.zzhk) r10)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0267:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjw r6 = r1.zza((int) r6)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zziq r7 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r7.zza(r2, r4)     // Catch:{ zzij -> 0x05ae }
            r0.zzb(r4, r6, r10)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0279:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzq(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0286:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzp(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0293:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzo(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x02a0:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzn(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x02ad:
            com.google.android.gms.internal.firebase_auth.zziq r7 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r8 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r5 = r7.zza(r2, r8)     // Catch:{ zzij -> 0x05ae }
            r0.zzm(r5)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzic r6 = r1.zzc((int) r6)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r14 = com.google.android.gms.internal.firebase_auth.zzjy.zza(r4, r5, r6, r14, r11)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x02c2:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzl(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x02cf:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzh(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x02dc:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzg(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x02e9:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzf(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x02f6:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zze(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0303:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzc(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0310:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzd(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x031d:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzb(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x032a:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zza(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0337:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzq(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0344:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzp(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0351:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzo(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x035e:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzn(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x036b:
            com.google.android.gms.internal.firebase_auth.zziq r7 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r8 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r5 = r7.zza(r2, r8)     // Catch:{ zzij -> 0x05ae }
            r0.zzm(r5)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzic r6 = r1.zzc((int) r6)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r14 = com.google.android.gms.internal.firebase_auth.zzjy.zza(r4, r5, r6, r14, r11)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0380:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzl(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x038d:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzk(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x039a:
            com.google.android.gms.internal.firebase_auth.zzjw r4 = r1.zza((int) r6)     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zziq r7 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            java.util.List r5 = r7.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zza(r5, r4, (com.google.android.gms.internal.firebase_auth.zzhk) r10)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x03ab:
            boolean r4 = zzf(r5)     // Catch:{ zzij -> 0x05ae }
            if (r4 == 0) goto L_0x03be
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzj(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x03be:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzi(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x03cb:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzh(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x03d8:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzg(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x03e5:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzf(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x03f2:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zze(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x03ff:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzc(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x040c:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzd(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0419:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zzb(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0426:
            com.google.android.gms.internal.firebase_auth.zziq r4 = r1.zzp     // Catch:{ zzij -> 0x05ae }
            r5 = r5 & r8
            long r5 = (long) r5     // Catch:{ zzij -> 0x05ae }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzij -> 0x05ae }
            r0.zza(r4)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0433:
            boolean r4 = r1.zza(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            if (r4 == 0) goto L_0x0451
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r2, r4)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjw r6 = r1.zza((int) r6)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r6 = r0.zzb(r6, r10)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zzib.zza((java.lang.Object) r7, (java.lang.Object) r6)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0451:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjw r7 = r1.zza((int) r6)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r7 = r0.zzb(r7, r10)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0464:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            long r7 = r19.zzt()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0473:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            int r7 = r19.zzs()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0482:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            long r7 = r19.zzr()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0491:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            int r7 = r19.zzq()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x04a0:
            int r7 = r19.zzp()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzic r9 = r1.zzc((int) r6)     // Catch:{ zzij -> 0x05ae }
            if (r9 == 0) goto L_0x04b7
            boolean r9 = r9.zza(r7)     // Catch:{ zzij -> 0x05ae }
            if (r9 == 0) goto L_0x04b1
            goto L_0x04b7
        L_0x04b1:
            java.lang.Object r14 = com.google.android.gms.internal.firebase_auth.zzjy.zza((int) r4, (int) r7, r14, r11)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x04b7:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x04c2:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            int r7 = r19.zzo()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x04d1:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzgm r7 = r19.zzn()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x04e0:
            boolean r4 = r1.zza(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            if (r4 == 0) goto L_0x04fe
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zzky.zzf(r2, r4)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjw r6 = r1.zza((int) r6)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r6 = r0.zza(r6, r10)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zzib.zza((java.lang.Object) r7, (java.lang.Object) r6)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x04fe:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzjw r7 = r1.zza((int) r6)     // Catch:{ zzij -> 0x05ae }
            java.lang.Object r7 = r0.zza(r7, r10)     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0511:
            r1.zza((java.lang.Object) r2, (int) r5, (com.google.android.gms.internal.firebase_auth.zzjx) r0)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0519:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            boolean r7 = r19.zzk()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (boolean) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0528:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            int r7 = r19.zzj()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0537:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            long r7 = r19.zzi()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0546:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            int r7 = r19.zzh()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (int) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0555:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            long r7 = r19.zzf()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0564:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            long r7 = r19.zzg()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (long) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0573:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            float r7 = r19.zze()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (float) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0582:
            r4 = r5 & r8
            long r4 = (long) r4     // Catch:{ zzij -> 0x05ae }
            double r7 = r19.zzd()     // Catch:{ zzij -> 0x05ae }
            com.google.android.gms.internal.firebase_auth.zzky.zza((java.lang.Object) r2, (long) r4, (double) r7)     // Catch:{ zzij -> 0x05ae }
            r1.zzb(r2, (int) r6)     // Catch:{ zzij -> 0x05ae }
            goto L_0x0011
        L_0x0591:
            boolean r4 = r11.zza(r14, (com.google.android.gms.internal.firebase_auth.zzjx) r0)     // Catch:{ zzij -> 0x05ae }
            if (r4 != 0) goto L_0x0011
            int r0 = r1.zzm
        L_0x0599:
            int r3 = r1.zzn
            if (r0 >= r3) goto L_0x05a8
            int[] r3 = r1.zzl
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r3, r14, r11)
            int r0 = r0 + 1
            goto L_0x0599
        L_0x05a8:
            if (r14 == 0) goto L_0x05ad
            r11.zzb((java.lang.Object) r2, r14)
        L_0x05ad:
            return
        L_0x05ae:
            r11.zza((com.google.android.gms.internal.firebase_auth.zzjx) r0)     // Catch:{ all -> 0x05d5 }
            if (r14 != 0) goto L_0x05b8
            java.lang.Object r4 = r11.zzc(r2)     // Catch:{ all -> 0x05d5 }
            r14 = r4
        L_0x05b8:
            boolean r4 = r11.zza(r14, (com.google.android.gms.internal.firebase_auth.zzjx) r0)     // Catch:{ all -> 0x05d5 }
            if (r4 != 0) goto L_0x0011
            int r0 = r1.zzm
        L_0x05c0:
            int r3 = r1.zzn
            if (r0 >= r3) goto L_0x05cf
            int[] r3 = r1.zzl
            r3 = r3[r0]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r3, r14, r11)
            int r0 = r0 + 1
            goto L_0x05c0
        L_0x05cf:
            if (r14 == 0) goto L_0x05d4
            r11.zzb((java.lang.Object) r2, r14)
        L_0x05d4:
            return
        L_0x05d5:
            r0 = move-exception
            int r3 = r1.zzm
        L_0x05d8:
            int r4 = r1.zzn
            if (r3 >= r4) goto L_0x05e7
            int[] r4 = r1.zzl
            r4 = r4[r3]
            java.lang.Object r14 = r1.zza((java.lang.Object) r2, (int) r4, r14, r11)
            int r3 = r3 + 1
            goto L_0x05d8
        L_0x05e7:
            if (r14 == 0) goto L_0x05ec
            r11.zzb((java.lang.Object) r2, r14)
        L_0x05ec:
            throw r0
        L_0x05ed:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            r0.<init>()
            goto L_0x05f4
        L_0x05f3:
            throw r0
        L_0x05f4:
            goto L_0x05f3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjk.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzjx, com.google.android.gms.internal.firebase_auth.zzhk):void");
    }

    private final zzjw zza(int i) {
        int i2 = (i / 3) << 1;
        zzjw zzjw = (zzjw) this.zzd[i2];
        if (zzjw != null) {
            return zzjw;
        }
        zzjw zza2 = zzjs.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzic zzc(int i) {
        return (zzic) this.zzd[((i / 3) << 1) + 1];
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
            Object zzf2 = zzky.zzf(t, zzd2);
            if (zzf2 != null) {
                zzky.zza((Object) t, zzd2, this.zzs.zze(zzf2));
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

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzks<UT, UB> zzks) {
        zzic zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzky.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzks);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzic zzic, UB ub, zzks<UT, UB> zzks) {
        zzjb<?, ?> zzb2 = this.zzs.zzb(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzic.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzks.zza();
                }
                zzgu zzc2 = zzgm.zzc(zziy.zza(zzb2, next.getKey(), next.getValue()));
                try {
                    zziy.zza(zzc2.zzb(), zzb2, next.getKey(), next.getValue());
                    zzks.zza(ub, i2, zzc2.zza());
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
                            Map<?, ?> zzc2 = this.zzs.zzc(zzky.zzf(t, (long) (zzd2 & 1048575)));
                            if (!zzc2.isEmpty()) {
                                if (this.zzs.zzb(zzb(i5)).zzc.zza() == zzlm.MESSAGE) {
                                    zzjw<?> zzjw = null;
                                    Iterator<?> it = zzc2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzjw == null) {
                                            zzjw = zzjs.zza().zza(next.getClass());
                                        }
                                        if (!zzjw.zzd(next)) {
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
                List list = (List) zzky.zzf(t, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzjw zza2 = zza(i5);
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

    private static boolean zza(Object obj, int i, zzjw zzjw) {
        return zzjw.zzd(zzky.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzll zzll) throws IOException {
        if (obj instanceof String) {
            zzll.zza(i, (String) obj);
        } else {
            zzll.zza(i, (zzgm) obj);
        }
    }

    private final void zza(Object obj, int i, zzjx zzjx) throws IOException {
        if (zzf(i)) {
            zzky.zza(obj, (long) (i & 1048575), (Object) zzjx.zzm());
        } else if (this.zzi) {
            zzky.zza(obj, (long) (i & 1048575), (Object) zzjx.zzl());
        } else {
            zzky.zza(obj, (long) (i & 1048575), (Object) zzjx.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzky.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzky.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzky.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzky.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzky.zzf(t, j)).booleanValue();
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
                    return zzky.zze(t, j) != 0.0d;
                case 1:
                    return zzky.zzd(t, j) != 0.0f;
                case 2:
                    return zzky.zzb(t, j) != 0;
                case 3:
                    return zzky.zzb(t, j) != 0;
                case 4:
                    return zzky.zza((Object) t, j) != 0;
                case 5:
                    return zzky.zzb(t, j) != 0;
                case 6:
                    return zzky.zza((Object) t, j) != 0;
                case 7:
                    return zzky.zzc(t, j);
                case 8:
                    Object zzf2 = zzky.zzf(t, j);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgm) {
                        return !zzgm.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzky.zzf(t, j) != null;
                case 10:
                    return !zzgm.zza.equals(zzky.zzf(t, j));
                case 11:
                    return zzky.zza((Object) t, j) != 0;
                case 12:
                    return zzky.zza((Object) t, j) != 0;
                case 13:
                    return zzky.zza((Object) t, j) != 0;
                case 14:
                    return zzky.zzb(t, j) != 0;
                case 15:
                    return zzky.zza((Object) t, j) != 0;
                case 16:
                    return zzky.zzb(t, j) != 0;
                case 17:
                    return zzky.zzf(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zze2 = zze(i);
            return (zzky.zza((Object) t, (long) (zze2 & 1048575)) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzj) {
            int zze2 = zze(i);
            long j = (long) (zze2 & 1048575);
            zzky.zza((Object) t, j, zzky.zza((Object) t, j) | (1 << (zze2 >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzky.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzky.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }
}
