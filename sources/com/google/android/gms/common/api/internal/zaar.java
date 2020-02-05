package com.google.android.gms.common.api.internal;

import androidx.annotation.BinderThread;
import com.google.android.gms.signin.internal.zac;
import com.google.android.gms.signin.internal.zaj;
import java.lang.ref.WeakReference;

final class zaar extends zac {
    private final WeakReference<zaak> zagk;

    zaar(zaak zaak) {
        this.zagk = new WeakReference<>(zaak);
    }

    @BinderThread
    public final void zab(zaj zaj) {
        zaak zaak = (zaak) this.zagk.get();
        if (zaak != null) {
            zaak.zaft.zaa((zabf) new zaas(this, zaak, zaak, zaj));
        }
    }
}
