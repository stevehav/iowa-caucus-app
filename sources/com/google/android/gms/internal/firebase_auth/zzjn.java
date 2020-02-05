package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzjn<T> implements zzjw<T> {
    private final zzjg zza;
    private final zzks<?, ?> zzb;
    private final boolean zzc;
    private final zzhm<?> zzd;

    private zzjn(zzks<?, ?> zzks, zzhm<?> zzhm, zzjg zzjg) {
        this.zzb = zzks;
        this.zzc = zzhm.zza(zzjg);
        this.zzd = zzhm;
        this.zza = zzjg;
    }

    static <T> zzjn<T> zza(zzks<?, ?> zzks, zzhm<?> zzhm, zzjg zzjg) {
        return new zzjn<>(zzks, zzhm, zzjg);
    }

    public final T zza() {
        return this.zza.zzaf().zze();
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
        zzjy.zza(this.zzb, t, t2);
        if (this.zzc) {
            zzjy.zza(this.zzd, t, t2);
        }
    }

    public final void zza(T t, zzll zzll) throws IOException {
        Iterator<Map.Entry<?, Object>> zzd2 = this.zzd.zza((Object) t).zzd();
        while (zzd2.hasNext()) {
            Map.Entry next = zzd2.next();
            zzhs zzhs = (zzhs) next.getKey();
            if (zzhs.zzc() != zzlm.MESSAGE || zzhs.zzd() || zzhs.zze()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzin) {
                zzll.zza(zzhs.zza(), (Object) ((zzin) next).zza().zzc());
            } else {
                zzll.zza(zzhs.zza(), next.getValue());
            }
        }
        zzks<?, ?> zzks = this.zzb;
        zzks.zzb(zzks.zzb(t), zzll);
    }

    public final void zza(T t, zzjx zzjx, zzhk zzhk) throws IOException {
        boolean z;
        zzks<?, ?> zzks = this.zzb;
        zzhm<?> zzhm = this.zzd;
        Object zzc2 = zzks.zzc(t);
        zzhq<?> zzb2 = zzhm.zzb(t);
        do {
            try {
                if (zzjx.zza() == Integer.MAX_VALUE) {
                    zzks.zzb((Object) t, zzc2);
                    return;
                }
                int zzb3 = zzjx.zzb();
                if (zzb3 == 11) {
                    int i = 0;
                    Object obj = null;
                    zzgm zzgm = null;
                    while (zzjx.zza() != Integer.MAX_VALUE) {
                        int zzb4 = zzjx.zzb();
                        if (zzb4 == 16) {
                            i = zzjx.zzo();
                            obj = zzhm.zza(zzhk, this.zza, i);
                        } else if (zzb4 == 26) {
                            if (obj != null) {
                                zzhm.zza(zzjx, obj, zzhk, zzb2);
                            } else {
                                zzgm = zzjx.zzn();
                            }
                        } else if (!zzjx.zzc()) {
                            break;
                        }
                    }
                    if (zzjx.zzb() != 12) {
                        throw zzig.zze();
                    } else if (zzgm != null) {
                        if (obj != null) {
                            zzhm.zza(zzgm, obj, zzhk, zzb2);
                        } else {
                            zzks.zza(zzc2, i, zzgm);
                        }
                    }
                } else if ((zzb3 & 7) == 2) {
                    Object zza2 = zzhm.zza(zzhk, this.zza, zzb3 >>> 3);
                    if (zza2 != null) {
                        zzhm.zza(zzjx, zza2, zzhk, zzb2);
                    } else {
                        z = zzks.zza(zzc2, zzjx);
                        continue;
                    }
                } else {
                    z = zzjx.zzc();
                    continue;
                }
                z = true;
                continue;
            } finally {
                zzks.zzb((Object) t, zzc2);
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
        zzks<?, ?> zzks = this.zzb;
        int zze = zzks.zze(zzks.zzb(t)) + 0;
        return this.zzc ? zze + this.zzd.zza((Object) t).zzg() : zze;
    }
}
