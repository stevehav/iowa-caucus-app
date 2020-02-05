package com.google.android.gms.internal.measurement;

import com.adobe.xmp.options.PropertyOptions;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.common.primitives.Ints;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
public final class zzbr {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zza extends zzfd<zza, C0012zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzgw<zza> zzi;
        private int zzc;
        private int zzd;
        private zzi zze;
        private zzi zzf;
        private boolean zzg;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbr$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class C0012zza extends zzfd.zza<zza, C0012zza> implements zzgp {
            private C0012zza() {
                super(zza.zzh);
            }

            public final C0012zza zza(int i) {
                zzp();
                ((zza) this.zza).zza(i);
                return this;
            }

            public final zzi zza() {
                return ((zza) this.zza).zzc();
            }

            public final C0012zza zza(zzi.zza zza) {
                zzp();
                ((zza) this.zza).zza(zza);
                return this;
            }

            public final boolean zzb() {
                return ((zza) this.zza).zzd();
            }

            public final zzi zzc() {
                return ((zza) this.zza).zze();
            }

            public final C0012zza zza(zzi zzi) {
                zzp();
                ((zza) this.zza).zza(zzi);
                return this;
            }

            public final C0012zza zza(boolean z) {
                zzp();
                ((zza) this.zza).zza(z);
                return this;
            }

            /* synthetic */ C0012zza(zzbs zzbs) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final zzi zzc() {
            zzi zzi2 = this.zze;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi.zza zza) {
            this.zze = (zzi) ((zzfd) zza.zzu());
            this.zzc |= 2;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final zzi zze() {
            zzi zzi2 = this.zzf;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi2) {
            if (zzi2 != null) {
                this.zzf = zzi2;
                this.zzc |= 4;
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final boolean zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        public static C0012zza zzh() {
            return (C0012zza) zzh.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0012zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u0004\u0000\u0002\t\u0001\u0003\t\u0002\u0004\u0007\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
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
        public static final zzb zzf;
        private static volatile zzgw<zzb> zzg;
        private int zzc;
        private int zzd;
        private long zze;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzb, zza> implements zzgp {
            private zza() {
                super(zzb.zzf);
            }

            public final zza zza(int i) {
                zzp();
                ((zzb) this.zza).zza(i);
                return this;
            }

            public final zza zza(long j) {
                zzp();
                ((zzb) this.zza).zza(j);
                return this;
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final long zzd() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zze() {
            return (zza) zzf.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0004\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgw<zzb> zzgw = zzg;
                    if (zzgw == null) {
                        synchronized (zzb.class) {
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
            zzb zzb = new zzb();
            zzf = zzb;
            zzfd.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzc extends zzfd<zzc, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzc zzi;
        private static volatile zzgw<zzc> zzj;
        private int zzc;
        private zzfk<zze> zzd = zzbo();
        private String zze = "";
        private long zzf;
        private long zzg;
        private int zzh;

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzc, zza> implements zzgp {
            private zza() {
                super(zzc.zzi);
            }

            public final List<zze> zza() {
                return Collections.unmodifiableList(((zzc) this.zza).zza());
            }

            public final int zzb() {
                return ((zzc) this.zza).zzb();
            }

            public final zze zza(int i) {
                return ((zzc) this.zza).zza(i);
            }

            public final zza zza(int i, zze zze) {
                zzp();
                ((zzc) this.zza).zza(i, zze);
                return this;
            }

            public final zza zza(int i, zze.zza zza) {
                zzp();
                ((zzc) this.zza).zza(i, zza);
                return this;
            }

            public final zza zza(zze zze) {
                zzp();
                ((zzc) this.zza).zza(zze);
                return this;
            }

            public final zza zza(zze.zza zza) {
                zzp();
                ((zzc) this.zza).zza(zza);
                return this;
            }

            public final zza zzb(int i) {
                zzp();
                ((zzc) this.zza).zzb(i);
                return this;
            }

            public final String zzc() {
                return ((zzc) this.zza).zzc();
            }

            public final zza zza(String str) {
                zzp();
                ((zzc) this.zza).zza(str);
                return this;
            }

            public final boolean zzd() {
                return ((zzc) this.zza).zzd();
            }

            public final long zze() {
                return ((zzc) this.zza).zze();
            }

            public final zza zza(long j) {
                zzp();
                ((zzc) this.zza).zza(j);
                return this;
            }

            public final long zzf() {
                return ((zzc) this.zza).zzg();
            }

            public final zza zzb(long j) {
                zzp();
                ((zzc) this.zza).zzb(j);
                return this;
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }
        }

        public final List<zze> zza() {
            return this.zzd;
        }

        public final int zzb() {
            return this.zzd.size();
        }

        public final zze zza(int i) {
            return (zze) this.zzd.get(i);
        }

        private final void zzl() {
            if (!this.zzd.zza()) {
                this.zzd = zzfd.zza(this.zzd);
            }
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze zze2) {
            if (zze2 != null) {
                zzl();
                this.zzd.set(i, zze2);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze.zza zza2) {
            zzl();
            this.zzd.set(i, (zze) ((zzfd) zza2.zzu()));
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze2) {
            if (zze2 != null) {
                zzl();
                this.zzd.add(zze2);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zze.zza zza2) {
            zzl();
            this.zzd.add((zze) ((zzfd) zza2.zzu()));
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            zzl();
            this.zzd.remove(i);
        }

        public final String zzc() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 1;
                this.zze = str;
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzd() {
            return (this.zzc & 2) != 0;
        }

        public final long zze() {
            return this.zzf;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzf = j;
        }

        public final boolean zzf() {
            return (this.zzc & 4) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzg = j;
        }

        public final boolean zzh() {
            return (this.zzc & 8) != 0;
        }

        public final int zzi() {
            return this.zzh;
        }

        public static zzc zza(byte[] bArr, zzeq zzeq) throws zzfn {
            return (zzc) zzfd.zza(zzi, bArr, zzeq);
        }

        public static zza zzj() {
            return (zza) zzi.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002\b\u0000\u0003\u0002\u0001\u0004\u0002\u0002\u0005\u0004\u0003", new Object[]{"zzc", "zzd", zze.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgw<zzc> zzgw = zzj;
                    if (zzgw == null) {
                        synchronized (zzc.class) {
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
            zzc zzc2 = new zzc();
            zzi = zzc2;
            zzfd.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzd extends zzfd<zzd, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzd zzf;
        private static volatile zzgw<zzd> zzg;
        private int zzc;
        private String zzd = "";
        private long zze;

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzd, zza> implements zzgp {
            private zza() {
                super(zzd.zzf);
            }

            public final zza zza(String str) {
                zzp();
                ((zzd) this.zza).zza(str);
                return this;
            }

            public final zza zza(long j) {
                zzp();
                ((zzd) this.zza).zza(j);
                return this;
            }

            /* synthetic */ zza(zzbs zzbs) {
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
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zza() {
            return (zza) zzf.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\b\u0000\u0002\u0002\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgw<zzd> zzgw = zzg;
                    if (zzgw == null) {
                        synchronized (zzd.class) {
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
            zzd zzd2 = new zzd();
            zzf = zzd2;
            zzfd.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zze extends zzfd<zze, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zze zzi;
        private static volatile zzgw<zze> zzj;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private long zzf;
        private float zzg;
        private double zzh;

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zze, zza> implements zzgp {
            private zza() {
                super(zze.zzi);
            }

            public final zza zza(String str) {
                zzp();
                ((zze) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzp();
                ((zze) this.zza).zzb(str);
                return this;
            }

            public final zza zza() {
                zzp();
                ((zze) this.zza).zzj();
                return this;
            }

            public final zza zza(long j) {
                zzp();
                ((zze) this.zza).zza(j);
                return this;
            }

            public final zza zzb() {
                zzp();
                ((zze) this.zza).zzk();
                return this;
            }

            public final zza zza(double d) {
                zzp();
                ((zze) this.zza).zza(d);
                return this;
            }

            public final zza zzc() {
                zzp();
                ((zze) this.zza).zzl();
                return this;
            }

            /* synthetic */ zza(zzbs zzbs) {
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
            return (this.zzc & 2) != 0;
        }

        public final String zzc() {
            return this.zze;
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
        public final void zzj() {
            this.zzc &= -3;
            this.zze = zzi.zze;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final long zze() {
            return this.zzf;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        public final void zzk() {
            this.zzc &= -5;
            this.zzf = 0;
        }

        public final boolean zzf() {
            return (this.zzc & 16) != 0;
        }

        public final double zzg() {
            return this.zzh;
        }

        /* access modifiers changed from: private */
        public final void zza(double d) {
            this.zzc |= 16;
            this.zzh = d;
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc &= -17;
            this.zzh = 0.0d;
        }

        public static zza zzh() {
            return (zza) zzi.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\u0002\u0002\u0004\u0001\u0003\u0005\u0000\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzgw<zze> zzgw = zzj;
                    if (zzgw == null) {
                        synchronized (zze.class) {
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
            zze zze2 = new zze();
            zzi = zze2;
            zzfd.zza(zze.class, zze2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzf extends zzfd<zzf, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzf zzd;
        private static volatile zzgw<zzf> zze;
        private zzfk<zzg> zzc = zzbo();

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzf, zza> implements zzgp {
            private zza() {
                super(zzf.zzd);
            }

            public final zzg zza(int i) {
                return ((zzf) this.zza).zza(0);
            }

            public final zza zza(zzg.zza zza) {
                zzp();
                ((zzf) this.zza).zza(zza);
                return this;
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }
        }

        public final List<zzg> zza() {
            return this.zzc;
        }

        public final zzg zza(int i) {
            return (zzg) this.zzc.get(0);
        }

        /* access modifiers changed from: private */
        public final void zza(zzg.zza zza2) {
            if (!this.zzc.zza()) {
                this.zzc = zzfd.zza(this.zzc);
            }
            this.zzc.add((zzg) ((zzfd) zza2.zzu()));
        }

        public static zza zzb() {
            return (zza) zzd.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzg.class});
                case 4:
                    return zzd;
                case 5:
                    zzgw<zzf> zzgw = zze;
                    if (zzgw == null) {
                        synchronized (zzf.class) {
                            zzgw = zze;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzd);
                                zze = zzgw;
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
            zzf zzf = new zzf();
            zzd = zzf;
            zzfd.zza(zzf.class, zzf);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzg extends zzfd<zzg, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzg zzav;
        private static volatile zzgw<zzg> zzaw;
        private int zzaa;
        private String zzab = "";
        private String zzac = "";
        private boolean zzad;
        private zzfk<zza> zzae = zzbo();
        private String zzaf = "";
        private int zzag;
        private int zzah;
        private int zzai;
        private String zzaj = "";
        private long zzak;
        private long zzal;
        private String zzam = "";
        private String zzan = "";
        private int zzao;
        private String zzap = "";
        private zzh zzaq;
        private zzfi zzar = zzbm();
        private long zzas;
        private long zzat;
        private String zzau = "";
        private int zzc;
        private int zzd;
        private int zze;
        private zzfk<zzc> zzf = zzbo();
        private zzfk<zzk> zzg = zzbo();
        private long zzh;
        private long zzi;
        private long zzj;
        private long zzk;
        private long zzl;
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private int zzq;
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private long zzu;
        private long zzv;
        private String zzw = "";
        private boolean zzx;
        private String zzy = "";
        private long zzz;

        private zzg() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzg, zza> implements zzgp {
            private zza() {
                super(zzg.zzav);
            }

            public final zza zza(int i) {
                zzp();
                ((zzg) this.zza).zzd(1);
                return this;
            }

            public final List<zzc> zza() {
                return Collections.unmodifiableList(((zzg) this.zza).zzc());
            }

            public final int zzb() {
                return ((zzg) this.zza).zzd();
            }

            public final zzc zzb(int i) {
                return ((zzg) this.zza).zza(i);
            }

            public final zza zza(int i, zzc.zza zza) {
                zzp();
                ((zzg) this.zza).zza(i, zza);
                return this;
            }

            public final zza zza(zzc.zza zza) {
                zzp();
                ((zzg) this.zza).zza(zza);
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                zzp();
                ((zzg) this.zza).zza(iterable);
                return this;
            }

            public final zza zzc() {
                zzp();
                ((zzg) this.zza).zzbs();
                return this;
            }

            public final zza zzc(int i) {
                zzp();
                ((zzg) this.zza).zze(i);
                return this;
            }

            public final List<zzk> zzd() {
                return Collections.unmodifiableList(((zzg) this.zza).zze());
            }

            public final int zze() {
                return ((zzg) this.zza).zzf();
            }

            public final zzk zzd(int i) {
                return ((zzg) this.zza).zzb(i);
            }

            public final zza zza(int i, zzk zzk) {
                zzp();
                ((zzg) this.zza).zza(i, zzk);
                return this;
            }

            public final zza zza(zzk zzk) {
                zzp();
                ((zzg) this.zza).zza(zzk);
                return this;
            }

            public final zza zza(zzk.zza zza) {
                zzp();
                ((zzg) this.zza).zza(zza);
                return this;
            }

            public final zza zzb(Iterable<? extends zzk> iterable) {
                zzp();
                ((zzg) this.zza).zzb(iterable);
                return this;
            }

            public final zza zza(long j) {
                zzp();
                ((zzg) this.zza).zza(j);
                return this;
            }

            public final long zzf() {
                return ((zzg) this.zza).zzj();
            }

            public final zza zzb(long j) {
                zzp();
                ((zzg) this.zza).zzb(j);
                return this;
            }

            public final long zzg() {
                return ((zzg) this.zza).zzl();
            }

            public final zza zzc(long j) {
                zzp();
                ((zzg) this.zza).zzc(j);
                return this;
            }

            public final zza zzd(long j) {
                zzp();
                ((zzg) this.zza).zzd(j);
                return this;
            }

            public final zza zzh() {
                zzp();
                ((zzg) this.zza).zzbu();
                return this;
            }

            public final zza zze(long j) {
                zzp();
                ((zzg) this.zza).zze(j);
                return this;
            }

            public final zza zzi() {
                zzp();
                ((zzg) this.zza).zzbv();
                return this;
            }

            public final zza zza(String str) {
                zzp();
                ((zzg) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzp();
                ((zzg) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                zzp();
                ((zzg) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                zzp();
                ((zzg) this.zza).zzd(str);
                return this;
            }

            public final zza zze(int i) {
                zzp();
                ((zzg) this.zza).zzf(i);
                return this;
            }

            public final zza zze(String str) {
                zzp();
                ((zzg) this.zza).zze(str);
                return this;
            }

            public final String zzj() {
                return ((zzg) this.zza).zzx();
            }

            public final zza zzf(String str) {
                zzp();
                ((zzg) this.zza).zzf(str);
                return this;
            }

            public final zza zzg(String str) {
                zzp();
                ((zzg) this.zza).zzg(str);
                return this;
            }

            public final zza zzf(long j) {
                zzp();
                ((zzg) this.zza).zzf(j);
                return this;
            }

            public final zza zzg(long j) {
                zzp();
                ((zzg) this.zza).zzg(j);
                return this;
            }

            public final zza zzh(String str) {
                zzp();
                ((zzg) this.zza).zzh(str);
                return this;
            }

            public final zza zza(boolean z) {
                zzp();
                ((zzg) this.zza).zza(z);
                return this;
            }

            public final zza zzi(String str) {
                zzp();
                ((zzg) this.zza).zzi(str);
                return this;
            }

            public final zza zzh(long j) {
                zzp();
                ((zzg) this.zza).zzh(j);
                return this;
            }

            public final zza zzf(int i) {
                zzp();
                ((zzg) this.zza).zzg(i);
                return this;
            }

            public final zza zzj(String str) {
                zzp();
                ((zzg) this.zza).zzj(str);
                return this;
            }

            public final zza zzk() {
                zzp();
                ((zzg) this.zza).zzbw();
                return this;
            }

            public final String zzl() {
                return ((zzg) this.zza).zzam();
            }

            public final zza zzk(String str) {
                zzp();
                ((zzg) this.zza).zzk(str);
                return this;
            }

            public final zza zzb(boolean z) {
                zzp();
                ((zzg) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(Iterable<? extends zza> iterable) {
                zzp();
                ((zzg) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzm() {
                zzp();
                ((zzg) this.zza).zzbx();
                return this;
            }

            public final zza zzl(String str) {
                zzp();
                ((zzg) this.zza).zzl(str);
                return this;
            }

            public final zza zzg(int i) {
                zzp();
                ((zzg) this.zza).zzh(i);
                return this;
            }

            public final zza zzm(String str) {
                zzp();
                ((zzg) this.zza).zzm(str);
                return this;
            }

            public final zza zzi(long j) {
                zzp();
                ((zzg) this.zza).zzi(j);
                return this;
            }

            public final zza zzj(long j) {
                zzp();
                ((zzg) this.zza).zzj(j);
                return this;
            }

            public final zza zzn(String str) {
                zzp();
                ((zzg) this.zza).zzn((String) null);
                return this;
            }

            public final zza zzn() {
                zzp();
                ((zzg) this.zza).zzby();
                return this;
            }

            public final zza zzh(int i) {
                zzp();
                ((zzg) this.zza).zzi(i);
                return this;
            }

            public final zza zzo(String str) {
                zzp();
                ((zzg) this.zza).zzo(str);
                return this;
            }

            public final zza zza(zzh.zzb zzb) {
                zzp();
                ((zzg) this.zza).zza(zzb);
                return this;
            }

            public final zza zzd(Iterable<? extends Integer> iterable) {
                zzp();
                ((zzg) this.zza).zzd(iterable);
                return this;
            }

            public final zza zzk(long j) {
                zzp();
                ((zzg) this.zza).zzk(j);
                return this;
            }

            public final zza zzl(long j) {
                zzp();
                ((zzg) this.zza).zzl(j);
                return this;
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            this.zzc |= 1;
            this.zze = i;
        }

        public final List<zzc> zzc() {
            return this.zzf;
        }

        public final int zzd() {
            return this.zzf.size();
        }

        public final zzc zza(int i) {
            return (zzc) this.zzf.get(i);
        }

        private final void zzbr() {
            if (!this.zzf.zza()) {
                this.zzf = zzfd.zza(this.zzf);
            }
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc.zza zza2) {
            zzbr();
            this.zzf.set(i, (zzc) ((zzfd) zza2.zzu()));
        }

        /* access modifiers changed from: private */
        public final void zza(zzc.zza zza2) {
            zzbr();
            this.zzf.add((zzc) ((zzfd) zza2.zzu()));
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zzc> iterable) {
            zzbr();
            zzdl.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        public final void zzbs() {
            this.zzf = zzbo();
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzbr();
            this.zzf.remove(i);
        }

        public final List<zzk> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzg.size();
        }

        public final zzk zzb(int i) {
            return (zzk) this.zzg.get(i);
        }

        private final void zzbt() {
            if (!this.zzg.zza()) {
                this.zzg = zzfd.zza(this.zzg);
            }
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzk zzk2) {
            if (zzk2 != null) {
                zzbt();
                this.zzg.set(i, zzk2);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzk zzk2) {
            if (zzk2 != null) {
                zzbt();
                this.zzg.add(zzk2);
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzk.zza zza2) {
            zzbt();
            this.zzg.add((zzk) ((zzfd) zza2.zzu()));
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends zzk> iterable) {
            zzbt();
            zzdl.zza(iterable, this.zzg);
        }

        public final boolean zzg() {
            return (this.zzc & 2) != 0;
        }

        public final long zzh() {
            return this.zzh;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzh = j;
        }

        public final boolean zzi() {
            return (this.zzc & 4) != 0;
        }

        public final long zzj() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzi = j;
        }

        public final boolean zzk() {
            return (this.zzc & 8) != 0;
        }

        public final long zzl() {
            return this.zzj;
        }

        /* access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 8;
            this.zzj = j;
        }

        public final boolean zzm() {
            return (this.zzc & 16) != 0;
        }

        public final long zzn() {
            return this.zzk;
        }

        /* access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzc |= 16;
            this.zzk = j;
        }

        /* access modifiers changed from: private */
        public final void zzbu() {
            this.zzc &= -17;
            this.zzk = 0;
        }

        public final boolean zzo() {
            return (this.zzc & 32) != 0;
        }

        public final long zzp() {
            return this.zzl;
        }

        /* access modifiers changed from: private */
        public final void zze(long j) {
            this.zzc |= 32;
            this.zzl = j;
        }

        /* access modifiers changed from: private */
        public final void zzbv() {
            this.zzc &= -33;
            this.zzl = 0;
        }

        public final String zzq() {
            return this.zzm;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            if (str != null) {
                this.zzc |= 64;
                this.zzm = str;
                return;
            }
            throw new NullPointerException();
        }

        public final String zzr() {
            return this.zzn;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            if (str != null) {
                this.zzc |= 128;
                this.zzn = str;
                return;
            }
            throw new NullPointerException();
        }

        public final String zzs() {
            return this.zzo;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            if (str != null) {
                this.zzc |= 256;
                this.zzo = str;
                return;
            }
            throw new NullPointerException();
        }

        public final String zzt() {
            return this.zzp;
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            if (str != null) {
                this.zzc |= 512;
                this.zzp = str;
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzu() {
            return (this.zzc & 1024) != 0;
        }

        public final int g_() {
            return this.zzq;
        }

        /* access modifiers changed from: private */
        public final void zzf(int i) {
            this.zzc |= 1024;
            this.zzq = i;
        }

        public final String zzw() {
            return this.zzr;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            if (str != null) {
                this.zzc |= 2048;
                this.zzr = str;
                return;
            }
            throw new NullPointerException();
        }

        public final String zzx() {
            return this.zzs;
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            if (str != null) {
                this.zzc |= 4096;
                this.zzs = str;
                return;
            }
            throw new NullPointerException();
        }

        public final String zzy() {
            return this.zzt;
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            if (str != null) {
                this.zzc |= 8192;
                this.zzt = str;
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzz() {
            return (this.zzc & 16384) != 0;
        }

        public final long zzaa() {
            return this.zzu;
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzc |= 16384;
            this.zzu = j;
        }

        public final boolean zzab() {
            return (this.zzc & 32768) != 0;
        }

        public final long zzac() {
            return this.zzv;
        }

        /* access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzc |= 32768;
            this.zzv = j;
        }

        public final String zzad() {
            return this.zzw;
        }

        /* access modifiers changed from: private */
        public final void zzh(String str) {
            if (str != null) {
                this.zzc |= 65536;
                this.zzw = str;
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzae() {
            return (this.zzc & 131072) != 0;
        }

        public final boolean zzaf() {
            return this.zzx;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 131072;
            this.zzx = z;
        }

        public final String zzag() {
            return this.zzy;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            if (str != null) {
                this.zzc |= 262144;
                this.zzy = str;
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzah() {
            return (this.zzc & 524288) != 0;
        }

        public final long zzai() {
            return this.zzz;
        }

        /* access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzc |= 524288;
            this.zzz = j;
        }

        public final boolean zzaj() {
            return (this.zzc & 1048576) != 0;
        }

        public final int zzak() {
            return this.zzaa;
        }

        /* access modifiers changed from: private */
        public final void zzg(int i) {
            this.zzc |= 1048576;
            this.zzaa = i;
        }

        public final String zzal() {
            return this.zzab;
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            if (str != null) {
                this.zzc |= 2097152;
                this.zzab = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzbw() {
            this.zzc &= -2097153;
            this.zzab = zzav.zzab;
        }

        public final String zzam() {
            return this.zzac;
        }

        /* access modifiers changed from: private */
        public final void zzk(String str) {
            if (str != null) {
                this.zzc |= 4194304;
                this.zzac = str;
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzan() {
            return (this.zzc & 8388608) != 0;
        }

        public final boolean zzao() {
            return this.zzad;
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8388608;
            this.zzad = z;
        }

        public final List<zza> zzap() {
            return this.zzae;
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zza> iterable) {
            if (!this.zzae.zza()) {
                this.zzae = zzfd.zza(this.zzae);
            }
            zzdl.zza(iterable, this.zzae);
        }

        /* access modifiers changed from: private */
        public final void zzbx() {
            this.zzae = zzbo();
        }

        public final String zzaq() {
            return this.zzaf;
        }

        /* access modifiers changed from: private */
        public final void zzl(String str) {
            if (str != null) {
                this.zzc |= 16777216;
                this.zzaf = str;
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzar() {
            return (this.zzc & 33554432) != 0;
        }

        public final int zzas() {
            return this.zzag;
        }

        /* access modifiers changed from: private */
        public final void zzh(int i) {
            this.zzc |= 33554432;
            this.zzag = i;
        }

        public final String zzat() {
            return this.zzaj;
        }

        /* access modifiers changed from: private */
        public final void zzm(String str) {
            if (str != null) {
                this.zzc |= 268435456;
                this.zzaj = str;
                return;
            }
            throw new NullPointerException();
        }

        public final boolean zzau() {
            return (this.zzc & PropertyOptions.DELETE_EXISTING) != 0;
        }

        public final long zzav() {
            return this.zzak;
        }

        /* access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzc |= PropertyOptions.DELETE_EXISTING;
            this.zzak = j;
        }

        public final boolean zzaw() {
            return (this.zzc & Ints.MAX_POWER_OF_TWO) != 0;
        }

        public final long zzax() {
            return this.zzal;
        }

        /* access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzc |= Ints.MAX_POWER_OF_TWO;
            this.zzal = j;
        }

        public final String zzay() {
            return this.zzam;
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            if (str != null) {
                this.zzc |= Integer.MIN_VALUE;
                this.zzam = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zzby() {
            this.zzc &= Integer.MAX_VALUE;
            this.zzam = zzav.zzam;
        }

        public final boolean zzaz() {
            return (this.zzd & 2) != 0;
        }

        public final int zzba() {
            return this.zzao;
        }

        /* access modifiers changed from: private */
        public final void zzi(int i) {
            this.zzd |= 2;
            this.zzao = i;
        }

        public final String zzbb() {
            return this.zzap;
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            if (str != null) {
                this.zzd |= 4;
                this.zzap = str;
                return;
            }
            throw new NullPointerException();
        }

        /* access modifiers changed from: private */
        public final void zza(zzh.zzb zzb) {
            this.zzaq = (zzh) ((zzfd) zzb.zzu());
            this.zzd |= 8;
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends Integer> iterable) {
            if (!this.zzar.zza()) {
                zzfi zzfi = this.zzar;
                int size = zzfi.size();
                this.zzar = zzfi.zzb(size == 0 ? 10 : size << 1);
            }
            zzdl.zza(iterable, this.zzar);
        }

        public final boolean zzbc() {
            return (this.zzd & 16) != 0;
        }

        public final long zzbd() {
            return this.zzas;
        }

        /* access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzd |= 16;
            this.zzas = j;
        }

        /* access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzd |= 32;
            this.zzat = j;
        }

        public static zzg zza(byte[] bArr, zzeq zzeq) throws zzfn {
            return (zzg) zzfd.zza(zzav, bArr, zzeq);
        }

        public static zza zzbe() {
            return (zza) zzav.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzav, "\u0001+\u0000\u0002\u00012+\u0000\u0004\u0000\u0001\u0004\u0000\u0002\u001b\u0003\u001b\u0004\u0002\u0001\u0005\u0002\u0002\u0006\u0002\u0003\u0007\u0002\u0005\b\b\u0006\t\b\u0007\n\b\b\u000b\b\t\f\u0004\n\r\b\u000b\u000e\b\f\u0010\b\r\u0011\u0002\u000e\u0012\u0002\u000f\u0013\b\u0010\u0014\u0007\u0011\u0015\b\u0012\u0016\u0002\u0013\u0017\u0004\u0014\u0018\b\u0015\u0019\b\u0016\u001a\u0002\u0004\u001c\u0007\u0017\u001d\u001b\u001e\b\u0018\u001f\u0004\u0019 \u0004\u001a!\u0004\u001b\"\b\u001c#\u0002\u001d$\u0002\u001e%\b\u001f&\b '\u0004!)\b\",\t#-\u001d.\u0002$/\u0002%2\b&", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", zzk.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", zza.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau"});
                case 4:
                    return zzav;
                case 5:
                    zzgw<zzg> zzgw = zzaw;
                    if (zzgw == null) {
                        synchronized (zzg.class) {
                            zzgw = zzaw;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzav);
                                zzaw = zzgw;
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
            zzg zzg2 = new zzg();
            zzav = zzg2;
            zzfd.zza(zzg.class, zzg2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzh extends zzfd<zzh, zzb> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzh zzf;
        private static volatile zzgw<zzh> zzg;
        private int zzc;
        private int zzd = 1;
        private zzfk<zzd> zze = zzbo();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public enum zza implements zzfh {
            RADS(1),
            PROVISIONING(2);
            
            private static final zzfg<zza> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zza zza(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }

            public static zzfj zzb() {
                return zzbt.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + '>';
            }

            private zza(int i) {
                this.zzd = i;
            }

            static {
                zzc = new zzbu();
            }
        }

        private zzh() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zzb extends zzfd.zza<zzh, zzb> implements zzgp {
            private zzb() {
                super(zzh.zzf);
            }

            public final zzb zza(zzd.zza zza) {
                zzp();
                ((zzh) this.zza).zza(zza);
                return this;
            }

            /* synthetic */ zzb(zzbs zzbs) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzd.zza zza2) {
            if (!this.zze.zza()) {
                this.zze = zzfd.zza(this.zze);
            }
            this.zze.add((zzd) ((zzfd) zza2.zzu()));
        }

        public static zzb zza() {
            return (zzb) zzf.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb((zzbs) null);
                case 3:
                    return zza((zzgn) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zzd.class});
                case 4:
                    return zzf;
                case 5:
                    zzgw<zzh> zzgw = zzg;
                    if (zzgw == null) {
                        synchronized (zzh.class) {
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
            zzh zzh = new zzh();
            zzf = zzh;
            zzfd.zza(zzh.class, zzh);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzi extends zzfd<zzi, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzi zzg;
        private static volatile zzgw<zzi> zzh;
        private zzfl zzc = zzbn();
        private zzfl zzd = zzbn();
        private zzfk<zzb> zze = zzbo();
        private zzfk<zzj> zzf = zzbo();

        private zzi() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzi, zza> implements zzgp {
            private zza() {
                super(zzi.zzg);
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                zzp();
                ((zzi) this.zza).zza(iterable);
                return this;
            }

            public final zza zza() {
                zzp();
                ((zzi) this.zza).zzl();
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                zzp();
                ((zzi) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzb() {
                zzp();
                ((zzi) this.zza).zzm();
                return this;
            }

            public final zza zzc(Iterable<? extends zzb> iterable) {
                zzp();
                ((zzi) this.zza).zzc(iterable);
                return this;
            }

            public final zza zza(int i) {
                zzp();
                ((zzi) this.zza).zzd(i);
                return this;
            }

            public final zza zzd(Iterable<? extends zzj> iterable) {
                zzp();
                ((zzi) this.zza).zzd(iterable);
                return this;
            }

            public final zza zzb(int i) {
                zzp();
                ((zzi) this.zza).zze(i);
                return this;
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }
        }

        public final List<Long> zza() {
            return this.zzc;
        }

        public final int zzb() {
            return this.zzc.size();
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            if (!this.zzc.zza()) {
                this.zzc = zzfd.zza(this.zzc);
            }
            zzdl.zza(iterable, this.zzc);
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc = zzbn();
        }

        public final List<Long> zzc() {
            return this.zzd;
        }

        public final int zzd() {
            return this.zzd.size();
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends Long> iterable) {
            if (!this.zzd.zza()) {
                this.zzd = zzfd.zza(this.zzd);
            }
            zzdl.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzbn();
        }

        public final List<zzb> zze() {
            return this.zze;
        }

        public final int zzf() {
            return this.zze.size();
        }

        public final zzb zza(int i) {
            return (zzb) this.zze.get(i);
        }

        private final void zzn() {
            if (!this.zze.zza()) {
                this.zze = zzfd.zza(this.zze);
            }
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zzb> iterable) {
            zzn();
            zzdl.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            zzn();
            this.zze.remove(i);
        }

        public final List<zzj> zzg() {
            return this.zzf;
        }

        public final int zzh() {
            return this.zzf.size();
        }

        public final zzj zzb(int i) {
            return (zzj) this.zzf.get(i);
        }

        private final void zzo() {
            if (!this.zzf.zza()) {
                this.zzf = zzfd.zza(this.zzf);
            }
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends zzj> iterable) {
            zzo();
            zzdl.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzo();
            this.zzf.remove(i);
        }

        public static zzi zza(byte[] bArr, zzeq zzeq) throws zzfn {
            return (zzi) zzfd.zza(zzg, bArr, zzeq);
        }

        public static zza zzi() {
            return (zza) zzg.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", zzb.class, "zzf", zzj.class});
                case 4:
                    return zzg;
                case 5:
                    zzgw<zzi> zzgw = zzh;
                    if (zzgw == null) {
                        synchronized (zzi.class) {
                            zzgw = zzh;
                            if (zzgw == null) {
                                zzgw = new zzfd.zzc<>(zzg);
                                zzh = zzgw;
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

        public static zzi zzj() {
            return zzg;
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzfd.zza(zzi.class, zzi);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzj extends zzfd<zzj, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzj zzf;
        private static volatile zzgw<zzj> zzg;
        private int zzc;
        private int zzd;
        private zzfl zze = zzbn();

        private zzj() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzj, zza> implements zzgp {
            private zza() {
                super(zzj.zzf);
            }

            public final zza zza(int i) {
                zzp();
                ((zzj) this.zza).zzb(i);
                return this;
            }

            public final zza zza(long j) {
                zzp();
                ((zzj) this.zza).zza(j);
                return this;
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                zzp();
                ((zzj) this.zza).zza(iterable);
                return this;
            }

            public final zza zza() {
                zzp();
                ((zzj) this.zza).zzh();
                return this;
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final List<Long> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final long zza(int i) {
            return this.zze.zzb(i);
        }

        private final void zzg() {
            if (!this.zze.zza()) {
                this.zze = zzfd.zza(this.zze);
            }
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            zzg();
            this.zze.zza(j);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzg();
            zzdl.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        public final void zzh() {
            this.zze = zzbn();
        }

        public static zza zze() {
            return (zza) zzf.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0004\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzgw<zzj> zzgw = zzg;
                    if (zzgw == null) {
                        synchronized (zzj.class) {
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
            zzj zzj = new zzj();
            zzf = zzj;
            zzfd.zza(zzj.class, zzj);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    public static final class zzk extends zzfd<zzk, zza> implements zzgp {
        /* access modifiers changed from: private */
        public static final zzk zzj;
        private static volatile zzgw<zzk> zzk;
        private int zzc;
        private long zzd;
        private String zze = "";
        private String zzf = "";
        private long zzg;
        private float zzh;
        private double zzi;

        private zzk() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
        public static final class zza extends zzfd.zza<zzk, zza> implements zzgp {
            private zza() {
                super(zzk.zzj);
            }

            public final zza zza(long j) {
                zzp();
                ((zzk) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                zzp();
                ((zzk) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                zzp();
                ((zzk) this.zza).zzb(str);
                return this;
            }

            public final zza zza() {
                zzp();
                ((zzk) this.zza).zzl();
                return this;
            }

            public final zza zzb(long j) {
                zzp();
                ((zzk) this.zza).zzb(j);
                return this;
            }

            public final zza zzb() {
                zzp();
                ((zzk) this.zza).zzm();
                return this;
            }

            public final zza zza(double d) {
                zzp();
                ((zzk) this.zza).zza(d);
                return this;
            }

            public final zza zzc() {
                zzp();
                ((zzk) this.zza).zzn();
                return this;
            }

            /* synthetic */ zza(zzbs zzbs) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
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

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final String zze() {
            return this.zzf;
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
        public final void zzl() {
            this.zzc &= -5;
            this.zzf = zzj.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzc &= -9;
            this.zzg = 0;
        }

        public final boolean zzh() {
            return (this.zzc & 32) != 0;
        }

        public final double zzi() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zza(double d) {
            this.zzc |= 32;
            this.zzi = d;
        }

        /* access modifiers changed from: private */
        public final void zzn() {
            this.zzc &= -33;
            this.zzi = 0.0d;
        }

        public static zza zzj() {
            return (zza) zzj.zzbj();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbs.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzbs) null);
                case 3:
                    return zza((zzgn) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\u0002\u0000\u0002\b\u0001\u0003\b\u0002\u0004\u0002\u0003\u0005\u0001\u0004\u0006\u0000\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzgw<zzk> zzgw = zzk;
                    if (zzgw == null) {
                        synchronized (zzk.class) {
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
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzfd.zza(zzk.class, zzk2);
        }
    }
}
