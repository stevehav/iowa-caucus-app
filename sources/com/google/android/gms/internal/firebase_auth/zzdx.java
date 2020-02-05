package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.UserProfileChangeRequest;

@SafeParcelable.Class(creator = "UpdateProfileAidlRequestCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzdx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdx> CREATOR = new zzea();
    @SafeParcelable.Field(getter = "getUserProfileChangeRequest", id = 1)
    private final UserProfileChangeRequest zza;
    @SafeParcelable.Field(getter = "getCachedState", id = 2)
    private final String zzb;

    @SafeParcelable.Constructor
    public zzdx(@SafeParcelable.Param(id = 1) UserProfileChangeRequest userProfileChangeRequest, @SafeParcelable.Param(id = 2) String str) {
        this.zza = userProfileChangeRequest;
        this.zzb = str;
    }

    public final UserProfileChangeRequest zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
