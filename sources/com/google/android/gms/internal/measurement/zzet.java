package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzev;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzet<FieldDescriptorType extends zzev<FieldDescriptorType>> {
    private static final zzet zzd = new zzet(true);
    final zzhh<FieldDescriptorType, Object> zza = zzhh.zza(16);
    private boolean zzb;
    private boolean zzc = false;

    private zzet() {
    }

    private zzet(boolean z) {
        zzb();
    }

    public static <T extends zzev<T>> zzet<T> zza() {
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
        if (!(obj instanceof zzet)) {
            return false;
        }
        return this.zza.equals(((zzet) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> zzd() {
        if (this.zzc) {
            return new zzft(this.zza.entrySet().iterator());
        }
        return this.zza.entrySet().iterator();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> zze() {
        if (this.zzc) {
            return new zzft(this.zza.zze().iterator());
        }
        return this.zza.zze().iterator();
    }

    private final Object zza(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zza.get(fielddescriptortype);
        return obj instanceof zzfo ? zzfo.zza() : obj;
    }

    private final void zzb(FieldDescriptorType fielddescriptortype, Object obj) {
        if (!fielddescriptortype.zzd()) {
            zza(fielddescriptortype.zzb(), obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (i < size) {
                Object obj2 = arrayList2.get(i);
                i++;
                zza(fielddescriptortype.zzb(), obj2);
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfo) {
            this.zzc = true;
        }
        this.zza.put(fielddescriptortype, obj);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002e, code lost:
        if ((r3 instanceof byte[]) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfo) == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfh) == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.measurement.zzil r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.zzfe.zza(r3)
            int[] r0 = com.google.android.gms.internal.measurement.zzew.zza
            com.google.android.gms.internal.measurement.zzio r2 = r2.zza()
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
                case 8: goto L_0x001e;
                case 9: goto L_0x0015;
                default: goto L_0x0014;
            }
        L_0x0014:
            goto L_0x0043
        L_0x0015:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzgn
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfo
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
        L_0x001e:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzfh
            if (r2 == 0) goto L_0x0043
        L_0x0026:
            r1 = 1
            goto L_0x0043
        L_0x0028:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.zzdv
            if (r2 != 0) goto L_0x0026
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L_0x0043
            goto L_0x0026
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
            r1 = r0
        L_0x0043:
            if (r1 == 0) goto L_0x0046
            return
        L_0x0046:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            goto L_0x004f
        L_0x004e:
            throw r2
        L_0x004f:
            goto L_0x004e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzet.zza(com.google.android.gms.internal.measurement.zzil, java.lang.Object):void");
    }

    public final boolean zzf() {
        for (int i = 0; i < this.zza.zzc(); i++) {
            if (!zza(this.zza.zzb(i))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> zza2 : this.zza.zzd()) {
            if (!zza(zza2)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zza(Map.Entry<FieldDescriptorType, Object> entry) {
        zzev zzev = (zzev) entry.getKey();
        if (zzev.zzc() == zzio.MESSAGE) {
            if (zzev.zzd()) {
                for (zzgn h_ : (List) entry.getValue()) {
                    if (!h_.h_()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgn) {
                    if (!((zzgn) value).h_()) {
                        return false;
                    }
                } else if (value instanceof zzfo) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    public final void zza(zzet<FieldDescriptorType> zzet) {
        for (int i = 0; i < zzet.zza.zzc(); i++) {
            zzb(zzet.zza.zzb(i));
        }
        for (Map.Entry<FieldDescriptorType, Object> zzb2 : zzet.zza.zzd()) {
            zzb(zzb2);
        }
    }

    private static Object zza(Object obj) {
        if (obj instanceof zzgs) {
            return ((zzgs) obj).zza();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private final void zzb(Map.Entry<FieldDescriptorType, Object> entry) {
        Object obj;
        zzev zzev = (zzev) entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfo) {
            value = zzfo.zza();
        }
        if (zzev.zzd()) {
            Object zza2 = zza(zzev);
            if (zza2 == null) {
                zza2 = new ArrayList();
            }
            for (Object zza3 : (List) value) {
                ((List) zza2).add(zza(zza3));
            }
            this.zza.put(zzev, zza2);
        } else if (zzev.zzc() == zzio.MESSAGE) {
            Object zza4 = zza(zzev);
            if (zza4 == null) {
                this.zza.put(zzev, zza(value));
                return;
            }
            if (zza4 instanceof zzgs) {
                obj = zzev.zza((zzgs) zza4, (zzgs) value);
            } else {
                obj = zzev.zza(((zzgn) zza4).zzbp(), (zzgn) value).zzu();
            }
            this.zza.put(zzev, obj);
        } else {
            this.zza.put(zzev, zza(value));
        }
    }

    static void zza(zzek zzek, zzil zzil, int i, Object obj) throws IOException {
        if (zzil == zzil.GROUP) {
            zzgn zzgn = (zzgn) obj;
            zzfe.zza(zzgn);
            zzek.zza(i, 3);
            zzgn.zza(zzek);
            zzek.zza(i, 4);
            return;
        }
        zzek.zza(i, zzil.zzb());
        switch (zzew.zzb[zzil.ordinal()]) {
            case 1:
                zzek.zza(((Double) obj).doubleValue());
                return;
            case 2:
                zzek.zza(((Float) obj).floatValue());
                return;
            case 3:
                zzek.zza(((Long) obj).longValue());
                return;
            case 4:
                zzek.zza(((Long) obj).longValue());
                return;
            case 5:
                zzek.zza(((Integer) obj).intValue());
                return;
            case 6:
                zzek.zzc(((Long) obj).longValue());
                return;
            case 7:
                zzek.zzd(((Integer) obj).intValue());
                return;
            case 8:
                zzek.zza(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzgn) obj).zza(zzek);
                return;
            case 10:
                zzek.zza((zzgn) obj);
                return;
            case 11:
                if (obj instanceof zzdv) {
                    zzek.zza((zzdv) obj);
                    return;
                } else {
                    zzek.zza((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzdv) {
                    zzek.zza((zzdv) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzek.zzb(bArr, 0, bArr.length);
                return;
            case 13:
                zzek.zzb(((Integer) obj).intValue());
                return;
            case 14:
                zzek.zzd(((Integer) obj).intValue());
                return;
            case 15:
                zzek.zzc(((Long) obj).longValue());
                return;
            case 16:
                zzek.zzc(((Integer) obj).intValue());
                return;
            case 17:
                zzek.zzb(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzfh) {
                    zzek.zza(((zzfh) obj).zza());
                    return;
                } else {
                    zzek.zza(((Integer) obj).intValue());
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
        for (Map.Entry<FieldDescriptorType, Object> zzc2 : this.zza.zzd()) {
            i += zzc(zzc2);
        }
        return i;
    }

    private static int zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        zzev zzev = (zzev) entry.getKey();
        Object value = entry.getValue();
        if (zzev.zzc() != zzio.MESSAGE || zzev.zzd() || zzev.zze()) {
            return zza((zzev<?>) zzev, value);
        }
        if (value instanceof zzfo) {
            return zzek.zzb(((zzev) entry.getKey()).zza(), (zzfs) (zzfo) value);
        }
        return zzek.zzb(((zzev) entry.getKey()).zza(), (zzgn) value);
    }

    static int zza(zzil zzil, int i, Object obj) {
        int zze = zzek.zze(i);
        if (zzil == zzil.GROUP) {
            zzfe.zza((zzgn) obj);
            zze <<= 1;
        }
        return zze + zzb(zzil, obj);
    }

    private static int zzb(zzil zzil, Object obj) {
        switch (zzew.zzb[zzil.ordinal()]) {
            case 1:
                return zzek.zzb(((Double) obj).doubleValue());
            case 2:
                return zzek.zzb(((Float) obj).floatValue());
            case 3:
                return zzek.zzd(((Long) obj).longValue());
            case 4:
                return zzek.zze(((Long) obj).longValue());
            case 5:
                return zzek.zzf(((Integer) obj).intValue());
            case 6:
                return zzek.zzg(((Long) obj).longValue());
            case 7:
                return zzek.zzi(((Integer) obj).intValue());
            case 8:
                return zzek.zzb(((Boolean) obj).booleanValue());
            case 9:
                return zzek.zzc((zzgn) obj);
            case 10:
                if (obj instanceof zzfo) {
                    return zzek.zza((zzfs) (zzfo) obj);
                }
                return zzek.zzb((zzgn) obj);
            case 11:
                if (obj instanceof zzdv) {
                    return zzek.zzb((zzdv) obj);
                }
                return zzek.zzb((String) obj);
            case 12:
                if (obj instanceof zzdv) {
                    return zzek.zzb((zzdv) obj);
                }
                return zzek.zzb((byte[]) obj);
            case 13:
                return zzek.zzg(((Integer) obj).intValue());
            case 14:
                return zzek.zzj(((Integer) obj).intValue());
            case 15:
                return zzek.zzh(((Long) obj).longValue());
            case 16:
                return zzek.zzh(((Integer) obj).intValue());
            case 17:
                return zzek.zzf(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfh) {
                    return zzek.zzk(((zzfh) obj).zza());
                }
                return zzek.zzk(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int zza(zzev<?> zzev, Object obj) {
        zzil zzb2 = zzev.zzb();
        int zza2 = zzev.zza();
        if (!zzev.zzd()) {
            return zza(zzb2, zza2, obj);
        }
        int i = 0;
        if (zzev.zze()) {
            for (Object zzb3 : (List) obj) {
                i += zzb(zzb2, zzb3);
            }
            return zzek.zze(zza2) + i + zzek.zzl(i);
        }
        for (Object zza3 : (List) obj) {
            i += zza(zzb2, zza2, zza3);
        }
        return i;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzet zzet = new zzet();
        for (int i = 0; i < this.zza.zzc(); i++) {
            Map.Entry<FieldDescriptorType, Object> zzb2 = this.zza.zzb(i);
            zzet.zzb((zzev) zzb2.getKey(), zzb2.getValue());
        }
        for (Map.Entry next : this.zza.zzd()) {
            zzet.zzb((zzev) next.getKey(), next.getValue());
        }
        zzet.zzc = this.zzc;
        return zzet;
    }
}
