package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "EmailAuthCredentialCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getEmail", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getPassword", id = 2)
    private String zzb;
    @SafeParcelable.Field(getter = "getSignInLink", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getCachedState", id = 4)
    private String zzd;
    @SafeParcelable.Field(getter = "isForLinking", id = 5)
    private boolean zze;

    @SafeParcelable.Constructor
    EmailAuthCredential(@SafeParcelable.Param(id = 1) @NonNull String str, @SafeParcelable.Param(id = 2) @NonNull String str2, @SafeParcelable.Param(id = 3) @NonNull String str3, @SafeParcelable.Param(id = 4) @NonNull String str4, @SafeParcelable.Param(id = 5) @NonNull boolean z) {
        this.zza = Preconditions.checkNotEmpty(str);
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.zzb = str2;
            this.zzc = str3;
            this.zzd = str4;
            this.zze = z;
            return;
        }
        throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
    }

    @NonNull
    public String getProvider() {
        return "password";
    }

    EmailAuthCredential(String str, String str2) {
        this(str, str2, (String) null, (String) null, false);
    }

    @NonNull
    public final String zza() {
        return this.zza;
    }

    @NonNull
    public final String zzb() {
        return this.zzb;
    }

    @NonNull
    public final String zzc() {
        return this.zzc;
    }

    @Nullable
    public final String zzd() {
        return this.zzd;
    }

    public final boolean zze() {
        return this.zze;
    }

    public final EmailAuthCredential zza(@Nullable FirebaseUser firebaseUser) {
        this.zzd = firebaseUser.zzf();
        this.zze = true;
        return this;
    }

    public String getSignInMethod() {
        return !TextUtils.isEmpty(this.zzb) ? "password" : EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
    }

    public final boolean zzf() {
        return !TextUtils.isEmpty(this.zzc);
    }

    public static boolean zza(@NonNull String str) {
        zzf zza2;
        if (!TextUtils.isEmpty(str) && (zza2 = zzf.zza(str)) != null && zza2.zza() == 4) {
            return true;
        }
        return false;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
