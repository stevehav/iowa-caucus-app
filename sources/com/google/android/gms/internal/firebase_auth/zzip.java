package com.google.android.gms.internal.firebase_auth;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public class zzip {
    private static final zzhk zza = zzhk.zza();
    private zzgm zzb;
    private volatile zzjg zzc;
    private volatile zzgm zzd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzip)) {
            return false;
        }
        zzip zzip = (zzip) obj;
        zzjg zzjg = this.zzc;
        zzjg zzjg2 = zzip.zzc;
        if (zzjg == null && zzjg2 == null) {
            return zzc().equals(zzip.zzc());
        }
        if (zzjg != null && zzjg2 != null) {
            return zzjg.equals(zzjg2);
        }
        if (zzjg != null) {
            return zzjg.equals(zzip.zzb(zzjg.zzag()));
        }
        return zzb(zzjg2.zzag()).equals(zzjg2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.firebase_auth.zzjg zzb(com.google.android.gms.internal.firebase_auth.zzjg r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase_auth.zzjg r0 = r1.zzc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase_auth.zzjg r0 = r1.zzc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzc = r2     // Catch:{ zzig -> 0x0012 }
            com.google.android.gms.internal.firebase_auth.zzgm r0 = com.google.android.gms.internal.firebase_auth.zzgm.zza     // Catch:{ zzig -> 0x0012 }
            r1.zzd = r0     // Catch:{ zzig -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase_auth.zzgm r2 = com.google.android.gms.internal.firebase_auth.zzgm.zza     // Catch:{ all -> 0x001a }
            r1.zzd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase_auth.zzjg r2 = r1.zzc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzip.zzb(com.google.android.gms.internal.firebase_auth.zzjg):com.google.android.gms.internal.firebase_auth.zzjg");
    }

    public final zzjg zza(zzjg zzjg) {
        zzjg zzjg2 = this.zzc;
        this.zzb = null;
        this.zzd = null;
        this.zzc = zzjg;
        return zzjg2;
    }

    public final int zzb() {
        if (this.zzd != null) {
            return this.zzd.zza();
        }
        if (this.zzc != null) {
            return this.zzc.zzab();
        }
        return 0;
    }

    public final zzgm zzc() {
        if (this.zzd != null) {
            return this.zzd;
        }
        synchronized (this) {
            if (this.zzd != null) {
                zzgm zzgm = this.zzd;
                return zzgm;
            }
            if (this.zzc == null) {
                this.zzd = zzgm.zza;
            } else {
                this.zzd = this.zzc.zzw();
            }
            zzgm zzgm2 = this.zzd;
            return zzgm2;
        }
    }
}
