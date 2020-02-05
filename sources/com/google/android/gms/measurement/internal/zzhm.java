package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.MainThread;

@TargetApi(14)
@MainThread
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
final class zzhm implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzgt zza;

    private zzhm(zzgt zzgt) {
        this.zza = zzgt;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d3 A[Catch:{ Exception -> 0x01d6, all -> 0x01d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0123 A[Catch:{ Exception -> 0x01d6, all -> 0x01d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015f A[SYNTHETIC, Splitter:B:75:0x015f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onActivityCreated(android.app.Activity r20, android.os.Bundle r21) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            r3 = r21
            java.lang.String r0 = "referrer"
            com.google.android.gms.measurement.internal.zzgt r4 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzx()     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r5 = "onActivityCreated"
            r4.zza(r5)     // Catch:{ Exception -> 0x01d6 }
            android.content.Intent r4 = r20.getIntent()     // Catch:{ Exception -> 0x01d6 }
            if (r4 != 0) goto L_0x0027
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza
            com.google.android.gms.measurement.internal.zzhx r0 = r0.zzi()
            r0.zza((android.app.Activity) r2, (android.os.Bundle) r3)
            return
        L_0x0027:
            android.net.Uri r5 = r4.getData()     // Catch:{ Exception -> 0x01d6 }
            if (r5 == 0) goto L_0x01ca
            boolean r6 = r5.isHierarchical()     // Catch:{ Exception -> 0x01d6 }
            if (r6 != 0) goto L_0x0035
            goto L_0x01ca
        L_0x0035:
            com.google.android.gms.measurement.internal.zzgt r6 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            r6.zzp()     // Catch:{ Exception -> 0x01d6 }
            boolean r4 = com.google.android.gms.measurement.internal.zzjx.zza((android.content.Intent) r4)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r6 = "auto"
            if (r4 == 0) goto L_0x0045
            java.lang.String r4 = "gs"
            goto L_0x0046
        L_0x0045:
            r4 = r6
        L_0x0046:
            java.lang.String r7 = r5.getQueryParameter(r0)     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzgt r8 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzs r8 = r8.zzt()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzak.zzcc     // Catch:{ Exception -> 0x01d6 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean>) r9)     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r9 = "Activity created with data 'referrer' without required params"
            java.lang.String r10 = "utm_medium"
            java.lang.String r11 = "_cis"
            java.lang.String r12 = "utm_source"
            java.lang.String r13 = "utm_campaign"
            java.lang.String r15 = "gclid"
            if (r8 != 0) goto L_0x0077
            com.google.android.gms.measurement.internal.zzgt r8 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzs r8 = r8.zzt()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzak.zzcd     // Catch:{ Exception -> 0x01d6 }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean>) r14)     // Catch:{ Exception -> 0x01d6 }
            if (r8 == 0) goto L_0x0073
            goto L_0x0077
        L_0x0073:
            r17 = r9
            r14 = 0
            goto L_0x00d0
        L_0x0077:
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d6 }
            if (r8 == 0) goto L_0x007e
            goto L_0x0073
        L_0x007e:
            boolean r8 = r7.contains(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r8 != 0) goto L_0x00a4
            boolean r8 = r7.contains(r13)     // Catch:{ Exception -> 0x01d6 }
            if (r8 != 0) goto L_0x00a4
            boolean r8 = r7.contains(r12)     // Catch:{ Exception -> 0x01d6 }
            if (r8 != 0) goto L_0x00a4
            boolean r8 = r7.contains(r10)     // Catch:{ Exception -> 0x01d6 }
            if (r8 != 0) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzr()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzw()     // Catch:{ Exception -> 0x01d6 }
            r0.zza(r9)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x0073
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzgt r8 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzjx r8 = r8.zzp()     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r14 = "https://google.com/search?"
            r17 = r9
            java.lang.String r9 = java.lang.String.valueOf(r7)     // Catch:{ Exception -> 0x01d6 }
            int r18 = r9.length()     // Catch:{ Exception -> 0x01d6 }
            if (r18 == 0) goto L_0x00bd
            java.lang.String r9 = r14.concat(r9)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x00c2
        L_0x00bd:
            java.lang.String r9 = new java.lang.String     // Catch:{ Exception -> 0x01d6 }
            r9.<init>(r14)     // Catch:{ Exception -> 0x01d6 }
        L_0x00c2:
            android.net.Uri r9 = android.net.Uri.parse(r9)     // Catch:{ Exception -> 0x01d6 }
            android.os.Bundle r8 = r8.zza((android.net.Uri) r9)     // Catch:{ Exception -> 0x01d6 }
            if (r8 == 0) goto L_0x00cf
            r8.putString(r11, r0)     // Catch:{ Exception -> 0x01d6 }
        L_0x00cf:
            r14 = r8
        L_0x00d0:
            r8 = 1
            if (r3 != 0) goto L_0x0123
            com.google.android.gms.measurement.internal.zzgt r9 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzjx r9 = r9.zzp()     // Catch:{ Exception -> 0x01d6 }
            android.os.Bundle r5 = r9.zza((android.net.Uri) r5)     // Catch:{ Exception -> 0x01d6 }
            if (r5 == 0) goto L_0x0120
            java.lang.String r9 = "intent"
            r5.putString(r11, r9)     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzgt r9 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzs r9 = r9.zzt()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzak.zzcc     // Catch:{ Exception -> 0x01d6 }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean>) r11)     // Catch:{ Exception -> 0x01d6 }
            if (r9 == 0) goto L_0x0116
            boolean r9 = r5.containsKey(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r9 != 0) goto L_0x0116
            if (r14 == 0) goto L_0x0116
            boolean r9 = r14.containsKey(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r9 == 0) goto L_0x0116
            java.lang.String r9 = "_cer"
            java.lang.String r11 = "gclid=%s"
            java.lang.Object[] r0 = new java.lang.Object[r8]     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r16 = r14.getString(r15)     // Catch:{ Exception -> 0x01d6 }
            r18 = 0
            r0[r18] = r16     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r0 = java.lang.String.format(r11, r0)     // Catch:{ Exception -> 0x01d6 }
            r5.putString(r9, r0)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x0118
        L_0x0116:
            r18 = 0
        L_0x0118:
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r9 = "_cmp"
            r0.zza((java.lang.String) r4, (java.lang.String) r9, (android.os.Bundle) r5)     // Catch:{ Exception -> 0x01d6 }
            goto L_0x0126
        L_0x0120:
            r18 = 0
            goto L_0x0126
        L_0x0123:
            r18 = 0
            r5 = 0
        L_0x0126:
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzt()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzak.zzcd     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean>) r4)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x014f
            if (r14 == 0) goto L_0x014f
            boolean r0 = r14.containsKey(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x014f
            if (r5 == 0) goto L_0x0144
            boolean r0 = r5.containsKey(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x014f
        L_0x0144:
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r4 = "_lgclid"
            java.lang.String r5 = r14.getString(r15)     // Catch:{ Exception -> 0x01d6 }
            r0.zza((java.lang.String) r6, (java.lang.String) r4, (java.lang.Object) r5, (boolean) r8)     // Catch:{ Exception -> 0x01d6 }
        L_0x014f:
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x015f
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza
            com.google.android.gms.measurement.internal.zzhx r0 = r0.zzi()
            r0.zza((android.app.Activity) r2, (android.os.Bundle) r3)
            return
        L_0x015f:
            boolean r0 = r7.contains(r15)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x0189
            boolean r0 = r7.contains(r13)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x0187
            boolean r0 = r7.contains(r12)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x0187
            boolean r0 = r7.contains(r10)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x0187
            java.lang.String r0 = "utm_term"
            boolean r0 = r7.contains(r0)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x0187
            java.lang.String r0 = "utm_content"
            boolean r0 = r7.contains(r0)     // Catch:{ Exception -> 0x01d6 }
            if (r0 == 0) goto L_0x0189
        L_0x0187:
            r18 = 1
        L_0x0189:
            if (r18 != 0) goto L_0x01a4
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzr()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzw()     // Catch:{ Exception -> 0x01d6 }
            r4 = r17
            r0.zza(r4)     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza
            com.google.android.gms.measurement.internal.zzhx r0 = r0.zzi()
            r0.zza((android.app.Activity) r2, (android.os.Bundle) r3)
            return
        L_0x01a4:
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzr()     // Catch:{ Exception -> 0x01d6 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzw()     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r4 = "Activity created with referrer"
            r0.zza(r4, r7)     // Catch:{ Exception -> 0x01d6 }
            boolean r0 = android.text.TextUtils.isEmpty(r7)     // Catch:{ Exception -> 0x01d6 }
            if (r0 != 0) goto L_0x01c0
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza     // Catch:{ Exception -> 0x01d6 }
            java.lang.String r4 = "_ldl"
            r0.zza((java.lang.String) r6, (java.lang.String) r4, (java.lang.Object) r7, (boolean) r8)     // Catch:{ Exception -> 0x01d6 }
        L_0x01c0:
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza
            com.google.android.gms.measurement.internal.zzhx r0 = r0.zzi()
            r0.zza((android.app.Activity) r2, (android.os.Bundle) r3)
            return
        L_0x01ca:
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza
            com.google.android.gms.measurement.internal.zzhx r0 = r0.zzi()
            r0.zza((android.app.Activity) r2, (android.os.Bundle) r3)
            return
        L_0x01d4:
            r0 = move-exception
            goto L_0x01f0
        L_0x01d6:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzgt r4 = r1.zza     // Catch:{ all -> 0x01d4 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ all -> 0x01d4 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()     // Catch:{ all -> 0x01d4 }
            java.lang.String r5 = "Throwable caught in onActivityCreated"
            r4.zza(r5, r0)     // Catch:{ all -> 0x01d4 }
            com.google.android.gms.measurement.internal.zzgt r0 = r1.zza
            com.google.android.gms.measurement.internal.zzhx r0 = r0.zzi()
            r0.zza((android.app.Activity) r2, (android.os.Bundle) r3)
            return
        L_0x01f0:
            com.google.android.gms.measurement.internal.zzgt r4 = r1.zza
            com.google.android.gms.measurement.internal.zzhx r4 = r4.zzi()
            r4.zza((android.app.Activity) r2, (android.os.Bundle) r3)
            goto L_0x01fb
        L_0x01fa:
            throw r0
        L_0x01fb:
            goto L_0x01fa
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhm.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzi().zzc(activity);
    }

    @MainThread
    public final void onActivityPaused(Activity activity) {
        this.zza.zzi().zzb(activity);
        zzjd zzk = this.zza.zzk();
        zzk.zzq().zza((Runnable) new zzjj(zzk, zzk.zzm().elapsedRealtime()));
    }

    @MainThread
    public final void onActivityResumed(Activity activity) {
        this.zza.zzi().zza(activity);
        zzjd zzk = this.zza.zzk();
        zzk.zzq().zza((Runnable) new zzjg(zzk, zzk.zzm().elapsedRealtime()));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzi().zzb(activity, bundle);
    }

    /* synthetic */ zzhm(zzgt zzgt, zzgv zzgv) {
        this(zzgt);
    }
}
