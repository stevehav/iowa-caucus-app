package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;

final class zau implements zabt {
    private final /* synthetic */ zas zaeq;

    private zau(zas zas) {
        this.zaeq = zas;
    }

    public final void zab(@Nullable Bundle bundle) {
        this.zaeq.zaeo.lock();
        try {
            this.zaeq.zaa(bundle);
            ConnectionResult unused = this.zaeq.zael = ConnectionResult.RESULT_SUCCESS;
            this.zaeq.zax();
        } finally {
            this.zaeq.zaeo.unlock();
        }
    }

    public final void zac(@NonNull ConnectionResult connectionResult) {
        this.zaeq.zaeo.lock();
        try {
            ConnectionResult unused = this.zaeq.zael = connectionResult;
            this.zaeq.zax();
        } finally {
            this.zaeq.zaeo.unlock();
        }
    }

    public final void zab(int i, boolean z) {
        this.zaeq.zaeo.lock();
        try {
            if (!this.zaeq.zaen && this.zaeq.zaem != null) {
                if (this.zaeq.zaem.isSuccess()) {
                    boolean unused = this.zaeq.zaen = true;
                    this.zaeq.zaeg.onConnectionSuspended(i);
                    this.zaeq.zaeo.unlock();
                    return;
                }
            }
            boolean unused2 = this.zaeq.zaen = false;
            this.zaeq.zaa(i, z);
        } finally {
            this.zaeq.zaeo.unlock();
        }
    }

    /* synthetic */ zau(zas zas, zat zat) {
        this(zas);
    }
}
