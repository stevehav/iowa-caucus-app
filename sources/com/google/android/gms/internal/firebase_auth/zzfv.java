package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzea;

@SafeParcelable.Class(creator = "VerifyCustomTokenResponseCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfv extends AbstractSafeParcelable implements zzea<zzfv, zzp.zzt> {
    public static final Parcelable.Creator<zzfv> CREATOR = new zzfy();
    @SafeParcelable.Field(getter = "getIdToken", id = 2)
    private String zza;
    @SafeParcelable.Field(getter = "getRefreshToken", id = 3)
    private String zzb;
    @SafeParcelable.Field(getter = "getExpiresIn", id = 4)
    private long zzc;
    @SafeParcelable.Field(getter = "isNewUser", id = 5)
    private boolean zzd;

    public zzfv() {
    }

    @SafeParcelable.Constructor
    zzfv(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) long j, @SafeParcelable.Param(id = 5) boolean z) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = z;
    }

    public final String zzb() {
        return this.zza;
    }

    @NonNull
    public final String zzc() {
        return this.zzb;
    }

    public final long zzd() {
        return this.zzc;
    }

    public final boolean zze() {
        return this.zzd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzjq<zzp.zzt> zza() {
        return zzp.zzt.zze();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        if (zzjg instanceof zzp.zzt) {
            zzp.zzt zzt = (zzp.zzt) zzjg;
            this.zza = Strings.emptyToNull(zzt.zza());
            this.zzb = Strings.emptyToNull(zzt.zzb());
            this.zzc = zzt.zzc();
            this.zzd = zzt.zzd();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of VerifyCustomTokenResponse.");
    }
}
