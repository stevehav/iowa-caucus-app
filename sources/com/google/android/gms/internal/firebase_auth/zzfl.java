package com.google.android.gms.internal.firebase_auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzp;
import com.google.firebase.auth.api.internal.zzfk;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public final class zzfl implements zzfk<zzp.zzm> {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private zzfp zzf = new zzfp();
    private zzfp zzg = new zzfp();
    private boolean zzh = true;
    private String zzi;
    @Nullable
    private String zzj;

    public final boolean zza(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzg.zza().contains(str);
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    @Nullable
    public final String zzc() {
        return this.zzc;
    }

    @Nullable
    public final String zzd() {
        return this.zzd;
    }

    @Nullable
    public final String zze() {
        return this.zze;
    }

    @NonNull
    public final zzfl zzb(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
        return this;
    }

    @NonNull
    public final zzfl zzc(@Nullable String str) {
        if (str == null) {
            this.zzg.zza().add("EMAIL");
        } else {
            this.zzb = str;
        }
        return this;
    }

    @NonNull
    public final zzfl zzd(@Nullable String str) {
        if (str == null) {
            this.zzg.zza().add("PASSWORD");
        } else {
            this.zzc = str;
        }
        return this;
    }

    @NonNull
    public final zzfl zze(@Nullable String str) {
        if (str == null) {
            this.zzg.zza().add("DISPLAY_NAME");
        } else {
            this.zzd = str;
        }
        return this;
    }

    @NonNull
    public final zzfl zzf(@Nullable String str) {
        if (str == null) {
            this.zzg.zza().add("PHOTO_URL");
        } else {
            this.zze = str;
        }
        return this;
    }

    @NonNull
    public final zzfl zzg(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzf.zza().add(str);
        return this;
    }

    @NonNull
    public final zzfl zzh(String str) {
        this.zzi = Preconditions.checkNotEmpty(str);
        return this;
    }

    @NonNull
    public final zzfl zzi(@Nullable String str) {
        this.zzj = str;
        return this;
    }

    public final /* synthetic */ zzjg zza() {
        zzv zzv;
        zzp.zzm.zza zzb2 = zzp.zzm.zza().zza(this.zzh).zzb((Iterable<String>) this.zzf.zza());
        List<String> zza2 = this.zzg.zza();
        zzv[] zzvArr = new zzv[zza2.size()];
        for (int i = 0; i < zza2.size(); i++) {
            String str = zza2.get(i);
            char c = 65535;
            switch (str.hashCode()) {
                case -333046776:
                    if (str.equals("DISPLAY_NAME")) {
                        c = 1;
                        break;
                    }
                    break;
                case 66081660:
                    if (str.equals("EMAIL")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1939891618:
                    if (str.equals("PHOTO_URL")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1999612571:
                    if (str.equals("PASSWORD")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                zzv = zzv.EMAIL;
            } else if (c == 1) {
                zzv = zzv.DISPLAY_NAME;
            } else if (c == 2) {
                zzv = zzv.PASSWORD;
            } else if (c != 3) {
                zzv = zzv.USER_ATTRIBUTE_NAME_UNSPECIFIED;
            } else {
                zzv = zzv.PHOTO_URL;
            }
            zzvArr[i] = zzv;
        }
        zzp.zzm.zza zza3 = zzb2.zza((Iterable<? extends zzv>) Arrays.asList(zzvArr));
        String str2 = this.zza;
        if (str2 != null) {
            zza3.zza(str2);
        }
        String str3 = this.zzb;
        if (str3 != null) {
            zza3.zzc(str3);
        }
        String str4 = this.zzc;
        if (str4 != null) {
            zza3.zzd(str4);
        }
        String str5 = this.zzd;
        if (str5 != null) {
            zza3.zzb(str5);
        }
        String str6 = this.zze;
        if (str6 != null) {
            zza3.zzf(str6);
        }
        String str7 = this.zzi;
        if (str7 != null) {
            zza3.zze(str7);
        }
        String str8 = this.zzj;
        if (str8 != null) {
            zza3.zzg(str8);
        }
        return (zzp.zzm) ((zzhx) zza3.zzf());
    }
}
