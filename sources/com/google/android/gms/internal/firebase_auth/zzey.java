package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzlo;
import com.google.firebase.auth.api.internal.zzea;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GetTokenResponseCreator")
@SafeParcelable.Reserved({1})
/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzey extends AbstractSafeParcelable implements zzea<zzey, zzlo.zzb> {
    public static final Parcelable.Creator<zzey> CREATOR = new zzex();
    @SafeParcelable.Field(getter = "getRefreshToken", id = 2)
    private String zza;
    @SafeParcelable.Field(getter = "getAccessToken", id = 3)
    private String zzb;
    @SafeParcelable.Field(getter = "getExpiresIn", id = 4)
    private Long zzc;
    @SafeParcelable.Field(getter = "getTokenType", id = 5)
    private String zzd;
    @SafeParcelable.Field(getter = "getIssuedAt", id = 6)
    private Long zze;

    public zzey() {
        this.zze = Long.valueOf(System.currentTimeMillis());
    }

    public zzey(String str, String str2, Long l, String str3) {
        this(str, str2, l, str3, Long.valueOf(System.currentTimeMillis()));
    }

    @SafeParcelable.Constructor
    zzey(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) Long l, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) Long l2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = l;
        this.zzd = str3;
        this.zze = l2;
    }

    public final boolean zzb() {
        return DefaultClock.getInstance().currentTimeMillis() + 300000 < this.zze.longValue() + (this.zzc.longValue() * 1000);
    }

    public final void zza(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final long zze() {
        Long l = this.zzc;
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }

    @Nullable
    public final String zzf() {
        return this.zzd;
    }

    public final long zzg() {
        return this.zze.longValue();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeLongObject(parcel, 4, Long.valueOf(zze()), false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeLongObject(parcel, 6, Long.valueOf(this.zze.longValue()), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzjq<zzlo.zzb> zza() {
        return zzlo.zzb.zze();
    }

    public final String zzh() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.zza);
            jSONObject.put("access_token", this.zzb);
            jSONObject.put("expires_in", this.zzc);
            jSONObject.put("token_type", this.zzd);
            jSONObject.put("issued_at", this.zze);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to convert GetTokenResponse to JSON");
            throw new zzbq((Throwable) e);
        }
    }

    public static zzey zzb(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzey zzey = new zzey();
            zzey.zza = jSONObject.optString("refresh_token", (String) null);
            zzey.zzb = jSONObject.optString("access_token", (String) null);
            zzey.zzc = Long.valueOf(jSONObject.optLong("expires_in"));
            zzey.zzd = jSONObject.optString("token_type", (String) null);
            zzey.zze = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzey;
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to read GetTokenResponse from JSONObject");
            throw new zzbq((Throwable) e);
        }
    }

    public final /* synthetic */ zzea zza(zzjg zzjg) {
        if (zzjg instanceof zzlo.zzb) {
            zzlo.zzb zzb2 = (zzlo.zzb) zzjg;
            this.zza = Strings.emptyToNull(zzb2.zzd());
            this.zzb = Strings.emptyToNull(zzb2.zza());
            this.zzc = Long.valueOf(zzb2.zzb());
            this.zzd = Strings.emptyToNull(zzb2.zzc());
            this.zze = Long.valueOf(System.currentTimeMillis());
            return this;
        }
        throw new IllegalArgumentException("The passed proto must be an instance of GrantTokenResponse.");
    }
}
