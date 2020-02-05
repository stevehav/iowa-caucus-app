package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzkp extends zzhx<zzkp, zza> implements zzji {
    /* access modifiers changed from: private */
    public static final zzkp zze;
    private static volatile zzjq<zzkp> zzf;
    private long zzc;
    private int zzd;

    private zzkp() {
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zza extends zzhx.zzb<zzkp, zza> implements zzji {
        private zza() {
            super(zzkp.zze);
        }

        /* synthetic */ zza(zzko zzko) {
            this();
        }
    }

    public final long zza() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzko.zza[i - 1]) {
            case 1:
                return new zzkp();
            case 2:
                return new zza((zzko) null);
            case 3:
                return zza((zzjg) zze, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzc", "zzd"});
            case 4:
                return zze;
            case 5:
                zzjq<zzkp> zzjq = zzf;
                if (zzjq == null) {
                    synchronized (zzkp.class) {
                        zzjq = zzf;
                        if (zzjq == null) {
                            zzjq = new zzhx.zza<>(zze);
                            zzf = zzjq;
                        }
                    }
                }
                return zzjq;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static zzkp zzb() {
        return zze;
    }

    static {
        zzkp zzkp = new zzkp();
        zze = zzkp;
        zzhx.zza(zzkp.class, zzkp);
    }
}
