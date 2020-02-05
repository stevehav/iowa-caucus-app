package com.google.firebase.auth.api.internal;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzfl;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzy;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
final class zzaf implements zzfe<zzey> {
    private final /* synthetic */ UserProfileChangeRequest zza;
    private final /* synthetic */ zzdr zzb;
    private final /* synthetic */ zza zzc;

    zzaf(zza zza2, UserProfileChangeRequest userProfileChangeRequest, zzdr zzdr) {
        this.zzc = zza2;
        this.zza = userProfileChangeRequest;
        this.zzb = zzdr;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zza(zzy.zza(str));
    }

    public final /* synthetic */ void zza(Object obj) {
        zzey zzey = (zzey) obj;
        zzfl zzfl = new zzfl();
        zzfl.zzb(zzey.zzd());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzfl.zze(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzfl.zzf(this.zza.zza());
        }
        this.zzc.zza(this.zzb, zzey, zzfl, (zzfb) this);
    }
}
