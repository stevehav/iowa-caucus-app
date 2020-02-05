package io.sentry.connection;

import io.sentry.environment.SentryEnvironment;
import io.sentry.event.Event;
import io.sentry.util.Util;
import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractConnection implements Connection {
    public static final String SENTRY_PROTOCOL_VERSION = "6";
    private static final Logger lockdownLogger = LoggerFactory.getLogger(AbstractConnection.class.getName() + ".lockdown");
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) AbstractConnection.class);
    private final String authHeader;
    private Set<EventSendCallback> eventSendCallbacks = new HashSet();
    private LockdownManager lockdownManager = new LockdownManager();

    /* access modifiers changed from: protected */
    public abstract void doSend(Event event) throws ConnectionException;

    protected AbstractConnection(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append("Sentry sentry_version=6,sentry_client=");
        sb.append(SentryEnvironment.getSentryName());
        sb.append(",");
        sb.append("sentry_key=");
        sb.append(str);
        if (!Util.isNullOrEmpty(str2)) {
            str3 = ",sentry_secret=" + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        this.authHeader = sb.toString();
    }

    /* access modifiers changed from: protected */
    public String getAuthHeader() {
        return this.authHeader;
    }

    public final void send(Event event) throws ConnectionException {
        try {
            if (!this.lockdownManager.isLockedDown()) {
                doSend(event);
                this.lockdownManager.unlock();
                for (EventSendCallback next : this.eventSendCallbacks) {
                    try {
                        next.onSuccess(event);
                    } catch (Exception e) {
                        Logger logger2 = logger;
                        logger2.warn("An exception occurred while running an EventSendCallback.onSuccess: " + next.getClass().getName(), (Throwable) e);
                    }
                }
                return;
            }
            throw new LockedDownException();
        } catch (ConnectionException e2) {
            for (EventSendCallback next2 : this.eventSendCallbacks) {
                try {
                    next2.onFailure(event, e2);
                } catch (Exception e3) {
                    Logger logger3 = logger;
                    logger3.warn("An exception occurred while running an EventSendCallback.onFailure: " + next2.getClass().getName(), (Throwable) e3);
                }
            }
            if (this.lockdownManager.lockdown(e2)) {
                Logger logger4 = lockdownLogger;
                logger4.warn("Initiated a temporary lockdown because of exception: " + e2.getMessage());
            }
            throw e2;
        }
    }

    public void addEventSendCallback(EventSendCallback eventSendCallback) {
        this.eventSendCallbacks.add(eventSendCallback);
    }
}
