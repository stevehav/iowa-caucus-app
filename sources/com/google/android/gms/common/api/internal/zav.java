package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

final class zav implements zabt {
    private final /* synthetic */ zas zaeq;

    private zav(zas zas) {
        this.zaeq = zas;
    }

    public final void zab(@Nullable Bundle bundle) {
        this.zaeq.zaeo.lock();
        try {
            ConnectionResult unused = this.zaeq.zaem = ConnectionResult.RESULT_SUCCESS;
            this.zaeq.zax();
        } finally {
            this.zaeq.zaeo.unlock();
        }
    }

    public final void zac(@NonNull ConnectionResult connectionResult) {
        this.zaeq.zaeo.lock();
        try {
            ConnectionResult unused = this.zaeq.zaem = connectionResult;
            this.zaeq.zax();
        } finally {
            this.zaeq.zaeo.unlock();
        }
    }

    public final void zab(int i, boolean z) {
        this.zaeq.zaeo.lock();
        try {
            if (this.zaeq.zaen) {
                boolean unused = this.zaeq.zaen = false;
                this.zaeq.zaa(i, z);
                return;
            }
            boolean unused2 = this.zaeq.zaen = true;
            this.zaeq.zaef.onConnectionSuspended(i);
            this.zaeq.zaeo.unlock();
        } finally {
            this.zaeq.zaeo.unlock();
        }
    }

    /* synthetic */ zav(zas zas, zat zat) {
        this(zas);
    }
}
