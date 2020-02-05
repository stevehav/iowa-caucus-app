package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.zzg;
import java.util.List;

@SafeParcelable.Class(creator = "GetAccountInfoUserCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzes extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzes> CREATOR = new zzer();
    @SafeParcelable.Field(getter = "getLocalId", id = 2)
    private String zza;
    @SafeParcelable.Field(getter = "getEmail", id = 3)
    private String zzb;
    @SafeParcelable.Field(getter = "isEmailVerified", id = 4)
    private boolean zzc;
    @SafeParcelable.Field(getter = "getDisplayName", id = 5)
    private String zzd;
    @SafeParcelable.Field(getter = "getPhotoUrl", id = 6)
    private String zze;
    @SafeParcelable.Field(getter = "getProviderInfoList", id = 7)
    private zzfe zzf;
    @SafeParcelable.Field(getter = "getPassword", id = 8)
    private String zzg;
    @SafeParcelable.Field(getter = "getPhoneNumber", id = 9)
    private String zzh;
    @SafeParcelable.Field(getter = "getCreationTimestamp", id = 10)
    private long zzi;
    @SafeParcelable.Field(getter = "getLastSignInTimestamp", id = 11)
    private long zzj;
    @SafeParcelable.Field(getter = "isNewUser", id = 12)
    private boolean zzk;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 13)
    private zzg zzl;
    @SafeParcelable.Field(getter = "getMfaInfoList", id = 14)
    private List<zzfa> zzm;

    public zzes() {
        this.zzf = new zzfe();
    }

    @SafeParcelable.Constructor
    public zzes(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) zzfe zzfe, @SafeParcelable.Param(id = 8) String str5, @SafeParcelable.Param(id = 9) String str6, @SafeParcelable.Param(id = 10) long j, @SafeParcelable.Param(id = 11) long j2, @SafeParcelable.Param(id = 12) boolean z2, @SafeParcelable.Param(id = 13) zzg zzg2, @SafeParcelable.Param(id = 14) List<zzfa> list) {
        zzfe zzfe2;
        this.zza = str;
        this.zzb = str2;
        this.zzc = z;
        this.zzd = str3;
        this.zze = str4;
        if (zzfe == null) {
            zzfe2 = new zzfe();
        } else {
            zzfe2 = zzfe.zza(zzfe);
        }
        this.zzf = zzfe2;
        this.zzg = str5;
        this.zzh = str6;
        this.zzi = j;
        this.zzj = j2;
        this.zzk = z2;
        this.zzl = zzg2;
        this.zzm = list == null ? zzaz.zza() : list;
    }

    @Nullable
    public final String zza() {
        return this.zzb;
    }

    public final boolean zzb() {
        return this.zzc;
    }

    @NonNull
    public final String zzc() {
        return this.zza;
    }

    @Nullable
    public final String zzd() {
        return this.zzd;
    }

    @Nullable
    public final Uri zze() {
        if (!TextUtils.isEmpty(this.zze)) {
            return Uri.parse(this.zze);
        }
        return null;
    }

    @Nullable
    public final String zzf() {
        return this.zzh;
    }

    public final long zzg() {
        return this.zzi;
    }

    public final long zzh() {
        return this.zzj;
    }

    public final boolean zzi() {
        return this.zzk;
    }

    @NonNull
    public final zzes zza(@Nullable String str) {
        this.zzb = str;
        return this;
    }

    @NonNull
    public final zzes zzb(@Nullable String str) {
        this.zzd = str;
        return this;
    }

    @NonNull
    public final zzes zzc(@Nullable String str) {
        this.zze = str;
        return this;
    }

    @NonNull
    public final zzes zzd(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzg = str;
        return this;
    }

    @NonNull
    public final zzes zza(List<zzfc> list) {
        Preconditions.checkNotNull(list);
        this.zzf = new zzfe();
        this.zzf.zza().addAll(list);
        return this;
    }

    public final zzes zza(boolean z) {
        this.zzk = z;
        return this;
    }

    @NonNull
    public final List<zzfc> zzj() {
        return this.zzf.zza();
    }

    public final zzfe zzk() {
        return this.zzf;
    }

    @Nullable
    public final zzg zzl() {
        return this.zzl;
    }

    @NonNull
    public final zzes zza(zzg zzg2) {
        this.zzl = zzg2;
        return this;
    }

    @NonNull
    public final List<zzfa> zzm() {
        return this.zzm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzc);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzf, i, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzh, false);
        SafeParcelWriter.writeLong(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzk);
        SafeParcelWriter.writeParcelable(parcel, 13, this.zzl, i, false);
        SafeParcelWriter.writeTypedList(parcel, 14, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
