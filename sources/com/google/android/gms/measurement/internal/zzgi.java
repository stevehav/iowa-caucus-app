package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
abstract class zzgi extends zzgj {
    private boolean zza;

    zzgi(zzfn zzfn) {
        super(zzfn);
        this.zzw.zza(this);
    }

    /* access modifiers changed from: protected */
    public void f_() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zze();

    /* access modifiers changed from: package-private */
    public final boolean zzz() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzaa() {
        if (!zzz()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzab() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zze()) {
            this.zzw.zzaf();
            this.zza = true;
        }
    }

    public final void zzac() {
        if (!this.zza) {
            f_();
            this.zzw.zzaf();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
