package io.grpc;

import com.google.common.annotations.VisibleForTesting;
import java.util.ArrayList;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

final class ServiceProviders {

    public interface PriorityAccessor<T> {
        int getPriority(T t);

        boolean isAvailable(T t);
    }

    private ServiceProviders() {
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Iterable<java.lang.Class<?>>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> T load(java.lang.Class<T> r0, java.lang.Iterable<java.lang.Class<?>> r1, java.lang.ClassLoader r2, io.grpc.ServiceProviders.PriorityAccessor<T> r3) {
        /*
            java.util.List r0 = loadAll(r0, r1, r2, r3)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x000c
            r0 = 0
            return r0
        L_0x000c:
            r1 = 0
            java.lang.Object r0 = r0.get(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.ServiceProviders.load(java.lang.Class, java.lang.Iterable, java.lang.ClassLoader, io.grpc.ServiceProviders$PriorityAccessor):java.lang.Object");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Iterable<java.lang.Class<?>>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T> java.util.List<T> loadAll(java.lang.Class<T> r1, java.lang.Iterable<java.lang.Class<?>> r2, java.lang.ClassLoader r3, final io.grpc.ServiceProviders.PriorityAccessor<T> r4) {
        /*
            boolean r0 = isAndroid(r3)
            if (r0 == 0) goto L_0x000b
            java.lang.Iterable r1 = getCandidatesViaHardCoded(r1, r2)
            goto L_0x000f
        L_0x000b:
            java.lang.Iterable r1 = getCandidatesViaServiceLoader(r1, r3)
        L_0x000f:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r1 = r1.iterator()
        L_0x0018:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x002d
            java.lang.Object r3 = r1.next()
            boolean r0 = r4.isAvailable(r3)
            if (r0 != 0) goto L_0x0029
            goto L_0x0018
        L_0x0029:
            r2.add(r3)
            goto L_0x0018
        L_0x002d:
            io.grpc.ServiceProviders$1 r1 = new io.grpc.ServiceProviders$1
            r1.<init>()
            java.util.Comparator r1 = java.util.Collections.reverseOrder(r1)
            java.util.Collections.sort(r2, r1)
            java.util.List r1 = java.util.Collections.unmodifiableList(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.ServiceProviders.loadAll(java.lang.Class, java.lang.Iterable, java.lang.ClassLoader, io.grpc.ServiceProviders$PriorityAccessor):java.util.List");
    }

    static boolean isAndroid(ClassLoader classLoader) {
        try {
            Class.forName("android.app.Application", false, classLoader);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @VisibleForTesting
    public static <T> Iterable<T> getCandidatesViaServiceLoader(Class<T> cls, ClassLoader classLoader) {
        ServiceLoader<S> load = ServiceLoader.load(cls, classLoader);
        return !load.iterator().hasNext() ? ServiceLoader.load(cls) : load;
    }

    @VisibleForTesting
    static <T> Iterable<T> getCandidatesViaHardCoded(Class<T> cls, Iterable<Class<?>> iterable) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> create : iterable) {
            arrayList.add(create(cls, create));
        }
        return arrayList;
    }

    @VisibleForTesting
    static <T> T create(Class<T> cls, Class<?> cls2) {
        try {
            return cls2.asSubclass(cls).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            throw new ServiceConfigurationError(String.format("Provider %s could not be instantiated %s", new Object[]{cls2.getName(), th}), th);
        }
    }
}
