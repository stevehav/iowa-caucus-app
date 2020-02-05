package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.sentry.marshaller.json.JsonMarshaller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzx extends zzjm {
    /* access modifiers changed from: private */
    public static final String[] zzb = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", "remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzf = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    private final zzy zzj = new zzy(this, zzn(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzji zzk = new zzji(zzm());

    zzx(zzjp zzjp) {
        super(zzjp);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    @WorkerThread
    public final void zzf() {
        zzak();
        c_().beginTransaction();
    }

    @WorkerThread
    public final void b_() {
        zzak();
        c_().setTransactionSuccessful();
    }

    @WorkerThread
    public final void zzh() {
        zzak();
        c_().endTransaction();
    }

    @WorkerThread
    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = c_().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    @WorkerThread
    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = c_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final SQLiteDatabase c_() {
        zzd();
        try {
            return this.zzj.getWritableDatabase();
        } catch (SQLiteException e) {
            zzr().zzi().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x0176  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzae zza(java.lang.String r32, java.lang.String r33) {
        /*
            r31 = this;
            r15 = r32
            r14 = r33
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r32)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r33)
            r31.zzd()
            r31.zzak()
            com.google.android.gms.measurement.internal.zzs r0 = r31.zzt()
            com.google.android.gms.measurement.internal.zzdy<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzak.zzbv
            boolean r0 = r0.zze(r15, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 8
            java.lang.String[] r3 = new java.lang.String[r2]
            r4 = 0
            java.lang.String r5 = "lifetime_count"
            r3[r4] = r5
            r5 = 1
            java.lang.String r6 = "current_bundle_count"
            r3[r5] = r6
            r6 = 2
            java.lang.String r7 = "last_fire_timestamp"
            r3[r6] = r7
            r7 = 3
            java.lang.String r8 = "last_bundled_timestamp"
            r3[r7] = r8
            r8 = 4
            java.lang.String r9 = "last_bundled_day"
            r3[r8] = r9
            r9 = 5
            java.lang.String r10 = "last_sampled_complex_event_id"
            r3[r9] = r10
            r10 = 6
            java.lang.String r11 = "last_sampling_rate"
            r3[r10] = r11
            r11 = 7
            java.lang.String r12 = "last_exempt_from_sampling"
            r3[r11] = r12
            java.util.List r3 = java.util.Arrays.asList(r3)
            r1.<init>(r3)
            if (r0 == 0) goto L_0x0056
            java.lang.String r3 = "current_session_count"
            r1.add(r3)
        L_0x0056:
            r18 = 0
            android.database.sqlite.SQLiteDatabase r19 = r31.c_()     // Catch:{ SQLiteException -> 0x014f, all -> 0x014b }
            java.lang.String r20 = "events"
            java.lang.String[] r3 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x014f, all -> 0x014b }
            java.lang.Object[] r1 = r1.toArray(r3)     // Catch:{ SQLiteException -> 0x014f, all -> 0x014b }
            r21 = r1
            java.lang.String[] r21 = (java.lang.String[]) r21     // Catch:{ SQLiteException -> 0x014f, all -> 0x014b }
            java.lang.String r22 = "app_id=? and name=?"
            java.lang.String[] r1 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x014f, all -> 0x014b }
            r1[r4] = r15     // Catch:{ SQLiteException -> 0x014f, all -> 0x014b }
            r1[r5] = r14     // Catch:{ SQLiteException -> 0x014f, all -> 0x014b }
            r24 = 0
            r25 = 0
            r26 = 0
            r23 = r1
            android.database.Cursor r12 = r19.query(r20, r21, r22, r23, r24, r25, r26)     // Catch:{ SQLiteException -> 0x014f, all -> 0x014b }
            boolean r1 = r12.moveToFirst()     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            if (r1 != 0) goto L_0x0088
            if (r12 == 0) goto L_0x0087
            r12.close()
        L_0x0087:
            return r18
        L_0x0088:
            long r16 = r12.getLong(r4)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            long r19 = r12.getLong(r5)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            long r21 = r12.getLong(r6)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            boolean r1 = r12.isNull(r7)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            r23 = 0
            if (r1 == 0) goto L_0x009f
            r25 = r23
            goto L_0x00a5
        L_0x009f:
            long r6 = r12.getLong(r7)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            r25 = r6
        L_0x00a5:
            boolean r1 = r12.isNull(r8)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            if (r1 == 0) goto L_0x00ae
            r27 = r18
            goto L_0x00b8
        L_0x00ae:
            long r6 = r12.getLong(r8)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            r27 = r1
        L_0x00b8:
            boolean r1 = r12.isNull(r9)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            if (r1 == 0) goto L_0x00c1
            r28 = r18
            goto L_0x00cb
        L_0x00c1:
            long r6 = r12.getLong(r9)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            r28 = r1
        L_0x00cb:
            boolean r1 = r12.isNull(r10)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            if (r1 == 0) goto L_0x00d4
            r29 = r18
            goto L_0x00de
        L_0x00d4:
            long r6 = r12.getLong(r10)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            java.lang.Long r1 = java.lang.Long.valueOf(r6)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            r29 = r1
        L_0x00de:
            boolean r1 = r12.isNull(r11)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            if (r1 != 0) goto L_0x00f6
            long r6 = r12.getLong(r11)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            r8 = 1
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x00ef
            r4 = 1
        L_0x00ef:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            r30 = r1
            goto L_0x00f8
        L_0x00f6:
            r30 = r18
        L_0x00f8:
            if (r0 == 0) goto L_0x0106
            boolean r0 = r12.isNull(r2)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            if (r0 != 0) goto L_0x0106
            long r0 = r12.getLong(r2)     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            r8 = r0
            goto L_0x0108
        L_0x0106:
            r8 = r23
        L_0x0108:
            com.google.android.gms.measurement.internal.zzae r0 = new com.google.android.gms.measurement.internal.zzae     // Catch:{ SQLiteException -> 0x0147, all -> 0x0143 }
            r1 = r0
            r2 = r32
            r3 = r33
            r4 = r16
            r6 = r19
            r10 = r21
            r19 = r12
            r12 = r25
            r14 = r27
            r15 = r28
            r16 = r29
            r17 = r30
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0141 }
            boolean r1 = r19.moveToNext()     // Catch:{ SQLiteException -> 0x0141 }
            if (r1 == 0) goto L_0x013b
            com.google.android.gms.measurement.internal.zzej r1 = r31.zzr()     // Catch:{ SQLiteException -> 0x0141 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x0141 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r32)     // Catch:{ SQLiteException -> 0x0141 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0141 }
        L_0x013b:
            if (r19 == 0) goto L_0x0140
            r19.close()
        L_0x0140:
            return r0
        L_0x0141:
            r0 = move-exception
            goto L_0x0152
        L_0x0143:
            r0 = move-exception
            r19 = r12
            goto L_0x0174
        L_0x0147:
            r0 = move-exception
            r19 = r12
            goto L_0x0152
        L_0x014b:
            r0 = move-exception
            r19 = r18
            goto L_0x0174
        L_0x014f:
            r0 = move-exception
            r19 = r18
        L_0x0152:
            com.google.android.gms.measurement.internal.zzej r1 = r31.zzr()     // Catch:{ all -> 0x0173 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ all -> 0x0173 }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r32)     // Catch:{ all -> 0x0173 }
            com.google.android.gms.measurement.internal.zzeh r4 = r31.zzo()     // Catch:{ all -> 0x0173 }
            r5 = r33
            java.lang.String r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x0173 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0173 }
            if (r19 == 0) goto L_0x0172
            r19.close()
        L_0x0172:
            return r18
        L_0x0173:
            r0 = move-exception
        L_0x0174:
            if (r19 == 0) goto L_0x0179
            r19.close()
        L_0x0179:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzae");
    }

    @WorkerThread
    public final void zza(zzae zzae) {
        Preconditions.checkNotNull(zzae);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzae.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzae.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzae.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzae.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzae.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzae.zzg));
        contentValues.put("last_bundled_day", zzae.zzh);
        contentValues.put("last_sampled_complex_event_id", zzae.zzi);
        contentValues.put("last_sampling_rate", zzae.zzj);
        if (zzt().zze(zzae.zza, zzak.zzbv)) {
            contentValues.put("current_session_count", Long.valueOf(zzae.zze));
        }
        contentValues.put("last_exempt_from_sampling", (zzae.zzk == null || !zzae.zzk.booleanValue()) ? null : 1L);
        try {
            if (c_().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update event aggregates (got -1). appId", zzej.zza(zzae.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event aggregates. appId", zzej.zza(zzae.zza), e);
        }
    }

    @WorkerThread
    public final void zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            zzr().zzx().zza("Deleted user attribute rows", Integer.valueOf(c_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting user attribute. appId", zzej.zza(str), zzo().zzc(str2), e);
        }
    }

    @WorkerThread
    public final boolean zza(zzjy zzjy) {
        Preconditions.checkNotNull(zzjy);
        zzd();
        zzak();
        if (zzc(zzjy.zza, zzjy.zzc) == null) {
            if (zzjx.zza(zzjy.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzjy.zza}) >= 25) {
                    return false;
                }
            } else if (!zzt().zze(zzjy.zza, zzak.zzbg)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzjy.zza, zzjy.zzb}) >= 25) {
                    return false;
                }
            } else if (!"_npa".equals(zzjy.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzjy.zza, zzjy.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzjy.zza);
        contentValues.put("origin", zzjy.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzjy.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzjy.zzd));
        zza(contentValues, "value", zzjy.zze);
        try {
            if (c_().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update user property (got -1). appId", zzej.zza(zzjy.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing user property. appId", zzej.zza(zzjy.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00ae  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzjy zzc(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzd()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.c_()     // Catch:{ SQLiteException -> 0x0088, all -> 0x0083 }
            java.lang.String r11 = "user_attributes"
            r0 = 3
            java.lang.String[] r12 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0088, all -> 0x0083 }
            java.lang.String r0 = "set_timestamp"
            r1 = 0
            r12[r1] = r0     // Catch:{ SQLiteException -> 0x0088, all -> 0x0083 }
            java.lang.String r0 = "value"
            r2 = 1
            r12[r2] = r0     // Catch:{ SQLiteException -> 0x0088, all -> 0x0083 }
            java.lang.String r0 = "origin"
            r3 = 2
            r12[r3] = r0     // Catch:{ SQLiteException -> 0x0088, all -> 0x0083 }
            java.lang.String r13 = "app_id=? and name=?"
            java.lang.String[] r14 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0088, all -> 0x0083 }
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x0088, all -> 0x0083 }
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x0088, all -> 0x0083 }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0088, all -> 0x0083 }
            boolean r0 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x007f, all -> 0x007b }
            if (r0 != 0) goto L_0x0044
            if (r10 == 0) goto L_0x0043
            r10.close()
        L_0x0043:
            return r9
        L_0x0044:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x007f, all -> 0x007b }
            r11 = r18
            java.lang.Object r7 = r11.zza((android.database.Cursor) r10, (int) r2)     // Catch:{ SQLiteException -> 0x0079 }
            java.lang.String r3 = r10.getString(r3)     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.measurement.internal.zzjy r0 = new com.google.android.gms.measurement.internal.zzjy     // Catch:{ SQLiteException -> 0x0079 }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x0079 }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x0079 }
            if (r1 == 0) goto L_0x0073
            com.google.android.gms.measurement.internal.zzej r1 = r18.zzr()     // Catch:{ SQLiteException -> 0x0079 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x0079 }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x0079 }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x0079 }
        L_0x0073:
            if (r10 == 0) goto L_0x0078
            r10.close()
        L_0x0078:
            return r0
        L_0x0079:
            r0 = move-exception
            goto L_0x008c
        L_0x007b:
            r0 = move-exception
            r11 = r18
            goto L_0x00ac
        L_0x007f:
            r0 = move-exception
            r11 = r18
            goto L_0x008c
        L_0x0083:
            r0 = move-exception
            r11 = r18
            r10 = r9
            goto L_0x00ac
        L_0x0088:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x008c:
            com.google.android.gms.measurement.internal.zzej r1 = r18.zzr()     // Catch:{ all -> 0x00ab }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ all -> 0x00ab }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r19)     // Catch:{ all -> 0x00ab }
            com.google.android.gms.measurement.internal.zzeh r4 = r18.zzo()     // Catch:{ all -> 0x00ab }
            java.lang.String r4 = r4.zzc(r8)     // Catch:{ all -> 0x00ab }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x00ab }
            if (r10 == 0) goto L_0x00aa
            r10.close()
        L_0x00aa:
            return r9
        L_0x00ab:
            r0 = move-exception
        L_0x00ac:
            if (r10 == 0) goto L_0x00b1
            r10.close()
        L_0x00b1:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzjy");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00b8  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzjy> zza(java.lang.String r23) {
        /*
            r22 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzd()
            r22.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r22.c_()     // Catch:{ SQLiteException -> 0x009a, all -> 0x0095 }
            java.lang.String r3 = "user_attributes"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x009a, all -> 0x0095 }
            java.lang.String r5 = "name"
            r11 = 0
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x009a, all -> 0x0095 }
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch:{ SQLiteException -> 0x009a, all -> 0x0095 }
            java.lang.String r5 = "set_timestamp"
            r13 = 2
            r4[r13] = r5     // Catch:{ SQLiteException -> 0x009a, all -> 0x0095 }
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch:{ SQLiteException -> 0x009a, all -> 0x0095 }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x009a, all -> 0x0095 }
            r6[r11] = r23     // Catch:{ SQLiteException -> 0x009a, all -> 0x0095 }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "1000"
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x009a, all -> 0x0095 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r3 != 0) goto L_0x0048
            if (r2 == 0) goto L_0x0047
            r2.close()
        L_0x0047:
            return r0
        L_0x0048:
            java.lang.String r18 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            java.lang.String r3 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            if (r3 != 0) goto L_0x0054
            java.lang.String r3 = ""
        L_0x0054:
            r17 = r3
            long r19 = r2.getLong(r13)     // Catch:{ SQLiteException -> 0x0091, all -> 0x008d }
            r3 = r22
            java.lang.Object r21 = r3.zza((android.database.Cursor) r2, (int) r14)     // Catch:{ SQLiteException -> 0x008b }
            if (r21 != 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzej r4 = r22.zzr()     // Catch:{ SQLiteException -> 0x008b }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()     // Catch:{ SQLiteException -> 0x008b }
            java.lang.String r5 = "Read invalid user property value, ignoring it. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r23)     // Catch:{ SQLiteException -> 0x008b }
            r4.zza(r5, r6)     // Catch:{ SQLiteException -> 0x008b }
            goto L_0x007f
        L_0x0074:
            com.google.android.gms.measurement.internal.zzjy r4 = new com.google.android.gms.measurement.internal.zzjy     // Catch:{ SQLiteException -> 0x008b }
            r15 = r4
            r16 = r23
            r15.<init>(r16, r17, r18, r19, r21)     // Catch:{ SQLiteException -> 0x008b }
            r0.add(r4)     // Catch:{ SQLiteException -> 0x008b }
        L_0x007f:
            boolean r4 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x008b }
            if (r4 != 0) goto L_0x0048
            if (r2 == 0) goto L_0x008a
            r2.close()
        L_0x008a:
            return r0
        L_0x008b:
            r0 = move-exception
            goto L_0x009e
        L_0x008d:
            r0 = move-exception
            r3 = r22
            goto L_0x00b6
        L_0x0091:
            r0 = move-exception
            r3 = r22
            goto L_0x009e
        L_0x0095:
            r0 = move-exception
            r3 = r22
            r2 = r1
            goto L_0x00b6
        L_0x009a:
            r0 = move-exception
            r3 = r22
            r2 = r1
        L_0x009e:
            com.google.android.gms.measurement.internal.zzej r4 = r22.zzr()     // Catch:{ all -> 0x00b5 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()     // Catch:{ all -> 0x00b5 }
            java.lang.String r5 = "Error querying user properties. appId"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r23)     // Catch:{ all -> 0x00b5 }
            r4.zza(r5, r6, r0)     // Catch:{ all -> 0x00b5 }
            if (r2 == 0) goto L_0x00b4
            r2.close()
        L_0x00b4:
            return r1
        L_0x00b5:
            r0 = move-exception
        L_0x00b6:
            if (r2 == 0) goto L_0x00bb
            r2.close()
        L_0x00bb:
            goto L_0x00bd
        L_0x00bc:
            throw r0
        L_0x00bd:
            goto L_0x00bc
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x011b, code lost:
        r14 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0122, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0123, code lost:
        r14 = r21;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0126, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0127, code lost:
        r14 = r21;
        r11 = r22;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0122 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x000f] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0149  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzjy> zza(java.lang.String r22, java.lang.String r23, java.lang.String r24) {
        /*
            r21 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r22)
            r21.zzd()
            r21.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0126, all -> 0x0122 }
            r3 = 3
            r2.<init>(r3)     // Catch:{ SQLiteException -> 0x0126, all -> 0x0122 }
            r11 = r22
            r2.add(r11)     // Catch:{ SQLiteException -> 0x011e, all -> 0x0122 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x011e, all -> 0x0122 }
            java.lang.String r5 = "app_id=?"
            r4.<init>(r5)     // Catch:{ SQLiteException -> 0x011e, all -> 0x0122 }
            boolean r5 = android.text.TextUtils.isEmpty(r23)     // Catch:{ SQLiteException -> 0x011e, all -> 0x0122 }
            if (r5 != 0) goto L_0x0032
            r5 = r23
            r2.add(r5)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r6 = " and origin=?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            goto L_0x0034
        L_0x0032:
            r5 = r23
        L_0x0034:
            boolean r6 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            if (r6 != 0) goto L_0x004c
            java.lang.String r6 = java.lang.String.valueOf(r24)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r7 = "*"
            java.lang.String r6 = r6.concat(r7)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            r2.add(r6)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r6 = " and name glob ?"
            r4.append(r6)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
        L_0x004c:
            int r6 = r2.size()     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.Object[] r2 = r2.toArray(r6)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            r16 = r2
            java.lang.String[] r16 = (java.lang.String[]) r16     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            android.database.sqlite.SQLiteDatabase r12 = r21.c_()     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r13 = "user_attributes"
            r2 = 4
            java.lang.String[] r14 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r2 = "name"
            r10 = 0
            r14[r10] = r2     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r2 = "set_timestamp"
            r8 = 1
            r14[r8] = r2     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r2 = "value"
            r9 = 2
            r14[r9] = r2     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r2 = "origin"
            r14[r3] = r2     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            java.lang.String r15 = r4.toString()     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            r17 = 0
            r18 = 0
            java.lang.String r19 = "rowid"
            java.lang.String r20 = "1001"
            android.database.Cursor r2 = r12.query(r13, r14, r15, r16, r17, r18, r19, r20)     // Catch:{ SQLiteException -> 0x011a, all -> 0x0122 }
            boolean r4 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            if (r4 != 0) goto L_0x0092
            if (r2 == 0) goto L_0x0091
            r2.close()
        L_0x0091:
            return r0
        L_0x0092:
            int r4 = r0.size()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            r6 = 1000(0x3e8, float:1.401E-42)
            if (r4 < r6) goto L_0x00ae
            com.google.android.gms.measurement.internal.zzej r3 = r21.zzr()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            java.lang.String r4 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            r3.zza(r4, r6)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            r14 = r21
            goto L_0x00fb
        L_0x00ae:
            java.lang.String r7 = r2.getString(r10)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            long r12 = r2.getLong(r8)     // Catch:{ SQLiteException -> 0x0116, all -> 0x0112 }
            r14 = r21
            java.lang.Object r15 = r14.zza((android.database.Cursor) r2, (int) r9)     // Catch:{ SQLiteException -> 0x0110 }
            java.lang.String r6 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x0110 }
            if (r15 != 0) goto L_0x00e0
            com.google.android.gms.measurement.internal.zzej r4 = r21.zzr()     // Catch:{ SQLiteException -> 0x00dd }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()     // Catch:{ SQLiteException -> 0x00dd }
            java.lang.String r5 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r22)     // Catch:{ SQLiteException -> 0x00dd }
            r12 = r24
            r4.zza(r5, r7, r6, r12)     // Catch:{ SQLiteException -> 0x00dd }
            r17 = r6
            r12 = 0
            r18 = 2
            r19 = 1
            goto L_0x00f5
        L_0x00dd:
            r0 = move-exception
            r5 = r6
            goto L_0x012e
        L_0x00e0:
            com.google.android.gms.measurement.internal.zzjy r5 = new com.google.android.gms.measurement.internal.zzjy     // Catch:{ SQLiteException -> 0x010a }
            r4 = r5
            r3 = r5
            r5 = r22
            r17 = r6
            r18 = 2
            r19 = 1
            r8 = r12
            r12 = 0
            r10 = r15
            r4.<init>(r5, r6, r7, r8, r10)     // Catch:{ SQLiteException -> 0x0108 }
            r0.add(r3)     // Catch:{ SQLiteException -> 0x0108 }
        L_0x00f5:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0108 }
            if (r3 != 0) goto L_0x0101
        L_0x00fb:
            if (r2 == 0) goto L_0x0100
            r2.close()
        L_0x0100:
            return r0
        L_0x0101:
            r5 = r17
            r3 = 3
            r8 = 1
            r9 = 2
            r10 = 0
            goto L_0x0092
        L_0x0108:
            r0 = move-exception
            goto L_0x010d
        L_0x010a:
            r0 = move-exception
            r17 = r6
        L_0x010d:
            r5 = r17
            goto L_0x012e
        L_0x0110:
            r0 = move-exception
            goto L_0x012e
        L_0x0112:
            r0 = move-exception
            r14 = r21
            goto L_0x0146
        L_0x0116:
            r0 = move-exception
            r14 = r21
            goto L_0x012e
        L_0x011a:
            r0 = move-exception
            r14 = r21
            goto L_0x012d
        L_0x011e:
            r0 = move-exception
            r14 = r21
            goto L_0x012b
        L_0x0122:
            r0 = move-exception
            r14 = r21
            goto L_0x0147
        L_0x0126:
            r0 = move-exception
            r14 = r21
            r11 = r22
        L_0x012b:
            r5 = r23
        L_0x012d:
            r2 = r1
        L_0x012e:
            com.google.android.gms.measurement.internal.zzej r3 = r21.zzr()     // Catch:{ all -> 0x0145 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ all -> 0x0145 }
            java.lang.String r4 = "(2)Error querying user properties"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r22)     // Catch:{ all -> 0x0145 }
            r3.zza(r4, r6, r5, r0)     // Catch:{ all -> 0x0145 }
            if (r2 == 0) goto L_0x0144
            r2.close()
        L_0x0144:
            return r1
        L_0x0145:
            r0 = move-exception
        L_0x0146:
            r1 = r2
        L_0x0147:
            if (r1 == 0) goto L_0x014c
            r1.close()
        L_0x014c:
            goto L_0x014e
        L_0x014d:
            throw r0
        L_0x014e:
            goto L_0x014d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    @WorkerThread
    public final boolean zza(zzq zzq) {
        Preconditions.checkNotNull(zzq);
        zzd();
        zzak();
        if (zzc(zzq.zza, zzq.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{zzq.zza}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzq.zza);
        contentValues.put("origin", zzq.zzb);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzq.zzc.zza);
        zza(contentValues, "value", zzq.zzc.zza());
        contentValues.put("active", Boolean.valueOf(zzq.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzq.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzq.zzh));
        zzp();
        contentValues.put("timed_out_event", zzjx.zza((Parcelable) zzq.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzq.zzd));
        zzp();
        contentValues.put("triggered_event", zzjx.zza((Parcelable) zzq.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzq.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzq.zzj));
        zzp();
        contentValues.put("expired_event", zzjx.zza((Parcelable) zzq.zzk));
        try {
            if (c_().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update conditional user property (got -1)", zzej.zza(zzq.zza));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing conditional user property", zzej.zza(zzq.zza), e);
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0155  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzq zzd(java.lang.String r33, java.lang.String r34) {
        /*
            r32 = this;
            r7 = r34
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r33)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r34)
            r32.zzd()
            r32.zzak()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r32.c_()     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r10 = "conditional_properties"
            r0 = 11
            java.lang.String[] r11 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "origin"
            r1 = 0
            r11[r1] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "value"
            r2 = 1
            r11[r2] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "active"
            r3 = 2
            r11[r3] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "trigger_event_name"
            r4 = 3
            r11[r4] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "trigger_timeout"
            r5 = 4
            r11[r5] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "timed_out_event"
            r6 = 5
            r11[r6] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "creation_timestamp"
            r15 = 6
            r11[r15] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "triggered_event"
            r14 = 7
            r11[r14] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "triggered_timestamp"
            r13 = 8
            r11[r13] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "time_to_live"
            r12 = 9
            r11[r12] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "expired_event"
            r6 = 10
            r11[r6] = r0     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            java.lang.String r0 = "app_id=? and name=?"
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            r13[r1] = r33     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            r17 = 0
            r18 = 0
            r19 = 0
            r6 = 9
            r12 = r0
            r0 = 8
            r6 = 7
            r14 = r17
            r0 = 6
            r15 = r18
            r16 = r19
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x012f, all -> 0x012a }
            boolean r10 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x0126, all -> 0x0122 }
            if (r10 != 0) goto L_0x007e
            if (r9 == 0) goto L_0x007d
            r9.close()
        L_0x007d:
            return r8
        L_0x007e:
            java.lang.String r19 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x0126, all -> 0x0122 }
            r10 = r32
            java.lang.Object r11 = r10.zza((android.database.Cursor) r9, (int) r2)     // Catch:{ SQLiteException -> 0x0120 }
            int r3 = r9.getInt(r3)     // Catch:{ SQLiteException -> 0x0120 }
            if (r3 == 0) goto L_0x0091
            r23 = 1
            goto L_0x0093
        L_0x0091:
            r23 = 0
        L_0x0093:
            java.lang.String r24 = r9.getString(r4)     // Catch:{ SQLiteException -> 0x0120 }
            long r26 = r9.getLong(r5)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzjt r1 = r32.zzg()     // Catch:{ SQLiteException -> 0x0120 }
            r2 = 5
            byte[] r2 = r9.getBlob(r2)     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r3 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable r1 = r1.zza((byte[]) r2, r3)     // Catch:{ SQLiteException -> 0x0120 }
            r25 = r1
            com.google.android.gms.measurement.internal.zzai r25 = (com.google.android.gms.measurement.internal.zzai) r25     // Catch:{ SQLiteException -> 0x0120 }
            long r12 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzjt r0 = r32.zzg()     // Catch:{ SQLiteException -> 0x0120 }
            byte[] r1 = r9.getBlob(r6)     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r2 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x0120 }
            r28 = r0
            com.google.android.gms.measurement.internal.zzai r28 = (com.google.android.gms.measurement.internal.zzai) r28     // Catch:{ SQLiteException -> 0x0120 }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0120 }
            r0 = 9
            long r29 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzjt r0 = r32.zzg()     // Catch:{ SQLiteException -> 0x0120 }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r2 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ SQLiteException -> 0x0120 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x0120 }
            r31 = r0
            com.google.android.gms.measurement.internal.zzai r31 = (com.google.android.gms.measurement.internal.zzai) r31     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzjw r20 = new com.google.android.gms.measurement.internal.zzjw     // Catch:{ SQLiteException -> 0x0120 }
            r1 = r20
            r2 = r34
            r5 = r11
            r6 = r19
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzq r0 = new com.google.android.gms.measurement.internal.zzq     // Catch:{ SQLiteException -> 0x0120 }
            r17 = r0
            r18 = r33
            r21 = r12
            r17.<init>(r18, r19, r20, r21, r23, r24, r25, r26, r28, r29, r31)     // Catch:{ SQLiteException -> 0x0120 }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x0120 }
            if (r1 == 0) goto L_0x011a
            com.google.android.gms.measurement.internal.zzej r1 = r32.zzr()     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x0120 }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r33)     // Catch:{ SQLiteException -> 0x0120 }
            com.google.android.gms.measurement.internal.zzeh r4 = r32.zzo()     // Catch:{ SQLiteException -> 0x0120 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ SQLiteException -> 0x0120 }
            r1.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x0120 }
        L_0x011a:
            if (r9 == 0) goto L_0x011f
            r9.close()
        L_0x011f:
            return r0
        L_0x0120:
            r0 = move-exception
            goto L_0x0133
        L_0x0122:
            r0 = move-exception
            r10 = r32
            goto L_0x0153
        L_0x0126:
            r0 = move-exception
            r10 = r32
            goto L_0x0133
        L_0x012a:
            r0 = move-exception
            r10 = r32
            r9 = r8
            goto L_0x0153
        L_0x012f:
            r0 = move-exception
            r10 = r32
            r9 = r8
        L_0x0133:
            com.google.android.gms.measurement.internal.zzej r1 = r32.zzr()     // Catch:{ all -> 0x0152 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ all -> 0x0152 }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r33)     // Catch:{ all -> 0x0152 }
            com.google.android.gms.measurement.internal.zzeh r4 = r32.zzo()     // Catch:{ all -> 0x0152 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ all -> 0x0152 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0152 }
            if (r9 == 0) goto L_0x0151
            r9.close()
        L_0x0151:
            return r8
        L_0x0152:
            r0 = move-exception
        L_0x0153:
            if (r9 == 0) goto L_0x0158
            r9.close()
        L_0x0158:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzq");
    }

    @WorkerThread
    public final int zze(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        try {
            return c_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting conditional property", zzej.zza(str), zzo().zzc(str2), e);
            return 0;
        }
    }

    @WorkerThread
    public final List<zzq> zzb(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(String.valueOf(str3).concat(Marker.ANY_MARKER));
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x016d  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0175  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzq> zza(java.lang.String r40, java.lang.String[] r41) {
        /*
            r39 = this;
            r39.zzd()
            r39.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r2 = r39.c_()     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r3 = "conditional_properties"
            r4 = 13
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "app_id"
            r11 = 0
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "origin"
            r12 = 1
            r4[r12] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "name"
            r13 = 2
            r4[r13] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "value"
            r14 = 3
            r4[r14] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "active"
            r15 = 4
            r4[r15] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "trigger_event_name"
            r10 = 5
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "trigger_timeout"
            r9 = 6
            r4[r9] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "timed_out_event"
            r8 = 7
            r4[r8] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "creation_timestamp"
            r7 = 8
            r4[r7] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "triggered_event"
            r6 = 9
            r4[r6] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "triggered_timestamp"
            r1 = 10
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "time_to_live"
            r1 = 11
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            java.lang.String r5 = "expired_event"
            r1 = 12
            r4[r1] = r5     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            r19 = 0
            r20 = 0
            java.lang.String r21 = "rowid"
            java.lang.String r22 = "1001"
            r5 = r40
            r1 = 9
            r6 = r41
            r1 = 8
            r7 = r19
            r1 = 7
            r8 = r20
            r1 = 6
            r9 = r21
            r1 = 5
            r10 = r22
            android.database.Cursor r2 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x0158, all -> 0x0155 }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            if (r3 != 0) goto L_0x0086
            if (r2 == 0) goto L_0x0085
            r2.close()
        L_0x0085:
            return r0
        L_0x0086:
            int r3 = r0.size()     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r4 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r4) goto L_0x00a1
            com.google.android.gms.measurement.internal.zzej r1 = r39.zzr()     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            java.lang.String r3 = "Read more than the max allowed conditional properties, ignoring extra"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r1.zza(r3, r4)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            goto L_0x0146
        L_0x00a1:
            java.lang.String r3 = r2.getString(r11)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            java.lang.String r10 = r2.getString(r12)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            java.lang.String r5 = r2.getString(r13)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r9 = r39
            java.lang.Object r8 = r9.zza((android.database.Cursor) r2, (int) r14)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            int r4 = r2.getInt(r15)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            if (r4 == 0) goto L_0x00bc
            r22 = 1
            goto L_0x00be
        L_0x00bc:
            r22 = 0
        L_0x00be:
            java.lang.String r24 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r6 = 6
            long r25 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzjt r4 = r39.zzg()     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r7 = 7
            byte[] r1 = r2.getBlob(r7)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r6 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            android.os.Parcelable r1 = r4.zza((byte[]) r1, r6)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzai r1 = (com.google.android.gms.measurement.internal.zzai) r1     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r6 = 8
            long r27 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzjt r4 = r39.zzg()     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r11 = 9
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r7 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            android.os.Parcelable r4 = r4.zza((byte[]) r6, r7)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r29 = r4
            com.google.android.gms.measurement.internal.zzai r29 = (com.google.android.gms.measurement.internal.zzai) r29     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r6 = 10
            long r16 = r2.getLong(r6)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r7 = 11
            long r31 = r2.getLong(r7)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzjt r4 = r39.zzg()     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r11 = 12
            byte[] r6 = r2.getBlob(r11)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzai> r7 = com.google.android.gms.measurement.internal.zzai.CREATOR     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            android.os.Parcelable r4 = r4.zza((byte[]) r6, r7)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r30 = r4
            com.google.android.gms.measurement.internal.zzai r30 = (com.google.android.gms.measurement.internal.zzai) r30     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzjw r33 = new com.google.android.gms.measurement.internal.zzjw     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r4 = r33
            r34 = 11
            r35 = 10
            r36 = 8
            r37 = 7
            r38 = 6
            r6 = r16
            r9 = r10
            r4.<init>(r5, r6, r8, r9)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            com.google.android.gms.measurement.internal.zzq r4 = new com.google.android.gms.measurement.internal.zzq     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r16 = r4
            r17 = r3
            r18 = r10
            r19 = r33
            r20 = r27
            r23 = r24
            r24 = r1
            r27 = r29
            r28 = r31
            r16.<init>(r17, r18, r19, r20, r22, r23, r24, r25, r27, r28, r30)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            r0.add(r4)     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            boolean r1 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x0152, all -> 0x0150 }
            if (r1 != 0) goto L_0x014c
        L_0x0146:
            if (r2 == 0) goto L_0x014b
            r2.close()
        L_0x014b:
            return r0
        L_0x014c:
            r1 = 5
            r11 = 0
            goto L_0x0086
        L_0x0150:
            r0 = move-exception
            goto L_0x0173
        L_0x0152:
            r0 = move-exception
            r1 = r2
            goto L_0x015a
        L_0x0155:
            r0 = move-exception
            r2 = 0
            goto L_0x0173
        L_0x0158:
            r0 = move-exception
            r1 = 0
        L_0x015a:
            com.google.android.gms.measurement.internal.zzej r2 = r39.zzr()     // Catch:{ all -> 0x0171 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()     // Catch:{ all -> 0x0171 }
            java.lang.String r3 = "Error querying conditional user property value"
            r2.zza(r3, r0)     // Catch:{ all -> 0x0171 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0171 }
            if (r1 == 0) goto L_0x0170
            r1.close()
        L_0x0170:
            return r0
        L_0x0171:
            r0 = move-exception
            r2 = r1
        L_0x0173:
            if (r2 == 0) goto L_0x0178
            r2.close()
        L_0x0178:
            goto L_0x017a
        L_0x0179:
            throw r0
        L_0x017a:
            goto L_0x0179
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.String, java.lang.String[]):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x018d A[Catch:{ SQLiteException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0191 A[Catch:{ SQLiteException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01c5 A[Catch:{ SQLiteException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x01c8 A[Catch:{ SQLiteException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x01d7 A[Catch:{ SQLiteException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0207 A[Catch:{ SQLiteException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x020a A[Catch:{ SQLiteException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0219 A[Catch:{ SQLiteException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0234 A[Catch:{ SQLiteException -> 0x024b }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0278  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzf zzb(java.lang.String r21) {
        /*
            r20 = this;
            r1 = r21
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r21)
            r20.zzd()
            r20.zzak()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r20.c_()     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r4 = "apps"
            r0 = 28
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "app_instance_id"
            r11 = 0
            r5[r11] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "gmp_app_id"
            r12 = 1
            r5[r12] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "resettable_device_id_hash"
            r13 = 2
            r5[r13] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "last_bundle_index"
            r14 = 3
            r5[r14] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "last_bundle_start_timestamp"
            r15 = 4
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "last_bundle_end_timestamp"
            r10 = 5
            r5[r10] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "app_version"
            r9 = 6
            r5[r9] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 7
            java.lang.String r6 = "app_store"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 8
            java.lang.String r6 = "gmp_version"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 9
            java.lang.String r6 = "dev_cert_hash"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "measurement_enabled"
            r8 = 10
            r5[r8] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 11
            java.lang.String r6 = "day"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 12
            java.lang.String r6 = "daily_public_events_count"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 13
            java.lang.String r6 = "daily_events_count"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 14
            java.lang.String r6 = "daily_conversions_count"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 15
            java.lang.String r6 = "config_fetched_time"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 16
            java.lang.String r6 = "failed_config_fetch_time"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "app_version_int"
            r7 = 17
            r5[r7] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 18
            java.lang.String r6 = "firebase_instance_id"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 19
            java.lang.String r6 = "daily_error_events_count"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 20
            java.lang.String r6 = "daily_realtime_events_count"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 21
            java.lang.String r6 = "health_monitor_sample"
            r5[r0] = r6     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "android_id"
            r6 = 22
            r5[r6] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "adid_reporting_enabled"
            r15 = 23
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "ssaid_reporting_enabled"
            r15 = 24
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r0 = 25
            java.lang.String r16 = "admob_app_id"
            r5[r0] = r16     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "dynamite_version"
            r15 = 26
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "safelisted_events"
            r15 = 27
            r5[r15] = r0     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            java.lang.String r0 = "app_id=?"
            java.lang.String[] r7 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            r17 = 0
            r18 = 0
            r19 = 0
            r15 = 22
            r6 = r0
            r0 = 17
            r15 = 10
            r8 = r17
            r0 = 6
            r9 = r18
            r15 = 5
            r10 = r19
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x025a, all -> 0x0255 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x0251, all -> 0x024d }
            if (r4 != 0) goto L_0x00e1
            if (r3 == 0) goto L_0x00e0
            r3.close()
        L_0x00e0:
            return r2
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzf r4 = new com.google.android.gms.measurement.internal.zzf     // Catch:{ SQLiteException -> 0x0251, all -> 0x024d }
            r5 = r20
            com.google.android.gms.measurement.internal.zzjp r6 = r5.zza     // Catch:{ SQLiteException -> 0x024b }
            com.google.android.gms.measurement.internal.zzfn r6 = r6.zzs()     // Catch:{ SQLiteException -> 0x024b }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x024b }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x024b }
            r4.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x024b }
            java.lang.String r6 = r3.getString(r12)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzb((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x024b }
            java.lang.String r6 = r3.getString(r13)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzd((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x024b }
            long r6 = r3.getLong(r14)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzg((long) r6)     // Catch:{ SQLiteException -> 0x024b }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x024b }
            r4.zza((long) r6)     // Catch:{ SQLiteException -> 0x024b }
            long r6 = r3.getLong(r15)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzb((long) r6)     // Catch:{ SQLiteException -> 0x024b }
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzf((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 7
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzg((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 8
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzd((long) r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 9
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zze((long) r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 10
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r6 != 0) goto L_0x014b
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r0 == 0) goto L_0x0149
            goto L_0x014b
        L_0x0149:
            r0 = 0
            goto L_0x014c
        L_0x014b:
            r0 = 1
        L_0x014c:
            r4.zza((boolean) r0)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 11
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzj(r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 12
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzk(r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 13
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzl(r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 14
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzm(r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 15
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzh((long) r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 16
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzi(r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 17
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r6 == 0) goto L_0x0191
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0196
        L_0x0191:
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x024b }
            long r6 = (long) r0     // Catch:{ SQLiteException -> 0x024b }
        L_0x0196:
            r4.zzc((long) r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 18
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zze((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 19
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzo(r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 20
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzn(r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 21
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzh((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 22
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r6 == 0) goto L_0x01c8
            r6 = 0
            goto L_0x01cc
        L_0x01c8:
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
        L_0x01cc:
            r4.zzp(r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 23
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r6 != 0) goto L_0x01e0
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r0 == 0) goto L_0x01de
            goto L_0x01e0
        L_0x01de:
            r0 = 0
            goto L_0x01e1
        L_0x01e0:
            r0 = 1
        L_0x01e1:
            r4.zzb((boolean) r0)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 24
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r6 != 0) goto L_0x01f2
            int r0 = r3.getInt(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r0 == 0) goto L_0x01f3
        L_0x01f2:
            r11 = 1
        L_0x01f3:
            r4.zzc((boolean) r11)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 25
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zzc((java.lang.String) r0)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 26
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r6 == 0) goto L_0x020a
            r6 = 0
            goto L_0x020e
        L_0x020a:
            long r6 = r3.getLong(r0)     // Catch:{ SQLiteException -> 0x024b }
        L_0x020e:
            r4.zzf((long) r6)     // Catch:{ SQLiteException -> 0x024b }
            r0 = 27
            boolean r6 = r3.isNull(r0)     // Catch:{ SQLiteException -> 0x024b }
            if (r6 != 0) goto L_0x022b
            java.lang.String r0 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x024b }
            java.lang.String r6 = ","
            r7 = -1
            java.lang.String[] r0 = r0.split(r6, r7)     // Catch:{ SQLiteException -> 0x024b }
            java.util.List r0 = java.util.Arrays.asList(r0)     // Catch:{ SQLiteException -> 0x024b }
            r4.zza((java.util.List<java.lang.String>) r0)     // Catch:{ SQLiteException -> 0x024b }
        L_0x022b:
            r4.zza()     // Catch:{ SQLiteException -> 0x024b }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x024b }
            if (r0 == 0) goto L_0x0245
            com.google.android.gms.measurement.internal.zzej r0 = r20.zzr()     // Catch:{ SQLiteException -> 0x024b }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzf()     // Catch:{ SQLiteException -> 0x024b }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r21)     // Catch:{ SQLiteException -> 0x024b }
            r0.zza(r6, r7)     // Catch:{ SQLiteException -> 0x024b }
        L_0x0245:
            if (r3 == 0) goto L_0x024a
            r3.close()
        L_0x024a:
            return r4
        L_0x024b:
            r0 = move-exception
            goto L_0x025e
        L_0x024d:
            r0 = move-exception
            r5 = r20
            goto L_0x0276
        L_0x0251:
            r0 = move-exception
            r5 = r20
            goto L_0x025e
        L_0x0255:
            r0 = move-exception
            r5 = r20
            r3 = r2
            goto L_0x0276
        L_0x025a:
            r0 = move-exception
            r5 = r20
            r3 = r2
        L_0x025e:
            com.google.android.gms.measurement.internal.zzej r4 = r20.zzr()     // Catch:{ all -> 0x0275 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()     // Catch:{ all -> 0x0275 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r21)     // Catch:{ all -> 0x0275 }
            r4.zza(r6, r1, r0)     // Catch:{ all -> 0x0275 }
            if (r3 == 0) goto L_0x0274
            r3.close()
        L_0x0274:
            return r2
        L_0x0275:
            r0 = move-exception
        L_0x0276:
            if (r3 == 0) goto L_0x027b
            r3.close()
        L_0x027b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzb(java.lang.String):com.google.android.gms.measurement.internal.zzf");
    }

    @WorkerThread
    public final void zza(zzf zzf2) {
        Preconditions.checkNotNull(zzf2);
        zzd();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzf2.zzb());
        contentValues.put("app_instance_id", zzf2.zzc());
        contentValues.put("gmp_app_id", zzf2.zzd());
        contentValues.put("resettable_device_id_hash", zzf2.zzf());
        contentValues.put("last_bundle_index", Long.valueOf(zzf2.zzq()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzf2.zzh()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzf2.zzi()));
        contentValues.put("app_version", zzf2.zzj());
        contentValues.put("app_store", zzf2.zzl());
        contentValues.put("gmp_version", Long.valueOf(zzf2.zzm()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzf2.zzn()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzf2.zzp()));
        contentValues.put("day", Long.valueOf(zzf2.zzu()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzf2.zzv()));
        contentValues.put("daily_events_count", Long.valueOf(zzf2.zzw()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzf2.zzx()));
        contentValues.put("config_fetched_time", Long.valueOf(zzf2.zzr()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzf2.zzs()));
        contentValues.put("app_version_int", Long.valueOf(zzf2.zzk()));
        contentValues.put("firebase_instance_id", zzf2.zzg());
        contentValues.put("daily_error_events_count", Long.valueOf(zzf2.zzz()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzf2.zzy()));
        contentValues.put("health_monitor_sample", zzf2.zzaa());
        contentValues.put("android_id", Long.valueOf(zzf2.zzac()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzf2.zzad()));
        contentValues.put("ssaid_reporting_enabled", Boolean.valueOf(zzf2.zzae()));
        contentValues.put("admob_app_id", zzf2.zze());
        contentValues.put("dynamite_version", Long.valueOf(zzf2.zzo()));
        if (zzf2.zzag() != null) {
            if (zzf2.zzag().size() == 0) {
                zzr().zzi().zza("Safelisted events should not be an empty list. appId", zzf2.zzb());
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzf2.zzag()));
            }
        }
        try {
            SQLiteDatabase c_ = c_();
            if (((long) c_.update("apps", contentValues, "app_id = ?", new String[]{zzf2.zzb()})) == 0 && c_.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzr().zzf().zza("Failed to insert/update app (got -1). appId", zzej.zza(zzf2.zzb()));
            }
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing app. appId", zzej.zza(zzf2.zzb()), e);
        }
    }

    public final long zzc(String str) {
        Preconditions.checkNotEmpty(str);
        zzd();
        zzak();
        try {
            return (long) c_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zzt().zzb(str, zzak.zzs))))});
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error deleting over the limit events. appId", zzej.zza(str), e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012a  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzw zza(long r22, java.lang.String r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29) {
        /*
            r21 = this;
            java.lang.String r0 = "daily_realtime_events_count"
            java.lang.String r1 = "daily_error_events_count"
            java.lang.String r2 = "daily_conversions_count"
            java.lang.String r3 = "daily_public_events_count"
            java.lang.String r4 = "daily_events_count"
            java.lang.String r5 = "day"
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r24)
            r21.zzd()
            r21.zzak()
            r6 = 1
            java.lang.String[] r7 = new java.lang.String[r6]
            r8 = 0
            r7[r8] = r24
            com.google.android.gms.measurement.internal.zzw r9 = new com.google.android.gms.measurement.internal.zzw
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r15 = r21.c_()     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            java.lang.String r12 = "apps"
            r11 = 6
            java.lang.String[] r13 = new java.lang.String[r11]     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            r13[r8] = r5     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            r13[r6] = r4     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            r14 = 2
            r13[r14] = r3     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            r11 = 3
            r13[r11] = r2     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            r10 = 4
            r13[r10] = r1     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            r10 = 5
            r13[r10] = r0     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            java.lang.String r16 = "app_id=?"
            java.lang.String[] r10 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            r10[r8] = r24     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            r17 = 0
            r18 = 0
            r19 = 0
            r11 = r15
            r14 = r16
            r20 = r15
            r15 = r10
            r16 = r17
            r17 = r18
            r18 = r19
            android.database.Cursor r10 = r11.query(r12, r13, r14, r15, r16, r17, r18)     // Catch:{ SQLiteException -> 0x010e, all -> 0x010b }
            boolean r11 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0109 }
            if (r11 != 0) goto L_0x0072
            com.google.android.gms.measurement.internal.zzej r0 = r21.zzr()     // Catch:{ SQLiteException -> 0x0109 }
            com.google.android.gms.measurement.internal.zzel r0 = r0.zzi()     // Catch:{ SQLiteException -> 0x0109 }
            java.lang.String r1 = "Not updating daily counts, app is not known. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r24)     // Catch:{ SQLiteException -> 0x0109 }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0109 }
            if (r10 == 0) goto L_0x0071
            r10.close()
        L_0x0071:
            return r9
        L_0x0072:
            long r11 = r10.getLong(r8)     // Catch:{ SQLiteException -> 0x0109 }
            int r8 = (r11 > r22 ? 1 : (r11 == r22 ? 0 : -1))
            if (r8 != 0) goto L_0x009c
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0109 }
            r9.zzb = r11     // Catch:{ SQLiteException -> 0x0109 }
            r6 = 2
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0109 }
            r9.zza = r11     // Catch:{ SQLiteException -> 0x0109 }
            r6 = 3
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0109 }
            r9.zzc = r11     // Catch:{ SQLiteException -> 0x0109 }
            r6 = 4
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0109 }
            r9.zzd = r11     // Catch:{ SQLiteException -> 0x0109 }
            r6 = 5
            long r11 = r10.getLong(r6)     // Catch:{ SQLiteException -> 0x0109 }
            r9.zze = r11     // Catch:{ SQLiteException -> 0x0109 }
        L_0x009c:
            r11 = 1
            if (r25 == 0) goto L_0x00a5
            long r13 = r9.zzb     // Catch:{ SQLiteException -> 0x0109 }
            long r13 = r13 + r11
            r9.zzb = r13     // Catch:{ SQLiteException -> 0x0109 }
        L_0x00a5:
            if (r26 == 0) goto L_0x00ac
            long r13 = r9.zza     // Catch:{ SQLiteException -> 0x0109 }
            long r13 = r13 + r11
            r9.zza = r13     // Catch:{ SQLiteException -> 0x0109 }
        L_0x00ac:
            if (r27 == 0) goto L_0x00b3
            long r13 = r9.zzc     // Catch:{ SQLiteException -> 0x0109 }
            long r13 = r13 + r11
            r9.zzc = r13     // Catch:{ SQLiteException -> 0x0109 }
        L_0x00b3:
            if (r28 == 0) goto L_0x00ba
            long r13 = r9.zzd     // Catch:{ SQLiteException -> 0x0109 }
            long r13 = r13 + r11
            r9.zzd = r13     // Catch:{ SQLiteException -> 0x0109 }
        L_0x00ba:
            if (r29 == 0) goto L_0x00c1
            long r13 = r9.zze     // Catch:{ SQLiteException -> 0x0109 }
            long r13 = r13 + r11
            r9.zze = r13     // Catch:{ SQLiteException -> 0x0109 }
        L_0x00c1:
            android.content.ContentValues r6 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0109 }
            r6.<init>()     // Catch:{ SQLiteException -> 0x0109 }
            java.lang.Long r8 = java.lang.Long.valueOf(r22)     // Catch:{ SQLiteException -> 0x0109 }
            r6.put(r5, r8)     // Catch:{ SQLiteException -> 0x0109 }
            long r11 = r9.zza     // Catch:{ SQLiteException -> 0x0109 }
            java.lang.Long r5 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x0109 }
            r6.put(r3, r5)     // Catch:{ SQLiteException -> 0x0109 }
            long r11 = r9.zzb     // Catch:{ SQLiteException -> 0x0109 }
            java.lang.Long r3 = java.lang.Long.valueOf(r11)     // Catch:{ SQLiteException -> 0x0109 }
            r6.put(r4, r3)     // Catch:{ SQLiteException -> 0x0109 }
            long r3 = r9.zzc     // Catch:{ SQLiteException -> 0x0109 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0109 }
            r6.put(r2, r3)     // Catch:{ SQLiteException -> 0x0109 }
            long r2 = r9.zzd     // Catch:{ SQLiteException -> 0x0109 }
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ SQLiteException -> 0x0109 }
            r6.put(r1, r2)     // Catch:{ SQLiteException -> 0x0109 }
            long r1 = r9.zze     // Catch:{ SQLiteException -> 0x0109 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ SQLiteException -> 0x0109 }
            r6.put(r0, r1)     // Catch:{ SQLiteException -> 0x0109 }
            java.lang.String r0 = "apps"
            java.lang.String r1 = "app_id=?"
            r2 = r20
            r2.update(r0, r6, r1, r7)     // Catch:{ SQLiteException -> 0x0109 }
            if (r10 == 0) goto L_0x0108
            r10.close()
        L_0x0108:
            return r9
        L_0x0109:
            r0 = move-exception
            goto L_0x0110
        L_0x010b:
            r0 = move-exception
            r10 = 0
            goto L_0x0128
        L_0x010e:
            r0 = move-exception
            r10 = 0
        L_0x0110:
            com.google.android.gms.measurement.internal.zzej r1 = r21.zzr()     // Catch:{ all -> 0x0127 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ all -> 0x0127 }
            java.lang.String r2 = "Error updating daily counts. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r24)     // Catch:{ all -> 0x0127 }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x0127 }
            if (r10 == 0) goto L_0x0126
            r10.close()
        L_0x0126:
            return r9
        L_0x0127:
            r0 = move-exception
        L_0x0128:
            if (r10 == 0) goto L_0x012d
            r10.close()
        L_0x012d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zzw");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] zzd(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzd()
            r11.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.c_()     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            java.lang.String r2 = "apps"
            r3 = 1
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            java.lang.String r5 = "remote_config"
            r9 = 0
            r4[r9] = r5     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            java.lang.String r5 = "app_id=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            r6[r9] = r12     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            r7 = 0
            r8 = 0
            r10 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x005d, all -> 0x005a }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0058 }
            if (r2 != 0) goto L_0x0037
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            byte[] r2 = r1.getBlob(r9)     // Catch:{ SQLiteException -> 0x0058 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0058 }
            if (r3 == 0) goto L_0x0052
            com.google.android.gms.measurement.internal.zzej r3 = r11.zzr()     // Catch:{ SQLiteException -> 0x0058 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x0058 }
            java.lang.String r4 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0058 }
            r3.zza(r4, r5)     // Catch:{ SQLiteException -> 0x0058 }
        L_0x0052:
            if (r1 == 0) goto L_0x0057
            r1.close()
        L_0x0057:
            return r2
        L_0x0058:
            r2 = move-exception
            goto L_0x005f
        L_0x005a:
            r12 = move-exception
            r1 = r0
            goto L_0x0077
        L_0x005d:
            r2 = move-exception
            r1 = r0
        L_0x005f:
            com.google.android.gms.measurement.internal.zzej r3 = r11.zzr()     // Catch:{ all -> 0x0076 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ all -> 0x0076 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r12)     // Catch:{ all -> 0x0076 }
            r3.zza(r4, r12, r2)     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x0075
            r1.close()
        L_0x0075:
            return r0
        L_0x0076:
            r12 = move-exception
        L_0x0077:
            if (r1 == 0) goto L_0x007c
            r1.close()
        L_0x007c:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzd(java.lang.String):byte[]");
    }

    @WorkerThread
    public final boolean zza(zzbr.zzg zzg2, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        Preconditions.checkState(zzg2.zzk());
        zzv();
        long currentTimeMillis = zzm().currentTimeMillis();
        if (zzg2.zzl() < currentTimeMillis - zzs.zzk() || zzg2.zzl() > zzs.zzk() + currentTimeMillis) {
            zzr().zzi().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzej.zza(zzg2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzg2.zzl()));
        }
        try {
            byte[] zzc2 = zzg().zzc(zzg2.zzbh());
            zzr().zzx().zza("Saving bundle, size", Integer.valueOf(zzc2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzg2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzg2.zzl()));
            contentValues.put("data", zzc2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzg2.zzaz()) {
                contentValues.put("retry_count", Integer.valueOf(zzg2.zzba()));
            }
            try {
                if (c_().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzr().zzf().zza("Failed to insert bundle (got -1). appId", zzej.zza(zzg2.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error storing bundle. appId", zzej.zza(zzg2.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzr().zzf().zza("Data loss. Failed to serialize bundle. appId", zzej.zza(zzg2.zzx()), e2);
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String d_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.c_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x002b
        L_0x0024:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003f
        L_0x0029:
            r2 = move-exception
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.zzej r3 = r6.zzr()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.d_():java.lang.String");
    }

    public final boolean zzk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    @WorkerThread
    public final List<Pair<zzbr.zzg, Long>> zza(String str, int i, int i2) {
        int i3 = i2;
        zzd();
        zzak();
        Preconditions.checkArgument(i > 0);
        Preconditions.checkArgument(i3 > 0);
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = c_().query("queue", new String[]{"rowid", "data", "retry_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", String.valueOf(i));
            if (!cursor.moveToFirst()) {
                List<Pair<zzbr.zzg, Long>> emptyList = Collections.emptyList();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyList;
            }
            ArrayList arrayList = new ArrayList();
            int i4 = 0;
            do {
                long j = cursor.getLong(0);
                try {
                    byte[] zzb2 = zzg().zzb(cursor.getBlob(1));
                    if (!arrayList.isEmpty() && zzb2.length + i4 > i3) {
                        break;
                    }
                    try {
                        zzbr.zzg.zza zza = (zzbr.zzg.zza) zzbr.zzg.zzbe().zza(zzb2, zzeq.zzb());
                        if (!cursor.isNull(2)) {
                            zza.zzh(cursor.getInt(2));
                        }
                        i4 += zzb2.length;
                        arrayList.add(Pair.create((zzbr.zzg) ((zzfd) zza.zzu()), Long.valueOf(j)));
                    } catch (IOException e) {
                        zzr().zzf().zza("Failed to merge queued bundle. appId", zzej.zza(str), e);
                    }
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } catch (IOException e2) {
                    zzr().zzf().zza("Failed to unzip queued bundle. appId", zzej.zza(str), e2);
                }
            } while (i4 <= i3);
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e3) {
            zzr().zzf().zza("Error querying bundles. appId", zzej.zza(str), e3);
            List<Pair<zzbr.zzg, Long>> emptyList2 = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzv() {
        int delete;
        zzd();
        zzak();
        if (zzam()) {
            long zza = zzs().zzf.zza();
            long elapsedRealtime = zzm().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza) > zzak.zzab.zza(null).longValue()) {
                zzs().zzf.zza(elapsedRealtime);
                zzd();
                zzak();
                if (zzam() && (delete = c_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzm().currentTimeMillis()), String.valueOf(zzs.zzk())})) > 0) {
                    zzr().zzx().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final void zza(List<Long> list) {
        zzd();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzam()) {
            String join = TextUtils.join(",", list);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 80);
            sb3.append("SELECT COUNT(1) FROM queue WHERE rowid IN ");
            sb3.append(sb2);
            sb3.append(" AND retry_count =  2147483647 LIMIT 1");
            if (zzb(sb3.toString(), (String[]) null) > 0) {
                zzr().zzi().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                SQLiteDatabase c_ = c_();
                StringBuilder sb4 = new StringBuilder(String.valueOf(sb2).length() + 127);
                sb4.append("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN ");
                sb4.append(sb2);
                sb4.append(" AND (retry_count IS NULL OR retry_count < 2147483647)");
                c_.execSQL(sb4.toString());
            } catch (SQLiteException e) {
                zzr().zzf().zza("Error incrementing retry count. error", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(String str, zzbj.zza[] zzaArr) {
        boolean z;
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaArr);
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        try {
            zzak();
            zzd();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase c_2 = c_();
            c_2.delete("property_filters", "app_id=?", new String[]{str});
            c_2.delete("event_filters", "app_id=?", new String[]{str});
            for (zzbj.zza zza : zzaArr) {
                zzak();
                zzd();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(zza);
                if (!zza.zza()) {
                    zzr().zzi().zza("Audience with no ID. appId", zzej.zza(str));
                } else {
                    int zzb2 = zza.zzb();
                    Iterator<zzbj.zzb> it = zza.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zza()) {
                                zzr().zzi().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzej.zza(str), Integer.valueOf(zzb2));
                                break;
                            }
                        } else {
                            Iterator<zzbj.zze> it2 = zza.zzc().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zza()) {
                                        zzr().zzi().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzej.zza(str), Integer.valueOf(zzb2));
                                        break;
                                    }
                                } else {
                                    Iterator<zzbj.zzb> it3 = zza.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str, zzb2, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzbj.zze> it4 = zza.zzc().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str, zzb2, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzd();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase c_3 = c_();
                                        c_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb2)});
                                        c_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(zzb2)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzbj.zza zza2 : zzaArr) {
                arrayList.add(zza2.zza() ? Integer.valueOf(zza2.zzb()) : null);
            }
            zzb(str, (List<Integer>) arrayList);
            c_.setTransactionSuccessful();
        } finally {
            c_.endTransaction();
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbj.zzb zzb2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (TextUtils.isEmpty(zzb2.zzc())) {
            zzel zzi2 = zzr().zzi();
            Object zza = zzej.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zza()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzi2.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbh = zzb2.zzbh();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zza() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put("event_name", zzb2.zzc());
        if (zzt().zze(str, zzak.zzbu)) {
            contentValues.put("session_scoped", zzb2.zzj() ? Boolean.valueOf(zzb2.zzk()) : null);
        }
        contentValues.put("data", zzbh);
        try {
            if (c_().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert event filter (got -1). appId", zzej.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing event filter. appId", zzej.zza(str), e);
            return false;
        }
    }

    @WorkerThread
    private final boolean zza(String str, int i, zzbj.zze zze2) {
        zzak();
        zzd();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (TextUtils.isEmpty(zze2.zzc())) {
            zzel zzi2 = zzr().zzi();
            Object zza = zzej.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zza()) {
                num = Integer.valueOf(zze2.zzb());
            }
            zzi2.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbh = zze2.zzbh();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zza() ? Integer.valueOf(zze2.zzb()) : null);
        contentValues.put("property_name", zze2.zzc());
        if (zzt().zze(str, zzak.zzbu)) {
            contentValues.put("session_scoped", zze2.zzg() ? Boolean.valueOf(zze2.zzh()) : null);
        }
        contentValues.put("data", zzbh);
        try {
            if (c_().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert property filter (got -1). appId", zzej.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing property filter. appId", zzej.zza(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbj.zzb>> zzf(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.c_()
            r9 = 0
            java.lang.String r2 = "event_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            java.lang.String r5 = "app_id=? AND event_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            r6[r10] = r13     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0048
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0092 }
            if (r14 == 0) goto L_0x0047
            r14.close()
        L_0x0047:
            return r13
        L_0x0048:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.internal.measurement.zzeq r2 = com.google.android.gms.internal.measurement.zzeq.zzb()     // Catch:{ IOException -> 0x0074 }
            com.google.android.gms.internal.measurement.zzbj$zzb r1 = com.google.android.gms.internal.measurement.zzbj.zzb.zza((byte[]) r1, (com.google.android.gms.internal.measurement.zzeq) r2)     // Catch:{ IOException -> 0x0074 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0092 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0092 }
            if (r3 != 0) goto L_0x0070
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0092 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0070:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0092 }
            goto L_0x0086
        L_0x0074:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzej r2 = r12.zzr()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.String r3 = "Failed to merge filter. appId"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0092 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0086:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0048
            if (r14 == 0) goto L_0x0091
            r14.close()
        L_0x0091:
            return r0
        L_0x0092:
            r0 = move-exception
            goto L_0x0099
        L_0x0094:
            r13 = move-exception
            r14 = r9
            goto L_0x00b1
        L_0x0097:
            r0 = move-exception
            r14 = r9
        L_0x0099:
            com.google.android.gms.measurement.internal.zzej r1 = r12.zzr()     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r13)     // Catch:{ all -> 0x00b0 }
            r1.zza(r2, r13, r0)     // Catch:{ all -> 0x00b0 }
            if (r14 == 0) goto L_0x00af
            r14.close()
        L_0x00af:
            return r9
        L_0x00b0:
            r13 = move-exception
        L_0x00b1:
            if (r14 == 0) goto L_0x00b6
            r14.close()
        L_0x00b6:
            goto L_0x00b8
        L_0x00b7:
            throw r13
        L_0x00b8:
            goto L_0x00b7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzf(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.measurement.zzbj.zze>> zzg(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r12.zzak()
            r12.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r13)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r12.c_()
            r9 = 0
            java.lang.String r2 = "property_filters"
            r3 = 2
            java.lang.String[] r4 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            java.lang.String r5 = "audience_id"
            r10 = 0
            r4[r10] = r5     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            java.lang.String r5 = "data"
            r11 = 1
            r4[r11] = r5     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            java.lang.String r5 = "app_id=? AND property_name=?"
            java.lang.String[] r6 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            r6[r10] = r13     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            r6[r11] = r14     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            r14 = 0
            r7 = 0
            r8 = 0
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r14
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0097, all -> 0x0094 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0048
            java.util.Map r13 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0092 }
            if (r14 == 0) goto L_0x0047
            r14.close()
        L_0x0047:
            return r13
        L_0x0048:
            byte[] r1 = r14.getBlob(r11)     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.internal.measurement.zzeq r2 = com.google.android.gms.internal.measurement.zzeq.zzb()     // Catch:{ IOException -> 0x0074 }
            com.google.android.gms.internal.measurement.zzbj$zze r1 = com.google.android.gms.internal.measurement.zzbj.zze.zza((byte[]) r1, (com.google.android.gms.internal.measurement.zzeq) r2)     // Catch:{ IOException -> 0x0074 }
            int r2 = r14.getInt(r10)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Object r3 = r0.get(r3)     // Catch:{ SQLiteException -> 0x0092 }
            java.util.List r3 = (java.util.List) r3     // Catch:{ SQLiteException -> 0x0092 }
            if (r3 != 0) goto L_0x0070
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0092 }
            r3.<init>()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0092 }
            r0.put(r2, r3)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0070:
            r3.add(r1)     // Catch:{ SQLiteException -> 0x0092 }
            goto L_0x0086
        L_0x0074:
            r1 = move-exception
            com.google.android.gms.measurement.internal.zzej r2 = r12.zzr()     // Catch:{ SQLiteException -> 0x0092 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()     // Catch:{ SQLiteException -> 0x0092 }
            java.lang.String r3 = "Failed to merge filter"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x0092 }
            r2.zza(r3, r4, r1)     // Catch:{ SQLiteException -> 0x0092 }
        L_0x0086:
            boolean r1 = r14.moveToNext()     // Catch:{ SQLiteException -> 0x0092 }
            if (r1 != 0) goto L_0x0048
            if (r14 == 0) goto L_0x0091
            r14.close()
        L_0x0091:
            return r0
        L_0x0092:
            r0 = move-exception
            goto L_0x0099
        L_0x0094:
            r13 = move-exception
            r14 = r9
            goto L_0x00b1
        L_0x0097:
            r0 = move-exception
            r14 = r9
        L_0x0099:
            com.google.android.gms.measurement.internal.zzej r1 = r12.zzr()     // Catch:{ all -> 0x00b0 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ all -> 0x00b0 }
            java.lang.String r2 = "Database error querying filters. appId"
            java.lang.Object r13 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r13)     // Catch:{ all -> 0x00b0 }
            r1.zza(r2, r13, r0)     // Catch:{ all -> 0x00b0 }
            if (r14 == 0) goto L_0x00af
            r14.close()
        L_0x00af:
            return r9
        L_0x00b0:
            r13 = move-exception
        L_0x00b1:
            if (r14 == 0) goto L_0x00b6
            r14.close()
        L_0x00b6:
            goto L_0x00b8
        L_0x00b7:
            throw r13
        L_0x00b8:
            goto L_0x00b7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzg(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zza(java.lang.String r14, java.util.List<java.lang.String> r15) {
        /*
            r13 = this;
            r13.zzak()
            r13.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r14)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r15)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            boolean r1 = r15.isEmpty()
            if (r1 == 0) goto L_0x0018
            return r0
        L_0x0018:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "app_id=? AND property_name in ("
            r1.append(r2)
            r2 = 0
            r3 = 0
        L_0x0024:
            int r4 = r15.size()
            if (r3 >= r4) goto L_0x0039
            if (r3 <= 0) goto L_0x0031
            java.lang.String r4 = ","
            r1.append(r4)
        L_0x0031:
            java.lang.String r4 = "?"
            r1.append(r4)
            int r3 = r3 + 1
            goto L_0x0024
        L_0x0039:
            java.lang.String r3 = ")"
            r1.append(r3)
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r15)
            r3.add(r2, r14)
            android.database.sqlite.SQLiteDatabase r4 = r13.c_()
            r15 = 0
            java.lang.String r5 = "property_filters"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00ae }
            java.lang.String r7 = "audience_id"
            r6[r2] = r7     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00ae }
            java.lang.String r7 = "filter_id"
            r12 = 1
            r6[r12] = r7     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00ae }
            java.lang.String r7 = r1.toString()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00ae }
            java.lang.String[] r1 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00ae }
            java.lang.Object[] r1 = r3.toArray(r1)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00ae }
            r8 = r1
            java.lang.String[] r8 = (java.lang.String[]) r8     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00ae }
            r9 = 0
            r10 = 0
            r11 = 0
            android.database.Cursor r1 = r4.query(r5, r6, r7, r8, r9, r10, r11)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00ae }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00ac }
            if (r3 != 0) goto L_0x0079
            if (r1 == 0) goto L_0x0078
            r1.close()
        L_0x0078:
            return r0
        L_0x0079:
            int r3 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x00ac }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00ac }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ SQLiteException -> 0x00ac }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x00ac }
            if (r4 != 0) goto L_0x0095
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00ac }
            r4.<init>()     // Catch:{ SQLiteException -> 0x00ac }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00ac }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x00ac }
        L_0x0095:
            int r3 = r1.getInt(r12)     // Catch:{ SQLiteException -> 0x00ac }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x00ac }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x00ac }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x00ac }
            if (r3 != 0) goto L_0x0079
            if (r1 == 0) goto L_0x00ab
            r1.close()
        L_0x00ab:
            return r0
        L_0x00ac:
            r0 = move-exception
            goto L_0x00b3
        L_0x00ae:
            r14 = move-exception
            r1 = r15
            goto L_0x00cb
        L_0x00b1:
            r0 = move-exception
            r1 = r15
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzej r2 = r13.zzr()     // Catch:{ all -> 0x00ca }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = "Database error querying filters. appId"
            java.lang.Object r14 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r14)     // Catch:{ all -> 0x00ca }
            r2.zza(r3, r14, r0)     // Catch:{ all -> 0x00ca }
            if (r1 == 0) goto L_0x00c9
            r1.close()
        L_0x00c9:
            return r15
        L_0x00ca:
            r14 = move-exception
        L_0x00cb:
            if (r1 == 0) goto L_0x00d0
            r1.close()
        L_0x00d0:
            goto L_0x00d2
        L_0x00d1:
            throw r14
        L_0x00d2:
            goto L_0x00d1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.String, java.util.List):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0086  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, java.util.List<java.lang.Integer>> zze(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzak()
            r7.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r8)
            androidx.collection.ArrayMap r0 = new androidx.collection.ArrayMap
            r0.<init>()
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()
            r2 = 0
            java.lang.String r3 = "select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            r5 = 0
            r4[r5] = r8     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            r6 = 1
            r4[r6] = r8     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            android.database.Cursor r1 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x006a, all -> 0x0067 }
            boolean r3 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            java.util.Map r8 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0065 }
            if (r1 == 0) goto L_0x0031
            r1.close()
        L_0x0031:
            return r8
        L_0x0032:
            int r3 = r1.getInt(r5)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Object r4 = r0.get(r4)     // Catch:{ SQLiteException -> 0x0065 }
            java.util.List r4 = (java.util.List) r4     // Catch:{ SQLiteException -> 0x0065 }
            if (r4 != 0) goto L_0x004e
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0065 }
            r4.<init>()     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r0.put(r3, r4)     // Catch:{ SQLiteException -> 0x0065 }
        L_0x004e:
            int r3 = r1.getInt(r6)     // Catch:{ SQLiteException -> 0x0065 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0065 }
            r4.add(r3)     // Catch:{ SQLiteException -> 0x0065 }
            boolean r3 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0065 }
            if (r3 != 0) goto L_0x0032
            if (r1 == 0) goto L_0x0064
            r1.close()
        L_0x0064:
            return r0
        L_0x0065:
            r0 = move-exception
            goto L_0x006c
        L_0x0067:
            r8 = move-exception
            r1 = r2
            goto L_0x0084
        L_0x006a:
            r0 = move-exception
            r1 = r2
        L_0x006c:
            com.google.android.gms.measurement.internal.zzej r3 = r7.zzr()     // Catch:{ all -> 0x0083 }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ all -> 0x0083 }
            java.lang.String r4 = "Database error querying scoped filters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r8)     // Catch:{ all -> 0x0083 }
            r3.zza(r4, r8, r0)     // Catch:{ all -> 0x0083 }
            if (r1 == 0) goto L_0x0082
            r1.close()
        L_0x0082:
            return r2
        L_0x0083:
            r8 = move-exception
        L_0x0084:
            if (r1 == 0) goto L_0x0089
            r1.close()
        L_0x0089:
            goto L_0x008b
        L_0x008a:
            throw r8
        L_0x008b:
            goto L_0x008a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zze(java.lang.String):java.util.Map");
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzd();
        SQLiteDatabase c_ = c_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zzt().zzb(str, zzak.zzai)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null || !(num instanceof Integer)) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            String join = TextUtils.join(",", arrayList);
            StringBuilder sb = new StringBuilder(String.valueOf(join).length() + 2);
            sb.append("(");
            sb.append(join);
            sb.append(")");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 140);
            sb3.append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ");
            sb3.append(sb2);
            sb3.append(" order by rowid desc limit -1 offset ?)");
            return c_.delete("audience_filter_values", sb3.toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Database error querying filters. appId", zzej.zza(str), e);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0096  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map<java.lang.Integer, com.google.android.gms.internal.measurement.zzbr.zzi> zzf(java.lang.String r12) {
        /*
            r11 = this;
            r11.zzak()
            r11.zzd()
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.c_()
            r8 = 0
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            java.lang.String r3 = "audience_id"
            r9 = 0
            r2[r9] = r3     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            java.lang.String r3 = "current_results"
            r10 = 1
            r2[r10] = r3     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            java.lang.String r3 = "app_id=?"
            java.lang.String[] r4 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            r4[r9] = r12     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x007a, all -> 0x0077 }
            boolean r1 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0075 }
            if (r1 != 0) goto L_0x0036
            if (r0 == 0) goto L_0x0035
            r0.close()
        L_0x0035:
            return r8
        L_0x0036:
            androidx.collection.ArrayMap r1 = new androidx.collection.ArrayMap     // Catch:{ SQLiteException -> 0x0075 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x0075 }
        L_0x003b:
            int r2 = r0.getInt(r9)     // Catch:{ SQLiteException -> 0x0075 }
            byte[] r3 = r0.getBlob(r10)     // Catch:{ SQLiteException -> 0x0075 }
            com.google.android.gms.internal.measurement.zzeq r4 = com.google.android.gms.internal.measurement.zzeq.zzb()     // Catch:{ IOException -> 0x0053 }
            com.google.android.gms.internal.measurement.zzbr$zzi r3 = com.google.android.gms.internal.measurement.zzbr.zzi.zza((byte[]) r3, (com.google.android.gms.internal.measurement.zzeq) r4)     // Catch:{ IOException -> 0x0053 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0075 }
            r1.put(r2, r3)     // Catch:{ SQLiteException -> 0x0075 }
            goto L_0x0069
        L_0x0053:
            r3 = move-exception
            com.google.android.gms.measurement.internal.zzej r4 = r11.zzr()     // Catch:{ SQLiteException -> 0x0075 }
            com.google.android.gms.measurement.internal.zzel r4 = r4.zzf()     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Object r6 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x0075 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ SQLiteException -> 0x0075 }
            r4.zza(r5, r6, r2, r3)     // Catch:{ SQLiteException -> 0x0075 }
        L_0x0069:
            boolean r2 = r0.moveToNext()     // Catch:{ SQLiteException -> 0x0075 }
            if (r2 != 0) goto L_0x003b
            if (r0 == 0) goto L_0x0074
            r0.close()
        L_0x0074:
            return r1
        L_0x0075:
            r1 = move-exception
            goto L_0x007c
        L_0x0077:
            r12 = move-exception
            r0 = r8
            goto L_0x0094
        L_0x007a:
            r1 = move-exception
            r0 = r8
        L_0x007c:
            com.google.android.gms.measurement.internal.zzej r2 = r11.zzr()     // Catch:{ all -> 0x0093 }
            com.google.android.gms.measurement.internal.zzel r2 = r2.zzf()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "Database error querying filter results. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r12)     // Catch:{ all -> 0x0093 }
            r2.zza(r3, r12, r1)     // Catch:{ all -> 0x0093 }
            if (r0 == 0) goto L_0x0092
            r0.close()
        L_0x0092:
            return r8
        L_0x0093:
            r12 = move-exception
        L_0x0094:
            if (r0 == 0) goto L_0x0099
            r0.close()
        L_0x0099:
            goto L_0x009b
        L_0x009a:
            throw r12
        L_0x009b:
            goto L_0x009a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzf(java.lang.String):java.util.Map");
    }

    @WorkerThread
    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    @VisibleForTesting
    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzr().zzf().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzr().zzf().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzr().zzf().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    @WorkerThread
    public final long zzw() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    @VisibleForTesting
    public final long zzh(String str, String str2) {
        long j;
        String str3 = str;
        String str4 = str2;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzd();
        zzak();
        SQLiteDatabase c_ = c_();
        c_.beginTransaction();
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 32);
            sb.append("select ");
            sb.append(str4);
            sb.append(" from app2 where app_id=?");
            try {
                j = zza(sb.toString(), new String[]{str3}, -1);
                if (j == -1) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("app_id", str3);
                    contentValues.put("first_open_count", 0);
                    contentValues.put("previous_install_count", 0);
                    if (c_.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                        zzr().zzf().zza("Failed to insert column (got -1). appId", zzej.zza(str), str4);
                        c_.endTransaction();
                        return -1;
                    }
                    j = 0;
                }
            } catch (SQLiteException e) {
                e = e;
                j = 0;
                try {
                    zzr().zzf().zza("Error inserting column. appId", zzej.zza(str), str4, e);
                    c_.endTransaction();
                    return j;
                } catch (Throwable th) {
                    th = th;
                    c_.endTransaction();
                    throw th;
                }
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str3);
                contentValues2.put(str4, Long.valueOf(1 + j));
                if (((long) c_.update("app2", contentValues2, "app_id = ?", new String[]{str3})) == 0) {
                    zzr().zzf().zza("Failed to update column (got 0). appId", zzej.zza(str), str4);
                    c_.endTransaction();
                    return -1;
                }
                c_.setTransactionSuccessful();
                c_.endTransaction();
                return j;
            } catch (SQLiteException e2) {
                e = e2;
                zzr().zzf().zza("Error inserting column. appId", zzej.zza(str), str4, e);
                c_.endTransaction();
                return j;
            }
        } catch (SQLiteException e3) {
            e = e3;
            j = 0;
            zzr().zzf().zza("Error inserting column. appId", zzej.zza(str), str4, e);
            c_.endTransaction();
            return j;
        } catch (Throwable th2) {
            th = th2;
            c_.endTransaction();
            throw th;
        }
    }

    @WorkerThread
    public final long zzx() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zza(zzbr.zzg zzg2) throws IOException {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzg2);
        Preconditions.checkNotEmpty(zzg2.zzx());
        byte[] zzbh = zzg2.zzbh();
        long zza = zzg().zza(zzbh);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzg2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza));
        contentValues.put("metadata", zzbh);
        try {
            c_().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return zza;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event metadata. appId", zzej.zza(zzg2.zzx()), e);
            throw e;
        }
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final long zzg(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzd()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.c_()     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0043, all -> 0x0040 }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003e }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzej r6 = r4.zzr()     // Catch:{ SQLiteException -> 0x003e }
            com.google.android.gms.measurement.internal.zzel r6 = r6.zzx()     // Catch:{ SQLiteException -> 0x003e }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x0033
            r5.close()
        L_0x0033:
            return r0
        L_0x0034:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x003d
            r5.close()
        L_0x003d:
            return r6
        L_0x003e:
            r6 = move-exception
            goto L_0x0045
        L_0x0040:
            r6 = move-exception
            r5 = r0
            goto L_0x0059
        L_0x0043:
            r6 = move-exception
            r5 = r0
        L_0x0045:
            com.google.android.gms.measurement.internal.zzej r1 = r4.zzr()     // Catch:{ all -> 0x0058 }
            com.google.android.gms.measurement.internal.zzel r1 = r1.zzf()     // Catch:{ all -> 0x0058 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0058 }
            if (r5 == 0) goto L_0x0057
            r5.close()
        L_0x0057:
            return r0
        L_0x0058:
            r6 = move-exception
        L_0x0059:
            if (r5 == 0) goto L_0x005e
            r5.close()
        L_0x005e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(long):java.lang.String");
    }

    public final long zzaa() {
        Cursor cursor = null;
        try {
            cursor = c_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x008a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzbr.zzc, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzd()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.c_()     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0072, all -> 0x006f }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x006d }
            if (r2 != 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzej r8 = r7.zzr()     // Catch:{ SQLiteException -> 0x006d }
            com.google.android.gms.measurement.internal.zzel r8 = r8.zzx()     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x006d }
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x006d }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x006d }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x006d }
            com.google.android.gms.internal.measurement.zzeq r4 = com.google.android.gms.internal.measurement.zzeq.zzb()     // Catch:{ IOException -> 0x0055 }
            com.google.android.gms.internal.measurement.zzbr$zzc r8 = com.google.android.gms.internal.measurement.zzbr.zzc.zza((byte[]) r2, (com.google.android.gms.internal.measurement.zzeq) r4)     // Catch:{ IOException -> 0x0055 }
            android.util.Pair r8 = android.util.Pair.create(r8, r3)     // Catch:{ SQLiteException -> 0x006d }
            if (r1 == 0) goto L_0x0054
            r1.close()
        L_0x0054:
            return r8
        L_0x0055:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzej r3 = r7.zzr()     // Catch:{ SQLiteException -> 0x006d }
            com.google.android.gms.measurement.internal.zzel r3 = r3.zzf()     // Catch:{ SQLiteException -> 0x006d }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzej.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x006d }
            r3.zza(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x006d }
            if (r1 == 0) goto L_0x006c
            r1.close()
        L_0x006c:
            return r0
        L_0x006d:
            r8 = move-exception
            goto L_0x0074
        L_0x006f:
            r8 = move-exception
            r1 = r0
            goto L_0x0088
        L_0x0072:
            r8 = move-exception
            r1 = r0
        L_0x0074:
            com.google.android.gms.measurement.internal.zzej r9 = r7.zzr()     // Catch:{ all -> 0x0087 }
            com.google.android.gms.measurement.internal.zzel r9 = r9.zzf()     // Catch:{ all -> 0x0087 }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x0087 }
            if (r1 == 0) goto L_0x0086
            r1.close()
        L_0x0086:
            return r0
        L_0x0087:
            r8 = move-exception
        L_0x0088:
            if (r1 == 0) goto L_0x008d
            r1.close()
        L_0x008d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    public final boolean zza(String str, Long l, long j, zzbr.zzc zzc2) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzc2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbh = zzc2.zzbh();
        zzr().zzx().zza("Saving complex main event, appId, data size", zzo().zza(str), Integer.valueOf(zzbh.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(JsonMarshaller.EVENT_ID, l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbh);
        try {
            if (c_().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert complex main event (got -1). appId", zzej.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing complex main event. appId", zzej.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzaf zzaf, long j, boolean z) {
        zzd();
        zzak();
        Preconditions.checkNotNull(zzaf);
        Preconditions.checkNotEmpty(zzaf.zza);
        zzbr.zzc.zza zzb2 = zzbr.zzc.zzj().zzb(zzaf.zzd);
        Iterator<String> it = zzaf.zze.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzbr.zze.zza zza = zzbr.zze.zzh().zza(next);
            zzg().zza(zza, zzaf.zze.zza(next));
            zzb2.zza(zza);
        }
        byte[] zzbh = ((zzbr.zzc) ((zzfd) zzb2.zzu())).zzbh();
        zzr().zzx().zza("Saving event, name, data size", zzo().zza(zzaf.zzb), Integer.valueOf(zzbh.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaf.zza);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.NAME, zzaf.zzb);
        contentValues.put("timestamp", Long.valueOf(zzaf.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbh);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (c_().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            zzr().zzf().zza("Failed to insert raw event (got -1). appId", zzej.zza(zzaf.zza));
            return false;
        } catch (SQLiteException e) {
            zzr().zzf().zza("Error storing raw event. appId", zzej.zza(zzaf.zza), e);
            return false;
        }
    }

    private final boolean zzam() {
        return zzn().getDatabasePath("google_app_measurement.db").exists();
    }
}
