package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzge;
import com.google.android.gms.internal.firebase_auth.zzgh;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public abstract class zzgh<MessageType extends zzge<MessageType, BuilderType>, BuilderType extends zzgh<MessageType, BuilderType>> implements zzjj {
    /* renamed from: zza */
    public abstract BuilderType clone();

    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public final /* synthetic */ zzjj zza(zzjg zzjg) {
        if (zzag().getClass().isInstance(zzjg)) {
            return zza((zzge) zzjg);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
