package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "MfaInfoCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfa> CREATOR = new zzez();
    @SafeParcelable.Field(getter = "getPhoneInfo", id = 1)
    @Nullable
    private final String zza;
    @SafeParcelable.Field(getter = "getMfaEnrollmentId", id = 2)
    @NonNull
    private final String zzb;
    @SafeParcelable.Field(getter = "getDisplayName", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getEnrolledAtTimestampInSeconds", id = 4)
    private final long zzd;
    @Nullable
    private String zze;

    @SafeParcelable.Constructor
    public zzfa(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) long j) {
        this.zza = str;
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = j;
    }

    @Nullable
    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzd;
    }

    public static zzfa zza(zzr zzr) {
        zzfa zzfa = new zzfa(zzr.zza(), zzr.zzb(), zzr.zzc(), zzr.zzd().zza());
        zzfa.zze = zzr.zze();
        return zzfa;
    }

    public static List<zzfa> zza(List<zzr> list) {
        if (list == null) {
            return zzaz.zza();
        }
        ArrayList arrayList = new ArrayList();
        for (zzr zza2 : list) {
            arrayList.add(zza(zza2));
        }
        return arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
