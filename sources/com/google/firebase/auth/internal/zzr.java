package com.google.firebase.auth.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.zzy;
import com.google.firebase.auth.zzz;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzr extends zzz {
    private final zzn zza;

    public zzr(zzn zzn) {
        Preconditions.checkNotNull(zzn);
        this.zza = zzn;
    }

    public final List<zzy> zza() {
        return this.zza.zzl();
    }
}
