package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.zzg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "GetAccountInfoUserListCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzeu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeu> CREATOR = new zzet();
    @SafeParcelable.Field(getter = "getUsers", id = 2)
    private List<zzes> zza;

    public zzeu() {
        this.zza = new ArrayList();
    }

    @SafeParcelable.Constructor
    zzeu(@SafeParcelable.Param(id = 2) List<zzes> list) {
        List<zzes> list2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.zza = list2;
    }

    public final List<zzes> zza() {
        return this.zza;
    }

    public static zzeu zza(zzeu zzeu) {
        Preconditions.checkNotNull(zzeu);
        List<zzes> list = zzeu.zza;
        zzeu zzeu2 = new zzeu();
        if (list != null && !list.isEmpty()) {
            zzeu2.zza.addAll(list);
        }
        return zzeu2;
    }

    public static zzeu zza(zzp.zzg zzg) {
        ArrayList arrayList = new ArrayList(zzg.zza());
        for (int i = 0; i < zzg.zza(); i++) {
            zzz zza2 = zzg.zza(i);
            zzes zzes = r4;
            zzes zzes2 = new zzes(Strings.emptyToNull(zza2.zza()), Strings.emptyToNull(zza2.zzb()), zza2.zze(), Strings.emptyToNull(zza2.zzc()), Strings.emptyToNull(zza2.zzd()), zzfe.zza(zza2.zzf()), Strings.emptyToNull(zza2.zzi()), Strings.emptyToNull(zza2.zzj()), zza2.zzh(), zza2.zzg(), false, (zzg) null, zzfa.zza(zza2.zzk()));
            arrayList.add(zzes);
        }
        return new zzeu(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
