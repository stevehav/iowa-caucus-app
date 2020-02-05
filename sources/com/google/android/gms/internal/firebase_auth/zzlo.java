package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzlo {

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zza extends zzhx<zza, C0007zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzjq<zza> zzi;
        private String zzc = "";
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzlo$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class C0007zza extends zzhx.zzb<zza, C0007zza> implements zzji {
            private C0007zza() {
                super(zza.zzh);
            }

            public final C0007zza zza(String str) {
                zzb();
                ((zza) this.zza).zza(str);
                return this;
            }

            public final C0007zza zzb(String str) {
                zzb();
                ((zza) this.zza).zzb(str);
                return this;
            }

            /* synthetic */ C0007zza(zzln zzln) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        public static C0007zza zza() {
            return (C0007zza) zzh.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzln.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0007zza((zzln) null);
                case 3:
                    return zza((zzjg) zzh, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004Ȉ\u0005Ȉ", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjq<zza> zzjq = zzi;
                    if (zzjq == null) {
                        synchronized (zza.class) {
                            zzjq = zzi;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzh);
                                zzi = zzjq;
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
            zza zza = new zza();
            zzh = zza;
            zzhx.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzb extends zzhx<zzb, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzb zzj;
        private static volatile zzjq<zzb> zzk;
        private String zzc = "";
        private long zzd;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private long zzi;

        private zzb() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzb, zza> implements zzji {
            private zza() {
                super(zzb.zzj);
            }

            /* synthetic */ zza(zzln zzln) {
                this();
            }
        }

        public final String zza() {
            return this.zzc;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final String zzd() {
            return this.zzf;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzln.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzln) null);
                case 3:
                    return zza((zzjg) zzj, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0000\u0000\u0001Ȉ\u0002\u0002\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006Ȉ\u0007\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzjq<zzb> zzjq = zzk;
                    if (zzjq == null) {
                        synchronized (zzb.class) {
                            zzjq = zzk;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzj);
                                zzk = zzjq;
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

        public static zzjq<zzb> zze() {
            return (zzjq) zzj.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzb zzb = new zzb();
            zzj = zzb;
            zzhx.zza(zzb.class, zzb);
        }
    }
}
