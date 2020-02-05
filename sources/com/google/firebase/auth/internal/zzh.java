package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzg;
import java.util.List;

@SafeParcelable.Class(creator = "DefaultAuthResultCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzh implements AuthResult {
    public static final Parcelable.Creator<zzh> CREATOR = new zzk();
    @SafeParcelable.Field(getter = "getUser", id = 1)
    private zzn zza;
    @SafeParcelable.Field(getter = "getAdditionalUserInfo", id = 2)
    private zzf zzb;
    @SafeParcelable.Field(getter = "getOAuthCredential", id = 3)
    private zzg zzc;

    @SafeParcelable.Constructor
    zzh(@SafeParcelable.Param(id = 1) zzn zzn, @SafeParcelable.Param(id = 2) zzf zzf, @SafeParcelable.Param(id = 3) zzg zzg) {
        this.zza = zzn;
        this.zzb = zzf;
        this.zzc = zzg;
    }

    public final int describeContents() {
        return 0;
    }

    public zzh(zzn zzn) {
        this.zza = (zzn) Preconditions.checkNotNull(zzn);
        List<zzj> zzi = this.zza.zzi();
        this.zzb = null;
        for (int i = 0; i < zzi.size(); i++) {
            if (!TextUtils.isEmpty(zzi.get(i).zza())) {
                this.zzb = new zzf(zzi.get(i).getProviderId(), zzi.get(i).zza(), zzn.zzj());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzf(zzn.zzj());
        }
        this.zzc = zzn.zzk();
    }

    @Nullable
    public final FirebaseUser getUser() {
        return this.zza;
    }

    @Nullable
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    public final AuthCredential getCredential() {
        return this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
