package com.google.android.gms.internal.measurement;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzdr {
    static int zza(byte[] bArr, int i, zzdq zzdq) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzdq);
        }
        zzdq.zza = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzdq zzdq) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzdq.zza = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Ascii.DEL) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzdq.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Ascii.DEL) << Ascii.SO);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzdq.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Ascii.DEL) << Ascii.NAK);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzdq.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Ascii.DEL) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzdq.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzdq zzdq) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzdq.zzb = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & Ascii.DEL)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & Ascii.DEL)) << i4;
            int i6 = i5;
            b = b2;
            i3 = i6;
        }
        zzdq.zzb = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzdq zzdq) throws zzfn {
        int zza = zza(bArr, i, zzdq);
        int i2 = zzdq.zza;
        if (i2 < 0) {
            throw zzfn.zzb();
        } else if (i2 == 0) {
            zzdq.zzc = "";
            return zza;
        } else {
            zzdq.zzc = new String(bArr, zza, i2, zzfe.zza);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzdq zzdq) throws zzfn {
        int zza = zza(bArr, i, zzdq);
        int i2 = zzdq.zza;
        if (i2 < 0) {
            throw zzfn.zzb();
        } else if (i2 == 0) {
            zzdq.zzc = "";
            return zza;
        } else {
            zzdq.zzc = zzid.zzb(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzdq zzdq) throws zzfn {
        int zza = zza(bArr, i, zzdq);
        int i2 = zzdq.zza;
        if (i2 < 0) {
            throw zzfn.zzb();
        } else if (i2 > bArr.length - zza) {
            throw zzfn.zza();
        } else if (i2 == 0) {
            zzdq.zzc = zzdv.zza;
            return zza;
        } else {
            zzdq.zzc = zzdv.zza(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int zza(com.google.android.gms.internal.measurement.zzhc r6, byte[] r7, int r8, int r9, com.google.android.gms.internal.measurement.zzdq r10) throws java.io.IOException {
        /*
            int r0 = r8 + 1
            byte r8 = r7[r8]
            if (r8 >= 0) goto L_0x000c
            int r0 = zza((int) r8, (byte[]) r7, (int) r0, (com.google.android.gms.internal.measurement.zzdq) r10)
            int r8 = r10.zza
        L_0x000c:
            r3 = r0
            if (r8 < 0) goto L_0x0025
            int r9 = r9 - r3
            if (r8 > r9) goto L_0x0025
            java.lang.Object r9 = r6.zza()
            int r8 = r8 + r3
            r0 = r6
            r1 = r9
            r2 = r7
            r4 = r8
            r5 = r10
            r0.zza(r1, r2, r3, r4, r5)
            r6.zzc(r9)
            r10.zzc = r9
            return r8
        L_0x0025:
            com.google.android.gms.internal.measurement.zzfn r6 = com.google.android.gms.internal.measurement.zzfn.zza()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzdr.zza(com.google.android.gms.internal.measurement.zzhc, byte[], int, int, com.google.android.gms.internal.measurement.zzdq):int");
    }

    static int zza(zzhc zzhc, byte[] bArr, int i, int i2, int i3, zzdq zzdq) throws IOException {
        zzgr zzgr = (zzgr) zzhc;
        Object zza = zzgr.zza();
        int zza2 = zzgr.zza(zza, bArr, i, i2, i3, zzdq);
        zzgr.zzc(zza);
        zzdq.zzc = zza;
        return zza2;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfk<?> zzfk, zzdq zzdq) {
        zzff zzff = (zzff) zzfk;
        int zza = zza(bArr, i2, zzdq);
        zzff.zzd(zzdq.zza);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzdq);
            if (i != zzdq.zza) {
                break;
            }
            zza = zza(bArr, zza2, zzdq);
            zzff.zzd(zzdq.zza);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzfk<?> zzfk, zzdq zzdq) throws IOException {
        zzff zzff = (zzff) zzfk;
        int zza = zza(bArr, i, zzdq);
        int i2 = zzdq.zza + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzdq);
            zzff.zzd(zzdq.zza);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzfn.zza();
    }

    static int zza(zzhc<?> zzhc, int i, byte[] bArr, int i2, int i3, zzfk<?> zzfk, zzdq zzdq) throws IOException {
        int zza = zza((zzhc) zzhc, bArr, i2, i3, zzdq);
        zzfk.add(zzdq.zzc);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzdq);
            if (i != zzdq.zza) {
                break;
            }
            zza = zza((zzhc) zzhc, bArr, zza2, i3, zzdq);
            zzfk.add(zzdq.zzc);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzhx zzhx, zzdq zzdq) throws zzfn {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzdq);
                zzhx.zza(i, (Object) Long.valueOf(zzdq.zzb));
                return zzb;
            } else if (i4 == 1) {
                zzhx.zza(i, (Object) Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzdq);
                int i5 = zzdq.zza;
                if (i5 < 0) {
                    throw zzfn.zzb();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzhx.zza(i, (Object) zzdv.zza);
                    } else {
                        zzhx.zza(i, (Object) zzdv.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzfn.zza();
                }
            } else if (i4 == 3) {
                zzhx zzb2 = zzhx.zzb();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzdq);
                    int i8 = zzdq.zza;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zza(i8, bArr, zza2, i3, zzb2, zzdq);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzfn.zzg();
                }
                zzhx.zza(i, (Object) zzb2);
                return i2;
            } else if (i4 == 5) {
                zzhx.zza(i, (Object) Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzfn.zzd();
            }
        } else {
            throw zzfn.zzd();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzdq zzdq) throws zzfn {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzdq);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzdq) + zzdq.zza;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzdq);
                    i6 = zzdq.zza;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzdq);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzfn.zzg();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzfn.zzd();
            }
        } else {
            throw zzfn.zzd();
        }
    }
}
