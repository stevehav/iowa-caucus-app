package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.List;

final class zzfc implements zzhv {
    private int tag;
    private int zzru;
    private final zzez zzsp;
    private int zzsq = 0;

    public static zzfc zza(zzez zzez) {
        if (zzez.zzsi != null) {
            return zzez.zzsi;
        }
        return new zzfc(zzez);
    }

    private zzfc(zzez zzez) {
        this.zzsp = (zzez) zzga.zza(zzez, "input");
        this.zzsp.zzsi = this;
    }

    public final int zzcn() throws IOException {
        int i = this.zzsq;
        if (i != 0) {
            this.tag = i;
            this.zzsq = 0;
        } else {
            this.tag = this.zzsp.zzdq();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzru) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final int getTag() {
        return this.tag;
    }

    public final boolean zzco() throws IOException {
        int i;
        if (this.zzsp.zzcm() || (i = this.tag) == this.zzru) {
            return false;
        }
        return this.zzsp.zzal(i);
    }

    private final void zzab(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzgf.zzfm();
        }
    }

    public final double readDouble() throws IOException {
        zzab(1);
        return this.zzsp.readDouble();
    }

    public final float readFloat() throws IOException {
        zzab(5);
        return this.zzsp.readFloat();
    }

    public final long zzcp() throws IOException {
        zzab(0);
        return this.zzsp.zzcp();
    }

    public final long zzcq() throws IOException {
        zzab(0);
        return this.zzsp.zzcq();
    }

    public final int zzcr() throws IOException {
        zzab(0);
        return this.zzsp.zzcr();
    }

    public final long zzcs() throws IOException {
        zzab(1);
        return this.zzsp.zzcs();
    }

    public final int zzct() throws IOException {
        zzab(5);
        return this.zzsp.zzct();
    }

    public final boolean zzcu() throws IOException {
        zzab(0);
        return this.zzsp.zzcu();
    }

    public final String readString() throws IOException {
        zzab(2);
        return this.zzsp.readString();
    }

    public final String zzcv() throws IOException {
        zzab(2);
        return this.zzsp.zzcv();
    }

    public final <T> T zza(Class<T> cls, zzfk zzfk) throws IOException {
        zzab(2);
        return zzb(zzhs.zzgl().zzf(cls), zzfk);
    }

    public final <T> T zza(zzhw<T> zzhw, zzfk zzfk) throws IOException {
        zzab(2);
        return zzb(zzhw, zzfk);
    }

    public final <T> T zzb(Class<T> cls, zzfk zzfk) throws IOException {
        zzab(3);
        return zzd(zzhs.zzgl().zzf(cls), zzfk);
    }

    public final <T> T zzc(zzhw<T> zzhw, zzfk zzfk) throws IOException {
        zzab(3);
        return zzd(zzhw, zzfk);
    }

    private final <T> T zzb(zzhw<T> zzhw, zzfk zzfk) throws IOException {
        int zzcx = this.zzsp.zzcx();
        if (this.zzsp.zzsf < this.zzsp.zzsg) {
            int zzan = this.zzsp.zzan(zzcx);
            T newInstance = zzhw.newInstance();
            this.zzsp.zzsf++;
            zzhw.zza(newInstance, this, zzfk);
            zzhw.zze(newInstance);
            this.zzsp.zzak(0);
            zzez zzez = this.zzsp;
            zzez.zzsf--;
            this.zzsp.zzao(zzan);
            return newInstance;
        }
        throw zzgf.zzfn();
    }

    private final <T> T zzd(zzhw<T> zzhw, zzfk zzfk) throws IOException {
        int i = this.zzru;
        this.zzru = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzhw.newInstance();
            zzhw.zza(newInstance, this, zzfk);
            zzhw.zze(newInstance);
            if (this.tag == this.zzru) {
                return newInstance;
            }
            throw zzgf.zzfo();
        } finally {
            this.zzru = i;
        }
    }

    public final zzeo zzcw() throws IOException {
        zzab(2);
        return this.zzsp.zzcw();
    }

    public final int zzcx() throws IOException {
        zzab(0);
        return this.zzsp.zzcx();
    }

    public final int zzcy() throws IOException {
        zzab(0);
        return this.zzsp.zzcy();
    }

    public final int zzcz() throws IOException {
        zzab(5);
        return this.zzsp.zzcz();
    }

    public final long zzda() throws IOException {
        zzab(1);
        return this.zzsp.zzda();
    }

    public final int zzdb() throws IOException {
        zzab(0);
        return this.zzsp.zzdb();
    }

    public final long zzdc() throws IOException {
        zzab(0);
        return this.zzsp.zzdc();
    }

    public final void zza(List<Double> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzfh) {
            zzfh zzfh = (zzfh) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzfh.zzc(this.zzsp.readDouble());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzcx = this.zzsp.zzcx();
                zzac(zzcx);
                int zzds = this.zzsp.zzds() + zzcx;
                do {
                    zzfh.zzc(this.zzsp.readDouble());
                } while (this.zzsp.zzds() < zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzsp.readDouble()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzcx2 = this.zzsp.zzcx();
                zzac(zzcx2);
                int zzds2 = this.zzsp.zzds() + zzcx2;
                do {
                    list.add(Double.valueOf(this.zzsp.readDouble()));
                } while (this.zzsp.zzds() < zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzb(List<Float> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzfv) {
            zzfv zzfv = (zzfv) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzcx = this.zzsp.zzcx();
                zzad(zzcx);
                int zzds = this.zzsp.zzds() + zzcx;
                do {
                    zzfv.zzh(this.zzsp.readFloat());
                } while (this.zzsp.zzds() < zzds);
            } else if (i == 5) {
                do {
                    zzfv.zzh(this.zzsp.readFloat());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzcx2 = this.zzsp.zzcx();
                zzad(zzcx2);
                int zzds2 = this.zzsp.zzds() + zzcx2;
                do {
                    list.add(Float.valueOf(this.zzsp.readFloat()));
                } while (this.zzsp.zzds() < zzds2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzsp.readFloat()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzc(List<Long> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgt.zzp(this.zzsp.zzcp());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzds = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    zzgt.zzp(this.zzsp.zzcp());
                } while (this.zzsp.zzds() < zzds);
                zzae(zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzcp()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzds2 = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    list.add(Long.valueOf(this.zzsp.zzcp()));
                } while (this.zzsp.zzds() < zzds2);
                zzae(zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzd(List<Long> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgt.zzp(this.zzsp.zzcq());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzds = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    zzgt.zzp(this.zzsp.zzcq());
                } while (this.zzsp.zzds() < zzds);
                zzae(zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzcq()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzds2 = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    list.add(Long.valueOf(this.zzsp.zzcq()));
                } while (this.zzsp.zzds() < zzds2);
                zzae(zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zze(List<Integer> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfz.zzbg(this.zzsp.zzcr());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzds = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    zzfz.zzbg(this.zzsp.zzcr());
                } while (this.zzsp.zzds() < zzds);
                zzae(zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzcr()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzds2 = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzcr()));
                } while (this.zzsp.zzds() < zzds2);
                zzae(zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzf(List<Long> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzgt.zzp(this.zzsp.zzcs());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzcx = this.zzsp.zzcx();
                zzac(zzcx);
                int zzds = this.zzsp.zzds() + zzcx;
                do {
                    zzgt.zzp(this.zzsp.zzcs());
                } while (this.zzsp.zzds() < zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzcs()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzcx2 = this.zzsp.zzcx();
                zzac(zzcx2);
                int zzds2 = this.zzsp.zzds() + zzcx2;
                do {
                    list.add(Long.valueOf(this.zzsp.zzcs()));
                } while (this.zzsp.zzds() < zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzg(List<Integer> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzcx = this.zzsp.zzcx();
                zzad(zzcx);
                int zzds = this.zzsp.zzds() + zzcx;
                do {
                    zzfz.zzbg(this.zzsp.zzct());
                } while (this.zzsp.zzds() < zzds);
            } else if (i == 5) {
                do {
                    zzfz.zzbg(this.zzsp.zzct());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzcx2 = this.zzsp.zzcx();
                zzad(zzcx2);
                int zzds2 = this.zzsp.zzds() + zzcx2;
                do {
                    list.add(Integer.valueOf(this.zzsp.zzct()));
                } while (this.zzsp.zzds() < zzds2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzct()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzem) {
            zzem zzem = (zzem) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzem.addBoolean(this.zzsp.zzcu());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzds = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    zzem.addBoolean(this.zzsp.zzcu());
                } while (this.zzsp.zzds() < zzds);
                zzae(zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzsp.zzcu()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzds2 = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    list.add(Boolean.valueOf(this.zzsp.zzcu()));
                } while (this.zzsp.zzds() < zzds2);
                zzae(zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzdq;
        int zzdq2;
        if ((this.tag & 7) != 2) {
            throw zzgf.zzfm();
        } else if (!(list instanceof zzgo) || z) {
            do {
                list.add(z ? zzcv() : readString());
                if (!this.zzsp.zzcm()) {
                    zzdq = this.zzsp.zzdq();
                } else {
                    return;
                }
            } while (zzdq == this.tag);
            this.zzsq = zzdq;
        } else {
            zzgo zzgo = (zzgo) list;
            do {
                zzgo.zzc(zzcw());
                if (!this.zzsp.zzcm()) {
                    zzdq2 = this.zzsp.zzdq();
                } else {
                    return;
                }
            } while (zzdq2 == this.tag);
            this.zzsq = zzdq2;
        }
    }

    public final <T> void zza(List<T> list, zzhw<T> zzhw, zzfk zzfk) throws IOException {
        int zzdq;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzb(zzhw, zzfk));
                if (!this.zzsp.zzcm() && this.zzsq == 0) {
                    zzdq = this.zzsp.zzdq();
                } else {
                    return;
                }
            } while (zzdq == i);
            this.zzsq = zzdq;
            return;
        }
        throw zzgf.zzfm();
    }

    public final <T> void zzb(List<T> list, zzhw<T> zzhw, zzfk zzfk) throws IOException {
        int zzdq;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzhw, zzfk));
                if (!this.zzsp.zzcm() && this.zzsq == 0) {
                    zzdq = this.zzsp.zzdq();
                } else {
                    return;
                }
            } while (zzdq == i);
            this.zzsq = zzdq;
            return;
        }
        throw zzgf.zzfm();
    }

    public final void zzj(List<zzeo> list) throws IOException {
        int zzdq;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzcw());
                if (!this.zzsp.zzcm()) {
                    zzdq = this.zzsp.zzdq();
                } else {
                    return;
                }
            } while (zzdq == this.tag);
            this.zzsq = zzdq;
            return;
        }
        throw zzgf.zzfm();
    }

    public final void zzk(List<Integer> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfz.zzbg(this.zzsp.zzcx());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzds = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    zzfz.zzbg(this.zzsp.zzcx());
                } while (this.zzsp.zzds() < zzds);
                zzae(zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzcx()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzds2 = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzcx()));
                } while (this.zzsp.zzds() < zzds2);
                zzae(zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfz.zzbg(this.zzsp.zzcy());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzds = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    zzfz.zzbg(this.zzsp.zzcy());
                } while (this.zzsp.zzds() < zzds);
                zzae(zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzcy()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzds2 = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzcy()));
                } while (this.zzsp.zzds() < zzds2);
                zzae(zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzcx = this.zzsp.zzcx();
                zzad(zzcx);
                int zzds = this.zzsp.zzds() + zzcx;
                do {
                    zzfz.zzbg(this.zzsp.zzcz());
                } while (this.zzsp.zzds() < zzds);
            } else if (i == 5) {
                do {
                    zzfz.zzbg(this.zzsp.zzcz());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzcx2 = this.zzsp.zzcx();
                zzad(zzcx2);
                int zzds2 = this.zzsp.zzds() + zzcx2;
                do {
                    list.add(Integer.valueOf(this.zzsp.zzcz()));
                } while (this.zzsp.zzds() < zzds2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzcz()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzn(List<Long> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzgt.zzp(this.zzsp.zzda());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzcx = this.zzsp.zzcx();
                zzac(zzcx);
                int zzds = this.zzsp.zzds() + zzcx;
                do {
                    zzgt.zzp(this.zzsp.zzda());
                } while (this.zzsp.zzds() < zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzda()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzcx2 = this.zzsp.zzcx();
                zzac(zzcx2);
                int zzds2 = this.zzsp.zzds() + zzcx2;
                do {
                    list.add(Long.valueOf(this.zzsp.zzda()));
                } while (this.zzsp.zzds() < zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzo(List<Integer> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzfz) {
            zzfz zzfz = (zzfz) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzfz.zzbg(this.zzsp.zzdb());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzds = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    zzfz.zzbg(this.zzsp.zzdb());
                } while (this.zzsp.zzds() < zzds);
                zzae(zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzsp.zzdb()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzds2 = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    list.add(Integer.valueOf(this.zzsp.zzdb()));
                } while (this.zzsp.zzds() < zzds2);
                zzae(zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int zzdq;
        int zzdq2;
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzgt.zzp(this.zzsp.zzdc());
                    if (!this.zzsp.zzcm()) {
                        zzdq2 = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq2 == this.tag);
                this.zzsq = zzdq2;
            } else if (i == 2) {
                int zzds = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    zzgt.zzp(this.zzsp.zzdc());
                } while (this.zzsp.zzds() < zzds);
                zzae(zzds);
            } else {
                throw zzgf.zzfm();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzsp.zzdc()));
                    if (!this.zzsp.zzcm()) {
                        zzdq = this.zzsp.zzdq();
                    } else {
                        return;
                    }
                } while (zzdq == this.tag);
                this.zzsq = zzdq;
            } else if (i2 == 2) {
                int zzds2 = this.zzsp.zzds() + this.zzsp.zzcx();
                do {
                    list.add(Long.valueOf(this.zzsp.zzdc()));
                } while (this.zzsp.zzds() < zzds2);
                zzae(zzds2);
            } else {
                throw zzgf.zzfm();
            }
        }
    }

    private static void zzac(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzgf.zzfo();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzco() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.vision.zzgf("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.vision.zzgy<K, V> r9, com.google.android.gms.internal.vision.zzfk r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzab(r0)
            com.google.android.gms.internal.vision.zzez r1 = r7.zzsp
            int r1 = r1.zzcx()
            com.google.android.gms.internal.vision.zzez r2 = r7.zzsp
            int r1 = r2.zzan(r1)
            K r2 = r9.zzyw
            V r3 = r9.zzgq
        L_0x0014:
            int r4 = r7.zzcn()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.vision.zzez r5 = r7.zzsp     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzcm()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzco()     // Catch:{ zzgg -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.vision.zzgf r4 = new com.google.android.gms.internal.vision.zzgf     // Catch:{ zzgg -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzgg -> 0x004e }
            throw r4     // Catch:{ zzgg -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.vision.zzjd r4 = r9.zzyx     // Catch:{ zzgg -> 0x004e }
            V r5 = r9.zzgq     // Catch:{ zzgg -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzgg -> 0x004e }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.vision.zzjd) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzfk) r10)     // Catch:{ zzgg -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.vision.zzjd r4 = r9.zzyv     // Catch:{ zzgg -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza((com.google.android.gms.internal.vision.zzjd) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzfk) r5)     // Catch:{ zzgg -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzco()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.vision.zzgf r8 = new com.google.android.gms.internal.vision.zzgf     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.vision.zzez r8 = r7.zzsp
            r8.zzao(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.vision.zzez r9 = r7.zzsp
            r9.zzao(r1)
            goto L_0x006c
        L_0x006b:
            throw r8
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfc.zza(java.util.Map, com.google.android.gms.internal.vision.zzgy, com.google.android.gms.internal.vision.zzfk):void");
    }

    private final Object zza(zzjd zzjd, Class<?> cls, zzfk zzfk) throws IOException {
        switch (zzfd.zzrr[zzjd.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzcu());
            case 2:
                return zzcw();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzcy());
            case 5:
                return Integer.valueOf(zzct());
            case 6:
                return Long.valueOf(zzcs());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzcr());
            case 9:
                return Long.valueOf(zzcq());
            case 10:
                return zza(cls, zzfk);
            case 11:
                return Integer.valueOf(zzcz());
            case 12:
                return Long.valueOf(zzda());
            case 13:
                return Integer.valueOf(zzdb());
            case 14:
                return Long.valueOf(zzdc());
            case 15:
                return zzcv();
            case 16:
                return Integer.valueOf(zzcx());
            case 17:
                return Long.valueOf(zzcp());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static void zzad(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzgf.zzfo();
        }
    }

    private final void zzae(int i) throws IOException {
        if (this.zzsp.zzds() != i) {
            throw zzgf.zzfh();
        }
    }
}
