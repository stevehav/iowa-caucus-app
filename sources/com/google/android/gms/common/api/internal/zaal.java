package com.google.android.gms.common.api.internal;

final class zaal implements Runnable {
    private final /* synthetic */ zaak zagj;

    zaal(zaak zaak) {
        this.zagj = zaak;
    }

    public final void run() {
        this.zagj.zaey.cancelAvailabilityErrorNotifications(this.zagj.mContext);
    }
}
