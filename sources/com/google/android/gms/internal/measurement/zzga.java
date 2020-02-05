package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzga implements zzhf {
    private static final zzgk zzb = new zzgd();
    private final zzgk zza;

    public zzga() {
        this(new zzgc(zzfb.zza(), zza()));
    }

    private zzga(zzgk zzgk) {
        this.zza = (zzgk) zzfe.zza(zzgk, "messageInfoFactory");
    }

    public final <T> zzhc<T> zza(Class<T> cls) {
        zzhe.zza((Class<?>) cls);
        zzgl zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            if (zzfd.class.isAssignableFrom(cls)) {
                return zzgt.zza(zzhe.zzc(), zzeu.zza(), zzb2.zzc());
            }
            return zzgt.zza(zzhe.zza(), zzeu.zzb(), zzb2.zzc());
        } else if (zzfd.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzgr.zza(cls, zzb2, zzgx.zzb(), zzfx.zzb(), zzhe.zzc(), zzeu.zza(), zzgi.zzb());
            }
            return zzgr.zza(cls, zzb2, zzgx.zzb(), zzfx.zzb(), zzhe.zzc(), (zzes<?>) null, zzgi.zzb());
        } else if (zza(zzb2)) {
            return zzgr.zza(cls, zzb2, zzgx.zza(), zzfx.zza(), zzhe.zza(), zzeu.zzb(), zzgi.zza());
        } else {
            return zzgr.zza(cls, zzb2, zzgx.zza(), zzfx.zza(), zzhe.zzb(), (zzes<?>) null, zzgi.zza());
        }
    }

    private static boolean zza(zzgl zzgl) {
        return zzgl.zza() == zzfd.zzd.zzh;
    }

    private static zzgk zza() {
        try {
            return (zzgk) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }
}
