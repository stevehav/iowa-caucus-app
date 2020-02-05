package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzix implements zzjz {
    private static final zzjh zzb = new zziw();
    private final zzjh zza;

    public zzix() {
        this(new zziz(zzhy.zza(), zza()));
    }

    private zzix(zzjh zzjh) {
        this.zza = (zzjh) zzib.zza(zzjh, "messageInfoFactory");
    }

    public final <T> zzjw<T> zza(Class<T> cls) {
        zzjy.zza((Class<?>) cls);
        zzje zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzhx.class.isAssignableFrom(cls)) {
                return zzjn.zza(zzjy.zzc(), zzhn.zza(), zzb2.zzc());
            }
            return zzjn.zza(zzjy.zza(), zzhn.zzb(), zzb2.zzc());
        } else if (zzhx.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzjk.zza(cls, zzb2, zzjr.zzb(), zziq.zzb(), zzjy.zzc(), zzhn.zza(), zzjf.zzb());
            }
            return zzjk.zza(cls, zzb2, zzjr.zzb(), zziq.zzb(), zzjy.zzc(), (zzhm<?>) null, zzjf.zzb());
        } else if (zza(zzb2)) {
            return zzjk.zza(cls, zzb2, zzjr.zza(), zziq.zza(), zzjy.zza(), zzhn.zzb(), zzjf.zza());
        } else {
            return zzjk.zza(cls, zzb2, zzjr.zza(), zziq.zza(), zzjy.zzb(), (zzhm<?>) null, zzjf.zza());
        }
    }

    private static boolean zza(zzje zzje) {
        return zzje.zza() == zzhx.zze.zzh;
    }

    private static zzjh zza() {
        try {
            return (zzjh) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
