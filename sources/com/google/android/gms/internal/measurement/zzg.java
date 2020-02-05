package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzg extends zzb implements zzf {
    zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle zza(Bundle bundle) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) bundle);
        Parcel zza = zza(1, a_);
        Bundle bundle2 = (Bundle) zzd.zza(zza, Bundle.CREATOR);
        zza.recycle();
        return bundle2;
    }
}
