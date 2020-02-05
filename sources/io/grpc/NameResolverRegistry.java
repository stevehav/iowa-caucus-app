package io.grpc;

import androidx.core.os.EnvironmentCompat;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import io.grpc.NameResolver;
import io.grpc.ServiceProviders;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.ThreadSafe;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/4159")
@ThreadSafe
public final class NameResolverRegistry {
    private static NameResolverRegistry instance;
    private static final Logger logger = Logger.getLogger(NameResolverRegistry.class.getName());
    @GuardedBy("this")
    private final LinkedHashSet<NameResolverProvider> allProviders = new LinkedHashSet<>();
    @GuardedBy("this")
    private List<NameResolverProvider> effectiveProviders = Collections.emptyList();
    private final NameResolver.Factory factory = new NameResolverFactory();

    public synchronized void register(NameResolverProvider nameResolverProvider) {
        addProvider(nameResolverProvider);
        refreshProviders();
    }

    private synchronized void addProvider(NameResolverProvider nameResolverProvider) {
        Preconditions.checkArgument(nameResolverProvider.isAvailable(), "isAvailable() returned false");
        this.allProviders.add(nameResolverProvider);
    }

    public synchronized void deregister(NameResolverProvider nameResolverProvider) {
        this.allProviders.remove(nameResolverProvider);
        refreshProviders();
    }

    private synchronized void refreshProviders() {
        ArrayList arrayList = new ArrayList(this.allProviders);
        Collections.sort(arrayList, Collections.reverseOrder(new Comparator<NameResolverProvider>() {
            public int compare(NameResolverProvider nameResolverProvider, NameResolverProvider nameResolverProvider2) {
                return nameResolverProvider.priority() - nameResolverProvider2.priority();
            }
        }));
        this.effectiveProviders = Collections.unmodifiableList(arrayList);
    }

    public static synchronized NameResolverRegistry getDefaultRegistry() {
        NameResolverRegistry nameResolverRegistry;
        synchronized (NameResolverRegistry.class) {
            if (instance == null) {
                List<T> loadAll = ServiceProviders.loadAll(NameResolverProvider.class, getHardCodedClasses(), NameResolverProvider.class.getClassLoader(), new NameResolverPriorityAccessor());
                if (loadAll.isEmpty()) {
                    logger.warning("No NameResolverProviders found via ServiceLoader, including for DNS. This is probably due to a broken build. If using ProGuard, check your configuration");
                }
                instance = new NameResolverRegistry();
                for (T t : loadAll) {
                    Logger logger2 = logger;
                    logger2.fine("Service loader found " + t);
                    if (t.isAvailable()) {
                        instance.addProvider(t);
                    }
                }
                instance.refreshProviders();
            }
            nameResolverRegistry = instance;
        }
        return nameResolverRegistry;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public synchronized List<NameResolverProvider> providers() {
        return this.effectiveProviders;
    }

    public NameResolver.Factory asFactory() {
        return this.factory;
    }

    @VisibleForTesting
    static List<Class<?>> getHardCodedClasses() {
        ArrayList arrayList = new ArrayList();
        try {
            arrayList.add(Class.forName("io.grpc.internal.DnsNameResolverProvider"));
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Unable to find DNS NameResolver", e);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private final class NameResolverFactory extends NameResolver.Factory {
        private NameResolverFactory() {
        }

        @Nullable
        public NameResolver newNameResolver(URI uri, NameResolver.Args args) {
            for (NameResolverProvider newNameResolver : NameResolverRegistry.this.providers()) {
                NameResolver newNameResolver2 = newNameResolver.newNameResolver(uri, args);
                if (newNameResolver2 != null) {
                    return newNameResolver2;
                }
            }
            return null;
        }

        public String getDefaultScheme() {
            List<NameResolverProvider> providers = NameResolverRegistry.this.providers();
            if (providers.isEmpty()) {
                return EnvironmentCompat.MEDIA_UNKNOWN;
            }
            return providers.get(0).getDefaultScheme();
        }
    }

    private static final class NameResolverPriorityAccessor implements ServiceProviders.PriorityAccessor<NameResolverProvider> {
        private NameResolverPriorityAccessor() {
        }

        public boolean isAvailable(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.isAvailable();
        }

        public int getPriority(NameResolverProvider nameResolverProvider) {
            return nameResolverProvider.priority();
        }
    }
}
