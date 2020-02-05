package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzu extends zzhx<zzu, zza> implements zzji {
    /* access modifiers changed from: private */
    public static final zzu zzl;
    private static volatile zzjq<zzu> zzm;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    private zzu() {
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zza extends zzhx.zzb<zzu, zza> implements zzji {
        private zza() {
            super(zzu.zzl);
        }

        /* synthetic */ zza(zzt zzt) {
            this();
        }
    }

    public final String zza() {
        return this.zzd;
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzh;
    }

    public final String zzf() {
        return this.zzk;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzt.zza[i - 1]) {
            case 1:
                return new zzu();
            case 2:
                return new zza((zzt) null);
            case 3:
                return zza((zzjg) zzl, "\u0001\b\u0000\u0001\u0001\t\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\t\b\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                zzjq<zzu> zzjq = zzm;
                if (zzjq == null) {
                    synchronized (zzu.class) {
                        zzjq = zzm;
                        if (zzjq == null) {
                            zzjq = new zzhx.zza<>(zzl);
                            zzm = zzjq;
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
        zzu zzu = new zzu();
        zzl = zzu;
        zzhx.zza(zzu.class, zzu);
    }
}
