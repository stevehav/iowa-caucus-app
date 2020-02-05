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
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "CreateAuthUriResponseCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzei extends AbstractSafeParcelable implements zzea<zzei, zzp.zzb> {
    public static final Parcelable.Creator<zzei> CREATOR = new zzeh();
    @SafeParcelable.Field(getter = "getAuthUri", id = 2)
    private String zza;
    @SafeParcelable.Field(getter = "isRegistered", id = 3)
    private boolean zzb;
    @SafeParcelable.Field(getter = "getProviderId", id = 4)
    private String zzc;
    @SafeParcelable.Field(getter = "isForExistingProvider", id = 5)
    private boolean zzd;
    @SafeParcelable.Field(getter = "getStringList", id = 6)
    private zzfp zze;
    @SafeParcelable.Field(getter = "getSignInMethods", id = 7)
    private List<String> zzf;

    public zzei() {
        this.zze = zzfp.zzb();
    }

    @SafeParcelable.Constructor
    public zzei(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) boolean z2, @SafeParcelable.Param(id = 6) zzfp zzfp, @SafeParcelable.Param(id = 7) List<String> list) {
        this.zza = str;
        this.zzb = z;
        this.zzc = str2;
        this.zzd = z2;
        this.zze = zzfp == null ? zzfp.zzb() : zzfp.zza(zzfp);
        this.zzf = list;
    }

    @Nullable
    public final List<String> zzb() {
        return this.zzf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzb);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zze, i, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzjq<zzp.zzb> zza() {
        return zzp.zzb.zzi();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        zzfp zzfp;
        if (zzjg instanceof zzp.zzb) {
            zzp.zzb zzb2 = (zzp.zzb) zzjg;
            this.zza = Strings.emptyToNull(zzb2.zza());
            this.zzb = zzb2.zzd();
            this.zzc = Strings.emptyToNull(zzb2.zze());
            this.zzd = zzb2.zzf();
            if (zzb2.zzc() == 0) {
                zzfp = zzfp.zzb();
            } else {
                zzfp = new zzfp(1, new ArrayList(zzb2.zzb()));
            }
            this.zze = zzfp;
            this.zzf = zzb2.zzh() == 0 ? new ArrayList<>(0) : zzb2.zzg();
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of CreateAuthUriResponse.");
    }
}
