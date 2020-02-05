package com.google.android.gms.internal.vision;

final class zzgw implements zzhe {
    private zzhe[] zzyu;

    zzgw(zzhe... zzheArr) {
        this.zzyu = zzheArr;
    }

    public final boolean zzb(Class<?> cls) {
        for (zzhe zzb : this.zzyu) {
            if (zzb.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzhd zzc(Class<?> cls) {
        for (zzhe zzhe : this.zzyu) {
            if (zzhe.zzb(cls)) {
                return zzhe.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
