package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzfd;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
public final class zzbo {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zza extends zzfd<zza, C0011zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzgw<zza> zzi;
        private int zzc;
        private String zzd = "";
        private boolean zze;
        private boolean zzf;
        private int zzg;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbo$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class C0011zza extends zzfd.zza<zza, C0011zza> implements zzgp {
            private C0011zza() {
                super(zza.zzh);
            }

            public final String zza() {
                return ((zza) this.zza).zza();
            }

            public final C0011zza zza(String str) {
                zzp();
                ((zza) this.zza).zza(str);
                return this;
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzb();
            }

            public final boolean zzc() {
                return ((zza) this.zza).zzc();
            }

            public final boolean zzd() {
                return ((zza) this.zza).zzd();
            }

            public final int zze() {
                return ((zza) this.zza).zze();
            }

            /* synthetic */ C0011zza(zzbq zzbq) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
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

        public final boolean zzb() {
            return this.zze;
        }

        public final boolean zzc() {
            return this.zzf;
        }

        public final boolean zzd() {
            return (this.zzc & 8) != 0;
        }

        public final int zze() {
            return this.zzg;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbq.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0011zza((zzbq) null);
                case 3:
                    return zza((zzgn) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\b\u0000\u0002\u0007\u0001\u0003\u0007\u0002\u0004\u0004\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzgw<zza> zzgw = zzi;
                    if (zzgw == null) {
                        synchronized (zza.class) {
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

        static {
            zza zza = new zza();
            zzh = zza;
            zzfd.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzb extends zzfd<zzb, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzb zzl;
        private static volatile zzgw<zzb> zzm;
        private int zzc;
        private long zzd;
        private String zze = "";
        private int zzf;
        private zzfk<zzc> zzg = zzbo();
        private zzfk<zza> zzh = zzbo();
        private zzfk<zzbj.zza> zzi = zzbo();
        private String zzj = "";
        private boolean zzk;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzb, zza> implements zzgp {
            private zza() {
                super(zzb.zzl);
            }

            public final int zza() {
                return ((zzb) this.zza).zze();
            }

            public final zza zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zza.C0011zza zza) {
                zzp();
                ((zzb) this.zza).zza(i, zza);
                return this;
            }

            public final List<zzbj.zza> zzb() {
                return Collections.unmodifiableList(((zzb) this.zza).zzf());
            }

            public final zza zzc() {
                zzp();
                ((zzb) this.zza).zzj();
                return this;
            }

            /* synthetic */ zza(zzbq zzbq) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        public final List<zzc> zzd() {
            return this.zzg;
        }

        public final int zze() {
            return this.zzh.size();
        }

        public final zza zza(int i) {
            return (zza) this.zzh.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zza.C0011zza zza2) {
            if (!this.zzh.zza()) {
                this.zzh = zzfd.zza(this.zzh);
            }
            this.zzh.set(i, (zza) ((zzfd) zza2.zzu()));
        }

        public final List<zzbj.zza> zzf() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zzj() {
            this.zzi = zzbo();
        }

        public final boolean zzg() {
            return this.zzk;
        }

        public static zzb zza(byte[] bArr, zzeq zzeq) throws zzfn {
            return (zzb) zzfd.zza(zzl, bArr, zzeq);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbq.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbq) null);
                case 3:
                    return zza((zzgn) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\u0004\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007\b\u0003\b\u0007\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzc.class, "zzh", zza.class, "zzi", zzbj.zza.class, "zzj", "zzk"});
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

        public static zzb zzh() {
            return zzl;
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
        public static final zzc zzf;
        private static volatile zzgw<zzc> zzg;
        private int zzc;
        private String zzd = "";
        private String zze = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzc, zza> implements zzgp {
            private zza() {
                super(zzc.zzf);
            }

            /* synthetic */ zza(zzbq zzbq) {
                this();
            }
        }

        public final String zza() {
            return this.zzd;
        }

        public final String zzb() {
            return this.zze;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbq.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbq) null);
                case 3:
                    return zza((zzgn) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgw<zzc> zzgw = zzg;
                    if (zzgw == null) {
                        synchronized (zzc.class) {
                            zzgw = zzg;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzf);
                                zzg = zzgw;
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
            zzc zzc2 = new zzc();
            zzf = zzc2;
            zzfd.zza(zzc.class, zzc2);
        }
    }
}
