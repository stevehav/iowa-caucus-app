package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfy;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzfm extends zzfl<zzfy.zze> {
    zzfm() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(zzhf zzhf) {
        return zzhf instanceof zzfy.zzd;
    }

    /* access modifiers changed from: package-private */
    public final zzfp<zzfy.zze> zzc(Object obj) {
        return ((zzfy.zzd) obj).zzwp;
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, zzfp<zzfy.zze> zzfp) {
        ((zzfy.zzd) obj).zzwp = zzfp;
    }

    /* access modifiers changed from: package-private */
    public final zzfp<zzfy.zze> zzd(Object obj) {
        zzfp<zzfy.zze> zzc = zzc(obj);
        if (!zzc.isImmutable()) {
            return zzc;
        }
        zzfp<zzfy.zze> zzfp = (zzfp) zzc.clone();
        zza(obj, zzfp);
        return zzfp;
    }

    /* access modifiers changed from: package-private */
    public final void zze(Object obj) {
        zzc(obj).zzci();
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB zza(zzhv zzhv, Object obj, zzfk zzfk, zzfp<zzfy.zze> zzfp, UB ub, zzio<UT, UB> zzio) throws IOException {
        Object zza;
        ArrayList arrayList;
        zzfy.zzf zzf = (zzfy.zzf) obj;
        int i = zzf.zzww.number;
        if (!zzf.zzww.zzws || !zzf.zzww.zzwt) {
            Object obj2 = null;
            if (zzf.zzww.zzwr != zzjd.ENUM) {
                switch (zzf.zzww.zzwr) {
                    case DOUBLE:
                        obj2 = Double.valueOf(zzhv.readDouble());
                        break;
                    case FLOAT:
                        obj2 = Float.valueOf(zzhv.readFloat());
                        break;
                    case INT64:
                        obj2 = Long.valueOf(zzhv.zzcq());
                        break;
                    case UINT64:
                        obj2 = Long.valueOf(zzhv.zzcp());
                        break;
                    case INT32:
                        obj2 = Integer.valueOf(zzhv.zzcr());
                        break;
                    case FIXED64:
                        obj2 = Long.valueOf(zzhv.zzcs());
                        break;
                    case FIXED32:
                        obj2 = Integer.valueOf(zzhv.zzct());
                        break;
                    case BOOL:
                        obj2 = Boolean.valueOf(zzhv.zzcu());
                        break;
                    case UINT32:
                        obj2 = Integer.valueOf(zzhv.zzcx());
                        break;
                    case SFIXED32:
                        obj2 = Integer.valueOf(zzhv.zzcz());
                        break;
                    case SFIXED64:
                        obj2 = Long.valueOf(zzhv.zzda());
                        break;
                    case SINT32:
                        obj2 = Integer.valueOf(zzhv.zzdb());
                        break;
                    case SINT64:
                        obj2 = Long.valueOf(zzhv.zzdc());
                        break;
                    case ENUM:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case BYTES:
                        obj2 = zzhv.zzcw();
                        break;
                    case STRING:
                        obj2 = zzhv.readString();
                        break;
                    case GROUP:
                        obj2 = zzhv.zzb(zzf.zzwv.getClass(), zzfk);
                        break;
                    case MESSAGE:
                        obj2 = zzhv.zza(zzf.zzwv.getClass(), zzfk);
                        break;
                }
            } else {
                int zzcr = zzhv.zzcr();
                if (zzf.zzww.zzwq.zzf(zzcr) == null) {
                    return zzhy.zza(i, zzcr, ub, zzio);
                }
                obj2 = Integer.valueOf(zzcr);
            }
            if (zzf.zzww.zzws) {
                zzfp.zzb(zzf.zzww, (Object) obj2);
            } else {
                int i2 = zzfn.zzrr[zzf.zzww.zzwr.ordinal()];
                if ((i2 == 17 || i2 == 18) && (zza = zzfp.zza(zzf.zzww)) != null) {
                    obj2 = zzga.zza(zza, (Object) obj2);
                }
                zzfp.zza(zzf.zzww, (Object) obj2);
            }
        } else {
            switch (zzf.zzww.zzwr) {
                case DOUBLE:
                    arrayList = new ArrayList();
                    zzhv.zza(arrayList);
                    break;
                case FLOAT:
                    arrayList = new ArrayList();
                    zzhv.zzb(arrayList);
                    break;
                case INT64:
                    arrayList = new ArrayList();
                    zzhv.zzd(arrayList);
                    break;
                case UINT64:
                    arrayList = new ArrayList();
                    zzhv.zzc(arrayList);
                    break;
                case INT32:
                    arrayList = new ArrayList();
                    zzhv.zze(arrayList);
                    break;
                case FIXED64:
                    arrayList = new ArrayList();
                    zzhv.zzf(arrayList);
                    break;
                case FIXED32:
                    arrayList = new ArrayList();
                    zzhv.zzg(arrayList);
                    break;
                case BOOL:
                    arrayList = new ArrayList();
                    zzhv.zzh(arrayList);
                    break;
                case UINT32:
                    arrayList = new ArrayList();
                    zzhv.zzk(arrayList);
                    break;
                case SFIXED32:
                    arrayList = new ArrayList();
                    zzhv.zzm(arrayList);
                    break;
                case SFIXED64:
                    arrayList = new ArrayList();
                    zzhv.zzn(arrayList);
                    break;
                case SINT32:
                    arrayList = new ArrayList();
                    zzhv.zzo(arrayList);
                    break;
                case SINT64:
                    arrayList = new ArrayList();
                    zzhv.zzp(arrayList);
                    break;
                case ENUM:
                    arrayList = new ArrayList();
                    zzhv.zzl(arrayList);
                    ub = zzhy.zza(i, (List<Integer>) arrayList, zzf.zzww.zzwq, ub, zzio);
                    break;
                default:
                    String valueOf = String.valueOf(zzf.zzww.zzwr);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
                    sb.append("Type cannot be packed: ");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
            }
            zzfp.zza(zzf.zzww, (Object) arrayList);
        }
        return ub;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        return ((zzfy.zze) entry.getKey()).number;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjj zzjj, Map.Entry<?, ?> entry) throws IOException {
        zzfy.zze zze = (zzfy.zze) entry.getKey();
        if (zze.zzws) {
            switch (zze.zzwr) {
                case DOUBLE:
                    zzhy.zza(zze.number, (List<Double>) (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case FLOAT:
                    zzhy.zzb(zze.number, (List<Float>) (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case INT64:
                    zzhy.zzc(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case UINT64:
                    zzhy.zzd(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case INT32:
                    zzhy.zzh(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case FIXED64:
                    zzhy.zzf(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case FIXED32:
                    zzhy.zzk(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case BOOL:
                    zzhy.zzn(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case UINT32:
                    zzhy.zzi(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case SFIXED32:
                    zzhy.zzl(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case SFIXED64:
                    zzhy.zzg(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case SINT32:
                    zzhy.zzj(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case SINT64:
                    zzhy.zze(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case ENUM:
                    zzhy.zzh(zze.number, (List) entry.getValue(), zzjj, zze.zzwt);
                    return;
                case BYTES:
                    zzhy.zzb(zze.number, (List) entry.getValue(), zzjj);
                    return;
                case STRING:
                    zzhy.zza(zze.number, (List<String>) (List) entry.getValue(), zzjj);
                    return;
                case GROUP:
                    List list = (List) entry.getValue();
                    if (list != null && !list.isEmpty()) {
                        zzhy.zzb(zze.number, (List<?>) (List) entry.getValue(), zzjj, (zzhw) zzhs.zzgl().zzf(list.get(0).getClass()));
                        return;
                    }
                    return;
                case MESSAGE:
                    List list2 = (List) entry.getValue();
                    if (list2 != null && !list2.isEmpty()) {
                        zzhy.zza(zze.number, (List<?>) (List) entry.getValue(), zzjj, (zzhw) zzhs.zzgl().zzf(list2.get(0).getClass()));
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            switch (zze.zzwr) {
                case DOUBLE:
                    zzjj.zza(zze.number, ((Double) entry.getValue()).doubleValue());
                    return;
                case FLOAT:
                    zzjj.zza(zze.number, ((Float) entry.getValue()).floatValue());
                    return;
                case INT64:
                    zzjj.zzi(zze.number, ((Long) entry.getValue()).longValue());
                    return;
                case UINT64:
                    zzjj.zza(zze.number, ((Long) entry.getValue()).longValue());
                    return;
                case INT32:
                    zzjj.zze(zze.number, ((Integer) entry.getValue()).intValue());
                    return;
                case FIXED64:
                    zzjj.zzc(zze.number, ((Long) entry.getValue()).longValue());
                    return;
                case FIXED32:
                    zzjj.zzh(zze.number, ((Integer) entry.getValue()).intValue());
                    return;
                case BOOL:
                    zzjj.zzb(zze.number, ((Boolean) entry.getValue()).booleanValue());
                    return;
                case UINT32:
                    zzjj.zzf(zze.number, ((Integer) entry.getValue()).intValue());
                    return;
                case SFIXED32:
                    zzjj.zzo(zze.number, ((Integer) entry.getValue()).intValue());
                    return;
                case SFIXED64:
                    zzjj.zzj(zze.number, ((Long) entry.getValue()).longValue());
                    return;
                case SINT32:
                    zzjj.zzg(zze.number, ((Integer) entry.getValue()).intValue());
                    return;
                case SINT64:
                    zzjj.zzb(zze.number, ((Long) entry.getValue()).longValue());
                    return;
                case ENUM:
                    zzjj.zze(zze.number, ((Integer) entry.getValue()).intValue());
                    return;
                case BYTES:
                    zzjj.zza(zze.number, (zzeo) entry.getValue());
                    return;
                case STRING:
                    zzjj.zza(zze.number, (String) entry.getValue());
                    return;
                case GROUP:
                    zzjj.zzb(zze.number, (Object) entry.getValue(), (zzhw) zzhs.zzgl().zzf(entry.getValue().getClass()));
                    return;
                case MESSAGE:
                    zzjj.zza(zze.number, (Object) entry.getValue(), (zzhw) zzhs.zzgl().zzf(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Object zza(zzfk zzfk, zzhf zzhf, int i) {
        return zzfk.zza(zzhf, i);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzhv zzhv, Object obj, zzfk zzfk, zzfp<zzfy.zze> zzfp) throws IOException {
        zzfy.zzf zzf = (zzfy.zzf) obj;
        zzfp.zza(zzf.zzww, (Object) zzhv.zza(zzf.zzwv.getClass(), zzfk));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeo zzeo, Object obj, zzfk zzfk, zzfp<zzfy.zze> zzfp) throws IOException {
        byte[] bArr;
        zzfy.zzf zzf = (zzfy.zzf) obj;
        zzhf zzff = zzf.zzwv.zzfa().zzff();
        int size = zzeo.size();
        if (size == 0) {
            bArr = zzga.zzxn;
        } else {
            byte[] bArr2 = new byte[size];
            zzeo.zza(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (wrap.hasArray()) {
            zzel zzel = new zzel(wrap, true);
            zzhs.zzgl().zzs(zzff).zza(zzff, zzel, zzfk);
            zzfp.zza(zzf.zzww, (Object) zzff);
            if (zzel.zzcn() != Integer.MAX_VALUE) {
                throw zzgf.zzfl();
            }
            return;
        }
        throw new IllegalArgumentException("Direct buffers not yet supported");
    }
}
