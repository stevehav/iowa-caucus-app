package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzea;
import java.util.List;

@SafeParcelable.Class(creator = "GetAccountInfoResponseCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzeq extends AbstractSafeParcelable implements zzea<zzeq, zzp.zzg> {
    public static final Parcelable.Creator<zzeq> CREATOR = new zzep();
    @SafeParcelable.Field(getter = "getUserList", id = 2)
    private zzeu zza;

    public zzeq() {
    }

    @SafeParcelable.Constructor
    zzeq(@SafeParcelable.Param(id = 2) zzeu zzeu) {
        zzeu zzeu2;
        if (zzeu == null) {
            zzeu2 = new zzeu();
        } else {
            zzeu2 = zzeu.zza(zzeu);
        }
        this.zza = zzeu2;
    }

    public final List<zzes> zzb() {
        return this.zza.zza();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zza, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzjq<zzp.zzg> zza() {
        return zzp.zzg.zzb();
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        if (zzjg instanceof zzp.zzg) {
            zzp.zzg zzg = (zzp.zzg) zzjg;
            if (zzg.zza() == 0) {
                this.zza = new zzeu();
            } else {
                this.zza = zzeu.zza(zzg);
            }
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of GetAccountInfoResponse.");
    }
}
