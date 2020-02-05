package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzl extends zzhx<zzl, zza> implements zzji {
    /* access modifiers changed from: private */
    public static final zzl zzf;
    private static volatile zzjq<zzl> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    private zzl() {
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zza extends zzhx.zzb<zzl, zza> implements zzji {
        private zza() {
            super(zzl.zzf);
        }

        /* synthetic */ zza(zzn zzn) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzn.zza[i - 1]) {
            case 1:
                return new zzl();
            case 2:
                return new zza((zzn) null);
            case 3:
                return zza((zzjg) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                zzjq<zzl> zzjq = zzg;
                if (zzjq == null) {
                    synchronized (zzl.class) {
                        zzjq = zzg;
                        if (zzjq == null) {
                            zzjq = new zzhx.zza<>(zzf);
                            zzg = zzjq;
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

    static {
        zzl zzl = new zzl();
        zzf = zzl;
        zzhx.zza(zzl.class, zzl);
    }
}
