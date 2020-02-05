package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

final class zaac implements PendingResult.StatusListener {
    private final /* synthetic */ BasePendingResult zafm;
    private final /* synthetic */ zaab zafn;

    zaac(zaab zaab, BasePendingResult basePendingResult) {
        this.zafn = zaab;
        this.zafm = basePendingResult;
    }

    public final void onComplete(Status status) {
        this.zafn.zafk.remove(this.zafm);
    }
}
