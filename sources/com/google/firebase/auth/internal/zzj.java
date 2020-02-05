package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzbq;
import com.google.android.gms.internal.firebase_auth.zzes;
import com.google.android.gms.internal.firebase_auth.zzfc;
import com.google.firebase.auth.UserInfo;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "DefaultAuthUserInfoCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzj extends AbstractSafeParcelable implements UserInfo {
    public static final Parcelable.Creator<zzj> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getUid", id = 1)
    @NonNull
    private String zza;
    @SafeParcelable.Field(getter = "getProviderId", id = 2)
    @NonNull
    private String zzb;
    @SafeParcelable.Field(getter = "getDisplayName", id = 3)
    @Nullable
    private String zzc;
    @SafeParcelable.Field(getter = "getPhotoUrlString", id = 4)
    @Nullable
    private String zzd;
    @Nullable
    private Uri zze;
    @SafeParcelable.Field(getter = "getEmail", id = 5)
    @Nullable
    private String zzf;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 6)
    @Nullable
    private String zzg;
    @SafeParcelable.Field(getter = "isEmailVerified", id = 7)
    private boolean zzh;
    @SafeParcelable.Field(getter = "getRawUserInfo", id = 8)
    @Nullable
    private String zzi;

    @SafeParcelable.Constructor
    @VisibleForTesting
    public zzj(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 5) @Nullable String str3, @SafeParcelable.Param(id = 4) @Nullable String str4, @SafeParcelable.Param(id = 3) @Nullable String str5, @SafeParcelable.Param(id = 6) @Nullable String str6, @SafeParcelable.Param(id = 7) boolean z, @SafeParcelable.Param(id = 8) @Nullable String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzf = str3;
        this.zzg = str4;
        this.zzc = str5;
        this.zzd = str6;
        if (!TextUtils.isEmpty(this.zzd)) {
            this.zze = Uri.parse(this.zzd);
        }
        this.zzh = z;
        this.zzi = str7;
    }

    public zzj(zzes zzes, String str) {
        Preconditions.checkNotNull(zzes);
        Preconditions.checkNotEmpty(str);
        this.zza = Preconditions.checkNotEmpty(zzes.zzc());
        this.zzb = str;
        this.zzf = zzes.zza();
        this.zzc = zzes.zzd();
        Uri zze2 = zzes.zze();
        if (zze2 != null) {
            this.zzd = zze2.toString();
            this.zze = zze2;
        }
        this.zzh = zzes.zzb();
        this.zzi = null;
        this.zzg = zzes.zzf();
    }

    public zzj(zzfc zzfc) {
        Preconditions.checkNotNull(zzfc);
        this.zza = zzfc.zza();
        this.zzb = Preconditions.checkNotEmpty(zzfc.zzd());
        this.zzc = zzfc.zzb();
        Uri zzc2 = zzfc.zzc();
        if (zzc2 != null) {
            this.zzd = zzc2.toString();
            this.zze = zzc2;
        }
        this.zzf = zzfc.zzg();
        this.zzg = zzfc.zze();
        this.zzh = false;
        this.zzi = zzfc.zzf();
    }

    @NonNull
    public final String getUid() {
        return this.zza;
    }

    @NonNull
    public final String getProviderId() {
        return this.zzb;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzc;
    }

    @Nullable
    public final Uri getPhotoUrl() {
        if (!TextUtils.isEmpty(this.zzd) && this.zze == null) {
            this.zze = Uri.parse(this.zzd);
        }
        return this.zze;
    }

    @Nullable
    public final String getEmail() {
        return this.zzf;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.zzg;
    }

    public final boolean isEmailVerified() {
        return this.zzh;
    }

    @Nullable
    public final String zza() {
        return this.zzi;
    }

    @Nullable
    public final String zzb() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("userId", this.zza);
            jSONObject.putOpt("providerId", this.zzb);
            jSONObject.putOpt("displayName", this.zzc);
            jSONObject.putOpt("photoUrl", this.zzd);
            jSONObject.putOpt("email", this.zzf);
            jSONObject.putOpt("phoneNumber", this.zzg);
            jSONObject.putOpt("isEmailVerified", Boolean.valueOf(this.zzh));
            jSONObject.putOpt("rawUserInfo", this.zzi);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to jsonify this object");
            throw new zzbq((Throwable) e);
        }
    }

    @Nullable
    public static zzj zza(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new zzj(jSONObject.optString("userId"), jSONObject.optString("providerId"), jSONObject.optString("email"), jSONObject.optString("phoneNumber"), jSONObject.optString("displayName"), jSONObject.optString("photoUrl"), jSONObject.optBoolean("isEmailVerified"), jSONObject.optString("rawUserInfo"));
        } catch (JSONException e) {
            Log.d("DefaultAuthUserInfo", "Failed to unpack UserInfo from JSON");
            throw new zzbq((Throwable) e);
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUid(), false);
        SafeParcelWriter.writeString(parcel, 2, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, getEmail(), false);
        SafeParcelWriter.writeString(parcel, 6, getPhoneNumber(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, isEmailVerified());
        SafeParcelWriter.writeString(parcel, 8, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
