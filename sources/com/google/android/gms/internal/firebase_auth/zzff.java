package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzea;

@SafeParcelable.Class(creator = "ResetPasswordResponseCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzff extends AbstractSafeParcelable implements zzea<zzff, zzp.zzj> {
    public static final Parcelable.Creator<zzff> CREATOR = new zzfh();
    @SafeParcelable.Field(getter = "getEmail", id = 2)
    private String zza;
    @SafeParcelable.Field(getter = "getNewEmail", id = 3)
    private String zzb;
    @SafeParcelable.Field(getter = "getRequestType", id = 4)
    private String zzc;
    @SafeParcelable.Field(getter = "getMfaInfo", id = 5)
    private zzfa zzd;

    public zzff() {
    }

    @SafeParcelable.Constructor
    zzff(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) String str3, @SafeParcelable.Param(id = 5) zzfa zzfa) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzfa;
    }

    public final String zzb() {
        return this.zza;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzc;
    }

    @Nullable
    public final zzfa zze() {
        return this.zzd;
    }

    public final boolean zzf() {
        return this.zza != null;
    }

    public final boolean zzg() {
        return this.zzb != null;
    }

    public final boolean zzh() {
        return this.zzc != null;
    }

    public final boolean zzi() {
        return this.zzd != null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzjq<zzp.zzj> zza() {
        return zzp.zzj.zzf();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        String str;
        if (zzjg instanceof zzp.zzj) {
            zzp.zzj zzj = (zzp.zzj) zzjg;
            this.zza = Strings.emptyToNull(zzj.zza());
            this.zzb = Strings.emptyToNull(zzj.zzb());
            switch (zzfi.zza[zzj.zzc().ordinal()]) {
                case 1:
                    str = "VERIFY_EMAIL";
                    break;
                case 2:
                    str = "PASSWORD_RESET";
                    break;
                case 3:
                    str = "EMAIL_SIGNIN";
                    break;
                case 4:
                    str = "VERIFY_BEFORE_UPDATE_EMAIL";
                    break;
                case 5:
                    str = "RECOVER_EMAIL";
                    break;
                case 6:
                    str = "REVERT_SECOND_FACTOR_ADDITION";
                    break;
                default:
                    str = null;
                    break;
            }
            this.zzc = str;
            if (zzj.zzd()) {
                this.zzd = zzfa.zza(zzj.zze());
            }
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of ResetPasswordResponse.");
    }
}
