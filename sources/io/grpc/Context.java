package io.grpc;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

@CheckReturnValue
public class Context {
    static final int CONTEXT_DEPTH_WARN_THRESH = 1000;
    private static final PersistentHashArrayMappedTrie<Key<?>, Object> EMPTY_ENTRIES = new PersistentHashArrayMappedTrie<>();
    public static final Context ROOT = new Context((Context) null, EMPTY_ENTRIES);
    static final Logger log = Logger.getLogger(Context.class.getName());
    final CancellableContext cancellableAncestor;
    final int generation;
    final PersistentHashArrayMappedTrie<Key<?>, Object> keyValueEntries;
    private ArrayList<ExecutableListener> listeners;
    private CancellationListener parentListener;

    @interface CanIgnoreReturnValue {
    }

    public interface CancellationListener {
        void cancelled(Context context);
    }

    @interface CheckReturnValue {
    }

    static Storage storage() {
        return LazyStorage.storage;
    }

    private static final class LazyStorage {
        static final Storage storage;

        private LazyStorage() {
        }

        static {
            AtomicReference atomicReference = new AtomicReference();
            storage = createStorage(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                Context.log.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        private static Storage createStorage(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (Storage) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(Storage.class).getConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e) {
                atomicReference.set(e);
                return new ThreadLocalContextStorage();
            } catch (Exception e2) {
                throw new RuntimeException("Storage override failed to initialize", e2);
            }
        }
    }

    public static <T> Key<T> key(String str) {
        return new Key<>(str);
    }

    public static <T> Key<T> keyWithDefault(String str, T t) {
        return new Key<>(str, t);
    }

    public static Context current() {
        Context current = storage().current();
        return current == null ? ROOT : current;
    }

    private Context(PersistentHashArrayMappedTrie<Key<?>, Object> persistentHashArrayMappedTrie, int i) {
        this.parentListener = new ParentListener();
        this.cancellableAncestor = null;
        this.keyValueEntries = persistentHashArrayMappedTrie;
        this.generation = i;
        validateGeneration(i);
    }

    private Context(Context context, PersistentHashArrayMappedTrie<Key<?>, Object> persistentHashArrayMappedTrie) {
        int i;
        this.parentListener = new ParentListener();
        this.cancellableAncestor = cancellableAncestor(context);
        this.keyValueEntries = persistentHashArrayMappedTrie;
        if (context == null) {
            i = 0;
        } else {
            i = context.generation + 1;
        }
        this.generation = i;
        validateGeneration(this.generation);
    }

    public CancellableContext withCancellation() {
        return new CancellableContext();
    }

    public CancellableContext withDeadlineAfter(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return withDeadline(Deadline.after(j, timeUnit), scheduledExecutorService);
    }

    public CancellableContext withDeadline(Deadline deadline, ScheduledExecutorService scheduledExecutorService) {
        checkNotNull(deadline, "deadline");
        checkNotNull(scheduledExecutorService, "scheduler");
        return new CancellableContext(deadline, scheduledExecutorService);
    }

    public <V> Context withValue(Key<V> key, V v) {
        return new Context(this, this.keyValueEntries.put(key, v));
    }

    public <V1, V2> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2) {
        return new Context(this, this.keyValueEntries.put(key, v1).put(key2, v2));
    }

    public <V1, V2, V3> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2, Key<V3> key3, V3 v3) {
        return new Context(this, this.keyValueEntries.put(key, v1).put(key2, v2).put(key3, v3));
    }

    public <V1, V2, V3, V4> Context withValues(Key<V1> key, V1 v1, Key<V2> key2, V2 v2, Key<V3> key3, V3 v3, Key<V4> key4, V4 v4) {
        return new Context(this, this.keyValueEntries.put(key, v1).put(key2, v2).put(key3, v3).put(key4, v4));
    }

    public Context fork() {
        return new Context(this.keyValueEntries, this.generation + 1);
    }

    /* access modifiers changed from: package-private */
    public boolean canBeCancelled() {
        return this.cancellableAncestor != null;
    }

    public Context attach() {
        Context doAttach = storage().doAttach(this);
        return doAttach == null ? ROOT : doAttach;
    }

    public void detach(Context context) {
        checkNotNull(context, "toAttach");
        storage().detach(this, context);
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrent() {
        return current() == this;
    }

    public boolean isCancelled() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return false;
        }
        return cancellableContext.isCancelled();
    }

    public Throwable cancellationCause() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.cancellationCause();
    }

    public Deadline getDeadline() {
        CancellableContext cancellableContext = this.cancellableAncestor;
        if (cancellableContext == null) {
            return null;
        }
        return cancellableContext.getDeadline();
    }

    public void addListener(CancellationListener cancellationListener, Executor executor) {
        checkNotNull(cancellationListener, "cancellationListener");
        checkNotNull(executor, "executor");
        if (canBeCancelled()) {
            ExecutableListener executableListener = new ExecutableListener(executor, cancellationListener);
            synchronized (this) {
                if (isCancelled()) {
                    executableListener.deliver();
                } else if (this.listeners == null) {
                    this.listeners = new ArrayList<>();
                    this.listeners.add(executableListener);
                    if (this.cancellableAncestor != null) {
                        this.cancellableAncestor.addListener(this.parentListener, DirectExecutor.INSTANCE);
                    }
                } else {
                    this.listeners.add(executableListener);
                }
            }
        }
    }

    public void removeListener(CancellationListener cancellationListener) {
        if (canBeCancelled()) {
            synchronized (this) {
                if (this.listeners != null) {
                    int size = this.listeners.size() - 1;
                    while (true) {
                        if (size < 0) {
                            break;
                        } else if (this.listeners.get(size).listener == cancellationListener) {
                            this.listeners.remove(size);
                            break;
                        } else {
                            size--;
                        }
                    }
                    if (this.listeners.isEmpty()) {
                        if (this.cancellableAncestor != null) {
                            this.cancellableAncestor.removeListener(this.parentListener);
                        }
                        this.listeners = null;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
        r1 = 0;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        if (r2 >= r0.size()) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0026, code lost:
        if ((r0.get(r2).listener instanceof io.grpc.Context.ParentListener) != false) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        r0.get(r2).deliver();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0031, code lost:
        r2 = r2 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
        if (r1 >= r0.size()) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        if ((r0.get(r1).listener instanceof io.grpc.Context.ParentListener) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r0.get(r1).deliver();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0052, code lost:
        r0 = r4.cancellableAncestor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0056, code lost:
        r0.removeListener(r4.parentListener);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyAndClearListeners() {
        /*
            r4 = this;
            boolean r0 = r4.canBeCancelled()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            monitor-enter(r4)
            java.util.ArrayList<io.grpc.Context$ExecutableListener> r0 = r4.listeners     // Catch:{ all -> 0x005c }
            if (r0 != 0) goto L_0x000e
            monitor-exit(r4)     // Catch:{ all -> 0x005c }
            return
        L_0x000e:
            java.util.ArrayList<io.grpc.Context$ExecutableListener> r0 = r4.listeners     // Catch:{ all -> 0x005c }
            r1 = 0
            r4.listeners = r1     // Catch:{ all -> 0x005c }
            monitor-exit(r4)     // Catch:{ all -> 0x005c }
            r1 = 0
            r2 = 0
        L_0x0016:
            int r3 = r0.size()
            if (r2 >= r3) goto L_0x0034
            java.lang.Object r3 = r0.get(r2)
            io.grpc.Context$ExecutableListener r3 = (io.grpc.Context.ExecutableListener) r3
            io.grpc.Context$CancellationListener r3 = r3.listener
            boolean r3 = r3 instanceof io.grpc.Context.ParentListener
            if (r3 != 0) goto L_0x0031
            java.lang.Object r3 = r0.get(r2)
            io.grpc.Context$ExecutableListener r3 = (io.grpc.Context.ExecutableListener) r3
            r3.deliver()
        L_0x0031:
            int r2 = r2 + 1
            goto L_0x0016
        L_0x0034:
            int r2 = r0.size()
            if (r1 >= r2) goto L_0x0052
            java.lang.Object r2 = r0.get(r1)
            io.grpc.Context$ExecutableListener r2 = (io.grpc.Context.ExecutableListener) r2
            io.grpc.Context$CancellationListener r2 = r2.listener
            boolean r2 = r2 instanceof io.grpc.Context.ParentListener
            if (r2 == 0) goto L_0x004f
            java.lang.Object r2 = r0.get(r1)
            io.grpc.Context$ExecutableListener r2 = (io.grpc.Context.ExecutableListener) r2
            r2.deliver()
        L_0x004f:
            int r1 = r1 + 1
            goto L_0x0034
        L_0x0052:
            io.grpc.Context$CancellableContext r0 = r4.cancellableAncestor
            if (r0 == 0) goto L_0x005b
            io.grpc.Context$CancellationListener r1 = r4.parentListener
            r0.removeListener(r1)
        L_0x005b:
            return
        L_0x005c:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x005c }
            goto L_0x0060
        L_0x005f:
            throw r0
        L_0x0060:
            goto L_0x005f
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.notifyAndClearListeners():void");
    }

    /* access modifiers changed from: package-private */
    public int listenerCount() {
        int size;
        synchronized (this) {
            size = this.listeners == null ? 0 : this.listeners.size();
        }
        return size;
    }

    public void run(Runnable runnable) {
        Context attach = attach();
        try {
            runnable.run();
        } finally {
            detach(attach);
        }
    }

    @CanIgnoreReturnValue
    public <V> V call(Callable<V> callable) throws Exception {
        Context attach = attach();
        try {
            return callable.call();
        } finally {
            detach(attach);
        }
    }

    public Runnable wrap(final Runnable runnable) {
        return new Runnable() {
            public void run() {
                Context attach = Context.this.attach();
                try {
                    runnable.run();
                } finally {
                    Context.this.detach(attach);
                }
            }
        };
    }

    public <C> Callable<C> wrap(final Callable<C> callable) {
        return new Callable<C>() {
            public C call() throws Exception {
                Context attach = Context.this.attach();
                try {
                    return callable.call();
                } finally {
                    Context.this.detach(attach);
                }
            }
        };
    }

    public Executor fixedContextExecutor(final Executor executor) {
        return new Executor() {
            public void execute(Runnable runnable) {
                executor.execute(Context.this.wrap(runnable));
            }
        };
    }

    public static Executor currentContextExecutor(final Executor executor) {
        return new Executor() {
            public void execute(Runnable runnable) {
                executor.execute(Context.current().wrap(runnable));
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Object lookup(Key<?> key) {
        return this.keyValueEntries.get(key);
    }

    public static final class CancellableContext extends Context implements Closeable {
        private Throwable cancellationCause;
        private boolean cancelled;
        private final Deadline deadline;
        private ScheduledFuture<?> pendingDeadline;
        private final Context uncancellableSurrogate;

        /* access modifiers changed from: package-private */
        public boolean canBeCancelled() {
            return true;
        }

        private CancellableContext(Context context) {
            super(context.keyValueEntries);
            this.deadline = context.getDeadline();
            this.uncancellableSurrogate = new Context(this.keyValueEntries);
        }

        private CancellableContext(Context context, Deadline deadline2, ScheduledExecutorService scheduledExecutorService) {
            super(context.keyValueEntries);
            Deadline deadline3 = context.getDeadline();
            if (deadline3 == null || deadline3.compareTo(deadline2) > 0) {
                if (!deadline2.isExpired()) {
                    this.pendingDeadline = deadline2.runOnExpiration(new Runnable() {
                        public void run() {
                            try {
                                CancellableContext.this.cancel(new TimeoutException("context timed out"));
                            } catch (Throwable th) {
                                Context.log.log(Level.SEVERE, "Cancel threw an exception, which should not happen", th);
                            }
                        }
                    }, scheduledExecutorService);
                } else {
                    cancel(new TimeoutException("context timed out"));
                }
                deadline3 = deadline2;
            }
            this.deadline = deadline3;
            this.uncancellableSurrogate = new Context(this.keyValueEntries);
        }

        public Context attach() {
            return this.uncancellableSurrogate.attach();
        }

        public void detach(Context context) {
            this.uncancellableSurrogate.detach(context);
        }

        @Deprecated
        public boolean isCurrent() {
            return this.uncancellableSurrogate.isCurrent();
        }

        @CanIgnoreReturnValue
        public boolean cancel(Throwable th) {
            boolean z;
            synchronized (this) {
                z = true;
                if (!this.cancelled) {
                    this.cancelled = true;
                    if (this.pendingDeadline != null) {
                        this.pendingDeadline.cancel(false);
                        this.pendingDeadline = null;
                    }
                    this.cancellationCause = th;
                } else {
                    z = false;
                }
            }
            if (z) {
                notifyAndClearListeners();
            }
            return z;
        }

        public void detachAndCancel(Context context, Throwable th) {
            try {
                detach(context);
            } finally {
                cancel(th);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
            return true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
            return false;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000d, code lost:
            if (io.grpc.Context.super.isCancelled() == false) goto L_0x0017;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x000f, code lost:
            cancel(io.grpc.Context.super.cancellationCause());
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean isCancelled() {
            /*
                r2 = this;
                monitor-enter(r2)
                boolean r0 = r2.cancelled     // Catch:{ all -> 0x0019 }
                r1 = 1
                if (r0 == 0) goto L_0x0008
                monitor-exit(r2)     // Catch:{ all -> 0x0019 }
                return r1
            L_0x0008:
                monitor-exit(r2)     // Catch:{ all -> 0x0019 }
                boolean r0 = io.grpc.Context.super.isCancelled()
                if (r0 == 0) goto L_0x0017
                java.lang.Throwable r0 = io.grpc.Context.super.cancellationCause()
                r2.cancel(r0)
                return r1
            L_0x0017:
                r0 = 0
                return r0
            L_0x0019:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0019 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: io.grpc.Context.CancellableContext.isCancelled():boolean");
        }

        public Throwable cancellationCause() {
            if (isCancelled()) {
                return this.cancellationCause;
            }
            return null;
        }

        public Deadline getDeadline() {
            return this.deadline;
        }

        public void close() {
            cancel((Throwable) null);
        }
    }

    public static final class Key<T> {
        private final T defaultValue;
        private final String name;

        Key(String str) {
            this(str, (Object) null);
        }

        Key(String str, T t) {
            this.name = (String) Context.checkNotNull(str, AppMeasurementSdk.ConditionalUserProperty.NAME);
            this.defaultValue = t;
        }

        public T get() {
            return get(Context.current());
        }

        public T get(Context context) {
            T lookup = context.lookup(this);
            return lookup == null ? this.defaultValue : lookup;
        }

        public String toString() {
            return this.name;
        }
    }

    public static abstract class Storage {
        public abstract Context current();

        public abstract void detach(Context context, Context context2);

        @Deprecated
        public void attach(Context context) {
            throw new UnsupportedOperationException("Deprecated. Do not call.");
        }

        public Context doAttach(Context context) {
            Context current = current();
            attach(context);
            return current;
        }
    }

    private final class ExecutableListener implements Runnable {
        private final Executor executor;
        final CancellationListener listener;

        ExecutableListener(Executor executor2, CancellationListener cancellationListener) {
            this.executor = executor2;
            this.listener = cancellationListener;
        }

        /* access modifiers changed from: package-private */
        public void deliver() {
            try {
                this.executor.execute(this);
            } catch (Throwable th) {
                Context.log.log(Level.INFO, "Exception notifying context listener", th);
            }
        }

        public void run() {
            this.listener.cancelled(Context.this);
        }
    }

    private final class ParentListener implements CancellationListener {
        private ParentListener() {
        }

        public void cancelled(Context context) {
            Context context2 = Context.this;
            if (context2 instanceof CancellableContext) {
                ((CancellableContext) context2).cancel(context.cancellationCause());
            } else {
                context2.notifyAndClearListeners();
            }
        }
    }

    @CanIgnoreReturnValue
    static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private enum DirectExecutor implements Executor {
        INSTANCE;

        public String toString() {
            return "Context.DirectExecutor";
        }

        public void execute(Runnable runnable) {
            runnable.run();
        }
    }

    static CancellableContext cancellableAncestor(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof CancellableContext) {
            return (CancellableContext) context;
        }
        return context.cancellableAncestor;
    }

    private static void validateGeneration(int i) {
        if (i == 1000) {
            log.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", new Exception());
        }
    }
}
