package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzfr;

@SafeParcelable.Class(creator = "DefaultOAuthCredentialCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public class zzg extends OAuthCredential {
    public static final Parcelable.Creator<zzg> CREATOR = new zzi();
    @SafeParcelable.Field(getter = "getProvider", id = 1)
    @Nullable
    private final String zza;
    @SafeParcelable.Field(getter = "getIdToken", id = 2)
    @Nullable
    private final String zzb;
    @SafeParcelable.Field(getter = "getAccessToken", id = 3)
    @Nullable
    private final String zzc;
    @SafeParcelable.Field(getter = "getWebSignInCredential", id = 4)
    @Nullable
    private final zzfr zzd;
    @SafeParcelable.Field(getter = "getPendingToken", id = 5)
    @Nullable
    private final String zze;
    @SafeParcelable.Field(getter = "getSecret", id = 6)
    @Nullable
    private final String zzf;

    @SafeParcelable.Constructor
    zzg(@SafeParcelable.Param(id = 1) @NonNull String str, @SafeParcelable.Param(id = 2) @Nullable String str2, @SafeParcelable.Param(id = 3) @Nullable String str3, @SafeParcelable.Param(id = 4) @Nullable zzfr zzfr, @SafeParcelable.Param(id = 5) @Nullable String str4, @SafeParcelable.Param(id = 6) @Nullable String str5) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzfr;
        this.zze = str4;
        this.zzf = str5;
    }

    public static zzg zza(String str, String str2, String str3) {
        return zza(str, str2, str3, (String) null, (String) null);
    }

    public static zzg zza(String str, String str2, String str3, @Nullable String str4, @Nullable String str5) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zzg(str, str2, str3, (zzfr) null, str4, str5);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public static zzg zza(@NonNull zzfr zzfr) {
        Preconditions.checkNotNull(zzfr, "Must specify a non-null webSignInCredential");
        return new zzg((String) null, (String) null, (String) null, zzfr, (String) null, (String) null);
    }

    public String getProvider() {
        return this.zza;
    }

    public String getSignInMethod() {
        return this.zza;
    }

    @Nullable
    public String getIdToken() {
        return this.zzb;
    }

    @Nullable
    public String getAccessToken() {
        return this.zzc;
    }

    @Nullable
    public String getSecret() {
        return this.zzf;
    }

    public static zzfr zza(@NonNull zzg zzg, @Nullable String str) {
        Preconditions.checkNotNull(zzg);
        zzfr zzfr = zzg.zzd;
        if (zzfr != null) {
            return zzfr;
        }
        return new zzfr(zzg.getIdToken(), zzg.getAccessToken(), zzg.getProvider(), (String) null, zzg.getSecret(), (String) null, str, zzg.zze);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProvider(), false);
        SafeParcelWriter.writeString(parcel, 2, getIdToken(), false);
        SafeParcelWriter.writeString(parcel, 3, getAccessToken(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, getSecret(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
