package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public abstract class zzea extends zza implements zzeb {
    public zzea() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((zzai) zzd.zza(parcel, zzai.CREATOR), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 2:
                zza((zzjw) zzd.zza(parcel, zzjw.CREATOR), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 4:
                zza((zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 5:
                zza((zzai) zzd.zza(parcel, zzai.CREATOR), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzb((zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 7:
                List<zzjw> zza = zza((zzn) zzd.zza(parcel, zzn.CREATOR), zzd.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 9:
                byte[] zza2 = zza((zzai) zzd.zza(parcel, zzai.CREATOR), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                return true;
            case 10:
                zza(parcel.readLong(), parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                return true;
            case 11:
                String zzc = zzc((zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeString(zzc);
                return true;
            case 12:
                zza((zzq) zzd.zza(parcel, zzq.CREATOR), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            case 13:
                zza((zzq) zzd.zza(parcel, zzq.CREATOR));
                parcel2.writeNoException();
                return true;
            case 14:
                List<zzjw> zza3 = zza(parcel.readString(), parcel.readString(), zzd.zza(parcel), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                return true;
            case 15:
                List<zzjw> zza4 = zza(parcel.readString(), parcel.readString(), parcel.readString(), zzd.zza(parcel));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                return true;
            case 16:
                List<zzq> zza5 = zza(parcel.readString(), parcel.readString(), (zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                return true;
            case 17:
                List<zzq> zza6 = zza(parcel.readString(), parcel.readString(), parcel.readString());
                parcel2.writeNoException();
                parcel2.writeTypedList(zza6);
                return true;
            case 18:
                zzd((zzn) zzd.zza(parcel, zzn.CREATOR));
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
