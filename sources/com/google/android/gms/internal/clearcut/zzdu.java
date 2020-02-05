package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzdu<T> implements zzef<T> {
    private final zzdo zzmn;
    private final boolean zzmo;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;

    private zzdu(zzex<?, ?> zzex, zzbu<?> zzbu, zzdo zzdo) {
        this.zzmx = zzex;
        this.zzmo = zzbu.zze(zzdo);
        this.zzmy = zzbu;
        this.zzmn = zzdo;
    }

    static <T> zzdu<T> zza(zzex<?, ?> zzex, zzbu<?> zzbu, zzdo zzdo) {
        return new zzdu<>(zzex, zzbu, zzdo);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzmx.zzq(t).equals(this.zzmx.zzq(t2))) {
            return false;
        }
        if (this.zzmo) {
            return this.zzmy.zza((Object) t).equals(this.zzmy.zza((Object) t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzmx.zzq(t).hashCode();
        return this.zzmo ? (hashCode * 53) + this.zzmy.zza((Object) t).hashCode() : hashCode;
    }

    public final T newInstance() {
        return this.zzmn.zzbd().zzbi();
    }

    public final void zza(T t, zzfr zzfr) throws IOException {
        int i;
        Object obj;
        Iterator<Map.Entry<?, Object>> it = this.zzmy.zza((Object) t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzca zzca = (zzca) next.getKey();
            if (zzca.zzav() != zzfq.MESSAGE || zzca.zzaw() || zzca.zzax()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (next instanceof zzct) {
                i = zzca.zzc();
                obj = ((zzct) next).zzbs().zzr();
            } else {
                i = zzca.zzc();
                obj = next.getValue();
            }
            zzfr.zza(i, obj);
        }
        zzex<?, ?> zzex = this.zzmx;
        zzex.zzc(zzex.zzq(t), zzfr);
    }

    public final void zza(T t, byte[] bArr, int i, int i2, zzay zzay) throws IOException {
        zzcg zzcg = (zzcg) t;
        zzey zzey = zzcg.zzjp;
        if (zzey == zzey.zzea()) {
            zzey = zzey.zzeb();
            zzcg.zzjp = zzey;
        }
        zzey zzey2 = zzey;
        while (i < i2) {
            int zza = zzax.zza(bArr, i, zzay);
            int i3 = zzay.zzfd;
            if (i3 != 11) {
                i = (i3 & 7) == 2 ? zzax.zza(i3, bArr, zza, i2, zzey2, zzay) : zzax.zza(i3, bArr, zza, i2, zzay);
            } else {
                int i4 = 0;
                zzbb zzbb = null;
                while (zza < i2) {
                    zza = zzax.zza(bArr, zza, zzay);
                    int i5 = zzay.zzfd;
                    int i6 = i5 >>> 3;
                    int i7 = i5 & 7;
                    if (i6 != 2) {
                        if (i6 == 3 && i7 == 2) {
                            zza = zzax.zze(bArr, zza, zzay);
                            zzbb = (zzbb) zzay.zzff;
                        }
                    } else if (i7 == 0) {
                        zza = zzax.zza(bArr, zza, zzay);
                        i4 = zzay.zzfd;
                    }
                    if (i5 == 12) {
                        break;
                    }
                    zza = zzax.zza(i5, bArr, zza, i2, zzay);
                }
                if (zzbb != null) {
                    zzey2.zzb((i4 << 3) | 2, zzbb);
                }
                i = zza;
            }
        }
        if (i != i2) {
            throw zzco.zzbo();
        }
    }

    public final void zzc(T t) {
        this.zzmx.zzc(t);
        this.zzmy.zzc(t);
    }

    public final void zzc(T t, T t2) {
        zzeh.zza(this.zzmx, t, t2);
        if (this.zzmo) {
            zzeh.zza(this.zzmy, t, t2);
        }
    }

    public final int zzm(T t) {
        zzex<?, ?> zzex = this.zzmx;
        int zzr = zzex.zzr(zzex.zzq(t)) + 0;
        return this.zzmo ? zzr + this.zzmy.zza((Object) t).zzat() : zzr;
    }

    public final boolean zzo(T t) {
        return this.zzmy.zza((Object) t).isInitialized();
    }
}
