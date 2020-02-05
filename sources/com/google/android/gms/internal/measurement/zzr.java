package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.0.1 */
public final class zzr extends zzb implements zzp {
    zzr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final void zza(Bundle bundle) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) bundle);
        zzb(1, a_);
    }
}
