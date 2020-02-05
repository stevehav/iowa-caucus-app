package com.google.android.gms.measurement.internal;

import android.os.Binder;
import android.text.TextUtils;
import androidx.annotation.BinderThread;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
public final class zzfo extends zzea {
    /* access modifiers changed from: private */
    public final zzjp zza;
    private Boolean zzb;
    @Nullable
    private String zzc;

    public zzfo(zzjp zzjp) {
        this(zzjp, (String) null);
    }

    private zzfo(zzjp zzjp, @Nullable String str) {
        Preconditions.checkNotNull(zzjp);
        this.zza = zzjp;
        this.zzc = null;
    }

    @BinderThread
    public final void zzb(zzn zzn) {
        zzb(zzn, false);
        zza((Runnable) new zzfr(this, zzn));
    }

    @BinderThread
    public final void zza(zzai zzai, zzn zzn) {
        Preconditions.checkNotNull(zzai);
        zzb(zzn, false);
        zza((Runnable) new zzgb(this, zzai, zzn));
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final zzai zzb(zzai zzai, zzn zzn) {
        boolean z = false;
        if (!(!"_cmp".equals(zzai.zza) || zzai.zzb == null || zzai.zzb.zza() == 0)) {
            String zzd = zzai.zzb.zzd("_cis");
            if (!TextUtils.isEmpty(zzd) && (("referrer broadcast".equals(zzd) || "referrer API".equals(zzd)) && this.zza.zzb().zzl(zzn.zza))) {
                z = true;
            }
        }
        if (!z) {
            return zzai;
        }
        this.zza.zzr().zzv().zza("Event has been filtered ", zzai.toString());
        return new zzai("_cmpx", zzai.zzb, zzai.zzc, zzai.zzd);
    }

    @BinderThread
    public final void zza(zzai zzai, String str, String str2) {
        Preconditions.checkNotNull(zzai);
        Preconditions.checkNotEmpty(str);
        zza(str, true);
        zza((Runnable) new zzga(this, zzai, str));
    }

    @BinderThread
    public final byte[] zza(zzai zzai, String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzai);
        zza(str, true);
        this.zza.zzr().zzw().zza("Log and bundle. event", this.zza.zzi().zza(zzai.zza));
        long nanoTime = this.zza.zzm().nanoTime() / 1000000;
        try {
            byte[] bArr = (byte[]) this.zza.zzq().zzb(new zzgd(this, zzai, str)).get();
            if (bArr == null) {
                this.zza.zzr().zzf().zza("Log and bundle returned null. appId", zzej.zza(str));
                bArr = new byte[0];
            }
            this.zza.zzr().zzw().zza("Log and bundle processed. event, size, time_ms", this.zza.zzi().zza(zzai.zza), Integer.valueOf(bArr.length), Long.valueOf((this.zza.zzm().nanoTime() / 1000000) - nanoTime));
            return bArr;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to log and bundle. appId, event, error", zzej.zza(str), this.zza.zzi().zza(zzai.zza), e);
            return null;
        }
    }

    @BinderThread
    public final void zza(zzjw zzjw, zzn zzn) {
        Preconditions.checkNotNull(zzjw);
        zzb(zzn, false);
        if (zzjw.zza() == null) {
            zza((Runnable) new zzgc(this, zzjw, zzn));
        } else {
            zza((Runnable) new zzgf(this, zzjw, zzn));
        }
    }

    @BinderThread
    public final List<zzjw> zza(zzn zzn, boolean z) {
        zzb(zzn, false);
        try {
            List<zzjy> list = (List) this.zza.zzq().zza(new zzge(this, zzn)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjy zzjy : list) {
                if (z || !zzjx.zze(zzjy.zzc)) {
                    arrayList.add(new zzjw(zzjy));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzej.zza(zzn.zza), e);
            return null;
        }
    }

    @BinderThread
    public final void zza(zzn zzn) {
        zzb(zzn, false);
        zza((Runnable) new zzgh(this, zzn));
    }

    @BinderThread
    private final void zzb(zzn zzn, boolean z) {
        Preconditions.checkNotNull(zzn);
        zza(zzn.zza, false);
        this.zza.zzj().zzc(zzn.zzb, zzn.zzr);
    }

    @BinderThread
    private final void zza(String str, boolean z) {
        boolean z2;
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                try {
                    if (this.zzb == null) {
                        if (!"com.google.android.gms".equals(this.zzc) && !UidVerifier.isGooglePlayServicesUid(this.zza.zzn(), Binder.getCallingUid())) {
                            if (!GoogleSignatureVerifier.getInstance(this.zza.zzn()).isUidGoogleSigned(Binder.getCallingUid())) {
                                z2 = false;
                                this.zzb = Boolean.valueOf(z2);
                            }
                        }
                        z2 = true;
                        this.zzb = Boolean.valueOf(z2);
                    }
                    if (this.zzb.booleanValue()) {
                        return;
                    }
                } catch (SecurityException e) {
                    this.zza.zzr().zzf().zza("Measurement Service called with invalid calling package. appId", zzej.zza(str));
                    throw e;
                }
            }
            if (this.zzc == null && GooglePlayServicesUtilLight.uidHasPackageName(this.zza.zzn(), Binder.getCallingUid(), str)) {
                this.zzc = str;
            }
            if (!str.equals(this.zzc)) {
                throw new SecurityException(String.format("Unknown calling package name '%s'.", new Object[]{str}));
            }
            return;
        }
        this.zza.zzr().zzf().zza("Measurement Service called without app package");
        throw new SecurityException("Measurement Service called without app package");
    }

    @BinderThread
    public final void zza(long j, String str, String str2, String str3) {
        zza((Runnable) new zzgg(this, str2, str3, str, j));
    }

    @BinderThread
    public final String zzc(zzn zzn) {
        zzb(zzn, false);
        return this.zza.zzd(zzn);
    }

    @BinderThread
    public final void zza(zzq zzq, zzn zzn) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotNull(zzq.zzc);
        zzb(zzn, false);
        zzq zzq2 = new zzq(zzq);
        zzq2.zza = zzn.zza;
        if (zzq.zzc.zza() == null) {
            zza((Runnable) new zzfq(this, zzq2, zzn));
        } else {
            zza((Runnable) new zzft(this, zzq2, zzn));
        }
    }

    @BinderThread
    public final void zza(zzq zzq) {
        Preconditions.checkNotNull(zzq);
        Preconditions.checkNotNull(zzq.zzc);
        zza(zzq.zza, true);
        zzq zzq2 = new zzq(zzq);
        if (zzq.zzc.zza() == null) {
            zza((Runnable) new zzfs(this, zzq2));
        } else {
            zza((Runnable) new zzfv(this, zzq2));
        }
    }

    @BinderThread
    public final List<zzjw> zza(String str, String str2, boolean z, zzn zzn) {
        zzb(zzn, false);
        try {
            List<zzjy> list = (List) this.zza.zzq().zza(new zzfu(this, zzn, str, str2)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjy zzjy : list) {
                if (z || !zzjx.zze(zzjy.zzc)) {
                    arrayList.add(new zzjw(zzjy));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzej.zza(zzn.zza), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzjw> zza(String str, String str2, String str3, boolean z) {
        zza(str, true);
        try {
            List<zzjy> list = (List) this.zza.zzq().zza(new zzfx(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList(list.size());
            for (zzjy zzjy : list) {
                if (z || !zzjx.zze(zzjy.zzc)) {
                    arrayList.add(new zzjw(zzjy));
                }
            }
            return arrayList;
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get user attributes. appId", zzej.zza(str), e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzq> zza(String str, String str2, zzn zzn) {
        zzb(zzn, false);
        try {
            return (List) this.zza.zzq().zza(new zzfw(this, zzn, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final List<zzq> zza(String str, String str2, String str3) {
        zza(str, true);
        try {
            return (List) this.zza.zzq().zza(new zzfz(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.zza.zzr().zzf().zza("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @BinderThread
    public final void zzd(zzn zzn) {
        zza(zzn.zza, false);
        zza((Runnable) new zzfy(this, zzn));
    }

    @VisibleForTesting
    private final void zza(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        if (this.zza.zzq().zzg()) {
            runnable.run();
        } else {
            this.zza.zzq().zza(runnable);
        }
    }
}
