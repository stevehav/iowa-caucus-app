package com.google.android.gms.vision.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.vision.zzdh;
import com.google.android.gms.internal.vision.zzdm;
import com.google.android.gms.internal.vision.zzdp;
import com.google.android.gms.internal.vision.zzdt;
import com.google.android.gms.internal.vision.zzdu;
import com.google.android.gms.vision.L;

@Keep
public class LogUtils {
    public static zzdu zza(long j, int i) {
        zzdu zzdu = new zzdu();
        zzdp zzdp = new zzdp();
        zzdu.zzqe = zzdp;
        zzdm zzdm = new zzdm();
        zzdp.zzpk = new zzdm[1];
        zzdp.zzpk[0] = zzdm;
        zzdm.zzot = Long.valueOf(j);
        zzdm.zzou = Long.valueOf((long) i);
        zzdm.zzov = new zzdt[i];
        return zzdu;
    }

    public static zzdh zzd(Context context) {
        zzdh zzdh = new zzdh();
        zzdh.zzod = context.getPackageName();
        String zze = zze(context);
        if (zze != null) {
            zzdh.version = zze;
        }
        return zzdh;
    }

    @Nullable
    private static String zze(Context context) {
        try {
            return Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            L.zza(e, "Unable to find calling package info for %s", context.getPackageName());
            return null;
        }
    }
}
