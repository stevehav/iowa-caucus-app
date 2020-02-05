package com.google.android.gms.internal.clearcut;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;

final class zzax {
    static int zza(int i, byte[] bArr, int i2, int i3, zzay zzay) throws zzco {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzay);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzay) + zzay.zzfd;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzay);
                    i6 = zzay.zzfd;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzay);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzco.zzbo();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzco.zzbm();
            }
        } else {
            throw zzco.zzbm();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzcn<?> zzcn, zzay zzay) {
        zzch zzch = (zzch) zzcn;
        int zza = zza(bArr, i2, zzay);
        while (true) {
            zzch.zzac(zzay.zzfd);
            if (zza >= i3) {
                break;
            }
            int zza2 = zza(bArr, zza, zzay);
            if (i != zzay.zzfd) {
                break;
            }
            zza = zza(bArr, zza2, zzay);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzey zzey, zzay zzay) throws IOException {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzay);
                zzey.zzb(i, Long.valueOf(zzay.zzfe));
                return zzb;
            } else if (i4 == 1) {
                zzey.zzb(i, Long.valueOf(zzd(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzay);
                int i5 = zzay.zzfd;
                zzey.zzb(i, i5 == 0 ? zzbb.zzfi : zzbb.zzb(bArr, zza, i5));
                return zza + i5;
            } else if (i4 == 3) {
                zzey zzeb = zzey.zzeb();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzay);
                    int i8 = zzay.zzfd;
                    if (i8 == i6) {
                        i7 = i8;
                        i2 = zza2;
                        break;
                    }
                    i7 = i8;
                    i2 = zza(i8, bArr, zza2, i3, zzeb, zzay);
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzco.zzbo();
                }
                zzey.zzb(i, zzeb);
                return i2;
            } else if (i4 == 5) {
                zzey.zzb(i, Integer.valueOf(zzc(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzco.zzbm();
            }
        } else {
            throw zzco.zzbm();
        }
    }

    static int zza(int i, byte[] bArr, int i2, zzay zzay) {
        int i3;
        int i4;
        int i5 = i & 127;
        int i6 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            i4 = b << 7;
        } else {
            int i7 = i5 | ((b & Ascii.DEL) << 7);
            int i8 = i6 + 1;
            byte b2 = bArr[i6];
            if (b2 >= 0) {
                i3 = b2 << Ascii.SO;
            } else {
                i5 = i7 | ((b2 & Ascii.DEL) << Ascii.SO);
                i6 = i8 + 1;
                byte b3 = bArr[i8];
                if (b3 >= 0) {
                    i4 = b3 << Ascii.NAK;
                } else {
                    i7 = i5 | ((b3 & Ascii.DEL) << Ascii.NAK);
                    i8 = i6 + 1;
                    byte b4 = bArr[i6];
                    if (b4 >= 0) {
                        i3 = b4 << Ascii.FS;
                    } else {
                        int i9 = i7 | ((b4 & Ascii.DEL) << Ascii.FS);
                        while (true) {
                            int i10 = i8 + 1;
                            if (bArr[i8] >= 0) {
                                zzay.zzfd = i9;
                                return i10;
                            }
                            i8 = i10;
                        }
                    }
                }
            }
            zzay.zzfd = i7 | i3;
            return i8;
        }
        zzay.zzfd = i5 | i4;
        return i6;
    }

    static int zza(byte[] bArr, int i, zzay zzay) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza((int) b, bArr, i2, zzay);
        }
        zzay.zzfd = b;
        return i2;
    }

    static int zza(byte[] bArr, int i, zzcn<?> zzcn, zzay zzay) throws IOException {
        zzch zzch = (zzch) zzcn;
        int zza = zza(bArr, i, zzay);
        int i2 = zzay.zzfd + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzay);
            zzch.zzac(zzay.zzfd);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzco.zzbl();
    }

    static int zzb(byte[] bArr, int i, zzay zzay) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzay.zzfe = j;
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
        zzay.zzfe = j2;
        return i3;
    }

    static int zzc(byte[] bArr, int i) {
        return ((bArr[i + 3] & UnsignedBytes.MAX_VALUE) << Ascii.CAN) | (bArr[i] & UnsignedBytes.MAX_VALUE) | ((bArr[i + 1] & UnsignedBytes.MAX_VALUE) << 8) | ((bArr[i + 2] & UnsignedBytes.MAX_VALUE) << Ascii.DLE);
    }

    static int zzc(byte[] bArr, int i, zzay zzay) {
        int zza = zza(bArr, i, zzay);
        int i2 = zzay.zzfd;
        if (i2 == 0) {
            zzay.zzff = "";
            return zza;
        }
        zzay.zzff = new String(bArr, zza, i2, zzci.UTF_8);
        return zza + i2;
    }

    static int zzd(byte[] bArr, int i, zzay zzay) throws IOException {
        int zza = zza(bArr, i, zzay);
        int i2 = zzay.zzfd;
        if (i2 == 0) {
            zzay.zzff = "";
            return zza;
        }
        int i3 = zza + i2;
        if (zzff.zze(bArr, zza, i3)) {
            zzay.zzff = new String(bArr, zza, i2, zzci.UTF_8);
            return i3;
        }
        throw zzco.zzbp();
    }

    static long zzd(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zze(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzd(bArr, i));
    }

    static int zze(byte[] bArr, int i, zzay zzay) {
        int zza = zza(bArr, i, zzay);
        int i2 = zzay.zzfd;
        if (i2 == 0) {
            zzay.zzff = zzbb.zzfi;
            return zza;
        }
        zzay.zzff = zzbb.zzb(bArr, zza, i2);
        return zza + i2;
    }

    static float zzf(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzc(bArr, i));
    }
}
