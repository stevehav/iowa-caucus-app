package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
public final class zzbj {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zza extends zzfd<zza, C0010zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zza zzi;
        private static volatile zzgw<zza> zzj;
        private int zzc;
        private int zzd;
        private zzfk<zze> zze = zzbo();
        private zzfk<zzb> zzf = zzbo();
        private boolean zzg;
        private boolean zzh;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbj$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class C0010zza extends zzfd.zza<zza, C0010zza> implements zzgp {
            private C0010zza() {
                super(zza.zzi);
            }

            public final int zza() {
                return ((zza) this.zza).zzd();
            }

            public final zze zza(int i) {
                return ((zza) this.zza).zza(i);
            }

            public final C0010zza zza(int i, zze.zza zza) {
                zzp();
                ((zza) this.zza).zza(i, zza);
                return this;
            }

            public final int zzb() {
                return ((zza) this.zza).zzf();
            }

            public final zzb zzb(int i) {
                return ((zza) this.zza).zzb(i);
            }

            public final C0010zza zza(int i, zzb.zza zza) {
                zzp();
                ((zza) this.zza).zza(i, zza);
                return this;
            }

            /* synthetic */ C0010zza(zzbk zzbk) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<zze> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final zze zza(int i) {
            return (zze) this.zze.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze.zza zza) {
            if (!this.zze.zza()) {
                this.zze = zzfd.zza(this.zze);
            }
            this.zze.set(i, (zze) ((zzfd) zza.zzu()));
        }

        public final List<zzb> zze() {
            return this.zzf;
        }

        public final int zzf() {
            return this.zzf.size();
        }

        public final zzb zzb(int i) {
            return (zzb) this.zzf.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzb.zza zza) {
            if (!this.zzf.zza()) {
                this.zzf = zzfd.zza(this.zzf);
            }
            this.zzf.set(i, (zzb) ((zzfd) zza.zzu()));
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0010zza((zzbk) null);
                case 3:
                    return zza((zzgn) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001\u0004\u0000\u0002\u001b\u0003\u001b\u0004\u0007\u0001\u0005\u0007\u0002", new Object[]{"zzc", "zzd", "zze", zze.class, "zzf", zzb.class, "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgw<zza> zzgw = zzj;
                    if (zzgw == null) {
                        synchronized (zza.class) {
                            zzgw = zzj;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzi);
                                zzj = zzgw;
                            }
                        }
                    }
                    return zzgw;
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
            zzi = zza;
            zzfd.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzb extends zzfd<zzb, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzb zzl;
        private static volatile zzgw<zzb> zzm;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzfk<zzc> zzf = zzbo();
        private boolean zzg;
        private zzd zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzb, zza> implements zzgp {
            private zza() {
                super(zzb.zzl);
            }

            public final String zza() {
                return ((zzb) this.zza).zzc();
            }

            public final zza zza(String str) {
                zzp();
                ((zzb) this.zza).zza(str);
                return this;
            }

            public final int zzb() {
                return ((zzb) this.zza).zze();
            }

            public final zzc zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zzc zzc) {
                zzp();
                ((zzb) this.zza).zza(i, zzc);
                return this;
            }

            /* synthetic */ zza(zzbk zzbk) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
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

        public final List<zzc> zzd() {
            return this.zzf;
        }

        public final int zze() {
            return this.zzf.size();
        }

        public final zzc zza(int i) {
            return (zzc) this.zzf.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            if (zzc2 != null) {
                if (!this.zzf.zza()) {
                    this.zzf = zzfd.zza(this.zzf);
                }
                this.zzf.set(i, zzc2);
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final zzd zzg() {
            zzd zzd2 = this.zzh;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public final boolean zzi() {
            return this.zzj;
        }

        public final boolean zzj() {
            return (this.zzc & 64) != 0;
        }

        public final boolean zzk() {
            return this.zzk;
        }

        public static zzb zza(byte[] bArr, zzeq zzeq) throws zzfn {
            return (zzb) zzfd.zza(zzl, bArr, zzeq);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbk) null);
                case 3:
                    return zza((zzgn) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\u001b\u0004\u0007\u0002\u0005\t\u0003\u0006\u0007\u0004\u0007\u0007\u0005\b\u0007\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzgw<zzb> zzgw = zzm;
                    if (zzgw == null) {
                        synchronized (zzb.class) {
                            zzgw = zzm;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzl);
                                zzm = zzgw;
                            }
                        }
                    }
                    return zzgw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzl = zzb;
            zzfd.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzc extends zzfd<zzc, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzc zzh;
        private static volatile zzgw<zzc> zzi;
        private int zzc;
        private zzf zzd;
        private zzd zze;
        private boolean zzf;
        private String zzg = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzc, zza> implements zzgp {
            private zza() {
                super(zzc.zzh);
            }

            public final zza zza(String str) {
                zzp();
                ((zzc) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzbk zzbk) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzf zzb() {
            zzf zzf2 = this.zzd;
            return zzf2 == null ? zzf.zzi() : zzf2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final zzd zzd() {
            zzd zzd2 = this.zze;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final String zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 8;
                this.zzg = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbk) null);
                case 3:
                    return zza((zzgn) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001\u0003\u0007\u0002\u0004\b\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgw<zzc> zzgw = zzi;
                    if (zzgw == null) {
                        synchronized (zzc.class) {
                            zzgw = zzi;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzh);
                                zzi = zzgw;
                            }
                        }
                    }
                    return zzgw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzc zzh() {
            return zzh;
        }

        static {
            zzc zzc2 = new zzc();
            zzh = zzc2;
            zzfd.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzd extends zzfd<zzd, zzb> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzd zzi;
        private static volatile zzgw<zzd> zzj;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public enum zza implements zzfh {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);
            
            private static final zzfg<zza> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i == 1) {
                    return LESS_THAN;
                }
                if (i == 2) {
                    return GREATER_THAN;
                }
                if (i == 3) {
                    return EQUAL;
                }
                if (i != 4) {
                    return null;
                }
                return BETWEEN;
            }

            public static zzfj zzb() {
                return zzbl.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + '>';
            }

            private zza(int i) {
                this.zzg = i;
            }

            static {
                zzf = new zzbm();
            }
        }

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zzb extends zzfd.zza<zzd, zzb> implements zzgp {
            private zzb() {
                super(zzd.zzi);
            }

            /* synthetic */ zzb(zzbk zzbk) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zza zzb() {
            zza zza2 = zza.zza(this.zzd);
            return zza2 == null ? zza.UNKNOWN_COMPARISON_TYPE : zza2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final boolean zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final String zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final String zzj() {
            return this.zzh;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb((zzbk) null);
                case 3:
                    return zza((zzgn) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\f\u0000\u0002\u0007\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgw<zzd> zzgw = zzj;
                    if (zzgw == null) {
                        synchronized (zzd.class) {
                            zzgw = zzj;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzi);
                                zzj = zzgw;
                            }
                        }
                    }
                    return zzgw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzd zzk() {
            return zzi;
        }

        static {
            zzd zzd2 = new zzd();
            zzi = zzd2;
            zzfd.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zze extends zzfd<zze, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zze zzj;
        private static volatile zzgw<zze> zzk;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzc zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zze, zza> implements zzgp {
            private zza() {
                super(zze.zzj);
            }

            public final zza zza(String str) {
                zzp();
                ((zze) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzbk zzbk) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
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

        public final zzc zzd() {
            zzc zzc2 = this.zzf;
            return zzc2 == null ? zzc.zzh() : zzc2;
        }

        public final boolean zze() {
            return this.zzg;
        }

        public final boolean zzf() {
            return this.zzh;
        }

        public final boolean zzg() {
            return (this.zzc & 32) != 0;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public static zze zza(byte[] bArr, zzeq zzeq) throws zzfn {
            return (zze) zzfd.zza(zzj, bArr, zzeq);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzbk) null);
                case 3:
                    return zza((zzgn) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0004\u0000\u0002\b\u0001\u0003\t\u0002\u0004\u0007\u0003\u0005\u0007\u0004\u0006\u0007\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgw<zze> zzgw = zzk;
                    if (zzgw == null) {
                        synchronized (zze.class) {
                            zzgw = zzk;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzj);
                                zzk = zzgw;
                            }
                        }
                    }
                    return zzgw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zze zze2 = new zze();
            zzj = zze2;
            zzfd.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzf extends zzfd<zzf, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzf zzh;
        private static volatile zzgw<zzf> zzi;
        private int zzc;
        private int zzd;
        private String zze = "";
        private boolean zzf;
        private zzfk<String> zzg = zzfd.zzbo();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public enum zzb implements zzfh {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);
            
            private static final zzfg<zzb> zzh = null;
            private final int zzi;

            public final int zza() {
                return this.zzi;
            }

            public static zzb zza(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            public static zzfj zzb() {
                return zzbp.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + '>';
            }

            private zzb(int i) {
                this.zzi = i;
            }

            static {
                zzh = new zzbn();
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzf, zza> implements zzgp {
            private zza() {
                super(zzf.zzh);
            }

            /* synthetic */ zza(zzbk zzbk) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzb zzb() {
            zzb zza2 = zzb.zza(this.zzd);
            return zza2 == null ? zzb.UNKNOWN_MATCH_TYPE : zza2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final List<String> zzg() {
            return this.zzg;
        }

        public final int zzh() {
            return this.zzg.size();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbk.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzbk) null);
                case 3:
                    return zza((zzgn) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\f\u0000\u0002\b\u0001\u0003\u0007\u0002\u0004\u001a", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgw<zzf> zzgw = zzi;
                    if (zzgw == null) {
                        synchronized (zzf.class) {
                            zzgw = zzi;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzh);
                                zzi = zzgw;
                            }
                        }
                    }
                    return zzgw;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzf zzi() {
            return zzh;
        }

        static {
            zzf zzf2 = new zzf();
            zzh = zzf2;
            zzfd.zza(zzf.class, zzf2);
        }
    }
}
