package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.clearcut.zzaa;
import com.google.android.gms.internal.clearcut.zze;
import com.google.android.gms.internal.clearcut.zzge;
import com.google.android.gms.internal.clearcut.zzha;
import com.google.android.gms.internal.clearcut.zzj;
import com.google.android.gms.internal.clearcut.zzp;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.ArrayList;
import java.util.TimeZone;
import javax.annotation.Nullable;

@KeepForSdk
public final class ClearcutLogger {
    @Deprecated
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ClearcutLogger.API", CLIENT_BUILDER, CLIENT_KEY);
    private static final Api.AbstractClientBuilder<zzj, Api.ApiOptions.NoOptions> CLIENT_BUILDER = new zza();
    private static final Api.ClientKey<zzj> CLIENT_KEY = new Api.ClientKey<>();
    private static final ExperimentTokens[] zze = new ExperimentTokens[0];
    private static final String[] zzf = new String[0];
    private static final byte[][] zzg = new byte[0][];
    /* access modifiers changed from: private */
    public final String packageName;
    /* access modifiers changed from: private */
    public final Context zzh;
    /* access modifiers changed from: private */
    public final int zzi;
    /* access modifiers changed from: private */
    public String zzj;
    /* access modifiers changed from: private */
    public int zzk;
    /* access modifiers changed from: private */
    public String zzl;
    private String zzm;
    /* access modifiers changed from: private */
    public final boolean zzn;
    /* access modifiers changed from: private */
    public zzge.zzv.zzb zzo;
    /* access modifiers changed from: private */
    public final zzb zzp;
    /* access modifiers changed from: private */
    public final Clock zzq;
    /* access modifiers changed from: private */
    public zzc zzr;
    /* access modifiers changed from: private */
    public final zza zzs;

    public class LogEventBuilder {
        private final zzha zzaa;
        private boolean zzab;
        private String zzj;
        private int zzk;
        private String zzl;
        private String zzm;
        private zzge.zzv.zzb zzo;
        private final zzb zzt;
        private ArrayList<Integer> zzu;
        private ArrayList<String> zzv;
        private ArrayList<Integer> zzw;
        private ArrayList<ExperimentTokens> zzx;
        private ArrayList<byte[]> zzy;
        private boolean zzz;

        private LogEventBuilder(ClearcutLogger clearcutLogger, byte[] bArr) {
            this(bArr, (zzb) null);
        }

        private LogEventBuilder(byte[] bArr, zzb zzb) {
            this.zzk = ClearcutLogger.this.zzk;
            this.zzj = ClearcutLogger.this.zzj;
            this.zzl = ClearcutLogger.this.zzl;
            ClearcutLogger clearcutLogger = ClearcutLogger.this;
            this.zzm = null;
            this.zzo = clearcutLogger.zzo;
            this.zzu = null;
            this.zzv = null;
            this.zzw = null;
            this.zzx = null;
            this.zzy = null;
            this.zzz = true;
            this.zzaa = new zzha();
            this.zzab = false;
            this.zzl = ClearcutLogger.this.zzl;
            this.zzm = null;
            this.zzaa.zzbkc = zzaa.zze(ClearcutLogger.this.zzh);
            this.zzaa.zzbjf = ClearcutLogger.this.zzq.currentTimeMillis();
            this.zzaa.zzbjg = ClearcutLogger.this.zzq.elapsedRealtime();
            zzha zzha = this.zzaa;
            zzc unused = ClearcutLogger.this.zzr;
            zzha.zzbju = (long) (TimeZone.getDefault().getOffset(this.zzaa.zzbjf) / 1000);
            if (bArr != null) {
                this.zzaa.zzbjp = bArr;
            }
            this.zzt = null;
        }

        /* synthetic */ LogEventBuilder(ClearcutLogger clearcutLogger, byte[] bArr, zza zza) {
            this(clearcutLogger, bArr);
        }

        @KeepForSdk
        public void log() {
            if (!this.zzab) {
                this.zzab = true;
                zze zze = new zze(new zzr(ClearcutLogger.this.packageName, ClearcutLogger.this.zzi, this.zzk, this.zzj, this.zzl, this.zzm, ClearcutLogger.this.zzn, this.zzo), this.zzaa, (zzb) null, (zzb) null, ClearcutLogger.zza((ArrayList<Integer>) null), (String[]) null, ClearcutLogger.zza((ArrayList<Integer>) null), (byte[][]) null, (ExperimentTokens[]) null, this.zzz);
                if (ClearcutLogger.this.zzs.zza(zze)) {
                    ClearcutLogger.this.zzp.zzb(zze);
                } else {
                    PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, (GoogleApiClient) null);
                }
            } else {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
        }

        @KeepForSdk
        public LogEventBuilder setEventCode(int i) {
            this.zzaa.zzbji = i;
            return this;
        }
    }

    public interface zza {
        boolean zza(zze zze);
    }

    public interface zzb {
        byte[] zza();
    }

    public static class zzc {
    }

    @VisibleForTesting
    private ClearcutLogger(Context context, int i, String str, String str2, String str3, boolean z, zzb zzb2, Clock clock, zzc zzc2, zza zza2) {
        this.zzk = -1;
        this.zzo = zzge.zzv.zzb.DEFAULT;
        this.zzh = context;
        this.packageName = context.getPackageName();
        this.zzi = zza(context);
        this.zzk = -1;
        this.zzj = str;
        this.zzl = str2;
        this.zzm = null;
        this.zzn = z;
        this.zzp = zzb2;
        this.zzq = clock;
        this.zzr = new zzc();
        this.zzo = zzge.zzv.zzb.DEFAULT;
        this.zzs = zza2;
        if (z) {
            Preconditions.checkArgument(str2 == null, "can't be anonymous with an upload account");
        }
    }

    @KeepForSdk
    public ClearcutLogger(Context context, String str, @Nullable String str2) {
        this(context, -1, str, str2, (String) null, false, zze.zzb(context), DefaultClock.getInstance(), (zzc) null, new zzp(context));
    }

    @KeepForSdk
    public static ClearcutLogger anonymousLogger(Context context, String str) {
        return new ClearcutLogger(context, -1, str, (String) null, (String) null, true, zze.zzb(context), DefaultClock.getInstance(), (zzc) null, new zzp(context));
    }

    private static int zza(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.", e);
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static int[] zza(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Object obj = arrayList2.get(i);
            i++;
            iArr[i2] = ((Integer) obj).intValue();
            i2++;
        }
        return iArr;
    }

    @KeepForSdk
    public final LogEventBuilder newEvent(@Nullable byte[] bArr) {
        return new LogEventBuilder(this, bArr, (zza) null);
    }
}
