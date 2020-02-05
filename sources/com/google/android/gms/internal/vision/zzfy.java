package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzfy;
import com.google.android.gms.internal.vision.zzfy.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzfy<MessageType extends zzfy<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzec<MessageType, BuilderType> {
    private static Map<Object, zzfy<?, ?>> zzwl = new ConcurrentHashMap();
    protected zzip zzwj = zzip.zzhe();
    private int zzwk = -1;

    /* 'enum' modifier removed */
    public static final class zzg {
        public static final int zzwx = 1;
        public static final int zzwy = 2;
        public static final int zzwz = 3;
        public static final int zzxa = 4;
        public static final int zzxb = 5;
        public static final int zzxc = 6;
        public static final int zzxd = 7;
        private static final /* synthetic */ int[] zzxe = {zzwx, zzwy, zzwz, zzxa, zzxb, zzxc, zzxd};
        public static final int zzxf = 1;
        public static final int zzxg = 2;
        private static final /* synthetic */ int[] zzxh = {zzxf, zzxg};
        public static final int zzxi = 1;
        public static final int zzxj = 2;
        private static final /* synthetic */ int[] zzxk = {zzxi, zzxj};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FE1P6UT3FC9QMCBQ7CLN6ASJ1EHIM8JB5EDPM2PR59HKN8P949LIN8Q3FCHA6UIBEEPNMMP9R0() {
            return (int[]) zzxe.clone();
        }
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public static abstract class zzc<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zza<MessageType, BuilderType> implements zzhh {
        protected zzc(MessageType messagetype) {
            super(messagetype);
        }

        /* access modifiers changed from: protected */
        public final void zzfc() {
            if (this.zzwo) {
                super.zzfc();
                ((zzd) this.zzwn).zzwp = (zzfp) ((zzd) this.zzwn).zzwp.clone();
            }
        }

        public /* synthetic */ zzfy zzfd() {
            return (zzd) zzff();
        }

        public /* synthetic */ zzhf zzff() {
            if (this.zzwo) {
                return (zzd) this.zzwn;
            }
            ((zzd) this.zzwn).zzwp.zzci();
            return (zzd) super.zzff();
        }
    }

    public static abstract class zzd<MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>> extends zzfy<MessageType, BuilderType> implements zzhh {
        protected zzfp<zze> zzwp = zzfp.zzep();

        public final <Type> Type zzc(zzfi<MessageType, Type> zzfi) {
            zzf zzb = zzfy.zza(zzfi);
            if (zzb.zzwu == ((zzfy) zzfb())) {
                Type zza = this.zzwp.zza(zzb.zzww);
                if (zza == null) {
                    return zzb.zzgq;
                }
                if (!zzb.zzww.zzws) {
                    return zzb.zzg(zza);
                }
                if (zzb.zzww.zzwr.zzho() != zzji.ENUM) {
                    return zza;
                }
                Type arrayList = new ArrayList();
                for (Object zzg : (List) zza) {
                    arrayList.add(zzb.zzg(zzg));
                }
                return arrayList;
            }
            throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
        }
    }

    public static class zzb<T extends zzfy<T, ?>> extends zzee<T> {
        private final T zzwm;

        public zzb(T t) {
            this.zzwm = t;
        }

        public final /* synthetic */ Object zza(zzez zzez, zzfk zzfk) throws zzgf {
            return zzfy.zza(this.zzwm, zzez, zzfk);
        }
    }

    public String toString() {
        return zzhi.zza(this, super.toString());
    }

    public int hashCode() {
        if (this.zzri != 0) {
            return this.zzri;
        }
        this.zzri = zzhs.zzgl().zzs(this).hashCode(this);
        return this.zzri;
    }

    static final class zze implements zzfr<zze> {
        final int number = 202056002;
        final zzgc<?> zzwq = null;
        final zzjd zzwr;
        final boolean zzws;
        final boolean zzwt;

        zze(zzgc<?> zzgc, int i, zzjd zzjd, boolean z, boolean z2) {
            this.zzwr = zzjd;
            this.zzws = true;
            this.zzwt = false;
        }

        public final int zzr() {
            return this.number;
        }

        public final zzjd zzes() {
            return this.zzwr;
        }

        public final zzji zzet() {
            return this.zzwr.zzho();
        }

        public final boolean zzeu() {
            return this.zzws;
        }

        public final boolean zzev() {
            return this.zzwt;
        }

        public final zzhg zza(zzhg zzhg, zzhf zzhf) {
            return ((zza) zzhg).zza((zzfy) zzhf);
        }

        public final zzhm zza(zzhm zzhm, zzhm zzhm2) {
            throw new UnsupportedOperationException();
        }

        public final /* synthetic */ int compareTo(Object obj) {
            return this.number - ((zze) obj).number;
        }
    }

    public static abstract class zza<MessageType extends zzfy<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzed<MessageType, BuilderType> {
        private final MessageType zzwm;
        protected MessageType zzwn;
        protected boolean zzwo = false;

        protected zza(MessageType messagetype) {
            this.zzwm = messagetype;
            this.zzwn = (zzfy) messagetype.zza(zzg.zzxa, (Object) null, (Object) null);
        }

        /* access modifiers changed from: protected */
        public void zzfc() {
            if (this.zzwo) {
                MessageType messagetype = (zzfy) this.zzwn.zza(zzg.zzxa, (Object) null, (Object) null);
                zza(messagetype, this.zzwn);
                this.zzwn = messagetype;
                this.zzwo = false;
            }
        }

        public final boolean isInitialized() {
            return zzfy.zza(this.zzwn, false);
        }

        /* renamed from: zzfd */
        public MessageType zzff() {
            if (this.zzwo) {
                return this.zzwn;
            }
            MessageType messagetype = this.zzwn;
            zzhs.zzgl().zzs(messagetype).zze(messagetype);
            this.zzwo = true;
            return this.zzwn;
        }

        /* renamed from: zzfe */
        public final MessageType zzfg() {
            MessageType messagetype = (zzfy) zzff();
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) messagetype.zza(zzg.zzwx, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzhs.zzgl().zzs(messagetype).zzr(messagetype);
                    if (booleanValue) {
                        messagetype.zza(zzg.zzwy, (Object) z ? messagetype : null, (Object) null);
                    }
                }
            }
            if (z) {
                return messagetype;
            }
            throw new zzin(messagetype);
        }

        public final BuilderType zza(MessageType messagetype) {
            zzfc();
            zza(this.zzwn, messagetype);
            return this;
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzhs.zzgl().zzs(messagetype).zzc(messagetype, messagetype2);
        }

        public final /* synthetic */ zzed zzcg() {
            return (zza) clone();
        }

        public final /* synthetic */ zzhf zzfb() {
            return this.zzwm;
        }

        public /* synthetic */ Object clone() throws CloneNotSupportedException {
            zza zza = (zza) ((zzfy) this.zzwm).zza(zzg.zzxb, (Object) null, (Object) null);
            zza.zza((zzfy) zzff());
            return zza;
        }
    }

    public static class zzf<ContainingType extends zzhf, Type> extends zzfi<ContainingType, Type> {
        final Type zzgq;
        final ContainingType zzwu;
        final zzhf zzwv;
        final zze zzww;

        zzf(ContainingType containingtype, Type type, zzhf zzhf, zze zze, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            } else if (zze.zzwr == zzjd.MESSAGE && zzhf == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            } else {
                this.zzwu = containingtype;
                this.zzgq = type;
                this.zzwv = zzhf;
                this.zzww = zze;
            }
        }

        /* access modifiers changed from: package-private */
        public final Object zzg(Object obj) {
            return this.zzww.zzwr.zzho() == zzji.ENUM ? this.zzww.zzwq.zzf(((Integer) obj).intValue()) : obj;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!((zzfy) zza(zzg.zzxc, (Object) null, (Object) null)).getClass().isInstance(obj)) {
            return false;
        }
        return zzhs.zzgl().zzs(this).equals(this, (zzfy) obj);
    }

    public final boolean isInitialized() {
        boolean booleanValue = Boolean.TRUE.booleanValue();
        byte byteValue = ((Byte) zza(zzg.zzwx, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzr = zzhs.zzgl().zzs(this).zzr(this);
        if (booleanValue) {
            zza(zzg.zzwy, (Object) zzr ? this : null, (Object) null);
        }
        return zzr;
    }

    /* access modifiers changed from: package-private */
    public final int zzcf() {
        return this.zzwk;
    }

    /* access modifiers changed from: package-private */
    public final void zzy(int i) {
        this.zzwk = i;
    }

    public final void zzb(zzfe zzfe) throws IOException {
        zzhs.zzgl().zzf(getClass()).zza(this, zzfg.zza(zzfe));
    }

    public final int zzeq() {
        if (this.zzwk == -1) {
            this.zzwk = zzhs.zzgl().zzs(this).zzp(this);
        }
        return this.zzwk;
    }

    static <T extends zzfy<?, ?>> T zzd(Class<T> cls) {
        T t = (zzfy) zzwl.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzfy) zzwl.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzfy) ((zzfy) zziu.zzh(cls)).zza(zzg.zzxc, (Object) null, (Object) null);
            if (t != null) {
                zzwl.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    protected static <T extends zzfy<?, ?>> void zza(Class<T> cls, T t) {
        zzwl.put(cls, t);
    }

    protected static Object zza(zzhf zzhf, String str, Object[] objArr) {
        return new zzhu(zzhf, str, objArr);
    }

    public static <ContainingType extends zzhf, Type> zzf<ContainingType, Type> zza(ContainingType containingtype, zzhf zzhf, zzgc<?> zzgc, int i, zzjd zzjd, boolean z, Class cls) {
        return new zzf(containingtype, Collections.emptyList(), zzhf, new zze((zzgc<?>) null, 202056002, zzjd, true, false), cls);
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

    /* access modifiers changed from: private */
    public static <MessageType extends zzd<MessageType, BuilderType>, BuilderType extends zzc<MessageType, BuilderType>, T> zzf<MessageType, T> zza(zzfi<MessageType, T> zzfi) {
        return (zzf) zzfi;
    }

    protected static final <T extends zzfy<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzg.zzwx, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        return zzhs.zzgl().zzs(t).zzr(t);
    }

    protected static <E> zzge<E> zzey() {
        return zzht.zzgm();
    }

    static <T extends zzfy<T, ?>> T zza(T t, zzez zzez, zzfk zzfk) throws zzgf {
        T t2 = (zzfy) t.zza(zzg.zzxa, (Object) null, (Object) null);
        try {
            zzhs.zzgl().zzs(t2).zza(t2, zzfc.zza(zzez), zzfk);
            zzhs.zzgl().zzs(t2).zze(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzgf) {
                throw ((zzgf) e.getCause());
            }
            throw new zzgf(e.getMessage()).zzg(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzgf) {
                throw ((zzgf) e2.getCause());
            }
            throw e2;
        }
    }

    private static <T extends zzfy<T, ?>> T zza(T t, byte[] bArr) throws zzgf {
        T t2 = (zzfy) t.zza(zzg.zzxa, (Object) null, (Object) null);
        try {
            zzhs.zzgl().zzs(t2).zza(t2, bArr, 0, bArr.length, new zzei());
            zzhs.zzgl().zzs(t2).zze(t2);
            if (t2.zzri == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzgf) {
                throw ((zzgf) e.getCause());
            }
            throw new zzgf(e.getMessage()).zzg(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzgf.zzfh().zzg(t2);
        }
    }

    private static <T extends zzfy<T, ?>> T zza(T t, byte[] bArr, zzfk zzfk) throws zzgf {
        T zza2;
        try {
            zzez zzf2 = zzez.zzf(bArr);
            zza2 = zza(t, zzf2, zzfk);
            zzf2.zzak(0);
            return zza2;
        } catch (zzgf e) {
            throw e.zzg(zza2);
        } catch (zzgf e2) {
            throw e2;
        }
    }

    protected static <T extends zzfy<T, ?>> T zzb(T t, byte[] bArr) throws zzgf {
        T zza2 = zza(t, bArr);
        if (zza2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zza2.zza(zzg.zzwx, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzhs.zzgl().zzs(zza2).zzr(zza2);
                    if (booleanValue) {
                        zza2.zza(zzg.zzwy, (Object) z ? zza2 : null, (Object) null);
                    }
                }
            }
            if (!z) {
                throw new zzin(zza2).zzhc().zzg(zza2);
            }
        }
        return zza2;
    }

    protected static <T extends zzfy<T, ?>> T zzb(T t, byte[] bArr, zzfk zzfk) throws zzgf {
        T zza2 = zza(t, bArr, zzfk);
        if (zza2 != null) {
            boolean booleanValue = Boolean.TRUE.booleanValue();
            byte byteValue = ((Byte) zza2.zza(zzg.zzwx, (Object) null, (Object) null)).byteValue();
            boolean z = true;
            if (byteValue != 1) {
                if (byteValue == 0) {
                    z = false;
                } else {
                    z = zzhs.zzgl().zzs(zza2).zzr(zza2);
                    if (booleanValue) {
                        zza2.zza(zzg.zzwy, (Object) z ? zza2 : null, (Object) null);
                    }
                }
            }
            if (!z) {
                throw new zzin(zza2).zzhc().zzg(zza2);
            }
        }
        return zza2;
    }

    public final /* synthetic */ zzhg zzez() {
        zza zza2 = (zza) zza(zzg.zzxb, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzhg zzfa() {
        return (zza) zza(zzg.zzxb, (Object) null, (Object) null);
    }

    public final /* synthetic */ zzhf zzfb() {
        return (zzfy) zza(zzg.zzxc, (Object) null, (Object) null);
    }
}
