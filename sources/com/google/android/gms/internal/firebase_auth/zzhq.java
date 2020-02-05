package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzhq<T extends zzhs<T>> {
    private static final zzhq zzd = new zzhq(true);
    final zzkb<T, Object> zza;
    private boolean zzb;
    private boolean zzc;

    private zzhq() {
        this.zza = zzkb.zza(16);
    }

    private zzhq(boolean z) {
        this(zzkb.zza(0));
        zzb();
    }

    private zzhq(zzkb<T, Object> zzkb) {
        this.zza = zzkb;
        zzb();
    }

    public static <T extends zzhs<T>> zzhq<T> zza() {
        return zzd;
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
        }
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhq)) {
            return false;
        }
        return this.zza.equals(((zzhq) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        if (this.zzc) {
            return new zzim(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zze() {
        if (this.zzc) {
            return new zzim(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(T t) {
        Object obj = this.zza.get(t);
        return obj instanceof zzil ? zzil.zza() : obj;
    }

    private final void zzb(T t, Object obj) {
        if (!t.zzd()) {
            zza(t.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(t.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzil) {
            this.zzc = true;
        }
        this.zza.put(t, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_auth.zzia) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0014;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001c, code lost:
        if ((r3 instanceof com.google.android.gms.internal.firebase_auth.zzil) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.firebase_auth.zzlf r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.firebase_auth.zzib.zza(r3)
            int[] r0 = com.google.android.gms.internal.firebase_auth.zzhp.zza
            com.google.android.gms.internal.firebase_auth.zzlm r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x003d;
                case 3: goto L_0x003a;
                case 4: goto L_0x0037;
                case 5: goto L_0x0034;
                case 6: goto L_0x0031;
                case 7: goto L_0x0028;
                case 8: goto L_0x001f;
                case 9: goto L_0x0016;
                default: goto L_0x0014;
            }
        L_0x0014:
            r0 = 0
            goto L_0x0042
        L_0x0016:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzjg
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzil
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x001f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzia
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.firebase_auth.zzgm
            if (r2 != 0) goto L_0x0042
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0014
            goto L_0x0042
        L_0x0031:
            boolean r0 = r3 instanceof java.lang.String
            goto L_0x0042
        L_0x0034:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L_0x0042
        L_0x0037:
            boolean r0 = r3 instanceof java.lang.Double
            goto L_0x0042
        L_0x003a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L_0x0042
        L_0x003d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L_0x0042
        L_0x0040:
            boolean r0 = r3 instanceof java.lang.Integer
        L_0x0042:
            if (r0 == 0) goto L_0x0045
            return
        L_0x0045:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L_0x004e
        L_0x004d:
            throw r2
        L_0x004e:
            goto L_0x004d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhq.zza(com.google.android.gms.internal.firebase_auth.zzlf, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza(this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> zza2 : this.zza.zzd()) {
            if (!zza(zza2)) {
                return false;
            }
        }
        return true;
    }

    private static <T extends zzhs<T>> boolean zza(Map.Entry<T, Object> entry) {
        zzhs zzhs = (zzhs) entry.getKey();
        if (zzhs.zzc() == zzlm.MESSAGE) {
            if (zzhs.zzd()) {
                for (zzjg zzaa : (List) entry.getValue()) {
                    if (!zzaa.zzaa()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzjg) {
                    if (!((zzjg) value).zzaa()) {
                        return false;
                    }
                } else if (value instanceof zzil) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzhq<T> zzhq) {
        for (int i = 0; i < zzhq.zza.zzc(); i++) {
            zzb(zzhq.zza.zzb(i));
        }
        for (Map.Entry<T, Object> zzb2 : zzhq.zza.zzd()) {
            zzb(zzb2);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzjm) {
            return ((zzjm) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        Object obj;
        zzhs zzhs = (zzhs) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzil) {
            value = zzil.zza();
        }
        if (zzhs.zzd()) {
            Object zza2 = zza(zzhs);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object zza3 : (List) value) {
                ((List) zza2).add(zza(zza3));
            }
            this.zza.put(zzhs, zza2);
        } else if (zzhs.zzc() == zzlm.MESSAGE) {
            Object zza4 = zza(zzhs);
            if (zza4 == null) {
                this.zza.put(zzhs, zza(value));
                return;
            }
            if (zza4 instanceof zzjm) {
                obj = zzhs.zza((zzjm) zza4, (zzjm) value);
            } else {
                obj = zzhs.zza(((zzjg) zza4).zzae(), (zzjg) value).zzf();
            }
            this.zza.put(zzhs, obj);
        } else {
            this.zza.put(zzhs, zza(value));
        }
    }

    static void zza(zzhh zzhh, zzlf zzlf, int i, Object obj) throws IOException {
        if (zzlf == zzlf.GROUP) {
            zzjg zzjg = (zzjg) obj;
            zzib.zza(zzjg);
            zzhh.zza(i, 3);
            zzjg.zza(zzhh);
            zzhh.zza(i, 4);
            return;
        }
        zzhh.zza(i, zzlf.zzb());
        switch (zzlf) {
            case DOUBLE:
                zzhh.zza(((Double) obj).doubleValue());
                return;
            case FLOAT:
                zzhh.zza(((Float) obj).floatValue());
                return;
            case INT64:
                zzhh.zza(((Long) obj).longValue());
                return;
            case UINT64:
                zzhh.zza(((Long) obj).longValue());
                return;
            case INT32:
                zzhh.zza(((Integer) obj).intValue());
                return;
            case FIXED64:
                zzhh.zzc(((Long) obj).longValue());
                return;
            case FIXED32:
                zzhh.zzd(((Integer) obj).intValue());
                return;
            case BOOL:
                zzhh.zza(((Boolean) obj).booleanValue());
                return;
            case GROUP:
                ((zzjg) obj).zza(zzhh);
                return;
            case MESSAGE:
                zzhh.zza((zzjg) obj);
                return;
            case STRING:
                if (obj instanceof zzgm) {
                    zzhh.zza((zzgm) obj);
                    return;
                } else {
                    zzhh.zza((String) obj);
                    return;
                }
            case BYTES:
                if (obj instanceof zzgm) {
                    zzhh.zza((zzgm) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzhh.zzb(bArr, 0, bArr.length);
                return;
            case UINT32:
                zzhh.zzb(((Integer) obj).intValue());
                return;
            case SFIXED32:
                zzhh.zzd(((Integer) obj).intValue());
                return;
            case SFIXED64:
                zzhh.zzc(((Long) obj).longValue());
                return;
            case SINT32:
                zzhh.zzc(((Integer) obj).intValue());
                return;
            case SINT64:
                zzhh.zzb(((Long) obj).longValue());
                return;
            case ENUM:
                if (obj instanceof zzia) {
                    zzhh.zza(((zzia) obj).zza());
                    return;
                } else {
                    zzhh.zza(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public final int zzg() {
        int i = 0;
        for (int i2 = 0; i2 < this.zza.zzc(); i2++) {
            i += zzc(this.zza.zzb(i2));
        }
        for (Map.Entry<T, Object> zzc2 : this.zza.zzd()) {
            i += zzc(zzc2);
        }
        return i;
    }

    private static int zzc(Map.Entry<T, Object> entry) {
        zzhs zzhs = (zzhs) entry.getKey();
        Object value = entry.getValue();
        if (zzhs.zzc() != zzlm.MESSAGE || zzhs.zzd() || zzhs.zze()) {
            return zza((zzhs<?>) zzhs, value);
        }
        if (value instanceof zzil) {
            return zzhh.zzb(((zzhs) entry.getKey()).zza(), (zzip) (zzil) value);
        }
        return zzhh.zzb(((zzhs) entry.getKey()).zza(), (zzjg) value);
    }

    static int zza(zzlf zzlf, int i, Object obj) {
        int zze = zzhh.zze(i);
        if (zzlf == zzlf.GROUP) {
            zzib.zza((zzjg) obj);
            zze <<= 1;
        }
        return zze + zzb(zzlf, obj);
    }

    private static int zzb(zzlf zzlf, Object obj) {
        switch (zzlf) {
            case DOUBLE:
                return zzhh.zzb(((Double) obj).doubleValue());
            case FLOAT:
                return zzhh.zzb(((Float) obj).floatValue());
            case INT64:
                return zzhh.zzd(((Long) obj).longValue());
            case UINT64:
                return zzhh.zze(((Long) obj).longValue());
            case INT32:
                return zzhh.zzf(((Integer) obj).intValue());
            case FIXED64:
                return zzhh.zzg(((Long) obj).longValue());
            case FIXED32:
                return zzhh.zzi(((Integer) obj).intValue());
            case BOOL:
                return zzhh.zzb(((Boolean) obj).booleanValue());
            case GROUP:
                return zzhh.zzc((zzjg) obj);
            case MESSAGE:
                if (obj instanceof zzil) {
                    return zzhh.zza((zzip) (zzil) obj);
                }
                return zzhh.zzb((zzjg) obj);
            case STRING:
                if (obj instanceof zzgm) {
                    return zzhh.zzb((zzgm) obj);
                }
                return zzhh.zzb((String) obj);
            case BYTES:
                if (obj instanceof zzgm) {
                    return zzhh.zzb((zzgm) obj);
                }
                return zzhh.zzb((byte[]) obj);
            case UINT32:
                return zzhh.zzg(((Integer) obj).intValue());
            case SFIXED32:
                return zzhh.zzj(((Integer) obj).intValue());
            case SFIXED64:
                return zzhh.zzh(((Long) obj).longValue());
            case SINT32:
                return zzhh.zzh(((Integer) obj).intValue());
            case SINT64:
                return zzhh.zzf(((Long) obj).longValue());
            case ENUM:
                if (obj instanceof zzia) {
                    return zzhh.zzk(((zzia) obj).zza());
                }
                return zzhh.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzhs<?> zzhs, Object obj) {
        zzlf zzb2 = zzhs.zzb();
        int zza2 = zzhs.zza();
        if (!zzhs.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzhs.zze()) {
            for (Object zzb3 : (List) obj) {
                i += zzb(zzb2, zzb3);
            }
            return zzhh.zze(zza2) + i + zzhh.zzl(i);
        }
        for (Object zza3 : (List) obj) {
            i += zza(zzb2, zza2, zza3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzhq zzhq = new zzhq();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<T, Object> zzb2 = this.zza.zzb(i);
            zzhq.zzb((zzhs) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzd()) {
            zzhq.zzb((zzhs) next.getKey(), next.getValue());
        }
        zzhq.zzc = this.zzc;
        return zzhq;
    }
}
