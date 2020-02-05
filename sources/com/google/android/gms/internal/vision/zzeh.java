package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

final class zzeh {
    static int zza(byte[] bArr, int i, zzei zzei) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzei);
        }
        zzei.zzro = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzei zzei) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzei.zzro = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & Ascii.DEL) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzei.zzro = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & Ascii.DEL) << Ascii.SO);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzei.zzro = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & Ascii.DEL) << Ascii.NAK);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzei.zzro = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & Ascii.DEL) << Ascii.FS);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzei.zzro = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzei zzei) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzei.zzrp = j;
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
        zzei.zzrp = j2;
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

    static int zzc(byte[] bArr, int i, zzei zzei) throws zzgf {
        int zza = zza(bArr, i, zzei);
        int i2 = zzei.zzro;
        if (i2 < 0) {
            throw zzgf.zzfi();
        } else if (i2 == 0) {
            zzei.zzrq = "";
            return zza;
        } else {
            zzei.zzrq = new String(bArr, zza, i2, zzga.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzei zzei) throws zzgf {
        int zza = zza(bArr, i, zzei);
        int i2 = zzei.zzro;
        if (i2 < 0) {
            throw zzgf.zzfi();
        } else if (i2 == 0) {
            zzei.zzrq = "";
            return zza;
        } else {
            zzei.zzrq = zziw.zzi(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzei zzei) throws zzgf {
        int zza = zza(bArr, i, zzei);
        int i2 = zzei.zzro;
        if (i2 < 0) {
            throw zzgf.zzfi();
        } else if (i2 > bArr.length - zza) {
            throw zzgf.zzfh();
        } else if (i2 == 0) {
            zzei.zzrq = zzeo.zzrx;
            return zza;
        } else {
            zzei.zzrq = zzeo.zzb(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzge<?> zzge, zzei zzei) {
        zzfz zzfz = (zzfz) zzge;
        int zza = zza(bArr, i2, zzei);
        zzfz.zzbg(zzei.zzro);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzei);
            if (i != zzei.zzro) {
                break;
            }
            zza = zza(bArr, zza2, zzei);
            zzfz.zzbg(zzei.zzro);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzge<?> zzge, zzei zzei) throws IOException {
        zzfz zzfz = (zzfz) zzge;
        int zza = zza(bArr, i, zzei);
        int i2 = zzei.zzro + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzei);
            zzfz.zzbg(zzei.zzro);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzgf.zzfh();
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzip zzip, zzei zzei) throws zzgf {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzei);
                zzip.zzb(i, Long.valueOf(zzei.zzrp));
                return zzb;
            } else if (i4 == 1) {
                zzip.zzb(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzei);
                int i5 = zzei.zzro;
                if (i5 < 0) {
                    throw zzgf.zzfi();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzip.zzb(i, zzeo.zzrx);
                    } else {
                        zzip.zzb(i, zzeo.zzb(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzgf.zzfh();
                }
            } else if (i4 == 3) {
                zzip zzhf = zzip.zzhf();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzei);
                    int i8 = zzei.zzro;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zza(i8, bArr, zza2, i3, zzhf, zzei);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzgf.zzfo();
                }
                zzip.zzb(i, zzhf);
                return i2;
            } else if (i4 == 5) {
                zzip.zzb(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzgf.zzfk();
            }
        } else {
            throw zzgf.zzfk();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzei zzei) throws zzgf {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzei);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzei) + zzei.zzro;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzei);
                    i6 = zzei.zzro;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzei);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzgf.zzfo();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzgf.zzfk();
            }
        } else {
            throw zzgf.zzfk();
        }
    }
}
