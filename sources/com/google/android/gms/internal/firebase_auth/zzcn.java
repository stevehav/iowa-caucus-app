package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LinkFederatedCredentialAidlRequestCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzcn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcn> CREATOR = new zzcq();
    @SafeParcelable.Field(getter = "getCachedState", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getVerifyAssertionRequest", id = 2)
    private final zzfr zzb;

    @SafeParcelable.Constructor
    public zzcn(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) zzfr zzfr) {
        this.zza = str;
        this.zzb = zzfr;
    }

    public final String zza() {
        return this.zza;
    }

    public final zzfr zzb() {
        return this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
