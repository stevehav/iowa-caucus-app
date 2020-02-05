package com.google.android.gms.internal.firebase_auth;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.api.internal.zzfk;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzew implements zzfk<zzp.zzh> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private ActionCodeSettings zze;
    @Nullable
    private String zzf;

    public zzew(zzgd zzgd) {
        this.zza = zza(zzgd);
    }

    private zzew(zzgd zzgd, ActionCodeSettings actionCodeSettings, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.zza = zza((zzgd) Preconditions.checkNotNull(zzgd));
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        this.zzb = null;
        this.zzc = str2;
        this.zzd = str3;
        this.zzf = null;
    }

    public static zzew zza(ActionCodeSettings actionCodeSettings, String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(actionCodeSettings);
        return new zzew(zzgd.VERIFY_AND_CHANGE_EMAIL, actionCodeSettings, (String) null, str2, str, (String) null);
    }

    public final zzew zza(String str) {
        this.zzb = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzew zzb(String str) {
        this.zzd = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzew zza(ActionCodeSettings actionCodeSettings) {
        this.zze = (ActionCodeSettings) Preconditions.checkNotNull(actionCodeSettings);
        return this;
    }

    public final zzew zzc(@Nullable String str) {
        this.zzf = str;
        return this;
    }

    public final ActionCodeSettings zzb() {
        return this.zze;
    }

    private static String zza(zzgd zzgd) {
        int i = zzev.zza[zzgd.ordinal()];
        if (i == 1) {
            return "PASSWORD_RESET";
        }
        if (i == 2) {
            return "VERIFY_EMAIL";
        }
        if (i != 3) {
            return i != 4 ? "REQUEST_TYPE_UNSET_ENUM_VALUE" : "VERIFY_BEFORE_UPDATE_EMAIL";
        }
        return "EMAIL_SIGNIN";
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzjg zza() {
        /*
            r6 = this;
            com.google.android.gms.internal.firebase_auth.zzp$zzh$zza r0 = com.google.android.gms.internal.firebase_auth.zzp.zzh.zza()
            java.lang.String r1 = r6.zza
            int r2 = r1.hashCode()
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r2) {
                case -1452371317: goto L_0x002f;
                case -1341836234: goto L_0x0025;
                case -1288726400: goto L_0x001b;
                case 870738373: goto L_0x0011;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x0039
        L_0x0011:
            java.lang.String r2 = "EMAIL_SIGNIN"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0039
            r1 = 2
            goto L_0x003a
        L_0x001b:
            java.lang.String r2 = "VERIFY_BEFORE_UPDATE_EMAIL"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0039
            r1 = 3
            goto L_0x003a
        L_0x0025:
            java.lang.String r2 = "VERIFY_EMAIL"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0039
            r1 = 1
            goto L_0x003a
        L_0x002f:
            java.lang.String r2 = "PASSWORD_RESET"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0039
            r1 = 0
            goto L_0x003a
        L_0x0039:
            r1 = -1
        L_0x003a:
            if (r1 == 0) goto L_0x004e
            if (r1 == r5) goto L_0x004b
            if (r1 == r4) goto L_0x0048
            if (r1 == r3) goto L_0x0045
            com.google.android.gms.internal.firebase_auth.zzgd r1 = com.google.android.gms.internal.firebase_auth.zzgd.OOB_REQ_TYPE_UNSPECIFIED
            goto L_0x0050
        L_0x0045:
            com.google.android.gms.internal.firebase_auth.zzgd r1 = com.google.android.gms.internal.firebase_auth.zzgd.VERIFY_AND_CHANGE_EMAIL
            goto L_0x0050
        L_0x0048:
            com.google.android.gms.internal.firebase_auth.zzgd r1 = com.google.android.gms.internal.firebase_auth.zzgd.EMAIL_SIGNIN
            goto L_0x0050
        L_0x004b:
            com.google.android.gms.internal.firebase_auth.zzgd r1 = com.google.android.gms.internal.firebase_auth.zzgd.VERIFY_EMAIL
            goto L_0x0050
        L_0x004e:
            com.google.android.gms.internal.firebase_auth.zzgd r1 = com.google.android.gms.internal.firebase_auth.zzgd.PASSWORD_RESET
        L_0x0050:
            com.google.android.gms.internal.firebase_auth.zzp$zzh$zza r0 = r0.zza((com.google.android.gms.internal.firebase_auth.zzgd) r1)
            java.lang.String r1 = r6.zzb
            if (r1 == 0) goto L_0x005b
            r0.zza((java.lang.String) r1)
        L_0x005b:
            java.lang.String r1 = r6.zzc
            if (r1 == 0) goto L_0x0062
            r0.zzb((java.lang.String) r1)
        L_0x0062:
            java.lang.String r1 = r6.zzd
            if (r1 == 0) goto L_0x0069
            r0.zzc(r1)
        L_0x0069:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            if (r1 == 0) goto L_0x00e4
            boolean r1 = r1.getAndroidInstallApp()
            com.google.android.gms.internal.firebase_auth.zzp$zzh$zza r1 = r0.zza((boolean) r1)
            com.google.firebase.auth.ActionCodeSettings r2 = r6.zze
            boolean r2 = r2.canHandleCodeInApp()
            r1.zzb((boolean) r2)
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.getUrl()
            if (r1 == 0) goto L_0x008f
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.getUrl()
            r0.zzd(r1)
        L_0x008f:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.getIOSBundle()
            if (r1 == 0) goto L_0x00a0
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.getIOSBundle()
            r0.zze(r1)
        L_0x00a0:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.zzb()
            if (r1 == 0) goto L_0x00b1
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.zzb()
            r0.zzf(r1)
        L_0x00b1:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.getAndroidPackageName()
            if (r1 == 0) goto L_0x00c2
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.getAndroidPackageName()
            r0.zzg(r1)
        L_0x00c2:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.getAndroidMinimumVersion()
            if (r1 == 0) goto L_0x00d3
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.getAndroidMinimumVersion()
            r0.zzh(r1)
        L_0x00d3:
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.zze()
            if (r1 == 0) goto L_0x00e4
            com.google.firebase.auth.ActionCodeSettings r1 = r6.zze
            java.lang.String r1 = r1.zze()
            r0.zzj(r1)
        L_0x00e4:
            java.lang.String r1 = r6.zzf
            if (r1 == 0) goto L_0x00eb
            r0.zzi(r1)
        L_0x00eb:
            com.google.android.gms.internal.firebase_auth.zzjg r0 = r0.zzf()
            com.google.android.gms.internal.firebase_auth.zzhx r0 = (com.google.android.gms.internal.firebase_auth.zzhx) r0
            com.google.android.gms.internal.firebase_auth.zzp$zzh r0 = (com.google.android.gms.internal.firebase_auth.zzp.zzh) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzew.zza():com.google.android.gms.internal.firebase_auth.zzjg");
    }
}
