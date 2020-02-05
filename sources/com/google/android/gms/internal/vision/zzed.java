package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzec;
import com.google.android.gms.internal.vision.zzed;

public abstract class zzed<MessageType extends zzec<MessageType, BuilderType>, BuilderType extends zzed<MessageType, BuilderType>> implements zzhg {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    /* renamed from: zzcg */
    public abstract BuilderType clone();

    public final /* synthetic */ zzhg zza(zzhf zzhf) {
        if (zzfb().getClass().isInstance(zzhf)) {
            return zza((zzec) zzhf);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
