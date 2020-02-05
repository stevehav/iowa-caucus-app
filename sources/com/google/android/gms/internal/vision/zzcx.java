package com.google.android.gms.internal.vision;

import java.util.List;

final class zzcx extends zzcu {
    private final zzcv zzlw = new zzcv();

    zzcx() {
    }

    public final void zza(Throwable th) {
        th.printStackTrace();
        List<Throwable> zza = this.zzlw.zza(th, false);
        if (zza != null) {
            synchronized (zza) {
                for (Throwable printStackTrace : zza) {
                    System.err.print("Suppressed: ");
                    printStackTrace.printStackTrace();
                }
            }
        }
    }
}
