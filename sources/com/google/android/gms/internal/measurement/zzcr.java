package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzcr {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;
    final boolean zzh;
    @Nullable
    final zzcv<Context, Boolean> zzi;

    public zzcr(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (zzcv<Context, Boolean>) null);
    }

    private zzcr(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable zzcv<Context, Boolean> zzcv) {
        this.zza = null;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = false;
        this.zzf = false;
        this.zzg = false;
        this.zzh = false;
        this.zzi = null;
    }

    public final zzcl<Long> zza(String str, long j) {
        return zzcl.zzb(this, str, j);
    }

    public final zzcl<Boolean> zza(String str, boolean z) {
        return zzcl.zzb(this, str, z);
    }

    public final zzcl<Double> zza(String str, double d) {
        return zzcl.zzb(this, str, -3.0d);
    }

    public final zzcl<String> zza(String str, String str2) {
        return zzcl.zzb(this, str, str2);
    }
}
