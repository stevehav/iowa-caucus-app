package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzd;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzed extends zzb implements zzeb {
    zzed(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void zza(zzai zzai, zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzai);
        zzd.zza(a_, (Parcelable) zzn);
        zzb(1, a_);
    }

    public final void zza(zzjw zzjw, zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzjw);
        zzd.zza(a_, (Parcelable) zzn);
        zzb(2, a_);
    }

    public final void zza(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzn);
        zzb(4, a_);
    }

    public final void zza(zzai zzai, String str, String str2) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzai);
        a_.writeString(str);
        a_.writeString(str2);
        zzb(5, a_);
    }

    public final void zzb(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzn);
        zzb(6, a_);
    }

    public final List<zzjw> zza(zzn zzn, boolean z) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzn);
        zzd.zza(a_, z);
        Parcel zza = zza(7, a_);
        ArrayList<zzjw> createTypedArrayList = zza.createTypedArrayList(zzjw.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final byte[] zza(zzai zzai, String str) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzai);
        a_.writeString(str);
        Parcel zza = zza(9, a_);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }

    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel a_ = a_();
        a_.writeLong(j);
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzb(10, a_);
    }

    public final String zzc(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzn);
        Parcel zza = zza(11, a_);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final void zza(zzq zzq, zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzq);
        zzd.zza(a_, (Parcelable) zzn);
        zzb(12, a_);
    }

    public final void zza(zzq zzq) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzq);
        zzb(13, a_);
    }

    public final List<zzjw> zza(String str, String str2, boolean z, zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzd.zza(a_, z);
        zzd.zza(a_, (Parcelable) zzn);
        Parcel zza = zza(14, a_);
        ArrayList<zzjw> createTypedArrayList = zza.createTypedArrayList(zzjw.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzjw> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        zzd.zza(a_, z);
        Parcel zza = zza(15, a_);
        ArrayList<zzjw> createTypedArrayList = zza.createTypedArrayList(zzjw.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzq> zza(String str, String str2, zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        zzd.zza(a_, (Parcelable) zzn);
        Parcel zza = zza(16, a_);
        ArrayList<zzq> createTypedArrayList = zza.createTypedArrayList(zzq.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final List<zzq> zza(String str, String str2, String str3) throws RemoteException {
        Parcel a_ = a_();
        a_.writeString(str);
        a_.writeString(str2);
        a_.writeString(str3);
        Parcel zza = zza(17, a_);
        ArrayList<zzq> createTypedArrayList = zza.createTypedArrayList(zzq.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final void zzd(zzn zzn) throws RemoteException {
        Parcel a_ = a_();
        zzd.zza(a_, (Parcelable) zzn);
        zzb(18, a_);
    }
}
