package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfy;

final class zzgu implements zzhx {
    private static final zzhe zzyt = new zzgv();
    private final zzhe zzys;

    public zzgu() {
        this(new zzgw(zzfx.zzex(), zzfx()));
    }

    private zzgu(zzhe zzhe) {
        this.zzys = (zzhe) zzga.zza(zzhe, "messageInfoFactory");
    }

    public final <T> zzhw<T> zze(Class<T> cls) {
        zzhy.zzg(cls);
        zzhd zzc = this.zzys.zzc(cls);
        if (zzc.zzgf()) {
            if (zzfy.class.isAssignableFrom(cls)) {
                return zzhl.zza(zzhy.zzgr(), zzfo.zzen(), zzc.zzgg());
            }
            return zzhl.zza(zzhy.zzgp(), zzfo.zzeo(), zzc.zzgg());
        } else if (zzfy.class.isAssignableFrom(cls)) {
            if (zza(zzc)) {
                return zzhj.zza(cls, zzc, zzhp.zzgj(), zzgp.zzfw(), zzhy.zzgr(), zzfo.zzen(), zzhc.zzgc());
            }
            return zzhj.zza(cls, zzc, zzhp.zzgj(), zzgp.zzfw(), zzhy.zzgr(), (zzfl<?>) null, zzhc.zzgc());
        } else if (zza(zzc)) {
            return zzhj.zza(cls, zzc, zzhp.zzgi(), zzgp.zzfv(), zzhy.zzgp(), zzfo.zzeo(), zzhc.zzgb());
        } else {
            return zzhj.zza(cls, zzc, zzhp.zzgi(), zzgp.zzfv(), zzhy.zzgq(), (zzfl<?>) null, zzhc.zzgb());
        }
    }

    private static boolean zza(zzhd zzhd) {
        return zzhd.zzge() == zzfy.zzg.zzxf;
    }

    private static zzhe zzfx() {
        try {
            return (zzhe) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzyt;
        }
    }
}
