package com.google.android.gms.internal.clearcut;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.clearcut.zzgw;
import com.google.android.gms.phenotype.Phenotype;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class zzp implements ClearcutLogger.zza {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final zzao zzaq = new zzao(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public")).zzc("gms:playlog:service:samplingrules_").zzd("LogSamplingRules__");
    private static final zzao zzar = new zzao(Phenotype.getContentProviderUri("com.google.android.gms.clearcut.public")).zzc("gms:playlog:service:sampling_").zzd("LogSampling__");
    private static final ConcurrentHashMap<String, zzae<zzgw.zza>> zzas = new ConcurrentHashMap<>();
    private static final HashMap<String, zzae<String>> zzat = new HashMap<>();
    @VisibleForTesting
    private static Boolean zzau = null;
    @VisibleForTesting
    private static Long zzav = null;
    @VisibleForTesting
    private static final zzae<Boolean> zzaw = zzaq.zzc("enable_log_sampling_rules", false);
    private final Context zzh;

    public zzp(Context context) {
        this.zzh = context;
        Context context2 = this.zzh;
        if (context2 != null) {
            zzae.maybeInit(context2);
        }
    }

    @VisibleForTesting
    private static long zza(String str, long j) {
        if (str == null || str.isEmpty()) {
            return zzk.zza(ByteBuffer.allocate(8).putLong(j).array());
        }
        byte[] bytes = str.getBytes(UTF_8);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j);
        return zzk.zza(allocate.array());
    }

    @VisibleForTesting
    private static zzgw.zza.zzb zza(String str) {
        String str2;
        int i;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(44);
        if (indexOf >= 0) {
            str2 = str.substring(0, indexOf);
            i = indexOf + 1;
        } else {
            str2 = "";
            i = 0;
        }
        int indexOf2 = str.indexOf(47, i);
        if (indexOf2 <= 0) {
            String valueOf = String.valueOf(str);
            Log.e("LogSamplerImpl", valueOf.length() != 0 ? "Failed to parse the rule: ".concat(valueOf) : new String("Failed to parse the rule: "));
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return (zzgw.zza.zzb) zzgw.zza.zzb.zzfz().zzn(str2).zzr(parseLong).zzs(parseLong2).zzbh();
            }
            StringBuilder sb = new StringBuilder(72);
            sb.append("negative values not supported: ");
            sb.append(parseLong);
            sb.append("/");
            sb.append(parseLong2);
            Log.e("LogSamplerImpl", sb.toString());
            return null;
        } catch (NumberFormatException e) {
            String valueOf2 = String.valueOf(str);
            Log.e("LogSamplerImpl", valueOf2.length() != 0 ? "parseLong() failed while parsing: ".concat(valueOf2) : new String("parseLong() failed while parsing: "), e);
            return null;
        }
    }

    @VisibleForTesting
    private static boolean zzb(long j, long j2, long j3) {
        if (j2 < 0 || j3 <= 0) {
            return true;
        }
        return ((j > 0 ? 1 : (j == 0 ? 0 : -1)) >= 0 ? j % j3 : (((Long.MAX_VALUE % j3) + 1) + ((j & Long.MAX_VALUE) % j3)) % j3) < j2;
    }

    private static boolean zzc(Context context) {
        if (zzau == null) {
            zzau = Boolean.valueOf(Wrappers.packageManager(context).checkCallingOrSelfPermission("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return zzau.booleanValue();
    }

    @VisibleForTesting
    private static long zzd(Context context) {
        if (zzav == null) {
            long j = 0;
            if (context == null) {
                return 0;
            }
            if (zzc(context)) {
                j = zzy.getLong(context.getContentResolver(), "android_id", 0);
            }
            zzav = Long.valueOf(j);
        }
        return zzav.longValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a3, code lost:
        r1 = zzaq.zza(r0, com.google.android.gms.internal.clearcut.zzgw.zza.zzft(), com.google.android.gms.internal.clearcut.zzq.zzax);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.clearcut.zze r13) {
        /*
            r12 = this;
            com.google.android.gms.internal.clearcut.zzr r0 = r13.zzag
            java.lang.String r0 = r0.zzj
            com.google.android.gms.internal.clearcut.zzr r1 = r13.zzag
            int r1 = r1.zzk
            com.google.android.gms.internal.clearcut.zzha r2 = r13.zzaa
            r3 = 0
            if (r2 == 0) goto L_0x0012
            com.google.android.gms.internal.clearcut.zzha r13 = r13.zzaa
            int r13 = r13.zzbji
            goto L_0x0013
        L_0x0012:
            r13 = 0
        L_0x0013:
            com.google.android.gms.internal.clearcut.zzae<java.lang.Boolean> r2 = zzaw
            java.lang.Object r2 = r2.get()
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            r4 = 0
            if (r2 != 0) goto L_0x007d
            if (r0 == 0) goto L_0x002b
            boolean r13 = r0.isEmpty()
            if (r13 != 0) goto L_0x002b
            goto L_0x0033
        L_0x002b:
            if (r1 < 0) goto L_0x0032
            java.lang.String r0 = java.lang.String.valueOf(r1)
            goto L_0x0033
        L_0x0032:
            r0 = r4
        L_0x0033:
            if (r0 == 0) goto L_0x0103
            android.content.Context r13 = r12.zzh
            if (r13 == 0) goto L_0x005c
            boolean r13 = zzc(r13)
            if (r13 != 0) goto L_0x0040
            goto L_0x005c
        L_0x0040:
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.clearcut.zzae<java.lang.String>> r13 = zzat
            java.lang.Object r13 = r13.get(r0)
            com.google.android.gms.internal.clearcut.zzae r13 = (com.google.android.gms.internal.clearcut.zzae) r13
            if (r13 != 0) goto L_0x0055
            com.google.android.gms.internal.clearcut.zzao r13 = zzar
            com.google.android.gms.internal.clearcut.zzae r13 = r13.zza(r0, r4)
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.clearcut.zzae<java.lang.String>> r1 = zzat
            r1.put(r0, r13)
        L_0x0055:
            java.lang.Object r13 = r13.get()
            r4 = r13
            java.lang.String r4 = (java.lang.String) r4
        L_0x005c:
            com.google.android.gms.internal.clearcut.zzgw$zza$zzb r13 = zza((java.lang.String) r4)
            if (r13 == 0) goto L_0x0103
            java.lang.String r0 = r13.zzfw()
            android.content.Context r1 = r12.zzh
            long r1 = zzd(r1)
            long r3 = zza(r0, r1)
            long r5 = r13.zzfx()
            long r7 = r13.zzfy()
            boolean r13 = zzb(r3, r5, r7)
            return r13
        L_0x007d:
            if (r0 == 0) goto L_0x0086
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0086
            goto L_0x008e
        L_0x0086:
            if (r1 < 0) goto L_0x008d
            java.lang.String r0 = java.lang.String.valueOf(r1)
            goto L_0x008e
        L_0x008d:
            r0 = r4
        L_0x008e:
            if (r0 == 0) goto L_0x0103
            android.content.Context r1 = r12.zzh
            if (r1 != 0) goto L_0x0099
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00c4
        L_0x0099:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.google.android.gms.internal.clearcut.zzae<com.google.android.gms.internal.clearcut.zzgw$zza>> r1 = zzas
            java.lang.Object r1 = r1.get(r0)
            com.google.android.gms.internal.clearcut.zzae r1 = (com.google.android.gms.internal.clearcut.zzae) r1
            if (r1 != 0) goto L_0x00ba
            com.google.android.gms.internal.clearcut.zzao r1 = zzaq
            com.google.android.gms.internal.clearcut.zzgw$zza r2 = com.google.android.gms.internal.clearcut.zzgw.zza.zzft()
            com.google.android.gms.internal.clearcut.zzan r4 = com.google.android.gms.internal.clearcut.zzq.zzax
            com.google.android.gms.internal.clearcut.zzae r1 = r1.zza(r0, r2, r4)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.google.android.gms.internal.clearcut.zzae<com.google.android.gms.internal.clearcut.zzgw$zza>> r2 = zzas
            java.lang.Object r0 = r2.putIfAbsent(r0, r1)
            com.google.android.gms.internal.clearcut.zzae r0 = (com.google.android.gms.internal.clearcut.zzae) r0
            if (r0 == 0) goto L_0x00ba
            r1 = r0
        L_0x00ba:
            java.lang.Object r0 = r1.get()
            com.google.android.gms.internal.clearcut.zzgw$zza r0 = (com.google.android.gms.internal.clearcut.zzgw.zza) r0
            java.util.List r0 = r0.zzfs()
        L_0x00c4:
            java.util.Iterator r0 = r0.iterator()
        L_0x00c8:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0103
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.clearcut.zzgw$zza$zzb r1 = (com.google.android.gms.internal.clearcut.zzgw.zza.zzb) r1
            boolean r2 = r1.zzfv()
            if (r2 == 0) goto L_0x00e6
            int r2 = r1.getEventCode()
            if (r2 == 0) goto L_0x00e6
            int r2 = r1.getEventCode()
            if (r2 != r13) goto L_0x00c8
        L_0x00e6:
            java.lang.String r2 = r1.zzfw()
            android.content.Context r4 = r12.zzh
            long r4 = zzd(r4)
            long r6 = zza(r2, r4)
            long r8 = r1.zzfx()
            long r10 = r1.zzfy()
            boolean r1 = zzb(r6, r8, r10)
            if (r1 != 0) goto L_0x00c8
            return r3
        L_0x0103:
            r13 = 1
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzp.zza(com.google.android.gms.clearcut.zze):boolean");
    }
}
