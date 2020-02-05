package com.google.firebase.auth.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.zza;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzg implements ActionCodeResult {
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final zza zzd;

    public zzg(zzff zzff) {
        this.zzb = zzff.zzg() ? zzff.zzc() : zzff.zzb();
        this.zzc = zzff.zzb();
        zza zza2 = null;
        if (!zzff.zzh()) {
            this.zza = 3;
            this.zzd = null;
            return;
        }
        String zzd2 = zzff.zzd();
        char c = 65535;
        switch (zzd2.hashCode()) {
            case -1874510116:
                if (zzd2.equals("REVERT_SECOND_FACTOR_ADDITION")) {
                    c = 5;
                    break;
                }
                break;
            case -1452371317:
                if (zzd2.equals("PASSWORD_RESET")) {
                    c = 0;
                    break;
                }
                break;
            case -1341836234:
                if (zzd2.equals("VERIFY_EMAIL")) {
                    c = 1;
                    break;
                }
                break;
            case -1288726400:
                if (zzd2.equals("VERIFY_BEFORE_UPDATE_EMAIL")) {
                    c = 3;
                    break;
                }
                break;
            case 870738373:
                if (zzd2.equals("EMAIL_SIGNIN")) {
                    c = 2;
                    break;
                }
                break;
            case 970484929:
                if (zzd2.equals("RECOVER_EMAIL")) {
                    c = 4;
                    break;
                }
                break;
        }
        this.zza = c != 0 ? c != 1 ? c != 2 ? c != 3 ? c != 4 ? c != 5 ? 3 : 6 : 2 : 5 : 4 : 1 : 0;
        int i = this.zza;
        if (i == 4 || i == 3) {
            this.zzd = null;
            return;
        }
        if (zzff.zzi()) {
            zza2 = new zzd(zzff.zzb(), zzar.zza(zzff.zze()));
        } else if (zzff.zzg()) {
            zza2 = new zzb(zzff.zzc(), zzff.zzb());
        } else if (zzff.zzf()) {
            zza2 = new zze(zzff.zzb());
        }
        this.zzd = zza2;
    }

    public final int getOperation() {
        return this.zza;
    }

    @Nullable
    public final String getData(int i) {
        if (this.zza == 4) {
            return null;
        }
        if (i == 0) {
            return this.zzb;
        }
        if (i != 1) {
            return null;
        }
        return this.zzc;
    }
}
