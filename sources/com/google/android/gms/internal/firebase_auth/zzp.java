package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzp {

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zza extends zzhx<zza, C0008zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zza zzs;
        private static volatile zzjq<zza> zzt;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private zzih<zzl> zzq = zzad();
        private String zzr = "";

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzp$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class C0008zza extends zzhx.zzb<zza, C0008zza> implements zzji {
            private C0008zza() {
                super(zza.zzs);
            }

            public final C0008zza zza(String str) {
                zzb();
                ((zza) this.zza).zza(str);
                return this;
            }

            public final C0008zza zzb(String str) {
                zzb();
                ((zza) this.zza).zzb(str);
                return this;
            }

            public final C0008zza zzc(String str) {
                zzb();
                ((zza) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ C0008zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 2;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 8192;
                this.zzr = str;
                return;
            }
            throw new NullPointerException();
        }

        public static C0008zza zza() {
            return (C0008zza) zzs.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0008zza((zzo) null);
                case 3:
                    return zza((zzjg) zzs, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0001\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\u001b\u000f\b\r", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzl.class, "zzr"});
                case 4:
                    return zzs;
                case 5:
                    zzjq<zza> zzjq = zzt;
                    if (zzjq == null) {
                        synchronized (zza.class) {
                            zzjq = zzt;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzs);
                                zzt = zzjq;
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
            zzs = zza;
            zzhx.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzb extends zzhx<zzb, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzb zzn;
        private static volatile zzjq<zzb> zzo;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private zzih<String> zzf = zzhx.zzad();
        private boolean zzg;
        private String zzh = "";
        private boolean zzi;
        private boolean zzj;
        private String zzk = "";
        private zzih<String> zzl = zzhx.zzad();
        private byte zzm = 2;

        private zzb() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzb, zza> implements zzji {
            private zza() {
                super(zzb.zzn);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final List<String> zzb() {
            return this.zzf;
        }

        public final int zzc() {
            return this.zzf.size();
        }

        public final boolean zzd() {
            return this.zzg;
        }

        public final String zze() {
            return this.zzh;
        }

        public final boolean zzf() {
            return this.zzi;
        }

        public final List<String> zzg() {
            return this.zzl;
        }

        public final int zzh() {
            return this.zzl.size();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzn, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\u001a\u0004\u0007\u0002\u0005\b\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\b\u0006\t\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
                case 4:
                    return zzn;
                case 5:
                    zzjq<zzb> zzjq = zzo;
                    if (zzjq == null) {
                        synchronized (zzb.class) {
                            zzjq = zzo;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzn);
                                zzo = zzjq;
                            }
                        }
                    }
                    return zzjq;
                case 6:
                    return Byte.valueOf(this.zzm);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzm = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjq<zzb> zzi() {
            return (zzjq) zzn.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzb zzb = new zzb();
            zzn = zzb;
            zzhx.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzc extends zzhx<zzc, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzc zzg;
        private static volatile zzjq<zzc> zzh;
        private int zzc;
        private String zzd = "";
        private long zze;
        private String zzf = "";

        private zzc() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzc, zza> implements zzji {
            private zza() {
                super(zzc.zzg);
            }

            public final zza zza(String str) {
                zzb();
                ((zzc) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 4;
                this.zzf = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzg.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzg, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001\u0003\b\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
                case 4:
                    return zzg;
                case 5:
                    zzjq<zzc> zzjq = zzh;
                    if (zzjq == null) {
                        synchronized (zzc.class) {
                            zzjq = zzh;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzg);
                                zzh = zzjq;
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
            zzc zzc2 = new zzc();
            zzg = zzc2;
            zzhx.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzd extends zzhx<zzd, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzd zzh;
        private static volatile zzjq<zzd> zzi;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";

        private zzd() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzd, zza> implements zzji {
            private zza() {
                super(zzd.zzh);
            }

            public final zza zza(String str) {
                zzb();
                ((zzd) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzd) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzb();
                ((zzd) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                zzb();
                ((zzd) this.zza).zzd(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 2;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 4;
                this.zzf = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            if (str != null) {
                this.zzc |= 8;
                this.zzg = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzh.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzh, "\u0001\u0004\u0000\u0001\u0001\u0006\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0006\b\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjq<zzd> zzjq = zzi;
                    if (zzjq == null) {
                        synchronized (zzd.class) {
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
            zzd zzd2 = new zzd();
            zzh = zzd2;
            zzhx.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zze extends zzhx<zze, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zze zzl;
        private static volatile zzjq<zze> zzm;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private long zzh;
        private String zzi = "";
        private boolean zzj;
        private byte zzk = 2;

        private zze() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zze, zza> implements zzji {
            private zza() {
                super(zze.zzl);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final long zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzi;
        }

        public final boolean zzf() {
            return this.zzj;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzl, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u0002\u0004\u0006\b\u0005\u0007\u0007\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzl;
                case 5:
                    zzjq<zze> zzjq = zzm;
                    if (zzjq == null) {
                        synchronized (zze.class) {
                            zzjq = zzm;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzl);
                                zzm = zzjq;
                            }
                        }
                    }
                    return zzjq;
                case 6:
                    return Byte.valueOf(this.zzk);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzk = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjq<zze> zzg() {
            return (zzjq) zzl.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zze zze2 = new zze();
            zzl = zze2;
            zzhx.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzf extends zzhx<zzf, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzf zzh;
        private static volatile zzjq<zzf> zzi;
        private int zzc;
        private String zzd = "";
        private zzih<String> zze = zzhx.zzad();
        private zzih<String> zzf = zzhx.zzad();
        private long zzg;

        private zzf() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzf, zza> implements zzji {
            private zza() {
                super(zzf.zzh);
            }

            public final zza zza(String str) {
                zzb();
                ((zzf) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzh.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001\b\u0000\u0002\u001a\u0003\u001a\u0004\u0002\u0001", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjq<zzf> zzjq = zzi;
                    if (zzjq == null) {
                        synchronized (zzf.class) {
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
            zzf zzf2 = new zzf();
            zzh = zzf2;
            zzhx.zza(zzf.class, zzf2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzg extends zzhx<zzg, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzg zzg;
        private static volatile zzjq<zzg> zzh;
        private int zzc;
        private String zzd = "";
        private zzih<zzz> zze = zzad();
        private byte zzf = 2;

        private zzg() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzg, zza> implements zzji {
            private zza() {
                super(zzg.zzg);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final int zza() {
            return this.zze.size();
        }

        public final zzz zza(int i) {
            return (zzz) this.zze.get(i);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", "zze", zzz.class});
                case 4:
                    return zzg;
                case 5:
                    zzjq<zzg> zzjq = zzh;
                    if (zzjq == null) {
                        synchronized (zzg.class) {
                            zzjq = zzh;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzg);
                                zzh = zzjq;
                            }
                        }
                    }
                    return zzjq;
                case 6:
                    return Byte.valueOf(this.zzf);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzf = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjq<zzg> zzb() {
            return (zzjq) zzg.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzg zzg2 = new zzg();
            zzg = zzg2;
            zzhx.zza(zzg.class, zzg2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzh extends zzhx<zzh, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzh zzu;
        private static volatile zzjq<zzh> zzv;
        private int zzc;
        private int zzd;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzn = "";
        private boolean zzo;
        private String zzp = "";
        private boolean zzq;
        private String zzr = "";
        private String zzs = "";
        private boolean zzt;

        private zzh() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzh, zza> implements zzji {
            private zza() {
                super(zzh.zzu);
            }

            public final zza zza(zzgd zzgd) {
                zzb();
                ((zzh) this.zza).zza(zzgd);
                return this;
            }

            public final zza zza(String str) {
                zzb();
                ((zzh) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzh) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzb();
                ((zzh) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                zzb();
                ((zzh) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                zzb();
                ((zzh) this.zza).zze(str);
                return this;
            }

            public final zza zzf(String str) {
                zzb();
                ((zzh) this.zza).zzf(str);
                return this;
            }

            public final zza zzg(String str) {
                zzb();
                ((zzh) this.zza).zzg(str);
                return this;
            }

            public final zza zza(boolean z) {
                zzb();
                ((zzh) this.zza).zza(z);
                return this;
            }

            public final zza zzh(String str) {
                zzb();
                ((zzh) this.zza).zzh(str);
                return this;
            }

            public final zza zzb(boolean z) {
                zzb();
                ((zzh) this.zza).zzb(z);
                return this;
            }

            public final zza zzi(String str) {
                zzb();
                ((zzh) this.zza).zzi(str);
                return this;
            }

            public final zza zzj(String str) {
                zzb();
                ((zzh) this.zza).zzj(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzgd zzgd) {
            if (zzgd != null) {
                this.zzc |= 1;
                this.zzd = zzgd.zza();
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 2;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 32;
                this.zzi = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 64;
                this.zzj = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            if (str != null) {
                this.zzc |= 128;
                this.zzk = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            if (str != null) {
                this.zzc |= 256;
                this.zzl = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            if (str != null) {
                this.zzc |= 512;
                this.zzm = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzc |= 1024;
                this.zzn = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 2048;
            this.zzo = z;
        }

        /* access modifiers changed from: private */
        public final void zzh(String str) {
            if (str != null) {
                this.zzc |= 4096;
                this.zzp = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8192;
            this.zzq = z;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzc |= 16384;
                this.zzr = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzc |= 32768;
                this.zzs = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzu.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzu, "\u0001\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0000\u0000\u0001\f\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\u0007\u000b\r\b\f\u000e\u0007\r\u000f\b\u000e\u0012\b\u000f\u0013\u0007\u0010", new Object[]{"zzc", "zzd", zzgd.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
                case 4:
                    return zzu;
                case 5:
                    zzjq<zzh> zzjq = zzv;
                    if (zzjq == null) {
                        synchronized (zzh.class) {
                            zzjq = zzv;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzu);
                                zzv = zzjq;
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
            zzh zzh2 = new zzh();
            zzu = zzh2;
            zzhx.zza(zzh.class, zzh2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzi extends zzhx<zzi, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzi zzi;
        private static volatile zzjq<zzi> zzj;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        private zzi() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzi, zza> implements zzji {
            private zza() {
                super(zzi.zzi);
            }

            public final zza zza(String str) {
                zzb();
                ((zzi) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzi) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzb();
                ((zzi) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 2;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 16;
                this.zzh = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzi.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzi, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0006\b\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjq<zzi> zzjq = zzj;
                    if (zzjq == null) {
                        synchronized (zzi.class) {
                            zzjq = zzj;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzi);
                                zzj = zzjq;
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
            zzi zzi2 = new zzi();
            zzi = zzi2;
            zzhx.zza(zzi.class, zzi2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzj extends zzhx<zzj, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzj zzj;
        private static volatile zzjq<zzj> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private int zzg;
        private zzr zzh;
        private byte zzi = 2;

        private zzj() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzj, zza> implements zzji {
            private zza() {
                super(zzj.zzj);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final zzgd zzc() {
            zzgd zza2 = zzgd.zza(this.zzg);
            return zza2 == null ? zzgd.OOB_REQ_TYPE_UNSPECIFIED : zza2;
        }

        public final boolean zzd() {
            return (this.zzc & 16) != 0;
        }

        public final zzr zze() {
            zzr zzr = this.zzh;
            return zzr == null ? zzr.zzf() : zzr;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\f\u0003\u0005\t\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzgd.zzb(), "zzh"});
                case 4:
                    return zzj;
                case 5:
                    zzjq<zzj> zzjq = zzk;
                    if (zzjq == null) {
                        synchronized (zzj.class) {
                            zzjq = zzk;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzj);
                                zzk = zzjq;
                            }
                        }
                    }
                    return zzjq;
                case 6:
                    return Byte.valueOf(this.zzi);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzi = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjq<zzj> zzf() {
            return (zzjq) zzj.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzj zzj2 = new zzj();
            zzj = zzj2;
            zzhx.zza(zzj.class, zzj2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzk extends zzhx<zzk, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzk zzi;
        private static volatile zzjq<zzk> zzj;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        private zzk() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzk, zza> implements zzji {
            private zza() {
                super(zzk.zzi);
            }

            public final zza zza(String str) {
                zzb();
                ((zzk) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzk) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzb();
                ((zzk) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 8;
                this.zzg = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 16;
                this.zzh = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzi.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjq<zzk> zzjq = zzj;
                    if (zzjq == null) {
                        synchronized (zzk.class) {
                            zzjq = zzj;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzi);
                                zzj = zzjq;
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
            zzk zzk = new zzk();
            zzi = zzk;
            zzhx.zza(zzk.class, zzk);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzl extends zzhx<zzl, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzl zze;
        private static volatile zzjq<zzl> zzf;
        private int zzc;
        private String zzd = "";

        private zzl() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzl, zza> implements zzji {
            private zza() {
                super(zzl.zze);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzl();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zze, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001\b\u0000", new Object[]{"zzc", "zzd"});
                case 4:
                    return zze;
                case 5:
                    zzjq<zzl> zzjq = zzf;
                    if (zzjq == null) {
                        synchronized (zzl.class) {
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

        public static zzjq<zzl> zzb() {
            return (zzjq) zze.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzl zzl = new zzl();
            zze = zzl;
            zzhx.zza(zzl.class, zzl);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzm extends zzhx<zzm, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzm zzaa;
        private static volatile zzjq<zzm> zzab;
        private static final zzie<Integer, zzv> zzu = new zzq();
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private zzih<String> zzi = zzhx.zzad();
        private String zzj = "";
        private boolean zzk;
        private boolean zzl;
        private String zzm = "";
        private String zzn = "";
        private zzkp zzo;
        private boolean zzp;
        private String zzq = "";
        private long zzr;
        private String zzs = "";
        private zzif zzt = zzac();
        private boolean zzv;
        private zzih<String> zzw = zzhx.zzad();
        private long zzx;
        private long zzy;
        private String zzz = "";

        private zzm() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzm, zza> implements zzji {
            private zza() {
                super(zzm.zzaa);
            }

            public final zza zza(String str) {
                zzb();
                ((zzm) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzm) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzb();
                ((zzm) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                zzb();
                ((zzm) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                zzb();
                ((zzm) this.zza).zze(str);
                return this;
            }

            public final zza zzf(String str) {
                zzb();
                ((zzm) this.zza).zzf(str);
                return this;
            }

            public final zza zza(Iterable<? extends zzv> iterable) {
                zzb();
                ((zzm) this.zza).zza(iterable);
                return this;
            }

            public final zza zza(boolean z) {
                zzb();
                ((zzm) this.zza).zza(z);
                return this;
            }

            public final zza zzb(Iterable<String> iterable) {
                zzb();
                ((zzm) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzg(String str) {
                zzb();
                ((zzm) this.zza).zzg(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 4;
                this.zzf = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 8;
                this.zzg = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            if (str != null) {
                this.zzc |= 16;
                this.zzh = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            if (str != null) {
                this.zzc |= 32;
                this.zzj = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            if (str != null) {
                this.zzc |= 16384;
                this.zzs = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zzv> iterable) {
            if (!this.zzt.zza()) {
                zzif zzif = this.zzt;
                int size = zzif.size();
                this.zzt = zzif.zzb(size == 0 ? 10 : size << 1);
            }
            for (zzv zza2 : iterable) {
                this.zzt.zzd(zza2.zza());
            }
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 32768;
            this.zzv = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<String> iterable) {
            if (!this.zzw.zza()) {
                zzih<String> zzih = this.zzw;
                int size = zzih.size();
                this.zzw = zzih.zza(size == 0 ? 10 : size << 1);
            }
            zzge.zza(iterable, this.zzw);
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzc |= 262144;
                this.zzz = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzaa.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzm();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzaa, "\u0001\u0016\u0000\u0001\u0002\u0019\u0016\u0000\u0003\u0000\u0002\b\u0000\u0003\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u001a\b\b\u0005\t\u0007\u0006\n\u0007\u0007\u000b\b\b\f\b\t\r\t\n\u000e\u0007\u000b\u000f\b\f\u0010\u0002\r\u0011\b\u000e\u0012\u001e\u0013\u0007\u000f\u0014\u001a\u0015\u0002\u0010\u0016\u0002\u0011\u0019\b\u0012", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", zzv.zzb(), "zzv", "zzw", "zzx", "zzy", "zzz"});
                case 4:
                    return zzaa;
                case 5:
                    zzjq<zzm> zzjq = zzab;
                    if (zzjq == null) {
                        synchronized (zzm.class) {
                            zzjq = zzab;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzaa);
                                zzab = zzjq;
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
            zzm zzm2 = new zzm();
            zzaa = zzm2;
            zzhx.zza(zzm.class, zzm2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzn extends zzhx<zzn, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzn zzr;
        private static volatile zzjq<zzn> zzs;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private zzih<String> zzh = zzhx.zzad();
        private String zzi = "";
        private zzih<zzu> zzj = zzad();
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private long zzn;
        private String zzo = "";
        private boolean zzp;
        private byte zzq = 2;

        private zzn() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzn, zza> implements zzji {
            private zza() {
                super(zzn.zzr);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        @Deprecated
        public final String zza() {
            return this.zzf;
        }

        @Deprecated
        public final String zzb() {
            return this.zzg;
        }

        public final String zzc() {
            return this.zzi;
        }

        @Deprecated
        public final List<zzu> zzd() {
            return this.zzj;
        }

        @Deprecated
        public final String zze() {
            return this.zzl;
        }

        public final String zzf() {
            return this.zzm;
        }

        public final long zzg() {
            return this.zzn;
        }

        public final String zzh() {
            return this.zzo;
        }

        public final boolean zzi() {
            return this.zzp;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzn();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzr, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0002\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\u001a\u0006\b\u0004\u0007\u001b\b\b\u0005\t\b\u0006\n\b\u0007\u000b\u0002\b\f\b\t\r\u0007\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzu.class, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
                case 4:
                    return zzr;
                case 5:
                    zzjq<zzn> zzjq = zzs;
                    if (zzjq == null) {
                        synchronized (zzn.class) {
                            zzjq = zzs;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzr);
                                zzs = zzjq;
                            }
                        }
                    }
                    return zzjq;
                case 6:
                    return Byte.valueOf(this.zzq);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzq = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjq<zzn> zzj() {
            return (zzjq) zzr.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzn zzn2 = new zzn();
            zzr = zzn2;
            zzhx.zza(zzn.class, zzn2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzo extends zzhx<zzo, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzo zzo;
        private static volatile zzjq<zzo> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private boolean zzk;
        private String zzl = "";
        private boolean zzm;
        private String zzn = "";

        private zzo() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzo, zza> implements zzji {
            private zza() {
                super(zzo.zzo);
            }

            public final zza zza(String str) {
                zzb();
                ((zzo) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzo) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzb();
                ((zzo) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 2;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 1024;
                this.zzn = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzo.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzo();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzo, "\u0001\u000b\u0000\u0001\u0001\r\u000b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0007\u0007\t\b\b\n\u0007\t\r\b\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzjq<zzo> zzjq = zzp;
                    if (zzjq == null) {
                        synchronized (zzo.class) {
                            zzjq = zzp;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzo);
                                zzp = zzjq;
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
            zzo zzo2 = new zzo();
            zzo = zzo2;
            zzhx.zza(zzo.class, zzo2);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase_auth.zzp$zzp  reason: collision with other inner class name */
    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class C0009zzp extends zzhx<C0009zzp, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final C0009zzp zzl;
        private static volatile zzjq<C0009zzp> zzm;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private long zzi;
        private String zzj = "";
        private byte zzk = 2;

        private C0009zzp() {
        }

        /* renamed from: com.google.android.gms.internal.firebase_auth.zzp$zzp$zza */
        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<C0009zzp, zza> implements zzji {
            private zza() {
                super(C0009zzp.zzl);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final String zzd() {
            return this.zzh;
        }

        public final long zze() {
            return this.zzi;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new C0009zzp();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzl, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0004\b\u0002\u0005\b\u0003\u0006\b\u0004\u0007\u0002\u0005\b\b\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
                case 4:
                    return zzl;
                case 5:
                    zzjq<C0009zzp> zzjq = zzm;
                    if (zzjq == null) {
                        synchronized (C0009zzp.class) {
                            zzjq = zzm;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzl);
                                zzm = zzjq;
                            }
                        }
                    }
                    return zzjq;
                case 6:
                    return Byte.valueOf(this.zzk);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzk = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjq<C0009zzp> zzf() {
            return (zzjq) zzl.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            C0009zzp zzp = new C0009zzp();
            zzl = zzp;
            zzhx.zza(C0009zzp.class, zzp);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzq extends zzhx<zzq, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzq zzq;
        private static volatile zzjq<zzq> zzr;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private boolean zzg;
        private String zzh = "";
        private String zzi = "";
        private long zzj;
        private String zzk = "";
        private boolean zzl;
        private boolean zzm;
        private boolean zzn = true;
        private String zzo = "";
        private String zzp = "";

        private zzq() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzq, zza> implements zzji {
            private zza() {
                super(zzq.zzq);
            }

            public final zza zza(String str) {
                zzb();
                ((zzq) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzq) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzb();
                ((zzq) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                zzb();
                ((zzq) this.zza).zzd(str);
                return this;
            }

            public final zza zza(boolean z) {
                zzb();
                ((zzq) this.zza).zza(z);
                return this;
            }

            public final zza zzb(boolean z) {
                zzb();
                ((zzq) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(boolean z) {
                zzb();
                ((zzq) this.zza).zzc(z);
                return this;
            }

            public final zza zze(String str) {
                zzb();
                ((zzq) this.zza).zze(str);
                return this;
            }

            public final zza zzf(String str) {
                zzb();
                ((zzq) this.zza).zzf(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 2;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 16;
                this.zzh = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            if (str != null) {
                this.zzc |= 128;
                this.zzk = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 256;
            this.zzl = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 512;
            this.zzm = z;
        }

        /* access modifiers changed from: private */
        public final void zzc(boolean z) {
            this.zzc |= 1024;
            this.zzn = z;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            if (str != null) {
                this.zzc |= 2048;
                this.zzo = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            if (str != null) {
                this.zzc |= 4096;
                this.zzp = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzq.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzq();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzq, "\u0001\r\u0000\u0001\u0001\u000f\r\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\u0002\u0006\b\b\u0007\t\u0007\b\n\u0007\t\u000b\u0007\n\r\b\u000b\u000f\b\f", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
                case 4:
                    return zzq;
                case 5:
                    zzjq<zzq> zzjq = zzr;
                    if (zzjq == null) {
                        synchronized (zzq.class) {
                            zzjq = zzr;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzq);
                                zzr = zzjq;
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
            zzq zzq2 = new zzq();
            zzq = zzq2;
            zzhx.zza(zzq.class, zzq2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzr extends zzhx<zzr, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzr zzav;
        private static volatile zzjq<zzr> zzaw;
        private zzih<String> zzaa = zzhx.zzad();
        private boolean zzab;
        private String zzac = "";
        private String zzad = "";
        private String zzae = "";
        private String zzaf = "";
        private long zzag;
        private String zzah = "";
        private boolean zzai;
        private String zzaj = "";
        private String zzak = "";
        private long zzal;
        private String zzam = "";
        private String zzan = "";
        private String zzao = "";
        private String zzap = "";
        private boolean zzaq;
        private String zzar = "";
        private String zzas = "";
        private String zzat = "";
        private zzih<zzr> zzau = zzad();
        private int zzc;
        private int zzd;
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private boolean zzh;
        private String zzi = "";
        private String zzj = "";
        private String zzk = "";
        private String zzl = "";
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private String zzq = "";
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private String zzu = "";
        private boolean zzv;
        private String zzw = "";
        private String zzx = "";
        private String zzy = "";
        private String zzz = "";

        private zzr() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzr, zza> implements zzji {
            private zza() {
                super(zzr.zzav);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zzf;
        }

        public final String zzb() {
            return this.zzg;
        }

        public final String zzc() {
            return this.zzo;
        }

        public final String zzd() {
            return this.zzu;
        }

        public final String zze() {
            return this.zzw;
        }

        public final String zzf() {
            return this.zzx;
        }

        public final boolean zzg() {
            return this.zzab;
        }

        public final String zzh() {
            return this.zzae;
        }

        public final boolean zzi() {
            return this.zzai;
        }

        public final String zzj() {
            return this.zzaj;
        }

        public final String zzk() {
            return this.zzak;
        }

        public final long zzl() {
            return this.zzal;
        }

        public final String zzm() {
            return this.zzam;
        }

        public final String zzn() {
            return this.zzao;
        }

        public final String zzo() {
            return this.zzap;
        }

        public final boolean zzp() {
            return this.zzaq;
        }

        public final String zzq() {
            return this.zzar;
        }

        public final String zzr() {
            return this.zzas;
        }

        public final String zzs() {
            return this.zzat;
        }

        public final List<zzr> zzt() {
            return this.zzau;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzr();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzav, "\u0001+\u0000\u0002\u0001-+\u0000\u0002\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0007\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\b\u0007\t\b\b\n\b\t\u000b\b\n\f\b\u000b\r\b\f\u000e\b\r\u000f\b\u000e\u0010\b\u000f\u0011\b\u0010\u0012\u0007\u0011\u0013\b\u0012\u0014\b\u0013\u0015\b\u0014\u0017\b\u0015\u0018\u001a\u0019\u0007\u0016\u001a\b\u0017\u001b\b\u0018\u001c\b\u0019\u001d\b\u001a\u001e\u0002\u001b\u001f\b\u001c \u0007\u001d!\b\u001e\"\b\u001f#\u0002 $\b!%\b\"&\b#'\b$(\u0007%*\b&+\b',\b(-\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", zzr.class});
                case 4:
                    return zzav;
                case 5:
                    zzjq<zzr> zzjq = zzaw;
                    if (zzjq == null) {
                        synchronized (zzr.class) {
                            zzjq = zzaw;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzav);
                                zzaw = zzjq;
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

        public static zzjq<zzr> zzu() {
            return (zzjq) zzav.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzr zzr2 = new zzr();
            zzav = zzr2;
            zzhx.zza(zzr.class, zzr2);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzs extends zzhx<zzs, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzs zzi;
        private static volatile zzjq<zzs> zzj;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private boolean zzf;
        private long zzg;
        private String zzh = "";

        private zzs() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzs, zza> implements zzji {
            private zza() {
                super(zzs.zzi);
            }

            public final zza zza(String str) {
                zzb();
                ((zzs) this.zza).zza(str);
                return this;
            }

            public final zza zza(boolean z) {
                zzb();
                ((zzs) this.zza).zza(true);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzs) this.zza).zzb(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 4;
            this.zzf = z;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 16;
                this.zzh = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzi.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzs();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u0002\u0003\u0005\b\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjq<zzs> zzjq = zzj;
                    if (zzjq == null) {
                        synchronized (zzs.class) {
                            zzjq = zzj;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzi);
                                zzj = zzjq;
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
            zzs zzs = new zzs();
            zzi = zzs;
            zzhx.zza(zzs.class, zzs);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzt extends zzhx<zzt, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzt zzj;
        private static volatile zzjq<zzt> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private long zzg;
        private boolean zzh;
        private byte zzi = 2;

        private zzt() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzt, zza> implements zzji {
            private zza() {
                super(zzt.zzj);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final long zzc() {
            return this.zzg;
        }

        public final boolean zzd() {
            return this.zzh;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzt();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzj;
                case 5:
                    zzjq<zzt> zzjq = zzk;
                    if (zzjq == null) {
                        synchronized (zzt.class) {
                            zzjq = zzk;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzj);
                                zzk = zzjq;
                            }
                        }
                    }
                    return zzjq;
                case 6:
                    return Byte.valueOf(this.zzi);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzi = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjq<zzt> zze() {
            return (zzjq) zzj.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzt zzt = new zzt();
            zzj = zzt;
            zzhx.zza(zzt.class, zzt);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzu extends zzhx<zzu, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzu zzo;
        private static volatile zzjq<zzu> zzp;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private String zzj = "";
        private long zzk;
        private String zzl = "";
        private boolean zzm;
        private String zzn = "";

        private zzu() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzu, zza> implements zzji {
            private zza() {
                super(zzu.zzo);
            }

            public final zza zza(String str) {
                zzb();
                ((zzu) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzu) this.zza).zzb(str);
                return this;
            }

            public final zza zza(boolean z) {
                zzb();
                ((zzu) this.zza).zza(z);
                return this;
            }

            public final zza zzc(String str) {
                zzb();
                ((zzu) this.zza).zzc(str);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 2;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 512;
            this.zzm = z;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 1024;
                this.zzn = str;
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzo.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzu();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzo, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\b\u0006\b\u0002\u0007\t\b\b\n\u0007\t\u000b\b\n", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn"});
                case 4:
                    return zzo;
                case 5:
                    zzjq<zzu> zzjq = zzp;
                    if (zzjq == null) {
                        synchronized (zzu.class) {
                            zzjq = zzp;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzo);
                                zzp = zzjq;
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
            zzo = zzu;
            zzhx.zza(zzu.class, zzu);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzv extends zzhx<zzv, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzv zzs;
        private static volatile zzjq<zzv> zzt;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private boolean zzi;
        private String zzj = "";
        private String zzk = "";
        private long zzl;
        private String zzm = "";
        private String zzn = "";
        private long zzo;
        private String zzp = "";
        private zzih<zzr> zzq = zzad();
        private byte zzr = 2;

        private zzv() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzv, zza> implements zzji {
            private zza() {
                super(zzv.zzs);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zze;
        }

        public final String zzb() {
            return this.zzf;
        }

        public final String zzc() {
            return this.zzg;
        }

        public final String zzd() {
            return this.zzh;
        }

        public final String zze() {
            return this.zzj;
        }

        public final String zzf() {
            return this.zzn;
        }

        public final long zzg() {
            return this.zzo;
        }

        public final String zzh() {
            return this.zzp;
        }

        public final List<zzr> zzi() {
            return this.zzq;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzv();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzs, "\u0001\u000e\u0000\u0001\u0001\u000f\u000e\u0000\u0001\u0001\u0001Ԉ\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\u0007\u0005\u0007\b\u0006\b\b\u0007\t\u0002\b\n\b\t\u000b\b\n\f\u0002\u000b\u000e\b\f\u000f\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzr.class});
                case 4:
                    return zzs;
                case 5:
                    zzjq<zzv> zzjq = zzt;
                    if (zzjq == null) {
                        synchronized (zzv.class) {
                            zzjq = zzt;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzs);
                                zzt = zzjq;
                            }
                        }
                    }
                    return zzjq;
                case 6:
                    return Byte.valueOf(this.zzr);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zzr = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzjq<zzv> zzj() {
            return (zzjq) zzs.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzv zzv = new zzv();
            zzs = zzv;
            zzhx.zza(zzv.class, zzv);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzw extends zzhx<zzw, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzw zzl;
        private static volatile zzjq<zzw> zzm;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";
        private String zzi = "";
        private int zzj;
        private String zzk = "";

        private zzw() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzw, zza> implements zzji {
            private zza() {
                super(zzw.zzl);
            }

            public final zza zza(String str) {
                zzb();
                ((zzw) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzb();
                ((zzw) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzb();
                ((zzw) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                zzb();
                ((zzw) this.zza).zzd(str);
                return this;
            }

            public final zza zze(String str) {
                zzb();
                ((zzw) this.zza).zze(str);
                return this;
            }

            public final zza zza(zzaa zzaa) {
                zzb();
                ((zzw) this.zza).zza(zzaa);
                return this;
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zzd = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 2;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 4;
                this.zzf = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            if (str != null) {
                this.zzc |= 8;
                this.zzg = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            if (str != null) {
                this.zzc |= 32;
                this.zzi = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzaa zzaa) {
            if (zzaa != null) {
                this.zzc |= 64;
                this.zzj = zzaa.zza();
                return;
            }
            throw new NullPointerException();
        }

        public static zza zza() {
            return (zza) zzl.zzz();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzw();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005\u0007\f\u0006\b\b\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzaa.zzb(), "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzjq<zzw> zzjq = zzm;
                    if (zzjq == null) {
                        synchronized (zzw.class) {
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
            zzw zzw = new zzw();
            zzl = zzw;
            zzhx.zza(zzw.class, zzw);
        }
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zzx extends zzhx<zzx, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzx zzn;
        private static volatile zzjq<zzx> zzo;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private long zzf;
        private String zzg = "";
        private boolean zzh;
        private String zzi = "";
        private String zzj = "";
        private long zzk;
        private String zzl = "";
        private long zzm;

        private zzx() {
        }

        /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
        public static final class zza extends zzhx.zzb<zzx, zza> implements zzji {
            private zza() {
                super(zzx.zzn);
            }

            /* synthetic */ zza(zzo zzo) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        public final long zzc() {
            return this.zzf;
        }

        public final String zzd() {
            return this.zzg;
        }

        public final boolean zze() {
            return this.zzh;
        }

        public final String zzf() {
            return this.zzi;
        }

        public final String zzg() {
            return this.zzj;
        }

        public final long zzh() {
            return this.zzk;
        }

        public final String zzi() {
            return this.zzl;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzo.zza[i - 1]) {
                case 1:
                    return new zzx();
                case 2:
                    return new zza((zzo) null);
                case 3:
                    return zza((zzjg) zzn, "\u0001\n\u0000\u0001\u0001\n\n\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\b\u0003\u0005\u0007\u0004\u0006\b\u0005\u0007\b\u0006\b\u0002\u0007\t\b\b\n\u0002\t", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
                case 4:
                    return zzn;
                case 5:
                    zzjq<zzx> zzjq = zzo;
                    if (zzjq == null) {
                        synchronized (zzx.class) {
                            zzjq = zzo;
                            if (zzjq == null) {
                                zzjq = new zzhx.zza<>(zzn);
                                zzo = zzjq;
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

        public static zzjq<zzx> zzj() {
            return (zzjq) zzn.zza(zzhx.zze.zzg, (Object) null, (Object) null);
        }

        static {
            zzx zzx = new zzx();
            zzn = zzx;
            zzhx.zza(zzx.class, zzx);
        }
    }
}
