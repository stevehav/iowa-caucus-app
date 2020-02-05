package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzgd;

@SafeParcelable.Class(creator = "ActionCodeSettingsCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public class ActionCodeSettings extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActionCodeSettings> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getUrl", id = 1)
    private final String zza;
    @SafeParcelable.Field(getter = "getIOSBundle", id = 2)
    private final String zzb;
    @SafeParcelable.Field(getter = "getIOSAppStoreId", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getAndroidPackageName", id = 4)
    private final String zzd;
    @SafeParcelable.Field(getter = "getAndroidInstallApp", id = 5)
    private final boolean zze;
    @SafeParcelable.Field(getter = "getAndroidMinimumVersion", id = 6)
    private final String zzf;
    @SafeParcelable.Field(getter = "canHandleCodeInApp", id = 7)
    private final boolean zzg;
    @SafeParcelable.Field(getter = "getLocaleHeader", id = 8)
    private String zzh;
    @SafeParcelable.Field(getter = "getRequestType", id = 9)
    private int zzi;
    @SafeParcelable.Field(getter = "getDynamicLinkDomain", id = 10)
    private String zzj;

    @SafeParcelable.Constructor
    ActionCodeSettings(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) String str4, @SafeParcelable.Param(id = 5) boolean z, @SafeParcelable.Param(id = 6) String str5, @SafeParcelable.Param(id = 7) boolean z2, @SafeParcelable.Param(id = 8) String str6, @SafeParcelable.Param(id = 9) int i, @SafeParcelable.Param(id = 10) String str7) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = z;
        this.zzf = str5;
        this.zzg = z2;
        this.zzh = str6;
        this.zzi = i;
        this.zzj = str7;
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static class Builder {
        /* access modifiers changed from: private */
        public String zza;
        /* access modifiers changed from: private */
        public String zzb;
        /* access modifiers changed from: private */
        public String zzc;
        /* access modifiers changed from: private */
        public boolean zzd;
        /* access modifiers changed from: private */
        public String zze;
        /* access modifiers changed from: private */
        public boolean zzf;
        /* access modifiers changed from: private */
        public String zzg;

        private Builder() {
            this.zzf = false;
        }

        public Builder setUrl(@NonNull String str) {
            this.zza = str;
            return this;
        }

        public Builder setIOSBundleId(@NonNull String str) {
            this.zzb = str;
            return this;
        }

        public Builder setAndroidPackageName(@NonNull String str, boolean z, @Nullable String str2) {
            this.zzc = str;
            this.zzd = z;
            this.zze = str2;
            return this;
        }

        public Builder setHandleCodeInApp(boolean z) {
            this.zzf = z;
            return this;
        }

        public Builder setDynamicLinkDomain(String str) {
            this.zzg = str;
            return this;
        }

        public ActionCodeSettings build() {
            if (this.zza != null) {
                return new ActionCodeSettings(this);
            }
            throw new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
        }
    }

    private ActionCodeSettings(Builder builder) {
        this.zza = builder.zza;
        this.zzb = builder.zzb;
        this.zzc = null;
        this.zzd = builder.zzc;
        this.zze = builder.zzd;
        this.zzf = builder.zze;
        this.zzg = builder.zzf;
        this.zzj = builder.zzg;
    }

    public static ActionCodeSettings zza() {
        return new ActionCodeSettings(new Builder());
    }

    public String getUrl() {
        return this.zza;
    }

    public String getIOSBundle() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }

    public String getAndroidPackageName() {
        return this.zzd;
    }

    public boolean getAndroidInstallApp() {
        return this.zze;
    }

    public String getAndroidMinimumVersion() {
        return this.zzf;
    }

    public boolean canHandleCodeInApp() {
        return this.zzg;
    }

    public final void zza(@NonNull String str) {
        this.zzh = str;
    }

    public final String zzc() {
        return this.zzh;
    }

    public final void zza(@NonNull zzgd zzgd) {
        this.zzi = zzgd.zza();
    }

    public final int zzd() {
        return this.zzi;
    }

    public final String zze() {
        return this.zzj;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getUrl(), false);
        SafeParcelWriter.writeString(parcel, 2, getIOSBundle(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 4, getAndroidPackageName(), false);
        SafeParcelWriter.writeBoolean(parcel, 5, getAndroidInstallApp());
        SafeParcelWriter.writeString(parcel, 6, getAndroidMinimumVersion(), false);
        SafeParcelWriter.writeBoolean(parcel, 7, canHandleCodeInApp());
        SafeParcelWriter.writeString(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeString(parcel, 10, this.zzj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
