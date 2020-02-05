package io.sentry.context;

import io.sentry.event.Breadcrumb;
import io.sentry.event.User;
import io.sentry.event.interfaces.HttpInterface;
import io.sentry.util.CircularFifoQueue;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Context implements Serializable {
    private static final int DEFAULT_BREADCRUMB_LIMIT = 100;
    private final int breadcrumbLimit;
    private volatile CircularFifoQueue<Breadcrumb> breadcrumbs;
    private volatile Map<String, Object> extra;
    private volatile HttpInterface http;
    private volatile UUID lastEventId;
    private volatile Map<String, String> tags;
    private volatile User user;

    public Context() {
        this(100);
    }

    public Context(int i) {
        this.breadcrumbLimit = i;
    }

    public synchronized void clear() {
        setLastEventId((UUID) null);
        clearBreadcrumbs();
        clearUser();
        clearTags();
        clearExtra();
        clearHttp();
    }

    public synchronized List<Breadcrumb> getBreadcrumbs() {
        if (this.breadcrumbs != null) {
            if (!this.breadcrumbs.isEmpty()) {
                ArrayList arrayList = new ArrayList(this.breadcrumbs.size());
                arrayList.addAll(this.breadcrumbs);
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    public synchronized Map<String, String> getTags() {
        if (this.tags != null) {
            if (!this.tags.isEmpty()) {
                return Collections.unmodifiableMap(this.tags);
            }
        }
        return Collections.emptyMap();
    }

    public synchronized Map<String, Object> getExtra() {
        if (this.extra != null) {
            if (!this.extra.isEmpty()) {
                return Collections.unmodifiableMap(this.extra);
            }
        }
        return Collections.emptyMap();
    }

    public synchronized void addTag(String str, String str2) {
        if (this.tags == null) {
            this.tags = new HashMap();
        }
        this.tags.put(str, str2);
    }

    public synchronized void removeTag(String str) {
        if (this.tags != null) {
            this.tags.remove(str);
        }
    }

    public synchronized void clearTags() {
        this.tags = null;
    }

    public synchronized void addExtra(String str, Object obj) {
        if (this.extra == null) {
            this.extra = new HashMap();
        }
        this.extra.put(str, obj);
    }

    public synchronized void removeExtra(String str) {
        if (this.extra != null) {
            this.extra.remove(str);
        }
    }

    public synchronized void clearExtra() {
        this.extra = null;
    }

    public synchronized void setHttp(HttpInterface httpInterface) {
        this.http = httpInterface;
    }

    public synchronized HttpInterface getHttp() {
        return this.http;
    }

    public synchronized void clearHttp() {
        this.http = null;
    }

    public synchronized void recordBreadcrumb(Breadcrumb breadcrumb) {
        if (this.breadcrumbs == null) {
            this.breadcrumbs = new CircularFifoQueue<>(this.breadcrumbLimit);
        }
        this.breadcrumbs.add(breadcrumb);
    }

    public synchronized void clearBreadcrumbs() {
        this.breadcrumbs = null;
    }

    public void setLastEventId(UUID uuid) {
        this.lastEventId = uuid;
    }

    public UUID getLastEventId() {
        return this.lastEventId;
    }

    public void setUser(User user2) {
        this.user = user2;
    }

    public void clearUser() {
        setUser((User) null);
    }

    public User getUser() {
        return this.user;
    }
}
