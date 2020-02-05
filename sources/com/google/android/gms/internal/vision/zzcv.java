package com.google.android.gms.internal.vision;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

final class zzcv {
    private final ConcurrentHashMap<zzcw, List<Throwable>> zzlt = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzlu = new ReferenceQueue<>();

    zzcv() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzlu.poll();
        while (poll != null) {
            this.zzlt.remove(poll);
            poll = this.zzlu.poll();
        }
        return this.zzlt.get(new zzcw(th, (ReferenceQueue<Throwable>) null));
    }
}
