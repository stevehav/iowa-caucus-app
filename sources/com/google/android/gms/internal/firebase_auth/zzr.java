package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzr extends zzhx<zzr, zza> implements zzji {
    /* access modifiers changed from: private */
    public static final zzr zzk;
    private static volatile zzjq<zzr> zzl;
    private int zzc;
    private int zzd = 0;
    private Object zze;
    private int zzf = 0;
    private Object zzg;
    private String zzh = "";
    private String zzi = "";
    private zzkp zzj;

    private zzr() {
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zza extends zzhx.zzb<zzr, zza> implements zzji {
        private zza() {
            super(zzr.zzk);
        }

        /* synthetic */ zza(zzs zzs) {
            this();
        }
    }

    public final String zza() {
        return this.zzd == 1 ? (String) this.zze : "";
    }

    public final String zzb() {
        return this.zzh;
    }

    public final String zzc() {
        return this.zzi;
    }

    public final zzkp zzd() {
        zzkp zzkp = this.zzj;
        return zzkp == null ? zzkp.zzb() : zzkp;
    }

    public final String zze() {
        return this.zzf == 5 ? (String) this.zzg : "";
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzs.zza[i - 1]) {
            case 1:
                return new zzr();
            case 2:
                return new zza((zzs) null);
            case 3:
                return zza((zzjg) zzk, "\u0001\u0005\u0002\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001;\u0000\u0002\b\u0001\u0003\b\u0002\u0004\t\u0003\u0005;\u0001", new Object[]{"zze", "zzd", "zzg", "zzf", "zzc", "zzh", "zzi", "zzj"});
            case 4:
                return zzk;
            case 5:
                zzjq<zzr> zzjq = zzl;
                if (zzjq == null) {
                    synchronized (zzr.class) {
                        zzjq = zzl;
                        if (zzjq == null) {
                            zzjq = new zzhx.zza<>(zzk);
                            zzl = zzjq;
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

    public static zzr zzf() {
        return zzk;
    }

    static {
        zzr zzr = new zzr();
        zzk = zzr;
        zzhx.zza(zzr.class, zzr);
    }
}
