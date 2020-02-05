package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.zzaa;
import com.google.firebase.auth.zzae;
import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "DefaultMultiFactorSessionCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzw extends zzaa {
    public static final Parcelable.Creator<zzw> CREATOR = new zzv();
    @SafeParcelable.Field(getter = "getIdToken", id = 1)
    @Nullable
    private String zza;
    @SafeParcelable.Field(getter = "getPendingCredential", id = 2)
    @Nullable
    private String zzb;
    @SafeParcelable.Field(getter = "getPhoneMultiFactorInfoList", id = 3)
    @Nullable
    private List<zzae> zzc;

    private zzw() {
    }

    @SafeParcelable.Constructor
    zzw(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) List<zzae> list) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = list;
    }

    public static zzw zza(List<zzy> list, String str) {
        Preconditions.checkNotNull(list);
        Preconditions.checkNotEmpty(str);
        zzw zzw = new zzw();
        zzw.zzc = new ArrayList();
        for (zzy next : list) {
            if (next instanceof zzae) {
                zzw.zzc.add((zzae) next);
            }
        }
        zzw.zzb = str;
        return zzw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
