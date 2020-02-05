package io.sentry;

import io.sentry.config.Lookup;
import io.sentry.dsn.Dsn;
import io.sentry.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SentryClientFactory {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SentryClientFactory.class);

    public abstract SentryClient createSentryClient(Dsn dsn);

    public static SentryClient sentryClient() {
        return sentryClient((String) null, (SentryClientFactory) null);
    }

    public static SentryClient sentryClient(String str) {
        return sentryClient(str, (SentryClientFactory) null);
    }

    public static SentryClient sentryClient(String str, SentryClientFactory sentryClientFactory) {
        Dsn resolveDsn = resolveDsn(str);
        if (sentryClientFactory == null) {
            String lookup = Lookup.lookup("factory", resolveDsn);
            if (Util.isNullOrEmpty(lookup)) {
                sentryClientFactory = new DefaultSentryClientFactory();
            } else {
                try {
                    sentryClientFactory = (SentryClientFactory) Class.forName(lookup).newInstance();
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                    Logger logger2 = logger;
                    logger2.error("Error creating SentryClient using factory class: '" + lookup + "'.", e);
                    return null;
                }
            }
        }
        return sentryClientFactory.createSentryClient(resolveDsn);
    }

    private static Dsn resolveDsn(String str) {
        try {
            if (Util.isNullOrEmpty(str)) {
                str = Dsn.dsnLookup();
            }
            return new Dsn(str);
        } catch (Exception e) {
            logger.error("Error creating valid DSN from: '{}'.", (Object) str, (Object) e);
            throw e;
        }
    }

    public String toString() {
        return "SentryClientFactory{name='" + getClass().getName() + '\'' + '}';
    }
}
