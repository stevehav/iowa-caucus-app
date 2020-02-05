package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.auth.zzg;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzk implements Parcelable.Creator<zzh> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzh[i];
    }

    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzn zzn = null;
        zzf zzf = null;
        zzg zzg = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 1) {
                zzn = (zzn) SafeParcelReader.createParcelable(parcel, readHeader, zzn.CREATOR);
            } else if (fieldId == 2) {
                zzf = (zzf) SafeParcelReader.createParcelable(parcel, readHeader, zzf.CREATOR);
            } else if (fieldId != 3) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                zzg = (zzg) SafeParcelReader.createParcelable(parcel, readHeader, zzg.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzh(zzn, zzf, zzg);
    }
}
