package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzgt<T> implements zzhc<T> {
    private final zzgn zza;
    private final zzhu<?, ?> zzb;
    private final boolean zzc;
    private final zzes<?> zzd;

    private zzgt(zzhu<?, ?> zzhu, zzes<?> zzes, zzgn zzgn) {
        this.zzb = zzhu;
        this.zzc = zzes.zza(zzgn);
        this.zzd = zzes;
        this.zza = zzgn;
    }

    static <T> zzgt<T> zza(zzhu<?, ?> zzhu, zzes<?> zzes, zzgn zzgn) {
        return new zzgt<>(zzhu, zzes, zzgn);
    }

    public final T zza() {
        return this.zza.zzbq().zzt();
    }

    public final boolean zza(T t, T t2) {
        if (!this.zzb.zzb(t).equals(this.zzb.zzb(t2))) {
            return false;
        }
        if (this.zzc) {
            return this.zzd.zza((Object) t).equals(this.zzd.zza((Object) t2));
        }
        return true;
    }

    public final int zza(T t) {
        int hashCode = this.zzb.zzb(t).hashCode();
        return this.zzc ? (hashCode * 53) + this.zzd.zza((Object) t).hashCode() : hashCode;
    }

    public final void zzb(T t, T t2) {
        zzhe.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzhe.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzir zzir) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzev zzev = (zzev) next.getKey();
            if (zzev.zzc() != zzio.MESSAGE || zzev.zzd() || zzev.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzfq) {
                zzir.zza(zzev.zza(), (Object) ((zzfq) next).zza().zzc());
            } else {
                zzir.zza(zzev.zza(), next.getValue());
            }
        }
        zzhu<?, ?> zzhu = this.zzb;
        zzhu.zzb(zzhu.zzb(t), zzir);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v11, resolved type: com.google.android.gms.internal.measurement.zzfd$zze} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.zzdq r14) throws java.io.IOException {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.zzfd r0 = (com.google.android.gms.internal.measurement.zzfd) r0
            com.google.android.gms.internal.measurement.zzhx r1 = r0.zzb
            com.google.android.gms.internal.measurement.zzhx r2 = com.google.android.gms.internal.measurement.zzhx.zza()
            if (r1 != r2) goto L_0x0011
            com.google.android.gms.internal.measurement.zzhx r1 = com.google.android.gms.internal.measurement.zzhx.zzb()
            r0.zzb = r1
        L_0x0011:
            com.google.android.gms.internal.measurement.zzfd$zzb r10 = (com.google.android.gms.internal.measurement.zzfd.zzb) r10
            r10.zza()
            r10 = 0
            r0 = r10
        L_0x0018:
            if (r12 >= r13) goto L_0x00a4
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r11, r12, r14)
            int r2 = r14.zza
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L_0x0051
            r12 = r2 & 7
            if (r12 != r3) goto L_0x004c
            com.google.android.gms.internal.measurement.zzes<?> r12 = r9.zzd
            com.google.android.gms.internal.measurement.zzeq r0 = r14.zzd
            com.google.android.gms.internal.measurement.zzgn r3 = r9.zza
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.zza(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.zzfd$zze r0 = (com.google.android.gms.internal.measurement.zzfd.zze) r0
            if (r0 != 0) goto L_0x0043
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.zzdr.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzhx) r6, (com.google.android.gms.internal.measurement.zzdq) r7)
            goto L_0x0018
        L_0x0043:
            com.google.android.gms.internal.measurement.zzgy.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x004c:
            int r12 = com.google.android.gms.internal.measurement.zzdr.zza((int) r2, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzdq) r14)
            goto L_0x0018
        L_0x0051:
            r12 = 0
            r2 = r10
        L_0x0053:
            if (r4 >= r13) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r11, r4, r14)
            int r5 = r14.zza
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L_0x007b
            r8 = 3
            if (r6 == r8) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            if (r0 != 0) goto L_0x0072
            if (r7 != r3) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzdr.zze(r11, r4, r14)
            java.lang.Object r2 = r14.zzc
            com.google.android.gms.internal.measurement.zzdv r2 = (com.google.android.gms.internal.measurement.zzdv) r2
            goto L_0x0053
        L_0x0072:
            com.google.android.gms.internal.measurement.zzgy.zza()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L_0x007b:
            if (r7 != 0) goto L_0x0090
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza(r11, r4, r14)
            int r12 = r14.zza
            com.google.android.gms.internal.measurement.zzes<?> r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzeq r5 = r14.zzd
            com.google.android.gms.internal.measurement.zzgn r6 = r9.zza
            java.lang.Object r0 = r0.zza(r5, r6, r12)
            com.google.android.gms.internal.measurement.zzfd$zze r0 = (com.google.android.gms.internal.measurement.zzfd.zze) r0
            goto L_0x0053
        L_0x0090:
            r6 = 12
            if (r5 == r6) goto L_0x0099
            int r4 = com.google.android.gms.internal.measurement.zzdr.zza((int) r5, (byte[]) r11, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzdq) r14)
            goto L_0x0053
        L_0x0099:
            if (r2 == 0) goto L_0x00a1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.zza((int) r12, (java.lang.Object) r2)
        L_0x00a1:
            r12 = r4
            goto L_0x0018
        L_0x00a4:
            if (r12 != r13) goto L_0x00a7
            return
        L_0x00a7:
            com.google.android.gms.internal.measurement.zzfn r10 = com.google.android.gms.internal.measurement.zzfn.zzg()
            goto L_0x00ad
        L_0x00ac:
            throw r10
        L_0x00ad:
            goto L_0x00ac
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzgt.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzdq):void");
    }

    public final void zza(T t, zzhd zzhd, zzeq zzeq) throws IOException {
        boolean z;
        zzhu<?, ?> zzhu = this.zzb;
        zzes<?> zzes = this.zzd;
        Object zzc2 = zzhu.zzc(t);
        zzet<?> zzb2 = zzes.zzb(t);
        do {
            try {
                if (zzhd.zza() == Integer.MAX_VALUE) {
                    zzhu.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzhd.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzdv zzdv = null;
                    while (zzhd.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzhd.zzb();
                        if (zzb4 == 16) {
                            i = zzhd.zzo();
                            obj = zzes.zza(zzeq, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzes.zza(zzhd, obj, zzeq, zzb2);
                            } else {
                                zzdv = zzhd.zzn();
                            }
                        } else if (!zzhd.zzc()) {
                            break;
                        }
                    }
                    if (zzhd.zzb() != 12) {
                        throw zzfn.zze();
                    } else if (zzdv != null) {
                        if (obj != null) {
                            zzes.zza(zzdv, obj, zzeq, zzb2);
                        } else {
                            zzhu.zza(zzc2, i, zzdv);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzes.zza(zzeq, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzes.zza(zzhd, zza2, zzeq, zzb2);
                    } else {
                        z = zzhu.zza(zzc2, zzhd);
                        continue;
                    }
                } else {
                    z = zzhd.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzhu.zzb((Object) t, zzc2);
            }
        } while (z);
    }

    public final void zzc(T t) {
        this.zzb.zzd(t);
        this.zzd.zzc(t);
    }

    public final boolean zzd(T t) {
        return this.zzd.zza((Object) t).zzf();
    }

    public final int zzb(T t) {
        zzhu<?, ?> zzhu = this.zzb;
        int zze = zzhu.zze(zzhu.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }
}
