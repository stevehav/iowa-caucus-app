package com.google.firebase.auth.api.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzbp;
import com.google.android.gms.internal.firebase_auth.zzbr;
import com.google.android.gms.internal.firebase_auth.zzbt;
import com.google.android.gms.internal.firebase_auth.zzbv;
import com.google.android.gms.internal.firebase_auth.zzbx;
import com.google.android.gms.internal.firebase_auth.zzbz;
import com.google.android.gms.internal.firebase_auth.zzcb;
import com.google.android.gms.internal.firebase_auth.zzcd;
import com.google.android.gms.internal.firebase_auth.zzcf;
import com.google.android.gms.internal.firebase_auth.zzch;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzcl;
import com.google.android.gms.internal.firebase_auth.zzcn;
import com.google.android.gms.internal.firebase_auth.zzcp;
import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcv;
import com.google.android.gms.internal.firebase_auth.zzcx;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzd;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.android.gms.internal.firebase_auth.zzdd;
import com.google.android.gms.internal.firebase_auth.zzdf;
import com.google.android.gms.internal.firebase_auth.zzdh;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.android.gms.internal.firebase_auth.zzdn;
import com.google.android.gms.internal.firebase_auth.zzdp;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzdt;
import com.google.android.gms.internal.firebase_auth.zzdv;
import com.google.android.gms.internal.firebase_auth.zzdx;
import com.google.android.gms.internal.firebase_auth.zzdz;
import com.google.android.gms.internal.firebase_auth.zzfk;
import com.google.android.gms.internal.firebase_auth.zzfr;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzef extends zzb implements zzee {
    zzef(IBinder iBinder) {
        super(iBinder, "com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    public final void zza(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(1, zza);
    }

    public final void zzb(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(2, zza);
    }

    public final void zza(zzfr zzfr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzfr);
        zzd.zza(zza, (IInterface) zzdz);
        zza(3, zza);
    }

    public final void zza(String str, UserProfileChangeRequest userProfileChangeRequest, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) userProfileChangeRequest);
        zzd.zza(zza, (IInterface) zzdz);
        zza(4, zza);
    }

    public final void zza(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzdz);
        zza(5, zza);
    }

    public final void zzb(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzdz);
        zza(6, zza);
    }

    public final void zzc(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzdz);
        zza(7, zza);
    }

    public final void zzd(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzdz);
        zza(8, zza);
    }

    public final void zzc(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(9, zza);
    }

    public final void zzd(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(10, zza);
    }

    public final void zza(String str, String str2, String str3, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzd.zza(zza, (IInterface) zzdz);
        zza(11, zza);
    }

    public final void zza(String str, zzfr zzfr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) zzfr);
        zzd.zza(zza, (IInterface) zzdz);
        zza(12, zza);
    }

    public final void zze(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(13, zza);
    }

    public final void zze(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzdz);
        zza(14, zza);
    }

    public final void zzf(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(15, zza);
    }

    public final void zza(zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (IInterface) zzdz);
        zza(16, zza);
    }

    public final void zzg(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(17, zza);
    }

    public final void zzh(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(18, zza);
    }

    public final void zzi(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(19, zza);
    }

    public final void zzj(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(20, zza);
    }

    public final void zzf(String str, String str2, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzd.zza(zza, (IInterface) zzdz);
        zza(21, zza);
    }

    public final void zza(zzfk zzfk, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzfk);
        zzd.zza(zza, (IInterface) zzdz);
        zza(22, zza);
    }

    public final void zza(PhoneAuthCredential phoneAuthCredential, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) phoneAuthCredential);
        zzd.zza(zza, (IInterface) zzdz);
        zza(23, zza);
    }

    public final void zza(String str, PhoneAuthCredential phoneAuthCredential, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) phoneAuthCredential);
        zzd.zza(zza, (IInterface) zzdz);
        zza(24, zza);
    }

    public final void zza(String str, ActionCodeSettings actionCodeSettings, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) actionCodeSettings);
        zzd.zza(zza, (IInterface) zzdz);
        zza(25, zza);
    }

    public final void zzb(String str, ActionCodeSettings actionCodeSettings, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) actionCodeSettings);
        zzd.zza(zza, (IInterface) zzdz);
        zza(26, zza);
    }

    public final void zzk(String str, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (IInterface) zzdz);
        zza(27, zza);
    }

    public final void zzc(String str, ActionCodeSettings actionCodeSettings, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, (Parcelable) actionCodeSettings);
        zzd.zza(zza, (IInterface) zzdz);
        zza(28, zza);
    }

    public final void zza(EmailAuthCredential emailAuthCredential, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) emailAuthCredential);
        zzd.zza(zza, (IInterface) zzdz);
        zza(29, zza);
    }

    public final void zza(zzch zzch, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzch);
        zzd.zza(zza, (IInterface) zzdz);
        zza(101, zza);
    }

    public final void zza(zzdf zzdf, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdf);
        zzd.zza(zza, (IInterface) zzdz);
        zza(102, zza);
    }

    public final void zza(zzdd zzdd, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdd);
        zzd.zza(zza, (IInterface) zzdz);
        zza(103, zza);
    }

    public final void zza(zzdx zzdx, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdx);
        zzd.zza(zza, (IInterface) zzdz);
        zza(104, zza);
    }

    public final void zza(zzbr zzbr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbr);
        zzd.zza(zza, (IInterface) zzdz);
        zza(105, zza);
    }

    public final void zza(zzbt zzbt, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbt);
        zzd.zza(zza, (IInterface) zzdz);
        zza(106, zza);
    }

    public final void zza(zzbz zzbz, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbz);
        zzd.zza(zza, (IInterface) zzdz);
        zza(107, zza);
    }

    public final void zza(zzdh zzdh, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdh);
        zzd.zza(zza, (IInterface) zzdz);
        zza(108, zza);
    }

    public final void zza(zzcj zzcj, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcj);
        zzd.zza(zza, (IInterface) zzdz);
        zza(109, zza);
    }

    public final void zza(zzcl zzcl, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcl);
        zzd.zza(zza, (IInterface) zzdz);
        zza(111, zza);
    }

    public final void zza(zzcn zzcn, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcn);
        zzd.zza(zza, (IInterface) zzdz);
        zza(112, zza);
    }

    public final void zza(zzdt zzdt, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdt);
        zzd.zza(zza, (IInterface) zzdz);
        zza(113, zza);
    }

    public final void zza(zzdv zzdv, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdv);
        zzd.zza(zza, (IInterface) zzdz);
        zza(114, zza);
    }

    public final void zza(zzcr zzcr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcr);
        zzd.zza(zza, (IInterface) zzdz);
        zza(115, zza);
    }

    public final void zza(zzdb zzdb, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdb);
        zzd.zza(zza, (IInterface) zzdz);
        zza(116, zza);
    }

    public final void zza(zzcb zzcb, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcb);
        zzd.zza(zza, (IInterface) zzdz);
        zza(117, zza);
    }

    public final void zza(zzbv zzbv, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbv);
        zzd.zza(zza, (IInterface) zzdz);
        zza(119, zza);
    }

    public final void zza(zzbp zzbp, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbp);
        zzd.zza(zza, (IInterface) zzdz);
        zza(120, zza);
    }

    public final void zza(zzbx zzbx, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzbx);
        zzd.zza(zza, (IInterface) zzdz);
        zza(PanasonicMakernoteDirectory.TAG_INTELLIGENT_D_RANGE, zza);
    }

    public final void zza(zzcx zzcx, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcx);
        zzd.zza(zza, (IInterface) zzdz);
        zza(122, zza);
    }

    public final void zza(zzdl zzdl, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdl);
        zzd.zza(zza, (IInterface) zzdz);
        zza(123, zza);
    }

    public final void zza(zzcp zzcp, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcp);
        zzd.zza(zza, (IInterface) zzdz);
        zza(PanasonicMakernoteDirectory.TAG_CLEAR_RETOUCH, zza);
    }

    public final void zza(zzct zzct, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzct);
        zzd.zza(zza, (IInterface) zzdz);
        zza(126, zza);
    }

    public final void zza(zzcz zzcz, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcz);
        zzd.zza(zza, (IInterface) zzdz);
        zza(127, zza);
    }

    public final void zza(zzcv zzcv, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcv);
        zzd.zza(zza, (IInterface) zzdz);
        zza(128, zza);
    }

    public final void zza(zzdj zzdj, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdj);
        zzd.zza(zza, (IInterface) zzdz);
        zza(129, zza);
    }

    public final void zza(zzdn zzdn, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdn);
        zzd.zza(zza, (IInterface) zzdz);
        zza(NikonType2MakernoteDirectory.TAG_ADAPTER, zza);
    }

    public final void zza(zzdr zzdr, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdr);
        zzd.zza(zza, (IInterface) zzdz);
        zza(131, zza);
    }

    public final void zza(zzcd zzcd, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcd);
        zzd.zza(zza, (IInterface) zzdz);
        zza(NikonType2MakernoteDirectory.TAG_LENS, zza);
    }

    public final void zza(zzdp zzdp, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdp);
        zzd.zza(zza, (IInterface) zzdz);
        zza(NikonType2MakernoteDirectory.TAG_MANUAL_FOCUS_DISTANCE, zza);
    }

    public final void zza(zzcf zzcf, zzdz zzdz) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzcf);
        zzd.zza(zza, (IInterface) zzdz);
        zza(NikonType2MakernoteDirectory.TAG_DIGITAL_ZOOM, zza);
    }

    public final void zza(zzdz zzdz, zzdz zzdz2) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, (Parcelable) zzdz);
        zzd.zza(zza, (IInterface) zzdz2);
        zza(NikonType2MakernoteDirectory.TAG_FLASH_USED, zza);
    }
}
