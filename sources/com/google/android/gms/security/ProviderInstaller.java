package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final Object lock = new Object();
    /* access modifiers changed from: private */
    public static final GoogleApiAvailabilityLight zziv = GoogleApiAvailabilityLight.getInstance();
    private static Method zziw = null;

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: java.lang.Throwable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v7, resolved type: java.lang.Exception} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void installIfNeeded(android.content.Context r8) throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException {
        /*
            java.lang.String r0 = "Context must not be null"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r8, r0)
            com.google.android.gms.common.GoogleApiAvailabilityLight r0 = zziv
            r1 = 11925000(0xb5f608, float:1.6710484E-38)
            r0.verifyGooglePlayServicesIsAvailable(r8, r1)
            android.content.Context r0 = zzk(r8)
            if (r0 != 0) goto L_0x0017
            android.content.Context r0 = zzl(r8)
        L_0x0017:
            r1 = 8
            if (r0 == 0) goto L_0x008d
            java.lang.Object r2 = lock
            monitor-enter(r2)
            java.lang.reflect.Method r3 = zziw     // Catch:{ Exception -> 0x004a }
            r4 = 0
            r5 = 1
            if (r3 != 0) goto L_0x003c
            java.lang.ClassLoader r3 = r0.getClassLoader()     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = "com.google.android.gms.common.security.ProviderInstallerImpl"
            java.lang.Class r3 = r3.loadClass(r6)     // Catch:{ Exception -> 0x004a }
            java.lang.Class[] r6 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x004a }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r4] = r7     // Catch:{ Exception -> 0x004a }
            java.lang.String r7 = "insertProvider"
            java.lang.reflect.Method r3 = r3.getMethod(r7, r6)     // Catch:{ Exception -> 0x004a }
            zziw = r3     // Catch:{ Exception -> 0x004a }
        L_0x003c:
            java.lang.reflect.Method r3 = zziw     // Catch:{ Exception -> 0x004a }
            r6 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x004a }
            r5[r4] = r0     // Catch:{ Exception -> 0x004a }
            r3.invoke(r6, r5)     // Catch:{ Exception -> 0x004a }
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            return
        L_0x0048:
            r8 = move-exception
            goto L_0x008b
        L_0x004a:
            r0 = move-exception
            java.lang.Throwable r3 = r0.getCause()     // Catch:{ all -> 0x0048 }
            java.lang.String r4 = "ProviderInstaller"
            r5 = 6
            boolean r4 = android.util.Log.isLoggable(r4, r5)     // Catch:{ all -> 0x0048 }
            if (r4 == 0) goto L_0x007e
            if (r3 != 0) goto L_0x005f
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0048 }
            goto L_0x0063
        L_0x005f:
            java.lang.String r4 = r3.getMessage()     // Catch:{ all -> 0x0048 }
        L_0x0063:
            java.lang.String r5 = "ProviderInstaller"
            java.lang.String r6 = "Failed to install provider: "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0048 }
            int r7 = r4.length()     // Catch:{ all -> 0x0048 }
            if (r7 == 0) goto L_0x0076
            java.lang.String r4 = r6.concat(r4)     // Catch:{ all -> 0x0048 }
            goto L_0x007b
        L_0x0076:
            java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x0048 }
            r4.<init>(r6)     // Catch:{ all -> 0x0048 }
        L_0x007b:
            android.util.Log.e(r5, r4)     // Catch:{ all -> 0x0048 }
        L_0x007e:
            if (r3 != 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r0 = r3
        L_0x0082:
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r8, r0)     // Catch:{ all -> 0x0048 }
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r8 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException     // Catch:{ all -> 0x0048 }
            r8.<init>(r1)     // Catch:{ all -> 0x0048 }
            throw r8     // Catch:{ all -> 0x0048 }
        L_0x008b:
            monitor-exit(r2)     // Catch:{ all -> 0x0048 }
            throw r8
        L_0x008d:
            java.lang.String r8 = "ProviderInstaller"
            java.lang.String r0 = "Failed to get remote context"
            android.util.Log.e(r8, r0)
            com.google.android.gms.common.GooglePlayServicesNotAvailableException r8 = new com.google.android.gms.common.GooglePlayServicesNotAvailableException
            r8.<init>(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.security.ProviderInstaller.installIfNeeded(android.content.Context):void");
    }

    public static void installIfNeededAsync(Context context, ProviderInstallListener providerInstallListener) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Preconditions.checkNotNull(providerInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        new zza(context, providerInstallListener).execute(new Void[0]);
    }

    @Nullable
    private static Context zzk(Context context) {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "providerinstaller").getModuleContext();
        } catch (DynamiteModule.LoadingException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load providerinstaller module: ".concat(valueOf) : new String("Failed to load providerinstaller module: "));
            return null;
        }
    }

    @Nullable
    private static Context zzl(Context context) {
        try {
            return GooglePlayServicesUtilLight.getRemoteContext(context);
        } catch (Resources.NotFoundException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load GMS Core context for providerinstaller: ".concat(valueOf) : new String("Failed to load GMS Core context for providerinstaller: "));
            CrashUtils.addDynamiteErrorToDropBox(context, e);
            return null;
        }
    }
}
