package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "ProviderUserInfoListCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfe> CREATOR = new zzfd();
    @SafeParcelable.Field(getter = "getProviderUserInfos", id = 2)
    private List<zzfc> zza;

    public zzfe() {
        this.zza = new ArrayList();
    }

    @SafeParcelable.Constructor
    zzfe(@SafeParcelable.Param(id = 2) List<zzfc> list) {
        if (list == null || list.isEmpty()) {
            this.zza = Collections.emptyList();
        } else {
            this.zza = Collections.unmodifiableList(list);
        }
    }

    public final List<zzfc> zza() {
        return this.zza;
    }

    public static zzfe zza(zzfe zzfe) {
        List<zzfc> list = zzfe.zza;
        zzfe zzfe2 = new zzfe();
        if (list != null) {
            zzfe2.zza.addAll(list);
        }
        return zzfe2;
    }

    public static zzfe zza(List<zzu> list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            zzu zzu = list.get(i);
            arrayList.add(new zzfc(Strings.emptyToNull(zzu.zzd()), Strings.emptyToNull(zzu.zzb()), Strings.emptyToNull(zzu.zzc()), Strings.emptyToNull(zzu.zza()), (String) null, Strings.emptyToNull(zzu.zzf()), Strings.emptyToNull(zzu.zze())));
        }
        return new zzfe(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
