package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzab extends zza implements zzaa {
    zzab(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    public final zzae[] zza(IObjectWrapper iObjectWrapper, zzn zzn, zzag zzag) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzn);
        zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) zzag);
        Parcel zza = zza(3, obtainAndWriteInterfaceToken);
        zzae[] zzaeArr = (zzae[]) zza.createTypedArray(zzae.CREATOR);
        zza.recycle();
        return zzaeArr;
    }

    public final void zzs() throws RemoteException {
        zzb(2, obtainAndWriteInterfaceToken());
    }
}
