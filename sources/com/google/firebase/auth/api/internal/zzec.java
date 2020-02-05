package com.google.firebase.auth.api.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zza;
import com.google.android.gms.internal.firebase_auth.zzd;
import com.google.android.gms.internal.firebase_auth.zzeb;
import com.google.android.gms.internal.firebase_auth.zzed;
import com.google.android.gms.internal.firebase_auth.zzei;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzey;
import com.google.android.gms.internal.firebase_auth.zzff;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public abstract class zzec extends zza implements zzdz {
    public zzec() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zza((zzey) zzd.zza(parcel, zzey.CREATOR));
                return true;
            case 2:
                zza((zzey) zzd.zza(parcel, zzey.CREATOR), (zzes) zzd.zza(parcel, zzes.CREATOR));
                return true;
            case 3:
                zza((zzei) zzd.zza(parcel, zzei.CREATOR));
                return true;
            case 4:
                zza((zzff) zzd.zza(parcel, zzff.CREATOR));
                return true;
            case 5:
                zza((Status) zzd.zza(parcel, Status.CREATOR));
                return true;
            case 6:
                a_();
                return true;
            case 7:
                zzb();
                return true;
            case 8:
                zza(parcel.readString());
                return true;
            case 9:
                zzb(parcel.readString());
                return true;
            case 10:
                zza((PhoneAuthCredential) zzd.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 11:
                zzc(parcel.readString());
                return true;
            case 12:
                zza((Status) zzd.zza(parcel, Status.CREATOR), (PhoneAuthCredential) zzd.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 13:
                zzc();
                return true;
            case 14:
                zza((zzeb) zzd.zza(parcel, zzeb.CREATOR));
                return true;
            case 15:
                zza((zzed) zzd.zza(parcel, zzed.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
