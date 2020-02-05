package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import com.google.android.gms.internal.measurement.zzfd.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
public abstract class zzfd<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdl<MessageType, BuilderType> {
    private static Map<Object, zzfd<?, ?>> zzd = new ConcurrentHashMap();
    protected zzhx zzb = zzhx.zza();
    private int zzc = -1;

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
    public static class zzc<T extends zzfd<T, ?>> extends zzdm<T> {
        private final T zza;

        public zzc(T t) {
            this.zza = t;
        }
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
    public static final class zzd {
        public static final int zza = 1;
        public static final int zzb = 2;
        public static final int zzc = 3;
        public static final int zzd = 4;
        public static final int zze = 5;
        public static final int zzf = 6;
        public static final int zzg = 7;
        public static final int zzh = 1;
        public static final int zzi = 2;
        public static final int zzj = 1;
        public static final int zzk = 2;
        private static final /* synthetic */ int[] zzl = {zza, zzb, zzc, zzd, zze, zzf, zzg};
        private static final /* synthetic */ int[] zzm = {zzh, zzi};
        private static final /* synthetic */ int[] zzn = {zzj, zzk};

        public static int[] zza() {
            return (int[]) zzl.clone();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
    public static class zze<ContainingType extends zzgn, Type> extends zzeo<ContainingType, Type> {
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzfd<MessageType, BuilderType> implements zzgp {
        protected zzet<Object> zzc = zzet.zza();

        /* access modifiers changed from: package-private */
        public final zzet<Object> zza() {
            if (this.zzc.zzc()) {
                this.zzc = (zzet) this.zzc.clone();
            }
            return this.zzc;
        }
    }

    public String toString() {
        return zzgo.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzgy.zza().zza(this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@17.0.1 */
    public static abstract class zza<MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzdn<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;
        private boolean zzc = false;

        protected zza(MessageType messagetype) {
            this.zzb = messagetype;
            this.zza = (zzfd) messagetype.zza(zzd.zzd, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzp() {
            if (this.zzc) {
                MessageType messagetype = (zzfd) this.zza.zza(zzd.zzd, (Object) null, (Object) null);
                zza(messagetype, this.zza);
                this.zza = messagetype;
                this.zzc = false;
            }
        }

        public final boolean h_() {
            return zzfd.zza(this.zza, false);
        }

        /* renamed from: zzr */
        public MessageType zzt() {
            if (this.zzc) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzgy.zza().zza(messagetype).zzc(messagetype);
            this.zzc = true;
            return this.zza;
        }

        /* renamed from: zzs */
        public final MessageType zzu() {
            MessageType messagetype = (zzfd) zzt();
            if (messagetype.h_()) {
                return messagetype;
            }
            throw new zzhv(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzp();
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzgy.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzeq zzeq) throws zzfn {
            zzp();
            try {
                zzgy.zza().zza(this.zza).zza(this.zza, bArr, 0, i2 + 0, new zzdq(zzeq));
                return this;
            } catch (zzfn e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzfn.zza();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzeh zzeh, zzeq zzeq) throws IOException {
            zzp();
            try {
                zzgy.zza().zza(this.zza).zza(this.zza, zzei.zza(zzeh), zzeq);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        public final /* synthetic */ zzdn zza(byte[] bArr, int i, int i2, zzeq zzeq) throws zzfn {
            return zzb(bArr, 0, i2, zzeq);
        }

        public final /* synthetic */ zzdn zzo() {
            return (zza) clone();
        }

        public final /* synthetic */ zzgn zzv() {
            return this.zzb;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza2 = (zza) ((zzfd) this.zzb).zza(zzd.zze, (Object) null, (Object) null);
            zza2.zza((zzfd) zzt());
            return zza2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzfd) zza(zzd.zzf, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzgy.zza().zza(this).zza(this, (zzfd) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzfd<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbj() {
        return (zza) zza(zzd.zze, (Object) null, (Object) null);
    }

    public final boolean h_() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public final BuilderType zzbk() {
        BuilderType buildertype = (zza) zza(zzd.zze, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    /* access modifiers changed from: package-private */
    public final int zzbi() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(int i) {
        this.zzc = i;
    }

    public final void zza(zzek zzek) throws IOException {
        zzgy.zza().zza(this).zza(this, (zzir) zzen.zza(zzek));
    }

    public final int zzbl() {
        if (this.zzc == -1) {
            this.zzc = zzgy.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzfd<?, ?>> T zza(Class<T> cls) {
        T t = (zzfd) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzfd) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzfd) ((zzfd) zzia.zza(cls)).zza(zzd.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzfd<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzgn zzgn, String str, Object[] objArr) {
        return new zzha(zzgn, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static final <T extends zzfd<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzd.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzgy.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zzd.zzb, (Object) zzd2 ? t : null, (Object) null);
        }
        return zzd2;
    }

    protected static zzfi zzbm() {
        return zzff.zzd();
    }

    protected static zzfl zzbn() {
        return zzgb.zzd();
    }

    protected static zzfl zza(zzfl zzfl) {
        int size = zzfl.size();
        return zzfl.zzc(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzfk<E> zzbo() {
        return zzhb.zzd();
    }

    protected static <E> zzfk<E> zza(zzfk<E> zzfk) {
        int size = zzfk.size();
        return zzfk.zza(size == 0 ? 10 : size << 1);
    }

    private static <T extends zzfd<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzeq zzeq) throws zzfn {
        T t2 = (zzfd) t.zza(zzd.zzd, (Object) null, (Object) null);
        try {
            zzhc zza2 = zzgy.zza().zza(t2);
            zza2.zza(t2, bArr, 0, i2, new zzdq(zzeq));
            zza2.zzc(t2);
            if (t2.zza == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzfn) {
                throw ((zzfn) e.getCause());
            }
            throw new zzfn(e.getMessage()).zza(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzfn.zza().zza(t2);
        }
    }

    protected static <T extends zzfd<T, ?>> T zza(T t, byte[] bArr, zzeq zzeq) throws zzfn {
        T zza2 = zza(t, bArr, 0, bArr.length, zzeq);
        if (zza2 == null || zza2.h_()) {
            return zza2;
        }
        throw new zzfn(new zzhv(zza2).getMessage()).zza(zza2);
    }

    public final /* synthetic */ zzgm zzbp() {
        zza zza2 = (zza) zza(zzd.zze, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzgm zzbq() {
        return (zza) zza(zzd.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzgn zzv() {
        return (zzfd) zza(zzd.zzf, (Object) null, (Object) null);
    }
}
