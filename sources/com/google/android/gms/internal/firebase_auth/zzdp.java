package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.zzae;

@SafeParcelable.Class(creator = "StartMfaPhoneNumberSignInAidlRequestCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzdp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdp> CREATOR = new zzds();
    @SafeParcelable.Field(getter = "getPhoneMultiFactorInfo", id = 1)
    private zzae zza;
    @SafeParcelable.Field(getter = "getPendingCredential", id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getLocaleHeader", id = 3)
    @Nullable
    private final String zzc;
    @SafeParcelable.Field(getter = "getTimeoutInSeconds", id = 4)
    private final long zzd;
    @SafeParcelable.Field(getter = "getForceNewSmsVerificationSession", id = 5)
    private final boolean zze;
    @SafeParcelable.Field(getter = "getRequireSmsVerification", id = 6)
    private final boolean zzf;

    @SafeParcelable.Constructor
    public zzdp(@SafeParcelable.Param(id = 1) zzae zzae, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) @Nullable String str2, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) boolean z2) {
        this.zza = zzae;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = j;
        this.zze = z;
        this.zzf = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
