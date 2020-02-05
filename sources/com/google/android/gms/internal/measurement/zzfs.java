package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public class zzfs {
    private static final zzeq zza = zzeq.zza();
    private zzdv zzb;
    private volatile zzgn zzc;
    private volatile zzdv zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfs)) {
            return false;
        }
        zzfs zzfs = (zzfs) obj;
        zzgn zzgn = this.zzc;
        zzgn zzgn2 = zzfs.zzc;
        if (zzgn == null && zzgn2 == null) {
            return zzc().equals(zzfs.zzc());
        }
        if (zzgn != null && zzgn2 != null) {
            return zzgn.equals(zzgn2);
        }
        if (zzgn != null) {
            return zzgn.equals(zzfs.zzb(zzgn.zzv()));
        }
        return zzb(zzgn2.zzv()).equals(zzgn2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.measurement.zzgn zzb(com.google.android.gms.internal.measurement.zzgn r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.measurement.zzgn r0 = r1.zzc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.measurement.zzgn r0 = r1.zzc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzfn -> 0x0012 }
            com.google.android.gms.internal.measurement.zzdv r0 = com.google.android.gms.internal.measurement.zzdv.zza     // Catch:{ zzfn -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzfn -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.measurement.zzdv r2 = com.google.android.gms.internal.measurement.zzdv.zza     // Catch:{ all -> 0x001a }
            r1.zzd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.measurement.zzgn r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzfs.zzb(com.google.android.gms.internal.measurement.zzgn):com.google.android.gms.internal.measurement.zzgn");
    }

    public final zzgn zza(zzgn zzgn) {
        zzgn zzgn2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzgn;
        return zzgn2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzbl();
        }
        return 0;
    }

    public final zzdv zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzdv zzdv = this.zzd;
                return zzdv;
            }
            if (this.zzc == null) {
                this.zzd = zzdv.zza;
            } else {
                this.zzd = this.zzc.zzbg();
            }
            zzdv zzdv2 = this.zzd;
            return zzdv2;
        }
    }
}
