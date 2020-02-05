package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbr;
import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.0.1 */
final class zzhs extends zzjm {
    public zzhs(zzjp zzjp) {
        super(zzjp);
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    @WorkerThread
    public final byte[] zza(@NonNull zzai zzai, @Size(min = 1) String str) {
        zzjy zzjy;
        zzbr.zzf.zza zza;
        zzbr.zzg.zza zza2;
        zzf zzf;
        byte[] bArr;
        Bundle bundle;
        zzae zzae;
        long j;
        zzai zzai2 = zzai;
        String str2 = str;
        zzd();
        this.zzw.zzae();
        Preconditions.checkNotNull(zzai);
        Preconditions.checkNotEmpty(str);
        if (!zzt().zze(str2, zzak.zzbl)) {
            zzr().zzw().zza("Generating ScionPayload disabled. packageName", str2);
            return new byte[0];
        } else if ("_iap".equals(zzai2.zza) || "_iapx".equals(zzai2.zza)) {
            zzbr.zzf.zza zzb = zzbr.zzf.zzb();
            zzi().zzf();
            try {
                zzf zzb2 = zzi().zzb(str2);
                if (zzb2 == null) {
                    zzr().zzw().zza("Log and bundle not available. package_name", str2);
                    return new byte[0];
                } else if (!zzb2.zzp()) {
                    zzr().zzw().zza("Log and bundle disabled. package_name", str2);
                    byte[] bArr2 = new byte[0];
                    zzi().zzh();
                    return bArr2;
                } else {
                    zzbr.zzg.zza zza3 = zzbr.zzg.zzbe().zza(1).zza("android");
                    if (!TextUtils.isEmpty(zzb2.zzb())) {
                        zza3.zzf(zzb2.zzb());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzl())) {
                        zza3.zze(zzb2.zzl());
                    }
                    if (!TextUtils.isEmpty(zzb2.zzj())) {
                        zza3.zzg(zzb2.zzj());
                    }
                    if (zzb2.zzk() != -2147483648L) {
                        zza3.zzg((int) zzb2.zzk());
                    }
                    zza3.zzf(zzb2.zzm()).zzk(zzb2.zzo());
                    if (!TextUtils.isEmpty(zzb2.zzd())) {
                        zza3.zzk(zzb2.zzd());
                    } else if (!TextUtils.isEmpty(zzb2.zze())) {
                        zza3.zzo(zzb2.zze());
                    }
                    zza3.zzh(zzb2.zzn());
                    if (this.zzw.zzab() && zzs.zzy() && zzt().zzd(zza3.zzj())) {
                        zza3.zzj();
                        if (!TextUtils.isEmpty((CharSequence) null)) {
                            zza3.zzn((String) null);
                        }
                    }
                    Pair<String, Boolean> zza4 = zzs().zza(zzb2.zzb());
                    if (zzb2.zzad() && zza4 != null && !TextUtils.isEmpty((CharSequence) zza4.first)) {
                        zza3.zzh(zza((String) zza4.first, Long.toString(zzai2.zzd)));
                        if (zza4.second != null) {
                            zza3.zza(((Boolean) zza4.second).booleanValue());
                        }
                    }
                    zzl().zzaa();
                    zzbr.zzg.zza zzc = zza3.zzc(Build.MODEL);
                    zzl().zzaa();
                    zzc.zzb(Build.VERSION.RELEASE).zze((int) zzl().zzf()).zzd(zzl().zzg());
                    try {
                        zza3.zzi(zza(zzb2.zzc(), Long.toString(zzai2.zzd)));
                        if (!TextUtils.isEmpty(zzb2.zzg())) {
                            zza3.zzl(zzb2.zzg());
                        }
                        String zzb3 = zzb2.zzb();
                        List<zzjy> zza5 = zzi().zza(zzb3);
                        Iterator<zzjy> it = zza5.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                zzjy = null;
                                break;
                            }
                            zzjy = it.next();
                            if ("_lte".equals(zzjy.zzc)) {
                                break;
                            }
                        }
                        if (zzjy == null || zzjy.zze == null) {
                            zzjy zzjy2 = new zzjy(zzb3, "auto", "_lte", zzm().currentTimeMillis(), 0L);
                            zza5.add(zzjy2);
                            zzi().zza(zzjy2);
                        }
                        if (zzt().zze(zzb3, zzak.zzbg)) {
                            zzjt zzg = zzg();
                            zzg.zzr().zzx().zza("Checking account type status for ad personalization signals");
                            if (zzg.zzl().zzj()) {
                                String zzb4 = zzb2.zzb();
                                if (zzb2.zzad() && zzg.zzj().zze(zzb4)) {
                                    zzg.zzr().zzw().zza("Turning off ad personalization due to account type");
                                    Iterator<zzjy> it2 = zza5.iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        } else if ("_npa".equals(it2.next().zzc)) {
                                            it2.remove();
                                            break;
                                        }
                                    }
                                    zza5.add(new zzjy(zzb4, "auto", "_npa", zzg.zzm().currentTimeMillis(), 1L));
                                }
                            }
                        }
                        zzbr.zzk[] zzkArr = new zzbr.zzk[zza5.size()];
                        for (int i = 0; i < zza5.size(); i++) {
                            zzbr.zzk.zza zza6 = zzbr.zzk.zzj().zza(zza5.get(i).zzc).zza(zza5.get(i).zzd);
                            zzg().zza(zza6, zza5.get(i).zze);
                            zzkArr[i] = (zzbr.zzk) ((zzfd) zza6.zzu());
                        }
                        zza3.zzb((Iterable<? extends zzbr.zzk>) Arrays.asList(zzkArr));
                        Bundle zzb5 = zzai2.zzb.zzb();
                        zzb5.putLong("_c", 1);
                        zzr().zzw().zza("Marking in-app purchase as real-time");
                        zzb5.putLong("_r", 1);
                        zzb5.putString("_o", zzai2.zzc);
                        if (zzp().zzf(zza3.zzj())) {
                            zzp().zza(zzb5, "_dbg", (Object) 1L);
                            zzp().zza(zzb5, "_r", (Object) 1L);
                        }
                        zzae zza7 = zzi().zza(str2, zzai2.zza);
                        if (zza7 == null) {
                            zzf = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle = zzb5;
                            bArr = null;
                            zzae = new zzae(str, zzai2.zza, 0, 0, zzai2.zzd, 0, (Long) null, (Long) null, (Long) null, (Boolean) null);
                            j = 0;
                        } else {
                            zzf = zzb2;
                            zza2 = zza3;
                            zza = zzb;
                            bundle = zzb5;
                            bArr = null;
                            j = zza7.zzf;
                            zzae = zza7.zza(zzai2.zzd);
                        }
                        zzi().zza(zzae);
                        zzaf zzaf = new zzaf(this.zzw, zzai2.zzc, str, zzai2.zza, zzai2.zzd, j, bundle);
                        zzbr.zzc.zza zzb6 = zzbr.zzc.zzj().zza(zzaf.zzc).zza(zzaf.zzb).zzb(zzaf.zzd);
                        Iterator<String> it3 = zzaf.zze.iterator();
                        while (it3.hasNext()) {
                            String next = it3.next();
                            zzbr.zze.zza zza8 = zzbr.zze.zzh().zza(next);
                            zzg().zza(zza8, zzaf.zze.zza(next));
                            zzb6.zza(zza8);
                        }
                        zzbr.zzg.zza zza9 = zza2;
                        zza9.zza(zzb6).zza(zzbr.zzh.zza().zza(zzbr.zzd.zza().zza(zzae.zzc).zza(zzai2.zza)));
                        zza9.zzc((Iterable<? extends zzbr.zza>) e_().zza(zzf.zzb(), (List<zzbr.zzc>) Collections.emptyList(), zza9.zzd(), Long.valueOf(zzb6.zze())));
                        if (zzb6.zzd()) {
                            zza9.zzb(zzb6.zze()).zzc(zzb6.zze());
                        }
                        long zzi = zzf.zzi();
                        if (zzi != 0) {
                            zza9.zze(zzi);
                        }
                        long zzh = zzf.zzh();
                        if (zzh != 0) {
                            zza9.zzd(zzh);
                        } else if (zzi != 0) {
                            zza9.zzd(zzi);
                        }
                        zzf.zzt();
                        zza9.zzf((int) zzf.zzq()).zzg(zzt().zzf()).zza(zzm().currentTimeMillis()).zzb(Boolean.TRUE.booleanValue());
                        zzbr.zzf.zza zza10 = zza;
                        zza10.zza(zza9);
                        zzf zzf2 = zzf;
                        zzf2.zza(zza9.zzf());
                        zzf2.zzb(zza9.zzg());
                        zzi().zza(zzf2);
                        zzi().b_();
                        zzi().zzh();
                        try {
                            return zzg().zzc(((zzbr.zzf) ((zzfd) zza10.zzu())).zzbh());
                        } catch (IOException e) {
                            zzr().zzf().zza("Data loss. Failed to bundle and serialize. appId", zzej.zza(str), e);
                            return bArr;
                        }
                    } catch (SecurityException e2) {
                        zzr().zzw().zza("app instance id encryption failed", e2.getMessage());
                        byte[] bArr3 = new byte[0];
                        zzi().zzh();
                        return bArr3;
                    }
                }
            } catch (SecurityException e3) {
                zzr().zzw().zza("Resettable device id encryption failed", e3.getMessage());
                return new byte[0];
            } finally {
                zzi().zzh();
            }
        } else {
            zzr().zzw().zza("Generating a payload for this event is not available. package_name, event_name", str2, zzai2.zza);
            return null;
        }
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }
}
