package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzf;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public final class zzey {
    final zzfn zza;

    zzey(zzfn zzfn) {
        this.zza = zzfn;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza(String str) {
        if (str == null || str.isEmpty()) {
            this.zza.zzr().zzv().zza("Install Referrer Reporter was called with invalid app package name");
            return;
        }
        this.zza.zzq().zzd();
        if (!zza()) {
            this.zza.zzr().zzv().zza("Install Referrer Reporter is not available");
            return;
        }
        this.zza.zzr().zzv().zza("Install Referrer Reporter is initializing");
        zzfb zzfb = new zzfb(this, str);
        this.zza.zzq().zzd();
        Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
        intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
        PackageManager packageManager = this.zza.zzn().getPackageManager();
        if (packageManager == null) {
            this.zza.zzr().zzi().zza("Failed to obtain Package Manager to verify binding conditions");
            return;
        }
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.zza.zzr().zzv().zza("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        ResolveInfo resolveInfo = queryIntentServices.get(0);
        if (resolveInfo.serviceInfo != null) {
            String str2 = resolveInfo.serviceInfo.packageName;
            if (resolveInfo.serviceInfo.name == null || !"com.android.vending".equals(str2) || !zza()) {
                this.zza.zzr().zzv().zza("Play Store missing or incompatible. Version 8.3.73 or later required");
                return;
            }
            try {
                this.zza.zzr().zzv().zza("Install Referrer Service is", ConnectionTracker.getInstance().bindService(this.zza.zzn(), new Intent(intent), zzfb, 1) ? "available" : "not available");
            } catch (Exception e) {
                this.zza.zzr().zzf().zza("Exception occurred while binding to Install Referrer Service", e.getMessage());
            }
        }
    }

    @VisibleForTesting
    private final boolean zza() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zzn());
            if (packageManager == null) {
                this.zza.zzr().zzv().zza("Failed to retrieve Package Manager to check Play Store compatibility");
                return false;
            } else if (packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            this.zza.zzr().zzv().zza("Failed to retrieve Play Store version", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @Nullable
    @VisibleForTesting
    public final Bundle zza(String str, zzf zzf) {
        this.zza.zzq().zzd();
        if (zzf == null) {
            this.zza.zzr().zzi().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle zza2 = zzf.zza(bundle);
            if (zza2 != null) {
                return zza2;
            }
            this.zza.zzr().zzf().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.zza.zzr().zzf().zza("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }
}
