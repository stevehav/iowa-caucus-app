package com.google.android.gms.internal.firebase_auth;

import com.google.common.primitives.UnsignedBytes;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzbi<K, V> extends zzbe<K, V> {
    private static final zzbe<Object, Object> zza = new zzbi((Object) null, new Object[0], 0);
    private final transient Object zzb;
    private final transient Object[] zzc;
    private final transient int zzd;

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [short[], byte[]], vars: [r2v4 ?, r2v1 ?, r2v5 ?, r2v6 ?, r2v8 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    static <K, V> com.google.android.gms.internal.firebase_auth.zzbi<K, V> zza(int r10, java.lang.Object[] r11) {
        /*
            if (r10 != 0) goto L_0x0007
            com.google.android.gms.internal.firebase_auth.zzbe<java.lang.Object, java.lang.Object> r10 = zza
            com.google.android.gms.internal.firebase_auth.zzbi r10 = (com.google.android.gms.internal.firebase_auth.zzbi) r10
            return r10
        L_0x0007:
            r0 = 0
            r1 = 0
            r2 = 1
            if (r10 != r2) goto L_0x0019
            r10 = r11[r1]
            r1 = r11[r2]
            com.google.android.gms.internal.firebase_auth.zzay.zza(r10, r1)
            com.google.android.gms.internal.firebase_auth.zzbi r10 = new com.google.android.gms.internal.firebase_auth.zzbi
            r10.<init>(r0, r11, r2)
            return r10
        L_0x0019:
            int r3 = r11.length
            int r3 = r3 >> r2
            com.google.android.gms.internal.firebase_auth.zzao.zzb(r10, r3)
            r3 = 2
            int r3 = java.lang.Math.max(r10, r3)
            r4 = 751619276(0x2ccccccc, float:5.8207657E-12)
            r5 = 1073741824(0x40000000, float:2.0)
            if (r3 >= r4) goto L_0x0045
            int r4 = r3 + -1
            int r4 = java.lang.Integer.highestOneBit(r4)
            int r4 = r4 << r2
            r5 = r4
        L_0x0032:
            double r6 = (double) r5
            r8 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            java.lang.Double.isNaN(r6)
            double r6 = r6 * r8
            double r8 = (double) r3
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 >= 0) goto L_0x004f
            int r5 = r5 << 1
            goto L_0x0032
        L_0x0045:
            if (r3 >= r5) goto L_0x0049
            r3 = 1
            goto L_0x004a
        L_0x0049:
            r3 = 0
        L_0x004a:
            java.lang.String r4 = "collection too large"
            com.google.android.gms.internal.firebase_auth.zzao.zza((boolean) r3, (java.lang.Object) r4)
        L_0x004f:
            if (r10 != r2) goto L_0x005b
            r1 = r11[r1]
            r2 = r11[r2]
            com.google.android.gms.internal.firebase_auth.zzay.zza(r1, r2)
            r2 = r0
            goto L_0x010c
        L_0x005b:
            int r0 = r5 + -1
            r2 = 128(0x80, float:1.794E-43)
            r3 = -1
            if (r5 > r2) goto L_0x009a
            byte[] r2 = new byte[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x0067:
            if (r1 >= r10) goto L_0x010c
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.firebase_auth.zzay.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.firebase_auth.zzax.zza(r6)
        L_0x007c:
            r6 = r6 & r0
            byte r7 = r2[r6]
            r8 = 255(0xff, float:3.57E-43)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x008a
            byte r3 = (byte) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x0067
        L_0x008a:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x0095
            int r6 = r6 + 1
            goto L_0x007c
        L_0x0095:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x009a:
            r2 = 32768(0x8000, float:4.5918E-41)
            if (r5 > r2) goto L_0x00d8
            short[] r2 = new short[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x00a4:
            if (r1 >= r10) goto L_0x010c
            int r3 = r1 * 2
            r4 = r11[r3]
            r5 = r3 ^ 1
            r5 = r11[r5]
            com.google.android.gms.internal.firebase_auth.zzay.zza(r4, r5)
            int r6 = r4.hashCode()
            int r6 = com.google.android.gms.internal.firebase_auth.zzax.zza(r6)
        L_0x00b9:
            r6 = r6 & r0
            short r7 = r2[r6]
            r8 = 65535(0xffff, float:9.1834E-41)
            r7 = r7 & r8
            if (r7 != r8) goto L_0x00c8
            short r3 = (short) r3
            r2[r6] = r3
            int r1 = r1 + 1
            goto L_0x00a4
        L_0x00c8:
            r8 = r11[r7]
            boolean r8 = r8.equals(r4)
            if (r8 != 0) goto L_0x00d3
            int r6 = r6 + 1
            goto L_0x00b9
        L_0x00d3:
            java.lang.IllegalArgumentException r10 = zza(r4, r5, r11, r7)
            throw r10
        L_0x00d8:
            int[] r2 = new int[r5]
            java.util.Arrays.fill(r2, r3)
        L_0x00dd:
            if (r1 >= r10) goto L_0x010c
            int r4 = r1 * 2
            r5 = r11[r4]
            r6 = r4 ^ 1
            r6 = r11[r6]
            com.google.android.gms.internal.firebase_auth.zzay.zza(r5, r6)
            int r7 = r5.hashCode()
            int r7 = com.google.android.gms.internal.firebase_auth.zzax.zza(r7)
        L_0x00f2:
            r7 = r7 & r0
            r8 = r2[r7]
            if (r8 != r3) goto L_0x00fc
            r2[r7] = r4
            int r1 = r1 + 1
            goto L_0x00dd
        L_0x00fc:
            r9 = r11[r8]
            boolean r9 = r9.equals(r5)
            if (r9 != 0) goto L_0x0107
            int r7 = r7 + 1
            goto L_0x00f2
        L_0x0107:
            java.lang.IllegalArgumentException r10 = zza(r5, r6, r11, r8)
            throw r10
        L_0x010c:
            com.google.android.gms.internal.firebase_auth.zzbi r0 = new com.google.android.gms.internal.firebase_auth.zzbi
            r0.<init>(r2, r11, r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzbi.zza(int, java.lang.Object[]):com.google.android.gms.internal.firebase_auth.zzbi");
    }

    private static IllegalArgumentException zza(Object obj, Object obj2, Object[] objArr, int i) {
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(obj2);
        String valueOf3 = String.valueOf(objArr[i]);
        String valueOf4 = String.valueOf(objArr[i ^ 1]);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length());
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }

    private zzbi(Object obj, Object[] objArr, int i) {
        this.zzb = obj;
        this.zzc = objArr;
        this.zzd = i;
    }

    public final int size() {
        return this.zzd;
    }

    @NullableDecl
    public final V get(@NullableDecl Object obj) {
        Object obj2 = this.zzb;
        V[] vArr = this.zzc;
        int i = this.zzd;
        if (obj == null) {
            return null;
        }
        if (i == 1) {
            if (vArr[0].equals(obj)) {
                return vArr[1];
            }
            return null;
        } else if (obj2 == null) {
            return null;
        } else {
            if (obj2 instanceof byte[]) {
                byte[] bArr = (byte[]) obj2;
                int length = bArr.length - 1;
                int zza2 = zzax.zza(obj.hashCode());
                while (true) {
                    int i2 = zza2 & length;
                    byte b = bArr[i2] & UnsignedBytes.MAX_VALUE;
                    if (b == 255) {
                        return null;
                    }
                    if (vArr[b].equals(obj)) {
                        return vArr[b ^ 1];
                    }
                    zza2 = i2 + 1;
                }
            } else if (obj2 instanceof short[]) {
                short[] sArr = (short[]) obj2;
                int length2 = sArr.length - 1;
                int zza3 = zzax.zza(obj.hashCode());
                while (true) {
                    int i3 = zza3 & length2;
                    short s = sArr[i3] & 65535;
                    if (s == 65535) {
                        return null;
                    }
                    if (vArr[s].equals(obj)) {
                        return vArr[s ^ 1];
                    }
                    zza3 = i3 + 1;
                }
            } else {
                int[] iArr = (int[]) obj2;
                int length3 = iArr.length - 1;
                int zza4 = zzax.zza(obj.hashCode());
                while (true) {
                    int i4 = zza4 & length3;
                    int i5 = iArr[i4];
                    if (i5 == -1) {
                        return null;
                    }
                    if (vArr[i5].equals(obj)) {
                        return vArr[i5 ^ 1];
                    }
                    zza4 = i4 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzbg<Map.Entry<K, V>> zza() {
        return new zzbh(this, this.zzc, 0, this.zzd);
    }

    /* access modifiers changed from: package-private */
    public final zzbg<K> zzb() {
        return new zzbj(this, new zzbm(this.zzc, 0, this.zzd));
    }

    /* access modifiers changed from: package-private */
    public final zzba<V> zzc() {
        return new zzbm(this.zzc, 1, this.zzd);
    }
}
