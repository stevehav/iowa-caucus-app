package com.google.android.gms.flags;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
@Deprecated
public abstract class Flag<T> {
    private final String mKey;
    private final int zze;
    private final T zzf;

    private Flag(int i, String str, T t) {
        this.zze = i;
        this.mKey = str;
        this.zzf = t;
        Singletons.flagRegistry().zza(this);
    }

    /* access modifiers changed from: protected */
    public abstract T zza(zzc zzc);

    @Deprecated
    public static class BooleanFlag extends Flag<Boolean> {
        public BooleanFlag(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final Boolean zza(zzc zzc) {
            try {
                return Boolean.valueOf(zzc.getBooleanFlagValue(getKey(), ((Boolean) zzb()).booleanValue(), getSource()));
            } catch (RemoteException unused) {
                return (Boolean) zzb();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class IntegerFlag extends Flag<Integer> {
        public IntegerFlag(int i, String str, Integer num) {
            super(i, str, num);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzc */
        public final Integer zza(zzc zzc) {
            try {
                return Integer.valueOf(zzc.getIntFlagValue(getKey(), ((Integer) zzb()).intValue(), getSource()));
            } catch (RemoteException unused) {
                return (Integer) zzb();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class LongFlag extends Flag<Long> {
        public LongFlag(int i, String str, Long l) {
            super(i, str, l);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzd */
        public final Long zza(zzc zzc) {
            try {
                return Long.valueOf(zzc.getLongFlagValue(getKey(), ((Long) zzb()).longValue(), getSource()));
            } catch (RemoteException unused) {
                return (Long) zzb();
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public static class StringFlag extends Flag<String> {
        public StringFlag(int i, String str, String str2) {
            super(i, str, str2);
        }

        /* access modifiers changed from: private */
        /* renamed from: zze */
        public final String zza(zzc zzc) {
            try {
                return zzc.getStringFlagValue(getKey(), (String) zzb(), getSource());
            } catch (RemoteException unused) {
                return (String) zzb();
            }
        }
    }

    public final String getKey() {
        return this.mKey;
    }

    public final T zzb() {
        return this.zzf;
    }

    @KeepForSdk
    public T get() {
        return Singletons.zzd().zzb(this);
    }

    @KeepForSdk
    @Deprecated
    public static BooleanFlag define(int i, String str, Boolean bool) {
        return new BooleanFlag(i, str, bool);
    }

    @KeepForSdk
    @Deprecated
    public static IntegerFlag define(int i, String str, int i2) {
        return new IntegerFlag(i, str, Integer.valueOf(i2));
    }

    @KeepForSdk
    @Deprecated
    public static LongFlag define(int i, String str, long j) {
        return new LongFlag(i, str, Long.valueOf(j));
    }

    @KeepForSdk
    @Deprecated
    public static StringFlag define(int i, String str, String str2) {
        return new StringFlag(i, str, str2);
    }

    @Deprecated
    public final int getSource() {
        return this.zze;
    }
}
