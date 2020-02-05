package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import javax.annotation.concurrent.GuardedBy;

final class zaao extends zabf {
    private final /* synthetic */ ConnectionResult zagm;
    private final /* synthetic */ zaan zagn;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zaao(zaan zaan, zabd zabd, ConnectionResult connectionResult) {
        super(zabd);
        this.zagn = zaan;
        this.zagm = connectionResult;
    }

    @GuardedBy("mLock")
    public final void zaan() {
        this.zagn.zagj.zae(this.zagm);
    }
}
