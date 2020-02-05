package io.sentry;

import io.sentry.connection.Connection;
import io.sentry.connection.EventSendCallback;
import io.sentry.connection.LockedDownException;
import io.sentry.connection.TooManyRequestsException;
import io.sentry.context.Context;
import io.sentry.context.ContextManager;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;
import io.sentry.event.helper.EventBuilderHelper;
import io.sentry.event.helper.ShouldSendEventCallback;
import io.sentry.event.interfaces.ExceptionInterface;
import io.sentry.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SentryClient {
    private static final Logger lockdownLogger = LoggerFactory.getLogger(SentryClient.class.getName() + ".lockdown");
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SentryClient.class);
    private final List<EventBuilderHelper> builderHelpers = new CopyOnWriteArrayList();
    private final Connection connection;
    private final ContextManager contextManager;
    protected String dist;
    protected String environment;
    protected Map<String, Object> extra = new HashMap();
    protected Set<String> mdcTags = new HashSet();
    protected String release;
    protected String serverName;
    private final Set<ShouldSendEventCallback> shouldSendEventCallbacks = new HashSet();
    protected Map<String, String> tags = new HashMap();
    private SentryUncaughtExceptionHandler uncaughtExceptionHandler;

    public SentryClient(Connection connection2, ContextManager contextManager2) {
        this.connection = connection2;
        this.contextManager = contextManager2;
    }

    public void runBuilderHelpers(EventBuilder eventBuilder) {
        for (EventBuilderHelper helpBuildingEvent : this.builderHelpers) {
            helpBuildingEvent.helpBuildingEvent(eventBuilder);
        }
    }

    public void sendEvent(Event event) {
        for (ShouldSendEventCallback next : this.shouldSendEventCallbacks) {
            if (!next.shouldSend(event)) {
                logger.trace("Not sending Event because of ShouldSendEventCallback: {}", (Object) next);
                return;
            }
        }
        try {
            this.connection.send(event);
        } catch (LockedDownException | TooManyRequestsException unused) {
            Logger logger2 = logger;
            logger2.debug("Dropping an Event due to lockdown: " + event);
        } catch (Exception e) {
            logger.error("An exception occurred while sending the event to Sentry.", (Throwable) e);
        } catch (Throwable th) {
            getContext().setLastEventId(event.getId());
            throw th;
        }
        getContext().setLastEventId(event.getId());
    }

    public void sendEvent(EventBuilder eventBuilder) {
        if (!Util.isNullOrEmpty(this.release)) {
            eventBuilder.withRelease(this.release.trim());
            if (!Util.isNullOrEmpty(this.dist)) {
                eventBuilder.withDist(this.dist.trim());
            }
        }
        if (!Util.isNullOrEmpty(this.environment)) {
            eventBuilder.withEnvironment(this.environment.trim());
        }
        if (!Util.isNullOrEmpty(this.serverName)) {
            eventBuilder.withServerName(this.serverName.trim());
        }
        for (Map.Entry next : this.tags.entrySet()) {
            eventBuilder.withTag((String) next.getKey(), (String) next.getValue());
        }
        for (Map.Entry next2 : this.extra.entrySet()) {
            eventBuilder.withExtra((String) next2.getKey(), next2.getValue());
        }
        runBuilderHelpers(eventBuilder);
        sendEvent(eventBuilder.build());
    }

    public void sendMessage(String str) {
        sendEvent(new EventBuilder().withMessage(str).withLevel(Event.Level.INFO));
    }

    public void sendException(Throwable th) {
        sendEvent(new EventBuilder().withMessage(th.getMessage()).withLevel(Event.Level.ERROR).withSentryInterface(new ExceptionInterface(th)));
    }

    public void removeBuilderHelper(EventBuilderHelper eventBuilderHelper) {
        logger.debug("Removing '{}' from the list of builder helpers.", (Object) eventBuilderHelper);
        this.builderHelpers.remove(eventBuilderHelper);
    }

    public void addBuilderHelper(EventBuilderHelper eventBuilderHelper) {
        logger.debug("Adding '{}' to the list of builder helpers.", (Object) eventBuilderHelper);
        this.builderHelpers.add(eventBuilderHelper);
    }

    public List<EventBuilderHelper> getBuilderHelpers() {
        return Collections.unmodifiableList(this.builderHelpers);
    }

    public void closeConnection() {
        SentryUncaughtExceptionHandler sentryUncaughtExceptionHandler = this.uncaughtExceptionHandler;
        if (sentryUncaughtExceptionHandler != null) {
            sentryUncaughtExceptionHandler.disable();
        }
        try {
            this.connection.close();
        } catch (IOException e) {
            throw new RuntimeException("Couldn't close the Sentry connection", e);
        }
    }

    public void clearContext() {
        this.contextManager.clear();
    }

    public Context getContext() {
        return this.contextManager.getContext();
    }

    public String getRelease() {
        return this.release;
    }

    public String getDist() {
        return this.dist;
    }

    public String getEnvironment() {
        return this.environment;
    }

    public String getServerName() {
        return this.serverName;
    }

    public Map<String, String> getTags() {
        return Collections.unmodifiableMap(this.tags);
    }

    public Set<String> getMdcTags() {
        return Collections.unmodifiableSet(this.mdcTags);
    }

    public Map<String, Object> getExtra() {
        return this.extra;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public void addTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public void setTags(Map<String, String> map) {
        if (map == null) {
            this.tags = new HashMap();
        } else {
            this.tags = map;
        }
    }

    @Deprecated
    public void setExtraTags(Set<String> set) {
        setMdcTags(set);
    }

    public void setMdcTags(Set<String> set) {
        if (set == null) {
            this.mdcTags = new HashSet();
        } else {
            this.mdcTags = set;
        }
    }

    @Deprecated
    public void addExtraTag(String str) {
        addMdcTag(str);
    }

    public void addMdcTag(String str) {
        this.mdcTags.add(str);
    }

    public void addExtra(String str, Object obj) {
        this.extra.put(str, obj);
    }

    public void setExtra(Map<String, Object> map) {
        if (map == null) {
            this.extra = new HashMap();
        } else {
            this.extra = map;
        }
    }

    public void addEventSendCallback(EventSendCallback eventSendCallback) {
        this.connection.addEventSendCallback(eventSendCallback);
    }

    public void addShouldSendEventCallback(ShouldSendEventCallback shouldSendEventCallback) {
        this.shouldSendEventCallbacks.add(shouldSendEventCallback);
    }

    /* access modifiers changed from: protected */
    public void setupUncaughtExceptionHandler() {
        this.uncaughtExceptionHandler = SentryUncaughtExceptionHandler.setup();
    }

    public String toString() {
        return "SentryClient{release='" + this.release + '\'' + ", dist='" + this.dist + '\'' + ", environment='" + this.environment + '\'' + ", serverName='" + this.serverName + '\'' + ", tags=" + this.tags + ", mdcTags=" + this.mdcTags + ", extra=" + this.extra + ", connection=" + this.connection + ", builderHelpers=" + this.builderHelpers + ", contextManager=" + this.contextManager + ", uncaughtExceptionHandler=" + this.uncaughtExceptionHandler + '}';
    }
}
