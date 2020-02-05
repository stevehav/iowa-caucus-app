package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

final class zabc extends zabr {
    private WeakReference<zaaw> zahm;

    zabc(zaaw zaaw) {
        this.zahm = new WeakReference<>(zaaw);
    }

    public final void zas() {
        zaaw zaaw = (zaaw) this.zahm.get();
        if (zaaw != null) {
            zaaw.resume();
        }
    }
}
