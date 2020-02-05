package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager;

final class zaax implements GmsClientEventManager.GmsClientEventState {
    private final /* synthetic */ zaaw zahh;

    zaax(zaaw zaaw) {
        this.zahh = zaaw;
    }

    public final Bundle getConnectionHint() {
        return null;
    }

    public final boolean isConnected() {
        return this.zahh.isConnected();
    }
}
