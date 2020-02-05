package com.google.firebase.auth.api.internal;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzex implements Runnable {
    private final /* synthetic */ zzfa zza;
    private final /* synthetic */ zzeu zzb;

    zzex(zzeu zzeu, zzfa zzfa) {
        this.zzb = zzeu;
        this.zza = zzfa;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzi) {
            if (!this.zzb.zza.zzi.isEmpty()) {
                this.zza.zza(this.zzb.zza.zzi.get(0), new Object[0]);
            }
        }
    }
}
