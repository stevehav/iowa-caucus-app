package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.zzg;

@SafeParcelable.Class(creator = "OnFailedIdpSignInAidlResponseCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzeb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeb> CREATOR = new zzee();
    @SafeParcelable.Field(getter = "getStatus", id = 1)
    private final Status zza;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 2)
    private final zzg zzb;
    @SafeParcelable.Field(getter = "getEmail", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getTenantId", id = 4)
    private final String zzd;

    @SafeParcelable.Constructor
    public zzeb(@SafeParcelable.Param(id = 1) Status status, @SafeParcelable.Param(id = 2) zzg zzg, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) @Nullable String str2) {
        this.zza = status;
        this.zzb = zzg;
        this.zzc = str;
        this.zzd = str2;
    }

    public final Status zza() {
        return this.zza;
    }

    public final zzg zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
