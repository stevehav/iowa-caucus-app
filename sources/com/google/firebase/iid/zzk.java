package com.google.firebase.iid;

import java.util.concurrent.ThreadFactory;

final /* synthetic */ class zzk implements ThreadFactory {
    static final ThreadFactory zzan = new zzk();

    private zzk() {
    }

    public final Thread newThread(Runnable runnable) {
        return zzh.zza(runnable);
    }
}
