package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.internal.zzar;
import com.google.firebase.auth.zzg;
import com.google.firebase.auth.zzy;
import java.util.List;

@SafeParcelable.Class(creator = "OnFailedMfaSignInAidlResponseCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzed extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzed> CREATOR = new zzef();
    @SafeParcelable.Field(getter = "getMfaPendingCredential", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getMfaInfoList", id = 2)
    private List<zzfa> zzb;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 3)
    private zzg zzc;

    @SafeParcelable.Constructor
    public zzed(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) List<zzfa> list, @SafeParcelable.Param(id = 3) @Nullable zzg zzg) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzg;
    }

    public final String zza() {
        return this.zza;
    }

    public final zzg zzb() {
        return this.zzc;
    }

    public final List<zzy> zzc() {
        return zzar.zza(this.zzb);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
