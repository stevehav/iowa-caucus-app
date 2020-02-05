package com.google.firebase.auth.api.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfc;
import com.google.android.gms.internal.firebase_auth.zzfl;
import com.google.android.gms.internal.firebase_auth.zzfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzi implements zzfe<zzfo> {
    private final /* synthetic */ zzfl zza;
    private final /* synthetic */ zzes zzb;
    private final /* synthetic */ zzdr zzc;
    private final /* synthetic */ zzey zzd;
    private final /* synthetic */ zzfb zze;
    private final /* synthetic */ zza zzf;

    zzi(zza zza2, zzfl zzfl, zzes zzes, zzdr zzdr, zzey zzey, zzfb zzfb) {
        this.zzf = zza2;
        this.zza = zzfl;
        this.zzb = zzes;
        this.zzc = zzdr;
        this.zzd = zzey;
        this.zze = zzfb;
    }

    public final void zza(@Nullable String str) {
        this.zze.zza(str);
    }

    public final /* synthetic */ void zza(Object obj) {
        zzfo zzfo = (zzfo) obj;
        if (this.zza.zza("EMAIL")) {
            this.zzb.zza((String) null);
        } else if (this.zza.zzb() != null) {
            this.zzb.zza(this.zza.zzb());
        }
        if (this.zza.zza("DISPLAY_NAME")) {
            this.zzb.zzb((String) null);
        } else if (this.zza.zzd() != null) {
            this.zzb.zzb(this.zza.zzd());
        }
        if (this.zza.zza("PHOTO_URL")) {
            this.zzb.zzc((String) null);
        } else if (this.zza.zze() != null) {
            this.zzb.zzc(this.zza.zze());
        }
        if (!TextUtils.isEmpty(this.zza.zzc())) {
            this.zzb.zzd(Base64Utils.encode("redacted".getBytes()));
        }
        List zzf2 = zzfo.zzf();
        if (zzf2 == null) {
            zzf2 = new ArrayList();
        }
        this.zzb.zza((List<zzfc>) zzf2);
        this.zzc.zza(zza.zza(this.zzd, zzfo), this.zzb);
    }
}
