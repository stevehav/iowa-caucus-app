package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.adobe.xmp.XMPError;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzbo;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzjz;
import com.google.android.gms.internal.measurement.zzx;
import com.google.common.net.HttpHeaders;
import io.sentry.marshaller.json.JsonMarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
public class zzjp implements zzgl {
    private static volatile zzjp zza;
    private zzfh zzb;
    private zzen zzc;
    private zzx zzd;
    private zzeq zze;
    private zzjl zzf;
    private zzp zzg;
    private final zzjt zzh;
    private zzhs zzi;
    private final zzfn zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    @VisibleForTesting
    private long zzn;
    private List<Runnable> zzo;
    private int zzp;
    private int zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private FileLock zzu;
    private FileChannel zzv;
    private List<Long> zzw;
    private List<Long> zzx;
    private long zzy;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
    class zza implements zzz {
        zzbr.zzg zza;
        List<Long> zzb;
        List<zzbr.zzc> zzc;
        private long zzd;

        private zza() {
        }

        public final void zza(zzbr.zzg zzg) {
            Preconditions.checkNotNull(zzg);
            this.zza = zzg;
        }

        public final boolean zza(long j, zzbr.zzc zzc2) {
            Preconditions.checkNotNull(zzc2);
            if (this.zzc == null) {
                this.zzc = new ArrayList();
            }
            if (this.zzb == null) {
                this.zzb = new ArrayList();
            }
            if (this.zzc.size() > 0 && zza(this.zzc.get(0)) != zza(zzc2)) {
                return false;
            }
            long zzbl = this.zzd + ((long) zzc2.zzbl());
            if (zzbl >= ((long) Math.max(0, zzak.zzl.zza(null).intValue()))) {
                return false;
            }
            this.zzd = zzbl;
            this.zzc.add(zzc2);
            this.zzb.add(Long.valueOf(j));
            if (this.zzc.size() >= Math.max(1, zzak.zzm.zza(null).intValue())) {
                return false;
            }
            return true;
        }

        private static long zza(zzbr.zzc zzc2) {
            return ((zzc2.zze() / 1000) / 60) / 60;
        }

        /* synthetic */ zza(zzjp zzjp, zzjo zzjo) {
            this();
        }
    }

    public static zzjp zza(Context context) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zza == null) {
            synchronized (zzjp.class) {
                if (zza == null) {
                    zza = new zzjp(new zzju(context));
                }
            }
        }
        return zza;
    }

    private zzjp(zzju zzju) {
        this(zzju, (zzfn) null);
    }

    private zzjp(zzju zzju, zzfn zzfn) {
        this.zzk = false;
        Preconditions.checkNotNull(zzju);
        this.zzj = zzfn.zza(zzju.zza, (zzx) null);
        this.zzy = -1;
        zzjt zzjt = new zzjt(this);
        zzjt.zzal();
        this.zzh = zzjt;
        zzen zzen = new zzen(this);
        zzen.zzal();
        this.zzc = zzen;
        zzfh zzfh = new zzfh(this);
        zzfh.zzal();
        this.zzb = zzfh;
        this.zzj.zzq().zza((Runnable) new zzjo(this, zzju));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zza(zzju zzju) {
        this.zzj.zzq().zzd();
        zzx zzx2 = new zzx(this);
        zzx2.zzal();
        this.zzd = zzx2;
        this.zzj.zzb().zza((zzu) this.zzb);
        zzp zzp2 = new zzp(this);
        zzp2.zzal();
        this.zzg = zzp2;
        zzhs zzhs = new zzhs(this);
        zzhs.zzal();
        this.zzi = zzhs;
        zzjl zzjl = new zzjl(this);
        zzjl.zzal();
        this.zzf = zzjl;
        this.zze = new zzeq(this);
        if (this.zzp != this.zzq) {
            this.zzj.zzr().zzf().zza("Not all upload components initialized", Integer.valueOf(this.zzp), Integer.valueOf(this.zzq));
        }
        this.zzk = true;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public final void zza() {
        this.zzj.zzq().zzd();
        zze().zzv();
        if (this.zzj.zzc().zzc.zza() == 0) {
            this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
        }
        zzz();
    }

    public final zzr zzu() {
        return this.zzj.zzu();
    }

    public final zzs zzb() {
        return this.zzj.zzb();
    }

    public final zzej zzr() {
        return this.zzj.zzr();
    }

    public final zzfg zzq() {
        return this.zzj.zzq();
    }

    public final zzfh zzc() {
        zzb((zzjm) this.zzb);
        return this.zzb;
    }

    public final zzen zzd() {
        zzb((zzjm) this.zzc);
        return this.zzc;
    }

    public final zzx zze() {
        zzb((zzjm) this.zzd);
        return this.zzd;
    }

    private final zzeq zzt() {
        zzeq zzeq = this.zze;
        if (zzeq != null) {
            return zzeq;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final zzjl zzv() {
        zzb((zzjm) this.zzf);
        return this.zzf;
    }

    public final zzp zzf() {
        zzb((zzjm) this.zzg);
        return this.zzg;
    }

    public final zzhs zzg() {
        zzb((zzjm) this.zzi);
        return this.zzi;
    }

    public final zzjt zzh() {
        zzb((zzjm) this.zzh);
        return this.zzh;
    }

    public final zzeh zzi() {
        return this.zzj.zzj();
    }

    public final Context zzn() {
        return this.zzj.zzn();
    }

    public final Clock zzm() {
        return this.zzj.zzm();
    }

    public final zzjx zzj() {
        return this.zzj.zzi();
    }

    @WorkerThread
    private final void zzw() {
        this.zzj.zzq().zzd();
    }

    /* access modifiers changed from: package-private */
    public final void zzk() {
        if (!this.zzk) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    private static void zzb(zzjm zzjm) {
        if (zzjm == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!zzjm.zzaj()) {
            String valueOf = String.valueOf(zzjm.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzn zzn2) {
        zzw();
        zzk();
        Preconditions.checkNotEmpty(zzn2.zza);
        zze(zzn2);
    }

    private final long zzx() {
        long currentTimeMillis = this.zzj.zzm().currentTimeMillis();
        zzes zzc2 = this.zzj.zzc();
        zzc2.zzaa();
        zzc2.zzd();
        long zza2 = zzc2.zzg.zza();
        if (zza2 == 0) {
            zza2 = 1 + ((long) zzc2.zzp().zzh().nextInt(86400000));
            zzc2.zzg.zza(zza2);
        }
        return ((((currentTimeMillis + zza2) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzai zzai, String str) {
        zzai zzai2 = zzai;
        String str2 = str;
        zzf zzb2 = zze().zzb(str2);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzj())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping event", str2);
            return;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null) {
            if (!"_ui".equals(zzai2.zza)) {
                this.zzj.zzr().zzi().zza("Could not find package. appId", zzej.zza(str));
            }
        } else if (!zzb3.booleanValue()) {
            this.zzj.zzr().zzf().zza("App version does not match; dropping event. appId", zzej.zza(str));
            return;
        }
        zzn zzn2 = r2;
        zzf zzf2 = zzb2;
        zzn zzn3 = new zzn(str, zzb2.zzd(), zzb2.zzj(), zzb2.zzk(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), (String) null, zzb2.zzp(), false, zzf2.zzg(), zzf2.zzac(), 0, 0, zzf2.zzad(), zzf2.zzae(), false, zzf2.zze(), zzf2.zzaf(), zzf2.zzo(), zzf2.zzag());
        zza(zzai2, zzn2);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzai zzai, zzn zzn2) {
        List<zzq> list;
        List<zzq> list2;
        List<zzq> list3;
        zzai zzai2 = zzai;
        zzn zzn3 = zzn2;
        Preconditions.checkNotNull(zzn2);
        Preconditions.checkNotEmpty(zzn3.zza);
        zzw();
        zzk();
        String str = zzn3.zza;
        long j = zzai2.zzd;
        if (zzh().zza(zzai2, zzn3)) {
            if (!zzn3.zzh) {
                zze(zzn3);
                return;
            }
            if (this.zzj.zzb().zze(str, zzak.zzbt) && zzn3.zzu != null) {
                if (zzn3.zzu.contains(zzai2.zza)) {
                    Bundle zzb2 = zzai2.zzb.zzb();
                    zzb2.putLong("ga_safelisted", 1);
                    zzai2 = new zzai(zzai2.zza, new zzah(zzb2), zzai2.zzc, zzai2.zzd);
                } else {
                    this.zzj.zzr().zzw().zza("Dropping non-safelisted event. appId, event name, origin", str, zzai2.zza, zzai2.zzc);
                    return;
                }
            }
            zze().zzf();
            try {
                zzx zze2 = zze();
                Preconditions.checkNotEmpty(str);
                zze2.zzd();
                zze2.zzak();
                if (j < 0) {
                    zze2.zzr().zzi().zza("Invalid time querying timed out conditional properties", zzej.zza(str), Long.valueOf(j));
                    list = Collections.emptyList();
                } else {
                    list = zze2.zza("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j)});
                }
                for (zzq next : list) {
                    if (next != null) {
                        this.zzj.zzr().zzw().zza("User property timed out", next.zza, this.zzj.zzj().zzc(next.zzc.zza), next.zzc.zza());
                        if (next.zzg != null) {
                            zzb(new zzai(next.zzg, j), zzn3);
                        }
                        zze().zze(str, next.zzc.zza);
                    }
                }
                zzx zze3 = zze();
                Preconditions.checkNotEmpty(str);
                zze3.zzd();
                zze3.zzak();
                if (j < 0) {
                    zze3.zzr().zzi().zza("Invalid time querying expired conditional properties", zzej.zza(str), Long.valueOf(j));
                    list2 = Collections.emptyList();
                } else {
                    list2 = zze3.zza("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzq next2 : list2) {
                    if (next2 != null) {
                        this.zzj.zzr().zzw().zza("User property expired", next2.zza, this.zzj.zzj().zzc(next2.zzc.zza), next2.zzc.zza());
                        zze().zzb(str, next2.zzc.zza);
                        if (next2.zzk != null) {
                            arrayList.add(next2.zzk);
                        }
                        zze().zze(str, next2.zzc.zza);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    zzb(new zzai((zzai) obj, j), zzn3);
                }
                zzx zze4 = zze();
                String str2 = zzai2.zza;
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotEmpty(str2);
                zze4.zzd();
                zze4.zzak();
                if (j < 0) {
                    zze4.zzr().zzi().zza("Invalid time querying triggered conditional properties", zzej.zza(str), zze4.zzo().zza(str2), Long.valueOf(j));
                    list3 = Collections.emptyList();
                } else {
                    list3 = zze4.zza("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzq next3 : list3) {
                    if (next3 != null) {
                        zzjw zzjw = next3.zzc;
                        zzjy zzjy = r4;
                        zzjy zzjy2 = new zzjy(next3.zza, next3.zzb, zzjw.zza, j, zzjw.zza());
                        if (zze().zza(zzjy)) {
                            this.zzj.zzr().zzw().zza("User property triggered", next3.zza, this.zzj.zzj().zzc(zzjy.zzc), zzjy.zze);
                        } else {
                            this.zzj.zzr().zzf().zza("Too many active user properties, ignoring", zzej.zza(next3.zza), this.zzj.zzj().zzc(zzjy.zzc), zzjy.zze);
                        }
                        if (next3.zzi != null) {
                            arrayList3.add(next3.zzi);
                        }
                        next3.zzc = new zzjw(zzjy);
                        next3.zze = true;
                        zze().zza(next3);
                    }
                }
                zzb(zzai2, zzn3);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i2 = 0;
                while (i2 < size2) {
                    Object obj2 = arrayList4.get(i2);
                    i2++;
                    zzb(new zzai((zzai) obj2, j), zzn3);
                }
                zze().b_();
            } finally {
                zze().zzh();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:248:0x0853 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0883 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0272 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02a9 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x02f7 A[Catch:{ SQLiteException -> 0x023a, all -> 0x08c8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0324  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(com.google.android.gms.measurement.internal.zzai r28, com.google.android.gms.measurement.internal.zzn r29) {
        /*
            r27 = this;
            r1 = r27
            r2 = r28
            r3 = r29
            java.lang.String r4 = "_s"
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)
            java.lang.String r5 = r3.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)
            long r5 = java.lang.System.nanoTime()
            r27.zzw()
            r27.zzk()
            java.lang.String r15 = r3.zza
            com.google.android.gms.measurement.internal.zzjt r7 = r27.zzh()
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzai) r2, (com.google.android.gms.measurement.internal.zzn) r3)
            if (r7 != 0) goto L_0x0027
            return
        L_0x0027:
            boolean r7 = r3.zzh
            if (r7 != 0) goto L_0x002f
            r1.zze(r3)
            return
        L_0x002f:
            com.google.android.gms.measurement.internal.zzfh r7 = r27.zzc()
            java.lang.String r8 = r2.zza
            boolean r7 = r7.zzb(r15, r8)
            java.lang.String r14 = "_err"
            r13 = 0
            r12 = 1
            if (r7 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzi()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzj()
            java.lang.String r6 = r2.zza
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.zza(r6, r4, r5)
            com.google.android.gms.measurement.internal.zzfh r3 = r27.zzc()
            boolean r3 = r3.zzg(r15)
            if (r3 != 0) goto L_0x0075
            com.google.android.gms.measurement.internal.zzfh r3 = r27.zzc()
            boolean r3 = r3.zzh(r15)
            if (r3 == 0) goto L_0x0073
            goto L_0x0075
        L_0x0073:
            r3 = 0
            goto L_0x0076
        L_0x0075:
            r3 = 1
        L_0x0076:
            if (r3 != 0) goto L_0x0091
            java.lang.String r4 = r2.zza
            boolean r4 = r14.equals(r4)
            if (r4 != 0) goto L_0x0091
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj
            com.google.android.gms.measurement.internal.zzjx r7 = r4.zzi()
            r9 = 11
            java.lang.String r11 = r2.zza
            r12 = 0
            java.lang.String r10 = "_ev"
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)
        L_0x0091:
            if (r3 == 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()
            com.google.android.gms.measurement.internal.zzf r2 = r2.zzb(r15)
            if (r2 == 0) goto L_0x00da
            long r3 = r2.zzs()
            long r5 = r2.zzr()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj
            com.google.android.gms.common.util.Clock r5 = r5.zzm()
            long r5 = r5.currentTimeMillis()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.zzdy<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzac
            java.lang.Object r5 = r5.zza(r13)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00da
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzw()
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.zza(r4)
            r1.zza((com.google.android.gms.measurement.internal.zzf) r2)
        L_0x00da:
            return
        L_0x00db:
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzr()
            r10 = 2
            boolean r7 = r7.zza((int) r10)
            if (r7 == 0) goto L_0x0101
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzr()
            com.google.android.gms.measurement.internal.zzel r7 = r7.zzx()
            com.google.android.gms.measurement.internal.zzfn r8 = r1.zzj
            com.google.android.gms.measurement.internal.zzeh r8 = r8.zzj()
            java.lang.String r8 = r8.zza((com.google.android.gms.measurement.internal.zzai) r2)
            java.lang.String r9 = "Logging event"
            r7.zza(r9, r8)
        L_0x0101:
            com.google.android.gms.measurement.internal.zzx r7 = r27.zze()
            r7.zzf()
            r1.zze(r3)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = "_iap"
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "ecommerce_purchase"
            if (r7 != 0) goto L_0x0125
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x08c8 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0120
            goto L_0x0125
        L_0x0120:
            r23 = r5
            r6 = 0
            goto L_0x02b8
        L_0x0125:
            com.google.android.gms.measurement.internal.zzah r7 = r2.zzb     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = "currency"
            java.lang.String r7 = r7.zzd(r9)     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r2.zza     // Catch:{ all -> 0x08c8 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = "value"
            if (r8 == 0) goto L_0x018c
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzb     // Catch:{ all -> 0x08c8 }
            java.lang.Double r8 = r8.zzc(r9)     // Catch:{ all -> 0x08c8 }
            double r16 = r8.doubleValue()     // Catch:{ all -> 0x08c8 }
            r18 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r16 = r16 * r18
            r20 = 0
            int r8 = (r16 > r20 ? 1 : (r16 == r20 ? 0 : -1))
            if (r8 != 0) goto L_0x015e
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzb     // Catch:{ all -> 0x08c8 }
            java.lang.Long r8 = r8.zzb(r9)     // Catch:{ all -> 0x08c8 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08c8 }
            double r8 = (double) r8
            java.lang.Double.isNaN(r8)
            double r16 = r8 * r18
        L_0x015e:
            r8 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 > 0) goto L_0x016f
            r8 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r18 = (r16 > r8 ? 1 : (r16 == r8 ? 0 : -1))
            if (r18 < 0) goto L_0x016f
            long r8 = java.lang.Math.round(r16)     // Catch:{ all -> 0x08c8 }
            goto L_0x0196
        L_0x016f:
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r7 = r7.zzi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r15)     // Catch:{ all -> 0x08c8 }
            java.lang.Double r10 = java.lang.Double.valueOf(r16)     // Catch:{ all -> 0x08c8 }
            r7.zza(r8, r9, r10)     // Catch:{ all -> 0x08c8 }
            r23 = r5
            r6 = 0
            r11 = 0
            goto L_0x02a7
        L_0x018c:
            com.google.android.gms.measurement.internal.zzah r8 = r2.zzb     // Catch:{ all -> 0x08c8 }
            java.lang.Long r8 = r8.zzb(r9)     // Catch:{ all -> 0x08c8 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08c8 }
        L_0x0196:
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r10 != 0) goto L_0x02a3
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.toUpperCase(r10)     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = "[A-Z]{3}"
            boolean r10 = r7.matches(r10)     // Catch:{ all -> 0x08c8 }
            if (r10 == 0) goto L_0x02a3
            java.lang.String r10 = "_ltv_"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x08c8 }
            int r16 = r7.length()     // Catch:{ all -> 0x08c8 }
            if (r16 == 0) goto L_0x01bb
            java.lang.String r7 = r10.concat(r7)     // Catch:{ all -> 0x08c8 }
            goto L_0x01c0
        L_0x01bb:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x08c8 }
            r7.<init>(r10)     // Catch:{ all -> 0x08c8 }
        L_0x01c0:
            r10 = r7
            com.google.android.gms.measurement.internal.zzx r7 = r27.zze()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjy r7 = r7.zzc(r15, r10)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0201
            java.lang.Object r11 = r7.zze     // Catch:{ all -> 0x08c8 }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x08c8 }
            if (r11 != 0) goto L_0x01d2
            goto L_0x0201
        L_0x01d2:
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x08c8 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x08c8 }
            long r19 = r7.longValue()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjy r17 = new com.google.android.gms.measurement.internal.zzjy     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r2.zzc     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.util.Clock r7 = r7.zzm()     // Catch:{ all -> 0x08c8 }
            long r21 = r7.currentTimeMillis()     // Catch:{ all -> 0x08c8 }
            long r19 = r19 + r8
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x08c8 }
            r7 = r17
            r8 = r15
            r9 = r11
            r11 = 2
            r23 = r5
            r5 = 1
            r6 = 0
            r11 = r21
            r13 = r19
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08c8 }
            r5 = r17
            goto L_0x0268
        L_0x0201:
            r23 = r5
            r5 = 1
            r6 = 0
            com.google.android.gms.measurement.internal.zzx r7 = r27.zze()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r11 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzb()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzak.zzah     // Catch:{ all -> 0x08c8 }
            int r11 = r11.zzb(r15, r12)     // Catch:{ all -> 0x08c8 }
            int r11 = r11 - r5
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x08c8 }
            r7.zzd()     // Catch:{ all -> 0x08c8 }
            r7.zzak()     // Catch:{ all -> 0x08c8 }
            android.database.sqlite.SQLiteDatabase r12 = r7.c_()     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r13 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r5 = 3
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x023a }
            r5[r6] = r15     // Catch:{ SQLiteException -> 0x023a }
            r16 = 1
            r5[r16] = r15     // Catch:{ SQLiteException -> 0x023a }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x023a }
            r16 = 2
            r5[r16] = r11     // Catch:{ SQLiteException -> 0x023a }
            r12.execSQL(r13, r5)     // Catch:{ SQLiteException -> 0x023a }
            goto L_0x024d
        L_0x023a:
            r0 = move-exception
            r5 = r0
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r7 = r7.zzf()     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r15)     // Catch:{ all -> 0x08c8 }
            r7.zza(r11, r12, r5)     // Catch:{ all -> 0x08c8 }
        L_0x024d:
            com.google.android.gms.measurement.internal.zzjy r5 = new com.google.android.gms.measurement.internal.zzjy     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r2.zzc     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.util.Clock r7 = r7.zzm()     // Catch:{ all -> 0x08c8 }
            long r12 = r7.currentTimeMillis()     // Catch:{ all -> 0x08c8 }
            java.lang.Long r16 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x08c8 }
            r7 = r5
            r8 = r15
            r9 = r11
            r11 = r12
            r13 = r16
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08c8 }
        L_0x0268:
            com.google.android.gms.measurement.internal.zzx r7 = r27.zze()     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.zza((com.google.android.gms.measurement.internal.zzjy) r5)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x02a6
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r7 = r7.zzf()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r15)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r10 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r10 = r10.zzj()     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r5.zzc     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r10.zzc(r11)     // Catch:{ all -> 0x08c8 }
            java.lang.Object r5 = r5.zze     // Catch:{ all -> 0x08c8 }
            r7.zza(r8, r9, r10, r5)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjx r7 = r5.zzi()     // Catch:{ all -> 0x08c8 }
            r9 = 9
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r15
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x08c8 }
            goto L_0x02a6
        L_0x02a3:
            r23 = r5
            r6 = 0
        L_0x02a6:
            r11 = 1
        L_0x02a7:
            if (r11 != 0) goto L_0x02b8
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()     // Catch:{ all -> 0x08c8 }
            r2.b_()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()
            r2.zzh()
            return
        L_0x02b8:
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x08c8 }
            boolean r5 = com.google.android.gms.measurement.internal.zzjx.zza((java.lang.String) r5)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x08c8 }
            boolean r16 = r14.equals(r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r7 = r27.zze()     // Catch:{ all -> 0x08c8 }
            long r8 = r27.zzx()     // Catch:{ all -> 0x08c8 }
            r11 = 1
            r13 = 0
            r17 = 0
            r10 = r15
            r12 = r5
            r14 = r16
            r18 = r15
            r15 = r17
            com.google.android.gms.measurement.internal.zzw r7 = r7.zza(r8, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x08c8 }
            long r8 = r7.zzb     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.zzak.zzn     // Catch:{ all -> 0x08c8 }
            r14 = 0
            java.lang.Object r10 = r10.zza(r14)     // Catch:{ all -> 0x08c8 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x08c8 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x08c8 }
            long r10 = (long) r10     // Catch:{ all -> 0x08c8 }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 1
            r14 = 0
            int r17 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r17 <= 0) goto L_0x0324
            long r8 = r8 % r10
            int r2 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0315
            com.google.android.gms.measurement.internal.zzfn r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r18)     // Catch:{ all -> 0x08c8 }
            long r5 = r7.zzb     // Catch:{ all -> 0x08c8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08c8 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x08c8 }
        L_0x0315:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()     // Catch:{ all -> 0x08c8 }
            r2.b_()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()
            r2.zzh()
            return
        L_0x0324:
            if (r5 == 0) goto L_0x037c
            long r8 = r7.zza     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Integer> r6 = com.google.android.gms.measurement.internal.zzak.zzp     // Catch:{ all -> 0x08c8 }
            r12 = 0
            java.lang.Object r6 = r6.zza(r12)     // Catch:{ all -> 0x08c8 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x08c8 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x08c8 }
            long r12 = (long) r6     // Catch:{ all -> 0x08c8 }
            long r8 = r8 - r12
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x037c
            long r8 = r8 % r10
            r3 = 1
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x035b
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r18)     // Catch:{ all -> 0x08c8 }
            long r6 = r7.zza     // Catch:{ all -> 0x08c8 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x08c8 }
            r3.zza(r4, r5, r6)     // Catch:{ all -> 0x08c8 }
        L_0x035b:
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjx r7 = r3.zzi()     // Catch:{ all -> 0x08c8 }
            r9 = 16
            java.lang.String r10 = "_ev"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x08c8 }
            r12 = 0
            r8 = r18
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()     // Catch:{ all -> 0x08c8 }
            r2.b_()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()
            r2.zzh()
            return
        L_0x037c:
            if (r16 == 0) goto L_0x03ce
            long r8 = r7.zzd     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzb()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.zzak.zzo     // Catch:{ all -> 0x08c8 }
            int r6 = r6.zzb(r10, r11)     // Catch:{ all -> 0x08c8 }
            r10 = 1000000(0xf4240, float:1.401298E-39)
            int r6 = java.lang.Math.min(r10, r6)     // Catch:{ all -> 0x08c8 }
            r12 = 0
            int r6 = java.lang.Math.max(r12, r6)     // Catch:{ all -> 0x08c8 }
            long r10 = (long) r6     // Catch:{ all -> 0x08c8 }
            long r8 = r8 - r10
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x03cf
            r10 = 1
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x03bf
            com.google.android.gms.measurement.internal.zzfn r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r18)     // Catch:{ all -> 0x08c8 }
            long r5 = r7.zzd     // Catch:{ all -> 0x08c8 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08c8 }
            r2.zza(r3, r4, r5)     // Catch:{ all -> 0x08c8 }
        L_0x03bf:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()     // Catch:{ all -> 0x08c8 }
            r2.b_()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()
            r2.zzh()
            return
        L_0x03ce:
            r12 = 0
        L_0x03cf:
            com.google.android.gms.measurement.internal.zzah r6 = r2.zzb     // Catch:{ all -> 0x08c8 }
            android.os.Bundle r6 = r6.zzb()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjx r7 = r7.zzi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x08c8 }
            r7.zza((android.os.Bundle) r6, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjx r7 = r7.zzi()     // Catch:{ all -> 0x08c8 }
            r13 = r18
            boolean r7 = r7.zzf(r13)     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = "_r"
            if (r7 == 0) goto L_0x0410
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjx r7 = r7.zzi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "_dbg"
            r9 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08c8 }
            r7.zza((android.os.Bundle) r6, (java.lang.String) r8, (java.lang.Object) r12)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjx r7 = r7.zzi()     // Catch:{ all -> 0x08c8 }
            java.lang.Long r8 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08c8 }
            r7.zza((android.os.Bundle) r6, (java.lang.String) r11, (java.lang.Object) r8)     // Catch:{ all -> 0x08c8 }
        L_0x0410:
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x08c8 }
            boolean r7 = r4.equals(r7)     // Catch:{ all -> 0x08c8 }
            java.lang.String r8 = "_sno"
            if (r7 == 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzb()     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.zzo(r9)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzx r7 = r27.zze()     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r3.zza     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjy r7 = r7.zzc(r9, r8)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x0445
            java.lang.Object r9 = r7.zze     // Catch:{ all -> 0x08c8 }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x08c8 }
            if (r9 == 0) goto L_0x0445
            com.google.android.gms.measurement.internal.zzfn r9 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjx r9 = r9.zzi()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r7 = r7.zze     // Catch:{ all -> 0x08c8 }
            r9.zza((android.os.Bundle) r6, (java.lang.String) r8, (java.lang.Object) r7)     // Catch:{ all -> 0x08c8 }
        L_0x0445:
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x08c8 }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x08c8 }
            if (r4 == 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzb()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzak.zzbc     // Catch:{ all -> 0x08c8 }
            boolean r4 = r4.zze(r7, r9)     // Catch:{ all -> 0x08c8 }
            if (r4 == 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzb()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x08c8 }
            boolean r4 = r4.zzo(r7)     // Catch:{ all -> 0x08c8 }
            if (r4 != 0) goto L_0x0475
            com.google.android.gms.measurement.internal.zzjw r4 = new com.google.android.gms.measurement.internal.zzjw     // Catch:{ all -> 0x08c8 }
            r12 = 0
            r4.<init>(r8, r14, r12)     // Catch:{ all -> 0x08c8 }
            r1.zzb((com.google.android.gms.measurement.internal.zzjw) r4, (com.google.android.gms.measurement.internal.zzn) r3)     // Catch:{ all -> 0x08c8 }
            goto L_0x0476
        L_0x0475:
            r12 = 0
        L_0x0476:
            com.google.android.gms.measurement.internal.zzx r4 = r27.zze()     // Catch:{ all -> 0x08c8 }
            long r7 = r4.zzc(r13)     // Catch:{ all -> 0x08c8 }
            int r4 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x0499
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r13)     // Catch:{ all -> 0x08c8 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x08c8 }
            r4.zza(r9, r10, r7)     // Catch:{ all -> 0x08c8 }
        L_0x0499:
            com.google.android.gms.measurement.internal.zzaf r4 = new com.google.android.gms.measurement.internal.zzaf     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r8 = r1.zzj     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r2.zzc     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r2.zza     // Catch:{ all -> 0x08c8 }
            long r14 = r2.zzd     // Catch:{ all -> 0x08c8 }
            r19 = 0
            r7 = r4
            r2 = r10
            r10 = r13
            r26 = r11
            r11 = r2
            r16 = r12
            r2 = r13
            r25 = 0
            r12 = r14
            r28 = r16
            r14 = r19
            r16 = r6
            r7.<init>((com.google.android.gms.measurement.internal.zzfn) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r6 = r27.zze()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r4.zzb     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzae r6 = r6.zza((java.lang.String) r2, (java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x052c
            com.google.android.gms.measurement.internal.zzx r6 = r27.zze()     // Catch:{ all -> 0x08c8 }
            long r6 = r6.zzg(r2)     // Catch:{ all -> 0x08c8 }
            r8 = 500(0x1f4, double:2.47E-321)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x0512
            if (r5 == 0) goto L_0x0512
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ all -> 0x08c8 }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r2)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r7 = r7.zzj()     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = r4.zzb     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = r7.zza((java.lang.String) r4)     // Catch:{ all -> 0x08c8 }
            r7 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ all -> 0x08c8 }
            r3.zza(r5, r6, r4, r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjx r7 = r3.zzi()     // Catch:{ all -> 0x08c8 }
            r9 = 8
            r10 = 0
            r11 = 0
            r12 = 0
            r8 = r2
            r7.zza((java.lang.String) r8, (int) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()
            r2.zzh()
            return
        L_0x0512:
            com.google.android.gms.measurement.internal.zzae r5 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x08c8 }
            java.lang.String r9 = r4.zzb     // Catch:{ all -> 0x08c8 }
            r10 = 0
            r12 = 0
            long r14 = r4.zzc     // Catch:{ all -> 0x08c8 }
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r7 = r5
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14, r16, r18, r19, r20, r21)     // Catch:{ all -> 0x08c8 }
            goto L_0x053a
        L_0x052c:
            com.google.android.gms.measurement.internal.zzfn r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            long r7 = r6.zzf     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzaf r4 = r4.zza(r2, r7)     // Catch:{ all -> 0x08c8 }
            long r7 = r4.zzc     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzae r5 = r6.zza(r7)     // Catch:{ all -> 0x08c8 }
        L_0x053a:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()     // Catch:{ all -> 0x08c8 }
            r2.zza((com.google.android.gms.measurement.internal.zzae) r5)     // Catch:{ all -> 0x08c8 }
            r27.zzw()     // Catch:{ all -> 0x08c8 }
            r27.zzk()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r29)     // Catch:{ all -> 0x08c8 }
            java.lang.String r2 = r4.zza     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r2)     // Catch:{ all -> 0x08c8 }
            java.lang.String r2 = r4.zza     // Catch:{ all -> 0x08c8 }
            java.lang.String r5 = r3.zza     // Catch:{ all -> 0x08c8 }
            boolean r2 = r2.equals(r5)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.common.internal.Preconditions.checkArgument(r2)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r2 = com.google.android.gms.internal.measurement.zzbr.zzg.zzbe()     // Catch:{ all -> 0x08c8 }
            r5 = 1
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r2 = r2.zza((int) r5)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = "android"
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r2 = r2.zza((java.lang.String) r6)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0579
            java.lang.String r6 = r3.zza     // Catch:{ all -> 0x08c8 }
            r2.zzf((java.lang.String) r6)     // Catch:{ all -> 0x08c8 }
        L_0x0579:
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0586
            java.lang.String r6 = r3.zzd     // Catch:{ all -> 0x08c8 }
            r2.zze((java.lang.String) r6)     // Catch:{ all -> 0x08c8 }
        L_0x0586:
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0593
            java.lang.String r6 = r3.zzc     // Catch:{ all -> 0x08c8 }
            r2.zzg((java.lang.String) r6)     // Catch:{ all -> 0x08c8 }
        L_0x0593:
            long r6 = r3.zzj     // Catch:{ all -> 0x08c8 }
            r8 = -2147483648(0xffffffff80000000, double:NaN)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x05a2
            long r6 = r3.zzj     // Catch:{ all -> 0x08c8 }
            int r7 = (int) r6     // Catch:{ all -> 0x08c8 }
            r2.zzg((int) r7)     // Catch:{ all -> 0x08c8 }
        L_0x05a2:
            long r6 = r3.zze     // Catch:{ all -> 0x08c8 }
            r2.zzf((long) r6)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x05b4
            java.lang.String r6 = r3.zzb     // Catch:{ all -> 0x08c8 }
            r2.zzk((java.lang.String) r6)     // Catch:{ all -> 0x08c8 }
        L_0x05b4:
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzb()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzak.zzbp     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean>) r7)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x05da
            java.lang.String r6 = r2.zzl()     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x05e7
            java.lang.String r6 = r3.zzr     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x05e7
            java.lang.String r6 = r3.zzr     // Catch:{ all -> 0x08c8 }
            r2.zzo(r6)     // Catch:{ all -> 0x08c8 }
            goto L_0x05e7
        L_0x05da:
            java.lang.String r6 = r3.zzr     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x05e7
            java.lang.String r6 = r3.zzr     // Catch:{ all -> 0x08c8 }
            r2.zzo(r6)     // Catch:{ all -> 0x08c8 }
        L_0x05e7:
            long r6 = r3.zzf     // Catch:{ all -> 0x08c8 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x05f4
            long r6 = r3.zzf     // Catch:{ all -> 0x08c8 }
            r2.zzh((long) r6)     // Catch:{ all -> 0x08c8 }
        L_0x05f4:
            long r6 = r3.zzt     // Catch:{ all -> 0x08c8 }
            r2.zzk((long) r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzb()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.zzak.zzbk     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zze(r7, r10)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0616
            com.google.android.gms.measurement.internal.zzjt r6 = r27.zzh()     // Catch:{ all -> 0x08c8 }
            java.util.List r6 = r6.zzf()     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0616
            r2.zzd((java.lang.Iterable<? extends java.lang.Integer>) r6)     // Catch:{ all -> 0x08c8 }
        L_0x0616:
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzes r6 = r6.zzc()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x08c8 }
            android.util.Pair r6 = r6.zza((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0649
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08c8 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x08c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x0649
            boolean r7 = r3.zzo     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x06ab
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x08c8 }
            r2.zzh((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            java.lang.Object r7 = r6.second     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x06ab
            java.lang.Object r6 = r6.second     // Catch:{ all -> 0x08c8 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x08c8 }
            r2.zza((boolean) r6)     // Catch:{ all -> 0x08c8 }
            goto L_0x06ab
        L_0x0649:
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzx()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            android.content.Context r7 = r7.zzn()     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zza(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x06ab
            boolean r6 = r3.zzp     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x06ab
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            android.content.Context r6 = r6.zzn()     // Catch:{ all -> 0x08c8 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x068b
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r6 = r6.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r6 = r6.zzi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = "null secure ID. appId"
            java.lang.String r10 = r2.zzj()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r10)     // Catch:{ all -> 0x08c8 }
            r6.zza(r7, r10)     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = "null"
            goto L_0x06a8
        L_0x068b:
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x06a8
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r7 = r7.zzi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = "empty secure ID. appId"
            java.lang.String r11 = r2.zzj()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r11)     // Catch:{ all -> 0x08c8 }
            r7.zza(r10, r11)     // Catch:{ all -> 0x08c8 }
        L_0x06a8:
            r2.zzm(r6)     // Catch:{ all -> 0x08c8 }
        L_0x06ab:
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzx()     // Catch:{ all -> 0x08c8 }
            r6.zzaa()     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r6 = r2.zzc((java.lang.String) r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzx()     // Catch:{ all -> 0x08c8 }
            r7.zzaa()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r6 = r6.zzb((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzx()     // Catch:{ all -> 0x08c8 }
            long r10 = r7.zzf()     // Catch:{ all -> 0x08c8 }
            int r7 = (int) r10     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r6 = r6.zze((int) r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzac r7 = r7.zzx()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.zzg()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r6 = r6.zzd((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzl     // Catch:{ all -> 0x08c8 }
            r6.zzj((long) r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x08c8 }
            boolean r6 = r6.zzab()     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0707
            boolean r6 = com.google.android.gms.measurement.internal.zzs.zzy()     // Catch:{ all -> 0x08c8 }
            if (r6 == 0) goto L_0x0707
            r2.zzj()     // Catch:{ all -> 0x08c8 }
            boolean r6 = android.text.TextUtils.isEmpty(r28)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x0707
            r6 = r28
            r2.zzn(r6)     // Catch:{ all -> 0x08c8 }
        L_0x0707:
            com.google.android.gms.measurement.internal.zzx r6 = r27.zze()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zza     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzf r6 = r6.zzb(r7)     // Catch:{ all -> 0x08c8 }
            if (r6 != 0) goto L_0x077a
            com.google.android.gms.measurement.internal.zzf r6 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x08c8 }
            r6.<init>(r7, r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjx r7 = r7.zzi()     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.zzk()     // Catch:{ all -> 0x08c8 }
            r6.zza((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzk     // Catch:{ all -> 0x08c8 }
            r6.zze((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzb     // Catch:{ all -> 0x08c8 }
            r6.zzb((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzc()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r3.zza     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r7.zzb((java.lang.String) r10)     // Catch:{ all -> 0x08c8 }
            r6.zzd((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            r6.zzg((long) r8)     // Catch:{ all -> 0x08c8 }
            r6.zza((long) r8)     // Catch:{ all -> 0x08c8 }
            r6.zzb((long) r8)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzc     // Catch:{ all -> 0x08c8 }
            r6.zzf((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzj     // Catch:{ all -> 0x08c8 }
            r6.zzc((long) r10)     // Catch:{ all -> 0x08c8 }
            java.lang.String r7 = r3.zzd     // Catch:{ all -> 0x08c8 }
            r6.zzg((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zze     // Catch:{ all -> 0x08c8 }
            r6.zzd((long) r10)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzf     // Catch:{ all -> 0x08c8 }
            r6.zze((long) r10)     // Catch:{ all -> 0x08c8 }
            boolean r7 = r3.zzh     // Catch:{ all -> 0x08c8 }
            r6.zza((boolean) r7)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzl     // Catch:{ all -> 0x08c8 }
            r6.zzp(r10)     // Catch:{ all -> 0x08c8 }
            long r10 = r3.zzt     // Catch:{ all -> 0x08c8 }
            r6.zzf((long) r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r7 = r27.zze()     // Catch:{ all -> 0x08c8 }
            r7.zza((com.google.android.gms.measurement.internal.zzf) r6)     // Catch:{ all -> 0x08c8 }
        L_0x077a:
            java.lang.String r7 = r6.zzc()     // Catch:{ all -> 0x08c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x078b
            java.lang.String r7 = r6.zzc()     // Catch:{ all -> 0x08c8 }
            r2.zzi((java.lang.String) r7)     // Catch:{ all -> 0x08c8 }
        L_0x078b:
            java.lang.String r7 = r6.zzg()     // Catch:{ all -> 0x08c8 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08c8 }
            if (r7 != 0) goto L_0x079c
            java.lang.String r6 = r6.zzg()     // Catch:{ all -> 0x08c8 }
            r2.zzl((java.lang.String) r6)     // Catch:{ all -> 0x08c8 }
        L_0x079c:
            com.google.android.gms.measurement.internal.zzx r6 = r27.zze()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = r3.zza     // Catch:{ all -> 0x08c8 }
            java.util.List r3 = r6.zza((java.lang.String) r3)     // Catch:{ all -> 0x08c8 }
            r6 = 0
        L_0x07a7:
            int r7 = r3.size()     // Catch:{ all -> 0x08c8 }
            if (r6 >= r7) goto L_0x07de
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r7 = com.google.android.gms.internal.measurement.zzbr.zzk.zzj()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjy r10 = (com.google.android.gms.measurement.internal.zzjy) r10     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r10.zzc     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r7 = r7.zza((java.lang.String) r10)     // Catch:{ all -> 0x08c8 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjy r10 = (com.google.android.gms.measurement.internal.zzjy) r10     // Catch:{ all -> 0x08c8 }
            long r10 = r10.zzd     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r7 = r7.zza((long) r10)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjt r10 = r27.zzh()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r11 = r3.get(r6)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzjy r11 = (com.google.android.gms.measurement.internal.zzjy) r11     // Catch:{ all -> 0x08c8 }
            java.lang.Object r11 = r11.zze     // Catch:{ all -> 0x08c8 }
            r10.zza((com.google.android.gms.internal.measurement.zzbr.zzk.zza) r7, (java.lang.Object) r11)     // Catch:{ all -> 0x08c8 }
            r2.zza((com.google.android.gms.internal.measurement.zzbr.zzk.zza) r7)     // Catch:{ all -> 0x08c8 }
            int r6 = r6 + 1
            goto L_0x07a7
        L_0x07de:
            com.google.android.gms.measurement.internal.zzx r3 = r27.zze()     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.internal.measurement.zzgn r6 = r2.zzu()     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.internal.measurement.zzfd r6 = (com.google.android.gms.internal.measurement.zzfd) r6     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = (com.google.android.gms.internal.measurement.zzbr.zzg) r6     // Catch:{ IOException -> 0x0856 }
            long r2 = r3.zza((com.google.android.gms.internal.measurement.zzbr.zzg) r6)     // Catch:{ IOException -> 0x0856 }
            com.google.android.gms.measurement.internal.zzx r6 = r27.zze()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzah r7 = r4.zze     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x084c
            com.google.android.gms.measurement.internal.zzah r7 = r4.zze     // Catch:{ all -> 0x08c8 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x08c8 }
        L_0x07fc:
            boolean r10 = r7.hasNext()     // Catch:{ all -> 0x08c8 }
            if (r10 == 0) goto L_0x0814
            java.lang.Object r10 = r7.next()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x08c8 }
            r11 = r26
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x08c8 }
            if (r10 == 0) goto L_0x0811
            goto L_0x084d
        L_0x0811:
            r26 = r11
            goto L_0x07fc
        L_0x0814:
            com.google.android.gms.measurement.internal.zzfh r7 = r27.zzc()     // Catch:{ all -> 0x08c8 }
            java.lang.String r10 = r4.zza     // Catch:{ all -> 0x08c8 }
            java.lang.String r11 = r4.zzb     // Catch:{ all -> 0x08c8 }
            boolean r7 = r7.zzc(r10, r11)     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzx r10 = r27.zze()     // Catch:{ all -> 0x08c8 }
            long r11 = r27.zzx()     // Catch:{ all -> 0x08c8 }
            java.lang.String r13 = r4.zza     // Catch:{ all -> 0x08c8 }
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            com.google.android.gms.measurement.internal.zzw r10 = r10.zza(r11, r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x08c8 }
            if (r7 == 0) goto L_0x084c
            long r10 = r10.zze     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzb()     // Catch:{ all -> 0x08c8 }
            java.lang.String r12 = r4.zza     // Catch:{ all -> 0x08c8 }
            int r7 = r7.zza((java.lang.String) r12)     // Catch:{ all -> 0x08c8 }
            long r12 = (long) r7     // Catch:{ all -> 0x08c8 }
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x084c
            goto L_0x084d
        L_0x084c:
            r5 = 0
        L_0x084d:
            boolean r2 = r6.zza((com.google.android.gms.measurement.internal.zzaf) r4, (long) r2, (boolean) r5)     // Catch:{ all -> 0x08c8 }
            if (r2 == 0) goto L_0x086f
            r1.zzn = r8     // Catch:{ all -> 0x08c8 }
            goto L_0x086f
        L_0x0856:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzf()     // Catch:{ all -> 0x08c8 }
            java.lang.String r6 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.zzj()     // Catch:{ all -> 0x08c8 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r2)     // Catch:{ all -> 0x08c8 }
            r5.zza(r6, r2, r3)     // Catch:{ all -> 0x08c8 }
        L_0x086f:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()     // Catch:{ all -> 0x08c8 }
            r2.b_()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzfn r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzr()     // Catch:{ all -> 0x08c8 }
            r3 = 2
            boolean r2 = r2.zza((int) r3)     // Catch:{ all -> 0x08c8 }
            if (r2 == 0) goto L_0x089c
            com.google.android.gms.measurement.internal.zzfn r2 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzr()     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzx()     // Catch:{ all -> 0x08c8 }
            java.lang.String r3 = "Event recorded"
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj     // Catch:{ all -> 0x08c8 }
            com.google.android.gms.measurement.internal.zzeh r5 = r5.zzj()     // Catch:{ all -> 0x08c8 }
            java.lang.String r4 = r5.zza((com.google.android.gms.measurement.internal.zzaf) r4)     // Catch:{ all -> 0x08c8 }
            r2.zza(r3, r4)     // Catch:{ all -> 0x08c8 }
        L_0x089c:
            com.google.android.gms.measurement.internal.zzx r2 = r27.zze()
            r2.zzh()
            r27.zzz()
            com.google.android.gms.measurement.internal.zzfn r2 = r1.zzj
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzx()
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r23
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.zza(r4, r3)
            return
        L_0x08c8:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.zzx r3 = r27.zze()
            r3.zzh()
            goto L_0x08d3
        L_0x08d2:
            throw r2
        L_0x08d3:
            goto L_0x08d2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjp.zzb(com.google.android.gms.measurement.internal.zzai, com.google.android.gms.measurement.internal.zzn):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:95|96) */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r1.zzj.zzr().zzf().zza("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.zzej.zza(r5), r9);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x02c6 */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzl() {
        /*
            r17 = this;
            r1 = r17
            r17.zzw()
            r17.zzk()
            r0 = 1
            r1.zzt = r0
            r2 = 0
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0302 }
            r3.zzu()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzhy r3 = r3.zzw()     // Catch:{ all -> 0x0302 }
            java.lang.Boolean r3 = r3.zzag()     // Catch:{ all -> 0x0302 }
            if (r3 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzr()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzi()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Upload data called on the client side before use of service was decided"
            r0.zza(r3)     // Catch:{ all -> 0x0302 }
            r1.zzt = r2
            r17.zzaa()
            return
        L_0x0032:
            boolean r3 = r3.booleanValue()     // Catch:{ all -> 0x0302 }
            if (r3 == 0) goto L_0x004d
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzr()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzf()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Upload called in the client side when service should be used"
            r0.zza(r3)     // Catch:{ all -> 0x0302 }
            r1.zzt = r2
            r17.zzaa()
            return
        L_0x004d:
            long r3 = r1.zzn     // Catch:{ all -> 0x0302 }
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x005e
            r17.zzz()     // Catch:{ all -> 0x0302 }
            r1.zzt = r2
            r17.zzaa()
            return
        L_0x005e:
            r17.zzw()     // Catch:{ all -> 0x0302 }
            java.util.List<java.lang.Long> r3 = r1.zzw     // Catch:{ all -> 0x0302 }
            if (r3 == 0) goto L_0x0067
            r3 = 1
            goto L_0x0068
        L_0x0067:
            r3 = 0
        L_0x0068:
            if (r3 == 0) goto L_0x007f
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzr()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzx()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Uploading requested multiple times"
            r0.zza(r3)     // Catch:{ all -> 0x0302 }
            r1.zzt = r2
            r17.zzaa()
            return
        L_0x007f:
            com.google.android.gms.measurement.internal.zzen r3 = r17.zzd()     // Catch:{ all -> 0x0302 }
            boolean r3 = r3.zzf()     // Catch:{ all -> 0x0302 }
            if (r3 != 0) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzr()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzx()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Network not connected, ignoring upload request"
            r0.zza(r3)     // Catch:{ all -> 0x0302 }
            r17.zzz()     // Catch:{ all -> 0x0302 }
            r1.zzt = r2
            r17.zzaa()
            return
        L_0x00a1:
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.common.util.Clock r3 = r3.zzm()     // Catch:{ all -> 0x0302 }
            long r3 = r3.currentTimeMillis()     // Catch:{ all -> 0x0302 }
            long r7 = com.google.android.gms.measurement.internal.zzs.zzv()     // Catch:{ all -> 0x0302 }
            long r7 = r3 - r7
            r9 = 0
            r1.zza((java.lang.String) r9, (long) r7)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzc()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzc     // Catch:{ all -> 0x0302 }
            long r7 = r7.zza()     // Catch:{ all -> 0x0302 }
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 == 0) goto L_0x00de
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzr()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzw()     // Catch:{ all -> 0x0302 }
            java.lang.String r6 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r7 = r3 - r7
            long r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x0302 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0302 }
            r5.zza(r6, r7)     // Catch:{ all -> 0x0302 }
        L_0x00de:
            com.google.android.gms.measurement.internal.zzx r5 = r17.zze()     // Catch:{ all -> 0x0302 }
            java.lang.String r5 = r5.d_()     // Catch:{ all -> 0x0302 }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0302 }
            r7 = -1
            if (r6 != 0) goto L_0x02da
            long r10 = r1.zzy     // Catch:{ all -> 0x0302 }
            int r6 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x00fe
            com.google.android.gms.measurement.internal.zzx r6 = r17.zze()     // Catch:{ all -> 0x0302 }
            long r6 = r6.zzaa()     // Catch:{ all -> 0x0302 }
            r1.zzy = r6     // Catch:{ all -> 0x0302 }
        L_0x00fe:
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzb()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzak.zzj     // Catch:{ all -> 0x0302 }
            int r6 = r6.zzb(r5, r7)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzb()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Integer> r8 = com.google.android.gms.measurement.internal.zzak.zzk     // Catch:{ all -> 0x0302 }
            int r7 = r7.zzb(r5, r8)     // Catch:{ all -> 0x0302 }
            int r7 = java.lang.Math.max(r2, r7)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzx r8 = r17.zze()     // Catch:{ all -> 0x0302 }
            java.util.List r6 = r8.zza((java.lang.String) r5, (int) r6, (int) r7)     // Catch:{ all -> 0x0302 }
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x0302 }
            if (r7 != 0) goto L_0x02fc
            java.util.Iterator r7 = r6.iterator()     // Catch:{ all -> 0x0302 }
        L_0x012c:
            boolean r8 = r7.hasNext()     // Catch:{ all -> 0x0302 }
            if (r8 == 0) goto L_0x014b
            java.lang.Object r8 = r7.next()     // Catch:{ all -> 0x0302 }
            android.util.Pair r8 = (android.util.Pair) r8     // Catch:{ all -> 0x0302 }
            java.lang.Object r8 = r8.first     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbr$zzg r8 = (com.google.android.gms.internal.measurement.zzbr.zzg) r8     // Catch:{ all -> 0x0302 }
            java.lang.String r10 = r8.zzad()     // Catch:{ all -> 0x0302 }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x0302 }
            if (r10 != 0) goto L_0x012c
            java.lang.String r7 = r8.zzad()     // Catch:{ all -> 0x0302 }
            goto L_0x014c
        L_0x014b:
            r7 = r9
        L_0x014c:
            if (r7 == 0) goto L_0x017b
            r8 = 0
        L_0x014f:
            int r10 = r6.size()     // Catch:{ all -> 0x0302 }
            if (r8 >= r10) goto L_0x017b
            java.lang.Object r10 = r6.get(r8)     // Catch:{ all -> 0x0302 }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ all -> 0x0302 }
            java.lang.Object r10 = r10.first     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbr$zzg r10 = (com.google.android.gms.internal.measurement.zzbr.zzg) r10     // Catch:{ all -> 0x0302 }
            java.lang.String r11 = r10.zzad()     // Catch:{ all -> 0x0302 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x0302 }
            if (r11 != 0) goto L_0x0178
            java.lang.String r10 = r10.zzad()     // Catch:{ all -> 0x0302 }
            boolean r10 = r10.equals(r7)     // Catch:{ all -> 0x0302 }
            if (r10 != 0) goto L_0x0178
            java.util.List r6 = r6.subList(r2, r8)     // Catch:{ all -> 0x0302 }
            goto L_0x017b
        L_0x0178:
            int r8 = r8 + 1
            goto L_0x014f
        L_0x017b:
            com.google.android.gms.internal.measurement.zzbr$zzf$zza r7 = com.google.android.gms.internal.measurement.zzbr.zzf.zzb()     // Catch:{ all -> 0x0302 }
            int r8 = r6.size()     // Catch:{ all -> 0x0302 }
            java.util.ArrayList r10 = new java.util.ArrayList     // Catch:{ all -> 0x0302 }
            int r11 = r6.size()     // Catch:{ all -> 0x0302 }
            r10.<init>(r11)     // Catch:{ all -> 0x0302 }
            boolean r11 = com.google.android.gms.measurement.internal.zzs.zzy()     // Catch:{ all -> 0x0302 }
            if (r11 == 0) goto L_0x01a0
            com.google.android.gms.measurement.internal.zzfn r11 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzb()     // Catch:{ all -> 0x0302 }
            boolean r11 = r11.zzd(r5)     // Catch:{ all -> 0x0302 }
            if (r11 == 0) goto L_0x01a0
            r11 = 1
            goto L_0x01a1
        L_0x01a0:
            r11 = 0
        L_0x01a1:
            r12 = 0
        L_0x01a2:
            if (r12 >= r8) goto L_0x020d
            java.lang.Object r13 = r6.get(r12)     // Catch:{ all -> 0x0302 }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x0302 }
            java.lang.Object r13 = r13.first     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbr$zzg r13 = (com.google.android.gms.internal.measurement.zzbr.zzg) r13     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzfd$zza r13 = r13.zzbk()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzfd$zza r13 = (com.google.android.gms.internal.measurement.zzfd.zza) r13     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r13 = (com.google.android.gms.internal.measurement.zzbr.zzg.zza) r13     // Catch:{ all -> 0x0302 }
            java.lang.Object r14 = r6.get(r12)     // Catch:{ all -> 0x0302 }
            android.util.Pair r14 = (android.util.Pair) r14     // Catch:{ all -> 0x0302 }
            java.lang.Object r14 = r14.second     // Catch:{ all -> 0x0302 }
            java.lang.Long r14 = (java.lang.Long) r14     // Catch:{ all -> 0x0302 }
            r10.add(r14)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfn r14 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r14 = r14.zzb()     // Catch:{ all -> 0x0302 }
            long r14 = r14.zzf()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r14 = r13.zzg((long) r14)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r14 = r14.zza((long) r3)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzfn r15 = r1.zzj     // Catch:{ all -> 0x0302 }
            r15.zzu()     // Catch:{ all -> 0x0302 }
            r14.zzb((boolean) r2)     // Catch:{ all -> 0x0302 }
            if (r11 != 0) goto L_0x01e2
            r13.zzn()     // Catch:{ all -> 0x0302 }
        L_0x01e2:
            com.google.android.gms.measurement.internal.zzfn r14 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzs r14 = r14.zzb()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.zzak.zzbo     // Catch:{ all -> 0x0302 }
            boolean r14 = r14.zze(r5, r15)     // Catch:{ all -> 0x0302 }
            if (r14 == 0) goto L_0x0207
            com.google.android.gms.internal.measurement.zzgn r14 = r13.zzu()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzfd r14 = (com.google.android.gms.internal.measurement.zzfd) r14     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbr$zzg r14 = (com.google.android.gms.internal.measurement.zzbr.zzg) r14     // Catch:{ all -> 0x0302 }
            byte[] r14 = r14.zzbh()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzjt r15 = r17.zzh()     // Catch:{ all -> 0x0302 }
            long r14 = r15.zza((byte[]) r14)     // Catch:{ all -> 0x0302 }
            r13.zzl((long) r14)     // Catch:{ all -> 0x0302 }
        L_0x0207:
            r7.zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r13)     // Catch:{ all -> 0x0302 }
            int r12 = r12 + 1
            goto L_0x01a2
        L_0x020d:
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzej r6 = r6.zzr()     // Catch:{ all -> 0x0302 }
            r11 = 2
            boolean r6 = r6.zza((int) r11)     // Catch:{ all -> 0x0302 }
            if (r6 == 0) goto L_0x022b
            com.google.android.gms.measurement.internal.zzjt r6 = r17.zzh()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzgn r11 = r7.zzu()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzfd r11 = (com.google.android.gms.internal.measurement.zzfd) r11     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbr$zzf r11 = (com.google.android.gms.internal.measurement.zzbr.zzf) r11     // Catch:{ all -> 0x0302 }
            java.lang.String r6 = r6.zza((com.google.android.gms.internal.measurement.zzbr.zzf) r11)     // Catch:{ all -> 0x0302 }
            goto L_0x022c
        L_0x022b:
            r6 = r9
        L_0x022c:
            r17.zzh()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzgn r11 = r7.zzu()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzfd r11 = (com.google.android.gms.internal.measurement.zzfd) r11     // Catch:{ all -> 0x0302 }
            com.google.android.gms.internal.measurement.zzbr$zzf r11 = (com.google.android.gms.internal.measurement.zzbr.zzf) r11     // Catch:{ all -> 0x0302 }
            byte[] r14 = r11.zzbh()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.String> r11 = com.google.android.gms.measurement.internal.zzak.zzt     // Catch:{ all -> 0x0302 }
            java.lang.Object r9 = r11.zza(r9)     // Catch:{ all -> 0x0302 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0302 }
            java.net.URL r13 = new java.net.URL     // Catch:{ MalformedURLException -> 0x02c6 }
            r13.<init>(r9)     // Catch:{ MalformedURLException -> 0x02c6 }
            boolean r11 = r10.isEmpty()     // Catch:{ MalformedURLException -> 0x02c6 }
            if (r11 != 0) goto L_0x0250
            r11 = 1
            goto L_0x0251
        L_0x0250:
            r11 = 0
        L_0x0251:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r11)     // Catch:{ MalformedURLException -> 0x02c6 }
            java.util.List<java.lang.Long> r11 = r1.zzw     // Catch:{ MalformedURLException -> 0x02c6 }
            if (r11 == 0) goto L_0x0268
            com.google.android.gms.measurement.internal.zzfn r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzej r10 = r10.zzr()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzel r10 = r10.zzf()     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r11 = "Set uploading progress before finishing the previous upload"
            r10.zza(r11)     // Catch:{ MalformedURLException -> 0x02c6 }
            goto L_0x026f
        L_0x0268:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x02c6 }
            r11.<init>(r10)     // Catch:{ MalformedURLException -> 0x02c6 }
            r1.zzw = r11     // Catch:{ MalformedURLException -> 0x02c6 }
        L_0x026f:
            com.google.android.gms.measurement.internal.zzfn r10 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzes r10 = r10.zzc()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzex r10 = r10.zzd     // Catch:{ MalformedURLException -> 0x02c6 }
            r10.zza(r3)     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r3 = "?"
            if (r8 <= 0) goto L_0x0286
            com.google.android.gms.internal.measurement.zzbr$zzg r3 = r7.zza((int) r2)     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r3 = r3.zzx()     // Catch:{ MalformedURLException -> 0x02c6 }
        L_0x0286:
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzx()     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.String r7 = "Uploading data. app, uncompressed size, data"
            int r8 = r14.length     // Catch:{ MalformedURLException -> 0x02c6 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ MalformedURLException -> 0x02c6 }
            r4.zza(r7, r3, r8, r6)     // Catch:{ MalformedURLException -> 0x02c6 }
            r1.zzs = r0     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzen r11 = r17.zzd()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzjr r0 = new com.google.android.gms.measurement.internal.zzjr     // Catch:{ MalformedURLException -> 0x02c6 }
            r0.<init>(r1, r5)     // Catch:{ MalformedURLException -> 0x02c6 }
            r11.zzd()     // Catch:{ MalformedURLException -> 0x02c6 }
            r11.zzak()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r13)     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r14)     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzfg r3 = r11.zzq()     // Catch:{ MalformedURLException -> 0x02c6 }
            com.google.android.gms.measurement.internal.zzer r4 = new com.google.android.gms.measurement.internal.zzer     // Catch:{ MalformedURLException -> 0x02c6 }
            r15 = 0
            r10 = r4
            r12 = r5
            r16 = r0
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ MalformedURLException -> 0x02c6 }
            r3.zzb((java.lang.Runnable) r4)     // Catch:{ MalformedURLException -> 0x02c6 }
            goto L_0x02fc
        L_0x02c6:
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzr()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzf()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r5)     // Catch:{ all -> 0x0302 }
            r0.zza(r3, r4, r9)     // Catch:{ all -> 0x0302 }
            goto L_0x02fc
        L_0x02da:
            r1.zzy = r7     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzx r0 = r17.zze()     // Catch:{ all -> 0x0302 }
            long r5 = com.google.android.gms.measurement.internal.zzs.zzv()     // Catch:{ all -> 0x0302 }
            long r3 = r3 - r5
            java.lang.String r0 = r0.zza((long) r3)     // Catch:{ all -> 0x0302 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0302 }
            if (r3 != 0) goto L_0x02fc
            com.google.android.gms.measurement.internal.zzx r3 = r17.zze()     // Catch:{ all -> 0x0302 }
            com.google.android.gms.measurement.internal.zzf r0 = r3.zzb(r0)     // Catch:{ all -> 0x0302 }
            if (r0 == 0) goto L_0x02fc
            r1.zza((com.google.android.gms.measurement.internal.zzf) r0)     // Catch:{ all -> 0x0302 }
        L_0x02fc:
            r1.zzt = r2
            r17.zzaa()
            return
        L_0x0302:
            r0 = move-exception
            r1.zzt = r2
            r17.zzaa()
            goto L_0x030a
        L_0x0309:
            throw r0
        L_0x030a:
            goto L_0x0309
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjp.zzl():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0251, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0252, code lost:
        r8 = r3;
        r7 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r2 = r0;
        r8 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r7 = null;
        r8 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:493:0x0cce, code lost:
        if (r5 != r14) goto L_0x0cd0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:588:?, code lost:
        r8.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[ExcHandler: all (r0v16 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r3 
      PHI: (r3v165 android.database.Cursor) = (r3v160 android.database.Cursor), (r3v160 android.database.Cursor), (r3v160 android.database.Cursor), (r3v168 android.database.Cursor), (r3v168 android.database.Cursor), (r3v168 android.database.Cursor), (r3v168 android.database.Cursor), (r3v1 android.database.Cursor), (r3v1 android.database.Cursor) binds: [B:47:0x00da, B:53:0x00e7, B:54:?, B:24:0x007c, B:30:0x0089, B:32:0x008d, B:33:?, B:9:0x0031, B:10:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0272 A[SYNTHETIC, Splitter:B:131:0x0272] */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0279 A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0287 A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x03c9 A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x03cb A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x03ce A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x03cf A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x05de A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x060b A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x06a7 A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:319:0x07be A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:320:0x07d8 A[Catch:{ IOException -> 0x0228, all -> 0x0f50 }] */
    /* JADX WARNING: Removed duplicated region for block: B:456:0x0c19 A[Catch:{ all -> 0x0d8c }] */
    /* JADX WARNING: Removed duplicated region for block: B:457:0x0c1b A[Catch:{ all -> 0x0d8c }] */
    /* JADX WARNING: Removed duplicated region for block: B:461:0x0c23 A[SYNTHETIC, Splitter:B:461:0x0c23] */
    /* JADX WARNING: Removed duplicated region for block: B:472:0x0c51 A[SYNTHETIC, Splitter:B:472:0x0c51] */
    /* JADX WARNING: Removed duplicated region for block: B:500:0x0ceb A[Catch:{ all -> 0x0d8c }] */
    /* JADX WARNING: Removed duplicated region for block: B:504:0x0d33 A[Catch:{ all -> 0x0d8c }] */
    /* JADX WARNING: Removed duplicated region for block: B:580:0x0f38 A[SYNTHETIC, Splitter:B:580:0x0f38] */
    /* JADX WARNING: Removed duplicated region for block: B:587:0x0f4c A[SYNTHETIC, Splitter:B:587:0x0f4c] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zza(java.lang.String r60, long r61) {
        /*
            r59 = this;
            r1 = r59
            com.google.android.gms.measurement.internal.zzx r2 = r59.zze()
            r2.zzf()
            com.google.android.gms.measurement.internal.zzjp$zza r2 = new com.google.android.gms.measurement.internal.zzjp$zza     // Catch:{ all -> 0x0f50 }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzx r4 = r59.zze()     // Catch:{ all -> 0x0f50 }
            long r5 = r1.zzy     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0f50 }
            r4.zzd()     // Catch:{ all -> 0x0f50 }
            r4.zzak()     // Catch:{ all -> 0x0f50 }
            r8 = -1
            r10 = 2
            r11 = 0
            r12 = 1
            android.database.sqlite.SQLiteDatabase r15 = r4.c_()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            boolean r13 = android.text.TextUtils.isEmpty(r3)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            if (r13 == 0) goto L_0x009c
            int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r13 == 0) goto L_0x004b
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            java.lang.String r14 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            r13[r11] = r14     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            java.lang.String r14 = java.lang.String.valueOf(r61)     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            r13[r12] = r14     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            goto L_0x0053
        L_0x0040:
            r0 = move-exception
            r2 = r0
            r8 = r3
            goto L_0x0f4a
        L_0x0045:
            r0 = move-exception
            r7 = r3
            r8 = r7
        L_0x0048:
            r3 = r0
            goto L_0x025f
        L_0x004b:
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            java.lang.String r14 = java.lang.String.valueOf(r61)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            r13[r11] = r14     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        L_0x0053:
            int r14 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r14 == 0) goto L_0x005a
            java.lang.String r14 = "rowid <= ? and "
            goto L_0x005c
        L_0x005a:
            java.lang.String r14 = ""
        L_0x005c:
            int r7 = r14.length()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            int r7 = r7 + 148
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            r3.<init>(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r3.append(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            r3.append(r14)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            java.lang.String r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r3.append(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            java.lang.String r3 = r3.toString()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            android.database.Cursor r3 = r15.rawQuery(r3, r13)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0251, all -> 0x0040 }
            if (r7 != 0) goto L_0x0089
            if (r3 == 0) goto L_0x0275
            r3.close()     // Catch:{ all -> 0x0f50 }
            goto L_0x0275
        L_0x0089:
            java.lang.String r7 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0251, all -> 0x0040 }
            java.lang.String r13 = r3.getString(r12)     // Catch:{ SQLiteException -> 0x0099, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x0099, all -> 0x0040 }
            r22 = r3
            r3 = r7
            r7 = r13
            goto L_0x00f2
        L_0x0099:
            r0 = move-exception
            r8 = r3
            goto L_0x0048
        L_0x009c:
            int r3 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r3 == 0) goto L_0x00ac
            java.lang.String[] r3 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            r7 = 0
            r3[r11] = r7     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            java.lang.String r7 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            r3[r12] = r7     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            goto L_0x00b1
        L_0x00ac:
            java.lang.String[] r3 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            r7 = 0
            r3[r11] = r7     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
        L_0x00b1:
            int r7 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r7 == 0) goto L_0x00b8
            java.lang.String r7 = " and rowid <= ?"
            goto L_0x00ba
        L_0x00b8:
            java.lang.String r7 = ""
        L_0x00ba:
            int r13 = r7.length()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            int r13 = r13 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            r14.<init>(r13)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            java.lang.String r13 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r13)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            r14.append(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            java.lang.String r7 = " order by rowid limit 1;"
            r14.append(r7)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            java.lang.String r7 = r14.toString()     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            android.database.Cursor r3 = r15.rawQuery(r7, r3)     // Catch:{ SQLiteException -> 0x025b, all -> 0x0256 }
            boolean r7 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0251, all -> 0x0040 }
            if (r7 != 0) goto L_0x00e7
            if (r3 == 0) goto L_0x0275
            r3.close()     // Catch:{ all -> 0x0f50 }
            goto L_0x0275
        L_0x00e7:
            java.lang.String r13 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0251, all -> 0x0040 }
            r3.close()     // Catch:{ SQLiteException -> 0x0251, all -> 0x0040 }
            r22 = r3
            r7 = r13
            r3 = 0
        L_0x00f2:
            java.lang.String r14 = "raw_events_metadata"
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x024b, all -> 0x0245 }
            java.lang.String r16 = "metadata"
            r13[r11] = r16     // Catch:{ SQLiteException -> 0x024b, all -> 0x0245 }
            java.lang.String r16 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r8 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x024b, all -> 0x0245 }
            r8[r11] = r3     // Catch:{ SQLiteException -> 0x024b, all -> 0x0245 }
            r8[r12] = r7     // Catch:{ SQLiteException -> 0x024b, all -> 0x0245 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            java.lang.String r21 = "2"
            r9 = r13
            r13 = r15
            r23 = r15
            r15 = r9
            r17 = r8
            android.database.Cursor r8 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x024b, all -> 0x0245 }
            boolean r9 = r8.moveToFirst()     // Catch:{ SQLiteException -> 0x0241 }
            if (r9 != 0) goto L_0x0133
            com.google.android.gms.measurement.internal.zzej r5 = r4.zzr()     // Catch:{ SQLiteException -> 0x0241 }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzf()     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r6 = "Raw event metadata record is missing. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0241 }
            r5.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0241 }
            if (r8 == 0) goto L_0x0275
            r8.close()     // Catch:{ all -> 0x0f50 }
            goto L_0x0275
        L_0x0133:
            byte[] r9 = r8.getBlob(r11)     // Catch:{ SQLiteException -> 0x0241 }
            com.google.android.gms.internal.measurement.zzeq r13 = com.google.android.gms.internal.measurement.zzeq.zzb()     // Catch:{ IOException -> 0x0228 }
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = com.google.android.gms.internal.measurement.zzbr.zzg.zza((byte[]) r9, (com.google.android.gms.internal.measurement.zzeq) r13)     // Catch:{ IOException -> 0x0228 }
            boolean r13 = r8.moveToNext()     // Catch:{ SQLiteException -> 0x0241 }
            if (r13 == 0) goto L_0x0156
            com.google.android.gms.measurement.internal.zzej r13 = r4.zzr()     // Catch:{ SQLiteException -> 0x0241 }
            com.google.android.gms.measurement.internal.zzel r13 = r13.zzi()     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r14 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r15 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0241 }
            r13.zza(r14, r15)     // Catch:{ SQLiteException -> 0x0241 }
        L_0x0156:
            r8.close()     // Catch:{ SQLiteException -> 0x0241 }
            r2.zza(r9)     // Catch:{ SQLiteException -> 0x0241 }
            r13 = -1
            int r9 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r9 == 0) goto L_0x0176
            java.lang.String r9 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r13 = 3
            java.lang.String[] r14 = new java.lang.String[r13]     // Catch:{ SQLiteException -> 0x0241 }
            r14[r11] = r3     // Catch:{ SQLiteException -> 0x0241 }
            r14[r12] = r7     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0241 }
            r14[r10] = r5     // Catch:{ SQLiteException -> 0x0241 }
            r16 = r9
            r17 = r14
            goto L_0x0182
        L_0x0176:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r6 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0241 }
            r6[r11] = r3     // Catch:{ SQLiteException -> 0x0241 }
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x0241 }
            r16 = r5
            r17 = r6
        L_0x0182:
            java.lang.String r14 = "raw_events"
            r5 = 4
            java.lang.String[] r15 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = "rowid"
            r15[r11] = r5     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = "name"
            r15[r12] = r5     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = "timestamp"
            r15[r10] = r5     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r5 = "data"
            r6 = 3
            r15[r6] = r5     // Catch:{ SQLiteException -> 0x0241 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            r21 = 0
            r13 = r23
            android.database.Cursor r5 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0241 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            if (r6 != 0) goto L_0x01c4
            com.google.android.gms.measurement.internal.zzej r6 = r4.zzr()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            com.google.android.gms.measurement.internal.zzel r6 = r6.zzi()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r6.zza(r7, r8)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            if (r5 == 0) goto L_0x0275
            r5.close()     // Catch:{ all -> 0x0f50 }
            goto L_0x0275
        L_0x01c4:
            long r6 = r5.getLong(r11)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r8 = 3
            byte[] r9 = r5.getBlob(r8)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r8 = com.google.android.gms.internal.measurement.zzbr.zzc.zzj()     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzeq r13 = com.google.android.gms.internal.measurement.zzeq.zzb()     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzdn r8 = r8.zza((byte[]) r9, (com.google.android.gms.internal.measurement.zzeq) r13)     // Catch:{ IOException -> 0x01ff }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r8 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r8     // Catch:{ IOException -> 0x01ff }
            java.lang.String r9 = r5.getString(r12)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r9 = r8.zza((java.lang.String) r9)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            long r13 = r5.getLong(r10)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r9.zza((long) r13)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            com.google.android.gms.internal.measurement.zzgn r8 = r8.zzu()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            com.google.android.gms.internal.measurement.zzfd r8 = (com.google.android.gms.internal.measurement.zzfd) r8     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = (com.google.android.gms.internal.measurement.zzbr.zzc) r8     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            boolean r6 = r2.zza(r6, r8)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            if (r6 != 0) goto L_0x0212
            if (r5 == 0) goto L_0x0275
            r5.close()     // Catch:{ all -> 0x0f50 }
            goto L_0x0275
        L_0x01ff:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.zzej r7 = r4.zzr()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            com.google.android.gms.measurement.internal.zzel r7 = r7.zzf()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            java.lang.String r8 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            r7.zza(r8, r9, r6)     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
        L_0x0212:
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x0223, all -> 0x021e }
            if (r6 != 0) goto L_0x01c4
            if (r5 == 0) goto L_0x0275
            r5.close()     // Catch:{ all -> 0x0f50 }
            goto L_0x0275
        L_0x021e:
            r0 = move-exception
            r2 = r0
            r8 = r5
            goto L_0x0f4a
        L_0x0223:
            r0 = move-exception
            r7 = r3
            r8 = r5
            goto L_0x0048
        L_0x0228:
            r0 = move-exception
            r5 = r0
            com.google.android.gms.measurement.internal.zzej r6 = r4.zzr()     // Catch:{ SQLiteException -> 0x0241 }
            com.google.android.gms.measurement.internal.zzel r6 = r6.zzf()     // Catch:{ SQLiteException -> 0x0241 }
            java.lang.String r7 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r3)     // Catch:{ SQLiteException -> 0x0241 }
            r6.zza(r7, r9, r5)     // Catch:{ SQLiteException -> 0x0241 }
            if (r8 == 0) goto L_0x0275
            r8.close()     // Catch:{ all -> 0x0f50 }
            goto L_0x0275
        L_0x0241:
            r0 = move-exception
            r7 = r3
            goto L_0x0048
        L_0x0245:
            r0 = move-exception
            r2 = r0
            r8 = r22
            goto L_0x0f4a
        L_0x024b:
            r0 = move-exception
            r7 = r3
            r8 = r22
            goto L_0x0048
        L_0x0251:
            r0 = move-exception
            r8 = r3
            r7 = 0
            goto L_0x0048
        L_0x0256:
            r0 = move-exception
            r2 = r0
            r8 = 0
            goto L_0x0f4a
        L_0x025b:
            r0 = move-exception
            r3 = r0
            r7 = 0
            r8 = 0
        L_0x025f:
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ all -> 0x0f48 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()     // Catch:{ all -> 0x0f48 }
            java.lang.String r5 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r7)     // Catch:{ all -> 0x0f48 }
            r4.zza(r5, r6, r3)     // Catch:{ all -> 0x0f48 }
            if (r8 == 0) goto L_0x0275
            r8.close()     // Catch:{ all -> 0x0f50 }
        L_0x0275:
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r3 = r2.zzc     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x0284
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r3 = r2.zzc     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.isEmpty()     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x0282
            goto L_0x0284
        L_0x0282:
            r3 = 0
            goto L_0x0285
        L_0x0284:
            r3 = 1
        L_0x0285:
            if (r3 != 0) goto L_0x0f38
            com.google.android.gms.internal.measurement.zzbr$zzg r3 = r2.zza     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r3 = r3.zzbk()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r3 = (com.google.android.gms.internal.measurement.zzfd.zza) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r3 = (com.google.android.gms.internal.measurement.zzbr.zzg.zza) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r3 = r3.zzc()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzb()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzak.zzbf     // Catch:{ all -> 0x0f50 }
            boolean r4 = r4.zze(r5, r6)     // Catch:{ all -> 0x0f50 }
            r5 = -1
            r6 = 0
            r8 = 0
            r9 = 0
            r11 = -1
            r13 = 0
            r15 = 0
            r17 = 0
        L_0x02b1:
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r7 = r2.zzc     // Catch:{ all -> 0x0f50 }
            int r7 = r7.size()     // Catch:{ all -> 0x0f50 }
            java.lang.String r10 = "_e"
            java.lang.String r12 = "_et"
            r23 = r13
            if (r8 >= r7) goto L_0x0833
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r7 = r2.zzc     // Catch:{ all -> 0x0f50 }
            java.lang.Object r7 = r7.get(r8)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r7 = (com.google.android.gms.internal.measurement.zzbr.zzc) r7     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r7 = r7.zzbk()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r7 = (com.google.android.gms.internal.measurement.zzfd.zza) r7     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfh r13 = r59.zzc()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r14 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r14 = r14.zzx()     // Catch:{ all -> 0x0f50 }
            r21 = r9
            java.lang.String r9 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r9 = r13.zzb(r14, r9)     // Catch:{ all -> 0x0f50 }
            java.lang.String r13 = "_err"
            if (r9 == 0) goto L_0x0368
            com.google.android.gms.measurement.internal.zzfn r9 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r9 = r9.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzi()     // Catch:{ all -> 0x0f50 }
            java.lang.String r10 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r12)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfn r14 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzeh r14 = r14.zzj()     // Catch:{ all -> 0x0f50 }
            r22 = r15
            java.lang.String r15 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            java.lang.String r14 = r14.zza((java.lang.String) r15)     // Catch:{ all -> 0x0f50 }
            r9.zza(r10, r12, r14)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfh r9 = r59.zzc()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r10 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x0f50 }
            boolean r9 = r9.zzg(r10)     // Catch:{ all -> 0x0f50 }
            if (r9 != 0) goto L_0x0333
            com.google.android.gms.measurement.internal.zzfh r9 = r59.zzc()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r10 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x0f50 }
            boolean r9 = r9.zzh(r10)     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0331
            goto L_0x0333
        L_0x0331:
            r9 = 0
            goto L_0x0334
        L_0x0333:
            r9 = 1
        L_0x0334:
            if (r9 != 0) goto L_0x0359
            java.lang.String r9 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x0f50 }
            if (r9 != 0) goto L_0x0359
            com.google.android.gms.measurement.internal.zzfn r9 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzjx r25 = r9.zzi()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r9 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r26 = r9.zzx()     // Catch:{ all -> 0x0f50 }
            r27 = 11
            java.lang.String r28 = "_ev"
            java.lang.String r29 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            r30 = 0
            r25.zza((java.lang.String) r26, (int) r27, (java.lang.String) r28, (java.lang.String) r29, (int) r30)     // Catch:{ all -> 0x0f50 }
        L_0x0359:
            r28 = r4
            r10 = r8
            r9 = r21
            r15 = r22
            r13 = r23
            r4 = -1
            r8 = r3
            r3 = r11
            r11 = 3
            goto L_0x0828
        L_0x0368:
            r22 = r15
            com.google.android.gms.measurement.internal.zzfh r9 = r59.zzc()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r14 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r14 = r14.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.String r15 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r9 = r9.zzc(r14, r15)     // Catch:{ all -> 0x0f50 }
            java.lang.String r14 = "_c"
            if (r9 != 0) goto L_0x03d8
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            java.lang.String r15 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r15)     // Catch:{ all -> 0x0f50 }
            r27 = r8
            int r8 = r15.hashCode()     // Catch:{ all -> 0x0f50 }
            r28 = r4
            r4 = 94660(0x171c4, float:1.32647E-40)
            if (r8 == r4) goto L_0x03b6
            r4 = 95025(0x17331, float:1.33158E-40)
            if (r8 == r4) goto L_0x03ac
            r4 = 95027(0x17333, float:1.33161E-40)
            if (r8 == r4) goto L_0x03a2
            goto L_0x03c0
        L_0x03a2:
            java.lang.String r4 = "_ui"
            boolean r4 = r15.equals(r4)     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x03c0
            r4 = 1
            goto L_0x03c1
        L_0x03ac:
            java.lang.String r4 = "_ug"
            boolean r4 = r15.equals(r4)     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x03c0
            r4 = 2
            goto L_0x03c1
        L_0x03b6:
            java.lang.String r4 = "_in"
            boolean r4 = r15.equals(r4)     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x03c0
            r4 = 0
            goto L_0x03c1
        L_0x03c0:
            r4 = -1
        L_0x03c1:
            if (r4 == 0) goto L_0x03cb
            r8 = 1
            if (r4 == r8) goto L_0x03cb
            r8 = 2
            if (r4 == r8) goto L_0x03cb
            r4 = 0
            goto L_0x03cc
        L_0x03cb:
            r4 = 1
        L_0x03cc:
            if (r4 == 0) goto L_0x03cf
            goto L_0x03dc
        L_0x03cf:
            r8 = r3
            r30 = r6
            r29 = r11
            r31 = r12
            goto L_0x05b8
        L_0x03d8:
            r28 = r4
            r27 = r8
        L_0x03dc:
            r29 = r11
            r4 = 0
            r8 = 0
            r15 = 0
        L_0x03e1:
            int r11 = r7.zzb()     // Catch:{ all -> 0x0f50 }
            r30 = r6
            java.lang.String r6 = "_r"
            if (r4 >= r11) goto L_0x044f
            com.google.android.gms.internal.measurement.zzbr$zze r11 = r7.zza((int) r4)     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = r11.zza()     // Catch:{ all -> 0x0f50 }
            boolean r11 = r14.equals(r11)     // Catch:{ all -> 0x0f50 }
            if (r11 == 0) goto L_0x041a
            com.google.android.gms.internal.measurement.zzbr$zze r6 = r7.zza((int) r4)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r6 = r6.zzbk()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r6 = (com.google.android.gms.internal.measurement.zzfd.zza) r6     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r6 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r6     // Catch:{ all -> 0x0f50 }
            r31 = r12
            r11 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r6 = r6.zza((long) r11)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r6 = r6.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r6 = (com.google.android.gms.internal.measurement.zzfd) r6     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r6 = (com.google.android.gms.internal.measurement.zzbr.zze) r6     // Catch:{ all -> 0x0f50 }
            r7.zza((int) r4, (com.google.android.gms.internal.measurement.zzbr.zze) r6)     // Catch:{ all -> 0x0f50 }
            r8 = 1
            goto L_0x0448
        L_0x041a:
            r31 = r12
            com.google.android.gms.internal.measurement.zzbr$zze r11 = r7.zza((int) r4)     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = r11.zza()     // Catch:{ all -> 0x0f50 }
            boolean r6 = r6.equals(r11)     // Catch:{ all -> 0x0f50 }
            if (r6 == 0) goto L_0x0448
            com.google.android.gms.internal.measurement.zzbr$zze r6 = r7.zza((int) r4)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r6 = r6.zzbk()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r6 = (com.google.android.gms.internal.measurement.zzfd.zza) r6     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r6 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r6     // Catch:{ all -> 0x0f50 }
            r11 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r6 = r6.zza((long) r11)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r6 = r6.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r6 = (com.google.android.gms.internal.measurement.zzfd) r6     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r6 = (com.google.android.gms.internal.measurement.zzbr.zze) r6     // Catch:{ all -> 0x0f50 }
            r7.zza((int) r4, (com.google.android.gms.internal.measurement.zzbr.zze) r6)     // Catch:{ all -> 0x0f50 }
            r15 = 1
        L_0x0448:
            int r4 = r4 + 1
            r6 = r30
            r12 = r31
            goto L_0x03e1
        L_0x044f:
            r31 = r12
            if (r8 != 0) goto L_0x0483
            if (r9 == 0) goto L_0x0483
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.String r8 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.zzfn r11 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzj()     // Catch:{ all -> 0x0f50 }
            java.lang.String r12 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = r11.zza((java.lang.String) r12)     // Catch:{ all -> 0x0f50 }
            r4.zza(r8, r11)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r4 = com.google.android.gms.internal.measurement.zzbr.zze.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r4 = r4.zza((java.lang.String) r14)     // Catch:{ all -> 0x0f50 }
            r11 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r4 = r4.zza((long) r11)     // Catch:{ all -> 0x0f50 }
            r7.zza((com.google.android.gms.internal.measurement.zzbr.zze.zza) r4)     // Catch:{ all -> 0x0f50 }
        L_0x0483:
            if (r15 != 0) goto L_0x04b3
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.String r8 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.zzfn r11 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzeh r11 = r11.zzj()     // Catch:{ all -> 0x0f50 }
            java.lang.String r12 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = r11.zza((java.lang.String) r12)     // Catch:{ all -> 0x0f50 }
            r4.zza(r8, r11)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r4 = com.google.android.gms.internal.measurement.zzbr.zze.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r4 = r4.zza((java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            r11 = 1
            com.google.android.gms.internal.measurement.zzbr$zze$zza r4 = r4.zza((long) r11)     // Catch:{ all -> 0x0f50 }
            r7.zza((com.google.android.gms.internal.measurement.zzbr.zze.zza) r4)     // Catch:{ all -> 0x0f50 }
        L_0x04b3:
            com.google.android.gms.measurement.internal.zzx r32 = r59.zze()     // Catch:{ all -> 0x0f50 }
            long r33 = r59.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r35 = r4.zzx()     // Catch:{ all -> 0x0f50 }
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 1
            com.google.android.gms.measurement.internal.zzw r4 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0f50 }
            long r11 = r4.zze     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r4 = r4.zzb()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r8 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r8 = r8.zzx()     // Catch:{ all -> 0x0f50 }
            int r4 = r4.zza((java.lang.String) r8)     // Catch:{ all -> 0x0f50 }
            r8 = r3
            long r3 = (long) r4     // Catch:{ all -> 0x0f50 }
            int r15 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r15 <= 0) goto L_0x04eb
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            goto L_0x04ed
        L_0x04eb:
            r21 = 1
        L_0x04ed:
            java.lang.String r3 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r3 = com.google.android.gms.measurement.internal.zzjx.zza((java.lang.String) r3)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x05b8
            if (r9 == 0) goto L_0x05b8
            com.google.android.gms.measurement.internal.zzx r32 = r59.zze()     // Catch:{ all -> 0x0f50 }
            long r33 = r59.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r3 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r35 = r3.zzx()     // Catch:{ all -> 0x0f50 }
            r36 = 0
            r37 = 0
            r38 = 1
            r39 = 0
            r40 = 0
            com.google.android.gms.measurement.internal.zzw r3 = r32.zza(r33, r35, r36, r37, r38, r39, r40)     // Catch:{ all -> 0x0f50 }
            long r3 = r3.zzc     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzb()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.zzak.zzq     // Catch:{ all -> 0x0f50 }
            int r6 = r6.zzb(r11, r12)     // Catch:{ all -> 0x0f50 }
            long r11 = (long) r6     // Catch:{ all -> 0x0f50 }
            int r6 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r6 <= 0) goto L_0x05b8
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzi()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            r3.zza(r4, r6)     // Catch:{ all -> 0x0f50 }
            r3 = 0
            r4 = 0
            r6 = 0
            r11 = -1
        L_0x054b:
            int r12 = r7.zzb()     // Catch:{ all -> 0x0f50 }
            if (r3 >= r12) goto L_0x0577
            com.google.android.gms.internal.measurement.zzbr$zze r12 = r7.zza((int) r3)     // Catch:{ all -> 0x0f50 }
            java.lang.String r15 = r12.zza()     // Catch:{ all -> 0x0f50 }
            boolean r15 = r14.equals(r15)     // Catch:{ all -> 0x0f50 }
            if (r15 == 0) goto L_0x0569
            com.google.android.gms.internal.measurement.zzfd$zza r6 = r12.zzbk()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r6 = (com.google.android.gms.internal.measurement.zzfd.zza) r6     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r6 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r6     // Catch:{ all -> 0x0f50 }
            r11 = r3
            goto L_0x0574
        L_0x0569:
            java.lang.String r12 = r12.zza()     // Catch:{ all -> 0x0f50 }
            boolean r12 = r13.equals(r12)     // Catch:{ all -> 0x0f50 }
            if (r12 == 0) goto L_0x0574
            r4 = 1
        L_0x0574:
            int r3 = r3 + 1
            goto L_0x054b
        L_0x0577:
            if (r4 == 0) goto L_0x057f
            if (r6 == 0) goto L_0x057f
            r7.zzb((int) r11)     // Catch:{ all -> 0x0f50 }
            goto L_0x05b8
        L_0x057f:
            if (r6 == 0) goto L_0x059f
            java.lang.Object r3 = r6.clone()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r3 = (com.google.android.gms.internal.measurement.zzfd.zza) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r3 = (com.google.android.gms.internal.measurement.zzbr.zze.zza) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze$zza r3 = r3.zza((java.lang.String) r13)     // Catch:{ all -> 0x0f50 }
            r12 = 10
            com.google.android.gms.internal.measurement.zzbr$zze$zza r3 = r3.zza((long) r12)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r3 = r3.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r3 = (com.google.android.gms.internal.measurement.zzbr.zze) r3     // Catch:{ all -> 0x0f50 }
            r7.zza((int) r11, (com.google.android.gms.internal.measurement.zzbr.zze) r3)     // Catch:{ all -> 0x0f50 }
            goto L_0x05b8
        L_0x059f:
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            r3.zza(r4, r6)     // Catch:{ all -> 0x0f50 }
        L_0x05b8:
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.zzk(r4)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x0691
            if (r9 == 0) goto L_0x0691
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0f50 }
            java.util.List r4 = r7.zza()     // Catch:{ all -> 0x0f50 }
            r3.<init>(r4)     // Catch:{ all -> 0x0f50 }
            r4 = 0
            r6 = -1
            r9 = -1
        L_0x05d8:
            int r11 = r3.size()     // Catch:{ all -> 0x0f50 }
            if (r4 >= r11) goto L_0x0608
            java.lang.String r11 = "value"
            java.lang.Object r12 = r3.get(r4)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r12 = (com.google.android.gms.internal.measurement.zzbr.zze) r12     // Catch:{ all -> 0x0f50 }
            java.lang.String r12 = r12.zza()     // Catch:{ all -> 0x0f50 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0f50 }
            if (r11 == 0) goto L_0x05f2
            r6 = r4
            goto L_0x0605
        L_0x05f2:
            java.lang.String r11 = "currency"
            java.lang.Object r12 = r3.get(r4)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r12 = (com.google.android.gms.internal.measurement.zzbr.zze) r12     // Catch:{ all -> 0x0f50 }
            java.lang.String r12 = r12.zza()     // Catch:{ all -> 0x0f50 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x0f50 }
            if (r11 == 0) goto L_0x0605
            r9 = r4
        L_0x0605:
            int r4 = r4 + 1
            goto L_0x05d8
        L_0x0608:
            r4 = -1
            if (r6 == r4) goto L_0x0692
            java.lang.Object r4 = r3.get(r6)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r4 = (com.google.android.gms.internal.measurement.zzbr.zze) r4     // Catch:{ all -> 0x0f50 }
            boolean r4 = r4.zzd()     // Catch:{ all -> 0x0f50 }
            if (r4 != 0) goto L_0x0640
            java.lang.Object r4 = r3.get(r6)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r4 = (com.google.android.gms.internal.measurement.zzbr.zze) r4     // Catch:{ all -> 0x0f50 }
            boolean r4 = r4.zzf()     // Catch:{ all -> 0x0f50 }
            if (r4 != 0) goto L_0x0640
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzk()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = "Value must be specified with a numeric type."
            r3.zza(r4)     // Catch:{ all -> 0x0f50 }
            r7.zzb((int) r6)     // Catch:{ all -> 0x0f50 }
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r14)     // Catch:{ all -> 0x0f50 }
            r3 = 18
            java.lang.String r4 = "value"
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (int) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0f50 }
            goto L_0x0691
        L_0x0640:
            r4 = -1
            if (r9 != r4) goto L_0x0646
            r3 = 1
            r11 = 3
            goto L_0x0672
        L_0x0646:
            java.lang.Object r3 = r3.get(r9)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r3 = (com.google.android.gms.internal.measurement.zzbr.zze) r3     // Catch:{ all -> 0x0f50 }
            java.lang.String r3 = r3.zzc()     // Catch:{ all -> 0x0f50 }
            int r9 = r3.length()     // Catch:{ all -> 0x0f50 }
            r11 = 3
            if (r9 == r11) goto L_0x0659
        L_0x0657:
            r3 = 1
            goto L_0x0672
        L_0x0659:
            r9 = 0
        L_0x065a:
            int r12 = r3.length()     // Catch:{ all -> 0x0f50 }
            if (r9 >= r12) goto L_0x0671
            int r12 = r3.codePointAt(r9)     // Catch:{ all -> 0x0f50 }
            boolean r13 = java.lang.Character.isLetter(r12)     // Catch:{ all -> 0x0f50 }
            if (r13 != 0) goto L_0x066b
            goto L_0x0657
        L_0x066b:
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x0f50 }
            int r9 = r9 + r12
            goto L_0x065a
        L_0x0671:
            r3 = 0
        L_0x0672:
            if (r3 == 0) goto L_0x0693
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzk()     // Catch:{ all -> 0x0f50 }
            java.lang.String r9 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r3.zza(r9)     // Catch:{ all -> 0x0f50 }
            r7.zzb((int) r6)     // Catch:{ all -> 0x0f50 }
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r14)     // Catch:{ all -> 0x0f50 }
            r3 = 19
            java.lang.String r6 = "currency"
            zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (int) r3, (java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            goto L_0x0693
        L_0x0691:
            r4 = -1
        L_0x0692:
            r11 = 3
        L_0x0693:
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzak.zzbe     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.zze(r6, r9)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x07a8
            java.lang.String r3 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r3 = r10.equals(r3)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x06fc
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r3 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r3 = (com.google.android.gms.internal.measurement.zzbr.zzc) r3     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = "_fr"
            com.google.android.gms.internal.measurement.zzbr$zze r3 = com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r3, (java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            if (r3 != 0) goto L_0x07a8
            if (r17 == 0) goto L_0x06f4
            long r12 = r17.zze()     // Catch:{ all -> 0x0f50 }
            long r14 = r7.zze()     // Catch:{ all -> 0x0f50 }
            long r12 = r12 - r14
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0f50 }
            r14 = 1000(0x3e8, double:4.94E-321)
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 > 0) goto L_0x06f4
            java.lang.Object r3 = r17.clone()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r3 = (com.google.android.gms.internal.measurement.zzfd.zza) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r3 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r3     // Catch:{ all -> 0x0f50 }
            boolean r6 = r1.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r3)     // Catch:{ all -> 0x0f50 }
            if (r6 == 0) goto L_0x06f4
            r8.zza((int) r5, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r3)     // Catch:{ all -> 0x0f50 }
            r9 = r29
            r6 = r31
        L_0x06ee:
            r17 = 0
        L_0x06f0:
            r30 = 0
            goto L_0x07ac
        L_0x06f4:
            r30 = r7
            r9 = r22
        L_0x06f8:
            r6 = r31
            goto L_0x07ac
        L_0x06fc:
            java.lang.String r3 = "_vs"
            java.lang.String r6 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.equals(r6)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x074e
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r3 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r3 = (com.google.android.gms.internal.measurement.zzbr.zzc) r3     // Catch:{ all -> 0x0f50 }
            r6 = r31
            com.google.android.gms.internal.measurement.zzbr$zze r3 = com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r3, (java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            if (r3 != 0) goto L_0x074b
            if (r30 == 0) goto L_0x0744
            long r12 = r30.zze()     // Catch:{ all -> 0x0f50 }
            long r14 = r7.zze()     // Catch:{ all -> 0x0f50 }
            long r12 = r12 - r14
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0f50 }
            r14 = 1000(0x3e8, double:4.94E-321)
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 > 0) goto L_0x0744
            java.lang.Object r3 = r30.clone()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r3 = (com.google.android.gms.internal.measurement.zzfd.zza) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r3 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r3     // Catch:{ all -> 0x0f50 }
            boolean r9 = r1.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r3, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0744
            r9 = r29
            r8.zza((int) r9, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r3)     // Catch:{ all -> 0x0f50 }
            goto L_0x06ee
        L_0x0744:
            r9 = r29
            r17 = r7
            r5 = r22
            goto L_0x07ac
        L_0x074b:
            r9 = r29
            goto L_0x07ac
        L_0x074e:
            r9 = r29
            r6 = r31
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzak.zzcj     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.zze(r12, r13)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x07ac
            java.lang.String r3 = "_ab"
            java.lang.String r12 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.equals(r12)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x07ac
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r3 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r3 = (com.google.android.gms.internal.measurement.zzbr.zzc) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r3 = com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r3, (java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            if (r3 != 0) goto L_0x07ac
            if (r30 == 0) goto L_0x07ac
            long r12 = r30.zze()     // Catch:{ all -> 0x0f50 }
            long r14 = r7.zze()     // Catch:{ all -> 0x0f50 }
            long r12 = r12 - r14
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0f50 }
            r14 = 4000(0xfa0, double:1.9763E-320)
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 > 0) goto L_0x07ac
            java.lang.Object r3 = r30.clone()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd$zza r3 = (com.google.android.gms.internal.measurement.zzfd.zza) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r3 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r3     // Catch:{ all -> 0x0f50 }
            r1.zzb((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r3, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x0f50 }
            r8.zza((int) r9, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r3)     // Catch:{ all -> 0x0f50 }
            goto L_0x06f0
        L_0x07a8:
            r9 = r29
            goto L_0x06f8
        L_0x07ac:
            if (r28 != 0) goto L_0x080c
            java.lang.String r3 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r3 = r10.equals(r3)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x080c
            int r3 = r7.zzb()     // Catch:{ all -> 0x0f50 }
            if (r3 != 0) goto L_0x07d8
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzi()     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r10 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r10)     // Catch:{ all -> 0x0f50 }
            r3.zza(r6, r10)     // Catch:{ all -> 0x0f50 }
            goto L_0x080c
        L_0x07d8:
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r3 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r3 = (com.google.android.gms.internal.measurement.zzbr.zzc) r3     // Catch:{ all -> 0x0f50 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzjt.zzb(r3, r6)     // Catch:{ all -> 0x0f50 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0f50 }
            if (r3 != 0) goto L_0x0805
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzi()     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r10 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r10 = r10.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r10)     // Catch:{ all -> 0x0f50 }
            r3.zza(r6, r10)     // Catch:{ all -> 0x0f50 }
            goto L_0x080c
        L_0x0805:
            long r12 = r3.longValue()     // Catch:{ all -> 0x0f50 }
            long r12 = r23 + r12
            goto L_0x080e
        L_0x080c:
            r12 = r23
        L_0x080e:
            java.util.List<com.google.android.gms.internal.measurement.zzbr$zzc> r3 = r2.zzc     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r6 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r6 = (com.google.android.gms.internal.measurement.zzfd) r6     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r6 = (com.google.android.gms.internal.measurement.zzbr.zzc) r6     // Catch:{ all -> 0x0f50 }
            r10 = r27
            r3.set(r10, r6)     // Catch:{ all -> 0x0f50 }
            int r15 = r22 + 1
            r8.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x0f50 }
            r3 = r9
            r13 = r12
            r9 = r21
            r6 = r30
        L_0x0828:
            int r7 = r10 + 1
            r11 = r3
            r3 = r8
            r4 = r28
            r10 = 2
            r12 = 1
            r8 = r7
            goto L_0x02b1
        L_0x0833:
            r8 = r3
            r28 = r4
            r21 = r9
            r6 = r12
            r22 = r15
            if (r28 == 0) goto L_0x0892
            r4 = r22
            r13 = r23
            r3 = 0
        L_0x0842:
            if (r3 >= r4) goto L_0x0894
            com.google.android.gms.internal.measurement.zzbr$zzc r5 = r8.zzb((int) r3)     // Catch:{ all -> 0x0f50 }
            java.lang.String r7 = r5.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0f50 }
            if (r7 == 0) goto L_0x0865
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            java.lang.String r7 = "_fr"
            com.google.android.gms.internal.measurement.zzbr$zze r7 = com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r5, (java.lang.String) r7)     // Catch:{ all -> 0x0f50 }
            if (r7 == 0) goto L_0x0865
            r8.zzc((int) r3)     // Catch:{ all -> 0x0f50 }
            int r4 = r4 + -1
            int r3 = r3 + -1
            goto L_0x088f
        L_0x0865:
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r5 = com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r5, (java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            if (r5 == 0) goto L_0x088f
            boolean r7 = r5.zzd()     // Catch:{ all -> 0x0f50 }
            if (r7 == 0) goto L_0x087d
            long r11 = r5.zze()     // Catch:{ all -> 0x0f50 }
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f50 }
            goto L_0x087e
        L_0x087d:
            r5 = 0
        L_0x087e:
            if (r5 == 0) goto L_0x088f
            long r11 = r5.longValue()     // Catch:{ all -> 0x0f50 }
            r17 = 0
            int r7 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r7 <= 0) goto L_0x088f
            long r11 = r5.longValue()     // Catch:{ all -> 0x0f50 }
            long r13 = r13 + r11
        L_0x088f:
            r5 = 1
            int r3 = r3 + r5
            goto L_0x0842
        L_0x0892:
            r13 = r23
        L_0x0894:
            r3 = 0
            r1.zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r8, (long) r13, (boolean) r3)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzbw     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x08e1
            java.util.List r3 = r8.zza()     // Catch:{ all -> 0x0f50 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0f50 }
        L_0x08b2:
            boolean r4 = r3.hasNext()     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x08cc
            java.lang.Object r4 = r3.next()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r4 = (com.google.android.gms.internal.measurement.zzbr.zzc) r4     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "_s"
            java.lang.String r4 = r4.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r4 = r5.equals(r4)     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x08b2
            r3 = 1
            goto L_0x08cd
        L_0x08cc:
            r3 = 0
        L_0x08cd:
            if (r3 == 0) goto L_0x08dc
            com.google.android.gms.measurement.internal.zzx r3 = r59.zze()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "_se"
            r3.zzb((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0f50 }
        L_0x08dc:
            r3 = 1
            r1.zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r8, (long) r13, (boolean) r3)     // Catch:{ all -> 0x0f50 }
            goto L_0x0900
        L_0x08e1:
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzbx     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x0900
            com.google.android.gms.measurement.internal.zzx r3 = r59.zze()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "_se"
            r3.zzb((java.lang.String) r4, (java.lang.String) r5)     // Catch:{ all -> 0x0f50 }
        L_0x0900:
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzbg     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x09a5
            com.google.android.gms.measurement.internal.zzjt r3 = r59.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r4 = r3.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r4.zza(r5)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfh r4 = r3.zzj()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            boolean r4 = r4.zze(r5)     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x09a5
            com.google.android.gms.measurement.internal.zzx r4 = r3.zzi()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzf r4 = r4.zzb(r5)     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x09a5
            boolean r4 = r4.zzad()     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x09a5
            com.google.android.gms.measurement.internal.zzac r4 = r3.zzl()     // Catch:{ all -> 0x0f50 }
            boolean r4 = r4.zzj()     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x09a5
            com.google.android.gms.measurement.internal.zzej r4 = r3.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzw()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r4.zza(r5)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r4 = com.google.android.gms.internal.measurement.zzbr.zzk.zzj()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "_npa"
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzac r3 = r3.zzl()     // Catch:{ all -> 0x0f50 }
            long r5 = r3.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r3 = r4.zza((long) r5)     // Catch:{ all -> 0x0f50 }
            r4 = 1
            com.google.android.gms.internal.measurement.zzbr$zzk$zza r3 = r3.zzb((long) r4)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r3 = r3.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzk r3 = (com.google.android.gms.internal.measurement.zzbr.zzk) r3     // Catch:{ all -> 0x0f50 }
            r4 = 0
        L_0x0981:
            int r5 = r8.zze()     // Catch:{ all -> 0x0f50 }
            if (r4 >= r5) goto L_0x099f
            java.lang.String r5 = "_npa"
            com.google.android.gms.internal.measurement.zzbr$zzk r6 = r8.zzd((int) r4)     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = r6.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0f50 }
            if (r5 == 0) goto L_0x099c
            r8.zza((int) r4, (com.google.android.gms.internal.measurement.zzbr.zzk) r3)     // Catch:{ all -> 0x0f50 }
            r4 = 1
            goto L_0x09a0
        L_0x099c:
            int r4 = r4 + 1
            goto L_0x0981
        L_0x099f:
            r4 = 0
        L_0x09a0:
            if (r4 != 0) goto L_0x09a5
            r8.zza((com.google.android.gms.internal.measurement.zzbr.zzk) r3)     // Catch:{ all -> 0x0f50 }
        L_0x09a5:
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzcf     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.zze(r4, r5)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x09ba
            zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r8)     // Catch:{ all -> 0x0f50 }
        L_0x09ba:
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r3 = r8.zzm()     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            java.util.List r5 = r8.zzd()     // Catch:{ all -> 0x0f50 }
            java.util.List r6 = r8.zza()     // Catch:{ all -> 0x0f50 }
            long r9 = r8.zzf()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzp r7 = r59.zzf()     // Catch:{ all -> 0x0f50 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0f50 }
            java.util.List r4 = r7.zza((java.lang.String) r4, (java.util.List<com.google.android.gms.internal.measurement.zzbr.zzc>) r6, (java.util.List<com.google.android.gms.internal.measurement.zzbr.zzk>) r5, (java.lang.Long) r9)     // Catch:{ all -> 0x0f50 }
            r3.zzc((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzbr.zza>) r4)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r4.zzx()     // Catch:{ all -> 0x0f50 }
            boolean r3 = r3.zze(r4)     // Catch:{ all -> 0x0f50 }
            if (r3 == 0) goto L_0x0d91
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0d8c }
            r3.<init>()     // Catch:{ all -> 0x0d8c }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0d8c }
            r4.<init>()     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzjx r5 = r5.zzi()     // Catch:{ all -> 0x0d8c }
            java.security.SecureRandom r5 = r5.zzh()     // Catch:{ all -> 0x0d8c }
            r6 = 0
        L_0x0a07:
            int r7 = r8.zzb()     // Catch:{ all -> 0x0d8c }
            if (r6 >= r7) goto L_0x0d57
            com.google.android.gms.internal.measurement.zzbr$zzc r7 = r8.zzb((int) r6)     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzfd$zza r7 = r7.zzbk()     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzfd$zza r7 = (com.google.android.gms.internal.measurement.zzfd.zza) r7     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzbr$zzc$zza r7 = (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7     // Catch:{ all -> 0x0d8c }
            java.lang.String r9 = r7.zzc()     // Catch:{ all -> 0x0d8c }
            java.lang.String r10 = "_ep"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0d8c }
            java.lang.String r10 = "_sr"
            if (r9 == 0) goto L_0x0a9c
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r9 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r9 = (com.google.android.gms.internal.measurement.zzbr.zzc) r9     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = "_en"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzjt.zzb(r9, r11)     // Catch:{ all -> 0x0f50 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x0f50 }
            java.lang.Object r11 = r3.get(r9)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzae r11 = (com.google.android.gms.measurement.internal.zzae) r11     // Catch:{ all -> 0x0f50 }
            if (r11 != 0) goto L_0x0a53
            com.google.android.gms.measurement.internal.zzx r11 = r59.zze()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r12 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r12 = r12.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzae r11 = r11.zza((java.lang.String) r12, (java.lang.String) r9)     // Catch:{ all -> 0x0f50 }
            r3.put(r9, r11)     // Catch:{ all -> 0x0f50 }
        L_0x0a53:
            java.lang.Long r9 = r11.zzi     // Catch:{ all -> 0x0f50 }
            if (r9 != 0) goto L_0x0a90
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0f50 }
            long r12 = r9.longValue()     // Catch:{ all -> 0x0f50 }
            r14 = 1
            int r9 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r9 <= 0) goto L_0x0a6b
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            java.lang.Long r9 = r11.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r9)     // Catch:{ all -> 0x0f50 }
        L_0x0a6b:
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0a85
            java.lang.Boolean r9 = r11.zzk     // Catch:{ all -> 0x0f50 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0a85
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            java.lang.String r9 = "_efs"
            r10 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r9, (java.lang.Object) r12)     // Catch:{ all -> 0x0f50 }
        L_0x0a85:
            com.google.android.gms.internal.measurement.zzgn r9 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r9 = (com.google.android.gms.internal.measurement.zzbr.zzc) r9     // Catch:{ all -> 0x0f50 }
            r4.add(r9)     // Catch:{ all -> 0x0f50 }
        L_0x0a90:
            r8.zza((int) r6, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x0f50 }
        L_0x0a93:
            r18 = r2
            r60 = r5
            r1 = r6
            r5 = 1
            goto L_0x0d4c
        L_0x0a9c:
            com.google.android.gms.measurement.internal.zzfh r9 = r59.zzc()     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r2.zza     // Catch:{ all -> 0x0d8c }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0d8c }
            long r11 = r9.zzf(r11)     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzfn r9 = r1.zzj     // Catch:{ all -> 0x0d8c }
            r9.zzi()     // Catch:{ all -> 0x0d8c }
            long r13 = r7.zze()     // Catch:{ all -> 0x0d8c }
            long r13 = com.google.android.gms.measurement.internal.zzjx.zza((long) r13, (long) r11)     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzgn r9 = r7.zzu()     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzbr$zzc r9 = (com.google.android.gms.internal.measurement.zzbr.zzc) r9     // Catch:{ all -> 0x0d8c }
            java.lang.String r15 = "_dbg"
            r23 = r11
            r17 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0d8c }
            boolean r12 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x0d8c }
            if (r12 != 0) goto L_0x0b29
            if (r11 != 0) goto L_0x0ad2
            goto L_0x0b29
        L_0x0ad2:
            java.util.List r9 = r9.zza()     // Catch:{ all -> 0x0f50 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0f50 }
        L_0x0ada:
            boolean r12 = r9.hasNext()     // Catch:{ all -> 0x0f50 }
            if (r12 == 0) goto L_0x0b29
            java.lang.Object r12 = r9.next()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zze r12 = (com.google.android.gms.internal.measurement.zzbr.zze) r12     // Catch:{ all -> 0x0f50 }
            r60 = r9
            java.lang.String r9 = r12.zza()     // Catch:{ all -> 0x0f50 }
            boolean r9 = r15.equals(r9)     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0b26
            boolean r9 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0b04
            long r17 = r12.zze()     // Catch:{ all -> 0x0f50 }
            java.lang.Long r9 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x0f50 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f50 }
            if (r9 != 0) goto L_0x0b24
        L_0x0b04:
            boolean r9 = r11 instanceof java.lang.String     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0b12
            java.lang.String r9 = r12.zzc()     // Catch:{ all -> 0x0f50 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f50 }
            if (r9 != 0) goto L_0x0b24
        L_0x0b12:
            boolean r9 = r11 instanceof java.lang.Double     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0b29
            double r17 = r12.zzg()     // Catch:{ all -> 0x0f50 }
            java.lang.Double r9 = java.lang.Double.valueOf(r17)     // Catch:{ all -> 0x0f50 }
            boolean r9 = r11.equals(r9)     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0b29
        L_0x0b24:
            r9 = 1
            goto L_0x0b2a
        L_0x0b26:
            r9 = r60
            goto L_0x0ada
        L_0x0b29:
            r9 = 0
        L_0x0b2a:
            if (r9 != 0) goto L_0x0b3f
            com.google.android.gms.measurement.internal.zzfh r9 = r59.zzc()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.String r12 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            int r12 = r9.zzd(r11, r12)     // Catch:{ all -> 0x0f50 }
            goto L_0x0b40
        L_0x0b3f:
            r12 = 1
        L_0x0b40:
            if (r12 > 0) goto L_0x0b69
            com.google.android.gms.measurement.internal.zzfn r9 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r9 = r9.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzi()     // Catch:{ all -> 0x0f50 }
            java.lang.String r10 = "Sample rate must be positive. event, rate"
            java.lang.String r11 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r12)     // Catch:{ all -> 0x0f50 }
            r9.zza(r10, r11, r12)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r9 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r9 = (com.google.android.gms.internal.measurement.zzfd) r9     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r9 = (com.google.android.gms.internal.measurement.zzbr.zzc) r9     // Catch:{ all -> 0x0f50 }
            r4.add(r9)     // Catch:{ all -> 0x0f50 }
            r8.zza((int) r6, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x0f50 }
            goto L_0x0a93
        L_0x0b69:
            java.lang.String r9 = r7.zzc()     // Catch:{ all -> 0x0d8c }
            java.lang.Object r9 = r3.get(r9)     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzae r9 = (com.google.android.gms.measurement.internal.zzae) r9     // Catch:{ all -> 0x0d8c }
            if (r9 != 0) goto L_0x0c02
            com.google.android.gms.measurement.internal.zzx r9 = r59.zze()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.String r15 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza((java.lang.String) r11, (java.lang.String) r15)     // Catch:{ all -> 0x0f50 }
            if (r9 != 0) goto L_0x0c02
            com.google.android.gms.measurement.internal.zzfn r9 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r9 = r9.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzi()     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.zzbr$zzg r15 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r15 = r15.zzx()     // Catch:{ all -> 0x0f50 }
            r17 = r13
            java.lang.String r13 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            r9.zza(r11, r15, r13)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfn r9 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r9 = r9.zzb()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r11 = r11.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.zzak.zzbv     // Catch:{ all -> 0x0f50 }
            boolean r9 = r9.zze(r11, r13)     // Catch:{ all -> 0x0f50 }
            if (r9 == 0) goto L_0x0bde
            com.google.android.gms.measurement.internal.zzae r9 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r28 = r11.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.String r29 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            r30 = 1
            r32 = 1
            r34 = 1
            long r36 = r7.zze()     // Catch:{ all -> 0x0f50 }
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r27 = r9
            r27.<init>(r28, r29, r30, r32, r34, r36, r38, r40, r41, r42, r43)     // Catch:{ all -> 0x0f50 }
            goto L_0x0c04
        L_0x0bde:
            com.google.android.gms.measurement.internal.zzae r9 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r11 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r45 = r11.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.String r46 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            r47 = 1
            r49 = 1
            long r51 = r7.zze()     // Catch:{ all -> 0x0f50 }
            r53 = 0
            r55 = 0
            r56 = 0
            r57 = 0
            r58 = 0
            r44 = r9
            r44.<init>(r45, r46, r47, r49, r51, r53, r55, r56, r57, r58)     // Catch:{ all -> 0x0f50 }
            goto L_0x0c04
        L_0x0c02:
            r17 = r13
        L_0x0c04:
            r59.zzh()     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzgn r11 = r7.zzu()     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzfd r11 = (com.google.android.gms.internal.measurement.zzfd) r11     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzbr$zzc r11 = (com.google.android.gms.internal.measurement.zzbr.zzc) r11     // Catch:{ all -> 0x0d8c }
            java.lang.String r13 = "_eid"
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzjt.zzb(r11, r13)     // Catch:{ all -> 0x0d8c }
            java.lang.Long r11 = (java.lang.Long) r11     // Catch:{ all -> 0x0d8c }
            if (r11 == 0) goto L_0x0c1b
            r13 = 1
            goto L_0x0c1c
        L_0x0c1b:
            r13 = 0
        L_0x0c1c:
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)     // Catch:{ all -> 0x0d8c }
            r14 = 1
            if (r12 != r14) goto L_0x0c51
            com.google.android.gms.internal.measurement.zzgn r10 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r10 = (com.google.android.gms.internal.measurement.zzfd) r10     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r10 = (com.google.android.gms.internal.measurement.zzbr.zzc) r10     // Catch:{ all -> 0x0f50 }
            r4.add(r10)     // Catch:{ all -> 0x0f50 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0f50 }
            if (r10 == 0) goto L_0x0c4c
            java.lang.Long r10 = r9.zzi     // Catch:{ all -> 0x0f50 }
            if (r10 != 0) goto L_0x0c40
            java.lang.Long r10 = r9.zzj     // Catch:{ all -> 0x0f50 }
            if (r10 != 0) goto L_0x0c40
            java.lang.Boolean r10 = r9.zzk     // Catch:{ all -> 0x0f50 }
            if (r10 == 0) goto L_0x0c4c
        L_0x0c40:
            r10 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r10, r10, r10)     // Catch:{ all -> 0x0f50 }
            java.lang.String r10 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            r3.put(r10, r9)     // Catch:{ all -> 0x0f50 }
        L_0x0c4c:
            r8.zza((int) r6, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x0f50 }
            goto L_0x0a93
        L_0x0c51:
            int r14 = r5.nextInt(r12)     // Catch:{ all -> 0x0d8c }
            if (r14 != 0) goto L_0x0c96
            r59.zzh()     // Catch:{ all -> 0x0f50 }
            long r11 = (long) r12     // Catch:{ all -> 0x0f50 }
            java.lang.Long r14 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r14)     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r10 = r7.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r10 = (com.google.android.gms.internal.measurement.zzfd) r10     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzc r10 = (com.google.android.gms.internal.measurement.zzbr.zzc) r10     // Catch:{ all -> 0x0f50 }
            r4.add(r10)     // Catch:{ all -> 0x0f50 }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0f50 }
            if (r10 == 0) goto L_0x0c7c
            java.lang.Long r10 = java.lang.Long.valueOf(r11)     // Catch:{ all -> 0x0f50 }
            r11 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r11, r10, r11)     // Catch:{ all -> 0x0f50 }
        L_0x0c7c:
            java.lang.String r10 = r7.zzc()     // Catch:{ all -> 0x0f50 }
            long r11 = r7.zze()     // Catch:{ all -> 0x0f50 }
            r14 = r17
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r11, r14)     // Catch:{ all -> 0x0f50 }
            r3.put(r10, r9)     // Catch:{ all -> 0x0f50 }
            r18 = r2
            r60 = r5
            r1 = r6
            r5 = 1
            goto L_0x0d49
        L_0x0c96:
            r60 = r5
            r14 = r17
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzs r5 = r5.zzb()     // Catch:{ all -> 0x0d8c }
            r17 = r6
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r2.zza     // Catch:{ all -> 0x0d8c }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0d8c }
            boolean r5 = r5.zzm(r6)     // Catch:{ all -> 0x0d8c }
            if (r5 == 0) goto L_0x0cd4
            java.lang.Long r5 = r9.zzh     // Catch:{ all -> 0x0d8c }
            if (r5 == 0) goto L_0x0cbb
            java.lang.Long r5 = r9.zzh     // Catch:{ all -> 0x0f50 }
            long r5 = r5.longValue()     // Catch:{ all -> 0x0f50 }
            r18 = r2
            goto L_0x0ccc
        L_0x0cbb:
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj     // Catch:{ all -> 0x0d8c }
            r5.zzi()     // Catch:{ all -> 0x0d8c }
            long r5 = r7.zzf()     // Catch:{ all -> 0x0d8c }
            r18 = r2
            r1 = r23
            long r5 = com.google.android.gms.measurement.internal.zzjx.zza((long) r5, (long) r1)     // Catch:{ all -> 0x0d8c }
        L_0x0ccc:
            int r1 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r1 == 0) goto L_0x0cd2
        L_0x0cd0:
            r1 = 1
            goto L_0x0ce9
        L_0x0cd2:
            r1 = 0
            goto L_0x0ce9
        L_0x0cd4:
            r18 = r2
            long r1 = r9.zzg     // Catch:{ all -> 0x0d8c }
            long r5 = r7.zze()     // Catch:{ all -> 0x0d8c }
            long r5 = r5 - r1
            long r1 = java.lang.Math.abs(r5)     // Catch:{ all -> 0x0d8c }
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r22 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r22 < 0) goto L_0x0cd2
            goto L_0x0cd0
        L_0x0ce9:
            if (r1 == 0) goto L_0x0d33
            r59.zzh()     // Catch:{ all -> 0x0d8c }
            java.lang.String r1 = "_efs"
            r5 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0d8c }
            r59.zzh()     // Catch:{ all -> 0x0d8c }
            long r1 = (long) r12     // Catch:{ all -> 0x0d8c }
            java.lang.Long r11 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7, (java.lang.String) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzgn r10 = r7.zzu()     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzfd r10 = (com.google.android.gms.internal.measurement.zzfd) r10     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.internal.measurement.zzbr$zzc r10 = (com.google.android.gms.internal.measurement.zzbr.zzc) r10     // Catch:{ all -> 0x0d8c }
            r4.add(r10)     // Catch:{ all -> 0x0d8c }
            boolean r10 = r13.booleanValue()     // Catch:{ all -> 0x0d8c }
            if (r10 == 0) goto L_0x0d23
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0d8c }
            r2 = 1
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x0d8c }
            r2 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r2, r1, r10)     // Catch:{ all -> 0x0d8c }
        L_0x0d23:
            java.lang.String r1 = r7.zzc()     // Catch:{ all -> 0x0d8c }
            long r10 = r7.zze()     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzae r2 = r9.zza(r10, r14)     // Catch:{ all -> 0x0d8c }
            r3.put(r1, r2)     // Catch:{ all -> 0x0d8c }
            goto L_0x0d47
        L_0x0d33:
            r5 = 1
            boolean r1 = r13.booleanValue()     // Catch:{ all -> 0x0d8c }
            if (r1 == 0) goto L_0x0d47
            java.lang.String r1 = r7.zzc()     // Catch:{ all -> 0x0d8c }
            r2 = 0
            com.google.android.gms.measurement.internal.zzae r9 = r9.zza(r11, r2, r2)     // Catch:{ all -> 0x0d8c }
            r3.put(r1, r9)     // Catch:{ all -> 0x0d8c }
        L_0x0d47:
            r1 = r17
        L_0x0d49:
            r8.zza((int) r1, (com.google.android.gms.internal.measurement.zzbr.zzc.zza) r7)     // Catch:{ all -> 0x0d8c }
        L_0x0d4c:
            int r1 = r1 + 1
            r5 = r60
            r6 = r1
            r2 = r18
            r1 = r59
            goto L_0x0a07
        L_0x0d57:
            r18 = r2
            int r1 = r4.size()     // Catch:{ all -> 0x0d8c }
            int r2 = r8.zzb()     // Catch:{ all -> 0x0d8c }
            if (r1 >= r2) goto L_0x0d6a
            com.google.android.gms.internal.measurement.zzbr$zzg$zza r1 = r8.zzc()     // Catch:{ all -> 0x0d8c }
            r1.zza((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.zzbr.zzc>) r4)     // Catch:{ all -> 0x0d8c }
        L_0x0d6a:
            java.util.Set r1 = r3.entrySet()     // Catch:{ all -> 0x0d8c }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0d8c }
        L_0x0d72:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0d8c }
            if (r2 == 0) goto L_0x0d93
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0d8c }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzx r3 = r59.zze()     // Catch:{ all -> 0x0d8c }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0d8c }
            com.google.android.gms.measurement.internal.zzae r2 = (com.google.android.gms.measurement.internal.zzae) r2     // Catch:{ all -> 0x0d8c }
            r3.zza((com.google.android.gms.measurement.internal.zzae) r2)     // Catch:{ all -> 0x0d8c }
            goto L_0x0d72
        L_0x0d8c:
            r0 = move-exception
            r1 = r59
            goto L_0x0f51
        L_0x0d91:
            r18 = r2
        L_0x0d93:
            r1 = r59
            com.google.android.gms.measurement.internal.zzfn r2 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzs r2 = r2.zzb()     // Catch:{ all -> 0x0f50 }
            java.lang.String r3 = r8.zzj()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzak.zzcf     // Catch:{ all -> 0x0f50 }
            boolean r2 = r2.zze(r3, r4)     // Catch:{ all -> 0x0f50 }
            if (r2 != 0) goto L_0x0daa
            zza((com.google.android.gms.internal.measurement.zzbr.zzg.zza) r8)     // Catch:{ all -> 0x0f50 }
        L_0x0daa:
            r2 = r18
            com.google.android.gms.internal.measurement.zzbr$zzg r3 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r3 = r3.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzx r4 = r59.zze()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzf r4 = r4.zzb(r3)     // Catch:{ all -> 0x0f50 }
            if (r4 != 0) goto L_0x0dd6
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x0f50 }
            goto L_0x0e31
        L_0x0dd6:
            int r5 = r8.zzb()     // Catch:{ all -> 0x0f50 }
            if (r5 <= 0) goto L_0x0e31
            long r5 = r4.zzi()     // Catch:{ all -> 0x0f50 }
            r9 = 0
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0dea
            r8.zze((long) r5)     // Catch:{ all -> 0x0f50 }
            goto L_0x0ded
        L_0x0dea:
            r8.zzi()     // Catch:{ all -> 0x0f50 }
        L_0x0ded:
            long r9 = r4.zzh()     // Catch:{ all -> 0x0f50 }
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x0df8
            goto L_0x0df9
        L_0x0df8:
            r5 = r9
        L_0x0df9:
            int r7 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0e01
            r8.zzd((long) r5)     // Catch:{ all -> 0x0f50 }
            goto L_0x0e04
        L_0x0e01:
            r8.zzh()     // Catch:{ all -> 0x0f50 }
        L_0x0e04:
            r4.zzt()     // Catch:{ all -> 0x0f50 }
            long r5 = r4.zzq()     // Catch:{ all -> 0x0f50 }
            int r6 = (int) r5     // Catch:{ all -> 0x0f50 }
            r8.zzf((int) r6)     // Catch:{ all -> 0x0f50 }
            long r5 = r8.zzf()     // Catch:{ all -> 0x0f50 }
            r4.zza((long) r5)     // Catch:{ all -> 0x0f50 }
            long r5 = r8.zzg()     // Catch:{ all -> 0x0f50 }
            r4.zzb((long) r5)     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = r4.zzab()     // Catch:{ all -> 0x0f50 }
            if (r5 == 0) goto L_0x0e27
            r8.zzj((java.lang.String) r5)     // Catch:{ all -> 0x0f50 }
            goto L_0x0e2a
        L_0x0e27:
            r8.zzk()     // Catch:{ all -> 0x0f50 }
        L_0x0e2a:
            com.google.android.gms.measurement.internal.zzx r5 = r59.zze()     // Catch:{ all -> 0x0f50 }
            r5.zza((com.google.android.gms.measurement.internal.zzf) r4)     // Catch:{ all -> 0x0f50 }
        L_0x0e31:
            int r4 = r8.zzb()     // Catch:{ all -> 0x0f50 }
            if (r4 <= 0) goto L_0x0e97
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x0f50 }
            r4.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzfh r4 = r59.zzc()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = r5.zzx()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbo$zzb r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x0e5b
            boolean r5 = r4.zza()     // Catch:{ all -> 0x0f50 }
            if (r5 != 0) goto L_0x0e53
            goto L_0x0e5b
        L_0x0e53:
            long r4 = r4.zzb()     // Catch:{ all -> 0x0f50 }
            r8.zzi((long) r4)     // Catch:{ all -> 0x0f50 }
            goto L_0x0e86
        L_0x0e5b:
            com.google.android.gms.internal.measurement.zzbr$zzg r4 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r4 = r4.zzam()     // Catch:{ all -> 0x0f50 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0f50 }
            if (r4 == 0) goto L_0x0e6d
            r4 = -1
            r8.zzi((long) r4)     // Catch:{ all -> 0x0f50 }
            goto L_0x0e86
        L_0x0e6d:
            com.google.android.gms.measurement.internal.zzfn r4 = r1.zzj     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzi()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.zzbr$zzg r6 = r2.zza     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = r6.zzx()     // Catch:{ all -> 0x0f50 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r6)     // Catch:{ all -> 0x0f50 }
            r4.zza(r5, r6)     // Catch:{ all -> 0x0f50 }
        L_0x0e86:
            com.google.android.gms.measurement.internal.zzx r4 = r59.zze()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzgn r5 = r8.zzu()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzfd r5 = (com.google.android.gms.internal.measurement.zzfd) r5     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.internal.measurement.zzbr$zzg r5 = (com.google.android.gms.internal.measurement.zzbr.zzg) r5     // Catch:{ all -> 0x0f50 }
            r9 = r21
            r4.zza((com.google.android.gms.internal.measurement.zzbr.zzg) r5, (boolean) r9)     // Catch:{ all -> 0x0f50 }
        L_0x0e97:
            com.google.android.gms.measurement.internal.zzx r4 = r59.zze()     // Catch:{ all -> 0x0f50 }
            java.util.List<java.lang.Long> r2 = r2.zzb     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x0f50 }
            r4.zzd()     // Catch:{ all -> 0x0f50 }
            r4.zzak()     // Catch:{ all -> 0x0f50 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0f50 }
            r6 = 0
        L_0x0eae:
            int r7 = r2.size()     // Catch:{ all -> 0x0f50 }
            if (r6 >= r7) goto L_0x0ecb
            if (r6 == 0) goto L_0x0ebb
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0f50 }
        L_0x0ebb:
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x0f50 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0f50 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0f50 }
            r5.append(r7)     // Catch:{ all -> 0x0f50 }
            int r6 = r6 + 1
            goto L_0x0eae
        L_0x0ecb:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0f50 }
            android.database.sqlite.SQLiteDatabase r6 = r4.c_()     // Catch:{ all -> 0x0f50 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0f50 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0f50 }
            int r6 = r2.size()     // Catch:{ all -> 0x0f50 }
            if (r5 == r6) goto L_0x0efe
            com.google.android.gms.measurement.internal.zzej r4 = r4.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()     // Catch:{ all -> 0x0f50 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0f50 }
            int r2 = r2.size()     // Catch:{ all -> 0x0f50 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0f50 }
            r4.zza(r6, r5, r2)     // Catch:{ all -> 0x0f50 }
        L_0x0efe:
            com.google.android.gms.measurement.internal.zzx r2 = r59.zze()     // Catch:{ all -> 0x0f50 }
            android.database.sqlite.SQLiteDatabase r4 = r2.c_()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0f15 }
            r7 = 0
            r6[r7] = r3     // Catch:{ SQLiteException -> 0x0f15 }
            r7 = 1
            r6[r7] = r3     // Catch:{ SQLiteException -> 0x0f15 }
            r4.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0f15 }
            goto L_0x0f28
        L_0x0f15:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzr()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()     // Catch:{ all -> 0x0f50 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r3)     // Catch:{ all -> 0x0f50 }
            r2.zza(r5, r3, r4)     // Catch:{ all -> 0x0f50 }
        L_0x0f28:
            com.google.android.gms.measurement.internal.zzx r2 = r59.zze()     // Catch:{ all -> 0x0f50 }
            r2.b_()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzx r2 = r59.zze()
            r2.zzh()
            r2 = 1
            return r2
        L_0x0f38:
            com.google.android.gms.measurement.internal.zzx r2 = r59.zze()     // Catch:{ all -> 0x0f50 }
            r2.b_()     // Catch:{ all -> 0x0f50 }
            com.google.android.gms.measurement.internal.zzx r2 = r59.zze()
            r2.zzh()
            r2 = 0
            return r2
        L_0x0f48:
            r0 = move-exception
            r2 = r0
        L_0x0f4a:
            if (r8 == 0) goto L_0x0f4f
            r8.close()     // Catch:{ all -> 0x0f50 }
        L_0x0f4f:
            throw r2     // Catch:{ all -> 0x0f50 }
        L_0x0f50:
            r0 = move-exception
        L_0x0f51:
            r2 = r0
            com.google.android.gms.measurement.internal.zzx r3 = r59.zze()
            r3.zzh()
            goto L_0x0f5b
        L_0x0f5a:
            throw r2
        L_0x0f5b:
            goto L_0x0f5a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjp.zza(java.lang.String, long):boolean");
    }

    private static void zza(zzbr.zzg.zza zza2) {
        zza2.zzb(Long.MAX_VALUE).zzc(Long.MIN_VALUE);
        for (int i = 0; i < zza2.zzb(); i++) {
            zzbr.zzc zzb2 = zza2.zzb(i);
            if (zzb2.zze() < zza2.zzf()) {
                zza2.zzb(zzb2.zze());
            }
            if (zzb2.zze() > zza2.zzg()) {
                zza2.zzc(zzb2.zze());
            }
        }
    }

    @VisibleForTesting
    private final void zza(zzbr.zzg.zza zza2, long j, boolean z) {
        zzjy zzjy;
        String str = z ? "_se" : "_lte";
        zzjy zzc2 = zze().zzc(zza2.zzj(), str);
        if (zzc2 == null || zzc2.zze == null) {
            zzjy = new zzjy(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(j));
        } else {
            zzjy = new zzjy(zza2.zzj(), "auto", str, this.zzj.zzm().currentTimeMillis(), Long.valueOf(((Long) zzc2.zze).longValue() + j));
        }
        zzbr.zzk zzk2 = (zzbr.zzk) ((zzfd) zzbr.zzk.zzj().zza(str).zza(this.zzj.zzm().currentTimeMillis()).zzb(((Long) zzjy.zze).longValue()).zzu());
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (i >= zza2.zze()) {
                break;
            } else if (str.equals(zza2.zzd(i).zzc())) {
                zza2.zza(i, zzk2);
                z2 = true;
                break;
            } else {
                i++;
            }
        }
        if (!z2) {
            zza2.zza(zzk2);
        }
        if (j > 0) {
            zze().zza(zzjy);
            this.zzj.zzr().zzw().zza("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", zzjy.zze);
        }
    }

    private final boolean zza(zzbr.zzc.zza zza2, zzbr.zzc.zza zza3) {
        String str;
        Preconditions.checkArgument("_e".equals(zza2.zzc()));
        zzh();
        zzbr.zze zza4 = zzjt.zza((zzbr.zzc) ((zzfd) zza2.zzu()), "_sc");
        String str2 = null;
        if (zza4 == null) {
            str = null;
        } else {
            str = zza4.zzc();
        }
        zzh();
        zzbr.zze zza5 = zzjt.zza((zzbr.zzc) ((zzfd) zza3.zzu()), "_pc");
        if (zza5 != null) {
            str2 = zza5.zzc();
        }
        if (str2 == null || !str2.equals(str)) {
            return false;
        }
        zzb(zza2, zza3);
        return true;
    }

    private final void zzb(zzbr.zzc.zza zza2, zzbr.zzc.zza zza3) {
        Preconditions.checkArgument("_e".equals(zza2.zzc()));
        zzh();
        zzbr.zze zza4 = zzjt.zza((zzbr.zzc) ((zzfd) zza2.zzu()), "_et");
        if (zza4.zzd() && zza4.zze() > 0) {
            long zze2 = zza4.zze();
            zzh();
            zzbr.zze zza5 = zzjt.zza((zzbr.zzc) ((zzfd) zza3.zzu()), "_et");
            if (zza5 != null && zza5.zze() > 0) {
                zze2 += zza5.zze();
            }
            zzh();
            zzjt.zza(zza3, "_et", (Object) Long.valueOf(zze2));
            zzh();
            zzjt.zza(zza2, "_fr", (Object) 1L);
        }
    }

    @VisibleForTesting
    private static void zza(zzbr.zzc.zza zza2, @NonNull String str) {
        List<zzbr.zze> zza3 = zza2.zza();
        for (int i = 0; i < zza3.size(); i++) {
            if (str.equals(zza3.get(i).zza())) {
                zza2.zzb(i);
                return;
            }
        }
    }

    @VisibleForTesting
    private static void zza(zzbr.zzc.zza zza2, int i, String str) {
        List<zzbr.zze> zza3 = zza2.zza();
        int i2 = 0;
        while (i2 < zza3.size()) {
            if (!"_err".equals(zza3.get(i2).zza())) {
                i2++;
            } else {
                return;
            }
        }
        zza2.zza((zzbr.zze) ((zzfd) zzbr.zze.zzh().zza("_err").zza(Long.valueOf((long) i).longValue()).zzu())).zza((zzbr.zze) ((zzfd) zzbr.zze.zzh().zza("_ev").zzb(str).zzu()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(int i, Throwable th, byte[] bArr, String str) {
        zzx zze2;
        zzw();
        zzk();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.zzs = false;
                zzaa();
                throw th2;
            }
        }
        List<Long> list = this.zzw;
        this.zzw = null;
        boolean z = true;
        if ((i == 200 || i == 204) && th == null) {
            try {
                this.zzj.zzc().zzc.zza(this.zzj.zzm().currentTimeMillis());
                this.zzj.zzc().zzd.zza(0);
                zzz();
                this.zzj.zzr().zzx().zza("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                zze().zzf();
                try {
                    for (Long next : list) {
                        try {
                            zze2 = zze();
                            long longValue = next.longValue();
                            zze2.zzd();
                            zze2.zzak();
                            if (zze2.c_().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e) {
                            zze2.zzr().zzf().zza("Failed to delete a bundle in a queue table", e);
                            throw e;
                        } catch (SQLiteException e2) {
                            if (this.zzx == null || !this.zzx.contains(next)) {
                                throw e2;
                            }
                        }
                    }
                    zze().b_();
                    zze().zzh();
                    this.zzx = null;
                    if (!zzd().zzf() || !zzy()) {
                        this.zzy = -1;
                        zzz();
                    } else {
                        zzl();
                    }
                    this.zzn = 0;
                } catch (Throwable th3) {
                    zze().zzh();
                    throw th3;
                }
            } catch (SQLiteException e3) {
                this.zzj.zzr().zzf().zza("Database error while trying to delete uploaded bundles", e3);
                this.zzn = this.zzj.zzm().elapsedRealtime();
                this.zzj.zzr().zzx().zza("Disable upload, time", Long.valueOf(this.zzn));
            }
        } else {
            this.zzj.zzr().zzx().zza("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            this.zzj.zzc().zzd.zza(this.zzj.zzm().currentTimeMillis());
            if (i != 503) {
                if (i != 429) {
                    z = false;
                }
            }
            if (z) {
                this.zzj.zzc().zze.zza(this.zzj.zzm().currentTimeMillis());
            }
            zze().zza(list);
            zzz();
        }
        this.zzs = false;
        zzaa();
    }

    private final boolean zzy() {
        zzw();
        zzk();
        return zze().zzy() || !TextUtils.isEmpty(zze().d_());
    }

    @WorkerThread
    private final void zza(zzf zzf2) {
        zzw();
        if (!TextUtils.isEmpty(zzf2.zzd()) || !TextUtils.isEmpty(zzf2.zze())) {
            zzs zzb2 = this.zzj.zzb();
            Uri.Builder builder = new Uri.Builder();
            String zzd2 = zzf2.zzd();
            if (TextUtils.isEmpty(zzd2)) {
                zzd2 = zzf2.zze();
            }
            ArrayMap arrayMap = null;
            Uri.Builder encodedAuthority = builder.scheme(zzak.zzh.zza(null)).encodedAuthority(zzak.zzi.zza(null));
            String valueOf = String.valueOf(zzd2);
            encodedAuthority.path(valueOf.length() != 0 ? "config/app/".concat(valueOf) : new String("config/app/")).appendQueryParameter("app_instance_id", zzf2.zzc()).appendQueryParameter(JsonMarshaller.PLATFORM, "android").appendQueryParameter("gmp_version", String.valueOf(zzb2.zzf()));
            String uri = builder.build().toString();
            try {
                URL url = new URL(uri);
                this.zzj.zzr().zzx().zza("Fetching remote configuration", zzf2.zzb());
                zzbo.zzb zza2 = zzc().zza(zzf2.zzb());
                String zzb3 = zzc().zzb(zzf2.zzb());
                if (zza2 != null && !TextUtils.isEmpty(zzb3)) {
                    arrayMap = new ArrayMap();
                    arrayMap.put(HttpHeaders.IF_MODIFIED_SINCE, zzb3);
                }
                this.zzr = true;
                zzen zzd3 = zzd();
                String zzb4 = zzf2.zzb();
                zzjq zzjq = new zzjq(this);
                zzd3.zzd();
                zzd3.zzak();
                Preconditions.checkNotNull(url);
                Preconditions.checkNotNull(zzjq);
                zzd3.zzq().zzb((Runnable) new zzer(zzd3, zzb4, url, (byte[]) null, arrayMap, zzjq));
            } catch (MalformedURLException unused) {
                this.zzj.zzr().zzf().zza("Failed to parse config URL. Not fetching. appId", zzej.zza(zzf2.zzb()), uri);
            }
        } else {
            zza(zzf2.zzb(), XMPError.BADSTREAM, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x013a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x014a A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0172 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0176 A[Catch:{ all -> 0x018d, all -> 0x0196 }] */
    @androidx.annotation.WorkerThread
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.zzw()
            r6.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x0196 }
        L_0x000e:
            com.google.android.gms.measurement.internal.zzfn r1 = r6.zzj     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzr()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()     // Catch:{ all -> 0x0196 }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x0196 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x0196 }
            r1.zza(r2, r3)     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzx r1 = r6.zze()     // Catch:{ all -> 0x0196 }
            r1.zzf()     // Catch:{ all -> 0x0196 }
            com.google.android.gms.measurement.internal.zzx r1 = r6.zze()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzf r1 = r1.zzb(r7)     // Catch:{ all -> 0x018d }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003e
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003e
            if (r8 != r3) goto L_0x0042
        L_0x003e:
            if (r9 != 0) goto L_0x0042
            r2 = 1
            goto L_0x0043
        L_0x0042:
            r2 = 0
        L_0x0043:
            if (r1 != 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzfn r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzej r8 = r8.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzel r8 = r8.zzi()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r7)     // Catch:{ all -> 0x018d }
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x005a:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00ca
            if (r8 != r5) goto L_0x0061
            goto L_0x00ca
        L_0x0061:
            com.google.android.gms.measurement.internal.zzfn r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r10 = r10.zzm()     // Catch:{ all -> 0x018d }
            long r10 = r10.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzi(r10)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r10 = r6.zze()     // Catch:{ all -> 0x018d }
            r10.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfn r10 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzej r10 = r10.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzel r10 = r10.zzx()     // Catch:{ all -> 0x018d }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            r10.zza(r11, r1, r9)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfh r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            r9.zzc(r7)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfn r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zzd     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfn r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x018d }
            long r9 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r9)     // Catch:{ all -> 0x018d }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00ae
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00ad
            goto L_0x00ae
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            if (r4 == 0) goto L_0x00c5
            com.google.android.gms.measurement.internal.zzfn r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzes r7 = r7.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzex r7 = r7.zze     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzfn r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r8 = r8.zzm()     // Catch:{ all -> 0x018d }
            long r8 = r8.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r7.zza(r8)     // Catch:{ all -> 0x018d }
        L_0x00c5:
            r6.zzz()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x00ca:
            r9 = 0
            if (r11 == 0) goto L_0x00d6
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x018d }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x018d }
            goto L_0x00d7
        L_0x00d6:
            r11 = r9
        L_0x00d7:
            if (r11 == 0) goto L_0x00e6
            int r2 = r11.size()     // Catch:{ all -> 0x018d }
            if (r2 <= 0) goto L_0x00e6
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x018d }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x018d }
            goto L_0x00e7
        L_0x00e6:
            r11 = r9
        L_0x00e7:
            if (r8 == r5) goto L_0x0103
            if (r8 != r3) goto L_0x00ec
            goto L_0x0103
        L_0x00ec:
            com.google.android.gms.measurement.internal.zzfh r9 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r9.zza(r7, r10, r11)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzx r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzh()     // Catch:{ all -> 0x0196 }
            r6.zzr = r0
            r6.zzaa()
            return
        L_0x0103:
            com.google.android.gms.measurement.internal.zzfh r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            com.google.android.gms.internal.measurement.zzbo$zzb r11 = r11.zza((java.lang.String) r7)     // Catch:{ all -> 0x018d }
            if (r11 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzfh r11 = r6.zzc()     // Catch:{ all -> 0x018d }
            boolean r9 = r11.zza(r7, r9, r9)     // Catch:{ all -> 0x018d }
            if (r9 != 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzx r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzh()     // Catch:{ all -> 0x0196 }
            r6.zzr = r0
            r6.zzaa()
            return
        L_0x0124:
            com.google.android.gms.measurement.internal.zzfn r9 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.common.util.Clock r9 = r9.zzm()     // Catch:{ all -> 0x018d }
            long r2 = r9.currentTimeMillis()     // Catch:{ all -> 0x018d }
            r1.zzh((long) r2)     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r9 = r6.zze()     // Catch:{ all -> 0x018d }
            r9.zza((com.google.android.gms.measurement.internal.zzf) r1)     // Catch:{ all -> 0x018d }
            if (r8 != r5) goto L_0x014a
            com.google.android.gms.measurement.internal.zzfn r8 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzej r8 = r8.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzel r8 = r8.zzk()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.zza(r9, r7)     // Catch:{ all -> 0x018d }
            goto L_0x0162
        L_0x014a:
            com.google.android.gms.measurement.internal.zzfn r7 = r6.zzj     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzr()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzel r7 = r7.zzx()     // Catch:{ all -> 0x018d }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x018d }
            int r10 = r10.length     // Catch:{ all -> 0x018d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x018d }
            r7.zza(r9, r8, r10)     // Catch:{ all -> 0x018d }
        L_0x0162:
            com.google.android.gms.measurement.internal.zzen r7 = r6.zzd()     // Catch:{ all -> 0x018d }
            boolean r7 = r7.zzf()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            boolean r7 = r6.zzy()     // Catch:{ all -> 0x018d }
            if (r7 == 0) goto L_0x0176
            r6.zzl()     // Catch:{ all -> 0x018d }
            goto L_0x0179
        L_0x0176:
            r6.zzz()     // Catch:{ all -> 0x018d }
        L_0x0179:
            com.google.android.gms.measurement.internal.zzx r7 = r6.zze()     // Catch:{ all -> 0x018d }
            r7.b_()     // Catch:{ all -> 0x018d }
            com.google.android.gms.measurement.internal.zzx r7 = r6.zze()     // Catch:{ all -> 0x0196 }
            r7.zzh()     // Catch:{ all -> 0x0196 }
            r6.zzr = r0
            r6.zzaa()
            return
        L_0x018d:
            r7 = move-exception
            com.google.android.gms.measurement.internal.zzx r8 = r6.zze()     // Catch:{ all -> 0x0196 }
            r8.zzh()     // Catch:{ all -> 0x0196 }
            throw r7     // Catch:{ all -> 0x0196 }
        L_0x0196:
            r7 = move-exception
            r6.zzr = r0
            r6.zzaa()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjp.zza(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01c0  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzz() {
        /*
            r21 = this;
            r0 = r21
            r21.zzw()
            r21.zzk()
            boolean r1 = r21.zzac()
            if (r1 != 0) goto L_0x001d
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzs r1 = r1.zzb()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzbj
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean>) r2)
            if (r1 != 0) goto L_0x001d
            return
        L_0x001d:
            long r1 = r0.zzn
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0062
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.elapsedRealtime()
            r5 = 3600000(0x36ee80, double:1.7786363E-317)
            long r7 = r0.zzn
            long r1 = r1 - r7
            long r1 = java.lang.Math.abs(r1)
            long r5 = r5 - r1
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0060
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r5)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzeq r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzjl r1 = r21.zzv()
            r1.zzf()
            return
        L_0x0060:
            r0.zzn = r3
        L_0x0062:
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            boolean r1 = r1.zzag()
            if (r1 == 0) goto L_0x026b
            boolean r1 = r21.zzy()
            if (r1 != 0) goto L_0x0072
            goto L_0x026b
        L_0x0072:
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzad
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r7 = r5.longValue()
            long r7 = java.lang.Math.max(r3, r7)
            com.google.android.gms.measurement.internal.zzx r5 = r21.zze()
            boolean r5 = r5.zzz()
            if (r5 != 0) goto L_0x00a4
            com.google.android.gms.measurement.internal.zzx r5 = r21.zze()
            boolean r5 = r5.zzk()
            if (r5 == 0) goto L_0x00a2
            goto L_0x00a4
        L_0x00a2:
            r5 = 0
            goto L_0x00a5
        L_0x00a4:
            r5 = 1
        L_0x00a5:
            if (r5 == 0) goto L_0x00e1
            com.google.android.gms.measurement.internal.zzfn r10 = r0.zzj
            com.google.android.gms.measurement.internal.zzs r10 = r10.zzb()
            java.lang.String r10 = r10.zzw()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00d0
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00d0
            com.google.android.gms.measurement.internal.zzdy<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzy
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00f1
        L_0x00d0:
            com.google.android.gms.measurement.internal.zzdy<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzx
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
            goto L_0x00f1
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzdy<java.lang.Long> r10 = com.google.android.gms.measurement.internal.zzak.zzw
            java.lang.Object r10 = r10.zza(r6)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r3, r10)
        L_0x00f1:
            com.google.android.gms.measurement.internal.zzfn r12 = r0.zzj
            com.google.android.gms.measurement.internal.zzes r12 = r12.zzc()
            com.google.android.gms.measurement.internal.zzex r12 = r12.zzc
            long r12 = r12.zza()
            com.google.android.gms.measurement.internal.zzfn r14 = r0.zzj
            com.google.android.gms.measurement.internal.zzes r14 = r14.zzc()
            com.google.android.gms.measurement.internal.zzex r14 = r14.zzd
            long r14 = r14.zza()
            com.google.android.gms.measurement.internal.zzx r16 = r21.zze()
            r17 = r10
            long r9 = r16.zzw()
            com.google.android.gms.measurement.internal.zzx r11 = r21.zze()
            r19 = r7
            long r6 = r11.zzx()
            long r6 = java.lang.Math.max(r9, r6)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x0128
        L_0x0125:
            r8 = r3
            goto L_0x019e
        L_0x0128:
            long r6 = r6 - r1
            long r6 = java.lang.Math.abs(r6)
            long r6 = r1 - r6
            long r12 = r12 - r1
            long r8 = java.lang.Math.abs(r12)
            long r8 = r1 - r8
            long r14 = r14 - r1
            long r10 = java.lang.Math.abs(r14)
            long r1 = r1 - r10
            long r8 = java.lang.Math.max(r8, r1)
            long r10 = r6 + r19
            if (r5 == 0) goto L_0x014e
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x014e
            long r10 = java.lang.Math.min(r6, r8)
            long r10 = r10 + r17
        L_0x014e:
            com.google.android.gms.measurement.internal.zzjt r5 = r21.zzh()
            r12 = r17
            boolean r5 = r5.zza((long) r8, (long) r12)
            if (r5 != 0) goto L_0x015c
            long r8 = r8 + r12
            goto L_0x015d
        L_0x015c:
            r8 = r10
        L_0x015d:
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x019e
            int r5 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x019e
            r5 = 0
        L_0x0166:
            r6 = 20
            com.google.android.gms.measurement.internal.zzdy<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.zzak.zzaf
            r10 = 0
            java.lang.Object r7 = r7.zza(r10)
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            r11 = 0
            int r7 = java.lang.Math.max(r11, r7)
            int r6 = java.lang.Math.min(r6, r7)
            if (r5 >= r6) goto L_0x0125
            r6 = 1
            long r6 = r6 << r5
            com.google.android.gms.measurement.internal.zzdy<java.lang.Long> r12 = com.google.android.gms.measurement.internal.zzak.zzae
            java.lang.Object r12 = r12.zza(r10)
            java.lang.Long r12 = (java.lang.Long) r12
            long r12 = r12.longValue()
            long r12 = java.lang.Math.max(r3, r12)
            long r12 = r12 * r6
            long r8 = r8 + r12
            int r6 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r6 <= 0) goto L_0x019b
            goto L_0x019e
        L_0x019b:
            int r5 = r5 + 1
            goto L_0x0166
        L_0x019e:
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x01c0
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            java.lang.String r2 = "Next upload time is 0"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzeq r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzjl r1 = r21.zzv()
            r1.zzf()
            return
        L_0x01c0:
            com.google.android.gms.measurement.internal.zzen r1 = r21.zzd()
            boolean r1 = r1.zzf()
            if (r1 != 0) goto L_0x01e8
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            java.lang.String r2 = "No network"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzeq r1 = r21.zzt()
            r1.zza()
            com.google.android.gms.measurement.internal.zzjl r1 = r21.zzv()
            r1.zzf()
            return
        L_0x01e8:
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzex r1 = r1.zze
            long r1 = r1.zza()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Long> r5 = com.google.android.gms.measurement.internal.zzak.zzu
            r6 = 0
            java.lang.Object r5 = r5.zza(r6)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            long r5 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.zzjt r7 = r21.zzh()
            boolean r7 = r7.zza((long) r1, (long) r5)
            if (r7 != 0) goto L_0x0214
            long r1 = r1 + r5
            long r8 = java.lang.Math.max(r8, r1)
        L_0x0214:
            com.google.android.gms.measurement.internal.zzeq r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.common.util.Clock r1 = r1.zzm()
            long r1 = r1.currentTimeMillis()
            long r8 = r8 - r1
            int r1 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r1 > 0) goto L_0x0250
            com.google.android.gms.measurement.internal.zzdy<java.lang.Long> r1 = com.google.android.gms.measurement.internal.zzak.zzz
            r2 = 0
            java.lang.Object r1 = r1.zza(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r8 = java.lang.Math.max(r3, r1)
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzc()
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzc
            com.google.android.gms.measurement.internal.zzfn r2 = r0.zzj
            com.google.android.gms.common.util.Clock r2 = r2.zzm()
            long r2 = r2.currentTimeMillis()
            r1.zza(r2)
        L_0x0250:
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            java.lang.Long r2 = java.lang.Long.valueOf(r8)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.zza(r3, r2)
            com.google.android.gms.measurement.internal.zzjl r1 = r21.zzv()
            r1.zza(r8)
            return
        L_0x026b:
            com.google.android.gms.measurement.internal.zzfn r1 = r0.zzj
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzeq r1 = r21.zzt()
            r1.zzb()
            com.google.android.gms.measurement.internal.zzjl r1 = r21.zzv()
            r1.zzf()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjp.zzz():void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(Runnable runnable) {
        zzw();
        if (this.zzo == null) {
            this.zzo = new ArrayList();
        }
        this.zzo.add(runnable);
    }

    @WorkerThread
    private final void zzaa() {
        zzw();
        if (this.zzr || this.zzs || this.zzt) {
            this.zzj.zzr().zzx().zza("Not stopping services. fetch, network, upload", Boolean.valueOf(this.zzr), Boolean.valueOf(this.zzs), Boolean.valueOf(this.zzt));
            return;
        }
        this.zzj.zzr().zzx().zza("Stopping uploading service(s)");
        List<Runnable> list = this.zzo;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.zzo.clear();
        }
    }

    @WorkerThread
    private final Boolean zzb(zzf zzf2) {
        try {
            if (zzf2.zzk() != -2147483648L) {
                if (zzf2.zzk() == ((long) Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzf2.zzb(), 0).versionCode)) {
                    return true;
                }
            } else {
                String str = Wrappers.packageManager(this.zzj.zzn()).getPackageInfo(zzf2.zzb(), 0).versionName;
                if (zzf2.zzj() != null && zzf2.zzj().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zzab() {
        FileLock fileLock;
        zzw();
        if (!this.zzj.zzb().zza(zzak.zzce) || (fileLock = this.zzu) == null || !fileLock.isValid()) {
            try {
                this.zzv = new RandomAccessFile(new File(this.zzj.zzn().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.zzu = this.zzv.tryLock();
                if (this.zzu != null) {
                    this.zzj.zzr().zzx().zza("Storage concurrent access okay");
                    return true;
                }
                this.zzj.zzr().zzf().zza("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e) {
                this.zzj.zzr().zzf().zza("Failed to acquire storage lock", e);
                return false;
            } catch (IOException e2) {
                this.zzj.zzr().zzf().zza("Failed to access storage lock file", e2);
                return false;
            } catch (OverlappingFileLockException e3) {
                this.zzj.zzr().zzi().zza("Storage lock already acquired", e3);
                return false;
            }
        } else {
            this.zzj.zzr().zzx().zza("Storage concurrent access okay");
            return true;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final int zza(FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.zzj.zzr().zzi().zza("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to read from channel", e);
            return 0;
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final boolean zza(int i, FileChannel fileChannel) {
        zzw();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.zzj.zzr().zzf().zza("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.zzj.zzr().zzf().zza("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e) {
            this.zzj.zzr().zzf().zza("Failed to write to channel", e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzo() {
        zzw();
        zzk();
        if (!this.zzm) {
            this.zzm = true;
            zzw();
            zzk();
            if ((this.zzj.zzb().zza(zzak.zzbj) || zzac()) && zzab()) {
                int zza2 = zza(this.zzv);
                int zzae = this.zzj.zzy().zzae();
                zzw();
                if (zza2 > zzae) {
                    this.zzj.zzr().zzf().zza("Panic: can't downgrade version. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                } else if (zza2 < zzae) {
                    if (zza(zzae, this.zzv)) {
                        this.zzj.zzr().zzx().zza("Storage version upgraded. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                    } else {
                        this.zzj.zzr().zzf().zza("Storage version upgrade failed. Previous, current version", Integer.valueOf(zza2), Integer.valueOf(zzae));
                    }
                }
            }
        }
        if (!this.zzl && !this.zzj.zzb().zza(zzak.zzbj)) {
            this.zzj.zzr().zzv().zza("This instance being marked as an uploader");
            this.zzl = true;
            zzz();
        }
    }

    @WorkerThread
    private final boolean zzac() {
        zzw();
        zzk();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zzb(zzn zzn2) {
        if (this.zzw != null) {
            this.zzx = new ArrayList();
            this.zzx.addAll(this.zzw);
        }
        zzx zze2 = zze();
        String str = zzn2.zza;
        Preconditions.checkNotEmpty(str);
        zze2.zzd();
        zze2.zzak();
        try {
            SQLiteDatabase c_ = zze2.c_();
            String[] strArr = {str};
            int delete = c_.delete("apps", "app_id=?", strArr) + 0 + c_.delete("events", "app_id=?", strArr) + c_.delete("user_attributes", "app_id=?", strArr) + c_.delete("conditional_properties", "app_id=?", strArr) + c_.delete("raw_events", "app_id=?", strArr) + c_.delete("raw_events_metadata", "app_id=?", strArr) + c_.delete("queue", "app_id=?", strArr) + c_.delete("audience_filter_values", "app_id=?", strArr) + c_.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                zze2.zzr().zzx().zza("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zze2.zzr().zzf().zza("Error resetting analytics data. appId, error", zzej.zza(str), e);
        }
        zzjz.zzb();
        if (!this.zzj.zzb().zza(zzak.zzck)) {
            zzn zza2 = zza(this.zzj.zzn(), zzn2.zza, zzn2.zzb, zzn2.zzh, zzn2.zzo, zzn2.zzp, zzn2.zzm, zzn2.zzr);
            if (zzn2.zzh) {
                zzc(zza2);
            }
        } else if (zzn2.zzh) {
            zzc(zzn2);
        }
    }

    private final zzn zza(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j, String str3) {
        String str4;
        String str5;
        int i;
        String str6 = str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.zzj.zzr().zzf().zza("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str4 = packageManager.getInstallerPackageName(str6);
        } catch (IllegalArgumentException unused) {
            this.zzj.zzr().zzf().zza("Error retrieving installer package name. appId", zzej.zza(str));
            str4 = "Unknown";
        }
        if (str4 == null) {
            str4 = "manual_install";
        } else if ("com.android.vending".equals(str4)) {
            str4 = "";
        }
        String str7 = str4;
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str6, 0);
            if (packageInfo != null) {
                CharSequence applicationLabel = Wrappers.packageManager(context).getApplicationLabel(str6);
                if (!TextUtils.isEmpty(applicationLabel)) {
                    String charSequence = applicationLabel.toString();
                }
                String str8 = packageInfo.versionName;
                i = packageInfo.versionCode;
                str5 = str8;
            } else {
                i = Integer.MIN_VALUE;
                str5 = "Unknown";
            }
            this.zzj.zzu();
            return new zzn(str, str2, str5, (long) i, str7, this.zzj.zzb().zzf(), this.zzj.zzi().zza(context, str6), (String) null, z, false, "", 0, this.zzj.zzb().zzj(str6) ? j : 0, 0, z2, z3, false, str3, (Boolean) null, 0, (List<String>) null);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.zzj.zzr().zzf().zza("Error retrieving newly installed package info. appId, appName", zzej.zza(str), "Unknown");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzjw zzjw, zzn zzn2) {
        zzae zza2;
        zzw();
        zzk();
        if (TextUtils.isEmpty(zzn2.zzb) && TextUtils.isEmpty(zzn2.zzr)) {
            return;
        }
        if (!zzn2.zzh) {
            zze(zzn2);
            return;
        }
        int zzc2 = this.zzj.zzi().zzc(zzjw.zza);
        if (zzc2 != 0) {
            this.zzj.zzi();
            this.zzj.zzi().zza(zzn2.zza, zzc2, "_ev", zzjx.zza(zzjw.zza, 24, true), zzjw.zza != null ? zzjw.zza.length() : 0);
            return;
        }
        int zzb2 = this.zzj.zzi().zzb(zzjw.zza, zzjw.zza());
        if (zzb2 != 0) {
            this.zzj.zzi();
            String zza3 = zzjx.zza(zzjw.zza, 24, true);
            Object zza4 = zzjw.zza();
            this.zzj.zzi().zza(zzn2.zza, zzb2, "_ev", zza3, (zza4 == null || (!(zza4 instanceof String) && !(zza4 instanceof CharSequence))) ? 0 : String.valueOf(zza4).length());
            return;
        }
        Object zzc3 = this.zzj.zzi().zzc(zzjw.zza, zzjw.zza());
        if (zzc3 != null) {
            if ("_sid".equals(zzjw.zza) && this.zzj.zzb().zzo(zzn2.zza)) {
                long j = zzjw.zzb;
                String str = zzjw.zze;
                long j2 = 0;
                zzjy zzc4 = zze().zzc(zzn2.zza, "_sno");
                if (zzc4 == null || !(zzc4.zze instanceof Long)) {
                    if (zzc4 != null) {
                        this.zzj.zzr().zzi().zza("Retrieved last session number from database does not contain a valid (long) value", zzc4.zze);
                    }
                    if (this.zzj.zzb().zze(zzn2.zza, zzak.zzbb) && (zza2 = zze().zza(zzn2.zza, "_s")) != null) {
                        j2 = zza2.zzc;
                        this.zzj.zzr().zzx().zza("Backfill the session number. Last used session number", Long.valueOf(j2));
                    }
                } else {
                    j2 = ((Long) zzc4.zze).longValue();
                }
                zza(new zzjw("_sno", j, Long.valueOf(j2 + 1), str), zzn2);
            }
            zzjy zzjy = new zzjy(zzn2.zza, zzjw.zze, zzjw.zza, zzjw.zzb, zzc3);
            this.zzj.zzr().zzw().zza("Setting user property", this.zzj.zzj().zzc(zzjy.zzc), zzc3);
            zze().zzf();
            try {
                zze(zzn2);
                boolean zza5 = zze().zza(zzjy);
                zze().b_();
                if (zza5) {
                    this.zzj.zzr().zzw().zza("User property set", this.zzj.zzj().zzc(zzjy.zzc), zzjy.zze);
                } else {
                    this.zzj.zzr().zzf().zza("Too many unique user properties are set. Ignoring user property", this.zzj.zzj().zzc(zzjy.zzc), zzjy.zze);
                    this.zzj.zzi().zza(zzn2.zza, 9, (String) null, (String) null, 0);
                }
            } finally {
                zze().zzh();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzjw zzjw, zzn zzn2) {
        zzw();
        zzk();
        if (TextUtils.isEmpty(zzn2.zzb) && TextUtils.isEmpty(zzn2.zzr)) {
            return;
        }
        if (!zzn2.zzh) {
            zze(zzn2);
        } else if (!this.zzj.zzb().zze(zzn2.zza, zzak.zzbg)) {
            this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzjw.zza));
            zze().zzf();
            try {
                zze(zzn2);
                zze().zzb(zzn2.zza, zzjw.zza);
                zze().b_();
                this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzjw.zza));
            } finally {
                zze().zzh();
            }
        } else if (!"_npa".equals(zzjw.zza) || zzn2.zzs == null) {
            this.zzj.zzr().zzw().zza("Removing user property", this.zzj.zzj().zzc(zzjw.zza));
            zze().zzf();
            try {
                zze(zzn2);
                zze().zzb(zzn2.zza, zzjw.zza);
                zze().b_();
                this.zzj.zzr().zzw().zza("User property removed", this.zzj.zzj().zzc(zzjw.zza));
            } finally {
                zze().zzh();
            }
        } else {
            this.zzj.zzr().zzw().zza("Falling back to manifest metadata value for ad personalization");
            zza(new zzjw("_npa", this.zzj.zzm().currentTimeMillis(), Long.valueOf(zzn2.zzs.booleanValue() ? 1 : 0), "auto"), zzn2);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjm zzjm) {
        this.zzp++;
    }

    /* access modifiers changed from: package-private */
    public final void zzp() {
        this.zzq++;
    }

    /* access modifiers changed from: package-private */
    public final zzfn zzs() {
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x04a7 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x01f5 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0266 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0273 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0285 A[Catch:{ NameNotFoundException -> 0x0347, all -> 0x04d2 }] */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(com.google.android.gms.measurement.internal.zzn r22) {
        /*
            r21 = this;
            r1 = r21
            r2 = r22
            java.lang.String r3 = "_sys"
            java.lang.String r4 = "_pfo"
            java.lang.String r5 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r21.zzw()
            r21.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r22)
            java.lang.String r6 = r2.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r6)
            java.lang.String r6 = r2.zzb
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x002b
            java.lang.String r6 = r2.zzr
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 == 0) goto L_0x002b
            return
        L_0x002b:
            com.google.android.gms.measurement.internal.zzx r6 = r21.zze()
            java.lang.String r7 = r2.zza
            com.google.android.gms.measurement.internal.zzf r6 = r6.zzb(r7)
            r7 = 0
            if (r6 == 0) goto L_0x005e
            java.lang.String r9 = r6.zzd()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x005e
            java.lang.String r9 = r2.zzb
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x005e
            r6.zzh((long) r7)
            com.google.android.gms.measurement.internal.zzx r9 = r21.zze()
            r9.zza((com.google.android.gms.measurement.internal.zzf) r6)
            com.google.android.gms.measurement.internal.zzfh r6 = r21.zzc()
            java.lang.String r9 = r2.zza
            r6.zzd(r9)
        L_0x005e:
            boolean r6 = r2.zzh
            if (r6 != 0) goto L_0x0066
            r21.zze(r22)
            return
        L_0x0066:
            long r9 = r2.zzm
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x0076
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj
            com.google.android.gms.common.util.Clock r6 = r6.zzm()
            long r9 = r6.currentTimeMillis()
        L_0x0076:
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzb()
            java.lang.String r11 = r2.zza
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.zzak.zzbg
            boolean r6 = r6.zze(r11, r12)
            if (r6 == 0) goto L_0x008f
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj
            com.google.android.gms.measurement.internal.zzac r6 = r6.zzx()
            r6.zzi()
        L_0x008f:
            int r6 = r2.zzn
            r15 = 0
            r13 = 1
            if (r6 == 0) goto L_0x00b1
            if (r6 == r13) goto L_0x00b1
            com.google.android.gms.measurement.internal.zzfn r11 = r1.zzj
            com.google.android.gms.measurement.internal.zzej r11 = r11.zzr()
            com.google.android.gms.measurement.internal.zzel r11 = r11.zzi()
            java.lang.String r12 = r2.zza
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r12)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r11.zza(r14, r12, r6)
            r6 = 0
        L_0x00b1:
            com.google.android.gms.measurement.internal.zzx r11 = r21.zze()
            r11.zzf()
            com.google.android.gms.measurement.internal.zzfn r11 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r11 = r11.zzb()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.zzak.zzbg     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.zze(r12, r14)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0131
            com.google.android.gms.measurement.internal.zzx r11 = r21.zze()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r2.zza     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.zzjy r14 = r11.zzc(r12, r14)     // Catch:{ all -> 0x04d2 }
            if (r14 == 0) goto L_0x00e0
            java.lang.String r11 = "auto"
            java.lang.String r12 = r14.zzb     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0131
        L_0x00e0:
            java.lang.Boolean r11 = r2.zzs     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x011b
            com.google.android.gms.measurement.internal.zzjw r12 = new com.google.android.gms.measurement.internal.zzjw     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "_npa"
            java.lang.Boolean r11 = r2.zzs     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x00f3
            r17 = 1
            goto L_0x00f5
        L_0x00f3:
            r17 = 0
        L_0x00f5:
            java.lang.Long r17 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x04d2 }
            java.lang.String r18 = "auto"
            r11 = r12
            r7 = r12
            r12 = r16
            r19 = r3
            r8 = r14
            r3 = 1
            r13 = r9
            r15 = r17
            r16 = r18
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            if (r8 == 0) goto L_0x0117
            java.lang.Object r8 = r8.zze     // Catch:{ all -> 0x04d2 }
            java.lang.Long r11 = r7.zzc     // Catch:{ all -> 0x04d2 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x04d2 }
            if (r8 != 0) goto L_0x0134
        L_0x0117:
            r1.zza((com.google.android.gms.measurement.internal.zzjw) r7, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0134
        L_0x011b:
            r19 = r3
            r8 = r14
            r3 = 1
            if (r8 == 0) goto L_0x0134
            com.google.android.gms.measurement.internal.zzjw r7 = new com.google.android.gms.measurement.internal.zzjw     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_npa"
            r15 = 0
            java.lang.String r16 = "auto"
            r11 = r7
            r13 = r9
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zzb((com.google.android.gms.measurement.internal.zzjw) r7, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0134
        L_0x0131:
            r19 = r3
            r3 = 1
        L_0x0134:
            com.google.android.gms.measurement.internal.zzx r7 = r21.zze()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzf r7 = r7.zzb(r8)     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x01f2
            com.google.android.gms.measurement.internal.zzfn r11 = r1.zzj     // Catch:{ all -> 0x04d2 }
            r11.zzi()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = r2.zzb     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r7.zzd()     // Catch:{ all -> 0x04d2 }
            java.lang.String r13 = r2.zzr     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = r7.zze()     // Catch:{ all -> 0x04d2 }
            boolean r11 = com.google.android.gms.measurement.internal.zzjx.zza((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x01f2
            com.google.android.gms.measurement.internal.zzfn r11 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzej r11 = r11.zzr()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzel r11 = r11.zzi()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r7.zzb()     // Catch:{ all -> 0x04d2 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r13)     // Catch:{ all -> 0x04d2 }
            r11.zza(r12, r13)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzx r11 = r21.zze()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.zzb()     // Catch:{ all -> 0x04d2 }
            r11.zzak()     // Catch:{ all -> 0x04d2 }
            r11.zzd()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r7)     // Catch:{ all -> 0x04d2 }
            android.database.sqlite.SQLiteDatabase r12 = r11.c_()     // Catch:{ SQLiteException -> 0x01dd }
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01dd }
            r15 = 0
            r13[r15] = r7     // Catch:{ SQLiteException -> 0x01db }
            java.lang.String r14 = "events"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r15
            java.lang.String r8 = "user_attributes"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "conditional_properties"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "apps"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "raw_events"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "raw_events_metadata"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "event_filters"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "property_filters"
            int r8 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r8
            java.lang.String r8 = "audience_filter_values"
            int r0 = r12.delete(r8, r0, r13)     // Catch:{ SQLiteException -> 0x01db }
            int r14 = r14 + r0
            if (r14 <= 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzej r0 = r11.zzr()     // Catch:{ SQLiteException -> 0x01db }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzx()     // Catch:{ SQLiteException -> 0x01db }
            java.lang.String r8 = "Deleted application data. app, records"
            java.lang.Integer r12 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01db }
            r0.zza(r8, r7, r12)     // Catch:{ SQLiteException -> 0x01db }
            goto L_0x01f0
        L_0x01db:
            r0 = move-exception
            goto L_0x01df
        L_0x01dd:
            r0 = move-exception
            r15 = 0
        L_0x01df:
            com.google.android.gms.measurement.internal.zzej r8 = r11.zzr()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzel r8 = r8.zzf()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "Error deleting application data. appId, error"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r7)     // Catch:{ all -> 0x04d2 }
            r8.zza(r11, r7, r0)     // Catch:{ all -> 0x04d2 }
        L_0x01f0:
            r7 = 0
            goto L_0x01f3
        L_0x01f2:
            r15 = 0
        L_0x01f3:
            if (r7 == 0) goto L_0x0260
            long r11 = r7.zzk()     // Catch:{ all -> 0x04d2 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            java.lang.String r0 = "_pv"
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 == 0) goto L_0x022d
            long r11 = r7.zzk()     // Catch:{ all -> 0x04d2 }
            long r13 = r2.zzj     // Catch:{ all -> 0x04d2 }
            int r8 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r8 == 0) goto L_0x0260
            android.os.Bundle r8 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r8.<init>()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.zzj()     // Catch:{ all -> 0x04d2 }
            r8.putString(r0, r7)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_au"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r8)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r8 = 0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zza((com.google.android.gms.measurement.internal.zzai) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0261
        L_0x022d:
            r8 = 0
            java.lang.String r11 = r7.zzj()     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0261
            java.lang.String r11 = r7.zzj()     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = r2.zzc     // Catch:{ all -> 0x04d2 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x04d2 }
            if (r11 != 0) goto L_0x0261
            android.os.Bundle r11 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r11.<init>()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r7.zzj()     // Catch:{ all -> 0x04d2 }
            r11.putString(r0, r7)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_au"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r11)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zza((com.google.android.gms.measurement.internal.zzai) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0261
        L_0x0260:
            r8 = 0
        L_0x0261:
            r21.zze(r22)     // Catch:{ all -> 0x04d2 }
            if (r6 != 0) goto L_0x0273
            com.google.android.gms.measurement.internal.zzx r0 = r21.zze()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "_f"
            com.google.android.gms.measurement.internal.zzae r0 = r0.zza((java.lang.String) r7, (java.lang.String) r11)     // Catch:{ all -> 0x04d2 }
            goto L_0x0283
        L_0x0273:
            if (r6 != r3) goto L_0x0282
            com.google.android.gms.measurement.internal.zzx r0 = r21.zze()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "_v"
            com.google.android.gms.measurement.internal.zzae r0 = r0.zza((java.lang.String) r7, (java.lang.String) r11)     // Catch:{ all -> 0x04d2 }
            goto L_0x0283
        L_0x0282:
            r0 = 0
        L_0x0283:
            if (r0 != 0) goto L_0x04a7
            r11 = 3600000(0x36ee80, double:1.7786363E-317)
            long r13 = r9 / r11
            r15 = 1
            long r13 = r13 + r15
            long r13 = r13 * r11
            java.lang.String r0 = "_dac"
            java.lang.String r7 = "_r"
            java.lang.String r15 = "_c"
            java.lang.String r12 = "_et"
            if (r6 != 0) goto L_0x040a
            com.google.android.gms.measurement.internal.zzjw r6 = new com.google.android.gms.measurement.internal.zzjw     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "_fot"
            java.lang.Long r18 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04d2 }
            java.lang.String r20 = "auto"
            r11 = r6
            r13 = r12
            r12 = r16
            r3 = r13
            r13 = r9
            r8 = r15
            r15 = r18
            r16 = r20
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zza((com.google.android.gms.measurement.internal.zzjw) r6, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r6 = r6.zzb()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = r2.zzb     // Catch:{ all -> 0x04d2 }
            boolean r6 = r6.zzl(r11)     // Catch:{ all -> 0x04d2 }
            if (r6 == 0) goto L_0x02d0
            r21.zzw()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfn r6 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzey r6 = r6.zzf()     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x04d2 }
            r6.zza(r11)     // Catch:{ all -> 0x04d2 }
        L_0x02d0:
            r21.zzw()     // Catch:{ all -> 0x04d2 }
            r21.zzk()     // Catch:{ all -> 0x04d2 }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r6.<init>()     // Catch:{ all -> 0x04d2 }
            r11 = 1
            r6.putLong(r8, r11)     // Catch:{ all -> 0x04d2 }
            r6.putLong(r7, r11)     // Catch:{ all -> 0x04d2 }
            r7 = 0
            r6.putLong(r5, r7)     // Catch:{ all -> 0x04d2 }
            r6.putLong(r4, r7)     // Catch:{ all -> 0x04d2 }
            r15 = r19
            r6.putLong(r15, r7)     // Catch:{ all -> 0x04d2 }
            java.lang.String r11 = "_sysu"
            r6.putLong(r11, r7)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r7 = r7.zzb()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = r2.zza     // Catch:{ all -> 0x04d2 }
            boolean r7 = r7.zzr(r8)     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x0309
            r7 = 1
            r6.putLong(r3, r7)     // Catch:{ all -> 0x04d2 }
            goto L_0x030b
        L_0x0309:
            r7 = 1
        L_0x030b:
            boolean r11 = r2.zzq     // Catch:{ all -> 0x04d2 }
            if (r11 == 0) goto L_0x0312
            r6.putLong(r0, r7)     // Catch:{ all -> 0x04d2 }
        L_0x0312:
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ all -> 0x04d2 }
            android.content.Context r0 = r0.zzn()     // Catch:{ all -> 0x04d2 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04d2 }
            if (r0 != 0) goto L_0x0335
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzej r0 = r0.zzr()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzf()     // Catch:{ all -> 0x04d2 }
            java.lang.String r5 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r7 = r2.zza     // Catch:{ all -> 0x04d2 }
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r7)     // Catch:{ all -> 0x04d2 }
            r0.zza(r5, r7)     // Catch:{ all -> 0x04d2 }
            goto L_0x03d8
        L_0x0335:
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x0347 }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x0347 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x0347 }
            java.lang.String r7 = r2.zza     // Catch:{ NameNotFoundException -> 0x0347 }
            r8 = 0
            android.content.pm.PackageInfo r0 = r0.getPackageInfo(r7, r8)     // Catch:{ NameNotFoundException -> 0x0347 }
            goto L_0x035e
        L_0x0347:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfn r7 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzej r7 = r7.zzr()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzel r7 = r7.zzf()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x04d2 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r11)     // Catch:{ all -> 0x04d2 }
            r7.zza(r8, r11, r0)     // Catch:{ all -> 0x04d2 }
            r0 = 0
        L_0x035e:
            if (r0 == 0) goto L_0x0394
            long r7 = r0.firstInstallTime     // Catch:{ all -> 0x04d2 }
            r11 = 0
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 == 0) goto L_0x0394
            long r7 = r0.firstInstallTime     // Catch:{ all -> 0x04d2 }
            long r11 = r0.lastUpdateTime     // Catch:{ all -> 0x04d2 }
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 == 0) goto L_0x0377
            r7 = 1
            r6.putLong(r5, r7)     // Catch:{ all -> 0x04d2 }
            r0 = 0
            goto L_0x0378
        L_0x0377:
            r0 = 1
        L_0x0378:
            com.google.android.gms.measurement.internal.zzjw r5 = new com.google.android.gms.measurement.internal.zzjw     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_fi"
            if (r0 == 0) goto L_0x0381
            r7 = 1
            goto L_0x0383
        L_0x0381:
            r7 = 0
        L_0x0383:
            java.lang.Long r0 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "auto"
            r11 = r5
            r13 = r9
            r7 = r15
            r15 = r0
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zza((com.google.android.gms.measurement.internal.zzjw) r5, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0395
        L_0x0394:
            r7 = r15
        L_0x0395:
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ NameNotFoundException -> 0x03a7 }
            android.content.Context r0 = r0.zzn()     // Catch:{ NameNotFoundException -> 0x03a7 }
            com.google.android.gms.common.wrappers.PackageManagerWrapper r0 = com.google.android.gms.common.wrappers.Wrappers.packageManager(r0)     // Catch:{ NameNotFoundException -> 0x03a7 }
            java.lang.String r5 = r2.zza     // Catch:{ NameNotFoundException -> 0x03a7 }
            r8 = 0
            android.content.pm.ApplicationInfo r8 = r0.getApplicationInfo(r5, r8)     // Catch:{ NameNotFoundException -> 0x03a7 }
            goto L_0x03be
        L_0x03a7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzej r5 = r5.zzr()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzf()     // Catch:{ all -> 0x04d2 }
            java.lang.String r8 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r11 = r2.zza     // Catch:{ all -> 0x04d2 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r11)     // Catch:{ all -> 0x04d2 }
            r5.zza(r8, r11, r0)     // Catch:{ all -> 0x04d2 }
            r8 = 0
        L_0x03be:
            if (r8 == 0) goto L_0x03d8
            int r0 = r8.flags     // Catch:{ all -> 0x04d2 }
            r5 = 1
            r0 = r0 & r5
            if (r0 == 0) goto L_0x03cb
            r11 = 1
            r6.putLong(r7, r11)     // Catch:{ all -> 0x04d2 }
        L_0x03cb:
            int r0 = r8.flags     // Catch:{ all -> 0x04d2 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03d8
            java.lang.String r0 = "_sysu"
            r7 = 1
            r6.putLong(r0, r7)     // Catch:{ all -> 0x04d2 }
        L_0x03d8:
            com.google.android.gms.measurement.internal.zzx r0 = r21.zze()     // Catch:{ all -> 0x04d2 }
            java.lang.String r5 = r2.zza     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r5)     // Catch:{ all -> 0x04d2 }
            r0.zzd()     // Catch:{ all -> 0x04d2 }
            r0.zzak()     // Catch:{ all -> 0x04d2 }
            java.lang.String r7 = "first_open_count"
            long r7 = r0.zzh(r5, r7)     // Catch:{ all -> 0x04d2 }
            r11 = 0
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x03f6
            r6.putLong(r4, r7)     // Catch:{ all -> 0x04d2 }
        L_0x03f6:
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_f"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r6)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zza((com.google.android.gms.measurement.internal.zzai) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x0464
        L_0x040a:
            r3 = r12
            r8 = r15
            r4 = 1
            if (r6 != r4) goto L_0x0464
            com.google.android.gms.measurement.internal.zzjw r4 = new com.google.android.gms.measurement.internal.zzjw     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_fvt"
            java.lang.Long r15 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04d2 }
            java.lang.String r16 = "auto"
            r11 = r4
            r13 = r9
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04d2 }
            r1.zza((com.google.android.gms.measurement.internal.zzjw) r4, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
            r21.zzw()     // Catch:{ all -> 0x04d2 }
            r21.zzk()     // Catch:{ all -> 0x04d2 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r4.<init>()     // Catch:{ all -> 0x04d2 }
            r5 = 1
            r4.putLong(r8, r5)     // Catch:{ all -> 0x04d2 }
            r4.putLong(r7, r5)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfn r5 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r5 = r5.zzb()     // Catch:{ all -> 0x04d2 }
            java.lang.String r6 = r2.zza     // Catch:{ all -> 0x04d2 }
            boolean r5 = r5.zzr(r6)     // Catch:{ all -> 0x04d2 }
            if (r5 == 0) goto L_0x0448
            r5 = 1
            r4.putLong(r3, r5)     // Catch:{ all -> 0x04d2 }
            goto L_0x044a
        L_0x0448:
            r5 = 1
        L_0x044a:
            boolean r7 = r2.zzq     // Catch:{ all -> 0x04d2 }
            if (r7 == 0) goto L_0x0451
            r4.putLong(r0, r5)     // Catch:{ all -> 0x04d2 }
        L_0x0451:
            com.google.android.gms.measurement.internal.zzai r0 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_v"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r4)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zza((com.google.android.gms.measurement.internal.zzai) r0, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
        L_0x0464:
            com.google.android.gms.measurement.internal.zzfn r0 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r0 = r0.zzb()     // Catch:{ all -> 0x04d2 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzbf     // Catch:{ all -> 0x04d2 }
            boolean r0 = r0.zze(r4, r5)     // Catch:{ all -> 0x04d2 }
            if (r0 != 0) goto L_0x04c3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r0.<init>()     // Catch:{ all -> 0x04d2 }
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzfn r3 = r1.zzj     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()     // Catch:{ all -> 0x04d2 }
            java.lang.String r4 = r2.zza     // Catch:{ all -> 0x04d2 }
            boolean r3 = r3.zzr(r4)     // Catch:{ all -> 0x04d2 }
            if (r3 == 0) goto L_0x0493
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04d2 }
        L_0x0493:
            com.google.android.gms.measurement.internal.zzai r3 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_e"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r0)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r3
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zza((com.google.android.gms.measurement.internal.zzai) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
            goto L_0x04c3
        L_0x04a7:
            boolean r0 = r2.zzi     // Catch:{ all -> 0x04d2 }
            if (r0 == 0) goto L_0x04c3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04d2 }
            r0.<init>()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzai r3 = new com.google.android.gms.measurement.internal.zzai     // Catch:{ all -> 0x04d2 }
            java.lang.String r12 = "_cd"
            com.google.android.gms.measurement.internal.zzah r13 = new com.google.android.gms.measurement.internal.zzah     // Catch:{ all -> 0x04d2 }
            r13.<init>(r0)     // Catch:{ all -> 0x04d2 }
            java.lang.String r14 = "auto"
            r11 = r3
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04d2 }
            r1.zza((com.google.android.gms.measurement.internal.zzai) r3, (com.google.android.gms.measurement.internal.zzn) r2)     // Catch:{ all -> 0x04d2 }
        L_0x04c3:
            com.google.android.gms.measurement.internal.zzx r0 = r21.zze()     // Catch:{ all -> 0x04d2 }
            r0.b_()     // Catch:{ all -> 0x04d2 }
            com.google.android.gms.measurement.internal.zzx r0 = r21.zze()
            r0.zzh()
            return
        L_0x04d2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzx r2 = r21.zze()
            r2.zzh()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjp.zzc(com.google.android.gms.measurement.internal.zzn):void");
    }

    @WorkerThread
    private final zzn zza(String str) {
        String str2 = str;
        zzf zzb2 = zze().zzb(str2);
        if (zzb2 == null || TextUtils.isEmpty(zzb2.zzj())) {
            this.zzj.zzr().zzw().zza("No app data available; dropping", str2);
            return null;
        }
        Boolean zzb3 = zzb(zzb2);
        if (zzb3 == null || zzb3.booleanValue()) {
            zzf zzf2 = zzb2;
            return new zzn(str, zzb2.zzd(), zzb2.zzj(), zzb2.zzk(), zzb2.zzl(), zzb2.zzm(), zzb2.zzn(), (String) null, zzb2.zzp(), false, zzb2.zzg(), zzf2.zzac(), 0, 0, zzf2.zzad(), zzf2.zzae(), false, zzf2.zze(), zzf2.zzaf(), zzf2.zzo(), zzf2.zzag());
        }
        this.zzj.zzr().zzf().zza("App version does not match; dropping. appId", zzej.zza(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzq zzq2) {
        zzn zza2 = zza(zzq2.zza);
        if (zza2 != null) {
            zza(zzq2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(zzq zzq2, zzn zzn2) {
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq2.zza);
        Preconditions.checkNotNull(zzq2.zzb);
        Preconditions.checkNotNull(zzq2.zzc);
        Preconditions.checkNotEmpty(zzq2.zzc.zza);
        zzw();
        zzk();
        if (TextUtils.isEmpty(zzn2.zzb) && TextUtils.isEmpty(zzn2.zzr)) {
            return;
        }
        if (!zzn2.zzh) {
            zze(zzn2);
            return;
        }
        zzq zzq3 = new zzq(zzq2);
        boolean z = false;
        zzq3.zze = false;
        zze().zzf();
        try {
            zzq zzd2 = zze().zzd(zzq3.zza, zzq3.zzc.zza);
            if (zzd2 != null && !zzd2.zzb.equals(zzq3.zzb)) {
                this.zzj.zzr().zzi().zza("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.zzj.zzj().zzc(zzq3.zzc.zza), zzq3.zzb, zzd2.zzb);
            }
            if (zzd2 != null && zzd2.zze) {
                zzq3.zzb = zzd2.zzb;
                zzq3.zzd = zzd2.zzd;
                zzq3.zzh = zzd2.zzh;
                zzq3.zzf = zzd2.zzf;
                zzq3.zzi = zzd2.zzi;
                zzq3.zze = zzd2.zze;
                zzq3.zzc = new zzjw(zzq3.zzc.zza, zzd2.zzc.zzb, zzq3.zzc.zza(), zzd2.zzc.zze);
            } else if (TextUtils.isEmpty(zzq3.zzf)) {
                zzq3.zzc = new zzjw(zzq3.zzc.zza, zzq3.zzd, zzq3.zzc.zza(), zzq3.zzc.zze);
                zzq3.zze = true;
                z = true;
            }
            if (zzq3.zze) {
                zzjw zzjw = zzq3.zzc;
                zzjy zzjy = new zzjy(zzq3.zza, zzq3.zzb, zzjw.zza, zzjw.zzb, zzjw.zza());
                if (zze().zza(zzjy)) {
                    this.zzj.zzr().zzw().zza("User property updated immediately", zzq3.zza, this.zzj.zzj().zzc(zzjy.zzc), zzjy.zze);
                } else {
                    this.zzj.zzr().zzf().zza("(2)Too many active user properties, ignoring", zzej.zza(zzq3.zza), this.zzj.zzj().zzc(zzjy.zzc), zzjy.zze);
                }
                if (z && zzq3.zzi != null) {
                    zzb(new zzai(zzq3.zzi, zzq3.zzd), zzn2);
                }
            }
            if (zze().zza(zzq3)) {
                this.zzj.zzr().zzw().zza("Conditional property added", zzq3.zza, this.zzj.zzj().zzc(zzq3.zzc.zza), zzq3.zzc.zza());
            } else {
                this.zzj.zzr().zzf().zza("Too many conditional properties, ignoring", zzej.zza(zzq3.zza), this.zzj.zzj().zzc(zzq3.zzc.zza), zzq3.zzc.zza());
            }
            zze().b_();
        } finally {
            zze().zzh();
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzq zzq2) {
        zzn zza2 = zza(zzq2.zza);
        if (zza2 != null) {
            zzb(zzq2, zza2);
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(zzq zzq2, zzn zzn2) {
        Preconditions.checkNotNull(zzq2);
        Preconditions.checkNotEmpty(zzq2.zza);
        Preconditions.checkNotNull(zzq2.zzc);
        Preconditions.checkNotEmpty(zzq2.zzc.zza);
        zzw();
        zzk();
        if (TextUtils.isEmpty(zzn2.zzb) && TextUtils.isEmpty(zzn2.zzr)) {
            return;
        }
        if (!zzn2.zzh) {
            zze(zzn2);
            return;
        }
        zze().zzf();
        try {
            zze(zzn2);
            zzq zzd2 = zze().zzd(zzq2.zza, zzq2.zzc.zza);
            if (zzd2 != null) {
                this.zzj.zzr().zzw().zza("Removing conditional user property", zzq2.zza, this.zzj.zzj().zzc(zzq2.zzc.zza));
                zze().zze(zzq2.zza, zzq2.zzc.zza);
                if (zzd2.zze) {
                    zze().zzb(zzq2.zza, zzq2.zzc.zza);
                }
                if (zzq2.zzk != null) {
                    Bundle bundle = null;
                    if (zzq2.zzk.zzb != null) {
                        bundle = zzq2.zzk.zzb.zzb();
                    }
                    Bundle bundle2 = bundle;
                    zzb(this.zzj.zzi().zza(zzq2.zza, zzq2.zzk.zza, bundle2, zzd2.zzb, zzq2.zzk.zzd, true, false), zzn2);
                }
            } else {
                this.zzj.zzr().zzi().zza("Conditional user property doesn't exist", zzej.zza(zzq2.zza), this.zzj.zzj().zzc(zzq2.zzc.zza));
            }
            zze().b_();
        } finally {
            zze().zzh();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0144  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0152  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x018e  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zze(com.google.android.gms.measurement.internal.zzn r11) {
        /*
            r10 = this;
            r10.zzw()
            r10.zzk()
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r11)
            java.lang.String r0 = r11.zza
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r0)
            com.google.android.gms.measurement.internal.zzx r0 = r10.zze()
            java.lang.String r1 = r11.zza
            com.google.android.gms.measurement.internal.zzf r0 = r0.zzb(r1)
            com.google.android.gms.measurement.internal.zzfn r1 = r10.zzj
            com.google.android.gms.measurement.internal.zzes r1 = r1.zzc()
            java.lang.String r2 = r11.zza
            java.lang.String r1 = r1.zzb((java.lang.String) r2)
            r2 = 1
            if (r0 != 0) goto L_0x0042
            com.google.android.gms.measurement.internal.zzf r0 = new com.google.android.gms.measurement.internal.zzf
            com.google.android.gms.measurement.internal.zzfn r3 = r10.zzj
            java.lang.String r4 = r11.zza
            r0.<init>(r3, r4)
            com.google.android.gms.measurement.internal.zzfn r3 = r10.zzj
            com.google.android.gms.measurement.internal.zzjx r3 = r3.zzi()
            java.lang.String r3 = r3.zzk()
            r0.zza((java.lang.String) r3)
            r0.zzd((java.lang.String) r1)
        L_0x0040:
            r1 = 1
            goto L_0x005e
        L_0x0042:
            java.lang.String r3 = r0.zzf()
            boolean r3 = r1.equals(r3)
            if (r3 != 0) goto L_0x005d
            r0.zzd((java.lang.String) r1)
            com.google.android.gms.measurement.internal.zzfn r1 = r10.zzj
            com.google.android.gms.measurement.internal.zzjx r1 = r1.zzi()
            java.lang.String r1 = r1.zzk()
            r0.zza((java.lang.String) r1)
            goto L_0x0040
        L_0x005d:
            r1 = 0
        L_0x005e:
            java.lang.String r3 = r11.zzb
            java.lang.String r4 = r0.zzd()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0070
            java.lang.String r1 = r11.zzb
            r0.zzb((java.lang.String) r1)
            r1 = 1
        L_0x0070:
            java.lang.String r3 = r11.zzr
            java.lang.String r4 = r0.zze()
            boolean r3 = android.text.TextUtils.equals(r3, r4)
            if (r3 != 0) goto L_0x0082
            java.lang.String r1 = r11.zzr
            r0.zzc((java.lang.String) r1)
            r1 = 1
        L_0x0082:
            java.lang.String r3 = r11.zzk
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x009c
            java.lang.String r3 = r11.zzk
            java.lang.String r4 = r0.zzg()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x009c
            java.lang.String r1 = r11.zzk
            r0.zze((java.lang.String) r1)
            r1 = 1
        L_0x009c:
            long r3 = r11.zze
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00b4
            long r3 = r11.zze
            long r7 = r0.zzm()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x00b4
            long r3 = r11.zze
            r0.zzd((long) r3)
            r1 = 1
        L_0x00b4:
            java.lang.String r3 = r11.zzc
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00ce
            java.lang.String r3 = r11.zzc
            java.lang.String r4 = r0.zzj()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00ce
            java.lang.String r1 = r11.zzc
            r0.zzf((java.lang.String) r1)
            r1 = 1
        L_0x00ce:
            long r3 = r11.zzj
            long r7 = r0.zzk()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x00de
            long r3 = r11.zzj
            r0.zzc((long) r3)
            r1 = 1
        L_0x00de:
            java.lang.String r3 = r11.zzd
            if (r3 == 0) goto L_0x00f4
            java.lang.String r3 = r11.zzd
            java.lang.String r4 = r0.zzl()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x00f4
            java.lang.String r1 = r11.zzd
            r0.zzg((java.lang.String) r1)
            r1 = 1
        L_0x00f4:
            long r3 = r11.zzf
            long r7 = r0.zzn()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0104
            long r3 = r11.zzf
            r0.zze((long) r3)
            r1 = 1
        L_0x0104:
            boolean r3 = r11.zzh
            boolean r4 = r0.zzp()
            if (r3 == r4) goto L_0x0112
            boolean r1 = r11.zzh
            r0.zza((boolean) r1)
            r1 = 1
        L_0x0112:
            java.lang.String r3 = r11.zzg
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x012c
            java.lang.String r3 = r11.zzg
            java.lang.String r4 = r0.zzaa()
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x012c
            java.lang.String r1 = r11.zzg
            r0.zzh((java.lang.String) r1)
            r1 = 1
        L_0x012c:
            long r3 = r11.zzl
            long r7 = r0.zzac()
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x013c
            long r3 = r11.zzl
            r0.zzp(r3)
            r1 = 1
        L_0x013c:
            boolean r3 = r11.zzo
            boolean r4 = r0.zzad()
            if (r3 == r4) goto L_0x014a
            boolean r1 = r11.zzo
            r0.zzb((boolean) r1)
            r1 = 1
        L_0x014a:
            boolean r3 = r11.zzp
            boolean r4 = r0.zzae()
            if (r3 == r4) goto L_0x0158
            boolean r1 = r11.zzp
            r0.zzc((boolean) r1)
            r1 = 1
        L_0x0158:
            com.google.android.gms.measurement.internal.zzfn r3 = r10.zzj
            com.google.android.gms.measurement.internal.zzs r3 = r3.zzb()
            java.lang.String r4 = r11.zza
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzak.zzbg
            boolean r3 = r3.zze(r4, r7)
            if (r3 == 0) goto L_0x0176
            java.lang.Boolean r3 = r11.zzs
            java.lang.Boolean r4 = r0.zzaf()
            if (r3 == r4) goto L_0x0176
            java.lang.Boolean r1 = r11.zzs
            r0.zza((java.lang.Boolean) r1)
            r1 = 1
        L_0x0176:
            long r3 = r11.zzt
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x018c
            long r3 = r11.zzt
            long r5 = r0.zzo()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x018c
            long r3 = r11.zzt
            r0.zzf((long) r3)
            r1 = 1
        L_0x018c:
            if (r1 == 0) goto L_0x0195
            com.google.android.gms.measurement.internal.zzx r11 = r10.zze()
            r11.zza((com.google.android.gms.measurement.internal.zzf) r0)
        L_0x0195:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjp.zze(com.google.android.gms.measurement.internal.zzn):com.google.android.gms.measurement.internal.zzf");
    }

    /* access modifiers changed from: package-private */
    public final String zzd(zzn zzn2) {
        try {
            return (String) this.zzj.zzq().zza(new zzjs(this, zzn2)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.zzj.zzr().zzf().zza("Failed to get app instance id. appId", zzej.zza(zzn2.zza), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzz();
    }
}
