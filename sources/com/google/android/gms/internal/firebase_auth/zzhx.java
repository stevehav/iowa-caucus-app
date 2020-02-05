package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzhx;
import com.google.android.gms.internal.firebase_auth.zzhx.zzb;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
public abstract class zzhx<MessageType extends zzhx<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzge<MessageType, BuilderType> {
    private static Map<Object, zzhx<?, ?>> zzd = new ConcurrentHashMap();
    protected zzkr zzb = zzkr.zza();
    private int zzc = -1;

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static class zzc<ContainingType extends zzjg, Type> extends zzhl<ContainingType, Type> {
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType> extends zzhx<MessageType, BuilderType> implements zzji {
        protected zzhq<Object> zzc = zzhq.zza();
    }

    /* 'enum' modifier removed */
    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static final class zze {
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

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static class zza<T extends zzhx<T, ?>> extends zzgj<T> {
        private final T zza;

        public zza(T t) {
            this.zza = t;
        }

        public final /* synthetic */ Object zza(zzgy zzgy, zzhk zzhk) throws zzig {
            return zzhx.zza(this.zza, zzgy, zzhk);
        }
    }

    public String toString() {
        return zzjl.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zza != 0) {
            return this.zza;
        }
        this.zza = zzjs.zza().zza(this).zza(this);
        return this.zza;
    }

    /* compiled from: com.google.firebase:firebase-auth@@18.1.0 */
    public static abstract class zzb<MessageType extends zzhx<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> extends zzgh<MessageType, BuilderType> {
        protected MessageType zza;
        private final MessageType zzb;
        private boolean zzc = false;

        protected zzb(MessageType messagetype) {
            this.zzb = messagetype;
            this.zza = (zzhx) messagetype.zza(zze.zzd, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public final void zzb() {
            if (this.zzc) {
                MessageType messagetype = (zzhx) this.zza.zza(zze.zzd, (Object) null, (Object) null);
                zza(messagetype, this.zza);
                this.zza = messagetype;
                this.zzc = false;
            }
        }

        public final boolean zzaa() {
            return zzhx.zza(this.zza, false);
        }

        /* renamed from: zzc */
        public MessageType zze() {
            if (this.zzc) {
                return this.zza;
            }
            MessageType messagetype = this.zza;
            zzjs.zza().zza(messagetype).zzc(messagetype);
            this.zzc = true;
            return this.zza;
        }

        /* renamed from: zzd */
        public final MessageType zzf() {
            MessageType messagetype = (zzhx) zze();
            if (messagetype.zzaa()) {
                return messagetype;
            }
            throw new zzkq(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzb();
            zza(this.zza, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzjs.zza().zza(messagetype).zzb(messagetype, messagetype2);
        }

        public final /* synthetic */ zzgh zza() {
            return (zzb) clone();
        }

        public final /* synthetic */ zzjg zzag() {
            return this.zzb;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zzb zzb2 = (zzb) ((zzhx) this.zzb).zza(zze.zze, (Object) null, (Object) null);
            zzb2.zza((zzhx) zze());
            return zzb2;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzhx) zza(zze.zzf, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzjs.zza().zza(this).zza(this, (zzhx) obj);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzhx<MessageType, BuilderType>, BuilderType extends zzb<MessageType, BuilderType>> BuilderType zzz() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final boolean zzaa() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    /* access modifiers changed from: package-private */
    public final int zzy() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i) {
        this.zzc = i;
    }

    public final void zza(zzhh zzhh) throws IOException {
        zzjs.zza().zza(this).zza(this, (zzll) zzhj.zza(zzhh));
    }

    public final int zzab() {
        if (this.zzc == -1) {
            this.zzc = zzjs.zza().zza(this).zzb(this);
        }
        return this.zzc;
    }

    static <T extends zzhx<?, ?>> T zza(Class<T> cls) {
        T t = (zzhx) zzd.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzhx) zzd.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzhx) ((zzhx) zzky.zza(cls)).zza(zze.zzf, (Object) null, (Object) null);
            if (t != null) {
                zzd.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzhx<?, ?>> void zza(Class<T> cls, T t) {
        zzd.put(cls, t);
    }

    protected static Object zza(zzjg zzjg, String str, Object[] objArr) {
        return new zzju(zzjg, str, objArr);
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

    protected static final <T extends zzhx<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zze.zza, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzd2 = zzjs.zza().zza(t).zzd(t);
        if (z) {
            t.zza(zze.zzb, (Object) zzd2 ? t : null, (Object) null);
        }
        return zzd2;
    }

    protected static zzif zzac() {
        return zzhz.zzd();
    }

    protected static <E> zzih<E> zzad() {
        return zzjv.zzd();
    }

    static <T extends zzhx<T, ?>> T zza(T t, zzgy zzgy, zzhk zzhk) throws zzig {
        T t2 = (zzhx) t.zza(zze.zzd, (Object) null, (Object) null);
        try {
            zzjw zza2 = zzjs.zza().zza(t2);
            zza2.zza(t2, zzhf.zza(zzgy), zzhk);
            zza2.zzc(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzig) {
                throw ((zzig) e.getCause());
            }
            throw new zzig(e.getMessage()).zza(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzig) {
                throw ((zzig) e2.getCause());
            }
            throw e2;
        }
    }

    public final /* synthetic */ zzjj zzae() {
        zzb zzb2 = (zzb) zza(zze.zze, (Object) null, (Object) null);
        zzb2.zza(this);
        return zzb2;
    }

    public final /* synthetic */ zzjj zzaf() {
        return (zzb) zza(zze.zze, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzjg zzag() {
        return (zzhx) zza(zze.zzf, (Object) null, (Object) null);
    }
}
