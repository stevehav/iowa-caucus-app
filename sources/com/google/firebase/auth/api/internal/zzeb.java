package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzd;
import com.google.android.gms.internal.firebase_auth.zzed;
import com.google.android.gms.internal.firebase_auth.zzei;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzeb extends zzb implements zzdz {
    zzeb(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    public final void zza(zzey zzey) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzey);
        zzb(1, zza);
    }

    public final void zza(zzey zzey, zzes zzes) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzey);
        zzd.zza(zza, (Parcelable) zzes);
        zzb(2, zza);
    }

    public final void zza(zzei zzei) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzei);
        zzb(3, zza);
    }

    public final void zza(zzff zzff) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzff);
        zzb(4, zza);
    }

    public final void zza(Status status) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) status);
        zzb(5, zza);
    }

    public final void a_() throws RemoteException {
        zzb(6, zza());
    }

    public final void zzb() throws RemoteException {
        zzb(7, zza());
    }

    public final void zza(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(8, zza);
    }

    public final void zzb(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(9, zza);
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) phoneAuthCredential);
        zzb(10, zza);
    }

    public final void zzc(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzb(11, zza);
    }

    public final void zza(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) status);
        zzd.zza(zza, (Parcelable) phoneAuthCredential);
        zzb(12, zza);
    }

    public final void zzc() throws RemoteException {
        zzb(13, zza());
    }

    public final void zza(com.google.android.gms.internal.firebase_auth.zzeb zzeb) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzeb);
        zzb(14, zza);
    }

    public final void zza(zzed zzed) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzed);
        zzb(15, zza);
    }
}
