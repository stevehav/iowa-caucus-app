package com.google.android.gms.common.api.internal;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public final class zacp {
    public static final Status zakx = new Status(8, "The connection to Google Play services was lost");
    private static final BasePendingResult<?>[] zaky = new BasePendingResult[0];
    private final Map<Api.AnyClientKey<?>, Api.Client> zagz;
    @VisibleForTesting
    final Set<BasePendingResult<?>> zakz = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final zacs zala = new zacq(this);

    public zacp(Map<Api.AnyClientKey<?>, Api.Client> map) {
        this.zagz = map;
    }

    /* access modifiers changed from: package-private */
    public final void zab(BasePendingResult<? extends Result> basePendingResult) {
        this.zakz.add(basePendingResult);
        basePendingResult.zaa(this.zala);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.common.api.ResultCallback, com.google.android.gms.common.api.internal.zacs, com.google.android.gms.common.api.zac, com.google.android.gms.common.api.internal.zacq] */
    public final void release() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.zakz.toArray(zaky)) {
            ? r5 = 0;
            basePendingResult.zaa((zacs) r5);
            if (basePendingResult.zam() != null) {
                basePendingResult.setResultCallback(r5);
                IBinder serviceBrokerBinder = this.zagz.get(((BaseImplementation.ApiMethodImpl) basePendingResult).getClientKey()).getServiceBrokerBinder();
                if (basePendingResult.isReady()) {
                    basePendingResult.zaa((zacs) new zacr(basePendingResult, r5, serviceBrokerBinder, r5));
                } else if (serviceBrokerBinder == null || !serviceBrokerBinder.isBinderAlive()) {
                    basePendingResult.zaa((zacs) r5);
                    basePendingResult.cancel();
                    r5.remove(basePendingResult.zam().intValue());
                } else {
                    zacr zacr = new zacr(basePendingResult, r5, serviceBrokerBinder, r5);
                    basePendingResult.zaa((zacs) zacr);
                    try {
                        serviceBrokerBinder.linkToDeath(zacr, 0);
                    } catch (RemoteException unused) {
                        basePendingResult.cancel();
                        r5.remove(basePendingResult.zam().intValue());
                    }
                }
                this.zakz.remove(basePendingResult);
            } else if (basePendingResult.zat()) {
                this.zakz.remove(basePendingResult);
            }
        }
    }

    public final void zabx() {
        for (BasePendingResult zab : (BasePendingResult[]) this.zakz.toArray(zaky)) {
            zab.zab(zakx);
        }
    }
}
