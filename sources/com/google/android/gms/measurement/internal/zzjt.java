package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbj;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import io.sentry.marshaller.json.JsonMarshaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
public final class zzjt extends zzjm {
    zzjt(zzjp zzjp) {
        super(zzjp);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbr.zzk.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zzb(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else {
            zzr().zzf().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbr.zze.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else {
            zzr().zzf().zza("Ignoring invalid (type) event param value", obj);
        }
    }

    static zzbr.zze zza(zzbr.zzc zzc, String str) {
        for (zzbr.zze next : zzc.zza()) {
            if (next.zza().equals(str)) {
                return next;
            }
        }
        return null;
    }

    static Object zzb(zzbr.zzc zzc, String str) {
        zzbr.zze zza = zza(zzc, str);
        if (zza == null) {
            return null;
        }
        if (zza.zzb()) {
            return zza.zzc();
        }
        if (zza.zzd()) {
            return Long.valueOf(zza.zze());
        }
        if (zza.zzf()) {
            return Double.valueOf(zza.zzg());
        }
        return null;
    }

    static void zza(zzbr.zzc.zza zza, String str, Object obj) {
        List<zzbr.zze> zza2 = zza.zza();
        int i = 0;
        while (true) {
            if (i >= zza2.size()) {
                i = -1;
                break;
            } else if (str.equals(zza2.get(i).zza())) {
                break;
            } else {
                i++;
            }
        }
        zzbr.zze.zza zza3 = zzbr.zze.zzh().zza(str);
        if (obj instanceof Long) {
            zza3.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zza3.zzb((String) obj);
        } else if (obj instanceof Double) {
            zza3.zza(((Double) obj).doubleValue());
        }
        if (i >= 0) {
            zza.zza(i, zza3);
        } else {
            zza.zza(zza3);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbr.zzf zzf) {
        List<zzbr.zze> zza;
        if (zzf == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        for (zzbr.zzg next : zzf.zza()) {
            if (next != null) {
                zza(sb, 1);
                sb.append("bundle {\n");
                if (next.zza()) {
                    zza(sb, 1, "protocol_version", (Object) Integer.valueOf(next.zzb()));
                }
                zza(sb, 1, JsonMarshaller.PLATFORM, (Object) next.zzq());
                if (next.zzz()) {
                    zza(sb, 1, "gmp_version", (Object) Long.valueOf(next.zzaa()));
                }
                if (next.zzab()) {
                    zza(sb, 1, "uploading_gmp_version", (Object) Long.valueOf(next.zzac()));
                }
                if (next.zzbc()) {
                    zza(sb, 1, "dynamite_version", (Object) Long.valueOf(next.zzbd()));
                }
                if (next.zzau()) {
                    zza(sb, 1, "config_version", (Object) Long.valueOf(next.zzav()));
                }
                zza(sb, 1, "gmp_app_id", (Object) next.zzam());
                zza(sb, 1, "admob_app_id", (Object) next.zzbb());
                zza(sb, 1, "app_id", (Object) next.zzx());
                zza(sb, 1, "app_version", (Object) next.zzy());
                if (next.zzar()) {
                    zza(sb, 1, "app_version_major", (Object) Integer.valueOf(next.zzas()));
                }
                zza(sb, 1, "firebase_instance_id", (Object) next.zzaq());
                if (next.zzah()) {
                    zza(sb, 1, "dev_cert_hash", (Object) Long.valueOf(next.zzai()));
                }
                zza(sb, 1, "app_store", (Object) next.zzw());
                if (next.zzg()) {
                    zza(sb, 1, "upload_timestamp_millis", (Object) Long.valueOf(next.zzh()));
                }
                if (next.zzi()) {
                    zza(sb, 1, "start_timestamp_millis", (Object) Long.valueOf(next.zzj()));
                }
                if (next.zzk()) {
                    zza(sb, 1, "end_timestamp_millis", (Object) Long.valueOf(next.zzl()));
                }
                if (next.zzm()) {
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", (Object) Long.valueOf(next.zzn()));
                }
                if (next.zzo()) {
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", (Object) Long.valueOf(next.zzp()));
                }
                zza(sb, 1, "app_instance_id", (Object) next.zzag());
                zza(sb, 1, "resettable_device_id", (Object) next.zzad());
                zza(sb, 1, "device_id", (Object) next.zzat());
                zza(sb, 1, "ds_id", (Object) next.zzay());
                if (next.zzae()) {
                    zza(sb, 1, "limited_ad_tracking", (Object) Boolean.valueOf(next.zzaf()));
                }
                zza(sb, 1, "os_version", (Object) next.zzr());
                zza(sb, 1, "device_model", (Object) next.zzs());
                zza(sb, 1, "user_default_language", (Object) next.zzt());
                if (next.zzu()) {
                    zza(sb, 1, "time_zone_offset_minutes", (Object) Integer.valueOf(next.g_()));
                }
                if (next.zzaj()) {
                    zza(sb, 1, "bundle_sequential_index", (Object) Integer.valueOf(next.zzak()));
                }
                if (next.zzan()) {
                    zza(sb, 1, "service_upload", (Object) Boolean.valueOf(next.zzao()));
                }
                zza(sb, 1, "health_monitor", (Object) next.zzal());
                if (next.zzaw() && next.zzax() != 0) {
                    zza(sb, 1, "android_id", (Object) Long.valueOf(next.zzax()));
                }
                if (next.zzaz()) {
                    zza(sb, 1, "retry_counter", (Object) Integer.valueOf(next.zzba()));
                }
                List<zzbr.zzk> zze = next.zze();
                int i = 2;
                if (zze != null) {
                    for (zzbr.zzk next2 : zze) {
                        if (next2 != null) {
                            zza(sb, 2);
                            sb.append("user_property {\n");
                            zza(sb, 2, "set_timestamp_millis", (Object) next2.zza() ? Long.valueOf(next2.zzb()) : null);
                            zza(sb, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) zzo().zzc(next2.zzc()));
                            zza(sb, 2, "string_value", (Object) next2.zze());
                            zza(sb, 2, "int_value", (Object) next2.zzf() ? Long.valueOf(next2.zzg()) : null);
                            zza(sb, 2, "double_value", (Object) next2.zzh() ? Double.valueOf(next2.zzi()) : null);
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzbr.zza> zzap = next.zzap();
                String zzx = next.zzx();
                if (zzap != null) {
                    for (zzbr.zza next3 : zzap) {
                        if (next3 != null) {
                            zza(sb, i);
                            sb.append("audience_membership {\n");
                            if (next3.zza()) {
                                zza(sb, i, "audience_id", (Object) Integer.valueOf(next3.zzb()));
                            }
                            if (next3.zzf()) {
                                zza(sb, i, "new_audience", (Object) Boolean.valueOf(next3.zzg()));
                            }
                            StringBuilder sb2 = sb;
                            String str = zzx;
                            zza(sb2, 2, "current_data", next3.zzc(), str);
                            zza(sb2, 2, "previous_data", next3.zze(), str);
                            zza(sb, 2);
                            sb.append("}\n");
                            i = 2;
                        }
                    }
                }
                List<zzbr.zzc> zzc = next.zzc();
                if (zzc != null) {
                    for (zzbr.zzc next4 : zzc) {
                        if (next4 != null) {
                            zza(sb, 2);
                            sb.append("event {\n");
                            zza(sb, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) zzo().zza(next4.zzc()));
                            if (next4.zzd()) {
                                zza(sb, 2, "timestamp_millis", (Object) Long.valueOf(next4.zze()));
                            }
                            if (next4.zzf()) {
                                zza(sb, 2, "previous_timestamp_millis", (Object) Long.valueOf(next4.zzg()));
                            }
                            if (next4.zzh()) {
                                zza(sb, 2, "count", (Object) Integer.valueOf(next4.zzi()));
                            }
                            if (!(next4.zzb() == 0 || (zza = next4.zza()) == null)) {
                                for (zzbr.zze next5 : zza) {
                                    if (next5 != null) {
                                        zza(sb, 3);
                                        sb.append("param {\n");
                                        zza(sb, 3, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) zzo().zzb(next5.zza()));
                                        zza(sb, 3, "string_value", (Object) next5.zzc());
                                        zza(sb, 3, "int_value", (Object) next5.zzd() ? Long.valueOf(next5.zze()) : null);
                                        zza(sb, 3, "double_value", (Object) next5.zzf() ? Double.valueOf(next5.zzg()) : null);
                                        zza(sb, 3);
                                        sb.append("}\n");
                                    }
                                }
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zza(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbj.zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzb.zza()) {
            zza(sb, 0, "filter_id", (Object) Integer.valueOf(zzb.zzb()));
        }
        zza(sb, 0, "event_name", (Object) zzo().zza(zzb.zzc()));
        String zza = zza(zzb.zzh(), zzb.zzi(), zzb.zzk());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", (Object) zza);
        }
        zza(sb, 1, "event_count_filter", zzb.zzg());
        sb.append("  filters {\n");
        for (zzbj.zzc zza2 : zzb.zzd()) {
            zza(sb, 2, zza2);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbj.zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zze.zza()) {
            zza(sb, 0, "filter_id", (Object) Integer.valueOf(zze.zzb()));
        }
        zza(sb, 0, "property_name", (Object) zzo().zzc(zze.zzc()));
        String zza = zza(zze.zze(), zze.zzf(), zze.zzh());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", (Object) zza);
        }
        zza(sb, 1, zze.zzd());
        sb.append("}\n");
        return sb.toString();
    }

    private static String zza(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    private final void zza(StringBuilder sb, int i, String str, zzbr.zzi zzi, String str2) {
        if (zzi != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzi.zzd() != 0) {
                zza(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long next : zzi.zzc()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (zzi.zzb() != 0) {
                zza(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long next2 : zzi.zza()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next2);
                    i4 = i5;
                }
                sb.append(10);
            }
            if (zzt().zzi(str2)) {
                if (zzi.zzf() != 0) {
                    zza(sb, 4);
                    sb.append("dynamic_filter_timestamps: {");
                    int i6 = 0;
                    for (zzbr.zzb next3 : zzi.zze()) {
                        int i7 = i6 + 1;
                        if (i6 != 0) {
                            sb.append(", ");
                        }
                        sb.append(next3.zza() ? Integer.valueOf(next3.zzb()) : null);
                        sb.append(":");
                        sb.append(next3.zzc() ? Long.valueOf(next3.zzd()) : null);
                        i6 = i7;
                    }
                    sb.append("}\n");
                }
                if (zzi.zzh() != 0) {
                    zza(sb, 4);
                    sb.append("sequence_filter_timestamps: {");
                    int i8 = 0;
                    for (zzbr.zzj next4 : zzi.zzg()) {
                        int i9 = i8 + 1;
                        if (i8 != 0) {
                            sb.append(", ");
                        }
                        sb.append(next4.zza() ? Integer.valueOf(next4.zzb()) : null);
                        sb.append(": [");
                        int i10 = 0;
                        for (Long longValue : next4.zzc()) {
                            long longValue2 = longValue.longValue();
                            int i11 = i10 + 1;
                            if (i10 != 0) {
                                sb.append(", ");
                            }
                            sb.append(longValue2);
                            i10 = i11;
                        }
                        sb.append("]");
                        i8 = i9;
                    }
                    sb.append("}\n");
                }
            }
            zza(sb, 3);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzbj.zzd zzd) {
        if (zzd != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.zza()) {
                zza(sb, i, "comparison_type", (Object) zzd.zzb().name());
            }
            if (zzd.zzc()) {
                zza(sb, i, "match_as_float", (Object) Boolean.valueOf(zzd.zzd()));
            }
            zza(sb, i, "comparison_value", (Object) zzd.zzf());
            zza(sb, i, "min_comparison_value", (Object) zzd.zzh());
            zza(sb, i, "max_comparison_value", (Object) zzd.zzj());
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, zzbj.zzc zzc) {
        if (zzc != null) {
            zza(sb, i);
            sb.append("filter {\n");
            if (zzc.zze()) {
                zza(sb, i, "complement", (Object) Boolean.valueOf(zzc.zzf()));
            }
            zza(sb, i, "param_name", (Object) zzo().zzb(zzc.zzg()));
            int i2 = i + 1;
            zzbj.zzf zzb = zzc.zzb();
            if (zzb != null) {
                zza(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzb.zza()) {
                    zza(sb, i2, "match_type", (Object) zzb.zzb().name());
                }
                zza(sb, i2, "expression", (Object) zzb.zzd());
                if (zzb.zze()) {
                    zza(sb, i2, "case_sensitive", (Object) Boolean.valueOf(zzb.zzf()));
                }
                if (zzb.zzh() > 0) {
                    zza(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String append : zzb.zzg()) {
                        zza(sb, i2 + 2);
                        sb.append(append);
                        sb.append(ReactEditTextInputConnectionWrapper.NEWLINE_RAW_VALUE);
                    }
                    sb.append("}\n");
                }
                zza(sb, i2);
                sb.append("}\n");
            }
            zza(sb, i2, "number_filter", zzc.zzd());
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzr().zzf().zza("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T zza(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002d
        L_0x001c:
            com.google.android.gms.measurement.internal.zzej r5 = r4.zzr()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzel r5 = r5.zzf()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zza(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzjt.zza(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final boolean zza(zzai zzai, zzn zzn) {
        Preconditions.checkNotNull(zzai);
        Preconditions.checkNotNull(zzn);
        if (!TextUtils.isEmpty(zzn.zzb) || !TextUtils.isEmpty(zzn.zzr)) {
            return true;
        }
        zzu();
        return false;
    }

    static boolean zza(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zza(List<Long> list, int i) {
        if (i >= (list.size() << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
    }

    static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final List<Long> zza(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer next : list2) {
            if (next.intValue() < 0) {
                zzr().zzi().zza("Ignoring negative bit index to be cleared", next);
            } else {
                int intValue = next.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzr().zzi().zza("Ignoring bit index greater than bitSet size", next, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (next.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzm().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzp().zzd();
        MessageDigest zzi = zzjx.zzi();
        if (zzi != null) {
            return zzjx.zza(zzi.digest(bArr));
        }
        zzr().zzf().zza("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzr().zzf().zza("Failed to ungzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzc(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzr().zzf().zza("Failed to gzip content", e);
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final List<Integer> zzf() {
        Map<String, String> zza = zzak.zza(this.zza.zzn());
        if (zza == null || zza.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzak.zzap.zza(null).intValue();
        Iterator<Map.Entry<String, String>> it = zza.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            if (((String) next.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) next.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzr().zzi().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzr().zzi().zza("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public final /* bridge */ /* synthetic */ zzjt zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzp e_() {
        return super.e_();
    }

    public final /* bridge */ /* synthetic */ zzx zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfh zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzac zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzeh zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzjx zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfg zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzej zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzes zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzs zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzr zzu() {
        return super.zzu();
    }
}
