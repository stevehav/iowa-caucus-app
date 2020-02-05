package io.sentry.event;

import io.sentry.environment.SentryEnvironment;
import io.sentry.event.Event;
import io.sentry.event.interfaces.SentryInterface;
import io.sentry.event.interfaces.SentryStackTraceElement;
import java.net.InetAddress;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.CRC32;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventBuilder {
    public static final String DEFAULT_HOSTNAME = "unavailable";
    public static final String DEFAULT_PLATFORM = "java";
    private static final HostnameCache HOSTNAME_CACHE = new HostnameCache(HOSTNAME_CACHE_DURATION);
    public static final long HOSTNAME_CACHE_DURATION = TimeUnit.HOURS.toMillis(5);
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private boolean alreadyBuilt;
    private final Event event;
    private Set<String> sdkIntegrations;

    public EventBuilder() {
        this(UUID.randomUUID());
    }

    public EventBuilder(UUID uuid) {
        this.alreadyBuilt = false;
        this.sdkIntegrations = new HashSet();
        this.event = new Event(uuid);
    }

    private static String calculateChecksum(String str) {
        byte[] bytes = str.getBytes(UTF_8);
        CRC32 crc32 = new CRC32();
        crc32.update(bytes, 0, bytes.length);
        return Long.toHexString(crc32.getValue()).toUpperCase();
    }

    private void autoSetMissingValues() {
        if (this.event.getTimestamp() == null) {
            this.event.setTimestamp(new Date());
        }
        if (this.event.getPlatform() == null) {
            this.event.setPlatform(DEFAULT_PLATFORM);
        }
        if (this.event.getSdk() == null) {
            this.event.setSdk(new Sdk(SentryEnvironment.SDK_NAME, "1.7.23-1d154", this.sdkIntegrations));
        }
        if (this.event.getServerName() == null) {
            this.event.setServerName(HOSTNAME_CACHE.getHostname());
        }
    }

    private void makeImmutable() {
        Event event2 = this.event;
        event2.setTags(Collections.unmodifiableMap(event2.getTags()));
        Event event3 = this.event;
        event3.setBreadcrumbs(Collections.unmodifiableList(event3.getBreadcrumbs()));
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.event.getContexts().entrySet()) {
            hashMap.put(next.getKey(), Collections.unmodifiableMap((Map) next.getValue()));
        }
        this.event.setContexts(Collections.unmodifiableMap(hashMap));
        Event event4 = this.event;
        event4.setExtra(Collections.unmodifiableMap(event4.getExtra()));
        Event event5 = this.event;
        event5.setSentryInterfaces(Collections.unmodifiableMap(event5.getSentryInterfaces()));
    }

    public EventBuilder withMessage(String str) {
        this.event.setMessage(str);
        return this;
    }

    public EventBuilder withTimestamp(Date date) {
        this.event.setTimestamp(date);
        return this;
    }

    public EventBuilder withLevel(Event.Level level) {
        this.event.setLevel(level);
        return this;
    }

    public EventBuilder withRelease(String str) {
        this.event.setRelease(str);
        return this;
    }

    public EventBuilder withDist(String str) {
        this.event.setDist(str);
        return this;
    }

    public EventBuilder withEnvironment(String str) {
        this.event.setEnvironment(str);
        return this;
    }

    public EventBuilder withLogger(String str) {
        this.event.setLogger(str);
        return this;
    }

    public EventBuilder withPlatform(String str) {
        this.event.setPlatform(str);
        return this;
    }

    public EventBuilder withSdkIntegration(String str) {
        this.sdkIntegrations.add(str);
        return this;
    }

    @Deprecated
    public EventBuilder withCulprit(SentryStackTraceElement sentryStackTraceElement) {
        return withCulprit(buildCulpritString(sentryStackTraceElement.getModule(), sentryStackTraceElement.getFunction(), sentryStackTraceElement.getFileName(), sentryStackTraceElement.getLineno()));
    }

    @Deprecated
    public EventBuilder withCulprit(StackTraceElement stackTraceElement) {
        return withCulprit(buildCulpritString(stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getFileName(), stackTraceElement.getLineNumber()));
    }

    private String buildCulpritString(String str, String str2, String str3, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(".");
        sb.append(str2);
        if (str3 != null && !str3.isEmpty()) {
            sb.append("(");
            sb.append(str3);
            if (i >= 0) {
                sb.append(":");
                sb.append(i);
            }
            sb.append(")");
        }
        return sb.toString();
    }

    @Deprecated
    public EventBuilder withCulprit(String str) {
        this.event.setCulprit(str);
        return this;
    }

    public EventBuilder withTransaction(String str) {
        this.event.setTransaction(str);
        return this;
    }

    public EventBuilder withTag(String str, String str2) {
        this.event.getTags().put(str, str2);
        return this;
    }

    public EventBuilder withBreadcrumbs(List<Breadcrumb> list) {
        this.event.setBreadcrumbs(list);
        return this;
    }

    public EventBuilder withContexts(Map<String, Map<String, Object>> map) {
        this.event.setContexts(map);
        return this;
    }

    public EventBuilder withServerName(String str) {
        this.event.setServerName(str);
        return this;
    }

    public EventBuilder withExtra(String str, Object obj) {
        this.event.getExtra().put(str, obj);
        return this;
    }

    public EventBuilder withFingerprint(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        Collections.addAll(arrayList, strArr);
        this.event.setFingerprint(arrayList);
        return this;
    }

    public EventBuilder withFingerprint(List<String> list) {
        this.event.setFingerprint(list);
        return this;
    }

    public EventBuilder withChecksumFor(String str) {
        return withChecksum(calculateChecksum(str));
    }

    public EventBuilder withChecksum(String str) {
        this.event.setChecksum(str);
        return this;
    }

    public EventBuilder withSentryInterface(SentryInterface sentryInterface) {
        return withSentryInterface(sentryInterface, true);
    }

    public EventBuilder withSentryInterface(SentryInterface sentryInterface, boolean z) {
        if (z || !this.event.getSentryInterfaces().containsKey(sentryInterface.getInterfaceName())) {
            this.event.getSentryInterfaces().put(sentryInterface.getInterfaceName(), sentryInterface);
        }
        return this;
    }

    public synchronized Event build() {
        if (!this.alreadyBuilt) {
            autoSetMissingValues();
            makeImmutable();
            this.alreadyBuilt = true;
        } else {
            throw new IllegalStateException("A message can't be built twice");
        }
        return this.event;
    }

    public Event getEvent() {
        return this.event;
    }

    public String toString() {
        return "EventBuilder{event=" + this.event + ", alreadyBuilt=" + this.alreadyBuilt + '}';
    }

    private static final class HostnameCache {
        public static final long GET_HOSTNAME_TIMEOUT = TimeUnit.SECONDS.toMillis(1);
        private static final Logger logger = LoggerFactory.getLogger((Class<?>) HostnameCache.class);
        /* access modifiers changed from: private */
        public final long cacheDuration;
        /* access modifiers changed from: private */
        public volatile long expirationTimestamp;
        /* access modifiers changed from: private */
        public volatile String hostname;
        /* access modifiers changed from: private */
        public AtomicBoolean updateRunning;

        private HostnameCache(long j) {
            this.hostname = EventBuilder.DEFAULT_HOSTNAME;
            this.updateRunning = new AtomicBoolean(false);
            this.cacheDuration = j;
        }

        public String getHostname() {
            if (this.expirationTimestamp < System.currentTimeMillis() && this.updateRunning.compareAndSet(false, true)) {
                updateCache();
            }
            return this.hostname;
        }

        public void updateCache() {
            AnonymousClass1 r0 = new Callable<Void>() {
                /* JADX INFO: finally extract failed */
                public Void call() throws Exception {
                    try {
                        String unused = HostnameCache.this.hostname = InetAddress.getLocalHost().getCanonicalHostName();
                        long unused2 = HostnameCache.this.expirationTimestamp = System.currentTimeMillis() + HostnameCache.this.cacheDuration;
                        HostnameCache.this.updateRunning.set(false);
                        return null;
                    } catch (Throwable th) {
                        HostnameCache.this.updateRunning.set(false);
                        throw th;
                    }
                }
            };
            try {
                logger.debug("Updating the hostname cache");
                FutureTask futureTask = new FutureTask(r0);
                new Thread(futureTask).start();
                futureTask.get(GET_HOSTNAME_TIMEOUT, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                this.expirationTimestamp = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1);
                logger.debug("Localhost hostname lookup failed, keeping the value '{}'. If this persists it may mean your DNS is incorrectly configured and you may want to hardcode your server name: https://docs.sentry.io/clients/java/config/", (Object) this.hostname, (Object) e);
            }
        }
    }
}
