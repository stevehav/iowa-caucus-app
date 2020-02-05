package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzed;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzab;
import com.google.firebase.auth.zzae;
import com.google.firebase.auth.zzg;
import com.google.firebase.auth.zzy;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "DefaultMultiFactorResolverCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzu extends zzab {
    public static final Parcelable.Creator<zzu> CREATOR = new zzt();
    @SafeParcelable.Field(getter = "getPhoneMultiFactorInfoList", id = 1)
    private final List<zzae> zza = new ArrayList();
    @SafeParcelable.Field(getter = "getSession", id = 2)
    private final zzw zzb;
    @SafeParcelable.Field(getter = "getFirebaseAppName", id = 3)
    private final String zzc;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", id = 4)
    private final zzg zzd;
    @SafeParcelable.Field(getter = "getReauthUser", id = 5)
    private final zzn zze;

    @SafeParcelable.Constructor
    public zzu(@SafeParcelable.Param(id = 1) List<zzae> list, @SafeParcelable.Param(id = 2) zzw zzw, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) @Nullable zzg zzg, @SafeParcelable.Param(id = 5) @Nullable zzn zzn) {
        for (zzy next : list) {
            if (next instanceof zzae) {
                this.zza.add((zzae) next);
            }
        }
        this.zzb = (zzw) Preconditions.checkNotNull(zzw);
        this.zzc = Preconditions.checkNotEmpty(str);
        this.zzd = zzg;
        this.zze = zzn;
    }

    public static zzu zza(zzed zzed, FirebaseAuth firebaseAuth, @Nullable FirebaseUser firebaseUser) {
        List<zzy> zzc2 = zzed.zzc();
        ArrayList arrayList = new ArrayList();
        for (zzy next : zzc2) {
            if (next instanceof zzae) {
                arrayList.add((zzae) next);
            }
        }
        return new zzu(arrayList, zzw.zza(zzed.zzc(), zzed.zza()), firebaseAuth.zzb().getName(), zzed.zzb(), (zzn) firebaseUser);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
