package com.google.android.gms.internal.clearcut;

import java.lang.reflect.Field;
import java.util.Arrays;

final class zzed {
    /* access modifiers changed from: private */
    public final int flags;
    private final Object[] zzmj;
    /* access modifiers changed from: private */
    public final int zzmk;
    /* access modifiers changed from: private */
    public final int zzml;
    /* access modifiers changed from: private */
    public final int zzmm;
    /* access modifiers changed from: private */
    public final int[] zzms;
    private final zzee zznh;
    private Class<?> zzni;
    /* access modifiers changed from: private */
    public final int zznj;
    private final int zznk;
    private final int zznl;
    /* access modifiers changed from: private */
    public final int zznm;
    /* access modifiers changed from: private */
    public final int zznn;
    /* access modifiers changed from: private */
    public final int zzno;
    private int zznp;
    private int zznq;
    private int zznr = Integer.MAX_VALUE;
    private int zzns = Integer.MIN_VALUE;
    private int zznt = 0;
    private int zznu = 0;
    private int zznv = 0;
    private int zznw = 0;
    private int zznx = 0;
    private int zzny;
    private int zznz;
    private int zzoa;
    private int zzob;
    private int zzoc;
    private Field zzod;
    private Object zzoe;
    private Object zzof;
    private Object zzog;

    zzed(Class<?> cls, String str, Object[] objArr) {
        this.zzni = cls;
        this.zznh = new zzee(str);
        this.zzmj = objArr;
        this.flags = this.zznh.next();
        this.zznj = this.zznh.next();
        int[] iArr = null;
        if (this.zznj == 0) {
            this.zznk = 0;
            this.zznl = 0;
            this.zzmk = 0;
            this.zzml = 0;
            this.zznm = 0;
            this.zznn = 0;
            this.zzmm = 0;
            this.zzno = 0;
            this.zzms = null;
            return;
        }
        this.zznk = this.zznh.next();
        this.zznl = this.zznh.next();
        this.zzmk = this.zznh.next();
        this.zzml = this.zznh.next();
        this.zznn = this.zznh.next();
        this.zzmm = this.zznh.next();
        this.zznm = this.zznh.next();
        this.zzno = this.zznh.next();
        int next = this.zznh.next();
        this.zzms = next != 0 ? new int[next] : iArr;
        this.zznp = (this.zznk << 1) + this.zznl;
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

    private final Object zzcw() {
        Object[] objArr = this.zzmj;
        int i = this.zznp;
        this.zznp = i + 1;
        return objArr[i];
    }

    private final boolean zzcz() {
        return (this.flags & 1) == 1;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d0, code lost:
        if (zzcz() != false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x015e, code lost:
        if (r1 != false) goto L_0x00d2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0165, code lost:
        if (zzcz() != false) goto L_0x00d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean next() {
        /*
            r5 = this;
            com.google.android.gms.internal.clearcut.zzee r0 = r5.zznh
            boolean r0 = r0.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000a
            return r1
        L_0x000a:
            com.google.android.gms.internal.clearcut.zzee r0 = r5.zznh
            int r0 = r0.next()
            r5.zzny = r0
            com.google.android.gms.internal.clearcut.zzee r0 = r5.zznh
            int r0 = r0.next()
            r5.zznz = r0
            int r0 = r5.zznz
            r0 = r0 & 255(0xff, float:3.57E-43)
            r5.zzoa = r0
            int r0 = r5.zzny
            int r2 = r5.zznr
            if (r0 >= r2) goto L_0x0028
            r5.zznr = r0
        L_0x0028:
            int r0 = r5.zzny
            int r2 = r5.zzns
            if (r0 <= r2) goto L_0x0030
            r5.zzns = r0
        L_0x0030:
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.MAP
            int r2 = r2.id()
            r3 = 1
            if (r0 != r2) goto L_0x0041
            int r0 = r5.zznt
            int r0 = r0 + r3
            r5.zznt = r0
            goto L_0x005a
        L_0x0041:
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.DOUBLE_LIST
            int r2 = r2.id()
            if (r0 < r2) goto L_0x005a
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.GROUP_LIST
            int r2 = r2.id()
            if (r0 > r2) goto L_0x005a
            int r0 = r5.zznu
            int r0 = r0 + r3
            r5.zznu = r0
        L_0x005a:
            int r0 = r5.zznx
            int r0 = r0 + r3
            r5.zznx = r0
            int r0 = r5.zznr
            int r2 = r5.zzny
            int r4 = r5.zznx
            boolean r0 = com.google.android.gms.internal.clearcut.zzeh.zzc((int) r0, (int) r2, (int) r4)
            if (r0 == 0) goto L_0x0076
            int r0 = r5.zzny
            int r0 = r0 + r3
            r5.zznw = r0
            int r0 = r5.zznw
            int r2 = r5.zznr
            int r0 = r0 - r2
            goto L_0x0079
        L_0x0076:
            int r0 = r5.zznv
            int r0 = r0 + r3
        L_0x0079:
            r5.zznv = r0
            int r0 = r5.zznz
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0083
            r0 = 1
            goto L_0x0084
        L_0x0083:
            r0 = 0
        L_0x0084:
            if (r0 == 0) goto L_0x0092
            int[] r0 = r5.zzms
            int r2 = r5.zznq
            int r4 = r2 + 1
            r5.zznq = r4
            int r4 = r5.zzny
            r0[r2] = r4
        L_0x0092:
            r0 = 0
            r5.zzoe = r0
            r5.zzof = r0
            r5.zzog = r0
            boolean r0 = r5.zzda()
            if (r0 == 0) goto L_0x00e2
            com.google.android.gms.internal.clearcut.zzee r0 = r5.zznh
            int r0 = r0.next()
            r5.zzob = r0
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r1 = com.google.android.gms.internal.clearcut.zzcb.MESSAGE
            int r1 = r1.id()
            int r1 = r1 + 51
            if (r0 == r1) goto L_0x00da
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r1 = com.google.android.gms.internal.clearcut.zzcb.GROUP
            int r1 = r1.id()
            int r1 = r1 + 51
            if (r0 != r1) goto L_0x00c0
            goto L_0x00da
        L_0x00c0:
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r1 = com.google.android.gms.internal.clearcut.zzcb.ENUM
            int r1 = r1.id()
            int r1 = r1 + 51
            if (r0 != r1) goto L_0x0171
            boolean r0 = r5.zzcz()
            if (r0 == 0) goto L_0x0171
        L_0x00d2:
            java.lang.Object r0 = r5.zzcw()
            r5.zzof = r0
            goto L_0x0171
        L_0x00da:
            java.lang.Object r0 = r5.zzcw()
        L_0x00de:
            r5.zzoe = r0
            goto L_0x0171
        L_0x00e2:
            java.lang.Class<?> r0 = r5.zzni
            java.lang.Object r2 = r5.zzcw()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.reflect.Field r0 = zza(r0, r2)
            r5.zzod = r0
            boolean r0 = r5.zzde()
            if (r0 == 0) goto L_0x00fe
            com.google.android.gms.internal.clearcut.zzee r0 = r5.zznh
            int r0 = r0.next()
            r5.zzoc = r0
        L_0x00fe:
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.MESSAGE
            int r2 = r2.id()
            if (r0 == r2) goto L_0x0169
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.GROUP
            int r2 = r2.id()
            if (r0 != r2) goto L_0x0113
            goto L_0x0169
        L_0x0113:
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.MESSAGE_LIST
            int r2 = r2.id()
            if (r0 == r2) goto L_0x00da
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.GROUP_LIST
            int r2 = r2.id()
            if (r0 != r2) goto L_0x0128
            goto L_0x00da
        L_0x0128:
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.ENUM
            int r2 = r2.id()
            if (r0 == r2) goto L_0x0161
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.ENUM_LIST
            int r2 = r2.id()
            if (r0 == r2) goto L_0x0161
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.ENUM_LIST_PACKED
            int r2 = r2.id()
            if (r0 != r2) goto L_0x0147
            goto L_0x0161
        L_0x0147:
            int r0 = r5.zzoa
            com.google.android.gms.internal.clearcut.zzcb r2 = com.google.android.gms.internal.clearcut.zzcb.MAP
            int r2 = r2.id()
            if (r0 != r2) goto L_0x0171
            java.lang.Object r0 = r5.zzcw()
            r5.zzog = r0
            int r0 = r5.zznz
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x015e
            r1 = 1
        L_0x015e:
            if (r1 == 0) goto L_0x0171
            goto L_0x0167
        L_0x0161:
            boolean r0 = r5.zzcz()
            if (r0 == 0) goto L_0x0171
        L_0x0167:
            goto L_0x00d2
        L_0x0169:
            java.lang.reflect.Field r0 = r5.zzod
            java.lang.Class r0 = r0.getType()
            goto L_0x00de
        L_0x0171:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzed.next():boolean");
    }

    /* access modifiers changed from: package-private */
    public final int zzcx() {
        return this.zzny;
    }

    /* access modifiers changed from: package-private */
    public final int zzcy() {
        return this.zzoa;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzda() {
        return this.zzoa > zzcb.MAP.id();
    }

    /* access modifiers changed from: package-private */
    public final Field zzdb() {
        int i = this.zzob << 1;
        Object obj = this.zzmj[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzni, (String) obj);
        this.zzmj[i] = zza;
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final Field zzdc() {
        int i = (this.zzob << 1) + 1;
        Object obj = this.zzmj[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzni, (String) obj);
        this.zzmj[i] = zza;
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final Field zzdd() {
        return this.zzod;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzde() {
        return zzcz() && this.zzoa <= zzcb.GROUP.id();
    }

    /* access modifiers changed from: package-private */
    public final Field zzdf() {
        int i = (this.zznk << 1) + (this.zzoc / 32);
        Object obj = this.zzmj[i];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field zza = zza(this.zzni, (String) obj);
        this.zzmj[i] = zza;
        return zza;
    }

    /* access modifiers changed from: package-private */
    public final int zzdg() {
        return this.zzoc % 32;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzdh() {
        return (this.zznz & 256) != 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzdi() {
        return (this.zznz & 512) != 0;
    }

    /* access modifiers changed from: package-private */
    public final Object zzdj() {
        return this.zzoe;
    }

    /* access modifiers changed from: package-private */
    public final Object zzdk() {
        return this.zzof;
    }

    /* access modifiers changed from: package-private */
    public final Object zzdl() {
        return this.zzog;
    }
}
