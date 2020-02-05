package com.google.android.gms.phenotype;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.UserManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.phenotype.zzf;
import com.google.android.gms.internal.phenotype.zzh;
import javax.annotation.Nullable;

@KeepForSdk
@Deprecated
public abstract class PhenotypeFlag<T> {
    private static final Object zzak = new Object();
    @SuppressLint({"StaticFieldLeak"})
    private static Context zzal = null;
    private static boolean zzam = false;
    private static Boolean zzan = null;
    private final Factory zzao;
    final String zzap;
    private final String zzaq;
    private final T zzar;
    private T zzas;

    @KeepForSdk
    public static class Factory {
        /* access modifiers changed from: private */
        public final String zzax;
        /* access modifiers changed from: private */
        public final Uri zzay;
        /* access modifiers changed from: private */
        public final String zzaz;
        /* access modifiers changed from: private */
        public final String zzba;
        /* access modifiers changed from: private */
        public final boolean zzbb;
        /* access modifiers changed from: private */
        public final boolean zzbc;

        @KeepForSdk
        public Factory(Uri uri) {
            this((String) null, uri, "", "", false, false);
        }

        private Factory(String str, Uri uri, String str2, String str3, boolean z, boolean z2) {
            this.zzax = str;
            this.zzay = uri;
            this.zzaz = str2;
            this.zzba = str3;
            this.zzbb = z;
            this.zzbc = z2;
        }

        @KeepForSdk
        public PhenotypeFlag<String> createFlag(String str, String str2) {
            return PhenotypeFlag.zza(this, str, str2);
        }

        @KeepForSdk
        public Factory withGservicePrefix(String str) {
            boolean z = this.zzbb;
            if (!z) {
                return new Factory(this.zzax, this.zzay, str, this.zzba, z, this.zzbc);
            }
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }

        @KeepForSdk
        public Factory withPhenotypePrefix(String str) {
            return new Factory(this.zzax, this.zzay, this.zzaz, str, this.zzbb, this.zzbc);
        }
    }

    interface zza<V> {
        V zzh();
    }

    private PhenotypeFlag(Factory factory, String str, T t) {
        this.zzas = null;
        if (factory.zzax == null && factory.zzay == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (factory.zzax == null || factory.zzay == null) {
            this.zzao = factory;
            String valueOf = String.valueOf(factory.zzaz);
            String valueOf2 = String.valueOf(str);
            this.zzaq = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            String valueOf3 = String.valueOf(factory.zzba);
            String valueOf4 = String.valueOf(str);
            this.zzap = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
            this.zzar = t;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    /* synthetic */ PhenotypeFlag(Factory factory, String str, Object obj, zzr zzr) {
        this(factory, str, obj);
    }

    @KeepForSdk
    public static void maybeInit(Context context) {
        zzh.maybeInit(context);
        if (zzal == null) {
            zzh.init(context);
            synchronized (zzak) {
                if (Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                }
                if (zzal != context) {
                    zzan = null;
                }
                zzal = context;
            }
            zzam = false;
        }
    }

    /* access modifiers changed from: private */
    public static PhenotypeFlag<String> zza(Factory factory, String str, String str2) {
        return new zzs(factory, str, str2);
    }

    private static <V> V zza(zza<V> zza2) {
        long clearCallingIdentity;
        try {
            return zza2.zzh();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V zzh = zza2.zzh();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzh;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    static boolean zza(String str, boolean z) {
        if (zzf()) {
            return ((Boolean) zza(new zzq(str, false))).booleanValue();
        }
        return false;
    }

    @TargetApi(24)
    @Nullable
    private final T zzd() {
        if (zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            String valueOf = String.valueOf(this.zzap);
            Log.w("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        } else if (this.zzao.zzay != null) {
            String str = (String) zza(new zzo(this, zza.zza(zzal.getContentResolver(), this.zzao.zzay)));
            if (str != null) {
                return zza(str);
            }
        } else if (this.zzao.zzax == null || (Build.VERSION.SDK_INT >= 24 && !zzal.isDeviceProtectedStorage() && !((UserManager) zzal.getSystemService(UserManager.class)).isUserUnlocked())) {
            return null;
        } else {
            SharedPreferences sharedPreferences = zzal.getSharedPreferences(this.zzao.zzax, 0);
            if (sharedPreferences.contains(this.zzap)) {
                return zza(sharedPreferences);
            }
        }
        return null;
    }

    @Nullable
    private final T zze() {
        String str;
        if (this.zzao.zzbb || !zzf() || (str = (String) zza(new zzp(this))) == null) {
            return null;
        }
        return zza(str);
    }

    private static boolean zzf() {
        if (zzan == null) {
            Context context = zzal;
            boolean z = false;
            if (context == null) {
                return false;
            }
            if (PermissionChecker.checkCallingOrSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z = true;
            }
            zzan = Boolean.valueOf(z);
        }
        return zzan.booleanValue();
    }

    @KeepForSdk
    public T get() {
        if (zzal != null) {
            if (this.zzao.zzbc) {
                T zze = zze();
                if (zze != null) {
                    return zze;
                }
                T zzd = zzd();
                if (zzd != null) {
                    return zzd;
                }
            } else {
                T zzd2 = zzd();
                if (zzd2 != null) {
                    return zzd2;
                }
                T zze2 = zze();
                if (zze2 != null) {
                    return zze2;
                }
            }
            return this.zzar;
        }
        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }

    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(String str);

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzg() {
        return zzf.zza(zzal.getContentResolver(), this.zzaq, (String) null);
    }
}
