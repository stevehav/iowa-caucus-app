package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzhl<T> implements zzhw<T> {
    private final zzhf zzzh;
    private final boolean zzzi;
    private final zzio<?, ?> zzzr;
    private final zzfl<?> zzzs;

    private zzhl(zzio<?, ?> zzio, zzfl<?> zzfl, zzhf zzhf) {
        this.zzzr = zzio;
        this.zzzi = zzfl.zze(zzhf);
        this.zzzs = zzfl;
        this.zzzh = zzhf;
    }

    static <T> zzhl<T> zza(zzio<?, ?> zzio, zzfl<?> zzfl, zzhf zzhf) {
        return new zzhl<>(zzio, zzfl, zzhf);
    }

    public final T newInstance() {
        return this.zzzh.zzfa().zzff();
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzzr.zzt(t).equals(this.zzzr.zzt(t2))) {
            return false;
        }
        if (this.zzzi) {
            return this.zzzs.zzc(t).equals(this.zzzs.zzc(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzzr.zzt(t).hashCode();
        return this.zzzi ? (hashCode * 53) + this.zzzs.zzc(t).hashCode() : hashCode;
    }

    public final void zzc(T t, T t2) {
        zzhy.zza(this.zzzr, t, t2);
        if (this.zzzi) {
            zzhy.zza(this.zzzs, t, t2);
        }
    }

    public final void zza(T t, zzjj zzjj) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzzs.zzc(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzfr zzfr = (zzfr) next.getKey();
            if (zzfr.zzet() != zzji.MESSAGE || zzfr.zzeu() || zzfr.zzev()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzgk) {
                zzjj.zza(zzfr.zzr(), (Object) ((zzgk) next).zzfs().zzce());
            } else {
                zzjj.zza(zzfr.zzr(), next.getValue());
            }
        }
        zzio<?, ?> zzio = this.zzzr;
        zzio.zzc(zzio.zzt(t), zzjj);
    }

    public final void zza(T t, byte[] bArr, int i, int i2, zzei zzei) throws IOException {
        zzfy zzfy = (zzfy) t;
        zzip zzip = zzfy.zzwj;
        if (zzip == zzip.zzhe()) {
            zzip = zzip.zzhf();
            zzfy.zzwj = zzip;
        }
        zzip zzip2 = zzip;
        while (i < i2) {
            int zza = zzeh.zza(bArr, i, zzei);
            int i3 = zzei.zzro;
            if (i3 == 11) {
                int i4 = 0;
                zzeo zzeo = null;
                while (zza < i2) {
                    zza = zzeh.zza(bArr, zza, zzei);
                    int i5 = zzei.zzro;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3 && i7 == 2) {
                            zza = zzeh.zze(bArr, zza, zzei);
                            zzeo = (zzeo) zzei.zzrq;
                        }
                    } else if (i7 == 0) {
                        zza = zzeh.zza(bArr, zza, zzei);
                        i4 = zzei.zzro;
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzeh.zza(i5, bArr, zza, i2, zzei);
                }
                if (zzeo != null) {
                    zzip2.zzb((i4 << 3) | 2, zzeo);
                }
                i = zza;
            } else if ((i3 & 7) == 2) {
                i = zzeh.zza(i3, bArr, zza, i2, zzip2, zzei);
            } else {
                i = zzeh.zza(i3, bArr, zza, i2, zzei);
            }
        }
        if (i != i2) {
            throw zzgf.zzfo();
        }
    }

    public final void zza(T t, zzhv zzhv, zzfk zzfk) throws IOException {
        boolean z;
        zzio<?, ?> zzio = this.zzzr;
        zzfl<?> zzfl = this.zzzs;
        Object zzu = zzio.zzu(t);
        zzfp<?> zzd = zzfl.zzd(t);
        do {
            try {
                if (zzhv.zzcn() == Integer.MAX_VALUE) {
                    zzio.zzf(t, zzu);
                    return;
                }
                int tag = zzhv.getTag();
                if (tag == 11) {
                    int i = 0;
                    Object obj = null;
                    zzeo zzeo = null;
                    while (zzhv.zzcn() != Integer.MAX_VALUE) {
                        int tag2 = zzhv.getTag();
                        if (tag2 == 16) {
                            i = zzhv.zzcx();
                            obj = zzfl.zza(zzfk, this.zzzh, i);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzfl.zza(zzhv, obj, zzfk, zzd);
                            } else {
                                zzeo = zzhv.zzcw();
                            }
                        } else if (!zzhv.zzco()) {
                            break;
                        }
                    }
                    if (zzhv.getTag() != 12) {
                        throw zzgf.zzfl();
                    } else if (zzeo != null) {
                        if (obj != null) {
                            zzfl.zza(zzeo, obj, zzfk, zzd);
                        } else {
                            zzio.zza(zzu, i, zzeo);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzfl.zza(zzfk, this.zzzh, tag >>> 3);
                    if (zza != null) {
                        zzfl.zza(zzhv, zza, zzfk, zzd);
                    } else {
                        z = zzio.zza(zzu, zzhv);
                        continue;
                    }
                } else {
                    z = zzhv.zzco();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzio.zzf(t, zzu);
            }
        } while (z);
    }

    public final void zze(T t) {
        this.zzzr.zze(t);
        this.zzzs.zze((Object) t);
    }

    public final boolean zzr(T t) {
        return this.zzzs.zzc(t).isInitialized();
    }

    public final int zzp(T t) {
        zzio<?, ?> zzio = this.zzzr;
        int zzv = zzio.zzv(zzio.zzt(t)) + 0;
        return this.zzzi ? zzv + this.zzzs.zzc(t).zzer() : zzv;
    }
}
