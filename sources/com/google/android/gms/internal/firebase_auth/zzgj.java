package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzjg;
import java.io.InputStream;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public abstract class zzgj<MessageType extends zzjg> implements zzjq<MessageType> {
    private static final zzhk zza = zzhk.zza();

    private final MessageType zzb(InputStream inputStream, zzhk zzhk) throws zzig {
        zzgy zzgy;
        if (inputStream == null) {
            byte[] bArr = zzib.zzb;
            zzgy = zzgy.zza(bArr, 0, bArr.length, false);
        } else {
            zzgy = new zzhd(inputStream);
        }
        MessageType messagetype = (zzjg) zza(zzgy, zzhk);
        try {
            zzgy.zza(0);
            return messagetype;
        } catch (zzig e) {
            throw e.zza(messagetype);
        }
    }

    public final /* synthetic */ Object zza(InputStream inputStream, zzhk zzhk) throws zzig {
        zzkq zzkq;
        zzjg zzb = zzb(inputStream, zzhk);
        if (zzb == null || zzb.zzaa()) {
            return zzb;
        }
        if (zzb instanceof zzge) {
            zzkq = new zzkq((zzge) zzb);
        } else if (zzb instanceof zzgg) {
            zzkq = new zzkq((zzgg) zzb);
        } else {
            zzkq = new zzkq(zzb);
        }
        throw new zzig(zzkq.getMessage()).zza(zzb);
    }
}
