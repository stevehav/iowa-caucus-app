package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.internal.base.zaa;
import com.google.android.gms.internal.base.zac;

public final class zag extends zaa implements zaf {
    zag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    public final void zam(int i) throws RemoteException {
        Parcel zaa = zaa();
        zaa.writeInt(i);
        zab(7, zaa);
    }

    public final void zaa(IAccountAccessor iAccountAccessor, int i, boolean z) throws RemoteException {
        Parcel zaa = zaa();
        zac.zaa(zaa, (IInterface) iAccountAccessor);
        zaa.writeInt(i);
        zac.writeBoolean(zaa, z);
        zab(9, zaa);
    }

    public final void zaa(zah zah, zad zad) throws RemoteException {
        Parcel zaa = zaa();
        zac.zaa(zaa, (Parcelable) zah);
        zac.zaa(zaa, (IInterface) zad);
        zab(12, zaa);
    }
}
