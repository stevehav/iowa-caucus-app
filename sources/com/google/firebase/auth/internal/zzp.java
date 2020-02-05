package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "DefaultFirebaseUserMetadataCreator")
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzp implements FirebaseUserMetadata {
    public static final Parcelable.Creator<zzp> CREATOR = new zzs();
    @SafeParcelable.Field(getter = "getLastSignInTimestamp", id = 1)
    private long zza;
    @SafeParcelable.Field(getter = "getCreationTimestamp", id = 2)
    private long zzb;

    @SafeParcelable.Constructor
    public zzp(@SafeParcelable.Param(id = 1) long j, @SafeParcelable.Param(id = 2) long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    public final int describeContents() {
        return 0;
    }

    public final long getLastSignInTimestamp() {
        return this.zza;
    }

    public final long getCreationTimestamp() {
        return this.zzb;
    }

    public final JSONObject zza() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.zza);
            jSONObject.put("creationTimestamp", this.zzb);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public static zzp zza(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new zzp(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getLastSignInTimestamp());
        SafeParcelWriter.writeLong(parcel, 2, getCreationTimestamp());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
