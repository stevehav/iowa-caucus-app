package com.google.android.gms.measurement.internal;

import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzp extends zzjm {
    zzp(zzjp zzjp) {
        super(zzjp);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v23, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v1, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r20v6, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r23v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v25, resolved type: java.lang.Long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v11, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v13, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v14, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v15, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v16, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v21, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v22, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r18v13, resolved type: androidx.collection.ArrayMap} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v92, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v70, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r41v5, resolved type: java.util.ArrayList} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:419:0x0dba, code lost:
        if (r8.zza() == false) goto L_0x0dc5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:420:0x0dbc, code lost:
        r15 = java.lang.Integer.valueOf(r8.zzb());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:421:0x0dc5, code lost:
        r15 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:422:0x0dc6, code lost:
        r0.zza("Invalid property filter ID. appId, id", r1, java.lang.String.valueOf(r15));
        r13.add(java.lang.Integer.valueOf(r11));
        r5 = r73;
        r6 = r74;
        r1 = r10;
        r9 = r17;
        r8 = r18;
        r4 = r21;
        r68 = r22;
        r0 = r26;
        r14 = r43;
        r42 = r44;
        r67 = r46;
        r69 = r48;
        r10 = r72;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x03d8  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x04b4  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x04d1  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04d8  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x050c  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x057a  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0601  */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0692  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x06b3  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x07a8  */
    /* JADX WARNING: Removed duplicated region for block: B:303:0x0a54  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00e9 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x0bae  */
    /* JADX WARNING: Removed duplicated region for block: B:427:0x0e3f  */
    /* JADX WARNING: Removed duplicated region for block: B:431:0x0e5c  */
    /* JADX WARNING: Removed duplicated region for block: B:562:0x0df1 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01eb  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.internal.measurement.zzbr.zza> zza(java.lang.String r72, java.util.List<com.google.android.gms.internal.measurement.zzbr.zzc> r73, java.util.List<com.google.android.gms.internal.measurement.zzbr.zzk> r74, java.lang.Long r75) {
        /*
            r71 = this;
            r7 = r71
            r9 = r72
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r72)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r73)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r74)
            java.util.HashSet r15 = new java.util.HashSet
            r15.<init>()
            androidx.collection.ArrayMap r13 = new androidx.collection.ArrayMap
            r13.<init>()
            androidx.collection.ArrayMap r14 = new androidx.collection.ArrayMap
            r14.<init>()
            androidx.collection.ArrayMap r11 = new androidx.collection.ArrayMap
            r11.<init>()
            androidx.collection.ArrayMap r12 = new androidx.collection.ArrayMap
            r12.<init>()
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap
            r10.<init>()
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zzbu
            boolean r0 = r0.zzd(r9, r1)
            r8 = 1
            r6 = 0
            if (r0 != 0) goto L_0x0045
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zzbv
            boolean r0 = r0.zzd(r9, r1)
            if (r0 == 0) goto L_0x0064
        L_0x0045:
            java.util.Iterator r0 = r73.iterator()
        L_0x0049:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.measurement.zzbr$zzc r1 = (com.google.android.gms.internal.measurement.zzbr.zzc) r1
            java.lang.String r1 = r1.zzc()
            java.lang.String r2 = "_s"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0049
            r25 = 1
            goto L_0x0066
        L_0x0064:
            r25 = 0
        L_0x0066:
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            boolean r1 = r0.zzi(r9)
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzbu
            boolean r2 = r0.zzd(r9, r2)
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzak.zzbv
            boolean r0 = r0.zzd(r9, r3)
            if (r25 == 0) goto L_0x00cc
            if (r0 == 0) goto L_0x00cc
            com.google.android.gms.measurement.internal.zzx r3 = r71.zzi()
            r3.zzak()
            r3.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r72)
            android.content.ContentValues r0 = new android.content.ContentValues
            r0.<init>()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)
            java.lang.String r5 = "current_session_count"
            r0.put(r5, r4)
            android.database.sqlite.SQLiteDatabase r4 = r3.c_()     // Catch:{ SQLiteException -> 0x00b7 }
            java.lang.String r5 = "events"
            java.lang.String r6 = "app_id = ?"
            r17 = r15
            java.lang.String[] r15 = new java.lang.String[r8]     // Catch:{ SQLiteException -> 0x00b5 }
            r16 = 0
            r15[r16] = r9     // Catch:{ SQLiteException -> 0x00b5 }
            r4.update(r5, r0, r6, r15)     // Catch:{ SQLiteException -> 0x00b5 }
            goto L_0x00ce
        L_0x00b5:
            r0 = move-exception
            goto L_0x00ba
        L_0x00b7:
            r0 = move-exception
            r17 = r15
        L_0x00ba:
            com.google.android.gms.measurement.internal.zzej r3 = r3.zzr()
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r72)
            java.lang.String r5 = "Error resetting session-scoped event counts. appId"
            r3.zza(r5, r4, r0)
            goto L_0x00ce
        L_0x00cc:
            r17 = r15
        L_0x00ce:
            com.google.android.gms.measurement.internal.zzx r0 = r71.zzi()
            java.util.Map r0 = r0.zzf(r9)
            if (r0 == 0) goto L_0x035d
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L_0x035d
            java.util.HashSet r3 = new java.util.HashSet
            java.util.Set r4 = r0.keySet()
            r3.<init>(r4)
            if (r2 == 0) goto L_0x01e0
            if (r25 == 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.zzp r4 = r71.e_()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r72)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
            boolean r6 = r0.isEmpty()
            if (r6 != 0) goto L_0x01e1
            com.google.android.gms.measurement.internal.zzx r6 = r4.zzi()
            java.util.Map r6 = r6.zze(r9)
            java.util.Set r18 = r0.keySet()
            java.util.Iterator r18 = r18.iterator()
        L_0x0110:
            boolean r19 = r18.hasNext()
            if (r19 == 0) goto L_0x01e1
            java.lang.Object r19 = r18.next()
            java.lang.Integer r19 = (java.lang.Integer) r19
            int r19 = r19.intValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r19)
            java.lang.Object r15 = r0.get(r15)
            com.google.android.gms.internal.measurement.zzbr$zzi r15 = (com.google.android.gms.internal.measurement.zzbr.zzi) r15
            java.lang.Integer r8 = java.lang.Integer.valueOf(r19)
            java.lang.Object r8 = r6.get(r8)
            java.util.List r8 = (java.util.List) r8
            if (r8 == 0) goto L_0x01cc
            boolean r22 = r8.isEmpty()
            if (r22 == 0) goto L_0x013e
            goto L_0x01cc
        L_0x013e:
            r22 = r6
            com.google.android.gms.measurement.internal.zzjt r6 = r4.zzg()
            java.util.List r7 = r15.zzc()
            java.util.List r6 = r6.zza((java.util.List<java.lang.Long>) r7, (java.util.List<java.lang.Integer>) r8)
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x01c5
            com.google.android.gms.internal.measurement.zzfd$zza r7 = r15.zzbk()
            com.google.android.gms.internal.measurement.zzfd$zza r7 = (com.google.android.gms.internal.measurement.zzfd.zza) r7
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r7 = (com.google.android.gms.internal.measurement.zzbr.zzi.zza) r7
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r7 = r7.zzb()
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r6 = r7.zzb((java.lang.Iterable<? extends java.lang.Long>) r6)
            com.google.android.gms.measurement.internal.zzjt r7 = r4.zzg()
            r23 = r4
            java.util.List r4 = r15.zza()
            java.util.List r4 = r7.zza((java.util.List<java.lang.Long>) r4, (java.util.List<java.lang.Integer>) r8)
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r7 = r6.zza()
            r7.zza((java.lang.Iterable<? extends java.lang.Long>) r4)
            r4 = 0
        L_0x0178:
            int r7 = r15.zzf()
            if (r4 >= r7) goto L_0x0196
            com.google.android.gms.internal.measurement.zzbr$zzb r7 = r15.zza((int) r4)
            int r7 = r7.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L_0x0193
            r6.zza((int) r4)
        L_0x0193:
            int r4 = r4 + 1
            goto L_0x0178
        L_0x0196:
            r4 = 0
        L_0x0197:
            int r7 = r15.zzh()
            if (r4 >= r7) goto L_0x01b5
            com.google.android.gms.internal.measurement.zzbr$zzj r7 = r15.zzb((int) r4)
            int r7 = r7.zzb()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r7 = r8.contains(r7)
            if (r7 == 0) goto L_0x01b2
            r6.zzb((int) r4)
        L_0x01b2:
            int r4 = r4 + 1
            goto L_0x0197
        L_0x01b5:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            com.google.android.gms.internal.measurement.zzgn r6 = r6.zzu()
            com.google.android.gms.internal.measurement.zzfd r6 = (com.google.android.gms.internal.measurement.zzfd) r6
            com.google.android.gms.internal.measurement.zzbr$zzi r6 = (com.google.android.gms.internal.measurement.zzbr.zzi) r6
            r5.put(r4, r6)
            goto L_0x01d7
        L_0x01c5:
            r8 = 1
            r7 = r71
            r6 = r22
            goto L_0x0110
        L_0x01cc:
            r23 = r4
            r22 = r6
            java.lang.Integer r4 = java.lang.Integer.valueOf(r19)
            r5.put(r4, r15)
        L_0x01d7:
            r7 = r71
            r6 = r22
            r4 = r23
            r8 = 1
            goto L_0x0110
        L_0x01e0:
            r5 = r0
        L_0x01e1:
            java.util.Iterator r3 = r3.iterator()
        L_0x01e5:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x035d
            java.lang.Object r4 = r3.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            java.lang.Object r6 = r5.get(r6)
            com.google.android.gms.internal.measurement.zzbr$zzi r6 = (com.google.android.gms.internal.measurement.zzbr.zzi) r6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)
            java.lang.Object r7 = r14.get(r7)
            java.util.BitSet r7 = (java.util.BitSet) r7
            java.lang.Integer r8 = java.lang.Integer.valueOf(r4)
            java.lang.Object r8 = r11.get(r8)
            java.util.BitSet r8 = (java.util.BitSet) r8
            if (r1 == 0) goto L_0x0278
            androidx.collection.ArrayMap r15 = new androidx.collection.ArrayMap
            r15.<init>()
            if (r6 == 0) goto L_0x026c
            int r18 = r6.zzf()
            if (r18 != 0) goto L_0x0223
            goto L_0x026c
        L_0x0223:
            java.util.List r18 = r6.zze()
            java.util.Iterator r18 = r18.iterator()
        L_0x022b:
            boolean r19 = r18.hasNext()
            if (r19 == 0) goto L_0x026c
            java.lang.Object r19 = r18.next()
            com.google.android.gms.internal.measurement.zzbr$zzb r19 = (com.google.android.gms.internal.measurement.zzbr.zzb) r19
            boolean r22 = r19.zza()
            if (r22 == 0) goto L_0x0263
            int r22 = r19.zzb()
            r23 = r3
            java.lang.Integer r3 = java.lang.Integer.valueOf(r22)
            boolean r22 = r19.zzc()
            if (r22 == 0) goto L_0x025c
            long r26 = r19.zzd()
            java.lang.Long r19 = java.lang.Long.valueOf(r26)
            r70 = r19
            r19 = r5
            r5 = r70
            goto L_0x025f
        L_0x025c:
            r19 = r5
            r5 = 0
        L_0x025f:
            r15.put(r3, r5)
            goto L_0x0267
        L_0x0263:
            r23 = r3
            r19 = r5
        L_0x0267:
            r5 = r19
            r3 = r23
            goto L_0x022b
        L_0x026c:
            r23 = r3
            r19 = r5
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r12.put(r3, r15)
            goto L_0x027d
        L_0x0278:
            r23 = r3
            r19 = r5
            r15 = 0
        L_0x027d:
            if (r7 != 0) goto L_0x0297
            java.util.BitSet r7 = new java.util.BitSet
            r7.<init>()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r14.put(r3, r7)
            java.util.BitSet r8 = new java.util.BitSet
            r8.<init>()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            r11.put(r3, r8)
        L_0x0297:
            if (r6 == 0) goto L_0x02f4
            r3 = 0
        L_0x029a:
            int r5 = r6.zzb()
            int r5 = r5 << 6
            if (r3 >= r5) goto L_0x02f4
            java.util.List r5 = r6.zza()
            boolean r5 = com.google.android.gms.measurement.internal.zzjt.zza((java.util.List<java.lang.Long>) r5, (int) r3)
            if (r5 == 0) goto L_0x02d9
            com.google.android.gms.measurement.internal.zzej r5 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzx()
            r18 = r11
            java.lang.Integer r11 = java.lang.Integer.valueOf(r4)
            r22 = r12
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
            r24 = r14
            java.lang.String r14 = "Filter already evaluated. audience ID, filter ID"
            r5.zza(r14, r11, r12)
            r8.set(r3)
            java.util.List r5 = r6.zzc()
            boolean r5 = com.google.android.gms.measurement.internal.zzjt.zza((java.util.List<java.lang.Long>) r5, (int) r3)
            if (r5 == 0) goto L_0x02df
            r7.set(r3)
            r5 = 1
            goto L_0x02e0
        L_0x02d9:
            r18 = r11
            r22 = r12
            r24 = r14
        L_0x02df:
            r5 = 0
        L_0x02e0:
            if (r15 == 0) goto L_0x02eb
            if (r5 != 0) goto L_0x02eb
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            r15.remove(r5)
        L_0x02eb:
            int r3 = r3 + 1
            r11 = r18
            r12 = r22
            r14 = r24
            goto L_0x029a
        L_0x02f4:
            r18 = r11
            r22 = r12
            r24 = r14
            com.google.android.gms.internal.measurement.zzbr$zza$zza r3 = com.google.android.gms.internal.measurement.zzbr.zza.zzh()
            r5 = 0
            com.google.android.gms.internal.measurement.zzbr$zza$zza r3 = r3.zza((boolean) r5)
            if (r2 == 0) goto L_0x0313
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
            java.lang.Object r5 = r0.get(r5)
            com.google.android.gms.internal.measurement.zzbr$zzi r5 = (com.google.android.gms.internal.measurement.zzbr.zzi) r5
            r3.zza((com.google.android.gms.internal.measurement.zzbr.zzi) r5)
            goto L_0x0316
        L_0x0313:
            r3.zza((com.google.android.gms.internal.measurement.zzbr.zzi) r6)
        L_0x0316:
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r5 = com.google.android.gms.internal.measurement.zzbr.zzi.zzi()
            java.util.List r6 = com.google.android.gms.measurement.internal.zzjt.zza((java.util.BitSet) r7)
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r5 = r5.zzb((java.lang.Iterable<? extends java.lang.Long>) r6)
            java.util.List r6 = com.google.android.gms.measurement.internal.zzjt.zza((java.util.BitSet) r8)
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r5 = r5.zza((java.lang.Iterable<? extends java.lang.Long>) r6)
            if (r1 == 0) goto L_0x033f
            java.util.List r6 = zza(r15)
            r5.zzc(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r4)
            androidx.collection.ArrayMap r7 = new androidx.collection.ArrayMap
            r7.<init>()
            r10.put(r6, r7)
        L_0x033f:
            r3.zza((com.google.android.gms.internal.measurement.zzbr.zzi.zza) r5)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            com.google.android.gms.internal.measurement.zzgn r3 = r3.zzu()
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3
            com.google.android.gms.internal.measurement.zzbr$zza r3 = (com.google.android.gms.internal.measurement.zzbr.zza) r3
            r13.put(r4, r3)
            r11 = r18
            r5 = r19
            r12 = r22
            r3 = r23
            r14 = r24
            goto L_0x01e5
        L_0x035d:
            r18 = r11
            r22 = r12
            r24 = r14
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            boolean r7 = r0.zzi(r9)
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zzbu
            boolean r26 = r0.zzd(r9, r1)
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zzbv
            boolean r27 = r0.zzd(r9, r1)
            boolean r0 = r73.isEmpty()
            java.lang.String r15 = "Filter definition"
            java.lang.String r12 = "Skipping failed audience ID"
            java.lang.String r28 = "null"
            if (r0 != 0) goto L_0x0a15
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
            java.util.Iterator r29 = r73.iterator()
            r30 = 0
            r2 = r30
            r0 = 0
            r1 = 0
        L_0x039a:
            boolean r4 = r29.hasNext()
            if (r4 == 0) goto L_0x0a15
            java.lang.Object r4 = r29.next()
            r6 = r4
            com.google.android.gms.internal.measurement.zzbr$zzc r6 = (com.google.android.gms.internal.measurement.zzbr.zzc) r6
            java.lang.String r4 = r6.zzc()
            java.util.List r5 = r6.zza()
            r71.zzg()
            java.lang.String r11 = "_eid"
            java.lang.Object r23 = com.google.android.gms.measurement.internal.zzjt.zzb(r6, r11)
            r14 = r23
            java.lang.Long r14 = (java.lang.Long) r14
            if (r14 == 0) goto L_0x03c1
            r23 = 1
            goto L_0x03c3
        L_0x03c1:
            r23 = 0
        L_0x03c3:
            if (r23 == 0) goto L_0x03d1
            r33 = r2
            java.lang.String r2 = "_ep"
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L_0x03d3
            r2 = 1
            goto L_0x03d4
        L_0x03d1:
            r33 = r2
        L_0x03d3:
            r2 = 0
        L_0x03d4:
            r35 = 1
            if (r2 == 0) goto L_0x050c
            r71.zzg()
            java.lang.String r2 = "_en"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzjt.zzb(r6, r2)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            boolean r2 = android.text.TextUtils.isEmpty(r4)
            if (r2 == 0) goto L_0x03ff
            com.google.android.gms.measurement.internal.zzej r2 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()
            java.lang.String r3 = "Extra parameter without an event name. eventId"
            r2.zza(r3, r14)
            r37 = r8
            r38 = r15
            r21 = 1
            goto L_0x0504
        L_0x03ff:
            if (r0 == 0) goto L_0x0414
            if (r1 == 0) goto L_0x0414
            long r2 = r14.longValue()
            long r37 = r1.longValue()
            int r23 = (r2 > r37 ? 1 : (r2 == r37 ? 0 : -1))
            if (r23 == 0) goto L_0x0410
            goto L_0x0414
        L_0x0410:
            r11 = r0
            r23 = r1
            goto L_0x043e
        L_0x0414:
            com.google.android.gms.measurement.internal.zzx r2 = r71.zzi()
            android.util.Pair r2 = r2.zza((java.lang.String) r9, (java.lang.Long) r14)
            if (r2 == 0) goto L_0x04f0
            java.lang.Object r3 = r2.first
            if (r3 != 0) goto L_0x0424
            goto L_0x04f0
        L_0x0424:
            java.lang.Object r0 = r2.first
            com.google.android.gms.internal.measurement.zzbr$zzc r0 = (com.google.android.gms.internal.measurement.zzbr.zzc) r0
            java.lang.Object r1 = r2.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r2 = r1.longValue()
            r71.zzg()
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzjt.zzb(r0, r11)
            java.lang.Long r1 = (java.lang.Long) r1
            r11 = r0
            r23 = r1
            r33 = r2
        L_0x043e:
            long r33 = r33 - r35
            int r0 = (r33 > r30 ? 1 : (r33 == r30 ? 0 : -1))
            if (r0 > 0) goto L_0x0488
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzi()
            r1.zzd()
            com.google.android.gms.measurement.internal.zzej r0 = r1.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzx()
            java.lang.String r2 = "Clearing complex main event info. appId"
            r0.zza(r2, r9)
            android.database.sqlite.SQLiteDatabase r0 = r1.c_()     // Catch:{ SQLiteException -> 0x046d }
            java.lang.String r2 = "delete from main_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x046b }
            r16 = 0
            r14[r16] = r9     // Catch:{ SQLiteException -> 0x0469 }
            r0.execSQL(r2, r14)     // Catch:{ SQLiteException -> 0x0469 }
            goto L_0x047e
        L_0x0469:
            r0 = move-exception
            goto L_0x0471
        L_0x046b:
            r0 = move-exception
            goto L_0x046f
        L_0x046d:
            r0 = move-exception
            r3 = 1
        L_0x046f:
            r16 = 0
        L_0x0471:
            com.google.android.gms.measurement.internal.zzej r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()
            java.lang.String r2 = "Error clearing complex main event"
            r1.zza(r2, r0)
        L_0x047e:
            r14 = r5
            r37 = r8
            r38 = r15
            r21 = 1
            r8 = r4
            r15 = r6
            goto L_0x04a1
        L_0x0488:
            r3 = 1
            r16 = 0
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzi()
            r2 = r72
            r21 = 1
            r3 = r14
            r14 = r5
            r37 = r8
            r8 = r4
            r4 = r33
            r38 = r15
            r15 = r6
            r6 = r11
            r1.zza(r2, r3, r4, r6)
        L_0x04a1:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r1 = r11.zza()
            java.util.Iterator r1 = r1.iterator()
        L_0x04ae:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x04cb
            java.lang.Object r2 = r1.next()
            com.google.android.gms.internal.measurement.zzbr$zze r2 = (com.google.android.gms.internal.measurement.zzbr.zze) r2
            r71.zzg()
            java.lang.String r3 = r2.zza()
            com.google.android.gms.internal.measurement.zzbr$zze r3 = com.google.android.gms.measurement.internal.zzjt.zza((com.google.android.gms.internal.measurement.zzbr.zzc) r15, (java.lang.String) r3)
            if (r3 != 0) goto L_0x04ae
            r0.add(r2)
            goto L_0x04ae
        L_0x04cb:
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x04d8
            r0.addAll(r14)
            r41 = r0
            r0 = r8
            goto L_0x04e8
        L_0x04d8:
            com.google.android.gms.measurement.internal.zzej r0 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzi()
            java.lang.String r1 = "No unique parameters in main event. eventName"
            r0.zza(r1, r8)
            r0 = r8
            r41 = r14
        L_0x04e8:
            r39 = r33
            r33 = r11
            r34 = r23
            goto L_0x0562
        L_0x04f0:
            r37 = r8
            r38 = r15
            r21 = 1
            r8 = r4
            com.google.android.gms.measurement.internal.zzej r2 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()
            java.lang.String r3 = "Extra parameter without existing main event. eventName, eventId"
            r2.zza(r3, r8, r14)
        L_0x0504:
            r2 = r33
            r8 = r37
            r15 = r38
            goto L_0x039a
        L_0x050c:
            r37 = r8
            r38 = r15
            r21 = 1
            r8 = r5
            r15 = r6
            if (r23 == 0) goto L_0x0558
            r71.zzg()
            java.lang.Long r0 = java.lang.Long.valueOf(r30)
            java.lang.String r1 = "_epc"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzjt.zzb(r15, r1)
            if (r1 != 0) goto L_0x0526
            goto L_0x0527
        L_0x0526:
            r0 = r1
        L_0x0527:
            java.lang.Long r0 = (java.lang.Long) r0
            long r33 = r0.longValue()
            int r0 = (r33 > r30 ? 1 : (r33 == r30 ? 0 : -1))
            if (r0 > 0) goto L_0x0540
            com.google.android.gms.measurement.internal.zzej r0 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzi()
            java.lang.String r1 = "Complex event with zero extra param count. eventName"
            r0.zza(r1, r4)
            r11 = r4
            goto L_0x054e
        L_0x0540:
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzi()
            r2 = r72
            r3 = r14
            r11 = r4
            r4 = r33
            r6 = r15
            r1.zza(r2, r3, r4, r6)
        L_0x054e:
            r41 = r8
            r0 = r11
            r39 = r33
            r34 = r14
            r33 = r15
            goto L_0x0562
        L_0x0558:
            r11 = r4
            r41 = r8
            r39 = r33
            r33 = r0
            r34 = r1
            r0 = r11
        L_0x0562:
            com.google.android.gms.measurement.internal.zzs r1 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzak.zzbv
            boolean r1 = r1.zzd(r9, r2)
            com.google.android.gms.measurement.internal.zzx r2 = r71.zzi()
            java.lang.String r3 = r15.zzc()
            com.google.android.gms.measurement.internal.zzae r2 = r2.zza((java.lang.String) r9, (java.lang.String) r3)
            if (r2 != 0) goto L_0x0601
            com.google.android.gms.measurement.internal.zzej r2 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzi()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r72)
            com.google.android.gms.measurement.internal.zzeh r4 = r71.zzo()
            java.lang.String r4 = r4.zza((java.lang.String) r0)
            java.lang.String r5 = "Event aggregate wasn't created during raw event logging. appId, event"
            r2.zza(r5, r3, r4)
            if (r1 == 0) goto L_0x05ce
            com.google.android.gms.measurement.internal.zzae r1 = new com.google.android.gms.measurement.internal.zzae
            r5 = r37
            r6 = 1
            r8 = r1
            java.lang.String r2 = r15.zzc()
            r4 = r10
            r10 = r2
            r2 = 1
            r43 = r12
            r14 = r18
            r6 = r22
            r11 = r2
            r44 = r13
            r46 = r14
            r45 = r24
            r13 = r2
            r32 = r15
            r47 = r17
            r48 = r38
            r15 = r2
            long r17 = r32.zze()
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r3 = r9
            r9 = r72
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r21, r22, r23, r24)
            goto L_0x064a
        L_0x05ce:
            r3 = r9
            r4 = r10
            r43 = r12
            r44 = r13
            r32 = r15
            r47 = r17
            r46 = r18
            r6 = r22
            r45 = r24
            r5 = r37
            r48 = r38
            com.google.android.gms.measurement.internal.zzae r1 = new com.google.android.gms.measurement.internal.zzae
            java.lang.String r10 = r32.zzc()
            r11 = 1
            r13 = 1
            long r15 = r32.zze()
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r8 = r1
            r9 = r72
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r20, r21, r22)
            goto L_0x064a
        L_0x0601:
            r3 = r9
            r4 = r10
            r43 = r12
            r44 = r13
            r32 = r15
            r47 = r17
            r46 = r18
            r6 = r22
            r45 = r24
            r5 = r37
            r48 = r38
            if (r1 == 0) goto L_0x064f
            com.google.android.gms.measurement.internal.zzae r1 = new com.google.android.gms.measurement.internal.zzae
            r49 = r1
            java.lang.String r8 = r2.zza
            r50 = r8
            java.lang.String r8 = r2.zzb
            r51 = r8
            long r8 = r2.zzc
            long r52 = r8 + r35
            long r8 = r2.zzd
            long r54 = r8 + r35
            long r8 = r2.zze
            long r56 = r8 + r35
            long r8 = r2.zzf
            r58 = r8
            long r8 = r2.zzg
            r60 = r8
            java.lang.Long r8 = r2.zzh
            r62 = r8
            java.lang.Long r8 = r2.zzi
            r63 = r8
            java.lang.Long r8 = r2.zzj
            r64 = r8
            java.lang.Boolean r2 = r2.zzk
            r65 = r2
            r49.<init>(r50, r51, r52, r54, r56, r58, r60, r62, r63, r64, r65)
        L_0x064a:
            r36 = r6
            r35 = r7
            goto L_0x0680
        L_0x064f:
            com.google.android.gms.measurement.internal.zzae r1 = new com.google.android.gms.measurement.internal.zzae
            r8 = r1
            java.lang.String r9 = r2.zza
            java.lang.String r10 = r2.zzb
            long r11 = r2.zzc
            long r11 = r11 + r35
            long r13 = r2.zzd
            long r13 = r13 + r35
            r36 = r6
            r35 = r7
            long r6 = r2.zze
            r15 = r6
            long r6 = r2.zzf
            r17 = r6
            long r6 = r2.zzg
            r19 = r6
            java.lang.Long r6 = r2.zzh
            r21 = r6
            java.lang.Long r6 = r2.zzi
            r22 = r6
            java.lang.Long r6 = r2.zzj
            r23 = r6
            java.lang.Boolean r2 = r2.zzk
            r24 = r2
            r8.<init>(r9, r10, r11, r13, r15, r17, r19, r21, r22, r23, r24)
        L_0x0680:
            r7 = r1
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzi()
            r1.zza((com.google.android.gms.measurement.internal.zzae) r7)
            long r8 = r7.zzc
            java.lang.Object r1 = r5.get(r0)
            java.util.Map r1 = (java.util.Map) r1
            if (r1 != 0) goto L_0x06a4
            com.google.android.gms.measurement.internal.zzx r1 = r71.zzi()
            java.util.Map r1 = r1.zzf(r3, r0)
            if (r1 != 0) goto L_0x06a1
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
        L_0x06a1:
            r5.put(r0, r1)
        L_0x06a4:
            r10 = r1
            java.util.Set r1 = r10.keySet()
            java.util.Iterator r11 = r1.iterator()
        L_0x06ad:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x09fa
            java.lang.Object r1 = r11.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r12 = r1.intValue()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r13 = r47
            boolean r1 = r13.contains(r1)
            if (r1 == 0) goto L_0x06dd
            com.google.android.gms.measurement.internal.zzej r1 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            r14 = r43
            r1.zza(r14, r2)
            r47 = r13
            goto L_0x06ad
        L_0x06dd:
            r14 = r43
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r15 = r45
            java.lang.Object r1 = r15.get(r1)
            java.util.BitSet r1 = (java.util.BitSet) r1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            r6 = r46
            java.lang.Object r2 = r6.get(r2)
            java.util.BitSet r2 = (java.util.BitSet) r2
            if (r35 == 0) goto L_0x0718
            r73 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r16 = r5
            r5 = r36
            java.lang.Object r1 = r5.get(r1)
            java.util.Map r1 = (java.util.Map) r1
            r17 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            java.lang.Object r1 = r4.get(r1)
            java.util.Map r1 = (java.util.Map) r1
            r18 = r1
            goto L_0x0722
        L_0x0718:
            r73 = r1
            r16 = r5
            r5 = r36
            r17 = 0
            r18 = 0
        L_0x0722:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r19 = r8
            r8 = r44
            java.lang.Object r1 = r8.get(r1)
            com.google.android.gms.internal.measurement.zzbr$zza r1 = (com.google.android.gms.internal.measurement.zzbr.zza) r1
            if (r1 != 0) goto L_0x078e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            com.google.android.gms.internal.measurement.zzbr$zza$zza r2 = com.google.android.gms.internal.measurement.zzbr.zza.zzh()
            r9 = 1
            com.google.android.gms.internal.measurement.zzbr$zza$zza r2 = r2.zza((boolean) r9)
            com.google.android.gms.internal.measurement.zzgn r2 = r2.zzu()
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2
            com.google.android.gms.internal.measurement.zzbr$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zza) r2
            r8.put(r1, r2)
            java.util.BitSet r1 = new java.util.BitSet
            r1.<init>()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            r15.put(r2, r1)
            java.util.BitSet r2 = new java.util.BitSet
            r2.<init>()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)
            r6.put(r9, r2)
            if (r35 == 0) goto L_0x078a
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
            r73 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r5.put(r1, r9)
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap
            r1.<init>()
            r22 = r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            r4.put(r2, r1)
            r17 = r9
            r2 = r22
            r9 = r73
            r73 = r11
            r11 = r1
            goto L_0x0794
        L_0x078a:
            r73 = r1
            r22 = r2
        L_0x078e:
            r9 = r73
            r73 = r11
            r11 = r18
        L_0x0794:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            java.lang.Object r1 = r10.get(r1)
            java.util.List r1 = (java.util.List) r1
            java.util.Iterator r18 = r1.iterator()
        L_0x07a2:
            boolean r1 = r18.hasNext()
            if (r1 == 0) goto L_0x09e6
            java.lang.Object r1 = r18.next()
            com.google.android.gms.internal.measurement.zzbj$zzb r1 = (com.google.android.gms.internal.measurement.zzbj.zzb) r1
            if (r27 == 0) goto L_0x07bf
            if (r26 == 0) goto L_0x07bf
            boolean r22 = r1.zzk()
            if (r22 == 0) goto L_0x07bf
            r22 = r2
            long r2 = r7.zze
            r23 = r2
            goto L_0x07c3
        L_0x07bf:
            r22 = r2
            r23 = r19
        L_0x07c3:
            com.google.android.gms.measurement.internal.zzej r2 = r71.zzr()
            r3 = 2
            boolean r2 = r2.zza((int) r3)
            if (r2 == 0) goto L_0x081f
            com.google.android.gms.measurement.internal.zzej r2 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzx()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            boolean r36 = r1.zza()
            if (r36 == 0) goto L_0x07f1
            int r36 = r1.zzb()
            java.lang.Integer r36 = java.lang.Integer.valueOf(r36)
            r37 = r5
            r70 = r36
            r36 = r4
            r4 = r70
            goto L_0x07f6
        L_0x07f1:
            r36 = r4
            r37 = r5
            r4 = 0
        L_0x07f6:
            com.google.android.gms.measurement.internal.zzeh r5 = r71.zzo()
            r46 = r6
            java.lang.String r6 = r1.zzc()
            java.lang.String r5 = r5.zza((java.lang.String) r6)
            java.lang.String r6 = "Evaluating filter. audience, filter, event"
            r2.zza(r6, r3, r4, r5)
            com.google.android.gms.measurement.internal.zzej r2 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzx()
            com.google.android.gms.measurement.internal.zzjt r3 = r71.zzg()
            java.lang.String r3 = r3.zza((com.google.android.gms.internal.measurement.zzbj.zzb) r1)
            r5 = r48
            r2.zza(r5, r3)
            goto L_0x0827
        L_0x081f:
            r36 = r4
            r37 = r5
            r46 = r6
            r5 = r48
        L_0x0827:
            boolean r2 = r1.zza()
            if (r2 == 0) goto L_0x0993
            int r2 = r1.zzb()
            r6 = 256(0x100, float:3.59E-43)
            if (r2 <= r6) goto L_0x0837
            goto L_0x0993
        L_0x0837:
            java.lang.String r4 = "Event filter result"
            if (r35 == 0) goto L_0x0910
            boolean r2 = r1.zzh()
            boolean r38 = r1.zzi()
            if (r26 == 0) goto L_0x084d
            boolean r3 = r1.zzk()
            if (r3 == 0) goto L_0x084d
            r3 = 1
            goto L_0x084e
        L_0x084d:
            r3 = 0
        L_0x084e:
            if (r2 != 0) goto L_0x0858
            if (r38 != 0) goto L_0x0858
            if (r3 == 0) goto L_0x0855
            goto L_0x0858
        L_0x0855:
            r43 = 0
            goto L_0x085a
        L_0x0858:
            r43 = 1
        L_0x085a:
            int r2 = r1.zzb()
            boolean r2 = r9.get(r2)
            if (r2 == 0) goto L_0x0895
            if (r43 != 0) goto L_0x0895
            com.google.android.gms.measurement.internal.zzej r2 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzx()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r12)
            boolean r4 = r1.zza()
            if (r4 == 0) goto L_0x0881
            int r1 = r1.zzb()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0882
        L_0x0881:
            r1 = 0
        L_0x0882:
            java.lang.String r4 = "Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r2.zza(r4, r3, r1)
            r3 = r72
            r48 = r5
            r2 = r22
            r4 = r36
            r5 = r37
            r6 = r46
            goto L_0x07a2
        L_0x0895:
            r3 = r17
            r17 = r1
            r1 = r71
            r44 = r7
            r7 = r22
            r2 = r17
            r42 = r8
            r22 = r10
            r10 = r72
            r8 = r3
            r3 = r0
            r45 = r15
            r66 = r36
            r15 = r4
            r4 = r41
            r69 = r5
            r68 = r37
            r67 = r46
            r5 = r23
            java.lang.Boolean r1 = r1.zza((com.google.android.gms.internal.measurement.zzbj.zzb) r2, (java.lang.String) r3, (java.util.List<com.google.android.gms.internal.measurement.zzbr.zze>) r4, (long) r5)
            com.google.android.gms.measurement.internal.zzej r2 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzx()
            if (r1 != 0) goto L_0x08c9
            r3 = r28
            goto L_0x08ca
        L_0x08c9:
            r3 = r1
        L_0x08ca:
            r2.zza(r15, r3)
            if (r1 != 0) goto L_0x08d8
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r13.add(r1)
            goto L_0x09d0
        L_0x08d8:
            int r2 = r17.zzb()
            r7.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x09d0
            int r1 = r17.zzb()
            r9.set(r1)
            if (r43 == 0) goto L_0x09d0
            boolean r1 = r32.zzd()
            if (r1 == 0) goto L_0x09d0
            if (r38 == 0) goto L_0x0903
            int r1 = r17.zzb()
            long r2 = r32.zze()
            zzb(r11, r1, r2)
            goto L_0x09d0
        L_0x0903:
            int r1 = r17.zzb()
            long r2 = r32.zze()
            zza((java.util.Map<java.lang.Integer, java.lang.Long>) r8, (int) r1, (long) r2)
            goto L_0x09d0
        L_0x0910:
            r69 = r5
            r44 = r7
            r42 = r8
            r45 = r15
            r8 = r17
            r7 = r22
            r66 = r36
            r68 = r37
            r67 = r46
            r17 = r1
            r15 = r4
            r22 = r10
            r10 = r72
            int r1 = r17.zzb()
            boolean r1 = r9.get(r1)
            if (r1 == 0) goto L_0x0956
            com.google.android.gms.measurement.internal.zzej r1 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r12)
            boolean r3 = r17.zza()
            if (r3 == 0) goto L_0x094e
            int r3 = r17.zzb()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r3)
            goto L_0x094f
        L_0x094e:
            r15 = 0
        L_0x094f:
            java.lang.String r3 = "Event filter already evaluated true. audience ID, filter ID"
            r1.zza(r3, r2, r15)
            goto L_0x09d0
        L_0x0956:
            r1 = r71
            r2 = r17
            r3 = r0
            r4 = r41
            r5 = r23
            java.lang.Boolean r1 = r1.zza((com.google.android.gms.internal.measurement.zzbj.zzb) r2, (java.lang.String) r3, (java.util.List<com.google.android.gms.internal.measurement.zzbr.zze>) r4, (long) r5)
            com.google.android.gms.measurement.internal.zzej r2 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzx()
            if (r1 != 0) goto L_0x0970
            r3 = r28
            goto L_0x0971
        L_0x0970:
            r3 = r1
        L_0x0971:
            r2.zza(r15, r3)
            if (r1 != 0) goto L_0x097e
            java.lang.Integer r1 = java.lang.Integer.valueOf(r12)
            r13.add(r1)
            goto L_0x09d0
        L_0x097e:
            int r2 = r17.zzb()
            r7.set(r2)
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x09d0
            int r1 = r17.zzb()
            r9.set(r1)
            goto L_0x09d0
        L_0x0993:
            r69 = r5
            r44 = r7
            r42 = r8
            r45 = r15
            r8 = r17
            r7 = r22
            r66 = r36
            r68 = r37
            r67 = r46
            r17 = r1
            r22 = r10
            r10 = r72
            com.google.android.gms.measurement.internal.zzej r1 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzi()
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r72)
            boolean r3 = r17.zza()
            if (r3 == 0) goto L_0x09c6
            int r3 = r17.zzb()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r3)
            goto L_0x09c7
        L_0x09c6:
            r15 = 0
        L_0x09c7:
            java.lang.String r3 = java.lang.String.valueOf(r15)
            java.lang.String r4 = "Invalid event filter ID. appId, id"
            r1.zza(r4, r2, r3)
        L_0x09d0:
            r2 = r7
            r17 = r8
            r3 = r10
            r10 = r22
            r8 = r42
            r7 = r44
            r15 = r45
            r4 = r66
            r6 = r67
            r5 = r68
            r48 = r69
            goto L_0x07a2
        L_0x09e6:
            r11 = r73
            r36 = r5
            r46 = r6
            r44 = r8
            r47 = r13
            r43 = r14
            r45 = r15
            r5 = r16
            r8 = r19
            goto L_0x06ad
        L_0x09fa:
            r9 = r3
            r10 = r4
            r8 = r5
            r0 = r33
            r1 = r34
            r7 = r35
            r22 = r36
            r2 = r39
            r12 = r43
            r13 = r44
            r24 = r45
            r18 = r46
            r17 = r47
            r15 = r48
            goto L_0x039a
        L_0x0a15:
            r66 = r10
            r14 = r12
            r42 = r13
            r69 = r15
            r13 = r17
            r67 = r18
            r68 = r22
            r45 = r24
            r10 = r9
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            boolean r0 = r0.zzi(r10)
            com.google.android.gms.measurement.internal.zzs r1 = r71.zzt()
            boolean r1 = r1.zzs(r10)
            com.google.android.gms.measurement.internal.zzs r2 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzak.zzbu
            boolean r2 = r2.zzd(r10, r3)
            com.google.android.gms.measurement.internal.zzs r3 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzak.zzby
            boolean r3 = r3.zzd(r10, r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            boolean r5 = r74.isEmpty()
            if (r5 != 0) goto L_0x0e11
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
            java.util.Iterator r6 = r74.iterator()
        L_0x0a5d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0e11
            java.lang.Object r7 = r6.next()
            com.google.android.gms.internal.measurement.zzbr$zzk r7 = (com.google.android.gms.internal.measurement.zzbr.zzk) r7
            java.lang.String r8 = r7.zzc()
            r4.add(r8)
            java.lang.String r8 = r7.zzc()
            java.lang.Object r8 = r5.get(r8)
            java.util.Map r8 = (java.util.Map) r8
            if (r8 != 0) goto L_0x0a96
            com.google.android.gms.measurement.internal.zzx r8 = r71.zzi()
            java.lang.String r9 = r7.zzc()
            java.util.Map r8 = r8.zzg(r10, r9)
            if (r8 != 0) goto L_0x0a8f
            androidx.collection.ArrayMap r8 = new androidx.collection.ArrayMap
            r8.<init>()
        L_0x0a8f:
            java.lang.String r9 = r7.zzc()
            r5.put(r9, r8)
        L_0x0a96:
            java.util.Set r9 = r8.keySet()
            java.util.Iterator r9 = r9.iterator()
        L_0x0a9e:
            boolean r11 = r9.hasNext()
            if (r11 == 0) goto L_0x0e09
            java.lang.Object r11 = r9.next()
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            boolean r12 = r13.contains(r12)
            if (r12 == 0) goto L_0x0ac8
            com.google.android.gms.measurement.internal.zzej r12 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r12 = r12.zzx()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r12.zza(r14, r11)
            goto L_0x0a9e
        L_0x0ac8:
            java.lang.Integer r12 = java.lang.Integer.valueOf(r11)
            r15 = r45
            java.lang.Object r12 = r15.get(r12)
            java.util.BitSet r12 = (java.util.BitSet) r12
            r73 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r74 = r6
            r6 = r67
            java.lang.Object r5 = r6.get(r5)
            java.util.BitSet r5 = (java.util.BitSet) r5
            if (r0 == 0) goto L_0x0b09
            r16 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r17 = r9
            r9 = r68
            java.lang.Object r5 = r9.get(r5)
            java.util.Map r5 = (java.util.Map) r5
            r18 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r19 = r12
            r12 = r66
            java.lang.Object r5 = r12.get(r5)
            java.util.Map r5 = (java.util.Map) r5
            r20 = r5
            goto L_0x0b17
        L_0x0b09:
            r16 = r5
            r17 = r9
            r19 = r12
            r12 = r66
            r9 = r68
            r18 = 0
            r20 = 0
        L_0x0b17:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r43 = r14
            r14 = r42
            java.lang.Object r5 = r14.get(r5)
            com.google.android.gms.internal.measurement.zzbr$zza r5 = (com.google.android.gms.internal.measurement.zzbr.zza) r5
            if (r5 != 0) goto L_0x0b8c
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r21 = r4
            com.google.android.gms.internal.measurement.zzbr$zza$zza r4 = com.google.android.gms.internal.measurement.zzbr.zza.zzh()
            r10 = 1
            com.google.android.gms.internal.measurement.zzbr$zza$zza r4 = r4.zza((boolean) r10)
            com.google.android.gms.internal.measurement.zzgn r4 = r4.zzu()
            com.google.android.gms.internal.measurement.zzfd r4 = (com.google.android.gms.internal.measurement.zzfd) r4
            com.google.android.gms.internal.measurement.zzbr$zza r4 = (com.google.android.gms.internal.measurement.zzbr.zza) r4
            r14.put(r5, r4)
            java.util.BitSet r4 = new java.util.BitSet
            r4.<init>()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r15.put(r5, r4)
            java.util.BitSet r5 = new java.util.BitSet
            r5.<init>()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r11)
            r6.put(r10, r5)
            if (r0 == 0) goto L_0x0b81
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap
            r10.<init>()
            r16 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r11)
            r9.put(r4, r10)
            androidx.collection.ArrayMap r4 = new androidx.collection.ArrayMap
            r4.<init>()
            r19 = r5
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r12.put(r5, r4)
            r22 = r9
            r66 = r12
            r5 = r19
            r12 = r4
            r4 = r16
            goto L_0x0b9a
        L_0x0b81:
            r16 = r4
            r19 = r5
            r22 = r9
            r66 = r12
            r10 = r18
            goto L_0x0b98
        L_0x0b8c:
            r21 = r4
            r22 = r9
            r66 = r12
            r5 = r16
            r10 = r18
            r4 = r19
        L_0x0b98:
            r12 = r20
        L_0x0b9a:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)
            java.lang.Object r9 = r8.get(r9)
            java.util.List r9 = (java.util.List) r9
            java.util.Iterator r9 = r9.iterator()
        L_0x0ba8:
            boolean r16 = r9.hasNext()
            if (r16 == 0) goto L_0x0df1
            java.lang.Object r16 = r9.next()
            r18 = r8
            r8 = r16
            com.google.android.gms.internal.measurement.zzbj$zze r8 = (com.google.android.gms.internal.measurement.zzbj.zze) r8
            r16 = r9
            com.google.android.gms.measurement.internal.zzej r9 = r71.zzr()
            r46 = r6
            r6 = 2
            boolean r9 = r9.zza((int) r6)
            if (r9 == 0) goto L_0x0c16
            com.google.android.gms.measurement.internal.zzej r9 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzx()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r11)
            boolean r19 = r8.zza()
            if (r19 == 0) goto L_0x0be8
            int r19 = r8.zzb()
            java.lang.Integer r19 = java.lang.Integer.valueOf(r19)
            r44 = r14
            r45 = r15
            r14 = r19
            goto L_0x0bed
        L_0x0be8:
            r44 = r14
            r45 = r15
            r14 = 0
        L_0x0bed:
            com.google.android.gms.measurement.internal.zzeh r15 = r71.zzo()
            r19 = r10
            java.lang.String r10 = r8.zzc()
            java.lang.String r10 = r15.zzc(r10)
            java.lang.String r15 = "Evaluating filter. audience, filter, property"
            r9.zza(r15, r6, r14, r10)
            com.google.android.gms.measurement.internal.zzej r6 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r6 = r6.zzx()
            com.google.android.gms.measurement.internal.zzjt r9 = r71.zzg()
            java.lang.String r9 = r9.zza((com.google.android.gms.internal.measurement.zzbj.zze) r8)
            r10 = r69
            r6.zza(r10, r9)
            goto L_0x0c1e
        L_0x0c16:
            r19 = r10
            r44 = r14
            r45 = r15
            r10 = r69
        L_0x0c1e:
            boolean r6 = r8.zza()
            if (r6 == 0) goto L_0x0da3
            int r6 = r8.zzb()
            r9 = 256(0x100, float:3.59E-43)
            if (r6 <= r9) goto L_0x0c2e
            goto L_0x0da3
        L_0x0c2e:
            java.lang.String r6 = "Property filter result"
            if (r0 == 0) goto L_0x0d29
            boolean r14 = r8.zze()
            boolean r15 = r8.zzf()
            if (r2 == 0) goto L_0x0c45
            boolean r20 = r8.zzh()
            if (r20 == 0) goto L_0x0c45
            r20 = 1
            goto L_0x0c47
        L_0x0c45:
            r20 = 0
        L_0x0c47:
            if (r14 != 0) goto L_0x0c50
            if (r15 != 0) goto L_0x0c50
            if (r20 == 0) goto L_0x0c4e
            goto L_0x0c50
        L_0x0c4e:
            r14 = 0
            goto L_0x0c51
        L_0x0c50:
            r14 = 1
        L_0x0c51:
            int r9 = r8.zzb()
            boolean r9 = r4.get(r9)
            if (r9 == 0) goto L_0x0c8e
            if (r14 != 0) goto L_0x0c8e
            com.google.android.gms.measurement.internal.zzej r6 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r6 = r6.zzx()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r11)
            boolean r14 = r8.zza()
            if (r14 == 0) goto L_0x0c78
            int r8 = r8.zzb()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r8)
            goto L_0x0c79
        L_0x0c78:
            r15 = 0
        L_0x0c79:
            java.lang.String r8 = "Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID"
            r6.zza(r8, r9, r15)
            r69 = r10
            r9 = r16
            r8 = r18
            r10 = r19
            r14 = r44
            r15 = r45
            r6 = r46
            goto L_0x0ba8
        L_0x0c8e:
            r9 = r71
            java.lang.Boolean r23 = r9.zza((com.google.android.gms.internal.measurement.zzbj.zze) r8, (com.google.android.gms.internal.measurement.zzbr.zzk) r7)
            com.google.android.gms.measurement.internal.zzej r24 = r71.zzr()
            r26 = r0
            com.google.android.gms.measurement.internal.zzel r0 = r24.zzx()
            if (r23 != 0) goto L_0x0ca5
            r48 = r10
            r10 = r28
            goto L_0x0ca9
        L_0x0ca5:
            r48 = r10
            r10 = r23
        L_0x0ca9:
            r0.zza(r6, r10)
            if (r23 != 0) goto L_0x0cbd
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            r13.add(r0)
        L_0x0cb5:
            r9 = r16
            r8 = r18
            r10 = r19
            goto L_0x0d63
        L_0x0cbd:
            int r0 = r8.zzb()
            r5.set(r0)
            if (r2 == 0) goto L_0x0cce
            if (r20 == 0) goto L_0x0cce
            boolean r0 = r23.booleanValue()
            if (r0 == 0) goto L_0x0cb5
        L_0x0cce:
            if (r1 == 0) goto L_0x0cec
            int r0 = r8.zzb()
            boolean r0 = r4.get(r0)
            if (r0 == 0) goto L_0x0ce0
            boolean r0 = r8.zze()
            if (r0 == 0) goto L_0x0cf7
        L_0x0ce0:
            int r0 = r8.zzb()
            boolean r6 = r23.booleanValue()
            r4.set(r0, r6)
            goto L_0x0cf7
        L_0x0cec:
            int r0 = r8.zzb()
            boolean r6 = r23.booleanValue()
            r4.set(r0, r6)
        L_0x0cf7:
            boolean r0 = r23.booleanValue()
            if (r0 == 0) goto L_0x0cb5
            if (r14 == 0) goto L_0x0cb5
            boolean r0 = r7.zza()
            if (r0 == 0) goto L_0x0cb5
            long r23 = r7.zzb()
            if (r3 == 0) goto L_0x0d11
            if (r75 == 0) goto L_0x0d11
            long r23 = r75.longValue()
        L_0x0d11:
            r10 = r1
            r0 = r23
            if (r15 == 0) goto L_0x0d1f
            int r6 = r8.zzb()
            zzb(r12, r6, r0)
            r1 = r10
            goto L_0x0cb5
        L_0x0d1f:
            int r6 = r8.zzb()
            r14 = r19
            zza((java.util.Map<java.lang.Integer, java.lang.Long>) r14, (int) r6, (long) r0)
            goto L_0x0d5d
        L_0x0d29:
            r9 = r71
            r26 = r0
            r48 = r10
            r14 = r19
            r10 = r1
            int r0 = r8.zzb()
            boolean r0 = r4.get(r0)
            if (r0 == 0) goto L_0x0d6f
            com.google.android.gms.measurement.internal.zzej r0 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzx()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            boolean r6 = r8.zza()
            if (r6 == 0) goto L_0x0d57
            int r6 = r8.zzb()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r6)
            goto L_0x0d58
        L_0x0d57:
            r15 = 0
        L_0x0d58:
            java.lang.String r6 = "Property filter already evaluated true. audience ID, filter ID"
            r0.zza(r6, r1, r15)
        L_0x0d5d:
            r1 = r10
            r10 = r14
            r9 = r16
            r8 = r18
        L_0x0d63:
            r0 = r26
            r14 = r44
            r15 = r45
            r6 = r46
            r69 = r48
            goto L_0x0ba8
        L_0x0d6f:
            java.lang.Boolean r0 = r9.zza((com.google.android.gms.internal.measurement.zzbj.zze) r8, (com.google.android.gms.internal.measurement.zzbr.zzk) r7)
            com.google.android.gms.measurement.internal.zzej r1 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzx()
            if (r0 != 0) goto L_0x0d80
            r15 = r28
            goto L_0x0d81
        L_0x0d80:
            r15 = r0
        L_0x0d81:
            r1.zza(r6, r15)
            if (r0 != 0) goto L_0x0d8e
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            r13.add(r0)
            goto L_0x0d5d
        L_0x0d8e:
            int r1 = r8.zzb()
            r5.set(r1)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0d5d
            int r0 = r8.zzb()
            r4.set(r0)
            goto L_0x0d5d
        L_0x0da3:
            r9 = r71
            r26 = r0
            r48 = r10
            r10 = r1
            com.google.android.gms.measurement.internal.zzej r0 = r71.zzr()
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzi()
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r72)
            boolean r4 = r8.zza()
            if (r4 == 0) goto L_0x0dc5
            int r4 = r8.zzb()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r4)
            goto L_0x0dc6
        L_0x0dc5:
            r15 = 0
        L_0x0dc6:
            java.lang.String r4 = java.lang.String.valueOf(r15)
            java.lang.String r5 = "Invalid property filter ID. appId, id"
            r0.zza(r5, r1, r4)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            r13.add(r0)
            r5 = r73
            r6 = r74
            r1 = r10
            r9 = r17
            r8 = r18
            r4 = r21
            r68 = r22
            r0 = r26
            r14 = r43
            r42 = r44
            r67 = r46
            r69 = r48
            r10 = r72
            goto L_0x0a9e
        L_0x0df1:
            r9 = r71
            r10 = r72
            r5 = r73
            r67 = r6
            r42 = r14
            r45 = r15
            r9 = r17
            r4 = r21
            r68 = r22
            r14 = r43
            r6 = r74
            goto L_0x0a9e
        L_0x0e09:
            r9 = r71
            r44 = r42
            r10 = r72
            goto L_0x0a5d
        L_0x0e11:
            r9 = r71
            r21 = r4
            r44 = r42
            r46 = r67
            r22 = r68
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            r1 = r72
            r2 = 1
            boolean r3 = r0.zzi(r1)
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            boolean r4 = r0.zzs(r1)
            com.google.android.gms.measurement.internal.zzs r0 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.zzak.zzby
            boolean r0 = r0.zzd(r1, r5)
            androidx.collection.ArrayMap r5 = new androidx.collection.ArrayMap
            r5.<init>()
            if (r0 == 0) goto L_0x0e49
            com.google.android.gms.measurement.internal.zzx r0 = r71.zzi()
            r5 = r21
            java.util.Map r5 = r0.zza((java.lang.String) r1, (java.util.List<java.lang.String>) r5)
        L_0x0e49:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Set r0 = r45.keySet()
            java.util.Iterator r7 = r0.iterator()
        L_0x0e56:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L_0x115a
            java.lang.Object r0 = r7.next()
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            boolean r8 = r13.contains(r8)
            if (r8 != 0) goto L_0x1156
            java.lang.Integer r8 = java.lang.Integer.valueOf(r0)
            r10 = r44
            java.lang.Object r8 = r10.get(r8)
            com.google.android.gms.internal.measurement.zzbr$zza r8 = (com.google.android.gms.internal.measurement.zzbr.zza) r8
            if (r8 != 0) goto L_0x0e83
            com.google.android.gms.internal.measurement.zzbr$zza$zza r8 = com.google.android.gms.internal.measurement.zzbr.zza.zzh()
            goto L_0x0e8b
        L_0x0e83:
            com.google.android.gms.internal.measurement.zzfd$zza r8 = r8.zzbk()
            com.google.android.gms.internal.measurement.zzfd$zza r8 = (com.google.android.gms.internal.measurement.zzfd.zza) r8
            com.google.android.gms.internal.measurement.zzbr$zza$zza r8 = (com.google.android.gms.internal.measurement.zzbr.zza.C0012zza) r8
        L_0x0e8b:
            r8.zza((int) r0)
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r11 = com.google.android.gms.internal.measurement.zzbr.zzi.zzi()
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)
            r14 = r45
            java.lang.Object r12 = r14.get(r12)
            java.util.BitSet r12 = (java.util.BitSet) r12
            java.util.List r12 = com.google.android.gms.measurement.internal.zzjt.zza((java.util.BitSet) r12)
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r11 = r11.zzb((java.lang.Iterable<? extends java.lang.Long>) r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)
            r15 = r46
            java.lang.Object r12 = r15.get(r12)
            java.util.BitSet r12 = (java.util.BitSet) r12
            java.util.List r12 = com.google.android.gms.measurement.internal.zzjt.zza((java.util.BitSet) r12)
            com.google.android.gms.internal.measurement.zzbr$zzi$zza r11 = r11.zza((java.lang.Iterable<? extends java.lang.Long>) r12)
            if (r3 == 0) goto L_0x10b3
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)
            r2 = r22
            java.lang.Object r12 = r2.get(r12)
            java.util.Map r12 = (java.util.Map) r12
            java.util.List r12 = zza(r12)
            r11.zzc(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r0)
            r2 = r66
            java.lang.Object r12 = r2.get(r12)
            java.util.Map r12 = (java.util.Map) r12
            if (r12 != 0) goto L_0x0eeb
            java.util.List r12 = java.util.Collections.emptyList()
            r66 = r2
            r73 = r3
            r75 = r7
            r47 = r13
            goto L_0x0f68
        L_0x0eeb:
            r66 = r2
            java.util.ArrayList r2 = new java.util.ArrayList
            r73 = r3
            int r3 = r12.size()
            r2.<init>(r3)
            java.util.Set r3 = r12.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x0f00:
            boolean r16 = r3.hasNext()
            if (r16 == 0) goto L_0x0f63
            java.lang.Object r16 = r3.next()
            r74 = r3
            r3 = r16
            java.lang.Integer r3 = (java.lang.Integer) r3
            r75 = r7
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r7 = com.google.android.gms.internal.measurement.zzbr.zzj.zze()
            int r9 = r3.intValue()
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r7 = r7.zza((int) r9)
            java.lang.Object r3 = r12.get(r3)
            java.util.List r3 = (java.util.List) r3
            if (r3 == 0) goto L_0x0f49
            java.util.Collections.sort(r3)
            java.util.Iterator r3 = r3.iterator()
        L_0x0f2d:
            boolean r9 = r3.hasNext()
            if (r9 == 0) goto L_0x0f49
            java.lang.Object r9 = r3.next()
            java.lang.Long r9 = (java.lang.Long) r9
            r16 = r12
            r47 = r13
            long r12 = r9.longValue()
            r7.zza((long) r12)
            r12 = r16
            r13 = r47
            goto L_0x0f2d
        L_0x0f49:
            r16 = r12
            r47 = r13
            com.google.android.gms.internal.measurement.zzgn r3 = r7.zzu()
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3
            com.google.android.gms.internal.measurement.zzbr$zzj r3 = (com.google.android.gms.internal.measurement.zzbr.zzj) r3
            r2.add(r3)
            r9 = r71
            r3 = r74
            r7 = r75
            r12 = r16
            r13 = r47
            goto L_0x0f00
        L_0x0f63:
            r75 = r7
            r47 = r13
            r12 = r2
        L_0x0f68:
            if (r4 == 0) goto L_0x0f99
            boolean r2 = r8.zzb()
            if (r2 == 0) goto L_0x0f99
            com.google.android.gms.internal.measurement.zzlq.zzb()
            com.google.android.gms.measurement.internal.zzs r2 = r71.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzak.zzbz
            boolean r2 = r2.zzd(r1, r3)
            if (r2 == 0) goto L_0x0f81
            if (r25 != 0) goto L_0x0f99
        L_0x0f81:
            com.google.android.gms.internal.measurement.zzbr$zzi r2 = r8.zzc()
            java.util.List r2 = r2.zzg()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            java.lang.Object r3 = r5.get(r3)
            java.util.List r3 = (java.util.List) r3
            boolean r7 = r2.isEmpty()
            if (r7 == 0) goto L_0x0f9f
        L_0x0f99:
            r74 = r4
            r17 = 1
            goto L_0x10af
        L_0x0f9f:
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>(r12)
            androidx.collection.ArrayMap r9 = new androidx.collection.ArrayMap
            r9.<init>()
            java.util.Iterator r2 = r2.iterator()
        L_0x0fad:
            boolean r12 = r2.hasNext()
            if (r12 == 0) goto L_0x0fea
            java.lang.Object r12 = r2.next()
            com.google.android.gms.internal.measurement.zzbr$zzj r12 = (com.google.android.gms.internal.measurement.zzbr.zzj) r12
            boolean r13 = r12.zza()
            if (r13 == 0) goto L_0x0fe3
            int r13 = r12.zzd()
            if (r13 <= 0) goto L_0x0fe3
            int r13 = r12.zzb()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            int r16 = r12.zzd()
            r74 = r2
            r17 = 1
            int r2 = r16 + -1
            long r18 = r12.zza((int) r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r18)
            r9.put(r13, r2)
            goto L_0x0fe7
        L_0x0fe3:
            r74 = r2
            r17 = 1
        L_0x0fe7:
            r2 = r74
            goto L_0x0fad
        L_0x0fea:
            r17 = 1
            r2 = 0
        L_0x0fed:
            int r12 = r7.size()
            if (r2 >= r12) goto L_0x1070
            java.lang.Object r12 = r7.get(r2)
            com.google.android.gms.internal.measurement.zzbr$zzj r12 = (com.google.android.gms.internal.measurement.zzbr.zzj) r12
            boolean r13 = r12.zza()
            if (r13 == 0) goto L_0x1008
            int r13 = r12.zzb()
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            goto L_0x1009
        L_0x1008:
            r13 = 0
        L_0x1009:
            java.lang.Object r13 = r9.remove(r13)
            java.lang.Long r13 = (java.lang.Long) r13
            if (r13 == 0) goto L_0x1063
            if (r3 == 0) goto L_0x1027
            int r16 = r12.zzb()
            r74 = r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r16)
            boolean r4 = r3.contains(r4)
            if (r4 != 0) goto L_0x1024
            goto L_0x1029
        L_0x1024:
            r16 = r3
            goto L_0x1067
        L_0x1027:
            r74 = r4
        L_0x1029:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            long r18 = r13.longValue()
            r16 = r3
            r3 = 0
            long r20 = r12.zza((int) r3)
            int r23 = (r18 > r20 ? 1 : (r18 == r20 ? 0 : -1))
            if (r23 >= 0) goto L_0x1040
            r4.add(r13)
        L_0x1040:
            java.util.List r13 = r12.zzc()
            r4.addAll(r13)
            com.google.android.gms.internal.measurement.zzfd$zza r12 = r12.zzbk()
            com.google.android.gms.internal.measurement.zzfd$zza r12 = (com.google.android.gms.internal.measurement.zzfd.zza) r12
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r12 = (com.google.android.gms.internal.measurement.zzbr.zzj.zza) r12
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r12 = r12.zza()
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r4 = r12.zza((java.lang.Iterable<? extends java.lang.Long>) r4)
            com.google.android.gms.internal.measurement.zzgn r4 = r4.zzu()
            com.google.android.gms.internal.measurement.zzfd r4 = (com.google.android.gms.internal.measurement.zzfd) r4
            com.google.android.gms.internal.measurement.zzbr$zzj r4 = (com.google.android.gms.internal.measurement.zzbr.zzj) r4
            r7.set(r2, r4)
            goto L_0x1068
        L_0x1063:
            r16 = r3
            r74 = r4
        L_0x1067:
            r3 = 0
        L_0x1068:
            int r2 = r2 + 1
            r4 = r74
            r3 = r16
            goto L_0x0fed
        L_0x1070:
            r74 = r4
            r3 = 0
            java.util.Set r2 = r9.keySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x107b:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x10ae
            java.lang.Object r4 = r2.next()
            java.lang.Integer r4 = (java.lang.Integer) r4
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r12 = com.google.android.gms.internal.measurement.zzbr.zzj.zze()
            int r13 = r4.intValue()
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r12 = r12.zza((int) r13)
            java.lang.Object r4 = r9.get(r4)
            java.lang.Long r4 = (java.lang.Long) r4
            long r3 = r4.longValue()
            com.google.android.gms.internal.measurement.zzbr$zzj$zza r3 = r12.zza((long) r3)
            com.google.android.gms.internal.measurement.zzgn r3 = r3.zzu()
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3
            com.google.android.gms.internal.measurement.zzbr$zzj r3 = (com.google.android.gms.internal.measurement.zzbr.zzj) r3
            r7.add(r3)
            r3 = 0
            goto L_0x107b
        L_0x10ae:
            r12 = r7
        L_0x10af:
            r11.zzd(r12)
            goto L_0x10bd
        L_0x10b3:
            r73 = r3
            r74 = r4
            r75 = r7
            r47 = r13
            r17 = 1
        L_0x10bd:
            r8.zza((com.google.android.gms.internal.measurement.zzbr.zzi.zza) r11)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            com.google.android.gms.internal.measurement.zzgn r3 = r8.zzu()
            com.google.android.gms.internal.measurement.zzfd r3 = (com.google.android.gms.internal.measurement.zzfd) r3
            com.google.android.gms.internal.measurement.zzbr$zza r3 = (com.google.android.gms.internal.measurement.zzbr.zza) r3
            r10.put(r2, r3)
            com.google.android.gms.internal.measurement.zzgn r2 = r8.zzu()
            com.google.android.gms.internal.measurement.zzfd r2 = (com.google.android.gms.internal.measurement.zzfd) r2
            com.google.android.gms.internal.measurement.zzbr$zza r2 = (com.google.android.gms.internal.measurement.zzbr.zza) r2
            r6.add(r2)
            com.google.android.gms.measurement.internal.zzx r2 = r71.zzi()
            com.google.android.gms.internal.measurement.zzbr$zzi r3 = r8.zza()
            r2.zzak()
            r2.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r72)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)
            byte[] r3 = r3.zzbh()
            android.content.ContentValues r4 = new android.content.ContentValues
            r4.<init>()
            java.lang.String r7 = "app_id"
            r4.put(r7, r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r7 = "audience_id"
            r4.put(r7, r0)
            java.lang.String r0 = "current_results"
            r4.put(r0, r3)
            android.database.sqlite.SQLiteDatabase r0 = r2.c_()     // Catch:{ SQLiteException -> 0x1130 }
            java.lang.String r3 = "audience_filter_values"
            r7 = 5
            r8 = 0
            long r3 = r0.insertWithOnConflict(r3, r8, r4, r7)     // Catch:{ SQLiteException -> 0x112e }
            r11 = -1
            int r0 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x1143
            com.google.android.gms.measurement.internal.zzej r0 = r2.zzr()     // Catch:{ SQLiteException -> 0x112e }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x112e }
            java.lang.String r3 = "Failed to insert filter results (got -1). appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r72)     // Catch:{ SQLiteException -> 0x112e }
            r0.zza(r3, r4)     // Catch:{ SQLiteException -> 0x112e }
            goto L_0x1143
        L_0x112e:
            r0 = move-exception
            goto L_0x1132
        L_0x1130:
            r0 = move-exception
            r8 = 0
        L_0x1132:
            com.google.android.gms.measurement.internal.zzej r2 = r2.zzr()
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r72)
            java.lang.String r4 = "Error storing filter results. appId"
            r2.zza(r4, r3, r0)
        L_0x1143:
            r9 = r71
            r3 = r73
            r4 = r74
            r7 = r75
            r44 = r10
            r45 = r14
            r46 = r15
            r13 = r47
            r2 = 1
            goto L_0x0e56
        L_0x1156:
            r9 = r71
            goto L_0x0e56
        L_0x115a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzp.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long):java.util.List");
    }

    private final Boolean zza(zzbj.zzb zzb, String str, List<zzbr.zze> list, long j) {
        Boolean bool;
        if (zzb.zzf()) {
            Boolean zza = zza(j, zzb.zzg());
            if (zza == null) {
                return null;
            }
            if (!zza.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzbj.zzc next : zzb.zzd()) {
            if (next.zzg().isEmpty()) {
                zzr().zzi().zza("null or empty param name in filter. event", zzo().zza(str));
                return null;
            }
            hashSet.add(next.zzg());
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzbr.zze next2 : list) {
            if (hashSet.contains(next2.zza())) {
                if (next2.zzd()) {
                    arrayMap.put(next2.zza(), next2.zzd() ? Long.valueOf(next2.zze()) : null);
                } else if (next2.zzf()) {
                    arrayMap.put(next2.zza(), next2.zzf() ? Double.valueOf(next2.zzg()) : null);
                } else if (next2.zzb()) {
                    arrayMap.put(next2.zza(), next2.zzc());
                } else {
                    zzr().zzi().zza("Unknown value for param. event, param", zzo().zza(str), zzo().zzb(next2.zza()));
                    return null;
                }
            }
        }
        Iterator<zzbj.zzc> it = zzb.zzd().iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                return true;
            }
            zzbj.zzc next3 = it.next();
            if (!next3.zze() || !next3.zzf()) {
                z = false;
            }
            String zzg = next3.zzg();
            if (zzg.isEmpty()) {
                zzr().zzi().zza("Event has empty param name. event", zzo().zza(str));
                return null;
            }
            Object obj = arrayMap.get(zzg);
            if (obj instanceof Long) {
                if (!next3.zzc()) {
                    zzr().zzi().zza("No number filter for long param. event, param", zzo().zza(str), zzo().zzb(zzg));
                    return null;
                }
                Boolean zza2 = zza(((Long) obj).longValue(), next3.zzd());
                if (zza2 == null) {
                    return null;
                }
                if (zza2.booleanValue() == z) {
                    return false;
                }
            } else if (obj instanceof Double) {
                if (!next3.zzc()) {
                    zzr().zzi().zza("No number filter for double param. event, param", zzo().zza(str), zzo().zzb(zzg));
                    return null;
                }
                Boolean zza3 = zza(((Double) obj).doubleValue(), next3.zzd());
                if (zza3 == null) {
                    return null;
                }
                if (zza3.booleanValue() == z) {
                    return false;
                }
            } else if (obj instanceof String) {
                if (next3.zza()) {
                    bool = zza((String) obj, next3.zzb());
                } else if (next3.zzc()) {
                    String str2 = (String) obj;
                    if (zzjt.zza(str2)) {
                        bool = zza(str2, next3.zzd());
                    } else {
                        zzr().zzi().zza("Invalid param value for number filter. event, param", zzo().zza(str), zzo().zzb(zzg));
                        return null;
                    }
                } else {
                    zzr().zzi().zza("No filter for String param. event, param", zzo().zza(str), zzo().zzb(zzg));
                    return null;
                }
                if (bool == null) {
                    return null;
                }
                if (bool.booleanValue() == z) {
                    return false;
                }
            } else if (obj == null) {
                zzr().zzx().zza("Missing param for filter. event, param", zzo().zza(str), zzo().zzb(zzg));
                return false;
            } else {
                zzr().zzi().zza("Unknown param type. event, param", zzo().zza(str), zzo().zzb(zzg));
                return null;
            }
        }
    }

    private final Boolean zza(zzbj.zze zze, zzbr.zzk zzk) {
        zzbj.zzc zzd = zze.zzd();
        boolean zzf = zzd.zzf();
        if (zzk.zzf()) {
            if (zzd.zzc()) {
                return zza(zza(zzk.zzg(), zzd.zzd()), zzf);
            }
            zzr().zzi().zza("No number filter for long property. property", zzo().zzc(zzk.zzc()));
            return null;
        } else if (zzk.zzh()) {
            if (zzd.zzc()) {
                return zza(zza(zzk.zzi(), zzd.zzd()), zzf);
            }
            zzr().zzi().zza("No number filter for double property. property", zzo().zzc(zzk.zzc()));
            return null;
        } else if (!zzk.zzd()) {
            zzr().zzi().zza("User property has no value, property", zzo().zzc(zzk.zzc()));
            return null;
        } else if (zzd.zza()) {
            return zza(zza(zzk.zze(), zzd.zzb()), zzf);
        } else {
            if (!zzd.zzc()) {
                zzr().zzi().zza("No string or number filter defined. property", zzo().zzc(zzk.zzc()));
            } else if (zzjt.zza(zzk.zze())) {
                return zza(zza(zzk.zze(), zzd.zzd()), zzf);
            } else {
                zzr().zzi().zza("Invalid user property value for Numeric number filter. property, value", zzo().zzc(zzk.zzc()), zzk.zze());
            }
            return null;
        }
    }

    @VisibleForTesting
    private static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() != z);
    }

    @VisibleForTesting
    private final Boolean zza(String str, zzbj.zzf zzf) {
        String str2;
        List<String> list;
        Preconditions.checkNotNull(zzf);
        if (str == null || !zzf.zza() || zzf.zzb() == zzbj.zzf.zzb.UNKNOWN_MATCH_TYPE) {
            return null;
        }
        if (zzf.zzb() == zzbj.zzf.zzb.IN_LIST) {
            if (zzf.zzh() == 0) {
                return null;
            }
        } else if (!zzf.zzc()) {
            return null;
        }
        zzbj.zzf.zzb zzb = zzf.zzb();
        boolean zzf2 = zzf.zzf();
        if (zzf2 || zzb == zzbj.zzf.zzb.REGEXP || zzb == zzbj.zzf.zzb.IN_LIST) {
            str2 = zzf.zzd();
        } else {
            str2 = zzf.zzd().toUpperCase(Locale.ENGLISH);
        }
        String str3 = str2;
        if (zzf.zzh() == 0) {
            list = null;
        } else {
            List<String> zzg = zzf.zzg();
            if (!zzf2) {
                ArrayList arrayList = new ArrayList(zzg.size());
                for (String upperCase : zzg) {
                    arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
                }
                zzg = Collections.unmodifiableList(arrayList);
            }
            list = zzg;
        }
        return zza(str, zzb, zzf2, str3, list, zzb == zzbj.zzf.zzb.REGEXP ? str3 : null);
    }

    private final Boolean zza(String str, zzbj.zzf.zzb zzb, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (zzb == zzbj.zzf.zzb.IN_LIST) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && zzb != zzbj.zzf.zzb.REGEXP) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (zzo.zza[zzb.ordinal()]) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    zzr().zzi().zza("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean zza(long j, zzbj.zzd zzd) {
        try {
            return zza(new BigDecimal(j), zzd, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(double d, zzbj.zzd zzd) {
        try {
            return zza(new BigDecimal(d), zzd, Math.ulp(d));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean zza(String str, zzbj.zzd zzd) {
        if (!zzjt.zza(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str), zzd, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0085, code lost:
        if (r2 != null) goto L_0x0087;
     */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Boolean zza(java.math.BigDecimal r9, com.google.android.gms.internal.measurement.zzbj.zzd r10, double r11) {
        /*
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)
            boolean r0 = r10.zza()
            r1 = 0
            if (r0 == 0) goto L_0x0110
            com.google.android.gms.internal.measurement.zzbj$zzd$zza r0 = r10.zzb()
            com.google.android.gms.internal.measurement.zzbj$zzd$zza r2 = com.google.android.gms.internal.measurement.zzbj.zzd.zza.UNKNOWN_COMPARISON_TYPE
            if (r0 != r2) goto L_0x0014
            goto L_0x0110
        L_0x0014:
            com.google.android.gms.internal.measurement.zzbj$zzd$zza r0 = r10.zzb()
            com.google.android.gms.internal.measurement.zzbj$zzd$zza r2 = com.google.android.gms.internal.measurement.zzbj.zzd.zza.BETWEEN
            if (r0 != r2) goto L_0x0029
            boolean r0 = r10.zzg()
            if (r0 == 0) goto L_0x0028
            boolean r0 = r10.zzi()
            if (r0 != 0) goto L_0x0030
        L_0x0028:
            return r1
        L_0x0029:
            boolean r0 = r10.zze()
            if (r0 != 0) goto L_0x0030
            return r1
        L_0x0030:
            com.google.android.gms.internal.measurement.zzbj$zzd$zza r0 = r10.zzb()
            com.google.android.gms.internal.measurement.zzbj$zzd$zza r2 = r10.zzb()
            com.google.android.gms.internal.measurement.zzbj$zzd$zza r3 = com.google.android.gms.internal.measurement.zzbj.zzd.zza.BETWEEN
            if (r2 != r3) goto L_0x0067
            java.lang.String r2 = r10.zzh()
            boolean r2 = com.google.android.gms.measurement.internal.zzjt.zza((java.lang.String) r2)
            if (r2 == 0) goto L_0x0066
            java.lang.String r2 = r10.zzj()
            boolean r2 = com.google.android.gms.measurement.internal.zzjt.zza((java.lang.String) r2)
            if (r2 != 0) goto L_0x0051
            goto L_0x0066
        L_0x0051:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r3 = r10.zzh()     // Catch:{ NumberFormatException -> 0x0066 }
            r2.<init>(r3)     // Catch:{ NumberFormatException -> 0x0066 }
            java.math.BigDecimal r3 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0066 }
            java.lang.String r10 = r10.zzj()     // Catch:{ NumberFormatException -> 0x0066 }
            r3.<init>(r10)     // Catch:{ NumberFormatException -> 0x0066 }
            r10 = r2
            r2 = r1
            goto L_0x007d
        L_0x0066:
            return r1
        L_0x0067:
            java.lang.String r2 = r10.zzf()
            boolean r2 = com.google.android.gms.measurement.internal.zzjt.zza((java.lang.String) r2)
            if (r2 != 0) goto L_0x0072
            return r1
        L_0x0072:
            java.math.BigDecimal r2 = new java.math.BigDecimal     // Catch:{ NumberFormatException -> 0x0110 }
            java.lang.String r10 = r10.zzf()     // Catch:{ NumberFormatException -> 0x0110 }
            r2.<init>(r10)     // Catch:{ NumberFormatException -> 0x0110 }
            r10 = r1
            r3 = r10
        L_0x007d:
            com.google.android.gms.internal.measurement.zzbj$zzd$zza r4 = com.google.android.gms.internal.measurement.zzbj.zzd.zza.BETWEEN
            if (r0 != r4) goto L_0x0085
            if (r10 == 0) goto L_0x0084
            goto L_0x0087
        L_0x0084:
            return r1
        L_0x0085:
            if (r2 == 0) goto L_0x0110
        L_0x0087:
            int[] r4 = com.google.android.gms.measurement.internal.zzo.zzb
            int r0 = r0.ordinal()
            r0 = r4[r0]
            r4 = -1
            r5 = 0
            r6 = 1
            if (r0 == r6) goto L_0x0104
            r7 = 2
            if (r0 == r7) goto L_0x00f8
            r8 = 3
            if (r0 == r8) goto L_0x00b0
            r11 = 4
            if (r0 == r11) goto L_0x009e
            goto L_0x0110
        L_0x009e:
            int r10 = r9.compareTo(r10)
            if (r10 == r4) goto L_0x00ab
            int r9 = r9.compareTo(r3)
            if (r9 == r6) goto L_0x00ab
            r5 = 1
        L_0x00ab:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00b0:
            r0 = 0
            int r10 = (r11 > r0 ? 1 : (r11 == r0 ? 0 : -1))
            if (r10 == 0) goto L_0x00ec
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r11)
            java.math.BigDecimal r0 = new java.math.BigDecimal
            r0.<init>(r7)
            java.math.BigDecimal r10 = r10.multiply(r0)
            java.math.BigDecimal r10 = r2.subtract(r10)
            int r10 = r9.compareTo(r10)
            if (r10 != r6) goto L_0x00e7
            java.math.BigDecimal r10 = new java.math.BigDecimal
            r10.<init>(r11)
            java.math.BigDecimal r11 = new java.math.BigDecimal
            r11.<init>(r7)
            java.math.BigDecimal r10 = r10.multiply(r11)
            java.math.BigDecimal r10 = r2.add(r10)
            int r9 = r9.compareTo(r10)
            if (r9 != r4) goto L_0x00e7
            r5 = 1
        L_0x00e7:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00ec:
            int r9 = r9.compareTo(r2)
            if (r9 != 0) goto L_0x00f3
            r5 = 1
        L_0x00f3:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x00f8:
            int r9 = r9.compareTo(r2)
            if (r9 != r6) goto L_0x00ff
            r5 = 1
        L_0x00ff:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x0104:
            int r9 = r9.compareTo(r2)
            if (r9 != r4) goto L_0x010b
            r5 = 1
        L_0x010b:
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)
            return r9
        L_0x0110:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzp.zza(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzbj$zzd, double):java.lang.Boolean");
    }

    private static List<zzbr.zzb> zza(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Integer intValue : map.keySet()) {
            int intValue2 = intValue.intValue();
            arrayList.add((zzbr.zzb) ((zzfd) zzbr.zzb.zze().zza(intValue2).zza(map.get(Integer.valueOf(intValue2)).longValue()).zzu()));
        }
        return arrayList;
    }

    private static void zza(Map<Integer, Long> map, int i, long j) {
        Long l = map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }

    private static void zzb(Map<Integer, List<Long>> map, int i, long j) {
        List list = map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList();
            map.put(Integer.valueOf(i), list);
        }
        list.add(Long.valueOf(j / 1000));
    }
}
