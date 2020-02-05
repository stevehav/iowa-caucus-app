package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzdl;
import com.google.android.gms.internal.measurement.zzdn;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public abstract class zzdn<MessageType extends zzdl<MessageType, BuilderType>, BuilderType extends zzdn<MessageType, BuilderType>> implements zzgm {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzeh zzeh, zzeq zzeq) throws IOException;

    /* renamed from: zzo */
    public abstract BuilderType clone();

    public final BuilderType zza(byte[] bArr, zzeq zzeq) throws zzfn {
        return zza(bArr, 0, bArr.length, zzeq);
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzeq zzeq) throws zzfn {
        try {
            zzeh zza = zzeh.zza(bArr, 0, i2, false);
            zza(zza, zzeq);
            zza.zza(0);
            return this;
        } catch (zzfn e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + "byte array".length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    public final /* synthetic */ zzgm zza(zzgn zzgn) {
        if (zzv().getClass().isInstance(zzgn)) {
            return zza((zzdl) zzgn);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
